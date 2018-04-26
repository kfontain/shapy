package controller;

import view.JavaFXView;

public class EditCommand extends JavaFXCommand{
	private JavaFXView view; 
	
	public EditCommand(JavaFXView view) {
		this.view = view;
	}
	
	@Override
	public void execute() {
		//view.createMenuEditor();
	}

}
