/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.bits2page;

//import open.GlobalMethods;
import dbviewer.globals.GlobalMethods;
import static web.bits2page.Empire.CRLF;
import static web.bits2page.Empire.jTextArea2;

/**
 *
 * @author Mark Ferguson
 */
public class Economics {

  //<editor-fold defaultstate="collapsed" desc="Variables">
  static final String[][] ra = new String[][]{
    {"0", "0", "0", "1", "2", "2", "3", "3", "4", "4", "5", "5", "6", "6", "7", "7"}, // 0
    {"0", "0", "0", "1", "2", "2", "3", "4", "5", "5", "6", "6", "8", "8", "9", "9"}, // 1
    {"0", "0", "1", "1", "2", "3", "4", "5", "6", "6", "7", "8", "9", "10", "11", "11"}, // 2
    {"0", "0", "1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"}, // 3
    {"0", "1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"}, // 4
    {"0", "1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"}, // 5
    {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}, // 6
    {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}, // 7
    {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}, // 8
    {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}, // 9
    {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"}, // 10
    {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "14", "15", "16", "17"}, // 11
    {"1", "2", "3", "4", "6", "7", "8", "9", "10", "11", "12", "13", "15", "16", "17", "18"}, // 12
    {"1", "2", "3", "5", "6", "7", "8", "9", "10", "11", "12", "13", "16", "17", "18", "19"}, // 13
    {"1", "2", "3", "5", "7", "8", "9", "10", "11", "12", "13", "14", "17", "18", "19", "20"}, // 14
    {"1", "2", "4", "5", "7", "8", "9", "11", "12", "13", "15", "16", "18", "19", "21", "22"} // 15
  };
  static final double[] fga = new double[]{
    // A STARPORTS
    0.000, 1.000, 1.106, 1.184, 1.244, 1.293, 1.333, 1.368, 1.397, 1.423,
    1.445, 1.465, 1.484, 1.500, 1.515, 1.529, 1.541, 1.553, 1.564, 1.574,
    1.583, 1.592, 1.6, 1.608, 1.615, 1.622, 1.629, 1.635, 1.641, 1.646,
    1.652, 1.657, 1.662, 1.667, 1.671, 1.676, 1.680, 1.684, 1.688, 1.691,
    1.695, 1.698, 1.702, 1.705, 1.708, 1.711, 1.714, 1.717, 1.720, 1.723,
    1.725, 1.728, 1.730, 1.733, 1.735, 1.737, 1.740, 1.742, 1.744, 1.746,
    1.748, 1.750, 1.752, 1.754, 1.756, 1.757, 1.759, 1.761, 1.763, 1.764,
    1.766, 1.768, 1.769, 1.771, 1.772, 1.774, 1.775, 1.776, 1.778, 1.779, 1.780
  };
  static final double[] fgb = new double[]{
    // B STARPORTS
    0.000, 1.000, 1.053, 1.095, 1.130, 1.160, 1.185, 1.207, 1.227, 1.244,
    1.260, 1.274, 1.286, 1.298, 1.309, 1.319, 1.328, 1.337, 1.345, 1.352,
    1.359, 1.366, 1.372, 1.378, 1.384, 1.389, 1.394, 1.399, 1.404, 1.408,
    1.412, 1.416, 1.420, 1.424, 1.427, 1.431, 1.434, 1.437, 1.440, 1.443,
    1.446, 1.449, 1.452, 1.454, 1.457, 1.459, 1.462, 1.464, 1.466, 1.468,
    1.471, 1.473, 1.475, 1.477, 1.478, 1.480, 1.482, 1.484, 1.486, 1.487,
    1.489, 1.491, 1.492, 1.494, 1.495, 1.497, 1.498, 1.500, 1.501, 1.502,
    1.504, 1.505, 1.506, 1.507, 1.509, 1.510, 1.511, 1.512, 1.513, 1.514, 1.515
  };
  static final double[] fgc = new double[]{
    // C STARPORTS
    0.000, 1.000, 1.015, 1.029, 1.041, 1.053, 1.063, 1.072, 1.081, 1.089,
    1.096, 1.103, 1.110, 1.116, 1.121, 1.127, 1.132, 1.137, 1.141, 1.145,
    1.150, 1.153, 1.157, 1.161, 1.164, 1.167, 1.171, 1.174, 1.177, 1.179,
    1.182, 1.185, 1.187, 1.190, 1.192, 1.194, 1.196, 1.198, 1.201, 1.203,
    1.204, 1.206, 1.208, 1.210, 1.212, 1.213, 1.215, 1.217, 1.218, 1.220,
    1.221, 1.223, 1.224, 1.225, 1.227, 1.228, 1.229, 1.231, 1.232, 1.233,
    1.234, 1.235, 1.236, 1.238, 1.239, 1.240, 1.241, 1.242, 1.243, 1.244,
    1.245, 1.246, 1.247, 1.247, 1.248, 1.249, 1.250, 1.251, 1.252, 1.253, 1.253
  };
  static final double[] fgd = new double[]{
    // D STARPORTS
    0.000, 1.000, 1.000, 1.001, 1.001, 1.002, 1.002, 1.002, 1.003, 1.003,
    1.004, 1.004, 1.004, 1.005, 1.005, 1.005, 1.006, 1.006, 1.006, 1.007,
    1.007, 1.007, 1.008, 1.008, 1.008, 1.009, 1.009, 1.009, 1.010, 1.010,
    1.010, 1.010, 1.011, 1.011, 1.011, 1.012, 1.012, 1.012, 1.012, 1.013,
    1.013, 1.013, 1.014, 1.014, 1.014, 1.014, 1.015, 1.015, 1.015, 1.015,
    1.016, 1.016, 1.016, 1.016, 1.017, 1.017, 1.017, 1.017, 1.018, 1.018,
    1.018, 1.018, 1.018, 1.019, 1.019, 1.019, 1.019, 1.020, 1.020, 1.020,
    1.020, 1.020, 1.021, 1.021, 1.021, 1.021, 1.021, 1.022, 1.022, 1.022, 1.022
  };
  static final String[] govtexpense = new String[]{
    "0.95",
    "1.10", "1.4", "1.3", "1.15", "1.35",
    "9", "99", "1.3", "1.35", "1.05",
    "1.00", "1.25", "1.05", "1.10", "1.20"};
  static final String[] basetax = new String[]{
    "0.05",
    "0.20", "0.30", "0.20", "0.25", "0.25",
    "9", "99", "0.40", "0.35", "0.30",
    "0.25", "0.30", "0.40", "0.35", "0.35"};
  static final String[] change = new String[]{ // 2d6
    "-0.06", "-0.04", "-0.03", "-0.02", "-0.01",
    "0.00",
    "0.01", "0.02", "0.03", "0.04", "0.06"};
//  static final String[] prevDM = new String[]{
//    "5",  // 0 0.49-
//    "4",  // 1 0.50 - 0.69
//    "3",  // 2 0.70 - 0.79
//    "2",  // 3 0.80 - 0.89
//    "1",  // 4 0.90 - 0.95
//    "0",  // 5 0.96 - 1.05
//    "-1", // 6 1.06 - 1.10
//    "-2", // 7 1.11 - 1.20
//    "-3", // 8 1.21 - 1.30
//    "-4", // 9 1.31 - 1.40
//    "-5"  // A 1.41+ 
//  };
  static String[] admin = new String[]{
    "0.90", // Spectacular success
    "1.00", // Success
    "1.10", // Failure
    "1.20" // Spectacular Failure
  };
  static String[] pricemult = new String[]{ // 2d
    "0.8", // 2
    "0.85", // 3
    "0.90", // 4
    "0.95", // 5
    "1.00", // 6
    "1.00", // 7
    "1.00", // 8
    "1.05", // 9
    "1.10", // 10
    "1.15", // 11
    "1.20" // 12
  };
  static int res = GlobalMethods.fromHex(Empire.jTextField4.getText().substring(0, 1));
  static int lab = GlobalMethods.fromHex(Empire.jTextField4.getText().substring(1, 2)) - 1;
  static int inf = GlobalMethods.fromHex(Empire.jTextField4.getText().substring(2, 3));
  static int cul = GlobalMethods.fromHex(Empire.jTextField5.getText().substring(0, 1));
  static int pop = GlobalMethods.fromHex(Empire.jTextField2.getText().substring(4, 5));
  static int gov = GlobalMethods.fromHex(Empire.jTextField2.getText().substring(5, 6));
  static int ll = GlobalMethods.fromHex(Empire.jTextField2.getText().substring(6, 7));
  static int tl = GlobalMethods.fromHex(Empire.jTextField2.getText().substring(8, 9));
  static String[] titles = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
  static int totaldemand = 0;
  static int basedemand = 0; // BASE
  static int demandroll = 0;
  static int exports;
  static int imports;
  static double gwp = 0;
  static int mod = 0;
  static int resmod = res + mod;
  static double re = tl * 0.1 * resmod; // TL * 0.1 * RA
  static double lf = 0; // Labour Force (lab * pm)
  static int pm = 0;
  static double prev = 1.000;
  static double aggregatechange = 0.000;
  static double current = 0.000;
  static int dm = 1;
  private static double fgtm;
  //</editor-fold>

  // 0
  /**
   *
   */
  public static void computePlanetaryDemand() { // 
    String out = "";
    clear();
    { // Inf <= Res
      if (inf <= res) {
        if (getPop() >= 4) {
          basedemand = res;
        } else {
          if (getPop() <= 3) {
            basedemand = getPop();
          }
        }
      }
    }
    { // Inf > Res
      if (inf > res) {
        if (getPop() >= 4) {
          basedemand = inf;
        } else {
          if (getPop() <= 3) {
            basedemand = getPop();
          }
        }
      }
    }
    if (basedemand < 0) {
      basedemand = 0;
    }
    if (basedemand > 15) {
      basedemand = 15;
    }
    // cross reference on table
    demandroll = GlobalMethods.roll2d() + computeDMs(getPop(), getCulture());
    out += " res = " + res + CRLF;
    out += " lab = " + lab + CRLF;
    out += " inf = " + inf + CRLF;
    out += " pop = " + getPop() + CRLF;
    out += " cul = " + getCulture() + CRLF;
    out += " basedemand = " + basedemand + CRLF;
    out += " demandroll = " + demandroll + CRLF;
    int x = findTitle(basedemand);
    if (x > 15) {
      x = 15;
    }
    if (x < 0) {
      x = 0;
    }
    int y = demandroll;
    if (y > 15) {
      y = 15;
    }
    if (y < 0) {
      y = 0;
    }
    String reply = " TOTAL DEMAND = " + ra[x][y];
    totaldemand = Integer.parseInt(ra[x][y]);
    out += " totaldemand = " + totaldemand + CRLF;
    out += reply + CRLF;
    Empire.jTextArea2.append(out + CRLF);
  }

  // 1
  /**
   *
   */
  public static void computeResourceTrade() { // 
    String out = "";
    clear();
    if ((res - totaldemand) > 0) {
      exports = res - totaldemand;
      imports = totaldemand - res;
      out += " Exports = Resources - Total Demand" + CRLF;
      out += " Exports = " + (res - totaldemand) + CRLF;
//      Empire.jTextArea3.append(out + CRLF);
      Empire.jTextArea2.append(out + CRLF);
    } else {
      exports = res - totaldemand;
      imports = totaldemand - res;
      out += " Imports = Total Demand - Resources" + CRLF;
      out += " Imports = ".toUpperCase() + imports + CRLF;
//      Empire.jTextArea3.append(out + CRLF);
      Empire.jTextArea2.append(out + CRLF);
    }
  }

  // 2
  /**
   *
   */
  public static void computeBaseGWP() { // GWP = (RE * LF * I) / (C + 1)
    String out = "";
    gwp = 0;
    tl = GlobalMethods.fromHex(Empire.jTextField2.getText().substring(0, 1));
    imports
      = mod = imports;
    resmod = res + mod;
    re = resmod * tl * 0.1; // TL * 0.1 * RA
    pm = GlobalMethods.fromHex(Empire.jTextField6.getText().substring(0, 1));
    lf = pm * getProduct(lab); // Labour Force (lab * pm)
    clear();
//    out += "GWP = (RE * LF * I) / (C +1)" + CRLF;
//    out += "resmod = " + resmod + CRLF;
    out += " re = " + re + CRLF;
    out += " lf = " + lf + CRLF;
    out += " inf = " + inf + CRLF;
    out += " cul = " + cul + CRLF;
    gwp = ((re * lf * inf) / (cul + 1));
    out += " GWP = " + gwp + CRLF;
//    Empire.jTextArea3.append(out + CRLF);
    Empire.jTextArea2.append(out + CRLF);
  }

  // 3
  /**
   *
   */
  public static void computeFinishedGoodsTradeMult() { // 
    String out = "";
    String port = Empire.jTextField2.getText().substring(0, 1);
    int worlds = Integer.parseInt(Empire.jTextField7.getText());
    double[] ras = null;
    switch (port) {
      case "A": {
        ras = fga;
        break;
      }
      case "B": {
        ras = fgb;
        break;
      }
      case "C": {
        ras = fgc;
        break;
      }
      case "D": {
        ras = fgd;
        break;
      }
    }
    fgtm = ras[worlds];
    out += " FGTM = " + fgtm + CRLF;
    clear();
    Empire.jTextArea2.append(out + CRLF);
//    Empire.jTextArea3.append(out + CRLF);
  }

  // 4
  /**
   *
   */
  public static void computeInterstellarDemandMult() { // 
    try {
      String out = "";
      int roll = GlobalMethods.roll2d();
      out += " 2D roll of " + roll + CRLF;

      int val = (roll - 2) + dm;
      if (val < 0) {
        val = 0;
      }
      if (val > 10) {
        val = 10;
      }
      out += " dm = " + getDM(current) + CRLF;
      out += " change[" + val + "]" + " = " + change[val] + CRLF;

      aggregatechange = Double.parseDouble(change[val]);
      out += " aggregatechange = " + aggregatechange + CRLF;
      out += " prev = " + prev + CRLF;
      //
      current = prev + aggregatechange;
      out += " current = ".toUpperCase() + current + CRLF;
      prev = current;
      clear();
      Empire.jTextArea2.append(out + CRLF);
    } catch (Exception e) {
      System.out.println("e" + " = " + e.toString());
    }
  }

  // 5
  /**
   *
   */
  public static void computeFinalGWP() { // 
    String out = "";
    // FinalGWP = BaseGWP * FGTM * ISD
    out += " basedemand = " + basedemand + CRLF;
    out += " fgtm = " + fgtm + CRLF;
    out += " totaldemand = " + totaldemand + CRLF;
    out += " FinalGWP = ".toUpperCase() + (basedemand * fgtm * totaldemand) + CRLF;
    clear();
    Empire.jTextArea2.append(out + CRLF);
  }

  // 6
  /**
   *
   */
  public static void computeTaxRate() { // 
    String out = "";
    // TotalTaxRate = Base + Social  + Discretionary
    Base = Double.parseDouble(basetax[gov]);
    out += " Base = " + Base + CRLF;
    // Social = (ll + cul)/100;
    Social = (ll * cul) / 100;
    out += " Social = " + Social + CRLF;
    // Discretionary = 
    Discretionary = Double.parseDouble(Empire.jTextField9.getText());
    out += " Discretionary = " + Discretionary + CRLF;
    TotalTax = Base + Social + Discretionary;
    out += " TotalTax = ".toUpperCase() + TotalTax + CRLF;
    clear();
    Empire.jTextArea2.append(out + CRLF);
//    Empire.jTextArea3.append(out + CRLF);
  }
  static double Base = 0.000;
  static double Social = 0.000;
  static double Discretionary = 0.000;
  static double TotalTax = 0.000;

  // 7
  /**
   *
   */
  public static void computeBudget() { // 
    String out = " GB = TotalTax * GWP" + CRLF;
    GB = TotalTax * gwp;
    out += " TotalTax = " + TotalTax + CRLF;
    out += " GWP = " + gwp + CRLF;
    GB = TotalTax * gwp;
    out += " GB = " + GB + CRLF;
    clear();
    Empire.jTextArea2.append(out + CRLF);
  }
  static double GB; // Governmental Budget
  static final double C = cul; // Cultural spending
  static final double I = inf; // Infrastructure maintenance
  static final double L = ll; // Law and Order
  static final double A = 1.0; // Admin factor
  static double G = Double.parseDouble(govtexpense[gov]); // Govt type factor

  // 8
  /**
   *
   */
  public static void computeCivilianExpenses() { // 
    String out = " Civilian Expenses = [(C+I+L)/100] * A * G * GB" + CRLF;
    out += " C" + " = " + C + CRLF;
    out += " I" + " = " + I + CRLF;
    out += " L" + " = " + L + CRLF;
    out += " A" + " = " + A + CRLF;
    G = Double.parseDouble(govtexpense[gov]);
    out += " G" + " = " + G + CRLF;
    double GB1 = (C + I + L) / 100;
    out += " GB1" + " = " + GB1 + CRLF;
    GB = GB1 * A * G;
    out += " GB" + " = " + GB + CRLF;
    clear();
    Empire.jTextArea2.append(out + CRLF);
//    Empire.jTextArea3.append(out + CRLF);
  }

  // 9
  /**
   *
   */
  public static void computeMilitaryExpenses() { // 

    String out = " Military Expenses = M * A * G" + CRLF;

    double activemaint = 0.0; // 3 * SIZE
    double mothmaint = 0.0;   // 1 * SIZE
    M = activemaint + mothmaint;
    out += " Military Maintenance = " + M + CRLF;
    out += " Admin Factor = " + A + CRLF;
    out += " Government Factor = " + G + CRLF;
    out += " Military Expenses = ".toUpperCase() + MEX + CRLF;
    clear();
    Empire.jTextArea2.append(out + CRLF);
  }
  static final double SIZE = Double.parseDouble(Empire.jTextField10.getText());
  static double M = 0;
  static final double MEX = M * A * G;

  // 10
  /**
   *
   */
  public static void computePAL() { // ADVANCE 1 YEAR
    String out = "";
    clear();
    jTextArea2.append(out + CRLF);
  }

  private static void clear() { // 
//    Empire.jTextArea3.setText("");
  }

  static int getPop() {
    pop = Integer.parseInt(Empire.jTextField2.getText().substring(4, 5));
    return pop;
  }

  static int getCulture() {
    cul = GlobalMethods.fromHex(Empire.jTextField5.getText().substring(0, 1));
    return cul;
  }

  static int computeDMs(int pop, int cul) {
    int DM = 0;
    if (pop < 2) {
      DM += -3;
    }
    if (pop == 2 | pop == 3) {
      DM += -2;
    }
    if (pop == 4 | pop == 5) {
      DM += -1;
    }
    if (pop == 6) {
      DM += 0;
    }
    if (pop == 7 | pop == 8) {
      DM += 1;
    }
    if (pop == 9 | pop == 10) {
      DM += 2;
    }
    if (pop > 11) {
      DM += 3;
    }

    if (cul < 2) {
      DM += -3;
    }
    if (cul == 2 | cul == 3) {
      DM += -2;
    }
    if (cul == 4 | cul == 5) {
      DM += -1;
    }
    if (cul == 6 | cul == 7) {
      DM += 0;
    }
    if (cul == 8 | cul == 9 | cul == 10) {
      DM += 1;
    }
    if (cul == 11 | cul == 13) {
      DM += 2;
    }
    if (cul > 13) {
      DM += 3;
    }

    return DM;
  }

  private static int findTitle(int demand) {
    for (int i = 0; i < titles.length; i++) {
      if (Integer.parseInt(titles[i]) == demand) {
        totaldemand = i;
        return i;
      }
    }
    return 0;
  }

  private static double getProduct(int lab) {
    double num = lab;
    switch (lab) {
      case 0: {
        num = 0.0000001;
        break;
      }
      case 1: {
        num = 0.000001;
        break;
      }
      case 2: {
        num = 0.00001;
        break;
      }
      case 3: {
        num = 0.0001;
        break;
      }
      case 4: {
        num = 0.001;
        break;
      }
      case 5: {
        num = 0.01;
        break;
      }
      case 6: {
        num = 0.1;
        break;
      }
      case 7: {
        num = 1;
        break;
      }
      case 8: {
        num = 10;
        break;
      }
      case 9: {
        num = 100;
        break;
      }
      case 10: {
        num = 1000;
        break;
      }
      case 11: {
        num = 10000;
        break;
      }
      case 12: {
        num = 100000;
        break;
      }
      case 13: {
        num = 1000000;
        break;
      }
      case 14: {
        num = 10000000;
        break;
      }
    }
    return num;
  }

  private static String getDM(double current1) {
    if (current <= 0.49) {
      dm = 5;                 //
    }
    if (current >= 0.50 & current <= 0.70) {
      dm = 4; // 
    }
    if (current >= 0.70 & current <= 0.80) {
      dm = 3; // 
    }
    if (current >= 0.80 & current <= 0.90) {
      dm = 2; // 
    }
    if (current >= 0.90 & current <= 0.95) {
      dm = 1; // 
    }
    if (current >= .96 & current <= 1.05) {
      dm = 0;  // 
    }
    if (current >= 1.06 & current <= 1.1) {
      dm = -1; // 
    }
    if (current >= 1.11 & current <= 1.2) {
      dm = -2; // 
    }
    if (current >= 1.21 & current <= 1.3) {
      dm = -3; // 
    }
    if (current >= 1.31 & current <= 1.4) {
      dm = -4; // 
    }
    if (current >= 1.41) {
      dm = -5;
    }
    return "" + dm;
  }
  
//  /**
//   *
//   */
//  public void development() {
//    Development.main(new String[] {""});
//  }
}
