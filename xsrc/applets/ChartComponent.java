/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package applets;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

/**

 @author maggot
 */
public class ChartComponent extends JComponent {

  private static double[] values;
  private static String[] names;
  private static String title;
  private static int max = 15;
  private static int panelWidth;
  private static int panelHeight;
  private static int stringWidth;
  private static int stringHeight;
  private static Graphics2D g2;
  private Rectangle2D labelBounds;
  private Color titleColor = Color.black;
  private Paint barColor = Color.lightGray;
  private Color nameColor = Color.black;
  private Color backColor = Color.white;
  private static Font titleFont;
  private static Font labelFont;
  private static long serialVersionUID = 1L;

  /**
   Constructs a ChartComponent.
   @param v the array of values for the chart
   @param n the array of names for the values
   @param t the title of the chart
   @param m maximum value
   */
  public ChartComponent(double[] v, String[] n, String t, int m) {
    super();
    setName("Chart");
    values = v;
    names = n;
    title = t;
    max = m;
  }

  /**
   @param g graphics context
   */
  @Override
  public void paintComponent(Graphics g) {
    setG2((Graphics2D) g);
    getG2().setBackground(getBackColor());

    // compute the minimum and maximum values
    if (getValues() == null) {
      return;
    }
    double minValue = 0;
    double maxValue = 0;
    for (double v : getValues()) {
      if (minValue > v) {
        minValue = v;
      }
      if (maxValue < v) {
        maxValue = v;
      }
    }
    if (maxValue == minValue) {
      return;
    }

    setPanelWidth(getWidth());
    setPanelHeight(getHeight());

    setTitleFont(new Font("SansSerif", Font.BOLD, 20));
    setLabelFont(new Font("SansSerif", Font.PLAIN, 12));

    // compute the extent of the title
    FontRenderContext context = getG2().getFontRenderContext();
    Rectangle2D titleBounds = getTitleFont()
      .getStringBounds(getTitle(), context);
    double titleWidth = titleBounds.getWidth();
    double top = titleBounds.getHeight();

    // draw the title
    double y = -titleBounds.getY(); // ascent
    double x = (getPanelWidth() - titleWidth) / 2;
    getG2().setFont(getTitleFont());
    getG2().setColor(getTitleColor());
    getG2().drawString(getTitle(), (float) x, (float) y);

    // compute the extent of the bar labels
    LineMetrics labelMetrics = getLabelFont().getLineMetrics("", context);
    double bottom = labelMetrics.getHeight();

    y = getPanelHeight() - labelMetrics.getDescent();
    getG2().setFont(getLabelFont());

    // get the scale factor and width for the bars
    double scale = (getPanelHeight() - top - bottom) / getMax();
    int barWidth = getPanelWidth() / getValues().length;

    // draw the bars
    for (int i = 0; i < getValues().length; i++) {
      // get the coordinates of the bar rectangle
      double x1 = i * barWidth + 1;
      double y1 = top + ((getMax() - maxValue) * scale);
      double height = getValues()[i] * scale;
      if (getValues()[i] >= 0) {
        y1 += (maxValue - getValues()[i]) * scale;
      } else {
        y1 += maxValue * scale;
        height = -height;
      }

      // fill the bar and draw the bar outline
      Rectangle2D rect = new Rectangle2D.Double(x1, y1, barWidth - 2, height);
      getG2().setPaint(getBarColor());
      getG2().fill(rect);
      getG2().setPaint(Color.cyan);
      getG2().draw(rect);

      // draw the centered label below the bar
      setLabelBounds(getLabelFont().getStringBounds(getNames()[i], context));

      double labelWidth = getLabelBounds().getWidth();
      x = x1 + (barWidth - labelWidth) / 2;
      getG2().setColor(getNameColor());
      getG2().drawString(getNames()[i], (float) x, (float) y);
    }
//    savePic();
  }

  /**
   @return the values
   */
  public static double[] getValues() {
    return values;
  }

  /**
   @param aValues the values to set
   */
  public static void setValues(double[] aValues) {
    values = aValues;
  }

  /**
   @return the names
   */
  public static String[] getNames() {
    return names;
  }

  /**
   @param aNames the names to set
   */
  public static void setNames(String[] aNames) {
    names = aNames;
  }

  /**
   @param aTitle the title to set
   */
  public static void setTitle(String aTitle) {
    title = aTitle;
  }

  /**
   @return title
   */
  public static String getTitle() {
    return title;
  }

