package sheet;


import expr.Environment;
import util.XLException;

/**
 * A cell that throws an error if reached
 */

public class BombCell implements Cell {


    BombCell() {
    }

    /**
     * Throw error
     * @param environment an environment that evaluates cells
     * @return throws an error and doesn't return
     */

    @Override
    public double value(Environment environment)
    {
        throw XLException.CIRCULAR_ERROR;
    }

    /**
     * Creates a string of the cell content
     * @return A blank string
     */

    @Override
    public String toString() {
        return "";
    }

    /**
     * Creates a representative string of the cell
     * @param environment An environment that evaluates cells
     * @return A blank string
     */
    @Override
    public String representation(Environment environment) {
        return "bomb";
    }


}