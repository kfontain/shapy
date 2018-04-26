package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import model.Position;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Main extends Application {


    /*
     * Renvoie un tableau de Double contenant les coordonnées des points.
     * L'objet Polygon de JavaFX peut directement utiliser le tableau retourné.
     * @param n nombre de côtés du polygone
     * @param l longueur des côtés du polygone
     */
    public Double[] toDouble (int n, double l) {

        Double[] tmp = new Double[n*2];
        tmp[0] = tmp[1] = 0.0; // first point (0,0)

        // angle intérieur en radian
        double angle =  (n - 2) * 3.14 / n;

        // Calcul des coordonées des points
        for (int i = 2; i < n * 2; i+=2) {
            double tmp_angle = angle - ((i/2 * 360/n) * 3.14 / 180);
            tmp[i] = tmp[i - 2] + l * cos(tmp_angle);
            tmp[i+1] = tmp[i - 1] + l * sin(tmp_angle);
        }

        /*
        return new Double[] {
                0.0, 0.0,
                20.0, 10.0,
                10.0, 20.0
        };
        */

        return tmp;
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene s = new Scene(pane, 800, 600, Color.WHEAT);

        /* Création d'un polygone en précisant nombre de côtés et longueur */
        Polygon p = new Polygon();
        p.getPoints().addAll(toDouble(7, 100));

        p.relocate(400, 300);
        pane.getChildren().add(p);
        primaryStage.setScene(s);
        primaryStage.show();
    }

    public static void main (String args[] ) {
        launch(args);
    }
}
