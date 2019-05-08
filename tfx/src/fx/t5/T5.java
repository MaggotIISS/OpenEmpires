/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.t5;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static panels.Panel4T5Locator.stylesheet;

/**

 @author Mark Ferguson
 */
public class T5 extends Application {

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("T5.fxml"));
    Scene scene = new Scene(root, 600, 600);
    scene.setUserAgentStylesheet(stylesheet);
    primaryStage.setTitle("T5");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
