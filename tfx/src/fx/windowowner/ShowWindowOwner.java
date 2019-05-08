/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.windowowner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**

 @author Mark Ferguson
 */
public class ShowWindowOwner extends Application {

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    StackPane pane = new StackPane();
    WindowOwner ownWindows = new WindowOwner(primaryStage);
    pane.getChildren().add(ownWindows);
    Scene scene = new Scene(pane);
//    String stylesheet = "file:///C://T5/TFX/src/fx/TravellerStylesheet.css";
//    setUserAgentStylesheet(stylesheet);
    primaryStage.setTitle("primaryStage");
    primaryStage.setScene(scene);
    primaryStage.setX(0);
    primaryStage.setY(0);
    primaryStage.show();
  }

}
