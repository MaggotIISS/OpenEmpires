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

import java.awt.Color;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 <p>
 @author Your Name Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4Mining extends Panel4 {

  //<editor-fold defaultstate="collapsed" desc="variables">
  private String CRLF = System.lineSeparator();
  private String are = "";
  private String pot = "";
  private String com = "";
  private String pre = "";
  private int siz = 0;
  private int dep = 0;
  private String ins = "";
  private String out = "";
  private String[] parts = {
    "N-Zone(Nickel-Iron)", "M-Zone(Mixed)",
    "C-Zone-Trojans(Carbonaceous)", "Rings"};
  private String[] potential = {
    "Radioactives", "Crystals", "Dense Metals", "Exotics"};
  private String[] composition = {"Carbonaceous", "Nickel-Iron", "Ice"};
  private String[] size = {"1", "10", "100", "1000", "10000",
    "100000", "1000000", "Small planetoid", "Small planetoid",
    "Small planetoid", "Large planetoid", "Large planetoid"};
  private int[] WatchesRequired = {0, 1, 1, 2, 3, 3, 4, 5, 5, 5, 10, 10};
  private String[] location = {"Inside", "Outside"};
  private String[] inside = {"Distress call", "Excess fuel use",
    "System malfunction",
    "Scanner failure", "Ship encounter", "Quarrel", "Asteroid swarm"
  };
  private String[] outside = {"Artifact", "Lost character", "Suit rupture",
    "Equipment malfunction", "Quarrel", "Injury", "Second resource"
  };
  private int Watch = 0;
  private int Day = 1;
  private Boolean in = true;
  private int min = 0;
  private int max = 0;
  private int time = 0;
  private int checks = 0;
  private double yield = 0;
  private int zeroes = 0;
  //private int r = 0;
  private static int step = 0;
  private static double volume = 0;
  private int beacon = 0;
  private int beacons = 100;
  private static double r, d, cv, dt, m;
  private static NumberFormat nf = NumberFormat.getNumberInstance();
  private static double COST;
  private static String[][] products;
  private static double find;
  private static double value;
  private static double banked = 0;

  //</editor-fold>
  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    Panel4Mining p4 = new Panel4Mining();
    Frame4 f4 = new Frame4(p4);
    f4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    f4.setSize(200, 200);
    f4.setTitle("Asteroid Belt Mining - " + panels.Panel4T5Locator.getSysPath());
    p4.Starport.setText(Panel4T5Locator.UWP.substring(0, 1).toString());
  }

  /**
   Creates new form Panel4Mining
   */
  public Panel4Mining() {
    super();
    products = new String[9][4];
    products[0] = new String[]{"Crystals", "20000", "Na-3,In+3,Ri+3", "-1d"};
    products[1] = new String[]{"Dense Metals", "50000", "In+4,Ni-3", "-1d"};
    products[2] = new String[]{"Radioactives", "1000000", "In+6,Ni-3,Ri-4",
      "-2d"};
    products[3] = new String[]{"Artifacts", "0", "", ""};
    products[4] = new String[]{"Carbonaceous material", "75", "SS+3", ""};
    products[5] = new String[]{"Nickel-Iron", "1000", "In+2,Po+3", ""};
    products[6] = new String[]{"Ice", "75", "SS+5,Wa-6,GG-3", ""};
    products[7] = new String[]{"Nickel-Iron planetoid", "400", "SB-3", ""};
    products[8] = new String[]{"Exotics", "5000", "SB-3", ""};
    initComponents();
    jButton6.setVisible(false);
    jButton1.setVisible(false);
    jButton3.setVisible(false);
    jButton5.setVisible(false);

    jButton8.setVisible(false);

  }

  /**
   EventRoll
   */
  public void EventRoll() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    //once per day onboard
    //once per watch outside
    int roll = (int) (Math.random() * 6) + 1;
    roll += (int) (Math.random() * 6) + 1;
    int num = 0;
    switch (jComboBox9.getSelectedIndex()) {//N-Zone, M-Zone, C-Zone/Trojans, Rings
      case 0: {
        num = 7;
        break;
      }
      case 1: {
        num = 8;
        break;
      }
      case 2: {
        num = 9;
        if (jRadioButton5.isSelected()) {
          num = 8;
        }
        break;
      }
      case 3: {
        num = 9;
        break;
      }
      default: {
        num = 8;
        break;
      }
    }
    if (roll >= num) {
      if (in == false) {
        EventLocation();
        Events();
      }
    } else {
    }
  }

