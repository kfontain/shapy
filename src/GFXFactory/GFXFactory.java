package GFXFactory;

import controller.Controller;
import view.View;

public interface GFXFactory {
	public Controller createController();
	public View createView();
}
