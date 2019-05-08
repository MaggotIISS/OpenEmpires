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
package dbviewer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 <p>
 @author maggot.iiss
 */
@SuppressWarnings("serial")
public class Hexer extends javax.swing.JPanel {
//---------------------------
  //<editor-fold defaultstate="collapsed" desc="Variables">

  private static float H = 0; //Height
  private static float G = 0; //Gap
  private static float M = 0; //Multiplier
  private static float I = 0; //Line Multiplier;
  private static float S = 0; //Square size
//---------------------------
  private static float Cols = 0;  //X
  private static float Rows = 0;  //Y
//---------------------------
  private static float col = 0;  //X
  private static float row = 0;  //Y
//---------------------------
  private static float T = 0; //Top
  private static float L = 0; //Left
  private static float W = 0; //Width
  private static float L3 = 0;  //Line3
  private static float L4 = 0;  //Line4
  private static float L5 = 0;  //Line5
  private static float CX = 0;  //CenterX
  private static float CY = 0;  //CenterY
//---------------------------
  private static Polygon poly = null;
  private static Polygon sq = null;
//---------------------------
  private static JSpinner jsx = new JSpinner(
    new SpinnerNumberModel(5, 1, 100, 1));
  private static JSpinner jsy = new JSpinner(
    new SpinnerNumberModel(5, 1, 100, 1));
  private static JSpinner jsm = new JSpinner(
    new SpinnerNumberModel(1, 1, 100, 1));
  private static JSpinner jsg = new JSpinner(
    new SpinnerNumberModel(0, 0, 100, 1));
  private static JSpinner jsh = new JSpinner(new SpinnerNumberModel(20, 1, 1000,
    1));
  private static JButton printButton = new JButton("Print");
  private static JSpinner jsl = new JSpinner(
    new SpinnerNumberModel(1, 1, 100, 1));
  private static JCheckBox square = new JCheckBox();
  private static JSpinner jss = new JSpinner(new SpinnerNumberModel(10, 1, 100,
    1));
//---------------------------
  /**
   JFrame
   */
  public static JFrame jf;
//---------------------------
  private static int jump = 13;
  private static int down = jump;
  private static int across = jump;
  private static int width = 0;
  private static int height = 0;
  private static int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
//---------------------------
  private static String string = "string";
  private static boolean NOLINE = false;
  private static boolean LEFT = true;
  private static boolean RIGHT = true;
  private static boolean TOP = true;
  private static boolean BOTTOM = true;
  private static boolean CENTRES = false;
  private static boolean STAR3 = false;
  private static boolean STAR4 = false;
  private static boolean STAR5 = false;
  private static boolean STAR6 = false;
  private static boolean DIAG2 = false;
  private static boolean DIAG3 = false;
  private static boolean FILE = false;
//---------------------------
  private static boolean NOPRESET = false;
  private static boolean JUMP = true;
  private static boolean SUBSECTOR = false;
  private static boolean SECTOR = false;
//---------------------------
  private static boolean NOUWP = false;
  private static boolean HEX = false;
  private static boolean NAME = false;
  private static boolean UWP = false;
  private static boolean PAG = false;
  private static boolean POP = false;
//---------------------------
  private static String[] commands = new String[]{
    "Left", "Right", "Top", "Bottom", "Centres", "Star3", "Star4", "Star5",
    "Star6", "Diag2", "Diag3", "File"
  };
  private static int commandsLen = commands.length;
//---------------------------
  private static String[] presets = new String[]{
    "NONE", "Sector", "SubSector", "Jump"
  };
  private static int presetsLen = presets.length;
//---------------------------
  private static String[] uwp = new String[]{
    "Hex", "Name", "UWP", "PAG", "Pop"
  };
  private static int uwpLen = uwp.length;
//---------------------------
  private static Color[] cols = {
    //Zone
    Color.red, Color.orange, Color.green,
    //Allegiance
    Color.orange, Color.white, Color.cyan, Color.magenta, Color.yellow,
    //Atmosphere
    Color.black, Color.gray, Color.white
//---------------------------
  };
  //</editor-fold>
//---------------------------

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jf = new JFrame();
    jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    jf.setBounds(0, 0, 600, 700);
    ConPanel cp = new ConPanel();
    jf.getContentPane().add(cp, "North");
    HexPanel hp = new HexPanel();
    jf.getContentPane().add(hp, "Center");
    SouthPanel sp = new SouthPanel();
    jf.getContentPane().add(sp, "South");
    jf.setVisible(true);

  }
