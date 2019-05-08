/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package linkpictext;

import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalVariables.CRLF;
import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables.T5;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import static linkpictext.Panel4Add.saveTextFile;
import panels.Frame4;
import panels.Panel4;
import panels.Panel4T5Locator;
import static panels.Panel4T5Locator.jta4Bases;
import static panels.Panel4T5Locator.jta4Near;
import static panels.Panel4T5Locator.jta4Sub;
import static panels.Panel4T5Locator.jta4UWP;

/**
 @author Mark Ferguson
 */
public class Panel4LPT extends Panel4 {

  //<editor-fold defaultstate="collapsed" desc="Variables">
  private static JPanel jp;

  /**

   */
  public static JFrame jf;
  private static boolean running;
//  static String CRLF = System.lineSeparator();
//  static String FS = File.separator;
  static final String links = "C:" + FS + FS + "T5" + FS + "_Links" + FS;
  private String cat = "";
  private String itm = "";
  static String sec = "Spinward Marches";
  static String sub = "C Regina";
  static String sys = "1705 Efate";
  static String path = "C:" + FS + FS + "T5" + FS + sec + FS + sub + FS + sys
    + FS + sys;
  private String nam = "";
  private String pix = "";
  private String txt = "";
  private String not = "";
  static JFileChooser jfc = new JFileChooser();
  private static MouseEvent me;
  private static ActionEvent ae;
  //</editor-fold>

