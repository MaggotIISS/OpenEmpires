/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package starters;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import panels.Frame4;
import panels.Panel4;

/**

 @author maggot
 */
public class MyChart {

  /**

   */
  public static double[] values = {8, 10, 8, 8, 8, 8};

  /**

   */
  public static String[] names
    = {"Str ", "Dex ", "End ", "Int ", "Edu ", "Cha "};

  /**

   */
  public static String title = "UPP";

  /**

   */
  public static int max = 15;

  /**

   */
  public static JPanel jp = new Panel4();

  /**

   */
  public static JFrame jf = new Frame4(jp);

  /**

   */
  public static Component component;

  /**
   * @return the jp
   */
  public static JPanel getJp() {
    return jp;
  }

  /**
   * @param aJp the jp to set
   */
  public static void setJp(JPanel aJp) {
    jp = aJp;
  }

  /**

   */
  public int left = 800;

  /**

   */
  public int top = 0;

  /**

   */
  public int width = 404;

  /**

   */
  public int height = 150;
  private double[] v;
  private String[] n;
  private String t;
  private int m;
  private static Color backColor = Color.white;

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    component = new applets.ChartComponent(values, names, title, max);
    jp.setOpaque(true);
    jp.setBackground(backColor);
    jp.add(component);
    jp.validate();
  }

  /**
   MyChart
   */
  public MyChart() {
    super();
    component = new applets.ChartComponent(values, names, title, max);
    main(new String[]{""});
    jp.removeAll();
    jp.setOpaque(true);
    jp.setBackground(backColor);
    jp.add(component);
    jf.setTitle(t);
    jf.setBounds(left, top, width, height);
    jf.setVisible(true);
//        Panel4T5Locator.panel4Graph = jp;
  }

  /**

   @param v values
   @param n names
   @param t title
   @param m maximum
   */
  public MyChart(double[] v, String[] n, String t, int m) {
    this();
    values = v;
    names = n;
    title = t;
    max = m;
    component = new applets.ChartComponent(values, names, title, max);
    main(new String[]{""});
    jp.removeAll();
    jp.setOpaque(true);
    jp.add(component);
    jf.setTitle(t);
    jf.setVisible(true);
    jp.setBackground(backColor);
    Graphics2D g2 = (Graphics2D) jp.getGraphics();
//    applets.ChartComponent.updateTitleBounds(g2);

  }

  /**
   @param vis boolean of visibility
   */
  public static void setVisible(boolean vis) {
    jf.setVisible(vis);
  }
}