//  /**
//   *
//   * @param txt
//   */
//  public Panel4Mining(String[] txt) {
//    this();
//    if (txt.equals("")) {
//    }
//
//  }
  /**
   <p>
   @return mining bc
   */
  public static String getText() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    return jTextArea1.getText();
  }

  /**
   <p>
   @return work details
   */
  public static String getDetails() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    String details = "";
    if (jRadioButton1.isSelected()) {
      details += " Double Shift";
    }
    if (jRadioButton2.isSelected()) {
      details += " Accelerating";
    }
    if (jRadioButton5.isSelected()) {
      details += " Trojans";
    }
    if (jRadioButton6.isSelected()) {
      details += " Producing";
    }
    if (jRadioButton7.isSelected()) {
      details += " Rings";
    }
    details += " " + jComboBox9.getSelectedItem().toString();
    //System.out.print("details" + " = " + details);
    return details;
  }

  /**
   <p>
   @return step number of mining process
   */
  public static int getStep() {
    return step;
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jButton1 = new javax.swing.JButton();
    jRadioButton1 = new javax.swing.JRadioButton();
    jRadioButton2 = new javax.swing.JRadioButton();
    jRadioButton5 = new javax.swing.JRadioButton();
    jRadioButton6 = new javax.swing.JRadioButton();
    jRadioButton7 = new javax.swing.JRadioButton();
    jComboBox9 = new javax.swing.JComboBox();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    Prospecting = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    jButton3 = new javax.swing.JButton();
    Intelligence = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    Admin = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    Pilot = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    jButton6 = new javax.swing.JButton();
    Starport = new javax.swing.JTextField();
    jLabel9 = new javax.swing.JLabel();
    jButton5 = new javax.swing.JButton();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jButton8 = new javax.swing.JButton();
    jLabel12 = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    Broker = new javax.swing.JTextField();
    jLabel14 = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();

    setBackground(new java.awt.Color(0, 0, 0));
    setForeground(java.awt.Color.lightGray);

    jButton1.setBackground(new java.awt.Color(0, 0, 0));
    jButton1.setForeground(java.awt.Color.lightGray);
    jButton1.setText("Scan");
    jButton1.setToolTipText("Roll once/watch (6hrs)\t11+");
    jButton1.setInheritsPopupMenu(true);
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jRadioButton1.setBackground(new java.awt.Color(0, 0, 0));
    jRadioButton1.setForeground(java.awt.Color.lightGray);
    jRadioButton1.setText("Double shift");
    jRadioButton1.setInheritsPopupMenu(true);

    jRadioButton2.setBackground(new java.awt.Color(0, 0, 0));
    jRadioButton2.setForeground(java.awt.Color.lightGray);
    jRadioButton2.setText("Accelerating");
    jRadioButton2.setInheritsPopupMenu(true);

    jRadioButton5.setBackground(new java.awt.Color(0, 0, 0));
    jRadioButton5.setForeground(java.awt.Color.lightGray);
    jRadioButton5.setText("Trojan Cluster");
    jRadioButton5.setInheritsPopupMenu(true);
    jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jRadioButton5ActionPerformed(evt);
      }
    });

    jRadioButton6.setBackground(new java.awt.Color(0, 0, 0));
    jRadioButton6.setForeground(java.awt.Color.lightGray);
    jRadioButton6.setText("Producing");
    jRadioButton6.setInheritsPopupMenu(true);

    jRadioButton7.setBackground(new java.awt.Color(0, 0, 0));
    jRadioButton7.setForeground(java.awt.Color.lightGray);
    jRadioButton7.setText("Ring system");
    jRadioButton7.setInheritsPopupMenu(true);
    jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jRadioButton7ActionPerformed(evt);
      }
    });

    jComboBox9.setForeground(new java.awt.Color(255, 0, 0));
    jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "N-Zone", "M-Zone", "C-Zone", "Trojans", "Rings" }));
    jComboBox9.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        jComboBox9ItemStateChanged(evt);
      }
    });

    jLabel1.setForeground(new java.awt.Color(0, 255, 0));
    jLabel1.setText("Watches");
    jLabel1.setToolTipText("End of");
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    jLabel2.setForeground(java.awt.Color.lightGray);
    jLabel2.setText("0");

    Prospecting.setText("0");

    jLabel5.setForeground(new java.awt.Color(0, 255, 0));
    jLabel5.setLabelFor(Prospecting);
    jLabel5.setText("Prospecting");
    jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel5MouseClicked(evt);
      }
    });

    jButton3.setBackground(new java.awt.Color(0, 0, 0));
    jButton3.setForeground(java.awt.Color.lightGray);
    jButton3.setText("Survey");
    jButton3.setToolTipText("Roll once/watch (6hrs)\t11+");
    jButton3.setInheritsPopupMenu(true);
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    Intelligence.setText("8");

    jLabel6.setForeground(new java.awt.Color(0, 255, 0));
    jLabel6.setLabelFor(Intelligence);
    jLabel6.setText("Intelligence");
    jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel6MouseClicked(evt);
      }
    });

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextArea1MouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jTextArea1);

    jLabel3.setForeground(java.awt.Color.lightGray);
    jLabel3.setText("0");
    jLabel3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jLabel3PropertyChange(evt);
      }
    });

    jLabel4.setForeground(new java.awt.Color(0, 255, 0));
    jLabel4.setText("Total");
    jLabel4.setToolTipText("End of");
    jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel4MouseClicked(evt);
      }
    });

    Admin.setText("0");

    jLabel7.setForeground(new java.awt.Color(0, 255, 0));
    jLabel7.setLabelFor(Admin);
    jLabel7.setText("Admin");
    jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel7MouseClicked(evt);
      }
    });

    Pilot.setText("0");

    jLabel8.setForeground(new java.awt.Color(0, 255, 0));
    jLabel8.setLabelFor(Pilot);
    jLabel8.setText("Pilot");
    jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel8MouseClicked(evt);
      }
    });

    jButton6.setBackground(new java.awt.Color(0, 0, 0));
    jButton6.setForeground(java.awt.Color.lightGray);
    jButton6.setText("Fly");
    jButton6.setToolTipText("Roll once/watch (6hrs)\t11+");
    jButton6.setInheritsPopupMenu(true);
    jButton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton6ActionPerformed(evt);
      }
    });

    Starport.setText("A");

    jLabel9.setForeground(new java.awt.Color(0, 255, 0));
    jLabel9.setLabelFor(Starport);
    jLabel9.setText("Starport");
    jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel9MouseClicked(evt);
      }
    });

    jButton5.setBackground(new java.awt.Color(0, 0, 0));
    jButton5.setForeground(java.awt.Color.lightGray);
    jButton5.setText("Beacon");
    jButton5.setToolTipText("Roll once/watch (6hrs)\t11+");
    jButton5.setInheritsPopupMenu(true);
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton5ActionPerformed(evt);
      }
    });

    jLabel10.setForeground(java.awt.Color.lightGray);
    jLabel10.setText("0");

    jLabel11.setForeground(java.awt.Color.lightGray);
    jLabel11.setText("Hours");
    jLabel11.setToolTipText("End of");
    jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel11MouseClicked(evt);
      }
    });

    jButton8.setBackground(new java.awt.Color(0, 0, 0));
    jButton8.setForeground(java.awt.Color.lightGray);
    jButton8.setText("Sell");
    jButton8.setToolTipText("Roll once/watch (6hrs)\t11+");
    jButton8.setInheritsPopupMenu(true);
    jButton8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton8ActionPerformed(evt);
      }
    });

    jLabel12.setForeground(java.awt.Color.lightGray);
    jLabel12.setText("MCr");

    jLabel13.setForeground(java.awt.Color.lightGray);
    jLabel13.setText("0");
    jLabel13.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jLabel13PropertyChange(evt);
      }
    });

    Broker.setText("0");

    jLabel14.setForeground(new java.awt.Color(0, 255, 0));
    jLabel14.setLabelFor(Broker);
    jLabel14.setText("Broker");
    jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel14MouseClicked(evt);
      }
    });

    jLabel15.setForeground(java.awt.Color.lightGray);
    jLabel15.setText("0");
    jLabel15.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jLabel15PropertyChange(evt);
      }
    });

    jLabel16.setForeground(java.awt.Color.lightGray);
    jLabel16.setText("MCr");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jRadioButton1)
              .addComponent(jRadioButton7)
              .addComponent(jRadioButton6)
              .addComponent(jRadioButton5)
              .addComponent(jRadioButton2)
              .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel1)
                  .addComponent(jLabel4)
                  .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                  .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                  .addComponent(jLabel9)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(Starport, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Broker)
                    .addComponent(Prospecting)
                    .addComponent(Admin)
                    .addComponent(Pilot)
                    .addComponent(Intelligence, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Admin, Intelligence, Pilot, Prospecting});

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton3});

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jRadioButton1, jRadioButton2, jRadioButton5, jRadioButton6, jRadioButton7});

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel5, jLabel6, jLabel7, jLabel8});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Starport, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Intelligence, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Prospecting, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Pilot, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Broker, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jRadioButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(34, 34, 34)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel12)
          .addComponent(jLabel13))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel16)
          .addComponent(jLabel15))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jLabel2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel11)
          .addComponent(jLabel10))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel4)
          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(20, 20, 20))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Step_1_Potential();
    if (!"Nothing".equals(pot)) {
      Step_2_Composition();
      Step_3_ASize();
      DoEvents(1);
    }
    jTextArea1.setToolTipText("Scanning");
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
    if (jRadioButton5.isSelected()) {
      jComboBox9.setSelectedIndex(3);
      jRadioButton7.setSelected(false);
    } else {
      jComboBox9.setSelectedIndex(0);
    }
