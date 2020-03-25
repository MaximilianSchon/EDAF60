package Instructions;
import Core.*;

/**
 * En instruktion som adderar två värden och lagrar summan på en address.
 */
public class Add extends BinOpInstruction {

    public Add(Value v1, Value v2, Address address) {
        super(v1, v2, address);
    }

    /**
     * Utför operationen som adderar värdena.
     * @param left ett ord
     * @param right ett ord
     */
    public void op(Word left, Word right) {
        left.add(right);
    }

    /**
     * Gör om klassen till en representativ sträng
     * @return ADD _ _ [x], där _ _ representerar värde och [x] en adress.
     */
    public String toString() {
        return "ADD" + super.toString();
    }
}


