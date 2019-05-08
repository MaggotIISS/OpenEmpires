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
import dbviewer.globals.GlobalVariables;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import static panels.Panel4Squadron.color;
import static panels.Panel4Squadron.sidn;

/**
 <p>
 @author Your Name Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4UTP extends Panel4 {

  //<editor-fold defaultstate="collapsed" desc="variables">
  private Graphics g;
  private Graphics2D g2;
  private int PP;
  private static Frame4 jf;
  static JPanel jp;
  static String CRLF = dbviewer.globals.GlobalVariables.CRLF;
  static Font fo;
  static FontMetrics fm;
  static String str = "";
  static String str1 = "Size";
  static String str2 = "Qlty";
  static String str3 = "Arm.";
  static String str4 = "Type";
  static String str5 = "ID";
  static String str7 = "CF(TF)";
  static String str6 = "Points";
  static String str8 = "TL";
  static int left = 0;
  static int top = 110;
  static int wid = 100;
  static int hgt = 100;
  static int r = 10;
  static int cx = left + (wid / 2);
  static int cy = top + (hgt / 2);
  static int fw;
  static int fh;
  static int cfx;
  static int cfy;
  static String[] lines;
  static String[] replies;
  static int CF;
  static int pts;
  private static String FS = GlobalVariables.FS;
  private static String bmp = GlobalVariables.BMP + FS;
  static Color col = Color.RED;
  BufferedImage bi1;
  BufferedImage bi11;
  BufferedImage bi2;
  BufferedImage bi21;
  BufferedImage bi3;
  BufferedImage bi31;
  BufferedImage bi4;
  BufferedImage bi41;

  //</editor-fold>
  /**
   @param args strings to start
   */
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    jp = new Panel4UTP();
    jf = new Frame4(jp);
    jf.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {
//          GlobalMethods.saveTextFile(Panel4Locator.getPath(),
//            Panel4SubSector.jList1.getSelectedValue().toString(),
          GlobalMethods.saveTextFile(Panel4T5Locator.getSysPath().toString(),
            jf.getTitle(),
            ".utp",
            jta.getText());
        } catch (Exception ex) {
          System.out.println("NO SAVE");
        }
      }
    });
    loadFile();
    countPoints();
    toComboBox(jta, jComboBox1);
    try {
      jf.setTitle(Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim());
    } catch (Exception e) {
      jf.setTitle("Panel4UTP");
    }
    jf.setBounds(1200, 0, 600, 200);
    jf.setVisible(false);
    jLabel11.setText("" + GlobalMethods.fromHex(Panel4T5Locator.UWP.substring(8,
      9)));
    jLabel2.setText(Panel4T5Locator.troopunits.getText());
    jLabel2.setText(Panel4T5Locator.troopunits.getText());
    countPoints();
