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

import dbviewer.JumpCalc;
import dbviewer.globals.GlobalMethods;
import dbviewer.globals.GlobalVariables;
import static dbviewer.globals.GlobalVariables.T5;
import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 <p>
 @author maggot
 */
public class Panel4Locator extends Panel4 {

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    //DBViewer.main(args);
    new Panel4Imperium();
  }
  /**
   sectors
   */
  public static String[] sectors;
  /**
   part
   */
  public static String[] part;
  /**
   worlds
   */
  public static String[] worlds;
  static int i;
  /**
   prevpanel
   */
  public static String prevpanel;

  /**
   <p>
   @return file path
   */
  public static String getPath() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    String folder = "";
    try {
      folder = "" + GlobalVariables.IMP + GlobalVariables.FS
        + getSectorName().toString().substring(0, 4).toUpperCase()
        + GlobalVariables.FS
        + getSubSectorName().toString() + GlobalVariables.FS;
      //JOptionPane.showMessageDialog(Panel4SubSector.jComboBox19, folder);
    } catch (Exception e) {
      folder = "" + GlobalVariables.BMP;
    }
    return folder;
  }

  /**
   <p>
   @return active sector
   */
  public static String getSector() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    if (getJcb4Sector() != null) {
      return getJcb4Sector().getSelectedItem().toString();
    } else {
      return "";
    }
