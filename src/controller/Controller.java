package controller;

public interface Controller {
	
	/* Initialize View and Event Handlers*/
	public void initilizeView();
	public void initEventHandlers();
	
	/* Observer update method */
	public void updateView();
}
