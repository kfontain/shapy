package model;

public interface Shape {

    /* position parameter */
    Position getPosition();
    void setPosition(Position p);
    void translate(double dx, double dy);

    int getRotation();
    void setRotation(int r);

    Position getRotationCenter();
    void setRotationCenter(Position p);

    Position getTranslationCenter();
    void setTranslationCenter(Position p);

    RGB getRGB();
    void setRGB(RGB rgb);

}
