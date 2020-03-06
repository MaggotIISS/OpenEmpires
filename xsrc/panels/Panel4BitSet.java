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
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;

/**
 <p>
 @author Your Name Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4BitSet extends Panel4 {

  //<editor-fold defaultstate="collapsed" desc="variables">
  /**
   Frame4
   */
  public static Frame4 jf;
  /**
   Panel4
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
   BitSet
   */
  public BitSet bs;
  /**
   Graphics
   */
  public Graphics g = getGraphics();
  DefaultListModel dlm;
  private int mag = 0;
  boolean covered = false;
  Object[] worlds;
  String[] parts;
  BufferedImage bi;
  //</editor-fold>

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4BitSet();
    jf = new Frame4(jp, "Panel4BitSets");
//    jf.setBounds(0, 0, 1024, 768);
//    jList1.setSelectedValue("Spinward Marches", true);
  }

  /**
   Creates new form Panel4BitMaps
   */
  public Panel4BitSet() {
    super();
    g = getGraphics();
    initComponents();
    loadSectors();
    setListBox();
//    automate();
    jList1.setSelectedValue("Spinward Marches", true);
    jList1.setSelectedIndex(0);
    jTextField1.setText(jList1.getSelectedValue().toString());
    jButton1.doClick();
    mag = 65;
    jSpinner2.setValue(mag);
    repaint();
  }

  /**
   <p>
   @param hex location
   @return bit number set to true from xy location
   */
  public int getBit(String hex) {
    int i = 0;
    String[] partso = new String[2];
    partso[0] = hex.substring(0, 2);
    partso[1] = hex.substring(2);
    int x = ((Integer.parseInt(partso[0]) - 1) * 40);
    int y = ((Integer.parseInt(partso[1]) - 1) % 40);
    return x + y;
  }

  /**
   <p>
   @param bit part of BitSet
   @return xy location from bit number
   */
  public String getHex(int bit) {
    String y = "" + (1 + (bit % 40));
    String x = "" + (1 + (bit / 40));
    if (x.length() == 1) {
      x = "0" + x;
    }
    if (y.length() == 1) {
      y = "0" + y;
    }
    return x + y;
  }

  /**
   <p>
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
   <p>
   @param bit to convert to Hex
   @return hex location from selected bit
   */
  public String getHexNum(int bit) {
    String res = getHex(bit);
    return res;
  }

  /**
   <p>
   @param g Graphics
   */
  @Override
  public void paintComponent(Graphics g) {
//    jp.setBackground(Color.white);
    int mod = 0;
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 32 * mag, 40 * mag + (mag / 2));
    super.paintComponent(g);
    int[] xy = null;
    for (int i = 0; i < 1279; i++) {
//      g.setColor(Color.white);
      if (bs.get(i) == true) {
        xy = getXY(getHex(i));
        if (xy[0] % 2 == 0) {
          mod = (mag / 2);
        } else {
          mod = 0;
        }
        int x = mag * (xy[0] - 1);// + jPanel1.getWidth();
        int y = (mag * (xy[1] - 1)) + mod;
        int wid = mag * 11 / 10;
        int hgt = mag;
        jLabel1.setText(("" + wid));
//        g.setColor(Color.black);
//        g.fillRect(x, y,wid,hgt );
        g.drawOval(x, y, wid, hgt);
        g.setColor(Color.white);
        g.fillOval(x, y, wid, hgt);
//        g.setColor(Color.black);
        if (!covered) {
          String s[] = new String[12];
          if ((int) jSpinner2.getValue() > 30) {
            //<editor-fold defaultstate="collapsed" desc="text">
            for (int j = 0; j < worlds.length; j++) {
              if (worlds[j].toString().contains("" + getHexNum(i))) {
                String[] bits = worlds[j].toString().split(",");
                //bits = bits.toString().replace("\"", "");
//                System.out.println("" + " = " + bits[0]);
                s[0] = bits[11].replace("\"", "");
                s[1] = bits[0].replace("\"", "");
                s[2] = bits[2].replace("\"", "");
                s[3] = bits[16].replace("\"", "") + " " + bits[3].replace("\"",
                  "");
                s[4] = bits[9].replace("\"", "");
                s[5] = bits[4].replace("\"", "");
                s[6] = bits[12].replace("\"", "");
                s[7] = bits[13].replace("\"", "");
                s[8] = bits[14].replace("\"", "");
                s[9] = bits[5].replace("\"", "");
                s[10] = bits[10].replace("\"", "");
                s[11] = bits[17].replace("\"", "");
              }
            }
            Font f = new Font("Monospaced", Font.PLAIN, 10);
            g.setFont(f);
            FontMetrics fm = g.getFontMetrics();
            int fheight = (int) fm.getStringBounds(getHexNum(i), g).getHeight()
              * 2 / 3;
            int left = 0, top = 0;
            g.setColor(Color.LIGHT_GRAY);
            //Hex number at top
            left = (int) (x + (wid / 2) - (fm.getStringBounds(getHexNum(i), g)
              .getCenterX()));
            top = y + fheight;//+ (hgt / 2) - (mod / 2);
            g.drawString(getHexNum(i), left, top);//+mod-mod);
//            //Name
//            s[0] = "Regina";
            left = (int) (x + (wid / 2) - (fm.getStringBounds(s[0], g)
              .getCenterX()));
            top = y + (fheight * 2);
            g.drawString(s[0], left, top);//+mod-mod);
//            //UWP
//            s[1] = "A788899A";
            left = (int) (x + (wid / 2) - (fm.getStringBounds(s[1], g)
              .getCenterX()));
            top = y + (fheight * 3);
            g.drawString(s[1], left, top);//+mod-mod);
//            //GGsAst
//            s[2] = "3GGs 0Ast";
            left = (int) (x + (wid / 2) - (fm.getStringBounds(s[2], g)
              .getCenterX()));
            top = y + (fheight * 4);
            g.drawString(s[2], left, top);//+mod-mod);
//            //Bases
//            s[3] = "2 Bases";
            if ((int) jSpinner2.getValue() > 35) {
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[3], g)
                .getCenterX()));
              top = y + (fheight * 5);
              g.drawString(s[3], left, top);//+mod-mod);
//            //Trade
//            s[4] = "Ri Cp";
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[4], g)
                .getCenterX()));
              top = y + (fheight * 6);
              g.drawString(s[4], left, top);//+mod-mod);
