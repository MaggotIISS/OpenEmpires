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
import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalMethods.comment;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 <p>
 @author maggot
 */
public class Panel4T5System extends Panel4 {

  //<editor-fold defaultstate="collapsed" desc="variables">
  private static String CRLF = System.lineSeparator();
  private static String MWName;
  private static MouseEvent me = null;
  static int stars;
  private static int star;
  private static int gasg;
  private static int target;
  private static String hzva;
  private static String clim;
  private static JLabel jl = new JLabel();
  private static int x;
  private static int val;
  private static String ob;
  private static String placecol;
  private static int hz1;
  private static int min;
  private static int hzone;
  private static int roll;
  private static String starcol;
  private static String ty;
  private static int de;
  private static String si;
  private static JFrame jf;
  private static int max;
  //</editor-fold>

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    JPanel t5 = new Panel4T5System();
    jf = new Frame4(t5);
    jf.setSize(jf.getWidth(), jf.getHeight() + 200);
    jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    //JOptionPane.showMessageDialog(starnum, args.length);
    if (args.length == 5) {
      Stars = args;
      Stars[0] = args[0];//
      Stars[1] = args[1];//
      Stars[2] = args[2];//
      Stars[3] = args[3];//
      MWName = args[4];//F7 V  M0 VII  M6 V
    } else { // Panel4T5Locator
//      Stars = Panel4SubSector.getStars();
      Stars[0] = "F7 V";
      Stars[1] = "M0 VII";
      Stars[2] = "M6 V";
      Stars[3] = "";
      MWName = "Regina";
    }
    jf.setTitle(MWName);
//    oth.setText("3");
    systemGenChecklist();
  }

  private static void showMinMax() {
//    int min = 0, max = 0;
    switch (star) {
      case 0: {
        min = 2;
        max = 19;
        break;
      }
      case 1: {
        min = 22;
        max = min + orb[1] - 1;
        break;
      }
      case 2: {
        min = 24 + orb[1];
        max = min + orb[2] - 1;
        break;
      }
      case 3: {
        min = 26 + orb[1] + orb[2];
        max = min + orb[1] + orb[2] + orb[3] - 1;
        break;
      }
    }
    System.out.println("\tmin" + " = " + min);
    System.out.println("\tmax" + " = " + max);
  }

  /**
   Creates new form Panel4T5Systems
   */
  public Panel4T5System() {
    super();
    initComponents();
    Orbits = new String[18];
    Stars[0] = "F7 V";
    Stars[1] = "M0 VII";
    Stars[2] = "M6 V";
    MWName = "Regina";
    number = jList1.getModel().getSize();
    lastSelection = new String[number];
    for (int i = 0; i < number; i++) {
      lastSelection[i] = "" + i;
    }
    countStars();
    jList1.setSelectedIndex(0);
  }

  @SuppressWarnings("AssignmentToMethodParameter")
  private static void listPick(int i, String def, Object[] values) {
    string = jList1.getModel().getElementAt(i).toString();
    jf.setTitle("Regina");
    try {
      if (jf.getTitle() == "Regina") {
        def = setReginaDefaults(string);
      } else {
        try {
          //<editor-fold defaultstate="collapsed" desc="switch (string)">
          switch (string) {
            //<editor-fold defaultstate="collapsed" desc="comment">
            case "Sector name": {
              def = getSectorName();
              break;
            }
            case "Hex location": {
              def = getHexLocation();
              break;
            }
            case "Mainworld name": {
              def = setTitle(MWName);
              break;
            }
            case "StarPort": {
              def = getStarPort();
              break;
            }
            case "Mainworld type": {
              def = getMainworldType();
              break;
            }
            case "H zone variance": {
              def = getHZoneVariance();
              break;
            }
            case "Climate": {
              def = getClimate();
              break;
            }
            case "Gas Giants": {
              def = getGasGiants();
              break;
            }
            case "Belts": {
              def = placeBelts();
              break;
            }
            case "Size": {
              def = getSiz();
              break;
            }
            case "Atmosphere": {
              def = getAtmo();
              break;
            }
            case "Hydrographics": {
              def = getHydro();
              break;
            }
            case "Population": {
              def = getPop();
              break;
            }
            case "Government": {
              def = getGov();
              break;
            }
            case "Law level": {
              def = getLaw();
              break;
            }
            case "Tech Level": {
              def = getTech();
              break;
            }
            case "Trade": {
              def = getTrade();
              break;
            }
            case "Importance": {
              def = getImportance();
              break;
            }
            case "Economic": {
              def = getEconomic();
              break;
            }
            case "Cultural": {
              def = getCultural();
              break;
            }
            case "Resource Units": {
              def = getRU();
              break;
            }

            case "Nobility": {
              def = getNobility();
              break;
            }
            case "Allegiance": {
              def = getAllegiance();
              break;
            }
            case "Bases": {
              def = getBases();
              break;
            }
            case "Travel zone": {
              def = getZone();
              break;
            }
            case "N.I.L.": {
              def = getNIL();
              break;
            }
            //</editor-fold>
            case "Stars": {
              def = getStars();
              break;
            }
            case "Types": {
              def = getType();
              break;
            }
            case "Habitable Zones": {
              def = getHabz();
              break;
            }
            case "Total worlds": {
              def = "" + getOrbitals();
              break;
            }
            case "Place stars": {
              def = placeStars();
              break;
            }
            case "Place mainworld": {
              def = placeMainworld();
              break;
            }
            case "Create Orbits": {
              def = createOrbits();
              break;
            }
            case "Place gas giants": {
              def = place(ggs);
              break;
            }
            case "Place belts": {
              def = place(pbs);
              break;
            }
            case "Place other worlds": {
//              def = place(oth);
              break;
            }
            case "Twilight zone": {
              def = getTwilightZone();
              break;
            }
            case "Locked": {
              def = getLocked();
              break;
            }
            case "MainWorld": {
              def = getWorldName();
              break;
            }
            case "ERROR LIST": {
              def = getErrors();
              break;
            }
            case "Systems": {
              def = getSystemCount();
              break;
            }
            case "Orbit List": {
              def = getOrbitList();
              break;
            }
            case "Print systems": {
              def = "" + systems;
              break;
            }
            default: {
              //JOptionPane.showMessageDialog(jf, "ERR - " + jList1.getSelectedValue().toString());
              break;
            }
          }
          //</editor-fold>
        } catch (Exception e) {
          addErr(string);
          def = "ERROR - " + string + " = " + e.toString();
          jta.append(def + " = " + e.toString() + CRLF);
        }
      }
    } catch (Exception e) {
      System.out.println(string + " = " + def);
      JOptionPane.showMessageDialog(jf, string + " = " + def);
    }
    Object rep = def;
    jta.append("" + string.toUpperCase() + ":  " + rep + CRLF);
    lastSelection[jList1.getSelectedIndex()] = (String) rep;
    def = (String) rep;
  }
  private static String string;

  private static String setReginaDefaults(String string) {
    try {
      switch (string) {
        case "Sector name": {
          def = "Spinward Marches";
          break;
        }
        case "Hex location": {
          def = "1910";
          break;
        }
        case "Mainworld name": {
          def = "Regina";
          break;
        }
        case "StarPort": {
          def = "A";
          break;
        }
        case "Mainworld type": {
          def = "Far Satellite (Arr) Orbiting Gas Giant (Assiniboia)";
          break;
        }
        case "H zone variance": {
          def = "+0";
          break;
        }
        case "Climate": {
          def = "Temperate";
          break;
        }
        case "Gas Giants": {
          def = "3";
          break;
        }
        case "Belts": {
          def = "0";
          break;
        }
        case "Size": {
          def = "7";
          break;
        }
        case "Atmosphere": {
          def = "8";
          break;
        }
        case "Hydrographics": {
          def = "8";
          break;
        }
        case "Population": {
          def = "8";
          break;
        }
        case "Government": {
          def = "9";
          break;
        }
        case "Law level": {
          def = "9";
          break;
        }
        case "Tech Level": {
          def = "A";
          break;
        }
        case "Trade": {
          def = "Ri Pa Ph";
          break;
        }
        case "Importance": {
          def = "+4 = Important";
          break;
        }
        case "Economic": {
          def = "A8B6";
          re = 10;
          la = 8;
          in = 11;
          ba = 6;
          break;
        }
        case "Cultural": {
          def = "6C5C";
          ho = 6;
          ac = 12;
          st = 5;
          sy = 12;
          break;
        }
        case "Resource Units": {
          def = "0";
          break;
        }

        case "Nobility": {
          def = "cCDe";
          break;
        }
        case "Allegiance": {
          def = "Im";
          break;
        }
        case "Bases": {
          def = "NS";
          break;
        }
        case "Travel zone": {
          def = "Green";
          break;
        }
        case "N.I.L.": {
          def = "yes";
          break;
        }
        case "Place Stars": {
          def = "F7 V  M0 VII  M6 V";
          break;
        }
        case "Total worlds": {
          def = "12";
          break;
        }
        case "Place mainworld": {
          def = getHZ(Stars[0]);
          break;
        }
        case "Place gas giants": {
          def = "3";
          break;
        }
        case "Place belts": {
          def = "0";
          break;
        }
        case "Place other worlds": {
          def = oth.getText();
          break;
        }
        case "Twilight zone": {
          def = "Orbits 0 & 1";
          break;
        }
        case "Locked": {
          def = "Close satellites";
          break;
        }
        case "Stars": {
          countStars();
          break;
        }
        case "Types": {
          def = " F7 V  M0 VII  M6 V  ";
          break;
        }
        case "Orbits": {
          def = "" + (Orbits.length - (2 * stars));
          break;
        }
        case "MainWorld": {
          def = "HZ";
          break;
        }
        case "Generate": {
          def = "?";
          break;
        }
        case "ERROR LIST": {
          def = getErrors();
          break;
        }
        case "Habitable Zones": {
          def = getHabz();
          break;
        }
        case "Worlds": {
          def = "" + oth.getText();
          break;
        }
        case "Systems": {
          def = "" + systems;
          break;
        }
        case "Orbit List": {
          def = getOrbitList();
          break;
        }
        case "HabZones": {
          def = getHabz();
          break;
        }
        case "Print systems": {
          def = "" + systems;
          break;
        }
        case "Place GGs": {
          def = "" + 3;
        }
        default: {
          System.out.println("ERR - setReginaDefaults() = " + jList1
            .getSelectedValue().toString());
        }
      }
    } catch (Exception e) {
      System.out.println(string + " = " + e);
    }
    return def;
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
    jList1 = new javax.swing.JList();
    jScrollPane2 = new javax.swing.JScrollPane();
    jta = new javax.swing.JTextArea();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jComboBox1 = new javax.swing.JComboBox();
    starnum = new javax.swing.JLabel();
    mw = new javax.swing.JLabel();
    ggs = new javax.swing.JLabel();
    pbs = new javax.swing.JLabel();
    oth = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    totalled = new javax.swing.JLabel();
    jToggleButton1 = new javax.swing.JToggleButton();

    jList1.setModel(new javax.swing.AbstractListModel() {
      String[] strings = { "Sector name", "Hex location", "Mainworld name", "StarPort", "Mainworld type", "H zone variance", "Climate", "Gas Giants", "Belts", "Size", "Atmosphere", "Hydrographics", "Population", "Government", "Law level", "Tech Level", "Trade", "Importance", "Economic", "Cultural", "Resource Units", "Nobility", "Allegiance", "Bases", "Travel zone", "N.I.L.", "Locked", "Twilight zone", "Stars", "Types", "Habitable Zones", "Total worlds", "Place stars", "Systems", "Create Orbits", "Place mainworld", "Place gas giants", "Place belts", "Place other worlds", "Orbit List", "ERROR LIST" };
      public int getSize() { return strings.length; }
      public Object getElementAt(int i) { return strings[i]; }
    });
    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList1MouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jList1);

    jta.setColumns(20);
    jta.setRows(5);
    jta.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jtaMouseClicked(evt);
      }
    });
    jScrollPane2.setViewportView(jta);

    jLabel1.setForeground(java.awt.Color.green);
    jLabel1.setText("Maps");
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    jLabel2.setForeground(java.awt.Color.green);
    jLabel2.setText("Go");
    jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel2MouseClicked(evt);
      }
    });

    jLabel3.setForeground(java.awt.Color.green);
    jLabel3.setText("Save");
    jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel3MouseClicked(evt);
      }
    });

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "//CT-Scout reference", "Planets", "Moons", "Zones", "Magnitude", "Luminosity", "Temp", "Radii", "Masses", "WhiteDwarfs", "HabitableDistance", "Distance", "HabZones", "Placement" }));
    jComboBox1.setToolTipText("CT-Scout reference");
    jComboBox1.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        jComboBox1ItemStateChanged(evt);
      }
    });

    starnum.setText("3");
    starnum.setToolTipText("Stars");
    starnum.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        starnumMouseClicked(evt);
      }
    });

    mw.setText("1");
    mw.setToolTipText("Mainworld");

    ggs.setText("3");
    ggs.setToolTipText("GGs");
    ggs.setName("gg"); // NOI18N

    pbs.setText("0");
    pbs.setToolTipText("PBs");
    pbs.setName("pb"); // NOI18N

    oth.setText("0");
    oth.setToolTipText("Others");
    oth.setName("ot"); // NOI18N
    oth.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        othPropertyChange(evt);
      }
    });

    jLabel9.setText("=");

    totalled.setText("00");
    totalled.setToolTipText("Total");
    totalled.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        totalledMouseClicked(evt);
      }
    });

    jToggleButton1.setText("jToggleButton1");
    jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jToggleButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel3))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(starnum)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(mw)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(ggs)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pbs)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(oth)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel9)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(totalled, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jToggleButton1)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jLabel2)
          .addComponent(jLabel3)
          .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(starnum)
          .addComponent(mw)
          .addComponent(ggs)
          .addComponent(pbs)
          .addComponent(oth)
          .addComponent(jLabel9)
          .addComponent(totalled)
          .addComponent(jToggleButton1))
        .addGap(3, 3, 3)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
          .addComponent(jScrollPane2)))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtaMouseClicked
    if (evt.getClickCount() > 2) {
      jta.setText("");
    }
  }//GEN-LAST:event_jtaMouseClicked

  private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
    int n = jList1.getSelectedIndex();
    jta.setText("");
    listPick(n, def, values);
    if (evt.getClickCount() > 1) {
      reply = JOptionPane.showInputDialog(
        null,
        string.toUpperCase(),
        string,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        values,
        lastSelection[n]);
      lastSelection[n] = (String) reply;
    }
  }//GEN-LAST:event_jList1MouseClicked
  private static Object reply;
  private static int number;
  private static String[] lastSelection;
  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    JPanel jp = new Panel4T5SystemPic();
    JFrame jf = new Frame4(jp, "Panel4T5SystemPic");
  }//GEN-LAST:event_jLabel1MouseClicked
  private static int count;
  private static JPanel ss;
  private static JFrame jfs;
  private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
