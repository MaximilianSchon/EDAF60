package expr;

import util.XLException;

class Div extends BinaryExpr {
    Div(Expr expr1, Expr expr2) {
        super(expr1, expr2);
        precedence1 = 1;
        precedence2 = 2;
    }

    /**
     * Evaluates the division of a dividend and a divisor. If the divisor equals 0 a XLException is thrown.
     * @param op1 The dividend.
     * @param op2 The divisor.
     * @return The result of division.
     */
    public double op(double op1, double op2) {
        if (op2 != 0)
            return op1 / op2;
        else
            throw new XLException("Division by zero");
    }

    /**
     * Decides the representation division.
     * @return The representation.
     */
    protected String opString() {
        return "/";
    }
}