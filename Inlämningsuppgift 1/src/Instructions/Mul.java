package Instructions;
import Core.*;

/**
 * En instruktion som multiplicerar två värden och lagrar produkten på en address.
 */
public class Mul extends BinOpInstruction {

    public Mul(Value v1, Value v2, Address address) {
        super(v1, v2, address);
    }

    /**
     * Utför operationen som multiplicerar värdena.
     * @param left ett ord
     * @param right ett ord
     */

    public void op(Word left, Word right) {
        left.mul(right);
    }

    /**
     * GÃ¶r om klassen till en representativ strÃ¤ng
     * @return MUL _ _ [x], dÃ¤r _ _ representerar vÃ¤rde och [x] en adress.
     */


    public String toString() {
        return "MUL" + super.toString();
    }

}
