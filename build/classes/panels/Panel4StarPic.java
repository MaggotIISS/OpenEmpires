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

import dbviewer.StarGen;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 <p>
 @author Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4StarPic extends javax.swing.JPanel {

  //<editor-fold defaultstate="collapsed" desc="Variables">
  private static int starwid;
  private static Graphics graphics;
  private static JPanel jp;
  private static JFrame jf;

  /**
   String[]
   */
  public static String[] starcol = new String[60];

  /**
   red
   */
  public static int r = 255;

  /**
   green
   */
  public static int g = 0;

  /**
   blue
   */
  public static int b = 0;

  /**
   int[][]
   */
  public static int[][] ints;

  /**
   int step
   */
  public static int step = 4;

  /**
   String
   */
  public static String c;

  /**
   String[] of stars by colour
   */
  public static String[] stars = new String[]{
    "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9",
    "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9",
    "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9",
    "G0", "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9",
    "K0", "K1", "K2", "K3", "K4", "K5", "K6", "K7", "K8", "K9",
    "M0", "M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9"
  };
  /**
   boolean hasparent
   */
  public static boolean hasparent = false;
  /**
   distance in AU
   */
  public static double[] rau = new double[]{
    0.2, 0.4, 0.7, 1.0, 1.6, 2.8, 5.2, 10, 19.6, 38.8, 77.2, 154.0, 307.7, 614.8,
    1229.2,
    2458.0, 4916.0, 9832.0, 19664, 39328, 78656
  };
  private static String size;
  private static double radau;
  private static double ppau;
  private static int w;
  private static int h;
  /**
   maximum orbit
   */
  public static int MO;
  private static int orbits;
  private static int sysrad;
  private static int syspxl;
  private static int[] intss;
  private static int cx;
  private static int cy;
  /**
   habitable
   */
  public static String habitable;
  private static int zoom;
  //</editor-fold>
  private static int num;
  private static int rotation;

  /**
   Creates new form Panel4Pic
   */
  public Panel4StarPic() {
    super();
    initComponents();
    addMouseWheelListener(new MouseWheelListener() {
      @Override
      public void mouseWheelMoved(MouseWheelEvent e) {
        rotation = (int) e.getPreciseWheelRotation();
        if (MO > 0) {
//          zoom+=rotation;
        } else {
//          zoom -= zoom;
        }
//        System.out.print(globals.GlobalMethods.comment("-", 20));
//        System.out.println("MO" + " = " + MO);
//        System.out.println("zoom+=rotation" + " = " + (zoom+rotation));
      }
    });
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        if (MO > 0) {
          zoom += -1;
        } else {
          zoom -= zoom;
        }
        System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
        System.out.println("zoom" + " = " + zoom);
        System.out.println("MO" + " = " + MO);
        resize();
      }
    });
  }

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4StarPic();
    jf = new Frame4(jp);
    jf.setSize(600, 150);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setTitle("M6 D");