//    else {
//      jComboBox9.setSelectedIndex(4);
//      jRadioButton5.setSelected(false);
//    }

  }//GEN-LAST:event_jRadioButton5ActionPerformed

  private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
    if (jRadioButton7.isSelected()) {
      jComboBox9.setSelectedIndex(4);
      jRadioButton5.setSelected(false);
    } else {
      jComboBox9.setSelectedIndex(0);
    }
//    else {
//      jComboBox9.setSelectedIndex(3);
//    }

  }//GEN-LAST:event_jRadioButton7ActionPerformed

  private void jComboBox9ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox9ItemStateChanged
    if (jComboBox9.getSelectedItem().toString().contains("Trojans")) {
      jRadioButton5.setSelected(true);
      jRadioButton7.setSelected(false);
    } else if (jComboBox9.getSelectedItem().toString().contains("Rings")) {
      jRadioButton5.setSelected(false);
      jRadioButton7.setSelected(true);
    } else {
      jRadioButton5.setSelected(false);
      jRadioButton7.setSelected(false);
    }
  }//GEN-LAST:event_jComboBox9ItemStateChanged

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
//<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    Watch = 0;
    jLabel2.setText("" + Watch);
    jButton6.doClick();
    jButton1.doClick();
    jButton3.doClick();

//    //jLabel4MouseClicked(evt);
//    jButton6.doClick();
//    Step_1_Potential();
//    Step_2_Composition();
//    Step_3_ASize();
//    DoEvents(1);
//    Step_4_Deposit();
//    DoEvents(1);
//    Step_5_Presence();
//    AddTime(time);
//    DoEvents(time);
    int total = 0 + Integer.parseInt(jLabel3.getText()) + Integer.parseInt(
      jLabel2.getText());
    jLabel3.setText("" + total);
