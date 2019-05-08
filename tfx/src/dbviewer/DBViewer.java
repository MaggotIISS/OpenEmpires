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
import static dbviewer.globals.GlobalVariables.T5;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import panels.Frame4;
import panels.Frame4Careers;
import panels.Frame4DBView;
import panels.Frame4ReflectionView;
import panels.Frame4TextFileView;
import panels.Panel4;
import panels.Panel4Boxer;
import panels.Panel4Calculator;
import panels.Panel4Careers;
import panels.Panel4DBButtons;
import panels.Panel4LabelComboButton;
import panels.Panel4Locator;
import panels.Panel4Title;

/**

 @author maggot.iiss
 */
public class DBViewer extends javax.swing.JPanel {

//<editor-fold defaultstate="collapsed" desc="Variables">
  /**
   ConsoleWindow
   */
  public static ConsoleWindow cw;
  /**
   JFrame of main window
   */
  public static JFrame jf = null;
  /**
   JFileChooser
   */
  public static JFileChooser jfc = new JFileChooser();
  /**
   Boolean
   */
  public static Boolean ok = null;
  /**
   DBWork
   */
  public static DBWork dbw = null;
  //------------------------------------
  private static int wid = 420;
  private static int hgt = 500;
  private static int left = 200;//jf.getX();
  private static int top = 0;//jf.getY();
  private static final long serialVersionUID = 1L;
  private static ArrayList<String> al = null;
  private static int files = 0;
  private static int folders = 0;
  static String string = null;
  private static String CRLF = System.lineSeparator();
  private static String FS = File.pathSeparator;
  private String title = null;
  /**
   String[] of pics ?
   */
  public String[] names = null;
  private Boolean[] enabled = null;
  private String sel = null;
  private JScrollPane jsp = null;
  private String list = null;
  private static String path = "";
  private static String[] strings = null;
  private JFrame jf1 = null;
  private JFrame jf2 = null;
  private JTextArea jta = null;
  //  private Frame4Boxer f4b = null;
  //private Frame4Calculator f4calc = null;
  private Frame4Careers f4c = null;
  private Frame4DBView f4dbv = null;
  private Frame4ReflectionView f4rv = null;
  private Frame4TextFileView f4tfv = null;
  private Panel4Boxer p4b = null;
  private Panel4Title p4info = null;
  private Panel4DBButtons p4dbb = null;
  private Panel4LabelComboButton p4lcb = null;
  private Dialog4About dialog = null;
  private DefaultListModel<String> dlm = null;
  private ComboBoxModel<String> cbm = null;
  private static JComboBox jcb = new JComboBox();
  private static AnyMenu am;
  private static DBViewer dbv;
//  static String it = "IT";
  //</editor-fold>

  /**

   @param args strings to start
   */
  public static void main(String[] args) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      String s = "";
      s += GlobalMethods.comment("=", 80) + CRLF;
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      s += "\t" + method + CRLF;
//      s += "" + " = " + "" + CRLF;
      System.out.print(s);
//      JOptionPane.showMessageDialog(null, s);
    }
    //</editor-fold>
    jf = new Frame4();
    am = new AnyMenu(jf);
    dbv = new DBViewer();
    jf.getContentPane().add(dbv, "Center");
    GlobalMethods.autoColor(jf, Color.black, Color.LIGHT_GRAY);
    //Robots.main(args);
    //JOptionPane.showMessageDialog(jf, "Panel4Locator.getPath() = " + Panel4Locator.getPath());
    dbv.updateUI();
  }

  /**
   Creates new form DBViewer
   */
  public DBViewer() {
    super();
    //<editor-fold defaultstate="collapsed" desc="IFD">
    String s = "";
    {
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
        s += GlobalMethods.comment("=", 80) + CRLF;
        s += "\t" + getClass() + "-" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        JTextArea jta = new JTextArea(s, 20, 20);
        JScrollPane jsp = new JScrollPane(jta);
        System.out.println(s);
//        JOptionPane.showMessageDialog(jf, jsp);
      }
    }
    //</editor-fold>
