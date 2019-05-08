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

import dbviewer.globals.GlobalMethods;
import dbviewer.globals.GlobalVariables;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import panels.Panel4Imperium;
import panels.Panel4Locator;
import panels.Panel4Neighbours;
import panels.Panel4SubSector;
import panels.Panel4T5Locator;

/**
 <p>
 @author maggot
 */
public class T5JumpCalc {

//<editor-fold defaultstate="collapsed" desc="variables">
  static DefaultListModel dlm2;
  static int dt = 100, ref = 10, unref = 1, dist = 0;
  static double fuelused, fuelcost;
  static String prefix, suffix;
  /**
   Start hex for practice
   */
  public static String src = "1910 Regina";
  /**
   Array of worlds in range?
   */
  public static String[] worlds = null;
  /**
   worlds outside of sector?
   */
  public static Boolean EXTERNAL;
  /**
   Array of destinations with worlds?
   */
  public static String[] dests;
  /**
   Array of all possible destinations?
   */
  public static String[] hexes;
//  private static int jump = 8;
  private static int possible = 0;
  static int x = Integer.parseInt(src.substring(0, 2));
  static int y = Integer.parseInt(src.substring(2, 4));
  private static String[] Jump0 = new String[1]; //3 possible star systems
  private static String[] Jump1 = new String[6]; //6
  private static String[] Jump2 = new String[12];//18
  private static String[] Jump3 = new String[18];//36
  private static String[] Jump4 = new String[24];//60
  private static String[] Jump5 = new String[30];//90
  private static String[] Jump6 = new String[36];//126 total destinations out of hex
  private static String[] Jump7 = new String[42];//168
  private static String[] Jump8 = new String[48];//216
  private static String[] Jump9 = new String[54];//270
  /**
   all modifiers to all destination coords
   */
  public static String[][] Jumps = {Jump0, Jump1, Jump2, Jump3, Jump4, Jump5,
    Jump6, Jump7, Jump8, Jump9};
  private static DefaultListModel dlm;
//</editor-fold>

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    Panel4T5Locator.main(args);
  }

  /**
   <p>
   @param ring jump range
   */
  @SuppressWarnings("AssignmentToMethodParameter")
  public static void doCalc(int ring) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
//    System.out.println("\tJUMP " + ring + ":");
    dests = null;
    String[] tmp = null;
//    System.out.println("src = " + src);
    //<editor-fold defaultstate="collapsed" desc="switch(ring)">
    switch (ring) {
      case 0: {
        dests = new String[Jump0.length];
        tmp = Jump0;
        break;
      }
      case 1: {
        dests = new String[Jump1.length];
        tmp = Jump1;
        break;
      }
      case 2: {
        dests = new String[Jump2.length];
        tmp = Jump2;
        break;
      }
      case 3: {
        dests = new String[Jump3.length];
        tmp = Jump3;
        break;
      }
      case 4: {
        dests = new String[Jump4.length];
        tmp = Jump4;
        break;
      }
      case 5: {
        dests = new String[Jump5.length];
        tmp = Jump5;
        break;
      }
      case 6: {
        dests = new String[Jump6.length];
        tmp = Jump6;
        break;
      }
      case 7: {
        dests = new String[Jump7.length];
        tmp = Jump7;
        break;
      }
      case 8: {
        dests = new String[Jump8.length];
        tmp = Jump8;
        break;
      }
      case 9: {
        dests = new String[Jump9.length];
        tmp = Jump9;
        break;
      }
    }
    //</editor-fold>
//    System.out.println("dests.length" + " = " + dests.length);
    System.arraycopy(tmp, 0, dests, 0, dests.length);
//    for (int i = 0; i < tmp.length; i++) {
//      System.out.println("tmp[" + i + "]" + " = " + dests[i]);
//    }
    hexes = new String[dests.length];
//    System.out.println("dests.length" + " = " + dests.length);
//    System.out.println("tmp.length" + " = " + tmp.length);
    for (int i = 0; i < dests.length; i++) {
//      System.out.print("dests[" + i + "] = " + dests[i] + " = " + getHexNum(dests[i], src));
      //dests[i] = getHexNum(dests[i], src);
      hexes[i] = getHexNum(dests[i], src);
      Panel4T5Locator.jta4Near.append("" + hexes[i]
        + dbviewer.globals.GlobalVariables.CRLF);
    }
    for (int i = 0; i < tmp.length; i++) {
//      System.out.println("tmp[" + i + "]" + " = " + tmp[i]);
    }
    possible += dests.length;
    if (ring == 0) {
      ring = 1;
    }
