package Instructions;

import Core.Counter;
import Core.Memory;
import Core.Value;

/**
 * Hoppar i minnet ifall två värden är lika.
 */

public class JumpEq implements Instruction {
    private final int i;
    private final Value v1,v2;

    public JumpEq(int i, Value v1, Value v2) {
        this.i = i;
        this.v1 = v1;
        this.v2 = v2;
    }

    /**
     * Representerar instruktionen i en sträng
     * @return JEQ i _ _, där i är vart den hoppar och _ representerar ett värde.
     */
    public String toString() {
        return String.format("JEQ %s %s %s", i, v1, v2);
    }

    /**
     * Utför instruktionen, i detta fallet ett hopp ifall två värden är lika.
     * @param memory minnet till datorn
     * @param counter programräknaren till datorn
     */
    @Override
    public void execute(Memory memory, Counter counter) {
        counter.increment();
        if (v1.equals(v2, memory)) {
            new Jump(i).execute(memory, counter);
        }
    }
}
