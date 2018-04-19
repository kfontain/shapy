package controller;

import view.JavaFXView;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import model.Position;
import model.Rectangle;

public class JavaFXController implements Controller {
	private JavaFXView view;
	private Rectangle shapeInToolBar;
	private Rectangle shapeInCanvas;
	
	/* Handlers attributes */
	private double initX, initY;
	private Point2D dragAnchor;

	
	public JavaFXController(JavaFXView view) {
		this.view = view;
		shapeInToolBar = new Rectangle();
		
		shapeInToolBar.setHeight(32);
		shapeInToolBar.setwidth(64);
		
		shapeInToolBar.addObserver(this);
	}
		
	@Override
	public void initilizeView() {
		view.addMenuBar();
		view.addCanvas();
		view.drawRectangleInToolBar(shapeInToolBar.getWidth(), shapeInToolBar.getHeight());
	}
	
	public Scene getScene() {
		return view.getScene();
	}
	
	/************************************************************************/
							/* Event Handlers */
	/************************************************************************/
	
	EventHandler<MouseEvent> createRectangleInToolBarOnClick = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent me) {
			Shape shape = (Shape)me.getSource();
			double x = view.getRecgtanleXPositionInToolBar(shape);
			double y = view.getRectangleYPositionInToolBar(shape);
			
			/* Set the model position */
			shapeInToolBar.setPosition(new Position(x, y));
			shapeInCanvas = shapeInToolBar.clone();
			
			view.drawRectangle(shapeInCanvas.getPosition().getX() , shapeInCanvas.getPosition().getY(), shapeInCanvas.getWidth(), shapeInCanvas.getHeight());
			view.registerDragRectangleToCanvas(dragRectangleToCanvas);
			view.registerMoveRectangleOnMouseEnter(moveRectangleOnMouseEnter);
			view.registerRectangleOnMousePressed(rectangleOnMousePressed);
			
            me.consume();
        }
	};
				
	EventHandler<MouseEvent> dragRectangleToCanvas = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent me) {
			Shape shape = (Shape)me.getSource();
			
			double dragX = me.getSceneX() - dragAnchor.getX();
            double dragY = me.getSceneY() - dragAnchor.getY();
			//calculate new position
            double newXPosition = initX + dragX;
			double newYPosition = initY + dragY;
			shape.setTranslateX(newXPosition);
            shape.setTranslateY(newYPosition);
            
            shapeInCanvas.translate(dragX, dragY);
        }
	};
    
	EventHandler<MouseEvent> moveRectangleOnMouseEnter = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent me) {
			Shape shape = (Shape)me.getSource();
            //change the z-coordinate
            shape.toFront();
        }
	};
        
	EventHandler<MouseEvent> rectangleOnMousePressed= new EventHandler<MouseEvent>() {
		public void handle(MouseEvent me) {
			 Shape shape = (Shape)me.getSource();
			 
            initX = shape.getTranslateX();
            initY = shape.getTranslateY();
            dragAnchor = new Point2D(me.getSceneX(), me.getSceneY());
        }
	};
    
	public void registerEventHandlers() {		
		view.registerCreateRectangleInToolBarOnClick(createRectangleInToolBarOnClick);
		view.registerDragRectangleToCanvas(dragRectangleToCanvas);
		view.registerMoveRectangleOnMouseEnter(moveRectangleOnMouseEnter);
		view.registerRectangleOnMousePressed(rectangleOnMousePressed);
		
	}
	
	/* Model Observer */
	public void updateView() {
	}
}
