package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class SaveMenuItem extends OpenMenuItem {
    SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    protected void action(String path) throws FileNotFoundException {
        if (!path.endsWith(".xl")) {
            path += ".xl";
        }
        XLPrintStream ps = new XLPrintStream(path);
        ps.save(xl.getEntrySet());
        statusLabel.setText("Successfully saved " + path.substring(1+path.lastIndexOf("\\")));

    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}