package controller;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import model.Entity;

public class DragAndDropHandler extends JavaFXEventHandlers {
	
	/* Handler attributes */
	private double initX, initY;
	private Point2D dragAnchor;

	public DragAndDropHandler(JavaFXController controller) {
		super(controller);
	}
	
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
		controller.getView().registerDragShapeToCanvas(dragShapeToCanvas);
		controller.getView().registerMoveShapeOnMouseEnter(moveShapeOnMouseEnter);
		controller.getView().registerShapeOnMousePressed(shapeOnMousePressed);
	}
}
