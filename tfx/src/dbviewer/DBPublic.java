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
package dbviewer;

import dbviewer.globals.FindExtensions;
import dbviewer.globals.GlobalMethods;
import dbviewer.globals.GlobalVariables;
import static dbviewer.globals.GlobalVariables.T5;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import panels.Frame4;
import panels.Frame4Careers;
import panels.Panel4;
import panels.Panel4Batch;
import panels.Panel4Catalogue;
import panels.Panel4Chars;
import panels.Panel4ComboSpinner;
import panels.Panel4Conflict;
import panels.Panel4Counter;
import panels.Panel4D66;
import panels.Panel4Dimensions;
import panels.Panel4GridLayer;
import panels.Panel4Hexer;
import panels.Panel4Imperium;
import panels.Panel4Jump;
import panels.Panel4ListBox;
import panels.Panel4Locator;
import panels.Panel4MassCombat;
import panels.Panel4Mining;
import panels.Panel4Piece;
import panels.Panel4PieceInfo;
import panels.Panel4Rotate;
import panels.Panel4Routes;
import panels.Panel4Squadrons;
import panels.Panel4SubSector;
import panels.Panel4T5CounterMaker;
import panels.Panel4UTP;
import panels.Panel4WordGenOld;
import panels._ShowCode;
import panels._ShowPanels;

/**

 @author maggot
 */
public class DBPublic {

  /**

   */
  private static JFrame f4n;
  private static JFrame f4p;
  private static String[] args;
  private static JScrollPane jsp;
  private static int secwid;
  private static int sechgt;
  private static String[] sectors;
  private static String FS = File.separator;
  private static String CRLF = "\n";

  /**

   @param column    to search
   @param searchfor string to find
   */
  public static void LocateSystems(String column, String searchfor) {
    System.out.println("Search " + column + " for " + searchfor);
  }

  /**

   @return frame 4 panel
   */
  public static JFrame getFrame4Panel() {
    return f4p;
  }

  /**
   MS-DOS batch files
   */
  public static void BAT() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("e.toString()" + " = " + e.toString());
    }
