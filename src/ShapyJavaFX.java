import GFXFactory.GFXFactory;
import GFXFactory.JavaFXFactory;
import controller.Controller;
import controller.JavaFXController;
import javafx.application.Application;
import javafx.stage.Stage;

public class ShapyJavaFX extends Application implements Shapy {
	private GFXFactory javafx;

	public ShapyJavaFX() {
		javafx = new JavaFXFactory();
	}
	
	@Override
	public void start(Stage primaryStage) {
		Controller controller = javafx.createController();
		controller.initilizeView();
		controller.initEventHandlers();
		
		JavaFXController javafxController = (JavaFXController)controller;
		primaryStage.setTitle("Shapy");
		primaryStage.setScene(javafxController.getScene());
		primaryStage.show();

		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void launchShapy(String[] args) { 
		ShapyJavaFX.main(args);
	}

}
