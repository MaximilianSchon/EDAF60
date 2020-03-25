package expr;

class Add extends BinaryExpr {
    Add(Expr expr1, Expr expr2) {
        super(expr1, expr2);
        precedence1 = 0;
        precedence2 = 0;
    }

    /**
     * Evaluates the addition of two terms.
     * @param op1 The first term of the addition.
     * @param op2 The second term of the addition.
     * @return The result of the addition.
     */
    public double op(double op1, double op2) {
        return op1 + op2;
    }

    /**
     * Decides the representation of addition.
     * @return The representation.
     */
    protected String opString() {
        return "+";
    }
}