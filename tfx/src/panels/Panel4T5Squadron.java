/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package panels;

import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalVariables.CRLF;
import static dbviewer.globals.GlobalVariables.FS;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.CaretEvent;
import javax.swing.text.BadLocationException;
import static panels.Panel4T5CounterMaker.counter;
import static panels.Panel4T5Locator.gettl;
import static panels.Panel4T5Locator.sdbs1;
import static panels.Panel4T5Locator.squadrons;

/**
 @author Mark Ferguson
 */
public class Panel4T5Squadron extends Panel4 {

  //<editor-fold defaultstate="collapsed" desc="variables">
  static Frame4 jf;
  static Panel4 jp;
  static double pts;
  static double cost;
  static double used;
  static double left;
  static int count = 0;
  private Color color;
  private int offset;
  static String tl;
  static String BaseJump;
  static String MaxJump;
  static int basejf;
  static int DF;
  static int basedf;
  static int AF;
  static int baseaf;
  static int BF;
  static int basebf;
  static int TF;
  static int basetf;
  static int popu;
  static String ron;
  static int tlmo;
  static int rmo;
  static int imo;
  static int cmo;
  static String[] lines;
  String line;
  CaretEvent evt;
  int offset1;
  int olddf;
  int oldmod;
  int newmod = 0;
  //</editor-fold>
  String[] tf = new String[20];
  private String[] values;

  /**
   @param args strings to start
   */
  public static void main(String[] args) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    jp = new Panel4T5Squadron();
//    jf = new Frame4(jp);
    jf.setBounds(1200, 0, 600, 200);
  }

  /**
   Creates new form Panel4T5Squadron
   */
  public Panel4T5Squadron() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    jf = new Frame4(this);
    jf.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {

        saveFile();
//        GlobalMethods.savePic(jf, jf.getTitle());
      }
    });
    initComponents();
    loadFile();
    l4Hex.setText(Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
      .substring(0, 4));
    l4TL
      .setText("" + GlobalMethods.fromHex(Panel4T5Locator.UWP.substring(8, 9)));
    setPointsValue();
    calcPts();
//    jf.addWindowListener(new WindowAdapter() {
//      @Override
//      public void windowClosing(WindowEvent e) {
//        saveFile();
////        GlobalMethods.savePic(jf, jf.getTitle());
//      }
//    });
  }

//  /**
//   <p>
//   @param g Graphics
//   */
//  @Override
//  public void paintComponent(Graphics g) {
//    //<editor-fold defaultstate="collapsed" desc="left panel">
//    try {
//      super.paintComponent(g);
//      //      w = jLabel5.getWidth();
//      //      h = jLabel5.getHeight();
//      g.setColor(color);
//      g.fillRect(0, 0, 100, 100);
//      g.setColor(Color.black);
//      g.drawRect(0, 0, 100, 100);
//
//      //g = jLabel5.getGraphics();
//      //Graphics2D g2 = (Graphics2D) g;
//      Image im = ImageIO.read(new File(_GIF + "lines.gif"));
//      g.drawImage(im, Panel4UTP.centerOnX(im, 0, 100),
//        Panel4UTP.centerOnY(im, 0, 100), null);
//
//      // Squadron Type
//      BufferedImage bii1 = Panel4UTP.strToSmall(3, 5,
//        jComboBox1.getSelectedItem().toString().substring(0, 2));
//      g.drawImage(bii1, Panel4UTP.centerOnX(bii1, 29, 0), 25, null);
//      try {
//        // Home hex
//        BufferedImage bi1 = Panel4UTP.strToSmall(3, 5, jf.getTitle().substring(0, 4));
//        g.drawImage(bi1, Panel4UTP.centerOnX(bi1, 51, 0), 25, null);
//        // Fleet ID
//        BufferedImage bi11 = Panel4UTP.strToSmall(3, 5, sidn.getText());
//        g.drawImage(bi11, Panel4UTP.centerOnX(bi11, 51, 0), 31, null);
//
//        // Streamlining and Jump to middle left box
//        BufferedImage bi00 = Panel4UTP.strToSmall(3, 5, ns.getText().substring(0, 1) + "SL");
//        g.drawImage(bi00, Panel4UTP.centerOnX(bi00, 29, 0), 43, null);
//        //      int s1 = jtf4CF.getText().indexOf("(");
//        BufferedImage bi0021 = Panel4UTP.strToSmall(3, 5, "J" + nj.getText());
//        g.drawImage(bi0021, Panel4UTP.centerOnX(bi0021, 29, 0), 49, null);
//
//        // TF to middle right box
//        BufferedImage bi0 = Panel4UTP.strToSmall(3, 5, "TF");
//        g.drawImage(bi0, Panel4UTP.centerOnX(bi0, 73, 0), 43, null);
//        //      int s1 = jtf4CF.getText().indexOf("(");
//        BufferedImage bi021 = Panel4UTP.strToSmall(3, 5, nt.getText());
//        g.drawImage(bi021, Panel4UTP.centerOnX(bi021, 73, 0), 49, null);
//
//        // DF to bottom left box
//        BufferedImage bi2 = Panel4UTP.strToSmall(3, 5, "DF");
//        g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 29, 0), 61, null);
//        //      int s1 = jtf4CF.getText().indexOf("(");
//        BufferedImage bi21 = Panel4UTP.strToSmall(3, 5, nd.getText());
//        g.drawImage(bi21, Panel4UTP.centerOnX(bi21, 29, 0), 67, null);
//
//        // AF to bottom middle box
//        BufferedImage bi3 = Panel4UTP.strToSmall(3, 5, "AF");
//        g.drawImage(bi3, Panel4UTP.centerOnX(bi3, 51, 0), 61, null);
//        //      int s2 = jtf4CF.getText().indexOf(")");
//        BufferedImage bi31 = Panel4UTP.strToSmall(3, 5, na.getText());
//        g.drawImage(bi31, Panel4UTP.centerOnX(bi31, 51, 0), 67, null);
//
//        // BF to bottom right box
//        BufferedImage bi4 = Panel4UTP.strToSmall(3, 5, "BF");
//        g.drawImage(bi4, Panel4UTP.centerOnX(bi4, 73, 0), 61, null);
//        BufferedImage bi41 = Panel4UTP.strToSmall(3, 5, nb.getText());
//        g.drawImage(bi41, Panel4UTP.centerOnX(bi41, 73, 0), 67, null);
//        //    } catch (IOException ex) {
//        //      Logger.getLogger(Panel4UTP.class.getName()).log(Level.SEVERE, null, ex);
//        //    }
//      } catch (Exception e) {
//
//      }
//    } catch (IOException ex) {
//      Logger.getLogger(Panel4Squadron.class.getName()).log(Level.SEVERE, null, ex);
//      System.out.println("" + " = " + ex.toString());
//    }
//    BufferedImage pc = null;
//    try {
//      pc = ImageIO.read(new File(folder + pic));
//      g.drawImage(pc, Panel4UTP.centerOnX(pc, 50, 0), 46, null);
//    } catch (IOException ex) {
//      Logger.getLogger(Panel4Squadron.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    //</editor-fold>
//    //<editor-fold defaultstate="collapsed" desc="right panel">
//    //2nd Panel
//    int left = 100;
//    int tops = 0;
//    int wid = 100;
//    int hgt = 100;
//    int r = 10;
//    g.setColor(color);
//    g.fillRect(left, tops, wid, hgt);
//    g.setColor(Color.black);
//    g.drawRect(left, tops, wid, hgt);
//    titles = new String[]{"ID", "TYPE", "S/L", "JUMP", "TF", "DF", "AF", "BF"};
//    values = new String[]{sidn.getText(), sron.getText(), ns.getText(),
//      nj.getText(), nt.getText(), nd.getText(), na.getText(), nb.getText()
//    };
//    for (int i = 0; i < 8; i++) {
//      g.drawString(titles[i], left + 2, tops + 15 + (i * 11));
//      g.drawString(values[i], left + 37, tops + 15 + (i * 11));
//    }
//    //</editor-fold>//Right
//  }
//
  /**
   change of System
   */
  public static void systemChange() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    l4Hex.setText(Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
      .substring(0, 4));
    l4TL.setText("" + GlobalMethods.fromHex(Panel4T5Locator.gettl()));
    loadFile();
    calcPts();
    countUsed();
  }

  private static void setPointsValue() {
    String p = "" + Panel4T5Locator.squadrons.getText();
    if (!"X".equals(p)) {
      pts = Double.parseDouble("" + GlobalMethods.fromHex(
        Panel4T5Locator.squadrons.getText()));
    } else {
      pts = 0.0;
    }
    Pts.setText("" + pts);
  }

  static void calc() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