//    System.out.println("" + getJumpFuelCost(dt, ring, false));
//    System.out.println("" + getJumpFuelCost(dt, ring, true));
  }

  private static String getHexNum(String hex, String src) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.println("hex" + " = " + hex);
      System.out.println("src" + " = " + src);
    }
//</editor-fold>
    x = Integer.parseInt(src.substring(0, 2));
//    System.out.println("x" + " = " + x);
    y = Integer.parseInt(src.substring(2, 4));
//    System.out.println("y" + " = " + y);
    String l = "";
    String r = "";
    String end = "";
//    System.out.println("Before");
    String[] xy = new String[2];
    xy = hex.split(",");
////    xy[0] = "19";
////    xy[1] = "10";
//    System.out.println("After");
    x += Integer.parseInt(xy[0]);
    if ((x < 10) && (x > 0)) {
      l = "0";
    } else if (x < 1) {
      l = "";
      x += 32;
      end = " OUT";
    } else if (x > 32) {
      l = "0";
      x -= 32;
      end = " OUT";
    }
//    System.out.println("x" + " = " + x);
    y += Integer.parseInt(xy[1]);
    if (Integer.parseInt(src.substring(0, 2)) % 2 != 1) { //odd columns only
      if (x % 2 != 0) {
        y += 1;
      }
    }
    if ((y < 10) & (y > 0)) {
      r = "0";
    }
    if (y < 1) {
      r = "";
      y += 40;
      end = " OUT";
    }
    if (y > 40) {
      r = "0";
      y -= 40;
      end = " OUT";
    }
//    System.out.println("y" + " = " + y);
    hex = "" + l + x + r + y + end;
