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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 <p>
 @author Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4T5SystemPic1 extends Panel4 {

  static MouseEvent me;
  String[][] orbits = new String[4][20];
  DefaultListModel<String> model;
  static JLabel jl;
  static Graphics g;
  static String sel;
  static int linenum;
  static String[] tmp;
  Boolean combod = null;
  ArrayList<String>[] cbm;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    JPanel jp = new Panel4T5SystemPic1();
    JFrame jf = new Frame4(jp, "Panel4T5SystemPic");
//    jButton1.doClick();
//    jComboBox1.setSelectedIndex(0);
  }

  /**
   Creates new form Panel4T5SystemPic
   */
  @SuppressWarnings("unchecked")
  public Panel4T5SystemPic1() {
    super();
    initComponents();
    DefaultComboBoxModel cbm = new DefaultComboBoxModel();
    try {
//      String[] str = Panel4SubSector.getStars();
      String[] str = new String[Panel4T5Locator.jcb4Star.getItemCount()];
      for (int i = 0; i < str.length; i++) {
        System.out.println("" + i + " = " + str[i]);
        if (str[i].length() > 0) {
          cbm.addElement(str[i]);
        }
      }
    } catch (Exception e) {
      //JOptionPane.showMessageDialog(jf, "" + 1);
    }
    jComboBox1.setModel(cbm);
    model = new DefaultListModel<>();
    tmp = null;
    try {
      tmp = Panel4T5System.Orbits;
    } catch (Exception e) {
      //JOptionPane.showMessageDialog(jf, "" + 2);
    }
    try {
      for (int i = 0; i < 20; i++) {
        orbits[0][i] = tmp[i];
        model.addElement(tmp[i]);
      }
    } catch (Exception e) {
      //JOptionPane.showMessageDialog(jf, "" + 3);
    }
    jList1.setModel(model);
    for (int j = 0; j < 4; j++) {
      for (int k = 0; k < 20; k++) {
        orbits[j][k] = "";
      }
    }
    setOrbits();
//    jButton1.doClick();
  }

  private void draw(String text) {
    jl = new JLabel(text);
    int bottom = jLabel1.getHeight();
    int left = jLabel1.getX();
    //<editor-fold defaultstate="collapsed" desc="switch (text)">
    switch (text) {
      case "Inner": {
        jl = jLabel1;
//        jl.setBackground(Color.red);
        break;
      }
      case "Outer": {
        jl = jLabel2;
//        jl.setBackground(Color.BLUE);
        break;
      }
      case "Remote": {
        jl = jLabel3;
//        jl.setBackground(Color.DARK_GRAY);
        break;
      }
      case "Orbit": {
        jl = jLabel7;
//        jl.setBackground(Color.GREEN);
        break;
      }
      case "DEFAULT":
      default: {
        jl = jLabel7;
//        g.setColor(Color.LIGHT_GRAY);
        jl.setBackground(Color.yellow);
        break;
      }
    }

    //</editor-fold>
    int dia = 8;
    int rad = dia / 2;
    int cx = jl.getWidth() / 4;
    int cy = jl.getHeight() / 8;
    g = jl.getGraphics();
    g.setColor(Color.LIGHT_GRAY);
    g.fillOval(cx - rad, cy - rad, dia, dia);
    int sel = jList1.getSelectedIndex() - 1;
    if (!"Orbit".equals(text)) {
      if ("Inner".equals(text)) {
      }
      if ("Outer".equals(text)) {
        sel = sel - 6;
      }
      if ("Remote".equals(text)) {
        sel = sel - 12;
      }
      for (int i = 0; i < 6; i++) {
        dia = dia + ((i + 1) * jl.getWidth() / 14);
        rad = dia / 2;
        if (i == sel) {
          g.setColor(Color.black);
        } else {
          g.setColor(Color.LIGHT_GRAY);
        }
        g.drawOval(cx - rad, cy - rad, dia, dia);
        g.setColor(Color.LIGHT_GRAY);
      }
    } else if ("Orbit".equals(text)) {
      cx = jl.getWidth() / 4;
      int wid = (jl.getWidth() - cx);
      cy = jl.getHeight() / 8;
      for (int i = 1; i <= 24; i++) {
        dia = 2 * (wid / 25) * i;
        rad = dia / 2;
        if (i == sel - 19) {
          g.setColor(Color.black);
        } else {
          g.setColor(Color.LIGHT_GRAY);
        }
        g.drawOval(cx - rad, cy - rad, dia, dia);
      }
    }
    g.setColor(Color.BLACK);
    if ((text != "Orbit") & (text != "Inner")) {
      g.drawLine(left, 0, cx, cy);
      g.drawLine(left, bottom, cx, cy);
    }
//    drawStar();
  }

  private void redraw() {
    jLabel4MouseClicked(me);
    jLabel5MouseClicked(me);
    jLabel6MouseClicked(me);
    jLabel8MouseClicked(me);
  }

  @SuppressWarnings("unchecked")
  private void setOrbits() {
    int stars = 0;
    int starnum = 0;
    for (int i = 0; i < orbits[starnum].length; i++) {
      if (orbits[starnum][i].contains("HZ=")) {
        stars += 1;
      }
    }
    cbm = new ArrayList[stars];
    int sele = 0;
    int end = 0;
    do {
      starnum += 1;
    } while (starnum < stars);
    int start = 0;
    int i = jComboBox1.getSelectedIndex();
    System.out.print("" + " = " + GlobalMethods.comment("-", 20));
//    System.out.println("System star" + " = " + jComboBox1.getItemAt(i)
//      .toString());
//    System.out.println("  Orbits" + " = " + Panel4T5System.orb[i]);
    switch (i) {
      case 0: {
        start = 1;
        end = Panel4T5System.orb[0] + 2;
        break;
      }
      case 1: {
        start = Panel4T5System.orb[0]
          + 3;
        end = start + Panel4T5System.orb[1] + 1;
        break;
      }
      case 2: {
        start = Panel4T5System.orb[0]
          + Panel4T5System.orb[1]
          + 5;
        end = start + Panel4T5System.orb[2] + 1;
        break;
      }
      case 3: {
        start = Panel4T5System.orb[0]
          + Panel4T5System.orb[1]
          + Panel4T5System.orb[2]
          + 7;

        end = Panel4T5System.orb[3] + 2;
        break;
      }
    }
    System.out.println(" start" + " = " + start);
    System.out.println(" end" + " = " + end);
//      jList1.clearSelection();
    DefaultListModel dlm = new DefaultListModel();
    for (int j = start; j < end; j++) {
      if (tmp[j] == "") {
        break;
      }
      dlm.addElement(tmp[j]);
      System.out.println(" tmp[" + j + "]" + " = " + tmp[j]);
      //System.out.print("" + " = " + GlobalMethods.comment("-", 20));
    }
    jList1.setModel(dlm);
  }

  private void showTmp() {
    for (int i = 0; i < tmp.length; i++) {
      System.out.println("tmp[" + i + "]" + " = " + tmp[i]);
    }
  }

  private void listClick() {
    jTextArea1.setText("");
    if (!jList1.isSelectionEmpty()) {
      sel = jList1.getSelectedValue().toString();
    }
    int orbnum = -1;
    try {
      orbnum = Integer.parseInt(sel.substring(0, 2).trim());
      jTextArea1.setText("");
    } catch (Exception e) {
      orbnum = -2;
    }
//    redraw();
    String text = null;
    switch (orbnum) {
      case -2:
      case -1: {
        jLabel4MouseClicked(me);
      }
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5: {
        text = "Inner";
        jl = jLabel1;
        jLabel4MouseClicked(me);
        jLabel5MouseClicked(me);
        break;
      }
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11: {
        text = "Outer";
        jl = jLabel2;
        jLabel4MouseClicked(me);
        jLabel5MouseClicked(me);
        jLabel6MouseClicked(me);
        break;
      }
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17: {
        text = "Remote";
        jl = jLabel3;
        jLabel5MouseClicked(me);
        jLabel6MouseClicked(me);
        break;
      }
      default: {
        text = "Orbit";
        jLabel8MouseClicked(me);
        break;
      }
    }
    draw(text);
    if (!jList1.isSelectionEmpty()) {
      jTextArea1.append(jList1.getSelectedValue().toString());
    }
    jLabel8MouseClicked(me);
//    drawStar();
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panel41 = new panels.Panel4();
    jScrollPane1 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jTextField1 = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jComboBox1 = new javax.swing.JComboBox();

    jScrollPane1.setOpaque(false);

    jList1.setModel(new javax.swing.AbstractListModel() {
      String[] strings = { "Test" };
      public int getSize() { return strings.length; }
      public Object getElementAt(int i) { return strings[i]; }
    });
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
    jScrollPane1.setViewportView(jList1);

    jPanel1.setOpaque(false);

    jLabel1.setBackground(java.awt.Color.red);
    jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel1.setOpaque(true);

    jLabel2.setBackground(java.awt.Color.cyan);
    jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel2.setOpaque(true);

    jLabel3.setBackground(java.awt.Color.blue);
    jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel3.setOpaque(true);

    jLabel4.setForeground(java.awt.Color.green);
    jLabel4.setText("Inner System");
    jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel4MouseClicked(evt);
      }
    });

    jLabel5.setForeground(java.awt.Color.green);
    jLabel5.setText("Outer System");
    jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel5MouseClicked(evt);
      }
    });

    jLabel6.setForeground(java.awt.Color.green);
    jLabel6.setText("Remote System");
    jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel6MouseClicked(evt);
      }
    });

    jLabel7.setBackground(new java.awt.Color(255, 255, 255));
    jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel7.setOpaque(true);

    jLabel8.setForeground(java.awt.Color.green);
    jLabel8.setText("Orbit");
    jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel8MouseClicked(evt);
      }
    });

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane2.setViewportView(jTextArea1);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(43, 43, 43))
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(18, 18, 18)))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(41, 41, 41))
          .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
      .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jScrollPane2)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(0, 0, 0)
        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(0, 0, 0)
        .addComponent(jScrollPane2))
    );

    jTextField1.setEditable(false);
    jTextField1.setOpaque(false);
    jTextField1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField1ActionPerformed(evt);
      }
    });

    jButton1.setText("jButton1");
    jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jButton1MouseClicked(evt);
      }
    });

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout panel41Layout = new javax.swing.GroupLayout(panel41);
    panel41.setLayout(panel41Layout);
    panel41Layout.setHorizontalGroup(
      panel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel41Layout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(panel41Layout.createSequentialGroup()
        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(58, 58, 58)
        .addComponent(jTextField1))
    );
    panel41Layout.setVerticalGroup(
      panel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(panel41Layout.createSequentialGroup()
        .addGroup(panel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addGroup(panel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
    listClick();
    drawStar();
  }//GEN-LAST:event_jList1MouseClicked

  private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
    jList1MouseClicked(me);
  }//GEN-LAST:event_jList1ValueChanged

  private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
    draw("Inner");
  }//GEN-LAST:event_jLabel4MouseClicked

  private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    draw("Outer");
  }//GEN-LAST:event_jLabel5MouseClicked

  private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    draw("Remote");
  }//GEN-LAST:event_jLabel6MouseClicked

  private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    draw("Orbit");
  }//GEN-LAST:event_jLabel8MouseClicked

  private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
//    redraw();
//    showTmp();
    jList1.setSelectedIndex(0);
  }//GEN-LAST:event_jButton1MouseClicked

  private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextField1ActionPerformed

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    setOrbits();
    jList1.setSelectedIndex(0);
    jButton1MouseClicked(me);
  }//GEN-LAST:event_jComboBox1ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private static javax.swing.JButton jButton1;
  private static javax.swing.JComboBox jComboBox1;
  private static javax.swing.JLabel jLabel1;
  private static javax.swing.JLabel jLabel2;
  private static javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private static javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private static javax.swing.JList jList1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextArea jTextArea1;
  private static javax.swing.JTextField jTextField1;
  private panels.Panel4 panel41;
  // End of variables declaration//GEN-END:variables

  private void drawStar() {
    if (jList1.getSelectedIndex() == 0) {
      int dia = 6;
      int rad = dia / 2;
      int cx = jLabel1.getWidth() / 4;
      int cy = jLabel1.getHeight() / 8;
      g = jLabel1.getGraphics();
      g.setColor(Color.black);
      g.fillOval(cx - rad, cy - rad, dia, dia);
      g.setColor(Color.lightGray);
    }
  }

}
