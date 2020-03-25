package gui;

import sheet.Cell;
import sheet.Sheet;

import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import javax.swing.SwingConstants;


class CellLabels extends GridPanel implements Observer {
    private final List<CellLabel> labelList;
    private final Map<Character, Integer> adrMap;
    private final Sheet sheet;


    /**
     * Creates unique celllabels with a MouseAdapter and an address.
     * @param rows Rows in the sheet.
     * @param cols Columns in the sheet.
     * @param current Keeps track of the current cell
     */

    CellLabels(int rows, int cols, CurrentCell current, Sheet sheet) {
        super(rows + 1, cols);
        this.sheet = sheet;
        sheet.addObserver(this);
        adrMap = new HashMap<>();
        labelList = new ArrayList<>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        int i = 0;
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++, i++) {
                if (row == 1) adrMap.put(ch, i);
                CellLabel label = new CellLabel(ch + Integer.toString(row));
                label.addMouseListener(new MouseAdapter() {
                                           @Override
                                           public void mousePressed(MouseEvent e) {
                                               current.setCurrent((CellLabel) e.getSource(),
                                                       ((CellLabel) e.getSource()).getAddress());
                                           }
                                       });
                add(label);
                labelList.add(label);
            }
        }
        current.setCurrent(labelList.get(0), "A1");
    }

    /**
     * Update the gui when Sheet is changed.
     * @param o The sheet.
     * @param arg an argument passed to the notifyObservers method.
     */
    @Override
    public void update(Observable o, Object arg) {
        HashMap<String, Cell> cells = (sheet).getCells();
        labelList.forEach(l -> l.setText(""));
        cells.forEach((k,v) -> adrToCL(k).setText(v.representation((sheet))));
    }

    /**
     * Converts a address to a CellLabel.
     * @param a address
     * @return CellLabel that is on the address.
     */

    private CellLabel adrToCL(String a) {
        Character first = a.charAt(0);
        int col = adrMap.get(first);
        int cols = adrMap.size();
        int row =  Integer.parseInt(a.substring(1))-1;
        return labelList.get(row * cols + col);
    }
}
