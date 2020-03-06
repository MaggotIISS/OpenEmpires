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
import static dbviewer.globals.GlobalVariables.T5;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

/**
 <p>
 @author maggot
 */
public class Panel4Neighbours extends Panel4 {

  /**
   neighbours
   */
  public static String[] neighbours = //<editor-fold defaultstate="collapsed" desc="neighbours">
    {
      "APMNBFEHD", "BMNOCGFEA", "CNOPDHGFB", "DOPMAEHGC",
      "EDABFJILH", "FABCGKJIE", "GBCDHLKJF", "HCDAEILKG",
      "IHEFJNMPL", "JEFGKONMI", "KFGHLPONJ", "LGHEIMPOK",
      "MLIJNBADP", "NIJKOCBAM", "OJKLPDCBN", "PKLIMADCO"
    }; //</editor-fold>
  /**
   outsec
   */
  public static String[] outsec = //<editor-fold defaultstate="collapsed" desc="out">
    {
      "12378", "123", "123", "12345",
      "178", "", "", "345",
      "178", "", "", "345",
      "15678", "567", "567", "34567"
    };
  /**
   outsub
   */
  public static String outsub = "12345678";
  //</editor-fold>
  /**

   */
  private static String[] corners = //<editor-fold defaultstate="collapsed" desc="corners">
    {"A", "D", "P", "M"};
  //</editor-fold>
  /**
   outside
   */
  public static String outside;
  private static String CRLF = dbviewer.globals.GlobalVariables.CRLF;
  private static String home;
  /**
   jta
   */
  public static JTextArea jta = new JTextArea();
  MouseEvent men;
  private String sub;
  String[] old;
  String[] now;
  String[] ott;
  String[] tt;
  int[] num;
  String mt;
  int[] mtnum;
  String inside;
  String outsidesec;
  String let;
  JTextArea[] jtxta;
  int[] dir;
  String sel;
  int pos;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    //DBViewer.main(args);
    JPanel jp = new Panel4Neighbours();
    JFrame jf = new Frame4(jp);
  }

  /**
   Creates new form Panel4Neighbours
   */
  public Panel4Neighbours() {
    initComponents();
    MouseAdapter ml;
    ml = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        //<editor-fold defaultstate="collapsed" desc="DEBUG">
        boolean DEBUG = false;
        if (DEBUG) { // true or false
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
            .getMethodName());
          //System.out.print("" + " = " + );
        }
//</editor-fold>
        pick(me.toString().substring(me.toString().length() - 1, me.toString()
          .length()));
        Panel4Locator.jcb4SubSector.setSelectedIndex(Panel4Locator.jcb4SubSector
          .getSelectedIndex());
      }

      /**
       <p>
       @param str the value of me
       */
      @SuppressWarnings("unchecked")
      public void pick(String str) {
        try {
          //<editor-fold defaultstate="collapsed" desc="DEBUG">
          boolean DEBUG = false;
          if (DEBUG) { // true or false
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
              .getMethodName());
            //System.out.print("" + " = " + );
          }
//</editor-fold>
          //String it = me.toString().substring(me.toString().length() - 1, me.toString().length());
          System.out.println("str = " + str);
          //<editor-fold defaultstate="collapsed" desc="switch">
          switch (str) {
            case "0": {
              jta = jTextArea0;
              break;
            }
            case "1": {
              jta = jTextArea1;
              break;
            }
            case "2": {
              jta = jTextArea2;
              break;
            }
            case "3": {
              jta = jTextArea3;
              break;
            }
            case "4": {
              jta = jTextArea4;
              break;
            }
            case "5": {
              jta = jTextArea5;
              break;
            }
            case "6": {
              jta = jTextArea6;
              break;
            }
            case "7": {
              jta = jTextArea7;
              break;
            }
            case "8": {
              jta = jTextArea8;
              break;
            }
          }
          //</editor-fold>
          String[] line = jta.getText().split(CRLF);
          String sec = GlobalMethods.capWords(line[1].toLowerCase());
          String subl = null;
          String subw;
          String sub = null;
          subl = GlobalMethods.capWords(line[0].toLowerCase());
          try {
            subw = GlobalMethods.capWords(line[2].toLowerCase());
          } catch (Exception e) {
            subw = "Unnamed";
          }
          sub = subl.substring(subl.length() - 1, subl.length()) + " - " + subw;
          System.out.println(sec);
          Panel4Locator.setSector(sec);
          try {
            Panel4Locator.setSubSector(sub, jta.getText());
            System.out.println(sub);
          } catch (Exception e) {
            System.out.println("p4n.196 e = " + e.toString());
          }
          DefaultListModel<String> dlm = new DefaultListModel<>();
          Panel4SubSector.jList2.setModel(dlm);
          hideInfo();
          Panel4Locator.setSubSector(sub, mt);
//        centreOn(str);
//        centredOn(sec, subl, subw);
          centredOn(Panel4Locator.getSectorName(),
            Panel4Locator.getSubSectorName(),
            jta.getText());
        } catch (Exception ex) {
          Logger.getLogger(Panel4Neighbours.class.getName()).log(Level.SEVERE,
            null, ex);
        }
      }

      private void centredOn(String sec, String sub, String text) {
        //<editor-fold defaultstate="collapsed" desc="DEBUG">
        boolean DEBUG = false;
        if (DEBUG) { // true or false
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
            .getMethodName());
          //System.out.println("" + " = " + );
        }
