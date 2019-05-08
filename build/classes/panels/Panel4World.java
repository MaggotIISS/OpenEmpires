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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static panels.Panel4Squadron.tables;

/**
 <p>
 @author Your Name Mark Ferguson maggot.iiss@sky.com
 */
public final class Panel4World extends Panel4 implements Interface4UWP {

  //<editor-fold defaultstate="collapsed" desc="variables">
  private static String FS = dbviewer.globals.GlobalVariables.FS;
  private static JFrame jf;
  private static JPanel jp;
  static Graphics g;
  private Graphics2D g2;
  private MouseEvent me;
  private static String[] table;
  //</editor-fold>

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4World();
    jf = new Frame4(jp, "World");
    //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setSize(220, 260);
    jp.setBackground(Color.white);
    sub2Pic();
  }

  /**
   Creates new form Panel4Tabs
   */
  public Panel4World() {
    initComponents();
    //g = jp.getGraphics();
    //g2 = (Graphics2D) g;
    updater();
    jPanel1.setVisible(false);
//    jPanel2.setVisible(false);
    jPanel3.setVisible(false);
    go.setVisible(false);
//    jPanel2.setVisible(false);
//    jLabel1.setVisible(false);
    validate();
    //jp.setBackground(Color.white);
  }

  static String getFromTable(int tablenum, String x, String y) {
    String[] tableo = tables[tablenum];
    int cols = Integer.parseInt(tableo[0]);
    int rows = (tableo.length - 1) / cols;
    int col = 0;
    int row = dbviewer.globals.GlobalMethods.fromHex(y);
    String pop = Panel4SubSector.UWP.getText().substring(5, 6);
    String tl = Panel4SubSector.UWP.getText().substring(7, 8);
    int i = 0;
    for (i = 1; i <= cols; i++) {
      if (tableo[i].contains(x)) {
        col = i;
        break;
      }
    }
    for (i = 1; i < tableo.length; i += cols) {
      if (tableo[i].contains(y)) {
        break;
      }
    }
    if (i + col < tableo.length) {
      return tableo[(i + col) - 1];
    } else {
      return null;
    }
  }

  /**
   <p>
   @param g Graphics
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    updater();
    switch (zone.getText().toLowerCase().substring(0, 1)) {
      case "r": {
        g.setColor(Color.LIGHT_GRAY);
        break;
      }
      case "a": {
        g.setColor(Color.orange);
        break;
      }
      case "g":
      case "": {
        g.setColor(Color.green);
        break;
      }
    }
    g.fillRect(0, 0, 200, 200);
    switch (atmo.getText().toLowerCase()) {
      case "normal": {
        g.setColor(Color.cyan);
        break;
      }
      case "tainted": {
        g.setColor(Color.darkGray);
        break;
      }
      case "vaccuum": {
        g.setColor(Color.white);
        break;
      }
    }
    g.fillRect(25, 25, 150, 150);

    try {
      g.setColor(Color.gray);
      g.drawString("SP", 35, 40);
      g.drawString("Base", 85, 40);
      g.drawString("TL", 140, 40);

      g.setColor(Color.black);
      g.drawString(sp.getText().toString(), 35, 55);
      g.drawString(bases.getText().toString(), 85, 55);
      g.drawString(tl.getText().toString(), 140, 55);

      g.setColor(Color.gray);
      g.drawString("SDBs", 35, 80);
      g.drawString("H20", 85, 80);
      g.drawString("DEF CF", 130, 80);

      g.setColor(Color.black);
      g.drawString(Panel4SubSector.sdbs1.getText().toString(), 35, 95);

      String w;
      if (GlobalMethods.fromHex(getHy()) > 1) {
        w = "Y";
      } else {
        w = "N";
      }
      g.drawString(w, 95, 95);
      g.drawString(Panel4SubSector.defbats.getText().toString(), 130, 95);

      g.setColor(Color.gray);
      g.drawString("Max Rons", 35, 120);
      g.drawString("", 85, 120);
      g.drawString("Troops", 130, 120);

      g.setColor(Color.black);
      g.drawString(Panel4SubSector.squadrons.getText(), 35, 135);
      g.drawString("", 50, 100);
      g.drawString(Panel4SubSector.troopunits.getText(), 130, 135);

      g.drawString(name.getText().toString(), 65, 160);

    } catch (Exception e) {
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

    jPanel1 = new javax.swing.JPanel();
    batts = new javax.swing.JLabel();
    sdbs = new javax.swing.JLabel();
    atmo = new javax.swing.JLabel();
    zone = new javax.swing.JLabel();
    bases = new javax.swing.JLabel();
    tl = new javax.swing.JLabel();
    sp = new javax.swing.JLabel();
    name = new javax.swing.JLabel();
    h2o = new javax.swing.JLabel();
    go = new javax.swing.JButton();
    jPanel3 = new javax.swing.JPanel();
    jLabel37 = new javax.swing.JLabel();
    UWP = new javax.swing.JLabel();
    jLabel36 = new javax.swing.JLabel();
    jLabel40 = new javax.swing.JLabel();
    jLabel41 = new javax.swing.JLabel();
    jLabel42 = new javax.swing.JLabel();
    sdbs1 = new javax.swing.JLabel();
    squadrons = new javax.swing.JLabel();
    defbats = new javax.swing.JLabel();
    troopunits = new javax.swing.JLabel();

    setForeground(new java.awt.Color(255, 255, 255));
    setOpaque(true);
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        formMouseClicked(evt);
      }
    });

    jPanel1.setOpaque(false);

    batts.setForeground(new java.awt.Color(255, 0, 0));
    batts.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    batts.setText("20000");
    batts.setToolTipText("Defence Battalions");

    sdbs.setForeground(new java.awt.Color(255, 0, 0));
    sdbs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    sdbs.setText("2000");
    sdbs.setToolTipText("SDBs");

    atmo.setForeground(new java.awt.Color(255, 0, 0));
    atmo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    atmo.setText("Normal");
    atmo.setToolTipText("Atmosphere Type");
    atmo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

    zone.setForeground(new java.awt.Color(255, 0, 0));
    zone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    zone.setText("Red");
    zone.setToolTipText("Travel Zone");

    bases.setForeground(new java.awt.Color(255, 0, 0));
    bases.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    bases.setText("2");
    bases.setToolTipText("Bases");

    tl.setForeground(new java.awt.Color(255, 0, 0));
    tl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    tl.setText("15");
    tl.setToolTipText("TL");

    sp.setForeground(new java.awt.Color(255, 0, 0));
    sp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    sp.setText("A");
    sp.setToolTipText("StarPort");

    name.setForeground(new java.awt.Color(255, 0, 0));
    name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    name.setText("Name");
    name.setToolTipText("System Name");

    h2o.setForeground(new java.awt.Color(255, 0, 0));
    h2o.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    h2o.setText("H2O");
    h2o.setToolTipText("Water presence");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(sp)
              .addComponent(sdbs))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(name)
              .addComponent(h2o)
              .addComponent(bases)))
          .addComponent(zone))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(batts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addComponent(atmo, javax.swing.GroupLayout.Alignment.TRAILING))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(zone)
          .addComponent(atmo))
        .addGap(13, 13, 13)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(sp)
          .addComponent(bases)
          .addComponent(tl))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(sdbs)
          .addComponent(h2o)
          .addComponent(batts))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(name))
    );

    go.setText("GO");
    go.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        goActionPerformed(evt);
      }
    });

    jPanel3.setOpaque(false);

    jLabel37.setForeground(new java.awt.Color(255, 0, 0));
    jLabel37.setText("UWP");
    jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel37MouseClicked(evt);
      }
    });

    UWP.setForeground(new java.awt.Color(255, 0, 0));
    UWP.setText("A569ABBD-F9D4");
    UWP.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        UWPMouseClicked(evt);
      }
    });
    UWP.addInputMethodListener(new java.awt.event.InputMethodListener() {
      public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
      }
      public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
        UWPInputMethodTextChanged(evt);
      }
    });
    UWP.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        UWPPropertyChange(evt);
      }
    });

    jLabel36.setForeground(new java.awt.Color(255, 0, 0));
    jLabel36.setText("SDB Squadrons");
    jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel36MouseClicked(evt);
      }
    });

    jLabel40.setForeground(new java.awt.Color(255, 0, 0));
    jLabel40.setText("Squadron pts");
    jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel40MouseClicked(evt);
      }
    });

    jLabel41.setForeground(new java.awt.Color(255, 0, 0));
    jLabel41.setText("Def. Batt. CF");
    jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel41MouseClicked(evt);
      }
    });

    jLabel42.setForeground(new java.awt.Color(255, 0, 0));
    jLabel42.setText("Troop Points");
    jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel42MouseClicked(evt);
      }
    });

    sdbs1.setForeground(new java.awt.Color(255, 0, 0));
    sdbs1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    sdbs1.setText("0");

    squadrons.setForeground(new java.awt.Color(255, 0, 0));
    squadrons.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    squadrons.setText("0");

    defbats.setForeground(new java.awt.Color(255, 0, 0));
    defbats.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    defbats.setText("0");

    troopunits.setForeground(new java.awt.Color(255, 0, 0));
    troopunits.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    troopunits.setText("0");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel40)
              .addComponent(jLabel36)
              .addComponent(jLabel42)
              .addComponent(jLabel41))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(sdbs1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(troopunits, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addComponent(defbats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(squadrons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(7, 7, 7)
            .addComponent(jLabel37)
            .addGap(5, 5, 5)
            .addComponent(UWP))))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel37)
          .addComponent(UWP))
        .addGap(0, 0, 0)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel36)
          .addComponent(sdbs1))
        .addGap(0, 0, 0)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(squadrons)
          .addComponent(jLabel40))
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel41)
          .addComponent(defbats))
        .addGap(0, 0, 0)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel42)
          .addComponent(troopunits)))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(go)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(155, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(200, 200, 200)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(go)
          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(15, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void goActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goActionPerformed
    jLabel37MouseClicked(me);
    updater();
    switch (zone.getText().toLowerCase().substring(0, 1)) {
      case "r": {
//        jPanel2.setBackground(Color.LIGHT_GRAY);
        break;
      }
      case "a": {
//        jPanel2.setBackground(Color.orange);
        break;
      }
      case "":
      case "g": {
//        jPanel2.setBackground(Color.green);
        break;
      }
    }
    switch (atmo.getText().toLowerCase().substring(0, 1)) {
      case "":
      case "n": {
//        jLabel1.setBackground(Color.cyan);
        break;
      }
      case "t": {
//        jLabel1.setBackground(Color.darkGray);
        break;
      }
      case "v": {
//        jLabel1.setBackground(Color.white);
        break;
      }
    }
//    g = jLabel1.getGraphics();
    g2 = (Graphics2D) g;
    //super.paintComponent(g);

//    g.setColor(Color.gray);
//    g.drawString("SP", 10, 15);
//    g.drawString("Base", 50, 15);
//    g.drawString("TL", 85, 15);
//
//    g.setColor(Color.black);
//    g.drawString(sp.getText().toString(), 10, 30);
//    g.drawString(bases.getText().toString(), 50, 30);
//    g.drawString(tl.getText().toString(), 85, 30);
//
//    g.setColor(Color.gray);
//    g.drawString("SDBs", 10, 50);
//    g.drawString("H20", 50, 50);
//    g.drawString("DEF CF", 80, 50);
//
//    g.setColor(Color.black);
//    g.drawString(sdbs.getText().toString(), 10, 65);
//    String w;
//    if (GlobalMethods.fromHex(getHy()) > 1) {
//      w = "Y";
//    } else {
//      w = "N";
//    }
//    g.drawString(w, 50, 65);
//    g.drawString(batts.getText().toString(), 80, 65);
//
//    g.setColor(Color.gray);
//    g.drawString("Max Rons", 10, 85);
//    g.drawString("", 50, 85);
//    g.drawString("Troops", 80, 85);
//
//    g.setColor(Color.black);
//    g.drawString(squadrons.getText(), 10, 100);
//    g.drawString("", 50, 100);
//    g.drawString(troopunits.getText(), 80, 100);
//
//    g.drawString(name.getText().toString(), 10, 120);
//    try {
//      Panel4SubSector.sdbs1.setText(sdbs.getText());
//      Panel4SubSector.squadrons.setText(squadrons.getText());
//      Panel4SubSector.defbats.setText(defbats.getText());
//      Panel4SubSector.troopunits.setText(troopunits.getText());
//    } catch (Exception e) {
//      System.out.println("Error" + " = " + e);
//    }
  }//GEN-LAST:event_goActionPerformed

  private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
    //    try {
    //      Panel4UTP.setHeight(300);
    //      Panel4UTP.setTop(300);
    //    } catch (Exception e) {
    //    }
    //    try {
    //      String TROOPUNITS = "0";
    ////      troopunits.setText(TROOPUNITS);
    //      int u, p;
    ////      t = globals.GlobalMethods.fromHex(jLabel27.getText());
    ////      p = globals.GlobalMethods.fromHex(jLabel38.getText());
    //      u = Integer.parseInt(Panel4Squadron.jLabel27.getText());
    //      p = Integer.parseInt(Panel4Squadron.jLabel38.getText());
    //      if (u > 6 & p > 6) {
    ////        System.out.println("getFromTable(10, " + getPop() + ", " + getTL()
    ////                + ")" + " = " + getFromTable(10, getPop(), getTL()));
    //        TROOPUNITS = getFromTable(10, Panel4Squadron.getpop(), Panel4Squadron.getTecL());
    //      }
    //    } catch (Exception e) {
    //      System.out.println("TROOPUNITS error" + " = " + e);
    //    }

    if (GlobalMethods.fromHex(Panel4Squadron.getpop()) > 6
      & GlobalMethods.fromHex(Panel4Squadron.getTecL()) > 6) {
      String TROOPUNITS;
      String pop = "";
      String tech = "";
      pop = UWP.getText().substring(4, 5);
      tech = UWP.getText().substring(7, 8);
      System.out.println("pop" + " = " + pop);
      System.out.println("tech" + " = " + tech);
      try {
        TROOPUNITS = Panel4Squadron.getFromTable(10, pop, tech);
      } catch (Exception e) {
        TROOPUNITS = "0";
        System.out.println("TROOPUNITS error" + " = " + e);
      }
      System.out.println("TROOPUNITS" + " = " + TROOPUNITS);
      troopunits.setText(TROOPUNITS);
      //jLabel22MouseClicked(evt);
    }
  }//GEN-LAST:event_jLabel42MouseClicked

  private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
    if (GlobalMethods.fromHex(Panel4Squadron.getpop()) > 5
      & GlobalMethods.fromHex(Panel4Squadron.getTecL()) > 5) {
      table = GlobalVariables.tables[8];
      Panel4Squadron.printTable("SDBs", table);
      String DEFENCEBATTS;
      String pop = "";
      String tech = "";
      pop = UWP.getText().substring(4, 5);
      tech = UWP.getText().substring(7, 8);
      System.out.println("pop" + " = " + pop);
      System.out.println("tech" + " = " + tech);
      try {
        DEFENCEBATTS = Panel4Squadron.getFromTable(8, pop, tech);
      } catch (Exception e) {
        DEFENCEBATTS = "0";
        System.out.println("DEFENCEBATTS error" + " = " + e);
      }
      System.out.println("DEFENCEBATTS" + " = " + DEFENCEBATTS);
      batts.setText(DEFENCEBATTS);
      defbats.setText(DEFENCEBATTS);
    }
  }//GEN-LAST:event_jLabel41MouseClicked

  private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
    //    try {
    //      Panel4Squadron.worldupdate("SQUADRON");
    //    } catch (Exception e) {
    //      System.out.println("SQUADRON error" + " = " + e);
    //    }
    //      case "SQUADRONS": {
    if (GlobalMethods.fromHex(Panel4Squadron.getTecL()) > 8 & GlobalMethods
      .fromHex(Panel4Squadron.getpop()) > 6) {
      table = GlobalVariables.tables[7];
      Panel4Squadron.printTable("Ships", table);
      String SQUADRON = null;
      String sdbs0 = "";
      String tech = "";
      sdbs0 = sdbs.getText();
      tech = UWP.getText().substring(7, 8);
      System.out.println("sdbs0" + " = " + sdbs0);
      System.out.println("tech" + " = " + tech);
      try {
        SQUADRON = Panel4Squadron.getFromTable(7, tech, sdbs0);
      } catch (Exception e) {
        SQUADRON = "0";
        System.out.println("SQUADRON error" + " = " + e);
      }
      System.out.println("SQUADRON" + " = " + SQUADRON);
      squadrons.setText(SQUADRON);
    }
  }//GEN-LAST:event_jLabel40MouseClicked

  private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
    if (GlobalMethods.fromHex(Panel4Squadron.getpop()) > 6
      & GlobalMethods.fromHex(Panel4Squadron.getTecL()) > 6) {
      String SDBs = null;
      String pop = "";
      String tech = "";
      table = GlobalVariables.tables[2];
      Panel4Squadron.printTable("SDBs", table);
      System.out.println("UWP.getText()" + " = " + UWP.getText());
      pop = UWP.getText().substring(4, 5);
      tech = UWP.getText().substring(7, 8);
      System.out.println("pop" + " = " + pop);
      System.out.println("tech" + " = " + tech);
      try {
        SDBs = Panel4Squadron.getFromTable(2, pop, tech);
        System.out.println("SDBs" + " = " + SDBs);
      } catch (Exception e) {
        //SDBs = "0";
        System.out.println("SDB error" + " = " + e);
        System.out.println("SDBs" + " = " + SDBs);
      }
      System.out.println("SDBs" + " = " + SDBs);
      sdbs.setText(SDBs);
      sdbs1.setText(SDBs);
    }
  }//GEN-LAST:event_jLabel36MouseClicked

  private void UWPPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_UWPPropertyChange
    updater();
  }//GEN-LAST:event_UWPPropertyChange

  private void UWPInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_UWPInputMethodTextChanged
    updater();
  }//GEN-LAST:event_UWPInputMethodTextChanged

  private void UWPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UWPMouseClicked
    updater();
  }//GEN-LAST:event_UWPMouseClicked

  private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
    try {
      jLabel36MouseClicked(evt);
    } catch (Exception e) {
      System.out.println("" + " = " + e.toString());
    }
    try {
      jLabel40MouseClicked(evt);
    } catch (Exception e) {
      System.out.println("" + " = " + e.toString());
    }
    try {
      jLabel41MouseClicked(evt);
    } catch (Exception e) {
      System.out.println("" + " = " + e.toString());
    }
    try {
      jLabel42MouseClicked(evt);
    } catch (Exception e) {
      System.out.println("" + " = " + e.toString());
    }
    //    worldUpdate();
  }//GEN-LAST:event_jLabel37MouseClicked

  private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    sub2Pic();
  }//GEN-LAST:event_formMouseClicked
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private static javax.swing.JLabel UWP;
  static javax.swing.JLabel atmo;
  static javax.swing.JLabel bases;
  private javax.swing.JLabel batts;
  private static javax.swing.JLabel defbats;
  public static javax.swing.JButton go;
  private javax.swing.JLabel h2o;
  private static javax.swing.JLabel jLabel36;
  private static javax.swing.JLabel jLabel37;
  private static javax.swing.JLabel jLabel40;
  private static javax.swing.JLabel jLabel41;
  private static javax.swing.JLabel jLabel42;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel3;
  static javax.swing.JLabel name;
  private javax.swing.JLabel sdbs;
  private static javax.swing.JLabel sdbs1;
  static javax.swing.JLabel sp;
  private static javax.swing.JLabel squadrons;
  static javax.swing.JLabel tl;
  private static javax.swing.JLabel troopunits;
  static javax.swing.JLabel zone;
  // End of variables declaration//GEN-END:variables

  static void updater() {
    try {
      name.setText(Panel4SubSector.jList1.getSelectedValue().toString());
      jf.setTitle(name.getText());// + " World Box");
      UWP.setText(Panel4SubSector.UWP.getText());
      zone.setText(Panel4SubSector.jcb4Zone.getSelectedItem().toString());
      switch (Panel4SubSector.jcb4Zone.getSelectedItem().toString()
        .toLowerCase()) {
        case "a": {
          zone.setText("Amber");
          break;
        }
        case "r": {
          zone.setText("Red");
          break;
        }
        default: {
          zone.setText("Green");
          break;
        }

      }
      switch (Panel4SubSector.UWP.getText().substring(2, 3)) {
        case "0":
        case "1": {
          atmo.setText("Vaccuum");
          break;
        }
        case "5":
        case "6":
        case "8": {
          atmo.setText("Normal");
          break;
        }
        default: {
          atmo.setText("Tainted");
          break;
        }
      }
      sp.setText(Panel4SubSector.UWP.getText().substring(0, 1));
      tl.setText(Panel4SubSector.UWP.getText().substring(7, 8));
      bases.setText(Panel4SubSector.jcb4Bases.getSelectedItem().toString());
    } catch (NullPointerException e) {
      System.out.println("e" + " = " + e);
    }
  }

  @Override
  public String getUWP() {
    return Panel4SubSector.UWP.getText();
  }

  @Override
  public String getSp() {
    return Panel4SubSector.UWP.getText().substring(0, 1);
  }

  @Override
  public String getSi() {
    return Panel4SubSector.UWP.getText().substring(1, 2);
  }

  @Override
  public String getAt() {
    return Panel4SubSector.UWP.getText().substring(2, 3);
  }

  @Override
  public String getHy() {
    try {
      return Panel4SubSector.UWP.getText().substring(3, 4);
    } catch (Exception e) {
      return UWP.getText().substring(3, 4);
    }
  }

  @Override
  public String getPo() {
    try {
      return Panel4SubSector.UWP.getText().substring(4, 5);
    } catch (Exception e) {
      return UWP.getText().substring(3, 4);
    }
    //return Panel4SubSector.UWP.getText().substring(4, 5);
  }

  @Override
  public String getGo() {
    return Panel4SubSector.UWP.getText().substring(5, 6);
  }

  @Override
  public String getLl() {
    return Panel4SubSector.UWP.getText().substring(6, 7);
  }

//  @Override
  public String getTl() {
    return Panel4SubSector.UWP.getText().substring(7, 8);
  }

  @Override
  public String getHex() {
    return name.getText().substring(0, 4);
  }

  @Override
  public String getSector() {
    try {
      return Panel4Locator.getSectorName();
    } catch (Exception ex) {
      Logger.getLogger(Panel4World.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  @Override
  public String getSubSector() {
    return Panel4Locator.getSubSectorName();
  }

  @Override
  public String getSystem() {
    return Panel4Locator.getSystem();
  }

  static void sub2Pic() {
    updater();
    File f = new File(Panel4Locator.getPath() + FS + jf.getTitle()
      + " World Box.gif");
    System.out.println(f.toString());
    BufferedImage bi;
    try {
      bi = ImageIO.read(f);
    } catch (IOException ex) {
      bi = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
    }
    g = bi.createGraphics();
    switch (zone.getText().toLowerCase().substring(0, 1)) {
      case "r": {
        g.setColor(Color.LIGHT_GRAY);
        break;
      }
      case "a": {
        g.setColor(Color.orange);
        break;
      }
      case "g":
      case "": {
        g.setColor(Color.green);
        break;
      }
    }
    g.fillRect(0, 0, 200, 200);
    switch (atmo.getText().toLowerCase()) {
      case "normal": {
        g.setColor(Color.cyan);
        break;
      }
      case "tainted": {
        g.setColor(Color.darkGray);
        break;
      }
      case "vaccuum": {
        g.setColor(Color.white);
        break;
      }
    }
    g.fillRect(25, 25, 150, 150);
    try {
      g.setColor(Color.gray);
      g.drawString("SP", 35, 40);
      g.drawString("Base", 85, 40);
      g.drawString("TL", 140, 40);
      g.setColor(Color.black);
      g.drawString(sp.getText().toString(), 35, 55);
      g.drawString(bases.getText().toString(), 85, 55);
      g.drawString(tl.getText().toString(), 140, 55);
      g.setColor(Color.gray);
      g.drawString("SDBs", 35, 80);
      g.drawString("H20", 85, 80);
      g.drawString("DEF CF", 130, 80);
      g.setColor(Color.black);
      g.drawString(Panel4SubSector.sdbs1.getText().toString(), 35, 95);
      String w;
      if (GlobalMethods.fromHex(Panel4SubSector.UWP.getText().substring(3, 4))
        > 1) {
        w = "Y";
      } else {
        w = "N";
      }
      g.drawString(w, 95, 95);
      g.drawString(Panel4SubSector.defbats.getText().toString(), 130, 95);
      g.setColor(Color.gray);
      g.drawString("Max Rons", 35, 120);
      g.drawString("", 85, 120);
      g.drawString("Troops", 130, 120);
      g.setColor(Color.black);
      g.drawString(Panel4SubSector.squadrons.getText(), 35, 135);
      g.drawString("", 50, 100);
      g.drawString(Panel4SubSector.troopunits.getText(), 130, 135);
      g.drawString(name.getText().toString(), 65, 160);

    } catch (Exception e) {
    }

    try {
      ImageIO.write(bi, "gif", f);
    } catch (IOException ex1) {
      Logger.getLogger(Panel4World.class.getName())
        .log(Level.SEVERE, null, ex1);
    }
  }

  @Override
  public String getZone() {
    return "getZone";
  }
}
