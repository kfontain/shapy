package view;

public interface View {
	public void addMenuBar();
	public void addCanvas();
	
	public void drawRectangle(double x, double y, double w, double h);
	public void drawRectangleInToolBar(double width, double height);
}
