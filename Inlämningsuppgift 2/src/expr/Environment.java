package expr;

public interface Environment {
    /**
     * Evaluates something.
     * @param name What to evaluate.
     * @return The result of the evaluation.
     */
    double value(String name);
}