package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import model.Entity;
import model.RGB;

public class EditShapeMenuHandler extends JavaFXEventHandlers {
	private Color color;
	private Shape shapeInCanvas;
	
	public EditShapeMenuHandler(JavaFXController controller) {
		super(controller);
	}

	EventHandler<ContextMenuEvent> shapeMenuHandler = new EventHandler<ContextMenuEvent>() {
		@Override
		public void handle(ContextMenuEvent event) {
			Shape shape = (Shape)event.getSource();
			shapeInCanvas = shape;
			for(Shape shapeInView : controller.getView().getShapesInCanvas()) {
				controller.getView().getEditShapeMenu().show(shapeInView, event.getScreenX(), event.getScreenY());	
			}
		}
	};
	
	EventHandler<ActionEvent> colorPicker = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			color = controller.getView().getColorPicker().getValue();
			shapeInCanvas.setFill(color);

			int red = (int)color.getRed();
			int green = (int)color.getGreen();
			int blue = (int)color.getBlue();
			double x = controller.getView().getShapeXPositionInToolBar(shapeInCanvas);
			double y = controller.getView().getShapeYPositionInToolBar(shapeInCanvas);
			
			for(Entity shapeModel : controller.getShapesInCanvas()) {
				if(shapeModel.getPosition().getX() == x && shapeModel.getPosition().getY() == y) {
					Command colorCommand = new EditColorCommand(new RGB(red, green, blue), shapeModel);
					colorCommand.execute();
				}
			}
		}
	};
	
	EventHandler<ActionEvent> editColor = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
		}
	};
	
	@Override
	public void registerEventHandler() {
		controller.getView().registerShapeMenuEditorHandler(shapeMenuHandler);
		controller.getView().registerColorPickerHandler(colorPicker);
		controller.getView().registerShapeEditColorHandler(editColor);
	}

}
