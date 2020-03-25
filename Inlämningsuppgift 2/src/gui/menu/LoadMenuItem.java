package gui.menu;

import gui.StatusLabel;
import gui.XL;
import sheet.Sheet;
import util.XLException;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {
    private final Sheet sheet;
    public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Load");
        this.sheet = sheet;
    }

    protected void action(String path) throws FileNotFoundException {
        XLBufferedReader reader = new XLBufferedReader(path);
        try {
            reader.load(sheet);
            statusLabel.setText(String.format("Loaded %s", path.substring(path.lastIndexOf("/") + 1)));
        } catch (XLException e) {
            statusLabel.setText(String.format("Loaded %s, with the error: %s", path.substring(path.lastIndexOf("/") + 1), e.getMessage()));
        } catch (IOException e) {
            statusLabel.setText(e.getMessage());
        }

    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}