//</editor-fold>
        System.out.println(sec + "/" + sub);
        jta = jTextArea0;
        jta.setText(text);
        int count = 0;
        for (int i = 0; i < 9; i++) {
          //<editor-fold defaultstate="collapsed" desc="switch (i)">
          switch (i) {
            case 0: {
              jta = jTextArea0;
              break;
            }
            case 1: {
              jta = jTextArea1;
              break;
            }
            case 2: {
              jta = jTextArea2;
              break;
            }
            case 3: {
              jta = jTextArea3;
              break;
            }
            case 4: {
              jta = jTextArea4;
              break;
            }
            case 5: {
              jta = jTextArea5;
              break;
            }
            case 6: {
              jta = jTextArea6;
              break;
            }
            case 7: {
              jta = jTextArea7;
              break;
            }
            case 8: {
              jta = jTextArea8;
              break;
            }
          }
          jta.setText("");
          let = sub.substring(0, 1);
          //</editor-fold>
          //<editor-fold defaultstate="collapsed" desc="switch (let)">
          switch (let) {
            case "A": {
              mt = "APMNBFEHD";
              inside = "ABFE";
              outsidesec = "PMNHD";
              dir = new int[]{1, 2, 2, 8, 8};
              break;
            }
            case "B": {
              mt = "BMNOCGFEA";
              inside = "BCGFEA";
              outsidesec = "MNO";
              dir = new int[]{2, 2, 2};
              break;
            }
            case "C": {
              mt = "CNOPDHGFB";
              inside = "CDHGFB";
              outsidesec = "NOP";
              dir = new int[]{2, 2, 2};
              break;
            }
            case "D": {
              mt = "DOPMAEHGC";
              inside = "DHGC";
              outsidesec = "OPMAE";
              dir = new int[]{2, 2, 3, 4, 4};
              break;
            }
            case "E": {
              mt = "EDABFJILH";
              inside = "EABFJI";
              outsidesec = "DLH";
              dir = new int[]{8, 8, 8};
              break;
            }
            case "F": {
              mt = "FABCGKJIE";
              inside = "FABCGKJIE";
              outsidesec = "";
              dir = new int[]{0};
              break;
            }
            case "G": {
              mt = "GBCDHLKJF";
              inside = "GBCDHLKJF";
              outsidesec = "";
              dir = new int[]{0};
              break;
            }
            case "H": {
              mt = "HCDAEILKG";
              inside = "HCDLKG";
              outsidesec = "AEI";
              dir = new int[]{4, 4, 4};
              break;
            }
            case "I": {
              mt = "IHEFJNMPL";
              inside = "IEFJNM";
              outsidesec = "HPL";
              dir = new int[]{8, 8, 8};
              break;
            }
            case "J": {
              mt = "JEFGKONMI";
              inside = "JEFGKONMI";
              outsidesec = "";
              dir = new int[]{0};
              break;
            }
            case "K": {
              mt = "KFGHLPONJ";
              inside = "KFGHLPONJ";
              outsidesec = "";
              dir = new int[]{0};
              break;
            }
            case "L": {
              mt = "LGHEIMPOK";
              inside = "LGHPOK";
              outsidesec = "EIM";
              dir = new int[]{4, 4, 4};
              break;
            }
            case "M": {
              mt = "MLIJNBADP";
              inside = "MIJN";
              outsidesec = "LBADP";
              dir = new int[]{6, 6, 7, 8, 8};
              break;
            }
            case "N": {
              mt = "NIJKOCBAM";
              inside = "NIJKOM";
              outsidesec = "CBA";
              dir = new int[]{6, 6, 6};
              break;
            }
            case "O": {
              mt = "OJKLPDCBN";
              inside = "OJKLPN";
              outsidesec = "DCB";
              dir = new int[]{6, 6, 6};
              break;
            }
            case "P": {
              mt = "PKLIMADCO";
              inside = "PKLO";
              outsidesec = "IMADC";
              dir = new int[]{4, 4, 5, 6, 6};
              break;
            }
          }
          //</editor-fold>
          System.out.println("SubSector " + mt.substring(i, i + 1));
          jta.setText("SubSector " + mt.substring(i, i + 1) + CRLF);
          if (inside.contains(mt.substring(i, i + 1))) {
            try {
              jta.setBackground(Color.CYAN);
              jta.append(Panel4Locator.getSectorName().toUpperCase() + CRLF);
            } catch (Exception ex) {
              Logger.getLogger(Panel4Neighbours.class.getName()).log(
                Level.SEVERE, null, ex);
            }
          } else {
            jta.setBackground(Color.BLACK);
            count += 1;
            jta.append(getSector(i, let, count, Panel4Locator.getXnum(),
              Panel4Locator.getYnum()) + CRLF);
          }
          jta.append(getSub(jta.getText()) + CRLF);
          jta.append(GlobalMethods.comment("-", 14));
          jta.append(addWorlds(jta));
        }
      }

      /**
       <p>
       @param panel the value of i
       @param xnum  the value of xnum
       @param ynum  the value of ynum
       */
      private String getSector(int panel, String l, int count, JLabel xnum,
        JLabel ynum) {
        int x = 0, y = 0;
        String s = "";
        x = Integer.parseInt(xnum.getText());
        y = Integer.parseInt(ynum.getText());
        //<editor-fold defaultstate="collapsed" desc="switch (count[i-1])">
        switch (dir[count - 1]) {
          case 0: {
            break;
          }
          case 1: {
            x -= 1;
            y += 1;
            break;
          }
          case 2: {
            y += 1;
            break;
          }
          case 3: {
            x += 1;
            y += 1;
            break;
          }
          case 4: {
            x += 1;
            break;
          }
          case 5: {
            x += 1;
            y -= 1;
            break;
          }
          case 6: {
            y -= 1;
            break;
          }
          case 7: {
            x -= 1;
            y -= 1;
            break;
          }
          case 8: {
            x -= 1;
            break;
          }
        }
        //</editor-fold>
        s = "x=" + x + ", y=" + y + CRLF;
        System.out.println("s = " + s);
        //<editor-fold defaultstate="collapsed" desc="DEBUG">
        boolean DEBUG = false;
        if (DEBUG) { // true or false
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
            .getMethodName());
          System.out.println("panel" + " = " + panel);
          System.out.println("dir[count - 1]" + " = " + dir[count - 1]);
//          System.out.println("dir[panel]" + " = " + dir[panel]);
          System.out.println("dir.length = " + dir.length);
        }
//</editor-fold>
        return getSectorName(x, y);
      }

      /**
       <p>
       @param x the value of s
       @param y the value of y
       */
      private String getSectorName(int x, int y) {
        //<editor-fold defaultstate="collapsed" desc="DEBUG">
        boolean DEBUG = false;
        if (DEBUG) { // true or false
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
            .getMethodName());
          //System.out.println("" + " = " + );
        }
//</editor-fold>
        File f = new File(T5 + "/CSV/uwp-sector");
        String[] lines = GlobalMethods.getLinesFromFile(f);
        String[] parts = null;
        for (int i = 1; i < lines.length; i++) {
          parts = lines[i].replace("\"", "").split(",");
          if ((Integer.parseInt(parts[2]) == x) & (Integer.parseInt(parts[3])
            == y)) {
            return parts[0].toUpperCase();
          }
        }
        return null;
      }

      private String getSub(String text) {
        //<editor-fold defaultstate="collapsed" desc="DEBUG">
        boolean DEBUG = false;
        if (DEBUG) { // true or false
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
            .getMethodName());
          //System.out.println("" + " = " + );
        }
