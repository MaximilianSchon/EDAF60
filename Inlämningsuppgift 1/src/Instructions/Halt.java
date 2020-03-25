package Instructions;

import Core.Counter;
import Core.Memory;

/**
 * Stänger av datorn
 **/
 
public class Halt implements Instruction {

/**
 * Stänger av datorn
 * */
    @Override
    public void execute(Memory memory, Counter counter) {
        new Jump(-1).execute(memory, counter);
    }

/**
 * Returnerar en sträng "HLT"
 * */
 
    public String toString() {
        return "HLT";
    }
}
