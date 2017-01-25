package filters;

import java.util.ArrayList;

/**
 * Created by adrian on 25/1/17.
 */
public class Filter {

    private Pipe in, out;

    public Filter() {

    }

    public void setIn(Pipe pipe) {
        in = pipe;
    }

    public void setOut(Pipe pipe) {
        out = pipe;
    }

    public ArrayList<String> readBuffer() {
        return in.readBuffer();
    }

    public ArrayList<String> readIgnore() {
        return in.readIgnore();
    }

    public void writeBuffer(ArrayList<String> s) {
        out.writeBuffer(s);
    }

    public void writeIgnore(ArrayList<String> s) {
        out.writeIgnore(s);
    }
}
