package expr;

import util.NumberAdjustment;

class Num extends Expr {
    private static final NumberAdjustment adjustment = new NumberAdjustment(0, 2);
    private final double value;

    Num(double value) {
        this.value = value;
    }

    public String toString(int prec) {
        return adjustment.right(value);
    }

    public double value(Environment env) {
        return value;
    }
}