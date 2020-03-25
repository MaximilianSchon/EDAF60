package expr;

class Sub extends BinaryExpr {
    Sub(Expr expr1, Expr expr2) {
        super(expr1, expr2);
        precedence1 = 0;
        precedence2 = 1;
    }

    /**
     * Evaluates the subtraction of two factors.
     * @param op1 The minuend.
     * @param op2 The subtrahend.
     * @return The result of the subtraction.
     */
    public double op(double op1, double op2) {
        return op1 - op2;
    }

    /**
     * Decides the representation of the subtraction.
     * @return The representation.
     */
    protected String opString() {
        return "-";
    }
}
