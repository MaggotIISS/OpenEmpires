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

import dbviewer.DBPublic;
import dbviewer.JumpCalc;
import dbviewer.globals.GlobalMethods;
import dbviewer.globals.GlobalVariables;
import static dbviewer.globals.GlobalVariables.T5;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;

/**

 @author maggot
 */
public class Panel4SubSector extends javax.swing.JPanel implements
  Interface4UWP, Interface4ImSq, Interface4EcEx {

  //<editor-fold defaultstate="collapsed" desc="variables">
  static JPanel p4n;
  static String crlf = dbviewer.globals.GlobalVariables.CRLF;
  /**
   total fuel cost
   */
  public static int cost = 0;
  /**
   int denotes cost per tom
   */
  public static int refined = 10;
  /**
   int denotes cost per tom
   */
  public static int unrefined = 1;
  /**
   boolean denotes use of refined/unrefined fuel
   */
  public static boolean Refined;
  private static boolean running = true;

  /**

   @return if window is open and running
   */
  public static boolean isRunning() {
    return running;
  }

  /**
   x
   */
  public int x;
  /**
   y
   */
  public int y;
  //Panel4Hexer p4h = new Panel4Hexer();
  /**
   if visible
   */
  public static boolean vis = false;
  /**
   String[][]
   */
  public String[][] data;
  /**
   String
   */
  public static String in = T5 + "/CSV/uwp-worlds";
  /**
   String
   */
  public static String out = T5 + "/CSV/uwp-sector";
  /**
   JPanel
   */
  public static JPanel p4ffw;
  /**
   JFrame
   */
  public static JFrame jf;
  /**
   JComboBox
   */
  public static JComboBox Sp;
  /**
   JComboBox
   */
  public static JComboBox Si;
  /**
   JComboBox
   */
  public static JComboBox At;
  /**
   JComboBox
   */
  public static JComboBox Hy;
  /**
   JComboBox
   */
  public static JComboBox Po;
  /**
   JComboBox
   */
  public static JComboBox Go;
  /**
   JComboBox
   */
  public static JComboBox Ll;
  /**
   JComboBox
   */
  public static JComboBox Tl;
  /**
   String
   */
  public static String sp;
  /**
   String
   */
  public static String si;
  /**
   String
   */
  public static String at;
  /**
   String
   */
  public static String hy;
  /**
   String
   */
  public static String po;
  /**
   String
   */
  public static String go;
  /**
   String
   */
  public static String ll;
  /**
   String
   */
  public static String tl;
  /**
   String
   */
  public static JTextField jtf;
  /**
   String
   */
  public static String[] text;
  /**
   JComboBox[]
   */
  public static JComboBox[] jcbs;
  /**
   int[]
   */
  public static int[] sels;
  /**
   int
   */
  public static int i;
  /**
   int
   */
  public static int j;
  /**
   DefaultListModel
   */
  public static DefaultListModel dlm;
  /**
   JComboBox
   */
  public static JComboBox trade;
  /**
   JPanel
   */
  public static JPanel ep;
  /**
   JComboBox
   */
  public static JComboBox zone;
  /**
   JTextField
   */
  public static JTextField bases;
  //private Frame4 JFrame;
  private String[] lines;
  private int linecount;
  /**
   String[]
   */
  public String[] dests;
  /**
   String[]
   */
  public String[] insub;
  /**
   String[]
   */
  public String[] insec;
  /**
   String[]
   */
  public String[] outsec;
  /**
   String[]
   */
  public static String[] worlds;
  //Object o;
  DefaultListModel lmold = new DefaultListModel();
  /**
   String
   */
  public static String prev;
  private boolean history;
  private boolean hist = false;
  /**
   Frame4
   */
  public static Frame4 frame4 = null;
  /**
   Panel4TradeCargo
   */
  public static Panel4TradeCargo p4tc;
  /**
   String
   */
  public static String last2 = "Test";
  /**
   Frame4
   */
  public Frame4 f4tc;
  /**
   String fromTrade
   */
  public static String fromTrade;
  private Boolean started;
//  private static int count = 0;
//  private String crlf;
  /**
   List2
   */
  public static String List2;
  /**
   String
   */
  public static String List1;
  /**
   ListModel
   */
  public static ListModel olm;
  private String FS = GlobalVariables.FS;
  //</editor-fold>
  /**
   JFrame
   */
  public static JFrame f4n;
  MouseEvent me;
  MouseEvent men;
  /**

   */
  static String uwp;
  /**

   */
  static String starport;
  /**

   */
  static String size;
  /**

   */
  static String atmo;
  /**

   */
  static String hydro;
  /**

   */
  static String pop;
  /**

   */
  static String gov;
  /**

   */
  static String law;
  /**

   */
  static String tech;

  /**

   @param args strings to start
   */
  public static void main(String[] args) {
    //DBViewer.main(args);
    new Panel4Imperium();
  }

  /**
   Creates new form Panel4SubSector
   */
  @SuppressWarnings("unchecked")
  public Panel4SubSector() {
//    this.tech = uwp.substring(7,8);
//    this.law = uwp.substring(6,7);
//    this.gov = uwp.substring(5,6);
//    this.pop = uwp.substring(4,5);
//    this.hydro = uwp.substring(3,4);
//    this.atmo = uwp.substring(2,3);
//    this.size = uwp.substring(1,2);
//    this.starport = uwp.substring(0, 1);
//    this.uwp = Panel4SubSector.UWP.getText();
    initComponents();
    //File f = new File(Panel4SubSector.in);
    //worlds = GlobalMethods.getStringsFromFile(f);
    worlds = Panel4Imperium.Systems;
    if (dbviewer.globals.GlobalVariables.VARCOMBO == false) {
      dbviewer.globals.GlobalVariables.varCombos();
    }
    setName("p4s");
    Panel4Locator.prevpanel = "p4j";
    JComboBox cb;
    if (UWP.getText().length() == 8) {
      for (i = 0; i < 8; i++) {
        ////System.out.print("" + " = " + jTextField1.getText().substring(i, i + 1));
        switch (i) {
          case 0://<editor-fold defaultstate="collapsed" desc="comment">
            //            cb = globals.GlobalVariables.jcb4SP;
            cb = jcb4StarPort;
            //jcb4SP = new JComboBox();
            cb.removeAllItems();
            cb.setToolTipText("StarPort");
            cb.addItem("A - Excellent");
            cb.addItem("B - Good");
            cb.addItem("C - Routine");
            cb.addItem("D - Poor");
            cb.addItem("E - Poor");
            cb.addItem("X - None");
            break;
          //</editor-fold>
          case 1://<editor-fold defaultstate="collapsed" desc="comment">
            cb = jcb4Size;
            //jcb4Size = new JComboBox();
            cb.removeAllItems();
            cb.setToolTipText("Size");
            cb.addItem("0 - 800km");
            cb.addItem("1 - 1600km");
            cb.addItem("2 - 3200km");
            cb.addItem("3 - 4800km");
            cb.addItem("4 - 6400km");
            cb.addItem("5 - 8000km");
            cb.addItem("6 - 9600km");
            cb.addItem("7 - 11200km");
            cb.addItem("8 - 12800km");
            cb.addItem("9 - 14400km");
            cb.addItem("A - 16000km");
            break;
          //</editor-fold>
          case 2://<editor-fold defaultstate="collapsed" desc="comment">
            cb = jcb4Atmos;
            //jcb4Atmos = new JComboBox();
            cb.removeAllItems();
            cb.setToolTipText("Atmosphere");
            cb.addItem("0 - None");
            cb.addItem("1 - Trace");
            cb.addItem("2 - V Thin, Tainted");
            cb.addItem("3 - V Thin");
            cb.addItem("4 - Thin, Tainted");
            cb.addItem("5 - Thin");
            cb.addItem("6 - Standard");
            cb.addItem("7 - Std, Tainted");
            cb.addItem("8 - Dense");
            cb.addItem("9 - Dense, Tainted");
            cb.addItem("A - Exotic");
            cb.addItem("B - Corrosive");
            cb.addItem("C - Insidious");
            cb.addItem("D - Dense, High");
            cb.addItem("E - Thin, Low");
            cb.addItem("F - Unusual");
            break;
          //</editor-fold>
          case 3://<editor-fold defaultstate="collapsed" desc="comment">
            cb = jcb4Hydros;
            //jcb4Hydros = new JComboBox();
            cb.removeAllItems();
            cb.setToolTipText("Hydrosphere");
            cb.addItem("0 - 0%");
            cb.addItem("1 - 10%");
            cb.addItem("2 - 20%");
            cb.addItem("3 - 30%");
            cb.addItem("4 - 40%");
            cb.addItem("5 - 50%");
            cb.addItem("6 - 60%");
            cb.addItem("7 - 70%");
            cb.addItem("8 - 80%");
            cb.addItem("9 - 90%");
            cb.addItem("A - 100%");
            break;
          //</editor-fold>
          case 4://<editor-fold defaultstate="collapsed" desc="comment">
            cb = jcb4Pop;
            //jcb4Pop = new JComboBox();
            cb.removeAllItems();
            cb.setToolTipText("Population");
            cb.addItem("0 - None");
            cb.addItem("1 - Few");
            cb.addItem("2 - Hundreds");
            cb.addItem("3 - Thousands");
            cb.addItem("4 - Tens of Thousands");
            cb.addItem("5 - Hundreds of Thousands");
            cb.addItem("6 - Millions");
            cb.addItem("7 - Tens of Millions");
            cb.addItem("8 - Hundreds of Millions");
            cb.addItem("9 - Billions");
            cb.addItem("A - Tens of Billions");
            cb.addItem("B - Hundreds of Billions");
            cb.addItem("C - Trillions");
            break;
          //</editor-fold>
          case 5://<editor-fold defaultstate="collapsed" desc="comment">
            cb = jcb4Govt;
            //jcb4Govt = new JComboBox();
            cb.removeAllItems();
            cb.setToolTipText("Government");
            cb.addItem("0 - None");
            cb.addItem("1 - Company/Corporation ");
            cb.addItem("2 - Participating Democracy");
            cb.addItem("3 - Self Perpetuating Oligarchy");
            cb.addItem("4 - Representative Democracy");
            cb.addItem("5 - Feudal Technocracy");
            cb.addItem("6 - Captive Government");
            cb.addItem("7 - Balkanisation");
            cb.addItem("8 - Civil Service Bureaucracy");
            cb.addItem("9 - Impersonal Bureaucracy");
            cb.addItem("A - Charismatic Dictator");
            cb.addItem("B - Non Charismatic Leader");
            cb.addItem("C - Charismatic Oligarchy");
            cb.addItem("D - Religious Dictatorship");
            break;
          //</editor-fold>
          case 6://<editor-fold defaultstate="collapsed" desc="comment">
            cb = jcb4Law;
            //jcb4LL = new JComboBox();
            cb.setToolTipText("Law Level");
            cb.removeAllItems();
            cb.addItem("0 - No Law");
            cb.addItem("1 - Low Law");
            cb.addItem("2 - Low Law");
            cb.addItem("3 - Low Law");
            cb.addItem("4 - Moderate Law");
            cb.addItem("5 - Moderate Law");
            cb.addItem("6 - Moderate Law");
            cb.addItem("7 - Moderate Law");
            cb.addItem("8 - High Law");
            cb.addItem("9 - High Law");
            cb.addItem("A - Extreme Law");
            cb.addItem("B - Extreme Law");
            cb.addItem("C - Extreme Law");
            cb.addItem("D - Extreme Law");
            cb.addItem("E - Extreme Law");
            cb.addItem("F - Extreme Law");
            cb.addItem("G - Extreme Law");
            cb.addItem("H - Extreme Law");
            cb.addItem("J - Extreme Law");
            cb.addItem("K - Extreme Law");
            cb.addItem("L - Extreme Law");
            break;
          //</editor-fold>
          case 7://<editor-fold defaultstate="collapsed" desc="comment">
            cb = jcb4Tech;
            //jcb4TL = new JComboBox();
            cb.setToolTipText("Tech Level");
            cb.removeAllItems();
            cb.addItem("0 - Stone Age");
            cb.addItem("1 - Bronze Age");
            cb.addItem("2 - 1400-1700AD");
            cb.addItem("3 - 1700-1860AD");
            cb.addItem("4 - 1860-1900AD");
            cb.addItem("5 - 1900-1939AD");
            cb.addItem("6 - 1940-1969");
            cb.addItem("7 - 1970-1990");
            cb.addItem("8 - 1990-2100");
            cb.addItem("9 - 2100+AD");
            cb.addItem("A - Early Interstellar");
            cb.addItem("B - Average Interstellar");
            cb.addItem("C - Average Interstellar");
            cb.addItem("D - Above Average Interstellar");
            cb.addItem("E - Above Average Interstellar");
            cb.addItem("F - Technical Maximum");
            break;
          //</editor-fold>
        }
        Panel4SubSector.jcb4Bases.setToolTipText("Bases");//3
        Panel4SubSector.jcb4Remarks.setToolTipText("Remarks");//4
        Panel4SubSector.jcb4Zone.setToolTipText("Zone");//5
        Panel4SubSector.jcb4GGs.setToolTipText("GGs");//6
        Panel4SubSector.jcb4Cargo.setToolTipText("Cargo");//10
        Panel4SubSector.jcb4Trade.setToolTipText("Trade");//11
        Panel4SubSector.jcb4Star1.setToolTipText("Star1");//12
        Panel4SubSector.jcb4Star2.setToolTipText("Star2");//13
        Panel4SubSector.jcb4Star3.setToolTipText("Star3");//14
        Panel4SubSector.jcb4HW.setToolTipText("HW");//15
        Panel4SubSector.jcb4Al.setToolTipText("AL");//16
        Panel4SubSector.jcb4PAG.setToolTipText("PAG");//17
        Panel4SubSector.jcb4ZonedFor.setToolTipText("Zoned for");//18
        Panel4SubSector.jcb4Detail.setToolTipText("Detail");//19
        Panel4SubSector.jcb4Hard1.setToolTipText("Hard1");//20
        Panel4SubSector.jcb4Hard2.setToolTipText("Hard2");//21
        Panel4SubSector.jcb4Hard3.setToolTipText("Hard3");//22
        Panel4SubSector.jcb4Star4.setToolTipText("Star4");//23
        //jList1.setSelectedIndex(0);
        //dbviewer.DBPublic.Imports();
      }
    }
    updateCombos();
    calcCost();
    jCheckBox2.setToolTipText("" + unrefined + "KCr per ton");
    Panel4Locator.jButton1.setEnabled(true);
    Panel4Locator.jcb4Sector.setEnabled(true);
    Panel4Locator.jcb4SubSector.setEnabled(true);
    Panel4Locator.jcb4System.setEnabled(true);
    //jComboBox0.setSelectedIndex(1);
    jList1.setSelectedIndex(0);
    //jTextArea1.setVisible(false);
    panels.Panel4TradeCargo.start = "Panel4SubSector";
    jButton2.setEnabled(false);
    jButton2.setVisible(false);
    jButton3.setVisible(false);
    jButton4.setVisible(false);
    jButton5.setVisible(false);
    jButton6.setVisible(false);
    jScrollPane7.setVisible(false);

  }

  /**
   Destinations
   */
  public static void Destinations() {
//    Neighbours(true);
    ArrayList<String> outnums;
    outnums = new ArrayList<>();
    String[] hexes = jTextArea1.getText().split(crlf);
    // check if out of sector
    for (i = 0; i < hexes.length; i++) {
      if (hexes[i].contains("OUT")) {
        outnums.add(hexes[i].substring(0, 4));
      }
    }
    // display hex numbers
    for (i = 0; i < outnums.size(); i++) {
      //System.out.print("outnums.get(" + i + ") = " + outnums.get(i));
      String[] coords;
      coords = dbviewer.globals.GlobalMethods.splitCoords(outnums.get(i)
        .toString());
      int lr = Integer.parseInt(coords[0]);
      int tb = Integer.parseInt(coords[1]);
      String subsec = Panel4Locator.getSubSectorName().substring(0, 1)
        .toUpperCase();
      //System.out.print("subsec" + " = " + subsec);
      String dir = "";
      switch (subsec) {
        case "A":
        case "B":
        case "E": {
          //<editor-fold defaultstate="collapsed" desc="LT">
          //LM >26      // W
          if ((lr > 26)) {
            dir = "LM-W";
          }
          //RM <6       // E
          if (lr < 6) {
            dir = "RM-E";
          }
          //MT      >35 // N
          if (tb > 35) {
            dir = "MT-N";
          }
          //LT >26  >35 // NW
          if ((lr > 26) & (tb > 35)) {
            dir = "LT-NW";
          }
          //RB <6   <6  // NW
          if ((lr < 6) & (tb < 6)) {
            dir = "RB-NW";
          }
          //</editor-fold>
          break;
        }

        case "D":
        case "C":
        case "H": {
          //<editor-fold defaultstate="collapsed" desc="RT">
//          //LM >26      // W
//          if ((lr > 26)) {
//            dir = "LM-W";
//          }
          //RM <6       // E
          if (lr < 6) {
            dir = "RM-E";
          }
          //MT      >35 // N
          if (tb > 35) {
            dir = "MT-N";
          }
//          //MB      <6  // S
//          if (tb < 6) {
//            dir = "MB-S";
//          }
//          //LT >26  >35 // NW
//          if ((lr > 26) & (tb > 35)) {
//            dir = "LT-NW";
//          }
//          //LB >26  <6  // SW
//          if ((lr > 26) & (tb < 6)) {
//            dir = "LB-SW";
//          }
          //RT <6   >35 // NE
          if ((lr < 6) & (tb > 35)) {
            dir = "RT-NE";
          }
//          //RB <6   <6  // NW
//          if ((lr < 6) & (tb < 6)) {
//            dir = "RB-NW";
//          }
          //</editor-fold>
          break;
        }

        case "P":
        case "L":
        case "O": {
          //<editor-fold defaultstate="collapsed" desc="RB">
          //RM <6       // E
          if (lr < 6) {
            dir = "RM-E";
          }
          //MB      <6  // S
          if (tb < 6) {
            dir = "MB-S";
          }
          //RB <6   <6  // NW
          if ((lr < 6) & (tb < 6)) {
            dir = "RB-SE";
          }
          //</editor-fold>
          break;
        }

        case "M":
        case "I":
        case "N": {
          //<editor-fold defaultstate="collapsed" desc="LB">
          //LM >26      // W
          if ((lr > 26)) {
            dir = "LM-W";
          }
          //MB      <6  // S
          if (tb < 6) {
            dir = "MB-S";
          }
          //LB >26  <6  // SW
          if ((lr > 26) & (tb < 6)) {
            dir = "LB-SW";
          }
          //</editor-fold>
          break;
        }
      }
      //System.out.print("" + lr + tb + " = " + dir);
    }
  }

  /**
   ffw
   */
  @SuppressWarnings({"unchecked", "unchecked"})
  public static void ffw() {
    dbviewer.globals.GlobalVariables.varCombos();
    jtf = new JTextField("A788999C");//parts[0]);
    jtf.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        ////System.out.print("" + " = " + e);
        updateBoxes();
      }
    });
    text = new String[]{sp, si, at, hy, po, go, ll, tl};
    for (i = 0; i < 8; i++) {
      text[i] = jtf.getText().substring(i, i + 1);
      i += 1;
    }
    Sp = dbviewer.globals.GlobalVariables.jcb4SP;
    Si = dbviewer.globals.GlobalVariables.jcb4Size;
    At = dbviewer.globals.GlobalVariables.jcb4Atmos;
    Hy = dbviewer.globals.GlobalVariables.jcb4Hydros;
    Po = dbviewer.globals.GlobalVariables.jcb4Pop;
    Go = dbviewer.globals.GlobalVariables.jcb4Govt;
    Ll = dbviewer.globals.GlobalVariables.jcb4LL;
    Tl = dbviewer.globals.GlobalVariables.jcb4TL;
    jcbs = new JComboBox[]{Sp, Si, At, Hy, Po, Go, Ll, Tl};
    sels = new int[]{0, 7, 8, 8, 9, 9, 9, 12};
    for (i = 0; i < jcbs.length; i++) {
      jcbs[i].setSelectedIndex(sels[i]);
      jcbs[i].addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          updateBoxes();
        }
      });
    }
    jcb4StarPort = Sp;
    jcb4Size = Si;
    jcb4Atmos = At;
    jcb4Hydros = Hy;
    jcb4Pop = Po;
    jcb4Govt = Go;
    jcb4Law = Ll;
    jcb4Tech = Tl;

    bases = new JTextField();
    bases.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (bases.getText().equals("A")) {
          //Army, square
        }
        if (bases.getText().equals("N")) {
          //Navy, star
        }
        if (bases.getText().equals("B")) {
          //Navy & Scout
        }
        if (bases.getText().equals("S")) {
          //triangle Scout
        }
        if (bases.getText().equals("R")) {
          //research
        }
        if (bases.getText().equals("T")) {
          //TAS
        }
        if (bases.getText().equals("C")) {
          //consulate
        }
        if (bases.getText().equals("P")) {
          //pirate
        }
      }
    });

    trade = new JComboBox<>();
    trade.addItem("Ag - Agricultural");
    trade.addItem("As - Asteroid");
    trade.addItem("Ba - Barren");
    trade.addItem("De - Desert");
    trade.addItem("Fl - Fluid Oceans");
    trade.addItem("Ga - Garden");
    trade.addItem("Hi - High Population");
    trade.addItem("Ht - High Technology");
    trade.addItem("Ic - Ice Capped");
    trade.addItem("In - Industrial");
    trade.addItem("Lo - Low Population");
    trade.addItem("Lt - Low Technology");
    trade.addItem("Na - Non Agricultural");
    trade.addItem("Ni - Non Industrial");
    trade.addItem("Po - Poor");
    trade.addItem("Ri - Rich");
    trade.addItem("Wa - Water World");
    trade.addItem("Va - Vacuum");

    zone = new JComboBox<>();
    zone.addItem("Green");
    zone.addItem("Amber");
    zone.addItem("Red");

    p4ffw = new Panel4("FFW");
    p4ffw.setBackground(Color.white);
    JPanel wp = new JPanel();
    wp.setLayout(new GridLayout(25, 1));
    wp.add(dbviewer.globals.GlobalVariables.jcb4Atmo);
    wp.add(dbviewer.globals.GlobalVariables.jcb4GG);
    wp.add(dbviewer.globals.GlobalVariables.jcb4Hex);
    wp.add(dbviewer.globals.GlobalVariables.jcb4Ron);
    wp.add(dbviewer.globals.GlobalVariables.jcb4SP);
    wp.add(dbviewer.globals.GlobalVariables.jcb4SSS);
    wp.add(dbviewer.globals.GlobalVariables.jcb4TAS);
    wp.add(dbviewer.globals.GlobalVariables.jcb4TL);
    wp.add(dbviewer.globals.GlobalVariables.jcb4choice);
    wp.add(dbviewer.globals.GlobalVariables.jcb4imp);
    wp.add(dbviewer.globals.GlobalVariables.jcb4side);

    ep = new JPanel();
    ep.setLayout(new GridLayout(20, 1));
    ep.add(jtf);
    ep.add(Sp);
    ep.add(Si);
    ep.add(At);
    ep.add(Hy);
    ep.add(Po);
    ep.add(Go);
    ep.add(Ll);
    ep.add(Tl);
    ep.add(bases);
    ep.add(trade);
    ep.add(zone);

    p4ffw.add(wp, BorderLayout.WEST);
    p4ffw.add(ep, BorderLayout.EAST);

    updateBoxes();
    jf = new Frame4(p4ffw);
    //jf.add(ep, BorderLayout.EAST);
    jf.list();
  }

  /**
   updateCombos
   */
  public static void updateCombos() {
    JComboBox cb = new JComboBox();
    String letter;
    String first;
    for (int l = 0; l < 8; l++) {
      switch (l) {
        case 0:
          cb = jcb4StarPort;
          break;
        case 1:
          cb = jcb4Size;
          break;
        case 2:
          cb = jcb4Atmos;
          break;
        case 3:
          cb = jcb4Hydros;
          break;
        case 4:
          cb = jcb4Pop;
          break;
        case 5:
          cb = jcb4Govt;
          break;
        case 6:
          cb = jcb4Law;
          break;
        case 7:
          cb = jcb4Tech;
          break;
        case 8://Base[3]
          cb = jcb4Bases;
          break;
        case 9://Remarks[4]
          cb = jcb4Remarks;
          break;
        case 10://Zone[5]
          cb = jcb4Zone;
          break;
        case 11://Gas[6]
          cb = jcb4GGs;
          break;
        case 12://Cargo[10]
          cb = jcb4Cargo;
          break;
        case 13://Trade[11]
          cb = jcb4Trade;
          break;
        case 14://Star1[12]
          cb = jcb4Star1;
          break;
        case 15://Star2[13]
          cb = jcb4Star2;
          break;
        case 16://Star3[14]
          cb = jcb4Star3;
          break;
        case 17://HW[15]
          cb = jcb4HW;
          break;
        case 18://Al[16]
          cb = jcb4Al;
          break;
        case 19://PAG[17]
          cb = jcb4PAG;
          break;
        case 20://Zoned for[18]
          cb = jcb4ZonedFor;
          break;
        case 21://Detail[19]
          cb = jcb4Detail;
          break;
        case 22://Hard1[20]
          cb = jcb4Hard1;
          break;
        case 23://Hard2[21]
          cb = jcb4Hard2;
          break;
        case 24://Hard3[22]
          cb = jcb4Hard3;
          break;
        case 25://Star4[23]
          cb = jcb4Star4;
          break;
      }
      if (l > 7) {
        cb.removeAllItems();
      }
      letter = UWP.getText().substring(l, l + 1);
      //first = "";
      ////System.out.print("letter" + " = " + letter);
      if (cb.getItemCount() > 0) {
        for (i = 0; i < cb.getItemCount(); i++) {
          ////System.out.print("" + i + " = " + cb.getItemAt(i));
          first = cb.getItemAt(i).toString().substring(0, 1);
          ////System.out.print("first" + " = " + first);
          if (letter.equals(first)) {
            cb.setSelectedIndex(i);
            ////System.out.print("\tFOUND");
            break;
          }
        }
      }
    }
//    String hex = Panel4Locator.jcb4System.getSelectedItem().toString().substring(0, 4);
//    new dbviewer.JumpCalc(hex, 6);
  }

  /**
   setupMapBoxes
   */
  public static void setupMapBoxes() {
    MapBox[] boxes;
    boxes = new MapBox[9];
    boxes[0] = new MapBox(1, 1, "O", -4, 1, "MM", 0, 0);
    boxes[1] = new MapBox(0, 0, "NW", -5, 2, "LT", -1, 1);
    boxes[2] = new MapBox(1, 0, "N", -4, 2, "MT", 0, 1);
    boxes[3] = new MapBox(2, 0, "NE", -3, 2, "RT", 1, 1);
    boxes[4] = new MapBox(2, 1, "E", -3, 1, "RM", 1, 0);
    boxes[5] = new MapBox(2, 2, "SE", -3, 0, "RB", 1, -1);
    boxes[6] = new MapBox(1, 2, "S", -4, 0, "MB", 0, -1);
    boxes[7] = new MapBox(0, 2, "SW", -5, 0, "LB", -1, -1);
    boxes[8] = new MapBox(0, 1, "W", -5, 1, "LM", -1, 0);
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jButton6 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jScrollPane7 = new javax.swing.JScrollPane();
    jTextArea2 = new javax.swing.JTextArea();
    jButton3 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton5 = new javax.swing.JButton();
    jScrollPane2 = new javax.swing.JScrollPane();
    jPanel2 = new javax.swing.JPanel();
    UWP = new javax.swing.JTextField();
    jcb4StarPort = new javax.swing.JComboBox();
    jcb4Size = new javax.swing.JComboBox();
    jcb4Atmos = new javax.swing.JComboBox();
    jcb4Hydros = new javax.swing.JComboBox();
    jcb4Pop = new javax.swing.JComboBox();
    jcb4Govt = new javax.swing.JComboBox();
    jcb4Law = new javax.swing.JComboBox();
    jcb4Tech = new javax.swing.JComboBox();
    jcb4Bases = new javax.swing.JComboBox();
    jcb4Remarks = new javax.swing.JComboBox();
    jcb4Zone = new javax.swing.JComboBox();
    jcb4GGs = new javax.swing.JComboBox();
    jcb4Cargo = new javax.swing.JComboBox();
    jcb4Trade = new javax.swing.JComboBox();
    jcb4Star1 = new javax.swing.JComboBox();
    jcb4Star2 = new javax.swing.JComboBox();
    jcb4Star3 = new javax.swing.JComboBox();
    jcb4Star4 = new javax.swing.JComboBox();
    jcb4HW = new javax.swing.JComboBox();
    jcb4Al = new javax.swing.JComboBox();
    jcb4PAG = new javax.swing.JComboBox();
    jcb4ZonedFor = new javax.swing.JComboBox();
    jcb4Detail = new javax.swing.JComboBox();
    jcb4Hard1 = new javax.swing.JComboBox();
    jcb4Hard2 = new javax.swing.JComboBox();
    jcb4Hard3 = new javax.swing.JComboBox();
    jScrollPane3 = new javax.swing.JScrollPane();
    jPanel1 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList();
    jComboBox0 = new javax.swing.JComboBox();
    jScrollPane5 = new javax.swing.JScrollPane();
    jPanel4 = new javax.swing.JPanel();
    jScrollPane4 = new javax.swing.JScrollPane();
    jList2 = new javax.swing.JList();
    jScrollPane6 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jSlider1 = new javax.swing.JSlider();
    jButton1 = new javax.swing.JButton();
    jPanel3 = new javax.swing.JPanel();
    jLabel36 = new javax.swing.JLabel();
    defbats = new javax.swing.JLabel();
    jLabel42 = new javax.swing.JLabel();
    troopunits = new javax.swing.JLabel();
    squadrons = new javax.swing.JLabel();
    sdbs1 = new javax.swing.JLabel();
    jLabel40 = new javax.swing.JLabel();
    jLabel41 = new javax.swing.JLabel();
    jPanel5 = new javax.swing.JPanel();
    lab4Culture = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    lab4Labour = new javax.swing.JLabel();
    lab4Resources = new javax.swing.JLabel();
    lab4Infrastructure = new javax.swing.JLabel();
    jPanel6 = new javax.swing.JPanel();
    jLabel9 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jPanel7 = new javax.swing.JPanel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();
    jLabel17 = new javax.swing.JLabel();
    prog = new javax.swing.JLabel();
    plan = new javax.swing.JLabel();
    adva = new javax.swing.JLabel();
    grow = new javax.swing.JLabel();
    mili = new javax.swing.JLabel();
    unit = new javax.swing.JLabel();
    tole = new javax.swing.JLabel();
    jPanel8 = new javax.swing.JPanel();
    record = new javax.swing.JRadioButton();
    jLabel2 = new javax.swing.JLabel();
    MT = new javax.swing.JCheckBox();
    jPanel9 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jComboBox19 = new javax.swing.JComboBox();
    jCheckBox2 = new javax.swing.JCheckBox();
    jCheckBox1 = new javax.swing.JCheckBox();
    jPanel10 = new javax.swing.JPanel();
    jScrollPane8 = new javax.swing.JScrollPane();
    jTextArea3 = new javax.swing.JTextArea();
    jLabel8 = new javax.swing.JLabel();

    jButton6.setText("Info");
    jButton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton6ActionPerformed(evt);
      }
    });

    jButton4.setText("jButton2");
    jButton4.setToolTipText("StarGen");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    jTextArea2.setBackground(new java.awt.Color(0, 0, 0));
    jTextArea2.setColumns(5);
    jTextArea2.setForeground(new java.awt.Color(102, 102, 102));
    jTextArea2.setRows(5);
    jTextArea2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextArea2MouseClicked(evt);
      }
    });
    jTextArea2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jTextArea2PropertyChange(evt);
      }
    });
    jScrollPane7.setViewportView(jTextArea2);

    jButton3.setText("jButton2");
    jButton3.setToolTipText("BUY");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jButton2.setText("Info");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jButton5.setText("Info");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton5ActionPerformed(evt);
      }
    });

    setBackground(new java.awt.Color(0, 0, 0));
    setOpaque(false);

    jScrollPane2.setBackground(new java.awt.Color(0, 0, 0));
    jScrollPane2.setForeground(new java.awt.Color(204, 204, 204));
    jScrollPane2.setOpaque(false);

    jPanel2.setBackground(new java.awt.Color(0, 0, 0));
    jPanel2.setForeground(java.awt.Color.lightGray);
    jPanel2.setLayout(new java.awt.GridLayout(27, 1));

    UWP.setBackground(new java.awt.Color(0, 0, 0));
    UWP.setForeground(java.awt.Color.lightGray);
    UWP.setText("A788999C");
    UWP.setToolTipText("UWP");
    UWP.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        UWPMouseClicked(evt);
      }
    });
    UWP.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        UWPActionPerformed(evt);
      }
    });
    jPanel2.add(UWP);

    jcb4StarPort.setBackground(new java.awt.Color(0, 0, 0));
    jcb4StarPort.setForeground(java.awt.Color.lightGray);
    jcb4StarPort.setToolTipText("StarPort");
    jPanel2.add(jcb4StarPort);

    jcb4Size.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Size.setForeground(java.awt.Color.lightGray);
    jcb4Size.setToolTipText("Size");
    jcb4Size.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcb4SizeActionPerformed(evt);
      }
    });
    jPanel2.add(jcb4Size);

    jcb4Atmos.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Atmos.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Atmos);

    jcb4Hydros.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Hydros.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Hydros);

    jcb4Pop.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Pop.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Pop);

    jcb4Govt.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Govt.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Govt);

    jcb4Law.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Law.setForeground(java.awt.Color.lightGray);
    jcb4Law.setToolTipText("");
    jcb4Law.setName(""); // NOI18N
    jPanel2.add(jcb4Law);

    jcb4Tech.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Tech.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Tech);

    jcb4Bases.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Bases.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Bases);
    jcb4Bases.getAccessibleContext().setAccessibleDescription("Bases");

    jcb4Remarks.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Remarks.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Remarks);

    jcb4Zone.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Zone.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Zone);

    jcb4GGs.setBackground(new java.awt.Color(0, 0, 0));
    jcb4GGs.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4GGs);

    jcb4Cargo.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Cargo.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Cargo);

    jcb4Trade.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Trade.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Trade);

    jcb4Star1.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Star1.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Star1);

    jcb4Star2.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Star2.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Star2);

    jcb4Star3.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Star3.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Star3);

    jcb4Star4.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Star4.setForeground(java.awt.Color.lightGray);
    jcb4Star4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcb4Star4ActionPerformed(evt);
      }
    });
    jPanel2.add(jcb4Star4);

    jcb4HW.setBackground(new java.awt.Color(0, 0, 0));
    jcb4HW.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4HW);

    jcb4Al.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Al.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Al);

    jcb4PAG.setBackground(new java.awt.Color(0, 0, 0));
    jcb4PAG.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4PAG);

    jcb4ZonedFor.setBackground(new java.awt.Color(0, 0, 0));
    jcb4ZonedFor.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4ZonedFor);

    jcb4Detail.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Detail.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Detail);

    jcb4Hard1.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Hard1.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Hard1);

    jcb4Hard2.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Hard2.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Hard2);

    jcb4Hard3.setBackground(new java.awt.Color(0, 0, 0));
    jcb4Hard3.setForeground(java.awt.Color.lightGray);
    jPanel2.add(jcb4Hard3);

    jScrollPane2.setViewportView(jPanel2);

    jScrollPane3.setBackground(new java.awt.Color(0, 0, 0));
    jScrollPane3.setForeground(new java.awt.Color(204, 204, 204));
    jScrollPane3.setAutoscrolls(true);

    jPanel1.setBackground(new java.awt.Color(0, 0, 0));

    jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setHorizontalScrollBar(null);

    jList1.setBackground(new java.awt.Color(0, 0, 0));
    jList1.setForeground(java.awt.Color.lightGray);
    jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jList1.setToolTipText("Click to View, Double click to open");
    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList1MouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jList1);

    jComboBox0.setBackground(new java.awt.Color(0, 0, 0));
    jComboBox0.setForeground(java.awt.Color.lightGray);
    jComboBox0.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "hexer", "boxer", "bitset" }));
    jComboBox0.setOpaque(false);
    jComboBox0.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox0ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jComboBox0, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 92, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(jComboBox0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
        .addContainerGap())
    );

    jScrollPane3.setViewportView(jPanel1);

    jScrollPane5.setBackground(new java.awt.Color(0, 0, 0));
    jScrollPane5.setOpaque(false);

    jPanel4.setBackground(new java.awt.Color(0, 0, 0));
    jPanel4.setPreferredSize(new java.awt.Dimension(250, 600));

    jList2.setToolTipText("Destinations");
    jList2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList2MouseClicked(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jList2MousePressed(evt);
      }
    });
    jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        jList2ValueChanged(evt);
      }
    });
    jScrollPane4.setViewportView(jList2);

    jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
    jTextArea1.setColumns(5);
    jTextArea1.setForeground(java.awt.Color.lightGray);
    jTextArea1.setRows(5);
    jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextArea1MouseClicked(evt);
      }
    });
    jTextArea1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jTextArea1PropertyChange(evt);
      }
    });
    jScrollPane6.setViewportView(jTextArea1);

    jSlider1.setBackground(new java.awt.Color(0, 0, 0));
    jSlider1.setForeground(java.awt.Color.lightGray);
    jSlider1.setMajorTickSpacing(1);
    jSlider1.setMaximum(9);
    jSlider1.setPaintLabels(true);
    jSlider1.setPaintTicks(true);
    jSlider1.setSnapToTicks(true);
    jSlider1.setToolTipText("Jump Number");
    jSlider1.setValue(3);
    jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jSlider1StateChanged(evt);
      }
    });

    jButton1.setText("Jumps");
    jButton1.setToolTipText("Jump Calc");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jPanel3.setForeground(java.awt.Color.lightGray);
    jPanel3.setOpaque(false);

    jLabel36.setForeground(java.awt.Color.lightGray);
    jLabel36.setText("SDBs");
    jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel36MouseClicked(evt);
      }
    });

    defbats.setForeground(java.awt.Color.lightGray);
    defbats.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    defbats.setText("X");

    jLabel42.setForeground(java.awt.Color.lightGray);
    jLabel42.setText("Troops");
    jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel42MouseClicked(evt);
      }
    });

    troopunits.setForeground(java.awt.Color.lightGray);
    troopunits.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    troopunits.setText("X");

    squadrons.setForeground(java.awt.Color.lightGray);
    squadrons.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    squadrons.setText("X");

    sdbs1.setForeground(java.awt.Color.lightGray);
    sdbs1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    sdbs1.setText("X");

    jLabel40.setForeground(java.awt.Color.lightGray);
    jLabel40.setText("Max Rons");
    jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel40MouseClicked(evt);
      }
    });

    jLabel41.setForeground(java.awt.Color.lightGray);
    jLabel41.setText("Def. CF");
    jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel41MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel40)
          .addComponent(jLabel36)
          .addComponent(jLabel42)
          .addComponent(jLabel41))
        .addGap(0, 0, 0)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(defbats, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
          .addComponent(squadrons, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(sdbs1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(troopunits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(0, 0, 0))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
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

    jPanel5.setForeground(java.awt.Color.lightGray);
    jPanel5.setOpaque(false);

    lab4Culture.setForeground(java.awt.Color.lightGray);
    lab4Culture.setText("X");

    jLabel4.setForeground(java.awt.Color.lightGray);
    jLabel4.setText("Resources");
    jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel4MouseClicked(evt);
      }
    });

    jLabel6.setForeground(java.awt.Color.lightGray);
    jLabel6.setText("Infrastr.");
    jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel6MouseClicked(evt);
      }
    });

    jLabel5.setForeground(java.awt.Color.lightGray);
    jLabel5.setText("Labour");
    jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel5MouseClicked(evt);
      }
    });

    jLabel7.setForeground(java.awt.Color.lightGray);
    jLabel7.setText("Culture");
    jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel7MouseClicked(evt);
      }
    });

    lab4Labour.setForeground(java.awt.Color.lightGray);
    lab4Labour.setText("X");

    lab4Resources.setForeground(java.awt.Color.lightGray);
    lab4Resources.setText("X");

    lab4Infrastructure.setForeground(java.awt.Color.lightGray);
    lab4Infrastructure.setText("X");

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4)
          .addComponent(jLabel5)
          .addComponent(jLabel6)
          .addComponent(jLabel7))
        .addGap(6, 6, 6)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(lab4Culture)
          .addComponent(lab4Infrastructure)
          .addComponent(lab4Labour)
          .addComponent(lab4Resources))
        .addGap(0, 0, 0))
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(lab4Resources))
        .addGap(0, 0, 0)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(lab4Labour))
        .addGap(0, 0, 0)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(lab4Infrastructure))
        .addGap(0, 0, 0)
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel7)
          .addComponent(lab4Culture))
        .addGap(0, 0, 0))
    );

    jPanel6.setOpaque(false);

    jLabel9.setForeground(java.awt.Color.green);
    jLabel9.setText("Trade");
    jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel9MouseClicked(evt);
      }
    });

    jLabel3.setForeground(java.awt.Color.green);
    jLabel3.setText("World");
    jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel3MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 36, Short.MAX_VALUE))
    );

    jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel9});

    jPanel6Layout.setVerticalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addComponent(jLabel3)
        .addGap(0, 0, 0)
        .addComponent(jLabel9)
        .addContainerGap())
    );

    jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel9});

    jPanel7.setForeground(java.awt.Color.lightGray);
    jPanel7.setOpaque(false);

    jLabel11.setForeground(java.awt.Color.lightGray);
    jLabel11.setText("Progression");
    jLabel11.setToolTipText("Progression");

    jLabel12.setForeground(java.awt.Color.lightGray);
    jLabel12.setText("Planning");
    jLabel12.setToolTipText("Planning");

    jLabel13.setForeground(java.awt.Color.lightGray);
    jLabel13.setText("Advancement");
    jLabel13.setToolTipText("Advancement");

    jLabel14.setForeground(java.awt.Color.lightGray);
    jLabel14.setText("Growth");
    jLabel14.setToolTipText("Growth");

    jLabel15.setForeground(java.awt.Color.lightGray);
    jLabel15.setText("Militancy");
    jLabel15.setToolTipText("Militancy");

    jLabel16.setForeground(java.awt.Color.lightGray);
    jLabel16.setText("Unity");
    jLabel16.setToolTipText("Unity");

    jLabel17.setForeground(java.awt.Color.lightGray);
    jLabel17.setText("Tolerance");
    jLabel17.setToolTipText("Tolerance");

    prog.setForeground(java.awt.Color.lightGray);
    prog.setText("X");

    plan.setForeground(java.awt.Color.lightGray);
    plan.setText("X");

    adva.setForeground(java.awt.Color.lightGray);
    adva.setText("X");

    grow.setForeground(java.awt.Color.lightGray);
    grow.setText("X");

    mili.setForeground(java.awt.Color.lightGray);
    mili.setText("X");

    unit.setForeground(java.awt.Color.lightGray);
    unit.setText("X");

    tole.setForeground(java.awt.Color.lightGray);
    tole.setText("X");

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel7Layout.createSequentialGroup()
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel17)
          .addComponent(jLabel15)
          .addComponent(jLabel16)
          .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(0, 0, 0)
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(tole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(unit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(mili, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(grow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(adva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(plan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(prog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(63, 63, 63))
      .addGroup(jPanel7Layout.createSequentialGroup()
        .addComponent(jLabel14)
        .addGap(91, 91, 91))
    );

    jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel16, jLabel17});

    jPanel7Layout.setVerticalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel7Layout.createSequentialGroup()
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel11)
          .addComponent(prog))
        .addGap(0, 0, 0)
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel12)
          .addComponent(plan))
        .addGap(0, 0, 0)
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel13)
          .addComponent(adva))
        .addGap(0, 0, 0)
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel14)
          .addComponent(grow))
        .addGap(0, 0, 0)
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(mili)
          .addComponent(jLabel15))
        .addGap(0, 0, 0)
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(unit)
          .addComponent(jLabel16))
        .addGap(0, 0, 0)
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(tole)
          .addComponent(jLabel17))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel8.setOpaque(false);

    record.setBackground(new java.awt.Color(0, 0, 0));
    record.setForeground(java.awt.Color.lightGray);
    record.setText("REC");
    record.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        recordActionPerformed(evt);
      }
    });

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Cyberboard\\BMP\\SkyRig.gif")); // NOI18N
    jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
    jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
    jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel2MouseClicked(evt);
      }
    });

    MT.setForeground(java.awt.Color.lightGray);
    MT.setSelected(true);
    MT.setText("ALL");
    MT.setToolTipText("Include empty hexes");
    MT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    MT.setOpaque(false);
    MT.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        MTActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel8Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel8Layout.createSequentialGroup()
            .addComponent(record)
            .addGap(0, 0, 0)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(MT))
        .addGap(0, 0, 0))
    );
    jPanel8Layout.setVerticalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel8Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel8Layout.createSequentialGroup()
            .addComponent(MT)
            .addGap(0, 0, 0)
            .addComponent(record)
            .addGap(7, 7, 7))
          .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0))
    );

    jPanel9.setOpaque(false);

    jLabel1.setBackground(new java.awt.Color(0, 0, 0));
    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel1.setForeground(java.awt.Color.green);
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Cost");
    jLabel1.setToolTipText("Click changes Cr");
    jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel1.setOpaque(true);
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    jComboBox19.setBackground(new java.awt.Color(0, 0, 0));
    jComboBox19.setEditable(true);
    jComboBox19.setForeground(new java.awt.Color(255, 255, 255));
    jComboBox19.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "100", "200", "300", "400", "500", "600", "700", "800", "900", "1000", "1100", "1200" }));
    jComboBox19.setToolTipText("Starship size in dtons");
    jComboBox19.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox19ActionPerformed(evt);
      }
    });

    jCheckBox2.setBackground(new java.awt.Color(0, 0, 0));
    jCheckBox2.setForeground(java.awt.Color.green);
    jCheckBox2.setText("Unrefined");
    jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBox2ActionPerformed(evt);
      }
    });

    jCheckBox1.setBackground(new java.awt.Color(0, 0, 0));
    jCheckBox1.setForeground(java.awt.Color.green);
    jCheckBox1.setText("dTons");
    jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBox1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );
    jPanel9Layout.setVerticalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jCheckBox1)
        .addGap(0, 0, 0)
        .addComponent(jCheckBox2)
        .addGap(0, 0, 0)
        .addComponent(jLabel1)
        .addContainerGap())
    );

    jPanel10.setOpaque(false);

    jTextArea3.setColumns(20);
    jTextArea3.setRows(5);
    jScrollPane8.setViewportView(jTextArea3);

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        .addGap(0, 0, 0))
    );
    jPanel10Layout.setVerticalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel10Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addComponent(jScrollPane8)
        .addGap(0, 0, 0))
    );

    jLabel8.setForeground(java.awt.Color.green);
    jLabel8.setText("jLabel8");
    jLabel8.setToolTipText("");
    jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel8MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(jPanel4Layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8))))
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(0, 0, 0))
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addGap(5, 5, 5)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(6, 6, 6)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(34, 34, 34)
            .addComponent(jLabel8)))
        .addGap(11, 11, 11)
        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addComponent(jButton1)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
              .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)))))
      .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jScrollPane5.setViewportView(jPanel4);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        .addGap(0, 0, 0)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
      .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
      .addComponent(jScrollPane5)
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jComboBox0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox0ActionPerformed
    comboChoice(jComboBox0.getSelectedItem().toString());
  }//GEN-LAST:event_jComboBox0ActionPerformed

  private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
    Panel4Neighbours.showInfo();
    List1 = jList1.getSelectedValue().toString();
    Panel4Locator.jcb4System.setSelectedItem(jList1.getSelectedValue());
