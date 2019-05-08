/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.xmultimap;

import fx.multiedit.MultiEdit;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static panels.Panel4T5Locator.stylesheet;

/**

 @author Mark Ferguson
 */
public class TestMap extends Application {

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  MultiEdit mm;
  private final String CRLF = "\n";
  private Map<String, String> map;
  Stage primaryStage;

  @Override
  public void start(Stage aStage) {
    this.primaryStage = aStage;
    Button btn = new Button("TestMap");
    btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        String[] args = {"args"};
        for (int i = 0; i < args.length; i++) {
          System.out.println("args.toString()" + " = " + args);
        }
        String[][] strings = MultiEdit.STRINGARRAYS;
        for (int i = 0; i < strings.length; i++) {
          System.out.println("" + " = " + strings[i]);
        }
        mm = new MultiEdit();
        System.out.println("" + " = " + mm.getMap());
        try {
          Stage stage = new Stage();
          stage.initOwner(aStage);
          mm.start(stage);
        } catch (Exception ex) {
          Logger.getLogger(TestMap.class.getName()).log(Level.SEVERE, null, ex);
        }
        Set<String> set = null;
        mm.setKeys(set);
        Collection<String> values = null;
        mm.setValues(values);
      }
    });
    String[] args = {"args"};
    String[][] strings = MultiEdit.STRINGARRAYS;

    mm = new MultiEdit();
    System.out.println("" + " = " + mm.getMap());

    Stage stage = new Stage();
    stage.initOwner(this.primaryStage);
    try {
      mm.start(stage);
    } catch (Exception ex) {
      Logger.getLogger(TestMap.class.getName()).log(Level.SEVERE, null, ex);
    }

    StackPane root = new StackPane();
    root.getChildren().add(btn);
    Scene scene = new Scene(root, 300, 250);
    scene.setUserAgentStylesheet(stylesheet);
    this.primaryStage.setTitle("TestMap");
    this.primaryStage.setScene(scene);
    this.primaryStage.show();
    stage.toFront();
  }
}
