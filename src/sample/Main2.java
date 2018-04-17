package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        /* Initialize */
        View view = new View(800, 600);
        view.Initialize(primaryStage);
        view.drawShape(275, 225, 250, 150);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
