/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package wordgen;

//import java.awt.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**

 @author Mark Ferguson
 */
public class WordGen extends Application {

  @Override
  public void start(Stage primaryStage) {
    Button btn = new Button();
    btn.setText("WordGen");
    btn.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        JPanel jp = new JPanel();
        JFrame jf = new Frame4(jp);
        jp = new Panel4WordGen();

        jf.setContentPane(jp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
      }
    });
    Label label = new Label("About");
    EventHandler<? super MouseEvent> value = new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        showAbout();
      }

      private void showAbout() {
        JFrame jf = new JFrame();
        String txt = "ABOUT\n"
          + "\n"
          + "Programmed by Mark Ferguson	(maggot.iiss@sky.com)\n"
          + "\n"
          + "https://github.com/MaggotIISS\n"
          + "\n"
          + "The Traveller game in all forms is owned by Far Future Enterprises. \n"
          + "Copyright 1977 - 20016 Far Future Enterprises. \n"
          + "\n"
          + "Traveller is a registered trademark of Far Future Enterprises. \n"
          + "Far Future permits web sites and fanzines for this game, provided \n"
          + "it contains this notice, that Far Future is notified, and subject \n"
          + "to a withdrawal of permission on 90 days notice. \n"
          + "\n"
          + "The contents of this site are for personal, non-commercial use only. \n"
          + "\n"
          + "Any use of Far Future Enterprises's copyrighted material or \n"
          + "trademarks anywhere on this web site and its files should not \n"
          + "be viewed as a challenge to those copyrights or trademarks. \n"
          + "In addition, any program/articles/file on this site cannot be \n"
          + "republished or distributed without the consent of \n"
          + "the author who contributed it.\n";
        JTextArea jta = new JTextArea(txt, 50, 50);
        jta.setEditable(false);
        JScrollPane jsp = new JScrollPane(jta);
        jf.getContentPane().add(jsp);
        jf.setSize(500, 500);
        jf.setLocation(300, 300);
        jf.setVisible(true);
      }
    };
    label.setOnMouseClicked(value);
    FlowPane root = new FlowPane();

    VBox box = new VBox();
    box.getChildren().add(btn);
    box.getChildren().add(label);

    root.getChildren().add(box);

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle(
      "Alien Word Generation");
    primaryStage.setScene(scene);
    btn.fire();
//    primaryStage.show();

  }

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
