package ui;

import filters.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("KWIC");
        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {

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
        /*
        input.run();
        cs.run();
        sort.run();
        output.run();
        //*/

        launch(args);
    }
}