//    System.out.println("hex" + " = " + hex);
    return hex;
  }

  private static String getJumpFuelCost(int dt, int jump, boolean ref) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    if (dt < 0) {
      dt = -dt;
      prefix = "MCr";
    } else {
      prefix = "KCr";
    }
    fuelused = 0.1 * dt * jump;
    if (ref == true) {
      suffix = "Refined";
      fuelcost = fuelused * 1;
    } else {
      suffix = "Unrefined";
      fuelcost = fuelused * 0.3;
    }
    return prefix + fuelcost + "(" + suffix + ") for " + (dt / 10) * jump
      + " dtons";

  }

  /**
   setWorlds?
   */
  @SuppressWarnings("unchecked")
  public static void setWorlds() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    try {
      String[] parts;
      String line;
      String sec = Panel4Locator.getSectorName();
      String sub = Panel4Locator.getSubSectorName().substring(4, Panel4Locator
        .getSubSectorName().length());
      String[] titles = Panel4Imperium.Systems[0].split("\",\"");
      titles[0] = titles[0].replace("\"", "");
      titles[titles.length - 1] = titles[titles.length - 1].replace("\"", "");
      String string = "";
      for (int i = 0; i < titles.length; i++) {
        string += titles[i].replace("\"", "") + ", ";
      }
      Panel4Imperium.sow.append(string + GlobalVariables.CRLF);
      Panel4Locator.jcb4System.removeAllItems();
      // if line contains sector AND subsector name
      for (int i = 1; i < Panel4Imperium.Systems.length; i++) {
        parts = Panel4Imperium.Systems[i].split("\",\"");
        if ((parts[7].toLowerCase().equals(sec.toLowerCase())) & (parts[9]
          .toLowerCase().equals(sub.toLowerCase()))) {
          string = "";
          for (int j = 0; j < parts.length - 1; j++) {
            string += parts[j].replace("\"", "") + ", ";
          }
          if (parts[1].length() == 3) {
            parts[1] = "0" + parts[1];
          }
          parts[0] = parts[0].substring(1, parts[0].length());
          Panel4Locator.jcb4System.addItem(parts[1] + "-" + parts[0]);
          string += titles[titles.length - 1].toUpperCase() + " = "
            + parts[parts.length - 1].replace("\"", "");
          Panel4Imperium.sow.append(string + GlobalVariables.CRLF);
        }
      }
      String target = GlobalVariables.IMP + GlobalVariables.FS + (Panel4Locator
        .getSectorName().substring(0, 4)) + GlobalVariables.FS + Panel4Locator
        .getSubSectorName();
      Panel4Imperium.sow.setCurrentDirectory(target);
      SaveOutputWindow.setFname(Panel4Locator.getSubSectorName());
      Panel4Imperium.sow.setTitle(target);
    } catch (Exception ex) {
      Logger.getLogger(T5JumpCalc.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  /**
   <p>
   @param evt MouseEvent
   */
  @SuppressWarnings("unchecked")
  public static void showSubWorlds(MouseEvent evt) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    try {
      String[] parts;
      String sec = Panel4Locator.getSectorName();
      String sub = Panel4Locator.getSubSectorName().substring(4, Panel4Locator
        .getSubSectorName().length());
      dlm = new DefaultListModel();
      for (int i = 1; i < Panel4Imperium.Systems.length; i++) {
        parts = Panel4Imperium.Systems[i].split("\",\"");
        if ((parts[7].toLowerCase().equals(sec.toLowerCase())) & (parts[9]
          .toLowerCase().equals(sub.toLowerCase()))) {
          dlm.addElement(parts[1] + "-" + parts[0].substring(1));
        }
      }
      Object[] ra = dlm.toArray();
      Arrays.sort(ra);
      dlm = new DefaultListModel();
      for (int i = 0; i < ra.length; i++) {
        dlm.addElement(ra[i]);
      }
      Panel4SubSector.jList1.setModel(dlm);
    } catch (Exception ex) {
      Logger.getLogger(T5JumpCalc.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  /**
   <p>
   @return worlds
   */
  public static String[] getWorlds() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    //String[] worlds = null;
    //setWorlds();
    return Panel4Imperium.Systems;
  }

  /**
   setJumps modifiers for hex number
   */
  public static void setJumps() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    Jump0 = new String[]{
      "0,0"
    };
    Jump1 = new String[]{
      "0,-1", "1,-1", "1,0", "0,1", "-1,0", "-1,-1"
    };
    Jump2 = new String[]{
      "0,-2", "1,-2", "2,-1", "2,0", "2,1", "1,1", "0,2", "-1,1", "-2,1",
      "-2,0", "-2,-1", "-1,-2"
    };
    Jump3 = new String[]{
      "0,-3", "1,-3", "2,-2", "3,-2", "3,-1", "3,0", "3,1", "2,2", "1,2", "0,3",
      "-1,2", "-2,2", "-3,1", "-3,0", "-3,-1", "-3,-2", "-2,-2", "-1,-3"
    };
    Jump4 = new String[]{
      "0,-4", "1,-4", "2,-3", "3,-3", "4,-2", "4,-1", "4,0", "4,1", "4,2",
      "3,2", "2,3", "1,3", "0,4", "-1,3", "-2,3", "-3,2", "-4,2", "-4,1",
      "-4,0", "-4,-1", "-4,-2", "-3,-3", "-2,-3", "-1,-4"
    };
    Jump5 = new String[]{
      "0,-5", "1,-5", "2,-4", "3,-4", "4,-3", "5,-3", "5,-2", "5,-1", "5,0",
      "5,1", "5,2", "4,3", "3,3", "2,4", "1,4", "0,5", "-1,4", "-2,4", "-3,3",
      "-4,3", "-5,2", "-5,1", "-5,0", "-5,-1", "-5,-2", "-5,-3", "-4,-3",
      "-3,-4", "-2,-4", "-1,-5"
    };
    Jump6 = new String[]{
      "0,-6", "1,-6", "2,-5", "3,-5", "4,-4", "5,-4", "6,-3", "6,-2", "6,-1",
      "6,0", "6,1", "6,2", "6,3", "5,3", "4,4", "3,4", "2,5", "1,5", "0,6",
      "-1,5", "-2,5", "-3,4", "-4,4", "-5,3", "-6,3", "-6,2", "-6,1", "-6,0",
      "-6,-1", "-6,-2", "-6,-3", "-5,-4", "-4,-4", "-3,-5", "-2,-5", "-1,-6"
    };
    Jump7 = new String[]{
      "0,-7", "1,-7", "2,-6", "3,-6", "4,-5", "5,-5", "6,-4", "7,-4", "7,-3",
      "7,-2", "7,-1", "7,0", "7,1", "7,2", "7,3", "6,4", "5,4", "4,5", "3,5",
      "2,6", "1,6", "0,7", "-1,6", "-2,6", "-3,5", "-4,5", "-5,4", "-6,4",
      "-7,3", "-7,2", "-7,1", "-7,0", "-7,-1", "-7,2", "-7,3", "-7,4",
      "-6,-4", "-5,-5", "-4,-5", "-3,-6", "-2,-6", "-1,-7"
    };
    Jump8 = new String[]{
      "0,-8", "1,-8", "2,-7", "3,-7", "4,-6", "5,-6", "6,-5", "7,-5", "8,-4",
      "8,-3", "8,-2", "8,-1", "8,0", "8,1", "8,2", "8,3", "8,4", "7,4", "6,5",
      "5,5", "4,6", "3,6", "2,7", "1,7", "0,8", "-1,7", "-2,7", "-3,6",
      "-4,6", "-5,5", "-6,5", "-7,4", "-8,4", "-8,3", "-8,2", "-8,1",
      "-8,0", "-8,-1", "-8,-2", "-8,-3", "-8,-4", "-7,-5", "-6,-5", "-5,-6",
      "-4,-6",
      "-3,-7", "-2,-7", "-1,-8"
    };
    Jump9 = new String[]{
      "0,-9", "1,-9", "2,-8", "3,-8", "4,-7", "5,-7", "6,-6", "7,-6", "8,-5",
      "9,-5",
      "9,-4", "9,-3", "9,-2", "9,0", "9,1", "9,2", "9,3", "9,4", "8,5", "7,5",
      "6,6", "5,6", "4,7", "3,7", "2,8", "1,8", "0,9", "-1,8", "-2,8", "-3,7",
      "-4,7", "-5,6", "-6,6", "-7,5", "-8,5", "-9,4", "-9,3", "-9,2", "-9,1",
      "-9,-0",
      "-9,-1", "-9,-2", "-9,-3", "-9,-4", "-8,-5", "-7,-6", "-6,-6", "-5,-7",
      "-4,-7", "-3,-8",
      "-2,-8", "-1,-9"
    };
  }

  /**
   <p>
   @param Outs String array to search
   @return Object[] of strings
   */
  @SuppressWarnings("unchecked")
  public static Object[] locateOuts(String[] Outs) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    try {
      String sector = Panel4Locator.getSectorName();
    } catch (Exception ex) {
      Logger.getLogger(T5JumpCalc.class.getName()).log(Level.SEVERE, null, ex);
    }
    String subsector = Panel4Locator.getSubSectorName();
    String system = Panel4Locator.getSystem();
    int X = Integer.parseInt(Panel4Locator.Xnum.getText());
    int Y = Integer.parseInt(Panel4Locator.Ynum.getText());
    ArrayList al = new ArrayList();
    for (int i = 0; i < Outs.length; i++) {
      al.add(searchFor(Outs[i]));
    }
    Object[] strings = al.toArray();
    return strings;
  }

  private static String searchFor(String hex) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//      //System.out.print("" + " = " + string);
    }
