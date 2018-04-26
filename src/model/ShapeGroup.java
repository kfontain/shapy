package model;

import java.util.ArrayList;
import java.util.Iterator;

import controller.Controller;
import view.ShapeDrawer;

public class ShapeGroup implements Entity {

    private ArrayList<Shape> children;
    private ArrayList<Controller> observators;

    public ShapeGroup() {
    	children = new ArrayList<Shape>();
    	observators = new ArrayList<Controller>();
    }

    @Override
    public void addEntity(Entity e) {

    }

    @Override
    public void removeEntity(Entity e) {

    }

    @Override
    public Iterator<Entity> getChildren() {
        // return children;
        return null;
    }
    
    public ShapeGroup clone() {
    	try {
        	return (ShapeGroup) super.clone();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return this;
    }
    
	@Override
	public void addObserver(Controller observer) {
		// TODO Auto-generated method stub
		observators.add(observer);
	}

	@Override
	public void removeObserver(Controller observer) {
		// TODO Auto-generated method stub
		observators.remove(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Controller each : observators){
			each.updateView();
		}
	}

	@Override
	public Position getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosition(Position p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void translate(double dx, double dy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getRotation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRotation(int r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Position getRotationCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRotationCenter(Position p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Position getTranslationCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTranslationCenter(Position p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RGB getRGB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRGB(RGB rgb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ShapeDrawer createShapeDrawer(Controller controller) {
		// TODO Auto-generated method stub
		return null;
	}
}
