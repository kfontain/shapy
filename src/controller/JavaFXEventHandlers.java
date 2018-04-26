package controller;

public abstract class JavaFXEventHandlers implements EventHandlers{	
	protected JavaFXController controller;
	
	public JavaFXEventHandlers(JavaFXController controller) {
		this.controller = controller;
	}
	
	public abstract void registerEventHandler();
}
