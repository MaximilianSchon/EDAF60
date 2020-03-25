package gui;


import sheet.Sheet;
import util.XLException;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

class Editor extends JTextField implements ActionListener, Observer {
    private final StatusLabel statusLabel;
    private final Sheet sheet;
    private final CurrentCell current;
    private String address;

    Editor(StatusLabel statusLabel, Sheet sheet, CurrentCell current) {
        this.sheet = sheet;
        this.current = current;
        this.statusLabel = statusLabel;
        setBackground(Color.WHITE);
        sheet.addObserver(this);
        address = "A1";
        addActionListener(this);
    }

    /**
     * Sends the content to the controller when enter is pressed
     * @param e Enter pressed
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        put(getText());
    }


    /**
     * Test if it is possible to add content to a cell.
     * If it isn't possible, an error message is displayed in the status-panel.
     * @param content The content of the cell.
     */

    private void put(String content) {
        try {
            sheet.put(address, content);
            setText(content);
            statusLabel.setText("");
            //   setStatus(String.format("Saved %s to %s", content, address));
        } catch (XLException e) {
            statusLabel.setText(e.getMessage());
            setText(sheet.get(address).map(c -> c.toString()).orElse(""));
        }
    }
    /**
     * Updates when something happens in the current cell.
     * @param o CurrentCell
     */

    @Override
    public void update(Observable o, Object arg) {
        address = current.getAddress();
        setText(sheet.get(address).map(c -> c.toString()).orElse(""));
        statusLabel.setText("");
    }
}