//    repaint();
  }

  /**
   Creates new form Panel4UTP
   */
  public Panel4UTP() {
    initComponents();
    top = jPanel1.getHeight();
    jPanel1.setBackground(col);
    jPanel2.setBackground(col);
    try {
      jLabel2.setText(Panel4SubSector.troopunits.getText());
    } catch (Exception e) {
      jLabel2.setText("10");
    }
    calcUTP();
  }

  /**
   <p>
   @param g Graphics
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    jp.setBackground(Color.RED);
    left = 0;
    top = 0;
    fo = g.getFont();
    fm = g.getFontMetrics();
    fw = (int) (fm.getStringBounds(str, g).getWidth() / 2);
    fh = (int) (fm.getStringBounds(str, g).getHeight() / 2);
    File[] files = new File[6];
    Image[] images = new Image[6];
    lines = new String[]{str1, str2, str3, str4, str5, str6, str7, str8};
    replies = new String[]{"", "", "", "", "", "", "", ""};
    JComboBox jcb = new JComboBox();
    JComboBox[] jcbs = new JComboBox[]{
      jcb4Size, jcb4Quality, jcb4Armament, jcb4Type
    };
    String fname = "";//jf.getTitle() + "-" + jSpinner1.getValue() + ".gif";
    //<editor-fold defaultstate="collapsed" desc="2nd panel">
    //2nd Panel
    left += wid;
    g.setColor(col);
    g.fillRect(left, top, wid, hgt);
    g.setColor(Color.black);
    g.drawRect(left, top, wid, hgt);

    g.setColor(Color.black);
    for (int i = 0; i < jcbs.length; i++) {
      jcb = jcbs[i];
      replies[i] = jcb.getSelectedItem().toString().substring(2);
      g.drawString(lines[i], left + 2, top + 15 + (i * 11));
      g.drawString(replies[i], left + 32, top + 15 + (i * 11));
    }
    replies[4] = jTextField1.getText();
    replies[5] = "" + (CF * Integer.parseInt(jLabel8.getText()));
    replies[6] = jtf4CF.getText();
    jLabel16.setText(replies[6]);
    replies[7] = jSpinner1.getValue().toString();
    for (int i = 4; i < replies.length; i++) {
      str = lines[i];
      g.drawString(str, left + 2, top + 15 + (i * 11));
      str = replies[i];
      g.drawString(str, left + 42, top + 15 + (i * 11));
    }
    //</editor-fold>//Right
    //<editor-fold defaultstate="collapsed" desc="1st panel">
    //1st Panel
    left -= wid;
    g.setColor(col);
    g.fillRect(left, top, wid, hgt);
    g.setColor(Color.black);
    g.drawRect(left, top, wid, hgt);
    try {
      Image im = ImageIO.read(new File(bmp + "lines.gif"));
      g.drawImage(im, centerOnX(im, left, wid), centerOnY(im, top, hgt), null);
    } catch (IOException ex) {
      Logger.getLogger(Panel4UTP.class.getName()).log(Level.SEVERE, null, ex);
    }
    for (int i = 0; i < files.length; i++) {
      switch (i) {
        case 0: {
          //<editor-fold defaultstate="collapsed" desc="jcb4Size.getSelectedItem().toString()">
          switch (jcb4Size.getSelectedItem().toString()) {
            case "0-Company": {
              str = "I";
              break;
            }
            case "1-Battalion": {
              str = "II";
              break;
            }
            case "2-Regiment": {
              str = "III";
              break;
            }
            case "3-Brigade": {
              str = "IIII";
              break;
            }
            case "4-Division": {
              str = "X";
              break;
            }
            case "5-Corps": {
              str = "XX";
              break;
            }
            case "6-Army": {
              str = "XXX";
              break;
            }
            case "7-Army Group": {
              str = "XXXX";
              break;
            }
            default: {
              break;
            }
          }
          //</editor-fold>
          BufferedImage bi = strToSmall(3, 5, str);
          g.drawImage(bi, centerOnX(bi, 51, 0), 42, null);
          break;
        }
        case 1: {
          //<editor-fold defaultstate="collapsed" desc="jcb4Quality.getSelectedItem().toString()">
          switch (jcb4Quality.getSelectedItem().toString()) {
            case "1-Elite": {
              fname = "launch.gif";
              break;
            }
            default: {
              fname = "";
              break;
            }
          }
          //</editor-fold>
          break;
        }
        case 2: {
          //<editor-fold defaultstate="collapsed" desc="jcb4Armament.getSelectedItem().toString()">
          switch (jcb4Armament.getSelectedItem().toString()) {
            case "1-Armoured": {
              fname = "armor.gif";
              break;
            }
            default: {
              fname = "";
              break;
            }
          }
          //</editor-fold>
          break;
        }
        case 3: {
          //<editor-fold defaultstate="collapsed" desc="jcb4Type.getSelectedItem().toString()">
          switch (jcb4Type.getSelectedItem().toString()) {
            case "0-Infantry": {
              fname = "infantry.gif";
              break;
            }
            case "1-Cavalry": {
              fname = "cavalry.gif";
              break;
            }
            case "2-Marines": {
              fname = "IM.gif";
              break;
            }
            case "3-Jump Troops": {
              fname = "airborne.gif";
              break;
            }
            case "4-Guerilla": {
              fname = "G.gif";
              break;
            }
            default: {
              fname = "";
              break;
            }
          }
          //</editor-fold>
          break;
        }
        case 4: {
          //<editor-fold defaultstate="collapsed" desc="jcb4Mobility.getSelectedItem().toString()">
          switch (jcb4Mobility.getSelectedItem().toString()) {
            case "Grav": {
              fname = "Grav.gif";
              break;
            }
            case "Wheeled": {
              fname = "Wheeled.gif";
              break;
            }
            case "Tracked": {
              fname = "Tracked.gif";
              break;
            }
            default: {
              fname = "";
              break;
            }
          }
          //</editor-fold>
          break;
        }
        default: {
          fname = "";
          break;
        }
      }
//      System.out.println("fname" + " = " +fname);
//      System.out.println("i" + " = " +i);
      try {
        if (!"".equals(fname)) {
          files[i] = new File(bmp + fname);
          images[i] = ImageIO.read(files[i]);
          int x, y;
          x = centerOnX(images[i], left, wid);
          y = centerOnY(images[i], top, hgt);
          switch (i) {
            case 1: {
              g.drawImage(images[i], x - 8, y - 7, null);
              break;
            }
            case 4: {
              g.drawImage(images[i], x, y + 7, null);
              break;
            }
            default: {
              g.drawImage(images[i], x, y, null);
              break;
            }
          }
        }
      } catch (IOException ex) {
        Logger.getLogger(Panel4UTP.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    bi1 = strToSmall(3, 5, jf.getTitle().substring(0, 4));
    g.drawImage(bi1, centerOnX(bi1, 51, 0), 25, null);
    bi11 = strToSmall(3, 5, jTextField1.getText());
    g.drawImage(bi11, centerOnX(bi11, 51, 0), 31, null);
    // CF to bottom left box
    bi2 = strToSmall(3, 5, "CF");
    g.drawImage(bi2, centerOnX(bi2, 29, 0), 61, null);
    int s1 = jtf4CF.getText().indexOf("(");
    bi21 = strToSmall(3, 5, jtf4CF.getText().substring(0, s1));
    g.drawImage(bi21, centerOnX(bi21, 29, 0), 67, null);
    // TF to bottom middle box
    bi3 = strToSmall(3, 5, "TF");
    g.drawImage(bi3, centerOnX(bi3, 51, 0), 61, null);
    int s2 = jtf4CF.getText().indexOf(")");
    bi31 = strToSmall(3, 5, jtf4CF.getText().substring(s1 + 1, s2));
    g.drawImage(bi31, centerOnX(bi31, 51, 0), 67, null);
    // TL to bottom right box
    bi4 = strToSmall(3, 5, "TL");
    g.drawImage(bi4, centerOnX(bi4, 73, 0), 61, null);
    bi41 = strToSmall(3, 5, jLabel11.getText());
    g.drawImage(bi41, centerOnX(bi41, 73, 0), 67, null);
//g.dispose();
    //</editor-fold>//Left
    top = 0;
    left = 0;

    try {
//      jLabel11.setText(Panel4SubSector.UWP.getText().substring(7, 8));
      jLabel11.setText("" + GlobalMethods.fromHex(Panel4T5Locator.UWP.substring(
        8, 9)));
      jLabel2.setText(Panel4SubSector.troopunits.getText());
    } catch (Exception e) {
    }
  }

  /**
   <p>
   @param s "squadron" or "utp"
   */
  @SuppressWarnings("unchecked")
  public static void updatePic(String s) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.println("Panel4UTP.updatePic(" + s + ")");
    }