//    ConsoleWindow.init();
//    ConsoleWindow.setBounds(715, 0, 340, 550);
    initComponents();
    Group.setSelectedIndex(0);
    setPath();
    jfc.addPropertyChangeListener((PropertyChangeEvent evt) -> {
//      System.out.println("propertyChange");
    });
    //jComboBox1.setSelectedIndex(27);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setBounds(0, 100, 200, 200);
    jf.setTitle(getTitle());
    jf.setLayout(new BorderLayout());
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    //jComboBox1.setSelectedItem("MapImperium");

  }

//==============================================================================
  /**

   @return Dialog with about message
   */
  public static JDialog getAbout() {
    JDialog jd = new Dialog4About();
    return jd;
  }

  /**

   @return name of class
   */
  @Override
  public String toString() {
    return Panel4Locator.getPath();
  }

  /**
   Loads from file, array of Strings for use

   @return Array of Strings from file
   */
  @SuppressWarnings("ReturnOfCollectionOrArrayField")
  public static String[] loadFileArray() {
//    Debug.debug("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//    Debug.debug("path = " + path);
//    Debug.debug("getPath() = " + getPath());
    setPath();
    File dir = new File(path);
    if (!dir.exists()) {
      JOptionPane.showMessageDialog(jf, path);
      dir.mkdirs();
    }

    path = (path).replace(".", "").replace("/", FS).replace(FS, "/");
    path.replace("/", FS);
    System.out.println("230 path" + " = " + path);
    setPath();
//    JOptionPane.showMessageDialog(jf, path);
//    System.out.println("path" + " = " + path);
    String[] tmp = dir.list();
//    if (tmp != null) {
    countFoldersAndFiles(tmp);
//    Debug.debug(" = " + dir.list().toString());
    al = new ArrayList<>();
    int num = 0;
    for (int i = 0; i < tmp.length; i++) {
      File t = new File(path, tmp[i]);
      if (!t.exists()) {
        JOptionPane.showMessageDialog(jf, path + " + " + tmp[i] + " = 243");
      }
      if (!t.isDirectory()) {
        al.add(tmp[i]);
        num += 1;
      }
    }
    strings = null;
    if (dir.list() != null) {
      strings = new String[num];
      for (int i = 0; i < num; i++) {
        strings[i] = al.get(i);
      }
    }
//    }
    return strings;
  }

  /**

   @return return JFrame of Main window
   */
  public static JFrame getJf() {
    return jf;
  }

  /**

   @return title of window
   */
  public static String getTitle() {
    if ((jList1.getSelectedValue().toString() != null)) {
      //System.out.print("jList1.getSelectedValue().toString() = " + jList1.getSelectedValue().toString());
      setPath();
      return getPath() + jList1.getSelectedValue().toString();
    }
    if (Group.getSelectedItem().toString().equals("WHO")) {
      //System.out.print("" + " = WHO!!");
      return Panel4Careers.updateName();
    }

    return jf.getTitle();
  }

  /**

   @return PATH AND FILENAME AS STRING
   */
  public static String getPath() {
    setPath();
    return path;
  }

  /**
   set directory and file as Pathfile
   */
  public static void setPath() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    try {
      if ("_CSV".equals(Group.getSelectedItem().toString())) {
        setPathFile(T5 + "/" + Group.getSelectedItem().toString() + "/");
      } else if (!"_CSV".equals(Group.getSelectedItem().toString())) {
        setPathFile(T5 + "/_CSV/" + Group.getSelectedItem().toString() + "/");
      } else if ((Group.getSelectedItem().toString()).contains("BMP")) {
        setPathFile(dbviewer.globals.GlobalVariables.BMP);
      }
    } catch (Exception e) {
      System.out.println("e" + " = " + e + " = " + e.toString());
    }
  }

  /**

   @return path and file names as string
   */
  public static String getPathFile() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    setPath();
    return path + jList1.getSelectedValue().toString();
  }

  /**
   @param pf STRING TO SET AS NEW PATH AND FILENAME
   */
  public static void setPathFile(String pf) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    //Debug.debug("path = " + path);
    path = pf;

  }

  /**
   @return the JFrame of Frame4TextFileView
   */
  public JFrame getJf2() {
    return jf2;
  }

  /**
   @param jf2 the JFrame of Frame4TextFileView
   */
  public void setJf2(JFrame jf2) {
    this.jf2 = jf2;
  }

  /**
   @return the p4info
   */
  public Panel4Title getP4t() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    return getP4info();
  }

  /**
   @param ip INFO PANEL TO SET
   */
  public void setIp(Panel4Title ip) {
    this.setP4info(ip);
  }

  /**
   @return the p4dbb
   */
  public Panel4DBButtons getDbb() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    return getP4dbb();
  }

  /**
   @param dbb Panel4DBButtons
   */
  public void setDbb(Panel4DBButtons dbb) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    this.setP4dbb(dbb);
  }

  /**
   @return the JFrame of Frame4DBView
   */
  public JFrame getJf1() {
    return jf1;
  }

  /**
   @param jf1 the Frame4DBView to set
   */
  public void setJf1(JFrame jf1) {
    this.jf1 = jf1;
  }

  /**
   @return the JScrollPane
   */
  public JScrollPane getJsp() {
    return jsp;
  }

  /**
   @param jsp the JScrollPane to set
   */
  public void setJsp(JScrollPane jsp) {
    this.jsp = jsp;
  }

  /**
   @return the p4info
   */
  public Panel4Title getP4info() {
    return p4info;
  }

  /**
   @param p4info the p4info to set
   */
  public void setP4info(Panel4Title p4info) {
    this.p4info = p4info;
  }

  /**
   @return the p4dbb
   */
  public Panel4DBButtons getP4dbb() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    return p4dbb;
  }

  /**
   @param p4dbb the p4dbb to set
   */
  public void setP4dbb(Panel4DBButtons p4dbb) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    this.p4dbb = p4dbb;
  }

  /**
   @return the p4lcb
   */
  public Panel4LabelComboButton getP4lcb() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    return p4lcb;
  }

  /**
   @param p4lcb the p4lcb to set
   */
  public void setP4lcb(Panel4LabelComboButton p4lcb) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    this.p4lcb = p4lcb;
  }

  /**
   @return the f4dbv
   */
  public Frame4DBView getF4dbv() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    return f4dbv;
  }

  /**
   @param f4dbv the f4dbv to set
   */
  public void setF4dbv(Frame4DBView f4dbv) {
    this.f4dbv = f4dbv;
  }

  /**
   @return the f4rv
   */
  public Frame4ReflectionView getF4rv() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    return f4rv;
  }

  /**
   @param f4rv the f4rv to set
   */
  public void setF4rv(Frame4ReflectionView f4rv) {
    this.f4rv = f4rv;
  }

  /**
   @return the f4tfv
   */
  public Frame4TextFileView getF4tfv() {
    return f4tfv;
  }

  /**
   @param f4tfv the f4tfv to set
   */
  public void setF4tfv(Frame4TextFileView f4tfv) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    this.f4tfv = f4tfv;
  }

  /**
   @return the jta
   */
  public JTextArea getJta() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    return jta;
  }

  /**
   @param jta the jta to set
   */
  public void setJta(JTextArea jta) {
    this.jta = jta;
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

    jButton7 = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    jButton5 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton6 = new javax.swing.JButton();
    Group = new javax.swing.JComboBox();
    jComboBox1 = new javax.swing.JComboBox();
    jScrollPane1 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList();

    jButton7.setText("jButton1");
    jButton7.setToolTipText("");
    jButton7.setName("jButton7"); // NOI18N
    jButton7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton7ActionPerformed(evt);
      }
    });

    jButton1.setText("jButton1");
    jButton1.setToolTipText("DBView");
    jButton1.setName("jButton1"); // NOI18N
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton5.setText("jButton1");
    jButton5.setToolTipText("Discover/Create");
    jButton5.setName("jButton5"); // NOI18N
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton5ActionPerformed(evt);
      }
    });

    jButton4.setText("jButton1");
    jButton4.setToolTipText("About");
    jButton4.setName("jButton4"); // NOI18N
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    jButton3.setText("jButton1");
    jButton3.setToolTipText("Reflect");
    jButton3.setName("jButton3"); // NOI18N
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jButton2.setText("jButton1");
    jButton2.setToolTipText("Edit");
    jButton2.setName("jButton2"); // NOI18N
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jButton6.setText("jButton1");
    jButton6.setToolTipText("");
    jButton6.setName("jButton6"); // NOI18N
    jButton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton6ActionPerformed(evt);
      }
    });

    org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, Group, org.jdesktop.beansbinding.ELProperty.create("${background}"), this, org.jdesktop.beansbinding.BeanProperty.create("background"));
    bindingGroup.addBinding(binding);

    Group.setBackground(new java.awt.Color(0, 0, 0));
    Group.setForeground(java.awt.Color.lightGray);
    Group.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "_CSV", "BAT", "D66", "GLOBAL", "GT", "Lists", "TEXT", "WHAT", "WHEN", "WHERE", "WHO", "WHY" }));
    Group.setName("Group"); // NOI18N
    Group.setRequestFocusEnabled(false);
    Group.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        GroupActionPerformed(evt);
      }
    });

    jComboBox1.setBackground(new java.awt.Color(0, 0, 0));
    jComboBox1.setForeground(java.awt.Color.lightGray);
    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "About", "BAT", "//Backup", "BMP", "Boxer", "Brain", "Calc", "Capture", "Catalogue", "Colour", "Conflict", "Convert pic", "Counter", "D66", "DBP", "DBView", "DBWork", "//DirFile", "Extensions", "Folder", "Fonts", "Frames", "Greek", "GridLayer", "Hex", "Hidden", "Imports", "MapImperium", "MassCombat", "Mining", "PCGen", "Piece", "PrintSmall", "Programs", "Reflect", "Robots", "Rotate", "Rules", "ShowAll", "ShowPanels", "Traveller", "TXTView", "Universe", "updateSecs", "updateSubs", "updateWorlds", "WordGen", "Worlds", "ZipOpen" }));
    jComboBox1.setName("jComboBox1"); // NOI18N
    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox1ActionPerformed(evt);
      }
    });

    jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
    jScrollPane1.setForeground(new java.awt.Color(204, 204, 204));
    jScrollPane1.setHorizontalScrollBar(null);
    jScrollPane1.setName("jScrollPane1"); // NOI18N
    jScrollPane1.setOpaque(false);

    jList1.setBackground(new java.awt.Color(0, 0, 0));
    jList1.setForeground(java.awt.Color.lightGray);
    jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jList1.setName("jList1"); // NOI18N
    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList1MouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jList1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(Group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(Group, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
    );

    bindingGroup.bind();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    f4dbv = new Frame4DBView(getTitle());
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    f4tfv = new Frame4TextFileView(getTitle());
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    jfc.setCurrentDirectory(new File("."));
    jfc.setSelectedFile(new File("Reflection"));
    f4rv = new Frame4ReflectionView("Reflection");
    f4rv.setTitle("Reflection");
    GlobalMethods.autoColor(f4rv, Color.black, Color.red);
  }//GEN-LAST:event_jButton3ActionPerformed

  private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
    if (jList1.getSelectedValue().toString() != null) {
//      Debug.debug("jList1.getSelectedValue().toString() = " + jList1.getSelectedValue().toString());
      setPath();
      jf.setTitle(getTitle());
      if (2 == evt.getClickCount()) {
        jComboBox1.setSelectedIndex(14);
      }
    }
  }//GEN-LAST:event_jList1MouseClicked

  private void GroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GroupActionPerformed
    listChange();
    }//GEN-LAST:event_GroupActionPerformed

  private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
