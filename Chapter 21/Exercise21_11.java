package application;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
  private Map<String, Integer>[] mapForBoy = new HashMap[10];
  private Map<String, Integer>[] mapForGirl = new HashMap[10];
  
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  private Label intructions = new Label("Please Capitalize the first letter of the names. " + "\nIf new information is not pulled up the name \nwas not in the ranking that year");
  private static Map<Integer, Map<String, Integer>> FNAMES = new HashMap<>();
  private static Map<Integer, Map<String, Integer>> MNAMES = new HashMap<>();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage)throws MalformedURLException {
	setNames();
	GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);
    borderPane.setTop(intructions);
    BorderPane.setAlignment(intructions, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 400, 200);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);
    }
    cboYear.setValue(2001);
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");
    
    btFindRanking.setOnAction(e ->
    {
        String name, gender;
        int rank, year;
        try
        {
            name = tfName.getText().trim();
            gender =  cboGender.getValue().trim();
            if( gender == "Female") {
            	rank = FNAMES.get( cboYear.getValue()).get(name);
            }else {
            	rank = MNAMES.get( cboYear.getValue()).get(name);
            }
            year =  cboYear.getValue();
        }
        catch (Exception ex)
        {
            return;
        }
        lblResult.setText(gender + " name " + name + " is ranked #" +  rank + " in year "+ year );
    });
}
  public static ArrayList<String> getAllContent(URL url)
  {
      ArrayList<String> elements = new ArrayList<>();
      try (Scanner scanner = new Scanner(url.openStream()))
      {
          while (scanner.hasNext())
          {
              String x = scanner.nextLine();
              elements.add(x);
          }
      }
      catch (IOException exception)
      {
          exception.printStackTrace();
      }
      return elements;
  }

  public static ArrayList<String> getAllWords(String line)
  {
      ArrayList<String> words = new ArrayList<>();

      try ( Scanner scanner = new Scanner(line))
      {
          while (scanner.hasNext())
              words.add(scanner.next());
          return words;
      }
  }

  public static void setNames()throws MalformedURLException{
      for (int i = 2001; i <= 2010; i++)
      {
          URL url = new URL("https://liveexample.pearsoncmg.com/data/babynamesranking" + i + ".txt");
          ArrayList<String> lines = getAllContent(url);
          Map<String, Integer> fyear = new HashMap<>();
          Map<String, Integer> myear = new HashMap<>();
          for (String line: lines)
          {
              ArrayList<String> words = getAllWords(line);
              int rank = Integer.parseInt(words.get(0));
              myear.put(words.get(1), rank);
              fyear.put(words.get(3), rank);
          }
          FNAMES.put(i, fyear);
          
          MNAMES.put(i, myear);
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

