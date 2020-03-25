package expr;

abstract class BinaryExpr extends Expr {
    private final Expr expr1;
    private final Expr expr2;
    int precedence1;
    int precedence2;

    BinaryExpr(Expr expr1, Expr expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    /**
     * Evaluates a binary operation.
     * @param op1 The first factor of the binary operation.
     * @param op2 The second factor of the binary operation.
     * @return The result of the binary operation.
     */
    abstract protected double op(double op1, double op2);

    /**
     * Decides the representation of a binary operation.
     * @return The representation.
     */
    abstract protected String opString();

    public String toString(int prec) {
        StringBuilder builder = new StringBuilder();
        boolean parentheses = prec > precedence1;
        if (parentheses) {
            builder.append('(');
        }
        builder.append(expr1.toString(precedence1));
        builder.append(opString());
        builder.append(expr2.toString(precedence2));
        if (parentheses) {
            builder.append(')');
        }
        return builder.toString();
    }

    /**
     * Execute a binary operation.
     * @param env
     *            is the <code>Environment</code> containing the values of
     *            variables.
     * @return The result of the binary operation.
     */
    public double value(Environment env) {
        return op(expr1.value(env), expr2.value(env));
    }
}