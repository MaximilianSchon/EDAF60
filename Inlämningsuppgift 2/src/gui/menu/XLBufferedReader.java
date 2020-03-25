package gui.menu;

import sheet.Sheet;
import util.XLException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class XLBufferedReader extends BufferedReader {
    XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    void load(Sheet sheet) throws IOException {
        sheet.clearAll();
        ArrayList<String> rest = new ArrayList<>();
        while (ready()) {
            String string = readLine();
            int i = string.indexOf('=');
            try {
                sheet.put(string.substring(0, i), string.substring(i + 1));
            } catch (XLException e) {
                rest.add(string);
            }
        }
        int old = 0;
        ArrayList<String> toBeRemoved = new ArrayList<>();
        while (old != rest.size()) {
            try {
                for (String s : rest) {
                    int i = s.indexOf('=');
                        sheet.put(s.substring(0, i), s.substring(i + 1));
                        toBeRemoved.add(s);
                    }
                rest.removeAll(toBeRemoved);
            } catch (XLException e) {
                old = rest.size();
            }
        }
        for (String s : rest) {
            int i = s.indexOf('=');
            sheet.put(s.substring(0, i), s.substring(i + 1));
        }
    }
}

