package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

class StatusPanel extends BorderPanel {
    StatusPanel(StatusLabel statusLabel, CurrentCell current) {
        add(WEST, new CurrentLabel(current));
        add(CENTER, statusLabel);
    }
}