  /**

   @param args
   */
  public static void main(String[] args) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
    jp = new Panel4LPT();
    jf = new Frame4();
    jf.add(jp);
    jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    jf.setSize(600, 600);
    jf.setTitle(links);
//    jf.setVisible(true);
    running = true;
    catCheck();
    Panel4Add.main(args);
  }

  /**
   Creates new form Panel4LPT
   */
  public Panel4LPT() {
    initComponents();
    auto.setVisible(false);
//    saveTexts();
  }

  private static void autoClick(MouseEvent evt) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = true;
      //DEBUG = false;
      if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
    sec = Panel4T5Locator.jcb4Sec.getSelectedItem().toString().trim();
    sub = Panel4T5Locator.jcb4Sub.getSelectedItem().toString().trim();
    sys = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
    String cat = category.getSelectedItem().toString();
    Panel4Add.xmldoc.setText(cat + ".xml");
    Panel4Add.xsldoc.setText(
      "../Style" + xsl.getSelectedItem().toString() + ".xsl");
    Panel4Add.comment.setText("comment");
    if (!"".equals(Panel4Add.title.getText())) {
      Panel4Add.title.setText(item.getSelectedItem().toString());
    } else {
      Panel4Add.title.setText("Untitled");
    }
    Panel4Add.script.setText("script");
    Panel4Add.header.setText("");
    Panel4Add.heading.setText(item.getSelectedItem().toString());
    Panel4Add.pics.setText(pic.getToolTipText());
    Panel4Add.picture.setText("file:///" + pic.getToolTipText());
    Panel4Add.intro.setText("");
    Panel4Add.text.setText(text.getText());
    String[] lines = getLinesFromFile(new File(text.getToolTipText()));
    String all = "";
    for (int i = 0; i < lines.length; i++) {
      all += lines[i] + "<br/>";
    }
    csv.setText(all);
    Panel4Add.footnote.setText("");
    Panel4Add.footer.setText("");

    Panel4Add.sec.setText(sec);
    Panel4Add.sub.setText(sub);
    Panel4Add.sys.setText(sys);

    Panel4Add.name.setText(item.getSelectedItem().toString());
    Panel4Add.Save.doClick();
  }

  private void catAction(ActionEvent evt) {
    if (running) {
      itemCheck();
    }
  }

  private static void catCheck() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
    if (running) {
      category.removeAllItems();
      File f = new File(links);
      String[] files = f.list();
      File file;
      for (int i = 0; i < files.length; i++) {
        file = new File(files[i]);
        if (!file.toString().contains(".")) {
          category.addItem(files[i]);
        }
      }
    }
    folderChange();
  }

  private void catClick(MouseEvent evt) {
    if (running) {
      if (evt.getClickCount() > 1) {
        catCheck();
      }
    }
  }

  /**
   <p>
   @param file to search
   @return number of lines in file
   */
  public static int countLines(File file) {
    int lines = 0;
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line;
      while ((line = reader.readLine()) != null) {
        lines++; // increment line count
      }
      reader.close();
    } catch (IOException exception) {
    } finally {
      return lines;
    }
  }

  private static void createIndex() {
    sec = Panel4T5Locator.jcb4Sec.getSelectedItem().toString().trim();
    sub = Panel4T5Locator.jcb4Sub.getSelectedItem().toString().trim();
    sys = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
    String index = "";
    String cat = category.getSelectedItem().toString().trim();
    String string = "";
    String[] links;
    int cnt = 0;
    File folder = new File("C://T5/" + sec + FS + sub + FS + sys + FS + sys);
    System.out.println("folder" + " = " + folder.toString());
    String[] files = folder.list();
    String s = "";
    int[] ra = new int[files.length];
    String[] bits = null;
    for (int i = 0; i < files.length; i++) {
      File f = new File(files[i]);
      if (f.toString().endsWith(".gif")) {
        string = f.toString().substring(0, f.toString().length() - 4);
        index += "\"" + string + "\"," + "\"" + string + ".gif\"," + "\""
          + string + ".txt\"," + "\"" + note
            .getText() + "\"" + "<br></br>" + CRLF;
        bits = string.split(",");
        try {
          lpt.setText("\"" + item.getSelectedItem().toString() + "\",\"" + pic
            .getToolTipText() + "\",\"" + text.getToolTipText() + "\",\"" + note
            .getText() + "\"");
          cnt += 1;
          ra[i] = i;
          if (ra[i] != 0) {
            System.out.println("ra[" + i + "]" + " = " + files[i]);
          }
          createLPT(string);
        } catch (Exception e) {
          System.out.println("268 = " + e);
        }
      }
    }
    s += index;
    String path = T5 + FS + sec + FS + sub + FS + sys + FS + sys + FS;
    saveTextFile(path, "Index", ".csv", s);
    System.out.print(s);
    System.out.println("CSV saved as " + path + "Index.csv");
    System.out.println("cnt" + " = " + cnt);
    links = new String[files.length];
    JTextArea jta = new JTextArea();
    for (int i = 0; i < files.length; i++) {
      string = files[i];
      bits = string.split(",");
      System.out.println("" + " = " + bits[0]);
      if (ra[i] != 0) {
        links[i] = "<a href=" + bits[0].substring(0, bits[0].length() - 4)
          .replace(" ", "%20") + ".html>" + bits[0].substring(0, bits[0]
          .length() - 4) + "</a><br/>" + CRLF;
        links[i] = links[i];
        jta.append(links[i]);
      }
    }
    saveTextFile(path, "Index", ".html", jta.getText());
    System.out.println("HTML saved as " + path + "Index.html");
    string = GlobalMethods.loadTextFile(path, "Index", ".html").replace(
      "href=", "href=\"file:///" + path + FS).replace("\\", "/").replace("html",
      "html\"");
    saveTextFile(path, "Index", ".html", jta.getText());

  }

  private static void createLPT(String string) {
    System.out.println("createLPT(" + string + ")");
    JTextArea jta = new JTextArea();
    jta.setText(
      "\"" + string + "\",\"" + T5 + FS + sec + FS + sub + FS + sys + FS + sys
      + FS + string + ".gif\",\"" + T5 + FS + sec + FS + sub + FS + sys + FS
      + sys + FS + string + ".txt\",\"" + note
        .getText() + "\"");
    String path = links + category.getSelectedItem().toString();
    saveTextFile(path, string, ".lpt", jta.getText());
  }

  /**
   folderChange
   */
  public static void folderChange() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
    try {
      String loc = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
      System.out.println("loc" + " = " + loc);
      String cat = "";
      for (int i = 0; i < category.getItemCount(); i++) {
        cat = category.getItemAt(i).trim();
        System.out.println("cat" + " = " + cat);
        if (cat.equals(loc)) {
          category.setSelectedIndex(i);
          itemCheck();
        }
      }
    } catch (Exception ex) {
      System.out.println("ex" + " = " + ex);
    } finally {
    }
  }

  /**

   @param f file to search
   @return lines within file
   */
  public static String[] getLinesFromFile(File f) {
    String line;
    String[] lines = new String[countLines(f)];
    int max = 0;
    int i = 0;
    try {
      BufferedReader in = new BufferedReader(new FileReader(f));
      try {
        while ((line = in.readLine()) != null) {
          //line = line.trim();
          lines[i] = line;
          i += 1;
        }
        in.close();

      } catch (IOException ex) {
        //Logger.getLogger(GlobalMethods.class.getName()).log(Level.SEVERE, null, ex);
      }
    } catch (FileNotFoundException ex) {
      //Logger.getLogger(GlobalMethods.class.getName()).log(Level.SEVERE, null, ex);
    }
    return lines;
  }

  private void itemAction(ActionEvent evt) {
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
    String s = "";
    s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
    if (running & item.getSelectedItem() != null & category.getSelectedItem()
      != null) {
      cat = category.getSelectedItem().toString();
      jfc.setCurrentDirectory(new File(links + cat));
      s += "jfc.getCurrentDirectory().toString() = " + jfc.getCurrentDirectory()
        .toString() + CRLF;
    }
    if (cat != null & item.getSelectedItem() != null & running) {
      String path = links + cat + FS + item.getSelectedItem().toString()
        + ".lpt";
      File file = new File(path);
      String[] lines = getLinesFromFile(file);
      lpt.setToolTipText(path);
      lpt.setText("");
      for (int i = 0; i < lines.length; i++) {
//        if (!lines[i].startsWith("null")) {
        lpt.append(lines[i] + CRLF);
//        }
        String[] parts = lines[i].split("\",\"");
        for (int j = 0; j < parts.length; j++) {
          parts[j] = parts[j].replace("\"", "");
        }
        if (parts.length > 1) {
          ////////////////////////////////////////////////////////////////////////
          nam = parts[0];
          s += "nam" + " = " + nam + CRLF;
          ////////////////////////////////////////////////////////////////////////
          pix = parts[1];
          s += "pix" + " = " + pix + CRLF;
          pic.setToolTipText(pix);
          try {
            pic.setIcon(new ImageIcon(ImageIO.read(
              new File(pic.getToolTipText()))));
          } catch (IOException ex) {
            try {
              pic.setIcon(new ImageIcon(ImageIO.read(
                new File("C://T5/_T5 Image Library/icon.png"))));
            } catch (IOException ex1) {
              Logger.getLogger(Panel4LPT.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(Panel4LPT.class.getName()).log(Level.SEVERE,
              null,
              ex);
//            {
//              JTextArea jta = new JTextArea(20, 20);
//              jta.setText(s);
//              JScrollPane jsp = new JScrollPane(jta);
//              System.out.println("s" + " = " + s);
//              JOptionPane.showMessageDialog(null, jsp);
//            }
          }
        }
        ////////////////////////////////////////////////////////////////////////
        if (parts.length > 2) {
          s += "txt" + " = " + parts[2] + CRLF;
          txt = parts[2];
          text.setToolTipText(parts[2]);
          File f = new File(txt);
          lines = getLinesFromFile(f);
          text.setText("");
          for (int j = 0; j < lines.length; j++) {
            text.append(lines[j] + "<br/>" + CRLF);
//            text.append(lines[j] + CRLF);
          }
        }
        ////////////////////////////////////////////////////////////////////////
        if (parts.length > 2) {
          not = parts[3];
          note.setText(not);
          note.setToolTipText("NOTE");
          s += "note" + " = " + parts[3] + CRLF;
        }
      }
      System.out.println("" + " = ");
      System.out.println("running" + " = " + running);
      System.out.println("cat" + " = " + cat);
      System.out.println("item" + " = " + item);
    } else {
      System.out.println("" + " = ");
      System.out.println("running" + " = " + running);
      System.out.println("cat" + " = " + cat);
      System.out.println("item" + " = " + item);
    }
    System.out.println(s);
//    autoClick(me);
  }

  private static void itemCheck() {
    if (category.getSelectedIndex() > -1) {
      String s = "";
      s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
        + CRLF;
      item.removeAllItems();
      File f = new File(links + category.getSelectedItem().toString());
      String[] files = f.list();
      if (files != null) {
        for (int i = 0; i < files.length; i++) {
          //File file = new File(files[i]);
          if (files[i].endsWith(".lpt")) {
            item.addItem(files[i].substring(0, files[i].length() - 4));
            System.out.println("files[" + i + "]" + " = " + files[i]);
          }
        }
      }
    }
  }

  private void itemClick(MouseEvent evt) {
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
    if (item.getSelectedIndex() > -1) {
      if (evt.getClickCount() > 1) {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        String s = "";
        {
//          boolean DEBUG = false;
          //DEBUG = false;
          if (DEBUG) { // true or false
//          s += GlobalMethods.comment("=", 80) + CRLF;
            s += "\t" + Thread.currentThread().getStackTrace()[1]
              .getMethodName() + CRLF;
            JTextArea jta = new JTextArea(s, 20, 20);
            JScrollPane jsp = new JScrollPane(jta);
            System.out.println(s);
            //JOptionPane.showMessageDialog(jf, jsp);
          }
        }
        //</editor-fold>
        cat = category.getSelectedItem().toString();
        itm = item.getSelectedItem().toString().substring(0, 4);
        File file = new File(links + cat + FS + itm + ".html");
        file = new File(
          T5 + FS + sec + FS + sub + FS + sys + FS + sys + FS + itm + ".html");
        System.out.println("file" + " = " + file);
        try {
          String a = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
          String b = file.toString();
          ProcessBuilder pb = new ProcessBuilder(a, b);
          pb.start();
        } catch (IOException ex) {
          Logger.getLogger(Panel4LPT.class.getName())
            .log(Level.SEVERE, null, ex);
        }
      }
    }
  }

  private void loadLPT() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
    jfc.resetChoosableFileFilters();
    jfc.setAcceptAllFileFilterUsed(false);
    FileFilter lptFilter = new FileFilter() {

      @Override
      public boolean accept(File file) {
        if (file.isDirectory() | file.toString().endsWith(".lpt")) {
          return true;
        }
        return false;
      }

      @Override
      public String getDescription() {
        return "LinkPicText Files";
      }
    };
    jfc.addChoosableFileFilter(lptFilter);
    jfc.setCurrentDirectory(new File(
      "C:" + FS + "T5" + FS + sec + FS + sub + FS + sys + FS + sys));
    jfc.setSelectedFile(new File(lpt.getToolTipText()));
    int rval = jfc.showOpenDialog(item);
    if (rval == JFileChooser.APPROVE_OPTION) {
      String fpath = jfc.getSelectedFile().toString();
      pic.setToolTipText(fpath);
      try {
        pic.setIcon(new ImageIcon(ImageIO.read(new File(fpath))));
      } catch (IOException ex) {
        Logger.getLogger(Panel4LPT.class.getName()).log(Level.SEVERE,
          null,
          ex);
      }
    }
//    }
  }

  private void newCategory() {
    Object[] os = null;
    String string = "";
    string = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
    String reply = (String) JOptionPane
      .showInputDialog(jp, "Enter new category", "new Category", WIDTH, null, os,
        string);
    File dir = new File(links + reply);
    dir.mkdir();
  }

  private static void newItem() {
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
    String s = "";
    if (running) {
      Object[] os = null;
//      String reply = (String) JOptionPane.showInputDialog(jp, "Enter new item", "newItem", WIDTH, null, os, Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + "-");
      String reply = null;
      try {
        reply = (String) JOptionPane.showInputDialog(jp, "Enter new item",
          "newItem", WIDTH, null, os, item.getSelectedItem().toString());
      } catch (Exception ex) {
        reply = (String) JOptionPane.showInputDialog(jp, "Enter new item",
          "newItem", WIDTH, null, os, "Index");
      } finally {
        File file = new File(
          links + category.getSelectedItem().toString() + FS + reply + ".lpt");
        lpt.setText(
          "\"" + reply + "\",\"" + pic.getToolTipText() + "\",\"" + text
          .getToolTipText() + "\",\"" + note.getText() + "\"");
        saveTextFile(links + category.getSelectedItem().toString(), reply,
          ".lpt", lpt.getText());
        String folder = T5 + FS + sec + FS + sub + FS + sys + FS + sys;
        saveTextFile(folder, reply, ".lpt", lpt.getText());
        for (int i = 0; i < item.getItemCount(); i++) {
          if (reply.equals(item.getItemAt(i).toString())) {
            return;
          }
        }
        item.addItem(reply);
        itemCheck();
      }
    }
  }

  private void noteClick(MouseEvent evt) {
//    String[] lines = null;
//    path = "C:" + FS + "T5" + FS + sec + FS + sub + FS + sys + FS + sys;
//    if (evt.getClickCount() == 1) {
//      // Load Default.html
//      path = links + "Default.html";
//    } else if (evt.getClickCount() > 1) {
//      // Modify output
//      path = links + category.getSelectedItem().toString() + FS + item.getSelectedItem().toString() + ".html";
//    }
//    System.out.println("path" + " = " + path);
//    lines = getLinesFromFile(new File(path));
//    note.setText("");
//    for (int i = 0; i < lines.length; i++) {
//      note.append(lines[i] + CRLF);
//    }
//    note.setToolTipText(path);

  }

  private void picClick(MouseEvent evt) {
    if (evt.getClickCount() > 1) {
      //<editor-fold defaultstate="collapsed" desc="IFD">
      String s = "";
      {
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
          s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
            + CRLF;
          JTextArea jta = new JTextArea(s, 20, 20);
          JScrollPane jsp = new JScrollPane(jta);
          System.out.println(s);
          //JOptionPane.showMessageDialog(jf, jsp);
        }
      }
      //</editor-fold>
      jfc.resetChoosableFileFilters();
      jfc.setAcceptAllFileFilterUsed(false);
      FileFilter picFilter = new FileFilter() {

        @Override
        public boolean accept(File file) {
          if (file.isDirectory() | file.toString().endsWith(".gif")) {
            return true;
          }
          return false;
        }

        @Override
        public String getDescription() {
          return "GIF pics";
        }
      };
      jfc.addChoosableFileFilter(picFilter);
      jfc.setCurrentDirectory(new File(
        "C:" + FS + "T5" + FS + sec + FS + sub + FS + sys + FS + sys));
      jfc.setSelectedFile(new File(txt));
      int rval = jfc.showOpenDialog(item);
      if (rval == JFileChooser.APPROVE_OPTION) {
        String fpath = jfc.getSelectedFile().toString();
        pic.setToolTipText(fpath);
        try {
          pic.setIcon(new ImageIcon(ImageIO.read(new File(fpath))));
        } catch (IOException ex) {
          Logger.getLogger(Panel4LPT.class.getName()).log(Level.SEVERE,
            null,
            ex);
        }
      }
    }
  }

  private void randomAction(ActionEvent evt) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
    int x = item.getItemCount();
    if (x > 0) {
      int number = (int) (Math.random() * x);
      System.out.println("number" + " = " + number);
      item.setSelectedIndex(number);
    }
  }

  private void showAction(ActionEvent evt) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