//</editor-fold>
    JPanel p4b = new Panel4Batch();
    JFrame f4b = new Frame4(p4b);
  }

  /**
   GURPS brain
   */
  public static void Brain() {
    Brain brain = new Brain();
    //System.out.print("" + " = " + brain.toString());
  }

  /**

   @return FileChooser for local use
   */
  public static JFileChooser CBView() {
//    Debug.debug("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    //jfc.setCurrentDirectory(new File("./bmp"));
    try {
      DBViewer.jfc.setCurrentDirectory(new File(DBViewer.getPath()));
      DBViewer.jfc.resetChoosableFileFilters();
    } catch (Exception e) {
    }
    int numFilters = 4;
    FileNameExtensionFilter[] filters = new FileNameExtensionFilter[numFilters];
    filters[0] = new FileNameExtensionFilter("Image files", "jpg", "jpeg",
      "gif", "bmp", "png");
    filters[1] = new FileNameExtensionFilter("Text files", "txt", "cfg", "ici",
      "java", "vbs", "bat", "u*", "npc", "gci");
    filters[2] = new FileNameExtensionFilter("QuickLinks", "zip", "qfm", "txt",
      "gts", "adv", "rar", "pak", "dst");
    filters[3] = new FileNameExtensionFilter("Trav", "bmp", "jpg", "jpeg",
      "gif", "bat", "txt", "cfg", "frm", "vb", "exe", "dwi", "frx",
      "gbx", "gsn", "gtl", "hlp", "xls", "mdb", "odb", "npc", "ace",
      "zip", "rar", "sec", "sub", "sys", "ttf");
    //filters[4] = new FileNameExtensionFilter(filters.toString());
    ImagePreviewer ipv = new ImagePreviewer(DBViewer.jfc);
    DBViewer.jfc.setAccessory(ipv);
    for (int i = 0; i < filters.length; i++) {
      DBViewer.jfc.addChoosableFileFilter(filters[i]);
    }
    DBViewer.jfc.setFileFilter(filters[3]);
    return DBViewer.jfc;
  }

  /**

   @param path dir for JFileChooser
   */
  public static void CBView(String path) {
    DBPublic.CBView();
    //System.out.print("path = " + path);
    DBViewer.setTitle(path);
    DBViewer.jfc.setCurrentDirectory(new File(path));
    //DBViewer.jfc.showSaveDialog(DBViewer.Group);
  }

  /**

   @param x number across
   @param y number down
   */
  public static void Counter(int x, int y) {
    final JPanel p4C = new Panel4("Counter");
    p4C.setLayout(new GridLayout(x, y));
    JFrame f4C = new Frame4(p4C);
    f4C.setSize(400, 400);
    for (int i = 0; i < y; i++) {
      for (int j = 0; j < x; j++) {
        JPanel pan = new Panel4Counter();
        pan.setName("X" + (j + 1) + "Y" + (i + 1));
        p4C.add(pan);
      }
    }
    JMenuItem jms = new JMenuItem("Save");
    //<editor-fold defaultstate="collapsed" desc="SAVE">
    jms.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        SaveOutputWindow sow = new SaveOutputWindow();
        String title = "Counter.bat";
        sow.setText("");
        sow.setTitle("Counter2");
        sow.setCurrentDirectory(GlobalVariables.BAT);
        sow.setSelectedFile(title);
        sow.append("# " + title + GlobalVariables.CRLF);
        sow.append(GlobalVariables.CRLF);
        int num = p4C.getComponentCount();
        Component[] comp = new Component[num];
        JTextField jtf;
        JComboBox jcb;
        JLabel jl;
        int red, green, blue;
        for (int i = 0; i < num; i++) {
          comp[i] = p4C.getComponent(i);
          sow.append("# comp[" + i + "].setName(\"" + comp[i].getName() + "\");"
            + GlobalVariables.CRLF);
          Container cont;
          //------------------------------------------
          if (comp[i] instanceof JPanel) {
            red = comp[i].getBackground().getRed();
            green = comp[i].getBackground().getGreen();
            blue = comp[i].getBackground().getBlue();
            sow.append("# comp[" + i + "].setBackground(new java.awt.Color("
              + red + ", " + green + ", " + blue + ");" + GlobalVariables.CRLF);
            cont = (Container) comp[i];
            for (int j = 0; j < cont.getComponentCount(); j++) {
              //------------------------------------------
              if (cont.getComponent(j) instanceof JTextField) {
                jtf = (JTextField) cont.getComponent(j);
                sow.append("# comp[" + i + "].add(new JTextField(\"" + jtf
                  .getText() + "\"));" + GlobalVariables.CRLF);
              }
              //------------------------------------------
//              if (cont.getComponent(j) instanceof JComboBox) {
//                jcb = (JComboBox) cont.getComponent(j);
//                ComboBoxModel cbm = jcb.getModel();
//                for (int k = 0; k < cbm.getSize(); k++) {
//                  sow.append("# cbm.add(\"" + cbm.getElementAt(k).toString() + "\");" + GlobalVariables.CRLF);
//                }
//              }
              //------------------------------------------
            }
            sow.append(GlobalVariables.CRLF);
          }
          //------------------------------------------
        }
      }
      //</editor-fold>
    });
    f4C.getJMenuBar().getMenu(0).add(jms);
    f4C.validate();
  }

  /**
   panel for D66 table
   */
  public static void D66() {
    JPanel p4d66 = new Panel4D66("D66");
    JFrame f4D66 = new Frame4(p4d66);
    JMenuItem jmi = new JMenuItem("Save");
    jmi.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        String name = "D66-";
        DBViewer.jfc.setSelectedFile(new File(name));
        DBViewer.jfc.setCurrentDirectory(new File(T5 + "/CSV/D66"));
        SaveOutputWindow sow = new SaveOutputWindow();
        sow.setText("D66 Table\n");
        for (int x = 0; x < 6; x++) {
          for (int y = 0; y < 6; y++) {
            sow.append(Panel4D66.result[x][y] + "\t");
            sow.append(Panel4D66.desc[x][y] + "\n");
          }
        }
      }
    });
    f4D66.getJMenuBar().getMenu(0).add(jmi);
    //GlobalMethods.autoColor(f4D66, Color.black, Color.light_gray);
  }

  /**
   panel 4 Font creation / modification
   */
  public static void Fonts() {
    JPanel p4F = new MyFonts();
    JFrame f4F = new Frame4(p4F, "Fonts");
  }

  /**
   Fifth Frontier War
   */
  public static void FFW() {
    Panel4SubSector.ffw();
  }

  /**

   @return rule set currently in use
   */
  public static String getRules() {
    return dbviewer.Rules.getRules();
  }

  /**
   Hex paper creation
   */
  public static void Hex() {
    Panel4Hexer p4h = new Panel4Hexer();
  }

  /**
   origianl database viewer for CSV database
   */
  public static void Imperium() {
    JPanel p4Imp = new Panel4Imperium("3rd Imperium");
    //JFrame f4Imp = new Frame4(p4Imp);
  }

  /**

   */