//
////    double num = getVolume(1.5);
//    double num = globals.GetRadiusAndVolume.getVolume(1.5);
//    //System.out.print("num" + " = " + num + CRLF);
  }//GEN-LAST:event_jLabel1MouseClicked

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Step_4_Deposit();
    DoEvents(1);
    Step_5_Presence();
    AddTime(time);
    DoEvents(time);
    jTextArea1.setToolTipText("Surveying");
  }//GEN-LAST:event_jButton3ActionPerformed

  private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
    if (evt.getClickCount() > 2) {
      jTextArea1.setText("");
    }
  }//GEN-LAST:event_jTextArea1MouseClicked

  private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
//<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    Watch = 0;
    jLabel2.setText("" + Watch);
    jLabel3.setText("" + 0);
    jTextArea1.setText("");
    jLabel13.setText("" + 0);
    jLabel6.setEnabled(true);
    jLabel1.setEnabled(true);
    jLabel3.setEnabled(true);
    beacons = 100;
    beacon = 0;
    jLabel15.setText("0");
  }//GEN-LAST:event_jLabel4MouseClicked

  private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    Prospecting.setText(JOptionPane.showInputDialog(
      "What is your Prospecting skill?", "2"));
  }//GEN-LAST:event_jLabel5MouseClicked

  private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    Intelligence.setText(JOptionPane.showInputDialog(
      "What is your Intelligence?", "8"));
  }//GEN-LAST:event_jLabel6MouseClicked

  private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    Pilot.setText(JOptionPane.showInputDialog("What is your Pilot skill?", "2"));
  }//GEN-LAST:event_jLabel8MouseClicked

  private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
    Admin.setText(JOptionPane.showInputDialog("What is your Admin skill?", "2"));
  }//GEN-LAST:event_jLabel7MouseClicked

  private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    jTextArea1.append("==================================" + CRLF);
    jTextArea1.append("Piloting ends after ");
    int num;
    try {
      num = Integer.parseInt(Pilot.getText());
    } catch (NumberFormatException e) {
      num = 0;
    }
    int roll = getRoll(2) + num;
    //System.out.print("total roll" + " = " + roll);
    int val;
    val = 8 - roll;
    if (roll >= 8) {
      AddTime(1);
      jTextArea1.append(" " + getTime());
    } else {
      val += 1;
      //System.out.print("diff" + " = " + val);
      //System.out.print("watches" + " = " + (val));
      AddTime(val);
      jTextArea1.append(" WATCH " + (val) + CRLF);
    }
    jTextArea1.setToolTipText("Flying");
  }//GEN-LAST:event_jButton6ActionPerformed

  private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
    Starport.setText(JOptionPane.showInputDialog("What Starport (A-E,X)",
      Panel4T5Locator.UWP.substring(0, 1)));
  }//GEN-LAST:event_jLabel9MouseClicked

  private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    beacon += 1;
    beacons -= 1;
    if (beacons > 0) {
      jTextArea1.append("\tBeacon " + beacon + " placed" + CRLF);
      jTextArea1.append("\t " + beacons + " Beacons remaining" + CRLF);
    } else {
      jTextArea1.append("\t---NO MORE BEACONS---");
    }
    this.setBackground(Color.black);
  }//GEN-LAST:event_jButton5ActionPerformed

  private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_jLabel11MouseClicked

  private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    int ret = JOptionPane.showConfirmDialog(Panel4Mining.jTextArea1,
      "Sell?", "What to do with it", JOptionPane.YES_NO_OPTION);
    if (ret == JOptionPane.OK_OPTION) {
      //<editor-fold defaultstate="collapsed" desc="comment">
      /*


       */
      jTextArea1.append("---------------SOLD---------------" + CRLF);
      sellFind();
      jTextArea1.append("---------------SOLD---------------" + CRLF);
      jLabel13.setText("0");
    } else if (ret == JOptionPane.CANCEL_OPTION) {
      jLabel13.setText("0");
    } else if (ret == JOptionPane.NO_OPTION) {
      int ret2 = JOptionPane.showConfirmDialog(this.jTextArea1,
        "Auction?", "What to do with it", JOptionPane.YES_NO_OPTION);
      if (ret2 == JOptionPane.OK_OPTION) {
        /*


         */
        jTextArea1.append("---------------AUCTION---------------" + CRLF);
        auctionFind();
        jTextArea1.append("---------------AUCTION---------------" + CRLF);
        jTextArea1.append("AUCTIONED" + CRLF);
        jLabel13.setText("0");
      } else if (ret2 == JOptionPane.CANCEL_OPTION) {
        jLabel13.setText("0");
      } else if (ret2 == JOptionPane.NO_OPTION) {
        JOptionPane.showInputDialog(jTextArea1,
          "enter DTs/Watch", "2");
        /*


         */
        jTextArea1.append("---------------MINING---------------" + CRLF);
        mineFind();
        jTextArea1.append("---------------MINING---------------" + CRLF);
        jTextArea1.append("MINED" + CRLF);
        jLabel13.setText("0");
      }
      //</editor-fold>
    }

  }//GEN-LAST:event_jButton8ActionPerformed

  private void jLabel3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel3PropertyChange
    String num = nf.format(Double.parseDouble(jLabel3.getText()) / 4);
    jLabel3.setToolTipText("" + num + " days (" + nf.format(Double.parseDouble(
      jLabel3.getText()) / 4 / 7) + " weeks)");
  }//GEN-LAST:event_jLabel3PropertyChange

  private void jLabel13PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel13PropertyChange

    if (!"0".equals(jLabel13.getText())) {
      jButton5.doClick();
      jButton8.doClick();
    }
  }//GEN-LAST:event_jLabel13PropertyChange

  private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
    Broker.setText(JOptionPane
      .showInputDialog("What is your Broker skill?", "2"));
  }//GEN-LAST:event_jLabel14MouseClicked

  private void jLabel15PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jLabel15PropertyChange
    // TODO add your handling code here:
  }//GEN-LAST:event_jLabel15PropertyChange
  // Variables declaration - do not modify//GEN-BEGIN:variables
  public static javax.swing.JTextField Admin;
  public static javax.swing.JTextField Broker;
  public static javax.swing.JTextField Intelligence;
  public static javax.swing.JTextField Pilot;
  public static javax.swing.JTextField Prospecting;
  public static javax.swing.JTextField Starport;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton5;
  private javax.swing.JButton jButton6;
  private javax.swing.JButton jButton8;
  public static javax.swing.JComboBox jComboBox9;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  public static javax.swing.JRadioButton jRadioButton1;
  public static javax.swing.JRadioButton jRadioButton2;
  public static javax.swing.JRadioButton jRadioButton5;
  public static javax.swing.JRadioButton jRadioButton6;
  public static javax.swing.JRadioButton jRadioButton7;
  private javax.swing.JScrollPane jScrollPane1;
  private static javax.swing.JTextArea jTextArea1;
  // End of variables declaration//GEN-END:variables

  //Find best rock in area
  private void Step_1_Potential() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    step = 1;
    in = true;
    pot = "Nothing";
    jTextArea1.append("-------------------------" + CRLF);
    int roll = getRoll(2);
    //<editor-fold defaultstate="collapsed" desc="DMs">
    if (jRadioButton1.isSelected()) {
      roll -= 2;
    }
    if (jRadioButton2.isSelected()) {
      roll -= 2;
    }
    if (!"".equals(Prospecting.getText())) {
      roll += 1;
    }
    if (!"".equals(Intelligence.getText())) {
      int attr = Integer.parseInt(Intelligence.getText());
      if (attr > 7) {
        roll += 1;
      }
    }
    if (jRadioButton5.isSelected()) {
      roll += 1;
    }
    if (jRadioButton6.isSelected()) {
      roll += 1;
    }
    if (jRadioButton7.isSelected()) {
      roll -= 1;
    }
    //</editor-fold>
    if (roll < 2) {
      roll = 2;
    } else if (roll > 12) {
      roll = 12;
    }
    int roll2 = getRoll(2);
