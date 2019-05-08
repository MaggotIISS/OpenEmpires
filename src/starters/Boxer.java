/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package starters;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import panels.Frame4;
import panels.Panel4Boxer;

/**
 <p>
 @author Mark Ferguson
 */
public class Boxer {

  /**
   <p>
   @param args main startup
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      //
      JPanel jp = new Panel4Boxer();
      JFrame jf = new Frame4(jp);
    });
  }
}
