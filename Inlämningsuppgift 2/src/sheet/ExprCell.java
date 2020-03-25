package sheet;

import expr.Environment;
import expr.Expr;

/**
 * A cell that contains an expression.
 */
public class ExprCell implements Cell {
    private final Expr expr;

    ExprCell(Expr expr) {
        this.expr = expr;
    }

    /**
     * Evaluate cell
     * @param environment an environment that evaluates cells.
     * @return the value of the cell.
     */
    @Override
    public double value(Environment environment) {
        return expr.value(environment);
    }

    /**
     * Creates a string of the cell content
     * @return the content of the cell
     */

    @Override
    public String toString() {
        return expr.toString();
    }

    /**
     * Creates a representative string of the cell
     * @param environment An environment that evaluates cells.
     * @return the representative string
     */

    @Override
    public String representation(Environment environment) {
        return Double.toString(value(environment));
    }

}
