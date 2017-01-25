package filters;

import ui.Controller;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by adrian on 25/1/17.
 */
public class Input extends Filter{

    private Scanner sc;

    public Input() {
        sc = new Scanner(System.in);
    }

    public void run(ArrayList<String> titles, ArrayList<String> ignore) {
        /*
        // Read in n number of lines
        int numLines = 0;
        numLines = sc.nextInt();
        sc.nextLine();

        ArrayList<String> s = new ArrayList<String>();
        for (int i = 0; i < numLines; i++) {
            s.add(sc.nextLine());
        }

        // Read in k number of words to ignore
        int numIgnore = 0;
        numIgnore = sc.nextInt();
        sc.nextLine();
        ArrayList<String> si = new ArrayList<String>();
        for (int i = 0; i < numIgnore; i++) {
            si.add(sc.nextLine());
        }
        //*/

        // Write the data to the pipe
        writeBuffer(titles);
        writeIgnore(ignore);
    }
}
