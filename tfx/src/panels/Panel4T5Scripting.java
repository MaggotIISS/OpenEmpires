/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package panels;

import dbviewer.DBPublic;
import dbviewer.globals.GlobalMethods;
import dbviewer.globals.GlobalVariables;
import static dbviewer.globals.GlobalVariables.CRLF;
import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables.TAB;
import static dbviewer.globals.GlobalVariables._JS;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import static panels.Panel4T5TableView.jta;

/**

 @author Mark Ferguson
 */
public class Panel4T5Scripting extends Panel4 {

  //<editor-fold defaultstate="collapsed" desc="variables">
  static Frame4 jf;
  static Panel4 jp;
  static JFileChooser jfc;// = DBPublic.CBView();
  static ScriptEngineManager manager;
  static ScriptEngine engine;
  static Bindings bindings;
  static String ext = ".txt";
  /////////////////////////////////
  /////////////////////////////////
  static final String start
    = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
    + "<!-- <?xml-stylesheet type=\"text/xsl\" href=\"Systems.xsl\"?> -->"
    + "<!DOCTYPE Systems SYSTEM \"file:///C://T5/_JS/DTD.dtd\">\n"
    + "<!-- This is a comment -->\n"
    + "<Systems xmlns:Systems=\"file:///C://T5/_JS/ns.txt\">\n";
  /////////////////////////////////
  static final String worldstart = "  <System>\n";
  static final String hex = "    <hex></hex>\n";
  static final String sname = "    <sname></sname>\n";
  static final String UWP = "    <UWP></UWP>\n";
  static final String st = "    <st></st>\n";
  static final String si = "    <si></si>\n";
  static final String at = "    <at></at>\n";
  static final String hy = "    <hy></hy>\n";
  static final String po = "    <po></po>\n";
  static final String go = "    <go></go>\n";
  static final String ll = "    <ll></ll>\n";
  static final String tl = "    <tl></tl>\n";
  static final String remarks = "    <remarks></remarks>\n";
  static final String ix = "    <ix></ix>\n";
  static final String ex = "    <ex></ex>\n";
  static final String cx = "    <cx></cx>\n";
  static final String n = "    <n></n>\n";
  static final String b = "    <b></b>\n";
  static final String z = "    <z></z>\n";
  static final String pbg = "    <pbg></pbg>\n";
  static final String w = "    <w></w>\n";
  static final String a = "    <a></a>\n";
  static final String stellar = "    <stellar></stellar>\n";
  static final String worldend = "  </System>\n";
  /////////////////////////////////
  static String SystemsData
    = worldstart
    + hex + sname + UWP + st + si + at + hy + po + go + ll + tl + remarks + ix
    + ex + cx + n + b + z + pbg + w + a + stellar
    + worldend;
  /////////////////////////////////
  static final String crewstart = "  <Crew>\n";
  static final String role = "    <role></role>\n";
  static final String cname = "    <cname></cname>\n";
  static final String upp = "    <upp></upp>\n";
  static final String ai = "    <ai></ai>\n";
  static final String ship = "    <ship></ship>\n";
  static final String vehicle = "    <vehicle></vehicle>\n";
  static final String crewend = "  </Crew>\n ";
  /////////////////////////////////
  static String CrewsData
    = crewstart
    + role
    + cname
    + upp
    + ai
    + ship
    + vehicle
    + crewend;
  /////////////////////////////////
  static final String shipsstart = "  <Ship>\n";
  static final String id = "    <col0></col0>\n";
  static final String shname = "    <col1></col1>\n";
  static final String dt = "    <col2></col2>\n";
  static final String gee = "    <col3></col3>\n";
  static final String jump = "    <col4></col4>\n";
  static final String crew = "    <col5></col5>\n";
  static final String pass = "    <col6></col6>\n";
  static final String cargo = "    <col7></col7>\n";
  static final String shipsend = "  </Ship>\n ";
  /////////////////////////////////
  static String ShipsData
    = shipsstart
    + id
    + shname
    + gee
    + jump
    + crew
    + pass
    + cargo
    + shipsend;
  /////////////////////////////////

  static String systemend = "</System>" + CRLF + "</DOCTYPE>";
  static MouseEvent me;
  static int[] lens;
  static String[] parts;
  static String Data;
  static String[] titles;
  static String[] data;
  static String txt;
  static int min = 0;
  static int max = 0;
  static String lineinfo;
  static int l = 0;
  static String stylesheet;
  static String s;
  static String shipname;
  static String named;
  static String sel;
  static String folder = "";

  PropertyChangeEvent pce = null;
  static int ret;
  static String xlink = "";
  static String link
    = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
    + "<?xml-stylesheet type=\"text/xsl\" href=\"STYLESHEET\"?>\n"
    + "<xlink xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n"
    + "  <xlink xlink:type=\"simple\" xlink:href=\"http://www.w3schools.com\">Visit W3Schools</xlink>\n"
    + "</xlink>\n";
  static String text = "// BlankTXT";
  static String dtd = "// BlankDTD";
  static String xsd = "// BlankXSD";
  static String css = "// BlankCSS";
  static String csv = "// BlankCSV";
  static String fx = "// BlankFX";
  static String html = "// BlankHTML";
  static String javas = "// BlankJava";
  static String js = "// BlankJavaScript";
  static String title;
  String end = "";
  //</editor-fold>
  static String savename = "";

  /**

   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4T5Scripting();
  }

  /**
   Creates new form Panel4T5Scripting
   */
  public Panel4T5Scripting() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    initComponents();
    manager = new ScriptEngineManager();
    engine = manager.getEngineByName("nashorn");
    bindings = engine.createBindings();
    jfc = DBPublic.CBView();
    jf = new Frame4(this);
    Folder.setSelectedIndex(9);
    Ext.setSelectedIndex(1);
    folder = Folder.getSelectedItem().toString();
    String path = _JS + FS + folder;
    jfc.setCurrentDirectory(new File(path));
    setExt(Ext.getSelectedItem().toString());
    change(Ext.getSelectedItem().toString());
    jf.setBounds(1200, 150, 650, 350);
    setFName();
    sel = Folder.getSelectedItem().toString();
    recreateFolders();
  }

  static void setExt(String sel) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("jfc.getCurrentDirectory()" + " = " + jfc
        .getCurrentDirectory());
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    jfc.setCurrentDirectory(new File(folder));
    System.out.println("jfc.getCurrentDirectory()" + " = " + jfc
      .getCurrentDirectory());
    jfc.resetChoosableFileFilters();
    jfc.setAcceptAllFileFilterUsed(true);
    jfc.setFileFilter(new FileFilter() {

      @Override
      public boolean accept(File f) {
        if (f == null) {
          return false;
        } else {
          return f.isDirectory() | f.toString().endsWith(sel);
        }
      }

      @Override
      public String getDescription() {
        return sel + " Files";
      }
    });
  }

  static void saveFile(boolean dlg) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    setFName();
    jfc.setCurrentDirectory(new File(_JS + FS + Folder.getSelectedItem()
      .toString()));
    if (dlg) {
      ret = jfc.showSaveDialog(Folder);
      if (ret == JFileChooser.APPROVE_OPTION) {
        saveIt();
      }
    } else {
      saveIt();
    }
  }

  static void saveIt() {
    //String f = jfc.getCurrentDirectory() + FS + jfc.getSelectedFile().toString();
    String f = jfc.getSelectedFile().toString();
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
      System.out.println("f" + " = " + f);
    }
    //</editor-fold>
    if (!f.contains(".")) {
      f += ext;
    }
    path.setText(f);
    GlobalMethods.saveTextFile(
      jfc.getCurrentDirectory().toString(),
      Name.getText(),
      ext,
      XML.getText());
  }

  void openFile() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    jfc.setCurrentDirectory(new File(_JS + FS + sel));
    JTextArea jta = null;
    switch (Ext.getSelectedItem().toString()) {
      case ".xml":
      case ".html":
      case "Me.java":
      case "FX.java":
      default: {
        jta = XML;
        break;
      }
      case ".xsl": {
        jta = XSL;
        break;
      }
      case ".txt":
      case ".csv":
      case ".js":
      case ".css": {
        jta = CSV;
        break;
      }
    }
