package expr;

class Variable extends Expr {
    private final String name;

    Variable(String name) {
        this.name = name;
    }

    public String toString(int prec) {
        return name;
    }

    public double value(Environment env) {
        return env.value(name);
    }
}