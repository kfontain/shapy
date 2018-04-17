package sample;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private Controller ctrl;
    private List<Shape> shapes;

    public void createShape(double x, double y, double w, double h) {
        Shape tmp = new Shape(x, y, w, h);
        shapes.add(tmp);
    }

    public Model() {
        shapes = new ArrayList<Shape>();
    }

    public void addShape(Shape s) {
        shapes.add(s);
    }

    public void notifyUpdate() {
        //ctrl.notifyUpdate();
    }

}
