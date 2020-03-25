package Core;

/**
 * En plats i minnet
 */
public class Address implements Value {
    private final int idx;
    Address(int i) {
        idx = i;
    }

    /**
     * Gör om en address till en sträng
     * @return "[Addressensplats]"
     */
    public String toString() {
        return String.format("[%d]", idx);
    }

    /**
     * Kollar om det som finns på en adress är lika med en värde
     * @param value Ett vÃ¤rde (adress/ord)
     * @param memory Minnet till datorn
     * @return sant eller falskt
     */
    @Override
    public Boolean equals(Value value, Memory memory) {
        return this.getWord(memory).equals(value, memory);
    }

    /**
     * Hämtar ett ord från minnet.
     * @param memory minnet
     * @return Ett ord
     */
    @Override
    public Word getWord(Memory memory) {
        return memory.getWord(idx);
    }
    
}