//    starnum.setText("3");
    System.out.println("" + " = " + comment("=", 30));
    errList = "";
    doCalc();
    systemGenChecklist();
  }//GEN-LAST:event_jLabel2MouseClicked

  private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
    try {
      dbviewer.DBViewer.jfc.setSelectedFile(
        new File(Panel4SubSector.jList1.getSelectedValue().toString()));
    } catch (Exception e) {
      String title;
      if ("Regina".equals(jf.getTitle())) {
        title = "1910-Regina";
      } else {
        title = MWName;
      }
      dbviewer.DBViewer.jfc.setSelectedFile(
        new File(title));
    }
    GlobalMethods.saveText(jta.getText(), "system");
  }//GEN-LAST:event_jLabel3MouseClicked
  //<editor-fold defaultstate="collapsed" desc="SpectralType">
  static final String[] SpectralSize = new String[]{
    "9",
    "Flux", "Sp", "O", "B", "A", "F", "G", "K", "M",
    "-5", "OB", "Ia", "Ia", "Ia", "II", "II", "II", "II",
    "-4", "A", "Ib", "Ib", "Ib", "III", "III", "III", "II",
    "-3", "A", "II", "II", "II", "IV", "IV", "IV", "II",
    "-2", "F", "III", "III", "III", "V", "V", "V", "III",
    "-1", "F", "III", "III", "IV", "V", "V", "V", "V",
    "0", "G", "III", "III", "V", "V", "V", "V", "V",
    "1", "K", "V", "III", "V", "V", "V", "V", "V",
    "2", "K", "V", "V", "V", "V", "V", "V", "V",
    "3", "M", "V", "V", "V", "V", "V", "V", "V",
    "4", "M", "IV", "IV", "V", "IV", "IV", "IV", "IV",
    "5", "M", "D", "D", "D", "D", "D", "D", "D",
    "6", "BD", "D", "D", "D", "D", "D", "D", "D"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="SystemStars">
  static final String[] SystemStars = new String[]{
    "6",
    "Flux", "Primary", "Close", "Near", "Far", "Companion",
    "-5", "Primary", "", "", "", "",
    "-4", "Primary", "", "", "", "",
    "-3", "Primary", "", "", "", "",
    "-2", "Primary", "", "", "", "",
    "-1", "Primary", "", "", "", "",
    "0", "Primary", "", "", "", "",
    "1", "Primary", "", "", "", "",
    "2", "Primary", "", "", "", "",
    "3", "Primary", "Close", "Near", "Far", "Companion",
    "4", "Primary", "Close", "Near", "Far", "Companion",
    "5", "Primary", "Close", "Near", "Far", "Companion"
  };

  //</editor-fold>
  private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
    jta.setText("");
    switch (jComboBox1.getSelectedItem().toString()) {
      case "Planets": {
        GlobalMethods.showTable(jta, "Planets", StarGen.Planets);
        break;
      }
      case "Moons": {
        GlobalMethods.showTable(jta, "Moons", StarGen.Moons);
        break;
      }
      case "Zones": {
        GlobalMethods.showTable(jta, "Zones", StarGen.Zones);
        break;
      }
      case "Magnitude": {
        GlobalMethods.showTable(jta, "Magnitude", StarGen.Magnitude);
        break;
      }
      case "Luminosity": {
        GlobalMethods.showTable(jta, "Luminosity", StarGen.Luminosity);
        break;
      }
      case "Temp": {
        GlobalMethods.showTable(jta, "Temp", StarGen.Temp);
        break;
      }
      case "Radii": {
        GlobalMethods.showTable(jta, "Radii", StarGen.Radii);
        break;
      }
      case "Masses": {
        GlobalMethods.showTable(jta, "Masses", StarGen.Masses);
        break;
      }
      case "WhiteDwarfs": {
        GlobalMethods.showTable(jta, "WhiteDwarfs", StarGen.WhiteDwarfs);
        break;
      }
      case "HabitableDistance": {
        GlobalMethods.showTable(jta, "HabitableDistance",
          StarGen.HabitableDistance);
        break;
      }
      case "Distance": {
        GlobalMethods.showTable(jta, "Distance", StarGen.Distance);
        break;
      }
      case "HabZones": {
        showTable(jta, "A0", HabZones);
        break;
      }
      case "Placement": {
        showTable(jta, "A0", Placement);
        break;
      }
    }

  }//GEN-LAST:event_jComboBox1ItemStateChanged

  private void starnumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_starnumMouseClicked
    countStars();
  }//GEN-LAST:event_starnumMouseClicked

  private void totalledMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalledMouseClicked
    int total = 0;
    int[] labs = new int[]{
      Integer.parseInt(starnum.getText()),
      Integer.parseInt(mw.getText()),
      Integer.parseInt(ggs.getText()),
      Integer.parseInt(pbs.getText()),
      Integer.parseInt(oth.getText()),};
    for (int i = 0; i < labs.length; i++) {
      total += labs[i];
    }
    totalled.setText("" + total);
  }//GEN-LAST:event_totalledMouseClicked

  private void othPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_othPropertyChange
    doCalc();
  }//GEN-LAST:event_othPropertyChange

  private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
    String txt = "";
    for (int i = 0; i < Orbits.length; i++) {
      System.out.println("Orbits[" + i + "]" + " = " + Orbits[i]);
      txt += "" + i + " = " + Orbits[i] + CRLF;
    }
    JOptionPane.showMessageDialog(jf, "" + txt);
  }//GEN-LAST:event_jToggleButton1ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  static javax.swing.JLabel ggs;
  public javax.swing.JComboBox jComboBox1;
  private static javax.swing.JLabel jLabel1;
  private static javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  static javax.swing.JLabel jLabel9;
  private static javax.swing.JList jList1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JToggleButton jToggleButton1;
  private static javax.swing.JTextArea jta;
  static javax.swing.JLabel mw;
  static javax.swing.JLabel oth;
  static javax.swing.JLabel pbs;
  static javax.swing.JLabel starnum;
  static javax.swing.JLabel totalled;
  // End of variables declaration//GEN-END:variables

  private static String check(String c2) {
    if (c2 == "") {
      return "Reroll";
    } else {
      return c2;
    }
  }

  private static String getSectorName() throws Exception {
    try {
      def = Panel4Locator.getSectorName();
    } catch (Exception ex) {
      if ("Regina".equals(jf.getTitle())) {
        def = "Spinward Marches";
        throw new Exception();
      } else {
        def = "Spinward Marches";
      }
    }
    return def;
  }

  private static String getHexLocation() {
    return Panel4Locator.getSystem().substring(0, 4);
  }

  private static String setTitle(String name) {
    MWName = name;
    jf.setTitle(MWName);
    return jf.getTitle();
  }

  private static String getStarPort() {
    try {
      def = Panel4SubSector.UWP.getText().substring(0, 1);
    } catch (Exception e) {
      def = "?";
    }
    //<editor-fold defaultstate="collapsed" desc="switch (def)">
    switch (def) {
      case "A": {
        Quality = "Excellent";
        Yards = "Starships";
        Repairs = "Overhaul";
        Fuel = "Both";
        Downport = "Yes";
        if (GlobalMethods.fromHex(get("popu")) > 6) {
          Highport = "Yes";
        } else {
          Highport = "No";
        }
        possBases = "NS";
        break;
      }
      case "B": {
        Quality = "Good";
        Yards = "Spacships";
        Repairs = "Overhaul";
        Fuel = "Both";
        Downport = "Yes";
        Highport = "";//if pop 8+
        if (GlobalMethods.fromHex(get("popu")) > 7) {
          Highport = "Yes";
        } else {
          Highport = "No";
        }
        possBases = "NS";
        break;
      }
      case "C": {
        Quality = "Routine";
        Yards = "No";
        Repairs = "Major damage";
        Fuel = "Unrefined";
        Downport = "Yes";
        Highport = "";//if pop 7+
        if (GlobalMethods.fromHex(get("popu")) > 8) {
          Highport = "Yes";
        } else {
          Highport = "No";
        }
        possBases = "S";
        break;
      }
      case "D": {
        Quality = "Poor";
        Yards = "No";
        Repairs = "Minor damage";
        Fuel = "Unrefined";
        Downport = "Yes";
        Highport = "No";
        possBases = "S";
        break;
      }
      case "E": {
        Quality = "Frontier";
        Yards = "No";
        Repairs = "No";
        Fuel = "No";
        Downport = "Beacon";
        Highport = "No";
        possBases = "No";
        break;
      }
      case "X": {
        Quality = "None";
        Yards = "No";
        Repairs = "No";
        Fuel = "No";
        Downport = "No";
        Highport = "No";
        possBases = "No";
        break;
      }
      case "F": {
        Quality = "Good";
        Yards = "No";
        Repairs = "Minor";
        Fuel = "Unrefined";
        Downport = "Yes";
        Highport = "No";
        possBases = "Fa Farming Possible";
        break;
      }
      case "G": {
        Quality = "Poor";
        Yards = "No";
        Repairs = "Superficial";
        Fuel = "Unrefined";
        Downport = "Yes";
        Highport = "No";
        possBases = "Mi Mining Possible.";
        break;
      }
      case "H": {
        Quality = "Primitive";
        Yards = "No";
        Repairs = "No";
        Fuel = "No";
        Downport = "Beacon";
        Highport = "No";
        possBases = "Co Colony Possible.  Pe Penal colony Possible";
        break;
      }
      case "Y": {
        Quality = "None";
        Yards = "No";
        Repairs = "No";
        Fuel = "No";
        Downport = "No";
        Highport = "No";
        possBases = "Re Reserve Possible";
        break;
      }
      case "?": {
        Quality = "?";
        Yards = "?";
        Repairs = "?";
        Fuel = "?";
        Downport = "?";
        Highport = "?";
        possBases = "?";
        break;
      }
    }
    //</editor-fold>
    jta.append("  Quality = " + Quality + CRLF);
    jta.append("  Yards = " + Yards + CRLF);
    jta.append("  Repairs = " + Repairs + CRLF);
    jta.append("  Fuel = " + Fuel + CRLF);
    jta.append("  Downport = " + Downport + CRLF);
    jta.append("  Highport = " + Highport + CRLF);
    jta.append("  possBases = " + possBases + CRLF);

    //System.out.println("T5UpdateCombo()");
    String[] StarportUpdate;
    StarportUpdate = new String[]{
      Quality = Panel4SubSector.jcb4StarPort.getModel().getSelectedItem()
      .toString(),
      "  Yards = " + Yards,
      "  Repairs = " + Repairs,
      "  Fuel = " + Fuel,
      "  Downport = " + Downport,
      "  Highport = " + Highport,
      "  possBases = " + possBases
    };
//    Panel4SubSector.jcb4StarPort.setModel(new DefaultComboBoxModel(StarportUpdate));
    return def;
  }
  private static String Quality;
  private static String Yards;
  private static String Repairs;
  private static String Fuel;
  private static String Downport;
  private static String Highport;
  private static String possBases;

  private static String getGasGiants() {
    return Panel4SubSector.jcb4PAG.getSelectedItem().toString().substring(2);
  }

  private static String getSiz() {
    return Panel4SubSector.UWP.getText().substring(1, 2);
  }

  private static String getAtmo() {
    return Panel4SubSector.UWP.getText().substring(2, 3);
  }

  private static String getHydro() {
    return Panel4SubSector.UWP.getText().substring(3, 4);
  }

  private static String getPop() {
    return Panel4SubSector.UWP.getText().substring(4, 5);
  }

  private static String getGov() {
    return Panel4SubSector.UWP.getText().substring(5, 6);
  }

  private static String getLaw() {
    return Panel4SubSector.UWP.getText().substring(6, 7);
  }

  private static String getTech() {
    return Panel4SubSector.UWP.getText().substring(7, 8);
  }

  private static String getErrors() {
    return errList;
  }

  private static void addErr(String string) {
    errList += string + CRLF;
  }
  private static String errList = "";

  private static void systemGenChecklist() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.println("" + " = " + );
    }
