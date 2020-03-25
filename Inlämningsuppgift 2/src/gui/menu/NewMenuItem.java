package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class NewMenuItem extends JMenuItem implements ActionListener {
    private final XL xl;
    private final StatusLabel status;

    NewMenuItem(XL xl, StatusLabel status) {
        super("New");
        this.xl = xl;
        this.status = status;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        new XL(xl);
        status.setText("Opened a new sheet");
    }
}