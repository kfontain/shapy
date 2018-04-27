package controller;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import model.Entity;
import model.Position;
import view.ShapeDrawer;

public class ShapeInCanvasHandlers extends JavaFXEventHandlers {
	private ArrayList<JavaFXEventHandlers> handlers;
	
	public ShapeInCanvasHandlers(JavaFXController controller,ArrayList<JavaFXEventHandlers> handlers) {
		super(controller);
		this.handlers = handlers;
	}
	
	/************************************************************************/
								/* Create Shape on click in ToolBar*/
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
			
			for(JavaFXEventHandlers handler : handlers) {
				handler.registerEventHandler();
			}
			
			me.consume();
		}
	};

	@Override
	public void registerEventHandler() {
		controller.getView().registerCreateShapeInToolBarOnClick(createShapeInToolBarOnClick);
	}
}