//    jf.setTitle("M9 VII");
//    jf.setTitle("F7 V");
    graphics = jp.getGraphics();
    String src;
    Color col = null;
    if (args.length != 0) {
      if ("Panel4StarGen".equals(args[0])) {
        jf.setTitle(Panel4StarGen.f4sg.getTitle());
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      }
    }
    if (hasparent == true) {
      src = Panel4SubSector.jcb4Star1.getSelectedItem().toString();
      jf.setTitle("" + src);
      jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      col = getColor(jf.getTitle().substring(0, 2));
//      JOptionPane.showMessageDialog(jp, col);
      if (col != null) {
        graphics.setColor(col);
      }
//      Panel4StarGen.Pic.setVisible(false);
    } else {
      jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      jf.setTitle(Panel4StarGen.f4sg.getTitle());
      //jf.setTitle("B0 Ia");
      //jf.setTitle("M9 VII");
      //jf.setTitle("F7 V");
    }
    jf.setBackground(Color.BLACK);
    jf.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public void windowClosed(WindowEvent e) {
        jf = null;
      }
    });

  }

  /**
   <p>
   @param g Graphics
   */
  @Override
  public void paint(Graphics g) {
    resize();
    //===================================================================
    //Draw central star
//    Color col = getColor(jf.getTitle().substring(0, 2));
    Color col = Panel4StarGen.Col;
    g.setColor(col);
    g.fillOval(-starwid / 2, (jp.getHeight() / 2) - starwid / 2, starwid,
      starwid);
    //===================================================================
    //Center line in grey
    g.setColor(Color.white);
    g.drawLine(0, (jp.getHeight() / 2), sysrad, (jp.getHeight() / 2));
    //===================================================================
    //Orbits in blue green red (outer,habitable,inner)
    g.setColor(Color.LIGHT_GRAY);
//    g.setColor(Color.green);
//    g.setColor(Color.blue);
    //===================================================================
    //How many orbits?
    int min = 0;
    if (("Ia".equals(size)) | ("Ib".equals(size)) | ("II".equals(size)) | ("III"
      .equals(size))) {
      min = 1;
    }
//    try {
    if (hasparent == true) {
      //MO = Integer.parseInt(Panel4StarGen.primaryorbits)+ zoom - 1;
      MO = Panel4StarGen.getOrbits() + zoom - 1;
    } else {
      MO = 10;
    }
//    if (Panel4StarGen.p4sg != null) {
//      //MO = Integer.parseInt(Panel4StarGen.primaryorbits+StarGen.useless) + zoom - 1;
//      //MO = Integer.parseInt(Panel4StarGen.primaryorbits) + zoom - 1;
//    }
//    }catch(Exception e) {
//
//    }
    double rad;
    int targetrad = jp.getWidth() / 20;
    for (int j = min; j <= MO; j++) {
      g.setColor(Color.gray);
      rad = (rau[j] * ppau) * 0.8;
      String UWP = "UWP";
      int orb = min;
      if (rad >= targetrad) {
        String name = " " + dbviewer.globals.GlobalMethods.let2Grk(
          dbviewer.globals.GlobalMethods.num2Let(j + 1));
        g.drawString("" + (j) + " " + name, (int) rad, (jp.getHeight() / 2));
        g.drawString("" + rau[j] + "AU", (int) rad, (jp.getHeight() / 2) + 10);
        try {
          if (null != dbviewer.StarGen.Orbit) {
            String[] parts = StarGen.orbitdata[j].split(" - ");
            //g.drawString(dbviewer.StarGen.orbitdata[j], (int) rad, (jp.getHeight() / 2) + 20);
            int y;
            for (int i = 0; i < parts.length; i++) {
              y = 20 + (i * 10);
              g.drawString(parts[i], (int) rad, (jp.getHeight() / 2) + y);
            }
            orb += 1;
          } else {
            g.drawString(UWP, (int) rad, (jp.getHeight() / 2) + 20);
          }
        } catch (Exception e) {
          String msg = e.toString();
          System.out.println("" + " = " + msg);
        }
      }
      int num;
      if (habitable != null) {
        num = Integer.parseInt(habitable);
      } else {
        num = 100;
      }
      if (j < num) {
        g.setColor(Color.LIGHT_GRAY);
      } else if (j == num) {
        g.setColor(Color.green);
      } else if ((j > num)) {
        g.setColor(Color.blue);
      }
      if (num == 100) {
        g.setColor(Color.blue);
      }
      g.drawOval((int) -rad, (int) -rad + (jp.getHeight() / 2), (int) rad * 2,
        (int) rad * 2);
    }
  }

  /**
   <p>
   @param string String of HZ
   */
  public static void setHabitable(String string) {
    habitable = string.trim();
//    System.out.println("habitable" + " = " + habitable);
  }

  /**
   resize
   */
  public void resize() {
    starwid = (int) getStarSize();
    radau = rau[MO];
    sysrad = jp.getWidth() * 10 / 9;
    int max = sysrad;
    ppau = sysrad / radau;
//    System.out.println(globals.GlobalMethods.comment("=", 20));
//    System.out.println("max" + " = " + max);
//    System.out.println("radau" + " = " + radau);
//    System.out.println("ppau" + " = " + ppau);
    repaint();
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setForeground(new java.awt.Color(255, 255, 255));
    setToolTipText("Click to zoom");
    setName("Panel4Pic"); // NOI18N
    setOpaque(false);
    setRequestFocusEnabled(false);
    addMouseWheelListener(new java.awt.event.MouseWheelListener() {
      public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
        formMouseWheelMoved(evt);
      }
    });
    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentMoved(java.awt.event.ComponentEvent evt) {
        formComponentMoved(evt);
      }
      public void componentResized(java.awt.event.ComponentEvent evt) {
        formComponentResized(evt);
      }
    });
    addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        formFocusGained(evt);
      }
    });
    addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        formPropertyChange(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 268, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 120, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents

  private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
    resize();
  }//GEN-LAST:event_formComponentResized

  private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
    resize();
  }//GEN-LAST:event_formFocusGained

  private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
    resize();
  }//GEN-LAST:event_formComponentMoved

  private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
    // TODO add your handling code here:
  }//GEN-LAST:event_formPropertyChange

  private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
    System.out.println("" + " = " + evt.getPreciseWheelRotation());
  }//GEN-LAST:event_formMouseWheelMoved

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
  private static void testColor() {
    int j = 0;
    for (j = 59; j >= 0; j--) {
      b = g = (j * step);
      c = "" + r + "," + g + "," + b;
      starcol[59 - j] = "" + stars[59 - j] + "-" + c + "";
    }
//    System.out.println("  getColor(\"B0\")" + " = " + getColor("B0"));
//    System.out.println("  getColor(\"M9\")" + " = " + getColor("M9"));
//    System.exit(0);
  }

  /**
   <p>
   @param star Star details
   @return Color of star
   */
  public static String getStarColor(String star) {
    for (int i = 0; i < 60; i++) {
      if (starcol[i].toUpperCase().contains(star.toUpperCase())) {
        return starcol[i] + "=" + i;
      }
    }
    return "";
  }

  /**
   <p>
   @param star Star details
   @return Color of star
   */
  public static Color getColor(String star) {
    int x = 16;
//    System.out.println("star" + " = " + star);
    for (int i = 0; i < stars.length; i++) {
      if (stars[i].equals(star)) {
        x = 4 * (59 - i);
      }
    }
    return new Color(r, x, x);
  }

  private void testAU() {
    //print details of AU range
    for (int j = 0; j < MO; j++) {
      System.out.println("" + " = " + (2 * rau[j]) * ppau);
    }
  }

  private double getStarSize() {
    String size = jf.getTitle().substring(2).trim();
    double num = 0;
    switch (size) {
      case "Ia":
        num = jp.getWidth() * .5;
        break;
      case "Ib":
        num = jp.getWidth() * .45;
        break;
      case "II":
        num = jp.getWidth() * .4;
        break;
      case "III":
        num = jp.getWidth() * .35;
        break;
      case "IV":
        num = jp.getWidth() * .3;
        break;
      case "V":
        num = jp.getWidth() * .25;
        break;
      case "VI":
        num = jp.getWidth() * .2;
        break;
      case "VII":
      case "D":
        num = jp.getWidth() * .05;
        break;
    }
    return num * 2;
  }
}