//  public static void Imports() {
//    JPanel p4im;
//    JFrame f4im;
//    p4im = new Panel4Imports();
//    f4im = new Frame4(p4im);
//  }
  private static void Frames() {
    JPanel p4lb;
    JFrame f4f;
    p4lb = new Panel4ListBox();
    f4f = new Frame4(p4lb);
    f4f.setSize(200, 400);
//    f4f.getJMenuBar().getMenu(0).add(dbviewer.AnyMenu.saveAction);
    GlobalMethods.autoColor(Panel4ListBox.jList1, Color.black, Color.LIGHT_GRAY);
  }

  private static void GridLayer() {
    JPanel p4g;
    JFrame f4g;
    p4g = new Panel4GridLayer("GridLayer");
    f4g = new Frame4(p4g);
  }

  private static void WordGen() {
    JFrame jf;
    JPanel jp;
    jp = new Panel4WordGenOld();
    jf = new Frame4(jp);
  }

  private static void DirFile() {
    dbviewer.DirFile.main(args);
  }

  private static void catalogue() {
    // list all worlds in database containing specifics
    JPanel pan4cat = new Panel4Catalogue();
    JFrame cat = new Frame4(pan4cat);
  }

  /**
   @return the f4n
   */
  public static JFrame getF4n() {
    return f4n;
  }

  /**
   @param aF4n the f4n to set
   */
  public static void setF4n(JFrame aF4n) {
    f4n = aF4n;
  }

  /**
   panel for mining operations
   */
  public static void Mining() {
    JFrame f4m;
    final JPanel p4m;
    p4m = new Panel4("Mining");
    p4m.add(new Panel4Mining(), BorderLayout.WEST);
    JMenuItem jmi = new JMenuItem("Save");
    jmi.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String line = Panel4Mining.getText();
        try {
          try (PrintWriter out = new PrintWriter(new FileWriter(
            "D:/Cyberboard/CSV/TEXT/Mining - " + fileNum() + ".txt"))) {
            out.print(Panel4Mining.getDetails() + CRLF + CRLF);
            out.print(line);
            dbviewer.DBViewer.Group.setSelectedItem("TEXT");
          }
        } catch (IOException ex) {
          Logger.getLogger(DBViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    });
    JMenuItem jmi2 = new JMenuItem("Open");
    jmi2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String line = Panel4Mining.getDetails();
        int showOpenDialog = DBViewer.jfc.showOpenDialog(p4m);
      }
    });
    f4m = new Frame4(p4m);
    f4m.getJMenuBar().getMenu(0).add(jmi);
    f4m.getJMenuBar().getMenu(0).add(jmi2);
  }

  /**
   @return number of lines in file
   */
  static public int fileNum() {
    File f = new File("D:/Cyberboard/CSV/TEXT/");
    //System.out.print("" + f.list().length + 1);
    int num = f.list().length + 1;
    //System.out.print("" + " = " + num);
    return num;
  }

  private static void MassCombat() {
    final JFrame f4m;
    JPanel p4m;
    //p4m = new Panel4("MassCombat");
    //p4m.add(new Panel4MassCombat());
    p4m = new Panel4MassCombat();
    f4m = new Frame4(p4m);
    String saver = "Save";
    JMenuItem save = new JMenuItem(saver);
    save.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String fname = Panel4MassCombat.getTitle();
        String line = Panel4MassCombat.getText();
        try {
          try (PrintWriter out = new PrintWriter(new FileWriter(""
            + "D:/Cyberboard/CSV/TEXT/" + f4m.getTitle()
            + " - " + fileNum() + ".txt"))) {
            out.print(fname + CRLF + CRLF);
            out.print(line);
            dbviewer.DBViewer.Group.setSelectedItem("TEXT");
          }
        } catch (IOException ex) {
          Logger.getLogger(DBViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    });
    f4m.getJMenuBar().getMenu(0).add(save);
  }

  /**
   Colour
   */
  public static void Colour() {
//    JPanel p4c = new Panel4("Colours");
//    JFrame jf = new Frame4(p4c);
    JColorChooser jcc = new JColorChooser(JColorChooser.showDialog(null, FS,
      Panel4T5CounterMaker.c));
    jcc.setLocation(0, 0);
    Color col = jcc.getColor();
    jcc.setVisible(true);
    Panel4T5CounterMaker.c = col;
//    System.out.println("col" + " = " + col);
  }

  private static void Backup() {
    //Save CSV & BMP folders to Backup store called <name>
    JPanel p4c = new Panel4("Backup");
    JTextArea jta = new JTextArea("Backup".toUpperCase() + CRLF);
    p4c.add(jta);
    JFrame jf = new Frame4(p4c);
    String bmp = dbviewer.globals.GlobalVariables.BMP;
    File fb = new File(bmp);
    jta.append("bmp" + " = " + bmp + CRLF);
    String csv = dbviewer.globals.GlobalVariables.CSV;
    File fc = new File(csv);
    jta.append("csv" + " = " + csv + CRLF);
    DBViewer.jfc.setCurrentDirectory(new File("C:/_Backup"));
    DBViewer.jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    DBViewer.jfc.showSaveDialog(jta);
    jta.append("Backup to " + DBViewer.jfc.getSelectedFile() + CRLF);
//    //    File[] files =  File.listRoots();
//    //    for (int i = 0; i < files.length; i++) {
//    //      jta.append("  " + " = " +files[i] + CRLF);
//    //    }
    File fd = DBViewer.jfc.getSelectedFile();
//    if (!fd.exists()) {
//      fd.mkdir();
//    }
    DBViewer.jfc.setCurrentDirectory(fd);
    try {
      Files.copy(fb.toPath(), fd.toPath(), null, null);
      Path path = Files.copy(fc.toPath(), fd.toPath(),
        StandardCopyOption.REPLACE_EXISTING);
      //System.out.print("" + " = " + path);
    } catch (Exception e) {
      //System.out.print("" + " = " + e);
    }

  }

  private static void UCP() {
    JPanel jp = new Panel4("UCP");
    JFrame jf = new Frame4(jp);
  }

  private static void UEP() {
    JPanel jp = new Panel4("UEP");
    JFrame jf = new Frame4(jp);
  }

  private static void UMP() {
    JPanel jp = new Panel4("UMP");
    JFrame jf = new Frame4(jp);
  }

  private static void USP() {
    JPanel jp = new Panel4("USP");
    JFrame jf = new Frame4(jp);
  }

  private static void USqP() {
//    JPanel jp = new Panel4USqP();
//    JFrame jf = new Frame4(jp);
    Panel4Squadrons.main(args);
  }

  private static void UTP() {
    Panel4UTP.main(args);
//    JPanel jp = new Panel4UTP();
//    JFrame jf = new Frame4(jp);
  }