//---------------------------

  /**
   Creates new form Hexer
   */
  public Hexer() {
    initComponents();
  }
//---------------------------

  /**
   @return name of class
   */
  @Override
  public String toString() {
    return "" + getClass().getName() + "[]";
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
//---------------------------

  private static class HexPrinter implements ActionListener, Printable {

    public HexPrinter() {
      //System.out.print("HexPrinter");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      //System.out.print("actionPerformed(ActionEvent ae) = " + ae);
      PrinterJob job = PrinterJob.getPrinterJob();
      job.setPrintable(this);
      boolean ok = job.printDialog();
      if (ok) {
        try {
          job.print();
        } catch (PrinterException ex) {
          /*
           The job did not successfully complete
           */
          //System.out.print("OOPS!");
        }
      }
    }

    @Override
    public int print(Graphics grphcs, PageFormat pf, int i) throws
      PrinterException {
      System.out.print("print(Graphics grphcs, PageFormat pf, int i) = "
        + grphcs + " " + pf + " " + i);
      if (i > 0) {
        /*
         We have only one page, and 'page' is zero-based
         */

        return NO_SUCH_PAGE;
      }

      /*
       User (0,0) is typically outside the imageable area, so we must
       translate by the X and Y values in the PageFormat to avoid clipping
       */
      Graphics2D g2d = (Graphics2D) grphcs;
      g2d.translate(pf.getImageableX(), pf.getImageableY());

//      /* Now we perform our rendering */
//      g2d.rotate(50);
//      //grphcs.drawString("Hello world!", 100, 100);
//      g2d.drawString("Hexer", 100, 300);
      jf.printAll(grphcs);

      /*
       tell the caller that this page is part of the printed document
       */
      return PAGE_EXISTS;
    }
  }
//---------------------------

  private static class ConPanel extends JPanel {

    public ConPanel() {
      setBackground(Color.gray);

      add(jsh);
      jsh.setValue(40);
      jsh.setToolTipText("jsh=Height");
      jsh.addChangeListener(new ChangeListenerImpl());

      add(jsx);
      jsx.setValue(13);
      jsx.setToolTipText("jsx=Across");
      jsx.addChangeListener(new ChangeListenerImpl());

      add(jsy);
      jsy.setValue(13);
      jsy.setToolTipText("jsy=Down");
      jsy.addChangeListener(new ChangeListenerImpl());

      add(printButton);
      printButton.setToolTipText("printButton=PRINT TO PRINTER");
      printButton.addActionListener(new HexPrinter());

      add(jsm);
      jsm.setValue(1);
      jsm.setToolTipText("jsm=Mult");
      jsm.addChangeListener(new ChangeListenerImpl());

      add(jsg);
      jsg.setValue(0);
      jsg.setToolTipText("jsg=Gap");
      jsg.addChangeListener(new ChangeListenerImpl());

      add(jsl);
      jsl.setValue(1);
      jsl.setToolTipText("jsl=Line");
      jsl.addChangeListener(new ChangeListenerImpl());

      add(square);
      //square.setValue(1);
      square.setToolTipText("square=Square");
      square.addChangeListener(new ChangeListenerImpl());

//      add(jss);
//      square.setToolTipText("jss=Squared");
//      square.addChangeListener(new ChangeListenerImpl());
    }

    public class ChangeListenerImpl implements ChangeListener {

      public ChangeListenerImpl() {
      }

      @Override
      public void stateChanged(ChangeEvent ce) {
        ////System.out.print("stateChanged(ChangeEvent ce) = " + ce);
        setupNumbers();
      }
    }

    private static void setupNumbers() {
      //System.out.print("setupNumbers()");
      M = (int) jsm.getValue();
      H = (int) jsh.getValue();
      G = (int) jsg.getValue();
      T = G;
      L = G;
      W = M * (H * 11 / 8);
      L3 = M * (H * 3 / 8);
      L4 = M * (H * 4 / 8);
      L5 = M * (H * 5 / 8);
      CX = M * (H / 2);
      CY = M * (W / 2);
      Cols = (int) jsx.getValue();
      Rows = (int) jsy.getValue();
      width = (int) (((Cols * ((G * M) + L3 + L5)) + L3) + (G * M));
      height = (int) (((Rows + 0.5) * ((G + H) * M) + (G * M)));
    }
  }
//---------------------------

  private static class HexPanel extends JPanel {

    public HexPanel() {
      setBackground(Color.white);
    }

    private static void addPoly() {
      ////System.out.print("addPoly()");
      poly = new Polygon();
      poly.addPoint((int) (L + L3), (int) T);
      poly.addPoint((int) (L + L3 + L5), (int) T);
      poly.addPoint((int) (L + L5 + (L3 * 2)), (int) (T + L4));
      poly.addPoint((int) (L + L3 + (int) L5), (int) (T + (L4 * 2)));
      poly.addPoint((int) (L + L3), (int) (T + (L4 * 2)));
      poly.addPoint((int) (L), (int) (T + L4));
      poly.addPoint((int) (L + L3), (int) T);

    }

    private void drawPoly(Graphics g) {
      g.setColor(Color.white);
      g.fillPolygon(poly);
      g.setColor(Color.black);
      Graphics2D painted = (Graphics2D) g;
      BasicStroke pen = new BasicStroke((int) jsl.getValue());
      painted.setStroke(pen);
      painted.draw(poly);
      repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      //boolean square = true;
      L = G * M;
      BufferedImage image = null;
      for (col = 1; col <= Cols; col++) {
        if (col % 2 == 1) {
          T = G * M;
        } else {
          T = ((H / 2) + (G * 3 / 2)) * M;
        }
        if ((col % 2 == 1) && (square.isSelected())) {
//          T = 0;
          T = ((H / 2) + (G * 3 / 2)) * M;
        }
        //ACROSS
        for (row = 1; row <= Rows; row++) {
          //DOWN
          if (!square.isSelected()) {
            jss.setEnabled(false);
            addPoly();
            drawPoly(g);

          } else {
            jss.setEnabled(true);
            jss.setValue(jsh.getValue());
            addSquare();
            drawSquare(g);

          }
//---------------------------
          //<editor-fold defaultstate="collapsed" desc="Extras">
          //Start
          //<editor-fold defaultstate="collapsed" desc="LEFT">
          if (LEFT) {
            x1 = 0;
            y1 = 0;
            x2 = 0;
            y2 = height;
            g.setColor(Color.black);
            g.drawLine(x1, y1, x2, y2);
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="RIGHT">
//          if (RIGHT) {
          if (square.isSelected()) {
            width = ((((int) jsh.getValue() + (int) jsg.getValue()) * (int) jsx
              .getValue() * (int) jsm.getValue()));
            int acr = (int) jsx.getValue();
            int gap = (int) jsg.getValue();
            int hgt = (int) jsh.getValue();
            //width = ((acr*hgt)+((acr+1)*gap))*(int)jsm.getValue();
          }
          x1 = width;
          y1 = 0;
          x2 = width;
          y2 = height;
          g.setColor(Color.black);
          g.drawLine(x1, y1, x2, y2);
//          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="TOP">
          if (TOP) {
            x1 = 0;
            y1 = 0;
            x2 = width;
            y2 = 0;
            g.setColor(Color.black);
            g.drawLine(x1, y1, x2, y2);
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="BOTTOM">
          if (BOTTOM) {
            x1 = 0;
            y1 = height;
            x2 = width;
            y2 = height;
            g.setColor(Color.black);
            g.drawLine(x1, y1, x2, y2);
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="CENTRES">
          if (CENTRES) {
            //TAS
            g.setColor(Color.red);
            int w = 12 * (int) M;
            int h = 12 * (int) M;
            g.fillOval((int) (L + (W / 2)) - (w / 2), (int) (T + (M * (H / 2)))
              - (h / 2), w, h);
            //Allegiance
            g.setColor(Color.cyan);
            w = 10 * (int) M;
            h = 10 * (int) M;
            g.fillOval((int) (L + (W / 2)) - (w / 2), (int) (T + (M * (H / 2)))
              - (h / 2), w, h);
            //Atmosphere
            g.setColor(Color.white);
            w = 8 * (int) M;
            h = 8 * (int) M;
            g.fillOval((int) (L + (W / 2)) - (w / 2), (int) (T + (M * (H / 2)))
              - (h / 2), w, h);
            //Mainworld
            g.setColor(Color.black);
            w = 5 * (int) M;
            h = 5 * (int) M;
            g.fillOval((int) (L + (W / 2)) - (w / 2), (int) (T + (M * (H / 2)))
              - (h / 2), w, h);
            //Water
            g.setColor(Color.cyan);
            w = 4 * (int) M;
            h = 4 * (int) M;
            g.fillOval((int) (L + (W / 2)) - (w / 2), (int) (T + (M * (H / 2)))
              - (h / 2), w, h);
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="STAR3">
          if (STAR3) {
            g.setColor(Color.red);
            poly = new Polygon();
            poly.addPoint((int) (L + L3 + (L5 / 2)), (int) T);
            poly.addPoint((int) (L + L3), (int) T + (int) (H * M));
            poly.addPoint((int) (L + L3 + L5), (int) T + (int) (H * M));
//4      poly.addPoint((int) (L + L3 + (int) L5), (int) (T + (L4 * 2)));
//5      poly.addPoint((int) (L + L3), (int) (T + (L4 * 2)));
//6      poly.addPoint((int) (L), (int) (T + L4));
//1      poly.addPoint((int) (L + L3), (int) T);
            g.fillPolygon(poly);
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="STAR4">
          if (STAR4) {
            g.setColor(Color.orange);
            poly = new Polygon();
            poly.addPoint((int) (L + L3), (int) (T + (L4 / 2)));
            poly.addPoint((int) (L + L3 + L5), (int) (T + (L4 / 2)));
            poly.addPoint((int) (L + L3 + L5), (int) (T + L4 + (L4 / 2)));
            poly.addPoint((int) (L + L3), (int) (T + L4 + (L4 / 2)));
            g.fillPolygon(poly);
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="STAR5">
          if (STAR5) {
            g.setColor(Color.blue);
            poly = new Polygon();
//1      poly.addPoint((int) (L + L3), (int) T);
//2      poly.addPoint((int) (L + L3 + L5), (int) T);
//3      poly.addPoint((int) (L + L5 + (L3 * 2)), (int) (T + L4));
//4      poly.addPoint((int) (L + L3 + (int) L5), (int) (T + (L4 * 2)));
//5      poly.addPoint((int) (L + L3), (int) (T + (L4 * 2)));
//6      poly.addPoint((int) (L), (int) (T + L4));
//1      poly.addPoint((int) (L + L3), (int) T);
            poly.addPoint((int) (L + L3), (int) T);//1
            poly.addPoint((int) (L + L5 + (L3 * 2)), (int) (T + L4));//3
            poly.addPoint((int) (L), (int) (T + L4));//6
            poly.addPoint((int) (L + L3 + L5), (int) T);//2
            poly.addPoint((int) (((L + L3) + (L5 / 2))), (int) (T + (L4 * 2)));
            poly.addPoint((int) (L + L3), (int) T);
            g.fillPolygon(poly);

          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="STAR6">
          if (STAR6) {

            g.setColor(Color.red);

            poly = new Polygon();
            poly.addPoint((int) (L + L3), (int) T);
            poly.addPoint((int) (L + L5 + (L3 * 2)), (int) (T + L4));
            poly.addPoint((int) (L + L3), (int) (T + (L4 * 2)));
            g.fillPolygon(poly);

            poly = new Polygon();
            poly.addPoint((int) (L), (int) (T + L4));
            poly.addPoint((int) (L + L3 + L5), (int) T);
            poly.addPoint((int) (L + L3 + (int) L5), (int) (T + (L4 * 2)));
            g.fillPolygon(poly);

          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="DIAG2">
          if (DIAG2) {
            g.setColor(Color.red);
            x1 = (int) L + 0;
            y1 = (int) T + 0;
            x2 = (int) L + (int) W;
            y2 = (int) T + (int) H * (int) M;
            g.drawLine(x1, y1, x2, y2);
            x1 = (int) L + (int) W;
            y1 = (int) T + 0;
            x2 = (int) L + 0;
            y2 = (int) T + (int) H * (int) M;
            g.drawLine(x1, y1, x2, y2);

          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="DIAG3">
          if (DIAG3) {
            g.setColor(Color.black);
            //1,4
            g.drawLine((int) (L + L3), (int) T, (int) (L + L3 + (int) L5),
              (int) (T + (L4 * 2)));
            //2,5
            g.drawLine((int) (L + L3 + L5), (int) T, (int) (L + L3), (int) (T
              + (L4 * 2)));
            //3,6
            g.drawLine((int) (L + L5 + (L3 * 2)), (int) (T + L4), (int) (L),
              (int) (T + L4));

            g.drawLine((int) (L + L3), (int) T, (int) (L + L5 + (L3 * 2)),
              (int) (T + L4));
            g
              .drawLine((int) (L + L5 + (L3 * 2)), (int) (T + L4),
                (int) (L + L3), (int) (T + (L4 * 2)));
            g.drawLine((int) (L + L3), (int) (T + (L4 * 2)), (int) (L + L3),
              (int) T);
            g.drawLine((int) (L), (int) (T + L4), (int) (L + L3 + L5), (int) T);
            g.drawLine((int) (L + L3 + L5), (int) T, (int) (L + L3 + (int) L5),
              (int) (T + (L4 * 2)));
            g.drawLine((int) (L + L3 + (int) L5), (int) (T + (L4 * 2)),
              (int) (L), (int) (T + L4));
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="FILE">
          if (FILE) {
            File file = new File(
              "D:/CYBERBOARD/BMP/Har/Cra/CM=50-ModularCutter-10.bmp");
            try {
              image = ImageIO.read(file);
            } catch (IOException ex) {
            }
            g.drawImage(image, (int) (L + L3 + (L5 / 2))
              - (image.getWidth() / 2), (int) (T + L4) - (image.getHeight() / 2),
              null);
          }
          //</editor-fold>
//---------------------------
          //<editor-fold defaultstate="collapsed" desc="NOPRESET">
          JUMP = false;
          SECTOR = false;
          SUBSECTOR = false;
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="JUMP">
          if (JUMP) {
            //g.fillPolygon((int)CX,(int)CY);
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="SECTOR">
          if (SECTOR) {
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="SUBSECTOR">
          if (SUBSECTOR) {
          }
          //</editor-fold>
//---------------------------
          //<editor-fold defaultstate="collapsed" desc="NOUWP">
          if (NOUWP) {
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="HEX">
          if (HEX) {
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="NAME">
          if (NAME) {
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="UWP">
          if (UWP) {
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="PAG">
          if (PAG) {
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="POP">
          if (POP) {
          }
          //</editor-fold>
//---------------------------
          //End Extras
          //</editor-fold>
//---------------------------
          if (!square.isSelected()) {
            T += (M * H) + (M * G);
          } else {
            T += (M * H) + G;
          }
          repaint();
        }
        if (!square.isSelected()) {
          L += ((M * G) + (W - L3));
        } else {
          L += S + G;
        }
      }
      //Graphics2D painter2D = (Graphics2D) painter;
    }

    private void addSquare() {
      //setBackground(Color.black);
      S = (int) jss.getValue() * M;
      //T = S;
      //W = S;
      sq = new Polygon();
      sq.addPoint((int) (L), (int) T);
      sq.addPoint((int) (L + S), (int) T);
      sq.addPoint((int) (L + S), (int) (T + S));
      sq.addPoint((int) (L), (int) (T + S));

    }

    private void drawSquare(Graphics g) {
      g.setColor(Color.white);
      g.fillPolygon(sq);
      g.setColor(Color.black);
      Graphics2D painted = (Graphics2D) g;
      BasicStroke pen = new BasicStroke((int) jsl.getValue());
      painted.setStroke(pen);
      painted.draw(sq);
      repaint();
    }
  }
//---------------------------

  private static class SouthPanel extends JPanel {

    public SouthPanel() {
      setBackground(Color.gray);
      //----------------------------------
      final JComboBox<String> jl1 = new JComboBox<>(commands);
      jl1.setToolTipText("jl1=Commands");
      jl1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          //System.out.print("jl1 Change to " + jl1.getModel().getSelectedItem().toString());
          Lines(jl1.getModel().getSelectedItem().toString());
        }
      });
      add(jl1);
      //----------------------------------
      JButton jb1 = new JButton("Show");
      jb1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          showBools();
        }
      });
      add(jb1);
      //----------------------------------
      final JComboBox<String> jl2 = new JComboBox<>(presets);
      jl2.setToolTipText("jl2=Presets");
      jl2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          //System.out.print("jl2 Change to " + jl2.getModel().getSelectedItem().toString());
          Presets(jl2.getModel().getSelectedItem().toString());
        }
      });
      jl2.setSelectedIndex(0);
      add(jl2);
      //----------------------------------
      final JComboBox<String> jl3 = new JComboBox<>(uwp);
      jl3.setToolTipText("jl3=UWP");
      jl3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          //System.out.print("jl3 Change to " + jl3.getModel().getSelectedItem().toString());
          UWP(jl3.getModel().getSelectedItem().toString());
        }
      });
      add(jl3);
      //----------------------------------
    }

    private static void Lines(String thestring) {
      ////System.out.print("Lines = " + string);
      string = thestring;
      switch (thestring) {
        case "NONE":
          NOLINE = !NOLINE;
          break;
        case "Left":
          LEFT = !LEFT;
          break;
        case "Right":
          RIGHT = !RIGHT;
          break;
        case "Top":
          TOP = !TOP;
          break;
        case "Bottom":
          BOTTOM = !BOTTOM;
          break;
        case "Centres":
          CENTRES = !CENTRES;
          break;
        case "Star3":
          STAR3 = !STAR3;
          break;
        case "Star4":
          STAR4 = !STAR4;
          break;
        case "Star5":
          STAR5 = !STAR5;
          break;
        case "Star6":
          STAR6 = !STAR6;
          break;
        case "Diag2":
          DIAG2 = !DIAG2;
          break;
        case "Diag3":
          DIAG3 = !DIAG3;
          break;
        case "File":
          FILE = !FILE;
          break;
        default:
          break;
      }
      //showBools();
    }

    private static void Presets(String thestring) {
      ////System.out.print("Presets = " + string);
      string = thestring;
      switch (thestring) {
        case "NONE":
          NOPRESET = !NOPRESET;
          JUMP = false;
          SECTOR = false;
          SUBSECTOR = false;
          jsh.setValue(20);
          jsx.setValue(10);
          jsy.setValue(10);
          jsm.setValue(1);
          jsg.setValue(0);
          NOPRESET = false;
          break;
        case "Jump":
          JUMP = !JUMP;
          jsh.setValue(40);
          jsx.setValue(13);
          jsy.setValue(13);
          jsm.setValue(1);
          jsg.setValue(0);
          JUMP = false;
          break;
        case "Sector":
          SECTOR = !SECTOR;
          jsh.setValue(13);
          jsx.setValue(32);
          jsy.setValue(40);
          jsm.setValue(1);
          jsg.setValue(0);
          SECTOR = false;
          break;
        case "SubSector":
          SUBSECTOR = !SUBSECTOR;
          jsh.setValue(50);
          jsx.setValue(8);
          jsy.setValue(10);
          jsm.setValue(1);
          jsg.setValue(0);
          SUBSECTOR = false;
          break;
        default:
          //System.out.print("Incorrect reply = " + thestring);
          //System.out.print("Left = " + LEFT);
          break;
      }
    }

    private static void UWP(String thestring) {
      ////System.out.print("UWP = " + string);
      string = thestring;
      switch (thestring) {
        case "NONE":
          NOUWP = !NOUWP;
          break;
        case "Hex":
          HEX = !HEX;
          break;
        case "Name":
          NAME = !NAME;
          break;
        case "UWP":
          UWP = !UWP;
          break;
        case "PAG":
          PAG = !PAG;
          break;
        case "Pop":
          POP = !POP;
          break;
        default:
          //System.out.print("Incorrect reply = " + thestring);
          break;
      }
    }

    private static void showBools() {
      //System.out.print("showBools()");
      int lot = commands.length + presets.length + uwp.length;
      String vName = "";
      for (int i = 0; i < lot; i++) {
        if (i < commands.length) {
          vName = commands[i];
        } else if (i >= commands.length && i < commands.length + presets.length) {
          vName = presets[i - commands.length];
        } else {
          vName = uwp[i - (commands.length + presets.length)];
        }
      }
      //System.out.print("vName = " + vName);
      //System.out.print("string = " + string);
//      H = (int) jsh.getValue();
      //System.out.print("H = " + (int) jsh.getValue());
//      M = (int) jsmult.getValue();
      //System.out.print("M = " + (int) jsm.getValue());
//      G = M * (int) jsgap.getValue();
      //System.out.print("G = " + (int) jsg.getValue());
//      //T = M * G;
      //System.out.print("T = " + T);
//      //L = M * G;
      //System.out.print("L = " + L);
//      W = M * (H * 11 / 8);
      //System.out.print("W = " + W);
//      L3 = M * (H * 3 / 8);
      //System.out.print("L3 = " + L3);
//      L4 = M * (H * 4 / 8);
      //System.out.print("L4 = " + L4);
//      L5 = M * (H * 5 / 8);
      //System.out.print("L5 = " + L5);
//      CX = M * (H / 2);
      //System.out.print("CX = " + CX);
//      CY = M * (W / 2);
      //System.out.print("CY = " + CY);
//      Cols = (int) jsx.getValue();
      //System.out.print("Cols = " + Cols);
//      Rows = (int) jsy.getValue();
      //System.out.print("Rows = " + Rows);
//      width = (int) (((Cols * (G + L3 + L5 + L3)) * M)+(2*G*M)) ;
      //System.out.print("Width = " + width);
//      height = (int) (((Rows + 0.5)*(G+H)* M + (2*G*M)));
      //System.out.print("Height = " + height);

    }
  }
//---------------------------
}
