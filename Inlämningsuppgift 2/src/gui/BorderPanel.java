package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * The border between the first row and the rest of the gui.
 */
class BorderPanel extends JPanel {
    BorderPanel() {
        super(new BorderLayout(2, 2));
        setBackground(Color.BLACK);
    }
}
