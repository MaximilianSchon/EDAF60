package gui.menu;

import gui.StatusLabel;
import gui.XL;
import gui.XLList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JMenu;

class WindowMenu extends JMenu implements Observer {
    private final XLList xlList;
    private final StatusLabel status;

    WindowMenu(XLList xlList, StatusLabel status) {
        super("Window");
        this.xlList = xlList;
        this.status = status;
        xlList.addObserver(this);
        update(null, null);
    }

    public void update(Observable observable, Object object) {
        removeAll();
        for (XL xl : xlList) {
            add(new WindowMenuItem(xl, status));
        }
    }
}