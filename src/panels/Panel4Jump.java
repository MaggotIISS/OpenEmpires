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

import static dbviewer.JumpCalc.setWorlds;
import static dbviewer.JumpCalc.showSubWorlds;
import static dbviewer.globals.GlobalMethods.countLines;
import static dbviewer.globals.GlobalVariables.T5;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import static java.util.logging.Logger.getLogger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static panels.Panel4Imperium.blacken;
import static panels.Panel4Locator.getJcb4SubSector;
import static panels.Panel4Locator.getNeighbours;
import static panels.Panel4Locator.getSector;
import static panels.Panel4Locator.getSectorName;
import static panels.Panel4Locator.getSubSectorName;
import static panels.Panel4Locator.getSystem;
import static panels.Panel4Locator.getXnum;
import static panels.Panel4Locator.getYnum;
import static panels.Panel4Locator.setTopLeft;
import static panels.Panel4Neighbours.centreOnRectangle;

/**
 <p>
 @author maggot
 */
public class Panel4Jump extends Panel4 {

  /**
   Panel4SubSector
   */
//  public static Panel4SubSector p4s;
  /**
   vis
   */
  public static boolean vis = false;
  int secx;
  int secy;
  String[] secs;
  int subX = 6;
  int subY = 6;
  int wid;
  int hgt;
  int subWid;
  int subHgt;
  static JLabel[] lab = new JLabel[36];
  private static JLabel label = new JLabel();
  int[][] subs = {//-1 off number for dimension & swap dimensions (y,x)
    {1, 2, 3, 4, 5, 6},
    {7, 8, 9, 10, 11, 12},
    {13, 14, 15, 16, 17, 18},
    {19, 20, 21, 22, 23, 24},
    {25, 26, 27, 28, 29, 30},
    {31, 32, 33, 34, 35, 36}
  };

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    JPanel jp = new Panel4Jump();
    JFrame jf = new Frame4(jp);
  }

  /**
   Creates new form Panel4SectorExplore
   */
  public Panel4Jump() {
    super();
    try {
      secx = parseInt(getXnum().getText());
      secy = parseInt(getYnum().getText());
    } catch (Exception e) {
      secx = 19;
      secy = 10;
    }
    setName("p4j");
    try {
      Panel4Locator.prevpanel = "p4i";
    } catch (Exception e) {
    }
    initComponents();
    wid = getWidth();
    hgt = getHeight();
    subWid = wid / subX;
    subHgt = hgt / subY;
    lab[0] = jLabel1;
    lab[1] = jLabel2;
    lab[2] = jLabel3;
    lab[3] = jLabel4;
    lab[4] = jLabel5;
    lab[5] = jLabel6;
    lab[6] = jLabel7;
    lab[7] = jLabel8;
    lab[8] = jLabel9;
    lab[9] = jLabel10;
    lab[10] = jLabel11;
    lab[11] = jLabel12;
    lab[12] = jLabel13;
    lab[13] = jLabel14;
    lab[14] = jLabel15;
    lab[15] = jLabel16;
    lab[16] = jLabel17;
    lab[17] = jLabel18;
    lab[18] = jLabel19;
    lab[19] = jLabel20;
    lab[20] = jLabel21;
    lab[21] = jLabel22;
    lab[22] = jLabel23;
    lab[23] = jLabel24;
    lab[24] = jLabel25;
    lab[25] = jLabel26;
    lab[26] = jLabel27;
    lab[27] = jLabel28;
    lab[28] = jLabel29;
    lab[29] = jLabel30;
    lab[30] = jLabel31;
    lab[31] = jLabel32;
    lab[32] = jLabel33;
    lab[33] = jLabel34;
    lab[34] = jLabel35;
    lab[35] = jLabel36;
    label = lab[0];
    try {
      Panel4Imperium.p4s = new Panel4SubSector();
      Panel4Locator.jButton1.setEnabled(true);
      Panel4Locator.jcb4Sector.setEnabled(true);
      Panel4Locator.jcb4SubSector.setEnabled(true);
      Panel4Locator.jcb4System.setEnabled(true);
    } catch (Exception e) {

    }

  }

  /**
   <p>
   @param sectorname to set Panel4Jump
   */
  public Panel4Jump(String sectorname) {
    this();
    //setName(sectorname);
  }

  /**
   <p>
   @return active label
   */
  public static String getLabel() {
    return label.getText();
  }

  /**
   <p>
   @return subsector
   */
  public static String getSubSector() {
    return getJcb4SubSector().getSelectedItem().toString();
  }

  /**
   <p>
   @return name of class
   */
  @Override
  public String toString() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    return "" + getClass().getName() + "[]";
  }

  private void labelClick(MouseEvent evt) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="showPanel4SubSector">
