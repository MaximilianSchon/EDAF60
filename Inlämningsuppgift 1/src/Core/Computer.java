package Core;

/**
 * En dator
 */

class Computer {
    private final Memory memory;
    private final Counter counter;
    private final Program program;

    /**
     *  En dator med ett minne som kan köra program
     * @param memory, minnet till datorn
     */
    private Computer(Memory memory) {
        this.memory = memory;
        this.counter = new Counter(0);
        this.program = new Program();
    }

    /**
     * Ladda programmet till datorns programkörare
     * @param program, ett program
     */
    private void load(Program program) {
        counter.set(0);
        this.program.addAll(program);
    }

    /**
     * Programloop, kör tills listan är slut eller kommandot "HLT" har exekverats.
     */
    private void run() {
        for (counter.get(); counter.get() >= 0 && counter.get() < program.size(); ) {
            program.get(counter.get()).execute(memory, counter);
        }
    }

    /**
     * Mainmetoden, startar programmet
     * @param args, standardargumentet i Java
     */
    public static void main(String[] args) {
        Program factorial = new Factorial(5);
        System.out.println(factorial);
        Computer computer = new Computer(new LongMemory(1024));
        computer.load(factorial);
        computer.run();
        }


}