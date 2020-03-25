package Core;

/**
 * Ett gränssnitt för minnen
 */
public interface Memory {

 /**
  * Hämtar ett ord i minnet på plats i
  * @param i en plats i minnet i integer-form
  * @return ordet på plats i.
  */

 Word getWord(int i);

}
