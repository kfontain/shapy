package model;

public abstract class Rectangle extends Shape {

    private double width;
    private double height;
    private int rotation;
    private Position rotationCenter;
    private Position translationCenter;
    private int arrondi;

    public Rectangle() {
    	super();
    	width = 30;
    	height = 30;
    }
    
    public Rectangle(double width, double height, double x, double y) {
    	super(x, y);
    	this.width = width;
    	this.height = height;    	
    }
    
    public Rectangle(double width, double height, double x, double y, RGB color) {
    	super(x, y, color);
    	this.width = width;
    	this.height = height;    	
    }

    public double getWidth() {
        return width;
    }

    public void setwidth(double w) {
        width = w;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double h) {
        height = h;
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
    
    public int getArrondi() {
        return arrondi;
    }

    public void setArrondi(int a) {
        arrondi = a;
    }

	@Override
	public Rectangle clone() {
		Rectangle copy = (Rectangle)super.clone();
		copy.setArrondi(arrondi);
		copy.setHeight(height);
		copy.setwidth(width);
		copy.setRGB(rgb);
		copy.setPosition(pos);
		copy.setRotationCenter(rotationCenter);
		copy.setRotation(rotation);
		copy.setTranslationCenter(translationCenter);
		
		return copy;
	}
}