//    clearAreas();
    setFName();
    int ret = jfc.showOpenDialog(Ext);
    if (ret == JFileChooser.APPROVE_OPTION) {
      String f = jfc.getSelectedFile().toString();
      path.setText(f);
      String txt = GlobalMethods.loadTextFile(f);
      jta.setText(txt);
      int start = 0, end = 0;
      start = jfc.getSelectedFile().toString().lastIndexOf("-") + 1;
//      if ("Catalogs".equals(sel)) {
//        System.out.println("" + " = " + sel);
      start = jfc.getSelectedFile().toString().lastIndexOf(FS) + 1;
//      }
      end = jfc.getSelectedFile().toString().lastIndexOf(".");
      Name.setText("" + jfc.getSelectedFile().toString().substring(start, end));
    }
    showFullNames();
  }

  static void setFName() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    try {
      sel = Folder.getSelectedItem().toString();
      jfc.setCurrentDirectory(new File(_JS + FS + sel));
    } catch (Exception e) {
      sel = GlobalVariables.T5;
      jfc.setCurrentDirectory(new File(sel));
    } finally {

    }
    ext = Ext.getSelectedItem().toString();
    setExt(ext);
    String name = Name.getText() + ext;
    if ("Sectors".equals(Folder.getSelectedItem().toString())) {
      name = Panel4T5Locator.jcb4Sec.getSelectedItem().toString().trim() + ext;
    } else if ("SubSectors".equals(Folder.getSelectedItem().toString())) {
      name = Panel4T5Locator.jcb4Sub.getSelectedItem().toString().trim() + ext;
    } else if ("Systems".equals(Folder.getSelectedItem().toString())) {
      name = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + ext;
    } else {
//      JOptionPane.showMessageDialog(jf, Folder.getSelectedItem().toString());
    }
    jfc.setSelectedFile(new File(name));
  }

  static void showFullNames() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    showFullName(xmlName);
    showFullName(xslName);
    showFullName(csvName);
  }

  static String getMinMaxXY(String sub) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    int mix = 0;
    int max = 0;
    int miy = 0;
    int may = 0;
    //<editor-fold defaultstate="collapsed" desc="comment">
    switch (sub) {
      case "A":
      case "E":
      case "I":
      case "M": {
        mix = 1;
        max = 8;
        break;
      }
      case "B":
      case "F":
      case "J":
      case "N": {
        mix = 9;
        max = 16;
        break;
      }
      case "C":
      case "G":
      case "K":
      case "O": {
        mix = 17;
        max = 24;
        break;
      }
      case "D":
      case "H":
      case "L":
      case "P": {
        mix = 25;
        max = 32;
        break;
      }
      default: {
        JOptionPane.showMessageDialog(jf, "DEFAULT 437: " + sub);
      }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="comment">
    switch (sub) {
      case "A":
      case "B":
      case "C":
      case "D": {
        miy = 1;
        may = 10;
        break;
      }
      case "E":
      case "F":
      case "G":
      case "H": {
        miy = 11;
        may = 20;
        break;
      }
      case "I":
      case "J":
      case "K":
      case "L": {
        miy = 21;
        may = 30;
        break;
      }
      case "M":
      case "N":
      case "O":
      case "P": {
        miy = 31;
        may = 40;
        break;
      }
      default: {
        JOptionPane.showMessageDialog(jf, "DEFAULT 476" + sub);
      }
    }
    //</editor-fold>

    String s = "" + mix + " " + miy + " " + max + " " + may;
    return s;
  }

  static void showWeb() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    try {
      String b;
      if ("".equals(Name.getText())) {
//        b = "http://www.w3schools.com/js/default.asp";
        b = "http://www.w3schools.com/xsl/default.asp";
      } else {
        b = _JS + FS + Folder.getSelectedItem().toString() + FS
          + path.getText();
      }
      if ((Folder.getSelectedItem().toString().equals("Catalogs"))) {
        b = _JS + FS + Folder.getSelectedItem().toString() + FS
          + path.getText();
      }
      String FTYPE = Folder.getSelectedItem().toString();
      String CTYPE = Panel4T5CounterMaker.Folder.getSelectedItem()
        .toString();
      if ((FTYPE.equals("Counters"))) {
        b = _JS + FS + Folder.getSelectedItem().toString() + FS
          + Panel4T5CounterMaker.jt4File.getText() + "-"
          + Panel4T5CounterMaker.Folder.getSelectedItem().toString();
        if ("Squadron".equals(CTYPE) | "Troop".equals(CTYPE)) {
          String t12 = Panel4T5CounterMaker.t12.getText();
          if (!"".equals(t12)) {
            b += "-" + t12;
          } else {
          }
        }
        b += ".html";
      }
      b = b.replace(".xml", ".html");
//      JOptionPane.showMessageDialog(jf, "b = " + b);
      String path = "C:\\Program Files (x86)\\Mozilla Firefox\\";
      String name = "firefox.exe";
      String a = path + name;
      Runtime runtime = Runtime.getRuntime();
      ProcessBuilder pb = new ProcessBuilder(a, b);
      pb.start();
    } catch (IOException ex) {
//      Logger.getLogger(Panel4T5Launch.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println("524" + " = " + ex.toString());
    }
  }

  static void updateWorld(String txt) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    int l = 0;
    try {
      for (int j = 0; j < lens.length; j++) {
        lens[j] = parts[j].length();
        parts[j] = txt.substring(l, l + lens[j]);
        l = (l + lens[j] + 1);
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(jp, "EXCEPTION: 556\n" + e.toString());
      System.out.println("" + " = " + e.toString());
      lens = new int[1];
      lens[0] = parts[0].length();
      parts[0] = txt.substring(0, 4);
      l = 4 + 1;
    }
    SystemsData
      = worldstart
      + hex.replace("><", ">" + parts[0].trim() + "<")
      + sname.replace("><", ">" + parts[1].trim() + "<")
      + UWP.replace("><", ">" + parts[2].trim() + "<")
      + st.replace("><", ">" + parts[2].substring(0, 1) + "<")
      + si.replace("><", ">" + parts[2].substring(1, 2) + "<")
      + at.replace("><", ">" + parts[2].substring(2, 3) + "<")
      + hy.replace("><", ">" + parts[2].substring(3, 4) + "<")
      + po.replace("><", ">" + parts[2].substring(4, 5) + "<")
      + go.replace("><", ">" + parts[2].substring(5, 6) + "<")
      + ll.replace("><", ">" + parts[2].substring(6, 7) + "<")
      + tl.replace("><", ">" + parts[2].substring(8, 9) + "<")
      + remarks.replace("><", ">" + parts[3].trim() + "<")
      + ix.replace("><", ">" + parts[4].trim() + "<")
      + ex.replace("><", ">" + parts[5].trim() + "<")
      + cx.replace("><", ">" + parts[6].trim() + "<")
      + n.replace("><", ">" + parts[7].trim() + "<")
      + b.replace("><", ">" + parts[8].trim() + "<")
      + z.replace("><", ">" + parts[9].trim() + "<")
      + pbg.replace("><", ">" + parts[10].trim() + "<")
      + w.replace("><", ">" + parts[11].trim() + "<")
      + a.replace("><", ">" + parts[12].trim() + "<")
      + stellar.replace("><", ">" + parts[13].trim() + "<")
      + worldend;
  }

  /**
   writeXML
   */
  public static void writeXML() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    String x = ".xml";
    Ext.setSelectedItem(x);
    CSV.setText("");
    saveXML(Folder.getSelectedItem().toString(), false);
    saveFile(false);
    showWeb();
    showFullNames();
  }

  private static void showStyleSheet(String foldername) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    stylesheet = foldername + ".xsl";
    switch (foldername) {
      case "Sectors":
      case "SubSectors":
      case "Systems":
      case "Routes": {
        stylesheet = "Systems.xsl";
        break;
      }
      case "Catalogs": {
        stylesheet = Name.getText() + ".xsl";
        break;
      }
    }
    try {
      File f = new File(_JS + FS + foldername + FS + stylesheet);
      String[] data = GlobalMethods.getLinesFromFile(f);
      for (int j = 0; j < data.length; j++) {
        XSL.append(data[j] + CRLF);
      }
    } catch (Exception e) {
      JOptionPane.showMessageDialog(jp, "EXCEPTION: 435\n" + e.toString());
      System.out.println("" + " = " + e.toString());
    }
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
//    boolean DEBUG = false;
    if (DEBUG) { // true or false
//      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
      System.out.println("Desired stylesheet" + " = " + stylesheet);
    }
    //</editor-fold>
  }

  static void csv2WebTable(String sel) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("sel" + " = " + sel);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    named = _JS + FS + sel + FS + shipname + ".xml";
    //<editor-fold defaultstate="collapsed" desc="switch (Folder.getSelectedItem().toString())">
    switch (Folder.getSelectedItem().toString()) {
      case "Sectors": {
        named = Panel4T5Locator.jcb4Sec.getSelectedItem().toString();
        break;
      }
      case "SubSectors": {
        named = Panel4T5Locator.jcb4Sub.getSelectedItem().toString();
        break;
      }
      case "Systems": {
        named = Panel4T5Locator.jcb4Sys.getSelectedItem().toString();
        break;
      }
    }
    //</editor-fold>
    jfc.setSelectedFile(new File(named));
    XSL.setText("");
    data = GlobalMethods.getLinesFromFile(new File(named.replace("xml", "txt")));
    CSV.setText("");
    for (int j = 0; j < data.length; j++) {
      txt = data[j];
      CSV.append(txt + "\n");
      parts = txt.split("\",\"");
      if (j == 0) {
        titles = new String[parts.length];
      }
      for (int k = 0; k < parts.length; k++) {
        if (k == 0) {
//          String string = "";
//          string += "<col0 xlink:type=\"simple\" xlink:href=\"http://www.w3schools.com\">A</col0>";
//          parts[k] = string;
////          parts[k] = "<link xlink:type=\"simple\" xlink:href=\"http://www.w3schools.com\">W3Schools</link>";
////          parts[k] = "<link xlink:type=\"simple\" xlink:href=\"http://www.w3schools.com\">W3Schools</link>";
        }
        parts[k] = parts[k].replace("\"", "");
        parts[k] = parts[k].replace("\t", "");
        parts[k] = parts[k].replace("+", "");
        if (j == 0) {
          titles[k] = parts[k].toUpperCase();
        }
        parts[k] = parts[k].replace("\"", "");
      }
      s += "" + txt + CRLF;
      if (j > 0) {
        updateData(txt);
        s += "" + Data + CRLF;
      }
    }