//  private static void Hidden() {
//    Panel4Hidden.main(args);
//  }
  /**

   @param path for JFileChooser
   @return path to selected file
   */
  public static String loadFile(String path) {
    CBView(path);
    DBViewer.string = "";
    int retval = 0;
    if (retval == JFileChooser.APPROVE_OPTION) {
      DBViewer.string = DBViewer.jfc.getSelectedFile().toString();
    }
    return DBViewer.string;
  }

  /**
   test case
   */
  public static void Panel4() {
    JPanel panel4 = new Panel4("Panel4");
    JFrame f4P4 = new Frame4(panel4);
  }

  /**
   PC creator for CT
   */
  public static void PCGen() {
//    if (f4c == null) {
//      f4c = new Frame4Careers();
//    }
    DBViewer.Group.setSelectedItem("WHO");
//    f4c.setLocation(620, 0);
//    f4c.setVisible(true);
    String[] career = {"ARMY"};
    Frame4Careers.main(career);

  }

  /**
   update paper counter creator
   */
  public static void Piece() {
    JPanel p4p = new Panel4Piece("Piece");
    p4p.setLayout(new BorderLayout());
    JPanel p4d = new Panel4Dimensions("Dimensions");
    JPanel p4lc = new Panel4ComboSpinner();
    JPanel p4pi = new Panel4PieceInfo();
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new GridLayout(3, 1));
    leftPanel.add(p4d);
    leftPanel.add(p4lc);
    leftPanel.add(p4pi);
    jsp = new JScrollPane(p4p);
    jsp.setPreferredSize(new Dimension(Panel4Piece.B.getWidth(), Panel4Piece.U
      .getY() + Panel4Piece.U.getHeight()));
    f4p = new Frame4();
    f4p.add(leftPanel, BorderLayout.WEST);
    f4p.add(jsp, BorderLayout.CENTER);
    f4p.setTitle("Piece");
    f4p.setSize(new Dimension(350, 300));
    Panel4Piece.updater();
