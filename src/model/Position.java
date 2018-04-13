package model;

public class Position {

    private int x;
    private int y;

    public Position() {
           x = y = 0;
    }

    public int getY() { return y; }
    public int getX() { return x; }
    public void setX(int n) { x = n; }
    public void setY(int n) { y = n; }

}
