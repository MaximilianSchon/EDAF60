package Instructions;
import Core.Counter;
import Core.Memory;

/**
 * En hopp-instruktion, som innebär att programräknaren flyttas fram eller bakåt i programlistan.
 */

public class Jump implements Instruction {
    private final int i;
    public Jump (int i) {
        this.i = i;
    }

    /**
     * Gör det faktiska hoppet genom att sätta programräknaren till ett värde (i-1).
     * @param memory minnet till datorn som utför hoppet.
     * @param counter programräknaren till datorn som utför hoppet.
     */

    public void execute(Memory memory, Counter counter) {
        counter.set(i);
    }

    /**
     * Gör om hopp-instruktionen till en representativ sträng.
     * @return "JMP n" där n är ett nummer dit adressen hoppar.
     */
    public String toString() {
        return String.format("JMP %d", i);
    }
}