//    s += "<links xmlns:xlink=\"http://www.w3.org/1999/xlink\">\n"
//      + "  <link xlink:type=\"simple\" xlink:href=\"http://www.w3schools.com\">W3Schools</link>\n"
//      + "  <link xlink:type=\"simple\" xlink:href=\"http://www.w3.org\">W3C</link>\n"
//      + "</links>\n"
//      + "";
    s += systemend;
    s = s.replace("Crew", sel.substring(0, sel.length() - 1));
    XML.setText(s);
    XML.setToolTipText(named);
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
//    boolean DEBUG = false;
    if (DEBUG) { // true or false
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
      System.out.println("path" + " = " + path.getText());
      System.out.println("Folder" + " = " + Folder.getSelectedItem().toString());
      System.out.println("Name" + " = " + Name.getText());
      System.out.println("Ext" + " = " + Ext.getSelectedItem().toString());
      System.out.print(GlobalMethods.comment("=", 80));
    }
    //</editor-fold>
    saveXSL(sel);
  }

  private void labelMouseClick(JLabel lab, MouseEvent evt) {
    if (evt.getClickCount() > 1) {
      JTextArea jta = new JTextArea();
      JLabel l = new JLabel("");
      //<editor-fold defaultstate="collapsed" desc="switch (lab.getToolTipText())">
      switch (lab.getToolTipText()) {
        case "XML": {
          l = xmlName;
          end = ".xml";
          jta = XML;
          break;
        }
        case "XSL": {
          l = xslName;
          end = ".xsl";
          jta = XSL;
          break;
        }
        case "CSV": {
          l = csvName;
          end = ".csv";
          jta = CSV;
          break;
        }
        case "HTML": {
          l = htmlName;
          end = ".html";
          jta = HTML;
          break;
        }
        default: {
          JOptionPane.showMessageDialog(jf, "777 OOPs");
        }
      }
      //</editor-fold>
//    setExt(end);
      Ext.setSelectedItem(end);
      jfc.resetChoosableFileFilters();
      jfc.setFileFilter(new FileFilter() {

        @Override
        public boolean accept(File f) {
          return f.isDirectory() | f.toString().endsWith(end);
        }

        @Override
        public String getDescription() {
          return "" + end.substring(1).toUpperCase()
            + " files";
        }
      });
      int ret = jfc.showOpenDialog(this);
      if (ret == JFileChooser.APPROVE_OPTION) {
        String name = jfc.getSelectedFile().toString();
        String txt = GlobalMethods.loadTextFile(name);
        jta.setText(txt);
        l.setText(jfc.getSelectedFile().toString());
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          String method = Thread.currentThread().getStackTrace()[1]
            .getMethodName();
          System.out.println("\t" + method);
          System.out.println("lab.getToolTipText()" + " = " + lab
            .getToolTipText());
        }
        //</editor-fold>
      }
    }
  }

  private void recreateFolders() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    for (int j = 0; j < Folder.getItemCount(); j++) {
      System.out.println("" + " = ");
      System.out.println("j" + " = " + j);
      String folder = Folder.getItemAt(j).toString();
      File f = new File(_JS + FS + folder);
      //<editor-fold defaultstate="collapsed" desc="DEBUG">
      //DEBUG = false;
      if (DEBUG) {
        System.out.print("1-f.toString()" + " = " + f.toString() + CRLF);
      }
      //</editor-fold>
      if (!f.exists()) {
        boolean yn = f.mkdir();
        //<editor-fold defaultstate="collapsed" desc="DEBUG">
        //DEBUG = false;
        if (DEBUG) {
          System.out.print("2-create" + " = " + yn + CRLF);
        }
        //</editor-fold>
      }
//      folder = Folder.getItemAt(j).toString();
      f = new File(_JS + FS + folder + ".xsl");
      if (j <= 3) {
        f = new File(_JS + FS + "Systems.xsl");
      }
      //<editor-fold defaultstate="collapsed" desc="DEBUG">
      //DEBUG = false;
      if (DEBUG) {
        System.out.print("3-f.toString()" + " = " + f.toString() + CRLF);
      }
      //</editor-fold>
      File srcfile = new File(f.toString());
      File destfile = new File(_JS + FS + Folder.getItemAt(j) + FS
        + f.toString().substring(f.toString().lastIndexOf(FS) + 1));
      //<editor-fold defaultstate="collapsed" desc="DEBUG">
//      DEBUG = false;
      if (DEBUG) {
        System.out.print("4-f" + " = " + f + CRLF);
        System.out.println("4-srcfile" + " = " + srcfile);
        System.out.println("4-destfile" + " = " + destfile);
      }
      //</editor-fold>
      if (!destfile.exists()) {
        try {
          //<editor-fold defaultstate="collapsed" desc="DEBUG">
          //DEBUG = false;
          if (DEBUG) {
            System.out.println(
              "COPY" + " " + srcfile.toString() + " AS " + destfile.toString());
          }
          //</editor-fold>
          Files.copy(srcfile.toPath(), destfile.toPath());
        } catch (IOException ex) {
          System.out.println("ex" + " = " + ex);
        }
      }
    }
//    createBlankXLink();
  }

  private static void clearAreas() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    XML.setText("");
    CSV.setText("");
    XSL.setText("");
  }

  private static String findHex(String data) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    data = data.substring(1, 5);
    for (int j = Panel4T5Locator.world1; j < Panel4T5Locator.lines.length; j++) {
      if (Panel4T5Locator.lines[j].startsWith(data)) {
        return (Panel4T5Locator.lines[j]);
      }
    }
    return "ERROR";
  }

  private static String getLongestParts() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    return Panel4T5Locator.getSpaceInfo(
      Panel4T5Locator.lines[Panel4T5Locator.world1 - 1]);
  }

  private void change(Object selectedItem) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    setFName();
    jfc.setSelectedFile(new File(selectedItem.toString()));
  }

  private static void showFullName(JLabel lab) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    String s = "";
    String na = _JS + FS + Folder.getSelectedItem().toString() + FS + Name
      .getText();

    s += na;

    switch (lab.getToolTipText()) {
      case "XML": {
        s += ".xml";
        break;
      }
      case "XSL": {
        s += ".xsl";
        break;
      }
      case "TXT": {
        s += ".txt";
        break;
      }
      case "CSV": {
        s += ".csv";
        break;
      }
      default: {
//        JOptionPane.showMessageDialog(jf, "DEFAULT: 983\n" + lab.getLabelFor());
      }
    }
    lab.setText(s);
  }

  private void clearIt(MouseEvent evt) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    if (evt.getClickCount() > 2) {
      XML.setText("");
      CSV.setText("");
//      jTextArea3.setText("");
    }
  }

  private void executeJS() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    Object result = null;
    CSV.setText("");
    JTextArea jta = null;
    if (XSL.getText().equals("")) {
      jta = XML;
    } else {
      jta = XSL;
    }
    try {
      result = engine.eval(jta.getText());
    } catch (ScriptException ex) {
      Logger.getLogger(Panel4T5Scripting.class.getName())
        .log(Level.SEVERE, null, ex);
    }
    CSV.append((String) result);
  }

  private void loader() {
    jfc.setCurrentDirectory(new File(_JS + FS + Folder.getSelectedItem()
      .toString()));
    jfc.setSelectedFile(new File(Name.getText()));
    int ret = jfc.showOpenDialog(jButton1);
    if (ret == JFileChooser.APPROVE_OPTION) {
      int start = jfc.getSelectedFile().toString().lastIndexOf(FS) + 1;
//      int end = jfc.getSelectedFile().toString().length() - 4;
      int end = jfc.getSelectedFile().toString().lastIndexOf(".");
      String ss = jfc.getSelectedFile().toString().substring(start, end);
      Name.setText(ss);
      writeXML();
    }
  }

  private void nameChange() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    MouseEvent me = null;
    jLabel2MouseClicked(me);