//    return getJcb4Sector().getSelectedItem().toString();
  }

  /**
   <p>
   @return active subsector
   */
  public static String getSubSector() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    try {
      if (getJcb4SubSector().getSelectedIndex() != -1) {
        return getJcb4SubSector().getSelectedItem().toString();
      } else {
        return "";
      }
    } catch (Exception e) {
    }
    return "";
  }

  /**
   <p>
   @return active system
   */
  public static String getSystem() {
    try {
      if (getJcb4SubSector().getSelectedIndex() != -1) {
        return getJcb4System().getSelectedItem().toString();
      } else {
        return "unset";
      }
    } catch (Exception e) {
    }
    return null;
  }

  /**
   <p>
   @param x      X coords
   @param y      Y coords
   @param sector or subsector
   @return all neighbours on border
   */
  public static String[] getNeighbours(int x, int y, boolean sector) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    String[] strings = new String[9];
    String f;
    if (sector == true) {
      //<editor-fold defaultstate="collapsed" desc="sector">
      f = T5 + "/CSV/uwp-sector";
      int secx = Integer.parseInt(Panel4Locator.getXnum().getText());
      int secy = Integer.parseInt(Panel4Locator.getYnum().getText());
//      ////System.out.print("secx" + " = " + secx);
//      ////System.out.print("secy" + " = " + secy);
      ////System.out.print("" + jcb4Sector.getSelectedItem().toString() + " = "
//              + "Sector " + x + "," + y);
      int replyX = x;
      int replyY = y;
      strings[0] = findSector(replyX, replyY) + "," + replyX + "," + replyY;//MM
      replyX = x - 1;
      replyY = y + 1;
      strings[1] = findSector(replyX, replyY) + "," + replyX + "," + replyY;//LT
      replyX = x;
      replyY = y + 1;
      strings[2] = findSector(replyX, replyY) + "," + replyX + "," + replyY;//MT
      replyX = x + 1;
      replyY = y + 1;
      strings[3] = findSector(replyX, replyY) + "," + replyX + "," + replyY;//RT
      replyX = x - 1;
      replyY = y;
      strings[4] = findSector(replyX, replyY) + "," + replyX + "," + replyY;//LM
      replyX = x + 1;
      replyY = y;
      strings[5] = findSector(replyX, replyY) + "," + replyX + "," + replyY;//RM
      replyX = x - 1;
      replyY = y - 1;
      strings[6] = findSector(replyX, replyY) + "," + replyX + "," + replyY;//LB
      replyX = x;
      replyY = y - 1;
      strings[7] = findSector(replyX, replyY) + "," + replyX + "," + replyY;//MB
      replyX = x + 1;
      replyY = y - 1;
      strings[8] = findSector(replyX, replyY) + "," + replyX + "," + replyY;//RB
      for (int i = 0; i < strings.length; i++) {
        String[] segments = strings[i].split(",");
        ////System.out.print("" + i + " = " + segments[0] + ", " + segments[1] + ", " + segments[2]);
        try {
          //now search for subs[1] and subs[2] on line in file, take dim[0] from
          //line and place in subs[0], found at sub[2] and sub [3] of file
          String line;
          BufferedReader in = new BufferedReader(new FileReader(f));
          try {
            while ((line = in.readLine()) != null) {
              String[] parts = line.split(",");
            }
            in.close();
          } catch (IOException ex) {
            Logger.getLogger(Panel4Locator.class.getName()).log(Level.SEVERE,
              null, ex);
          }
        } catch (FileNotFoundException ex) {
          Logger.getLogger(Panel4Locator.class.getName())
            .log(Level.SEVERE, null, ex);
        }
      }

      //</editor-fold>
    } else {
      //<editor-fold defaultstate="collapsed" desc="subsector">
      f = T5 + "/CSV/uwp-subsec";
      ////System.out.print("" + x + "," + y + " = " + Panel4Imperium.subs[y][x]);
      int replyX = 0;
      int replyY = 0;
      for (int i = 0; i < strings.length; i++) {
        switch (i) {
          case 0:
            replyX = x;
            replyY = y;
            strings[0] = "MidMid, " + replyX + "," + replyY;//MidMid,
            break;
          case 1:
            replyX = x - 1;
            replyY = y - 1;
            strings[1] = "LeftTop, " + replyX + "," + replyY;//LeftTop,
            break;
          case 2:
            replyX = x;
            replyY = y - 1;
            strings[2] = "MidTop, " + replyX + "," + replyY;//MidTop,
            break;
          case 3:
            replyX = x + 1;
            replyY = y - 1;
            strings[3] = "RightTop, " + replyX + "," + replyY;//RightTop,
            break;
          case 4:
            replyX = x - 1;
            replyY = y;
            strings[4] = "LeftMid, " + replyX + "," + replyY;//LeftMid,
            break;
          case 5:
            replyX = x + 1;
            replyY = y;
            strings[5] = "RightMid, " + replyX + "," + replyY;//RightMid,
            break;
          case 6:
            replyX = x - 1;
            replyY = y + 1;
            strings[6] = "LeftBottom, " + replyX + "," + replyY;//LeftBottom,
            break;
          case 7:
            replyX = x;
            replyY = y + 1;
            strings[7] = "MidBottom, " + replyX + "," + replyY;//MidBottom,
            break;
          case 8:
            replyX = x + 1;
            replyY = y + 1;
            strings[8] = "RightBottom, " + replyX + "," + replyY;//RightBottom,
            break;
        }
        if ((replyX < 0) | (replyX > 5) | (replyY < 0) | (replyY > 5)) {
          ////System.out.print("" + i + " = ---OFF MAP---, " + strings[i]);
          //Read another sector for its subsectors
        } else {
          String letter = Panel4Imperium.subs[replyY][replyX];
          ////System.out.print("" + i + " = " + strings[i] + " = " + letter);
        }
      }
      //</editor-fold>
    }

    return strings;
  }

  /**
   <p>
   @param replyX Sector X coords
   @param replyY Sector Y coords
   @return sector
   */
  public static String findSector(int replyX, int replyY) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    File f = new File(T5 + "/CSV/uwp-sector");
    String[] parts = null;
    try {
      BufferedReader in = new BufferedReader(new FileReader(f));
      String line;
      try {
        while ((line = in.readLine()) != null) {
          parts = line.split("\",\"");
          if (!"X".equals(parts[2])) {
            if ((replyX == Integer.parseInt(parts[2])) & ((replyY == Integer
              .parseInt(parts[3])))) {
//              ////System.out.print("" + parts[0].substring(1));
              break;
            }
          }
        }
        in.close();
      } catch (IOException ex) {
        Logger.getLogger(Panel4Locator.class.getName()).log(Level.SEVERE, null,
          ex);
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Panel4Locator.class.getName())
        .log(Level.SEVERE, null, ex);
    }
    return parts[0].substring(1);
  }

  /**
   <p>
   @return name of subsector
   */
  public static String getSubSectorName() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    return getSubSector();
  }

  static String getSectorName(String string, String string0) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    string = string.replace(" ", "");
    string0 = string0.replace(" ", "");
    int x = Integer.parseInt(string);
    int y = Integer.parseInt(string0);
    return findSector(x, y);
  }

  /**
   <p>
   @param system to set as System
   */
  public static void setSystem(String system) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    for (int j = 0; j < Panel4SubSector.jList1.getModel().getSize(); j++) {
      jcb4System.getModel().setSelectedItem(Panel4SubSector.jList1
        .getSelectedIndex());
    }
  }

  @SuppressWarnings("unchecked")
  static void setTopLeft(String topleft) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
    dcbm.addElement(topleft);
    jcb4System.setModel(dcbm);

  }
  private String CRLF = GlobalVariables.CRLF;

  /**
   Creates new form Locator
   */
  public Panel4Locator() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    dbviewer.JumpCalc.setJumps();
    initComponents();
