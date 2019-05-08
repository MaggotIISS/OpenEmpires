/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package starters;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 <p>
 @author Mark Ferguson
 */
public class TFX extends JApplet {

  /**
   Web page
   */
  private static final int WIDTH = 200;
  private static final int HEIGHT = 200;
  private static JFXPanel jfxPanel;
  private static JFrame frame;

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      frame = new JFrame("JavaFX 2 in Swing");
      frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

      JApplet applet = new TFX();
      applet.init();

      frame.setContentPane(applet.getContentPane());

      frame.pack();
      frame.setLocationRelativeTo(null);
      //frame.setVisible(true);

      applet.start();
    });
  }

  /**
   init
   */
  @Override
  public void init() {
    jfxPanel = new JFXPanel();
    jfxPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    add(jfxPanel, BorderLayout.CENTER);
    // create JavaFX scene
    Platform.runLater(new Runnable() {

      @Override
      public void run() {
        createScene();
      }
    });
  }

  private void createScene() {
    T5app t5app = new T5app();
  }

}
