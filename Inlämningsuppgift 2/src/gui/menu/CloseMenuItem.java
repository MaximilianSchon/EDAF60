package gui.menu;

import gui.StatusLabel;
import gui.XL;
import gui.XLList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class CloseMenuItem extends JMenuItem implements ActionListener {
    private final XL xl;
    private final XLList xlList;
    private final StatusLabel status;
    CloseMenuItem(XL xl, XLList xlList, StatusLabel status) {
        super("Close");
        this.xl = xl;
        this.xlList = xlList;
        this.status = status;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        xlList.remove(xl);
        status.setText(String.format("Closed %s", xl.getTitle()));
        xl.dispose();
        if (xlList.isEmpty()) {
            System.exit(0);
        } else {
            xlList.last().toFront();
        }
    }
}
