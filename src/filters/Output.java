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

    public void run() {
        s = readBuffer();
        si = readIgnore();
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
    }
}
