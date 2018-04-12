package view;

import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

public class JavaFXView implements View{
	private Canvas canvas;
	private ToolBar toolBar;
	private Scene scene;
	private Pane root;
	
	public JavaFXView() {
		canvas = new Canvas();
		toolBar = new ToolBar();
		root = new Pane();
		scene = new Scene(root);
		root.getChildren().add(toolBar);
		root.getChildren().add(canvas);
	}
	
	public void addMenuBar() {
		Button save_as = new Button("Save as", new ImageView(new Image("saveAs.png")));
		Button load_as = new Button("Load", new ImageView(new Image("loadAs.png")));
		Button undo = new Button("Undo", new ImageView(new Image("undo.png")));
		Button redo = new Button("redo", new ImageView(new Image("redo.png")));
		
		toolBar.getItems().add(save_as);
		toolBar.getItems().add(load_as);
		toolBar.getItems().add(undo);
		toolBar.getItems().add(redo);
	}
	
	public void addCanvas() {
		/* ToolBar */
		
		
		/* Canvas */
	}
	
	public void addRectangleToToolBar(double width, double height) {
		
	}
	
	public void addPolygoneToToolBar() {
		
	}
}
