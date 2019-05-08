/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.windowowner;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**

 @author Mark Ferguson
 */
public class WindowOwner extends Button {

  WindowOwner(Stage stage) {
    Button button = new Button();
    @SuppressWarnings("unchecked")
    EventHandler<ActionEvent> action = new EventHandler() {
      @Override
      public void handle(Event event) {
        Stage stage2 = new Stage();
        stage2.initOwner(stage);
        Pane pane = new StackPane();
        Scene scene = new Scene(pane);
        stage2.setScene(scene);
        stage2.show();
      }
    };
    setOnAction(action);
  }

}
