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
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

/**
 <p>
 @author Your Name Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4ListTextOld extends Panel4 implements Interface4UWP,
  Interface4Usqp {

  //<editor-fold defaultstate="collapsed" desc="variables">
  /**
   Properties of JFileChooser
   */
  public static final String PROP_JFC = "PROP_JFC";
  private static JFrame jf;
  private static Panel4 jp;
  private static String CRLF = dbviewer.globals.GlobalVariables.CRLF;
  private static String EE = "EE";
  private static String RU = "RU";
  static String tl = null, trade = null, uwp = null;
  private String[] table;
  static String[] TradeCode = {
    "4",
    "Code", "Resources", "Infrastructure", "Culture",
    "Ag", "+1", "0", "-1",
    "As", "0", "-1", "+1",
    "Ba", "0", "0", "0",
    "De", "-1", "0", "-1",
    "Fl", "-1", "0", "+1",
    "Hi", "+1", "+1", "0",
    "Ic", "-1", "0", "+1",
    "In", "+2", "+2", "0",
    "Lo", "0", "-1", "0",
    "Na", "-1", "0", "-1",
    "Ni", "0", "-1", "-1",
    "Po", "0", "-2", "+1",
    "Ri", "+1", "+2", "+1",
    "Va", "-1", "0", "+1",
    "Wa", "0", "-1", "0"
  };
  static String[] StarPort = {
    "4",
    "SP", "Resources", "Infrastructure", "Culture",
    "A", "+2", "+4", "0",
    "B", "+1", "+3", "0",
    "C", "0", "+2", "0",
    "D", "0", "+1", "0"
  };
  static String[] ResourceTradeBenefit = {
    "3",
    "Roll", "Export Benefit", "Import Benefit",
    "2", "0.3", "0.2",
    "3", "0.3", "0.2",
    "4", "0.4", "0.3",
    "5", "0.4", "0.3",
    "6", "0.5", "0.4",
    "7", "0.5", "0.4",
    "8", "0.5", "0.4",
    "9", "0.5", "0.4",
    "10", "0.6", "0.5",
    "11", "0.6", "0.5",
    "12", "0.7", "0.6"
  };
  static String[] StarportMultipliers = {
    "2",
    "A", "1.0",
    "B", "0.9",
    "C", "0.8",
    "D", "0.7",
    "E", "0.6"
  };
  static String[] TotalDemand = {
    "17",
    "Roll", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
    "13", "14", "15",
    "0", "0", "0", "0", "1", "2", "2", "3", "3", "4", "4", "5", "5", "6", "6",
    "7", "7",
    "1", "0", "0", "0", "1", "2", "2", "3", "4", "5", "5", "6", "6", "8", "8",
    "9", "9",
    "2", "0", "0", "1", "1", "2", "3", "4", "5", "6", "6", "7", "8", "9", "10",
    "11", "11",
    "3", "0", "0", "1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
    "12", "13",
    "4", "0", "1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
    "13", "14",
    "5", "0", "1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
    "13", "14",
    "6", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
    "13", "14", "15",
    "7", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
    "13", "14", "15",
    "8", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
    "13", "14", "15",
    "9", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
    "13", "14", "15",
    "10", "1", "2", "2", "3", "5", "6", "7", "8", "9", "10", "11", "12", "13",
    "14", "15", "16",
    "11", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "14",
    "15", "16", "17",
    "12", "1", "2", "3", "4", "6", "7", "8", "9", "10", "11", "12", "13", "15",
    "16", "17", "18",
    "13", "1", "2", "3", "5", "6", "7", "8", "9", "10", "11", "12", "13", "16",
    "17", "18", "19",
    "14", "1", "2", "3", "5", "7", "8", "9", "10", "11", "12", "13", "14", "17",
    "18", "19", "20",
    "15", "1", "2", "4", "5", "7", "8", "9", "11", "12", "13", "15", "16", "18",
    "19", "21", "22"
  };
  static String FS = GlobalVariables.FS;
  private static int res = 0;
  private static int lab = 0;
  private static int inf = 0;
  private static int cul = 0;
  String folder = "";
  String name = "";
  static String ext = "";
  String ee = "";
  private FileFilter[] choosableFileFilters;
  private MouseEvent evt;
  String demand = "demand";
  String bgwp = "bgwp";
  String reso = "reso";
  private final Graphics g;
  //</editor-fold>

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
//    Panel4System.main(args);
    Panel4ListTexts.main(args);
    paintBox(jLabel1.getGraphics());
  }

  /**
   Creates new form Panel4ListTextOld
   */
  public Panel4ListTextOld() {
    super();
    initComponents();
    setName("Panel4List");
    //jLabel1.setSize(new Dimension(65, 55));
    jLabel1.setBackground(Color.white);
    jLabel1.setOpaque(true);
//    paintBox(jLabel1.getGraphics());
    g = jLabel1.getGraphics();
  }

  /**
   <p>
   @param string setName()
   */
  public Panel4ListTextOld(String string) {
    this();
    setName(string);
//    paintBox(jLabel1.getGraphics());
  }

  /**
   <p>
   @return visible JList
   */
  @SuppressWarnings("unchecked")
  public JList<String> getList() {
    return this.jList1;
  }

  /**
   <p>
   @return selected item in jlist
   */
  public String getSelected() {
    return this.jList1.getSelectedValue().toString();
  }

  /**
   <p>
   @return visible jtextarea
   */
  public JTextArea getJta() {
    return this.jta;
  }

  /**
   <p>
   @return text in visible jtextarea
   */
  public String getText() {
    return this.jta.getText();
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
    Run = new javax.swing.JLabel();
    Open = new javax.swing.JLabel();
    Save = new javax.swing.JLabel();
    Clear = new javax.swing.JLabel();
    jScrollPane3 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList();
    jScrollPane4 = new javax.swing.JScrollPane();
    jta = new javax.swing.JTextArea();

    jLabel1.setMaximumSize(new java.awt.Dimension(100, 100));
    jLabel1.setMinimumSize(new java.awt.Dimension(100, 100));
    jLabel1.setPreferredSize(new java.awt.Dimension(100, 100));
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    Run.setForeground(new java.awt.Color(0, 255, 0));
    Run.setText("Run");
    Run.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        RunMouseClicked(evt);
      }
    });

    Open.setForeground(java.awt.Color.lightGray);
    Open.setText("Open");
    Open.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        OpenMouseClicked(evt);
      }
    });

    Save.setForeground(java.awt.Color.lightGray);
    Save.setText("Save");
    Save.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        SaveMouseClicked(evt);
      }
    });

    Clear.setForeground(new java.awt.Color(0, 255, 0));
    Clear.setText("Clear");
    Clear.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        ClearMouseClicked(evt);
      }
    });

    jList1.setToolTipText("Click to open, double-click to run");
    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList1MouseClicked(evt);
      }
    });
    jScrollPane3.setViewportView(jList1);

    jta.setColumns(10);
    jta.setRows(5);
    jta.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jtaMouseClicked(evt);
      }
    });
    jScrollPane4.setViewportView(jta);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(Clear)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Run)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Open)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Save)
            .addContainerGap(28, Short.MAX_VALUE))
          .addComponent(jScrollPane4)))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jScrollPane3))
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(Clear)
          .addComponent(Run)
          .addComponent(Open)
          .addComponent(Save))
        .addGap(0, 0, 0)
        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
