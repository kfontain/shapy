package sample;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class View {

    private Pane pane;
    private double width;
    private double height;

    public View(double w, double h) {
        height = h;
        width = w;
    }

    public void Initialize(Stage ps) {
        pane = new Pane();
        Scene s = new Scene(pane, width, height, Color.WHEAT);
        ps.setScene(s);
        ps.show();
    }

    public void drawShape(double x, double y, double w, double h) {
        Rectangle rectangle = new Rectangle(w, h, Color.RED);
        pane.getChildren().add(rectangle);
        rectangle.setX(x);
        rectangle.setY(y);
    }

}