//    MT.setSelected(false);
    if (record.isSelected()) {
      Panel4History.write(jList1.getSelectedValue().toString());
      Panel4History.write("(" + jcb4Trade.getModel().getSelectedItem()
        .toString() + ")" + crlf);
    }
    //prev = jTextField1.getText();
    //JOptionPane.showMessageDialog(jComboBox6, jComboBox6.getSelectedItem().toString());
    if (!"".equals(jcb4Trade.getSelectedItem().toString())) {
      fromTrade = jcb4Trade.getSelectedItem().toString();
      if (hist == true) {
        frame4.setTitle(jList1.getSelectedValue().toString() + "("
          + Panel4SubSector.jcb4Trade.getSelectedItem().toString() + ")");
      }
    }
    jButton3.doClick();
    Panel4TradeCargo.jtf1.setText(Panel4SubSector.last2);
    started = true;
    olm = Panel4TradeCargo.jList1.getModel();
    jButton2.setEnabled(true);
    if (evt.getClickCount() > 1) {
      Panel4TradeCargo.setMining();
      jButton2.doClick();
    }
    lab4Resources.setText("X");
    lab4Labour.setText("X");
    lab4Infrastructure.setText("X");
    lab4Culture.setText("X");
    sdbs1.setText("X");
    squadrons.setText("X");
    defbats.setText("X");
    troopunits.setText("X");
    try {
      Panel4Squadron.worldupdate("SDBs");
      Panel4Squadron.worldupdate("SQUADRONS");
      Panel4Squadron.worldupdate("DEFENCEBATTS");
      Panel4Squadron.worldupdate("TROOPUNITS");
    } catch (Exception e) {
      System.out.println("Panel4Squadron.worldupdate Error" + " = " + e);
    }
    setis();
    loadDetails();
    jTextArea1MouseClicked(men);
