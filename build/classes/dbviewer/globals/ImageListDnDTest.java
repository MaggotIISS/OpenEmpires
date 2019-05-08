package dbviewer.globals;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 This program demonstrates drag and drop in an image list.
 @version 1.01 2012-01-26
 @author Cay Horstmann
 */
public class ImageListDnDTest {

  /**

   @param args strings to start
   */
  public static void main(String[] args) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new ImageListDnDFrame();
        frame.setTitle("ImageListDnDTest");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
      }
    });
  }
}
