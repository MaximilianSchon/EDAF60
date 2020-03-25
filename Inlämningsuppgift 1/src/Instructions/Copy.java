package Instructions;
import Core.*;

/**
 * Kopierar ett värde till en adress
 **/

public class Copy implements Instruction {
    private final Address address;
    private final Value value;

    public Copy(Value value, Address address) {
        this.value = value;
        this.address = address;
    }

/**
 * Kopierar ett värde till en adress
 **/
 
    @Override
    public void execute(Memory memory, Counter counter) {
        counter.increment();
        address.getWord(memory).setWord(value.getWord(memory));
    }

/**
 * Returnerar en sträng av värdet och adressen
 **/
 
    public String toString() {
        return String.format("CPY %s %s", value, address);
    }
}

