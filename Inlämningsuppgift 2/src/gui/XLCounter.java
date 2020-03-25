package gui;

/**
 * A counter that counts the number of XL sheets.
 */
class XLCounter {
    private int counter;

    /**
     * Increments the counter
     */
    void increment() {
        counter++;
    }

    /**
     * The number the counter is set to as a string.
     * @return The counter.
     */
    public String toString() {
        return Integer.toString(counter);
    }
}