//    Panel4Add.jf.setVisible(!Panel4Add.jf.isVisible());
    Panel4Add.jf.setVisible(true);
  }

  private void csvClick(MouseEvent evt) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
    if (evt.getClickCount() > 1) {
      //<editor-fold defaultstate="collapsed" desc="IFD">
//      String s = "";
      {
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
          s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
            + CRLF;
          JTextArea jta = new JTextArea(s, 20, 20);
          JScrollPane jsp = new JScrollPane(jta);
          System.out.println(s);
          //JOptionPane.showMessageDialog(jf, jsp);
        }
      }
      //</editor-fold>
      jfc.resetChoosableFileFilters();
      jfc.setAcceptAllFileFilterUsed(false);
      FileFilter csvFilter = new FileFilter() {

        @Override
        public boolean accept(File file) {
          if (file.isDirectory() | file.toString().endsWith(".csv")) {
            return true;
          }
          return false;
        }

        @Override
        public String getDescription() {
          return "Comma Seperated Value (CSV) Files";
        }
      };
      jfc.addChoosableFileFilter(csvFilter);
      jfc.setCurrentDirectory(new File(
        "C:" + FS + "T5" + FS + sec + FS + sub + FS + sys + FS + sys));
      jfc.setSelectedFile(new File(txt));
      int rval = jfc.showOpenDialog(item);
      if (rval == JFileChooser.APPROVE_OPTION) {
        String fpath = jfc.getSelectedFile().toString();
        csv.setToolTipText(fpath);
        csv.setText("");
        String[] lines = getLinesFromFile(jfc.getSelectedFile());
        for (int i = 0; i < lines.length; i++) {
          csv.append(lines[i] + CRLF);
        }
      }
    }
  }

  private void textClick(MouseEvent evt) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
    if (evt.getClickCount() > 1) {
      //<editor-fold defaultstate="collapsed" desc="IFD">
//      String s = "";
      {
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
          s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
            + CRLF;
          JTextArea jta = new JTextArea(s, 20, 20);
          JScrollPane jsp = new JScrollPane(jta);
          System.out.println(s);
          //JOptionPane.showMessageDialog(jf, jsp);
        }
      }
      //</editor-fold>
      jfc.resetChoosableFileFilters();
      jfc.setAcceptAllFileFilterUsed(false);
      FileFilter txtFilter = new FileFilter() {

        @Override
        public boolean accept(File file) {
          if (file.isDirectory() | file.toString().endsWith(".txt")) {
            return true;
          }
          return false;
        }

        @Override
        public String getDescription() {
          return "TeXT Files";
        }
      };
      jfc.addChoosableFileFilter(txtFilter);
      jfc.setCurrentDirectory(new File(
        "C:" + FS + "T5" + FS + sec + FS + sub + FS + sys + FS + sys));
      jfc.setSelectedFile(new File(txt));
      int rval = jfc.showOpenDialog(item);
      if (rval == JFileChooser.APPROVE_OPTION) {
        String fpath = jfc.getSelectedFile().toString();
        text.setToolTipText(fpath);
        text.setText("");
        String[] lines = getLinesFromFile(jfc.getSelectedFile());
        for (int i = 0; i < lines.length; i++) {
          text.append(lines[i] + CRLF);
        }
      }
    }
  }

  private void txtClick(MouseEvent evt) {
    if (evt.getClickCount() > 1) {
      //<editor-fold defaultstate="collapsed" desc="IFD">
      String s = "";
      {
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
          s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
            + CRLF;
          JTextArea jta = new JTextArea(s, 20, 20);
          JScrollPane jsp = new JScrollPane(jta);
          System.out.println(s);
          //JOptionPane.showMessageDialog(jf, jsp);
        }
      }
      //</editor-fold>
      jfc.resetChoosableFileFilters();
      jfc.setAcceptAllFileFilterUsed(false);
      FileFilter txtFilter = new FileFilter() {

        @Override
        public boolean accept(File file) {
          if (file.isDirectory() | file.toString().endsWith(".txt")) {
            return true;
          }
          return false;
        }

        @Override
        public String getDescription() {
          return "TeXT Files";
        }
      };
      jfc.addChoosableFileFilter(txtFilter);
      jfc.setCurrentDirectory(new File(
        "C:" + FS + "T5" + FS + sec + FS + sub + FS + sys + FS + sys));
      jfc.setSelectedFile(new File(txt));
      int rval = jfc.showOpenDialog(item);
      if (rval == JFileChooser.APPROVE_OPTION) {
        String fpath = jfc.getSelectedFile().toString();
        text.setToolTipText(fpath);
        text.setText("");
        String[] lines = getLinesFromFile(jfc.getSelectedFile());
        for (int i = 0; i < lines.length; i++) {
          text.append(lines[i] + CRLF);
        }
      }
    }
  }

  private void webClick(MouseEvent evt) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
    try {
      String b = "http://www.w3schools.com/js/default.asp";
      String a = "C:\\Program Files (x86)\\Mozilla Firefox\\Firefox.exe";//Panel4AddPage.jLabel17.getText();
      Runtime runtime = Runtime.getRuntime();
      ProcessBuilder pb = new ProcessBuilder(a, b);
      pb.start();
    } catch (IOException ex) {
      Logger.getLogger(Panel4LPT.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @SuppressWarnings("unchecked")
  private static void writeCSV() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
//      if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
//        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
//        JTextArea jta = new JTextArea(s, 20, 20);
//        JScrollPane jsp = new JScrollPane(jta);
//        System.out.println(s);
//        //JOptionPane.showMessageDialog(jf, jsp);
//      }
    }
    //</editor-fold>
    File f = new File(links + category.getSelectedItem().toString());
    File file;
    File[] files;
    String[] lines = f.list();
    int cnt = 0;
    csv.setText(
      "" + "\"" + "Link" + "\"" + "," + "\"" + "Pic" + "\"" + "," + "\""
      + "Text" + "\"" + "," + "\"" + "ID" + "\"" + CRLF
    );
    ArrayList al = new ArrayList();
    if (lines.length > 0) {
      for (int i = 0; i < lines.length; i++) {
        file = new File(f + FS + lines[i]);
        System.out.println("" + " = " + file);
        if (file.toString().endsWith(".lpt") & !file.toString().startsWith(
          "null")) {
          cnt += 1;
          al.add(lines[i]);
        }
      }
      for (int i = 0; i < al.size(); i++) {
        f = new File(links + category.getSelectedItem().toString() + FS + al
          .get(i).toString());
        String[] lined = getLinesFromFile(f);
        for (int j = 0; j < lined.length; j++) {
          csv.append(lined[j] + CRLF);
        }
      }
      String fil = category.getSelectedItem().toString();
      String folder = links + fil;
      saveTextFile(folder, fil, ".csv", csv.getText());
      writeXML();
    }
  }

  private static void writeLPT() {
    lpt.setText("\"" + item.getSelectedItem().toString() + "\",\"" + pic
      .getToolTipText() + "\",\"" + text.getToolTipText() + "\",\"" + note
      .getText() + "\"");
  }

  private static void writeXML() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
    String cat = category.getSelectedItem().toString();
    String f = links + cat + FS + cat + ".csv";
    System.out.println("f" + " = " + f);
    int x = countLines(new File(f));
    xml.setText("" + "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
      + "<!-- <?xml-stylesheet type=\"text/xsl\" href=\"category.xsl\"?> -->\n"
      + "<!DOCTYPE category SYSTEM \"file:///C://T5/_Links/Default.dtd\">\n"
      + "<!-- Use category.xsl -->\n"
      + "<category xmlns:category=\"file:///C://T5/_JS/ns.txt\">\n");
    String[] lines = getLinesFromFile(new File(f));
    String[] bits = new String[4];
    for (int i = 0; i < x; i++) {
      bits = lines[i].split("\",\"");
      for (int j = 0; j < bits.length; j++) {
        bits[j] = bits[j].replace("\"", "");
      }
      xml.append("  <item>" + CRLF);
      xml.append("    <link>" + bits[0] + "</link>" + CRLF);
      xml.append("    <pic>" + bits[1] + "</pic>" + CRLF);
      xml.append("    <text>" + bits[2] + "</text>" + CRLF);
      xml.append("    <id>" + bits[3] + "</id>" + CRLF);
      xml.append("  </item>" + CRLF);
      xml.append("" + CRLF);
    }
    xml.append("</category>");
    saveTextFile(links + category.getSelectedItem().toString(), category
      .getSelectedItem().toString().trim(), "xml", xml.getText());
    writeXSL();
  }

  private static void writeXSL() {

  }

  private void xmlClick(MouseEvent evt) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
    if (evt.getClickCount() > 1) {
      saveTextFile(links + category.getSelectedItem().toString(), category
        .getSelectedItem().toString(), "xml", xml.getText());
    }
  }

  private void xslAction(ActionEvent evt) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