//    ItemEvent ie;
//    Panel4Locator.jcb4SystemItemStateChanged(ie);
//    Panel4Locator.setSubSector(sub, txt);
//    Panel4Neighbours
    Panel4Neighbours.showInfo();

//    Panel4T5WebData.worldTestMouseClick();
  }//GEN-LAST:event_jList1MouseClicked

  private void UWPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UWPActionPerformed
    JumpCalc.showUWP(jList2.getSelectedValue().toString());
    updateCombos();
  }//GEN-LAST:event_UWPActionPerformed

  private void jcb4SizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb4SizeActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jcb4SizeActionPerformed

  private void recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordActionPerformed
    Panel4History p4h = null;
    if (history == false) {
      p4h = new Panel4History();
    }
    Panel4History.jf.setVisible(true);
    history = true;
    Color col = new Color(255, 0, 0);
    if (record.isSelected()) {
      record.setForeground(col);
      setRecording(true);
    } else {
      record.setForeground(Color.GRAY);
    }
  }//GEN-LAST:event_recordActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    calcCost();
    checkNearbySystems(jTextArea1.getText());
    JumpCalc jumpCalc = new dbviewer.JumpCalc(Panel4Locator.getSystem()
      .substring(0, 4), Panel4SubSector.jSlider1.getValue());
    //    testJumps();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void MTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MTActionPerformed
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
    //</editor-fold>
    if (MT.isSelected()) {
      jScrollPane6.setVisible(true);
    } else {
      jScrollPane6.setVisible(false);
    }
  }//GEN-LAST:event_MTActionPerformed

  private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
    if (!jSlider1.getValueIsAdjusting()) {
      ////System.out.print("JUMP" + " = " + jSlider1.getValue());
      JumpCalc jumpCalc = new dbviewer.JumpCalc(Panel4Locator.getSystem(),
        Panel4SubSector.jSlider1.getValue());
      //calcCost();
      jButton1.doClick();
      ////System.out.print("" + " = " + jTextArea1.getText());
      jTextArea1MouseClicked(men);
    }
  }//GEN-LAST:event_jSlider1StateChanged

  private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
    if (jCheckBox1.isSelected()) {
      jCheckBox1.setText("KTons");
    } else {
      jCheckBox1.setText("dTons");
    }
    calcCost();
  }//GEN-LAST:event_jCheckBox1ActionPerformed

  private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
    if (jCheckBox2.isSelected()) {
      jCheckBox2.setText("Refined");
      jCheckBox2.setToolTipText("" + refined + "KCr per ton");
    } else {
      jCheckBox2.setText("Unrefined");
      jCheckBox2.setToolTipText("" + unrefined + "KCr per ton");
    }
    calcCost();
  }//GEN-LAST:event_jCheckBox2ActionPerformed

  private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
    //</editor-fold>
    p4tc.updateTo(Panel4Locator.jcb4System.getModel().getSelectedItem()
      .toString());
    p4tc.updateFrom(Panel4Locator.jcb4System.getModel().getSelectedItem()
      .toString() + "(" + jcb4Trade.getModel().getSelectedItem().toString()
      + ")");
    jTextArea1MouseClicked(men);
  }//GEN-LAST:event_jList2ValueChanged

  private void jList2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MousePressed
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
    //</editor-fold>
    List2 = jList2.getSelectedValue().toString();
    Panel4Locator.jcb4System.getModel().setSelectedItem(List2);
    //System.out.print("" + " = " + List1);
    //System.out.print("" + " = " + List2);
    if (record.isSelected() == true) {
      Panel4History.writeRecord(jList2);
      Panel4History.write(List2);
      Panel4History.write("(" + jcb4Trade.getModel().getSelectedItem()
        .toString() + ")" + crlf);
    }
    jList1.setSelectedValue(List2, true);
    System.out.println(List2);
    JTextArea jta = new JTextArea();
    for (int i = 0; i < 9; i++) {
      //<editor-fold defaultstate="collapsed" desc="switch">
      switch (i) {
        case 0: {
          jta = Panel4Neighbours.jTextArea0;
          break;
        }
        case 1: {
          jta = Panel4Neighbours.jTextArea1;
          break;
        }
        case 2: {
          jta = Panel4Neighbours.jTextArea2;
          break;
        }
        case 3: {
          jta = Panel4Neighbours.jTextArea3;
          break;
        }
        case 4: {
          jta = Panel4Neighbours.jTextArea4;
          break;
        }
        case 5: {
          jta = Panel4Neighbours.jTextArea5;
          break;
        }
        case 6: {
          jta = Panel4Neighbours.jTextArea6;
          break;
        }
        case 7: {
          jta = Panel4Neighbours.jTextArea7;
          break;
        }
        case 8: {
          jta = Panel4Neighbours.jTextArea8;
          break;
        }
      }
      //</editor-fold>
      String txt = jta.getText();
      if (txt.contains(List2)) {
        System.out.println("found in " + i);
        System.out.println(jta.getText());
        Panel4Neighbours.select("" + i);
        System.out.println("i = " + i);
        for (int k = 0; k < jList1.getModel().getSize(); k++) {
          //System.out.println(jList1.getModel().getElementAt(k));
          if (jList1.getModel().getElementAt(k).equals(List2)) {
            System.out.println("HERE @ " + k);
            jList1.setSelectedValue(List2, true);
            jList1MouseClicked(me);
            Panel4Locator.setSystem(List2.toString());
          }
        }
      }
    }
  }//GEN-LAST:event_jList2MousePressed

  private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
    //</editor-fold>
    List2 = jList1.getSelectedValue().toString();
    for (int k = 0; k < jList1.getModel().getSize(); k++) {
      //if (jList2.getSelectedValue().toString() == jList1.getModel().getElementAt(k).toString()) {
      if (List1.equals(List2)) {
        jList1.setSelectedIndex(k);
        jList1.setSelectedValue(List2, true);
        //Panel4Locator.setSystem(List2);
        jList1MouseClicked(evt);
        break;
      }
    }
    if (jList2.getSelectedIndex() != -1) {
      List2 = jList2.getSelectedValue().toString();
    }
    jButton3.doClick();
  }//GEN-LAST:event_jList2MouseClicked

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    String it = jCheckBox2.getText();
    switch (it) {
      case "Unrefined":
        cost = unrefined;
        break;
      case "Refined":
        cost = refined;
        break;
    }
    String var = JOptionPane.showInputDialog(it + " Cost per Ton", cost);
    switch (jCheckBox2.getText()) {
      case "Unrefined":
        unrefined = Integer.parseInt(var);
        break;
      case "Refined":
        refined = Integer.parseInt(var);
        break;
    }
    //jCheckBox2.setText(var);
    calcCost();
  }//GEN-LAST:event_jLabel1MouseClicked

  private void jComboBox19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox19ActionPerformed
    calcCost();
  }//GEN-LAST:event_jComboBox19ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    if (hist == false) {
      hist = true;
      if (Panel4SubSector.jList1.getSelectedValue().toString() != null) {
        p4tc = new Panel4TradeCargo(Panel4SubSector.jList1.getSelectedValue()
          .toString() + "(" + jcb4Trade.getSelectedItem().toString() + ")");
        f4tc = new Frame4(p4tc);
        setFrame4(f4tc);
      }
    }
    getFrame4Trade().setBounds(650, 0, 600, 300);
    last2 = Panel4SubSector.jList1.getSelectedValue().toString() + "("
      + jcb4Trade.getSelectedItem().toString() + ")";
    getFrame4Trade().setTitle(last2);
    //p4tc.updateFrom();
    getFrame4Trade().validate();
    getFrame4Trade().setVisible(false);

  }//GEN-LAST:event_jButton3ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    String txt = UWP.getText().toString();
    Panel4StarGen.main(new String[]{
      txt.substring(0, 1),
      txt.substring(1, 2),
      txt.substring(2, 3),
      txt.substring(3, 4),
      txt.substring(4, 5),
      txt.substring(5, 6),
      txt.substring(6, 7),
      txt.substring(7, 8)});