  /**
   @return the max
   */
  public static int getMax() {
    return max;
  }

  /**
   @param aMax the max to set
   */
  public static void setMax(int aMax) {
    max = aMax;
  }

  /**
   @return the panelWidth
   */
  public static int getPanelWidth() {
    return panelWidth;
  }

  /**
   @param aPanelWidth the panelWidth to set
   */
  public static void setPanelWidth(int aPanelWidth) {
    panelWidth = aPanelWidth;
  }

  /**
   @return the panelHeight
   */
  public static int getPanelHeight() {
    return panelHeight;
  }

  /**
   @param aPanelHeight the panelHeight to set
   */
  public static void setPanelHeight(int aPanelHeight) {
    panelHeight = aPanelHeight;
  }

  /**
   @return the serialVersionUID
   */
  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  /**
   @param aSerialVersionUID the serialVersionUID to set
   */
  public static void setSerialVersionUID(long aSerialVersionUID) {
    serialVersionUID = aSerialVersionUID;
  }

  /**
   @param aStringWidth the stringWidth to set
   */
  public static void setStringWidth(int aStringWidth) {
    stringWidth = aStringWidth;
  }

  /**
   @param aStringHeight the stringHeight to set
   */
  public static void setStringHeight(int aStringHeight) {
    stringHeight = aStringHeight;
  }

  /**
   @return the g2
   */
  public static Graphics2D getG2() {
    return g2;
  }

  /**
   @param aG2 the g2 to set
   */
  public static void setG2(Graphics2D aG2) {
    g2 = aG2;
  }

  /**
   @return the titleFont
   */
  public static Font getTitleFont() {
    return titleFont;
  }

  /**
   @param aTitleFont the titleFont to set
   */
  public static void setTitleFont(Font aTitleFont) {
    titleFont = aTitleFont;
  }

  /**
   @return the labelFont
   */
  public static Font getLabelFont() {
    return labelFont;
  }

  /**
   @param aLabelFont the labelFont to set
   */
  public static void setLabelFont(Font aLabelFont) {
    labelFont = aLabelFont;
  }

  /**
   @return width of string
   */
  public int getStringWidth() {
    return stringWidth;
  }

  /**
   @return height of string
   */
  public int getStringHeight() {
    return stringHeight;
  }

  /**
   @return bounds of label
   */
  public Rectangle2D getLabelBounds() {
    return labelBounds;
  }

  /**
   @return the titleColor
   */
  public Color getTitleColor() {
    return titleColor;
  }

  /**
   @param titleColor the titleColor to set
   */
  public void setTitleColor(Color titleColor) {
    this.titleColor = titleColor;
  }

  /**
   @return the barColor
   */
  public Paint getBarColor() {
    return barColor;
  }

  /**
   @param barColor the barColor to set
   */
  public void setBarColor(Paint barColor) {
    this.barColor = barColor;
  }

  /**
   @return the nameColor
   */
  public Color getNameColor() {
    return nameColor;
  }

  /**
   @param nameColor the nameColor to set
   */
  public void setNameColor(Color nameColor) {
    this.nameColor = nameColor;
  }

  /**
   @return the backColor
   */
  public Color getBackColor() {
    return backColor;
  }

  /**
   @param backColor the backColor to set
   */
  public void setBackColor(Color backColor) {
    this.backColor = backColor;
  }

  /**
   @param labelBounds the labelBounds to set
   */
  public void setLabelBounds(Rectangle2D labelBounds) {
    this.labelBounds = labelBounds;
  }

//  public void savePic() {
//    setVisible(true);
//    File f = new File(T5 + FS + "UWP.gif");
//    BufferedImage bi = new BufferedImage(getWidth(), getHeight(), TYPE_INT_RGB);
//    Graphics g = getGraphics();
//
//    Robot r = null;
//    try {
//      r = new Robot();
//    } catch (AWTException ex) {
//      System.out.println("6345" + " = " + ex);
//    }
//    int x = getX();
//    int y = getY() + 40;
//    int w = getWidth();
//    int h = getHeight();
//    bi = r.createScreenCapture(new Rectangle(x, y, w, h));
//    try {
//      ImageIO.write(bi, "gif", f);
//    } catch (IOException ex1) {
//      System.out.println("6352" + " = " + ex1);
//    }
//    System.out.println("x" + " = " + x);
//    System.out.println("y" + " = " + y);
//    System.out.println("w" + " = " + w);
//    System.out.println("h" + " = " + h);
//  }
}
