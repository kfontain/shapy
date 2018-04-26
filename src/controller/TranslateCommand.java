package controller;

import model.Entity;

public class TranslateCommand extends JavaFXCommand{
	private double dragX, dragY;
	private Entity shape;
	
	public TranslateCommand(double dragX, double dragY, Entity shape) {
		this.dragX = dragX;
		this.dragY = dragY;
		this.shape = shape;
	}
	
	@Override
	public void execute() {
		shape.translate(dragX, dragY);
	}

}