//</editor-fold>
        File f = new File(T5 + "/CSV/uwp-subsec");
        String[] lines = GlobalMethods.getLinesFromFile(f);
        String[] parts;
        String[] texts = text.split(CRLF);
        String sec = texts[1];
        String sub = texts[0]
          .substring(texts[0].length() - 1, texts[0].length());
        for (int i = 1; i < lines.length; i++) {
          parts = lines[i].toUpperCase().replace("\"", "").split(",");
          if (sec.equals(parts[1].toUpperCase()) & sub.equals(parts[2]
            .toUpperCase())) {
            return parts[0].toUpperCase();
          }
        }
        return null;
      }

      private String addWorlds(JTextArea jta) {
        //<editor-fold defaultstate="collapsed" desc="DEBUG">
        boolean DEBUG = false;
        if (DEBUG) { // true or false
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
            .getMethodName());
          //System.out.println("" + " = " + );
        }
//</editor-fold>
        File f = new File(T5 + "/CSV/uwp-worlds");
        String[] lines = GlobalMethods.getLinesFromFile(f);
        String[] parts;
        String[] texts = jta.getText().split(CRLF);
        String sub = texts[0]
          .substring(texts[0].length() - 1, texts[0].length());
        String sec = texts[1];
        String txt = "";
        for (int i = 1; i < lines.length; i++) {
          parts = lines[i].toUpperCase().replace("\"", "").split(",");
          if (sec.equals(parts[7].toUpperCase()) & sub.equals(parts[8]
            .toUpperCase())) {
            txt += parts[1] + "-" + GlobalMethods.capWords(parts[0]) + CRLF;
          }
        }
        return txt;
      }
    };

    for (int i = 0; i < 9; i++) {
      //<editor-fold defaultstate="collapsed" desc="switch">
      switch (i) {
        case 0: {
          jta = jTextArea0;
          break;
        }
        case 1: {
          jta = jTextArea1;
          break;
        }
        case 2: {
          jta = jTextArea2;
          break;
        }
        case 3: {
          jta = jTextArea3;
          break;
        }
        case 4: {
          jta = jTextArea4;
          break;
        }
        case 5: {
          jta = jTextArea5;
          break;
        }
        case 6: {
          jta = jTextArea6;
          break;
        }
        case 7: {
          jta = jTextArea7;
          break;
        }
        case 8: {
          jta = jTextArea8;
          break;
        }
      }
      //</editor-fold>
      jta.setName("" + i);
      jta.addMouseListener(ml);
    }
  }

  static void select(String me) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.print("" + " = " + );
    }
