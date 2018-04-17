package sample;

import model.Position;
import model.RGB;

public class Shape {

    private int length;
    private int height;
    private Position pos;
    private int rotation;
    private Position rotationCenter;
    private Position translationCenter;
    private RGB rgb;

    public Shape() {

    }

    public Shape(double x, double y, double w, double h) {

    }

    public int getLength() {
        return length;
    }

    public void setLength(int l) {
        length = l;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int h) {
        height = height;
    }

    public Position getPosition() {
        return pos;
    }

    public void setPosition(Position p) { pos = p; }

    public void translate(double dx, double dy) {
        pos.setX(pos.getX() + dx);
        pos.setY(pos.getY() + dy);
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int r) {
        rotation = r;
    }

    public Position getRotationCenter() {
        return rotationCenter;
    }

    public void setRotationCenter(Position p) {
        rotationCenter = p;
    }

    public Position getTranslationCenter() {
        return translationCenter;
    }

    public void setTranslationCenter(Position p) {
        translationCenter = p;
    }

    public RGB getRGB() {
        return rgb;
    }

    public void setRGB(RGB rgb) {
        this.rgb = rgb;
    }

}
