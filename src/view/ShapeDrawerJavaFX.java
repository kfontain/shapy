package view;

import javafx.scene.paint.Color;

public abstract class ShapeDrawerJavaFX implements ShapeDrawer {
	protected JavaFXView view;
	protected Color color;
	
	public ShapeDrawerJavaFX(JavaFXView view, Color color) {
		this.view = view;
		this.color = color;
	}
			
	public abstract void drawShape();
	public abstract void drawShapeInToolBar();
	
}
