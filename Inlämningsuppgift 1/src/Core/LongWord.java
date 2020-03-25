package Core;

public class LongWord implements Word {
    private long value;
    LongWord(long l) {
        this.value = l;
    }

    public void mul(Word other) {
        value = this.value * ((LongWord) other).value;
    }
    @Override
    public void add(Word other) {
        value = this.value + ((LongWord) other).value;
    }

    @Override
    public Word getWord(Memory memory) {
        return this;
    }

    @Override
    public void setWord(Word word) {
        LongWord other = (LongWord) word;
        this.value = other.value;
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }

    @Override
    public Boolean equals(Value value, Memory memory) {
        return this.value == ((LongWord) value.getWord(memory)).value;
    }
}
