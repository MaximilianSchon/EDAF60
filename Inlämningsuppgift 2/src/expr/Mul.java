package expr;

class Mul extends BinaryExpr {
    Mul(Expr expr1, Expr expr2) {
        super(expr1, expr2);
        precedence1 = 1;
        precedence2 = 1;
    }

    /**
     * Evaluates the multiplication of two factors.
     * @param op1 The first factor of the multiplication.
     * @param op2 The second factor of the multiplication.
     * @return The result of the multiplication.
     */
    public double op(double op1, double op2) {
        return op1 * op2;
    }

    /**
     * Decides the representation of multiplication.
     * @return The representation.
     */
    protected String opString() {
        return "*";
    }
}