//</editor-fold>
    JFrame jfa = null;
    JPanel jpa = null;
    JTextArea jtaa = null;
    JLabel jlab = null;
    JComboBox<String> jcb = null;
    switch (s) {
      case "squadron": {
        //001-SR-Scout-U-2-0-11-0-0 = 0.5 pt - 1st Scout Squadron (jf.getTitle==null)
        jpa = Panel4Squadron.getPanel();
        jcb = Panel4Squadron.jComboBox1;
        jtaa = Panel4Squadron.jTextArea1;
        jlab = Panel4Squadron.jLabel6;
        break;
      }
      case "utp": {
        //0001-0000-1(1)-A = 1pt - 1st Company of Regular Light Lift Infantry  (1910-Regina)
        jcb = Panel4UTP.jComboBox1;
        jtaa = Panel4UTP.jta;
        jlab = Panel4UTP.jLabel13;
        break;
      }
    }
    try {
      if (jcb.getItemCount() != 0) {
        String[] lines = jtaa.getText().split(CRLF);
        System.out.println(lines[jcb.getSelectedIndex()]);
        String string = lines[jcb.getSelectedIndex()];
        String id;
        if ("squadron".equals(s)) {
          //001-SR-Scout-U-2-0-11-0-0 = 0.5 pt - 1st Scout Squadron (jf.getTitle==null)
          String[] half = string.split(" = ");
          half[1] = half[1].substring(0, half[1].lastIndexOf("("));
          id = half[0].substring(0, 3);
          System.out.println(id);
          String data = half[0].substring(4);
          System.out.println(data);
          String cost = half[1].substring(0, half[1].indexOf(" pt"));
          System.out.println(cost);
          String home = string.substring(string.indexOf("(") + 1, string
            .indexOf(")"));
          System.out.println(home);
          updateID(id);
          updateCombos(data);
        }
        if ("utp".equals(s)) {
          System.out.println("" + " = " + s);
          id = string.substring(0, 4);
          updateCombos(string);
          updateID(id);
        }
      }
    } catch (Exception e) {
      System.out.println("441" + " = " + e);
    }
  }

  /**
   <p>
   @param x   width of string
   @param y   height of string
   @param str string to add to graphic
   @return string in graphic format (x * str.length() by y pixels)
   */
  public static BufferedImage strToSmall(int x, int y, String str) {
    BufferedImage bi = null;
    if ((x != 0) & (y != 0)) {
      bi = new BufferedImage(str.length() * (x + 1), y,
        BufferedImage.TYPE_INT_ARGB);
      Image[] im = new Image[str.length()];
      Graphics2D createGraphics = bi.createGraphics();
      BufferedImage m;
      String strings = "";
      for (int i = 0; i < str.length(); i++) {
        String name = bmp + x + y + str.substring(i, i + 1).toUpperCase()
          + ".gif";
        File f = new File(name);
        try {
          m = ImageIO.read(f);
          createGraphics.drawImage(m, null, i * 4, 0);
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(jComboBox1, bmp + x + y + str.substring(
            i, i + 1).toUpperCase() + ".gif");
          strings += str.substring(i, i + 1);
        }
      }
    }
    return bi;
  }

  /**
   <p>
   @param num1 number to lengthen
   @return string digit lengthened as required
   */
  public String num2Digit(int num1) {
    String string = "";
    if (num1 < 1000) {
      string += "0";
    }
    if (num1 < 100) {
      string += "0";
    }
    if (num1 < 10) {
      string += "0";
    }
    string += "" + num1;
    return string;
  }

  /**
   <p>
   @param image to centre on
   @param left  of image
   @param wid   of image
   @return x mod
   */
  public static int centerOnX(Image image, int left, int wid) {
    int iw = image.getWidth(null) / 2;
    int bw = wid / 2;
    int reply = left + (bw - iw);
    return reply;
  }

  /**
   <p>
   @param image to centre on
   @param top   of image
   @param hgt   of image
   @return y mod
   */
  public static int centerOnY(Image image, int top, int hgt) {
    int ih = image.getHeight(null) / 2;
    int bh = hgt / 2;
    int reply = top + (bh - ih);
    return reply;
  }

  /**
   <p>
   @param jta JTextArea of items to add to jcb
   @param jcb JComboBox place to add strings from jta
   */
  public static void toComboBox(JTextArea jta, JComboBox<String> jcb) {
    GlobalMethods.toComboBox(jta, jcb);
  }

  static void setHeight(int i) {
    jf.setSize(jf.getHeight(), i);
  }

  static void setTop(int i) {
    jf.setLocation(jf.getX(), i);
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane2 = new javax.swing.JScrollPane();
    jLabel13 = new javax.swing.JLabel();
    jta = new javax.swing.JTextArea();
    jPanel2 = new javax.swing.JPanel();
    jLabel8 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jSpinner1 = new javax.swing.JSpinner();
    jLabel5 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jLabel16 = new javax.swing.JLabel();
    jTextField4 = new javax.swing.JTextField();
    jTextField2 = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jTextField3 = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    jtf4CF = new javax.swing.JTextField();
    jLabel15 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    jcb4Size = new javax.swing.JComboBox();
    jcb4Type = new javax.swing.JComboBox();
    jcb4Quality = new javax.swing.JComboBox();
    jcb4Armament = new javax.swing.JComboBox();
    jButton1 = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    num = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jcb4Mobility = new javax.swing.JComboBox();
    jComboBox1 = new javax.swing.JComboBox();
    jButton2 = new javax.swing.JButton();

    jLabel13.setText("jLabel13");

    jta.setColumns(10);
    jta.setRows(5);
    jta.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jtaMouseClicked(evt);
      }
    });
    jta.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        jtaKeyPressed(evt);
      }
      public void keyTyped(java.awt.event.KeyEvent evt) {
        jtaKeyTyped(evt);
      }
    });

    jPanel2.setOpaque(false);

    jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel8.setText("1");

    jLabel4.setText("0");

    jSpinner1.setModel(new javax.swing.SpinnerListModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"}));
    jSpinner1.setEnabled(false);

    jLabel5.setText("0");

    jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    jTextField1.setText("1234");
    jTextField1.setToolTipText("ID");

    jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel16.setText("0");

    jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    jTextField4.setText("A");
    jTextField4.setToolTipText("TL");

    jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    jTextField2.setText("5678");
    jTextField2.setToolTipText("UTP");

    jLabel6.setText("0");

    jTextField3.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
    jTextField3.setText("9(9)");
    jTextField3.setToolTipText("CF(Transport)");

    jLabel7.setText("0");

    jtf4CF.setText("CF");
    jtf4CF.setToolTipText("CF(TF)");
    jtf4CF.setEnabled(false);

    jLabel15.setForeground(new java.awt.Color(255, 255, 255));
    jLabel15.setText("PP");

    jLabel3.setForeground(new java.awt.Color(255, 255, 255));
    jLabel3.setText("CF");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7)
            .addComponent(jLabel4)
            .addComponent(jLabel6))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
              .addGap(26, 26, 26)
              .addComponent(jLabel5))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15))
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jtf4CF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel6)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel5)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel16)
              .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel3)
              .addComponent(jLabel15))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jtf4CF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel8))))
        .addContainerGap(36, Short.MAX_VALUE))
    );

    setBackground(java.awt.Color.red);
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        formMouseClicked(evt);
      }
    });

    jPanel1.setBackground(new java.awt.Color(0, 0, 0));

    jcb4Size.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0-Company", "1-Battalion", "2-Regiment", "3-Brigade", "4-Division", "5-Corps", "6-Army", "7-Army Group" }));
    jcb4Size.setSelectedIndex(4);
    jcb4Size.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbsActionPerformed(evt);
      }
    });

    jcb4Type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0-Infantry", "1-Cavalry", "2-Marines", "3-Jump Troops", "4-Guerilla" }));
    jcb4Type.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbsActionPerformed(evt);
      }
    });

    jcb4Quality.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0-Regular", "1-Elite" }));
    jcb4Quality.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbsActionPerformed(evt);
      }
    });

    jcb4Armament.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0-Light", "1-Armoured" }));
    jcb4Armament.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbsActionPerformed(evt);
      }
    });

    jButton1.setText("ADD");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jLabel2.setBackground(new java.awt.Color(255, 255, 255));
    jLabel2.setForeground(java.awt.Color.lightGray);
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel2.setText("10");

    jLabel1.setBackground(new java.awt.Color(255, 255, 255));
    jLabel1.setForeground(new java.awt.Color(0, 255, 0));
    jLabel1.setText("Points -");
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    jLabel11.setBackground(new java.awt.Color(255, 255, 255));
    jLabel11.setForeground(java.awt.Color.lightGray);
    jLabel11.setText("A");

    jLabel10.setBackground(new java.awt.Color(255, 255, 255));
    jLabel10.setForeground(new java.awt.Color(0, 255, 0));
    jLabel10.setText("TL");
    jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel10MouseClicked(evt);
      }
    });

    num.setBackground(new java.awt.Color(255, 255, 255));
    num.setForeground(java.awt.Color.lightGray);
    num.setText("0");
    num.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
    });
    num.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        numPropertyChange(evt);
      }
    });

    jLabel9.setBackground(new java.awt.Color(255, 255, 255));
    jLabel9.setForeground(java.awt.Color.lightGray);
    jLabel9.setText("=");

    jLabel12.setBackground(new java.awt.Color(255, 255, 255));
    jLabel12.setForeground(java.awt.Color.lightGray);
    jLabel12.setText("0");
    jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelMouseClicked(evt);
      }
    });

    jcb4Mobility.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Grav", "Wheeled", "Tracked" }));
    jcb4Mobility.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbsActionPerformed(evt);
      }
    });

    jComboBox1.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        jComboBox1ItemStateChanged(evt);
      }
    });
    jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jComboBox1MouseClicked(evt);
      }
    });
    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox1ActionPerformed(evt);
      }
    });
    jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jComboBox1PropertyChange(evt);
      }
    });

    jButton2.setText("X");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jcb4Armament, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jcb4Size, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jcb4Mobility, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, 0)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jButton1)
              .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jcb4Type, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jcb4Quality, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(num)
            .addGap(0, 0, 0)
            .addComponent(jLabel9)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel12)))
        .addGap(0, 0, Short.MAX_VALUE))
    );

    jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jcb4Armament, jcb4Mobility, jcb4Quality, jcb4Size, jcb4Type});

    jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jcb4Size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(num)
                .addComponent(jLabel9)
                .addComponent(jLabel12))
              .addComponent(jcb4Quality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel10)
            .addComponent(jLabel11)
            .addComponent(jLabel2)))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jcb4Armament, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jcb4Mobility, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton2)
          .addComponent(jcb4Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 197, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
      .addGroup(layout.createSequentialGroup()
        .addGap(223, 223, 223)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(0, 0, 0))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMouseClicked
    num.setText("0");
    jLabel12.setText("0");
    countPoints();
  }//GEN-LAST:event_jLabelMouseClicked

  private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
    jLabel11.setText("" + GlobalMethods.fromHex(Panel4T5Locator.UWP.substring(8,
      9)));
    calcUTP();
    repaint();
  }//GEN-LAST:event_jLabel10MouseClicked

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    jLabel2.setText(Panel4T5Locator.troopunits.getText());
    countPoints();
    repaint();
  }//GEN-LAST:event_jLabel1MouseClicked

  @SuppressWarnings("unchecked")
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    //Add text line to jta
    try {
      calcUTP();
      repaint();
      int num1 = jta.getLineCount();
      String string = num2Digit(num1);
      jTextField1.setText(string);
      text = jcb4Size.getSelectedItem().toString().substring(0, 1)
        + jcb4Quality.getSelectedItem().toString().substring(0, 1)
        + jcb4Armament.getSelectedItem().toString().substring(0, 1)
        + jcb4Type.getSelectedItem().toString().substring(0, 1);
      jTextField2.setText(text);
      jTextField3.setText(CF + "(" + jLabel4.getText() + ")");
      jTextField4.setText(jSpinner1.getValue().toString());
      text = "";
      String num = jTextField1.getText();
      int pos = 0;
      for (int i = 0; i < num.length(); i++) {
        if ("0".equals(num.substring(i, i + 1))) {
          pos = i + 1;
        } else {
          break;
        }
      }
      String line = num.substring(pos);
      System.out.print("" + " = " + line);
      int j = Integer.parseInt(line);
      if (!(j > 10 & j < 20)) {
        if (line.endsWith("1")) {
          line += "st";
        } else if (line.endsWith("2")) {
          line += "nd";
        } else if (line.endsWith("3")) {
          line += "rd";
        } else {
          line += "th";
        }
      } else {
        line += "th";
      }
      System.out.println("" + " = " + line);
      text += line + " ";

      for (int i = 0; i < 4; i++) {
//      if (!replies[i].isEmpty()) {
        text += replies[i] + " ";
        if (i == 0) {
          text += "of ";
        }
        if (i == 2) {
          System.out.println("" + " = " + jcb4Type.getSelectedItem().toString());
          if ((jcb4Type.getSelectedItem().toString().equals("0-Infantry")
            | (jcb4Type.getSelectedItem().toString().equals("1-Cavalry")))
            & jcb4Mobility.getSelectedItem().toString().equals("Grav")) {
            text += "Lift ";
          } else {
            text += jcb4Mobility.getSelectedItem().toString() + " ";
          }
        }
//      }
      }
      text += " (" + jf.getTitle() + ")";
      // are there enough pts left to buy unit?
      int remaining = Integer.parseInt(jLabel12.getText());
      int cost = Integer.parseInt(replies[5]);
      if ((remaining - cost) >= 0) {
        jta.append(jTextField1.getText() + "-"
          + jTextField2.getText() + "-"
          + jTextField3.getText() + "-"
          + jTextField4.getText() + " = "
          + replies[5] + "pt -");
        jta.append(" " + text + CRLF);
        repaint();
        countPoints();
        toComboBox(jta, jComboBox1);
        jta.validate();
        jComboBox1.setSelectedIndex(num1 - 1);
        image2Pic("utp");
        Panel4T5Troop.jTextArea1.setText(jta.getText());
        Panel4T5Troop.jComboBox1.setModel(Panel4UTP.jComboBox1.getModel());
      }
    } catch (Exception e) {
      System.out.println("");
      System.out.println("1095" + " = " + e.toString());
      System.out.println("Panel4T5Troop.jTextArea1.getText()" + " = "
        + Panel4T5Troop.jTextArea1.getText());
      System.out.println("text" + " = " + text);
      System.out.println("jLabel11.getText()" + " = " + jLabel11.getText());
      System.out.println("jta.getText()" + " = " + jta.getText());
    }

  }//GEN-LAST:event_jButton1ActionPerformed
  String text = "";

  private void jtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtaMouseClicked
