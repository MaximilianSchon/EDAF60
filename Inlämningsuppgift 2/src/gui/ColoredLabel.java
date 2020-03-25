package gui;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * A colored label.
 */
class ColoredLabel extends JLabel {

    ColoredLabel(String text, Color color) {
        this(text, color, SwingConstants.LEFT);
    }

    ColoredLabel(String text, Color color, int alignment) {
        super(text, alignment);
        setBackground(color);
        setOpaque(true);
    }
}