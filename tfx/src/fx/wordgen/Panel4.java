/*

 Copyright (C) 2014 Mark Ferguson



 This program is free software: you can redistribute it and/or modify

 it under the terms of the GNU General Public License as published by

 the Free Software Foundation, either version 3 of the License, or

 (at your option) any later version.



 This program is distributed in the hope that it will be useful,

 but WITHOUT ANY WARRANTY; without even the implied warranty of

 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the

 GNU General Public License for more details.



 You should have received a copy of the GNU General Public License

 along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */
package fx.wordgen;

//import GlobalMethods;
//import static GlobalVariables.CRLF;
//import dbviewer.globals.ObjectAnalyzer;
import static fx.wordgen.Panel4WordGen.CRLF;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**

 @author maggot.iiss
 */
@SuppressWarnings("serial")
public class Panel4 extends javax.swing.JPanel {

  //<editor-fold defaultstate="collapsed" desc="Variables">
  private static String Name = "PanelName";
  private static String[] svarnames = new String[]{
    "Name"
  };
  private static String[] svars = new String[]{
    Name
  };
  static int i;
  private static int[] ivars = new int[]{i};
  private static String[] ivarnames = new String[]{"i"};
  static JFrame jf;
  static JPanel jp;
  private boolean showing = true;
  //</editor-fold>

  /**

   @param args text entry from keyboard
   */
//  public static void main(String[] args) {
//    jp = new Panel4(Name);
//    jf = new Frame4(jp);
//    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//  }
  /**
   Creates new form Panel4
   */
  public Panel4() {
    super();
    getRobot();
    initComponents();
    setLayout(new BorderLayout());
//    GlobalMethods.autoColor(this, Color.black, Color.lightGray);
//    this.setName(this.getClass().getName());
    this.setToolTipText(this.getClass().getName());
  }

  /**

   @param name strings to start
   */
  public Panel4(String name) {
    this();
    setName(name);
  }

  /**

   @return name of class
   */
//  @Override
//  public String toString() {
////    return "" + getClass().getName();
//    return new ObjectAnalyzer().toString(this);
//  }
  /**

   @return Robot
   */
  public static Robot getRobot() {
    GraphicsEnvironment environment = GraphicsEnvironment
      .getLocalGraphicsEnvironment();
    final GraphicsDevice screen = environment.getDefaultScreenDevice();
    Robot robot = null;
    try {
      robot = new Robot(screen);
    } catch (AWTException ex) {
      Logger.getLogger(Panel4.class.getName()).log(Level.SEVERE, null, ex);
    }
//    String path = T5 + FS + jf.getName() + ".gif";
//    BufferedImage bi = robot.createScreenCapture(new Rectangle(jf.getX(), jf.getY(), jf.getWidth(), jf.getHeight()));
////    Image scaledInstance = bi.getScaledInstance(800, 600, SCALE_REPLICATE);
//    File f = new File(path);
//    try {
//      ImageIO.write((RenderedImage) bi, "GIF", f);
//    } catch (IOException ex) {
//      Logger.getLogger(T5app.class
//        .getName()).log(Level.SEVERE, null, ex);
//    }
    return robot;
  }

  /**
   showThis
   */
  public void showThis() {
    String[] txt = this.toString().split(",");
    JTextArea jta = new JTextArea();
    jta.setText(this.getClass().getName() + CRLF);
    jta.append(txt.toString());
    GlobalMethods.saveTextFile(".", this.getClass().getName() + " Errors",
      ".txt", jta.getText());
  }

////<editor-fold defaultstate="collapsed" desc="comment">
  /**
   * // * Grab Window and save as GIF in T5 folder //
   */
//  public static void Save() {
//    Robot r = getRobot();
//    String path = T5 + FS + jf.getContentPane().getClass().getName() + ".gif";
//    BufferedImage bi = r.createScreenCapture(new Rectangle(jf.getX(), jf.getY(), jf.getWidth(), jf.getHeight()));
////    Image scaledInstance = bi.getScaledInstance(800, 600, SCALE_REPLICATE);
//    File f = new File(path);
//    try {
//      ImageIO.write((RenderedImage) bi, "GIF", f);
//    } catch (IOException ex) {
//      Logger.getLogger(T5app.class
//        .getName()).log(Level.SEVERE, null, ex);
//    }
//  }
//
//</editor-fold>
  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setOpaque(false);
    setLayout(new java.awt.BorderLayout());
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
