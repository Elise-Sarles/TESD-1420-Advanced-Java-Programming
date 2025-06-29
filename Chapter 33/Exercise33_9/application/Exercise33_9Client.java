package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
public class Exercise33_9Client extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
  public static Socket socket; 
  private DataOutputStream toServer;
  private DataInputStream fromServer;
  
 
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    taServer.setWrapText(true);
    taClient.setWrapText(true);
    //taServer.setDisable(true);

    BorderPane pane1 = new BorderPane();
    pane1.setTop(new Label("History"));
    pane1.setCenter(new ScrollPane(taServer));
    BorderPane pane2 = new BorderPane();
    pane2.setTop(new Label("New Message"));
    pane2.setCenter(new ScrollPane(taClient));
    Button close = new Button("Close");
    
    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(pane1, pane2, close);

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 200, 200);
    primaryStage.setTitle("Exercise31_09Client"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    // To complete later
    try
    {
        socket = new Socket(Exerise33_9Server.NAME, Exerise33_9Server.port);
        toServer = new DataOutputStream(socket.getOutputStream());
        fromServer = new DataInputStream(socket.getInputStream());
        
        new Thread(() ->
        {
            while (true)
            {
                try
                {
                    String message = fromServer.readUTF();
                    System.out.println("message recieved: " + message);
                    
                    taServer.setText(taServer.getText()+"\nS:" + message);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }).start();
        
        taClient.setOnKeyPressed( event -> {
        	if( event.getCode() == KeyCode.ENTER ) {
        		 try
                 {
        			 String sent = taClient.getText().trim();
        			 System.out.println("Enter pressed.");
                     toServer.writeUTF(sent);
                     Platform.runLater(() -> taServer.setText(taServer.getText()+ "\nC: " + sent));
                     toServer.flush();
                     taClient.setText("");
                 }
                 catch (Exception exception)
                 {
                     exception.printStackTrace();
                 }
        	}
        });
        
        close.setOnAction(event);
        
    }
    catch (Exception exception)
    {
        exception.printStackTrace();
    }
     
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
  
  EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent e)
      {
    	  close();
      }
         
  };
  
  private void close() {
	  System.exit(0);
  }
 
}
