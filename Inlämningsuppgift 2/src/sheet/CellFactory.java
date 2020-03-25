package sheet;
import expr.ExprParser;
import util.XLException;

/**
 * A factory that creates cells
 */

class CellFactory {
    static Cell build(String s) throws XLException {
        ExprParser parser = new ExprParser();
        if (s.length() > 0) {
            if (s.startsWith("#")) {
                return new CommentCell(s);
            } else {
                try {
                    return new ExprCell(parser.build(s));
                } catch (Exception e) {
                    throw XLException.SYNTAX_ERROR;
                }
            }
        }
        throw XLException.EMPTY_ERROR;
    }

}
