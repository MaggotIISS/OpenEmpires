/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.xml;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**

 @author Mark Ferguson
 */
public class XML1 {

  static JFrame jf = new JFrame();
  static JPanel jp = new panel4XML1();

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    jf.setContentPane(jp);
    jf.setBounds(0, 0, 500, 500);
    jf.setVisible(true);
  }

}
