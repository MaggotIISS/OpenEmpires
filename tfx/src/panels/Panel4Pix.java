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
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static panels.Panel4Pix.jp;

/**
 <p>
 @author maggot
 */
public class Panel4Pix extends Panel4 {

  static JFrame jf;
  static JPanel jp;
  private String[] table;
  private static MouseEvent me;
  private static Graphics g;
  private static Graphics2D g2;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4Pix();
    try {
      jf = new Frame4(jp, Panel4SubSector.jList1.getSelectedValue().toString());
    } catch (Exception e) {
      jf = new Frame4(jp);
    }
    //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jp.setBackground(Color.white);
//    go.setVisible(false);
    updater();
  }

  /**
   Panel4Pix
   */
  public Panel4Pix() {
    /**
     parts of picture countersize = (wid,hgt); counterposition = (x,y);
     fillcolour(back); drawcolour(fore); countercentrex = wid/2;
     */
    initComponents();
    g = jLabel1.getGraphics();
    g2 = (Graphics2D) g;
    try {
      updater();
    } catch (Exception e) {
    }
  }

  static void updater() {
    jp.setBackground(Color.white);
    g = jLabel1.getGraphics();
    g2 = (Graphics2D) g;
    //ZONE
    try {
      switch (Panel4SubSector.jcb4Zone.getSelectedItem().toString()) {
        case "A": {
          jPanel2.setBackground(Color.orange);
          break;
        }
        case "R": {
          jPanel2.setBackground(Color.LIGHT_GRAY);
          break;
        }
        default: {
          jPanel2.setBackground(Color.green);
          break;
        }
      }
    } catch (NullPointerException e) {
      System.out.println("81 zone" + " = " + e);
    }
    //ATMO
    try {
      switch (Panel4SubSector.UWP.getText().substring(2, 3)) {
        case "0":
        case "1": {
          jLabel1.setBackground(Color.white);
          break;
        }
        case "5":
        case "6":
        case "8": {
          jLabel1.setBackground(Color.cyan);
          break;
        }
        default: {
          jLabel1.setBackground(Color.darkGray);
          break;
        }
      }
    } catch (NullPointerException e) {
      System.out.println("81 zone" + " = " + e);
    }

    // Top titles
    g.setColor(Color.gray);
    g.drawString("SP", 10, 15);
    g.drawString("Base", 50, 15);
    g.drawString("TL", 85, 15);
    // Top entries
    try {
      g.setColor(Color.black);
      g.drawString(Panel4SubSector.UWP.getText().substring(0, 1), 10, 30);
      g.drawString(Panel4SubSector.jcb4Bases.getSelectedItem().toString(), 50,
        30);
      g.drawString(Panel4SubSector.UWP.getText().substring(7, 8), 85, 30);
    } catch (Exception e) {
      System.out.println("191 getGraphics" + " = " + e.toString());
    }
    // Mid titles
    try {
      g.setColor(Color.gray);
      g.drawString("SDBs", 10, 50);
      g.drawString("H20", 50, 50);
      g.drawString("DEF CF", 80, 50);
    } catch (Exception e) {
      System.out.println("200 getGraphics" + " = " + e.toString());
    }
    // Mid entries
    try {
      g.setColor(Color.black);
      g.drawString(Panel4SubSector.sdbs1.getText(), 10, 65);
      String w;
      if (GlobalMethods.fromHex(Panel4SubSector.UWP.getText().substring(3, 4))
        > 3) {
        w = "Y";
      } else {
        w = "N";
      }
      g.drawString(w, 50, 65);
      g.drawString(Panel4SubSector.defbats.getText().toString(), 80, 65);
    } catch (Exception e) {
      System.out.println("215 getGraphics" + " = " + e.toString());
    }
    // Bottom titles
    try {
      g.setColor(Color.gray);
      g.drawString("Rons", 10, 85);
      g.drawString("Troops", 80, 85);
    } catch (Exception e) {
      System.out.println("224 getGraphics" + " = " + e.toString());
    }
    // Bottom entries
    try {
      g.setColor(Color.black);
      g.drawString(Panel4SubSector.squadrons.getText(), 10, 100);
      g.drawString(Panel4SubSector.troopunits.getText(), 80, 100);
    } catch (Exception e) {
      System.out.println("233 getGraphics" + " = " + e.toString());
    }
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
    jPanel2.setMaximumSize(new java.awt.Dimension(195, 165));
    jPanel2.setMinimumSize(new java.awt.Dimension(195, 165));
    jPanel2.setName(""); // NOI18N

    jLabel1.setBackground(new java.awt.Color(255, 255, 255));
    jLabel1.setMaximumSize(new java.awt.Dimension(155, 125));
    jLabel1.setMinimumSize(new java.awt.Dimension(155, 125));
    jLabel1.setOpaque(true);
    jLabel1.setPreferredSize(new java.awt.Dimension(155, 125));
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(20, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 240, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(181, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    updater();
  }//GEN-LAST:event_jLabel1MouseClicked
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private static javax.swing.JLabel jLabel1;
  private static javax.swing.JPanel jPanel2;
  // End of variables declaration//GEN-END:variables
}