//    roll = 12;
    if (roll >= 11) {
      String result = "";
      String txt;
      txt = jComboBox9.getSelectedItem().toString();
      if (txt.startsWith("N")) {
        //<editor-fold defaultstate="collapsed" desc="comment">
        switch (roll2) {
          case 2:
          case 3:
          case 11: {
            result = "R";
            break;
          }
          case 4:
          case 7:
          case 10: {
            result = "D";
            break;
          }
          case 5:
          case 6:
          case 8:
          case 9: {
            result = "C";
            break;
          }
          case 12: {
            result = "A";
            break;
          }
        }
        //</editor-fold>
      } else if (txt.startsWith("M")) {
        //<editor-fold defaultstate="collapsed" desc="comment">
        switch (roll2) {
          case 3:
          case 11: {
            result = "R";
            break;
          }
          case 2:
          case 4:
          case 10: {
            result = "D";
            break;
          }
          case 5:
          case 6:
          case 7:
          case 8:
          case 9: {
            result = "C";
            break;
          }
          case 12: {
            result = "A";
            break;
          }
        }
        //</editor-fold>
      } else if (txt.startsWith("C")) {
        //<editor-fold defaultstate="collapsed" desc="comment">
        switch (roll2) {
          case 11: {
            result = "R";
            break;
          }
          case 2:
          case 3: {
            result = "D";
            break;
          }
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          case 10: {
            result = "C";
            break;
          }
          case 12: {
            result = "A";
            break;
          }
        }
        //</editor-fold>
      } else if (txt.startsWith("R")) {
        //<editor-fold defaultstate="collapsed" desc="comment">
        switch (roll2) {
          case 11: {
            result = "R";
            break;
          }
          case 2: {
            result = "D";
            break;
          }
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          case 10: {
            result = "C";
            break;
          }
          case 12: {
            result = "A";
            break;
          }
        }
        //</editor-fold>
      }
      switch (result) {
        //<editor-fold defaultstate="collapsed" desc="comment">
        case "R": {
          result = potential[0];
          break;
        }
        case "D": {
          result = potential[2];
          break;
        }
        case "C": {
          result = potential[1];
          break;
        }
        case "A": {
          result = potential[3];
          break;
        }
        default: {
//          jTextArea1.setText("ERROR in potential");
          //System.out.print("result" + " = " + result);
        }
        //</editor-fold>
      }
      jTextArea1.append(result + CRLF);
      pot = result;
      jButton1.setEnabled(false);
      jButton3.setEnabled(true);
    } else {
      jTextArea1.append("NOTHING" + CRLF);
      pot = "Nothing";
      jButton1.setEnabled(true);
      jButton3.setEnabled(false);
    }
    getTime();
    AddTime(1);
  }

  //Find out what it is made of
  private void Step_2_Composition() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    step = 2;
    in = true;
    String comp = "";
    int roll = (int) (Math.random() * 6) + 1;
    roll += (int) (Math.random() * 6) + 1;
    switch (jComboBox9.getSelectedItem().toString()) {//N-Zone, M-Zone, C-Zone/Trojans, Rings
      case "N-Zone": {
        //<editor-fold defaultstate="collapsed" desc="comment">
        switch (roll) {//composition(c,n,i)
          case 2:
          case 3: {
            comp = composition[0];
            break;
          }
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          case 10:
          case 11: {
            comp = composition[1];
            break;
          }
          case 12: {
            comp = composition[2];
            break;
          }
        }
        //</editor-fold>
        break;
      }
      case "M-Zone": {
        //<editor-fold defaultstate="collapsed" desc="comment">
        switch (roll) {//composition(c,n,i)
          case 2:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9: {
            comp = composition[0];
            break;
          }
          case 3:
          case 11:
          case 12: {
            comp = composition[1];
            break;
          }
          case 4:
          case 10: {
            comp = composition[2];
            break;
          }
        }
        //</editor-fold>
        break;
      }
      case "C-Zone":
      case "Trojans": {
        //<editor-fold defaultstate="collapsed" desc="comment">
        switch (roll) {//composition(c,n,i)
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          case 10: {
            comp = composition[0];
            break;
          }
          case 2:
          case 12: {
            comp = composition[1];
            break;
          }
          case 3:
          case 11: {
            comp = composition[2];
            break;
          }
        }
        //</editor-fold>
        break;
      }
      case "Rings": {
        //<editor-fold defaultstate="collapsed" desc="comment">
        switch (roll) {//composition(c,n,i)
          case 2:
          case 3:
          case 4: {
            comp = composition[0];
            break;
          }
          case 11:
          case 12: {
            comp = composition[1];
            break;
          }
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          case 10: {
            comp = composition[2];
            break;
          }
        }
        //</editor-fold>
        break;
      }
      default: {
        //System.out.print("ERROR");
      }
      AddTime(1);
    }
    jTextArea1.append(comp + CRLF);
    com = comp;
  }

  //Find out how big it is
  private void Step_3_ASize() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    step = 3;
    in = true;
    siz = (int) (Math.random() * 6) + 1;
    siz += (int) (Math.random() * 6) + 1;
    if (siz > 12) {
      siz = 12;
    }
    //jTextArea1.append("  SIZE" + CRLF);// + "  " + size[siz - 2] + CRLF);
    switch (siz) {
      //<editor-fold defaultstate="collapsed" desc="comment">
      case 2: {
        r = 2;
        break;
      }
      case 3: {
        r = 5;
        break;
      }
      case 4: {
        r = 10;
        break;
      }
      case 5: {
        r = 25;
        break;
      }
      case 6: {
        zeroes = 1;
        r = 50;
        break;
      }
      case 7: {
        zeroes = 1;
        r = 110;
        break;
      }

      case 8: {
        r = (getRoll(2)) * 100;
        zeroes = 2;
        break;
      }
      case 9: {
        r = (getRoll(2) + 1) * 100;
        zeroes = 2;
        break;
      }
      case 10: {
        r = (getRoll(2) + 2) * 100;
        zeroes = 2;
        break;
      }
      case 11: {
        r = (getRoll(2) - 1) * 1000;
        zeroes = 3;
        break;
      }
      case 12: {
        int num = getRoll(1);
        if (num == 1) {
          num += getRoll(1);
        }
        r = num * 1000;
        zeroes = 3;
        break;
      }
      default: {
        jTextArea1.append("ERROR in ASize()" + CRLF);
        jTextArea1.append("siz = " + siz);
      }
      //</editor-fold>
    }
    jTextArea1.append("Asteroid = " + r + "m" + CRLF);
    dt = (int) dbviewer.globals.GetRadiusAndVolume.getVolume((int) r);
    jTextArea1.append("" + " = " + nf.format(dt) + "dtons" + CRLF);
    //jTextArea1.append("" + " = " + nf.format((int) globals.GetRadiusAndVolume.getRadius((int) dt)) + "m(min)" + CRLF);
  }

  //Find out what is inside
  private void Step_4_Deposit() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    if (!"nothing".equals(pot.toLowerCase())) {
      step = 4;
      in = true;
      int roll = getRoll(1);
      dep = siz - roll;
      if (dep < 1) {
        dep = 1;
      }
      if (dep > 7) {
        dep = 7;
      }
      try {
        min = Integer.parseInt(size[dep - 2]);
      } catch (java.lang.ArrayIndexOutOfBoundsException nfe) {
        min = 1;
      }
      max = min * 10;
      time = WatchesRequired[siz - 2];
      AddTime(1);
    }
    volume = (int) dbviewer.globals.GetRadiusAndVolume.getVolume(r);
    jTextArea1.append(" volume = " + nf.format(volume) + " dtons" + CRLF);
  }

  private void Step_5_Presence() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    step = 5;
    in = false;
    int num = 0;
    //System.out.print("pot" + " = " + pot);
    //System.out.print("com" + " = " + com);
    switch (pot.toString().substring(0, 1)) {
      case "R":
        //<editor-fold defaultstate="collapsed" desc="comment">
        switch (com.toString().substring(0, 1)) {
          case "N": {
            num = 11;
            break;
          }
          case "C": {
            num = 12;
            break;
          }
          case "I": {
            num = 13;
            break;
          }
          default: {
            //System.out.print("ERROR");
            break;
          }
        }
      //</editor-fold>
      case "C":
        //<editor-fold defaultstate="collapsed" desc="comment">
        switch (com.toString().substring(0, 1)) {
          case "N": {
            num = 10;
            break;
          }
          case "C": {
            num = 8;
            break;
          }
          case "I": {
            num = 9;
            break;
          }
          default: {
            //System.out.print("ERROR");
            break;
          }
        }
      //</editor-fold>
      case "D":
        //<editor-fold defaultstate="collapsed" desc="comment">
        switch (com.toString().substring(0, 1)) {
          case "N": {
            num = 9;
            break;
          }
          case "C": {
            num = 12;
            break;
          }
          case "I": {
            num = 13;
            break;
          }
          default: {
            //System.out.print("ERROR");
            break;
          }
        }
      //</editor-fold>
      case "A":
        //<editor-fold defaultstate="collapsed" desc="comment">
        switch (com.toString().substring(0, 1)) {
          case "N": {
            num = 10;
            break;
          }
          case "C": {
            num = 10;
            break;
          }
          case "I": {
            num = 11;
            break;
          }
          default: {
            //System.out.print("ERROR");
            break;
          }
        }
      //</editor-fold>
    }
    int roll = getRoll(2);