//            //Trade
//            s[5] = "Ri Cp";
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[5], g)
                .getCenterX()));
              top = y + (fheight * 7);
              g.drawString(s[5], left, top);//+mod-mod);
            }
            if ((int) jSpinner2.getValue() > 65) {
//            //Trade
//            s[5] = "Ri Cp";
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[6], g)
                .getCenterX()));
              top = y + (fheight * 8);
              g.drawString(s[6], left, top);//+mod-mod);
//            //Trade
//            s[5] = "Ri Cp";
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[7], g)
                .getCenterX()));
              top = y + (fheight * 9);
              g.drawString(s[7], left, top);//+mod-mod);
//            //Trade
//            s[5] = "Ri Cp";
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[8], g)
                .getCenterX()));
              top = y + (fheight * 10);
              g.drawString(s[8], left, top);//+mod-mod);
            }
            if ((int) jSpinner2.getValue() > 95) {
//            //Trade
//            s[5] = "Ri Cp";
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[9], g)
                .getCenterX()));
              top = y + (fheight * 11);
              g.drawString(s[9], left, top);//+mod-mod);
//            //Trade
//            s[5] = "Ri Cp";
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[10], g)
                .getCenterX()));
              top = y + (fheight * 12);
              g.drawString(s[10], left, top);//+mod-mod);