//    popu = Integer.parseInt(Panel4T5Locator.UWP.substring(4, 5));
//    tlmo = Integer.parseInt(infmod.getText());
//    rmo = Integer.parseInt(resmod.getText());
//    imo = Integer.parseInt(tlmod.getText());
//    cmo = Integer.parseInt(culmod.getText());
    popu = GlobalMethods.fromHex(Panel4T5Locator.UWP.substring(4, 5));
    tlmo = GlobalMethods.fromHex(infmod.getText());
    rmo = GlobalMethods.fromHex(resmod.getText());
    imo = GlobalMethods.fromHex(tlmod.getText());
    cmo = GlobalMethods.fromHex(culmod.getText());
    calcJump();
    calcDF();
    calcAF();
    calcBF();
    calcTF();
  }

  static void calcPts() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
//    doMods();
    used = Double.parseDouble(Used.getText());
    left = pts - used;
    cost = Double.parseDouble(Cost.getText());
    Used.setText("" + used);
    Left.setText("" + left);
    Cost.setText("" + cost);
    if (left > 0.0 & cost <= left) {
      Cost.setForeground(Color.GREEN);
    } else {
      Cost.setForeground(Color.LIGHT_GRAY);
    }
    calc();
  }

  private static void loadFile() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    String dir = Panel4T5Locator.getSysPath();
    String file = Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
      .substring(0, 4);
    String ext = ".usqp";
    String txt = GlobalMethods.loadTextFile(dir, file, ext);
    rons.setText(txt.replace(CRLF + CRLF, CRLF));
  }

  static void saveFile() {
    try {
      GlobalMethods.saveTextFile(Panel4T5Locator.getSysPath() + FS,
        Panel4T5Locator.jcb4Sys.getSelectedItem().toString().substring(0, 4),
        ".usqp",
        rons.getText());
    } catch (Exception ex) {
    }
  }

  static void costClick() {
    calcPts();
    countCount();
    if (!"0.0".equals(Cost.getText()) && Cost.getForeground()
      .equals(Color.GREEN)) {
      count += 1;
      used += Double.parseDouble(Cost.getText());
      Used.setText("" + used);
      rons.append(jComboBox1.getSelectedItem().toString().substring(0, 1)
        + "00" + count
        + "-" + nj.getText() + ns.getText()
        + "-" + nd.getText()
        + na.getText()
        + nb.getText()
        + "-"
        + nt.getText()
        + "-" + GlobalMethods.toHex(Integer.parseInt(l4TL.getText())) + CRLF);
    }
    if (left > 0.0) {
      sj.setForeground(Color.GREEN);
      ss.setForeground(Color.GREEN);
      sd.setForeground(Color.GREEN);
      sa.setForeground(Color.GREEN);
      sb.setForeground(Color.GREEN);
    } else {
      sj.setForeground(Color.LIGHT_GRAY);
      ss.setForeground(Color.LIGHT_GRAY);
      sd.setForeground(Color.LIGHT_GRAY);
      sa.setForeground(Color.LIGHT_GRAY);
      sb.setForeground(Color.LIGHT_GRAY);
    }
    calcPts();
    saveFile();
    loadFile();
  }

  private static void countCount() {
    String[] lines = rons.getText().split(CRLF);
    int counter = 0;
    for (int j = 0; j < lines.length; j++) {
      if (lines[j].length() > 0) {
        counter += 1;
      }
    }
    count = counter;
  }

  private void line2Counter(String line) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.println("line" + " = " + line);
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    Panel4T5CounterMaker.Folder.setSelectedItem("Squadron");
    Panel4T5CounterMaker.jtfs[10].setText(Panel4T5Locator.jcb4Sys
      .getSelectedItem().toString().trim());
    Panel4T5CounterMaker.jtfs[11].setText(jLabel1.getText().substring(0, 4));
    Panel4T5CounterMaker.jtfs[12].setText(sron.getText());
    Panel4T5CounterMaker.jtfs[13].setText("J-" + jLabel1.getText()
      .substring(5, 6));
    Panel4T5CounterMaker.jtfs[14].setText(jLabel1.getText().substring(6, 7)
      + "SL");
    Panel4T5CounterMaker.jtfs[15].setText("DF " + jLabel1.getText().substring(8,
      9));
    Panel4T5CounterMaker.jtfs[16].setText("AF " + jLabel1.getText().substring(9,
      10));
    Panel4T5CounterMaker.jtfs[17].setText("BF " + jLabel1.getText()
      .substring(10,
        11));
    Panel4T5CounterMaker.jtfs[18].setText("TF " + jLabel1.getText()
      .substring(12,
        line.lastIndexOf("-")));
    Panel4T5CounterMaker.jtfs[19].setText("TL " + l4TL.getText());
    Panel4T5CounterMaker.picClick();
    Panel4T5CounterMaker.setText.doClick();
  }

  static void doMods() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="tlmods">
    String tlmods = "";
    switch (l4TL.getText()) {
      case "0":
      case "1":
      case "2":
      case "3":
      case "4":
      case "5":
      case "6": {
        tlmods = "-4";
        break;
      }
      case "7":
      case "8":
      case "9":
      default: {
        tlmods = "-2";
        break;
      }
      case "10":
      case "11": {
        tlmods = "-1";
        break;
      }
      case "12":
      case "13": {
        tlmods = "0";
        break;
      }
      case "14": {
        tlmods = "1";
        break;
      }
      case "15": {
        tlmods = "2";
        break;
      }
    }
    tlmod.setText(tlmods);