//</editor-fold>
    //String it = me.toString().substring(me.toString().length() - 1, me.toString().length());
    System.out.println("me = " + me);
    //<editor-fold defaultstate="collapsed" desc="switch (me)">
    switch (me) {
      case "0": {
        jta = jTextArea0;
        break;
      }
      case "1": {
        jta = jTextArea1;
        break;
      }
      case "2": {
        jta = jTextArea2;
        break;
      }
      case "3": {
        jta = jTextArea3;
        break;
      }
      case "4": {
        jta = jTextArea4;
        break;
      }
      case "5": {
        jta = jTextArea5;
        break;
      }
      case "6": {
        jta = jTextArea6;
        break;
      }
      case "7": {
        jta = jTextArea7;
        break;
      }
      case "8": {
        jta = jTextArea8;
        break;
      }
    }
    //</editor-fold>
    String[] line = jta.getText().split(CRLF);
    String sec = GlobalMethods.capWords(line[1].toLowerCase());
    String subl = null;
    String subw = null;
    String sub = null;
    subl = GlobalMethods.capWords(line[0].toLowerCase());
    try {
      subw = GlobalMethods.capWords(line[2].toLowerCase());
    } catch (Exception e) {
      subw = "Unnamed";
    }
    sub = subl.substring(subl.length() - 1, subl.length()) + " - " + subw;
    System.out.println(sec);
    Panel4Locator.setSector(sec);
    try {
      Panel4Locator.setSubSector(sub, jta.getText());
      System.out.println(sub);
    } catch (Exception e) {
      System.out.println("138 " + e.toString());
    }
    jta.setToolTipText(line[1] + "/" + line[2]);
  }

  //<editor-fold defaultstate="collapsed" desc="comment">
  //  private void centreOn(String str) {
  //    //<editor-fold defaultstate="collapsed" desc="DEBUG">
  //    boolean DEBUG = false;
  //    if (DEBUG) { // true or false
  //      System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
  //      //System.out.print("" + " = " + );
  //    }
  ////</editor-fold>
  //    old = new String[25];
  //    now = new String[9];
  //    ott = new String[9];
  //    tt = new String[9];
  //    num = new int[9];
  //    mt = "";
  //    mtnum = new int[25];
  //    jtxta = new JTextArea[]{
  //      jTextArea0, jTextArea1, jTextArea2, jTextArea3, jTextArea4,
  //      jTextArea5, jTextArea6, jTextArea7, jTextArea8
  //    };
  //    //<editor-fold defaultstate="collapsed" desc="switch (str)">
  //    switch (str) {
  //      case "0": {
  //        //Already there
  //        num = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
  //        mtnum = new int[]{};
  //        break;
  //      }
  //      case "1": {
  //        num = new int[]{1, 9, 10, 11, 2, 0, 8, 23, 24};
  //        mtnum = new int[]{1, 2, 3, 7, 8};
  //        break;
  //      }
  //      case "2": {
  //        num = new int[]{2, 10, 11, 12, 3, 4, 0, 8, 1};
  //        mtnum = new int[]{1, 2, 3};
  //        break;
  //      }
  //      case "3": {
  //        num = new int[]{3, 12, 12, 13, 14, 15, 4, 0, 2};
  //        mtnum = new int[]{1, 2, 3, 4, 5};
  //        break;
  //      }
  //      case "4": {
  //        num = new int[]{4, 2, 3, 14, 15, 16, 5, 6, 0};
  //        mtnum = new int[]{3, 4, 5};
  //        break;
  //      }
  //      case "5": {
  //        num = new int[]{5, 0, 4, 15, 16, 17, 18, 19, 6};
  //        mtnum = new int[]{3, 4, 5, 6, 7};
  //        break;
  //      }
  //      case "6": {
  //        num = new int[]{6, 8, 0, 4, 5, 18, 19, 20, 7};
  //        mtnum = new int[]{5, 6, 7};
  //        break;
  //      }
  //      case "7": {
  //        num = new int[]{7, 23, 8, 0, 6, 19, 20, 21, 22};
  //        mtnum = new int[]{1, 5, 6, 7, 8};
  //        break;
  //      }
  //      case "8": {
  //        num = new int[]{8, 24, 1, 2, 0, 6, 7, 22, 23};
  //        mtnum = new int[]{1, 7, 8};
  //        break;
  //      }
  //    }
  //    //</editor-fold>
  //    for (int i = 0; i < jtxta.length; i++) {
  //      old[i] = jtxta[i].getText();
  //      ott[i] = jtxta[i].getToolTipText();
  //    }
  //    for (int i = 0; i < jtxta.length; i++) {
  //      now[i] = old[num[i]];
  //      jtxta[i].setText(now[i]);
  //      jtxta[i].setToolTipText(ott[i]);
  //    }
  //    sub = Panel4Locator.getSubSector().substring(0, 1);
  //    System.out.println("sub = " + sub);
  //    for (int i = 0; i < mtnum.length; i++) {
  //      //<editor-fold defaultstate="collapsed" desc="switch(sub)">
  //      switch (sub) {
  //        case "A": {
  //          mt = "APMNBFEHD";
  //          inside = "ABFE";
  //          outsidesec = "PMNHD";
  //          beyond = "";
  //          break;
  //        }
  //        case "B": {
  //          mt = "BMNOCGFEA";
  //          inside = "BCGFEA";
  //          outsidesec = "MNO";
  //          beyond = "";
  //          break;
  //        }
  //        case "C": {
  //          mt = "CNOPDHGFB";
  //          inside = "CDHGFB";
  //          outsidesec = "NOP";
  //          beyond = "";
  //          break;
  //        }
  //        case "D": {
  //          mt = "DOPMAEHGC";
  //          inside = "DHGC";
  //          outsidesec = "OPMAE";
  //          beyond = "";
  //          break;
  //        }
  //        case "E": {
  //          mt = "EDABFJILH";
  //          inside = "EABFJI";
  //          outsidesec = "DLH";
  //          beyond = "";
  //          break;
  //        }
  //        case "F": {
  //          mt = "FABCGKJIE";
  //          inside = "FABCGKJIE";
  //          outsidesec = "";
  //          beyond = "";
  //          break;
  //        }
  //        case "G": {
  //          mt = "GBCDHLKJF";
  //          inside = "GBCDHLKJF";
  //          outsidesec = "";
  //          beyond = "";
  //          break;
  //        }
  //        case "H": {
  //          mt = "HCDAEILKG";
  //          inside = "HCDLKG";
  //          outsidesec = "AEI";
  //          beyond = "";
  //          break;
  //        }
  //        case "I": {
  //          mt = "IHEFJNMPL";
  //          inside = "IEFJNM";
  //          outsidesec = "HPL";
  //          beyond = "";
  //          break;
  //        }
  //        case "J": {
  //          mt = "JEFGKONMI";
  //          inside = "JEFGKONMI";
  //          outsidesec = "";
  //          beyond = "";
  //          break;
  //        }
  //        case "K": {
  //          mt = "KFGHLPONJ";
  //          inside = "KFGHLPONJ";
  //          outsidesec = "";
  //          beyond = "";
  //          break;
  //        }
  //        case "L": {
  //          mt = "LGHEIMPOK";
  //          inside = "LGHPOK";
  //          outsidesec = "EIM";
  //          beyond = "";
  //          break;
  //        }
  //        case "M": {
  //          mt = "MLIJNBADP";
  //          inside = "MIJN";
  //          outsidesec = "LBADP";
  //          beyond = "";
  //          break;
  //        }
  //        case "N": {
  //          mt = "NIJKOCBAM";
  //          inside = "NIJKOM";
  //          outsidesec = "CBA";
  //          beyond = "";
  //          break;
  //        }
  //        case "O": {
  //          mt = "OJKLPDCBN";
  //          inside = "OJKLPN";
  //          outsidesec = "DCB";
  //          beyond = "";
  //          break;
  //        }
  //        case "P": {
  //          mt = "PKLIMADCO";
  //          inside = "PKLO";
  //          outsidesec = "IMADC";
  //          beyond = "";
  //          break;
  //        }
  //      }
  //      //</editor-fold>
  //      String txt = "";
  //      if (i < mtnum.length) {
  //        txt = mt.substring(mtnum[i], mtnum[i] + 1);
  //      } else {
  //        txt = mt.substring(mtnum[i]);
  //      }
  //      txt = "SubSector " + txt + CRLF;
  //      jtxta[mtnum[i]].setText(txt);
  //
  //    }
  //    for (int i = 0; i < 9; i++) {
  //      String[] lines = jtxta[i].getText().split(CRLF);
  //      System.out.println("SubSector Letter = " + lines[0].substring(lines[0].length() - 1));
  //      for (int j = 0; j < inside.length(); j++) {
  //        if (j < inside.length() - 1) {
  //          if (jtxta[i].getText().contains("SubSector " + inside.substring(j, j + 1) + CRLF)) {
  //            jtxta[i].setBackground(Color.CYAN);
  //          }
  //        } else {
  //          if (jtxta[i].getText().contains("SubSector " + inside.substring(j))) {
  //            jtxta[i].setBackground(Color.CYAN);
  //          }
  //        }
  //        if (lines.length == 1 & lines[0].contains(
  //                "SubSector " + inside.substring(j, j + 1))
  //                & (!outsidesec.contains(
  //                lines[0].substring(lines[0].length() - 2)))) {
  //          jtxta[i].append(Panel4Locator.getSectorName().toUpperCase() + CRLF);
  //        }
  //        System.out.println("lines.length = " + lines.length);
  //      }
  ////      for (int j = 0; j < outside.length(); j++) {
  ////        if (j < outside.length() - 1) {
  ////          if (jtxta[i].getText().contains("SubSector " + outside.substring(j, j + 1) + CRLF)) {
  ////            jtxta[i].setBackground(Color.BLUE);
  ////          }
  ////        } else {
  ////          if (jtxta[i].getText().contains("SubSector " + outside.substring(j))) {
  ////            jtxta[i].setBackground(Color.BLUE);
  ////          }
  ////        }
  ////        if (lines.length == 1 & lines[0].contains(
  ////                "SubSector " + outside.substring(j, j + 1))
  ////                & (!outsidesec.contains(
  ////                lines[0].substring(lines[0].length() - 2)))) {
  ////          jtxta[i].append(Panel4Locator.getSectorName().toUpperCase() + CRLF);
  ////        }
  ////        System.out.println("lines.length = " + lines.length);
  ////      }
  //      jtxta[i].setBackground(Color.BLACK);
  //      if (jtxta[i].getText().toUpperCase().contains(
  //              Panel4Locator.getSectorName().toUpperCase())) {
  //        jtxta[i].setBackground(Color.CYAN);
  //      }
  //      System.out.println("inside = " + inside);
  //      System.out.println("outsidesec = " + outsidesec);
  //      if (jtxta[i].getText().split(CRLF).length < 3) {
  //        for (int j = 0; j < Panel4Locator.jcb4SubSector.getModel().getSize(); j++) {
  //          String let = Panel4Locator.jcb4SubSector.getModel().getElementAt(j).toString().substring(0, 1);
  //          if (Panel4Locator.jcb4SubSector.getModel().getElementAt(j).toString().startsWith(let)) {
  //            System.out.println("let = " + let);
  //            Panel4Locator.jcb4SubSector.setSelectedIndex(j);
  //            break;
  //          }
  //        }
  //      }
  //
  //
  //
  //
  //
  //
  //    }
  //  }
  //</editor-fold>
  static void hideInfo() {
    //<editor-fold defaultstate="collapsed" desc="hide">
    Panel4SubSector.UWP.setForeground(Color.BLACK);
    Panel4SubSector.jcb4StarPort.setForeground(Color.BLACK);
    Panel4SubSector.jcb4Size.setForeground(Color.BLACK);
    Panel4SubSector.jcb4Atmos.setForeground(Color.BLACK);
    Panel4SubSector.jcb4Hydros.setForeground(Color.BLACK);
    Panel4SubSector.jcb4Pop.setForeground(Color.BLACK);
    Panel4SubSector.jcb4Govt.setForeground(Color.BLACK);
    Panel4SubSector.jcb4Law.setForeground(Color.BLACK);
    Panel4SubSector.jcb4Tech.setForeground(Color.BLACK);
    JComboBox jcb = null;
    for (int i = 1; i < 19; i++) {
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
      jcb.setForeground(Color.BLACK);
    }
    //</editor-fold>
  }

  static void showInfo() {
    //<editor-fold defaultstate="collapsed" desc="show">
    Panel4SubSector.UWP.setForeground(Color.lightGray);
    Panel4SubSector.jcb4StarPort.setForeground(Color.lightGray);
    Panel4SubSector.jcb4Size.setForeground(Color.lightGray);
    Panel4SubSector.jcb4Atmos.setForeground(Color.lightGray);
    Panel4SubSector.jcb4Hydros.setForeground(Color.lightGray);
    Panel4SubSector.jcb4Pop.setForeground(Color.lightGray);
    Panel4SubSector.jcb4Govt.setForeground(Color.lightGray);
    Panel4SubSector.jcb4Law.setForeground(Color.lightGray);
    Panel4SubSector.jcb4Tech.setForeground(Color.lightGray);
    JComboBox jcb = null;
    for (int i = 1; i < 19; i++) {
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
      jcb.setForeground(Color.lightGray);
    }
    //</editor-fold>
  }

  private static String findNeighbourNames(boolean sector, int i, String x,
    String y) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.print("" + " = " + );
    }
