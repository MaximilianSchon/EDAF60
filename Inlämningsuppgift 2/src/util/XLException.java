package util;

public class XLException extends RuntimeException {

    public static final XLException CIRCULAR_ERROR = new XLException("Circular refrence error");
    public static final XLException SYNTAX_ERROR = new XLException("Syntax error");
    public static final XLException EMPTY_ERROR = new XLException("Empty cell error");

    public XLException(String message) {
        super(message);
    }
}