//    System.out.println("tlmods" + " = " + tlmods);
    //</editor-fold>
    //resmods
    String res = "" + GlobalMethods.fromHex(Panel4T5Locator.data[5].substring(8,
      9));
    System.out.println("res" + " = " + res);
    //infmods
    String inf = "" + GlobalMethods.fromHex(Panel4T5Locator.data[5]
      .substring(10, 11));
    System.out.println("inf" + " = " + inf);
    //culmods
    String cul = "" + GlobalMethods.fromHex(Panel4T5Locator.data[6].substring(1,
      2));
    System.out.println("cul" + " = " + Panel4T5Locator.data[6].substring(1, 2));
    //--------------------------------------------------------------------------
    String val = "";
    String ret = "";
//    int r = 0;
    String[] vals = {res, inf, cul};
    for (int k = 0; k < 3; k++) {
      val = vals[k];
      switch (val) {
        case "0":
        case "1":
        case "2": {
          ret = "-3";
          break;
        }
        case "3":
        case "4":
        case "5": {
          ret = "-2";
          break;
        }
        case "6":
        case "7":
        case "8": {
          ret = "-1";
          break;
        }
        case "9":
        case "10":
        case "11": {
          ret = "0";
          break;
        }
        case "12":
        case "13":
        case "14": {
          ret = "1";
          break;
        }
        case "15":
        case "16":
        case "17": {
          ret = "2";
          break;
        }
        case "18":
        case "19":
        case "20": {
          ret = "3";
          break;
        }
      }
      switch (k) {
        case 0: {
          resmod.setText(ret);
          break;
        }
        case 1: {
          infmod.setText(ret);
          break;
        }
        case 2: {
          culmod.setText(ret);
          break;
        }
      }
    }
  }

  static void calcJump() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    BaseJump = "0";
    MaxJump = "0";
    tl = l4TL.getText();
    switch (tl) {
      case "9":
      case "A":
      case "10": {
        BaseJump = "1";
        MaxJump = "1";
        break;
      }
      case "B":
      case "11": {
        BaseJump = "1";
        MaxJump = "2";
        break;
      }
      case "C":
      case "12": {
        BaseJump = "1";
        MaxJump = "3";
        break;
      }
      case "D":
      case "13": {
        BaseJump = "2";
        MaxJump = "4";
        break;
      }
      case "E":
      case "14": {
        BaseJump = "3";
        MaxJump = "5";
        break;
      }
      case "F":
      case "15": {
        BaseJump = "4";
        if ("BR".equals(ron)) {
          BaseJump = "3";
        }
        MaxJump = "6";
        break;
      }
    }
    nj.setText(BaseJump);
    basejf = Integer.parseInt(BaseJump);
