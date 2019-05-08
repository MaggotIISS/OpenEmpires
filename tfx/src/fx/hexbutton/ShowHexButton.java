package fx.hexbutton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ShowHexButton extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) {
    HexButton hexbutton = new HexButton();
//    HexButton hexbutton = new HexButton("Zhodani");
//    setUserAgentStylesheet(stylesheet);
    Pane pane = new StackPane();
    pane.getChildren().add(hexbutton);
    Scene scene = new Scene(pane, 250, 200);
//    String stylesheet = getClass().getResource("HexButtonStylesheet.css")
//      .toExternalForm();
//    scene.getStylesheets().add(stylesheet);
    stage.setScene(scene);
    stage.setTitle("HexButton");
    stage.show();
  }

}