//    int max = jta.getLineCount();
//    //System.out.println("max" + " = " + max);
//    String[] txt = jta.getText().split(CRLF);
//    for (int i = 0; i < txt.length; i++) {
//      if (txt[i].contains(" = ")) {
//        int start = txt[i].indexOf(" = ") + 3;
//        //System.out.println("" + " = " + txt[i].substring(start));
//      }
//    }
    countPoints();
    Panel4Squadron.updatePic("utp");
  }//GEN-LAST:event_jtaMouseClicked

  private void jcbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbsActionPerformed
    if (jcb4Type.getSelectedIndex() == 2 | jcb4Type.getSelectedIndex() == 3) {
      jLabel8.setText("2");
    } else {
      jLabel8.setText("1");
    }
    //String path = GlobalVariables.BMP + "/";
    calcUTP();
    repaint();

  }//GEN-LAST:event_jcbsActionPerformed

  private void jtaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaKeyPressed
    countPoints();
  }//GEN-LAST:event_jtaKeyPressed

  private void jtaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaKeyTyped
    countPoints();
  }//GEN-LAST:event_jtaKeyTyped

  @SuppressWarnings("unchecked")
  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    deletePics("utp");
    jta.setText("");
    toComboBox(jta, jComboBox1);
    countPoints();
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
//<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
//    System.out.println("jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)");
    updatePic("utp");
  }//GEN-LAST:event_jComboBox1ActionPerformed

  private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