//    roll = 12;
    if (roll >= num) {
      jTextArea1.append("" + getYield() + CRLF);
      jTextArea1.append("" + getValue());
      jButton1.setEnabled(true);
      jButton3.setEnabled(false);
    } else {
      jTextArea1.append("NO YIELD" + CRLF);
      jButton1.setEnabled(true);
      jButton3.setEnabled(false);
    }
  }

  private void EventLocation() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    int roll = (int) (Math.random() * 6) + 1;
    roll += (int) (Math.random() * 6) + 1;
    if (roll < 6) {
      in = true;
    } else {
      in = false;
    }
  }

  private void Events() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    //System.out.print("in" + " = " + in);
    int roll = (int) (Math.random() * 6) + 1;
    roll += (int) (Math.random() * 6) + 1;
    String loc;
    loc = "";
    if (in == true) {
      //<editor-fold defaultstate="collapsed" desc="comment">
      switch (roll) {
        case 2: {
          loc = inside[0];
          break;
        }
        case 3:
        case 11: {
          loc = inside[1];
          break;
        }
        case 4:
        case 10: {
          loc = inside[2];
          break;
        }
        case 5:
        case 9: {
          loc = inside[3];
          break;
        }
        case 6:
        case 8: {
          loc = inside[4];
          break;
        }
        case 7: {
          loc = inside[5];
          break;
        }
        case 12: {
          loc = inside[6];
          break;
        }
      }
      //</editor-fold>
    } else {
      //<editor-fold defaultstate="collapsed" desc="comment">
      switch (roll) {
        case 2: {
          loc = outside[0];
          break;
        }
        case 3:
        case 11: {
          loc = outside[1];
          this.setBackground(Color.LIGHT_GRAY);
          jTextArea1.setEditable(false);
          jButton5.doClick();
          JOptionPane.showMessageDialog(jTextArea1, "DEATH ?");
          break;
        }
        case 4:
        case 10: {
          loc = outside[2];
          break;
        }
        case 5:
        case 6: {
          loc = outside[3];
          break;
        }
        case 8:
        case 9: {
          loc = outside[5];
          break;
        }
        case 7: {
          loc = outside[4];
          break;
        }
        case 12: {
          loc = outside[6];
          break;
        }
      }
      //</editor-fold>
    }
    jTextArea1.append(loc + CRLF);
  }

  private void AddTime(int i) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    Watch += i;
    jLabel2.setText("" + Watch);
    //jTextArea1.append(getTime());
    //DoEvents(i);
  }

  private void DoEvents(int i) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    for (int x = 0; x < i; x++) {
      jTextArea1.append("" + getTime());
      EventRoll();
      setTime();
    }
  }

  private String getTime() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    return ("   WATCH " + Watch + CRLF);
  }

  private void setTime() {
//<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    jLabel2.setText("" + Watch);
  }

  private String getYield() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    int roll = getRoll(2);
    switch (roll) {
      case 2: {
        yield = getRoll(1);
        break;
      }
      case 3: {
        yield = getRoll(2);
        break;
      }
      case 4: {
        yield = getRoll(3);
        break;
      }
      case 5:
      case 6:
      case 7:
      case 8: {
        yield = getRoll(4);
        break;
      }
      case 9: {
        yield = 10 + getRoll(6);
        break;
      }
      case 10: {
        yield = 20 + getRoll(6);
        break;
      }
      case 11: {
        yield = 30 + getRoll(6);
        break;
      }
      case 12: {
        yield = 60 + getRoll(6);
        break;
      }
    }
