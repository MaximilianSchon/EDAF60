package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

/**
 *  Keeps track of the current address.
 */

class CurrentLabel extends ColoredLabel implements Observer {
    CurrentLabel(CurrentCell current) {
        super("A1", Color.WHITE);
        current.addObserver(this);
    }

    /**
     * When the Controller updates.
     * @param o the controller
     * @param arg the argument that is passed onto the notifyObservers.
     */
    @Override
    public void update(Observable o, Object arg) {
        setText(((CurrentCell) o).getAddress());
    }
}