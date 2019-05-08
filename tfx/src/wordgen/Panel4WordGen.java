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
package wordgen;

//import dbviewer.globals.GlobalMethods;
//import static dbviewer.globals.GlobalVariables.CSV;
//import static dbviewer.globals.GlobalVariables.FS;
//import static dbviewer.globals.GlobalVariables.T5;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static wordgen.GlobalVariables.FS;

/**
 <p>
 @author maggot
 */
public class Panel4WordGen extends javax.swing.JPanel {

  static String T5 = "C:/T5";
  //<editor-fold defaultstate="collapsed" desc="variables">
  /**
   any guesses?
   */
  public static boolean ok = false;
  /**
   language tables
   */
  public static final String[] langs = new String[]{
    T5 + "/CSV/imp-asl", T5 + "/CSV/imp-dro",
    T5 + "/CSV/imp-var", T5 + "/CSV/imp-vil",
    T5 + "/CSV/imp-zho", T5 + "/CSV/imp-lang"
  };
  static JFrame jf = null;
  static JPanel jp;
  static final String TAB = "\t";
  static final String CRLF = GlobalVariables.CRLF;
  static File f;
  static Object[] parts;
  static String[] lines;
  static int cols;
  static String syll;
  static int scount;
  static String word;
  static String lets;
  static String s = null;
  static wordgen.Panel4Grid6x6[] p4gs;
  static wordgen.Panel4Grid6x6 p4g;
  static String lang;
  static int n = 0;
  static int num = 0;
  static Component[] comps;
  //</editor-fold>
  private static String CSV = T5 + FS + "_CSV";

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    setTables(args);
    jp = new Panel4WordGen();
    jf = new Frame4(jp);
    jf.setLayout(new GridLayout(4, 4));
    jf.setBounds(0, 0, 435, 425);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    jf.setSize(new Dimension(jf.getWidth(),jf.getHeight()/2));
  }

  /**
   <p>
   @param evt the value of evt
   @param n   table to click
   @return syllable
   */
  public String getSyll(MouseEvent evt, int n) {
    //<editor-fold defaultstate="collapsed" desc="setup">
    clear();
    word = "";
//    reRoll(sylls);
    if (n == 0) {
      tab1MouseClicked(evt);
    } else {
      tab2MouseClicked(evt);
    }
    p4g = p4gs[n];
    syll = p4g.getSelected().replace("\t", "");
//    System.out.println("syll" + " = " + syll);
    lets = "";
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="switch">
    switch (syll) {
      case "C": {
        lets = p4gs[2].getSelected();
        break;
      }
      case "V": {
        lets = p4gs[3].getSelected();
        break;
      }
      case "CV": {
        lets = p4gs[2].getSelected();
        lets += p4gs[3].getSelected();
        break;
      }
      case "VC": {
        lets = p4gs[3].getSelected();
        lets += p4gs[2].getSelected();
        break;
      }
      case "CVC": {
        lets = p4gs[2].getSelected();
        lets += p4gs[3].getSelected();
        lets += p4gs[4].getSelected();
        break;
      }
    }
    lets = lets.replace("\t", "");
    //</editor-fold>
    return lets;
  }

  /**
   Creates new form Panel4WordGen
   */
  public Panel4WordGen() {
    setName("Panel4WordGen");
    initComponents();
    jButton1.setToolTipText("CTRL-A)(CTRL-C) copies to clipboard!");
    p4gs = new wordgen.Panel4Grid6x6[]{
      panel4Grid6x61,
      panel4Grid6x62,
      panel4Grid6x63,
      panel4Grid6x64,
      panel4Grid6x65
    };
    display();
//    jTextArea2.append(getWord() + CRLF);
  }

  /**
   <p>
   @param f1 file to load
   @return String array of lines of text
   */
  public static String[] loadLines(File f1) {
    lines = null;
    if (f.isFile()) {
      lines = GlobalMethods.getLinesFromFile(f);
    }
    return lines;
  }

  public static String getWord(MouseEvent evt) {
    Panel4WordGen panel4WordGen = new Panel4WordGen();
    panel4WordGen.jLabel6MouseClicked(evt);
    return panel4WordGen.jTextArea2.getText();
  }

  public static String getWord(MouseEvent evt, String arg, String text) {
    Panel4WordGen panel4WordGen = new Panel4WordGen();
    panel4WordGen.jComboBox1.setSelectedItem(arg);
    panel4WordGen.jComboBox1ItemStateChanged(null);
//    panel4WordGen.jTextArea2.setText("");
    panel4WordGen.jLabel6MouseClicked(evt);
    return panel4WordGen.jTextArea2.getText();
  }

  private static void setTables(String[] args) {
    int k = 0;
    for (k = 0; k < langs.length; k++) {
      f = new File(langs[k]);
      if (args.length == 0) {
        f = new File(T5 + FS + "WordGen/src/wordgen/imp-villang.csv");
      }
      lines = loadLines(f);
      int l = lines.length;
      parts = loadParts(lines);
      int p = parts.length;
      cols = parts.length / lines.length;
//      int i = 0;
//      for (i = 0; i < 7; i++) {
////        printParts(0, i * 7, 7, 7);
//      }
//      for (i = 0; i < 7; i++) {
////        printParts(7, i * 7, 7, 7);
//      }
//      for (i = 0; i < 7; i++) {
////        printParts(14, i * 7, 7, 7);
//      }
    }
  }

  private static Object[] loadParts(String[] lines) {
    System.out.println("loadParts(" + lines + ");");
    ArrayList<String> al = new ArrayList<>();
    String[] tmp;
    for (int i = 0; i < lines.length; i++) {
      tmp = GlobalMethods.stripCSV(lines[i]);
      al.addAll(Arrays.asList(tmp));
    }
    return al.toArray();
  }

  private static Object[] getParts(int left, int top, int across, int down) {
    ArrayList<String> bits = new ArrayList<>();
    String string;
    for (int i = top * cols; i < (top + down) * cols; i += cols) {
      for (int j = left; j < left + across; j++) {
        string = parts[i + j].toString().replace("\"", "").trim() + "\t";
        bits.add(string);
      }
    }
    return bits.toArray();
  }

  private static String getPart(int x, int y, int tbl) {
    int i = x + (y * cols);
    return (parts[i].toString());
  }

  /**

   */
  private static void display() {
    //<editor-fold defaultstate="collapsed" desc="lang">
    lang = jComboBox1.getSelectedItem().toString();
    ok = false;
    switch (lang) {
      case "Vilani": {
        s = CSV + FS + "imp-vil";
        num = 3;
        break;
      }
      case "Zhodani": {
        s = CSV + FS + "imp-zho";
        num = 4;
        break;
      }
      case "Vargr": {
        s = CSV + FS + "imp-var";
        num = 2;
        break;
      }
      case "Aslan": {
        s = CSV + FS + "imp-asl";
        num = 0;
        break;
      }
      case "Droyne": {
        s = CSV + FS + "imp-dro";
        num = 1;
        break;
      }
      case "Other": {
        s = CSV + FS + "imp-lang";
        num = 5;
        ok = true;
        break;
      }
    }
    //</editor-fold>
//    JOptionPane.showMessageDialog(jf, "" + s);
    f = new File(s);
    lines = loadLines(f);
    parts = loadParts(lines);
    cols = parts.length / lines.length;
    JLabel l;
    int tab1 = Integer.parseInt(jLabel3.getText());
    int tab2 = Integer.parseInt(jLabel4.getText());
    int tab3 = Integer.parseInt(jLabel5.getText());
    int[][] it = {
      {1, 1, 6, 6},
      {15, 1, 6, 6},
      {1, 1 + (tab1 * 7), 6, 6},//C
      {8, 1 + (tab2 * 7), 6, 6},//V
      {15, 1 + (tab3 * 7), 6, 6}//C
    };
    for (int i = 0; i < 5; i++) {
      p4g = p4gs[i];
      if (p4g.getComponents().length == 36) {
        Component[] comp = p4g.getComponents();
        Object[] pars = getParts(it[i][0], it[i][1], it[i][2], it[i][3]);
        for (int k = 0; k < comp.length; k++) {
          l = (JLabel) comp[k];
          l.setText((String) pars[k]);
        }
      }
    }
  }

  private void click(int n, MouseEvent evt) {
    syll = "";
    scount = 0;
    for (int i = 0; i < sylls.getText().length(); i++) {
      scount += 1;
      int x = getRoll(1);
      int y = getRoll(1);
      int numb = x + ((y - 1) * 6) - 1;
      if (i == 0 | syll.endsWith("V")) {
        syll = p4gs[n - 1].recolor(numb);
      } else {
        syll = p4gs[n].recolor(numb);
      }
      s = getParts(syll, evt);
    }
  }

  private String getParts(String sylla, MouseEvent evt) {
    lets = "";
    switch (sylla) {
      case "C": {
        lets = getFromTable(3, evt);
        break;
      }
      case "V": {
        lets = getFromTable(4, evt);
        break;
      }
      case "CV": {
        lets = getFromTable(3, evt);
        lets += getFromTable(4, evt);
        break;
      }
      case "VC": {
        lets = getFromTable(4, evt);
        lets += getFromTable(3, evt);
        break;
      }
      case "CVC": {
        lets = getFromTable(3, evt);
        lets += getFromTable(4, evt);
        lets += getFromTable(5, evt);
        break;
      }
    }
    return lets.replace("\t", "");
  }

  private String getFromTable(int i, MouseEvent evt) {
    Panel4Grid6x6 p4gr = null;
    switch (i) {
      case 1: {
        p4gr = null;
        break;
      }
      case 2: {
        p4gr = null;
        break;
      }
      case 3: {
        p4gr = p4gs[2];
        tab3MouseClicked(evt);
        break;
      }
      case 4: {
        p4gr = p4gs[3];
        tab4MouseClicked(evt);
        break;
      }
      case 5: {
        p4gr = p4gs[4];
        tab5MouseClicked(evt);
        break;
      }
    }
    for (int j = 0; j < 36; j++) {
      if (p4gr != null) {
        if (p4gr.labs[j].getBackground() == Color.white) {
          String string = p4gr.labs[j].getText().replace("\t", "");
//          //System.out.print(string);
          return string;
        }
      }
    }

    return "";
  }

  private int getRoll(int x) {
    int sub = 0;
    for (int i = 0; i < x; i++) {
      sub += (int) (Math.random() * 6) + 1;
    }
    return sub;
  }

  private static void reRoll(JLabel name) {
    JLabel lab;
    switch (name.getName()) {
      case "r1": {
        lab = jLabel3;
        break;
      }
      case "r2": {
        lab = jLabel4;
        break;
      }
      case "r3": {
        lab = jLabel5;
        break;
      }
      case "r4": {
        lab = sylls;
        break;
      }
      case "r5": {
        lab = jLabel7;
        break;
      }
      case "r6": {
        lab = jLabel8;
        break;
      }
      case "r7": {
        lab = jLabel9;
        break;
      }
      case "r8": {
        lab = jLabel10;
        break;
      }
      case "r9": {
        lab = jLabel11;
        break;
      }
      default: {
        lab = jLabel3;
        break;
      }
    }
    lab.setText("" + (int) ((Math.random() * 6) + 1));
    display();
  }

  private static void printParts(int left, int top, int across, int down) {
    for (int i = top * cols; i < (top + down) * cols; i += cols) {
      for (int j = left; j < left + across; j++) {
        //System.out.print(parts[i + j].toString().replace("\"", "").trim() + "\t");
      }
      if (i % cols == 0) {
        //System.out.print(CRLF);
      }
    }
  }

  private void clear() {
    for (int i = 0; i < 5; i++) {
      p4gs[i].unColor();
    }
  }

  private static void showAbout() {
    JFrame jf = new JFrame();
    String txt = "ABOUT\n"
      + "\n"
      + "Programmed by Mark Ferguson	(maggot.iiss@sky.com)\n"
      + "\n"
      + "https://github.com/MaggotIISS\n"
      + "\n"
      + "The Traveller game in all forms is owned by Far Future Enterprises. \n"
      + "Copyright 1977 - 20016 Far Future Enterprises. \n"
      + "\n"
      + "Traveller is a registered trademark of Far Future Enterprises. \n"
      + "Far Future permits web sites and fanzines for this game, provided \n"
      + "it contains this notice, that Far Future is notified, and subject \n"
      + "to a withdrawal of permission on 90 days notice. \n"
      + "\n"
      + "The contents of this site are for personal, non-commercial use only. \n"
      + "\n"
      + "Any use of Far Future Enterprises's copyrighted material or \n"
      + "trademarks anywhere on this web site and its files should not \n"
      + "be viewed as a challenge to those copyrights or trademarks. \n"
      + "In addition, any program/articles/file on this site cannot be \n"
      + "republished or distributed without the consent of \n"
      + "the author who contributed it.\n";
    JTextArea jta = new JTextArea(txt, 50, 50);
    jta.setEditable(false);
    JScrollPane jsp = new JScrollPane(jta);
    jf.getContentPane().add(jsp);
    jf.setSize(500, 500);
    jf.setLocation(300, 300);
    jf.setVisible(true);

  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jComboBox1 = new javax.swing.JComboBox();
    tab1 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTextArea2 = new javax.swing.JTextArea();
    jPanel3 = new javax.swing.JPanel();
    tab2 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jPanel4 = new javax.swing.JPanel();
    panel4Grid6x61 = new wordgen.Panel4Grid6x6();
    jPanel5 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    sylls = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jPanel6 = new javax.swing.JPanel();
    panel4Grid6x62 = new wordgen.Panel4Grid6x6();
    jPanel7 = new javax.swing.JPanel();
    panel4Grid6x63 = new wordgen.Panel4Grid6x6();
    jPanel8 = new javax.swing.JPanel();
    panel4Grid6x64 = new wordgen.Panel4Grid6x6();
    jPanel9 = new javax.swing.JPanel();
    panel4Grid6x65 = new wordgen.Panel4Grid6x6();
    jPanel10 = new javax.swing.JPanel();
    tab3 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jPanel11 = new javax.swing.JPanel();
    tab4 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jPanel12 = new javax.swing.JPanel();
    tab5 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();

    setBackground(java.awt.Color.black);
    setMaximumSize(new java.awt.Dimension(500, 500));
    setMinimumSize(new java.awt.Dimension(500, 500));
    setOpaque(false);
    setPreferredSize(new java.awt.Dimension(500, 500));
    addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        formKeyPressed(evt);
      }
    });
    setLayout(new java.awt.GridLayout(4, 3));

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setOpaque(false);

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vilani", "Zhodani", "Vargr", "Aslan", "Droyne", "Other" }));
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

    tab1.setForeground(java.awt.Color.green);
    tab1.setText("Table 1");
    tab1.setToolTipText("Table 1");
    tab1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tab1MouseClicked(evt);
      }
    });

    jLabel1.setForeground(java.awt.Color.green);
    jLabel1.setText("getSyll()");
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    jButton1.setText("Click and Wait Seconds");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setText("Dictionaries to T5 folder");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jButton3.setText("About");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(tab1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel1))
      .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
      .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jButton1)
        .addGap(0, 0, 0)
        .addComponent(jButton2)
        .addGap(0, 0, 0)
        .addComponent(jButton3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tab1)
          .addComponent(jLabel1)))
    );

    add(jPanel1);

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
    jPanel2.setOpaque(false);

    jTextArea2.setColumns(12);
    jTextArea2.setRows(2);
    jTextArea2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextArea2MouseClicked(evt);
      }
    });
    jScrollPane3.setViewportView(jTextArea2);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
    );

    add(jPanel2);

    jPanel3.setBackground(new java.awt.Color(255, 255, 255));
    jPanel3.setOpaque(false);

    tab2.setForeground(java.awt.Color.green);
    tab2.setText("Table 2");
    tab2.setToolTipText("Table 2");
    tab2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tab2MouseClicked(evt);
      }
    });

    jLabel2.setForeground(java.awt.Color.green);
    jLabel2.setText("getSyll()");
    jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel2MouseClicked(evt);
      }
    });

    jLabel6.setForeground(java.awt.Color.green);
    jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel6.setText("getWord()");
    jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel6MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(tab2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
        .addComponent(jLabel2))
      .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tab2)
          .addComponent(jLabel2)))
    );

    add(jPanel3);

    jPanel4.setOpaque(false);

    panel4Grid6x61.setName("Table 1"); // NOI18N

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel4Grid6x61, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel4Grid6x61, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
    );

    add(jPanel4);

    jPanel5.setOpaque(false);

    jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    jScrollPane1.setEnabled(false);

    jTextArea1.setEditable(false);
    jTextArea1.setColumns(17);
    jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
    jTextArea1.setRows(5);
    jTextArea1.setText("1 - 1d syllables\n2 - Table 1 for 1st syllable or if prev\n  end in a vowel, else use Table 2\n3 - 1d for tables below, 2d for \n  x & y coords");
    jTextArea1.setWrapStyleWord(true);
    jTextArea1.setBorder(null);
    jTextArea1.setCaretPosition(0);
    jTextArea1.setEnabled(false);
    jTextArea1.setFocusable(false);
    jScrollPane1.setViewportView(jTextArea1);

    sylls.setForeground(java.awt.Color.green);
    sylls.setText("1");
    sylls.setName("r4"); // NOI18N
    sylls.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        syllsMouseClicked(evt);
      }
    });

    jLabel7.setForeground(java.awt.Color.green);
    jLabel7.setText("1");
    jLabel7.setName("r5"); // NOI18N
    jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel7MouseClicked(evt);
      }
    });

    jLabel8.setForeground(java.awt.Color.green);
    jLabel8.setText("1");
    jLabel8.setName("r6"); // NOI18N
    jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel8MouseClicked(evt);
      }
    });

    jLabel9.setForeground(java.awt.Color.green);
    jLabel9.setText("1");
    jLabel9.setName("r7"); // NOI18N
    jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel9MouseClicked(evt);
      }
    });

    jLabel10.setForeground(java.awt.Color.green);
    jLabel10.setText("1");
    jLabel10.setName("r8"); // NOI18N
    jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel10MouseClicked(evt);
      }
    });

    jLabel11.setForeground(java.awt.Color.green);
    jLabel11.setText("1");
    jLabel11.setName("r9"); // NOI18N
    jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel11MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addComponent(sylls, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel7)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel7, jLabel8, jLabel9, sylls});

    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(sylls)
          .addComponent(jLabel7)
          .addComponent(jLabel8)
          .addComponent(jLabel9)
          .addComponent(jLabel10)
          .addComponent(jLabel11))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
    );

    jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel7, jLabel8, jLabel9, sylls});

    add(jPanel5);

    jPanel6.setBackground(new java.awt.Color(204, 204, 204));
    jPanel6.setOpaque(false);

    panel4Grid6x62.setName("Table 2"); // NOI18N

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel4Grid6x62, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
    );
    jPanel6Layout.setVerticalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel4Grid6x62, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
    );

    add(jPanel6);

    jPanel7.setOpaque(false);

    panel4Grid6x63.setName("Table 3"); // NOI18N

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel4Grid6x63, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
    );
    jPanel7Layout.setVerticalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel4Grid6x63, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
    );

    add(jPanel7);

    jPanel8.setOpaque(false);

    panel4Grid6x64.setName("Table 4"); // NOI18N

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel4Grid6x64, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
    );
    jPanel8Layout.setVerticalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel4Grid6x64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
    );

    add(jPanel8);

    jPanel9.setBackground(new java.awt.Color(204, 204, 204));
    jPanel9.setOpaque(false);

    panel4Grid6x65.setName("Table 5"); // NOI18N

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel4Grid6x65, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
    );
    jPanel9Layout.setVerticalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panel4Grid6x65, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
    );

    add(jPanel9);

    jPanel10.setOpaque(false);

    tab3.setForeground(java.awt.Color.green);
    tab3.setText("Table 3");
    tab3.setToolTipText("");
    tab3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tab3MouseClicked(evt);
      }
    });

    jLabel3.setForeground(java.awt.Color.green);
    jLabel3.setText("1");
    jLabel3.setName("r1"); // NOI18N
    jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel3MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel10Layout.createSequentialGroup()
        .addComponent(tab3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(160, 160, 160))
    );
    jPanel10Layout.setVerticalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel10Layout.createSequentialGroup()
        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tab3)
          .addComponent(jLabel3))
        .addGap(0, 111, Short.MAX_VALUE))
    );

    add(jPanel10);

    jPanel11.setOpaque(false);

    tab4.setForeground(java.awt.Color.green);
    tab4.setText("Table 4");
    tab4.setToolTipText("Table 4");
    tab4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tab4MouseClicked(evt);
      }
    });

    jLabel4.setForeground(java.awt.Color.green);
    jLabel4.setText("1");
    jLabel4.setName("r2"); // NOI18N
    jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel4MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
      jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel11Layout.createSequentialGroup()
        .addComponent(tab4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(161, 161, 161))
    );
    jPanel11Layout.setVerticalGroup(
      jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel11Layout.createSequentialGroup()
        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tab4)
          .addComponent(jLabel4))
        .addContainerGap(110, Short.MAX_VALUE))
    );

    add(jPanel11);

    jPanel12.setOpaque(false);

    tab5.setForeground(java.awt.Color.green);
    tab5.setText("Table 5");
    tab5.setToolTipText("Table 5");
    tab5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        tab5MouseClicked(evt);
      }
    });

    jLabel5.setForeground(java.awt.Color.green);
    jLabel5.setText("1");
    jLabel5.setName("r3"); // NOI18N
    jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel5MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
    jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(
      jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel12Layout.createSequentialGroup()
        .addComponent(tab5)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGap(160, 160, 160))
    );
    jPanel12Layout.setVerticalGroup(
      jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel12Layout.createSequentialGroup()
        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tab5)
          .addComponent(jLabel5))
        .addContainerGap(111, Short.MAX_VALUE))
    );

    add(jPanel12);
  }// </editor-fold>//GEN-END:initComponents

  private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