//</editor-fold>
    //Check in nearby sectors for mainworlds and report name
    String sX = hex.substring(0, 2);
    String sY = hex.substring(2, 4);
    int x = Integer.parseInt(sX);
    int y = Integer.parseInt(sY);
    String X;
    String Y;
    X = "M";
    Y = "M";
    if (x <= 8) {
      X = "R";
    }
    if (x >= 24) {
      X = "L";
    }
    if (y <= 10) {
      Y = "D";
    }
    if (y >= 30) {
      Y = "U";
    }
    String direction = X + Y;
    int modX = 0;
    int modY = 0;
    switch (direction) {
      case "LU": {
        modX = -1;
        modY = 1;
        break;
      }
      case "MU": {
        modX = 0;
        modY = 1;
        break;
      }
      case "RU": {
        modX = 1;
        modY = 1;
        break;
      }

      case "LM": {
        modX = -1;
        modY = 0;
        break;
      }
      case "MM": {
        modX = 0;
        modY = 0;
        break;
      }
      case "RM": {
        modX = 1;
        modY = 0;
        break;
      }

      case "LD": {
        modX = -1;
        modY = -1;
        break;
      }
      case "MD": {
        modX = 0;
        modY = -1;
        break;
      }
      case "RD": {
        modX = -1;
        modY = -1;
        break;
      }
    }
    int sx = Integer.parseInt(Panel4Locator.Xnum.getText()) + modX;
    int sy = Integer.parseInt(Panel4Locator.Ynum.getText()) + modY;
    String sXsY = sX + sY;
    String sxsy = " " + sx + " " + sy;
    String sec = Panel4Locator.findSector(sx, sy);
    String name = null;
    name = sec + " - " + hex + " - " + getWorldName(sec, hex);
    return name;
  }

  /**
   <p>
   @param sec sector of world
   @param hex hex of world
   @return name of world
   */
  public static String getWorldName(String sec, String hex) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //System.out.print("sec" + " = " + sec);//7
      //System.out.print("hex" + " = " + hex);//1
    }