//        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
        //JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
//    writeXML();
//    writeXSL();
//    writeHTML();
//    try {
//      Panel4AddPage.NewDefaults.doClick();
//    } catch (Exception e) {
//      System.out.println("" + " = " + e.toString());
//    }
//    writeXSL();
//    writeHTML();
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

    item = new javax.swing.JComboBox<String>();
    pic = new javax.swing.JLabel();
    category = new javax.swing.JComboBox<String>();
    b4NewItem = new javax.swing.JButton();
    b4Random = new javax.swing.JButton();
    xsl = new javax.swing.JComboBox<String>();
    web = new javax.swing.JLabel();
    auto = new javax.swing.JLabel();
    lpt = new javax.swing.JTextArea();
    b4newcat = new javax.swing.JButton();
    note = new javax.swing.JTextArea();
    jScrollPane1 = new javax.swing.JScrollPane();
    text = new javax.swing.JTextArea();
    jScrollPane2 = new javax.swing.JScrollPane();
    csv = new javax.swing.JTextArea();
    jScrollPane3 = new javax.swing.JScrollPane();
    xml = new javax.swing.JTextArea();
    jScrollPane4 = new javax.swing.JScrollPane();
    html = new javax.swing.JTextArea();
    Index = new javax.swing.JLabel();

    setBackground(new java.awt.Color(0, 0, 0));
    setMaximumSize(new java.awt.Dimension(600, 600));
    setMinimumSize(new java.awt.Dimension(600, 600));
    setOpaque(true);
    setPreferredSize(new java.awt.Dimension(600, 600));

    item.setMaximumRowCount(30);
    item.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
    item.setToolTipText("ITEM");
    item.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        itemMouseClicked(evt);
      }
    });
    item.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        itemActionPerformed(evt);
      }
    });

    pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    pic.setIcon(new javax.swing.ImageIcon("C:\\T5\\Spinward Marches\\C Regina\\1705 Efate\\1705 Efate\\1705 Efate.gif")); // NOI18N
    pic.setOpaque(true);
    pic.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        picMouseClicked(evt);
      }
    });

    category.setToolTipText("CATEGORY");
    category.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        categoryMouseClicked(evt);
      }
    });
    category.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        categoryActionPerformed(evt);
      }
    });
    category.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        categoryPropertyChange(evt);
      }
    });

    b4NewItem.setText("+S");
    b4NewItem.setToolTipText("Add Item");
    b4NewItem.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        b4NewItemActionPerformed(evt);
      }
    });

    b4Random.setText("R");
    b4Random.setToolTipText("Random");
    b4Random.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        b4RandomActionPerformed(evt);
      }
    });

    xsl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Table", "Text", "XML" }));
    xsl.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        xslActionPerformed(evt);
      }
    });

    web.setForeground(java.awt.Color.green);
    web.setText("w3schools");
    web.setToolTipText("Web help");
    web.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        webMouseClicked(evt);
      }
    });

    auto.setForeground(java.awt.Color.green);
    auto.setText("automate");
    auto.setToolTipText("JUST DO IT!");
    auto.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        autoMouseClicked(evt);
      }
    });

    lpt.setColumns(80);
    lpt.setLineWrap(true);
    lpt.setRows(5);
    lpt.setToolTipText("Follow instructions");
    lpt.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        lptMouseClicked(evt);
      }
    });

    b4newcat.setText("+");
    b4newcat.setToolTipText("Add Folder");
    b4newcat.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        b4newcatActionPerformed(evt);
      }
    });

    note.setColumns(5);
    note.setRows(3);
    note.setTabSize(2);
    note.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        noteMouseClicked(evt);
      }
    });

    text.setColumns(20);
    text.setRows(5);
    text.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        textMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(text);

    csv.setColumns(20);
    csv.setRows(5);
    csv.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        csvMouseClicked(evt);
      }
    });
    jScrollPane2.setViewportView(csv);

    xml.setColumns(20);
    xml.setRows(5);
    xml.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        xmlMouseClicked(evt);
      }
    });
    jScrollPane3.setViewportView(xml);

    html.setColumns(20);
    html.setRows(5);
    html.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        htmlMouseClicked(evt);
      }
    });
    jScrollPane4.setViewportView(html);

    Index.setForeground(java.awt.Color.green);
    Index.setText("Index");
    Index.setToolTipText("Web help");
    Index.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        IndexMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(lpt, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addComponent(pic)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(note))
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(item, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addComponent(b4newcat)
            .addGap(0, 0, 0)
            .addComponent(xsl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(b4NewItem)
            .addGap(0, 0, 0)
            .addComponent(b4Random, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(web)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(auto))
          .addComponent(Index))
        .addGap(0, 0, Short.MAX_VALUE))
      .addComponent(jScrollPane1)
      .addComponent(jScrollPane2)
      .addComponent(jScrollPane3)
      .addComponent(jScrollPane4)
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {category, item});

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {b4NewItem, b4newcat});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(xsl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(web)
          .addComponent(b4newcat)
          .addComponent(auto))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(b4NewItem)
          .addComponent(b4Random)
          .addComponent(Index))
        .addGap(0, 0, 0)
        .addComponent(lpt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(pic)
          .addComponent(note, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addComponent(jScrollPane1)
        .addGap(0, 0, 0)
        .addComponent(jScrollPane2)
        .addGap(0, 0, 0)
        .addComponent(jScrollPane3)
        .addGap(0, 0, 0)
        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
    );

    layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {auto, b4NewItem, b4Random, b4newcat, category, item, web, xsl});

    layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {note, pic});

  }// </editor-fold>//GEN-END:initComponents

  private void itemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemMouseClicked
    itemClick(evt);
  }//GEN-LAST:event_itemMouseClicked

  private void itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActionPerformed
    itemAction(evt);
  }//GEN-LAST:event_itemActionPerformed

  private void picMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picMouseClicked
    picClick(evt);
  }//GEN-LAST:event_picMouseClicked

  private void categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryMouseClicked
    catClick(evt);
  }//GEN-LAST:event_categoryMouseClicked

  private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
    catAction(evt);
  }//GEN-LAST:event_categoryActionPerformed

  private void b4NewItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4NewItemActionPerformed
