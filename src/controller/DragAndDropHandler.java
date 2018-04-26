package controller;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import model.Entity;
import model.Position;
import view.ShapeDrawer;

public class DragAndDropHandler extends JavaFXEventHandlers {
	
	public DragAndDropHandler(JavaFXController controller) {
		super(controller);
	}
	
	/* Handler attributes */
	private double initX, initY;
	private Point2D dragAnchor;

	/************************************************************************/
								/* Drag And Drop*/
	/************************************************************************/

	EventHandler<MouseEvent> createShapeInToolBarOnClick = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent me) {
			Shape shape = (Shape)me.getSource();
			double x = controller.getView().getShapeXPositionInToolBar(shape);
			double y = controller.getView().getShapeYPositionInToolBar(shape);
			
			/* Set the model position */
			ArrayList<Shape> shapes = controller.getView().getShapesInToolBar();
			if(shapes.size() == controller.getShapesInToolBar().size()) {
				double shapeX, shapeY; 
				for(int i = 0 ; i < shapes.size(); ++i) {
					shapeX = controller.getView().getShapeXPositionInToolBar(shapes.get(i));
					shapeY = controller.getView().getShapeYPositionInToolBar(shapes.get(i));
					if(shapeX == x && shapeY == y) {
						controller.getShapesInToolBar().get(i).setPosition(new Position(x, y));
					}
				}
			}

			for(Entity model : controller.getShapesInToolBar()) {
				if(model.getPosition().getX() == x && model.getPosition().getY() == y) {
					Entity copy = model.clone();
					ShapeDrawer drawer = copy.createShapeDrawer(controller);
					drawer.drawShape();
					controller.getShapesInCanvas().add(copy);
				}
			}
			
			controller.getView().registerDragShapeToCanvas(dragShapeToCanvas);
			controller.getView().registerMoveShapeOnMouseEnter(moveShapeOnMouseEnter);
			controller.getView().registerShapeOnMousePressed(shapeOnMousePressed);
			me.consume();
		}
	};

	EventHandler<MouseEvent> dragShapeToCanvas = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent me) {
			Shape shape = (Shape)me.getSource();
			double x = controller.getView().getShapeXPositionInToolBar(shape);
			double y = controller.getView().getShapeYPositionInToolBar(shape);

			double dragX = me.getSceneX() - dragAnchor.getX();
			double dragY = me.getSceneY() - dragAnchor.getY();
			//calculate new position
			double newXPosition = initX + dragX;
			double newYPosition = initY + dragY;
			shape.setTranslateX(newXPosition);
			shape.setTranslateY(newYPosition);

			for(Entity model : controller.getShapesInCanvas()) {
				if(model.getPosition().getX() == x && model.getPosition().getY() == y) {
					Command translateCommand = new TranslateCommand(dragX, dragY, model);
					controller.getCommands().addFirst(translateCommand);
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
		
	@Override
	public void registerEventHandler() {
		controller.getView().registerCreateShapeInToolBarOnClick(createShapeInToolBarOnClick);
	}
}