//    jcb4Sector.setEnabled(false);
//    jcb4SubSector.setEnabled(false);
//    jcb4System.setEnabled(false);
  }

  /**
   <p>
   @return ComboBox with item selected, but not added
   */
  public static JComboBox getJcb4Sector() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    ////System.out.print("" + " = " + jcb4Sector);
    return jcb4Sector;
  }

  /**
   <p>
   @return subsector combo
   */
  public static JComboBox getJcb4SubSector() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    return jcb4SubSector;
  }

  /**
   <p>
   @return sec/sub/sys
   */
  @Override
  public String toString() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    return getSector() + "/" + getSubSector() + "/" + getSystem();
  }

  /**
   <p>
   @return system combo
   */
  public static JComboBox getJcb4System() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    return jcb4System;
  }

  /**
   <p>
   @return sector name
   @throws java.lang.Exception fuck up
   */
  public static String getSectorName() throws Exception {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    try {
      return Panel4Locator.jcb4Sector.getSelectedItem().toString();
    } catch (Exception e) {
      throw new Exception();
//      return "Spinward marches";
    }
//    return "";
  }

  /**
   <p>
   @return sectors across
   */
  public static JLabel getXnum() {
    return Xnum;
  }

  /**
   <p>
   @return sectors down
   */
  public static JLabel getYnum() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    return Ynum;
  }

  /**
   <p>
   @param sectors JComboBox to set Jcb4Sector
   */
  public static void setJcb4Sector(JComboBox sectors) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    Panel4Locator.jcb4Sector = sectors;
  }

  /**
   <p>
   @param cbm DefaultComboBoxModel to set Model4Sector
   */
  @SuppressWarnings("unchecked")
  public static void setModel4Sector(DefaultComboBoxModel<String> cbm) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    Panel4Locator.jcb4Sector.setModel(cbm);
  }

  /**
   <p>
   @param subsectors to set Jcb4SubSector
   */
  public void setJcb4SubSector(JComboBox<String> subsectors) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    Panel4Locator.jcb4SubSector = subsectors;
  }

  /**
   <p>
   @param dcbm setModel4SubSector DefaultComboBoxModel
   */
  @SuppressWarnings("unchecked")
  public static void setModel4SubSector(DefaultComboBoxModel<String> dcbm) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    Panel4Locator.jcb4SubSector.setModel(dcbm);
  }

  /**
   <p>
   @param systems JComboBox to set
   */
  public static void setJcb4System(JComboBox<String> systems) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    Panel4Locator.jcb4System = systems;
  }

  /**
   <p>
   @param cbm DefaultComboBoxModel for setModel4Systems()
   */
  @SuppressWarnings("unchecked")
  public static void setModel4Systems(DefaultComboBoxModel<String> cbm) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    Panel4Locator.jcb4System.setModel(cbm);
  }

  /**
   <p>
   @param string number to set Xnum
   */
  public static void setXnum(String string) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    Panel4Locator.Xnum.setText(string);
  }

  /**
   <p>
   @param string number to set Ynum
   */
  public static void setYnum(String string) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    Panel4Locator.Ynum.setText(string);
  }

