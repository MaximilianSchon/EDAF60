package gui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * A GridPanel to portray the SpreadSheet
 */
class GridPanel extends JPanel {
    GridPanel(int rows, int columns) {
        super(new GridLayout(rows, columns, 2, 2));
        setBackground(Color.BLACK);
    }
}