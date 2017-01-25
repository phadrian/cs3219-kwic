package ui;

import filters.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    @FXML
    private TextArea inputTextArea;

    @FXML
    private TextArea ignoreTextArea;

    @FXML
    private TextArea outputTextArea;

    public Controller() {

    }

    @FXML
    private void handleRunButton(ActionEvent event) {

        // Get the text from TextArea into an ArrayList of strings
        ArrayList<String> inputText = new ArrayList<String>(Arrays.asList(inputTextArea.getText().split("\n")));
        ArrayList<String> ignoreText = new ArrayList<String>(Arrays.asList(ignoreTextArea.getText().split("\n")));

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
        ///*
        input.run(inputText, ignoreText);
        cs.run();
        sort.run();
        String result = output.run();
        //*/

        outputTextArea.setText(result);
    }
}
