/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.xweb;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**

 @author maggot
 */
public class RenameFX extends JApplet {

  /**
   Web page
   */
  private static final int JFXPANEL_WIDTH_INT = 800;
  private static final int JFXPANEL_HEIGHT_INT = 600;
  private static JFXPanel fxContainer;

  /**

   */
  public static String arg;
  /**

   */
  public final static String DEFAULT_URL
    = "file:///C:/T5/Spinward%20Marches/C%20Regina/1910%20Regina/1910%20Regina.html";

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
//    String DEFAULT_URL = args[0];
    if (args.length > 0) {
      arg = args[0];
    } else {
      arg = DEFAULT_URL;
    }
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
//        try {
//          UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//        } catch (Exception e) {
//        }

//  private static final String DEFAULT_URL;
        JFrame frame = new JFrame("JavaFX 2 in Swing");
//        System.out.println("args.toString()" + " = ");
        if (args.length > 0) {
          for (int i = 0; i < args.length; i++) {
            System.out.println("\targs[" + i + "]" + " = " + args[i]);
          }
          frame.setTitle(arg.substring(arg.lastIndexOf("/") + 1, arg.length()
            - 5));
        }
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JApplet applet = new RenameFX();
        applet.init();

        frame.setContentPane(applet.getContentPane());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        applet.start();
      }
    });
  }

  /**
   init
   */
  @Override
  public void init() {
    fxContainer = new JFXPanel();
    fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT,
      JFXPANEL_HEIGHT_INT));
    add(fxContainer, BorderLayout.CENTER);
    // create JavaFX scene
    Platform.runLater(new Runnable() {

      @Override
      public void run() {
        createScene();
      }
    });
  }

  private void createScene() {
    Group root = new Group();
    fxContainer.setScene(new Scene(root));
    WebView webView = new WebView();

    final WebEngine webEngine = webView.getEngine();
    webEngine.load(arg);

    final TextField locationField = new TextField(arg);
    webEngine.locationProperty().addListener(new ChangeListener<String>() {
      @Override public void changed(ObservableValue<? extends String> observable,
        String oldValue, String newValue) {
        locationField.setText(newValue);
      }
    });
    EventHandler<ActionEvent> goAction = new EventHandler<ActionEvent>() {
      @Override public void handle(ActionEvent event) {
        webEngine.load(locationField.getText().startsWith("file:///")
          ? locationField.getText()
          : "file:///" + locationField.getText());
      }
    };
    locationField.setOnAction(goAction);

    Button goButton = new Button("Go");
    goButton.setDefaultButton(true);
    goButton.setOnAction(goAction);

    // Layout logic
    HBox hBox = new HBox(5);
    hBox.getChildren().setAll(locationField, goButton);
    HBox.setHgrow(locationField, Priority.ALWAYS);

    VBox vBox = new VBox(5);
    vBox.getChildren().setAll(hBox, webView);
    VBox.setVgrow(webView, Priority.ALWAYS);

    root.getChildren().add(vBox);
  }

}