//  @Override
  /**
   <p>
   @return path of mainworld
   */
  public static String getString() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    return getSector() + "/" + getSubSector() + "/" + getSystem();
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jcb4Sector = new javax.swing.JComboBox();
    Xlab = new javax.swing.JLabel();
    Xnum = new javax.swing.JLabel();
    Ylab = new javax.swing.JLabel();
    Ynum = new javax.swing.JLabel();
    jcb4SubSector = new javax.swing.JComboBox();
    jcb4System = new javax.swing.JComboBox();
    jButton1 = new javax.swing.JButton();

    setOpaque(false);

    jcb4Sector.setForeground(java.awt.Color.lightGray);
    jcb4Sector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "test" }));
    jcb4Sector.setBorder(null);
    jcb4Sector.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcb4SectorActionPerformed(evt);
      }
    });

    Xlab.setForeground(java.awt.Color.lightGray);
    Xlab.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    Xlab.setText("X");
    Xlab.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    Xlab.setIconTextGap(0);
    Xlab.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        XnumMouseClicked(evt);
      }
    });

    Xnum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    Xnum.setForeground(java.awt.Color.lightGray);
    Xnum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    Xnum.setText("0");
    Xnum.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    Xnum.setIconTextGap(0);
    Xnum.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        XnumMouseClicked(evt);
      }
    });

    Ylab.setForeground(java.awt.Color.lightGray);
    Ylab.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    Ylab.setText("Y");
    Ylab.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    Ylab.setIconTextGap(0);
    Ylab.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        XnumMouseClicked(evt);
      }
    });

    Ynum.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    Ynum.setForeground(java.awt.Color.lightGray);
    Ynum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    Ynum.setText("0");
    Ynum.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    Ynum.setIconTextGap(0);
    Ynum.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        XnumMouseClicked(evt);
      }
    });

    jcb4SubSector.setForeground(java.awt.Color.lightGray);
    jcb4SubSector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "test" }));
    jcb4SubSector.setBorder(null);
    jcb4SubSector.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        jcb4SubSectorItemStateChanged(evt);
      }
    });
    jcb4SubSector.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcb4SubSectorActionPerformed(evt);
      }
    });
    jcb4SubSector.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jcb4SubSectorPropertyChange(evt);
      }
    });

    jcb4System.setForeground(java.awt.Color.lightGray);
    jcb4System.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0101" }));
    jcb4System.setBorder(null);
    jcb4System.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        jcb4SystemItemStateChanged(evt);
      }
    });
    jcb4System.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcb4SystemActionPerformed(evt);
      }
    });

    jButton1.setText("<");
    jButton1.setToolTipText("BACK");
    jButton1.setEnabled(false);
    jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jButtonMouseClicked(evt);
      }
    });
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jcb4Sector, 0, 107, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(Xlab)
        .addGap(1, 1, 1)
        .addComponent(Xnum)
        .addGap(1, 1, 1)
        .addComponent(Ylab)
        .addGap(1, 1, 1)
        .addComponent(Ynum)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jcb4SubSector, 0, 109, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jcb4System, 0, 112, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
        .addComponent(jcb4SubSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(Ylab)
        .addComponent(Ynum)
        .addComponent(Xnum)
        .addComponent(Xlab)
        .addComponent(jcb4System, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jcb4Sector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addComponent(jButton1))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jcb4SubSectorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb4SubSectorItemStateChanged
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
//    jcb4SystemItemStateChanged(evt);
//    jcb4System.setSelectedIndex(Panel4SubSector.jList1.getSelectedIndex());
  }//GEN-LAST:event_jcb4SubSectorItemStateChanged

  private void jButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    if (jButton1.isEnabled()) {
      ////System.out.print("" + " = " + prevpanel);
      if ("p4i".equals(prevpanel)) {
        Panel4Imperium.jsp.setVisible(true);
        Panel4Imperium.p4j.setVisible(false);
        Panel4Locator.prevpanel = "p4i";
      }
      if ("p4j".equals(prevpanel)) {
        Panel4Imperium.jsp.setVisible(false);
        Panel4Imperium.p4j.setVisible(true);
        Panel4Imperium.p4s.setVisible(false);
        Panel4Locator.prevpanel = "p4i";
      }
      if ("p4s".equals(prevpanel)) {
//        Panel4Imperium.jsp.setVisible(false);
        Panel4Imperium.p4j.setVisible(true);
        Panel4Imperium.p4s.setVisible(false);
        Panel4Locator.prevpanel = "p4j";
      }

    }