//            //Trade
//            s[5] = "Ri Cp";
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[11], g)
                .getCenterX()));
              top = y + (fheight * 13);
              g.drawString(s[11], left, top);//+mod-mod);
            }
            //===============================================
          }
          //</editor-fold>
        } else {
          //get centre of oval
          Point p = new Point(x + (wid / 2), y + (hgt / 2));
          g.drawRect((int) p.getX(), (int) p.getY(), 1, 1);
        }
      }
    }
    g.setColor(Color.white);
//    bi = (BufferedImage) createImage(null);
//    Graphics2D g2 = (Graphics2D) g; // we need a Graphics2D context
//    BufferedImage grid = null;
//    if (grid == null) {
//      // Compute the grid only one time
//      int w = this.getWidth();
//      int h = this.getHeight();
//      grid = (BufferedImage) (this.createImage(w, h));
//      Graphics2D gc = grid.createGraphics();
//      for (int x = 0; x < w; x += 10) {
//        gc.drawLine(x, 0, x, h);
//      }
//      for (int y = 0; y < h; y += 10) {
//        gc.drawLine(0, y, w, y);
//      }
//    }
//    // Draw the grid from the precomputed image
//    g2.drawImage(grid, null, 0, 0);
  }

  private void sectorToBitSet() {
    int num = 32 * 40;
    bs = new BitSet(num);
  }

  @SuppressWarnings("unchecked")
  private void loadSectors() {
    File f = new File(GlobalVariables.CSV + GlobalVariables.FS + "uwp-Worlds");
    //File f = new File(GlobalVariables.T5 + GlobalVariables.FS + "Worlds.txt");
    wlines = GlobalMethods.getLinesFromFile(f);
    for (int i = 1; i < wlines.length; i++) {
      parts = wlines[i].toString().split("\",\"");
      String word = parts[(int) jSpinner1.getValue()].replace("\"", "");
    }
    File f0 = new File(GlobalVariables.CSV + "/uwp-sector");
    slines = GlobalMethods.getLinesFromFile(f0);
    dlm = new DefaultListModel();
    for (int i = 1; i < slines.length; i++) {
      parts = slines[i].toString().split("\",\"");
      String word = parts[0].replace("\"", "");
      dlm.addElement(word);
    }
    jList1.setModel(dlm);
  }

  private void printSector(BitSet bs1) {
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
  }

  @SuppressWarnings("unchecked")
  private void automate() {
    File f = new File(GlobalVariables.CSV + "/uwp-sector");
    slines = GlobalMethods.getLinesFromFile(f);
    dlm = new DefaultListModel();
    for (int i = 1; i < slines.length; i++) {
      String[] partso = slines[i].toString().split("\",\"");
      String word = partso[0].replace("\"", "");
      jTextField1.setText(word);
      dlm.addElement(word);
      jButton1.doClick();
    }
    jList1.setModel(dlm);
  }

  private void setListBox() {
  }

  private void drawHex(int mag) {
    int h = 0, w = 0, l = 0, l3 = 0, l4 = 0, l5 = 0, t = 0;
    Point a, b, c, d, e, f;
    h = mag;
    w = h * 11 / 8;
    l3 = w / 11 * 3;
    l4 = w / 11 * 4;
    l5 = w / 11 * 5;
    a = new Point(l + l3, t);
    b = new Point(l + l3 + l5, t);
    c = new Point(l + l5 + (l3 * 2), t + l4);
    d = new Point(l + l3 + l5, t + (l4 * 2));
    e = new Point(l + l3, (l4 * 2));
    f = new Point(l, t + l4);
    int x = (int) a.getX();
    int y = (int) a.getY();
    int x1 = (int) b.getX();
    int y1 = (int) b.getY();
    Polygon p = new Polygon();
    p.addPoint((int) a.getX(), (int) a.getY());
    p.addPoint((int) b.getX(), (int) b.getY());
    p.addPoint((int) c.getX(), (int) c.getY());
    p.addPoint((int) d.getX(), (int) d.getY());
    p.addPoint((int) e.getX(), (int) e.getY());
    p.addPoint((int) f.getX(), (int) f.getY());
//    g.drawPolygon(p);
    repaint();
  }

  @SuppressWarnings("unchecked")
  private void sectorToList(String s) {
    ArrayList al = new ArrayList();
    for (int i = 0; i < wlines.length; i++) {
      if (wlines[i].toString().contains(s)) {
        al.add(wlines[i].toString());
        //System.out.println("" + " = " +wlines[i]);
      }
    }
    worlds = new String[al.size()];
    worlds = al.toArray();
//    parts = new String[worlds.length][25];
//    for (int i = 0; i < worlds.length; i++) {
//      parts[i] = worlds[i].toString().split(",");
//      //System.out.println("" + " = " +parts[i].toString());
//      for (int j = 0; j < parts[i].length; j++) {
//        //System.out.println("" +parts[i][j].toString());
//      }
//      //System.out.println(GlobalMethods.comment("=", 20));
//    }
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jPanel1 = new javax.swing.JPanel();
    jSpinner1 = new javax.swing.JSpinner();
    jButton1 = new javax.swing.JButton();
    jScrollPane2 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList();
    jLabel1 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jSpinner2 = new javax.swing.JSpinner();
    jButton2 = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    jList2 = new javax.swing.JList();

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

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(7), Integer.valueOf(0), null, Integer.valueOf(1)));

    jButton1.setText("GO");
    jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jScrollPane2.setHorizontalScrollBar(null);

    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList1MouseClicked(evt);
      }
    });
    jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        jList1ValueChanged(evt);
      }
    });
    jScrollPane2.setViewportView(jList1);

    jLabel1.setForeground(new java.awt.Color(255, 0, 0));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("jLabel1");
    jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel1.setOpaque(true);

    jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    jTextField1.setText("Spinward Marches");

    jSpinner2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
    jSpinner2.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
      public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
        jSpinner2MouseWheelMoved(evt);
      }
    });
    jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jSpinner2StateChanged(evt);
      }
    });

    jButton2.setText("Save");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jScrollPane3.setViewportView(jList2);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jSpinner2)
      .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jSpinner1)
      .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
      .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
      .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(jButton2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        .addGap(7, 7, 7)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jButton1)
        .addGap(0, 0, 0)
        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jLabel1))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(0, 0, 0)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    jTextArea1.setText("");
    String searchfor = jTextField1.getText();
    int column = (int) jSpinner1.getValue();
    String[] partso = wlines[0].toString().replace("\"", "").split(",");
    int cols = partso.length;
    sectorToBitSet();
    for (int i = 0; i < wlines.length; i++) {
      partso = wlines[i].toString().replace("\"", "").split(",");
      if (partso[column].toString().equals(searchfor)) {
        bs.set(getBit(partso[1]));
      }
    }
    jTextArea1.append("populated" + " = " + bs.cardinality()
      + GlobalVariables.CRLF);
    printSector(bs);
    jTextArea1.append("populated" + " = " + bs.cardinality());
    //GlobalMethods.saveTextFile(GlobalVariables.CSV + "/BitSets", "BitSet4" + jTextField1.getText(), "", jTextArea1.getText());
    repaint();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
    ListSelectionEvent lse = new ListSelectionEvent(jList1, jList1
      .getSelectedIndex(), jList1.getSelectedIndex(), true);
    jList1ValueChanged(lse);
  }//GEN-LAST:event_jList1MouseClicked

  private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
    if (evt.getValueIsAdjusting() != true) {
      String s = jList1.getSelectedValue().toString();
      jTextField1.setText(s);
      jButton1.doClick();
      sectorToList(s);
    }
    repaint();
  }//GEN-LAST:event_jList1ValueChanged

  private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
    mag = (int) jSpinner2.getValue();
    repaint();
  }//GEN-LAST:event_jSpinner2StateChanged

  private void jSpinner2MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jSpinner2MouseWheelMoved
    jSpinner2.setValue((int) jSpinner2.getValue() + evt.getWheelRotation());
  }//GEN-LAST:event_jSpinner2MouseWheelMoved

  private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
    int sum = (int) jSpinner2.getValue() + (evt.getWheelRotation() * 30);
    if (sum > 1) {
      jSpinner2.setValue(sum);
    }
  }//GEN-LAST:event_formMouseWheelMoved

  private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    covered = !covered;
    repaint();
  }//GEN-LAST:event_formMouseClicked

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    for (int i = 0; i < jList1.getModel().getSize(); i++) {
      jList1.setSelectedIndex(i);
      savePic();
    }

  }//GEN-LAST:event_jButton2ActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  public static javax.swing.JList jList1;
  private javax.swing.JList jList2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JSpinner jSpinner1;
  private javax.swing.JSpinner jSpinner2;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JTextField jTextField1;
  // End of variables declaration//GEN-END:variables

  private void savePic() {
    Iterator writers = ImageIO.getImageWritersByFormatName("gif");
    ImageWriter writer = (ImageWriter) writers.next();
    System.out.println("writer" + " = " + writer);

//Once an ImageWriter has been obtained, its destination must be set to an ImageOutputStream:
    String fname = jList1.getSelectedValue().toString();
    File f = new File(GlobalVariables.BMP + "/Imp/_" + fname + ".gif");
    //File f = new File(GlobalVariables.T5 + FS + "_" + fname + ".gif");
    ImageOutputStream ios = null;
    try {
      ios = ImageIO.createImageOutputStream(f);
    } catch (IOException ex) {
      Logger.getLogger(Panel4BitSet.class.getName()).log(Level.SEVERE, null, ex);
    }
    writer.setOutput(ios);
    repaint();

//Finally, the image may be written to the output stream:
    GraphicsConfiguration gc;
    gc = Panel4BitSet.jf.getContentPane()
      .getGraphicsConfiguration();
    bi = gc.createCompatibleImage(33 * mag, 41 * mag);
    g = bi.getGraphics();
    Graphics2D g2 = bi.createGraphics();
    int mod = 0;
    super.paintComponent(g);
    super.paintComponent(g2);
    g.setColor(Color.BLACK);
    g2.setColor(Color.BLACK);
    g.fillRect(0, 0, 34 * mag, 44 * mag + (mag / 2));
    int[] xy = null;
    for (int i = 0; i < 1279; i++) {
      if (bs.get(i) == true) {
        xy = getXY(getHex(i));
        if (xy[0] % 2 == 0) {
          mod = (mag / 2);
        } else {
          mod = 0;
        }
        int x = (mag * (xy[0] - 1));// + jPanel1.getWidth();
        int y = (mag * (xy[1] - 1)) + mod;
        int wid = mag * 11 / 10;
        int hgt = mag;
        jLabel1.setText(("" + wid));
        g.setColor(Color.black);
        g.drawOval(x, y, wid, hgt);
        g.setColor(Color.white);
        g.fillOval(x, y, wid, hgt);
        if (!covered) {
          String s[] = new String[12];
          if ((int) jSpinner2.getValue() > 30) {
            //<editor-fold defaultstate="collapsed" desc="text">
            for (int j = 0; j < worlds.length; j++) {
              if (worlds[j].toString().contains("" + getHexNum(i))) {
                String[] bits = worlds[j].toString().split(",");
                s[0] = bits[11].replace("\"", "");
                s[1] = bits[0].replace("\"", "");
                s[2] = bits[2].replace("\"", "");
                s[3] = bits[16].replace("\"", "") + " " + bits[3].replace("\"",
                  "");
                s[4] = bits[9].replace("\"", "");
                s[5] = bits[4].replace("\"", "");
                s[6] = bits[12].replace("\"", "");
                s[7] = bits[13].replace("\"", "");
                s[8] = bits[14].replace("\"", "");
                s[9] = bits[5].replace("\"", "");
                s[10] = bits[10].replace("\"", "");
                s[11] = bits[17].replace("\"", "");
              }
            }
            Font fo = new Font("Monospaced", Font.PLAIN, 10);
            g2.setFont(fo);
            FontMetrics fm = g2.getFontMetrics();
            int fheight = (int) fm.getStringBounds(getHexNum(i), g).getHeight()
              * 2 / 3;
            int left = 0, top = 0;
            g2.setColor(Color.LIGHT_GRAY);
            //Hex number at top
            left = (int) (x + (wid / 2) - (fm.getStringBounds(getHexNum(i), g)
              .getCenterX()));
            top = y + fheight;//+ (hgt / 2) - (mod / 2);
            g2.drawString(getHexNum(i), left, top);//+mod-mod);
//            //Name
            left = (int) (x + (wid / 2) - (fm.getStringBounds(s[0], g)
              .getCenterX()));
            top = y + (fheight * 2);
            g2.drawString(s[0], left, top);//+mod-mod);
//            //UWP
            left = (int) (x + (wid / 2) - (fm.getStringBounds(s[1], g)
              .getCenterX()));
            top = y + (fheight * 3);
            g2.drawString(s[1], left, top);//+mod-mod);
//            //GGsAst
            left = (int) (x + (wid / 2) - (fm.getStringBounds(s[2], g)
              .getCenterX()));
            top = y + (fheight * 4);
            g2.drawString(s[2], left, top);//+mod-mod);
//            //Bases
            if ((int) jSpinner2.getValue() > 35) {
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[3], g)
                .getCenterX()));
              top = y + (fheight * 5);
              g2.drawString(s[3], left, top);//+mod-mod);
//            //Trade
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[4], g)
                .getCenterX()));
              top = y + (fheight * 6);
              g2.drawString(s[4], left, top);//+mod-mod);