//</editor-fold>
    Dimension MM = new Dimension(Integer.parseInt(x), Integer.parseInt(y));
    Dimension LT;
    Dimension MT;
    Dimension RT;
    Dimension LM;
    Dimension RM;
    Dimension LB;
    Dimension MB;
    Dimension RB;

    LT = new Dimension(-1, 1);
    MT = new Dimension(0, 1);
    RT = new Dimension(1, 1);
    LM = new Dimension(-1, 0);
    RM = new Dimension(1, 0);
    LB = new Dimension(-1, -1);
    MB = new Dimension(0, -1);
    RB = new Dimension(1, -1);

    LT.setSize(MM.width + LT.width, MM.height + LT.height);
    MT.setSize(MM.width + MT.width, MM.height + MT.height);
    RT.setSize(MM.width + RT.width, MM.height + RT.height);
    LM.setSize(MM.width + LM.width, MM.height + LM.height);
    RM.setSize(MM.width + RM.width, MM.height + RM.height);
    LB.setSize(MM.width + LB.width, MM.height + LB.height);
    MB.setSize(MM.width + MB.width, MM.height + MB.height);
    RB.setSize(MM.width + RB.width, MM.height + RB.height);
    Dimension[] dims;
    dims = new Dimension[]{MM, LT, MT, RT, LM, RM, LB, MB, RB};
    //System.out.print("Panel " + i + " = ");
    File sec = new File(T5 + "/CSV/uwp-sector");
    File sub = new File(T5 + "/CSV/uwp-subsec");
    File f = null;
    if (sector == true) {
      f = sec;
    } else if (sector == false) {
      f = sub;
    }
    String line;
    String[] lines = new String[dbviewer.globals.GlobalMethods.countLines(f)];
    String[] parts = null;
    int num = 1;
    try {
      BufferedReader in = new BufferedReader(new FileReader(sec));
      try {
        line = in.readLine();
        while ((line = in.readLine()) != null) {
          lines[num++] = line;
          parts = line.split("\",\"");
          parts[0] = parts[0].substring(1);
          parts[parts.length - 1] = parts[parts.length - 1].substring(0,
            parts[parts.length - 1].length());
          if ((parts[2].equals(x)) & (parts[3].equals(y))) {
//              //System.out.print("NOT IN " + parts[0]);
            Dimension dim = new Dimension(MM);
            //System.out.print("boolean sector = " + sector);
            if (sector == true) {
              switch (i) {
                case 0:
                  dim = MM;//new Dimension(MM);
                  break;
                case 1:
                  dim = LT;//new Dimension(LT);
                  break;
                case 2:
                  dim = MT;//new Dimension(MT);
                  break;
                case 3:
                  dim = RT;//new Dimension(RT);
                  break;
                case 4:
                  dim = RM;//new Dimension(RM);
                  break;
                case 5:
                  dim = RB;//new Dimension(RB);
                  break;
                case 6:
                  dim = MB;//new Dimension(MB);
                  break;
                case 7:
                  dim = LB;//new Dimension(LB);
                  break;
                case 8:
                  dim = LM;//new Dimension(LM);
                  break;
              }
              //System.out.print(Panel4Locator.findSector(dim.width, dim.height));
              return (Panel4Locator.findSector(dim.width, dim.height));
            } else { // search for subsectors
              switch (i) {
                case 0:
                  dim = MM;//new Dimension(MM);
                  break;
                case 1:
                  dim = LT;//new Dimension(LT);
                  break;
                case 2:
                  dim = MT;//new Dimension(MT);
                  break;
                case 3:
                  dim = RT;//new Dimension(RT);
                  break;
                case 4:
                  dim = RM;//new Dimension(RM);
                  break;
                case 5:
                  dim = RB;//new Dimension(RB);
                  break;
                case 6:
                  dim = MB;//new Dimension(MB);
                  break;
                case 7:
                  dim = LB;//new Dimension(LB);
                  break;
                case 8:
                  dim = LM;//new Dimension(LM);
                  break;
              }
              //System.out.print(Panel4Locator.findSector(dim.width, dim.height));
              return (Panel4Locator.findSector(dim.width, dim.height));
            }
          }
        }
        in.close();

      } catch (IOException ex) {
        Logger.getLogger(Panel4Neighbours.class
          .getName()).log(Level.SEVERE, null, ex);
      }

    } catch (FileNotFoundException ex) {
      Logger.getLogger(Panel4Neighbours.class
        .getName()).log(Level.SEVERE, null, ex);
    }
    return parts[0];
  }

  /**
   <p>
   @param sec    sector name from table
   @param sub    subsector name from table
   @param sys    system name from table
   @param sector boolean true=sector, false=subsector
   */
  public static void centreOnRectangle(String sec, String sub, String sys,
    boolean sector) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    //System.out.print("sector" + " = " + sector);
    //System.out.print("sec" + " = " + sec);
    //System.out.print("sub" + " = " + sub);
    //System.out.print("sys" + " = " + sys);

    char letter[];
    if (sub != "") {
      letter = sub.substring(0, 1).toCharArray();
      int num;
      num = letter[0] - 65;//ASCII (utf-8?) = 'A'
      home = neighbours[num];//letter of Middle Middle jta[0]
      JTextArea jta = null;
      int panel = 9;
      for (int i = 0; i < panel; i++) {
        switch (i) {
          case 0:
            jta = jTextArea0;
            break;
          case 1:
            jta = jTextArea1;
            break;
          case 2:
            jta = jTextArea2;
            break;
          case 3:
            jta = jTextArea3;
            break;
          case 4:
            jta = jTextArea4;
            break;
          case 5:
            jta = jTextArea5;
            break;
          case 6:
            jta = jTextArea6;
            break;
          case 7:
            jta = jTextArea7;
            break;
          case 8:
            jta = jTextArea8;
            break;
        }
        //if (sector==true) {
        if (i < 8) {
          jta.setText("SubSector " + home.substring(i, i + 1) + CRLF);
        } else {
          jta.setText("SubSector " + home.substring(i) + CRLF);
        }
        //}
        if (sector == false) {
          outside = outsec[num];//indices of outside sectors
        } else if (sector == true) {
          outside = outsub;
        }
        //true if box is outside
        //System.out.print("isOutside(" + sector + ", outside, (\"\" + " + i + "))" + " = " + isOutside(sector, outside, ("" + i)));
        if (isOutside(sector, outside, ("" + i))) {
          String name;
          name = findNeighbourNames(sector == true, i, Panel4Locator.getXnum()
            .getText(), Panel4Locator.getYnum().getText());
          if (sector == true) {
            jta.append(name + CRLF);
          }
          if (sector == false) {  //recalculate sector names before placing
            switch (sub.substring(0, 1)) {//NOTIFY WHICH PANELS ARE OUTSIDE AND NEED CHANGING TO WHAT
              case "A": //3=2,7=8
                if (i == 3) {
                  name = findNeighbourNames(sector,
                    2, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                if (i == 7) {
                  name = findNeighbourNames(sector,
                    8, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                break;
              case "B": //1=2,3=2
                if (i == 1) {
                  name = findNeighbourNames(sector,
                    2, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                if (i == 3) {
                  name = findNeighbourNames(sector,
                    2, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                break;
              case "C": //1=2,3=2
                if (i == 1) {
                  name = findNeighbourNames(sector,
                    2, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                if (i == 3) {
                  name = findNeighbourNames(sector,
                    2, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                break;
              case "D": //1=2,5=4
                if (i == 1) {
                  name = findNeighbourNames(sector,
                    2, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                if (i == 5) {
                  name = findNeighbourNames(sector,
                    4, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                break;
              case "E": //1=8,7=8
                if (i == 1) {
                  name = findNeighbourNames(sector,
                    8, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                if (i == 7) {
                  name = findNeighbourNames(sector,
                    8, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                break;
              case "F": //OK
                break;
              case "G": //OK
                break;
              case "H": //3=4,5=4
                if (i == 3) {
                  name = findNeighbourNames(sector,
                    4, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                if (i == 5) {
                  name = findNeighbourNames(sector,
                    4, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                break;
              case "I": //1=8,7=8
                if (i == 1) {
                  name = findNeighbourNames(sector,
                    8, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                if (i == 7) {
                  name = findNeighbourNames(sector,
                    8, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                break;
              case "J": //OK
                break;
              case "K": //OK
                break;
              case "L": //3=4,5=4
                if (i == 3) {
                  name = findNeighbourNames(sector,
                    4, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                if (i == 5) {
                  name = findNeighbourNames(sector,
                    4, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                break;
              case "M": //1=8,5=6
                if (i == 1) {
                  name = findNeighbourNames(sector,
                    8, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                if (i == 5) {
                  name = findNeighbourNames(sector,
                    6, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                break;
              case "N": //5=6,7=6
                if (i == 5) {
                  name = findNeighbourNames(sector,
                    6, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                if (i == 7) {
                  name = findNeighbourNames(sector,
                    6, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                break;
              case "O": //5=6,7=6
                if (i == 5) {
                  name = findNeighbourNames(sector,
                    6, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                if (i == 7) {
                  name = findNeighbourNames(sector,
                    6, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                break;
              case "P": //3=4,7=6
                if (i == 3) {
                  name = findNeighbourNames(sector,
                    4, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                if (i == 7) {
                  name = findNeighbourNames(sector,
                    6, Panel4Locator.getXnum().getText(),
                    Panel4Locator.getYnum().getText());
                }
                break;
            }
            jta.append(name + CRLF);
          }
        } else if (!isOutside(sector, outside, ("" + i))) {
          jta.append(Panel4Locator.getSector() + CRLF);
          jta.setBackground(Color.CYAN);
        }
      }
    }
  }

  /**
   <p>
   @param sector  boolean or subsector
   @param outside outside of sector
   @param home    string to search
   @return true if outside, false otherwise
   */
  public static boolean isOutside(boolean sector, String outside, String home) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    if (sector == false) {
      if (outside.contains(home)) {
        return true;
      }
    } else {
      return true;
    }
    return false;
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
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jPanel2 = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTextArea2 = new javax.swing.JTextArea();
    jPanel3 = new javax.swing.JPanel();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTextArea3 = new javax.swing.JTextArea();
    jPanel8 = new javax.swing.JPanel();
    jScrollPane8 = new javax.swing.JScrollPane();
    jTextArea8 = new javax.swing.JTextArea();
    jPanel0 = new javax.swing.JPanel();
    jScrollPane0 = new javax.swing.JScrollPane();
    jTextArea0 = new javax.swing.JTextArea();
    jPanel4 = new javax.swing.JPanel();
    jScrollPane4 = new javax.swing.JScrollPane();
    jTextArea4 = new javax.swing.JTextArea();
    jPanel7 = new javax.swing.JPanel();
    jScrollPane7 = new javax.swing.JScrollPane();
    jTextArea7 = new javax.swing.JTextArea();
    jPanel6 = new javax.swing.JPanel();
    jScrollPane6 = new javax.swing.JScrollPane();
    jTextArea6 = new javax.swing.JTextArea();
    jPanel5 = new javax.swing.JPanel();
    jScrollPane5 = new javax.swing.JScrollPane();
    jTextArea5 = new javax.swing.JTextArea();

    setLayout(new java.awt.GridLayout(3, 3));

    jPanel1.setForeground(java.awt.Color.lightGray);
    jPanel1.setToolTipText("1");
    jPanel1.setOpaque(false);

    jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
    jTextArea1.setColumns(5);
    jTextArea1.setForeground(java.awt.Color.lightGray);
    jTextArea1.setRows(5);
    jTextArea1.setToolTipText("1");
    jTextArea1.setFocusCycleRoot(true);
    jTextArea1.setName("1"); // NOI18N
    jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextAreaMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jTextAreaMouseEntered(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jTextAreaMousePressed(evt);
      }
    });
    jScrollPane1.setViewportView(jTextArea1);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
    );

    add(jPanel1);

    jPanel2.setForeground(java.awt.Color.lightGray);
    jPanel2.setToolTipText("2");
    jPanel2.setOpaque(false);

    jTextArea2.setBackground(new java.awt.Color(0, 0, 0));
    jTextArea2.setColumns(5);
    jTextArea2.setForeground(java.awt.Color.lightGray);
    jTextArea2.setRows(5);
    jTextArea2.setToolTipText("2");
    jTextArea2.setFocusCycleRoot(true);
    jTextArea2.setName("2"); // NOI18N
    jTextArea2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextAreaMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jTextAreaMouseEntered(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jTextAreaMousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        jTextAreaMouseReleased(evt);
      }
    });
    jScrollPane2.setViewportView(jTextArea2);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
    );

    add(jPanel2);

    jPanel3.setForeground(java.awt.Color.lightGray);
    jPanel3.setToolTipText("3");
    jPanel3.setOpaque(false);

    jTextArea3.setBackground(new java.awt.Color(0, 0, 0));
    jTextArea3.setColumns(5);
    jTextArea3.setForeground(java.awt.Color.lightGray);
    jTextArea3.setRows(5);
    jTextArea3.setToolTipText("3");
    jTextArea3.setFocusCycleRoot(true);
    jTextArea3.setName("3"); // NOI18N
    jTextArea3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jTextAreaMouseEntered(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jTextAreaMousePressed(evt);
      }
    });
    jScrollPane3.setViewportView(jTextArea3);

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
    );

    add(jPanel3);

    jPanel8.setForeground(java.awt.Color.lightGray);
    jPanel8.setToolTipText("8");
    jPanel8.setOpaque(false);

    jTextArea8.setBackground(new java.awt.Color(0, 0, 0));
    jTextArea8.setColumns(5);
    jTextArea8.setForeground(java.awt.Color.lightGray);
    jTextArea8.setRows(5);
    jTextArea8.setToolTipText("8");
    jTextArea8.setFocusCycleRoot(true);
    jTextArea8.setName("8"); // NOI18N
    jTextArea8.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextAreaMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jTextAreaMouseEntered(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jTextAreaMousePressed(evt);
      }
    });
    jScrollPane8.setViewportView(jTextArea8);

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
    );
    jPanel8Layout.setVerticalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
    );

    add(jPanel8);

    jPanel0.setForeground(java.awt.Color.lightGray);
    jPanel0.setOpaque(false);

    jTextArea0.setBackground(new java.awt.Color(0, 0, 0));
    jTextArea0.setColumns(5);
    jTextArea0.setForeground(java.awt.Color.lightGray);
    jTextArea0.setRows(5);
    jTextArea0.setToolTipText("0");
    jTextArea0.setFocusCycleRoot(true);
    jTextArea0.setName("0"); // NOI18N
    jTextArea0.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextAreaMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jTextAreaMouseEntered(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jTextAreaMousePressed(evt);
      }
    });
    jScrollPane0.setViewportView(jTextArea0);

    javax.swing.GroupLayout jPanel0Layout = new javax.swing.GroupLayout(jPanel0);
    jPanel0.setLayout(jPanel0Layout);
    jPanel0Layout.setHorizontalGroup(
      jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane0, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
    );
    jPanel0Layout.setVerticalGroup(
      jPanel0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane0, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
    );

    add(jPanel0);

    jPanel4.setForeground(java.awt.Color.lightGray);
    jPanel4.setToolTipText("4");
    jPanel4.setOpaque(false);

    jTextArea4.setBackground(new java.awt.Color(0, 0, 0));
    jTextArea4.setColumns(5);
    jTextArea4.setForeground(java.awt.Color.lightGray);
    jTextArea4.setRows(5);
    jTextArea4.setToolTipText("4");
    jTextArea4.setFocusCycleRoot(true);
    jTextArea4.setName("4"); // NOI18N
    jTextArea4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextAreaMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jTextAreaMouseEntered(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jTextAreaMousePressed(evt);
      }
    });
    jScrollPane4.setViewportView(jTextArea4);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
    );

    add(jPanel4);

    jPanel7.setForeground(java.awt.Color.lightGray);
    jPanel7.setToolTipText("7");
    jPanel7.setOpaque(false);

    jTextArea7.setBackground(new java.awt.Color(0, 0, 0));
    jTextArea7.setColumns(5);
    jTextArea7.setForeground(java.awt.Color.lightGray);
    jTextArea7.setRows(5);
    jTextArea7.setToolTipText("7");
    jTextArea7.setFocusCycleRoot(true);
    jTextArea7.setName("7"); // NOI18N
    jTextArea7.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextAreaMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jTextAreaMouseEntered(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jTextAreaMousePressed(evt);
      }
    });
    jScrollPane7.setViewportView(jTextArea7);

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
    );
    jPanel7Layout.setVerticalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
    );

    add(jPanel7);

    jPanel6.setForeground(java.awt.Color.lightGray);
    jPanel6.setToolTipText("6");
    jPanel6.setOpaque(false);

    jTextArea6.setBackground(new java.awt.Color(0, 0, 0));
    jTextArea6.setColumns(5);
    jTextArea6.setForeground(java.awt.Color.lightGray);
    jTextArea6.setRows(5);
    jTextArea6.setToolTipText("6");
    jTextArea6.setFocusCycleRoot(true);
    jTextArea6.setName("6"); // NOI18N
    jTextArea6.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextAreaMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jTextAreaMouseEntered(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jTextAreaMousePressed(evt);
      }
    });
    jScrollPane6.setViewportView(jTextArea6);

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
    );
    jPanel6Layout.setVerticalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
    );

    add(jPanel6);

    jPanel5.setForeground(java.awt.Color.lightGray);
    jPanel5.setToolTipText("5");
    jPanel5.setOpaque(false);

    jTextArea5.setBackground(new java.awt.Color(0, 0, 0));
    jTextArea5.setColumns(5);
    jTextArea5.setForeground(java.awt.Color.lightGray);
    jTextArea5.setRows(5);
    jTextArea5.setToolTipText("5");
    jTextArea5.setFocusCycleRoot(true);
    jTextArea5.setName("5"); // NOI18N
    jTextArea5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextAreaMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jTextAreaMouseEntered(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jTextAreaMousePressed(evt);
      }
    });
    jScrollPane5.setViewportView(jTextArea5);

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
    );

    add(jPanel5);
  }// </editor-fold>//GEN-END:initComponents

  private void jTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaMouseClicked
    System.out.println("pan = " + evt.toString().
      substring(evt.toString().length() - 1, evt.toString().length()));
    //setList1(it);
  }//GEN-LAST:event_jTextAreaMouseClicked

  private void jTextAreaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaMouseEntered
    for (int i = 0; i < 9; i++) {
      //<editor-fold defaultstate="collapsed" desc="switch">
      switch ("" + i) {
        case "0": {
          jta = jTextArea0;
          break;
        }
        case "1": {
          jta = jTextArea1;
          break;
        }
        case "2": {
          jta = jTextArea2;
          break;
        }
        case "3": {
          jta = jTextArea3;
          break;
        }
        case "4": {
          jta = jTextArea4;
          break;
        }
        case "5": {
          jta = jTextArea5;
          break;
        }
        case "6": {
          jta = jTextArea6;
          break;
        }
        case "7": {
          jta = jTextArea7;
          break;
        }
        case "8": {
          jta = jTextArea8;
          break;
        }
      }
      //</editor-fold>
      String[] line = jta.getText().split(CRLF);
      String sec = null;
      if (line.length > 1) {
        sec = GlobalMethods.capWords(line[1].toLowerCase());
      }
      String subl = null;
      String subw = null;
      String sub = null;
      try {
        subl = GlobalMethods.capWords(line[0].toLowerCase());
      } catch (Exception e) {
        System.out.println("e = " + e);
      }
      try {
        subw = GlobalMethods.capWords(line[2].toLowerCase());
      } catch (Exception e) {
        subw = "Unnamed";
      }
      try {
        sub = subl.substring(subl.length() - 1, subl.length()) + " - " + subw;
      } catch (Exception e) {
        System.out.println("e = " + e);
      }
      jta.setToolTipText(sec + "/" + sub);
    }
  }//GEN-LAST:event_jTextAreaMouseEntered

  private void jTextAreaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaMousePressed
    sel = "" + evt.toString().
      substring(evt.toString().length() - 1, evt.toString().length());
    System.out.println("sel = " + sel);
    JTextArea jt = null;
    //<editor-fold defaultstate="collapsed" desc="switch(sel)">
    switch (sel) {
      case "0": {
        jt = jTextArea0;
        break;
      }
      case "1": {
        jt = jTextArea1;
        break;
      }
      case "2": {
        jt = jTextArea2;
        break;
      }
      case "3": {
        jt = jTextArea3;
        break;
      }
      case "4": {
        jt = jTextArea4;
        break;
      }
      case "5": {
        jt = jTextArea5;
        break;
      }
      case "6": {
        jt = jTextArea6;
        break;
      }
      case "7": {
        jt = jTextArea7;
        break;
      }
      case "8": {
        jt = jTextArea8;
        break;
      }
    }
    //</editor-fold>
    String[] lines = jt.getText().split(CRLF);
    pos = jt.getCaretPosition();
    for (int i = 0; i < lines.length; i++) {
      try {
        if (jt.getLineEndOffset(i) > pos) {
          System.out.println("lines[" + i + "] = " + lines[i]);
          setList1(lines[i]);
          break;
        }
      } catch (BadLocationException ex) {
        Logger.getLogger(Panel4Neighbours.class.getName()).log(Level.SEVERE,
          null, ex);
      }
    }

  }//GEN-LAST:event_jTextAreaMousePressed

  private void jTextAreaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaMouseReleased
    jta.setSelectionEnd(jta.getSelectionStart());
    jta.setSelectionStart(jta.getSelectionEnd());
  }//GEN-LAST:event_jTextAreaMouseReleased
  // Variables declaration - do not modify//GEN-BEGIN:variables
  javax.swing.JPanel jPanel0;
  javax.swing.JPanel jPanel1;
  javax.swing.JPanel jPanel2;
  javax.swing.JPanel jPanel3;
  javax.swing.JPanel jPanel4;
  javax.swing.JPanel jPanel5;
  javax.swing.JPanel jPanel6;
  javax.swing.JPanel jPanel7;
  javax.swing.JPanel jPanel8;
  javax.swing.JScrollPane jScrollPane0;
  javax.swing.JScrollPane jScrollPane1;
  javax.swing.JScrollPane jScrollPane2;
  javax.swing.JScrollPane jScrollPane3;
  javax.swing.JScrollPane jScrollPane4;
  javax.swing.JScrollPane jScrollPane5;
  javax.swing.JScrollPane jScrollPane6;
  javax.swing.JScrollPane jScrollPane7;
  javax.swing.JScrollPane jScrollPane8;
  public static javax.swing.JTextArea jTextArea0;
  public static javax.swing.JTextArea jTextArea1;
  public static javax.swing.JTextArea jTextArea2;
  public static javax.swing.JTextArea jTextArea3;
  public static javax.swing.JTextArea jTextArea4;
  public static javax.swing.JTextArea jTextArea5;
  public static javax.swing.JTextArea jTextArea6;
  public static javax.swing.JTextArea jTextArea7;
  public static javax.swing.JTextArea jTextArea8;
  // End of variables declaration//GEN-END:variables

  /**
   <p>
   @param string Selected string in List
   */
  public static void setList1(String string) {
    for (int i = 0; i < Panel4SubSector.jList1.getModel().getSize(); i++) {
      if (string.equals(Panel4SubSector.jList1.getModel().getElementAt(i))) {
        Panel4SubSector.jList1.setSelectedValue(string, true);
        Panel4Locator.jcb4System.setSelectedItem(string);
        showInfo();
      } else {
//        hideInfo();
      }
    }
  }
}