//    showFullName(xmlName);
  }

  private void showXSL(String stylesheet) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    File f = new File(
      _JS + FS + Folder.getSelectedItem().toString() + FS + stylesheet);
    if (f.exists()) {
      XSL.setText(GlobalMethods.loadTextFile(f.toString()));
      XSL.setToolTipText(f.toString());
      xslName.setText(f.toString());
    } else {
      XSL.setText("");
//      f = new File(_JS + FS + Folder.getSelectedItem().toString() + ".xsl");
//      if (Folder.getSelectedIndex() < 4) {
//        f = new File(_JS + FS + "Systems.xsl");
//      }
//      if (f.exists()) {
//        XSL.setText(GlobalMethods.loadTextFile(f.toString()));
//        xslName.setText(f.toString());
//      }
    }
  }

  private void updateCrews(String data) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    String[] parts = data.split("\",\"");
    for (String part : parts) {
      part.replace("\"", "");
    }
    CrewsData
      = crewstart
      + role.replace("><", ">" + parts[0].replace("\"", "").trim() + "<")
      + cname.replace("><", ">" + parts[1].replace("\"", "").trim() + "<")
      + upp.replace("><", ">" + parts[2].replace("\"", "").trim() + "<")
      + ai.replace("><", ">" + parts[3].replace("\"", "").trim() + "<")
      + ship.replace("><", ">" + parts[4].replace("\"", "").trim() + "<")
      + vehicle.replace("><", ">" + parts[5].replace("\"", "").trim() + "<")
      + crewend;
  }

  private void updateShips(String data) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    String[] parts = data.split("\",\"");
    for (String part : parts) {
      part.replace("\"", "");
    }
    ShipsData
      = shipsstart
      + id.replace("><", ">" + parts[0].replace("\"", "").trim() + "<")
      + shname.replace("><", ">" + parts[1].replace("\"", "").trim() + "<")
      + dt.replace("><", ">" + parts[2].replace("\"", "").trim() + "<")
      + gee.replace("><", ">" + parts[3].replace("\"", "").trim() + "<")
      + jump.replace("><", ">" + parts[4].replace("\"", "").trim() + "<")
      + crew.replace("><", ">" + parts[5].replace("\"", "").trim() + "<")
      + pass.replace("><", ">" + parts[6].replace("\"", "").trim() + "<")
      + cargo.replace("><", ">" + parts[7].replace("\"", "").trim() + "<")
      + shipsend;
  }

  private static void updateData(String txt) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    String s = Folder.getSelectedItem().toString();
    String sh = s.substring(0, s.length() - 1);
    Data = crewstart.replace("Crews", sh);
    for (int j = 0; j < parts.length; j++) {
      Data += "    " + "<XXX>".replace("XXX", "col" + j)
        + parts[j]
        + "</XXX>\n".replace("XXX", "col" + j);
    }
    Data += crewend.replace("Crews", sh);
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

    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    path = new javax.swing.JTextField();
    jLabel9 = new javax.swing.JLabel();
    Name = new javax.swing.JTextField();
    Ext = new javax.swing.JComboBox();
    jLabel10 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    executeJS = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    array2csv = new javax.swing.JLabel();
    file2csv = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    CSV = new javax.swing.JTextArea();
    jScrollPane4 = new javax.swing.JScrollPane();
    HTML = new javax.swing.JTextArea();
    xslName = new javax.swing.JLabel();
    csvName = new javax.swing.JLabel();
    jScrollPane3 = new javax.swing.JScrollPane();
    XSL = new javax.swing.JTextArea();
    jScrollPane1 = new javax.swing.JScrollPane();
    XML = new javax.swing.JTextArea();
    xmlName = new javax.swing.JLabel();
    htmlName = new javax.swing.JLabel();

    jLabel2.setForeground(java.awt.Color.green);
    jLabel2.setText("S");
    jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel2MouseClicked(evt);
      }
    });

    jLabel3.setForeground(java.awt.Color.green);
    jLabel3.setText("O");
    jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel3MouseClicked(evt);
      }
    });

    path.setHorizontalAlignment(javax.swing.JTextField.LEFT);
    path.setText("C:/T5/_JS");
    path.setToolTipText("Filename");
    path.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        pathMouseClicked(evt);
      }
    });
    path.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        pathActionPerformed(evt);
      }
    });

    setBackground(new java.awt.Color(0, 0, 0));
    setOpaque(true);

    jLabel9.setForeground(java.awt.Color.green);
    jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel9.setText("Browse");
    jLabel9.setFocusable(false);
    jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel9MouseClicked(evt);
      }
    });

    Name.setText("SkyRig");
    Name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Name.setMaximumSize(new java.awt.Dimension(34, 16));
    Name.setMinimumSize(new java.awt.Dimension(34, 16));
    Name.setName(""); // NOI18N
    Name.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        NameMouseClicked(evt);
      }
    });

    Ext.setMaximumRowCount(12);
    Ext.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".txt", ".xml", ".xsl", ".dtd", ".xsd", ".html", "Me.java", "FX.java", ".csv", ".js", ".css", ".ent" }));
    Ext.setToolTipText("Open");
    Ext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Ext.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        ExtMouseClicked(evt);
      }
    });
    Ext.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ExtActionPerformed(evt);
      }
    });

    Folder.setMaximumRowCount(10);
    Folder.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "array2CSV", "txt2CSV", "csv2XML", "xml2XSL", "xsl2HTML", "Sectors", "SubSectors", "Systems", "Routes", "Crews", "Ships", "Rons", "Fleets", "Catalogs", "Counters" }));
    Folder.setToolTipText("Save");
    Folder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    Folder.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        FolderMouseClicked(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        FolderMouseReleased(evt);
      }
    });
    Folder.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        FolderActionPerformed(evt);
      }
    });

    jLabel10.setForeground(java.awt.Color.green);
    jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel10.setText("writeXML");
    jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel10MouseClicked(evt);
      }
    });

    jButton1.setText("jfc");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    executeJS.setForeground(java.awt.Color.green);
    executeJS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    executeJS.setText("executeJS");
    executeJS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    executeJS.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        executeJSMouseClicked(evt);
      }
    });

    jLabel1.setForeground(java.awt.Color.green);
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("getNames");
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    jLabel11.setForeground(java.awt.Color.green);
    jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel11.setText("writeTXT");
    jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel11MouseClicked(evt);
      }
    });

    array2csv.setForeground(java.awt.Color.green);
    array2csv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    array2csv.setText("array2CSV");
    array2csv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    array2csv.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        array2csvMouseClicked(evt);
      }
    });

    file2csv.setForeground(java.awt.Color.green);
    file2csv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    file2csv.setText("file2CSV");
    file2csv.setToolTipText("file");
    file2csv.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    file2csv.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        file2csvMouseClicked(evt);
      }
    });

    jPanel1.setOpaque(false);

    CSV.setColumns(20);
    CSV.setRows(5);
    CSV.setToolTipText("CSV");
    jScrollPane2.setViewportView(CSV);

    HTML.setColumns(20);
    HTML.setRows(5);
    HTML.setToolTipText("HTML");
    jScrollPane4.setViewportView(HTML);

    xslName.setForeground(java.awt.Color.green);
    xslName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    xslName.setLabelFor(XSL);
    xslName.setText("xslName");
    xslName.setToolTipText("XSL");
    xslName.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        xslNameMouseClicked(evt);
      }
    });

    csvName.setForeground(java.awt.Color.green);
    csvName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    csvName.setLabelFor(CSV);
    csvName.setText("csvName");
    csvName.setToolTipText("CSV");
    csvName.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        csvNameMouseClicked(evt);
      }
    });

    XSL.setColumns(20);
    XSL.setRows(5);
    XSL.setToolTipText("XSL");
    XSL.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        XSLMouseClicked(evt);
      }
    });
    XSL.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        XSLPropertyChange(evt);
      }
    });
    jScrollPane3.setViewportView(XSL);

    XML.setColumns(20);
    XML.setRows(5);
    XML.setToolTipText("XML");
    XML.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        XMLMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(XML);

    xmlName.setForeground(java.awt.Color.green);
    xmlName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    xmlName.setLabelFor(XML);
    xmlName.setText("xmlName");
    xmlName.setToolTipText("XML");
    xmlName.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        xmlNameMouseClicked(evt);
      }
    });

    htmlName.setForeground(java.awt.Color.green);
    htmlName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    htmlName.setLabelFor(HTML);
    htmlName.setText("htmlName");
    htmlName.setToolTipText("HTML");
    htmlName.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        htmlNameMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(csvName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(xmlName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jScrollPane1)
            .addGap(6, 6, 6)))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
          .addComponent(jScrollPane4)
          .addComponent(htmlName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(xslName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(xslName)
            .addGap(0, 0, 0)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
              .addComponent(jScrollPane3))
            .addGap(0, 0, 0)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(htmlName)
              .addComponent(csvName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(3, 3, 3)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
              .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(xmlName)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(array2csv, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Folder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Ext, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(file2csv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(executeJS, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Ext, Folder, array2csv, executeJS, jLabel1, jLabel10, jLabel11, jLabel9});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(Folder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton1))
        .addGap(0, 0, 0)
        .addComponent(Ext, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(4, 4, 4)
        .addComponent(file2csv, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(array2csv, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(94, 94, 94)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 121, Short.MAX_VALUE)
        .addComponent(executeJS, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Name, jButton1});

    layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Ext, Folder});

    layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {array2csv, executeJS, jLabel1, jLabel10, jLabel11, jLabel9});

  }// </editor-fold>//GEN-END:initComponents

  private void pathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathActionPerformed
    nameChange();
  }//GEN-LAST:event_pathActionPerformed

  private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
    openFile();
  }//GEN-LAST:event_jLabel3MouseClicked

  private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
    saveFile(true);
  }//GEN-LAST:event_jLabel2MouseClicked

  private void XMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XMLMouseClicked
    clearIt(evt);
  }//GEN-LAST:event_XMLMouseClicked

  private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
    showWeb();
  }//GEN-LAST:event_jLabel9MouseClicked

  private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
    writeXML();

  }//GEN-LAST:event_jLabel10MouseClicked

  private void pathMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathMouseClicked
    String s = path.getText();
    GlobalMethods.txt2cb(s);
    if (evt.getClickCount() > 1) {
      path.setText("");
    }
  }//GEN-LAST:event_pathMouseClicked

  private void ExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExtActionPerformed
    setExt(Ext.getSelectedItem().toString());
  }//GEN-LAST:event_ExtActionPerformed

  private void FolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FolderActionPerformed
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    change(Ext.getSelectedItem().toString());
    if (".xml".equals(Folder.getSelectedItem().toString())) {
      writeXML();
    } else {
    }
    Name.setText("");
  }//GEN-LAST:event_FolderActionPerformed

  private void ExtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExtMouseClicked
    if (evt.getClickCount() > 1) {
      clearAreas();
      openFile();
    }
  }//GEN-LAST:event_ExtMouseClicked

  private void FolderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FolderMouseClicked
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    if (evt.getClickCount() > 1) {
      saveFile(true);
    }
  }//GEN-LAST:event_FolderMouseClicked

  private void xslNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xslNameMouseClicked
    labelMouseClick(xslName, evt);
  }//GEN-LAST:event_xslNameMouseClicked

  private void XSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XSLMouseClicked
    if (evt.getClickCount() > 1) {
      XSL.setText("");
    }
  }//GEN-LAST:event_XSLMouseClicked

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    loader();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void XSLPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_XSLPropertyChange
    XSL.setToolTipText(xslName.getText());
  }//GEN-LAST:event_XSLPropertyChange

  private void NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NameMouseClicked
    if (evt.getClickCount() > 1) {
      Name.setText("");
    }
  }//GEN-LAST:event_NameMouseClicked

  private void FolderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FolderMouseReleased
    loader();
  }//GEN-LAST:event_FolderMouseReleased

  private void csvNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csvNameMouseClicked
    labelMouseClick(csvName, evt);
  }//GEN-LAST:event_csvNameMouseClicked

  private void xmlNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xmlNameMouseClicked
    labelMouseClick(xmlName, evt);
  }//GEN-LAST:event_xmlNameMouseClicked

  private void executeJSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_executeJSMouseClicked
    executeJS();
  }//GEN-LAST:event_executeJSMouseClicked

  private void htmlNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_htmlNameMouseClicked
    labelMouseClick(htmlName, evt);
  }//GEN-LAST:event_htmlNameMouseClicked

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    JPanel jp = new Panel4("getNames");
    JTextArea jta = new JTextArea();
    JScrollPane jsp = new JScrollPane(jta);
    jp.add(jsp);
    JFrame jf = new Frame4(jp);
    String start = _JS + FS;
    String[] sa = null;
    for (int j = 0; j < Folder.getModel().getSize(); j++) {
      String folder = Folder.getItemAt(j).toString() + FS;
      File f = new File(start + folder);
      sa = f.list();
      for (int l = 0; l < sa.length; l++) {
        jta.append(f.toString() + FS);
        jta.append(sa[l] + CRLF);
      }
      jta.append("" + CRLF);
    }
  }//GEN-LAST:event_jLabel1MouseClicked

  private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
