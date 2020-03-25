package gui.menu;

import gui.StatusLabel;
import sheet.Sheet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
    private final Sheet sheet;
    private final StatusLabel status;
    ClearAllMenuItem(Sheet sheet, StatusLabel status) {
        super("Clear all");
        this.sheet = sheet;
        this.status = status;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        status.setText("Cleared sheet");

    }
}