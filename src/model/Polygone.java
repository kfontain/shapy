package model;

public class Polygone implements Shape {

    private Position pos;
    private int nbEdges;
    private int length;
    private int rotation;
    private Position rotationCenter;
    private Position translationCenter;
    private RGB rgb;

    public Polygone() {

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

    public int getLength() { return length; }

    public void setLength(int l) { length = l; }

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

}
