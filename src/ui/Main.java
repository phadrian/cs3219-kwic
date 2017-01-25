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
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {

        Input input = new Input();
        CircularShift cs = new CircularShift();
        Sort sort = new Sort();
        Output output = new Output();

        // Setting up pipes between filters
        Pipe p1 = new Pipe();
        input.setOut(p1);
        cs.setIn(p1);
        Pipe p2 = new Pipe();
        cs.setOut(p2);
        sort.setIn(p2);
        Pipe p3 = new Pipe();
        sort.setOut(p3);
        output.setIn(p3);

        input.run();
        cs.run();
        sort.run();
        output.run();

        launch(args);
    }
}
