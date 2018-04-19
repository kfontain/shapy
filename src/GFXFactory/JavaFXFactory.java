package GFXFactory;

import controller.Controller;
import controller.JavaFXController;
import view.JavaFXView;

public class JavaFXFactory implements GFXFactory{
	/* Attributes will be here */
	private JavaFXView view;
	
	public JavaFXFactory() {
		view = new JavaFXView();
	}
	
	public Controller createController() {
		return new JavaFXController(view);
	}
}
