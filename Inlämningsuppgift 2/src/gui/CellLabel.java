package gui;

import java.awt.Color;

/**
 * Describes a visual representation of a cell.
 */

class CellLabel extends ColoredLabel {
    private final String address;
    CellLabel(String address) {
        super("                    ", Color.WHITE, RIGHT);
        this.address = address;
    }

    /**
     * Gets the address of the celllabel.
     * @return the address of the celllabel.
     */
    String getAddress() {
        return address;
    }

}