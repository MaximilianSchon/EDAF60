package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import gui.menu.XLMenuBar;
import sheet.Cell;
import sheet.Sheet;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.Map;
import java.util.Set;
import javax.swing.*;

/**
 * The XL program
 */
public class XL extends JFrame implements Printable {
    private static final int ROWS = 10, COLUMNS = 8;
    private final XLCounter counter;
    private final XLList xlList;
    private final Sheet sheet;

    public XL(XL oldXL) {
        this(oldXL.xlList, oldXL.counter);
    }

    private XL(XLList xlList, XLCounter counter) {
        super("Untitled-" + counter);
        this.xlList = xlList;
        this.counter = counter;
        CurrentCell current = new CurrentCell();
        xlList.add(this);
        counter.increment();
        sheet = new Sheet();
        StatusLabel statusLabel = new StatusLabel();
        JPanel statusPanel = new StatusPanel(statusLabel, current);
        JPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, current, sheet);
        Editor editor = new Editor(statusLabel, sheet, current);
        current.addObserver(editor);
        add(NORTH, statusPanel);
        add(CENTER, editor);
        add(SOUTH, sheetPanel);
        setJMenuBar(new XLMenuBar(this, xlList, statusLabel, sheet, current));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Prints the program
     * @param g the graphics that should print
     * @param pageFormat the format it should print in
     * @param page the number of pages
     * @return the number of pages
     */
    public int print(Graphics g, PageFormat pageFormat, int page) {
        if (page > 0)
            return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        printAll(g2d);
        return PAGE_EXISTS;
    }

    /**
     * Renames XL
     * @param title the new name
     */
    public void rename(String title) {
        setTitle(title);
        xlList.setChanged();
    }

    /**
     * Initiates the program
     * @param args standard argument
     */
    public static void main(String[] args) {
        new XL(new XLList(), new XLCounter());
    }

    /**
     * Gets the elements used for saving.
     * @return the sheet in a set.
     */
    public Set<Map.Entry<String, Cell>> getEntrySet() {
        return sheet.getCells().entrySet();
    }
}