//    }
    Panel4StarPic.hasparent = true;
    Panel4StarGen.updateFromImperium();
  }//GEN-LAST:event_jButton4ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Panel4System.main(text);
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jTextArea1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextArea1PropertyChange
    //System.out.print("jTextArea1PropertyChange = " + evt.toString());
    String[] al = jTextArea1.getText().split(crlf);
    Arrays.sort(al);
    jTextArea1.setText("");
    for (int ii = 0; ii < al.length; ii++) {
      jTextArea1.append(al[ii]);
    }
    al = null;
  }//GEN-LAST:event_jTextArea1PropertyChange

  private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
    String[] lines = jTextArea1.getText().split(GlobalVariables.CRLF);
//    for (int k = 0; k < lines.length; k++) {
//      System.out.println("lines[" + k + "] = " + lines[k]);
//    }
    Arrays.sort(lines);
    jTextArea1.setText("");
    for (int k = 0; k < lines.length; k++) {
//      System.out.println("lines[" + k + "] = " + lines[k]);
      jTextArea1.append(lines[k] + GlobalVariables.CRLF);
    }
  }//GEN-LAST:event_jTextArea1MouseClicked

  private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
    //lab4Resources.setText(Panel4ListTextOld.getResources());
  }//GEN-LAST:event_jLabel4MouseClicked

  private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    //lab4Labour.setText(Panel4ListTextOld.getLabour());
  }//GEN-LAST:event_jLabel5MouseClicked

  private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    //lab4Infrastructure.setText(Panel4ListTextOld.getInfrastructure());
  }//GEN-LAST:event_jLabel6MouseClicked

  private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
    //lab4Culture.setText(Panel4ListTextOld.getCulture());
  }//GEN-LAST:event_jLabel7MouseClicked

  private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    try {
      Panel4BitSet.main(new String[]{Panel4Locator.getSectorName().toString()});
    } catch (Exception ex) {
      Logger.getLogger(Panel4SubSector.class.getName()).log(Level.SEVERE, null,
        ex);
    }
  }//GEN-LAST:event_jButton5ActionPerformed

  private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    Panel4World.main(new String[]{});
