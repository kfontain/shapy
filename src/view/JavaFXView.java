package view;

import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Orientation;
import javafx.scene.Scene;

public class JavaFXView implements View, Serializable {
	private Pane canvas;
	private ToolBar menuBar;
	private ToolBar toolBar;
	private Scene scene;
	private BorderPane root;
	
	/* Shape Menu on right click */
	private ContextMenu shapeMenu;
	private MenuItem group;
	private MenuItem deGroup;
	private MenuItem edit;

	private Button save_as;
	private Button load;
	private Button undo;
	private Button redo;

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
		
		shapeMenu = new ContextMenu();
		group = new MenuItem("Group");
		deGroup = new MenuItem("De-group");
		edit = new MenuItem("Edit Color");
		
		scene = new Scene(root, 500, 500);

        save_as = new Button("Save as");
        load = new Button("Load");
        undo = new Button("Undo");
        redo = new Button("redo");
	}

	public Pane getCanvas() {
		return canvas;
	}

	public void setCanvas(Pane canvas) {
		this.canvas = canvas;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	public ArrayList<Shape> getShapesInToolBar() {
		return shapesInToolBar;
	}

	public ArrayList<Shape> getShapesInCanvas() {
		return shapesInCanvas;
	}
	
	public ContextMenu getEditShapeMenu() {
		return shapeMenu;
	}

	public void addMenuBar() {
	    menuBar.getItems().add(save_as);
		menuBar.getItems().add(load);
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
	
	public void addShapeMenu() {
		shapeMenu.getItems().addAll(group, deGroup, edit);
	}

	public double getShapeXPositionInToolBar(Shape shape) {
		Bounds boundsInScene = shape.localToScene(shape.getBoundsInLocal());
		return boundsInScene.getMinX();
	}

	public double getShapeYPositionInToolBar(Shape shape) {
		Bounds boundsInScene = shape.localToScene(shape.getBoundsInLocal());
		return boundsInScene.getMinY();
	}

	public Scene getScene() {
		return scene;
	}

	/*********************************************************************************/
						/* Register Event Handlers on JavaFX objects */
	/*********************************************************************************/

	public void registerCreateShapeInToolBarOnClick(EventHandler<MouseEvent> event) {
		for(Shape item : shapesInToolBar) {
			item.setOnMouseClicked(event);
		}
	}

	public void registerDragShapeToCanvas(EventHandler<MouseEvent> event) {
		for(Shape item : shapesInCanvas) {
			item.setOnMouseDragged(event);
		}
	}

	public void registerMoveShapeOnMouseEnter(EventHandler<MouseEvent> event) {
		for(Shape item : shapesInCanvas) {
			item.setOnMouseEntered(event);
		}
	}

	public void registerShapeOnMousePressed(EventHandler<MouseEvent> event) {
		for(Shape item : shapesInCanvas) {
			item.setOnMousePressed(event);
		}
	}

	public void registerButtonOnMousePressed(EventHandler<MouseEvent> event) {

    }

	/***********************************************************************************/
									/* Testing */
	/***********************************************************************************/
}