//    if (evt.getStateChange() == ItemEvent.SELECTED) {
    display();
//    }
  }//GEN-LAST:event_jComboBox1ItemStateChanged

  private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
    reRoll(jLabel3);
  }//GEN-LAST:event_jLabel3MouseClicked

  private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
    reRoll(jLabel4);
  }//GEN-LAST:event_jLabel4MouseClicked

  private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    reRoll(jLabel5);
  }//GEN-LAST:event_jLabel5MouseClicked

  private void syllsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_syllsMouseClicked
    reRoll(sylls);
  }//GEN-LAST:event_syllsMouseClicked

  private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
  }//GEN-LAST:event_formKeyPressed

  private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
    display();
    tab1MouseClicked(null);
  }//GEN-LAST:event_jComboBox1MouseClicked

  private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
    clear();
    click(1, evt);
  }//GEN-LAST:event_tab1MouseClicked

  private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
    clear();
    click(2, evt);
  }//GEN-LAST:event_tab2MouseClicked

  private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked
    jLabel3MouseClicked(evt);
    click(3, evt);
  }//GEN-LAST:event_tab3MouseClicked

  private void tab4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab4MouseClicked
    jLabel4MouseClicked(evt);
    click(4, evt);
  }//GEN-LAST:event_tab4MouseClicked

  private void tab5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab5MouseClicked
    jLabel5MouseClicked(evt);
    click(5, evt);
  }//GEN-LAST:event_tab5MouseClicked

  private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
    reRoll(jLabel11);
  }//GEN-LAST:event_jLabel11MouseClicked

  private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
    reRoll(jLabel10);
  }//GEN-LAST:event_jLabel10MouseClicked

  private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
    reRoll(jLabel9);
  }//GEN-LAST:event_jLabel9MouseClicked

  private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    reRoll(jLabel8);
  }//GEN-LAST:event_jLabel8MouseClicked

  private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
    reRoll(jLabel7);
  }//GEN-LAST:event_jLabel7MouseClicked

  private void jTextArea2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea2MouseClicked
    if (evt.getClickCount() > 2) {
      jTextArea2.setText("");
    }
  }//GEN-LAST:event_jTextArea2MouseClicked

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    jTextArea2.append(GlobalMethods.capWords(getSyll(evt, 0)));
  }//GEN-LAST:event_jLabel1MouseClicked

  private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
    jTextArea2.append(GlobalMethods.capWords(getSyll(evt, 1)));
  }//GEN-LAST:event_jLabel2MouseClicked

  private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
