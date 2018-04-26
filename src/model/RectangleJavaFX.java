package model;

import controller.Controller;
import controller.JavaFXController;
import javafx.scene.paint.Color;
import view.RectangleDrawerJavaFX;
import view.ShapeDrawer;

public class RectangleJavaFX extends Rectangle {
	
	public RectangleJavaFX(double width, double height, double x, double y) {
		super(width, height, x, y);
	}
	
	public RectangleJavaFX(double width, double height, double x, double y, RGB color) {
		super(width, height, x, y, color);
	}
		
	public ShapeDrawer createShapeDrawer(Controller controller) {
		RGB rgb = this.getRGB();
		int red = rgb.getR();
		int blue = rgb.getB();
		int green = rgb.getG();
		
		return new RectangleDrawerJavaFX(this.getPosition().getX(), this.getPosition().getY(), this.getWidth(), this.getHeight(), Color.rgb(red, green, blue), ((JavaFXController) controller).getView());
	}
}
