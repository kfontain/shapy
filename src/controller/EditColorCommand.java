package controller;

import model.Entity;
import model.RGB;

public class EditColorCommand implements Command{
	private RGB color;
	private Entity shape;
	
	public EditColorCommand(RGB color, Entity shape) {
		this.color = color;
		this.shape = shape;
	}
	
	@Override
	public void execute() {
		shape.setRGB(color);
		//shape.notify();
	}

}
