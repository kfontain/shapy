package model;

public class Rectangle implements Shape {

    private int length;
    private int height;
    private Position pos;
    private int rotation;
    private Position rotationCenter;
    private Position translationCenter;
    private RGB rgb;
    private int arrondi;

    public Rectangle() {

    }

    @Override
    public Position getPosition() {
        return pos;
    }

    @Override
    public void translate(double dx, double dy) {
        pos.setX(pos.getX() + dx);
        pos.setY(pos.getY() + dy);
    }

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
    public int getArrondi() {
        return arrondi;
    }

    @Override
    public void setArrondi(int a) {
        arrondi = a;
    }
}