//</editor-fold>
    try {
      load(this.getSelected(), evt);
      if (evt.getClickCount() > 1) {
//        RunMouseClicked(evt);
        run(this.getSelected());
      }
    } catch (Exception e) {
      System.out.println("Exception" + " = " + e);
    }
  }//GEN-LAST:event_jList1MouseClicked

  private void jtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtaMouseClicked
    if (evt.getClickCount() > 2) {
      getJta().setText("");
    }
  }//GEN-LAST:event_jtaMouseClicked

  private void RunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RunMouseClicked
    // run
    try {
      run(this.getSelected());
    } catch (Exception e) {
      System.out.println("" + " = " + e);
    }
  }//GEN-LAST:event_RunMouseClicked

  private void OpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpenMouseClicked
    Panel4System.setJfc(Panel4System.getJfc());
    this.name = Panel4System.getTitle();
    Panel4ListTextOld.ext = getExt();
    Panel4System.getJfc().setSelectedFile(new File(this.name + "."
      + Panel4ListTextOld.ext));
    try {
      load(this.name, Panel4ListTextOld.ext);
    } catch (Exception e) {
      System.out.println("" + " = " + e);
    }
    switch (getExt()) {
      case "ekex": {
        //int lines = GlobalMethods.countLines(getJta());
        int len = getJta().getText().length() - 2;
        String r = getJta().getText().substring(len - 4, len - 3);
        String l = getJta().getText().substring(len - 3, len - 2);
        String i = getJta().getText().substring(len - 2, len - 1);
        String c = getJta().getText().substring(len - 1, len);

        Panel4SubSector.lab4Resources.setText(r);
        Panel4SubSector.lab4Labour.setText(l);
        Panel4SubSector.lab4Infrastructure.setText(i);
        Panel4SubSector.lab4Culture.setText(c);
        break;
      }
      case "deta": {
        Panel4SubSector.prog.setText(findNum(0));
        Panel4SubSector.plan.setText(findNum(1));
        Panel4SubSector.adva.setText(findNum(2));
        Panel4SubSector.grow.setText(findNum(3));
        Panel4SubSector.mili.setText(findNum(4));
        Panel4SubSector.unit.setText(findNum(5));
        Panel4SubSector.tole.setText(findNum(6));
        break;
      }
    }
  }//GEN-LAST:event_OpenMouseClicked

  private void SaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseClicked
    Panel4System.setJfc(Panel4System.getJfc());
    this.name = Panel4System.getTitle();

    Panel4ListTextOld.ext = getExt();
    Panel4System.getJfc().setSelectedFile(new File(this.name + "." + this.ext));
//    int showSaveDialog = Panel4Tabs.getJfc().showSaveDialog(jf);
//    if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
    save(name, ext);