//</editor-fold>
    String line = "";
    String[] parts = null;
    String s = null;
    for (int i = 0; i < Panel4SubSector.worlds.length; i++) {
      line = Panel4SubSector.worlds[i];
      parts = line.split(("\",\"").replace("", ""));
      if (parts[1].length() != 4) {
        parts[1] = "0" + parts[1];
      }
      if (parts[7].replace("\"", "").toLowerCase().equals(sec.toLowerCase())) {
        if (parts[1].equals(hex)) {
          s = parts[0].replace("\"", "");
          break;
        }
      }
    }
    return s;

  }

  /**
   <p>
   @param sec string to test
   @param hex location
   @return crap not used or called
   */
  public static String[] test(String sec, String hex) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    String[] strings = null;
    return strings;
  }

  /**
   <p>
   @param sectors    array of sectors
   @param subsectors array of subsectors
   @return world
   */
  @SuppressWarnings("unchecked")
  public static Object search4Worlds(String[] sectors, String[] subsectors) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    Object o;
    Date then = new Date();
    //File file = new File(T5 + "/CSV/uwp-worlds");
    //worlds = GlobalMethods.getStringsFromFile(file);
    //worlds = Panel4SubSector.worlds;
    worlds = Panel4Imperium.Systems;
    String sector = null, subsector = null;
    JTextArea jt = new JTextArea();
    dlm2 = new DefaultListModel();
    String[] parts;
    ArrayList[] al = new ArrayList[sectors.length];
    Object[] strings;
    JTextArea jta;
    String[] left;
    String[] old;
    String string;
    String[] partss;
    String[] right;
    ArrayList des;
    jta = new JTextArea();
    String line;
    for (int i = 0; i < sectors.length; i++) {
      al[i] = new ArrayList();
    }
    for (int i = 0; i < worlds.length; i++) {
      for (int j = 0; j < sectors.length; j++) {
        sector = sectors[j].toLowerCase();
        if (worlds[i].toLowerCase().contains(sector)) {
          subsector = subsectors[j].toLowerCase().substring(subsectors[j]
            .length() - 1);
//          //System.out.print("letter" + " = " +subsector.toUpperCase());
          parts = worlds[i].split("\",\"");
//          for (int k = 0; k < 9; k++) {
//
//          }
          if (subsector.equals(parts[8].toLowerCase())) {
            parts[0] = parts[0].replace("\"", "");
            if (parts[1].length() != 4) {
              parts[1] = "0" + parts[1];
            }
            //parts[parts.length-1] = parts[parts.length-1].substring(0,parts.length-1);
            line = "" + j + "=" + parts[7].toLowerCase() + "=" + parts[8]
              .toLowerCase()
              + "=" + parts[9].toLowerCase() + "=" + parts[1].toLowerCase()
              + "=" + parts[0];
            al[j].add(line);
            //System.out.print("" + " = " + line);
          }
        }
      }
    }
    for (int i = 0; i < sectors.length; i++) {
      //System.out.print("" + "====================");
      strings = al[i].toArray();
      Arrays.sort(strings);
      if (strings.length != 0) {
        //<editor-fold defaultstate="collapsed" desc="switch jta">
//        switch (Integer.parseInt(let)) {
        switch (i) {
          case 0:
            jta = Panel4Neighbours.jTextArea0;
            break;
          case 1:
            jta = Panel4Neighbours.jTextArea1;
            break;
          case 2:
            jta = Panel4Neighbours.jTextArea2;
            break;
          case 3:
            jta = Panel4Neighbours.jTextArea3;
            break;
          case 4:
            jta = Panel4Neighbours.jTextArea4;
            break;
          case 5:
            jta = Panel4Neighbours.jTextArea5;
            break;
          case 6:
            jta = Panel4Neighbours.jTextArea6;
            break;
          case 7:
            jta = Panel4Neighbours.jTextArea7;
            break;
          case 8:
            jta = Panel4Neighbours.jTextArea8;
            break;
        }
        //</editor-fold>
        left = Panel4SubSector.jTextArea1.getText().split(GlobalVariables.CRLF);
        old = jta.getText().split(GlobalVariables.CRLF);
        jta.setText("");
        jta.append(old[0] + GlobalVariables.CRLF);
        jta.append(old[1].toUpperCase() + GlobalVariables.CRLF);
        string = "" + strings[0];
        partss = string.split("=");
        jta.append("" + partss[3].toUpperCase() + GlobalVariables.CRLF);
        jta.append("--------------" + GlobalVariables.CRLF);
        //System.out.print(sectors[i]);
        for (int l = 0; l < strings.length; l++) {
          string = "" + strings[l];
          partss = string.split("=");
          jta.append("" + /*
             parts[3] + "-" +
             */ partss[4] + "-" + partss[5] + GlobalVariables.CRLF);
        }
        right = jta.getText().split(GlobalVariables.CRLF);
        des = new ArrayList();
        for (int k = 0; k < left.length; k++) {
          for (int j = 0; j < right.length; j++) {
            try {
              if (right[j].substring(0, 4).equals(left[k].substring(0, 4))) {
                des.add(right[j]);
              }
            } catch (StringIndexOutOfBoundsException e) {
              //System.out.print("" + " = " +e.toString());
            }
          }
        }
        for (int m = 0; m < des.size(); m++) {
          dlm2.addElement(des.get(m));
        }
      }
    }
    Arrays.sort(dlm2.toArray());
    o = dlm2.toArray();
    Panel4SubSector.jList2.setModel(dlm2);
    Date now = new Date();
    //System.out.print("" + " = " + ((now.getTime() - then.getTime())) + " milliseconds");
    return o;
  }

  /**
   <p>
   @param hexname hex and name of destination
   */
  public static void showUWP(String hexname) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    //System.out.print("hexname" + " = " + hexname);
    //check for selected value in Panel4Neighbours
    JTextArea jt = new JTextArea();
    JTextArea[] jta = {Panel4Neighbours.jTextArea0,
      Panel4Neighbours.jTextArea1, Panel4Neighbours.jTextArea2,
      Panel4Neighbours.jTextArea3, Panel4Neighbours.jTextArea4,
      Panel4Neighbours.jTextArea5, Panel4Neighbours.jTextArea6,
      Panel4Neighbours.jTextArea7, Panel4Neighbours.jTextArea8
    };
    for (int i = 0; i < jta.length; i++) {
      jt = jta[i];
      if (jt.getText().contains(hexname)) {
        String[] lines = jt.getText().split(GlobalVariables.CRLF);
        String sec = lines[1].toLowerCase();
        String sub = lines[2].toLowerCase();
        String name = null;
        int len = 0;
        for (int j = 0; j < worlds.length; j++) {
          if ((worlds[j].toLowerCase().contains(sub)) & (worlds[j].toLowerCase()
            .contains(sec))) {
            name = Panel4SubSector.jList2.getModel().getElementAt(
              Panel4SubSector.jList2.getSelectedIndex()).toString()
              .toLowerCase();
            len = Panel4SubSector.jList2.getSelectedValue().toString().length();
            if (worlds[j].toLowerCase().contains(name.substring(5, len))) {
              lines = worlds[j].split("\",\"");
              Panel4SubSector.UWP.setText(lines[2]);
            }
          }
        }
        //Panel4SubSector.jTextField1;
      }
    }
  }

  /**
   <p>
   @param string starting hex
   @param value  range of jump
   @param t5     not used
   */
  public T5JumpCalc(String string, int value, String t5) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
//      System.out.print(GlobalMethods.comment("=", 20));
//      System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //System.out.println("" + " = " + );
    }
//</editor-fold>
    Panel4T5Locator.jta4Near.setText("");
    setJumps();
    src = string.substring(0, 4);
//    System.out.println("string" + " = " + string);
//    System.out.println("value" + " = " + value);
    doCalc(value);
  }

}
