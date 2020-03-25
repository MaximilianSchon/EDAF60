package Core;

/**
 * Gränssnittet Word
 */

public interface Word extends Value {

    /**
     * Multiplicerar ett ord och ett ord.
     * @param other den andra faktorn.
     * @return produkten av de båda orden.
     */
    void mul(Word other);

    /**
     * Adderar ett ord och ett ord.
     * @param other den andra termen.
     * @return Summan av de båda orden.
     */

    void add(Word other);

    /**
     * Gör om ett ord till en sträng.
     * @return ordets värde
     */
    String toString();


    void setWord(Word word);
}
