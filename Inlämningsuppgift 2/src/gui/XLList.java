package gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/**
 * A list of the running sheets.
 */
public class XLList extends Observable implements Iterable<XL> {
    private final List<XL> list = new ArrayList<>();

    /**
     * Adding a sheet to the list
     * @param xl a sheet
     */
    public void add(XL xl) {
        list.add(xl);
        setChanged();
        notifyObservers();
    }

    /**
     * Checks if there is no current sheets.
     * @return if there are no sheets.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Creates an iterator
     * @return an iterator
     */
    public Iterator<XL> iterator() {
        return list.iterator();
    }

    /**
     * Gets the last sheet
     * @return the last sheet
     */

    public XL last() {
        return list.get(list.size() - 1);
    }

    /**
     * Removes a sheet from the list
     * @param xl the sheet to remove
     */
    public void remove(XL xl) {
        list.remove(xl);
        setChanged();
        notifyObservers();
    }

    /**
     * Sets a boolean to changed and notifies observers.
     */
    public void setChanged() {
        super.setChanged();
        notifyObservers();
    }
}