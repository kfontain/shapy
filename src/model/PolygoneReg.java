package model;

import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public abstract class PolygoneReg extends Shape {

    private Position pos;
    private int nbEdges;
    private double length;
    private int rotation;
    private Position rotationCenter;
    private Position translationCenter;
    private RGB rgb;

    public PolygoneReg() {
    	super();
    }

    public Double[] getPoints(int n, double l) {
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

        return tmp;
    }

    @Override
    public Position getPosition() {
        return pos;
    }

    @Override
    public void setPosition(Position p) { pos = p; }

    @Override
    public void translate(double dx, double dy) {
        pos.setX(pos.getX() + dx);
        pos.setY(pos.getY() + dy);
    }

    public int getNbEdges() { return nbEdges; }

    public void setNbEdges(int n) { nbEdges = n; }

    public double getLength() { return length; }

    public void setLength(double l) { length = l; }

    @Override
    public int getRotation() {
        return rotation;
    }

    @Override
    public void setRotation(int r) {
        rotation = r;
    }

    @Override
    public Position getRotationCenter() {
        return rotationCenter;
    }

    @Override
    public void setRotationCenter(Position p) {
        rotationCenter = p;
    }

    @Override
    public Position getTranslationCenter() {
        return translationCenter;
    }

    @Override
    public void setTranslationCenter(Position p) {
        translationCenter = p;
    }

    @Override
    public RGB getRGB() {
        return rgb;
    }

    @Override
    public void setRGB(RGB rgb) {
        this.rgb = rgb;
    }

	@Override
	public PolygoneReg clone() {
		return (PolygoneReg)super.clone();
	}
	
}
