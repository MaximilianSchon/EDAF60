package gui;

import java.awt.*;
import java.util.Observable;
import java.util.Optional;

/**
 * The current cell.
 */
public class CurrentCell extends Observable {
    private String address;
    private CellLabel current;

    /**
     * Changes the current cell
     * @param current the current cell as a label
     * @param a the address of the cell
     */
    void setCurrent(CellLabel current, String a) {
        Optional.ofNullable(this.current).ifPresent(c -> c.setBackground(Color.white));
        this.current = current;
        current.setBackground(Color.yellow);
        this.address = a;
        setChanged();
        notifyObservers();
    }

    /**
     * Gets the address
     * @return the address
     */

    public String getAddress() {
        return address;
    }
}