//    System.out.println("BaseJump" + " = " + BaseJump);
//    System.out.println("MaxJump" + " = " + MaxJump);
  }

  static void calcDF() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    DF = popu - 2 + tlmo + rmo + imo + cmo;
    basedf = DF;
    nd.setText("" + GlobalMethods.toHex(DF));
//    System.out.println("DF" + " = " + DF);
  }

  static void calcAF() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    AF = 0;
    if ("CR".equals(ron)) {
      AF = (DF / 2) + tlmo + rmo + imo + cmo;
    } else {
    }
    if ("BR".equals(ron)) {
      AF = ((2 * DF) / 3) + tlmo + rmo + imo + cmo;
    } else {
    }
    baseaf = AF;
    na.setText("" + GlobalMethods.toHex(AF));
//    System.out.println("AF" + " = " + AF);
  }

  static void calcBF() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    BF = 0;
    nb.setText("" + GlobalMethods.toHex(BF));
    basebf = BF;
//    System.out.println("BF" + " = " + BF);
  }

  static void calcTF() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    TF = 0;
    if ("AR".equals(ron)) {
      TF = 600;
    } else if ("BR".equals(ron)) {
      TF = 20;
    } else if ("CR".equals(ron)) {
      calcDF();
      TF = DF;
    }
    basetf = TF;
    nt.setText("" + TF);