//    if (f4b == null) {
//      f4b = new Frame4Boxer(getTitle());
//    }
//    f4b.setVisible(true);
    panels.Panel4Boxer.main(names);
  }//GEN-LAST:event_jButton6ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    if (dialog == null) {
      dialog = new Dialog4About();
    }
    dialog.setVisible(true); // pop up dialog
  }//GEN-LAST:event_jButton4ActionPerformed

  private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    ok = folderWork(getPath());
  }//GEN-LAST:event_jButton5ActionPerformed

  private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
//    if (f4calc == null) {
//      f4calc = new panels.Frame4Calculator();
//    }
    JPanel p4calc = new Panel4("Calculator");
    p4calc.add(new Panel4Calculator());
    JFrame f4calc = new Frame4(p4calc);
    f4calc.setSize(200, 200);
//    f4calc.setVisible(true);
  }//GEN-LAST:event_jButton7ActionPerformed

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    DBPublic.doMenu();
  }//GEN-LAST:event_jComboBox1ActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  public static javax.swing.JComboBox Group;
  public static javax.swing.JButton jButton1;
  public static javax.swing.JButton jButton2;
  public static javax.swing.JButton jButton3;
  public static javax.swing.JButton jButton4;
  public static javax.swing.JButton jButton5;
  public static javax.swing.JButton jButton6;
  public static javax.swing.JButton jButton7;
  public static javax.swing.JComboBox jComboBox1;
  public static javax.swing.JList jList1;
  private javax.swing.JScrollPane jScrollPane1;
  private org.jdesktop.beansbinding.BindingGroup bindingGroup;
  // End of variables declaration//GEN-END:variables

  @SuppressWarnings("unchecked")
  private static void listChange() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    strings = loadFileArray();
    @SuppressWarnings("unchecked")
    DefaultListModel<String> dlm = new DefaultListModel<>();
    if (strings != null) {
      for (int j = 0; j < strings.length; j++) {
        dlm.add(j, strings[j]);
      }
      DBViewer.jList1.setModel(dlm);
    }
    if (strings.length != 0) {
      DBViewer.jList1.setSelectedIndex(0);
      jf.setTitle(getTitle());
    }
  }

  /**
   directory review of files and folders

   @param strings to check if folder or file
   */
  private static void countFoldersAndFiles(String[] strings) {
    try {
      //<editor-fold defaultstate="collapsed" desc="DEBUG">
      boolean DEBUG = false;
      if (DEBUG) { // true or false
        //System.out.print("---------------------------");
        //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      }
//</editor-fold>
      int d = 0;
      int f = 0;
      al = null;
//      for (int i = 0; i < strings.length; i++) {
//        System.out.println("" + " = " + strings[i]);
//      }
//      debug("strings.length = " + strings.length);
      if ((strings.length > 0) & (strings != null)) {
        for (int i = 0; i < strings.length; i++) {
          File t = new File(path, strings[i]);
          al = new ArrayList<>();
          if (t.isDirectory()) {
            d += 1;
          } else {
            al.add(strings[i]);
            f += 1;
          }
        }
        //System.out.print("dirs" + " = " + d);
        //System.out.print("files" + " = " + f);
      }
    } catch (Exception e) {
    }
  }

  /**
   Find out file/folder, if not existing, create one

   @param path         to file
   @param createfolder yes/no
   @return true if file or folder created
   */
  private static Boolean OrMakeFileFolder(String path, Boolean createfolder) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    File desired = null;
    if (createfolder) {
      desired = new File(path + "Lists");
    } else if (!createfolder) {
      desired = new File(path + "Lists/" + jList1.getSelectedValue().toString());
    }
    boolean created = false;
    if (!desired.exists()) {
      if (createfolder) {
        created = desired.mkdir();
      } else if (!createfolder) {
        try {
          created = desired.createNewFile();
        } catch (IOException ex) {
          //<editor-fold defaultstate="collapsed" desc="DEBUG">
          DEBUG = false;
          if (DEBUG) { // true or false
            //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
          }
//</editor-fold>
          //System.out.print("ex" + " = " + ex);
        }
      }
    }
    return created;
  }

  /**
   Discover number of type in file and return array of indices

   @param type string equivalent of Component name
   @param path path to file
   @return true if Component(s) exists
   */
  @SuppressWarnings("unchecked")
  private static ArrayList<String> getArrayListOfType(String type, String path) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    jButton1.doClick();
    al = new ArrayList<>();
    Component[] comps = Panel4LabelComboButton.getJpan().getComponents();
    for (int i = 0; i < comps.length; i++) {
      if (comps[i].getClass().toString().contains(type)) {
        al.add("" + i);
        jcb.addItem((JComboBox<String>) comps[i]);
      }
    }
    return al;
  }

  /**
   @param type     NOT USED
   @param path     path to file
   @param editable true if allow edit
   @return editable true if allow edit
   */
  private static Boolean setEditables(String type, String path, Boolean editable) {
    return ok;
  }

  private static String[] getStringsFromFile(String path) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    String oldpath = path;
    path += "Lists/" + jList1.getSelectedValue().toString();
    int lines = 0;
    try {
      try (BufferedReader in = new BufferedReader(new FileReader(path))) {
        String line;
        while ((line = in.readLine()) != null) {
          lines += 1;
        }
      }
    } catch (IOException iox) {
      //<editor-fold defaultstate="collapsed" desc="DEBUG">
      DEBUG = false;
      if (DEBUG) { // true or false
        //System.out.print("---------------------------");
        //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      }
//</editor-fold>
      //System.out.print(iox);
    }
    strings = new String[lines];
    try {
      try (BufferedReader in = new BufferedReader(new FileReader(path))) {
        String line;
        int i = 0;
        while ((line = in.readLine()) != null) {
          strings[i] = line;
          if (line.startsWith("//")) {
            i += 1;
            continue;
          }
          i += 1;
        }
      }
    } catch (IOException iox) {
      //<editor-fold defaultstate="collapsed" desc="DEBUG">
      DEBUG = false;
      if (DEBUG) { // true or false
        //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      }
//</editor-fold>
      //System.out.print(iox);
    }

    return strings;
  }

  @SuppressWarnings({"unchecked", "unchecked"})
  private static JComboBox<String> setStringsToCombo(String path) {
    jcb = new JComboBox<>();
    for (String string1 : strings) {
      jcb.addItem(string1);
    }
    return jcb;
  }

  private static String[] getStringsFromCombo(JComboBox jcb) {
    strings = new String[jcb.getItemCount()];
    for (int i = 0; i < jcb.getItemCount(); i++) {
      strings[i] = jcb.getItemAt(i).toString();
    }
    return strings;
  }

  /**

   @param path to check
   @return true if OK
   */
  public static Boolean folderWork(String path) {
    ok = OrMakeFileFolder(getPath(), true);//create folder otherwise
    ok = OrMakeFileFolder(getPath(), false);//create file otherwise
    al = getArrayListOfType("JComboBox", getPath() + "Lists/" + jList1
      .getSelectedValue().toString());//get array of items in file
    strings = getStringsFromFile(getPath());
    ok = setEditables("JComboBox", path, false);
    jcb = setStringsToCombo(path);
    strings = getStringsFromCombo(jcb);
    for (int i = 0; i < strings.length; i++) {
      //System.out.print("" + " = " + strings[i]);
    }
    return ok;
  }

  /**

   @param saveName to set JFrame to
   */
  public static void setTitle(String saveName) {
    try {
      jf.setTitle(saveName);
    } catch (Exception e) {
    }
  }
}
