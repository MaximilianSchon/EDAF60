package gui;



import sheet.Sheet;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

class SheetPanel extends BorderPanel {
    SheetPanel(int rows, int columns, CurrentCell current, Sheet sheet) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new CellLabels(rows, columns, current, sheet));

    }
}