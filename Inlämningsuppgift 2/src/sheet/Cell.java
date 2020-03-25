package sheet;

import expr.Environment;

public interface  Cell {
     /**
      * Evaluate cell
      * @param environment an environment that evaluates cells
      * @return the value of the cell
      */
     double value(Environment environment);

     /**
      * Creates a string of the cell content
      * @return the content of the cell
      */
     String toString();

     /**
      * Creates a representative string of the cell
      * @param environment An environment that evaluates cells
      * @return the representation of the cell
      */
     String representation(Environment environment);
}
