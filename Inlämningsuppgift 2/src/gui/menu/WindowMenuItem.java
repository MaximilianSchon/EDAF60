package gui.menu;

import gui.StatusLabel;
import gui.XL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class WindowMenuItem extends JMenuItem implements ActionListener {
    private final XL xl;
    private final StatusLabel status;

    WindowMenuItem(XL xl, StatusLabel status) {
        super(xl.getTitle());
        this.xl = xl;
        this.status = status;
        addActionListener(this);

    }

    public void actionPerformed(ActionEvent event) {
        xl.toFront();
        status.setText(String.format("Moved %s to front.", xl.getTitle()));
    }
}