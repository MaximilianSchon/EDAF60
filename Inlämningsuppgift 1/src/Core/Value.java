package Core;

/**
 * Ett gränssnitt får ett värde, vilket motsvarar ett ord eller en minnesadress.
 */
public interface Value {
        /**
         * Hämtar ett ord ifrån ett värde.
         * @param memory minnet
         * @return ett ord
         */

        Word getWord(Memory memory);


        /**
         * Skriver ut värdet i strängformat.
         * @return en sträng
         */
        String toString();

        /**
         * Kollar om två värden innehåller samma värde.
         * @param value ett värde
         * @param memory ett minne
         * @return om värdena är samma.
         */
        Boolean equals(Value value, Memory memory);
}
