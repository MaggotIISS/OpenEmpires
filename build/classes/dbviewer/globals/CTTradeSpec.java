/* Copyright (C) 2014 Mark Ferguson This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>. */package dbviewer.globals;import panels.Panel4SubSector;import panels.Panel4TradeCargo;/** <p> @author maggot */public class CTTradeSpec {  //<editor-fold defaultstate="collapsed" desc="Class Variables">  /**   */  private String cargocost = "4.0";  /**   */  private String jumpcost = "30.0";  private static int x = (int) (Math.random() * 6) + 1;  private static int y = (int) (Math.random() * 6) + 1;  /**   purchasedm   */  public static String purchasedm = "0";  /**   saledm   */  public static String saledm = "0";  private static String[] titles;  /**   products   */  public static String[][] products;  /**   uwp   */  public static String uwp = "c333444a";//Panel4SubSector.jTextField1.getText();  /**   trade   */  public static String trade = "Ri Cp";//Panel4SubSector.jComboBox15.getSelectedItem().toString() //  private static String[] parts;  /**   lines   */  public static String lines;  //</editor-fold>  /**   <p>   @param args strings to start   */  public static void main(String[] args) {    //<editor-fold defaultstate="collapsed" desc="DEBUG">    boolean DEBUG = false;    if (DEBUG) { // true or false      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());      //////System.out.print("" + " = " + );    }//</editor-fold>    startup();    //<editor-fold defaultstate="collapsed" desc="getProduct">    String d66 = "" + x + y;    for (int line = 0; line < 36; line++) {      if (products[line][0].toString().equals(d66)) {        for (int column = 0; column < 6; column++) {          System.out.print(products[line][column] + "\t");        }        ////System.out.print("");        purchasedm = getDMs(products[line][3], 3);        saledm = getDMs(products[line][4], 4);//        ////System.out.print("uwp" + " = " + uwp);//        ////System.out.print("trade" + " = " + trade);//        ////System.out.print("purchasedm" + " = " + purchasedm);//        ////System.out.print("saledm" + " = " + saledm);      }    }    ////System.out.print("");    //</editor-fold>  }  private static void startup() {    //<editor-fold defaultstate="collapsed" desc="DEBUG">    boolean DEBUG = false;    if (DEBUG) { // true or false      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());      //////System.out.print("" + " = " + );    }//</editor-fold>    //<editor-fold defaultstate="collapsed" desc="startup">//    ////System.out.print("x" + " = " + x);//    ////System.out.print("y" + " = " + y);    try {      uwp = Panel4SubSector.UWP.getText();    } catch (java.lang.NullPointerException e) {      uwp = "a333444a";    }//    ////System.out.print("uwp" + " = " + uwp);    try {      trade = Panel4SubSector.jcb4Trade.getSelectedItem().toString();    } catch (java.lang.NullPointerException e) {      trade = "Ag Ni";    }//    ////System.out.print("trade" + " = " + trade + GlobalVariables.CRLF);//    ////System.out.print("x+y" + " = " + x + y + GlobalVariables.CRLF);    titles = new String[6];    titles[0] = "D66";    titles[1] = "Trade Goods";    titles[2] = "Base Cr";    titles[3] = "Purchase DMs";    titles[4] = "Sale DMs";    titles[5] = "dtons";    products = new String[36][6];    //</editor-fold>    //<editor-fold defaultstate="collapsed" desc="products">    products[0] = new String[]{"11", "Textiles", "3000", "Ag-7,Na-5,Ni-3",      "Ag-6,Na+1,Ri+3", "3,5"};    products[1] = new String[]{"12", "Polymers", "7000", "In-2,Ri-3,Po+2",      "In-2,Ri+3", "4,5"};    products[2]      = new String[]{"13", "Liquor", "10000", "Ag-4", "Ag-3,In+1,Ri+2", "1,5"};    products[3] = new String[]{"14", "Wood", "1000", "Ag-6", "Ag-6,In+1,Ri+2",      "2,10"};    products[4] = new String[]{"15", "Crystals", "20000", "Na-3,In+4",      "Na-3,In+3,Ri+2", "1,1"};    products[5]      = new String[]{"16", "Radioactives", "1000000", "In+7,Ni-3,Ri+5",        "In+6,Ni-3,Ri-4", "1,1"};    products[6] = new String[]{"21", "Steel", "500", "In-2,Ri-1,Po+1",      "In-2,Ri-1,Po+3", "4,10"};    products[7] = new String[]{"22", "Copper", "2000", "In-3,Ri-2,Po+1",      "In-3,Ri-1", "2,10"};    products[8] = new String[]{"23", "Aluminium", "1000", "In-3,Ri-2,Po+1",      "In-3,Ni+4,Ri-1", "5,10"};    products[9] = new String[]{"24", "Tin", "9000", "In-3,Ri-2,Po+1",      "In-3,Ri-1", "3,10"};    products[10] = new String[]{"25", "Silver", "70000", "In+5,Ri-1,Po+2",      "In+5,Ri-1", "1,5"};    products[11] = new String[]{"26", "Special Alloys", "200000",      "In-3,Ni+5,Ri-2", "In-3,Ni+4,Ri-1", "1,1"};    products[12] = new String[]{"31", "Petrochemicals", "10000",      "Na-4,In+1,Ni-5", "Na-4,In+3,Ni-5", "1,1"};    products[13] = new String[]{"32", "Grain", "300", "Ag-2,Na+1,In+2", "Ag-2",      "8,5"};    products[14] = new String[]{"33", "Meat", "1500", "Ag-2,Na+2,In+3",      "Ag-2,In+2,Po+1", "4,5"};    products[15] = new String[]{"34", "Spices", "6000", "Ag-2,Na+3,In+2",      "Ag-2,Ri+2,Po+3", "1,5"};    products[16] = new String[]{"35", "Fruit", "1000", "Ag-3,Na+1,In+2",      "Ag-2,In+3,Po+2", "2,5"};    products[17] = new String[]{"36", "Pharmaceuticals", "100000",      "Na-3,In+4,Po+3", "Na-3,In+5,Ri+4", "1,1"};    products[18] = new String[]{"41", "Gems", "1000000", "In+4,Ni-8,Po-3",      "In+4,Ni-2,Ri+8", "1,1"};    products[19] = new String[]{"42", "Firearms", "30000", "In-3,Ri-2,Po+3",      "In-2,Ri-1,Po+3", "2,1"};    products[20] = new String[]{"43", "Ammunition", "30000", "In-3,Ri-2,Po+3",      "In-2,Ri-1,Po+3", "2,1"};    products[21] = new String[]{"44", "Blades", "10000", "In-3,Ri-2,Po+3",      "In-2,Ri-1,Po+3", "2,1"};    products[22] = new String[]{"45", "Tools", "10000", "In-3,Ri-2,Po+3",      "In-2,Ri-1,Po+3", "2,1"};    products[23] = new String[]{"46", "Body Armour", "50000", "In-1,Ri-3,Po+3",      "In-2,Ri+1,P+4", "2,1"};    products[24] = new String[]{"51", "Aircraft", "1000000", "In-4,Ri-3",      "Ni+2,Po+1", "1,1"};    products[25] = new String[]{"52", "Air/Raft", "6000000", "In-3,Ri-2",      "Ni+2,Po+1", "1,1"};    products[26] = new String[]{"53", "Computers", "10000000", "In-2,Ri-2",      "Ni+2,Po+1,Ag-3", "1,1"};    products[27] = new String[]{"54", "ATVs", "3000000", "In-2,Ri-2",      "Ni+2,Po+1,Ag+1", "1,1"};    products[28] = new String[]{"55", "Armoured Vehicles", "7000000",      "In-5,Ri-2,Po+4", "Na-2,Ag+2,Ri+1", "1,1"};    products[29] = new String[]{"56", "Farm Machinery", "150000", "In-5,Ri-2",      "Ag+5,Na-8,Po+1", "1,1"};    products[30] = new String[]{"61", "Electronic Parts", "100000", "In-4,Ri-3",      "Ni+2,Po+1", "1,5"};    products[31] = new String[]{"62", "Mechanical Parts", "70000", "In-5,Ri-3",      "Ni-3,Ag+2", "1,5"};    products[32] = new String[]{"63", "Cybernetic Parts", "250000", "In-4,Ri-1",      "Ni+4,Ag+1,Na+2", "1,5"};    products[33] = new String[]{"64", "Computer Parts", "150000", "In-5,Ri-3",      "Ni+3,Ag+1,Na+2", "1,5"};    products[34] = new String[]{"65", "Machine Tools", "750000", "In-5,Ri-4",      "Ni+3,Ag+1,Na+2", "1,5"};    products[35] = new String[]{"66", "Vacc Suits", "400000", "Na-5,In-3,Ri-1",      "Na-1,Ni+2,Po+1", "1,5"};    //</editor-fold>  }  /**   @return the purchasedm   */  public static String getPurchasedm() {    return purchasedm;  }  /**   @param aPurchasedm the purchasedm to set   */  public static void setPurchasedm(String aPurchasedm) {    purchasedm = aPurchasedm;  }  /**   @return the saledm   */  public static String getSaledm() {    return saledm;  }  /**   @param aSaledm the saledm to set   */  public static void setSaledm(String aSaledm) {    saledm = aSaledm;  }  /**   @return the x   */  public static int getX() {    return x;  }  /**   @param aX the x to set   */  public static void setX(int aX) {    x = aX;  }  /**   @return the y   */  public static int getY() {    return y;  }  /**   @param aY the y to set   */  public static void setY(int aY) {    y = aY;  }  /**   @return the titles   */  public static String[] getTitles() {    return titles;  }  /**   @param aTitles the titles to set   */  public static void setTitles(String[] aTitles) {    titles = aTitles;  }  /**   @return the products   */  public static String[][] getProducts() {    return products;  }  /**   @param aProducts the products to set   */  public static void setProducts(String[][] aProducts) {    products = aProducts;  }  /**   @return the uwp   */  public static String getUwp() {    return uwp;  }  /**   @param aUwp the uwp to set   */  public static void setUwp(String aUwp) {    uwp = aUwp;  }  /**   @return the trade   */  public static String getTrade() {    return trade;  }  /**   @param aTrade the trade to set   */  public static void setTrade(String aTrade) {    trade = aTrade;  }  /**   @return the parts   */  public static String[] getParts() {    return parts;  }  /**   @param aParts the parts to set   */  public static void setParts(String[] aParts) {    parts = aParts;  }  /**   @return the lines   */  public static String getLines() {    return lines;  }  /**   @param aLines the lines to set   */  public static void setLines(String aLines) {    lines = aLines;  }  /**   <p>   @param string to get purchanseDM   @return purchaseDM to modify buying cost from CSV   */  public static String getPurchaseDMs(String string) {    //<editor-fold defaultstate="collapsed" desc="DEBUG">    boolean DEBUG = false;    if (DEBUG) { // true or false      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());      //////System.out.print("" + " = " + );    }//</editor-fold>    return getDMs(string, 3);  }  /**   <p>   @param string cargo to retrieve sale DMs   @return salesDM to modify selling cost from CSV   */  public static String getSaleDMs(String string) {    //<editor-fold defaultstate="collapsed" desc="DEBUG">    boolean DEBUG = false;    if (DEBUG) { // true or false      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());      //////System.out.print("" + " = " + );    }//</editor-fold>    return getDMs(string, 4);  }  /**   <p>   @param string to split into parts   @param x      part to show   @return DM from string   */  public static String getDMs(String string, int x) {    //<editor-fold defaultstate="collapsed" desc="DEBUG">    boolean DEBUG = false;    if (DEBUG) { // true or false      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());      //////System.out.print("" + " = " + );    }//</editor-fold>    if (string != null) {      //System.out.print("-----------------\n");      //System.out.print("string = " + string);      switch (Panel4TradeCargo.start) {        case "Panel4TradeCargo": {          //System.out.print("trade" + " = " + trade);          break;        }        case "CTTradeSpec": {          //System.out.print("trade" + " = " + trade);          break;        }        case "Panel4SubSector": {          trade = Panel4SubSector.jcb4Trade.getSelectedItem().toString();          //System.out.print("trade" + " = " + Panel4SubSector.jComboBox6.getSelectedItem().toString());          break;        }      }      //System.out.print("x" + " = " + x);      int num = 0;      String[] bits;      parts = string.split("\",\"");      //System.out.print("parts.length" + " = " + parts.length);      //System.out.print("trade" + " = " + trade);      num = 0;      try {        bits = parts[x].split(" ");      } catch (java.lang.RuntimeException e) {        bits = string.split(",");      }      for (int i = 0; i < bits.length; i++) {        //System.out.print("bits[" + i + "]" + " = " + bits[i].substring(0, 2));        if (trade.contains(bits[i].substring(0, 2))) {          //System.out.print("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX");          try {            num += Integer.parseInt(bits[i].substring(2, 4));          } catch (java.lang.StringIndexOutOfBoundsException e) {            //System.out.print("e" + " = " + e);            //System.out.print("e.getMessage()" + " = " + e.getMessage());            //System.out.print("e.fillInStackTrace()" + " = " + e.fillInStackTrace());            num += 0;          }        }      }      //System.out.print("DM" + " = " + num);      String reply = "" + num;// + " to " + word;      return reply;    }    return null;  }  /**   <p>   @return return CSV line of cargo info   */  public static String getCargo() {    //<editor-fold defaultstate="collapsed" desc="DEBUG">    boolean DEBUG = false;    if (DEBUG) { // true or false      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());      //////System.out.print("" + " = " + );    }//</editor-fold>    startup();    x = (int) (Math.random() * 6) + 1;    ////System.out.print("x" + " = " + x);    ////System.out.print("y" + " = " + y);    y = (int) (Math.random() * 6) + 1;    String d66 = "" + x + y;    ////System.out.print("d66" + " = " + d66);    String pop;    try {      pop = panels.Panel4SubSector.jcb4Pop.getSelectedItem().toString()        .substring(0, 1);    } catch (java.lang.NullPointerException e) {      pop = "3";    }    int num = 0;    try {      num = Integer.parseInt(panels.Panel4SubSector.UWP.getText()        .substring(4, 5));    } catch (java.lang.NullPointerException e) {      num = 6;    } catch (java.lang.NumberFormatException ee) {      switch (panels.Panel4SubSector.UWP.getText().substring(4, 5).toUpperCase()) {        case "A": {          num = 10;          break;        }        case "B": {          num = 11;          break;        }        case "C": {          num = 12;          break;        }        case "D": {          num = 13;          break;        }        case "E": {          num = 14;          break;        }        case "F": {          num = 15;          break;        }        default: {          num = 0;          //System.out.print("CTTradeSpec.java line 426");          break;        }      }    }    for (int i = 0; i < num; i++) {      pop += "0";    }    //System.out.print("population < " + " = " + pop);    lines = "\"";    int line;    for (line = 0; line < 36; line++) {      if (products[line][0].toString().equals(d66)) {        for (int column = 0; column < 6; column++) {          System.out.print(products[line][column] + "\t");          lines += products[line][column] + "\",\"";        }        break;      }    }    ////System.out.print("");    purchasedm = getDMs(products[line][3], 3);    ////System.out.print("purchasedm" + " = " + purchasedm);    saledm = getDMs(products[line][4], 4);    ////System.out.print("saledm" + " = " + saledm);    ////System.out.print("");    return lines.substring(0, lines.length() - 2);  }  /**   <p>   @param cargo CSV to split   @return size in dtons of cargo   */  public static int getSize(String cargo) {    //<editor-fold defaultstate="collapsed" desc="DEBUG">    boolean DEBUG = false;    if (DEBUG) { // true or false      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());      //////System.out.print("" + " = " + );    }//</editor-fold>    ////System.out.print("cargo" + " = " + cargo);    parts = GlobalMethods.stripCSV(cargo);//        GlobalMethods.saveCSV(parts);    showProducts();    for (int i = 0; i < parts.length; i++) {      panels.Panel4TradeCargo.jta        .append("\tparts[" + i + "]" + " = " + parts[i]);    }    int num = 0;    for (int i = 0; i < Integer.parseInt(parts[0]); i++) {      int die = (int) (Math.random() * 6) + 1;      num += die;      ////System.out.print("die" + " = " + die);    }    num *= Integer.parseInt(parts[1]);    ////System.out.print("rolled" + " = " + num);    return num;  }  /**   showProducts   */  public static void showProducts() {    //<editor-fold defaultstate="collapsed" desc="DEBUG">    boolean DEBUG = false;    if (DEBUG) { // true or false      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());      //////System.out.print("" + " = " + );    }//</editor-fold>    for (int i = 0; i < products.length; i++) {      for (int j = 0; j < products[0].length; j++) {        System.out.print("\"" + products[i][j]);        if (j < products[i][5].length()) {          ////System.out.print("\",");        } else {          ////System.out.print("\"");        }      }      ////System.out.print("");    }    ////System.out.print("");    ////System.out.print("cargos" + " = " + Panel4SubSector.p4tc.getCargo());  }  /**   @return the jumpcost   */  public String getJumpcost() {    jumpcost = Panel4SubSector.jLabel1.getText().substring(3);    return jumpcost;  }  /**   @param jumpcost the jumpcost to set   */  public void setJumpcost(String jumpcost) {    this.jumpcost = jumpcost;  }}