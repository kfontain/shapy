package GFXFactory;

import controller.Controller;
import controller.JavaFXController;
import view.JavaFXView;
import view.View;

public class JavaFXFactory implements GFXFactory{
	/* Attributes will be here */
	
	public JavaFXFactory() {
		
	}
	
	public Controller createController() {
		return new JavaFXController();
	}
	
	public View createView() {
		return new JavaFXView();
	}
}