//    DefaultListModel dlm = new DefaultListModel();
//    int size = Panel4SubSector.jList2.getModel().getSize();
//    String [] bits = new String[size];
//    for (int j = 0; j < size; j++) {
//      bits[j] = Panel4SubSector.jList2.getModel().getElementAt(j).toString();
//    }
//    Arrays.sort(bits);
//    for (int j = 0; j < size; j++) {
//      dlm.addElement(bits[j]);
//    }
//    Panel4SubSector.jList2.setModel(dlm);

  }//GEN-LAST:event_jButtonMouseClicked

  private void jcb4SystemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb4SystemItemStateChanged
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    if (evt.getStateChange() == ItemEvent.SELECTED) {
      String arg = jcb4System.getSelectedItem().toString();
      search4World(arg);
      JumpCalc jumpCalc = new dbviewer.JumpCalc(arg, Panel4SubSector.jSlider1
        .getValue());
      Panel4SubSector.jButton1.doClick();
    }
  }//GEN-LAST:event_jcb4SystemItemStateChanged

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
  }//GEN-LAST:event_jButton1ActionPerformed

    private void XnumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XnumMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    listNeighbours(Xnum.getText(), Ynum.getText());
    }//GEN-LAST:event_XnumMouseClicked

  private void jcb4SectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb4SectorActionPerformed
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    File f = new File(T5 + "/CSV/uwp-subsec");
    loadSubs(f);
  }//GEN-LAST:event_jcb4SectorActionPerformed

  private void jcb4SubSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb4SubSectorActionPerformed
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    File f = new File(T5 + "/CSV/uwp-worlds");
    loadSys(f);

//    jcb4System.setSelectedIndex(0);
  }//GEN-LAST:event_jcb4SubSectorActionPerformed

  private void jcb4SystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb4SystemActionPerformed
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    Panel4Neighbours.showInfo();
  }//GEN-LAST:event_jcb4SystemActionPerformed

  private void jcb4SubSectorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcb4SubSectorPropertyChange
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    System.out.println("jcb4SubSectorPropertyChange(" + evt + ")");
//    jcb4System.setSelectedIndex(0);
  }//GEN-LAST:event_jcb4SubSectorPropertyChange
  // Variables declaration - do not modify//GEN-BEGIN:variables
  public static javax.swing.JLabel Xlab;
  public static javax.swing.JLabel Xnum;
  public static javax.swing.JLabel Ylab;
  public static javax.swing.JLabel Ynum;
  public static javax.swing.JButton jButton1;
  public static javax.swing.JComboBox jcb4Sector;
  public static javax.swing.JComboBox jcb4SubSector;
  public static javax.swing.JComboBox jcb4System;
  // End of variables declaration//GEN-END:variables

  @SuppressWarnings("unchecked")
  private void search4World(String string) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.println("string" + " = " + string);
    }
