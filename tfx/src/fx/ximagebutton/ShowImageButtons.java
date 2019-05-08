/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.ximagebutton;

import com.sun.glass.ui.Screen;
import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables.T5;
import java.io.File;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**

 @author Mark Ferguson
 */
public class ShowImageButtons extends Application {

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  Button button;
  File file;
  String[] files;
  ImageView imageView;
  FlowPane pane;
  String start = T5 + FS + "_GIF";
  Tooltip tip;

  @Override
  @SuppressWarnings("unchecked")
  public void start(Stage primaryStage) {
    int wid = Screen.getMainScreen().getWidth();
    int hgt = Screen.getMainScreen().getHeight();
    file = new File(start);
    files = file.list();
    pane = new FlowPane();
    pane.setPrefSize(wid - 25, hgt);
    imageView = new ImageView();
    for (int i = 0; i < files.length; i++) {
      if (files[i].toLowerCase().endsWith(".gif")) {
        file = new File(start + FS + files[i]);
        imageView = new ImageView("file:" + start + FS + files[i]);
        button = new Button("", imageView);
        button.setId(files[i]);
        button.setOnAction(new EventHandler() {
          @Override
          public void handle(Event event) {
            System.out.println(event);
          }
        });
        tip = new Tooltip(files[i]);
        button.setTooltip(tip);
        pane.getChildren().add(button);
      }
    }
//    String stylesheet = getClass().getResource("ImageButtonsStylesheet.css")
//      .toExternalForm();
//    setUserAgentStylesheet("file:///C://T5/TFX/src/fx/TravellerStylesheet.css");
    ScrollPane sp = new ScrollPane();
    sp.setContent(pane);
    Scene scene = new Scene(sp, wid, hgt / 2);
    primaryStage.setTitle("Button It!");
    primaryStage.setScene(scene);
    primaryStage.show();

  }

}
