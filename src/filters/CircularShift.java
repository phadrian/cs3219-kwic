package filters;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by adrian on 25/1/17.
 */
public class CircularShift extends Filter {

    private ArrayList<String> s, si;

    public CircularShift() {
        s = new ArrayList<String>();
        si = new ArrayList<String>();
    }

    public void run() {
        // Read in data from its upward stream
        s = readBuffer();
        si = readIgnore();

        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < s.size(); i++) {
            addListToBuffer(getShiftedStrings(s.get(i)), result);
        }

        writeBuffer(result);
        writeIgnore(si);
    }

    private void addListToBuffer(ArrayList<String> s, ArrayList<String> t) {
        for (int i = 0; i < s.size(); i++) {
            t.add(s.get(i));
        }
    }

    private ArrayList<String> getShiftedStrings(String s) {
        // Split the string into an ArrayList
        ArrayList<String> split = new ArrayList<String>(Arrays.asList(s.split(" ")));
        // Shift the string
        ArrayList<String> shifted = new ArrayList<String>();
        for (int i = 0; i < split.size(); i++) {
            String concat = "";
            String word = split.get(i);
            if (!isIgnoreWord(word)) {
                for (int j = 0; j < split.size(); j++) {
                    concat += (split.get((j + i) % split.size()) + " ");
                }
                shifted.add(concat);
            }
        }
        return shifted;
    }

    private boolean isIgnoreWord(String word) {
        for (int i = 0; i < si.size(); i++) {
            if (word.toUpperCase().equals(si.get(i).toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
