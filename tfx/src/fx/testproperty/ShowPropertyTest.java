/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.testproperty;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**

 @author Mark Ferguson
 */
public class ShowPropertyTest extends Application {

  static TextArea ta;

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    ta = new TextArea();
    ta.setText("");
    PropertyTest pt = new PropertyTest(ta);
    StackPane root = new StackPane();
    root.getChildren().add(ta);
    Scene scene = new Scene(root, 300, 250);
    primaryStage.setTitle("PropertyTest");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
