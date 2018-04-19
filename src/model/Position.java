package model;

public class Position {

    private double x;
    private double y;

    public Position() {
           x = y = 0;
    }
    
    public Position(double x, double y) {
    	this.x = x;
    	this.y = y;
    }

    public double getX() { return x; }
    public void setX(double n) { x = n; }

    public double getY() { return y; }
    public void setY(double n) { y = n; }

}
