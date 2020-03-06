/* Copyright (C) 2014 Mark Ferguson This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>. */package dbviewer.globals;import dbviewer.DBViewer;import static dbviewer.globals.GlobalVariables.FS;import static dbviewer.globals.GlobalVariables.T5;import java.awt.Graphics2D;import java.awt.image.BufferedImage;import java.awt.image.WritableRaster;import java.io.File;import java.io.IOException;import java.util.logging.Level;import java.util.logging.Logger;import javax.imageio.ImageIO;import panels.Panel4UTP;/** <p> @author maggot */public class PrintSmall {  /**   <p>   @param string strings to start   */  public static void main(String[] string) {    //<editor-fold defaultstate="collapsed" desc="DEBUG">    boolean DEBUG = true;    if (DEBUG) { // true or false      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]        .getMethodName());      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));    }//</editor-fold>//    String path = null;//    try {//      path = DBViewer.getPath();//    } catch (Exception e) {//      path = GlobalVariables.CSV;//    }    int maxline = 0;    String[] lines;    File f = null;    try {      if ("_CSV".equals(DBViewer.Group.getSelectedItem().toString())) {        System.out.println("string[0]" + " = " + string[0]);        f = new File(string[0]);//      } else {//        f = new File(T5 + FS + "reflection");//        System.out.println("f.toString()" + " = " + f.toString());      }    } catch (Exception e) {      f = new File(T5 + FS + "reflection");      System.out.println("f.toString()" + " = " + f.toString());    }    lines = GlobalMethods.getLinesFromFile(f);    System.out.println("lines.length" + " = " + lines.length);    for (int i = 0; i < lines.length; i++) {      System.out.println("" + " = " + lines[i]);    }    int cols;    try {      cols = lines[0].split("\",\"").length;    } catch (Exception e) {      //cols = lines[0].split(" ").length;      cols = 1;    }    String[] column = new String[cols];    String[] bits = new String[cols * lines.length];    for (int j = 0; j < lines.length; j++) {      String[] parts;      try {        parts = lines[j].split("\",\"");      } catch (Exception e) {        parts = lines;      }      for (int i = 0; i < cols; i++) {        bits[(j * cols) + i] = parts[i].replace("\"", "");        System.out.println("" + " = " + parts[i]);      }    }    for (int col = 0; col < cols; col++) {      int len = 0;      for (int i = 0; i < lines.length; i++) {        String s = bits[((i * cols) + col)];        System.out.println("" + " = " + s);        if (s.length() > len) {          len = s.length();        }      }      System.out.println("max" + " = " + len * 4);      System.out.println("");      maxline += (len + 1);    }    int width = (maxline * 4);    width = (maxline * 4);    int height = (lines.length * 6);    System.out.println("width" + " = " + width);    System.out.println("height" + " = " + height);    BufferedImage bi = new BufferedImage(width, height,      BufferedImage.TYPE_INT_ARGB);    WritableRaster raster = bi.getRaster();    int total = (4 * width * height);    int[] pixels = new int[total];    for (int i = 0; i < pixels.length; i++) {      pixels[i] = 255;    }    raster.setPixels(0, 0, width, height, pixels);    Graphics2D g2 = (Graphics2D) bi.getGraphics();//-----------------------------------------------------//    for (int j = 0; j < cols; j++) {//      int len = 0;//      for (int i = j; i < lines.length; i += cols) {//        String s = bits[((i * cols) + j)];//        //System.out.println("" + " = " + s);//        BufferedImage b = Panel4UTP.strToSmall(3, 5, s);//        //System.out.println("b.getWidth()" + " = " + b.getWidth());//        if (s.length() > len) {//          len = s.length();//        }//        g2.drawImage(b, j * len, 6 * i, null);//      }//    }//-----------------------------------------------------    int start = 0;    for (int col = 0; col < cols; col++) {      int len = 0;      for (int lin = 0; lin < lines.length; lin++) {        String s = bits[(lin * cols) + col];        if (s.length() > 0) {          System.out.println("s" + " = " + s);//        if (s.length() > 0) {          BufferedImage b = Panel4UTP.strToSmall(3, 5, s);//        }          if (s.length() > len) {            len = s.length();          }          g2.drawImage(b, start, 6 * lin, null);        }      }//      System.out.println("");      start += (len * 4) + 4;    }    File out;    try {      try {        out = new File(string[0] + ".gif");      } catch (Exception e) {        out = new File(f.toString() + ".gif");      }      ImageIO.write(bi, "gif", out);      System.out.println("out" + " = " + out);    } catch (IOException ex) {      Logger.getLogger(PrintSmall.class.getName()).log(Level.SEVERE, null, ex);    }//    }  }}