//<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
//    System.out.println("jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt)");
  }//GEN-LAST:event_jComboBox1ItemStateChanged

  private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
//<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
//    System.out.println("jComboBox1MouseClicked(java.awt.event.MouseEvent evt)");
  }//GEN-LAST:event_jComboBox1MouseClicked

  private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange
//<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
//    System.out.println("jComboBo`x1PropertyChange(java.beans.PropertyChangeEvent evt)");
    updatePic("utp");
  }//GEN-LAST:event_jComboBox1PropertyChange

  private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    if (evt.getClickCount() > 1) {
      JPanel p4c = new Panel4("Colours");
      JColorChooser jcc = new JColorChooser(JColorChooser.showDialog(p4c, FS,
        Color.LIGHT_GRAY));
      col = jcc.getColor();
      jcc.setVisible(true);
      jp.setBackground(col);
      jf.setBackground(col);
//      image2Pic("utp");
    }
  }//GEN-LAST:event_formMouseClicked

  private void numPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_numPropertyChange
    Panel4T5Troop.spent.setText(num.getText());
  }//GEN-LAST:event_numPropertyChange

  // Variables declaration - do not modify//GEN-BEGIN:variables
  static javax.swing.JButton jButton1;
  static javax.swing.JButton jButton2;
  static javax.swing.JComboBox jComboBox1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private static javax.swing.JLabel jLabel11;
  private static javax.swing.JLabel jLabel12;
  public static javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel15;
  static javax.swing.JLabel jLabel16;
  private static javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  static javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private static javax.swing.JScrollPane jScrollPane2;
  static javax.swing.JSpinner jSpinner1;
  static javax.swing.JTextField jTextField1;
  private javax.swing.JTextField jTextField2;
  private javax.swing.JTextField jTextField3;
  private static javax.swing.JTextField jTextField4;
  static javax.swing.JComboBox jcb4Armament;
  static javax.swing.JComboBox jcb4Mobility;
  static javax.swing.JComboBox jcb4Quality;
  static javax.swing.JComboBox jcb4Size;
  static javax.swing.JComboBox jcb4Type;
  public static javax.swing.JTextArea jta;
  static javax.swing.JTextField jtf4CF;
  private static javax.swing.JLabel num;
  // End of variables declaration//GEN-END:variables

  static void countPoints() {
    int count = jta.getLineCount();
    int sub = 0;
    int start = 0;
    try {
      start = Integer.parseInt(jLabel2.getText());
    } catch (Exception e) {
    }
    String[] txt = jta.getText().split(CRLF);
    String string = "=";
    for (int i = 0; i < txt.length; i++) {
      if (txt[i].contains(string)) {
        int pos = txt[i].indexOf(string) + 2;
        int end = txt[i].lastIndexOf("pt");
        sub += Integer.parseInt(txt[i].substring(pos, end));
      }
    }
    num.setText("" + sub);
    jLabel12.setText("" + (start - sub));
  }

  /**
   <p>
   @param pos the value of split
   */
  private void addCounters(int pos) {
//    //CBCounter
//    wid = 40;
//    hgt = 40;
//    left = 0 + (pos * wid);
//    top = 110;
//    Color countercolour = Color.white;
//    g.setColor(countercolour);
//    g.fillRoundRect(left, top, wid, hgt, r, r);
//    Color bordercolor = Color.black;
//    g.setColor(bordercolor);
//    g.drawRoundRect(left, top, wid, hgt, r, r);
  }

  private void calcUTP() {
    //<editor-fold defaultstate="collapsed" desc="Size">
    int s = 0;
    switch (jcb4Size.getSelectedItem().toString()) {
      case "0-Company": {
        s = 1;
        break;
      }
      case "1-Battalion": {
        s = 2;
        break;
      }
      case "2-Regiment": {
        s = 5;
        break;
      }
      case "3-Brigade": {
        s = 10;
        break;
      }
      case "4-Division": {
        s = 20;
        break;
      }
      case "5-Corps": {
        s = 50;
        break;
      }
      case "6-Army": {
        s = 100;
        break;
      }
      case "7-Army Group": {
        s = 500;
        break;
      }
    }
    jLabel4.setText("" + s);
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Armament">
    int t = 0;
    switch (jcb4Armament.getSelectedItem().toString()) {
      case "0-Light": {
        t = 1;
        break;
      }
      case "1-Armoured": {
        t = 2;
        break;
      }
    }
    jLabel6.setText("" + t);
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Type">
    int a = 0;
    switch (jcb4Type.getSelectedItem().toString()) {
      case "0-Infantry": {
        a = 1;
        break;
      }
      case "1-Cavalry": {
        a = 1;
        break;
      }
      case "2-Marine": {
        a = 2;
        break;
      }
      case "3-Jump Troops": {
        a = 2;
        break;
      }
      case "4-Guerilla": {
        a = 1;
        break;
      }
    }
//    jLabel13.setText("" + a);
    jLabel5.setText("1");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Quality">
    int q = 0;
    switch (jcb4Quality.getSelectedItem().toString()) {
      case "0-Regular": {
        q = 1;
        break;
      }
      case "1-Elite": {
        q = 2;
        break;
      }
    }
    jLabel7.setText("" + q);
    //</editor-fold>
    String tl = jLabel11.getText();
    jSpinner1.setValue(tl);
    int si = Integer.parseInt(jLabel4.getText());
    int ar = Integer.parseInt(jLabel6.getText());
    int ty = Integer.parseInt(jLabel5.getText());
    int qu = Integer.parseInt(jLabel7.getText());
    CF = si * ar * ty * qu;
    PP = CF * (Integer.parseInt(jLabel8.getText()));
    //jLabel8.setText("" + cf);
    jtf4CF.setText("" + CF + "(" + si + ")");
    int num2 = jta.getLineCount();
    String string = "";
    if (num2 < 1000) {
      string += "0";
    }
    if (num2 < 100) {
      string += "0";
    }
    if (num2 < 10) {
      string += "0";
    }
    string += "" + num2;
    jTextField1.setText(string);
    string = jcb4Size.getSelectedItem().toString().substring(0, 1)
      + jcb4Quality.getSelectedItem().toString().substring(0, 1)
      + jcb4Armament.getSelectedItem().toString().substring(0, 1)
      + jcb4Type.getSelectedItem().toString().substring(0, 1);
    jTextField2.setText(string);
    jTextField3.setText(jLabel8.getText().toString() + "(" + jLabel4.getText()
      .toString() + ")");
    jTextField4.setText(jSpinner1.getValue().toString());
    repaint();
  }

  private static void loadFile() {
    try {
      String s = GlobalVariables.IMP + FS
        + Panel4Locator.getSectorName().substring(0, 4).toUpperCase() + FS
        + Panel4Locator.getSubSectorName() + FS
        + jf.getTitle()
        + ".utp";
      File f = new File(s);
      String txt = GlobalMethods.loadTextFile(s);
      if (!txt.contains("utp")) {
        jta.setText(txt);
      } else {
        jta.setText("");
      }
    } catch (Exception e) {
      System.out.println("1135 File not ready");
      jta.setText("");
    }
  }

  private static void updateID(String id) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