//</editor-fold>
    String[] parts = new String[2];
    parts[0] = string.substring(0, 4);
    try {
      parts[1] = string.substring(5, string.length());
    } catch (Exception e) {
      System.out.println("p4l.832 e = " + e);
    }
    String line;
    String[] lines;
//    File f = new File(T5 + "/CSV/uwp-worlds");
//    try {
//      BufferedReader in = new BufferedReader(new FileReader(f));
//      try {
//        while ((line = in.readLine()) != null) {
    for (i = 0; i < Panel4Imperium.Systems.length; i++) {
      line = Panel4Imperium.Systems[i];
      part = line.split("\",\"");
      for (int j = 0; j < part.length; j++) {
        part[j] = part[j].replace("\"", "").replace("\"", "");
        ////System.out.print("part["+j+"]" + " = " +part[j]);
      }
      if (part[0].equals(parts[1])) {
        Panel4SubSector.UWP.setText(part[2]);
        Panel4SubSector.updateCombos();
        Panel4SubSector.jcb4Bases.removeAllItems();
        Panel4SubSector.jcb4Bases.addItem(part[3]);
        Panel4SubSector.jcb4Remarks.removeAllItems();
        Panel4SubSector.jcb4Remarks.addItem(part[4]);
        Panel4SubSector.jcb4Zone.removeAllItems();
        Panel4SubSector.jcb4Zone.addItem(part[5]);
        Panel4SubSector.jcb4GGs.removeAllItems();
        Panel4SubSector.jcb4GGs.addItem(part[6]);
        Panel4SubSector.jcb4Cargo.removeAllItems();
        Panel4SubSector.jcb4Cargo.addItem(part[10]);
        Panel4SubSector.jcb4Trade.removeAllItems();
        Panel4SubSector.jcb4Trade.addItem(part[11]);
        Panel4SubSector.jcb4Star1.removeAllItems();
        Panel4SubSector.jcb4Star1.addItem(part[12]);
        Panel4SubSector.jcb4Star2.removeAllItems();
        Panel4SubSector.jcb4Star2.addItem(part[13]);
        Panel4SubSector.jcb4Star3.removeAllItems();
        Panel4SubSector.jcb4Star3.addItem(part[14]);
        Panel4SubSector.jcb4HW.removeAllItems();
        Panel4SubSector.jcb4HW.addItem(part[15]);
        Panel4SubSector.jcb4Al.removeAllItems();
        Panel4SubSector.jcb4Al.addItem(part[16]);
        Panel4SubSector.jcb4PAG.removeAllItems();
        Panel4SubSector.jcb4PAG.addItem(part[17]);
        Panel4SubSector.jcb4ZonedFor.removeAllItems();
        Panel4SubSector.jcb4ZonedFor.addItem(part[18]);
        Panel4SubSector.jcb4Detail.removeAllItems();
        Panel4SubSector.jcb4Detail.addItem(part[19]);
        Panel4SubSector.jcb4Hard1.removeAllItems();
        Panel4SubSector.jcb4Hard1.addItem(part[20]);
        Panel4SubSector.jcb4Hard2.removeAllItems();
        Panel4SubSector.jcb4Hard2.addItem(part[21]);
        Panel4SubSector.jcb4Hard3.removeAllItems();
        Panel4SubSector.jcb4Hard3.addItem(part[22]);
        Panel4SubSector.jcb4Star4.removeAllItems();
        Panel4SubSector.jcb4Star4.addItem(part[23]);
      }

    }