//    Panel4World panel4World = new Panel4World();
  }//GEN-LAST:event_jButton6ActionPerformed

  private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
    try {
      sdbs1.setText("" + Panel4Squadron.worldupdate("SDBs"));
    } catch (Exception e) {
      sdbs1.setText("0");
    }
  }//GEN-LAST:event_jLabel36MouseClicked

  private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
    try {
//      Panel4UTP.setHeight(300);
//      Panel4UTP.setTop(300);
    } catch (Exception e) {
    }
    try {
      troopunits.setText("" + Panel4Squadron.worldupdate("TROOPUNITS"));
    } catch (Exception e) {
      troopunits.setText("0");
    }
  }//GEN-LAST:event_jLabel42MouseClicked

  private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
    try {
      squadrons.setText("" + Panel4Squadron.worldupdate("SQUADRONS"));
    } catch (Exception e) {
      squadrons.setText("0");
    }
  }//GEN-LAST:event_jLabel40MouseClicked

  private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
    try {
      defbats.setText("" + Panel4Squadron.worldupdate("DEFENCEBATTS"));
    } catch (Exception e) {
      defbats.setText("0");
    }
  }//GEN-LAST:event_jLabel41MouseClicked

  private void jTextArea2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea2MouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextArea2MouseClicked

  private void jTextArea2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextArea2PropertyChange
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextArea2PropertyChange

  private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
