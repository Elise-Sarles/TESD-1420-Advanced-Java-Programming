/*
 * Author: Elise Sarles and Y.Daniel Liang
 * Title: Exercise18_19
 * Date: May 9-14 2025
 * Description:  Creates a Siepinski triangle using recursion buttons to increase and decrease the order of the triangle.
 */
package application;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class Exercise18_19  extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {       
    SierpinskiTrianglePane pane = new SierpinskiTrianglePane(); 
    TextField tfOrder = new TextField(); 
    Button plus = new Button("+");
    Button minus = new Button("-");
    plus.setOnAction(pane.plusb);
    minus.setOnAction(pane.minusb);
    /*
    tfOrder.setOnAction(
      e -> pane.setOrder(Integer.parseInt(tfOrder.getText())));
    */
    tfOrder.setPrefColumnCount(4);
    tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

    // Pane to hold label, text field, and a button
    HBox hBox = new HBox(10);
    hBox.getChildren().addAll(new Label("Plus or minus the number of the order"), plus, minus);
    hBox.setAlignment(Pos.CENTER);
    
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    borderPane.setBottom(hBox);
        
    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 300, 210);
    primaryStage.setTitle("SierpinskiTriangle"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    pane.widthProperty().addListener(ov -> pane.paint());
    pane.heightProperty().addListener(ov -> pane.paint());
  }

  /** Pane for displaying triangles */
  static class SierpinskiTrianglePane extends Pane {
    private int order = 0;

    /** Set a new order */
    /*public void setOrder(int order) {
      this.order = order;
      paint();
    }
    */
    EventHandler<ActionEvent> minusb = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
        	if(order > 0){
           order = order - 1;
           paint();
        	}
        }
    };
    EventHandler<ActionEvent> plusb = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e)
        {
        	order = order + 1;
        	paint();
        }
    };
    

    SierpinskiTrianglePane() {
    }

    protected void paint() {
      // Select three points in proportion to the panel size
      Point2D p1 = new Point2D(getWidth() / 2, 10);
      Point2D p2 = new Point2D(10, getHeight() - 10);
      Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);

      this.getChildren().clear(); // Clear the pane before redisplay

      displayTriangles(order, p1, p2, p3);
    }

    private void displayTriangles(int order, Point2D p1, 
        Point2D p2, Point2D p3) {
      if (order == 0) {
        // Draw a triangle to connect three points
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), 
          p2.getY(), p3.getX(), p3.getY());
        triangle.setStroke(Color.BLACK);
        triangle.setFill(Color.WHITE);

        this.getChildren().add(triangle);
      } 
      else {
        // Get the midpoint on each edge in the triangle
        Point2D p12 = p1.midpoint(p2);
        Point2D p23 = p2.midpoint(p3);
        Point2D p31 = p3.midpoint(p1);

        // Recursively display three triangles
        displayTriangles(order - 1, p1, p12, p31);
        displayTriangles(order - 1, p12, p2, p23);
        displayTriangles(order - 1, p31, p23, p3);
      }
    }
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
