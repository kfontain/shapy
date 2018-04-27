package controller;

import view.JavaFXView;
import view.ShapeDrawer;

import model.Entity;
import model.PolygoneRegJavaFX;
import model.RGB;
import model.RectangleJavaFX;

import java.util.ArrayDeque;
import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class JavaFXController implements Controller {

	/* View */
	private JavaFXView view;
	/* Model */
	private ArrayList<Entity> shapesInToolBar;
	private ArrayList<Entity> shapesInCanvas;

	/* Event Handlers */
	private ArrayList<JavaFXEventHandlers> eventHandlers;

	/* Command */
	private ArrayDeque<Command> commands;

	public JavaFXController(JavaFXView view) {
		this.view = view;
		shapesInToolBar = new ArrayList<Entity>();
		shapesInCanvas = new ArrayList<Entity>();
		
		shapesInToolBar.add(new RectangleJavaFX(64, 32, 0, 0, new RGB(0, 191, 255)));
		shapesInToolBar.add(new RectangleJavaFX(64, 32, 0, 0, new RGB(0, 21, 255)));
		shapesInToolBar.add(new PolygoneRegJavaFX(5, 30, new RGB(0, 21, 255)));
		
		commands = new ArrayDeque<Command>();
		eventHandlers = new ArrayList<JavaFXEventHandlers>();
		
		/* Shape in Canvas Event Handlers must be initialized within ShapeInCanvasHandlers */
		ArrayList<JavaFXEventHandlers> shapesInCanvasHandlers = new ArrayList<JavaFXEventHandlers>();
		shapesInCanvasHandlers.add(new EditShapeMenuHandler(this));
		shapesInCanvasHandlers.add(new DragAndDropHandler(this));
		
		/* All EventHandlers */
		eventHandlers.add(new ShapeInCanvasHandlers(this, shapesInCanvasHandlers));

		for(Entity shape : shapesInCanvas) {
			shape.addObserver(this);
		}
	}

	@Override
	public void initilizeView() {
		view.addMenuBar();
		view.addCanvas();
		view.addShapeMenu();

		for(Entity shape : shapesInToolBar) {
			ShapeDrawer drawer = shape.createShapeDrawer(this);
			drawer.drawShapeInToolBar();
		}		
	}

	public Scene getScene() {
		return view.getScene();
	}

	public JavaFXView getView() {
		return view;
	}

	public ArrayList<Entity> getShapesInToolBar() {
		return shapesInToolBar;
	}

	public ArrayList<Entity> getShapesInCanvas() {
		return shapesInCanvas;
	}

	public ArrayDeque<Command> getCommands() {
		return commands;
	}

	/* Model Observer */
	public void updateView() {
		for(Entity shapeModel : shapesInCanvas) {
			for(Shape shapeView : view.getShapesInCanvas()) {
				if(shapeModel.getPosition().getX() == view.getShapeXPositionInToolBar(shapeView) && shapeModel.getPosition().getY() == view.getShapeYPositionInToolBar(shapeView)) {
					int red = shapeModel.getRGB().getR();
					int blue = shapeModel.getRGB().getB();
					int green = shapeModel.getRGB().getG();
					shapeView.setFill(Color.rgb(red, green, blue));
				}
			}
		}
	}

	/***************************************************************************************************/
									/* Register Event Handlers */
	/**************************************************************************************************/

	public void initEventHandlers() {
		for(JavaFXEventHandlers event : eventHandlers) {
			event.registerEventHandler();
		}
	}	
}
