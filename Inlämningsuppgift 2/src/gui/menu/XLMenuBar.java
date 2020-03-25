package gui.menu;

import gui.CurrentCell;
import gui.StatusLabel;
import gui.XL;
import gui.XLList;
import sheet.Sheet;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class XLMenuBar extends JMenuBar {
    public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, Sheet sheet, CurrentCell current) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new PrintMenuItem(xl, statusLabel));
        file.add(new SaveMenuItem(xl, statusLabel));
        file.add(new LoadMenuItem(xl, statusLabel, sheet));
        file.add(new NewMenuItem(xl, statusLabel));
        file.add(new CloseMenuItem(xl, xlList, statusLabel));
        edit.add(new ClearMenuItem(sheet, current, statusLabel));
        edit.add(new ClearAllMenuItem(sheet, statusLabel));
        add(file);
        add(edit);
        add(new WindowMenu(xlList, statusLabel));
    }
}