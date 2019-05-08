package fx.xmaps;

/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**

 @author Mark Ferguson
 */
public class ShowMaps extends Application {

  String[] strings = new String[]{
    "One", "Two", "Three"
  };

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        System.out.println(s);
      }
    }
    //</editor-fold>
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        System.out.println(s);
      }
    }
    //</editor-fold>
    Button btn = new Button();
    btn.setText("ShowMaps");
    //<editor-fold defaultstate="collapsed" desc="btn.setOnAction((ActionEvent event)">
    btn.setOnAction((ActionEvent event) -> {
      System.out.println("ShowMaps");
      TextArea textArea = new TextArea();
//      textArea.setText(new StringMaps().getMap().toString() + CRLF);
//      textArea.appendText(new StringMaps().getMap("Sector").toString() + CRLF);
//      textArea.appendText(new StringMaps().getMap("Counter").toString() + CRLF);
//      textArea.appendText(new StringMaps().getMap("NPC").toString() + CRLF);
      textArea.appendText(new StringMaps().getMap(strings).toString() + CRLF);
      VBox root = new VBox();
      root.getChildren().add(textArea);
      Scene scene = new Scene(root);
      Stage stage = new Stage();
      stage.setScene(scene);
      stage.initOwner(primaryStage);
      stage.setWidth(200);
      stage.setHeight(200);
      stage.show();
    });
    //</editor-fold>
    StackPane root = new StackPane();
    root.getChildren().add(btn);
    Scene scene = new Scene(root, 200, 200);
    primaryStage.setTitle("ShowMaps");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static String CRLF = "\n";
}
