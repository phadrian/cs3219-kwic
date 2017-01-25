package filters;

import java.util.ArrayList;

/**
 * Created by adrian on 25/1/17.
 */
public class Pipe {

    private ArrayList<String> buffer;
    private ArrayList<String> ignore;

    public Pipe() {
        buffer = new ArrayList<String>();
        ignore = new ArrayList<String>();
    }

    public ArrayList<String> readBuffer() {
        return buffer;
    }

    public ArrayList<String> readIgnore() {
        return ignore;
    }

    public void writeBuffer(ArrayList<String> s) {
        buffer = s;
    }

    public void writeIgnore(ArrayList<String> s) {
        ignore = s;
    }
}
