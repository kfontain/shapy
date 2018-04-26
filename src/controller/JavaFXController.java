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
		eventHandlers.add(new DragAndDropHandler(this));

		for(Entity shape : shapesInToolBar) {
			shape.addObserver(this);
		}
	}

	@Override
	public void initilizeView() {
		view.addMenuBar();
		view.addCanvas();

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
	}

	/***************************************************************************************************/
									/* Register Event Handlers */
	/**************************************************************************************************/

	public void initDragAndDropShapeHandler() {
		//view.registerCreateShapeInToolBarOnClick(createShapeInToolBarOnClick);
		for(JavaFXEventHandlers event : eventHandlers) {
			event.registerEventHandler();
		}
	}	
}
