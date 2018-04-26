package controller;

import view.JavaFXView;
import view.ShapeDrawer;

import model.Entity;
import model.Position;
import model.RGB;
import model.RectangleJavaFX;

import java.util.ArrayDeque;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

public class JavaFXController implements Controller {
	
	/*View*/
	private JavaFXView view;
	/*Model*/
	private ArrayList<Entity> shapesInToolBar;
	private ArrayList<Entity> shapesInCanvas;
	
	/* Handlers attributes */
	private double initX, initY;
	private Point2D dragAnchor;
	
	/* Command */
	private ArrayDeque<Command> commands;
		
	public JavaFXController(JavaFXView view) {
		this.view = view;
		shapesInToolBar = new ArrayList<Entity>();
		shapesInCanvas = new ArrayList<Entity>();
		shapesInToolBar.add(new RectangleJavaFX(64, 32, 0, 0, new RGB(0, 191, 255)));
		shapesInToolBar.add(new RectangleJavaFX(64, 32, 0, 0, new RGB(0, 21, 255)));
		commands = new ArrayDeque<Command>();
		
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
	
	/************************************************************************/
							/* Event Handlers */
	/************************************************************************/
	
	EventHandler<MouseEvent> createShapeInToolBarOnClick = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent me) {
			Shape shape = (Shape)me.getSource();
			double x = view.getRecgtanleXPositionInToolBar(shape);
			double y = view.getRectangleYPositionInToolBar(shape);
			
			/* Set the model position */
			ArrayList<Shape> shapes = view.getShapesInToolBar();
			if(shapes.size() == shapesInToolBar.size()) {
				double shapeX, shapeY; 
				for(int i = 0 ; i < shapes.size(); ++i) {
					shapeX = view.getRecgtanleXPositionInToolBar(shapes.get(i));
					shapeY = view.getRectangleYPositionInToolBar(shapes.get(i));
					if(shapeX == x && shapeY == y) {
						shapesInToolBar.get(i).setPosition(new Position(x, y));
					}
				}
			}

			for(Entity model : shapesInToolBar) {
				if(model.getPosition().getX() == x && model.getPosition().getY() == y) {
					Entity copy = model.clone();
					ShapeDrawer drawer = copy.createShapeDrawer(JavaFXController.this);
					drawer.drawShape();
					shapesInCanvas.add(copy);
				}
			}
			
			view.registerDragShapeToCanvas(dragShapeToCanvas);
			view.registerMoveShapeOnMouseEnter(moveShapeOnMouseEnter);
			view.registerShapeOnMousePressed(shapeOnMousePressed);
            me.consume();
        }
	};
				
	EventHandler<MouseEvent> dragShapeToCanvas = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent me) {
			Shape shape = (Shape)me.getSource();
			double x = view.getRecgtanleXPositionInToolBar(shape);
			double y = view.getRectangleYPositionInToolBar(shape);
			
			double dragX = me.getSceneX() - dragAnchor.getX();
            double dragY = me.getSceneY() - dragAnchor.getY();
			//calculate new position
            double newXPosition = initX + dragX;
			double newYPosition = initY + dragY;
			shape.setTranslateX(newXPosition);
            shape.setTranslateY(newYPosition);
            
			for(Entity model : shapesInCanvas) {
				if(model.getPosition().getX() == x && model.getPosition().getY() == y) {
					Command translateCommand = new TranslateCommand(dragX, dragY, model);
		            commands.addFirst(translateCommand);
		            translateCommand.execute();
				}
			}
        }
	};
    
	EventHandler<MouseEvent> moveShapeOnMouseEnter = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent me) {
			Shape shape = (Shape)me.getSource();
            //change the z-coordinate
            shape.toFront();
        }
	};
        
	EventHandler<MouseEvent> shapeOnMousePressed= new EventHandler<MouseEvent>() {
		public void handle(MouseEvent me) {
			 Shape shape = (Shape)me.getSource();
			 
            initX = shape.getTranslateX();
            initY = shape.getTranslateY();
            dragAnchor = new Point2D(me.getSceneX(), me.getSceneY());
        }
	};
    	
	/* Model Observer */
	public void updateView() {
	}
	
	/***************************************************************************************************/
											/* Register Event Handlers */
	/**************************************************************************************************/
	
	public void initDragAndDropShapeHandler() {
		view.registerCreateShapeInToolBarOnClick(createShapeInToolBarOnClick);
	}	
}
