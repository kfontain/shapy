package model;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.ArrayList;
import java.util.Iterator;

import controller.Controller;

public abstract class Shape implements Entity {
	private ArrayList<Controller> observers;
    protected RGB rgb;
	
	public Shape() {
		observers = new ArrayList<Controller>();
		rgb = new RGB(0, 0, 0);
	}
	
	public Shape(RGB color) {
		this.rgb = color;
		observers = new ArrayList<Controller>();
	}
	
	public void addEntity(Entity e) throws UnsupportedOperationException {
		throw new UnsupportedAddressTypeException();
	}
	
	public void removeEntity(Entity e) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	public Iterator<Entity> getChildren() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	public Shape clone() {
		try {
			return (Shape) super.clone();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return this;
	}
	
    public void addObserver(Controller observer) {
    	observers.add(observer);
    }
    
    public void removeObserver(Controller observer) {
    	observers.remove(observer);
    }

    public void notifyObservers() {
    	for(Controller each : observers) {
    		each.updateView();
    	}
    }

}
