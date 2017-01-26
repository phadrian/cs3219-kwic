package filters;

import java.util.ArrayList;

/**
 * Created by adrian on 26/1/17.
 */
public class Pipeline {

    public String run(ArrayList<String> inputText, ArrayList<String> ignoreText) {

        // Initialization of filters
        Input input = new Input();
        CircularShift cs = new CircularShift();
        Sort sort = new Sort();
        Output output = new Output();

        // Setting up pipes between filters
        Pipe inputToCs = new Pipe();
        Pipe csToSort = new Pipe();
        Pipe sortToOutput = new Pipe();

        input.setOut(inputToCs);
        cs.setIn(inputToCs);

        cs.setOut(csToSort);
        sort.setIn(csToSort);

        sort.setOut(sortToOutput);
        output.setIn(sortToOutput);

        // Run the filters
        input.run(inputText, ignoreText);
        cs.run();
        sort.run();
        String result = output.run();

        return result;
    }
}