//        }
//        in.close();
//      } catch (IOException ex) {
//        Logger.getLogger(Panel4Locator.class.getName()).log(Level.SEVERE, null, ex);
//      }
//    } catch (FileNotFoundException ex) {
//      Logger.getLogger(Panel4Locator.class.getName()).log(Level.SEVERE, null, ex);
//    }
  }
  static String[][] coords;

  /**
   <p>
   @param text  x value
   @param text0 y value
   */
  public static void listNeighbours(String text, String text0) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//            //System.out.print("e.toString()" + " = " + e.toString());
    }
//</editor-fold>
    int x = Integer.parseInt(text);
    int y = Integer.parseInt(text0);
    int startx = x - 1;
    int endx = x + 1;
    int starty = y - 1;
    int endy = y + 1;

    coords = new String[3][3];
    File f = new File(T5 + "/CSV/uwp-sector");
////        String lines[];
    String line;
    String[] parts;
    sectors = new String[9];
    String string;
    String comp;
    coords[1][1] = "" + x + "," + y;
    coords[0][0] = "" + (x - 1) + "," + (y + 1);
    coords[1][0] = "" + x + "," + (y + 1);
    coords[2][0] = "" + (x + 1) + "," + (y + 1);
    coords[2][1] = "" + (x + 1) + "," + y;
    coords[2][2] = "" + (x + 1) + "," + (y - 1);
    coords[1][2] = "" + x + "," + (y - 1);
    coords[0][2] = "" + (x - 1) + "," + (y - 1);
    coords[0][1] = "" + (x - 1) + "," + y;
    sectors[0] = coords[1][1];//MM//-4,1
    sectors[1] = coords[0][0];//LT//-5,2
    sectors[2] = coords[1][0];//MT//-4,2
    sectors[3] = coords[2][0];//RT//-3,2
    sectors[4] = coords[2][1];//RM//-3,1
    sectors[5] = coords[2][2];//RB//-3,0
    sectors[6] = coords[1][2];//MB//-4,0
    sectors[7] = coords[0][2];//LB//-5,0
    sectors[8] = coords[0][1];//LM//-5,1
    for (i = 0; i < 9; i++) {
      //System.out.print("" + i + " = " + sectors[i]);
    }
    try {
      worlds = new String[GlobalMethods.countLines(f)];
      BufferedReader in = new BufferedReader(new FileReader(f));
      try {
        while ((line = in.readLine()) != null) {
          parts = line.split("\",\"");
          string = "" + parts[2] + "," + parts[3];
          ////System.out.print("string" + " = " +string);
          for (i = 0; i < 9; i++) {
            comp = sectors[i];
            ////System.out.print("comp" + " = " +comp);
            {
              if (string.equals(comp)) {
                worlds[i] = line;
                //System.out.print("" + " = " + line);
              }
            }
          }
          ////System.out.print("" + " = " + line);
        }
      } catch (IOException ex) {
        Logger.getLogger(Panel4Locator.class.getName()).log(Level.SEVERE, null,
          ex);
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Panel4Locator.class.getName())
        .log(Level.SEVERE, null, ex);
    }
    //Panel4SubSector.Destinations();

  }

  /**
   <p>
   @return array of neighbouring sectors
   */
  public String[] getNeighbours() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//            //System.out.print("e.toString()" + " = " + e.toString());
    }