//    System.out.println("getWord");
    syllsMouseClicked(evt);
    jLabel1MouseClicked(evt);
//    System.out.println("syll" + " = " + syll);
    for (int i = 1; i < Integer.parseInt(sylls.getText()); i++) {
      if (syll.endsWith("V")) {
        jLabel1MouseClicked(evt);
      } else {
        jLabel2MouseClicked(evt);
      }
    }
    jTextArea2.append(CRLF);
  }//GEN-LAST:event_jLabel6MouseClicked

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    MouseEvent me = null;
    for (int i = 0; i < 1000; i++) {
      jLabel6MouseClicked(me);
    }
    String[] lines = jTextArea2.getText().split(CRLF);
    String newtext = "";
    Arrays.sort(lines);
    newtext = lines[0] + CRLF;
    for (int i = 1; i < lines.length; i++) {
      if (!lines[i].equals(lines[i - 1])) {
        newtext += lines[i] + CRLF;
      }
    }
    jTextArea2.setText(newtext);
    jButton1.setText("" + newtext.split(CRLF).length + " Words in list");
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // Create Dictionaries for each race
    for (int i = 0; i < jComboBox1.getModel().getSize(); i++) {
      String string = jComboBox1.getSelectedItem().toString();
      jComboBox1.setSelectedIndex(i);
      for (int j = 0; j < 10; j++) {
        jButton1.doClick();

      }
      //jTextArea2.setText(string+CRLF);
      GlobalMethods.saveTextFile(T5, string + "Dictionary", "txt", jTextArea2.getText().split(CRLF));

    }
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    showAbout();
  }//GEN-LAST:event_jButton3ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  public static javax.swing.JComboBox jComboBox1;
  private javax.swing.JLabel jLabel1;
  private static javax.swing.JLabel jLabel10;
  private static javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel2;
  private static javax.swing.JLabel jLabel3;
  private static javax.swing.JLabel jLabel4;
  private static javax.swing.JLabel jLabel5;
  public static javax.swing.JLabel jLabel6;
  private static javax.swing.JLabel jLabel7;
  private static javax.swing.JLabel jLabel8;
  private static javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel10;
  private javax.swing.JPanel jPanel11;
  private javax.swing.JPanel jPanel12;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JPanel jPanel8;
  private javax.swing.JPanel jPanel9;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTextArea jTextArea1;
  public static javax.swing.JTextArea jTextArea2;
  private wordgen.Panel4Grid6x6 panel4Grid6x61;
  private wordgen.Panel4Grid6x6 panel4Grid6x62;
  private wordgen.Panel4Grid6x6 panel4Grid6x63;
  private wordgen.Panel4Grid6x6 panel4Grid6x64;
  private wordgen.Panel4Grid6x6 panel4Grid6x65;
  private static javax.swing.JLabel sylls;
  private static javax.swing.JLabel tab1;
  private javax.swing.JLabel tab2;
  private javax.swing.JLabel tab3;
  private javax.swing.JLabel tab4;
  private javax.swing.JLabel tab5;
  // End of variables declaration//GEN-END:variables
}