//    }
  }//GEN-LAST:event_SaveMouseClicked

  private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
    // TODO add your handling code here:
    getJta().setText("");
  }//GEN-LAST:event_ClearMouseClicked

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    System.out.println("jLabel1MouseClicked(evt)" + " = " + evt);
    updatePic();
    if (evt.getClickCount() > 1) {
      JPanel p4c = new Panel4("Colours");
      JColorChooser jcc = new JColorChooser(JColorChooser.showDialog(p4c, FS,
        Color.LIGHT_GRAY));
      color = jcc.getColor();
      jcc.setVisible(true);
      //jp.setBackground(color);
      //jf.setBackground(color);
      updatePic(color);
    }
  }//GEN-LAST:event_jLabel1MouseClicked
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel Clear;
  private javax.swing.JLabel Open;
  private javax.swing.JLabel Run;
  private javax.swing.JLabel Save;
  static javax.swing.JLabel jLabel1;
  public javax.swing.JList jList1;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  public javax.swing.JTextArea jta;
  // End of variables declaration//GEN-END:variables

  private void showUWPDetails() {
    try {
//            jta.append(Panel4Locator.getString() + CRLF);
      jta.append("StarPort " + Panel4SubSector.jcb4StarPort.getSelectedItem()
        .toString() + CRLF);
      jta.append("Size " + Panel4SubSector.jcb4Size.getSelectedItem().toString()
        + CRLF);
      jta.append("Atmos " + Panel4SubSector.jcb4Atmos.getSelectedItem()
        .toString() + CRLF);
      jta.append("Hydros " + Panel4SubSector.jcb4Hydros.getSelectedItem()
        .toString() + CRLF);
      jta.append("Pop " + Panel4SubSector.jcb4Pop.getSelectedItem().toString()
        + CRLF);
      jta.append("Govt " + Panel4SubSector.jcb4Govt.getSelectedItem().toString()
        + CRLF);
      jta.append("Law " + Panel4SubSector.jcb4Law.getSelectedItem().toString()
        + CRLF);
      jta.append("Tech " + Panel4SubSector.jcb4Tech.getSelectedItem().toString()
        + CRLF);
      JComboBox jcb = new JComboBox();
      for (int i = 1; i < 18; i++) {
        switch (i) {
          case 1: {
            jcb = Panel4SubSector.jcb4Bases;
            break;
          }
          case 2: {
            jcb = Panel4SubSector.jcb4Remarks;
            break;
          }
          case 3: {
            jcb = Panel4SubSector.jcb4Zone;
            break;
          }
          case 4: {
            jcb = Panel4SubSector.jcb4GGs;
            break;
          }
          case 5: {
            jcb = Panel4SubSector.jcb4Cargo;
            break;
          }
          case 6: {
            jcb = Panel4SubSector.jcb4Trade;
            break;
          }
          case 7: {
            jcb = Panel4SubSector.jcb4Star1;
            break;
          }
          case 8: {
            jcb = Panel4SubSector.jcb4Star2;
            break;
          }
          case 9: {
            jcb = Panel4SubSector.jcb4Star3;
            break;
          }
          case 10: {
            jcb = Panel4SubSector.jcb4HW;
            break;
          }
          case 11: {
            jcb = Panel4SubSector.jcb4Al;
            break;
          }
          case 12: {
            jcb = Panel4SubSector.jcb4PAG;
            break;
          }
          case 13: {
            jcb = Panel4SubSector.jcb4ZonedFor;
            break;
          }
          case 14: {
            jcb = Panel4SubSector.jcb4Detail;
            break;
          }
          case 15: {
            jcb = Panel4SubSector.jcb4Hard1;
            break;
          }
          case 16: {
            jcb = Panel4SubSector.jcb4Hard2;
            break;
          }
          case 17: {
            jcb = Panel4SubSector.jcb4Hard3;
            break;
          }
          case 18: {
            jcb = Panel4SubSector.jcb4Star4;
            break;
          }
        }
        jta.append(jcb.getToolTipText() + " - " + jcb.getSelectedItem()
          .toString() + CRLF);
      }
    } catch (Exception e) {
      System.out.println("" + " = " + e.toString());
    }
  }

  /**
   <p>
   @return Economic Extension
   */
  public String getEE() {
    if ("EE".equals(EE) | "XXXX".equals(EE)) {
      doEE();
    }
    Panel4SubSector.lab4Resources.setText(EE.substring(0, 1));
    Panel4SubSector.lab4Labour.setText(EE.substring(1, 2));
    Panel4SubSector.lab4Infrastructure.setText(EE.substring(2, 3));
    Panel4SubSector.lab4Culture.setText(EE.substring(3));
    return EE;
  }

  private String doEE() {
    //<editor-fold defaultstate="collapsed" desc="Resources">
    //Resources
    getJta().append("\tResources".toUpperCase() + CRLF);
    try {
      uwp = Panel4SubSector.UWP.getText();
      trade = Panel4SubSector.jcb4Trade.getSelectedItem().toString();
    } catch (Exception e) {
      uwp = "A788999C";
      trade = "Ri";
    }
    //if As Ba or Po then roll 1d-1, else roll 2d-2
    int num;
    if (trade.contains("As") | trade.contains("Ba") | trade.contains("Po")) {
      num = GlobalMethods.getRoll(1) - 1;
    } else {
      num = GlobalMethods.getRoll(2) - 2;
    }
    int tll = GlobalMethods.fromHex(uwp.substring(7));
    int ggs = 0, pbs = 0;
    //if TL8+ add GGs & PBs, if MW=As then -1 to PBs
    if (tll >= 8) {
      try {
        ggs = GlobalMethods.fromHex(Panel4SubSector.jcb4ZonedFor
          .getSelectedItem().toString().substring(2));
        pbs = GlobalMethods.fromHex(Panel4SubSector.jcb4ZonedFor
          .getSelectedItem().toString().substring(1));
      } catch (Exception e) {
        ggs = 3;
        pbs = 0;
      }
    }
    res = num + ggs + pbs;
    getJta().append("Resources" + " = " + res + CRLF);
    Panel4SubSector.lab4Resources.setText(GlobalMethods.toHex(res));
    //-----------------------------------------
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Labour">
    //Labour
    jta.append("\tLabour".toUpperCase() + CRLF);
    //Labour = Pop-1
    lab = (GlobalMethods.fromHex(uwp.substring(4, 5)) - 1);
    jta.append("Labour = " + lab + CRLF);
    Panel4SubSector.lab4Labour.setText(GlobalMethods.toHex(lab));
    //-----------------------------------------
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Infrastructure">
    //Infrastructure
    jta.append("\tInfrastructure".toUpperCase() + CRLF);
    //if MW=Ba then roll 1d:
    if (trade.contains("Ba")) {
      // 1-2 = 0, 3-4=1, 5-6=2
      int roll = GlobalMethods.getRoll(1);
      switch (roll) {
        case 1:
        case 2: {
          inf = 0;
        }
        case 3:
        case 4: {
          inf = 1;
        }
        case 5:
        case 6: {
          inf = 2;
        }
      }
    } else {
      //else roll 2d-2
      inf = GlobalMethods.getRoll(2) - 2;
    }
    //DMs from Trade Code and StarPort tables
    jta.append("Infrastructure = " + inf + CRLF);
    Panel4SubSector.lab4Infrastructure.setText(GlobalMethods.toHex(inf));
    //-----------------------------------------
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Culture">
    //Culture
    jta.append("\tCulture".toUpperCase() + CRLF);
    //if MW=Ba roll 1d: 1-4=0, 5-6=1;
    if (trade.contains("Ba")) {
      int roll = GlobalMethods.getRoll(1);
      if (roll < 5) {
        cul = 0;
      } else {
        cul = 1;
      }
    } else {
      //else roll 2d
      cul = GlobalMethods.getRoll(2);
    }
    //DMs from Trade Code and StarPort tables
    //if Pop 0 = Culture 0
    jta.append("Culture = " + cul + CRLF + CRLF);
    Panel4SubSector.lab4Culture.setText(GlobalMethods.toHex(cul));
    //-----------------------------------------
    //</editor-fold>
    EE = "" + GlobalMethods.toHex(res) + "" + GlobalMethods.toHex(lab) + ""
      + GlobalMethods.toHex(inf) + "" + GlobalMethods.toHex(cul);
    int total = res + lab + inf + cul;
    jta.append("Total = " + total + CRLF);
    getJta().append(CRLF + uwp + "-" + EE + CRLF);
    Panel4SubSector.lab4Resources.setText(EE.substring(0, 1));
    Panel4SubSector.lab4Labour.setText(EE.substring(1, 2));
    Panel4SubSector.lab4Infrastructure.setText(EE.substring(2, 3));
    Panel4SubSector.lab4Culture.setText(EE.substring(3));
    return EE;
  }

  /**
   <p>
   @return Resource Units
   */
  public String getRU() {
    if (!"RU".equals(RU)) {
      doRU();
    }
    return RU;
  }

  private String doRU() {
    return getRU();
  }

  private void showSystemDetails() {
    String txt[] = GlobalMethods.getLinesFromFile(Panel4System.getJfc()
      .getSelectedFile());
    for (int i = 0; i < txt.length; i++) {
      this.getJta().append(txt[i] + CRLF);
    }
  }

  private void showChooser() {
    getJta().setText(Panel4System.getJfc().getCurrentDirectory().toString()
      + CRLF);

    getJta().append(Panel4System.getJfc().getSelectedFile().toString() + CRLF);

    getJta().append(Panel4System.getJfc().getDescription(
      Panel4System.getJfc().getSelectedFile()).toString() + CRLF);

    getJta().append(Panel4ListTextOld.ext + CRLF);
  }

  private void showPicInfo() {
  }

  static String getResources() {
    return "" + res;
  }

  static String getLabour() {
    return "" + lab;
  }

  static String getInfrastructure() {
    return "" + inf;
  }

  static String getCulture() {
    return "" + cul;
  }

  private void save(String txt, String ext) {
    Panel4System.setFilter(ext);
    this.name = Panel4System.getTitle();
    this.folder = Panel4Locator.getPath();
    Panel4ListTextOld.ext = getExt();
    Panel4System.getJfc().setSelectedFile(new File(name));
    txt = getJta().getText();
    GlobalMethods.saveTextFile(folder, name, ext, txt);
  }

  private void load(String namee, String extt) {
    Panel4ListTextOld.ext = extt.toLowerCase();
//    Panel4Tabs.setFilter(ext);
    this.folder = Panel4Locator.getPath();
    this.name = namee;
    //JOptionPane.showMessageDialog(jScrollPane1, folder);
    getJta().setText(GlobalMethods.loadTextFile(folder, name, ext));
  }

  /**
   <p>
   @return extension selected/used
   */
  public String getExt() {
    return Panel4ListTextOld.ext;
  }

  /**
   <p>
   @param s extension to set
   */
  public void setExt(String s) {
    Panel4ListTextOld.ext = s;
  }

  private void showFilters() {
    getJta().setText("");
    FileFilter[] choosableFileFilters1 = Panel4System.getJfc()
      .getChoosableFileFilters();
    for (int i = 0; i < choosableFileFilters1.length; i++) {
      getJta().append("" + i + " = " + choosableFileFilters1[i].getDescription()
        + CRLF);
      System.out.println("" + " = " + choosableFileFilters1[i].getDescription());
    }
  }

  /**
   <p>
   @param ext extension for filter
   @return number of selected filter
   */
  public int getFilterNum(String ext) {
//    JOptionPane.showMessageDialog(jScrollPane1, ext);
//          int num = getFilterNum(Panel4ListText.ext);
//          Panel4Tabs.getJfc().setFileFilter(choosableFileFilters[num]);

    choosableFileFilters = Panel4System.getJfc().getChoosableFileFilters();
    for (int i = 0; i < choosableFileFilters.length; i++) {
      if (choosableFileFilters[i].getDescription().toLowerCase()
        .contains(getExt().toLowerCase())) {
        getJta().append("" + i + " = " + choosableFileFilters[i]
          .getDescription() + CRLF);
        Panel4System.getJfc().setFileFilter(choosableFileFilters[i]);
        return i;
      }
    }
    return -1;
  }

  /**
   <p>
   @return demand (PE)
   */
  public String getDemand() {
    if ("demand".equals(demand)) {
      demand = doDemand();
    }
    return demand;
  }

  /**
   <p>
   @return world trade demand
   */
  private String doDemand() {
    return demand;
  }

  /**
   <p>
   @return Base Gross World Product
   */
  public String getBgwp() {
    if ("bgwp".equals(bgwp)) {
      bgwp = doBgwp();
    }
    return bgwp;
  }

  /**
   <p>
   @return Base Gross World Product
   */
  private String doBgwp() {
    return bgwp;
  }

  /**
   <p>
   @return system resources
   */
  public String getReso() {
    if ("reso".equals(reso)) {
      reso = doReso();
    }
    return reso;
  }

  /**
   <p>
   @return System resources
   */
  private String doReso() {
    return reso;
  }

  private void load(String string, MouseEvent evt1) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