//</editor-fold>
    jta.setText("");
    values = null;
    def = null;
    for (int i = 0; i < jList1.getModel().getSize(); i++) {
      //System.out.println("def = " + def);
      listPick(i, def, values);
//      showDetails();
    }
  }
  private static String def = "Def";
  private static Object[] values;

  private static String get(String txt) {
    switch (txt.toLowerCase().substring(0, 4)) {
      case "": {
        return "";
      }
      case "sect": {
        return "";
      }
      case "subs": {
        return "";
      }
      case "syst": {
        return "";
      }
      case "port": {
        return Panel4SubSector.UWP.getText().substring(0, 1);
      }
      case "size": {
        return Panel4SubSector.UWP.getText().substring(1, 2);
      }
      case "atmo": {
        return Panel4SubSector.UWP.getText().substring(2, 3);
      }
      case "hydr": {
        return Panel4SubSector.UWP.getText().substring(3, 4);
      }
      case "popu": {
        return Panel4SubSector.UWP.getText().substring(4, 5);
      }
      case "govt": {
        return Panel4SubSector.UWP.getText().substring(5, 6);
      }
      case "lawl": {
        return Panel4SubSector.UWP.getText().substring(6, 7);
      }
      case "tech": {
        return Panel4SubSector.UWP.getText().substring(7, 8);
      }
      case "trad": {
        return trad;
      }
      case "impo": {
        return impo;
      }
      case "econ": {
        return econ;
      }
      case "nobi": {
        return nobi;
      }
      case "nob": {
        return titles;
      }
      default: {
        return "ERROR in get(" + txt + ")";
      }
    }
  }

  private static String getAllegiance() {
    //<editor-fold defaultstate="collapsed" desc="alle">
    alle = Panel4SubSector.jcb4Al.getSelectedItem().toString();
    //Im Imperial.
    if (alle.equals("Im")) {
      allies = "Imperial";
    }
    //Cs Client-State
    if (alle.equals("Cs")) {
      allies = "Client-State";
    }
    //Na Non-Aligned
    if (alle.equals("Na")) {
      allies = "Non-Aligned";
    }
    //Va Vargr
    if (alle.equals("Va")) {
      allies = "Vargr";
    }
    //As Aslan
    if (alle.equals("As")) {
      allies = "Aslan";
    }
    //Zh Zhodani
    if (alle.equals("Zh")) {
      allies = "Zhodani";
    }
    //So Solomani
    if (alle.equals("So")) {
      allies = "Solomani";
    }
    //Kk K’kree
    if (alle.equals("Kk")) {
      allies = "K’kree";
    }
    //Hv Hiver
    if (alle.equals("Hv")) {
      allies = "Hiver";
    }
    //</editor-fold>
    return alle + " (" + allies + ")";
  }
  private static String alle;
  private static String allies;

  private static String getBases() {
    //<editor-fold defaultstate="collapsed" desc="base">
    /*
     N Naval Base
     D Naval Depot
     S Scout Base
     W Scout Way Station
     M Military Base
     A Depot is established approximately one per 1000 worlds.
     A Way Station is placed approximately one per 50 parsecs along major trade
     routes.
     Military Base as needed

     2D A B A B C D
     2 N N S S S S
     3 N N S S S S
     4 N N S S S S
     5 N N - S S S
     6 N - - S S
     7 - - - - - S
     8 - - - - - -
     9 - - - - - -
     10 - - - - - -
     11 - - - - - -
     12 - - - - - -
     Columns are Starport Types. Roll once for each Base type.
     */
    base = Panel4SubSector.jcb4Bases.getSelectedItem().toString();
    switch (base) {
      case "N": {
        basetxt = "Naval Base";
        break;
      }
      case "D": {
        basetxt = "Naval Depot";
        break;
      }
      case "S": {
        basetxt = "Scout Base";
        break;
      }
      case "W": {
        basetxt = "Way Station";
        break;
      }
      case "M": {
        basetxt = "Military Base";
        break;
      }
      case "2": {
        base = "NS";
        basetxt = "Naval & Scout Bases";
        break;
      }
      default: {
        basetxt = "Unknown Base";
        break;
      }
    }
    //</editor-fold>
    return base + " - " + basetxt;
  }
  private static String base;
  private static String basetxt;

  private static String getClimate() {
    return clim;
  }

  private static String getCultural() {
    //<editor-fold defaultstate="collapsed" desc="cult">
    //Homogeneity  =Pop + Flux
    ho = GlobalMethods.rollFlux() + GlobalMethods.fromHex(get("popu"));
    //Acceptance  = Pop + Importance
    ac = (GlobalMethods.fromHex(get("popu"))) + (GlobalMethods.fromHex(impo));
    //Strangeness  5 + Flux
    st = (5 + GlobalMethods.rollFlux());
    //Symbols      TL + Flux
    sy = (GlobalMethods.fromHex(get("tech"))) + (GlobalMethods.rollFlux());
    //</editor-fold>
    jta.append("  Homogeneity = " + ho + CRLF);
    jta.append("  Acceptance = " + ac + CRLF);
    jta.append("  Strangeness = " + st + CRLF);
    jta.append("  Symbols = " + sy + CRLF);
    cult = "" + GlobalMethods.toHex(ho) + GlobalMethods.toHex(ac)
      + GlobalMethods.toHex(st) + GlobalMethods.toHex(sy);
    return cult;
  }
  private static String cult;
  private static int ho;
  private static int ac;
  private static int st;
  private static int sy;

  private static String getEconomic() {
    //<editor-fold defaultstate="collapsed" desc="econ">
    //Resources 2d+belt+ggs
    re = (GlobalMethods.roll2d()) + Integer.parseInt(getGasGiants()) + Integer
      .parseInt(placeBelts());
    //Labour    pop
    la = (GlobalMethods.fromHex(Panel4SubSector.jcb4Pop.getSelectedItem()
      .toString().substring(0, 1)));
    //Infrastructure  2d+importance
    in = (GlobalMethods.roll2d()) + (GlobalMethods.fromHex(get("impo")));
    //Barriers        2d-2
    ba = (GlobalMethods.roll2d()) + (-2);
    econ = "" + GlobalMethods.toHex(re) + GlobalMethods.toHex(la)
      + GlobalMethods.toHex(in) + GlobalMethods.toHex(ba);
    //</editor-fold>
    jta.append("  Resources = " + re + CRLF);
    jta.append("  Labour = " + la + CRLF);
    jta.append("  Infrastructure = " + in + CRLF);
    jta.append("  Barriers = " + ba + CRLF);
    return econ;
  }
  private static String econ;
  private static int re;
  private static int la;
  private static int in;
  private static int ba;

  private static String getImportance() {
    //<editor-fold defaultstate="collapsed" desc="impo">
    int imp = 0;
    if ("A" == get("port") | "B" == get("port")) {
      imp += 1;
    }
    if ("D".equals(get("port")) | "E".equals(get("port")) | "X".equals(get(
      "port"))) {
      imp -= 1;
    }
    if (GlobalMethods.fromHex(get("tech")) > 9) {
      imp += 1;
    }
    if (GlobalMethods.fromHex(get("tech")) < 7) {
      imp -= 1;
    }
    // +1 per Ag Hi In Pi Ri Pr Pa
    String[] target = {
      "Ag", "Hi", "In", "Pi", "Ri", "Pr", "Pa"
    };
    for (int i = 0; i < target.length; i++) {
      if (get("trad").contains(target[i])) {
        imp += 1;
      }
    }
    importance = "";
    if (imp > 3) {
      importance = " Important";
    }
    if (imp < 1) {
      importance = " Unimportant";
    }
    if (imp > 0) {
      start = "+";
    }
    if (imp < 0) {
      start = "";
    }
//PRIMUS = 4+ Importance
//SECUNDUS = 1 to 3 Importance
//TERTIUS = 0 to - 2 Importance
//QUATERNUS = -3 > Importance

    impo = start + imp;
    //</editor-fold>
    return impo + " " + importance;
  }
  private static String start;
  private static String impo;
  private static String importance;

  private static String getLocked() {
    //Close Satellites are tidally locked (but no twilight zone)
    lock = "Close Satellites";
    return lock;
  }
  private static String lock;

  private static String getMainworldType() {
    //<editor-fold defaultstate="collapsed" desc="mwty">
    num = GlobalMethods.rollFlux();
    switch (num) {
      case -6:
      case -3: {
        mwty = "Close satellite";
        break;
      }
      case -5:
      case -4: {
        mwty = "Far satellite";
        break;
      }
      default: {
        mwty = "Planet";
        break;
      }
    }
    int orbit = GlobalMethods.rollFlux();
    if (mwty.contains("Close satellite")) {
      //<editor-fold defaultstate="collapsed" desc="switch(orbit)">
      switch (orbit) {
        case -6: {
          mwty += " (Ay)";
          break;
        }
        case -5: {
          mwty += " (Bee)";
          break;
        }
        case -4: {
          mwty += " (Cee)";
          break;
        }
        case -3: {
          mwty += " (Dee)";
          break;
        }
        case -2: {
          mwty += " (Ee)";
          break;
        }
        case -1: {
          mwty += " (Eff)";
          break;
        }
        case 0: {
          mwty += " (Gee)";
          break;
        }
        case 1: {
          mwty += " (Aitch)";
          break;
        }
        case 2: {
          mwty += " (Eye)";
          break;
        }
        case 3: {
          mwty += " (Jay)";
          break;
        }
        case 4: {
          mwty += " (Kay)";
          break;
        }
        case 5: {
          mwty += " (Ell)";
          break;
        }
        case 6: {
          mwty += " (Emm)";
          break;
        }
        default: {
          break;
        }
      }
      mwty += " LK Tidally Locked";
      //</editor-fold>
    }
    if (mwty.contains("Far satellite")) {
      //<editor-fold defaultstate="collapsed" desc="switch(orbit)">
      switch (orbit) {
        case -6: {
          mwty += " (En)";
          break;
        }
        case -5: {
          mwty += " (Oh)";
          break;
        }
        case -4: {
          mwty += " (Pee)";
          break;
        }
        case -3: {
          mwty += " (Que)";
          break;
        }
        case -2: {
          mwty += " (Arr)";
          break;
        }
        case -1: {
          mwty += " (Ess)";
          break;
        }
        case 0: {
          mwty += " (Tee)";
          break;
        }
        case 1: {
          mwty += " (Yu)";
          break;
        }
        case 2: {
          mwty += " (Vee)";
          break;
        }
        case 3: {
          mwty += " (Dub)";
          break;
        }
        case 4: {
          mwty += " (Ex)";
          break;
        }
        case 5: {
          mwty += " (Wye)";
          break;
        }
        case 6: {
          mwty += " (Zee)";
          break;
        }
        default: {
          break;
        }
      }
      //</editor-fold>
    }
    if (MWName.equals("Regina")) {
      mwty = "Far satellite (Arr)";
    }
    //</editor-fold>
    return mwty;
  }
  private static String mwty;

  private static String getNIL() {
    //<editor-fold defaultstate="collapsed" desc="nil">
    int pop = GlobalMethods.fromHex(get("popu"));
    int atm = GlobalMethods.fromHex(get("atmo"));
    int tl = GlobalMethods.fromHex(get("tech"));
    int gov = GlobalMethods.fromHex(get("govt"));
    /*
     Pop Atm TL Comment (create sophonts as necessary)
     7+ 2-9 1+ Intelligent Life evolved on this world. Natives
     */
    if (pop > 6 & (atm > 1 & atm < 10) & tl > 1) {
      nati = "Intelligent Life evolved on this world";
      nat = "Natives";
    }
    /*
     7+ A+ 1+ Local Intelligent Life is incompatible with human environments
     Exotics
     */
    if (pop > 6 & atm > 9 & tl > 0) {
      nati = "Local Intelligent Life is incompatible with human environments";
      nat = "Exotics";
    }

    /*
     7+ 0-1 1+ Sophonts evolved elsewhere and settled here many years ago.
     Transplants
     */
    if (pop > 6 & (atm < 2) & tl > 0) {
      nati = "Intelligent Life evolved on this world";
      nat = "Natives";
    }

    /*
     0 2+ 1+ Intelligent Life evolved on this world, but is now extinct. Extinct
     */
    if (pop == 0 & atm > 1 & tl > 0) {
      nati = "Local Intelligent Life is incompatible with human environments";
      nat = "Exotics";
    }

    /*
     0 0-1 1+ Evidence of Transplants, but they are no longer present. Vanished
     */
    if (pop == 0 & atm < 2 & tl > 0) {
      nati = "Evidence of Transplants, but they are no longer present";
      nat = "Vanished";
    }

    /*
     1 - 2 - 3 Non-permanent commercial or scientific activity. Transients
     */
    if (pop == 1 & atm == 2 & tl == 3) {
      nati = "Non-permanent commercial or scientific activity";
      nat = "Transients";
    }

    /*
     4 - 5 - 6 The initial steps of creating a colony.Settlers
     */
    if (pop == 4 & atm == 5 & tl == 6) {
      nati = "The initial steps of creating a colony";
      nat = "Settlers";
    }

    /*
     if Gov = 1 Locals are company employees. Corporate.
     */
    if (gov == 1) {
      nati = "Locals are company employees";
      nat = "Corporate";
    }

    /*
     if Gov = 6 Locals are colonists from a nearby world. Colonists
     */
    if (gov == 6) {
      nati = "Locals are colonists from a nearby world";
      nat = "Colonists";
    }
    //</editor-fold>
    return nat + " - " + nati;
  }
  private static String nat;
  private static String nati;

  private static String getNobility() {
//    if (jf.getTitle() == "Regina") {
//      throw new Exception();
//    }
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.println("" + " = " + );
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="nobi">
//    JOptionPane.showMessageDialog(jf, get("trad"));
//    nobles = 0;
    nobi = "";
    titles = "";
    if (get("trad").contains("Pa") | get("trad").contains("Pr")) {
      nobi += "c";
      titles += "  Baronet - Pa Pr." + CRLF;
//      nobles += 1;
    }
    if (get("trad").contains("Ag") | get("trad").contains("Ri")) {
      nobi += "C";
      titles += "  Baron - Ag Ri." + CRLF;
//      nobles += 1;
    }
    if (get("trad").contains("Pi")) {
      nobi += "D";
      titles += "  Marquis - Pi." + CRLF;
//      nobles += 1;
    }
    if (get("trad").contains("Ph")) {
      nobi += "e";
      titles += "  Viscount - Ph." + CRLF;
//      nobles += 1;
    }
    if (get("trad").contains("Hi")) {
      nobi += "E";
      titles += "  Count - Hi." + CRLF;
//      nobles += 1;
    }
    if (get("trad").contains("In")) {
      nobi += "F";
      titles += "  Duke - In." + CRLF;
//      nobles += 1;
    }
    jta.append(titles);
    //</editor-fold>
//    JOptionPane.showMessageDialog(jf, get("trad"));
    return nobi;
  }
  private static String nobi;
  private static String titles;

  private static String getRU() {
    //
    int b = 5 - ba;
    if (b < 1) {
      b = 1;
    }
    return "" + (re * la * in * b);
  }

  private static String getTrade() {
    trad = "";
    //<editor-fold defaultstate="collapsed" desc="Planetary mods">
    //As Asteroid     s0
    if ("0".equals(get("size"))) {
      trad += "As ";
    }
    //De Desert             a2-9  h0
    if ("0".equals(get("hydr"))) {
      if (GlobalMethods.fromHex(get("atmo")) > 1 & GlobalMethods.fromHex(get(
        "atmo")) < 10) {
        trad += "De ";
      }
    }
    //Fl Fluid ocean        aA-C  h1-10
    if (!"0".equals(get("hydr"))) {
      if (GlobalMethods.fromHex(get("atmo")) > 9) {
        trad += "Fl ";
      }
    }
    //Ga Garden world s678  a568  h567
    if ("6".equals(get("size")) | "7".equals(get("size")) | "8".equals(get(
      "size"))) {
      if ("5".equals(get("atmo")) | "6".equals(get("atmo")) | "8".equals(get(
        "atmo"))) {
        if ("5".equals(get("hydr")) | "6".equals(get("hydr")) | "7".equals(get(
          "hydr"))) {
          trad += "Ga ";
        }
      }
    }
    //He Hell world   s3-10 a2-12 h0-2
    if (GlobalMethods.fromHex(get("size")) > 2 & GlobalMethods.fromHex(get(
      "size")) < 11) {
      if (GlobalMethods.fromHex(get("atmo")) > 1 & GlobalMethods.fromHex(get(
        "atmo")) < 13) {
        if (GlobalMethods.fromHex(get("hydr")) < 3) {
          trad += "He ";
        }
      }
    }
    //Ic Ice capped         a0-1  h1-10
    if (GlobalMethods.fromHex(get("atmo")) < 2) {
      if (GlobalMethods.fromHex(get("hydr")) > 0) {
        trad += "Ic ";
      }
    }
    //Oc Ocean world  sA-C        h10
    if (GlobalMethods.fromHex(get("size")) < 10) {
      if (GlobalMethods.fromHex(get("hydr")) == 10) {
        trad += "Oc ";
      }
    }
    //Va Vaccuum world      a0
    if (GlobalMethods.fromHex(get("atmo")) < 1) {
      trad += "Va ";
    }
    //Wa Water world  s5-9        h10
    if (GlobalMethods.fromHex(get("size")) > 4 & GlobalMethods.fromHex(get(
      "size")) < 10) {
      if (GlobalMethods.fromHex(get("hydr")) == 10) {
        trad += "Wa ";
      }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Population mods">
    //Di Dieback        p0 g0 l0 t>0
    if (GlobalMethods.fromHex(get("popu")) == 0) {
      if (GlobalMethods.fromHex(get("govt")) == 0) {
        if (GlobalMethods.fromHex(get("lawl")) == 0) {
          if (GlobalMethods.fromHex(get("tech")) > 0) {
            trad += "Di ";
          }
        }
      }
    }
    //Ba Barren         p0 g0 l0 t0
    if (GlobalMethods.fromHex(get("popu")) == 0) {
      if (GlobalMethods.fromHex(get("govt")) == 0) {
        if (GlobalMethods.fromHex(get("lawl")) == 0) {
          if (GlobalMethods.fromHex(get("tech")) == 0) {
            trad += "Ba ";
          }
        }
      }
    }
    //Lo Low pop        p1-3
    if (GlobalMethods.fromHex(get("popu")) > 1
      & GlobalMethods.fromHex(get("popu")) < 4) {
      trad += "Lo ";
    }
    //Ni Non industrial p4-6
    if (GlobalMethods.fromHex(get("popu")) > 3
      & GlobalMethods.fromHex(get("popu")) < 7) {
      trad += "Ni ";
    }
    //Ph Pre hi         p8
    if (GlobalMethods.fromHex(get("popu")) == 8) {
      trad += "Ph ";
    }
    //Hi High pop       p>8
    if (GlobalMethods.fromHex(get("popu")) > 8) {
      trad += "Hi ";
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Economic mods">
    //Pa Pre agricultural a4-9 h4-8 p4,8
    if (GlobalMethods.fromHex(get("atmo")) > 3 & GlobalMethods.fromHex(get(
      "atmo")) < 10) {
      if (GlobalMethods.fromHex(get("hydr")) > 3 & GlobalMethods.fromHex(get(
        "hydr")) < 9) {
        if (GlobalMethods.fromHex(get("popu")) == 4 | GlobalMethods.fromHex(get(
          "popu")) == 8) {
          trad += "Pa ";
        }
      }
    }
    //Ag Agricultural     a4-9 h4-8 p5-7
    if (GlobalMethods.fromHex(get("atmo")) > 3 & GlobalMethods.fromHex(get(
      "atmo")) < 10) {
      if (GlobalMethods.fromHex(get("hydr")) > 3 & GlobalMethods.fromHex(get(
        "hydr")) < 9) {
        if (GlobalMethods.fromHex(get("popu")) > 4 & GlobalMethods.fromHex(get(
          "popu")) < 8) {
          trad += "Ag ";
        }
      }
    }
    //Na Non agricultural a0-3 h0-3 p>5
    if (GlobalMethods.fromHex(get("atmo")) < 4) {
      if (GlobalMethods.fromHex(get("hydr")) < 4) {
        if (GlobalMethods.fromHex(get("popu")) > 5) {
          trad += "Na ";
        }
      }
    }
    //Pi Pre industrial   a<10 p7-8
    if (GlobalMethods.fromHex(get("atmo")) < 10) {
      if (GlobalMethods.fromHex(get("popu")) > 6 & GlobalMethods.fromHex(get(
        "popu")) < 9) {
        trad += "Pi ";
      }
    }
    //In Industrial       a<10 p>8
    if (GlobalMethods.fromHex(get("atmo")) < 10) {
      if (GlobalMethods.fromHex(get("popu")) > 8) {
        trad += "In ";
      }
    }
    //Po Poor             a2-5  h0-3
    if (GlobalMethods.fromHex(get("atmo")) > 1 & GlobalMethods.fromHex(get(
      "atmo")) < 6) {
      if (GlobalMethods.fromHex(get("hydr")) < 4) {
        trad += "Po ";
      }
    }
    //Pr Pre rich         a6,8  p5,9
    if (GlobalMethods.fromHex(get("atmo")) == 6 | GlobalMethods.fromHex(get(
      "atmo")) == 8) {
      if (GlobalMethods.fromHex(get("popu")) == 5 | GlobalMethods.fromHex(get(
        "popu")) == 9) {
        trad += "Pr ";
      }
    }
    //Ri Rich             a6,8  p6-8
    if (GlobalMethods.fromHex(get("atmo")) == 6 | GlobalMethods.fromHex(get(
      "atmo")) == 8) {
      if (GlobalMethods.fromHex(get("popu")) > 5 & GlobalMethods.fromHex(get(
        "popu")) < 9) {
        trad += "Ri ";
      }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Climate mods">
    //Fr Frozen         S2-9 H>0 >HZ
    if (GlobalMethods.fromHex(get("size")) > 1 & GlobalMethods.fromHex(get(
      "size")) < 10) {
      if (GlobalMethods.fromHex(get("hydr")) > 0) {
//        if (Orbit > Integer.parseInt(hzva)) {
        trad += "Fr ";
//        }
      }
    }
    //Ho Hot            HZ-1
//    if (Orbit < Integer.parseInt(hzva)) {
//      trad += "Ho ";
//    }
    //Co Cold           HZ+1
//    if (Orbit > Integer.parseInt(hzva)) {
//      trad += "Co ";
//    }
    //Lk Locked         Close satellite
    //Tr Tropic         s6-9 a4-9 h3-7 <HZ
    if (GlobalMethods.fromHex(get("size")) > 5 & GlobalMethods.fromHex(get(
      "size")) < 10) {
      if (GlobalMethods.fromHex(get("atmo")) > 3 & GlobalMethods.fromHex(get(
        "atmo")) < 10) {
        if (GlobalMethods.fromHex(get("hydr")) > 2 & GlobalMethods.fromHex(get(
          "hydr")) < 8) {
//          if (Orbit < Integer.parseInt(hzva)) {
//            trad += "Tr ";
//          }
        }
      }
    }
    //Tu Tundra         s6-9 a4-9 h3-7 >HZ
    if (GlobalMethods.fromHex(get("size")) > 5 & GlobalMethods.fromHex(get(
      "size")) < 10) {
      if (GlobalMethods.fromHex(get("atmo")) > 3 & GlobalMethods.fromHex(get(
        "atmo")) < 10) {
        if (GlobalMethods.fromHex(get("hydr")) > 2 & GlobalMethods.fromHex(get(
          "hydr")) < 8) {
//          if (Orbit > Integer.parseInt(hzva)) {
//            trad += "Tu ";
//          }
        }
      }
    }
    //Tz Twilight Zone  Orbit 0-1
//    if (Orbit < 2) {
//      trad = "Tz";
//    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Secondary mods">
    //Fa Farming  a456789 h45678 p23456 Not MW. HZ
    if (GlobalMethods.fromHex(get("atmo")) > 1 & GlobalMethods.fromHex(get(
      "atmo")) < 13) {
      if (GlobalMethods.fromHex(get("hydr")) < 3) {
        if (GlobalMethods.fromHex(get("popu")) > 2 & GlobalMethods.fromHex(get(
          "popu")) < 11) {
////          if (Orbit == Integer.parseInt(hzva) & !MW) {
////            trad += "Fa ";//Other worlds/satellites in HZ
////          }
        }
      }
    }
    //Mi Mining   p2-6 !MW MW=In
    if (GlobalMethods.fromHex(get("popu")) > 1 & GlobalMethods.fromHex(get(
      "popu")) < 7) {
//      if (Orbit == Integer.parseInt(hzva) & getTrade(Orbit).contains("In")) {
//        if (!MW) {
//          trad += "Mi ";//Other worlds/satellites in HZ
//        }
//      }
    }
    //Co Colony   p5-10 g6 l0-3
    if (GlobalMethods.fromHex(get("popu")) > 4 & GlobalMethods.fromHex(get(
      "popu")) < 11) {
      if (GlobalMethods.fromHex(get("govt")) == 6) {
        if (GlobalMethods.fromHex(get("lawl")) < 4) {
          trad += "Co ";
        }
      }
    }
    //Pe Penal Colony   p3-7 g6 l6-9
    if (GlobalMethods.fromHex(get("popu")) > 2 & GlobalMethods.fromHex(get(
      "popu")) < 8) {
      if (GlobalMethods.fromHex(get("govt")) == 6) {
        if (GlobalMethods.fromHex(get("lawl")) > 5 & GlobalMethods.fromHex(get(
          "lawl")) < 10) {
          trad += "Pe ";
        }
      }
    }
    //Re Reserve        p1-4 g6 l4-5
    if (GlobalMethods.fromHex(get("popu")) > 0 & GlobalMethods.fromHex(get(
      "popu")) < 5) {
      if (GlobalMethods.fromHex(get("govt")) == 6) {
        if (GlobalMethods.fromHex(get("lawl")) > 3 & GlobalMethods.fromHex(get(
          "lawl")) < 6) {
          trad += "Re ";
        }
      }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Political mods">
    //Cp  SubSector Capital
    //Cs  Sector Capital
    //Cx  Capital
    //An  Ancients Site
    //Ab  AAB Data repository
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Special mods">
    //Sa
    //Fo
    //Pz
    //Da
    //</editor-fold>
    return trad.trim();
  }
  private static String trad;

  private static String getTwilightZone() {
    //Worlds in Orbits 0 & 1 are tidally locked
    //and have a Twilight Zone
    twil = "Orbits 0 & 1";
    return twil;
  }
  private static String twil;

  private static int getOrbitals() {
//    jta.append("  Stars = " + starnum.getText() + CRLF);
//    jta.append("  Mainworld = " + mw.getText() + CRLF);
//    jta.append("  GGs = " + ggs.getText() + CRLF);
//    jta.append("  Belts = " + pbs.getText() + CRLF);
//    jta.append("  Other worlds = " + oth.getText() + CRLF);
    String[] string = new String[]{
      starnum.getText(),
      mw.getText(),
      ggs.getText(),
      pbs.getText(),
      oth.getText()
    };
    int[] parts = new int[string.length];
    int total = 0;
    for (int i = 0; i < string.length; i++) {
      parts[i] = Integer.parseInt(string[i]);
      total += parts[i];
    }
    return total;
  }

  private static String getZone() {
    //<editor-fold defaultstate="collapsed" desc="zone">
    zone = Panel4SubSector.jcb4Zone.getSelectedItem().toString();
    if (zone.equals("")) {
      zone = "Green";
    }
    if (zone.startsWith("R")) {
      zone = "Red";
    }
    if (zone.startsWith("A")) {
      zone = "Amber";
    }

    //</editor-fold>
    return zone;
  }//Travel Zones
  private static String zone;

  private static String getSystemLimits(int o, String type, int dec, String size) {
    String hz = getHZ(type, dec, size);
    if (dec < 5) {
      dec = 0;
    } else {
      dec = 5;
    }
    String habz = "  Habitable Zone = " + hz;
    String a = "  10 diameter Grav Limit past Orbit ";
    String a2 = getStringFromTable("St", type + dec, size, gravlimit);
    String b = "  100 diameter Jump Limit past Orbit ";
    String b2 = getStringFromTable("St", type + dec, size, jumplimit);
    String c = "  1000 diameter Maneuver Limit past Orbit ";
    String c2 = getStringFromTable("St", type + dec, size, jumplimit);
    return habz + CRLF + a + check(a2) + CRLF + b + check(b2) + CRLF + c
      + check(
        c2) + CRLF;
  }
  //<editor-fold defaultstate="collapsed" desc="10D">
  /*
   THE 10D GRAVITIC DRIVE LIMIT
   */
  static String[] gravlimit = new String[]{
    "9",
    "St", "Ia", "Ib", "II", "III", "IV", "V", "VI", "D",
    "A0", "7", "5", "4", "1", "1", "0", "*", "*",
    "A5", "7", "5", "3", "1", "0", "*", "*", "*",
    "F0", "7", "6", "3", "1", "0", "*", "*", "*",
    "F5", "7", "6", "4", "1", "0", "*", "*", "*",
    "G0", "8", "6", "4", "1", "0", "*", "*", "*",
    "G5", "9", "7", "5", "3", "0", "*", "*", "*",
    "K0", "10", "7", "6", "3", "0", "*", "*", "*",
    "K5", "10", "8", "7", "", "5", "*", "*", "*",
    "M0", "11", "10", "8", "", "6", "*", "*", "*",
    "M5", "11", "11", "9", "", "8", "*", "*", "*",
    "M9", "12", "11", "10", "", "8", "*", "*", "*"
  };
  //10 D Limit is beyond the Orbit Number shown.
  //* = inside Orbit  0.
  //Blank(K5-M9 IV, A0-F4 VI). Not possible.
  //Gravitic Drives (G-Drives) cannot operate outside the 10D Limit.
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="100D">
  /*
   THE 100D JUMP DRIVE LIMIT
   */
  static String[] jumplimit = new String[]{
    "9",
    "St", "Ia", "Ib", "II", "III", "IV", "V", "VI", "D",
    "A0", "10", "9", "7", "6", "5", "", "5", "*",
    "A5", "10", "9", "7", "5", "4", "", "4", "*",
    "F0", "11", "9", "7", "5", "4", "", "3", "*",
    "F5", "11", "9", "7", "5", "4", "3", "3", "*",
    "G0", "11", "10", "8", "6", "4", "2", "2", "*",
    "G5", "12", "10", "8", "7", "4", "2", "1", "*",
    "K0", "12", "11", "9", "7", "5", "2", "0", "*",
    "K5", "13", "12", "10", "", "9", "1", "0", "*",
    "M0", "14", "13", "11", "", "9", "1", "0", "*",
    "M5", "15", "14", "13", "", "11", "0", "*", "*",
    "M9", "15", "15", "13", "", "12", "*", "*", "*"
  };
  //100 D Limit is within the Orbit Number shown.
  //* = inside Orbit 0.
  //Blank(K5-M9 IV, A0-F4 VI). Not possible.
  //Jump Drives cannot operate inside the 100DLimit.
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="1000D">
  /*
   THE 1000D MANEUVER DRIVE LIMIT
   */
  static String[] manlimit = new String[]{
    "9",
    "St", "Ia", "Ib", "II", "III", "IV", "V", "VI", "D",
    "A0", "13", "12", "11", "9", "9", "", "8", "*",
    "A5", "14", "12", "10", "9", "8", "", "7", "*",
    "F0", "14", "12", "10", "9", "8", "", "7", "*",
    "F5", "14", "12", "11", "9", "8", "7", "7", "*",
    "G0", "15", "13", "11", "9", "8", "6", "6", "*",
    "G5", "15", "14", "12", "10", "8", "6", "5", "*",
    "K0", "16", "14", "12", "10", "8", "6", "5", "*",
    "K5", "16", "15", "13", "", "12", "6", "5", "*",
    "M0", "17", "16", "14", "", "12", "5", "4", "*",
    "M5", "18", "17", "16", "", "14", "5", "2", "*",
    "M9", "18", "18", "16", "", "15", "4", "1", "*"
  };
  //1000 D Limit is beyond Orbit Number shown.
  //* = inside Orbit 0.
  //Blank(K5-M9 IV, A0-F4 VI). Not possible.
  //Maneuver Drives (M-Drives) cannot operate outside the 1000D Limit.
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="Placing worlds">
  /*
   G PLACING WORLDS
   Chart G places the Mainworld in a specific Orbit and
   creates and places other worlds in the system. If the supply
   of worlds exceeds the available orbits, the excess worlds are
   ignored.
   Placing Worlds
   Worlds in a system must be places in orbits.
   The Placing Worlds Chart provides priorities and deals with
   several exceptions.
   The Mainworld is placed first. If it is a satellite, then a Gas
   Giant must be placed in that orbit to accommodate it. If there
   is no Gas Giant in the system, then a BigWorld (Size=-2D +7)
   must be placed in that orbit.
   If the Mainworld is an Asteroid Belt, it is placed using the
   Belt Column of the Basic Placement Chart without regard to
   Habitable Zone.
   Rotate Placement. The Placing Worlds Chart calls for
   Rotating Placement of various worlds in the system. If the
   system has more than one star (Close, Near, Far), place the
   first of the worlds concerned in orbit around the Primary, the
   second in orbit around the Close, the third in orbit around the
   Near, and the fourth in orbit around the Far (if possible).
   Repeat the process if necessary.
   Precluded Orbits. Some stars re so large that they engulf
   some of the orbits in the system and preclude their
   availablility.
   The Surface of the Star… Column of the Orbital Distance
   Chart 5a (in the Ranges Chapter) shows preculuded orbits.
   Worlds other than the Mainworld are subject to restrictions:
   Maximum Population is Mainworld Population minus 1. All
   worlds other than the Mainworld have Spaceports rather than
   Starports.
   Other Worlds
   The creation of additional worlds uses a simplified
   procedure:
   Inner Worlds are in orbits HZ minus 2 or more.
   Hospitable Worlds are in orbits HZ – 1 to HZ +1.
   Outer Worlds are in orbits HZ +2 or greater.
   Consult the charts to determine the specific type of world
   and then create it using the information from the Other
   Worlds column.
   Similar tables direct the creation of Satellites as necessary.
   Hospitables are potentially habitable or exploitable worlds
   located in the Habitable Zone.
   Planetoids are the worldlets of a Belt. The Population,
   Government, and Law Level represent the general level
   throughout the Belt.
   Iceworlds are frozen worlds beyond the HZ.
   RadWorlds are worlds with extreme levels of radiation.
   Local values for RadWorlds are provided in Range Table 3b
   Strangeworlds.
   Infernos are worlds with extremes of temperature. Local
   values for Infernos are provided in Range Table 3b
   Strangeworlds.
   BigWorlds are worlds with larger than expected Size.
   Occasionally, a satellite Mainworld in a system without Gas
   Giants requires a BigWorld as its primary. Bigworld may also
   occur throughout a system.
   Worldlets are worlds with generally small Size.
   Inner Worlds are located starward of the Habitable Zone.
   Stormworlds are worlds wracked by constant atmospheric
   turbulence. Local values for Stormworld are provided in
   Range Table 3b Strangeworlds.
   Satellites
   When necessary, satellites for worlds and for gas giants
   can be generated.
   Ring. The table may create one or more Rings.
   Even More Worlds
   This system does not create the many small chunks of rock
   and ice throughout most systems.






   W WORLDS
   Total Worlds In System=
   + Mainworld
   + Gas Giants
   + Belts
   + 2D
   PLACING WORLDS
   Place Mainworld If Satellite, place GG in MW Orbit.
   If Satellite and No Giants, place a BigWorld in MW Orbit.
   If Asteroid Belt, place as Belt without regard to HZ.
   Place Gas Giants Rotate Placement Per Star.
   Place Planetoid Belts Rotate Placement Per Star.
   Place Other Worlds Rotate Placement Per Star, place worlds using World1
   Column.
   Last World, place using World2 Column.
   OTHER WORLDS
   Subject to
   Max Pop =MW Pop - 1.
   St= Spaceport.
   Hospitable= StSAHPGL-T
   Planetoids= St000PGL-T
   Iceworld= StSAHPGL-T
   Pop= DM - 6
   RadWorld= StSAH000-0
   Siz= 2D
   Inferno= YSB0000-0
   Siz= 2D
   BigWorld= StSAHPGL-T
   Siz= 2D +7
   any with Siz= B+ is BW.
   GG GAS GIANTS
   2D Size WSize Diameter Type
   1 L 20 20,000 miles SGG
   2 M 21 30,000 miles SGG
   3 N 22 40,000 miles SGG
   4 P 23 50,000 miles SGG
   5 Q 24 60,000 miles SGG
   6 R 25 70,000 miles LGG
   7 S 26 80,000 miles LGG
   8 T 27 90,000 miles LGG
   9 U 28 100,000 miles LGG
   10 V 29 110,000 miles LGG
   11 W 30 120,000 miles LGG
   12 X 31 130,000 miles LGG
   Convert every second SGG Small
   Gas Giant to IGG Ice Giant (of the
   same size).
   Convert every fifth LGG to a BD
   Brown Dwarf (of Siz x 4; mark Size
   with* as in R*).
   BASIC PLACEMENT CHART
   2D LGG SGG IG Belt World1 World2
   2 - 3 - 2 +1 - 1 10 17
   3 - 2 - 1 +2 HZ 8 16
   4 - 1 HZ +3 +1 6 15
   5 HZ +1 +4 +2 4 14
   6 +1 +2 +5 +3 2 13
   7 +2 +3 +6 +4 0 12
   8 +3 +4 +7 +5 1 11
   9 +4 +5 +8 +6 3 10
   10 +5 +6 +9 +7 5 9
   11 +6 +7 +10 +8 7 8
   12 +7 +8 +11 +9 0 7
   GG and Belt placement is based on the HZ.
   World placement is based on Orbit.
   If an orbit is duplicated or precluded, adjust to
   an adjacent or the closest possible orbit.
   Gas Giant Skimming: Ship’s G must exceed
   World Size/8.
   Worldlet= StSAHPGL-T
   Siz= 1D - 3
   Inner World StSAHPGL-T
   Pop= DM - 4
   Hyd= DM - 4
   Stormworld StSAHPGL-T
   Siz= 2D
   Atm= DM +4
   Hyd= DM - 4
   Pop= DM – 6
   NUMBER OF SATELLITES
   Gas Giants= 1D-1
   Inners = 1D-5
   Hospitables= 1D-4
   Outers= 1D-3
   = total number of satellites
   for the world.
   The Inner Worlds
   = Orbits inside HZ - 1.
   - HZ INNERS
   1D Description
   1 Worldlet
   2 Inferno
   3 Inner World
   4 BigWorld
   5 Stormworld
   6 Radworld
   INNER SATELLITES
   1D Description
   1 Worldlet
   2 Worldlet
   3 Inferno
   4 Inner World
   5 Stormworld
   6 Radworld
   7 Bigworld
   The Hospitables
   = Orbits HZ-1, HZ, HZ+1.
   HZ HOSPITABLES
   Code Description
   1 Worldlet
   2 Inferno
   3 Hospitable
   4 BigWorld
   5 Stormworld
   6 Radworld
   HOSPITABLE SATELLITES
   1D Description
   1 Worldlet
   2 Worldlet
   3 Inferno
   4 Hospitable
   5 Stormworld
   6 Radworld
   7 Bigworld
   The Outer Worlds
   = Orbits beyond HZ+1.
   +HZ OUTERS
   Code Description
   1 Worldlet
   2 Iceworld
   3 Iceworld
   4 BigWorld
   5 Iceworld
   6 Radworld
   OUTER SATELLITES
   1D Description
   1 Worldlet
   2 Worldlet
   3 Iceworld
   4 Innerworld
   5 Stormworld
   6 Radworld
   7 Bigworld
   Zero exactly = Ring and
   reroll. Treat less than zero
   as none.
   DM+1 if satellite of GG.
   Close Satellites are Locked to the Planet.
   If Satellite Size is equal or greater than Planet Size, reduce it to Planet
   Size -3.







   */
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="comment">
//  private static String xgetStars() {
//    stars = countStars();
//    do {
//      starcount = 0;
//      int Flux = 0;
//      int ComFlux = 0;
//      int PrimFlux = GlobalMethods.rollFlux();
//      int PrimComFlux = GlobalMethods.rollFlux();
//      int CloseFlux = GlobalMethods.rollFlux();
//      int CloseComFlux = GlobalMethods.rollFlux();
//      int NearFlux = GlobalMethods.rollFlux();
//      int NearComFlux = GlobalMethods.rollFlux();
//      int FarFlux = GlobalMethods.rollFlux();
//      int FarComFlux = GlobalMethods.rollFlux();
//      StarText = "";
//      String s = "";
//      String s2 = "";
//      for (int i = 0; i < 4; i++) {
//        if (i == 0) {
//          Flux = PrimFlux;
//          ComFlux = PrimComFlux;
//          s = "Primary";
//          s2 = " (Center)";
//        } else if (i == 1) {
//          Flux = CloseFlux;
//          ComFlux = CloseComFlux;
//          s = "Close";
//          s2 = " (Inner System)";
//        } else if (i == 2) {
//          Flux = NearFlux;
//          ComFlux = NearComFlux;
//          s = "Near";
//          s2 = " (Outer System)";
//        } else if (i == 3) {
//          Flux = FarFlux;
//          ComFlux = FarComFlux;
//          s = "Far";
//          s2 = " (Remote System)";
//        }
//        if (Stars[i] != "" & getStringFromTable("Flux", "" + Flux, s, SystemStars).equals(s)) {
//          StarText += Stars[i] + " " + s + " Star ";
//          starcount += 1;
//          if ("Companion".equals(getStringFromTable("Flux", "" + ComFlux, "Companion", SystemStars))) {
//            StarText += " + Companion";
//          }
//          StarText += s2 + CRLF;
//        } else {
//          s = "";
//        }
//      }
//    } while (starcount != stars);
//    //JOptionPane.showMessageDialog(mw, StarText);
//    return "" + stars;
//  }
//</editor-fold>
  private static int starcount = 0;
  static String[] Stars = new String[4];
  private static String[] str;
  private static String stardesc = "";
  private static int num;

  private static String getWorldName() {
    //jta.append("" + MWName.toUpperCase() + CRLF + CRLF);
    return MWName;
  }

  private static int countStars() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.println("" + " = " + );
    }
//</editor-fold>
    String txt = null;
    int counter;
    counter = 0;
    for (int i = 0; i < 4; i++) {
      try {
        if (i == 0) {
          txt = Panel4SubSector.jcb4Star1.getSelectedItem().toString();
        }
        if (i == 1) {
          txt = Panel4SubSector.jcb4Star2.getSelectedItem().toString();
        }
        if (i == 2) {
          txt = Panel4SubSector.jcb4Star3.getSelectedItem().toString();
        }
        if (i == 3) {
          txt = Panel4SubSector.jcb4Star4.getSelectedItem().toString();
        }
        Stars[i] = txt;

        if (!Stars[i].isEmpty()) {
          counter += 1;
        }
      } catch (Exception e) {
        txt = Stars[i];
      }
    }
    starnum.setText("" + counter);
    return counter;
  }

  private static int doCalc() {
    JLabel lab = null;
    int total = 0;
    int ist = Integer.parseInt(starnum.getText());
    int imw = 1;
    try {
      pbs.setText(Panel4SubSector.jcb4PAG.getSelectedItem().toString()
        .substring(1, 2));
      ggs.setText(Panel4SubSector.jcb4PAG.getSelectedItem().toString()
        .substring(2, 3));
      oth.setText("" + GlobalMethods.roll2d());
//      oth.setText("" + oth.getText());
    } catch (Exception e) {

    }
    for (int i = 0; i < 5; i++) {
      switch (i) {
        case 0: {
          lab = starnum;
          break;
        }
        case 1: {
          lab = mw;
          break;
        }
        case 2: {
          lab = ggs;
          break;
        }
        case 3: {
          lab = pbs;
          break;
        }
        case 4: {
          lab = oth;
          break;
        }
        default: {
          lab = oth;
        }
      }
      total += Integer.parseInt(lab.getText());
//      //System.out.println("i = " + i + " = " + total);
    }
    totalled.setText("" + total);
    return total;
  }

  private static String getStars() {
    stars = Integer.parseInt(starnum.getText());
    String s1 = null, s2 = null, s3 = null;
    int o1 = -1, o2 = -1, o3 = -1;// o=Maximum orbital position number
    int rnd1, rnd2, rnd3;
    StarText = Stars[0] + " Center" + CRLF;
    //<editor-fold defaultstate="collapsed" desc="if (stars == 1)">
    if (stars == 1) {//no extras required
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="if (stars == 2)">
    if (stars == 2) {//pick random for 2nd}
      rnd1 = (int) (Math.random() * 3) + 1;
      switch (rnd1) {
        case 1: {
          s1 = "Inner";
          o1 = GlobalMethods.roll1d() - 1;
          break;
        }
        case 2: {
          s1 = "Outer";
          o1 = GlobalMethods.roll1d() + 5;
          break;
        }
        case 3: {
          s1 = "Remote";
          o1 = GlobalMethods.roll1d() + 11;
          break;
        }
      }
      StarText += Stars[1] + " " + s1 + " @ " + o1 + CRLF;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="if (stars == 3)">
    if (stars == 3) {//pick MT, include others}
      rnd1 = (int) (Math.random() * 3) + 1;
      switch (rnd1) {
        case 1: {//Inner system clear
          s1 = "Outer";
          o1 = GlobalMethods.roll1d() + 5;
          s2 = "Remote";
          o2 = GlobalMethods.roll1d() + 11;
          break;
        }
        case 2: {//Outer system clear
          s1 = "Inner";
          o1 = GlobalMethods.roll1d() - 1;
          s2 = "Remote";
          o2 = GlobalMethods.roll1d() + 11;
          break;
        }
        case 3: {//Remote system clear
          s1 = "Inner";
          o1 = GlobalMethods.roll1d() - 1;
          s2 = "Outer";
          o2 = GlobalMethods.roll1d() + 5;
          break;
        }
      }
      StarText += Stars[1] + " " + s1 + " @ " + o1 + CRLF;
      StarText += Stars[2] + " " + s2 + " @ " + o2 + CRLF;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="if (stars == 4)">
    if (stars == 4) {//pick all, include all}
      s1 = "Inner";
      o1 = GlobalMethods.roll1d() - 1;
      s2 = "Outer";
      o2 = GlobalMethods.roll1d() + 5;
      s3 = "Remote";
      o3 = GlobalMethods.roll1d() + 11;
      StarText += Stars[1] + " " + s1 + " @ " + o1 + CRLF;
      StarText += Stars[2] + " " + s2 + " @ " + o2 + CRLF;
      StarText += Stars[3] + " " + s3 + " @ " + o3 + CRLF;
    }
    //</editor-fold>
    return starnum.getText();
  }

  private static String getType() {
    return Stars[0] + "  " + Stars[1] + "  " + Stars[2] + "  " + Stars[3];
  }

  private static String placeStars() {
    systems = 1;
    String[] strs = StarText.split(CRLF);
    orb = new int[4];
    orb[0] = 18;
    for (int i = 0; i < 18; i++) {
      Orbits[i] = "" + i + "\t";
    }
    for (int i = 0; i < strs.length; i++) {
      if (strs[i].contains("@")) {
        int pos = strs[i].indexOf("@") + 2;
        int j = Integer.parseInt(strs[i].substring(pos));
        Orbits[j] += " " + strs[i].substring(0, pos - 3);
        if (Integer.parseInt(getHZ(Stars[i])) > -1) {
          Orbits[j] += " HZ=" + getHZ(Stars[i]);
        }
        if (j - 3 > -1) {
          systems += 1;
          orb[i] = j - 2;
          Orbits[j] += " max orbit = " + (j - 3);
        } else {
          orb[i] = 0;
          Orbits[j] += " NO ORBITS";
        }
      }
    }
    StarText = StarText.substring(0, StarText.length() - (4 - stars));
    //JOptionPane.showMessageDialog(mw, systems);
    return StarText;
  }
  private static int systems = 1;
  static int orb[];
//  static XPanel4T5StarSystem[] system;

  private static String placeMainworld() {
    num = Integer.parseInt(hzva);
    mainworldpos = "HZ" + (hzva) + " = " + (Integer.parseInt(getHZ(Stars[0]))
      + num);
    MWP = Integer.parseInt(getHZ(Stars[0])) + num + 2;
    if (MWP < 0) {
      MWP = 0;
    }
    Orbits[MWP] += " " + MWName + " " + Panel4SubSector.UWP.getText();
    if (mwty.contains("satellite")) {
      //string = getMoons("GG");
      if (Integer.parseInt(getGasGiants()) > 0) {
        Orbits[MWP] += " orbits a " + getGG() + " as " + mwty;// + " " + mwty + " of " + string;
      } else {
        Orbits[MWP] += " orbits a Big World: ";// +getBigWorld();
      }
    }
    return "" + mainworldpos;
  }
  private static String mainworldpos;
  private static int MWP;

  private static String getPB() {
    return "Planetoid Belt";
  }

  //<editor-fold defaultstate="collapsed" desc="GGs">
  static String[] GGs = {
    "5",
    "2D", "Size", "WSize", "Dia", "Type",
    "1", "L", "20", "20,000", "",
    "2", "M", "21", "30,000", "Neptune",
    "3", "N", "22", "40,000", "",
    "4", "P", "23", "50,000", "",
    "5", "Q", "24", "60,000", "",
    "6", "R", "25", "70,000", "Saturn",
    "7", "S", "26", "80,000", "",
    "8", "T", "27", "90,000", "Jupiter",
    "9", "U", "28", "125,000", "2Mj",
    "10", "V", "29", "180,000", "4Mj",
    "11", "W", "30", "220,000", "6Mj",
    "12", "X", "31", "250,000", "8Mj"
  };

  //</editor-fold>
  private static String getGG() {
    num = GlobalMethods.roll2d();
    String rep = getStringFromTable("2D", "" + num, "Dia", GGs);
    if (num < 4) {
      if (gasg % 2 == 0) {
        rep = " SGG (" + rep + " mi dia.) with ";
      } else {
        rep = " IG (" + rep + " mi dia.) with ";
        gasg += 1;
      }
    } else {
      rep = " LGG (" + rep + " mi dia.) with ";
    }
    return rep + getMoons("GG");
  }

  private static String getMoons(String type) {
    int moons = GlobalMethods.roll1d();
    //<editor-fold defaultstate="collapsed" desc="switch (type)">
    switch (type) {
      case "GG": {
        moons += -1;
        break;
      }
      case "Inn": {
        moons += -5;
        break;
      }
      case "Hos": {
        moons += -4;
        break;
      }
      case "Out": {
        moons += -3;
        break;
      }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="if (moons == 0)">
    if (moons == 0) {
      //ring and reroll
      int sats = GlobalMethods.roll1d();
      switch (type) {
        case "GG": {
          sats += -1;
          break;
        }
        case "Inn": {
          sats += -5;
          break;
        }
        case "Hos": {
          sats += -4;
          break;
        }
        case "Out": {
          sats += -3;
          break;
        }
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="if (moons == 0 & getMainworldType().contains("satellite"))">
      if (sats == 0 & getMainworldType().contains("satellite")) {
        return "Ring & 1 Moon";
      }
      //</editor-fold>
      if (sats == 0) {
        return "Ring";
      }
      if (sats > 1) {
        return "Ring and " + sats + " moons";
      }
      if (sats == 1) {
        return "Ring and 1 moon";
      }
    }
    if (moons == 0) {
      return "0 moons";
    }
    if (moons == 1) {
      return "1 moon";
    }
    return "" + moons + " moons";
  }

  private static String showMoons(String star, String type, int orb) {
//    String hz = getHZ(star);
    return type + " @ " + orb;
  }

  private static String gg;
  private static String size;

  private static String placeBelts() {
    belts = Integer.parseInt(Panel4SubSector.jcb4PAG.getSelectedItem()
      .toString().substring(1, 2));
    return "" + belts;
  }
  private static int belts;

  private static String placeOtherWorlds() {
    return oth.getText();
  }
  private static String othe;

  private static String getSystemCount() {
    return "" + systems;
  }

//<editor-fold defaultstate="collapsed" desc="comment">
//  private static String getOrbits() {
//    String strin = "" + CRLF;
//    strin += GlobalMethods.comment("=", 30);
//    String s = Stars[0] + " @ Center" + " HZ=" + getHZ(Stars[0]) + CRLF;
//    strin += s;
//    for (int i = 0; i < 20; i++) {
//      if (Orbits[i] != "" & Orbits[i] != null) {
//        s = "  " + Orbits[i] + CRLF;
//        strin += s;
//      } else {
//        s = "  " + i + "\t" + CRLF;
//        strin += s;
//      }
//    }
//    s = GlobalMethods.comment("=", 30);
//    strin += s;
//    jta.append(strin);
//    strin = "";
//    int orb;
//    int start;
//    for (int i = 0; i < 20; i++) {
//      if (Orbits[i].contains("Inner") & Orbits[i].contains("orbi =t")) {
//        start = Orbits[i].indexOf("orbit =") + 8;
//        orb = Integer.parseInt(Orbits[i].substring(start));
//        //JOptionPane.showMessageDialog(mw, orb);
//      }
//      if (Orbits[i].contains("Outer") & Orbits[i].contains("orbit =")) {
//        start = Orbits[i].indexOf("orbit =") + 8;
//        orb = Integer.parseInt(Orbits[i].substring(start));
//        //JOptionPane.showMessageDialog(mw, orb);
//      }
//      if (Orbits[i].contains("Remote") & Orbits[i].contains("orbit =")) {
//        start = Orbits[i].indexOf("orbit =") + 8;
//        orb = Integer.parseInt(Orbits[i].substring(start));
//        //JOptionPane.showMessageDialog(mw, orb);
//      }
//      if (Orbits[i].contains("Inner") & Orbits[i].contains("moon")) {
//        start = Orbits[i].indexOf("moon") - 3;
//        orb = Integer.parseInt(Orbits[i].substring(start));
//        //JOptionPane.showMessageDialog(mw, orb);
//      }
//      if (Orbits[i].contains("Outer") & Orbits[i].contains("moon")) {
//        start = Orbits[i].indexOf("moon") - 3;
//        orb = Integer.parseInt(Orbits[i].substring(start));
//        //JOptionPane.showMessageDialog(mw, orb);
//      }
//      if (Orbits[i].contains("Remote") & Orbits[i].contains("moon")) {
//        start = Orbits[i].indexOf("moon") - 3;
//        orb = Integer.parseInt(Orbits[i].substring(start));
//        //JOptionPane.showMessageDialog(mw, orb);
//      }
//    }
//    return "";
//  }
//</editor-fold>
  private static String StarText = "";
  static String Orbits[];

  private static String createOrbits() {
    len = Orbits.length;
    s = CRLF + Stars[0] + " HZ=" + getHZ(Stars[0]) + CRLF;
    for (int i = 0; i < 18; i++) {
      s += Orbits[i] + CRLF;
    }
    for (int i = 1; i < stars; i++) {
      s += CRLF + Stars[i] + " HZ=" + getHZ(Stars[i]) + CRLF;
      for (int j = 0; j < orb[i]; j++) {
        s += "" + j + "\t" + CRLF;
      }
    }
    txt = s.split(CRLF);
    len = txt.length;
    Orbits = new String[len];
    System.arraycopy(txt, 0, Orbits, 0, len);
    return "" + (len - (2 * stars));
  }
  private static int len;
  private static String[] txt;

  private static String getOrbitList() {
    for (int i = 0; i < Orbits.length; i++) {
      jta.append(Orbits[i] + CRLF);
    }
    return "" + (Orbits.length - (2 * stars));
  }
  private static String s;

  static void showOrbits(int star) {
    //System.out.println("    SHOW ORBITS FOR STAR " + star);
    int startnum = 0;
    if (star == 0) {
      startnum += 2;
    }
    if (star == 1) {
      startnum += 24;
    }
    if (star == 2) {
      startnum += 26 + orb[1];
    }
    if (star == 3) {
      startnum += 28 + orb[1] + orb[2];
    }
    for (int i = startnum; i < (startnum + orb[star]); i++) {
      //System.out.println(Orbits[i]);
      System.out.print("MT = " + isOrbitEmpty(star, i) + CRLF);
    }
  }

  private static Boolean isOrbitEmpty(int star, int orbit) {
    if (Orbits[orbit].endsWith("\t")) {
      return true;
    } else {
      return false;
    }
  }

  private static int getMaxOrbit(int star) {
    return orb[star] - 1;
  }

  private static String getInner() {
    //0 to before HZ-1
    num = GlobalMethods.roll1d() - 1;
    return inners[num];
  }
  //<editor-fold defaultstate="collapsed" desc="private static String[] inners">
  private static String[] inners = {
    "Worldlet",
    "Inferno",
    "Inner World",
    "Big World",
    "Storm World",
    "Rad World"
  };
  //</editor-fold>

  private static String getInnerSat(String parent) {
    //0 to before HZ-1 (hotter)
    num = GlobalMethods.roll1d() - 1;
    if (parent.contains("GG")) {
      num += 1;
    }
    return innersats[num];
  }
  //<editor-fold defaultstate="collapsed" desc="private static String[] innersats">
  private static String[] innersats = {
    "Worldlet",
    "Worldlet",
    "Inferno",
    "Inner World",
    "Storm World",
    "Rad World",
    "Big World"
  };
  //</editor-fold>

  private static String getOuter() {
    //0 to before HZ-1
    num = GlobalMethods.roll1d() - 1;
    return outers[num];
  }
  //<editor-fold defaultstate="collapsed" desc="private static String[] outers">
  private static String[] outers = {
    "Worldlet",
    "Ice World",
    "Ice World",
    "Big World",
    "Ice World",
    "Rad World"
  };
  //</editor-fold>

  private static String getOuterSat(String parent) {
    //beyond HZ+1 (colder)
    num = GlobalMethods.roll1d() - 1;
    if (parent.contains("GG")) {
      num += 1;
    }
    return outersats[num];
  }
  //<editor-fold defaultstate="collapsed" desc="private static String[] outersats">
  private static String[] outersats = {
    "Worldlet",
    "Worldlet",
    "Ice World",
    "Inner World",
    "Storm World",
    "Rad World",
    "Big World"
  };
  //</editor-fold>

  private static String getHosp() {
    //HZ-1(hot),HZ & HZ+1(cold)
    num = GlobalMethods.roll1d() - 1;
    return hosp[num];
  }
  //<editor-fold defaultstate="collapsed" desc="private static String[] outers">
  private static String[] hosp = {
    "Worldlet",
    "Inferno",
    "Hospitable World",
    "Big World",
    "Storm World",
    "Rad World"
  };
  //</editor-fold>

  private static String getHospSat(String parent) {
    //beyond HZ+1
    num = GlobalMethods.roll1d() - 1;
    if (parent.contains("GG")) {
      num += 1;
    }
    return hospsat[num];
  }
  //<editor-fold defaultstate="collapsed" desc="private static String[] outersats">
  private static String[] hospsat = {
    "Worldlet",
    "Worldlet",
    "Inferno",
    "Hospitable World",
    "Storm World",
    "Rad World",
    "Big World"
  };
  //</editor-fold>

  /**
   <p>
   @param jta   where to show table
   @param name  of table
   @param table to show
   */
  public static void showTable(JTextArea jta, String name, String[] table) {
    int c = Integer.parseInt(table[0]);
//    int r = 0;
    jta.append(name.toUpperCase() + CRLF);
    jta.append(dbviewer.globals.GlobalMethods.comment("=", 20) + CRLF);
    for (int i = 1; i < table.length; i++) {
      jta.append(table[i] + "\t");
      if (i % c == 0) {
        jta.append(CRLF);
      }
    }
//    jta.append(CRLF);
//    r += 1;
  }

  private static String getHZ(String star) {
    String type = star.substring(0, 1);
    int dec = Integer.parseInt(star.substring(1, 2));
    String siz = star.substring(3);
    return getHZ(type, dec, siz);
  }

  private static String getHabz() {
    int x = Integer.parseInt(starnum.getText());
    String ty, de, si;
    String[] linex = new String[x];
    String lines = "";
    for (int i = 0; i < x; i++) {
      ty = Stars[i].substring(0, 1);
      de = Stars[i].substring(1, 2);
      si = Stars[i].substring(3);
      linex[i] = "Star" + (i + 1) + " = " + getHZ(ty, Integer.parseInt(de), si);
      if (i < x - 1) {
        linex[i] += ", ";
      }
      //System.out.println(linex[i]);
      lines += linex[i];
//      JOptionPane.showMessageDialog(jf, linex[i]);
    }
    JOptionPane.showMessageDialog(jf, "" + lines);
    return lines;
  }

  private static String getHZoneVariance() {
    //<editor-fold defaultstate="collapsed" desc="hzva">
    num = GlobalMethods.rollFlux();
    switch (num) {
      case -6: {
        hzva = "-2";
        clim = "Extemely hot";
        break;
      }
      case -5:
      case -4:
      case -3: {
        hzva = "-1";
        clim = "Hot";
        break;
      }
      case -2:
      case -1:
      case 0:
      case 1:
      case 2: {
        hzva = "+0";
        clim = "Temperate";
        break;
      }
      case 3:
      case 4:
      case 5: {
        hzva = "+1";
        clim = "Cold";
        break;
      }
      case 6: {
        hzva = "+2";
        clim = "Extemely cold";
        break;
      }
    }
    //</editor-fold>
    if (MWName.contains("Regina")) {
      hzva = "+0";
      clim = "Temperate";
    }
    return hzva;
  }

  //<editor-fold defaultstate="collapsed" desc="HabZones">
  private static String[] HabZones = new String[]{
    "12",
    //    "Spectral", "A0-A3", "A4-A8", "A9-F1", "F2-F6", "F7-G1", "G2-G8", "G9-K3", "K4-K8", "K9-M3", "M4-M8", "M9",
    "Size", "A0", "A4", "A9", "F2", "F7", "G2", "G9", "K4", "K9", "M4", "M9",
    "Ia", "12", "12", "12", "12", "11", "12", "12", "12", "12", "12", "12",
    "Ib", "11", "11", "10", "10", "10", "10", "10", "10", "10", "11", "11",
    "II", "9", "9", "8", "8", "8", "8", "8", "9", "9", "10", "11",
    "III", "8", "8", "7", "6", "6", "6", "7", "7", "8", "8", "9",
    "IV", "7", "7", "6", "6", "5", "5", "5", "99", "99", "99", "99",
    "V", "7", "7", "6", "5", "4", "3", "2", "2", "0", "0", "0",
    "VI", "99", "99", "99", "3", "3", "2", "1", "0", "0", "0", "0",
    "VII", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"
  };

  //</editor-fold>
  private static String getHZ(String type, int dec, String size) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //System.out.println("type = " + type);
      //System.out.println("dec = " + dec);
      //System.out.println("size = " + size);
      ////System.out.println("" + " = " + );
    }
//</editor-fold>
    int x = 0;
//    String mod = "";
    switch (type) {
      case "A": {
        if (dec <= 3) {
          dec = 0;
        } else if (dec >= 4 & dec <= 8) {
          dec = 4;
        } else if (dec >= 9) {
          dec = 9;
        }
        break;
      }
      case "F": {
        if (dec <= 1) {
          type = "A";
          dec = 9;
        } else if (dec >= 2 & dec <= 6) {
          dec = 2;
        } else if (dec >= 7) {
          dec = 7;
        }
        break;
      }
      case "G": {
        if (dec <= 1) {
          type = "F";
          dec = 7;
        } else if (dec >= 2 & dec <= 8) {
          dec = 2;
        } else if (dec >= 9) {
          dec = 9;
        }
        break;
      }
      case "K": {
        if (dec <= 3) {
          type = "G";
          dec = 9;
        } else if (dec >= 4 & dec <= 8) {
          dec = 4;
        } else if (dec >= 9) {
          dec = 9;
        }
        break;
      }
      case "M": {
        if (dec <= 3) {
          type = "K";
          dec = 9;
        } else if (dec >= 4 & dec <= 8) {
          dec = 4;
        } else if (dec >= 9) {
          dec = 9;
        }
        break;
      }
    }
//    JOptionPane.showMessageDialog(jf, type + dec);
    try {
      x = Integer.parseInt(
        getStringFromTable("Size", size, type + dec, HabZones));
    } catch (NumberFormatException e) {
      //JOptionPane.showMessageDialog(jf, "STAR TYPE NOT AVAILABLE");
      //System.out.println("e" + " = " + e);
      //x = 15;
    }
    return "" + x;
  }

  private static String assessDec(String type, int decimal) {
    int d = 0;
    String ntype = null;
    switch (type) {
      case "A": {
        if (decimal <= 3) {
          d = 0;
        } else if (decimal >= 4 & decimal <= 8) {
          d = 4;
        } else if (decimal == 9) {
          d = 9;
        }
        break;
      }
      case "F": {
        if (decimal <= 1) {
          ntype = "A";
          d = 9;
        } else if (decimal >= 2 & decimal <= 6) {
          d = 2;
        } else if (decimal >= 7) {
          d = 7;
        }
        break;
      }
      case "G": {
        if (decimal <= 1) {
          ntype = "F";
          d = 7;
        } else if (decimal >= 2 & decimal <= 8) {
          d = 2;
        } else if (decimal == 9) {
          d = 9;
        }
        break;
      }
      case "K": {
        if (decimal <= 3) {
          ntype = "G";
          d = 9;
        } else if (decimal >= 4 & decimal <= 8) {
          d = 4;
        } else if (decimal == 9) {
          d = 9;
        }
        break;
      }
      case "M": {
        if (decimal <= 3) {
          ntype = "K";
          d = 9;
        } else if (decimal >= 4 & decimal <= 8) {
          d = 4;
        } else if (decimal == 9) {
          d = 9;
        }
        break;
      }
    }
    if (ntype == null) {
      ntype = type;
    }
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
      System.out.println(
        "type + dec = " + (type + decimal) + "  returning" + " = " + (ntype + d));
    }
//</editor-fold>
    return ntype + d;
  }

  private void hzTest() {
    String[] t = new String[]{
      "A", "F", "G", "K", "M",};
    String[] s = new String[]{
      "Ia", "Ib", "II", "III", "IV", "V", "VI", "VII"
    };
    for (int i = 0; i < t.length; i++) {
      //System.out.println(GlobalMethods.comment("=", 20));
      for (int j = 0; j < 10; j++) {
        //System.out.println("");
        for (int k = 0; k < s.length; k++) {
          if (Integer.parseInt(getHZ(t[i], j, s[k])) > -1) {
            //System.out.println(t[i] + j + s[k] + "  HZ = " + getHZ(t[i], j, s[k]));
          } else {
            //System.out.println(t[i] + j + s[k] + " NOT POSSIBLE");
          }
        }
      }
    }
  }

  private static String getStringFromTable(String column, String value,
    String column2, String[] tabledata) {
    // column  = title of table column that we compare with value to attain correct line of table
    // value   = string to compare to attain correct line of table
    // column2 = column to use for return value
    // tabledata = String[]
    try {
      int cols = Integer.parseInt(tabledata[0]);
      int col = 0;
      int i;
      for (i = 1; i <= cols; i++) {
        if (column.equals(tabledata[i])) {
          col = i;
//        jta.append("  col = " + tabledata[i] + CRLF);
          break;
        }
      }
      int j;
      int line = 0;
      for (j = col; j < tabledata.length; j += cols) {
        if (value.equals(tabledata[j])) {
//        jta.append("  value = " + tabledata[j] + CRLF);
//        jta.append("  line " + j / cols + CRLF);
          line = j / cols;
          break;
        }
      }

      int k;
      int col2 = 0;
      for (k = 1; k <= cols; k++) {
        if (column2.equals(tabledata[k])) {
          col2 = k;
//        jta.append("  col2 = " + tabledata[k] + CRLF);
          break;
        }
      }
//    jta.append("  return = " + tabledata[col2 + (line * cols)] + CRLF);
      return tabledata[col2 + (line * cols)];
    } catch (Exception e) {
      return null;
    }
  }
  //private static String returns;

  //<editor-fold defaultstate="collapsed" desc="Placement">
  /*
   2D LGG SGG IG Belt World1 World2
   GG and Belt placement is based on the HZ.
   World placement is based on Orbit.
   If an orbit is duplicated or precluded, adjust to
   an adjacent or the closest possible orbit.
   */
  static final String[] Placement = new String[]{
    "7",
    "2D", "LGG", "SGG", "IG", "Belt", "World1", "World2",
    "2", "-3", "-2", "+1", "-1", "10", "17",
    "3", "-2", "-1", "+2", "0", "8", "16",
    "4", "-1", "0", "+3", "+1", "6", "15",
    "5", "+0", "+1", "+4", "+2", "4", "14",
    "6", "+1", "+2", "+5", "+3", "2", "13",
    "7", "+2", "+3", "+6", "+4", "0", "12",
    "8", "+3", "+4", "+7", "+5", "1", "11",
    "9", "+4", "+5", "+8", "+6", "3", "10",
    "10", "+5", "+6", "+9", "+7", "5", "9",
    "11", "+6", "+7", "+10", "+8", "7", "8",
    "12", "+7", "+8", "+11", "+9", "10", "7"
  };

  //</editor-fold>
  private static String place(JLabel lab) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    jl = lab;
    int ol = Orbits.length;
    int placed = 0;
    if (Integer.parseInt(jl.getText()) > 0) {
      do {
        //<editor-fold defaultstate="collapsed" desc="switch (jl.getName())">
        switch (jl.getName()) {
          case "gg": {
            x = Integer.parseInt(ggs.getText());
            break;
          }
          case "pb": {
            x = Integer.parseInt(pbs.getText());
            break;
          }
          case "ot": {
            x = Integer.parseInt(oth.getText());
            break;
          }
          default: {
            //JOptionPane.showMessageDialog(jf, "ERROR in place(" + jl.getName() + ")");
          }
        }
        System.out.println("x" + " = " + x);
        //</editor-fold>
        star = 0;
        for (int i = 0; i < x; i++) {
          //<editor-fold defaultstate="collapsed" desc="switch (jl.getName())">
          switch (jl.getName()) {
            //<editor-fold defaultstate="collapsed" desc="gg">
            case "gg": {
              ob = getGG();
              if (ob.contains("LGG")) {
                placecol = "LGG";
              } else if (ob.contains("SGG")) {
                placecol = "SGG";
              } else if (ob.contains("IG")) {
                placecol = "IG";
              }
              break;
            }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="pb">
            case "pb": {
              ob = "Planetoid Belt";
              placecol = "Belt";
              break;
            }
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ot">
            case "ot": {
              placecol = "World1";
              if ((x - placed) == 1) {
                placecol = "World2";
              }
              if (i <= (hz1) & (i >= min)) {
                ob = getInner();
              }
              if ((i > (hz1)) & (i <= (hz1 + 3))) {
                ob = getHosp();
              }
              if ((i > hz1 + 3) & (i <= 22)) {
                ob = getOuter();
              }
              break;
            }
            //</editor-fold>
          }
          //</editor-fold>
          ty = Stars[star].substring(0, 1);
          de = Integer.parseInt(Stars[star].substring(1, 2));
          si = Stars[star].substring(3);
          starcol = assessDec(ty, de);
          roll = GlobalMethods.roll2d();
          System.out.println("star" + " = " + star);
          System.out.println("starcol" + " = " + starcol);
          System.out.println("ob" + " = " + ob);
          System.out.print(GlobalMethods.comment("-", 20));
          if (!placecol.contains("World")) {
            int hz = Integer.parseInt(getHZ(Stars[star]));
            System.out.println("\tHZ" + " = " + hz);
            int mod = Integer.parseInt(getStringFromTable("2D", "" + roll,
              placecol, Placement));
            System.out.println("\tmod" + " = " + mod);
            number = (hz + mod) + 2;
            System.out.println("\tindex = " + number);
            System.out.println("\torbit" + " = " + (number - 2));
          } else {
            int orb = Integer.parseInt(getStringFromTable("2D", "" + roll,
              placecol, Placement));
            number = orb + 2;
            System.out.println("\tindex" + " = " + number);
            System.out.println("\torbit" + " = " + orb);
          }
          showMinMax();
          System.out.println("star" + " = " + star);
          System.out.println("\tmin" + " = " + Orbits[min]);
          System.out.println("\tmax" + " = " + Orbits[max]);
          rotateStar();
          if ((number > 1 & number < ol) & (Orbits[number].endsWith("\t"))) {//& number <= orb[star]
            //number may outreach specific orbit numbers of specific stars>1
            Orbits[number] += ob;
            System.out.println("\tNormal = " + number);
          } else {
            Orbits[nearest(number)] += ob;
            System.out.println("\tNearest = " + number);
          }
          placed += 1;
        }
      } while (placed < stars);
      return "" + x;
    }
    return "" + 0;
  }

  private static int nearest(int n) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    int prev = 2, next = 2;
    System.out.println("  number" + " = " + n);
    for (int i = n - 1; i > 1; i--) {
      if (Orbits[i].endsWith("\t")) {
        prev = i;
        System.out.println(" prev" + " = " + prev);
        break;
      }
    }
    for (int i = n + 1; i < max; i++) {
      if (Orbits[i].endsWith("\t")) {
        next = i;
        System.out.println(" next" + " = " + next);
        break;
      }
    }
    System.out.println("(n-prev)" + " = " + (n - prev));
    System.out.println("(next - n)" + " = " + (next - n));
    if ((n - prev < next - n)) {
      System.out.println("next" + " = " + next);
      System.out.print(GlobalMethods.comment("-", 20));
      return next;
    } else {
      System.out.println("prev" + " = " + prev);
      System.out.print(GlobalMethods.comment("-", 20));
      return prev;
    }
  }

  private static void rotateStar() {
    System.out.println("rotateStar(" + star + ")");
    if (star > 0) {
      number += orb[0] + 2;
    }
    if (star > 1) {
      number += orb[1] + 2;
    }
    if (star > 2) {
      number += orb[2] + 2;
    }
    if (star > 3) {
      number += orb[3] + 2;
    }
    if (star > 3) {
      star = 0;
      number = 2;
    }
    star += 1;
  }

}