//</editor-fold>
    if (id.length() == 3) {
      sidn.setText(id);
    } else if (id.length() == 4) {
      System.out.println("id.length()" + " = " + id.length());
      jTextField1.setText(id);
    }
  }

  private static void updateCombos(String data) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
//</editor-fold>
    String[] parts = data.split("-");
    for (int i = 0; i < parts.length; i++) {
      System.out.println("" + i + " = " + parts[i]);
    }
    System.out.println("parts.length" + " = " + parts.length);

    if (parts.length == 8) {
      //001-SR-Scout-U-2-0-11-0-0 = 0.5 pt - 1st Scout Squadron (jf.getTitle==null)
      Panel4Squadron.sron.setText(parts[0]);
      for (int i = 0; i < Panel4Squadron.jComboBox0.getItemCount(); i++) {
        if (Panel4Squadron.jComboBox0.getItemAt(i).toString().startsWith(
          Panel4Squadron.sron.getText())) {
          Panel4Squadron.jComboBox0.setSelectedIndex(i);
        }
      }
      Panel4Squadron.jComboBox0.setSelectedItem(Panel4Squadron.sron);
      Panel4Squadron.ns.setText(parts[2]);
      Panel4Squadron.nj.setText(parts[3]);
      Panel4Squadron.nd.setText(parts[5]);
      Panel4Squadron.na.setText(parts[6]);
      Panel4Squadron.nb.setText(parts[7]);
      Panel4Squadron.nt.setText(parts[4]);
    } else {
      //0001-0000-1(1)-A = 1pt - 1st Company of Regular Light Lift Infantry  (1910-Regina)
      jTextField1.setText(parts[0]);
      System.out.println("" + " = " + parts.length);
      jcb4Size.setSelectedIndex(Integer.parseInt(parts[1].substring(0, 1)));
      jcb4Quality.setSelectedIndex(Integer.parseInt(parts[1].substring(1, 2)));
      jcb4Armament.setSelectedIndex(Integer.parseInt(parts[1].substring(2, 3)));
      jcb4Type.setSelectedIndex(Integer.parseInt(parts[1].substring(3, 4)));
    }
  }

  /**
   <p>
   @param type the value of pic
   */
  static void deletePics(String type) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
//</editor-fold>
    File f = new File(Panel4T5Locator.getSysPath());
    String fname = getFNameLen(type);
    System.out.print("" + " = " + f.toString() + FS);
    System.out.println(fname);
    String[] files = f.list();
    for (int i = 0; i < files.length; i++) {
      boolean truth = false;
      if (files[i].startsWith(jf.getTitle()) & files[i].length() == fname
        .length()) {
        try {
          File fi = new File(f + FS + files[i]);
          System.out.println("" + " = " + fi.toString());
          if (fi.exists()) {
            truth = fi.delete();
          }
        } catch (Exception e) {
          System.out.println("1514" + " = " + e);
          System.out.println("" + " = " + truth);
        }
//        JOptionPane.showMessageDialog(jComboBox1, "deleted = " + truth);
      }
    }

  }

  static String getFNameLen(String type) {
    String fname = null;
    try {
      fname = jf.getTitle() + "-";
      if ("squadron".equals(type)) {
        fname += "???";
      }
      if ("utp".equals(type)) {
        fname += "????";
      }
      fname += ".gif";
      return fname;
    } catch (Exception e) {
      System.out.println("jf.getTitle()" + " = " + jf.getTitle());
      System.out.println("type" + " = " + type);
      System.out.println("fname" + " = " + fname);
      return "OOPS @ 1459 = " + e.toString();
    }
  }

  static void image2Pic(String name) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
