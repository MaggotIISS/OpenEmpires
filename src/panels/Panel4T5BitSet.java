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
package panels;

import dbviewer.globals.GlobalMethods;
import dbviewer.globals.GlobalVariables;
import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables._SEC;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import java.io.File;
import java.io.IOException;
import java.util.BitSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;

/**
 @author Your Name Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4T5BitSet extends Panel4 {

  //<editor-fold defaultstate="collapsed" desc="variables">
  /**
   jf
   */
  public static Frame4 jf;
  /**
   jp
   */
  public static Panel4 jp;
  /**
   wlines
   */
  public Object[] wlines;
  /**
   slines
   */
  public Object[] slines;
  /**
   bs
   */
  public BitSet bs;
  /**
   g
   */
  public Graphics g;
  DefaultListModel dlm;
  private int mag = 13;
  boolean covered = false;
  Object[] worlds;
  String[] parts;
  BufferedImage bi;
  ListSelectionEvent lse;
  MouseEvent me;
  private int start;
  JTextArea jTextArea1 = new JTextArea();
  int[] xy = null;
  int xo;
  int yo;
  int h;
  int w;
  int l;
  int l3;
  int l4;
  int l5;
  int t;
  //</editor-fold>

  /**

   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4T5BitSet();
    jf = new Frame4(jp, "Panel4T5BitSet");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   Creates new form Panel4BitMaps
   */
  public Panel4T5BitSet() {
    super();
    g = getGraphics();
//    g = jLabel1.getGraphics();
    bs = new BitSet(1280);
    initComponents();
    bi = new BufferedImage((int) (32.6 * mag), (int) 40.6 * mag, TYPE_INT_RGB);
    loadSectors();
  }

  @SuppressWarnings("unchecked")
  private void loadSectors() {
    File fs = new File(_SEC);
    String[] sectors = fs.list();
    DefaultListModel dlm = new DefaultListModel();
    String sec = "";
    for (int j = 0; j < sectors.length; j++) {
      if (sectors[j].endsWith(".sec")) {
        sec = sectors[j].substring(0, sectors[j].length() - 4);
        dlm.addElement(sec);
      }
    }
    jList1.setModel(dlm);
    jList1.setSelectedValue("Spinward Marches", true);
  }

  /**

   @param hex location
   @return bit number set to true from xy location
   */
  public int getBit(String hex) {
    int i = 0;
    String[] partso = new String[2];
    partso[0] = hex.substring(0, 2);
    partso[1] = hex.substring(2);
    int x;
    int y;
    x = ((Integer.parseInt(partso[0]) - 1) * 40);
    y = ((Integer.parseInt(partso[1]) - 1) % 40);
    return x + y;
  }

  /**

   @param bit part of BitSet
   @return xy location from bit number
   */
  public String getHex(int bit) {
    String x = "" + (1 + (bit / 40));
    String y = "" + (1 + (bit % 40));
    if (x.length() == 1) {
      x = "0" + x;
    }
    if (y.length() == 1) {
      y = "0" + y;
    }
    return x + y;
  }

  /**

   @param hex to convert
   @return get x and y coords from string
   */
  public int[] getXY(String hex) {
    int[] xy = new int[2];
    String X = hex.substring(0, 2);
    String Y = hex.substring(2);
    xy[0] = Integer.parseInt(X);
    xy[1] = Integer.parseInt(Y);
    return xy;
  }

  /**

   @param bit to convert to Hex
   @return hex location from selected bit
   */
  public String getHexNum(int bit) {
    String res = getHex(bit);
    return res;
  }

  /**

   @param g Graphics
   */
  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    int mod = 0;
    g2.setColor(Color.black);
    super.paintComponent(g2);
    g2.fillRect(0, 0, 35 * mag, (int) 45 * mag);
    g2.setColor(Color.white);
    for (int i = 0; i < 1280; i++) {
      if (bs.get(i) == true) {
        xy = getXY(getHex(i));
        if (xy[0] % 2 == 0) {
          mod = (mag / 2);
        } else {
          mod = 0;
        }
        xo = mag * (xy[0]);
        yo = (mag * (xy[1])) + mod;
        l = 0;
        t = 0;
        h = mag;
        w = h * 11 / 8;
        l3 = w * 3 / 11;
        l4 = w * 4 / 11;
        l5 = w * 5 / 11;
        Point a, b, c, d, e, f;
        a = new Point(l + l3, t);
        b = new Point(l + l3 + l5, t);
        c = new Point(l + l5 + (l3 * 2), t + l4);
        d = new Point(l + l3 + l5, t + (l4 * 2));
        e = new Point(l + l3, (l4 * 2));
        f = new Point(l, t + l4);
        Point[] points = new Point[]{a, b, c, d, e, f};
        Polygon p = new Polygon();
        g.setColor(Color.white);
        for (int j = 0; j < points.length; j++) {
          int x = (int) (points[j].getX() + xo);
          int y = (int) (points[j].getY() + yo);
          p.addPoint((int) x, (int) y);
        }
        g2.fillPolygon(p);
        g2.setColor(Color.black);
        //Increase line thickness?
        g2.drawPolygon(p);
      }
    }
  }

  private void countWorlds() {
    File f = new File(_SEC + FS + jList1.getSelectedValue().toString() + ".sec");
    wlines = GlobalMethods.getLinesFromFile(f);
    start = 0;
    int worlds = 0;
    for (int i = 0; i < wlines.length; i++) {
      if (wlines[i].toString().startsWith("---- ")) {
        start = i + 1;
        worlds = wlines.length - start;
        break;
      }
    }
    if (worlds > 0) {
      for (int j = start; j < wlines.length; j++) {
        int b = getBit(wlines[j].toString().substring(0, 4));
        bs.set(b);
      }
    }
  }

  /**
   autoSave
   */
  public void autoSave() {
    for (int j = 0; j < 10; j++) {// {jList1.getModel().getSize(); j++) {
      jList1.setSelectedValue(jList1.getModel().getElementAt(j), true);
      jList1MouseClicked(me);
//      repaint();
//      savePic();
      jTextField1.setText(jList1.getSelectedValue().toString());
//      repaint();
      savePic();
    }
  }

  private void savePic() {
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
    String path = _SEC + FS + "GIF" + FS + jList1.getSelectedValue().toString()
      + ".gif";
    System.out.println(path);
    Robot r = null;
    try {
      r = new Robot();
    } catch (AWTException ex) {
      Logger.getLogger(Panel4T5BitSet.class.getName()).log(Level.SEVERE, null,
        ex);
    }
    bi = r.createScreenCapture(new Rectangle(
      jp.getLocationOnScreen().x + 24,
      jp.getLocationOnScreen().y + 24,
      //      jp.getWidth() - jList1.getWidth(),
      (int) (32.5 * mag) - 2,
      //  jp.getHeight()));
      (int) (41 * mag) - 10));
    File f = new File(path);
    try {
      ImageIO.write(bi, "GIF", f);
    } catch (IOException ex) {
      Logger.getLogger(Panel4T5BitSet.class.getName()).log(Level.SEVERE, null,
        ex);
      JOptionPane.showMessageDialog(jf, "Grab error");
    }
  }

  private void printSector(BitSet bs1) {
    jTextArea1.setText("");
    for (int y = 0; y < 40; y++) {
      for (int x = 0; x < 32; x++) {
        int num = (x * 32) + y;
        if (bs.get(num) == false) {
          jTextArea1.append("0 ");
        } else {
          jTextArea1.append("1 ");

        }
      }
      jTextArea1.append(GlobalVariables.CRLF);
    }
    try {
      GlobalMethods.saveTextFile(_SEC + FS + "BS", jList1.getSelectedValue()
        .toString(), ".txt", jTextArea1.getText());
    } catch (Exception e) {
      JOptionPane.showMessageDialog(jf, "" + 333);
    }
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane4 = new javax.swing.JScrollPane();
    jTextField1 = new javax.swing.JTextField();
    jScrollPane2 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList();

    setBackground(new java.awt.Color(255, 255, 255));
    addMouseWheelListener(new java.awt.event.MouseWheelListener() {
      public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
        formMouseWheelMoved(evt);
      }
    });
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        formMouseClicked(evt);
      }
    });

    jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    jTextField1.setText("Spinward Marches");
    jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextField1MouseClicked(evt);
      }
    });

    jScrollPane2.setHorizontalScrollBar(null);

    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList1MouseClicked(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jList1MousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        jList1MouseReleased(evt);
      }
    });
    jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        jList1ValueChanged(evt);
      }
    });
    jScrollPane2.setViewportView(jList1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
      .addGroup(layout.createSequentialGroup()
        .addGap(0, 252, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    bs = new BitSet(1280);
    countWorlds();
    jTextField1.setText(jList1.getSelectedValue().toString());
    if (evt.getValueIsAdjusting() == false) {
//      printSector(bs);
      repaint();
    }
  }//GEN-LAST:event_jList1ValueChanged

  private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    if (mag + evt.getWheelRotation() >= 4) {
      mag += (evt.getWheelRotation());
      jf.setTitle("" + mag);
    } else {
      mag = 4;
    }
    repaint();
  }//GEN-LAST:event_formMouseWheelMoved

  private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
  }//GEN-LAST:event_jList1MouseClicked

  private void jList1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MousePressed
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    repaint();
  }//GEN-LAST:event_jList1MousePressed

  private void jList1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseReleased
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    savePic();
  }//GEN-LAST:event_jList1MouseReleased

  private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
    int delay = 15; //milliseconds
    mag = 24;
    ActionListener taskPerformer = new ActionListener() {
      int j = 0;

      @Override
      public void actionPerformed(ActionEvent evt) {
        if (j < jList1.getModel().getSize()) {
          savePic();
          j += 1;
          jList1.setSelectedIndex(j);
          jList1.setSelectedValue(jList1.getSelectedValue(), true);
        }
      }
    };
    new Timer(delay, taskPerformer).start();
  }//GEN-LAST:event_jTextField1MouseClicked

  private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    savePic();
  }//GEN-LAST:event_formMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public static javax.swing.JList jList1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JTextField jTextField1;
  // End of variables declaration//GEN-END:variables
}
