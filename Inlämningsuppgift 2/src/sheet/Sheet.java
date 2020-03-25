package sheet;

import expr.Environment;
import util.XLException;

import java.util.HashMap;
import java.util.Observable;
import java.util.Optional;

/**
 * The representative spreadsheet.
 */

public class Sheet extends Observable implements Environment {
    private final HashMap<String, Cell> sheet;


    public Sheet() {
        sheet = new HashMap<>();
    }

    /**
     * Saves content to a cell.
     * @param address The address of the cell.
     * @param content The content of the cell.
     */
    public void put(String address, String content) {
        Optional<Cell> oldCell = get(address);
        try {
            Cell cell = CellFactory.build(content);
            tryCircular(address, cell);
            tryDivision(address, cell);
        } catch (XLException e) {
            oldCell.map(c -> sheet.put(address, c));
            throw e;
        } finally {
            setChanged();
            notifyObservers();
        }
    }

    private void tryDivision(String address, Cell cell) {
        sheet.put(address, cell);
        if (value(address) == 0) {
            try {
                sheet.forEach((k,v) -> value(k));
            } catch (XLException e) {
                sheet.remove(address);
                throw e;
            }
        }
    }

    /**
     * Puts a bombcell into the address and if doesn't throw an exception, put the real cell there.
     * @param address Address of the cell.
     * @param cell The cell.
     * @throws XLException If the bombcell is reached.
     */

    private void tryCircular(String address, Cell cell) throws XLException {
        try {
            BombCell bomb = new BombCell();
            sheet.put(address, bomb);
            cell.value(this);
        } finally {
            sheet.remove(address);
        }
    }

    /**
     * Clears the cell.
     * @param address the address of the cell.
     */
    public void clear(String address) {
        Optional<Cell> old = get(address);
        sheet.remove(address);
        try {
            sheet.forEach((k,v) -> value(k));
        } catch (XLException e){
            old.map(c -> sheet.put(address, c));
            throw e;
        }
        setChanged();
        notifyObservers();
    }

    /**
     * Clears all the sheet.
     */

    public void clearAll() {
        sheet.clear();
        setChanged();
        notifyObservers();
    }

    /**
     * Gets a cell from the sheet.
     * @param address The address to the cell.
     * @return An optional of the cell.
     */
    public Optional<Cell> get(String address) {
        return Optional.ofNullable(sheet.get(address));
    }

    /**
     * Evaluates a cell.
     * @param address the address of the cell.
     * @return the value of the cell.
     */

    @Override
    public double value(String address) {
        return  get(address)
                .map(c -> c.value(this))
                .orElseThrow(() -> XLException.EMPTY_ERROR);
        /*
        .orElse(0.0);
         */
    }

    /**
     * Gets all the cells of the sheet.
     * @return a copy of the has
     */
    public HashMap<String, Cell> getCells() {
        HashMap<String,Cell> cells = new HashMap<>();
        cells.putAll(sheet);
        return cells;
    }
}