//            //Trade
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[5], g)
                .getCenterX()));
              top = y + (fheight * 7);
              g2.drawString(s[5], left, top);//+mod-mod);
            }
            if ((int) jSpinner2.getValue() > 65) {
//            //Trade
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[6], g)
                .getCenterX()));
              top = y + (fheight * 8);
              g2.drawString(s[6], left, top);//+mod-mod);
//            //Trade
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[7], g)
                .getCenterX()));
              top = y + (fheight * 9);
              g2.drawString(s[7], left, top);//+mod-mod);
//            //Trade
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[8], g)
                .getCenterX()));
              top = y + (fheight * 10);
              g2.drawString(s[8], left, top);//+mod-mod);
            }
            if ((int) jSpinner2.getValue() > 95) {
//            //Trade
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[9], g)
                .getCenterX()));
              top = y + (fheight * 11);
              g2.drawString(s[9], left, top);//+mod-mod);
//            //Trade
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[10], g)
                .getCenterX()));
              top = y + (fheight * 12);
              g2.drawString(s[10], left, top);//+mod-mod);
//            //Trade
              left = (int) (x + (wid / 2) - (fm.getStringBounds(s[11], g)
                .getCenterX()));
              top = y + (fheight * 13);
              g2.drawString(s[11], left, top);//+mod-mod);
            }
          }
          //</editor-fold>
        } else {
          //get centre of oval
          Point p = new Point(x + (wid / 2), y + (hgt / 2));
          g.drawRect((int) p.getX(), (int) p.getY(), 1, 1);
        }
      }
    }
    g2.setColor(Color.LIGHT_GRAY);
    try {
      writer.write(bi);
    } catch (IOException ex) {
      Logger.getLogger(Panel4BitSet.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
