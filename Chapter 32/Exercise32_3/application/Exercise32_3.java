package application;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import javafx.animation.PathTransition; 
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise32_3 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) throws FileNotFoundException {
		// Create a pane
		Pane pane = new Pane();
	
		// Add an image view and add it to pane
		Image image = new Image(new FileInputStream("C:\\Users\\foxxe\\eclipse-workspace\\Exercise32_3\\src\\application\\us.gif"));  
		ImageView imageView = new ImageView(image);
		pane.getChildren().add(imageView);
		imageView.setX(50);

		Thread animation = new Thread(new Runnable() {
		     @Override
		    public void run() {
		    	try {
		    		for (int y = 200; y >= 0; y--) {
		    			int finalY = y;
		    			Platform.runLater(() -> imageView.setY(finalY));
		    			Thread.sleep(50); // Adjust speed as needed
		    		}
		    	} 
		    	catch (InterruptedException e) {
                e.printStackTrace();
		    	}
		  }
		});
		
		animation.start();
		// Create a path transition
		
		///PathTransition pt = new PathTransition(Duration.millis(10000),new Line(100, 250, 100, 50), imageView); 
		//pt.setCycleCount(5);
		///pt.play(); // Start animation
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 300, 300); 
		primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
		
	public static void main(String[] args) {
		Application.launch(args);
	}
}
