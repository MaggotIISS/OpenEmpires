/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.contextlink;

import fx.hexbutton.HexButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**

 @author Mark Ferguson
 */
public class ShowContextLink extends Application {

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    Hyperlink lab;
//    lab = new ContextLink();
//    lab = new ContextLink("Test");
    lab = new ContextLink("Traveller", HexButton.getStrings(
      HexButton.names[HexButton.selnum]));
    StackPane root = new StackPane();
    root.getChildren().add(lab);
    root.setBackground(Background.EMPTY);

    Scene scene = new Scene(root, 300, 250);
    scene.setFill(Color.CYAN);

    primaryStage.setTitle("ContextLink");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
