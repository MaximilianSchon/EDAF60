package Core;

/**
 * En räknare
 */
public class Counter  {
    private int i;

    Counter(int i) {
        this.i = i;
    }

    Counter() {
        this(0);
    }

    /**
     * Sätter räknaren till ett heltal i.
     * @param i ett heltal
     */

    public void set(int i) {
        this.i = i;
    }

    /**
     * Hämtar räknarens värde
     * @return räknarens värde
     */

    int get() {
        return i;
    }

    /**
     * Gör om räknaren till en sträng
     * @return heltalet i som en sträng
     */

    public String toString() {
        return Integer.toString(i);
    }

    /**
     * Ökar värdet med ett.
     */
    public void increment() {
        i++;
    }
}
