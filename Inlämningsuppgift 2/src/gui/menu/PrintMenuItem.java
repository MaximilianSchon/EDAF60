package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JMenuItem;

class PrintMenuItem extends JMenuItem implements ActionListener {
    private final StatusLabel statusLabel;
    private final XL xl;

    PrintMenuItem(XL xl, StatusLabel statusLabel) {
        super("Print");
        this.xl = xl;
        this.statusLabel = statusLabel;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(xl);
        // printJob.pageDialog(printJob.defaultPage());
        boolean doPrint = printerJob.printDialog();
        if (doPrint) {
            try {
                printerJob.print();
                statusLabel.setText("Printing " + xl.getTitle());
            } catch (PrinterException e) {
                statusLabel.setText(e.getMessage());
            }
        }
    }
}