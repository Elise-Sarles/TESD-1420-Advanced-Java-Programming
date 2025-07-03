package application;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise31_17  extends Application {
	// Text field for receiving radius
	private static TextField tfAnnualInterestRate = new TextField();
	private static TextField tfNumOfYears = new TextField();
	private static TextField tfinvestAmount = new TextField();
	private static TextField tffutureAmount = new TextField();
	private Button btCalculate= new Button("Calculate");

	// Text area to display contents

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
	 GridPane gridPane = new GridPane();
	 gridPane.add(new Label("Investment amount"), 0, 0);
	 gridPane.add(new Label("Number Of Years"), 0, 1);
	 gridPane.add(new Label("Annual Interest Rate"), 0, 2);
	 gridPane.add(new Label("Future Value"), 0, 3);
	 gridPane.add(tfinvestAmount, 1, 0);
	 gridPane.add(tfNumOfYears, 1, 1);
	 gridPane.add(tfAnnualInterestRate, 1, 2);
	 gridPane.add(tffutureAmount, 1, 3);
	 gridPane.add(btCalculate, 1, 4);
	 
	 tfAnnualInterestRate.setAlignment(Pos.BASELINE_RIGHT);
	 tfNumOfYears.setAlignment(Pos.BASELINE_RIGHT);
	 tfinvestAmount.setAlignment(Pos.BASELINE_RIGHT);
	 tffutureAmount.setAlignment(Pos.BASELINE_RIGHT);
	 
	 tfinvestAmount.setPrefColumnCount(5);
	 tfNumOfYears.setPrefColumnCount(5);
	 tfinvestAmount.setPrefColumnCount(5);
	 tffutureAmount.setPrefColumnCount(5);
	 
	 // Create a MenuBar
     MenuBar menuBar = new MenuBar();

     Menu operationsMenu = new Menu("Operations");

     MenuItem calculateMenuItem = new MenuItem("Calculate");
     calculateMenuItem.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			 calculate();
			
		}
    	 
     });
     MenuItem exitMenuItem = new MenuItem("Exit");
     exitMenuItem.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
			System.exit(0);
			
		}
    	 
     });
     operationsMenu.getItems().addAll(calculateMenuItem, exitMenuItem);

     // Add the Operations Menu to the MenuBar
     menuBar.getMenus().add(operationsMenu);
     
	 BorderPane pane = new BorderPane();
	 
	 pane.setTop(menuBar);
	 pane.setCenter(gridPane);
	 pane.setPadding(new Insets(0, 20, 10, 20));
	 
	 btCalculate.setOnAction(e ->
	 {
		 calculate();
	 });
	 
	 
	 // Create a scene and place it in the stage
	 Scene scene = new Scene(pane, 300, 250);
	 primaryStage.setTitle("Exercise31_01Client"); // Set the stage title
	 primaryStage.setScene(scene); // Place the scene in the stage
	 primaryStage.show(); // Display the stage
	}

	/**
	* The main method is only needed for the IDE with limited
	* JavaFX support. Not needed for running from the command line.
	*/
	public static void main(String[] args) {
	 launch(args);
	}
	
	public static void calculate() {
		 tffutureAmount.setText("");
		 
		  double interestRate = Double.parseDouble(tfAnnualInterestRate.getText());
		  double monthlyinterest = (interestRate/100)/12;
		     int years = Integer.parseInt(tfNumOfYears.getText());
		     double amount = Double.parseDouble(tfinvestAmount.getText());
		     
		double futureAmount;
		futureAmount = (amount * Math.pow((1 + monthlyinterest),(years * 12)));
		DecimalFormat df = new DecimalFormat("#.00"); // "#.00" ensures two decimal places
	    String formattedValue = df.format(futureAmount);
	    
		 tffutureAmount.setText(""+ formattedValue);
		
		
	}
}