//</editor-fold>
    System.out.println("string" + " = " + string);
    choosableFileFilters = Panel4System.getJfc().getChoosableFileFilters();
    this.getJta().setText("");
    try {
      switch (string) {
        //<editor-fold defaultstate="collapsed" desc="All">
        case "All": {
          Panel4System.getJfc().setFileFilter(Panel4System.getJfc()
            .getAcceptAllFileFilter());
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Only-World">
        case "World": {
          Panel4System.getJfc().setFileFilter(Panel4System.wff);
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Image">
        case "Image": {
          Panel4System.getJfc().setFileFilter(Panel4System.filt[0]);
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Text">
        case "Text": {
          Panel4System.getJfc().setFileFilter(Panel4System.filt[1]);
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Quicklink">
        case "Quicklink": {
          Panel4System.getJfc().setFileFilter(Panel4System.filt[2]);
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Trav">
        case "Trav": {
          Panel4System.getJfc().setFileFilter(Panel4System.filt[3]);
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="showFilters">
        case "showFilters": {
          showFilters();
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="getFilterNum">
        case "getFilterNum": {
          int num = getFilterNum(Panel4ListTextOld.ext);
          Panel4System.getJfc().setFileFilter(choosableFileFilters[num]);
          break;
        }
        //</editor-fold>
        //-----------------------------------------------------------
        //<editor-fold defaultstate="collapsed" desc="UWP">
        case "UWP": {
          Panel4System.setFilter("uwp");
//          showUWPDetails();
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Ekex (EE)">
        case "Ekex (EE)": {
          Panel4System.setFilter("ekex");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Demand">
        case "Demand": {
          Panel4System.setFilter("dema");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Base GWP">
        case "Base GWP": {
          Panel4System.setFilter("bgwp");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Resource Trade">
        case "Resource Trade": {
          Panel4System.setFilter("reso");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Aryu (RU)">
        case "Aryu (RU)": {
          Panel4System.setFilter("aryu");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="saveCSVs">
        case "saveCSVs": {
          String[][] tables = {TradeCode, StarPort, ResourceTradeBenefit,
            StarportMultipliers, TotalDemand};
          String[] names = {"TradeCode", "StarPort", "ResourceTradeBenefit",
            "StarportMultipliers", "TotalDemand"};
          String startname = "/PE-";
          GlobalMethods.saveCSVs(jta, tables, names, startname);
          break;
        }
        //</editor-fold>
        //-----------------------------------------------------------
        //<editor-fold defaultstate="collapsed" desc="Destinations">
        case "Destinations": {
          Panel4System.setFilter("dest");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="StarGen">
        case "StarGen": {
          Panel4System.setFilter("orb");
          //Panel4SubSector.jButton4.doClick();
          break;
        }
        case "Variables": {
          Panel4System.setFilter("txt");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Mine">
        case "Mining": {
          Panel4System.setFilter("Mining");
          if (Integer.parseInt(Panel4SubSector.jcb4PAG.getSelectedItem()
            .toString().substring(1, 2)) > 0) {
            Panel4Mining.main(table);
          } else {
            this.getJta().setText("NO ASTEROIDS IN SYSTEM TO MINE");
          }
          break;
        }
        //</editor-fold>
        //-----------------------------------------------------------
        //<editor-fold defaultstate="collapsed" desc="Squadrons">
        case "Squadrons": {
          Panel4System.setFilter("usqp");
          //Panel4SplitMultiTab.main(table);
          break;
        }
        //</editor-fold>
        //-----------------------------------------------------------
        //<editor-fold defaultstate="collapsed" desc="Details">
        case "Details": {
          Panel4System.setFilter("deta");
          break;
        }
        //</editor-fold>
        //-----------------------------------------------------------
        //<editor-fold defaultstate="collapsed" desc="Nobles">
        case "Nobles": {
          Panel4System.setFilter("nobl");
          //Panel4UMP.main(new String[]{uwp});
          break;
        }
        //</editor-fold>
        //-----------------------------------------------------------
        //<editor-fold defaultstate="collapsed" desc="UMP">
        case "UMP": {
          Panel4System.setFilter("ump");
          //Panel4UMP.main(new String[]{uwp});
          break;
        }
        //</editor-fold>
        //-----------------------------------------------------------
        //<editor-fold defaultstate="collapsed" desc="UTP">
        case "Troops": {
          Panel4System.setFilter("utp");
          //Panel4UTP.main(new String[]{uwp});
          break;
        }
        //</editor-fold>
        //-----------------------------------------------------------
        //<editor-fold defaultstate="collapsed" desc="System">
        case "System": {
          Panel4System.setFilter("system");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="T5ArmorMaker">
        case "T5ArmorMaker": {
          Panel4System.setFilter("T5ArmorMaker");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="2nd Survey">
        case "2nd Survey": {
          Panel4System.setFilter("2ndSurvey");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="GunMaker">
        case "GunMaker": {
          Panel4System.setFilter("GunMaker");
          break;
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="comment">
//                case "U": {
//                  Panel4Tabs.setFilter("");
//                  break;
//                }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="T5SectorSplit">
        case "T5SectorSplit": {
//          //JOptionPane.showMessageDialog(jp, getName());
//          Panel4System.setFilter("");
////          JPanel jp = new Panel4T5SectorSplit();
////          JFrame jf = new Frame4(jp);
          Panel4System.setFilter("T5SectorSplit");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="T5System">
        case "T5System": {
//          //JOptionPane.showMessageDialog(jp, getName());
//          Panel4System.setFilter("");
////          JPanel jp = new Panel4T5System();
////          JFrame jf = new Frame4(jp);
          Panel4System.setFilter("T5System");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="T5DBConvert">
        case "T5DBConvert": {
          Panel4System.setFilter("");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="T5SystemPic">
        case "T5SystemPic": {
          Panel4System.setFilter("T5SystemPic");
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="T5QREBS">
        case "T5QREBS": {
          Panel4System.setFilter("T5QREBS");
          break;
        }
        //</editor-fold>
        //-----------------------------------------------------------
        //<editor-fold defaultstate="collapsed" desc="T5Locator">
//                case "U": {
//                  Panel4Tabs.setFilter("");
//                  break;
//                }
        //</editor-fold>
        //-----------------------------------------------------------
        default: {
          System.out.println(string + " NOT in select(), why?");
        }
      }
    } catch (NumberFormatException e) {
      //System.out.println("Exception e" + " = " + e);
    }
//    this.getJta().setText("");
//    this.getJta().append(this.getSelected());
    OpenMouseClicked(evt);
  }

  @SuppressWarnings("unchecked")
  private void run(String name) {
    getJta().setText("");
    getJta().append(Panel4Locator.getString() + CRLF);
    switch (name) {
      //<editor-fold defaultstate="collapsed" desc="All">
      case "All": {
        Panel4System.getJfc().setFileFilter(Panel4System.getJfc()
          .getAcceptAllFileFilter());
        Panel4System.getJfc().showOpenDialog(this);
//        showChooser();
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="World">
      case "World": {
        Panel4System.getJfc().setFileFilter(Panel4System.wff);
        Panel4System.getJfc().showOpenDialog(this);
//        showChooser();
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Image">
      case "Image": {
        Panel4System.getJfc().setFileFilter(Panel4System.filt[0]);
        Panel4System.getJfc().showOpenDialog(this);
//        showChooser();
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Text">
      case "Text": {
        Panel4System.getJfc().setFileFilter(Panel4System.filt[1]);
        Panel4System.getJfc().showOpenDialog(this);
//        showChooser();
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Quicklink">
      case "Quicklink": {
        Panel4System.getJfc().setFileFilter(Panel4System.filt[2]);
        Panel4System.getJfc().showOpenDialog(this);
//        showChooser();
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Trav">
      case "Trav": {
        Panel4System.getJfc().setFileFilter(Panel4System.filt[3]);
        Panel4System.getJfc().showOpenDialog(this);
//        showChooser();
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="showFilters">
      case "showFilters": {
        showFilters();
        //showChooser();
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="getFilterNum">
      case "getFilterNum": {
        int num = getFilterNum(ext);
        Panel4System.getJfc().setFileFilter(choosableFileFilters[num]);
        //showChooser();
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="showChooser">
      case "showChooser": {
        showChooser();
        break;
      }
      //</editor-fold>
      //-----------------------------------------------------------
      //<editor-fold defaultstate="collapsed" desc="Squadrons">
      case "Squadrons": {
        //Panel4SplitMultiTab.main(table);
        Panel4Squadron.main(table);
        break;
      }
      //</editor-fold>
      //-----------------------------------------------------------
      //<editor-fold defaultstate="collapsed" desc="Details">
      case "Details": {
        doDetails();
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="UWP">
      case "UWP": {
        //Panel4Tabs.setFilter("uwp");
        showUWPDetails();
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Ekex (EE)">
      case "Ekex (EE)": {
        //Panel4Tabs.setFilter("ekex");
        doEE();
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Demand">
      case "Demand": {
        Panel4System.setFilter("dema");
        demand = getDemand();
        getJta().append(demand);
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Base GWP">
      case "Base GWP": {
        Panel4System.setFilter("bgwp");
        bgwp = getBgwp();
        getJta().append(bgwp);
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Resource Trade">
      case "Resource Trade": {
        Panel4System.setFilter("reso");
        reso = getReso();
        getJta().append(reso);
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Aryu (RU)">
      case "Aryu (RU)": {
        Panel4System.setFilter("aryu");
        RU = getRU();
        getJta().append(RU);
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="saveCSVs">
      case "saveCSVs": {
//        String[][] tables = {TradeCode, StarPort, ResourceTradeBenefit,
//          StarportMultipliers, TotalDemand};
//        String[] names = {"TradeCode", "StarPort", "ResourceTradeBenefit",
//          "StarportMultipliers", "TotalDemand"};
//        String startname = "/PE-";
//        GlobalMethods.saveCSVs(jta, tables, names, startname);
        break;
      }
      //</editor-fold>
      //-----------------------------------------------------------
      //<editor-fold defaultstate="collapsed" desc="Destinations">
      case "Destinations": {
        ArrayList<String> strings = new ArrayList<>();
        DefaultListModel<String> lm = new DefaultListModel<>();
        int num = 8;
        for (int i = 0; i <= num; i++) {
          Panel4SubSector.jSlider1.setValue(i);
          lm = new DefaultListModel<>();
          lm = (DefaultListModel<String>) Panel4SubSector.jList2.getModel();
          //            System.out.println("Jump " + i);
          this.getJta().append(("Jump " + i + " costs "
            + Panel4SubSector.jLabel1.getText()).toUpperCase() + CRLF);
          for (int j = 0; j < lm.getSize(); j++) {
            strings.add((String) lm.get(j));
            this.getJta().append("  " + (String) lm.get(j).toString() + CRLF);
          }
        }
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="StarGen">
      case "StarGen": {
        //Panel4Tabs.setFilter("star");
        Panel4SubSector.jButton4.doClick();
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Mine">
      case "Mining": {
//        Panel4Tabs.setFilter("mine");
        if (Integer.parseInt(Panel4SubSector.jcb4PAG.getSelectedItem()
          .toString().substring(1, 2)) > 0) {
          Panel4Mining.main(table);
        } else {
          this.getJta().setText(Panel4Locator.getString() + CRLF);
          this.getJta().append("NO ASTEROIDS IN SYSTEM TO MINE");
        }
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Variables">
      case "Variables": {
//        Panel4Tabs.setFilter("txt");
//        if (Integer.parseInt(Panel4SubSector.jComboBox12.getSelectedItem()
//                .toString().substring(1, 2)) > 0) {
//          Panel4Mining.main(table);
//        }
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="USqP">
//            case "USqP": {
//                Panel4Squadron.main(new String[]{uwp});
//                break;
//            }
      //</editor-fold>
      //-----------------------------------------------------------
      //<editor-fold defaultstate="collapsed" desc="Nobles">
      case "Nobles": {
//        Panel4Tabs.setFilter("nobl");
        Panel4Nobles.main(new String[]{uwp});
        break;
      }
      //</editor-fold>
      //-----------------------------------------------------------
      //<editor-fold defaultstate="collapsed" desc="UMP">
      case "UMP": {
        Panel4UMP.main(new String[]{uwp});
        break;
      }
      //</editor-fold>
      //-----------------------------------------------------------
      //<editor-fold defaultstate="collapsed" desc="Troops">
      case "Troops": {
        //Panel4Tabs.setFilter("utp");
        Panel4UTP.main(new String[]{Panel4SubSector.UWP.getText()});
        break;
      }
      //</editor-fold>
      //-----------------------------------------------------------
      //<editor-fold defaultstate="collapsed" desc="2nd Survey">
//      case "T52nd Survey": {
//        //JOptionPane.showMessageDialog(jp, getName());
//        XPanel4T52ndSurvey.main(new String[]{"Spinward Marches"});
//        break;
//      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="T5WebData">
      case "T5WebData": {
        panels.Panel4T5WebData.main(getStars());
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="T5System">
      case "T5System": {
        Panel4T5System.main(getStars());
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="T5ArmorMaker">
      case "T5ArmorMaker": {
        Panel4T5ArmorMaker.main(new String[]{"Human"});
        break;
      }

      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="GunMaker">
      case "T5GunMaker": {
        //JOptionPane.showMessageDialog(jp, getName());
        Panel4T5GunMaker.main(new String[]{"Spinward Marches"});
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="T5QREBS">
      case "T5QREBS": {
        //JOptionPane.showMessageDialog(jp, getName());
        JPanel jp = new Panel4T5QREBS();
        JFrame jf = new Frame4(jp, "T5QREBS");
        break;
      }
      //</editor-fold>
//      //<editor-fold defaultstate="collapsed" desc="T5SystemPic">
//      case "T5SystemPic": {
//        JPanel jp = new Panel4T5SystemPic();
//        JFrame jf = new Frame4(jp, "Panel4T5SystemPic");
//        break;
//      }
//      //</editor-fold>
//      //<editor-fold defaultstate="collapsed" desc="T5SectorSplit">
//      case "T5SectorSplit": {
//        //JOptionPane.showMessageDialog(jp, getName());
//        JPanel jp = new XPanel4T5SectorSplit();
//        JFrame jf = new Frame4(jp, "Panel4T5SectorSplit");
//        break;
//      }
//      //</editor-fold>
//      //<editor-fold defaultstate="collapsed" desc="T5DBConvert">
//      case "T5DBConvert": {
//        //JOptionPane.showMessageDialog(jp, getName());
//        JPanel jp = new XPanel4T5DBConvert();
//        JFrame jf = new Frame4(jp, "Panel4T5DBConvert"
//        );
//        break;
//      }
//      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="T5Locator">
      case "T5Locator": {
//        JPanel jp = new Panel4T5Locator();
//        JFrame jf = new Frame4(jp);
        Panel4T5Locator.main(table);
        break;
      }
      //</editor-fold>
    }
  }

  @Override
  public String getUWP() {
    return Panel4SubSector.uwp;
  }

  @Override
  public String getSp() {
    return Panel4SubSector.uwp.substring(0, 1);
  }

  @Override
  public String getSi() {
    return Panel4SubSector.uwp.substring(1, 2);
  }

  @Override
  public String getAt() {
    return Panel4SubSector.uwp.substring(2, 3);
  }

  @Override
  public String getHy() {
    return Panel4SubSector.uwp.substring(3, 4);
  }

  @Override
  public String getPo() {
    return Panel4SubSector.uwp.substring(4, 5);
  }

  @Override
  public String getGo() {
    return Panel4SubSector.uwp.substring(5, 6);
  }

  @Override
  public String getLl() {
    return Panel4SubSector.uwp.substring(6, 7);
  }

  @Override
  public String getTl() {
    return Panel4SubSector.uwp.substring(7, 8);
  }

  @Override
  public String getHex() {
    return Panel4SubSector.jList1.getSelectedValue().toString().substring(0, 4);

  }

  @Override
  public String getSector() {
    return Panel4Locator.getSector();
  }

  @Override
  public String getSubSector() {
    return Panel4Locator.getSubSector();
  }

  @Override
  public String getSystem() {
    return Panel4Locator.getSystem();
  }

  /**
   <p>
   @return Squadron cost
   */
  @Override
  public String getRonPts() {
    return Panel4Squadron.ronpts;
  }

  /**
   <p>
   @return Squadron type
   */
  @Override
  public String getType() {
    return Panel4Squadron.jComboBox0.getSelectedItem().toString();
  }

  /**
   <p>
   @return ID
   */
  @Override
  public String getID() {
    return Panel4Squadron.sidn.getText();
  }

  /**
   <p>
   @return Base Jump
   */
  @Override
  public String getJump() {
    return Panel4Squadron.nj.getText();
  }

  /**
   <p>
   @return Base Jump
   */
  @Override
  public String getBaseJump() {
    return Panel4Squadron.BaseJump;
  }

  /**
   <p>
   @return Maximum Jump by TL
   */
  @Override
  public String getMaxJump() {
    return Panel4Squadron.MaxJump;
  }

  /**
   <p>
   @return Streamline cost in DF
   */
  @Override
  public String getSL() {
    return Panel4Squadron.ns.getText();
  }

  /**
   <p>
   @return Defence Factor
   */
  @Override
  public String getDF() {
    return Panel4Squadron.od.getText();
  }

  /**
   <p>
   @return Attack Factor
   */
  @Override
  public String getAF() {
    return Panel4Squadron.na.getText();
  }

  /**
   <p>
   @return Bombardment Factor
   */
  @Override
  public String getBF() {
    return Panel4Squadron.nb.getText();
  }

  /**
   <p>
   @return Transport Factor
   */
  @Override
  public String getTF() {
    return Panel4Squadron.nt.getText();
  }

  /**
   <p>
   @return Tech Level
   */
  @Override
  public String getTL() {
    return Panel4Squadron.jLabel27.getText();
  }

  /**
   <p>
   @param g the value of g
   */
  static void paintBox(Graphics g) {
    g.setColor(Color.BLACK);
    File f = new File(GlobalVariables.BMP + FS + "x100y100.gif");
    System.out.println("f" + " = " + f);
    try {
      BufferedImage bi2 = new BufferedImage(100, 100,
        BufferedImage.TYPE_INT_ARGB);

      //=======================================
      //lines.bmp
      BufferedImage bi = ImageIO.read(f);
      g.drawImage(bi, Panel4UTP.centerOnX(bi, 0, 100), Panel4UTP
        .centerOnY(bi, 0, 100), null);
      //=======================================
      //Sector
      bi2 = Panel4UTP.strToSmall(3, 5, Panel4Locator.getSector());
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 1, null);
      //=======================================
      //SubSector
      bi2 = Panel4UTP.strToSmall(3, 5, Panel4Locator.getSubSector());
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 7, null);
      //=======================================
      //System
      bi2 = Panel4UTP.strToSmall(3, 5, Panel4Locator.getSystem() + "-"
        + Panel4SubSector.jcb4Al.getSelectedItem().toString());
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 13, null);
      //=======================================
      //UWP
      bi2 = Panel4UTP.strToSmall(3, 5, Panel4SubSector.UWP.getText() + "-"
        + Panel4SubSector.lab4Resources.getText()
        + Panel4SubSector.lab4Labour.getText()
        + Panel4SubSector.lab4Infrastructure.getText()
        + Panel4SubSector.lab4Culture.getText());

      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 19, null);
      //=======================================
      //
      bi2 = Panel4UTP.strToSmall(3, 5, "SDBs = "
        + Panel4SubSector.sdbs1.getText()
        + "   Bases = " + Panel4SubSector.jcb4Bases.getSelectedItem().toString());
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 25, null);
      //=======================================
      //
      bi2 = Panel4UTP.strToSmall(3, 5, "Squadrons="
        + Panel4SubSector.squadrons.getText()
        + " Troops=" + Panel4SubSector.troopunits.getText());
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 31, null);
      //=======================================
      //
      bi2 = Panel4UTP.strToSmall(3, 5, "Defence CF = "
        + Panel4SubSector.defbats.getText() + "-"
        + Panel4SubSector.UWP.getText().substring(7, 8));
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 37, null);
      //=======================================
      //
      bi2 = Panel4UTP.strToSmall(3, 5,
        Panel4SubSector.jcb4Trade.getSelectedItem().toString());
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 43, null);
      //=======================================
      //
      bi2 = Panel4UTP.strToSmall(3, 5, "-"
        + Panel4SubSector.jcb4Star1.getSelectedItem().toString() + " - "
        + Panel4SubSector.jcb4Star2.getSelectedItem().toString() + " - "
        + Panel4SubSector.jcb4Star3.getSelectedItem().toString());
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 49, null);
      //=======================================
      //
      bi2 = Panel4UTP.strToSmall(3, 5, "Atmo = "
        + Panel4SubSector.jcb4Atmos.getSelectedItem().toString().substring(4));
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 55, null);
      //=======================================
      //
      String zone = "Green";
      if ("".equals(Panel4SubSector.jcb4Zone.getSelectedItem().toString())) {
        zone = "Green";
      } else if ("A".equals(Panel4SubSector.jcb4Zone.getSelectedItem()
        .toString().toUpperCase())) {
        zone = "Amber";
      } else if ("R".equals(Panel4SubSector.jcb4Zone.getSelectedItem()
        .toString().toUpperCase())) {
        zone = "Red";
      }
      System.out.println(
        "Panel4SubSector.jComboBox3.getSelectedItem().toString()"
        + " = " + Panel4SubSector.jcb4Zone.getSelectedItem().toString());
      bi2 = Panel4UTP.strToSmall(3, 5, "Zone = " + zone);
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 61, null);
      //=======================================
      //
      bi2 = Panel4UTP.strToSmall(3, 5, "PAG=" + Panel4SubSector.jcb4PAG
        .getSelectedItem().toString());
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 67, null);
      //=======================================
      //
      bi2 = Panel4UTP.strToSmall(3, 5, "Progress "
        + Panel4SubSector.prog.getText()
        + " - Plan " + Panel4SubSector.plan.getText());
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 73, null);
      //=======================================
      //
      bi2 = Panel4UTP.strToSmall(3, 5, "Advance "
        + Panel4SubSector.adva.getText()
        + " - Growth " + Panel4SubSector.grow.getText());
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 79, null);
      //=======================================
      //
      bi2 = Panel4UTP.strToSmall(3, 5, "Military "
        + Panel4SubSector.mili.getText()
        + " - Unity " + Panel4SubSector.unit.getText());
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 85, null);
      //=======================================
      //
      bi2 = Panel4UTP.strToSmall(3, 5, "Tolerance "
        + Panel4SubSector.tole.getText());
      g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 0, 100), 91, null);
      //=======================================
      //=======================================
      //=======================================
      f = new File(Panel4Locator.getPath() + FS + Panel4SubSector.jList1
        .getSelectedValue().toString() + ".gif");
      System.out.println("f.toString()" + " = " + f.toString());
      //bi = new BufferedImage(100, 100, 12);
      //bi = (BufferedImage) jLabel1.createImage(null);
      Panel4UTP.image2Pic("uwp");
      ImageIO.write(bi, "gif", f);
    } catch (IOException ex) {
      Logger.getLogger(Panel4ListTextOld.class.getName())
        .log(Level.SEVERE, null, ex);
    }
    //repaint();
  }

  static void updatePic() {
    paintBox(jLabel1.getGraphics());
    Panel4UTP.image2Pic("uwp");
  }

  private void doDetails() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
//</editor-fold>
    Panel4SubSector.prog.setText("" + modProg(GlobalMethods.getRoll(2)));
    Panel4SubSector.plan.setText("" + modPlan(GlobalMethods.getRoll(2)));
    Panel4SubSector.adva.setText("" + modAdva(GlobalMethods.getRoll(2)));
    Panel4SubSector.grow.setText("" + modGrow(GlobalMethods.getRoll(2)));
    Panel4SubSector.mili.setText("" + modMili(GlobalMethods.getRoll(2)));
    Panel4SubSector.unit.setText("" + modUnit(GlobalMethods.getRoll(2)));
    Panel4SubSector.tole.setText("" + modTole(GlobalMethods.getRoll(2)));
    getJta().append("Progression - " + Panel4SubSector.prog.getText()
      + " = " + Progression + CRLF);
    getJta().append("Planning - " + Panel4SubSector.plan.getText()
      + " = " + Planning + CRLF);
    getJta().append("Advancement - " + Panel4SubSector.adva.getText()
      + " = " + Advancement + CRLF);
    getJta().append("Growth - " + Panel4SubSector.grow.getText()
      + " = " + Growth + CRLF);
    getJta().append("Militancy - " + Panel4SubSector.mili.getText()
      + " = " + Militancy + CRLF);
    getJta().append("Unity - " + Panel4SubSector.unit.getText()
      + " = " + Unity + CRLF);
    getJta().append("Tolerance - " + Panel4SubSector.tole.getText()
      + " = " + Tolerance + CRLF);
  }

  private String modProg(int roll) {//PEp105
    int p = GlobalMethods.fromHex(Panel4SubSector.UWP.getText().substring(4, 5));
    //Pop 6+ DM +1
    if (p > 5) {
      roll += 1;
    }
    //Pop 9+ DM +2
    if (p > 8) {
      roll += 1;
    }
    int l = GlobalMethods.fromHex(Panel4SubSector.UWP.getText().substring(6, 7));
    //Law A+ DM +1
    if (l > 9) {
      roll += 1;
    }
    int c = GlobalMethods.fromHex(Panel4SubSector.lab4Culture.getText());
    //Culture 3- DM -1
    if (c < 4) {
      roll -= 1;
    }
    //Culture 8+ DM +1
    if (c > 7) {
      roll += 1;
    }
    //Progression table
    switch (roll) {
      case 2:
      case 3: {
        Progression = "Radical";
        break;
      }
      case 4:
      case 5:
      case 6:
      case 7: {
        Progression = "Progressive";
        break;
      }
      case 8:
      case 9:
      case 10:
      case 11: {
        Progression = "Conservative";
        break;
      }
      default: {
        Progression = "Reactionary";
        break;
      }

    }
    //Panel4SubSector.jLabel11.setText(Progression);
    return "" + roll;
  }
  /**
   Progression
   */
  public static String Progression = "";

  private String modPlan(int roll) {
    //Progression Conservative or Reactionary DM +2
    //Progression Radical DM -2
    switch (Panel4SubSector.jLabel11.getText()) {
      case "Conservative":
      case "Reactionary": {
        roll += 2;
      }
      case "Radical": {
        roll -= 2;
      }
    }
    //Planning table
    switch (roll) {
      case 2:
      case 3: {
        Planning = "VShort(1 yr)";
        break;
      }
      case 4:
      case 5: {
        Planning = "Short(2-5 yrs)";
        break;
      }
      case 6:
      case 7: {
        Planning = "Medium(6-10 yrs)";
        break;
      }
      case 8:
      case 9: {
        Planning = "Long(11-50 yrs)";
        break;
      }
      case 10:
      case 11: {
        Planning = "VLong(51-100 yrs)";
        break;
      }
      default: {
        Planning = "Far Future(>100 yrs)";
        break;
      }
    }
    //Panel4SubSector.jLabel12.setText(Planning);
    return "" + roll;
  }
  /**
   Planning
   */
  public static String Planning = "";

  private String modAdva(int roll) {
    int l = GlobalMethods.fromHex(Panel4SubSector.UWP.getText().substring(6, 7));
    //Law A+ DM +1
    if (l > 9) {
      roll += 1;
    }
    //Progressiveness Conservative DM +3
    if (Progression == "Conservative") {
      roll += 3;
    }
    //Progressiveness Reactionary DM +6
    if (Progression == "Reactionary") {
      roll += 6;
    }
    //Advancement table
    switch (roll) {
      case 2:
      case 3:
      case 4:
      case 5: {
        Advancement = "Enterprising";
        break;
      }
      case 6:
      case 7:
      case 8:
      case 9: {
        Advancement = "Advancing";
        break;
      }
      case 10:
      case 11:
      case 12: {
        Advancement = "Indifferent";
        break;
      }
      default: {
        Advancement = "Stagnant";
        break;
      }
    }
    //Panel4SubSector.jLabel13.setText(Advancement);
    return "" + roll;
  }
  /**
   Advancement
   */
  public static String Advancement = "";

  private String modGrow(int roll) {
    int l = GlobalMethods.fromHex(Panel4SubSector.UWP.getText().substring(6, 7));
    //Law A+ DM +1
    int c = GlobalMethods.fromHex(Panel4SubSector.lab4Culture.getText());
    //Culture 3- DM -1
    if (c < 4) {
      roll -= 1;
    }
    //Culture 8+ DM +1
    if (c > 7) {
      roll += 1;
    }
    //Growth table
    switch (roll) {
      case 2:
      case 3: {
        Growth = "Expansionist";
        break;
      }
      case 4:
      case 5:
      case 6: {
        Growth = "Competitive";
        break;
      }
      case 7:
      case 8:
      case 9:
      case 10: {
        Growth = "Unaggressive";
        break;
      }
      default: {
        Growth = "Passive";
        break;
      }
    }
    //Panel4SubSector.jLabel14.setText(Growth);
    return "" + roll;
  }
  /**
   Growth
   */
  public static String Growth = "";

  private String modMili(int roll) {
    int l = GlobalMethods.fromHex(Panel4SubSector.UWP.getText().substring(6, 7));
    //Law A+ DM +1
    if (l > 9) {
      roll += 1;
    }
    //Expansionist DM -2
    if ("Expansionist".equals(Growth)) {
      roll -= 2;
    }
    //Competetive DM -1
    if ("Competitive".equals(Growth)) {
      roll -= 1;
    }
    //Passive DM +2
    if ("Passive".equals(Growth)) {
      roll += 2;
    }
    //Militancy table
    switch (roll) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4: {
        Militancy = "Militant";
        break;
      }
      case 5:
      case 6:
      case 7:
      case 8: {
        Militancy = "Neutral";
        break;
      }
      case 9:
      case 10:
      case 11: {
        Militancy = "Peaceable";
        break;
      }
      default: {
        Militancy = "Conciliatory";
        break;
      }
    }
    //Panel4SubSector.jLabel15.setText(Militancy);
    return "" + roll;
  }
  /**
   Militancy
   */
  public static String Militancy = "";

  private String modUnit(int roll) {
    int l = GlobalMethods.fromHex(Panel4SubSector.UWP.getText().substring(6, 7));
    //Law 4- DM +1
    if (l < 5) {
      roll += 1;
    }
    //Law A+ DM -1
    if (l > 9) {
      roll -= 1;
    }
    int g = GlobalMethods.fromHex(Panel4SubSector.UWP.getText().substring(5, 6));
    //Govt 2- DM +1
    if (g < 3) {
      roll += 1;
    }
    //Govt 7 DM +3
    if (g == 7) {
      roll += 3;
    }
    //Govt F DM -1
    if (g == 15) {
      roll -= 1;
    }
    //Growth Passive DM +2
    if (Growth == "Passive") {
      roll += 2;
    }
    //Unity table
    switch (roll) {
      case 0:
      case 1:
      case 2:
      case 3: {
        Unity = "Monolithic";
        break;
      }
      case 4:
      case 5:
      case 6:
      case 7: {
        Unity = "Harmonious";
        break;
      }
      case 8:
      case 9:
      case 10:
      case 11: {
        Unity = "Discordant";
        break;
      }
      default: {
        Unity = "Fragmented";
      }
    }
    //Panel4SubSector.jLabel16.setText(Unity);
    return "" + roll;
  }
  /**
   Unity
   */
  public static String Unity = "";

  private String modTole(int roll) {
    String s = Panel4SubSector.UWP.getText().substring(0, 1);
    //SP A DM -2
    if (s.equals("A")) {
      roll -= 2;
    }
    //SP B DM -1
    if (s.equals("B")) {
      roll -= 1;
    }
    //SP D DM +1
    if (s.equals("D")) {
      roll += 1;
    }
    //SP E DM +3
    if (s.equals("E")) {
      roll += 3;
    }
    //Progressiveness Conservative DM +2
    if (Progression == "Conservative") {
      roll += 2;
    }
    //Progressiveness Reactionary DM +4
    if (Progression == "Reactionary") {
      roll += 4;
    }
    int l = GlobalMethods.fromHex(Panel4SubSector.UWP.getText().substring(6, 7));
    //Law A+ DM +1
    if (l > 9) {
      roll += 1;
    }
    //Tolerance table
    switch (roll) {
      case 0:
      case 1:
      case 2:
      case 3: {
        Tolerance = "Xenophilic";
        break;
      }
      case 4:
      case 5:
      case 6: {
        Tolerance = "Friendly";
        break;
      }
      case 7:
      case 8:
      case 9: {
        Tolerance = "Neutral";
        break;
      }
      case 10:
      case 11: {
        Tolerance = "Aloof";
        break;
      }
      default: {
        Tolerance = "Xenophobic";
        break;
      }
    }
    //Panel4SubSector.jLabel17.setText(Tolerance);
    return "" + roll;
  }
  /**
   Tolerance
   */
  public static String Tolerance = "";

  /**
   <p>
   @param i number of line to search for
   @return number on specified line
   */
  public String findNum(int i) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
//</editor-fold>
    String[] lines = getJta().getText().split(CRLF);
    int start = lines[i + 1].indexOf(" - ") + 3;
    int end = lines[i + 1].indexOf(" = ");
    System.out.println("lines[" + (i + 1) + "] = " + lines[i + 1]);
    return lines[i + 1].substring(start, end);
  }

  private void updatePic(Color color) {
    paintBox(jLabel1.getGraphics());
    Panel4UTP.image2Pic("uwp");
  }
  static Color color = Color.white;

  String[] getStars() {
    String[] t = new String[]{
      Panel4SubSector.jcb4Star1.getSelectedItem().toString(),
      Panel4SubSector.jcb4Star2.getSelectedItem().toString(),
      Panel4SubSector.jcb4Star3.getSelectedItem().toString(),
      Panel4SubSector.jcb4Star4.getSelectedItem().toString(),
      Panel4SubSector.List1.substring(5)
    };
    return t;
  }

  @Override
  public String getZone() {
    return "getZone";
  }
}
