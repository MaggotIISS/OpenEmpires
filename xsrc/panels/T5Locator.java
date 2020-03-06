/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package panels;

import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalVariables.CRLF;
import java.util.Arrays;
import static panels.Panel4T5Locator.UWP;

/**

 @author Mark Ferguson
 */
public class T5Locator {

  public static void main(String[] args) {
    //addStrings();
    setSystem();
  }

  static void addStrings() {
    String folder;
    String name;
    String ext;
    String search;
    String out = "";
    folder = "C:/T5/TFX/src/panels";
    name = "Panel4T5Locator";
    ext = "java";
    search = "String[]";
    findStrings(folder, name, ext, search, out);
  }

  static void findStrings(String folder, String name, String ext, String search,
    String out) {
    String[] lines;
    lines = GlobalMethods.loadTextFile(folder, name, ext).split(CRLF);
    out = "" + name + CRLF;
    int start;
    String line = "";
    for (int i = 0; i < lines.length; i++) {
      line = lines[i].trim();
      if (line.contains(search)) {
        if (!line.startsWith("//")) {
          if (!line.contains("public static void main")) {
            start = line.indexOf(search) + search.length();
            line = line.substring(start).trim();
            out += line + "\t" + i + CRLF;
          }
        }
      }
    }
    String[] outs = out.split(CRLF);
    Arrays.sort(outs);
    out = "";
    for (int i = 0; i < outs.length; i++) {
      String[] lined = outs[i].replace(";", " ").replace("{", " ").replace("[]",
        " ").replace(")", " ").split(" ");
      out += lined[0] + CRLF;
    }
    Arrays.sort(outs);
    GlobalMethods.saveTextFile("C:/T5/TFX", "StringArrays", "txt", out);
    listStrings(out);
  }

  private static void listStrings(String out) {
    String[] lines = out.split(CRLF);
    String txt = "";
    for (int i = 0; i < lines.length; i++) {
      if (!"".equals(lines[i])) {
        txt += lines[i] + CRLF;
      }
    }

//    {
//      JTextArea jta = new JTextArea(txt, 50, 50);
//      JScrollPane jsp = new JScrollPane(jta);
//      JOptionPane.showMessageDialog(null, jsp);
//    }
  }

  static void setSystem() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    String txt = "";
    boolean DEBUG = true;
    {
      //DEBUG = false;
      if (DEBUG) { // true or false
        txt += GlobalMethods.comment("=", 80);
        txt += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
      }
    }
    //</editor-fold>
    String world;
    for (int i = Panel4T5Locator.world1; i < Panel4T5Locator.lines.length; i++) {
      world = Panel4T5Locator.lines[i];
      if (world.startsWith(Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
        .substring(0, 4))) {
        txt += world + CRLF;
        break;
      }
    }
    int old = Panel4T5Locator.jcb4Sys.getSelectedIndex();
    Panel4T5Locator.addSystems();
    Panel4T5Locator.jcb4Sys.setSelectedIndex(old);
    Panel4T5Locator.createSubPic();
//    Panel4T5Locator.showDetails();
    txt += "UWP" + " = " + UWP + CRLF;
    txt += "data[2]" + " = " + Panel4T5Locator.data[2] + CRLF;
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    {
      if (DEBUG) { // true or false
//        txt += "" + CRLF;
//        txt += "" + CRLF;
      }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="JOP">
    {
      System.out.println(txt);
//      JTextArea jta = new JTextArea(txt, 50, 50);
//      JScrollPane jsp = new JScrollPane(jta);
//      JOptionPane.showMessageDialog(null, jsp);
    }
    //</editor-fold>
  }
}
