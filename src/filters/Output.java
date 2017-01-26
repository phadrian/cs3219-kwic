package filters;

import java.util.ArrayList;

/**
 * Created by adrian on 25/1/17.
 */
public class Output extends Filter {

    private ArrayList<String> s, si;

    public Output() {
        s = new ArrayList<String>();
        si = new ArrayList<String>();
    }

    public String run() {
        s = readBuffer();
        si = readIgnore();

        // Concatenate the strings with newlines for display
        String result = "";
        for (int i = 0; i < s.size(); i++) {
            result += s.get(i) + "\n";
        }

        return result;
    }
}
