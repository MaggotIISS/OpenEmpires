/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.genetics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**

 @author Mark Ferguson
 */
public class Genetics extends Application {

  private static String[] dargs;
  private Parent root;

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    if (args.length == 0) {
//      dargs = new String[]{"XNA"};
//      dargs = new String[]{"DNA"};
      dargs = new String[]{"GENETICS"};
    } else {
      dargs = args;
    }
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    root = FXMLLoader.load(getClass().getResource("Genetics.fxml"));
    Scene scene = new Scene(root);
    stage.setHeight(550);
    stage.setX(0);
    stage.setY(500);

    stage.setTitle("Genetics");
    stage.setScene(scene);
    stage.show();
  }

}