//    Panel4World.main(new String[]{null});
    System.out.println("Click on pic");
    Panel4Ship.main(new String[]{"SkyRig"});
  }//GEN-LAST:event_jLabel2MouseClicked

  private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
    Panel4World.main(new String[]{null});
  }//GEN-LAST:event_jLabel3MouseClicked

  private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
    Boolean vis = getFrame4Trade().isVisible();
    if (vis) {
      getFrame4Trade().setVisible(false);
    } else {
      getFrame4Trade().setVisible(true);
    }
  }//GEN-LAST:event_jLabel9MouseClicked

  private void jcb4Star4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb4Star4ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jcb4Star4ActionPerformed

  private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    Panel4TableViewer.main(text);
  }//GEN-LAST:event_jLabel8MouseClicked

  private void UWPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UWPMouseClicked
    jTextArea3.setText(UWP.getText());
  }//GEN-LAST:event_UWPMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public static javax.swing.JCheckBox MT;
  public static javax.swing.JTextField UWP;
  public static javax.swing.JLabel adva;
  static javax.swing.JLabel defbats;
  public static javax.swing.JLabel grow;
  public static javax.swing.JButton jButton1;
  public static javax.swing.JButton jButton2;
  public static javax.swing.JButton jButton3;
  public static javax.swing.JButton jButton4;
  public static javax.swing.JButton jButton5;
  public static javax.swing.JButton jButton6;
  public static javax.swing.JCheckBox jCheckBox1;
  public static javax.swing.JCheckBox jCheckBox2;
  public static javax.swing.JComboBox jComboBox0;
  public static javax.swing.JComboBox jComboBox19;
  public static javax.swing.JLabel jLabel1;
  public static javax.swing.JLabel jLabel11;
  public static javax.swing.JLabel jLabel12;
  public static javax.swing.JLabel jLabel13;
  public static javax.swing.JLabel jLabel14;
  public static javax.swing.JLabel jLabel15;
  public static javax.swing.JLabel jLabel16;
  public static javax.swing.JLabel jLabel17;
  public static javax.swing.JLabel jLabel2;
  public static javax.swing.JLabel jLabel3;
  public static javax.swing.JLabel jLabel36;
  public static javax.swing.JLabel jLabel4;
  public static javax.swing.JLabel jLabel40;
  public static javax.swing.JLabel jLabel41;
  public static javax.swing.JLabel jLabel42;
  public static javax.swing.JLabel jLabel5;
  public static javax.swing.JLabel jLabel6;
  public static javax.swing.JLabel jLabel7;
  public static javax.swing.JLabel jLabel8;
  public static javax.swing.JLabel jLabel9;
  public static javax.swing.JList jList1;
  public static javax.swing.JList jList2;
  public static javax.swing.JPanel jPanel1;
  public static javax.swing.JPanel jPanel10;
  public static javax.swing.JPanel jPanel2;
  public static javax.swing.JPanel jPanel3;
  public static javax.swing.JPanel jPanel4;
  public static javax.swing.JPanel jPanel5;
  public static javax.swing.JPanel jPanel6;
  public static javax.swing.JPanel jPanel7;
  public static javax.swing.JPanel jPanel8;
  public static javax.swing.JPanel jPanel9;
  public static javax.swing.JScrollPane jScrollPane1;
  public static javax.swing.JScrollPane jScrollPane2;
  public static javax.swing.JScrollPane jScrollPane3;
  public static javax.swing.JScrollPane jScrollPane4;
  public static javax.swing.JScrollPane jScrollPane5;
  public static javax.swing.JScrollPane jScrollPane6;
  public static javax.swing.JScrollPane jScrollPane7;
  public static javax.swing.JScrollPane jScrollPane8;
  public static javax.swing.JSlider jSlider1;
  public static javax.swing.JTextArea jTextArea1;
  public static javax.swing.JTextArea jTextArea2;
  public static javax.swing.JTextArea jTextArea3;
  public static javax.swing.JComboBox jcb4Al;
  public static javax.swing.JComboBox jcb4Atmos;
  public static javax.swing.JComboBox jcb4Bases;
  public static javax.swing.JComboBox jcb4Cargo;
  public static javax.swing.JComboBox jcb4Detail;
  public static javax.swing.JComboBox jcb4GGs;
  public static javax.swing.JComboBox jcb4Govt;
  public static javax.swing.JComboBox jcb4HW;
  public static javax.swing.JComboBox jcb4Hard1;
  public static javax.swing.JComboBox jcb4Hard2;
  public static javax.swing.JComboBox jcb4Hard3;
  public static javax.swing.JComboBox jcb4Hydros;
  public static javax.swing.JComboBox jcb4Law;
  public static javax.swing.JComboBox jcb4PAG;
  public static javax.swing.JComboBox jcb4Pop;
  public static javax.swing.JComboBox jcb4Remarks;
  public static javax.swing.JComboBox jcb4Size;
  public static javax.swing.JComboBox jcb4Star1;
  public static javax.swing.JComboBox jcb4Star2;
  public static javax.swing.JComboBox jcb4Star3;
  public static javax.swing.JComboBox jcb4Star4;
  public static javax.swing.JComboBox jcb4StarPort;
  public static javax.swing.JComboBox jcb4Tech;
  public static javax.swing.JComboBox jcb4Trade;
  public static javax.swing.JComboBox jcb4Zone;
  public static javax.swing.JComboBox jcb4ZonedFor;
  public static javax.swing.JLabel lab4Culture;
  public static javax.swing.JLabel lab4Infrastructure;
  public static javax.swing.JLabel lab4Labour;
  public static javax.swing.JLabel lab4Resources;
  public static javax.swing.JLabel mili;
  public static javax.swing.JLabel plan;
  public static javax.swing.JLabel prog;
  public static javax.swing.JRadioButton record;
  static javax.swing.JLabel sdbs1;
  static javax.swing.JLabel squadrons;
  public static javax.swing.JLabel tole;
  static javax.swing.JLabel troopunits;
  public static javax.swing.JLabel unit;
  // End of variables declaration//GEN-END:variables

  private void comboChoice(String string) {
    ////System.out.print("" + " = " + string);
    if ("Destinations".equals(string)) {
      Destinations();
    }
    if ("updateWorlds".equals(string)) {
      dbviewer.DBPublic.updateWorlds();
    }
    if ("updateSubs".equals(string)) {
      dbviewer.DBPublic.updateSubs();
    }
    if ("updateSecs".equals(string)) {
      dbviewer.DBPublic.updateSecs();
    }
    if ("ffw".equals(string)) {
      ffw();
    }
    if ("filechooser".equals(string)) {
      filechooser();
    }
    if ("hexer".equals(string)) {
      hexer();
    }
    if ("boxer".equals(string)) {
      boxer();
    }
//        if ("USqP".equals(string)) {
//            usqp();
//        }
    if ("UTP".equals(string)) {
      utp();
    }
    if ("bitset".equals(string)) {
      jButton5.doClick();
    }
    if ("world".equals(string)) {
      jButton6.doClick();
    }

  }

  private void filechooser() {
    try {
//    JFrame af = new HelpFrame("filechooser");
//    JFileChooser jfc = dbviewer.DBViewer.jfc;
      JFileChooser jfc = DBPublic.CBView();
      String sec, sub, sys;
//    String FS = File.separator;
      sec = Panel4Locator.getSectorName().substring(0, 4).toUpperCase();
      sub = Panel4Locator.getSubSectorName();
      sys = Panel4Locator.getSystem();
//    String p = "\"" + globals.GlobalVariables.IMP+FS+sec+FS+sub+FS+sys+"\"";
//    String p = "'" + globals.GlobalVariables.IMP+FS+sec+FS+sub+FS+sys+"'";
      String p = "`" + dbviewer.globals.GlobalVariables.IMP + FS + sec + FS
        + sub + FS + sys + "`";
      System.out.println("p" + " = " + p);
      File f = new File(p);
      jfc.setCurrentDirectory(f);
      jfc.showOpenDialog(this);
//    HelpFrame.jta.append("jfc.getCurrentDirectory().toString()" + " = " + jfc.getCurrentDirectory().toString() + HelpFrame.CRLF);
//    HelpFrame.jta.append("jfc.getSelectedFile().toString()" + " = " + jfc.getSelectedFile().toString() + HelpFrame.CRLF);
//    HelpFrame.jta.append(HelpFrame.CRLF);
      //jfc.showOpenDialog(this);
    } catch (Exception ex) {
      Logger.getLogger(Panel4SubSector.class.getName()).log(Level.SEVERE, null,
        ex);
    }
  }

  private void hexer() {
    Panel4Hexer p4h = new Panel4Hexer();
  }

  private static void updateBoxes() {
    for (i = 0; i < jcbs.length; i++) {
      //what are we searching for - One letter starting line in combo
      text[i] = jtf.getText().substring(i, i + 1).toUpperCase();
      //where does it go?
      for (int jj = 0; jj < 8; jj++) {
        if (jcbs[i].getItemAt(jj).toString().startsWith(text[i])) {
          sels[i] = jj;
          jcbs[i].setSelectedIndex(jj);
        }
      }
    }
  }

  private void calcCost() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    int jj = jSlider1.getValue();
    int dt = Integer.parseInt(jComboBox19.getSelectedItem().toString());
    String start = "";
    Refined = jCheckBox2.isSelected();
    if (Refined == true) {
      cost = refined;
    }
    if (Refined == false) {
      cost = unrefined;
    }
    String k = null;
    boolean KT = jCheckBox1.isSelected();
    if (KT == true) {
      start = "MCr";
      k = ",000";
    }
    if (KT != true) {
      start = "KCr";
      k = "";
    }
    if (jSlider1.getValue() == 0) {
      jj = 1;
    }
    int sum = dt * jj / 10 * cost;
    jLabel1.setText("" + sum + start);
    jLabel1.setToolTipText("Click to alter costs");
    jCheckBox2.setToolTipText("" + cost + "KCr per ton");
    jCheckBox1.setToolTipText("" + (dt / 10 * jj) + k + " tons fuel");
