package view;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Orientation;
import javafx.scene.Scene;

public class JavaFXView implements View {
	private Pane canvas;
	private ToolBar menuBar;
	private ToolBar toolBar;
	private Scene scene;
	private BorderPane root;
	
	/* Shape attribute in ToolBar (JavaFX Shapes) */
	private ArrayList<Shape> shapesInToolBar;
	private ArrayList<Shape> shapesInCanvas;
	
	public JavaFXView() {
		canvas = new Pane();
		menuBar = new ToolBar();
		toolBar = new ToolBar();
		root = new BorderPane();
		shapesInToolBar = new ArrayList<Shape>();
		shapesInCanvas = new ArrayList<Shape>();
		scene = new Scene(root, 500, 500);
	}
	
	public void addMenuBar() {
		Button save_as = new Button("Save as");
		Button load_as = new Button("Load");
		Button undo = new Button("Undo");
		Button redo = new Button("redo");
		
		menuBar.getItems().add(save_as);
		menuBar.getItems().add(load_as);
		menuBar.getItems().add(undo);
		menuBar.getItems().add(redo);
		
		root.setTop(menuBar);
	}
	
	public void addCanvas() {
		/* ToolBar */
		toolBar.setOrientation(Orientation.VERTICAL);
		root.setLeft(toolBar);
		
		/* Canvas */
		root.setRight(canvas);
		root.setBackground(Background.EMPTY);
	}
	
	public void drawRectangleInToolBar(double width, double height) {
		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(width);
		rectangle.setHeight(height);
		rectangle.setFill(Color.LIGHTBLUE);
				
		toolBar.getItems().add(rectangle);
		shapesInToolBar.add(rectangle);
	}
	
	public void drawRectangle(double x, double y, double width, double height) {
		Rectangle rectangle = new Rectangle(x, y, width, height);
		rectangle.setFill(Color.LIGHTBLUE);
		
		root.getChildren().add(rectangle);
		shapesInCanvas.add(rectangle);
	}
	
	public double getRecgtanleXPositionInToolBar(Shape shape) {
		Bounds boundsInScene = shape.localToScene(shape.getBoundsInLocal());
		return boundsInScene.getMinX();
	}
	
	public double getRectangleYPositionInToolBar(Shape shape) {
		Bounds boundsInScene = shape.localToScene(shape.getBoundsInLocal());
		return boundsInScene.getMinY();
	}
	
	public Scene getScene() {
		return scene;
	}
	
	/*********************************************************************************/
						/* Register Event Handlers on JavaFX objects */
	/*********************************************************************************/
		
	public void registerCreateRectangleInToolBarOnClick(EventHandler<MouseEvent> event) {
		for(Shape item : shapesInToolBar) {
			item.setOnMouseClicked(event);
		}
	}
	
	public void registerDragRectangleToCanvas(EventHandler<MouseEvent> event) {
		for(Shape item : shapesInCanvas) {
			item.setOnMouseDragged(event);
		}
	}
	
	public void registerMoveRectangleOnMouseEnter(EventHandler<MouseEvent> event) {
		for(Shape item : shapesInCanvas) {
			item.setOnMouseEntered(event);
		}
	}
	
	public void registerRectangleOnMousePressed(EventHandler<MouseEvent> event) {
		for(Shape item : shapesInCanvas) {
			item.setOnMousePressed(event);
		}
	}
}
