package model;

import controller.Controller;
import controller.JavaFXController;
import javafx.scene.paint.Color;
import view.PolygoneDrawerJavaFX;
import view.ShapeDrawer;

public class PolygoneRegJavaFX extends PolygoneReg {

	public PolygoneRegJavaFX(int nbEdges, double length) {
		super(nbEdges, length);
	}
	
	public PolygoneRegJavaFX(int nbEdges, double length, RGB color) {
		super(nbEdges, length, color);
	}

	@Override
	public ShapeDrawer createShapeDrawer(Controller controller) {
		RGB rgb = this.getRGB();
		int red = rgb.getR();
		int blue = rgb.getB();
		int green = rgb.getG();
		Double[] points = this.getPoints(this.getNbEdges(), this.getLength());
		
		return new PolygoneDrawerJavaFX(points, ((JavaFXController)controller).getView(), Color.rgb(red, green, blue));
	}

}