//</editor-fold>
  }

  @SuppressWarnings("unchecked")
  private Object checkNearbySystems(String text) {
//<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
//    ArrayList all = new ArrayList();
    ArrayList all = new ArrayList();
    ArrayList al = new ArrayList();
    Object l;
    String sub;
    String sec;
    String[] list;
    JTextArea[] jta;
    String[] sectors;
    String[] subsectors;
    JTextArea jt;
    int num;

    lines = text.split(crlf);
    //all.add(lines[0]);
    for (i = 0; i < lines.length; i++) {
      all.add(lines[i]);
      ////System.out.print("" + " = " + lines[i]);
    }
    list = new String[all.size()];
    for (i = 0; i < list.length; i++) {
      list[i] = all.get(i).toString();
      ////System.out.print("" + " = " + list[i]);
    }
    jta = new JTextArea[]{
      Panel4Neighbours.jTextArea0,
      Panel4Neighbours.jTextArea1, Panel4Neighbours.jTextArea2,
      Panel4Neighbours.jTextArea3, Panel4Neighbours.jTextArea4,
      Panel4Neighbours.jTextArea5, Panel4Neighbours.jTextArea6,
      Panel4Neighbours.jTextArea7, Panel4Neighbours.jTextArea8
    };
    sectors = new String[9];
    subsectors = new String[9];
    for (i = 0; i < jta.length; i++) {
      jt = jta[i];
      lines = jt.getText().split(crlf);
      sub = lines[0];
      sec = lines[1];
      subsectors[i] = sub;
      sectors[i] = sec;
    }
    al = new ArrayList();
    al.add(sectors[0]);
    num = 0;
    for (int k = 0; k < jta.length; k++) {
      if (al.get(num).toString().equals(sectors[k])) {
        num += 1;
        break;
      }
      boolean add = al.add(sectors[k]);
    }
    l = JumpCalc.search4Worlds(sectors, subsectors);
    //lmold =  (DefaultListModel) jList2.getModel();
    return l;
  }

  private void testJumps() {
    JumpCalc.setJumps();
    ////System.out.print("" + " = " + jTextArea1.getText());
    for (int i = 0; i < 9; i++) {
      //System.out.print("===================");
      JumpCalc.doCalc(i);
      //System.out.print("Destinations" + " = " + JumpCalc.Jumps[i].length);
      for (int j = 0; j < JumpCalc.Jumps[i].length; j++) {
      }
    }
  }

  @SuppressWarnings("unchecked")
  private void findWorldsNearby(String text, int value) {
    //System.out.print("Jump" + " = " + value);
    //System.out.print(text);
    ArrayList al = new ArrayList();
    dlm = new DefaultListModel();
    JTextArea jta = new JTextArea();
    String[] lines = text.split(crlf);
    for (int i = 0; i < lines.length; i++) {
      lines[i] = lines[i].substring(0, 4);
      for (int j = 0; j < 9; j++) {
        //<editor-fold defaultstate="collapsed" desc="switch(j)">
        switch (j) {
          case 0: {
            jta = Panel4Neighbours.jTextArea0;
            break;
          }
          case 1: {
            jta = Panel4Neighbours.jTextArea1;
            break;
          }
          case 2: {
            jta = Panel4Neighbours.jTextArea2;
            break;
          }
          case 3: {
            jta = Panel4Neighbours.jTextArea3;
            break;
          }
          case 4: {
            jta = Panel4Neighbours.jTextArea4;
            break;
          }
          case 5: {
            jta = Panel4Neighbours.jTextArea5;
            break;
          }
          case 6: {
            jta = Panel4Neighbours.jTextArea6;
            break;
          }
          case 7: {
            jta = Panel4Neighbours.jTextArea7;
            break;
          }
          case 8: {
            jta = Panel4Neighbours.jTextArea8;
            break;
          }
        }
        //</editor-fold>
        if (jta.getText().contains(lines[i])) {
          String[] parts = jta.getText().split(crlf);
          for (int k = 0; k < parts.length; k++) {
            if (parts[k].contains(lines[i])) {
              ////System.out.print("" + "" + parts[k]+"-"+parts[1]);
              al.add(("" + parts[k] + "-" + parts[0]).substring(0, parts[k]
                .length() + 1 + parts[0].length() - 12));
            }
          }
        }
      }
    }
    Arrays.sort(al.toArray());
    DefaultListModel dll = new DefaultListModel();
    for (int i = 0; i < al.size(); i++) {
      //System.out.print("\t" + al.get(i));
      dll.addElement(al.get(i));
    }
    jList2.setModel(dll);
  }

  /**
   @return the frame4
   */
  public static Frame4 getFrame4Trade() {
    return frame4;
  }

  /**
   @param frame4 the frame4 to set
   */
  public void setFrame4(Frame4 frame4) {
    this.frame4 = frame4;
  }
  /**
   boolean
   */
  public static boolean Recording = false;

  /**
   Get the value of Recording

   @return the value of Recording
   */
  public static boolean isRecording() {
    return Recording;
  }

  /**
   Set the value of Recording

   @param Recording new value of Recording
   */
  public static void setRecording(boolean Recording) {
    Panel4SubSector.Recording = Recording;
  }

  private void swap() {
    String oldWorld = frame4.getTitle();
    String newWorld = Panel4TradeCargo.jtf1.getText();
    //System.out.print("BEFORE oldWorld" + " = " + oldWorld);
    //System.out.print("BEFORE newWorld" + " = " + newWorld);
    if (!oldWorld.equals(newWorld)) {
      oldWorld = newWorld;
      newWorld = "";
      List2 = "";
    }
    //System.out.print("AFTER oldWorld" + " = " + oldWorld);
    //System.out.print("AFTER newWorld" + " = " + newWorld);
  }

  private void boxer() {
    Panel4Boxer.main(new String[]{"Hidden"});
  }

