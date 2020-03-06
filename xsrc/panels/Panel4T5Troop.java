/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package panels;

import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalMethods.toComboBox;
import static dbviewer.globals.GlobalVariables.CRLF;
import static dbviewer.globals.GlobalVariables.FS;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

/**

 @author Mark Ferguson
 */
public class Panel4T5Troop extends Panel4 {

  //<editor-fold defaultstate="collapsed" desc="variables">
  static JFrame jf;
  static JPanel jp;
  static String[] lines = new String[]{""};
  static int counter = 0;
  static int cf4Size = 1;
  static int cf4Quality = 1;
  static int cf4Armament = 1;
  static int cf4Type = 1;
  static int CF;
  static int TF;
  static int Used;
//  static int Pts = Integer.parseInt(Panel4T5Locator.troopunits.getText());
  static int Pts = 0;
  static int Left;
  static int Cost = 0;
  //</editor-fold>

  /**
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4T5Troop();
    jf = new Frame4(jp);
    jf.setBounds(1200, 400, 600, 200);
//    jf.addWindowListener(new WindowAdapter() {
//      @Override
//      public void windowClosing(WindowEvent e) {
//        try {
////          saveFile();
//          GlobalMethods.saveTextFile(Panel4T5Locator.getSysPath(),
//            Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim().substring(0, 4),
//            ".utp",
//            jTextArea1.getText());
////          GlobalMethods.savePic(jf, jf.getTitle());
//        } catch (Exception ex) {
//        }
//      }
//    });
////    jButton1.doClick();
//    if (!jf.isVisible()) {
//      jf.setVisible(true);
//    }
  }

  /**
   Creates new form Panel4T5Troops
   */
  public Panel4T5Troop() {
    initComponents();
    jLabel11.setText("" + GlobalMethods.fromHex(Panel4T5Locator.UWP.substring(8, 9)));
    jLabel11.setText("15");
    pts.setText(Panel4T5Locator.troopunits.getText());
    pts.setText("2000");
    l4Hex.setText(Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
      .substring(0, 4));
    l4Hex.setText("2118");
    setCombos();
    loadFile();
    calcUsed();
  }

  /**
   change of System
   */
  public static void systemChange() {
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
//    jButton2.doClick();
    l4Hex.setText("" + Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
      .substring(0, 4));
    jLabel11.setText("" + GlobalMethods
      .fromHex(Panel4T5Locator.UWP.substring(8)));
//    calc();
    loadFile();
//    calc();
    String txt = Panel4T5Locator.troopunits.getText();
    if ("X".equals(txt)) {
      txt = "2000";
    }
    Pts = Integer.parseInt(txt);
    pts.setText("" + Pts);
//    calcUsed();
    loadFile();
  }

  private static void loadFile() {
    String dir = Panel4T5Locator.getSysPath();
    String file = Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
      .substring(0, 4);
    String ext = ".utp";
    String txt = GlobalMethods.loadTextFile(dir, file, ext);
    jTextArea1.setText(txt.replace(CRLF + CRLF, CRLF));
//    }
  }

  private static void calc() {
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
    calcCF();
    calcTF();
    pts.setText("" + Pts);
    spent.setText("" + Used);
    Left = Pts - Used;
    left.setText("" + Left);
  }

  private static String calcCF() {
    CF = cf4Size * cf4Quality * cf4Armament * cf4Type;
    left1.setText("" + CF);
    return "" + CF;
  }

  private static String calcTF() {
    try {
      TF = CF / cf4Quality / cf4Armament / cf4Type;
      return "" + TF;
    } catch (Exception e) {
      //JOptionPane.showMessageDialog(jp,e.toString());
      System.out.println("" + " = " + e.toString());
    }
    return "0";
  }

  private static void calcUsed() {
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
    String txt = jTextArea1.getText();
    int num = 0;
    int total = 0;
    if (jLabel3.getText().length() > 1) {
      lines = txt.split(CRLF);
      for (int j = 0; j < lines.length; j++) {
        if (lines[j].length() > 13) {
          num = Integer.parseInt(lines[j].substring(10, lines[j]
            .lastIndexOf("(")));
          //<editor-fold defaultstate="collapsed" desc="DEBUG">
          //DEBUG = false;
          if (DEBUG) {
            System.out.println("" + j + " = " + num);
          }
          //</editor-fold>
          total += num;
        }
      }
    }
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    //DEBUG = false;
    if (DEBUG) {
      System.out.println("total" + " = " + total);
    }
    //</editor-fold>
    Used = total;
    spent.setText("" + total);
    calc();
  }