//    showAction(evt);
    newItem();
  }//GEN-LAST:event_b4NewItemActionPerformed

  private void b4RandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4RandomActionPerformed
    randomAction(evt);
  }//GEN-LAST:event_b4RandomActionPerformed

  private void xslActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xslActionPerformed
    xslAction(evt);
  }//GEN-LAST:event_xslActionPerformed

  private void webMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webMouseClicked
    webClick(evt);
  }//GEN-LAST:event_webMouseClicked

  private void autoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autoMouseClicked
    autoClick(evt);
  }//GEN-LAST:event_autoMouseClicked

  private void lptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lptMouseClicked
    loadLPT();
  }//GEN-LAST:event_lptMouseClicked

  private void b4newcatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4newcatActionPerformed
    newCategory();
  }//GEN-LAST:event_b4newcatActionPerformed

  private void csvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_csvMouseClicked
    csvClick(evt);
  }//GEN-LAST:event_csvMouseClicked

  private void categoryPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_categoryPropertyChange
    //<editor-fold defaultstate="collapsed" desc="JOP">
    String s = "";
    {
      s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
        + CRLF;
      s += "" + "" + CRLF;
      s += "links = " + links + CRLF;
      s += "jfc.getCurrentDirectory().toString() = " + jfc.getCurrentDirectory()
        .toString() + CRLF;
      JTextArea jta = new JTextArea(s, 50, 80);
      JScrollPane jsp = new JScrollPane(jta);
//      JOptionPane.showMessageDialog(jf, jsp);
      System.out.println(s);
    }
    //</editor-fold>
  }//GEN-LAST:event_categoryPropertyChange

  private void noteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_noteMouseClicked
    noteClick(evt);
  }//GEN-LAST:event_noteMouseClicked

  private void xmlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xmlMouseClicked
    xmlClick(evt);
  }//GEN-LAST:event_xmlMouseClicked

  private void textMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textMouseClicked
    textClick(evt);
  }//GEN-LAST:event_textMouseClicked

  private void htmlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_htmlMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_htmlMouseClicked

  private void IndexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IndexMouseClicked
    for (int i = 0; i < item.getItemCount(); i++) {
      item.setSelectedIndex(i);
      autoClick(evt);
    }
    createIndex();
    try {
      String b = "File://" + T5 + FS + sec + FS + sub + FS + sys;
      b = "file:///" + T5 + FS + sec + FS + sub + FS + sys + FS + sys + FS + sys.substring(0, 4)
        + "-System Index.html";
      String a = "C:\\Program Files\\Mozilla Firefox\\Firefox.exe";
      Runtime runtime = Runtime.getRuntime();
      ProcessBuilder pb = new ProcessBuilder(a, b);
      pb.start();
    } catch (IOException ex) {
      Logger.getLogger(Panel4LPT.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_IndexMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  static javax.swing.JLabel Index;
  private javax.swing.JLabel auto;
  static javax.swing.JButton b4NewItem;
  private javax.swing.JButton b4Random;
  private javax.swing.JButton b4newcat;
  static javax.swing.JComboBox<String> category;
  public static javax.swing.JTextArea csv;
  public static javax.swing.JTextArea html;
  static javax.swing.JComboBox<String> item;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  static javax.swing.JTextArea lpt;
  static javax.swing.JTextArea note;
  static javax.swing.JLabel pic;
  public static javax.swing.JTextArea text;
  static javax.swing.JLabel web;
  static javax.swing.JTextArea xml;
  static javax.swing.JComboBox<String> xsl;
  // End of variables declaration//GEN-END:variables

  /**
   saveTexts
   */
  public static void saveTexts() {
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
    String all = GlobalMethods.loadTextFile(path, Panel4T5Locator.jcb4Sys
      .getSelectedItem().toString().trim(),
      ".txt");
    System.out.println("all = " + all);
    String SPLIT = GlobalMethods.comment("-", 80);
    String[] parts = all.split(SPLIT);
    String[] names = {"Name", "Sector", "Line", "System", "Info", "Orbits",
      "Strength", "J-0", "J-1", "J-2", "J-3", "J-4", "J-5", "J-6", "J-7",
      "J-8", "J-9"
    };
    System.out.println("parts.length = " + parts.length);
    for (int i = 0; i < names.length; i++) {
      System.out.println(path + FS + "" + i + "-" + names[i] + ".txt");
      GlobalMethods
        .saveTextFile(path, "" + i + "-" + names[i], ".txt", parts[i]);
    }
    String txt = "";
    txt = jta4Near.getText();
    GlobalMethods.saveTextFile(path, "17-" + "Near", ".txt", txt);
    txt = jta4UWP.getText();
    GlobalMethods.saveTextFile(path, "18-" + "UWP", ".txt", txt);
    txt = jta4Bases.getText();
    GlobalMethods.saveTextFile(path, "19-" + "Bases", ".txt", txt);
    txt = jta4Sub.getText();
    GlobalMethods.saveTextFile(path, "20-" + "Subsector", ".txt", txt);

    String[] partnames = {"", "-Sector", "-Subsector", "-System", "-UWP",
      "-Admiral", "-Army", "-Belts", "-Defences", "-Equipment", "-Fleet",
      "-Gas Giants", "-Marine", "-Merchant", "-Navy", "-Other",
      "-Population", "-Scout", "-SDBs", "-Ship", "-Squadrons",
      "-T5C", "-Troops", "-Vehicle", "-Worlds"
    };
    String[] picnames = new String[partnames.length];
//    for (int i = 1; i < 5; i++) {
//      picnames[i] = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + " " + partnames[i];
//    }
    for (int i = 0; i < picnames.length; i++) {
      picnames[i] = Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
        .substring(0, 4) + partnames[i];
    }
    int num = picnames.length;
    String[] jtas = new String[num];
    int[] txts = new int[num];
    for (int i = 1; i < num; i++) {
      jtas[i] = "";

      //<editor-fold defaultstate="collapsed" desc="switch(i)">
      switch (partnames[i]) {
        //
        case "": {
          txts = new int[]{0, 2};
          break;
        }
        //
//        case "Sector": {
//          txts = new int[]{0, 1, 2, 3, 4, 5};
//          break;
//        }
        //
        case "-Subsector": {
          txts = new int[]{0, 2};
          break;
        }
        //
        case "-System": {
          txts = new int[]{0, 2};
          break;
        }
        //
        case "-UWP": {
          txts = new int[]{0, 2};
          break;
        }
        //
        case "-Admiral": {
          txts = new int[]{0, 1, 2, 3, 4, 5, 6};
          break;
        }
        //
        case "-Army": {
          txts = new int[]{0, 2, 6};
          break;
        }
        //
        case "-Belts": {
          txts = new int[]{0, 2, 3};
          break;
        }
        //
        case "-Defences": {
          txts = new int[]{0, 2, 4, 6};
          break;
        }
        //
        case "-Equipment": {
          txts = new int[]{0, 2};
          break;
        }
        //
        case "-Fleet": {
          txts = new int[]{0, 2, 3, 4, 5, 6};
          break;
        }
        //
        case "-Gas Giants": {
          txts = new int[]{0, 2, 4};
          break;
        }
        //
        case "-Marine": {
          txts = new int[]{0, 2, 4, 6};
          break;
        }
        //
        case "-Merchant": {
          txts = new int[]{0, 2, 4, 5};
          break;
        }
        //
        case "-Navy": {
          txts = new int[]{0, 2, 4, 5};
          break;
        }
        //
        case "-Other": {
          txts = new int[]{0, 2, 4, 5};
          break;
        }
        //
        case "-Population": {
          txts = new int[]{0, 2, 4};
          break;
        }
        //
        case "-Scout": {
          txts = new int[]{0, 2, 4, 5};
          break;
        }
        //
        case "-SDBs": {
          txts = new int[]{0, 2, 5, 6};
          break;
        }
        //
        case "-Sector": {
          txts = new int[]{0, 1, 2};
          break;
        }
        case "-Ship": {
          txts = new int[]{0, 2};
          break;
        }
        //
        case "-Squadrons": {
          txts = new int[]{0, 2, 5, 6};
          break;
        }
        //
        case "-T5C": {
          txts = new int[]{0, 2};
          break;
        }
        //
        case "-Troops": {
          txts = new int[]{0, 2, 4, 6};
          break;
        }
        //
        case "-Vehicle": {
          txts = new int[]{0, 2};
          break;
        }
        //
        case "-Worlds": {
          txts = new int[]{0, 2, 3};
          break;
        }
//        //
//        case "": {
//          txts = new int[]{2};
//          break;
//        }
//        //
//        case "": {
//          txts = new int[]{2};
//          break;
//        }
        //
        //
        //
        //
        default: {
          System.out.println("DEFAULT = " + partnames[i]);
          txts = new int[]{0};
          break;
        }
      }
      //</editor-fold>

      try {
//        for (int j = 0; j < txts.length; j++) {
//          jtas[i] += parts[txts[j]] + "\n";
//        }
        GlobalMethods.saveTextFile(path, picnames[i], ".txt",
          jtas[i]);
      } catch (Exception e) {
        System.out.println("OOPs \"" + picnames[i] + "\"");
        continue;
      }
    }
    Panel4T5Locator.saveFullPic();
  }
}
