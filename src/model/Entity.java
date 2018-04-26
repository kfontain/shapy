package model;

import java.util.Iterator;

import controller.Controller;
import view.ShapeDrawer;

public interface Entity extends Cloneable {
	
	/* Composite Pattern */
    public void addEntity(Entity e);
    public void removeEntity(Entity e);
    public Iterator<Entity> getChildren();
    
    /* Prototype Pattern */
    public Entity clone();
    
    /* Observer pattern */
    public void addObserver(Controller observer);
    public void removeObserver(Controller observer);
    public void notifyObservers();
    
    /* MethodFactory Pattern */
    public ShapeDrawer createShapeDrawer(Controller controller);
    //public ShapeEditor createShapeEditor(Controller controller);
    
    /* Operations */
    public Position getPosition();
    public void setPosition(Position p);
    public void translate(double dx, double dy);

    public int getRotation();
    public void setRotation(int r);

    public Position getRotationCenter();
    public void setRotationCenter(Position p);

    public Position getTranslationCenter();
    public void setTranslationCenter(Position p);

    public RGB getRGB();
    public void setRGB(RGB rgb);
}
