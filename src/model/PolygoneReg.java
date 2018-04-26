package model;

import java.util.List;

public abstract class PolygoneReg extends Shape {

    private Position pos;
    private int nbEdges;
    private double length;
    private int rotation;
    private Position rotationCenter;
    private Position translationCenter;
    private RGB rgb;
    private getPointsAlgo algo;

    public PolygoneReg() {
    	super();
    }

    public List<Position> getPoints() {
        return algo.getPoints(this.nbEdges, this.length);
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
