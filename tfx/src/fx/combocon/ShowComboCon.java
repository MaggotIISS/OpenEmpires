/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.combocon;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**

 @author Mark Ferguson
 */
public class ShowComboCon extends Application {

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    //ComboCon comboCon = new ComboCon();
    ComboCon comboCon = new ComboCon(ComboCon.test);
    StackPane root = new StackPane();
    root.getChildren().add(comboCon);
    Scene scene = new Scene(root, 300, 250);
    String title = "ComboCon";
    stage.setTitle(title);
    stage.setScene(scene);
    stage.show();
  }

}