//</editor-fold>
    BufferedImage bi;
    File f = null;
    int w = 100, h = 100;
    switch (name) {
      case "squadron": {
        w = 200;
        h = 100;
        f = new File(Panel4T5Locator.getSysPath() + FS
          + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().substring(0, 4)
          + "-" + Panel4Squadron.sidn.getText() + ".gif");
        break;
      }
      case "utp": {
        w = 200;
        h = 100;
        f = new File(Panel4T5Locator.getSysPath() + FS
          + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().substring(0, 4)
          + "-" + jTextField1.getText() + ".gif");
        break;
      }
    }
    try {
      bi = ImageIO.read(f);
    } catch (IOException ex) {
      bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
      System.out.println("FAIL load image2Pic " + f.toString());
    }
    Graphics2D g = bi.createGraphics();
    //g.setColor(jf.getBackground());
    switch (name) {
      case "squadron": {
        g.setColor(Color.CYAN);
        color = Color.CYAN;
        break;
      }
      case "utp": {
        g.setColor(Color.RED);
        color = Color.RED;
        break;
      }
    }
    g.fillRect(0, 0, w, h);

    if (name.equals("squadron")) {
      //<editor-fold defaultstate="collapsed" desc="left panel">
      try {
        g.setColor(color);
        g.fillRect(0, 0, 100, 100);
        g.setColor(Color.black);
        g.drawRect(0, 0, 100, 100);

        Image im = ImageIO.read(new File(bmp + "lines.gif"));

        Panel4UTP.centerOnY(im, 0, 100);

        // Squadron Type
        BufferedImage bii1 = Panel4UTP.strToSmall(3, 5,
          Panel4Squadron.jComboBox0.getSelectedItem().toString().substring(0, 2));
        g.drawImage(bii1, Panel4UTP.centerOnX(bii1, 29, 0), 25, null);

        // Home hex
        BufferedImage bi1 = Panel4UTP.strToSmall(3, 5,
          Panel4Squadron.jf.getTitle().substring(0, 4));
        g.drawImage(bi1, Panel4UTP.centerOnX(bi1, 51, 0), 25, null);
        // Fleet ID
        BufferedImage bi11 = Panel4UTP.strToSmall(3, 5,
          Panel4Squadron.sidn.getText());
        g.drawImage(bi11, Panel4UTP.centerOnX(bi11, 51, 0), 31, null);

        // Streamlining and Jump to middle left box
        BufferedImage bi00 = Panel4UTP.strToSmall(3, 5,
          Panel4Squadron.ns.getText().substring(0, 1) + "SL");
        g.drawImage(bi00, Panel4UTP.centerOnX(bi00, 29, 0), 43, null);
        //      int s1 = jtf4CF.getText().indexOf("(");
        BufferedImage bi0021 = Panel4UTP.strToSmall(3, 5,
          "J " + Panel4Squadron.nj.getText());
        g.drawImage(bi0021, Panel4UTP.centerOnX(bi0021, 29, 0), 49, null);

        // TF to middle right box
        BufferedImage bi0 = Panel4UTP.strToSmall(3, 5, "TF");
        g.drawImage(bi0, Panel4UTP.centerOnX(bi0, 73, 0), 43, null);
        //      int s1 = jtf4CF.getText().indexOf("(");
        BufferedImage bi021 = Panel4UTP.strToSmall(3, 5,
          Panel4Squadron.nt.getText());
        g.drawImage(bi021, Panel4UTP.centerOnX(bi021, 73, 0), 49, null);

        // DF to bottom left box
        BufferedImage bi2 = Panel4UTP.strToSmall(3, 5, "DF");
        g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 29, 0), 61, null);
        //      int s1 = jtf4CF.getText().indexOf("(");
        BufferedImage bi21 = Panel4UTP.strToSmall(3, 5,
          Panel4Squadron.nd.getText());
        g.drawImage(bi21, Panel4UTP.centerOnX(bi21, 29, 0), 67, null);

        // AF to bottom middle box
        BufferedImage bi3 = Panel4UTP.strToSmall(3, 5, "AF");
        g.drawImage(bi3, Panel4UTP.centerOnX(bi3, 51, 0), 61, null);
        //      int s2 = jtf4CF.getText().indexOf(")");
        BufferedImage bi31 = Panel4UTP.strToSmall(3, 5,
          Panel4Squadron.na.getText());
        g.drawImage(bi31, Panel4UTP.centerOnX(bi31, 51, 0), 67, null);

        // BF to bottom right box
        BufferedImage bi4 = Panel4UTP.strToSmall(3, 5, "BF");
        g.drawImage(bi4, Panel4UTP.centerOnX(bi4, 73, 0), 61, null);
        BufferedImage bi41 = Panel4UTP.strToSmall(3, 5,
          Panel4Squadron.nb.getText());
        g.drawImage(bi41, Panel4UTP.centerOnX(bi41, 73, 0), 67, null);
        //    } catch (IOException ex) {
        //      Logger.getLogger(Panel4UTP.class.getName()).log(Level.SEVERE, null, ex);
        //    }
      } catch (IOException ex) {
        Logger.getLogger(Panel4Squadron.class.getName()).log(Level.SEVERE, null,
          ex);
        System.out.println("" + " = " + ex.toString());
      }
      BufferedImage pc = null;
      try {
        pc = ImageIO.read(new File(Panel4Squadron.folder + Panel4Squadron.pic));
        g.drawImage(pc, Panel4UTP.centerOnX(pc, 50, 0), 46, null);
      } catch (IOException ex) {
        Logger.getLogger(Panel4Squadron.class.getName()).log(Level.SEVERE, null,
          ex);
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="right panel">
      //2nd Panel
      int left = 100;
      int tops = 0;
      int wid = 100;
      int hgt = 100;
      int r = 10;
      g.setColor(color);
      g.fillRect(left, tops, wid, hgt);
      g.setColor(Color.black);
      g.drawRect(left, tops, wid, hgt);
      Panel4Squadron.titles = new String[]{"ID", "TYPE", "S/L", "JUMP", "TF",
        "DF", "AF", "BF"};
      Panel4Squadron.values = new String[]{sidn.getText(),
        Panel4Squadron.sron.getText(), Panel4Squadron.ns.getText(),
        Panel4Squadron.nj.getText(), Panel4Squadron.nt.getText(),
        Panel4Squadron.nd.getText(), Panel4Squadron.na.getText(),
        Panel4Squadron.nb.getText()
      };
      for (int i = 0; i < 8; i++) {
        g.drawString(Panel4Squadron.titles[i], left + 2, tops + 15 + (i * 11));
        g.drawString(Panel4Squadron.values[i], left + 37, tops + 15 + (i * 11));
      }
      //</editor-fold>//Right
    }
    if (name.equals("utp")) {
      //<editor-fold defaultstate="collapsed" desc="comment">
      left = 0;
      top = 0;
      fo = g.getFont();
      fm = g.getFontMetrics();
      fw = (int) (fm.getStringBounds(str, g).getWidth() / 2);
      fh = (int) (fm.getStringBounds(str, g).getHeight() / 2);
      File[] files = new File[6];
      Image[] images = new Image[6];
      lines = new String[]{str1, str2, str3, str4, str5, str6, str7, str8};
      replies = new String[]{"", "", "", "", "", "", "", ""};
      JComboBox jcb = new JComboBox();
      JComboBox[] jcbs = new JComboBox[]{
        jcb4Size, jcb4Quality, jcb4Armament, jcb4Type
      };
      String fname = "";//jf.getTitle() + "-" + jSpinner1.getValue() + ".gif";
      //<editor-fold defaultstate="collapsed" desc="2nd panel">
      //2nd Panel
      left += wid;
      g.setColor(col);
      g.fillRect(left, top, wid, hgt);
      g.setColor(Color.black);
      g.drawRect(left, top, wid, hgt);

      g.setColor(Color.black);
      for (int i = 0; i < jcbs.length; i++) {
        jcb = jcbs[i];
        replies[i] = jcb.getSelectedItem().toString().substring(2);
        g.drawString(lines[i], left + 2, top + 15 + (i * 11));
        g.drawString(replies[i], left + 32, top + 15 + (i * 11));
      }
      replies[4] = jTextField1.getText();
      replies[5] = "" + (CF * Integer.parseInt(jLabel8.getText()));
      replies[6] = jtf4CF.getText();
      jLabel16.setText(replies[6]);
      replies[7] = jSpinner1.getValue().toString();
      for (int i = 4; i < replies.length; i++) {
        str = lines[i];
        g.drawString(str, left + 2, top + 15 + (i * 11));
        str = replies[i];
        g.drawString(str, left + 42, top + 15 + (i * 11));
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="1st panel">
      //1st Panel
      left -= wid;
      g.setColor(col);
      g.fillRect(left, top, wid, hgt);
      g.setColor(Color.black);
      g.drawRect(left, top, wid, hgt);
      try {
        Image im = ImageIO.read(new File(bmp + "lines.gif"));
        g.drawImage(im, centerOnX(im, left, wid), centerOnY(im, top, hgt), null);
      } catch (IOException ex) {
        Logger.getLogger(Panel4UTP.class.getName()).log(Level.SEVERE, null, ex);
      }
      for (int i = 0; i < files.length; i++) {
        switch (i) {
          case 0: {
            //<editor-fold defaultstate="collapsed" desc="jcb4Size.getSelectedItem().toString()">
            switch (jcb4Size.getSelectedItem().toString()) {
              case "0-Company": {
                str = "I";
                break;
              }
              case "1-Battalion": {
                str = "II";
                break;
              }
              case "2-Regiment": {
                str = "III";
                break;
              }
              case "3-Brigade": {
                str = "IIII";
                break;
              }
              case "4-Division": {
                str = "X";
                break;
              }
              case "5-Corps": {
                str = "XX";
                break;
              }
              case "6-Army": {
                str = "XXX";
                break;
              }
              case "7-Army Group": {
                str = "XXXX";
                break;
              }
              default: {
                break;
              }
            }
            //</editor-fold>
            BufferedImage biq = strToSmall(3, 5, str);
            g.drawImage(biq, centerOnX(biq, 51, 0), 42, null);
            break;
          }
          case 1: {
            //<editor-fold defaultstate="collapsed" desc="jcb4Quality.getSelectedItem().toString()">
            switch (jcb4Quality.getSelectedItem().toString()) {
              case "1-Elite": {
                fname = "launch.gif";
                break;
              }
              default: {
                fname = "";
                break;
              }
            }
            //</editor-fold>
            break;
          }
          case 2: {
            //<editor-fold defaultstate="collapsed" desc="jcb4Armament.getSelectedItem().toString()">
            switch (jcb4Armament.getSelectedItem().toString()) {
              case "1-Armoured": {
                fname = "armor.gif";
                break;
              }
              default: {
                fname = "";
                break;
              }
            }
            //</editor-fold>
            break;
          }
          case 3: {
            //<editor-fold defaultstate="collapsed" desc="jcb4Type.getSelectedItem().toString()">
            switch (jcb4Type.getSelectedItem().toString()) {
              case "0-Infantry": {
                fname = "infantry.gif";
                break;
              }
              case "1-Cavalry": {
                fname = "cavalry.gif";
                break;
              }
              case "2-Marines": {
                fname = "IM.gif";
                break;
              }
              case "3-Jump Troops": {
                fname = "airborne.gif";
                break;
              }
              case "4-Guerilla": {
                fname = "G.gif";
                break;
              }
              default: {
                fname = "";
                break;
              }
            }
            //</editor-fold>
            break;
          }
          case 4: {
            //<editor-fold defaultstate="collapsed" desc="jcb4Mobility.getSelectedItem().toString()">
            switch (jcb4Mobility.getSelectedItem().toString()) {
              case "Grav": {
                fname = "Grav.gif";
                break;
              }
              case "Wheeled": {
                fname = "Wheeled.gif";
                break;
              }
              case "Tracked": {
                fname = "Tracked.gif";
                break;
              }
              default: {
                fname = "";
                break;
              }
            }
            //</editor-fold>
            break;
          }
          default: {
            fname = "";
            break;
          }
        }
        //      System.out.println("fname" + " = " +fname);
        //      System.out.println("i" + " = " +i);
        try {
          if (!"".equals(fname)) {
            files[i] = new File(bmp + fname);
            images[i] = ImageIO.read(files[i]);
            int x, y;
            x = centerOnX(images[i], left, wid);
            y = centerOnY(images[i], top, hgt);
            switch (i) {
              case 1: {
                g.drawImage(images[i], x - 8, y - 7, null);
                break;
              }
              case 4: {
                g.drawImage(images[i], x, y + 7, null);
                break;
              }
              default: {
                g.drawImage(images[i], x, y, null);
                break;
              }
            }
          }
        } catch (IOException ex) {
          Logger.getLogger(Panel4UTP.class.getName())
            .log(Level.SEVERE, null, ex);
        }
      }
      // ID to top centre box
      BufferedImage bi1 = strToSmall(3, 5, jf.getTitle().substring(0, 4));
      g.drawImage(bi1, centerOnX(bi1, 51, 0), 25, null);
      BufferedImage bi11 = strToSmall(3, 5, jTextField1.getText());
      g.drawImage(bi11, centerOnX(bi11, 51, 0), 31, null);
      // CF to bottom left box
      BufferedImage bi2 = strToSmall(3, 5, "CF");
      g.drawImage(bi2, centerOnX(bi2, 29, 0), 61, null);
      int s1 = jtf4CF.getText().indexOf("(");
      BufferedImage bi21 = strToSmall(3, 5, jtf4CF.getText().substring(0, s1));
      g.drawImage(bi21, centerOnX(bi21, 29, 0), 67, null);
      // TF to bottom middle box
      BufferedImage bi3 = strToSmall(3, 5, "TF");
      g.drawImage(bi3, centerOnX(bi3, 51, 0), 61, null);
      int s2 = jtf4CF.getText().indexOf(")");
      BufferedImage bi31 = strToSmall(3, 5, jtf4CF.getText().substring(s1 + 1,
        s2));
      g.drawImage(bi31, centerOnX(bi31, 51, 0), 67, null);
      // TL to bottom right box
      BufferedImage bi4 = strToSmall(3, 5, "TL");
      g.drawImage(bi4, centerOnX(bi4, 73, 0), 61, null);
      BufferedImage bi41 = strToSmall(3, 5, jLabel11.getText());
      g.drawImage(bi41, centerOnX(bi41, 73, 0), 67, null);
      //g.dispose();
      //</editor-fold>//Left
      top = 0;
      left = 0;
      try {
        jLabel11.setText(Panel4SubSector.UWP.getText().substring(7, 8));
        jLabel2.setText(Panel4SubSector.troopunits.getText());
      } catch (Exception e) {
      }
//      try {
//        ImageIO.write(bi, "gif", f);
//        System.out.println("" + " = " + f.toString());
//      } catch (IOException ex1) {
//        System.out.println("" + " = " + ex1);
//        Logger.getLogger(Panel4World.class.getName())
//                .log(Level.SEVERE, null, ex1);
//      }
      //</editor-fold>
    }
    try {
      ImageIO.write(bi, "gif", f);
      System.out.println("SUCCEED" + " = " + f.toString());
    } catch (IOException ex1) {
      System.out.println("FAIL save image2Pic" + " = " + ex1);
    }
  }
}
