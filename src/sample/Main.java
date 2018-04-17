package sample;

import com.apple.laf.AquaButtonBorder;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {

    private double x0, y0;
    private double xscene, yscene;
    private Rectangle selection;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Scene s = new Scene(pane, 800, 600, Color.WHEAT);
        Rectangle rectangle = new Rectangle(250,150,Color.RED);
        pane.getChildren().add(rectangle);
        rectangle.setX(275);
        rectangle.setY(225);

        s.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xscene = event.getSceneX();
                yscene = event.getSceneY();
                selection = new Rectangle(xscene, yscene,0, 0);
                selection.setFill(Color.LIGHTBLUE);
                pane.getChildren().add(selection);
            }
        });

        s.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent m) {
                selection.setWidth(m.getSceneX() - xscene);
                selection.setHeight(m.getSceneY() - yscene);
            }
        });

        s.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent m) {
                selection.setWidth(0);
                selection.setHeight(0);
            }
        });


        rectangle.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x0 = event.getSceneX() - rectangle.getX();
                y0 = event.getSceneY() - rectangle.getY();
            }
        });

        rectangle.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent m) {
                rectangle.setX(m.getSceneX() - x0);
                rectangle.setY(m.getSceneY() - y0);
            }
        });

        rectangle.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent m) {
                rectangle.setX(m.getSceneX() - x0);
                rectangle.setY(m.getSceneY() - y0);
            }
        });
        primaryStage.setScene(s);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
