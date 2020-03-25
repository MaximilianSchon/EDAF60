package sheet;

import expr.Environment;

public class CommentCell implements Cell {
    private final String comment;
    CommentCell(String comment) {
        this.comment = comment;
    }

    @Override
    public double value(Environment environment) {
        return 0;
    }

    /**
     * Creates a string of the cell content
     * @return the content of the cell
     */
    @Override
    public String toString() {
        return comment;
    }

    /**
     * Creates a representative string of the cell, in this case the string without a number sign.
     * @param environment An environment that evaluates cells
     * @return a representative string of the cell
     */
    @Override
    public String representation(Environment environment) {
        return comment.substring(1);
    }
}
