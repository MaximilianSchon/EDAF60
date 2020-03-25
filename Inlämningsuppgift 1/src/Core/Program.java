package Core;

import Instructions.Instruction;
import java.util.ArrayList;

class Program extends ArrayList<Instruction> {
    /**
     * Skriver programmet i maskinkod till en sträng
     * @return strängen med maskinkod
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Instruction i : this) {
            sb.append(this.indexOf(i));
            sb.append(" ");
            sb.append(i.toString());
            sb.append( "\n");
        }
        return sb.toString();
    }
}