//    System.out.println("TF" + " = " + TF);
  }

  private void setMods(String txt1) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    double sss = 1.0;
    int v = 0;
    String text = "";
    switch (txt1) {
      //<editor-fold defaultstate="collapsed" desc="Jump">
      case "Jump": {
        text += "JU+1,AF-2" + CRLF;
        text += "JU+1,BF-2" + CRLF;
        text += "JU-1,AF+2" + CRLF;
        text += "JU-1,BF+2" + CRLF;
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Sl">
      case "Sl": {
        //<editor-fold defaultstate="collapsed" desc="sss cost">
        try {
          switch (ron) {
            case "BR": {
              sss = 2.0;
              break;
            }
            case "SR": {
              sss = 0.5;
              break;
            }
          }
        } catch (Exception e) {
        }
        //</editor-fold>
        v = 0;
        text += "U = " + (int) (sss * v) + CRLF;
        v = -1;
        text += "P = " + (int) ((sss + 0.5) * v) + CRLF;
        v = -2;
        text += "S = " + (int) (sss * v) + CRLF;
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Df">

      case "Df": {
        text += "DF+2,AF-1" + CRLF;
        text += "DF-2,AF+1" + CRLF;
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Af">
      case "Af": {
        text += "AF+1,DF-2" + CRLF;
        text += "AF+1,BF-1" + CRLF;
        text += "AF-1,DF+2" + CRLF;
        text += "AF-1,BF+1" + CRLF;
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Bf">
      case "Bf": {
        text += "BF+1,AF-1" + CRLF;
        text += "BF+2,JU-1" + CRLF;
        text += "BF-1,AF+1" + CRLF;
        text += "BF-2,JU+1" + CRLF;
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Tf">
      case "Tf": {
        text += "AF+1,DF-2" + CRLF;
        text += "AF+1,BF-1" + CRLF;
        text += "AF-1,DF+2" + CRLF;
        text += "AF-1,BF+1" + CRLF;
        break;
      }
      //</editor-fold>
    }
    mods.setText(text);
  }

  private void modList(String s) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    String string = "";
    String[] ss = rons.getText().split(CRLF);
    for (int j = 0; j < ss.length; j++) {
      if (ss[j].substring(0, 5).equals(s.substring(0, 5))) {
        ss[j] = s;
      }
      string += ss[j] + CRLF;
    }
    rons.setText(string);
  }

  private void writeLabel() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
//        System.out.println("" + " = " + evt.getDot());
//        System.out.println("line" + " = " + line);
    }
    //</editor-fold>
    int d = 0, a = 0, b = 0;
    try {
      d = Integer.parseInt(nd.getText());
    } catch (Exception e) {
      d = GlobalMethods.fromHex(nd.getText());
    }
    olddf = d;
    try {
      a = Integer.parseInt(na.getText());
    } catch (Exception e) {
      a = GlobalMethods.fromHex(na.getText());
    }
    try {
      b = Integer.parseInt(nb.getText());
    } catch (Exception e) {
      b = GlobalMethods.fromHex(nb.getText());
    }
    jLabel1.setText(""
      + sron.getText().substring(0, 1) + sidn.getText()
      + "-"
      + nj.getText() + ns.getText()
      + "-"
      + GlobalMethods.toHex(d)
      + GlobalMethods.toHex(a)
      + GlobalMethods.toHex(b)
      + "-"
      + nt.getText()
      + "-"
      + l4TL.getText()
    );
    String[] txt = rons.getText().split(CRLF);
    rons.setText("");
    for (int j = 0; j < txt.length; j++) {
      if (txt[j].startsWith(jLabel1.getText().substring(0, 5))) {
        txt[j] = jLabel1.getText();
      }
      rons.append(txt[j] + CRLF);
    }
    String s = "";
    for (int j = 0; j < txt.length; j++) {
      s += txt[j] + CRLF;
    }
    rons.setText(s);
    saveFile();
  }

  private static void countUsed() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    double x = 0.0;
    lines = rons.getText().split(CRLF);
    for (int j = 0; j < lines.length; j++) {
      if (lines[j].length() > 1) {
        switch (lines[j].substring(0, 1)) {
          case "A": {
            x += 2.0;
            break;
          }
          case "B": {
            x += 2.0;
            break;
          }
          case "C": {
            x += 1.0;
            break;
          }
          case "S": {
            x += 0.5;
            break;
          }
          case "T": {
            x += 3.0;
            break;
          }
        }
      }
    }
    used = x;
    Used.setText("" + x);
    pts = x;
    Pts.setText("" + x);
    calcPts();
  }

  private void deletePics() {
    String folder = Panel4T5Locator.getSysPath();
    String[] list = new File(folder).list();
    for (int j = 0; j < list.length; j++) {
      if (list[j].length() == 12 & list[j].endsWith(".gif")) {
        String pathfile = Panel4T5Locator.getSysPath() + FS + list[j];
        File f = new File(pathfile);
        f.delete();
      }
    }
//    folder += FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
    list = new File(folder).list();
    for (int j = 0; j < list.length; j++) {
      if (list[j].startsWith("Squadron") & list[j].endsWith(".gif") & list[j]
        .length() != 17) {
        String pathfile = folder + FS + list[j];
        File f = new File(pathfile);
        f.delete();
      }
    }
  }

  /**
   This method is called from within the constructor to
   initialize the form.
   WARNING: Do NOT modify this code. The content of this method is
   always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel10 = new javax.swing.JLabel();
    jLabel43 = new javax.swing.JLabel();
    tlmod = new javax.swing.JLabel();
    resmod = new javax.swing.JLabel();
    infmod = new javax.swing.JLabel();
    culmod = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    stype = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    rons = new javax.swing.JTextArea();
    l4Hex = new javax.swing.JLabel();
    jComboBox1 = new javax.swing.JComboBox();
    lab4TL = new javax.swing.JLabel();
    l4TL = new javax.swing.JLabel();
    Cost = new javax.swing.JLabel();
    lab4pts = new javax.swing.JLabel();
    Pts = new javax.swing.JLabel();
    Used = new javax.swing.JLabel();
    Left = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    mods = new javax.swing.JTextArea();
    jPanel2 = new javax.swing.JPanel();
    sj = new javax.swing.JLabel();
    ss = new javax.swing.JLabel();
    sd = new javax.swing.JLabel();
    sa = new javax.swing.JLabel();
    sb = new javax.swing.JLabel();
    st = new javax.swing.JLabel();
    nj = new javax.swing.JLabel();
    ns = new javax.swing.JLabel();
    nd = new javax.swing.JLabel();
    na = new javax.swing.JLabel();
    nb = new javax.swing.JLabel();
    nt = new javax.swing.JLabel();
    sid = new javax.swing.JLabel();
    sidn = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jButton2 = new javax.swing.JButton();
    sron = new javax.swing.JLabel();

    jLabel10.setForeground(java.awt.Color.lightGray);
    jLabel10.setText("0");

    jLabel43.setForeground(java.awt.Color.lightGray);
    jLabel43.setText("pts");

    tlmod.setForeground(java.awt.Color.lightGray);
    tlmod.setText("0");
    tlmod.setToolTipText("tlmod");

    resmod.setForeground(java.awt.Color.lightGray);
    resmod.setText("0");
    resmod.setToolTipText("resmod");

    infmod.setForeground(java.awt.Color.lightGray);
    infmod.setText("0");
    infmod.setToolTipText("infmod");

    culmod.setForeground(java.awt.Color.lightGray);
    culmod.setText("0");
    culmod.setToolTipText("culmod");

    jButton1.setText("ADD");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    stype.setForeground(java.awt.Color.green);
    stype.setText("TYPE");
    stype.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        stypeMouseClicked(evt);
      }
    });

    setBackground(java.awt.Color.black);
    setForeground(new java.awt.Color(255, 255, 255));
    setOpaque(true);
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        formMouseClicked(evt);
      }
    });

    jScrollPane1.setHorizontalScrollBar(null);

    rons.setColumns(20);
    rons.setRows(3);
    rons.addCaretListener(new javax.swing.event.CaretListener() {
      public void caretUpdate(javax.swing.event.CaretEvent evt) {
        ronsCaretUpdate(evt);
      }
    });
    jScrollPane1.setViewportView(rons);

    l4Hex.setForeground(java.awt.Color.lightGray);
    l4Hex.setText("Hex");
    l4Hex.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        l4HexMouseClicked(evt);
      }
    });

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AR - AssaultRon(2)", "BR - BattRon(2)", "CR - CruRon(1)", "SR - ScoutRon(0.5)", "TR - TankRon(3)" }));
    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox1ActionPerformed(evt);
      }
    });

    lab4TL.setForeground(java.awt.Color.lightGray);
    lab4TL.setText("TL");

    l4TL.setForeground(java.awt.Color.lightGray);
    l4TL.setText("TL");

    Cost.setForeground(java.awt.Color.lightGray);
    Cost.setText("0");
    Cost.setToolTipText("Buy Cost");
    Cost.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        CostMouseClicked(evt);
      }
    });

    lab4pts.setForeground(java.awt.Color.green);
    lab4pts.setText("Pts");
    lab4pts.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        lab4ptsMouseClicked(evt);
      }
    });

    Pts.setForeground(java.awt.Color.lightGray);
    Pts.setText("0");
    Pts.setToolTipText("Points");

    Used.setForeground(java.awt.Color.lightGray);
    Used.setText("0");
    Used.setToolTipText("Used");

    Left.setForeground(java.awt.Color.lightGray);
    Left.setText("0");
    Left.setToolTipText("Left");

    jScrollPane2.setHorizontalScrollBar(null);

    mods.setColumns(20);
    mods.setRows(4);
    mods.addCaretListener(new javax.swing.event.CaretListener() {
      public void caretUpdate(javax.swing.event.CaretEvent evt) {
        modsCaretUpdate(evt);
      }
    });
    jScrollPane2.setViewportView(mods);

    jPanel2.setOpaque(false);

    sj.setForeground(java.awt.Color.lightGray);
    sj.setText("JUMP");
    sj.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        sjMouseClicked(evt);
      }
    });

    ss.setForeground(java.awt.Color.lightGray);
    ss.setText("S/L");
    ss.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        ssMouseClicked(evt);
      }
    });

    sd.setForeground(java.awt.Color.lightGray);
    sd.setText("DF");
    sd.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        sdMouseClicked(evt);
      }
    });

    sa.setForeground(java.awt.Color.lightGray);
    sa.setText("AF");
    sa.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        saMouseClicked(evt);
      }
    });

    sb.setForeground(java.awt.Color.lightGray);
    sb.setText("BF");
    sb.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        sbMouseClicked(evt);
      }
    });

    st.setForeground(java.awt.Color.lightGray);
    st.setText("TF");
    st.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        stMouseClicked(evt);
      }
    });

    nj.setForeground(java.awt.Color.lightGray);
    nj.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    nj.setText("0");

    ns.setForeground(java.awt.Color.lightGray);
    ns.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    ns.setText("U");

    nd.setForeground(java.awt.Color.lightGray);
    nd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    nd.setText("0");

    na.setForeground(java.awt.Color.lightGray);
    na.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    na.setText("0");

    nb.setForeground(java.awt.Color.lightGray);
    nb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    nb.setText("0");

    nt.setForeground(java.awt.Color.lightGray);
    nt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    nt.setText("0");

    sid.setForeground(java.awt.Color.lightGray);
    sid.setText("ID");

    sidn.setForeground(java.awt.Color.lightGray);
    sidn.setText("000");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(sj)
          .addComponent(ss)
          .addComponent(sd)
          .addComponent(sid)
          .addComponent(sa)
          .addComponent(sb)
          .addComponent(st))
        .addGap(10, 10, 10)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(nj, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ns, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(nd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(na, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(nb, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(nt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(sidn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(21, Short.MAX_VALUE))
    );

    jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {na, nb, nd, nj, ns, nt, sidn});

    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(sid)
          .addComponent(sidn))
        .addGap(0, 0, 0)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(nj)
          .addComponent(sj))
        .addGap(0, 0, 0)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(ns)
          .addComponent(ss))
        .addGap(0, 0, 0)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(sd)
          .addComponent(nd))
        .addGap(0, 0, 0)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(sa)
          .addComponent(na))
        .addGap(0, 0, 0)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(nb)
          .addComponent(sb))
        .addGap(0, 0, 0)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(st)
          .addComponent(nt))
        .addGap(0, 0, 0))
    );

    jLabel1.setForeground(java.awt.Color.lightGray);
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel1.setText("USqP");
    jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    jLabel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jLabel1PropertyChange(evt);
      }
    });

    jButton2.setText("X");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    sron.setForeground(java.awt.Color.lightGray);
    sron.setText("TYPE");
    sron.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        sronMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(lab4pts, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pts)
                .addGap(18, 18, 18)
                .addComponent(Used, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addComponent(l4Hex)
                .addGap(18, 18, 18)
                .addComponent(lab4TL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l4TL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cost)))
            .addGap(9, 9, 9))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGap(74, 74, 74)
            .addComponent(jButton2)))
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(sron, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
        .addContainerGap())
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBox1, jScrollPane2});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addComponent(sron, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, 0)
            .addComponent(jScrollPane1))
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(l4Hex)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lab4TL)
                .addComponent(l4TL))
              .addComponent(Cost))
            .addGap(0, 0, 0)
            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(Used)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lab4pts)
                .addComponent(Left)
                .addComponent(Pts)))
            .addGap(0, 0, 0)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
        .addGap(0, 0, 0))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
//<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    ron = jComboBox1.getSelectedItem().toString().substring(0, 2);
    switch (ron) {
      case "AR": {
        Cost.setText("2.0");
        break;
      }
      case "BR": {
        Cost.setText("2.0");
        break;
      }
      case "CR": {
        Cost.setText("1.0");
        break;
      }
      case "SR": {
        Cost.setText("0.5");
        break;
      }
      case "TR": {
        Cost.setText("3.0");
        break;
      }
      default: {
        Cost.setText("0.0");
        break;
      }
    }
    cost = Double.parseDouble(Cost.getText());
    calcPts();
  }//GEN-LAST:event_jComboBox1ActionPerformed

  private void CostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CostMouseClicked
    costClick();
  }//GEN-LAST:event_CostMouseClicked

  private void sjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sjMouseClicked
    setMods("Jump");
  }//GEN-LAST:event_sjMouseClicked

  private void ssMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ssMouseClicked
    setMods("Sl");
  }//GEN-LAST:event_ssMouseClicked

  private void sdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sdMouseClicked
    setMods("Df");
  }//GEN-LAST:event_sdMouseClicked

  private void saMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saMouseClicked
    setMods("Af");
  }//GEN-LAST:event_saMouseClicked

  private void sbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbMouseClicked
    setMods("Bf");
  }//GEN-LAST:event_sbMouseClicked

  private void stMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stMouseClicked
//    setOptions("Tf");
  }//GEN-LAST:event_stMouseClicked

  private void ronsCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_ronsCaretUpdate
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    sj.setForeground(Color.GREEN);
    ss.setForeground(Color.GREEN);
    sd.setForeground(Color.GREEN);
    sa.setForeground(Color.GREEN);
    sb.setForeground(Color.GREEN);
    st.setForeground(Color.GREEN);
    Panel4T5CounterMaker.Folder.setSelectedItem("Squadron");
    if (!"".equals(rons.getText())) {
      try {
        calcPts();
        String[] lines = rons.getText().split(CRLF);
        offset = evt.getDot();
        int ln = rons.getLineOfOffset(offset);
        if (ln < lines.length) {
          String type = lines[ln].substring(0, 1);
          sron.setText(type);
          switch (type) {
            case "A": {
              jComboBox1.setSelectedIndex(0);
              break;
            }
            case "B": {
              jComboBox1.setSelectedIndex(1);
              break;
            }
            case "C": {
              jComboBox1.setSelectedIndex(2);
              break;
            }
            case "S": {
              jComboBox1.setSelectedIndex(3);
              break;
            }
            case "T": {
              jComboBox1.setSelectedIndex(4);
              break;
            }
          }
          setMods("Sl");
          String num = lines[ln].substring(1, 4);
          sidn.setText(num);
          double lab = 0.0;
          String s = "";
          line = lines[ln];
          //<editor-fold defaultstate="collapsed" desc="DEBUG">
          //DEBUG = false;
          if (DEBUG) {
            System.out.println("line" + " = " + line);
          }
          //</editor-fold>
          jLabel1.setText(line);
          switch (sron.getText()) {
            case "A": {
              lab = 2.0;
              s = "Assault";
              break;
            }
            case "B": {
              lab = 2.0;
              s = "Battle";
              break;
            }
            case "C": {
              lab = 1.0;
              s = "Cruiser";
              break;
            }
            case "S": {
              lab = 0.5;
              s = "Scout";
              break;
            }
            case "T": {
              lab = 3.0;
              s = "Tanker";
              break;
            }
          }
          try {
            sron.setText(s);
            jLabel10.setText("" + lab);
            nj.setText(line.substring(5, 6));
            ns.setText(line.substring(6, 7));
            nd.setText("" + line.substring(8, 9));
            na.setText("" + line.substring(9, 10));
            nb.setText("" + line.substring(10, 11));
            if (line.length() > 11) {
              String st = line.substring(12, line.lastIndexOf("-"));
              nt.setText(st);
            }
            line2Counter(line);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(jp, e.toString());
            System.out.println("1350" + " = " + e.toString());
          }
          Panel4T5CounterMaker.saveConfig();
          Panel4T5CounterMaker.savePic();
        } else {
          Panel4T5CounterMaker.setText.doClick();
        }
        //<editor-fold defaultstate="collapsed" desc="DEBUG">
        if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
            .getMethodName());
          System.out.println("offset" + " = " + offset);
          System.out.println("linen" + " = " + ln);
//          System.out.println("ls[linen].length()" + " = " + ls[linen].length());
          System.out.println("line" + " = " + line);
        }
        //</editor-fold>
      } catch (BadLocationException ex) {
        System.out.println("1363" + " = " + ex);
      }
    }
    Panel4T5CounterMaker.savePic();
    Panel4T5CounterMaker.loadOldList(counter);
  }//GEN-LAST:event_ronsCaretUpdate

  private void lab4ptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab4ptsMouseClicked
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    int mod = Integer.parseInt(tlmod.getText())
      + Integer.parseInt(resmod.getText())
      + Integer.parseInt(infmod.getText())
      + Integer.parseInt(culmod.getText());
    Panel4T5TableView.main(new String[]{"MaxStarshipSquadrons", gettl(), sdbs1
      .getText(), squadrons.getText()});
    Panel4T5TableView.setMod("" + mod);
    Panel4T5TableView.calcRowMod();
//    Panel4T5TableView.jf.setVisible(false);
    String reply = JOptionPane.showInputDialog(jComboBox1, "Enter Point Value",
      Panel4T5TableView.getMod());
//    System.out.println("reply" + " = " + reply);
    Pts.setText("" + reply + ".0");
    pts = Double.parseDouble(reply);
    used = 0.0;
    Used.setText("" + used);
    Left.setText(reply + ".0");
    left = Double.parseDouble(reply);
    rons.setText("");
  }//GEN-LAST:event_lab4ptsMouseClicked

  private void stypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stypeMouseClicked
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    loadFile();
    countUsed();
//    CaretEvent ce = null;
//    jtaCaretUpdate(ce);
  }//GEN-LAST:event_stypeMouseClicked

  private void modsCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_modsCaretUpdate
    //<editor-fold defaultstate="collapsed" desc="old">
    //    String olds = "";
    //    try {
    //      olds = jLabel1.getText().substring(6, 7);
    //      ron = jLabel1.getText().substring(0, 1) + "R";
    //      olddf = GlobalMethods.fromHex(jLabel1.getText().substring(8, 9));
    ////      System.out.println("olddf" + " = " + olddf);
    //      oldmod = 0;
    //      String[] strings = mods.getText().split(CRLF);
    //      for (int j = 0; j < strings.length; j++) {
    //        if (strings[j].startsWith(olds)) {
    //          oldmod = Integer.parseInt(strings[j].substring(4));
    ////          System.out.println("oldmod" + " = " + oldmod);
    //        }
    //      }
    ////      System.out.println("(olddf-oldmod)" + " = " + (olddf - oldmod));
    //    } catch (Exception e) {
    ////      System.out.println("" + " = " + e.toString());
    //    }
    //    boolean OK = true;
    //    try {
    //      String[] ls = mods.getText().split(CRLF);
    //      offset1 = evt.getDot();
    //      int linen = mods.getLineOfOffset(offset1);
    //      String s;
    //      if (linen < ls.length) {
    //        line = ls[linen];
    ////        System.out.println("line" + " = " + line);
    //        if (line.contains(",")) {
    //          //<editor-fold defaultstate="collapsed" desc="JDABT">
    //          String[] parts = line.split(",");
    //          for (int j = 0; j < parts.length; j++) {
    //            String target = parts[j].substring(0, 2);
    //            //            System.out.println("target" + " = " + target);
    //            int num = 0;
    //            int mod = Integer.parseInt(parts[j].substring(2));
    //            switch (target) {
    //              case "JU": {
    //                num = GlobalMethods.fromHex(nj.getText());
    //                break;
    //              }
    //              case "DF": {
    //                num = GlobalMethods.fromHex(nd.getText());
    //                break;
    //              }
    //              case "AF": {
    //                num = GlobalMethods.fromHex(na.getText());
    //                break;
    //              }
    //              case "BF": {
    //                num = GlobalMethods.fromHex(nb.getText());
    //                break;
    //              }
    //              case "TF": {
    //                num = GlobalMethods.fromHex(nt.getText());
    //                break;
    //              }
    //            }
    //            if (num + mod >= 0) {
    //              //              System.out.println("num + mod" + " = " + (num + mod));
    //            } else {
    //              //              System.out.println("NO CHANGE");
    //              OK = false;
    //            }
    //          }
    //          if (OK) {
    //            for (int j = 0; j < parts.length; j++) {
    //              String target = parts[j].substring(0, 2);
    //              //              System.out.println("target" + " = " + target);
    //              int num = 0;
    //              int mod = Integer.parseInt(parts[j].substring(2));
    //              switch (target) {
    //                case "JU": {
    //                  num = GlobalMethods.fromHex(nj.getText());
    //                  nj.setText("" + (num + mod));
    //                  break;
    //                }
    //                case "DF": {
    //                  num = GlobalMethods.fromHex(nd.getText());
    //                  nd.setText("" + (num + mod));
    //                  break;
    //                }
    //                case "AF": {
    //                  num = GlobalMethods.fromHex(na.getText());
    //                  na.setText("" + (num + mod));
    //                  break;
    //                }
    //                case "BF": {
    //                  num = GlobalMethods.fromHex(nb.getText());
    //                  nb.setText("" + (num + mod));
    //                  break;
    //                }
    //                case "TF": {
    //                  num = GlobalMethods.fromHex(nt.getText());
    //                  nt.setText("" + (num + mod));
    //                  break;
    //                }
    //              }
    //            }
    //          }
    //          //</editor-fold>
    //        } else {
    //          //<editor-fold defaultstate="collapsed" desc="SL">
    ////          if (!"".equals(line)) {
    ////            s = line.substring(0, 1);
    ////            ns.setText(s);
    ////            newmod = Integer.parseInt(line.substring(4));
    ////          }
    //          //</editor-fold>
    //        }
    //      }
    //      writeLabel();
    //      int x = (olddf - oldmod + newmod);
    ////      System.out.println("(olddf-oldmod+newmod)" + " = " + GlobalMethods.toHex(x));
    //      s = jLabel1.getText().substring(0, 8) + GlobalMethods.toHex(x) + jLabel1.getText().substring(9);
    //      jLabel1.setText(s);
    //      modList(s);
    //    } catch (BadLocationException ex) {
    //    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
  }//GEN-LAST:event_modsCaretUpdate

  private void sronMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sronMouseClicked
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
  }//GEN-LAST:event_sronMouseClicked

  private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    if (evt.getClickCount() > 1) {
      JPanel p4c = new Panel4("Colours");
      JColorChooser jcc = new JColorChooser(JColorChooser.showDialog(p4c, FS,
        Color.LIGHT_GRAY));
      color = jcc.getColor();
      jcc.setVisible(true);
      jp.setBackground(color);
      jf.setBackground(color);
//      Panel4UTP.image2Pic("squadron");
    }
  }//GEN-LAST:event_formMouseClicked

  private void jLabel1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel1PropertyChange
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.println("jLabel1.getText()" + " = " + jLabel1.getText());
    }
    //</editor-fold>
    line = jLabel1.getText();
  }//GEN-LAST:event_jLabel1PropertyChange

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//    Panel4Squadron.addLine();
////    costClick();
    saveFile();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
      deletePics();
      rons.setText("");
      saveFile();
      used = 0.0;
      Used.setText("" + used);
      jComboBox1.setSelectedIndex(2);
      Panel4T5CounterMaker.deleteXConfig();
    } catch (Exception e) {
      System.out.println("1613" + " = " + e.toString());
      System.out.println("" + " = " + e.getLocalizedMessage());
    }
  }//GEN-LAST:event_jButton2ActionPerformed

  private void l4HexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4HexMouseClicked
    systemChange();
  }//GEN-LAST:event_l4HexMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  static javax.swing.JLabel Cost;
  static javax.swing.JLabel Left;
  static javax.swing.JLabel Pts;
  static javax.swing.JLabel Used;
  static javax.swing.JLabel culmod;
  static javax.swing.JLabel infmod;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  public static javax.swing.JComboBox jComboBox1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel43;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  static javax.swing.JLabel l4Hex;
  static javax.swing.JLabel l4TL;
  private javax.swing.JLabel lab4TL;
  private javax.swing.JLabel lab4pts;
  private javax.swing.JTextArea mods;
  public static javax.swing.JLabel na;
  public static javax.swing.JLabel nb;
  static javax.swing.JLabel nd;
  public static javax.swing.JLabel nj;
  public static javax.swing.JLabel ns;
  public static javax.swing.JLabel nt;
  static javax.swing.JLabel resmod;
  public static javax.swing.JTextArea rons;
  public static javax.swing.JLabel sa;
  static javax.swing.JLabel sb;
  public static javax.swing.JLabel sd;
  private javax.swing.JLabel sid;
  public static javax.swing.JLabel sidn;
  public static javax.swing.JLabel sj;
  static javax.swing.JLabel sron;
  public static javax.swing.JLabel ss;
  private javax.swing.JLabel st;
  private javax.swing.JLabel stype;
  static javax.swing.JLabel tlmod;
  // End of variables declaration//GEN-END:variables

}
