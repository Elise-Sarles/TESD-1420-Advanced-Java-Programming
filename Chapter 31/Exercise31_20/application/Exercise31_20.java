package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.geometry.Side;


public class Exercise31_20  extends Application {

	public void start(Stage primaryStage) throws Exception {
		TabPane tabPane = new TabPane();
	    Tab tab1 = new Tab("Line");
	    StackPane pane1 = new StackPane();
	    pane1.getChildren().add(new Line(10, 10, 80, 80));
	    tab1.setContent(pane1);
	    Tab tab2 = new Tab("Rectangle");
	    tab2.setContent(new Rectangle(10, 10, 200, 200));
	    Tab tab3 = new Tab("Circle");
	    tab3.setContent(new Circle(50, 50, 20));    
	    Tab tab4 = new Tab("Ellipse");
	    tab4.setContent(new Ellipse(10, 10, 100, 80));
	    tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
	    
	    HBox radiobuttons = new HBox();

	    ToggleGroup tg = new ToggleGroup();
	    RadioButton topButton = new RadioButton("Top");
	    RadioButton leftButton = new RadioButton("Left");
	    RadioButton bottomButton = new RadioButton("Bottom");
	    RadioButton rightButton = new RadioButton("Right");
	    
	    topButton.setToggleGroup(tg);
	    leftButton.setToggleGroup(tg);
	    bottomButton.setToggleGroup(tg);
	    rightButton.setToggleGroup(tg);
	    
	    radiobuttons.getChildren().addAll(topButton,leftButton, bottomButton,rightButton);
	    VBox pane = new VBox(5, tabPane, radiobuttons);

	    topButton.setOnAction(e ->
	            tabPane.setSide(Side.TOP));

	    leftButton.setOnAction(e ->
	            tabPane.setSide(Side.LEFT));

	    bottomButton.setOnAction(e ->
	            tabPane.setSide(Side.BOTTOM));

	    rightButton.setOnAction(e ->
	            tabPane.setSide(Side.RIGHT));

	    Scene scene = new Scene(pane, 300, 250);  
	    primaryStage.setTitle("DisplayFigure"); // Set the window title
	    primaryStage.setScene(scene); // Place the scene in the window
	    primaryStage.show(); // Display the window
	  }

	  /**
	   * The main method is only needed for the IDE with limited
	   * JavaFX support. Not needed for running from the command line.
	   * line.
	   */
	  public static void main(String[] args) {
	    launch(args);
	  }
	}