  private void deletePics() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
    }
    //</editor-fold>
    String folder = Panel4T5Locator.getSysPath();
    String[] list = new File(folder).list();
    for (int j = 0; j < list.length; j++) {
      if (list[j].length() == 13 & list[j].endsWith(".gif")) {
        String pathfile = Panel4T5Locator.getSysPath() + FS + list[j];
        //<editor-fold defaultstate="collapsed" desc="DEBUG">
        //DEBUG = false;
        if (DEBUG) {
          System.out.println("Delete " + pathfile);
        }
        //</editor-fold>
        File f = new File(pathfile);
        f.delete();
      }
    }
    saveFile();
//    folder += FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
    list = new File(folder).list();
    for (int j = 0; j < list.length; j++) {
      if (list[j].startsWith("Troop") & list[j].length() != 14) {
        String pathfile = folder + FS + list[j];
//        System.out.println("Delete " + pathfile);
        File f = new File(pathfile);
        f.delete();
      }
    }
  }

  private void line2Counter(String line) {
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
    Panel4T5CounterMaker.Folder.setSelectedIndex(4);
//    System.out.println("line" + " = " + line);
    Panel4T5CounterMaker.jtfs[10].setText(
      l4Hex.getText().substring(0, 4) + "-" + jLabel1.getText().substring(0, 4));
    Panel4T5CounterMaker.jtfs[11].setText("");
    Panel4T5CounterMaker.jtfs[12].setText("");
    Panel4T5CounterMaker.jtfs[13].setText("");
    Panel4T5CounterMaker.jtfs[14].setText("");
    Panel4T5CounterMaker.jtfs[15].setText("");
    Panel4T5CounterMaker.jtfs[16].setText("");
    Panel4T5CounterMaker.jtfs[17].setText("");
    Panel4T5CounterMaker.jtfs[18].setText("");
    Panel4T5CounterMaker.picClick();
    Panel4T5CounterMaker.setText.doClick();
  }

  private static void saveFile() {
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
    try {
      GlobalMethods.saveTextFile(Panel4T5Locator.getSysPath(),
        Panel4T5Locator.jcb4Sys.getSelectedItem().toString().substring(0, 4),
        ".utp",
        jTextArea1.getText());
//      System.out.println("jTextArea1.getText()" + " = " + jTextArea1.getText());
    } catch (Exception ex) {
      System.out.println("125" + " = " + ex);
      System.out.println("jTextArea1.getText()" + " = " + jTextArea1.getText());
    }
  }

  private static String countCount() {
    lines = jTextArea1.getText().split(CRLF);
    int zeroes = 0;
    counter = 1;
    for (int j = 0; j < lines.length; j++) {
      if (lines[j].length() > 1) {
        counter += 1;
      }
    }
    if (counter < 1000) {
      zeroes += 1;
    }
    if (counter < 100) {
      zeroes += 1;
    }
    if (counter < 10) {
      zeroes += 1;
    }
    String Zeroes = "";
    for (int j = 0; j < zeroes; j++) {
      Zeroes += "0";
    }
    return "" + Zeroes + counter;
  }

  private void setCombos() {
    jcb4Size.setSelectedIndex(2);
    jcb4Quality.setSelectedIndex(1);
    jcb4Armament.setSelectedIndex(1);
    jcb4Mobility.setSelectedIndex(0);
    jcb4Type.setSelectedIndex(0);
  }

  private void updateCombos() {
    ActionEvent ae = null;
    jcb4Size.actionPerformed(ae);
    jcb4Type.actionPerformed(ae);
    jcb4Mobility.actionPerformed(ae);
    jcb4Size.actionPerformed(ae);
    jcb4Size.actionPerformed(ae);
  }

  /**
   This method is called from within the constructor to
   initialize the form.
   WARNING: Do NOT modify this code. The content of this method is
   always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jComboBox1 = new javax.swing.JComboBox<String>();
    jLabel10 = new javax.swing.JLabel();
    spent = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jcb4Size = new javax.swing.JComboBox();
    left = new javax.swing.JLabel();
    jcb4Type = new javax.swing.JComboBox();
    jcb4Mobility = new javax.swing.JComboBox();
    jcb4Quality = new javax.swing.JComboBox();
    jcb4Armament = new javax.swing.JComboBox();
    jButton2 = new javax.swing.JButton();
    pts = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    l4Hex = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    left1 = new javax.swing.JLabel();

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

    setBackground(new java.awt.Color(0, 0, 0));
    setForeground(new java.awt.Color(255, 255, 255));
    setOpaque(true);

    jLabel10.setBackground(new java.awt.Color(255, 255, 255));
    jLabel10.setForeground(java.awt.Color.lightGray);
    jLabel10.setText("TL");

    spent.setBackground(new java.awt.Color(255, 255, 255));
    spent.setForeground(java.awt.Color.lightGray);
    spent.setText("0");
    spent.setToolTipText("Used");
    spent.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        spentjLabelMouseClicked(evt);
      }
    });

    jLabel9.setBackground(new java.awt.Color(255, 255, 255));
    jLabel9.setForeground(java.awt.Color.lightGray);
    jLabel9.setText("=");

    jcb4Size.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0-Company", "1-Battalion", "2-Regiment", "3-Brigade", "4-Division", "5-Corps", "6-Army", "7-Army Group" }));
    jcb4Size.setSelectedIndex(3);
    jcb4Size.setToolTipText("Size");
    jcb4Size.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcb4SizejcbsActionPerformed(evt);
      }
    });

    left.setBackground(new java.awt.Color(255, 255, 255));
    left.setForeground(java.awt.Color.lightGray);
    left.setText("0");
    left.setToolTipText("Unspent");
    left.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        leftjLabelMouseClicked(evt);
      }
    });

    jcb4Type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0-Infantry", "1-Cavalry", "2-Marines", "3-Jump Troops", "4-Guerilla" }));
    jcb4Type.setToolTipText("Type");
    jcb4Type.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcb4TypejcbsActionPerformed(evt);
      }
    });

    jcb4Mobility.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Grav", "Foot", "Wheeled", "Tracked", "AC", "Crawler", "Walker", "Air", "Space" }));
    jcb4Mobility.setToolTipText("Mobility");
    jcb4Mobility.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcb4MobilityjcbsActionPerformed(evt);
      }
    });

    jcb4Quality.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0-Regular", "1-Elite" }));
    jcb4Quality.setToolTipText("Quality");
    jcb4Quality.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcb4QualityActionPerformed(evt);
      }
    });

    jcb4Armament.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0-Light", "1-Armoured" }));
    jcb4Armament.setToolTipText("Armament");
    jcb4Armament.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcb4ArmamentjcbsActionPerformed(evt);
      }
    });

    jButton2.setText("X");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    pts.setBackground(new java.awt.Color(255, 255, 255));
    pts.setForeground(java.awt.Color.lightGray);
    pts.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    pts.setText("10");
    pts.setToolTipText("Points");
    pts.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        ptsMouseClicked(evt);
      }
    });

    jLabel1.setBackground(new java.awt.Color(255, 255, 255));
    jLabel1.setForeground(java.awt.Color.lightGray);
    jLabel1.setText("-");
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    jLabel11.setBackground(new java.awt.Color(255, 255, 255));
    jLabel11.setForeground(java.awt.Color.lightGray);
    jLabel11.setText("A");

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jTextArea1.addCaretListener(new javax.swing.event.CaretListener() {
      public void caretUpdate(javax.swing.event.CaretEvent evt) {
        jTextArea1CaretUpdate(evt);
      }
    });
    jScrollPane1.setViewportView(jTextArea1);

    l4Hex.setForeground(java.awt.Color.lightGray);
    l4Hex.setText("Hex");
    l4Hex.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        l4HexMouseClicked(evt);
      }
    });

    jLabel3.setBackground(java.awt.Color.black);
    jLabel3.setForeground(java.awt.Color.lightGray);
    jLabel3.setText("UTP");
    jLabel3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jLabel3PropertyChange(evt);
      }
    });

    left1.setBackground(new java.awt.Color(255, 255, 255));
    left1.setForeground(java.awt.Color.green);
    left1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    left1.setText("0");
    left1.setToolTipText("Buy Cost");
    left1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        left1MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(l4Hex)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel10)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel11)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(left1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(pts, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(spent, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel9)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(left))
          .addComponent(jcb4Armament, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jcb4Size, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jcb4Quality, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jcb4Mobility, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jButton2)
            .addComponent(jcb4Type, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGap(113, 113, 113)
            .addComponent(jLabel3)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addGap(0, 0, 0))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {left, pts, spent});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel10)
            .addComponent(jLabel11)
            .addComponent(l4Hex)
            .addComponent(left1)))
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel1)
              .addComponent(spent)
              .addComponent(jLabel9)
              .addComponent(left)
              .addComponent(pts))
            .addGap(0, 0, 0)
            .addComponent(jcb4Size, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jcb4Quality, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jcb4Armament, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jcb4Mobility, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addComponent(jcb4Type, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
            .addComponent(jButton2))))
    );

    layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jcb4Armament, jcb4Mobility, jcb4Quality, jcb4Size, jcb4Type});

  }// </editor-fold>//GEN-END:initComponents

  private void spentjLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spentjLabelMouseClicked
  }//GEN-LAST:event_spentjLabelMouseClicked

  private void jcb4SizejcbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb4SizejcbsActionPerformed
    //Panel4UTP.jcb4Size.setSelectedIndex(jcb4Size.getSelectedIndex());
    switch (jcb4Size.getSelectedItem().toString().substring(0, 1)) {
      case "0": {
        cf4Size = 1;
        break;
      }
      case "1": {
        cf4Size = 2;
        break;
      }
      case "2": {
        cf4Size = 5;
        break;
      }
      case "3": {
        cf4Size = 10;
        break;
      }
      case "4": {
        cf4Size = 20;
        break;
      }
      case "5": {
        cf4Size = 50;
        break;
      }
      case "6": {
        cf4Size = 100;
        break;
      }
      case "7": {
        cf4Size = 500;
        break;
      }
    }
    calc();
  }//GEN-LAST:event_jcb4SizejcbsActionPerformed

  private void leftjLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftjLabelMouseClicked
  }//GEN-LAST:event_leftjLabelMouseClicked

  private void jcb4TypejcbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb4TypejcbsActionPerformed
    //Panel4UTP.jcb4Type.setSelectedIndex(jcb4Type.getSelectedIndex());
    switch (jcb4Type.getSelectedItem().toString().substring(0, 1)) {
      case "0": {
        cf4Type = 1;
        break;
      }
      case "1": {
        cf4Type = 1;
        break;
      }
      case "2": {
        cf4Type = 2;
        break;
      }
      case "3": {
        cf4Type = 2;
        break;
      }
      case "4": {
        cf4Type = 1;
        break;
      }
    }
    calc();
  }//GEN-LAST:event_jcb4TypejcbsActionPerformed

  private void jcb4MobilityjcbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb4MobilityjcbsActionPerformed
    //Panel4UTP.jcb4Mobility.setSelectedIndex(jcb4Mobility.getSelectedIndex());
    switch (jcb4Mobility.getSelectedItem().toString()) {
      case "Grav": {
        break;
      }
      case "Foot": {
        break;
      }
      case "Wheeled": {
        break;
      }
      case "Tracked": {
        break;
      }
      case "AC": {
        break;
      }
      case "Crawler": {
        break;
      }
      case "Walker": {
        break;
      }
      case "Air": {
        break;
      }
      case "Space": {
        break;
      }
    }
    calc();
  }//GEN-LAST:event_jcb4MobilityjcbsActionPerformed

  private void jcb4QualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb4QualityActionPerformed
    //Panel4UTP.jcb4Quality.setSelectedIndex(jcb4Quality.getSelectedIndex());
    switch (jcb4Quality.getSelectedItem().toString().substring(0, 1)) {
      case "0": {
        cf4Quality = 1;
        break;
      }
      case "1": {
        cf4Quality = 2;
        break;
      }
    }
    calc();
  }//GEN-LAST:event_jcb4QualityActionPerformed

  private void jcb4ArmamentjcbsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb4ArmamentjcbsActionPerformed
    //Panel4UTP.jcb4Armament.setSelectedIndex(jcb4Armament.getSelectedIndex());
    switch (jcb4Armament.getSelectedItem().toString().substring(0, 1)) {
      case "0": {
        cf4Armament = 1;
        break;
      }
      case "1": {
        cf4Armament = 2;
        break;
      }
    }
    calc();
  }//GEN-LAST:event_jcb4ArmamentjcbsActionPerformed

  @SuppressWarnings("unchecked")
  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    deletePics();
    jTextArea1.setText("");
    toComboBox(jTextArea1, jComboBox1);
    saveFile();
//    jButton1.setEnabled(true);
    Used = 0;
    spent.setText("" + Used);
    calc();
    Panel4T5CounterMaker.deleteXConfig();
//    String path = Panel4T5Locator.getSysPath();
//    System.out.println("path" + " = " + path);
//    String file = l4Hex.getText();
//    System.out.println("file" + " = " + file);
//    String txt = GlobalMethods.loadTextFile(path, file, ".utp");
//    System.out.println(txt);
//    jTextArea1.setText(txt);
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
  }//GEN-LAST:event_jLabel1MouseClicked

  private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange

  }//GEN-LAST:event_jComboBox1PropertyChange

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

  }//GEN-LAST:event_jComboBox1ActionPerformed

  private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked

  }//GEN-LAST:event_jComboBox1MouseClicked

  private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged

  }//GEN-LAST:event_jComboBox1ItemStateChanged

  private void jTextArea1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextArea1CaretUpdate
    calc();
    updateCombos();
    try {
      Panel4T5CounterMaker.counter = "Troop";
      Panel4T5CounterMaker.Folder.setSelectedItem(Panel4T5CounterMaker.counter);
      Panel4T5CounterMaker.picClick();
      String[] lines = jTextArea1.getText().split(CRLF);
      int offset = evt.getDot();
      int ln = jTextArea1.getLineOfOffset(offset);
      try {
        if (lines[ln].length() > 0) {
          jLabel3.setText(lines[ln]);
          String line = lines[ln];
          int num = 0;
          //Hex
//          Panel4T5CounterMaker.jtfs[10].setText(l4Hex.getText() + "-" + line.substring(0, 4));
          Panel4T5CounterMaker.jtfs[10].setText(Panel4T5Locator.jcb4Sys
            .getSelectedItem().toString().trim());
          //Blank
          Panel4T5CounterMaker.jtfs[11].setText(line.substring(0, 4));
          //Size
          num = Integer.parseInt(line.substring(5, 6));
          Panel4T5CounterMaker.jtfs[12].setText(jcb4Size.getItemAt(num)
            .toString());
          //Quality
          num = Integer.parseInt(line.substring(6, 7));
          Panel4T5CounterMaker.jtfs[13].setText(jcb4Quality.getItemAt(num)
            .toString());
          //Armament
          num = jcb4Armament.getSelectedIndex();
          Panel4T5CounterMaker.jtfs[14].setText(jcb4Armament.getItemAt(num)
            .toString());
          //Mobility
          num = jcb4Mobility.getSelectedIndex();
          Panel4T5CounterMaker.jtfs[15].setText(jcb4Mobility.getItemAt(num)
            .toString());
          //Type
          num = Integer.parseInt(line.substring(8, 9));
          Panel4T5CounterMaker.jtfs[16].setText(jcb4Type.getItemAt(num)
            .toString());
          //
          String CF = line.substring(10, line.indexOf("("));
          Panel4T5CounterMaker.jtfs[17].setText("CF " + CF);
          //
          String TF = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
          Panel4T5CounterMaker.jtfs[18].setText("TF " + TF);
          //
//        num = Integer.parseInt(line.substring(0, 1));
          Panel4T5CounterMaker.jtfs[19].setText("TL " + GlobalMethods.fromHex(
            jLabel11.getText()));
          Panel4T5CounterMaker.setText.doClick();
          Panel4T5CounterMaker.saveConfig();
        } else {
//        Panel4T5CounterMaker.jtfs[19].setText("TL " + GlobalMethods.fromHex(jLabel11.getText()));
          Panel4T5CounterMaker.setText.doClick();
        }
      } catch (Exception e) {
        Panel4T5CounterMaker.setText.doClick();
      }
    } catch (BadLocationException ex) {
      Logger.getLogger(Panel4T5Troop.class.getName())
        .log(Level.SEVERE, null, ex);
    }
    updateCombos();
    Panel4T5CounterMaker.savePic();
    Panel4T5CounterMaker.loadOldList(Panel4T5CounterMaker.counter);
  }//GEN-LAST:event_jTextArea1CaretUpdate

  private void jLabel3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel3PropertyChange
    calcUsed();
    String s = jLabel3.getText();
    if (s.length() > 10) {
      jcb4Size.setSelectedIndex(GlobalMethods.fromHex(jLabel3.getText()
        .substring(5, 6)));
      jcb4Quality.setSelectedIndex(GlobalMethods.fromHex(jLabel3.getText()
        .substring(6, 7)));
      jcb4Armament.setSelectedIndex(GlobalMethods.fromHex(jLabel3.getText()
        .substring(7, 8)));
      jcb4Type.setSelectedIndex(GlobalMethods.fromHex(jLabel3.getText()
        .substring(8, 9)));
//    jcb4Mobility.setSelectedIndex(0);
    }
  }//GEN-LAST:event_jLabel3PropertyChange

  private void left1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_left1MouseClicked
    calc();
    calcUsed();
    if (Left >= CF) {
      String txt = "";
      //------------------------------------------------------------------------------------------------
//    txt += ""
//      + "0001-4000-1(1)-13 = 1pt - 1st Division of Regular Light Lift Infantry  (1705 Efate)" + CRLF
//      + "0002-4000-1(1)-13 = 1pt - 2nd Division of Regular Light Lift Infantry  (1705 Efate)" + CRLF
//      + "0003-4000-1(1)-13 = 1pt - 3rd Division of Regular Light Lift Infantry  (1705 Efate)" + CRLF
//      + "0004-4000-1(1)-13 = 1pt - 4th Division of Regular Light Lift Infantry  (1705 Efate)" + CRLF
//      + "0005-4000-1(1)-13 = 1pt - 5th Division of Regular Light Lift Infantry  (1705 Efate)" + CRLF;
      //------------------------------------------------------------------------------------------------
      txt += countCount();
      txt += "-";
      txt += jcb4Size.getSelectedItem().toString().substring(0, 1);
      txt += jcb4Quality.getSelectedItem().toString().substring(0, 1);
      txt += jcb4Armament.getSelectedItem().toString().substring(0, 1);
      txt += jcb4Type.getSelectedItem().toString().substring(0, 1);
      txt += "-";
      txt += calcCF() + "(" + calcTF() + ")";
      txt += "-";
      txt += GlobalMethods.toHex(Integer.parseInt(jLabel11.getText()));
      //------------------------------------------------------------------------------------------------

      spent.setText("" + (Used + CF));
      Used += CF;
      if (Used == Integer.parseInt(pts.getText())) {
//        jButton1.setEnabled(false);
      }
      jTextArea1.append(txt + CRLF);
//      saveFile();
    }
    calc();
    saveFile();
  }//GEN-LAST:event_left1MouseClicked

  private void l4HexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4HexMouseClicked
    systemChange();
  }//GEN-LAST:event_l4HexMouseClicked

  private void ptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ptsMouseClicked
    pts.setText("2000");
  }//GEN-LAST:event_ptsMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  static javax.swing.JButton jButton2;
  static javax.swing.JComboBox jComboBox1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private static javax.swing.JLabel jLabel11;
  static javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JScrollPane jScrollPane1;
  public static javax.swing.JTextArea jTextArea1;
  private static javax.swing.JComboBox jcb4Armament;
  private static javax.swing.JComboBox jcb4Mobility;
  private static javax.swing.JComboBox jcb4Quality;
  private static javax.swing.JComboBox jcb4Size;
  private static javax.swing.JComboBox jcb4Type;
  static javax.swing.JLabel l4Hex;
  private static javax.swing.JLabel left;
  private static javax.swing.JLabel left1;
  private static javax.swing.JLabel pts;
  static javax.swing.JLabel spent;
  // End of variables declaration//GEN-END:variables

}
