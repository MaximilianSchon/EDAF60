package Instructions;

import Core.*;

/**
 * En abstrakt klass som beskriver binära operationer i form av instruktioner.
 */

abstract class BinOpInstruction implements Instruction {
    private final Value v1;
    private final Value v2;
    private final Address address;


    BinOpInstruction(Value v1, Value v2, Address address) {
        this.address = address;
        this.v1 = v1;
        this.v2 = v2;
    }

    /**
     * Utför en egen binär operation, baserat på underklassen.
     *
     * @param left ett ord
     * @param right ett ord
     */
    abstract void op(Word left, Word right);

    /**
     * En metod som utför en instruktion, i detta fallet, en operand.
     *
     * @param memory  minnet där resultatet lagras i
     * @param counter programräknaren till motsvarande program
     */
    @Override
    public void execute(Memory memory, Counter counter) {
        counter.increment();
        address.getWord(memory).setWord(v1.getWord(memory));
        op(address.getWord(memory), v2.getWord(memory));

    }


    /**
     * GÃ¶r om klassen till en representativ strÃ¤ng
     * @return "Namnet på operationen" _ _ [x], där _ _ representerar värde och [x] en adress.
     */

    @Override
    public String toString() {
        return String.format(" %s %s %s", v1, v2, address);
    }

}