//--------------------------------------------------
    double num;
//    if (roll > 7) {
//      num = globals.GetRadiusAndVolume.getVolume(r) / 100 * yield;
//    }
    try {
      num = Integer.parseInt(size[siz - 2]) * yield / 100;
      num = dt;
    } catch (java.lang.NumberFormatException e) {
      num = 10000000 / 100 * yield;
    }
    //System.out.print("r" + " = " + r);
    //num = getVolume(r) * (yield / 100);
    return ("" + yield + "% = " + nf.format((dt * yield) / 100) + " dtons");
  }

  private int getRoll(int i) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    int roll = 0;
    for (int a = 0; a < i; a++) {
      roll += (int) (Math.random() * 6) + 1;
    }
    return roll;
  }

  private String getValue() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //System.out.print("r" + " = " + r);
      //System.out.print("cv" + " = " + cv);
      //System.out.print("pot" + " = " + pot);
      //System.out.print("com" + " = " + com);
    }
    COST = 1;
//</editor-fold>
    COST = 0;
    switch (com) {//"Carbonaceous", "Nickel-Iron", "Ice"
      //<editor-fold defaultstate="collapsed" desc="comment">
      case "Carbonaceous": {
        COST = 40;
        break;
      }
      case "Nickel-Iron": {
        COST = 1000;
      }
      case "Nickel-Iron planetoid": {
        COST = 400;
        break;
      }
      case "Ice": {
        COST = 75;
        break;
      }
      //</editor-fold>
    }
    switch (pot) {//"Radioactives", "Crystals", "Dense Metals", "Exotics"
      //<editor-fold defaultstate="collapsed" desc="comment">
      case "Radioactives": {
        COST = 1000000;
        break;
      }
      case "Crystals": {
        COST = 20000;
        break;
      }
      case "Dense Metals": {
        COST = 50000;
        break;
      }
      case "Exotics": {
        COST = 500000;
        break;
      }
//      case "Nothing": {
//        COST = 0;
//        break;
//      }
      default: {
        //System.out.print("" + " Error in getValue()");
        //System.out.print("pot" + " = " + pot);
      }
      //</editor-fold>
    }
    double val = (((dt / 1000) * (COST / 1000)) * (yield / 100));
    double money = Double.parseDouble(jLabel13.getText());
    money += val;
    jLabel13.setText("" + nf.format(money));
    return "WORTH MCr" + nf.format(val) + CRLF;
  }

  private void sellFind() {
    find = (dt * yield) / 100;
    jTextArea1.append("" + "" + nf.format(find) + " dtons of " + pot
      + " in " + nf.format(dt) + " dtons of " + com
      + " asteroid" + CRLF);
    value = 0;
    int num = 0;
    switch (pot) {//"Radioactives", "Crystals", "Dense Metals", "Exotics"
      //<editor-fold defaultstate="collapsed" desc="comment">
      case "Radioactives": {
        num = 2;
        break;
      }
      case "Crystals": {
        num = 0;
        break;
      }
      case "Dense Metals": {
        num = 1;
        break;
      }
      case "Exotics": {
        num = 8;
        break;
      }
      default: {
        JOptionPane.showMessageDialog(jTextArea1, "OOPS");
        num = 8;
      }
      //</editor-fold>
    }
    value = Integer.parseInt(products[num][1].toString());
    double gain = (dt * (yield / 100) * (value / 1000000)) / 10;
    banked += gain;
    jTextArea1.append(" @ Cr" + value + " per dton = MCr" + nf.format(gain)
      + CRLF);
    jLabel15.setText("" + nf.format(banked));
    if ((dt - ((dt * yield) / 100) > 10000)
      & ("A".equals(Starport.getText()) | "B".equals(Starport.getText()))
      & (dt < 1000000)) {
      switch (com) {
        //<editor-fold defaultstate="collapsed" desc="comment">
        case "Nickel-Iron": {
          jTextArea1.append("    METAL ASTEROID WORTH @ STARPORT = MCr");
          value = 0.0004;
          double num1 = (dt * value);
          jTextArea1.append("" + nf.format(num1) + CRLF);
          break;
        }
        case "Carbonaceous": {
          value = 0.000075;
          break;
        }
        case "Ice": {
          value = 0.00075;
          double num1 = (dt * value);
          jTextArea1.append("" + nf.format(num1) + CRLF);
          break;
        }
        //</editor-fold>
      }
    }
    showValues();
  }

  private void auctionFind() {
    jTextArea1.append("dt" + " = " + nf.format((dt * yield) / 100) + " dtons"
      + CRLF);
  }

  private void mineFind() {
    jTextArea1.append("dt" + " = " + nf.format((dt * yield) / 100) + " dtons"
      + CRLF);
  }

  private void showValues() {
    find = ((dt * yield) / 100);
    jTextArea1.append("" + CRLF);
    jTextArea1.append("dt" + " = " + nf.format(dt) + CRLF);
    jTextArea1.append("find" + " = " + nf.format(find) + CRLF);
    jTextArea1.append("cost" + " = " + nf.format(COST) + CRLF);
    jTextArea1.append("value" + " = " + nf.format(value) + CRLF);
  }
}
