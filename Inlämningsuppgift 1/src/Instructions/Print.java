package Instructions;

import Core.Counter;
import Core.Memory;
import Core.Value;

/**
 * En instruktion som skriver ut ett värdet av en adress eller ett ord i form av ett heltal.
 */

public class Print implements Instruction {
    private final Value value;
    public Print(Value value) {
        this.value = value;
    }

    /**
     * En representativ sträng av instruktionen
     * @return PRT v, där v är värdet.
     */

    @Override
    public String toString() {
        return String.format("PRT %s", value);
    }

    /**
     * Skriver ut värdet av instruktionen.
     * @param memory minnet till datorn som utför instruktionen
     * @param counter räknaren till datorn som utför instruktionen
     */
    @Override
    public void execute(Memory memory, Counter counter) {
        counter.increment();
        System.out.println(value.getWord(memory));
    }
}
