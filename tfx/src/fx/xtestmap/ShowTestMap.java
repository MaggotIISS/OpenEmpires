/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.xtestmap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**

 @author Mark Ferguson
 */
public class ShowTestMap extends Application {

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  public static TextArea ta;
  static String CRLF = "\n";

  public TestMap testMap;

  @Override
  public void start(Stage primaryStage) {
    testMap = new TestMap();
    ta = new TextArea();
    ta.setText("" + TestMap.getOutput());

    StackPane root = new StackPane();
    root.getChildren().add(ta);

    Scene scene = new Scene(root, 300, 250);
//    setUserAgentStylesheet("file:///C://T5/TFX/src/fx/TravellerStylesheet.css");
    primaryStage.setTitle(testMap.getMap().get("system").substring(0, 4) + "-"
      + testMap.getMap().get("career") + "-" + testMap.getMap().get("name"));
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
