
/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package controls.chapter02;

//import java.awt.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**

 @author Mark Ferguson
 */
public class Ch2_Stages extends Application {

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    String title = "primaryStage";
//    StackPane root = new StackPane();
//    Scene scene = new Scene(root, 300, 300);
//    primaryStage.setTitle(title);
//    primaryStage.setScene(scene);
//    primaryStage.show();

    title = "Decorated";
    Button but = new Button(title);
    StackPane dec = new StackPane();
    dec.getChildren().add(but);
    Stage Decorated = new Stage();
    Scene decorated = new Scene(dec, 300, 300);
    Decorated.setScene(decorated);
    Decorated.initStyle(StageStyle.DECORATED);
    Decorated.setTitle(title);
    Decorated.setX(0);
    Decorated.setY(0);
    Decorated.show();

    title = "Undecorated";
    but = new Button(title);
    StackPane und = new StackPane();
    und.getChildren().add(but);
    Stage Undecorated = new Stage();
    Scene undecorated = new Scene(und, 300, 300);
    Undecorated.setScene(undecorated);
    Undecorated.initStyle(StageStyle.UNDECORATED);
    Undecorated.setTitle(title);
    Undecorated.setX(300);
    Undecorated.setY(0);
    Undecorated.show();

    title = "Transparent";
    but = new Button(title);
    StackPane tran = new StackPane();
    tran.getChildren().add(but);
    Stage Transparent = new Stage();
    Scene transparent = new Scene(tran, 300, 300);
    Transparent.setScene(transparent);
    Transparent.initStyle(StageStyle.TRANSPARENT);
    Transparent.setTitle(title);
    Transparent.setX(600);
    Transparent.setY(0);
    Transparent.show();

    title = "Unified";
    but = new Button(title);
    StackPane uni = new StackPane();
    uni.getChildren().add(but);
    Scene unified = new Scene(uni, 300, 300);
    Stage Unified = new Stage();
    Unified.setScene(unified);
    Unified.initStyle(StageStyle.UNIFIED);
    Unified.setTitle(title);
    Unified.setX(0);
    Unified.setY(400);
    Unified.show();

    title = "Utility";
    but = new Button(title);
    StackPane util = new StackPane();
    util.getChildren().add(but);
    Stage Utility = new Stage();
    Scene utility = new Scene(util, 300, 300);
    Utility.setScene(utility);
    Utility.initStyle(StageStyle.UTILITY);
    Utility.setTitle(title);
    Utility.setX(300);
    Utility.setY(400);
    Utility.show();

  }

}