//    private void usqp() {
//        Panel4Squadrons.main(new String[]{"Hidden"});
//    }
//
  private void utp() {
    Panel4UTP.main(new String[]{"Hidden"});
  }

  /**

   @return Universal World Profile
   */
  @Override
  public String getUWP() {
    return UWP.getText();
  }

  /**

   @return StarPort
   */
  @Override
  public String getSp() {
    return UWP.getText().substring(0, 1);
  }

  /**

   @return Size
   */
  @Override
  public String getSi() {
    return UWP.getText().substring(1, 2);
  }

  /**

   @return Atmosphere
   */
  @Override
  public String getAt() {
    return UWP.getText().substring(2, 3);
  }

  /**

   @return Hydrosphere
   */
  @Override
  public String getHy() {
    return UWP.getText().substring(3, 4);
  }

  /**

   @return Population
   */
  @Override
  public String getPo() {
    return UWP.getText().substring(4, 5);
  }

  /**

   @return Government
   */
  @Override
  public String getGo() {
    return UWP.getText().substring(5, 6);
  }

  /**

   @return Law level
   */
  @Override
  public String getLl() {
    return UWP.getText().substring(6, 7);
  }

  /**

   @return Tech level
   */
  @Override
  public String getTl() {
    return UWP.getText().substring(7, 8);
  }

  @Override
  public String getHex() {
    return jList1.getSelectedValue().toString().substring(0, 4);
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

  static void setIS() {
//    jLabel36MouseClick(me);
//    jLabel40MouseClick(me);
//    jLabel41MouseClick(me);
//    jLabel42MouseClick(me);
  }

  static void setEE() {
//    jLabel4MouseClick(me);
//    jLabel5MouseClick(me);
//    jLabel6MouseClick(me);
//    jLabel7MouseClick(me);
  }

  void setis() {
    jLabel36MouseClicked(me);
    jLabel40MouseClicked(me);
    jLabel41MouseClicked(me);
    jLabel42MouseClicked(me);
    try {
      loadEkex();
    } catch (Exception e) {
    }
  }

  void setee() {
//    jLabel4MouseClicked(me);
//    jLabel5MouseClicked(me);
//    jLabel6MouseClicked(me);
//    jLabel7MouseClicked(me);
  }

  /**

   */
  @Override
  public void getSDBs() {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**

   */
  @Override
  public void getRons() {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**

   */
  @Override
  public void getDef() {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**

   */
  @Override
  public void getTroops() {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**

   */
  @Override
  public void getResource() {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**

   */
  @Override
  public void getLabour() {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**

   */
  @Override
  public void getInfrastructure() {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  /**

   */
  @Override
  public void getCulture() {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void loadEkex() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
//</editor-fold>
    //File f = new File(GlobalVariables.Regina + ".ekex");
    File f = new File(Panel4Locator.getPath() + FS + jList1.getSelectedValue()
      .toString() + ".ekex");
    System.out.println("f.toString()" + " = " + f.toString());
    if (f.exists()) {
      jTextArea2.setText("" + GlobalMethods
        .loadTextFile(Panel4Locator.getPath(), List1, "ekex"));
      String[] lin = jTextArea2.getText().split(GlobalVariables.CRLF);
      int last = lin.length - 1;
      String last4 = lin[last].substring(lin[last].length() - 4);
      //JOptionPane.showMessageDialog(jTextArea1, last4);
      lab4Resources.setText(last4.substring(0, 1));
      lab4Labour.setText(last4.substring(1, 2));
      lab4Infrastructure.setText(last4.substring(2, 3));
      lab4Culture.setText(last4.substring(3, 4));
    }
  }

  private void loadDetails() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
//</editor-fold>
    File f = new File(Panel4Locator.getPath() + FS + jList1.getSelectedValue()
      .toString() + ".deta");
    System.out.println("f.toString()" + " = " + f.toString());
    if (f.exists()) {
      String[] lines = GlobalMethods.getLinesFromFile(f);
      for (int k = 0; k < lines.length; k++) {
        System.out.println("lines[" + k + "]" + " = " + lines[k]);
        int start = lines[k].indexOf(" - ") + 3;
        int end = lines[k].indexOf(" = ");
        switch (k - 1) {
          case 0: {
            prog.setText(lines[k].substring(start, end));
            break;
          }
          case 1: {
            plan.setText(lines[k].substring(start, end));
            break;
          }
          case 2: {
            adva.setText(lines[k].substring(start, end));
            break;
          }
          case 3: {
            grow.setText(lines[k].substring(start, end));
            break;
          }
          case 4: {
            mili.setText(lines[k].substring(start, end));
            break;
          }
          case 5: {
            unit.setText(lines[k].substring(start, end));
            break;
          }
          case 6: {
            tole.setText(lines[k].substring(start, end));
            break;
          }
        }
      }
    } else {
      prog.setText("X");
      plan.setText("X");
      adva.setText("X");
      grow.setText("X");
      mili.setText("X");
      unit.setText("X");
      tole.setText("X");
    }
  }

  static String[] getStars() {
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