//</editor-fold>
    return sectors;
  }

  /**
   <p>
   @param s String to set jcb4Sector
   */
  public static void setSector(String s) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    jcb4Sector.setSelectedItem(s);
    File f = new File(T5 + "/CSV/uwp-sector");
    String[] lines = GlobalMethods.getLinesFromFile(f);
    for (int j = 0; j < lines.length; j++) {
      if (lines[j].toLowerCase().contains(s.toLowerCase())) {
        //System.out.println(lines[j]);
        try {
          String[] parts = lines[j].split(",");
//          for (int k = 0; k < parts.length; k++) {
//            System.out.println(parts[k]);
//          }
          setXnum(parts[2].replace("\"", ""));
          setYnum(parts[3].replace("\"", ""));
        } catch (Exception e) {
          System.out.println("969 " + e);
        }
      }
    }
  }

  /**
   <p>
   @param sub String to set jcb4SubSector
   @param txt String to split
   */
  @SuppressWarnings({"unchecked", "unchecked"})
  public static void setSubSector(String sub, String txt) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    try {
      String[] systems = txt.split(GlobalVariables.CRLF);
      for (int j = 3; j < systems.length; j++) {
        System.out.println(systems[j]);
      }
      System.out.println(GlobalMethods.comment("=", 30));
      File f = new File(T5 + "/CSV/uwp-subsec");
      String[] lined = GlobalMethods.getLinesFromFile(f);
      DefaultComboBoxModel<String> subs = new DefaultComboBoxModel<>();
      for (int j = 0; j < lined.length; j++) {
        if (lined[j].contains(getSector())) {
          //System.out.println(lined[j]);
          String[] bits = lined[j].split(",");
          String s = bits[2].replace("\"", "") + " - " + bits[0].replace("\"",
            "");
          System.out.println(s);
          subs.addElement(s);
        }
      }
      jcb4SubSector.setModel(subs);
      jcb4SubSector.setSelectedItem(sub);
      DefaultListModel<String> dlm = new DefaultListModel<>();
      DefaultComboBoxModel<String> worlds = new DefaultComboBoxModel<>();
      f = new File(T5 + "/CSV/uwp-worlds");
      String[] lines = txt.split(GlobalVariables.CRLF);
      if (lines.length > 3) {
        for (int j = 4; j < lines.length; j++) {
          dlm.addElement(lines[j]);
          worlds.addElement(lines[j]);
        }
      }
      jcb4System.setModel(worlds);
      jcb4System.setSelectedIndex(0);
      if (!dlm.isEmpty()) {
        Panel4SubSector.jList1.setModel(dlm);
//        Panel4SubSector.jList1.setSelectedIndex(0);
      } else {
        dlm = new DefaultListModel<>();
        Panel4SubSector.jList1.setModel(dlm);
//        jcb4System.setSelectedIndex(0);
//        MouseEvent me = null;

      }
    } catch (Exception e) {
      System.out.println("e = " + e);
    }
  }

  private String getWorld() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    return "" + jcb4System.getSelectedItem().toString();
  }

  @SuppressWarnings("unchecked")
  private void loadSubs(File f) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    JComboBox<String> jcb = new JComboBox<>();
    String[] lines = GlobalMethods.getLinesFromFile(f);
    DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
    String prev = getJcb4Sector().getModel().getSelectedItem().toString()
      .replace("\"", "");
//    System.out.println(prev);
    for (int i = 0; i < lines.length; i++) {
      if (lines[i].contains(prev)) {
        String[] parts = lines[i].split(",");
        String sub = parts[2].replace("\"", "") + " - "
          + parts[0].replace("\"", "");
        System.out.println(" " + sub);
        dcbm.addElement(sub);
      }
    }
    jcb4SubSector.setModel(dcbm);

  }

  @SuppressWarnings("unchecked")
  private void loadSys(File f) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName() + CRLF);
      ////System.out.print("" + " = " + );
    }
    //</editor-fold>
    JComboBox<String> jcb = new JComboBox<>();
    String[] lines = GlobalMethods.getLinesFromFile(f);
    DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
    //String prev = getJcb4Sector().getModel().getSelectedItem().toString().replace("\"", "");
    String prev = getSubSector().substring(4);
    System.out.println("prev = " + prev);
    for (int i = 3; i < lines.length; i++) {
      if (lines[i].contains(prev)) {
        String[] parts = lines[i].split(",");
        String sys = parts[1].replace("\"", "") + "-"
          + parts[0].replace("\"", "");
        System.out.println(" " + sys);
        dcbm.addElement(sys);
      }
    }
    jcb4System.setModel(dcbm);
    Panel4SubSector.jList1.setModel(dcbm);
//    jcb4System.setSelectedIndex(0);
  }
}