//    if (evt.getClickCount() == 1) {
    setWorlds();
    Panel4Imperium.p4s = new Panel4SubSector();
    Panel4Locator.prevpanel = "p4j";
    Panel4Imperium.p4j.setVisible(false);
    Panel4Imperium.p4s.setVisible(true);
    Panel4Imperium.p4Imp.add(Panel4Imperium.p4s);
    showSubWorlds(evt);
//    }
    //</editor-fold>
  }

  private void mouseEntered(MouseEvent evt) {
    try {
      //<editor-fold defaultstate="collapsed" desc="DEBUG">
      boolean DEBUG = false;
      if (DEBUG) { // true or false
        ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
        ////System.out.print("" + " = " + );
      }
//</editor-fold>
      Panel4Imperium.sow.setBounds(
        Panel4Imperium.f4Imp.getX() + Panel4Imperium.f4Imp.getWidth(),
        Panel4Imperium.f4Imp.getY(), 300, 600);
      //which of the 36 labels have you entered?
      int sx = evt.getLocationOnScreen().x;//screenX
      int sy = evt.getLocationOnScreen().y;//screenY
      int px = jLabel1.getLocationOnScreen().x;//LabelX
      int py = jLabel1.getLocationOnScreen().y;//LabelY
      int posx = sx - px;//x within sector
      int posy = sy - py;//y within sector
      int x = posx / (getWidth() / 6); //subsectorX
      int y = posy / (getHeight() / 6);//subsectorY
      label = lab[subs[y][x] - 1];
      secs = getNeighbours(x, y, false);
      int x1 = secx;//Integer.parseInt(Panel4Locator.getXnum().getText());
      int y1 = secy;//Integer.parseInt(Panel4Locator.getYnum().getText());
      if ((label.getBackground().equals(Color.LIGHT_GRAY) | (label
        .getBackground().equals(Color.BLUE)))) {
        //System.out.print("Out Sector");
        //x,y as tooltip text added to sector x,y to get x,y of sector.
        //System.out.print("" + " = " + label.getToolTipText());
      }
      if (label.getBackground().equals(Color.CYAN)) {
        for (int i = 0; i < Panel4Locator.jcb4SubSector.getItemCount(); i++) {
          String test = Panel4Locator.jcb4SubSector.getItemAt(i).toString()
            .substring(0, 1);
          if (test.equals(label.getText())) {
            Panel4Locator.jcb4SubSector.setSelectedIndex(i);
            label.setToolTipText("" + Panel4Locator.jcb4SubSector.getItemAt(i));
          }
        }
      }
      if (evt.getClickCount() > 1) {
        //<editor-fold defaultstate="collapsed" desc="showPanel4SubSector">
        Panel4Locator.prevpanel = "p4j";
        vis = !vis;
        Panel4Imperium.p4Imp.setVisible(false);
        //</editor-fold>
      } else {
        //<editor-fold defaultstate="collapsed" desc="select subsector">
        //Display info in SaveOutputWindow
        Panel4Imperium.sow.clear();
        //Panel4Imperium.sow.append("Panel4Imperium.f4Imp.getBounds()" + " = " + Panel4Imperium.f4Imp.getBounds());
        Panel4Imperium.sow.setText(Panel4Imperium.previoustext);
        Panel4Imperium.sow.append(
          "\tSubSector information" + dbviewer.globals.GlobalVariables.CRLF);
        File f = new File(T5 + "/CSV/uwp-subsec");
        try {
          BufferedReader in = new BufferedReader(new FileReader(f));
          String[] lines = new String[countLines(f)];
          String line;
          String[] titles = null;
          String[] parts;
          int i = 0;
          try {
            while ((line = in.readLine()) != null) {
              lines[i] = line;
              parts = line.split("\",\"");
              parts[0] = parts[0].replace("\"", "");
              if (i == 0) {
                titles = lines[0].split("\",\"");
              }
              i += 1;
              String secbox = getSectorName().toLowerCase();
              String subbox = getSubSectorName().toLowerCase().substring(4);
              String search = parts[1].toLowerCase();
              String subsearch = parts[0].toLowerCase();
              if ((secbox.equals(search)) & (subbox.equals(subsearch))) {
                for (int j = 0; j < parts.length; j++) {
                  Panel4Imperium.sow.append(
                    "" + titles[j].replace("\"", "") + " = " + parts[j].replace(
                    "\"", "") + dbviewer.globals.GlobalVariables.CRLF);
                }
                Panel4Imperium.sow.append(
                  "====================="
                  + dbviewer.globals.GlobalVariables.CRLF);
              }
            }
            in.close();
          } catch (IOException ex) {
            getLogger(Panel4Imperium.class.getName())
              .log(Level.SEVERE, null, ex);
          } catch (Exception ex) {
            getLogger(Panel4Jump.class.getName()).log(Level.SEVERE, null, ex);
          }
        } catch (FileNotFoundException ex) {
          getLogger(Panel4Imperium.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
      }
      String dir = dbviewer.globals.GlobalVariables.IMP
        + dbviewer.globals.GlobalVariables.FS;
      dir += getSectorName().substring(0, 4)
        + dbviewer.globals.GlobalVariables.FS;
      dir += getSubSectorName() + dbviewer.globals.GlobalVariables.FS;

      Panel4Imperium.sow.setCurrentDirectory(dir);
      Panel4Imperium.sow.setTitle(dir);
      Panel4Imperium.sow.setSelectedFile(getSubSectorName() + ".txt");
      Panel4Neighbours p4n = Panel4Imperium.p4n;
      p4n.setName("Neighbours");
      blacken();
      centreOnRectangle(getSector(), Panel4Locator.getSubSector(), getSystem(),
        false);
      String letter = getSubSectorName().substring(0, 1);
      String topleft = null;
      switch (letter) {
        case "A": {
          topleft = "0101";
          break;
        }
        case "B": {
          topleft = "0901";
          break;
        }
        case "C": {
          topleft = "1701";
          break;
        }
        case "D": {
          topleft = "2501";
          break;
        }
        case "E": {
          topleft = "0111";
          break;
        }
        case "F": {
          topleft = "0911";
          break;
        }
        case "G": {
          topleft = "1711";
          break;
        }
        case "H": {
          topleft = "2511";
          break;
        }
        case "I": {
          topleft = "0121";
          break;
        }
        case "J": {
          topleft = "0921";
          break;
        }
        case "K": {
          topleft = "1721";
          break;
        }
        case "L": {
          topleft = "2521";
          break;
        }
        case "M": {
          topleft = "0131";
          break;
        }
        case "N": {
          topleft = "0931";
          break;
        }
        case "O": {
          topleft = "1731";
          break;
        }
        case "P": {
          topleft = "2531";
          break;
        }
      }
      setTopLeft(topleft);
    } catch (Exception ex) {
      getLogger(Panel4Jump.class.getName()).log(Level.SEVERE, null, ex);
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

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();
    jLabel17 = new javax.swing.JLabel();
    jLabel18 = new javax.swing.JLabel();
    jLabel19 = new javax.swing.JLabel();
    jLabel20 = new javax.swing.JLabel();
    jLabel21 = new javax.swing.JLabel();
    jLabel22 = new javax.swing.JLabel();
    jLabel23 = new javax.swing.JLabel();
    jLabel24 = new javax.swing.JLabel();
    jLabel25 = new javax.swing.JLabel();
    jLabel26 = new javax.swing.JLabel();
    jLabel27 = new javax.swing.JLabel();
    jLabel28 = new javax.swing.JLabel();
    jLabel29 = new javax.swing.JLabel();
    jLabel30 = new javax.swing.JLabel();
    jLabel31 = new javax.swing.JLabel();
    jLabel32 = new javax.swing.JLabel();
    jLabel33 = new javax.swing.JLabel();
    jLabel34 = new javax.swing.JLabel();
    jLabel35 = new javax.swing.JLabel();
    jLabel36 = new javax.swing.JLabel();

    setBackground(new java.awt.Color(0, 255, 255));
    setName("Form"); // NOI18N
    setLayout(new java.awt.GridLayout(6, 6));

    jLabel1.setBackground(new java.awt.Color(0, 0, 0));
    jLabel1.setForeground(java.awt.Color.lightGray);
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("P");
    jLabel1.setToolTipText("-1,1");
    jLabel1.setAlignmentY(0.0F);
    jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
    jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel1.setIconTextGap(0);
    jLabel1.setName("jLabel1"); // NOI18N
    jLabel1.setOpaque(true);
    jLabel1.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel1);

    jLabel2.setBackground(new java.awt.Color(0, 0, 0));
    jLabel2.setForeground(java.awt.Color.lightGray);
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("M");
    jLabel2.setToolTipText("0,1");
    jLabel2.setAlignmentY(0.0F);
    jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel2.setIconTextGap(0);
    jLabel2.setName("jLabel2"); // NOI18N
    jLabel2.setOpaque(true);
    jLabel2.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel2);

    jLabel3.setBackground(new java.awt.Color(0, 0, 0));
    jLabel3.setForeground(java.awt.Color.lightGray);
    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("N");
    jLabel3.setToolTipText("0,1");
    jLabel3.setAlignmentY(0.0F);
    jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel3.setIconTextGap(0);
    jLabel3.setName("jLabel3"); // NOI18N
    jLabel3.setOpaque(true);
    jLabel3.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel3);

    jLabel4.setBackground(new java.awt.Color(0, 0, 0));
    jLabel4.setForeground(java.awt.Color.lightGray);
    jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel4.setText("O");
    jLabel4.setToolTipText("0,1");
    jLabel4.setAlignmentY(0.0F);
    jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel4.setIconTextGap(0);
    jLabel4.setName("jLabel4"); // NOI18N
    jLabel4.setOpaque(true);
    jLabel4.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel4);

    jLabel5.setBackground(new java.awt.Color(0, 0, 0));
    jLabel5.setForeground(java.awt.Color.lightGray);
    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel5.setText("P");
    jLabel5.setToolTipText("0,1");
    jLabel5.setAlignmentY(0.0F);
    jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel5.setIconTextGap(0);
    jLabel5.setName("jLabel5"); // NOI18N
    jLabel5.setOpaque(true);
    jLabel5.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel5);

    jLabel6.setBackground(new java.awt.Color(0, 0, 0));
    jLabel6.setForeground(java.awt.Color.lightGray);
    jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel6.setText("M");
    jLabel6.setToolTipText("1,1");
    jLabel6.setAlignmentY(0.0F);
    jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
    jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel6.setIconTextGap(0);
    jLabel6.setName("jLabel6"); // NOI18N
    jLabel6.setOpaque(true);
    jLabel6.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel6);

    jLabel7.setBackground(new java.awt.Color(0, 0, 0));
    jLabel7.setForeground(java.awt.Color.lightGray);
    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel7.setText("D");
    jLabel7.setToolTipText("-1,0");
    jLabel7.setAlignmentY(0.0F);
    jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel7.setIconTextGap(0);
    jLabel7.setName("jLabel7"); // NOI18N
    jLabel7.setOpaque(true);
    jLabel7.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel7);

    jLabel8.setBackground(new java.awt.Color(0, 255, 255));
    jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel8.setText("A");
    jLabel8.setToolTipText("0,0");
    jLabel8.setAlignmentY(0.0F);
    jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel8.setIconTextGap(0);
    jLabel8.setName("jLabel8"); // NOI18N
    jLabel8.setOpaque(true);
    jLabel8.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel8);

    jLabel9.setBackground(new java.awt.Color(0, 255, 255));
    jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel9.setText("B");
    jLabel9.setToolTipText("0,0");
    jLabel9.setAlignmentY(0.0F);
    jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel9.setIconTextGap(0);
    jLabel9.setName("jLabel9"); // NOI18N
    jLabel9.setOpaque(true);
    jLabel9.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel9);

    jLabel10.setBackground(new java.awt.Color(0, 255, 255));
    jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel10.setText("C");
    jLabel10.setToolTipText("0,0");
    jLabel10.setAlignmentY(0.0F);
    jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel10.setIconTextGap(0);
    jLabel10.setName("jLabel10"); // NOI18N
    jLabel10.setOpaque(true);
    jLabel10.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel10);

    jLabel11.setBackground(new java.awt.Color(0, 255, 255));
    jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel11.setText("D");
    jLabel11.setToolTipText("0,0");
    jLabel11.setAlignmentY(0.0F);
    jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel11.setIconTextGap(0);
    jLabel11.setName("jLabel11"); // NOI18N
    jLabel11.setOpaque(true);
    jLabel11.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel11);

    jLabel12.setBackground(new java.awt.Color(0, 0, 0));
    jLabel12.setForeground(java.awt.Color.lightGray);
    jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel12.setText("A");
    jLabel12.setToolTipText("1,0");
    jLabel12.setAlignmentY(0.0F);
    jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel12.setIconTextGap(0);
    jLabel12.setName("jLabel12"); // NOI18N
    jLabel12.setOpaque(true);
    jLabel12.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel12);

    jLabel13.setBackground(new java.awt.Color(0, 0, 0));
    jLabel13.setForeground(java.awt.Color.lightGray);
    jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel13.setText("H");
    jLabel13.setToolTipText("-1,0");
    jLabel13.setAlignmentY(0.0F);
    jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel13.setIconTextGap(0);
    jLabel13.setName("jLabel13"); // NOI18N
    jLabel13.setOpaque(true);
    jLabel13.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel13);

    jLabel14.setBackground(new java.awt.Color(0, 255, 255));
    jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel14.setText("E");
    jLabel14.setToolTipText("0,0");
    jLabel14.setAlignmentY(0.0F);
    jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel14.setIconTextGap(0);
    jLabel14.setName("jLabel14"); // NOI18N
    jLabel14.setOpaque(true);
    jLabel14.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel14);

    jLabel15.setBackground(new java.awt.Color(0, 255, 255));
    jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel15.setText("F");
    jLabel15.setToolTipText("0,0");
    jLabel15.setAlignmentY(0.0F);
    jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel15.setIconTextGap(0);
    jLabel15.setName("jLabel15"); // NOI18N
    jLabel15.setOpaque(true);
    jLabel15.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel15);

    jLabel16.setBackground(new java.awt.Color(0, 255, 255));
    jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel16.setText("G");
    jLabel16.setToolTipText("0,0");
    jLabel16.setAlignmentY(0.0F);
    jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel16.setIconTextGap(0);
    jLabel16.setName("jLabel16"); // NOI18N
    jLabel16.setOpaque(true);
    jLabel16.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel16);

    jLabel17.setBackground(new java.awt.Color(0, 255, 255));
    jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel17.setText("H");
    jLabel17.setToolTipText("0,0");
    jLabel17.setAlignmentY(0.0F);
    jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel17.setIconTextGap(0);
    jLabel17.setName("jLabel17"); // NOI18N
    jLabel17.setOpaque(true);
    jLabel17.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel17);

    jLabel18.setBackground(new java.awt.Color(0, 0, 0));
    jLabel18.setForeground(java.awt.Color.lightGray);
    jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel18.setText("E");
    jLabel18.setToolTipText("1,0");
    jLabel18.setAlignmentY(0.0F);
    jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel18.setIconTextGap(0);
    jLabel18.setName("jLabel18"); // NOI18N
    jLabel18.setOpaque(true);
    jLabel18.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel18);

    jLabel19.setBackground(new java.awt.Color(0, 0, 0));
    jLabel19.setForeground(java.awt.Color.lightGray);
    jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel19.setText("L");
    jLabel19.setToolTipText("-1,0");
    jLabel19.setAlignmentY(0.0F);
    jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel19.setIconTextGap(0);
    jLabel19.setName("jLabel19"); // NOI18N
    jLabel19.setOpaque(true);
    jLabel19.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel19);

    jLabel20.setBackground(new java.awt.Color(0, 255, 255));
    jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel20.setText("I");
    jLabel20.setToolTipText("0,0");
    jLabel20.setAlignmentY(0.0F);
    jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel20.setIconTextGap(0);
    jLabel20.setName("jLabel20"); // NOI18N
    jLabel20.setOpaque(true);
    jLabel20.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel20);

    jLabel21.setBackground(new java.awt.Color(0, 255, 255));
    jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel21.setText("J");
    jLabel21.setToolTipText("0,0");
    jLabel21.setAlignmentY(0.0F);
    jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel21.setIconTextGap(0);
    jLabel21.setName("jLabel21"); // NOI18N
    jLabel21.setOpaque(true);
    jLabel21.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel21);

    jLabel22.setBackground(new java.awt.Color(0, 255, 255));
    jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel22.setText("K");
    jLabel22.setToolTipText("0,0");
    jLabel22.setAlignmentY(0.0F);
    jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel22.setIconTextGap(0);
    jLabel22.setName("jLabel22"); // NOI18N
    jLabel22.setOpaque(true);
    jLabel22.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel22);

    jLabel23.setBackground(new java.awt.Color(0, 255, 255));
    jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel23.setText("L");
    jLabel23.setToolTipText("0,0");
    jLabel23.setAlignmentY(0.0F);
    jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel23.setIconTextGap(0);
    jLabel23.setName("jLabel23"); // NOI18N
    jLabel23.setOpaque(true);
    jLabel23.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel23);

    jLabel24.setBackground(new java.awt.Color(0, 0, 0));
    jLabel24.setForeground(java.awt.Color.lightGray);
    jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel24.setText("I");
    jLabel24.setToolTipText("1,0");
    jLabel24.setAlignmentY(0.0F);
    jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel24.setIconTextGap(0);
    jLabel24.setName("jLabel24"); // NOI18N
    jLabel24.setOpaque(true);
    jLabel24.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel24);

    jLabel25.setBackground(new java.awt.Color(0, 0, 0));
    jLabel25.setForeground(java.awt.Color.lightGray);
    jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel25.setText("P");
    jLabel25.setToolTipText("-1,0");
    jLabel25.setAlignmentY(0.0F);
    jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel25.setIconTextGap(0);
    jLabel25.setName("jLabel25"); // NOI18N
    jLabel25.setOpaque(true);
    jLabel25.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel25);

    jLabel26.setBackground(new java.awt.Color(0, 255, 255));
    jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel26.setText("M");
    jLabel26.setToolTipText("0,0");
    jLabel26.setAlignmentY(0.0F);
    jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel26.setIconTextGap(0);
    jLabel26.setName("jLabel26"); // NOI18N
    jLabel26.setOpaque(true);
    jLabel26.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel26);

    jLabel27.setBackground(new java.awt.Color(0, 255, 255));
    jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel27.setText("N");
    jLabel27.setToolTipText("0,0");
    jLabel27.setAlignmentY(0.0F);
    jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel27.setIconTextGap(0);
    jLabel27.setName("jLabel27"); // NOI18N
    jLabel27.setOpaque(true);
    jLabel27.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel27);

    jLabel28.setBackground(new java.awt.Color(0, 255, 255));
    jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel28.setText("O");
    jLabel28.setToolTipText("0,0");
    jLabel28.setAlignmentY(0.0F);
    jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel28.setIconTextGap(0);
    jLabel28.setName("jLabel28"); // NOI18N
    jLabel28.setOpaque(true);
    jLabel28.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel28);

    jLabel29.setBackground(new java.awt.Color(0, 255, 255));
    jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel29.setText("P");
    jLabel29.setToolTipText("0,0");
    jLabel29.setAlignmentY(0.0F);
    jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel29.setIconTextGap(0);
    jLabel29.setName("jLabel29"); // NOI18N
    jLabel29.setOpaque(true);
    jLabel29.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel29);

    jLabel30.setBackground(new java.awt.Color(0, 0, 0));
    jLabel30.setForeground(java.awt.Color.lightGray);
    jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel30.setText("M");
    jLabel30.setToolTipText("1,0");
    jLabel30.setAlignmentY(0.0F);
    jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel30.setIconTextGap(0);
    jLabel30.setName("jLabel30"); // NOI18N
    jLabel30.setOpaque(true);
    jLabel30.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel30);

    jLabel31.setBackground(new java.awt.Color(0, 0, 0));
    jLabel31.setForeground(java.awt.Color.lightGray);
    jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel31.setText("D");
    jLabel31.setToolTipText("-1,-1");
    jLabel31.setAlignmentY(0.0F);
    jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
    jLabel31.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel31.setIconTextGap(0);
    jLabel31.setName("jLabel31"); // NOI18N
    jLabel31.setOpaque(true);
    jLabel31.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel31);

    jLabel32.setBackground(new java.awt.Color(0, 0, 0));
    jLabel32.setForeground(java.awt.Color.lightGray);
    jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel32.setText("A");
    jLabel32.setToolTipText("0,-1");
    jLabel32.setAlignmentY(0.0F);
    jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel32.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel32.setIconTextGap(0);
    jLabel32.setName("jLabel32"); // NOI18N
    jLabel32.setOpaque(true);
    jLabel32.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel32);

    jLabel33.setBackground(new java.awt.Color(0, 0, 0));
    jLabel33.setForeground(java.awt.Color.lightGray);
    jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel33.setText("B");
    jLabel33.setToolTipText("0,-1");
    jLabel33.setAlignmentY(0.0F);
    jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel33.setIconTextGap(0);
    jLabel33.setName("jLabel33"); // NOI18N
    jLabel33.setOpaque(true);
    jLabel33.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel33);

    jLabel34.setBackground(new java.awt.Color(0, 0, 0));
    jLabel34.setForeground(java.awt.Color.lightGray);
    jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel34.setText("C");
    jLabel34.setToolTipText("0,-1");
    jLabel34.setAlignmentY(0.0F);
    jLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel34.setIconTextGap(0);
    jLabel34.setName("jLabel34"); // NOI18N
    jLabel34.setOpaque(true);
    jLabel34.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel34);

    jLabel35.setBackground(new java.awt.Color(0, 0, 0));
    jLabel35.setForeground(java.awt.Color.lightGray);
    jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel35.setText("D");
    jLabel35.setToolTipText("0,-1");
    jLabel35.setAlignmentY(0.0F);
    jLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jLabel35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel35.setIconTextGap(0);
    jLabel35.setName("jLabel35"); // NOI18N
    jLabel35.setOpaque(true);
    jLabel35.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel35);

    jLabel36.setBackground(new java.awt.Color(0, 0, 0));
    jLabel36.setForeground(java.awt.Color.lightGray);
    jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel36.setText("A");
    jLabel36.setToolTipText("1,-1");
    jLabel36.setAlignmentY(0.0F);
    jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
    jLabel36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel36.setIconTextGap(0);
    jLabel36.setName("jLabel36"); // NOI18N
    jLabel36.setOpaque(true);
    jLabel36.setPreferredSize(new java.awt.Dimension(32, 40));
    jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabelMouseEntered(evt);
      }
    });
    add(jLabel36);
  }// </editor-fold>//GEN-END:initComponents

  private void jLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMouseClicked
    labelClick(evt);
  }//GEN-LAST:event_jLabelMouseClicked

  private void jLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMouseEntered
    mouseEntered(evt);
  }//GEN-LAST:event_jLabelMouseEntered
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel18;
  private javax.swing.JLabel jLabel19;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel20;
  private javax.swing.JLabel jLabel21;
  private javax.swing.JLabel jLabel22;
  private javax.swing.JLabel jLabel23;
  private javax.swing.JLabel jLabel24;
  private javax.swing.JLabel jLabel25;
  private javax.swing.JLabel jLabel26;
  private javax.swing.JLabel jLabel27;
  private javax.swing.JLabel jLabel28;
  private javax.swing.JLabel jLabel29;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel30;
  private javax.swing.JLabel jLabel31;
  private javax.swing.JLabel jLabel32;
  private javax.swing.JLabel jLabel33;
  private javax.swing.JLabel jLabel34;
  private javax.swing.JLabel jLabel35;
  private javax.swing.JLabel jLabel36;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  // End of variables declaration//GEN-END:variables
}