//    writeTXT();
  }//GEN-LAST:event_jLabel11MouseClicked

  private void array2csvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_array2csvMouseClicked
    array2CSV();
  }//GEN-LAST:event_array2csvMouseClicked

  private void file2csvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_file2csvMouseClicked
    file2CSV();
  }//GEN-LAST:event_file2csvMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public static javax.swing.JTextArea CSV;
  static javax.swing.JComboBox Ext;
  static final javax.swing.JComboBox Folder = new javax.swing.JComboBox();
  static javax.swing.JTextArea HTML;
  static javax.swing.JTextField Name;
  static javax.swing.JTextArea XML;
  static javax.swing.JTextArea XSL;
  private javax.swing.JLabel array2csv;
  public static javax.swing.JLabel csvName;
  private javax.swing.JLabel executeJS;
  private javax.swing.JLabel file2csv;
  private static javax.swing.JLabel htmlName;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  static javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  static javax.swing.JScrollPane jScrollPane1;
  static javax.swing.JScrollPane jScrollPane2;
  static javax.swing.JScrollPane jScrollPane3;
  static javax.swing.JScrollPane jScrollPane4;
  static javax.swing.JTextField path;
  static javax.swing.JLabel xmlName;
  private static javax.swing.JLabel xslName;
  // End of variables declaration//GEN-END:variables

  static void saveTXT() {
    String FTYPE = Folder.getSelectedItem().toString();
    String CTYPE = Panel4T5CounterMaker.Folder.getSelectedItem().toString();
    String folder = _JS + FS + FTYPE;
    String tt1 = Panel4T5CounterMaker.jt4File.getText();
    String T11 = Panel4T5CounterMaker.t11.getText();
    String FNAME = Panel4T5CounterMaker.fname;
    String name;
    name = T11 + "-" + CTYPE;
    if (!"".equals(FNAME)) {
      name = FNAME;
    }
    String ext = "txt";
    String txt = "";
    Panel4T5Scripting.Folder.setSelectedItem("Counters");
    Panel4T5Scripting.Name.setText(name);
    Panel4T5Scripting.Ext.setSelectedItem(".xml");
    String words = "";
    String[] colTitles
      = new String[]{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", ""};
    //<editor-fold defaultstate="collapsed" desc="switch (Panel4T5CounterMaker.jComboBox1.getSelectedItem().toString())">
    switch (Panel4T5CounterMaker.Folder.getSelectedItem().toString()) {
      case "T5C": {
        String[] colTitlesT5C
          = new String[]{"T5C", "", "System", "", "", "", "", "", "", "", "", "",
            "", "", "", "System", "", "", "", "", "", "", "", "", ""};
        colTitles = colTitlesT5C;
        break;
      }
      case "Blank": {
        String[] colTitlesBlank
          = new String[]{"Blank", "", "System", "", "", "", "", "", "", "", "",
            "", "", "", "", "System", "", "", "", "", "", "", "", "", ""};
        colTitles = colTitlesBlank;
        break;
      }
      case "World": {
        String[] colTitlesWorld
          = new String[]{"World", "", "System", "", "", "", "", "", "", "", "",
            "", "", "", "", "System", "UWP", "SDBs", "Rons", "Def CF", "Troops",
            "Population", "Belts", "GGs", "Worlds"};
        colTitles = colTitlesWorld;
        break;
      }
      case "Squadrons": {
        String[] colTitlesSquadrons
          = new String[]{"Squadrons", "", "System", "", "", "", "", "", "", "",
            "", "", "", "", "", "System", "Population", "SDBs", "TL",
            "Squadrons", "", "", "", "", ""};
        colTitles = colTitlesSquadrons;
        break;
      }
      case "Squadron": {
        String[] colTitlesSquadron = new String[]{"Squadron", "", "System", "",
          "", "", "", "", "", "", "", "", "", "", "", "System", "", "Type",
          "Jump", "Refuel", "Defence", "Attack", "Bombard", "Transport", "TL"};
        colTitles = colTitlesSquadron;
        break;
      }
      case "Troops": {
        String[] colTitlesTroops = new String[]{"Troops", "", "System", "", "",
          "", "", "", "", "", "", "", "", "", "", "System", "Population", "TL",
          "CF", "", "", "", "", "", ""};
        colTitles = colTitlesTroops;
        break;
      }
      case "Troop": {
        String[] colTitlesTroop
          = new String[]{"Troop", "", "System", "", "", "", "", "", "", "", "",
            "", "", "", "", "System", "", "Size", "Quality", "Armament",
            "Mobility", "Type", "CF", "TF", "TL"};
        colTitles = colTitlesTroop;
        break;
      }
      case "SDBs": {
        String[] colTitlesSDBs = new String[]{"SDBs", "", "System", "", "", "",
          "", "", "", "", "", "", "", "", "", "System", "Population", "TL",
          "SDBs", "", "", "", "", "", ""};
        colTitles = colTitlesSDBs;
        break;
      }
      case "Fleet": {
        String[] colTitlesFleet
          = new String[]{"Fleet", "", "System", "", "", "", "", "", "", "", "",
            "", "", "", "", "System", "ID", "", "", "", "", "", "", "", ""};
        colTitles = colTitlesFleet;
        break;
      }
      case "Admiral": {
        String[] colTitlesAdmiral
          = new String[]{"Admiral", "", "System", "", "", "", "", "", "", "", "",
            "", "", "", "", "System", "", "Precedence", "Planning", "Tactical",
            "", "", "", "", ""};
        colTitles = colTitlesAdmiral;
        break;
      }
      case "Defences": {
        String[] colTitlesDefences = new String[]{"Defences", "", "System", "",
          "", "", "", "", "", "", "", "", "", "", "", "System", "Population",
          "TL", "CF", "", "", "", "", "", ""};
        colTitles = colTitlesDefences;
        break;
      }
      case "Population": {
        String[] colTitlesPopulation = new String[]{"Population", "", "System",
          "", "", "", "", "", "", "", "", "", "", "", "", "System", "Population",
          "TL", "", "", "", "", "", "", ""};
        colTitles = colTitlesPopulation;
        break;
      }
      case "Belts": {
        String[] colTitlesBelts
          = new String[]{"Belts", "", "System", "", "", "", "", "", "", "", "",
            "", "", "", "", "System", "Population", "TL", "Belts", "", "", "",
            "", "", ""};
        colTitles = colTitlesBelts;
        break;
      }
      case "Gas Giants": {
        String[] colTitlesGasGiants
          = new String[]{"GasGiants", "", "System", "", "", "", "", "", "", "",
            "", "", "", "", "", "System", "Population", "TL", "GGs", "", "", "",
            "", "", ""};
        colTitles = colTitlesGasGiants;
        break;
      }
      case "Worlds": {
        String[] colTitlesWorlds = new String[]{"Worlds", "", "System", "", "",
          "", "", "", "", "", "", "", "", "", "", "System", "Population", "TL",
          "Worlds", "", "", "", "", "", ""};
        colTitles = colTitlesWorlds;
        break;
      }
      case "Vehicle": {
        String[] colTitlesVehicle
          = new String[]{"Vehicle", "", "System", "", "", "", "", "", "", "", "",
            "", "", "", "", "System", "", "", "V", "M", "C", "W", "H", "L", "P"};
        colTitles = colTitlesVehicle;
        break;
      }
      case "Ship": {
        String[] colTitlesShip = new String[]{"Ship", "", "System", "", "", "",
          "", "", "", "", "", "", "", "", "", "System", "", "", "V", "M", "C",
          "TL", "J", "G", ""};
        colTitles = colTitlesShip;
        break;
      }
      case "Equipment": {
        String[] colTitlesEquipment
          = new String[]{"Equipment", "", "System", "", "", "", "", "", "", "",
            "", "", "", "", "", "System", "", "", "", "", "", "", "", "", ""};
        colTitles = colTitlesEquipment;
        break;
      }
      case "Navy": {
        String[] colTitlesNavy = new String[]{"Navy", "", "System", "", "", "",
          "", "", "", "", "", "", "", "", "", "System", "", "", "", "", "", "",
          "", "", ""};
        colTitles = colTitlesNavy;
        break;
      }
      case "Marine": {
        String[] colTitlesMarine = new String[]{"Marine", "", "System", "", "",
          "", "", "", "", "", "", "", "", "", "", "System", "", "", "", "", "",
          "", "", "", ""};
        colTitles = colTitlesMarine;
        break;
      }
      case "Army": {
        String[] colTitlesArmy = new String[]{"Army", "", "System", "", "", "",
          "", "", "", "", "", "", "", "", "", "System", "", "", "", "", "", "",
          "", "", ""};
        colTitles = colTitlesArmy;
        break;
      }
      case "Scout": {
        String[] colTitlesScout
          = new String[]{"Scout", "", "System", "", "", "", "", "", "", "", "",
            "", "", "", "", "System", "", "", "", "", "", "", "", "", ""};
        colTitles = colTitlesScout;
        break;
      }
      case "Other": {
        String[] colTitlesOther
          = new String[]{"Other", "", "System", "", "", "", "", "", "", "", "",
            "", "", "", "", "System", "", "", "", "", "", "", "", "", ""};
        colTitles = colTitlesOther;
        break;
      }
      case "Merchant": {
        String[] colTitlesMerchant = new String[]{"Merchant", "", "System", "",
          "", "", "", "", "", "", "", "", "", "", "", "System", "", "", "", "",
          "", "", "", "", ""};
        colTitles = colTitlesMerchant;
        break;
      }
    };
    //</editor-fold>
    Panel4T5CounterMaker.jtfs = new JTextField[]{Panel4T5CounterMaker.t1,
      Panel4T5CounterMaker.t2, Panel4T5CounterMaker.t3, Panel4T5CounterMaker.t4,
      Panel4T5CounterMaker.t5, Panel4T5CounterMaker.t6, Panel4T5CounterMaker.t7,
      Panel4T5CounterMaker.t8, Panel4T5CounterMaker.t9, Panel4T5CounterMaker.t10,
      Panel4T5CounterMaker.t11, Panel4T5CounterMaker.t12,
      Panel4T5CounterMaker.t13, Panel4T5CounterMaker.t14,
      Panel4T5CounterMaker.t15, Panel4T5CounterMaker.t16,
      Panel4T5CounterMaker.t17, Panel4T5CounterMaker.t18,
      Panel4T5CounterMaker.t19, Panel4T5CounterMaker.t20};
//    FNAME = ""; //------------------------------------------------------------------------------------------------------COMMENT OUT
    //<editor-fold defaultstate="collapsed" desc="write txt">
    for (int j = 0; j < colTitles.length; j++) {
      words = colTitles[j].toUpperCase();
      txt += "\"";
      txt += words;
      txt += "\"";
      if (j < colTitles.length - 1) {
        txt += ",";
      }
    }
    txt += CRLF;
    for (int j = 0; j < colTitles.length; j++) {
      if (j < 5) {
        switch (j) {
          case 0: {
            txt += "\"" + CTYPE + "\"";
            break;
          }
          case 1: {
            txt += "\"\"";
            break;
          }
          case 2: {
            txt += "\"" + T11 + "\"";
            break;
          }
          case 3: {
            txt += "\"" + FNAME + "\"";
            break;
          }
          case 4: {
            txt += "\"\"";
            break;
          }
        }
      } else {
        txt += "\"" + Panel4T5CounterMaker.jtfs[j - 5].getText() + "\"";
      }
      if (j < colTitles.length - 1) {
        txt += ",";
      }
    }
    txt += CRLF;
    txt = txt.replace("<", "&lt;");
    txt = txt.replace(">", "&gt;");
    //</editor-fold>
    GlobalMethods.saveTextFile(folder, name, ext, txt);
    JOptionPane.showMessageDialog(jf, "1986\n" + s);
    saveXML(FTYPE, false);
    showFullNames();
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      String s = method + CRLF;
      String string = "";
      s += "FTYPE" + " = " + FTYPE + CRLF;
      s += "CTYPE" + " = " + CTYPE + CRLF;
      s += "folder" + " = " + folder + CRLF;
      s += "tt1" + " = " + tt1 + CRLF;
      s += "T11" + " = " + T11 + CRLF;
      s += "name" + " = " + name + CRLF;
      s += "ext" + " = " + ext + CRLF;
      s += "txt" + " = " + txt + CRLF;
      s += "Panel4T5Scripting.Folder.getSelectedItem().toString()" + " = "
        + Panel4T5Scripting.Folder.getSelectedItem().toString() + CRLF;
      s += "Panel4T5Scripting.Name.getText()" + " = "
        + Panel4T5Scripting.Name.getText() + CRLF;
      s += "Panel4T5Scripting.Ext.getSelectedItem().toString()" + " = "
        + Panel4T5Scripting.Ext.getSelectedItem().toString() + CRLF;
      s += "words" + " = " + words + CRLF;
      s += "" + " = " + string + CRLF;
      s += "" + " = " + string + CRLF;
      System.out.print("s" + " = " + s + CRLF);
//      JOptionPane.showMessageDialog(jf, "" + s);
    }
    //</editor-fold>
  }

  /**

   @param folder
   @param newway
   */
  public static void saveXML(String folder, boolean newway) {
    if (newway) {
      {
        Boolean ok = true;//false//
        if (ok) {
          txt = folder;
          JTextArea jta = new JTextArea(20, 20);
          jta.setText(txt);
          JScrollPane jsp = new JScrollPane(jta);
          System.out.println("txt" + " = " + txt);
//          JOptionPane.showMessageDialog(null, jsp);
        }
      }
    } else {
      //<editor-fold defaultstate="collapsed" desc="oldway">
      //<editor-fold defaultstate="collapsed" desc="For ALL">
      l = 0;
      setExt(".xml");
      XML.setText("");
      if (folder.equals("Sectors") | folder.equals("SubSectors") | folder
        .equals(
          "Systems") | folder.equals("Routes")) {
        lineinfo = Panel4T5Locator.getSpaceInfo(
          Panel4T5Locator.lines[Panel4T5Locator.world1 - 1]);
      } else {
        lineinfo = getLongestParts();//??????????????????????????????????????????
      }
      lens = new int[lineinfo.split(" ").length];
      parts = lineinfo.split(" ");
      for (int j = 0; j < lens.length; j++) {
        lens[j] = parts[j].length();
        l = (l + lens[j] + 1);
      }
      stylesheet = folder + ".xsl";
      if ("Sectors".equals(folder) | "SubSectors".equals(folder) | "Systems"
        .equals(folder) | "Routes".equals(folder)) {
        folder = "Systems";
        stylesheet = "Systems.xsl";
      }
      if (folder.equals("Catalogs")) {
        stylesheet = Name.getText() + ".xsl";
      }
      s = start;
      s = s.replace("Systems.xsl", stylesheet);
      s = s.replace("Systems", folder);
      //    s = s.replace("System", folder);
      s = s.replace("This is a comment", "Use " + folder + ".xsl");
      systemend = "</" + folder + ">";
      s += lineinfo + CRLF;
      int count = 0;
      min = Panel4T5Locator.world1;
      max = min + Panel4T5Locator.worlds;
      shipname = Name.getText();
      named = "";
      sel = Folder.getSelectedItem().toString();
      //</editor-fold>
      ////////////////////////////////////////////////////////////////////////////////
      //<editor-fold defaultstate="collapsed" desc="sec">
      if ("Sectors".equals(Folder.getSelectedItem().toString())) {
        named = Panel4T5Locator.jcb4Sec.getSelectedItem().toString().trim();
        Name.setText(named);
        jfc.setSelectedFile(new File(_JS + FS + named));
        for (int j = min; j < max; j++) {
          String txt = Panel4T5Locator.lines[j];
          s += "" + txt + CRLF;
          updateWorld(txt);
          s += "" + SystemsData + CRLF;
        }
        s += systemend;
        XML.setText(s);
        XML.setToolTipText(named);
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="sub">
      if ("SubSectors".equals(Folder.getSelectedItem().toString())) {
        named = Panel4T5Locator.jcb4Sub.getSelectedItem().toString().trim()
          + ".xml";
        Name.setText(named.substring(0, named.length() - 4));
        for (int j = min; j < max; j++) {
          if (Panel4T5Locator.lines[j].contains(Panel4T5Locator.jcb4Sys
            .getItemAt(
              count).substring(0, 4))) {
            for (int k = count; k < Panel4T5Locator.jcb4Sys.getItemCount(); k++) {
              String txt = Panel4T5Locator.lines[j + k];
              s += "" + txt + CRLF;
              updateWorld(txt);
              s += "" + SystemsData + CRLF;
            }
            break;
          }
        }
        s += systemend;
        XML.setText(s);
        XML.setToolTipText(named);
        jfc.setSelectedFile(new File(named));
        //      return;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="sys">
      if ("Systems".equals(Folder.getSelectedItem().toString())) {
        named = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim()
          + ".xml";
        Name.setText(named.substring(0, named.length() - 4));
        for (int j = min; j < max; j++) {
          if (Panel4T5Locator.lines[j].contains(Panel4T5Locator.jcb4Sys
            .getSelectedItem().toString().substring(0, 4))) {
            s += (j - Panel4T5Locator.world1) + CRLF;
            String txt = Panel4T5Locator.lines[j];
            s += "" + txt + CRLF;
            updateWorld(txt);
            s += "" + SystemsData + CRLF;
          }
        }
        s += systemend;
        XML.setText(s);
        XML.setToolTipText(named);
        jfc.setSelectedFile(new File(named));
      }    //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="route">
      if ("Routes".equals(Folder.getSelectedItem().toString())) {
        //      named = _JS + FS + Folder.getSelectedItem().toString() + FS + shipname + ".xml";
        named = _JS + FS + Folder.getSelectedItem().toString() + FS + shipname
          + ".xml";
        Name.setText(named
          .substring(named.lastIndexOf(FS) + 1, named.length() - 4));
        jfc.setSelectedFile(new File(named));
        switch (Folder.getSelectedItem().toString()) {
          case "Sectors": {
            named = Panel4T5Locator.jcb4Sec.getSelectedItem().toString();
            break;
          }
          case "SubSectors": {
            named = Panel4T5Locator.jcb4Sub.getSelectedItem().toString();
            break;
          }
          case "Systems": {
            named = Panel4T5Locator.jcb4Sys.getSelectedItem().toString();
            break;
          }
        }
        XML.setText("");
        XML.setToolTipText(named);
        String[] data = GlobalMethods.getLinesFromFile(new File(named.replace(
          "xml", "txt")));
        for (int j = 0; j < data.length; j++) {
          CSV.append("" + data[j] + CRLF);
          s += "World " + (j + 1) + CRLF;
          String txt = data[j];
          s += "" + txt + CRLF;
          updateWorld(findHex(txt));
          s += "" + SystemsData + CRLF;
        }
        s += systemend;
        XML.setText(s);
      }
      //</editor-fold>
      try {
        if (Folder.getSelectedIndex() > 3) {
          csv2WebTable(Folder.getSelectedItem().toString());
        }
      } catch (Exception e) {
        System.out.println("2037" + " = " + e.toString());
      } finally {
        String htmlname = "savename";
        String dtdname = "Systems";
        switch (Folder.getSelectedItem().toString()) {
          //<editor-fold defaultstate="collapsed" desc="case "Sectors"">
          case "Sectors": {
            htmlname = Panel4T5Locator.jcb4Sec.getSelectedItem().toString()
              .trim();
            break;
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="case "SubSectors"">
          case "SubSectors": {
            htmlname = Panel4T5Locator.jcb4Sub.getSelectedItem().toString()
              .trim();
            break;
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="case "Systems">
          case "Systems": {
            htmlname = Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
              .trim();
            break;
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="case "Routes"">
          case "Routes": {
            htmlname = Name.getText();
            break;
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="case "Catalogs"">
          case "Catalogs": {
            dtdname = "Catalogs-" + Name.getText();
            htmlname = dtdname.substring(9);
            System.out.println("savename" + " = " + htmlname);
            int cols = 0;
            String fname = _JS + FS + dtdname + ".dtd";
            System.out.println(fname);
            String[] l = GlobalMethods.getLinesFromFile(new File(fname));
            for (int j = 0; j < l.length; j++) {
              System.out.println(l[j]);
            }
            break;
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="case "Counters"">
          case "Counters": {
            dtdname = "Counters";
            htmlname = Panel4T5CounterMaker.jt4File.getText() + "-"
              + Panel4T5CounterMaker.Folder.getSelectedItem().toString();
            String t12 = Panel4T5CounterMaker.t12.getText().trim();
            String t13 = Panel4T5CounterMaker.t13.getText().trim();
            String t15 = Panel4T5CounterMaker.t15.getText().trim();
            String CTYPE = Panel4T5CounterMaker.Folder.getSelectedItem()
              .toString();
            if ((!"".equals(t12)) && ("Squadron".equals(CTYPE)) /*
               | ("Troop".equals(CTYPE))
               */) {
              htmlname += "-" + t12;
            }
            if ((!"".equals(t12)) && ("Squadrons".equals(CTYPE)) | ("Troops"
              .equals(CTYPE))) {
              //            savename += "-" + t12;
              htmlname = Panel4T5CounterMaker.jt4File.getText() + "-"
                + Panel4T5CounterMaker.Folder.getSelectedItem().toString();
            }
            if ("Navy".equals(CTYPE) | "Marine".equals(CTYPE)
              | "Army".equals(CTYPE) | "Scout".equals(CTYPE)
              | "Other".equals(CTYPE) | "Merchant".equals(CTYPE)) {
              htmlname += "-" + t13;
            }
            //          JOptionPane.showMessageDialog(jf, "savename" + " = " + htmlname);
            int cols = 25;
            String fname = _JS + FS + dtdname + ".dtd";
            System.out.println("dtd = " + fname);
            System.out.println("htmlname" + " = " + htmlname);
            //        String[] l = GlobalMethods.getLinesFromFile(new File(fname));
            //        for (int j = 0; j < l.length; j++) {
            //          System.out.println(l[j]);
            //        }
            break;
          }
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="default">
          default: {
            htmlname = Name.getText();
            dtdname = Folder.getSelectedItem().toString();
            break;
          }
          //</editor-fold>
        }
        GlobalMethods.saveTextFile(_JS + FS + Folder.getSelectedItem()
          .toString(),
          htmlname, ".xml", XML.getText());
        showStyleSheet(Folder.getSelectedItem().toString());
        showFullNames();
        String xmlname = htmlname + ".xml";
        String xslname = stylesheet;
        saveHTML(htmlname, xmlname, xslname);
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          String method = Thread.currentThread().getStackTrace()[1]
            .getMethodName();
          System.out.println("\t" + method);
          //JOptionPane.showMessageDialog(null, method);
          String s = method + CRLF;
          String string = "";
          s += "folder" + " = " + folder + CRLF;
          s += "ext" + " = " + ext + CRLF;
          s += "txt" + " = " + txt + CRLF;
          s += "Panel4T5Scripting.Folder.getSelectedItem().toString()" + " = "
            + Panel4T5Scripting.Folder.getSelectedItem().toString() + CRLF;
          s += "Panel4T5Scripting.Name.getText()" + " = "
            + Panel4T5Scripting.Name.getText() + CRLF;
          s += "Panel4T5Scripting.Ext.getSelectedItem().toString()" + " = "
            + Panel4T5Scripting.Ext.getSelectedItem().toString() + CRLF;
          s += "" + " = " + string + CRLF;
          s += "" + " = " + string + CRLF;
          System.out.print("s" + " = " + s + CRLF);
          //        JOptionPane.showMessageDialog(jf, "" + s);
        }
        //</editor-fold>
      }
      //</editor-fold>
    }
  }

  private static void saveXSL(String sel) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      System.out.println("XSLstylesheet" + " = " + stylesheet);
      System.out.println("sel" + " = " + sel);
      //JOptionPane.showMessageDialog(null, method);
    }
    //</editor-fold>
    if (parts != null) {
      try {
        File f = new File(sel);
        System.out.println("f.exists()" + " = " + f.exists());
      } catch (Exception e) {
        //JOptionPane.showMessageDialog(jp,e.toString());
        System.out.println("" + " = " + e.toString());
      } finally {
        String s = ""
          + "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
          + "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n"
          + "<xsl:output method=\"html\"/>\n"
          + "  <xsl:template match=\"/\">\n"
          + "    <html>\n"
          + "      <body>\n"
          + "        <h3>COLTITLE</h3>\n"
          + "        <table border=\"0\">\n"
          + "          <tr bgcolor=\"#c0dcc0\">\n";
        for (int j = 0; j < parts.length; j++) {
          s += "            <th style=\"text-align:left\">TXT</th>\n".replace(
            "TXT", titles[j].toUpperCase());
        }
        s += "          </tr>\n"
          + "          <xsl:for-each select=\"Ships/Ship\">\n"
          + "            <tr>\n";
        for (int j = 0; j < parts.length; j++) {
          s += ""
            + "              <td>\n";
          s += "                <xsl:value-of select=\"" + ("col" + j)
            + "\"/>\n";
          s += "              </td>\n";
        }
        s += "            </tr>\n"
          + "          </xsl:for-each>\n"
          + "        </table>\n"
          + "      </body>\n"
          + "    </html>\n"
          + "  </xsl:template>\n"
          + "</xsl:stylesheet>\n";
        s = s.replace("Ships", sel);
        s = s.replace("Ship", sel.substring(0, sel.length() - 1));
        title = sel + "-" + Name.getText();
        switch (sel) {
          case "Sectors":
          case "SubSectors":
          case "Systems":
          case "Routes": {
            title = "Systems";
            break;
          }
          case "Crews":
          case "Ships":
          case "Rons":
          case "Fleets":
          case "Counters":
          default: {
            title = sel;
            break;
          }
          case "Catalogs": {
            title = Name.getText();
          }
        }
        s = s.replace("This is a comment", "COMMENT");
        String end = "";
        switch (title) {
          case "Crews": {
            end = "Ship";
            break;
          }
          case "Fleets": {
            end = "Empire";
            break;
          }
          case "Rons": {
            end = "Fleet";
            break;
          }
          case "Ships": {
            end = "Squadron";
            break;
          }
        }
        if (!"".equals(end)) {
          s = s.replace("COLTITLE", title + "-" + Name.getText() + "-" + end);
        } else {
          s = s.replace("COLTITLE", title);
        }
        GlobalMethods.saveTextFile(_JS + FS + sel, title, ".xsl", s);
        GlobalMethods.saveTextFile(_JS + FS + sel, title + "T", ".xsl", s
          .replace(
            "method=\"html\"", "method=\"text\""));
        XSL.setText(s);
        stylesheet = title;
        XSL.setToolTipText(title);
      }
    } else {
//      JOptionPane.showMessageDialog(jp, "2320");
    }
  }

  private static void saveHTML(String filename, String xmlname, String xslname) {
    //<editor-fold defaultstate="collapsed" desc="String xslts">
    String xslts = "<!DOCTYPE html>\n"
      + "<html>\n"
      + "  <head>\n"
      + "    <script>\n"
      + "      function loadXMLDoc(filename)\n"
      + "      {\n"
      + "        if (window.ActiveXObject)\n"
      + "        {\n"
      + "          xhttp = new ActiveXObject(\"Msxml2.XMLHTTP\");\n"
      + "        }\n"
      + "        else\n"
      + "        {\n"
      + "          xhttp = new XMLHttpRequest();\n"
      + "        }\n"
      + "        xhttp.open(\"GET\", filename, false);\n"
      + "        try {\n"
      + "          xhttp.responseType = \"msxml-document\"\n"
      + "        } catch (err) {\n"
      + "        } // Helping IE11\n"
      + "        xhttp.send(\"\");\n"
      + "        return xhttp.responseXML;\n"
      + "      }\n"
      + "\n"
      + "      function displayResult()\n"
      + "      {\n"
      + "        xml = loadXMLDoc(\"" + xmlname + "\");\n"
      + "        xsl = loadXMLDoc(\"" + xslname + "\");\n"
      + "        // code for IE\n"
      + "        if (window.ActiveXObject || xhttp.responseType == \"msxml-document\")\n"
      + "        {\n"
      + "          ex = xml.transformNode(xsl);\n"
      + "          document.getElementById(\"example\").innerHTML = ex;\n"
      + "        }\n"
      + "        // code for Chrome, Firefox, Opera, etc.\n"
      + "        else if (document.implementation && document.implementation.createDocument)\n"
      + "        {\n"
      + "          xsltProcessor = new XSLTProcessor();\n"
      + "          xsltProcessor.importStylesheet(xsl);\n"
      + "          resultDocument = xsltProcessor.transformToFragment(xml, document);\n"
      + "          document.getElementById(\"example\").appendChild(resultDocument);\n"
      + "        }\n"
      + "      }\n"
      + "    </script>\n"
      + "  </head>\n"
      + "  <body onload=\"displayResult()\">\n"
      + "    <div id=\"example\">\n"
      + "    </div>\n"
      + "  </body>\n"
      + "</html>";
    //</editor-fold>
    Name.setText(filename);
    String old = filename;
    String folder = _JS + FS + Folder.getSelectedItem().toString().trim();
    if (folder.endsWith("Counters")) {
      String CTYPE = Panel4T5CounterMaker.Folder.getSelectedItem()
        .toString().trim();
      String t12 = Panel4T5CounterMaker.t12.getText();
      String t13 = Panel4T5CounterMaker.t13.getText();
      if (("Squadrons".equals(CTYPE)) | ("Troops".equals(CTYPE))) {
        /*
         | ("Troop".equals(CTYPE))
         */

        if (!"".equals(t12)) {
          filename = old;
        }
      }
//      if ("Troop".equals(CTYPE)) {
//        JOptionPane.showMessageDialog(jf, "Troop");
//      }
      if (("Navy".equals(CTYPE)) | ("Marine".equals(CTYPE))
        | ("Army".equals(CTYPE)) | ("Scout".equals(CTYPE))
        | ("Other".equals(CTYPE)) | ("Merchant".equals(CTYPE))) {
        if (!"".equals(t13)) {
          filename += "-" + t13;
        }
      }
    }
    GlobalMethods.saveTextFile(folder, filename, ".html", xslts);
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      System.out.println("\t" + method);
      String s = "";
      s += method + CRLF;
      String string = "";
//        s += "FTYPE" + " = " + FTYPE + CRLF;
//        s += "CTYPE" + " = " + CTYPE + CRLF;
      s += "folder" + " = " + folder + CRLF;
//        s += "tt1" + " = " + tt1 + CRLF;
//        s += "T11" + " = " + T11 + CRLF;
//        s += "name" + " = " + name + CRLF;
      s += "ext" + " = " + ext + CRLF;
      s += "txt" + " = " + txt + CRLF;
      s += "Panel4T5Scripting.Folder.getSelectedItem().toString()" + " = "
        + Panel4T5Scripting.Folder.getSelectedItem().toString() + CRLF;
      s += "Panel4T5Scripting.Name.getText()" + " = "
        + Panel4T5Scripting.Name.getText() + CRLF;
      s += "Panel4T5Scripting.Ext.getSelectedItem().toString()" + " = "
        + Panel4T5Scripting.Ext.getSelectedItem().toString() + CRLF;
//        s += "words" + " = " + words + CRLF;
      s += "" + " = " + string + CRLF;
      s += "" + " = " + string + CRLF;
      System.out.print("s" + " = " + s + CRLF);
//      JOptionPane.showMessageDialog(jf, "" + s);
    }
    //</editor-fold>
  }

  static void saveTXT(String savename) {
    saveTXT();
  }

  private void file2CSV() {
    // file to csv ??????????????????????
    System.out.println("file2CSV");
    openFile();

  }

  static void array2CSV() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("DEBUG" + " = " + DEBUG);
    }
    //</editor-fold>
    // String array to csv by adding quotes and commas
    System.out.println("array2CSV");
//    Panel4T5TableView p4tv = new Panel4T5TableView();
//    p4tv.main(new String[]{""});
    String[] txt = jta.getText().split(CRLF);
    String lines = "";
    String row;
    for (int y = 2; y < txt.length; y++) {
      row = "";
      String[] col = txt[y].split(TAB);
      for (int x = 0; x < col.length; x++) {
        row += "\"" + col[x] + "\"";
        if (x < (col.length - 1)) {
          row += ",";
        } else {
          row += CRLF;
        }
      }
      lines += row;
    }
    System.out.println(lines);
    CSV.setText(lines);

  }

  static void txt2CSV() {
    // Tab separated text, tabs replaced with quotes and commas
    System.out.println("txt2CSV");
    Panel4T5TableView.main(parts);
    Panel4T5TableView.jta.setText("Panel4T5Scripting");
  }

  static void csv2XML() {
    //converted files to XML
    System.out.println("csv2XML");
  }

  static void xml2XSL() {
    //write XSL file from xml data file
    System.out.println("xml2XSL");
  }

  static void xsl2HTML() {
    //write HTML page with xml data formatted by xsl
    System.out.println("xsl2HTML");
  }

  /*
   */
}