//    GlobalMethods.autoColor(p4p, Color.black, Color.light_gray);
    GlobalMethods.autoColor(p4pi, Color.black, Color.lightGray);
    GlobalMethods.autoColor(p4lc, Color.black, Color.lightGray);
//    GlobalMethods.autoColor(topPanel, Color.black, Color.light_gray);
    //GlobalMethods.autoColor(jsp, Color.black, Color.light_gray);
  }

  /**
   NOT USED
   */
  public static void Planet() {
    JPanel p4P = new Panel4("Planet");
    JFrame f4P = new Frame4(p4P);
  }

  /**
   NOT USED
   */
  public static void Programs() {
    JPanel jp = new Panel4("Programs");
    JFrame jf = new Frame4(jp);
  }

  /**
   CreateSectorMapCode
   */
  public static void Sector() {
    JPanel p4Sec = new Panel4("Sector");
    JFrame f4Sec = new Frame4(p4Sec);
    CreateSectorMapCode.main(args);
  }

  private static void Universe() {
    //read ./CSV/uwp-worlds
    File f = new File(T5 + "/CSV/uwp-worlds");
    JFileChooser jfc = DBViewer.jfc;
    jfc.setCurrentDirectory(new File(T5 + "/CSV/"));
    jfc.setSelectedFile(f);
    //jfc.setSelectedFile(jfc.gets);
    SaveOutputWindow sow = new SaveOutputWindow();
    sow.openIt();
    SaveOutputWindow.setSearchWord("Regina");
  }

  /**
   NOT USED
   */
  public static void Station() {
    JPanel p4S = new Panel4("Station");
    JFrame f4S = new Frame4(p4S);
  }

  /**
   NOT USED
   */
  public static void SubSector() {
    JPanel p4Sub = new Panel4("SubSector");
    JFrame f4Sub = new Frame4(p4Sub);
  }

  /**
   NOT USED
   */
  public static void System() {
    JPanel p4Sys = new Panel4("System");
    JFrame f4Sys = new Frame4(p4Sys);
  }

  /**
   DISPLAY SKY RIG ROUTE
   */
  public static void Worlds() {
    JPanel p4w = new Panel4Routes("Worlds");
    JFrame f4Worlds = new Frame4(p4w);
  }

  /**

   @return relevant ScrollPane
   */
  public static JScrollPane getJsp() {
    return jsp;
  }

  /**

   @param file name of panel
   */
  public static void DBP(String file) {
    JPanel dbp = new Panel4(file);
    //System.out.print("file" + " = " + file);
    JScrollPane jsp1 = MyJTable.createTable(file);
    dbp.add(jsp1, BorderLayout.CENTER);
    JFrame jfr = new Frame4(dbp);
  }

  /**
   NOT USED
   */
  @SuppressWarnings("unchecked")
  public static void updateSecs() {
    JPanel p4usub = new Panel4("updateSubs");
    JTextArea jta = new JTextArea();
    JScrollPane jsp = new JScrollPane(jta);
    p4usub.add(jsp);
    JFrame jf = new Frame4(p4usub);

    String[] strings = Panel4Imperium.Systems;
    String[] parts;
    boolean found;
    parts = strings[0].split("\",\"");
    jta.append(parts[7] + GlobalVariables.CRLF);
    ArrayList al = new ArrayList();
    //al.add(parts[7]);
    for (int i = 1; i < strings.length; i++) {
      found = false;
      parts = strings[i].split("\",\"");
      for (int j = 0; j < al.size(); j++) {
        if (al.get(j).toString().equals(parts[7].toString())) {
          found = true;
          //System.out.print("found" + " = " + found);
        }
      }
      if (found == false) {
        jta.append(parts[7] + GlobalVariables.CRLF);
        al.add(parts[7]);
      }
    }
    //jta.append("al.size() = "+al.size());

  }

  /**
   NOT USED
   */
  @SuppressWarnings("unchecked")
  public static void updateSubs() {
    JPanel p4usub = new Panel4("updateSubs");
    JTextArea jta = new JTextArea();
    JScrollPane jsp = new JScrollPane(jta);
    p4usub.add(jsp);
    JFrame jf = new Frame4(p4usub);

    String[] strings = Panel4Imperium.Systems;
    String[] parts;
    ArrayList al = new ArrayList();
    for (int i = 0; i < strings.length; i++) {
      parts = strings[i].split("\",\"");
      try {
        addUnique(parts[9], parts[7], parts[8], al);
      } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        //System.out.print("ArrayIndexOutOfBoundsException" + " = " + e.toString());
      }
    }
    jta.setText("");
    for (int i = 0; i < al.size(); i++) {
      jta.append(al.get(i).toString());
      jta.append(GlobalVariables.CRLF);
    }
    //System.out.print("al.size()" + " = " + al.size());
  }

  private static void addUnique(String sub, String sec, String let,
    ArrayList<String> al) {
//    //System.out.print("al.size()" + " = " + al.size());
    if (al.isEmpty()) {
      al.add("\"" + sub + "\",\"" + sec + "\",\"" + let + "\",\"Notes\"");
    } else {
      boolean found = false;
      for (int i = 0; i < al.size(); i++) {
        if (al.get(i).toString().contains("\"" + sub + "\",\"")) {
          if (al.get(i).toString().contains("\"" + sec + "\",\"")) {
            if (al.get(i).toString().contains("\"" + let + "\",\"")) {
              found = true;
            }
          }
        }
      }
      if (found == false) {
        al.add("\"" + sub + "\",\"" + sec + "\",\"" + let + "\",\"\"");
      }
    }
  }

  /**
   NOT USED
   */
  public static void updateWorlds() {
    JPanel p4usec = new Panel4("updateWorlds");
    JTextArea jta = new JTextArea();
    JScrollPane jsp = new JScrollPane(jta);
    p4usec.add(jsp);
    JFrame jf = new Frame4(p4usec);

    String[] lines = Panel4Imperium.Systems;
    String[] parts;
    String word;
    for (int i = 0; i < lines.length; i++) {
      parts = lines[i].split("\",\"");
      for (int j = 0; j < parts.length; j++) {
        if ((j == 2) | (j == 12) | (j == 13) | (j == 14) | (j == 15)) {
          word = parts[j].toUpperCase().replace("\"", "");
        } else if ((j == 1) & (parts[j].length() == 3)) {
          word = "0" + parts[j];
        } else {
          word = GlobalMethods.capWords(parts[j].replace("\"", ""));
        }

        jta.append("\"" + word);

        if (j != parts.length - 1) {
          jta.append("\",");
        } else {
          jta.append("\"");
        }
      }
      jta.append(GlobalVariables.CRLF);
    }
  }

  /**
   SET JFileChooser filters
   */
  public void setJFCFilters() {
    DBViewer.jfc.resetChoosableFileFilters();
    int numFilters = 4;
    FileNameExtensionFilter[] filters = new FileNameExtensionFilter[numFilters];
    filters[0] = new FileNameExtensionFilter("Image files", "jpg", "jpeg",
      "gif", "bmp", "png");
    filters[1] = new FileNameExtensionFilter("Text files", "txt", "cfg", "ici",
      "java", "vbs", "bat", "u*", "npc", "gci");
    filters[2] = new FileNameExtensionFilter("QuickLinks", "zip", "qfm", "txt",
      "gts", "adv", "rar", "pak", "dst");
    filters[3] = new FileNameExtensionFilter("Trav", "bmp", "jpg", "jpeg",
      "gif", "bat", "txt", "cfg", "frm", "vb", "exe", "dwi", "frx",
      "gbx", "gsn", "gtl", "hlp", "xls", "mdb", "odb", "npc", "ace",
      "zip", "rar", "sec", "sub", "sys", "ttf");
    //filters[4] = new FileNameExtensionFilter(filters.toString());
    ImagePreviewer ipv = new ImagePreviewer(DBViewer.jfc);
    DBViewer.jfc.setAccessory(ipv);
    for (int i = 0; i < filters.length; i++) {
      DBViewer.jfc.addChoosableFileFilter(filters[i]);
    }
    DBViewer.jfc.setFileFilter(filters[3]);

  }

  /**

   @return name of class
   */
  @Override
  public String toString() {
    return "" + getClass().getName() + "[]";
  }

  //<editor-fold defaultstate="collapsed" desc="comment">
  //  private static String getDetails() {
  //    String details = "";
  //    if(Panel4Mining.jRadioButton1.isSelected()) {
  //      details += " Double";
  //    }
  //    if(Panel4Mining.jRadioButton2.isSelected()) {
  //      details += " Accel";
  //    }
  //    if(Panel4Mining.jRadioButton5.isSelected()) {
  //      details += " Trojans";
  //    }
  //    if(Panel4Mining.jRadioButton6.isSelected()) {
  //      details += " Producing";
  //    }
  //    if(Panel4Mining.jRadioButton7.isSelected()) {
  //      details += " Rings";
  //    }
  //    details += " " + Panel4Mining.jComboBox9.getSelectedItem().toString();
  //    //System.out.print("details" + " = " +details);
  //    return details;
  //  }
  //</editor-fold>
  private static class Jumps {

    public Jumps() {
      JPanel p4j = new Panel4Jump("Jumps");
      JPanel p4l = new Panel4Locator();
      JPanel jp = new Panel4("Select SubSector");
      jp.setLayout(new BorderLayout());
      jp.add(p4l, BorderLayout.NORTH);
      jp.add(p4j, BorderLayout.CENTER);
      JFrame f4se = new Frame4(jp);
      f4se.getContentPane().add(p4l, BorderLayout.NORTH);
      f4se.setSize(new Dimension(f4se.getHeight() * 8 / 10, f4se.getHeight()));
    }
  }

  static void doMenu() {
    String selected = DBViewer.jComboBox1.getSelectedItem().toString();
    String[] arg = {DBViewer.jf.getTitle()};
    DBViewer.ok = true;
    switch (selected) {
      //<editor-fold defaultstate="collapsed" desc="About">
      case "About":
        DBViewer.jButton4.doClick();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="BAT">
      case "BAT":
        BAT();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="BitSet">
      case "bitset":
        Panel4SubSector.jButton5.doClick();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="World">
      case "world":
        Panel4SubSector.jButton6.doClick();
        break;
      //</editor-fold>
      //      //<editor-fold defaultstate="collapsed" desc="Blacken">
//      case "Blacken":
//        GlobalMethods.autoColor(DBViewer.getJf(), Color.black, Color.light_gray);
//        GlobalMethods.autoColor(DBViewer.jf, Color.black, Color.light_gray);
//        break;
//      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="BMP">
      case "BMP":
        CBView(dbviewer.globals.GlobalVariables.BMP);
        int ret = DBViewer.jfc.showSaveDialog(DBViewer.jComboBox1);
        if (JFileChooser.APPROVE_OPTION == ret) {
          //System.out.print("Save " + DBViewer.jfc.getSelectedFile().toString());
        }
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Boxer">
      case "Boxer":
        DBViewer.jButton6.doClick();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Brain">
      case "Brain":
        Brain();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Calc">
      case "Calc":
        DBViewer.jButton7.doClick();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Capture">
      case "Capture":
        Capture.main(arg);
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Catalogue">
      case "Catalogue":
        catalogue();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Backup">
      case "Backup":
        Backup();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Colour">
      case "Colour":
        Colour();
        break;
      //</editor-fold>

      //<editor-fold defaultstate="collapsed" desc="Conflict">
      case "Conflict":
        Panel4Conflict.main(args);
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Convert">
      case "Convert pic":
        Pic2Ext.main(arg);
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Counter">
      case "Counter":
        Counter(3, 3);
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="DBWork">
      case "DBWork":
        DBViewer.dbw = new DBWork();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="DBView">
      case "DBView":
        DBViewer.jButton1.doClick();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="DBP">
      case "DBP":
        DBP(arg[0]);
        break;
      //</editor-fold>

      //<editor-fold defaultstate="collapsed" desc="DirFile">
      case "DirFile":
        DirFile();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="D66">
      case "D66":
        D66();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Extensions">
      case "Extensions":
        FindExtensions.main(arg);
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Fonts">
      case "Fonts":
        Fonts();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Folder">
      case "Folder":
        DBViewer.jButton5.doClick();
        DBViewer.ok = DBViewer.folderWork(arg[0]);
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Frames">
      case "Frames":
        Frames();
        break;
      //</editor-fold>

      //<editor-fold defaultstate="collapsed" desc="FFW">
      case "FFW":
        FFW();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Greek">
      case "Greek":
        Panel4Chars.main(arg);
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="GridLayer">
      case "GridLayer":
        GridLayer();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Hex">
      case "Hex":
        Hex();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Hidden">
//      case "Hidden":
//        Hidden();
//        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Imports">
//      case "Imports":
//        Imports();
//        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Jumps">
//      case "Jumps":
//        Jumps();
//        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="MapXXX">
      case "MapImperium":
        Imperium();
        break;
//      case "MapSector":
//        Sector();
//        break;
//      case "MapSubSector":
//        SubSector();
//        break;
//      case "MapSystem":
//        System();
//        break;
//      case "MapPlanet":
//        Planet();
//        break;
//      case "MapStation":
//        Station();
//        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="MassCombat">
      case "MassCombat":
        MassCombat();
        break;
//      case "MapSector":
//        Sector();
//        break;
//      case "MapSubSector":
//        SubSector();
//        break;
//      case "MapSystem":
//        System();
//        break;
//      case "MapPlanet":
//        Planet();
//        break;
//      case "MapStation":
//        Station();
//        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Mining">
      case "Mining":
        Mining();
        break;
//      case "MapSector":
//        Sector();
//        break;
//      case "MapSubSector":
//        SubSector();
//        break;
//      case "MapSystem":
//        System();
//        break;
//      case "MapPlanet":
//        Planet();
//        break;
//      case "MapStation":
//        Station();
//        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="PCGen">
      case "PCGen":
        PCGen();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Piece">
      case "Piece":
        Piece();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="PrintSmall">
      case "PrintSmall": {
        dbviewer.globals.PrintSmall.main(new String[]{GlobalVariables.CSV + FS
          + DBViewer.jList1.getSelectedValue().toString()});
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Programs">
      case "Programs":
        Programs();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Reflect">
      case "Reflect":
        DBViewer.jButton3.doClick();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Robots">
      case "Robots":
        Robots.main(arg);
        //Robots.Regina(new Robot());
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Rotate">
      case "Rotate":
        JPanel ri = new Panel4Rotate();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Rules">
      case "Rules":
        Rules.main(arg);
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="ShowAll">
      case "ShowAll":
        _ShowCode.main(arg);//
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="ShowPanels">
      case "ShowPanels":
        _ShowPanels.main(arg);// _showPanels = new jtrav._ShowPanels();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Traveller">
      case "Traveller":
        Traveller.main(arg);
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="TXTView">
      case "TXTView":
        DBViewer.jButton2.doClick();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="UCP">
      case "UCP":
        UCP();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="UEP">
      case "UEP":
        UEP();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="UMP">
      case "UMP":
        UMP();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="USP">
      case "USP":
        USP();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="USqP">
      case "USqP":
        USqP();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Universe">
      case "Universe":
        Universe();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="updateSecs">
      case "updateSecs":
        updateSecs();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="updateSubs">
      case "updateSubs":
        updateSubs();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="updateWorlds">
      case "updateWorlds":
        updateWorlds();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="WordGen">
      case "WordGen":
        WordGen();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Worlds">
      case "Worlds":
        Worlds();
        break;
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="ZipOpen">
      case "ZipOpen":
        dbviewer.globals.ZipOpen.main(arg);
        break;
      //</editor-fold>
      default:
      //System.out.print("selected = " + selected);
    }

  }
}
