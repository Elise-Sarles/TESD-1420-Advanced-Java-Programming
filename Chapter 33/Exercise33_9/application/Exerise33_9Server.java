package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Exerise33_9Server extends Application {
  private TextArea taServer = new TextArea();
  private TextArea taClient = new TextArea();
  public static final String NAME = "localhost";
  public static final int port = 6040;
  public static ServerSocket server;
  private DataInputStream fromclient;
  private DataOutputStream toclient;
  
 
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    taServer.setWrapText(true);
    taClient.setWrapText(true);
    //taClient.setDisable(true);

    BorderPane pane1 = new BorderPane();
    pane1.setTop(new Label("History"));
    pane1.setCenter(new ScrollPane(taServer));
    BorderPane pane2 = new BorderPane();
    pane2.setTop(new Label("New Message"));
    pane2.setCenter(new ScrollPane(taClient));
    Label directions = new Label("Close Client applicatioons before closeing server.");
    Button close = new Button("Close");
    
    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(pane1, pane2, directions ,close);

    // Create a scene and place it in the stage
    Scene scene = new Scene(vBox, 300, 200);
    primaryStage.setTitle("Exercise31_09Server"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    // To complete later
    try { 
    	server = new ServerSocket(port);
    	 Platform.runLater(() -> System.out.println("Server started at " + new Date()));
         Socket ClientSocket = server.accept();
         Platform.runLater(() -> System.out.println("Connected to client at " + new Date()));
    	fromclient = new DataInputStream(ClientSocket.getInputStream());
    	toclient = new DataOutputStream(ClientSocket.getOutputStream());
    	
    	new Thread(() ->
        {
            while (true)
            {
                try
                {
                    String message = fromclient.readUTF();
                    System.out.print("message recieved: " + message);
                    Platform.runLater(() -> taServer.setText(taServer.getText()+ "\nC: " + message));
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }).start();
    	
        taClient.setOnKeyPressed( event -> {
        	if( event.getCode() == KeyCode.ENTER ) {
        		System.out.print("Enter pressed.");
        		 try
                 {
        			 String sent = taClient.getText().trim();
        			 System.out.println("Enter pressed.");
                     toclient.writeUTF(sent);
                     Platform.runLater(() -> taServer.setText(taServer.getText()+ "\nS: " + sent));
                     toclient.flush();
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
  
  public static void close(){
	  try {
		 Platform.runLater(() -> {
			try {
				server.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.exit(0);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
  }
}
