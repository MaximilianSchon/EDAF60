package Instructions;
import Core.*;

/**
 * Ett gränssnitt som beskriver en simpel instruktion.
 **/

public interface Instruction {
    void execute(Memory memory, Counter counter);
    String toString();
}
