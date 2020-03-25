package Core;

/**
 * Ett minne med långa ord.
 */

class LongMemory implements Memory {
    private final LongWord[] memory;
    LongMemory(int i) {
        memory = new LongWord[i];
        for (int k = 0; k < memory.length; k++) {
            memory[k] = new LongWord(0);
        }
    }

    /**
     * Hämtar ordet på platsen i.
     * @param i en minnesplats som ett heltal.
     * @return Ordet på minnesplatsen.
     */
    public Word getWord(int i) {
        return memory[i];
    }
}
