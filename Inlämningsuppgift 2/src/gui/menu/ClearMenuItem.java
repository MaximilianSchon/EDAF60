package gui.menu;

import gui.CurrentCell;
import gui.StatusLabel;
import sheet.Sheet;
import util.XLException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ClearMenuItem extends JMenuItem implements ActionListener {
    private final Sheet sheet;
    private final CurrentCell current;
    private final StatusLabel status;
    ClearMenuItem(Sheet sheet, CurrentCell current, StatusLabel status) {
            super("Clear");
        addActionListener(this);
        this.status = status;
        this.sheet = sheet;
        this.current = current;
    }

    public void actionPerformed(ActionEvent evt) {
        try {
            sheet.clear(current.getAddress());
            status.setText(String.format("Cleared %s", current.getAddress()));
        } catch (XLException e) {
            status.setText(e.getMessage());
        }
    }
}