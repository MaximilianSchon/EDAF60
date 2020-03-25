package util;

/**
 * Adjustment.java Created: Tue Oct 24 2005
 * @author Lennart Andersson
 * @version 0.1
 */
/**
 * Adjustment is a class for adjusting string representations of values within a
 * String.
 */
class Adjustment {
    private final int width;

    /**
     * Creates an adjustment.
     * 
     * @param width
     *            is the number of positions for the result. If the width is
     *            insufficient extra positions are added.
     */
    Adjustment(int width) {
        this.width = width;
    }


    /**
     * Returns a left adjusted String.
     * 
     * @param s
     *            is the string to adjust.
     */
    public String left(String s) {
        StringBuilder builder = new StringBuilder(width);
        builder.append(s);
        int fill = width - s.length();
        for (int i = 0; i < fill; i++) {
            builder.append(' ');
        }
        return builder.toString();
    }

    /**
     * Returns a right adjusted String.
     * 
     * @param number
     *            is the value to adjust.
     */
    String right(double number) {
        return right(String.valueOf(number));
    }

    /**
     * Returns a right adjusted String.
     * 
     * @param number
     *            is the value to adjust.
     */
    String right(float number) {
        return right(String.valueOf(number));
    }

    /**
     * Returns a right adjusted String.
     * 
     * @param s
     *            is the string to adjust.
     */
    String right(String s) {
        StringBuilder builder = new StringBuilder(width);
        int fill = width - s.length();
        for (int i = 0; i < fill; i++) {
            builder.append(' ');
        }
        builder.append(s);
        return builder.toString();
    }
}