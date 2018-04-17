package sample;

public class Controller {

    Model m;

    public void addModel(Model m) {
        this.m = m;
    }

    public void createRectangle(double x, double y, double w, double h) {
        m.createShape(x, y, w, h);
    }



}
