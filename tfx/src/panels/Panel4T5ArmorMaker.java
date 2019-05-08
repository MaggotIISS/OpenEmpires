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

import static dbviewer.globals.GlobalVariables.CRLF;
import static dbviewer.globals.GlobalVariables.TAB;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 <p>
 @author Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4T5ArmorMaker extends javax.swing.JPanel {

//<editor-fold defaultstate="collapsed" desc="variables">
//<editor-fold defaultstate="collapsed" desc="stage">
  static final String[] stage = {
    "3",
    "STAGE", "CODE", "TL",
    "Experimental", "X", "-2",
    "Prototype", "P", "-1",
    "Early", "E", "-1",
    "Basic", "B", "0",
    "(blank)", "", "0",
    "Standard", "St", "1",
    "Improved", "Im", "1",
    "Modified", "Mod", "2",
    "Advanced", "A", "3",
    "Obsolete", "Ob", "4",
    "Alternate", "Alt", "1"
  };
//</editor-fold>
  String Stage = "";
//<editor-fold defaultstate="collapsed" desc="burden">
  static final String[] burden = {
    "3",
    "BURDEN", "CODE", "TL",
    "VLight", "Vl", "1",
    "Light", "Lt", "0",
    "(blank)", "", "0",
    "Medium", "M", "0",
    "Heavy", "H", "1",
    "Disposable", "D", "3",
    "Oversize", "OS", "1",
    "Titan", "T", "3"
  };
//</editor-fold>
  String Burden = "";
//<editor-fold defaultstate="collapsed" desc="type">
  static final String[] type = {
    "3",
    "TYPE", "CODE", "TL",
    "Armor", "A", "8",
    "Dress", "D", "10",
    "Suit", "S", "5",
    "Unit", "U", "9"
  };
//</editor-fold>
  String Type = "";
//<editor-fold defaultstate="collapsed" desc="user">
  static final String[] user = {
    "3",
    "USER", "CODE", "MANIPULATOR",
    "(blank)", "", "",
    "Man", "M", "Hand",
    "Vargr", "V", "",
    "Aslan", "A", "Paw",
    "K`kree", "K", "",
    "Hiver", "H", "Grasper",
    "Droyne", "D", "",
    "", "G", "Gripper",
    "Vegan", "V", "Tentacle",
    "", "S", "Socket",
    "", "U", "Universal"
  };
//</editor-fold>
  String User = "";
//<editor-fold defaultstate="collapsed" desc="armortypes">
  static final String[] armortypes = {
    "3",
    "ARMOR TYPE", "CODE", "TL",
    "Assault", "A", "4",
    "Battle", "B", "3",
    "Combat", "C", "3",
    "Drop", "Dr", "2",
    "Boarding", "Bd", "3",
    "Police", "P", "0",
    "Protected", "Pr", "2",
    "Hostile Environ", "He", "1",
    "Hazmat", "Hz", "0",
    "Environ", "E", "2",
    "Vacc", "V", "4",
    "Hot", "H", "1",
    "Cold", "C", "2",
    "Exploration", "Ex", "1",
    "Prospector", "Pr", "2",
    "Labor", "L", "-1",
    "Wpn Carrier", "C", "1",
    "Sapper", "S", "2"
  };
//</editor-fold>
  String ArmorType = "";
////<editor-fold defaultstate="collapsed" desc="dress">
//  private final static String[] dress = {
//    "1",
//    "DRESS",
//    "A",
//    "B",
//    "C",
//    "Dr",
//    "Bd",
//    "P",};
////</editor-fold>
//  String Dress = "";
////<editor-fold defaultstate="collapsed" desc="armor">
//  private final static String[] armor = {
//    "1",
//    "ARMOR",
//    "A",
//    "B",
//    "C",
//    "Dr",
//    "Bd",
//    "P",
//    "Pr",
//    "He",
//    "Hz",
//    "S"
//  };
////</editor-fold>
//  String Armor = "";
////<editor-fold defaultstate="collapsed" desc="suit">
//  private final static String[] suit = {
//    "1",
//    "SUIT",
//    "A",
//    "B",
//    "C",
//    "Dr",
//    "Bd",
//    "P",
//    "Pr",
//    "He",
//    "Hz",
//    "S",
//    "E",
//    "V",
//    "H",
//    "C",
//    "Ex",
//    "Pr",
//    "L",
//    "S"
//  };
////</editor-fold>
//  String Suit = "";
////<editor-fold defaultstate="collapsed" desc="unit">
//  private final static String[] unit = {
//    "1",
//    "UNIT",
//    "A",
//    "B",
//    "C",
//    "Dr",
//    "Bd",
//    "P",
//    "Pr",
//    "He",
//    "Hz",
//    "S",
//    "E",
//    "V",
//    "H",
//    "C",
//    "Ex",
//    "Pr",
//    "L",
//    "C",
//    "S"
//  };
////</editor-fold>
//  String Unit = "";
//<editor-fold defaultstate="collapsed" desc="body">
  static final String[] body = {
    "14",
    "CODE", "BODY", "TL", "MASS", "AR", "CA", "FL", "RA", "SO", "PS", "IN", "SE",
    "Comment", "Cr",
    "J", "Jack", "1", "1", "1", "5", "0", "0", "0", "0", "0", "4", "-", "50",
    "Ma", "Mail", "4", "3", "2", "6", "0", "0", "0", "0", "0", "0", "-", "400",
    "M", "Mesh", "7", "2", "1", "10", "0", "0", "0", "0", "0", "2", "-", "150",
    "K", "Cloth", "8", "2", "1", "14", "0", "0", "0", "0", "0", "6", "-", "250",
    "Q", "Quilt", "9", "1", "1", "18", "0", "0", "0", "0", "0", "9", "-", "600",
    "P", "Plate", "6", "4", "1", "22", "0", "0", "0", "0", "0", "0", "B=+2",
    "900",
    "A", "Ablat", "9", "2", "3", "12", "0", "0", "0", "0", "0", "8",
    "B=+3 2x vs K*", "375",
    "R", "Reflec", "10", "1", "0", "0", "0", "0", "0", "0", "0", "0",
    "Deflects laser", "10",
    "C", "Coat", "1", "1", "2", "0", "0", "0", "0", "0", "0", "5", "-", "100",
    "hC", "Heavy Coat", "2", "2", "3", "0", "0", "0", "0", "0", "0", "10", "-",
    "200",
    "Sh", "Shield", "2", "3", "3", "12", "0", "0", "0", "0", "0", "0", "-",
    "100",
    "aSh", "Adv Shield", "8", "2", "2", "14", "0", "8", "0", "0", "0", "0", "-",
    "400"
  };
//</editor-fold>
  String Body = "";
//<editor-fold defaultstate="collapsed" desc="item">
  static final String[] item = {
    "14",
    "CODE", "TYPE", "TL", "MASS", "AR", "CA", "FL", "RA", "SO", "PS", "IN", "SE",
    "Comment", "Cr",
    "A", "Armor", "8", "30", "7", "3", "3", "3", "3", "1", "3", "3", "", "20000",
    "D", "Dress", "10", "40", "9", "6", "6", "6", "6", "1", "6", "6", "",
    "40000",
    "S", "Suit", "5", "10", "2", "1", "1", "1", "1", "1", "1", "1", "", "1000",
    "U", "Unit", "9", "200", "4", "2", "2", "2", "2", "1", "2", "2", "", "60000"
  };
//</editor-fold>
  String Item = "";
//<editor-fold defaultstate="collapsed" desc="descriptor">
  static final String[] descriptor = {
    "14",
    "CODE", "TYPE", "TL", "MASS", "AR", "CA", "FL", "RA", "SO", "PS", "IN", "SE",
    "Comment", "Cr",
    "A", "Armor", "8", "30", "7", "3", "3", "3", "3", "1", "3", "3", "", "20000",
    "D", "Dress", "10", "40", "9", "6", "6", "6", "6", "1", "6", "6", "",
    "40000",
    "S", "Suit", "5", "10", "2", "1", "1", "1", "1", "1", "1", "1", "", "1000",
    "U", "Unit", "9", "200", "4", "2", "2", "2", "2", "1", "2", "2", "", "60000"
  };
//</editor-fold>
  String Descriptor = "";

  String[][] parts = {stage, burden, type, user, armortypes, body, item,
    descriptor};
  static JPanel jp;
  static JFrame jf;
  JPanel jp1;
  JFrame jf1;
  int i;
//  DefaultListModel<String> dlm = new DefaultListModel<>();
  JList jl = new JList();
  private static final MouseEvent evt = null;
  static String[] sa = null;
//</editor-fold>

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4T5ArmorMaker();
    jf = new Frame4(jp, "Panel4T5ArmorMaker");
  }

  /**
   Creates new form Panel4T5ArmorMaker
   */
  public Panel4T5ArmorMaker() {
    initComponents();
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jScrollPane3 = new javax.swing.JScrollPane();
    jList2 = new javax.swing.JList();

    jList1.setModel(new javax.swing.AbstractListModel() {
      String[] strings = { "Quick Create", "Fill Form", "Armor 1", "Armor 2", "Options", "Random", "Use", "Show" };
      public int getSize() { return strings.length; }
      public Object getElementAt(int i) { return strings[i]; }
    });
    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList1MouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jList1);

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextArea1MouseClicked(evt);
      }
    });
    jScrollPane2.setViewportView(jTextArea1);

    jList2.setModel(new javax.swing.AbstractListModel() {
      String[] strings = { "stage", "burden", "type", "armortypes", "body", "user", "item", "descriptor" };
      public int getSize() { return strings.length; }
      public Object getElementAt(int i) { return strings[i]; }
    });
    jList2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList2MouseClicked(evt);
      }
    });
    jScrollPane3.setViewportView(jList2);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
      .addComponent(jScrollPane2)
      .addComponent(jScrollPane3)
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
    partClick();
  }//GEN-LAST:event_jList1MouseClicked

  private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
    varClick();
  }//GEN-LAST:event_jList2MouseClicked

  private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
    clear(evt);
  }//GEN-LAST:event_jTextArea1MouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JList jList1;
  private javax.swing.JList jList2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTextArea jTextArea1;
  // End of variables declaration//GEN-END:variables

  private void partClick() {
    jTextArea1.append(jList1.getSelectedValue().toString().toUpperCase() + CRLF);
    switch (jList1.getSelectedValue().toString()) {
      case "Quick Create": {
        quickCreate();
        break;
      }
      case "Fill Form": {
        fillForm();
        break;
      }
      case "Armor 1": {
        armor1();
        break;
      }
      case "Armor 2": {
        armor2();
        break;
      }
      case "Options": {
        options();
        break;
      }
      case "Random": {
        random();
        break;
      }
      case "Use": {
        use();
        break;
      }
      case "Show": {
        showArmor();
        break;
      }
      default: {
        System.out.println("OOPs");
      }
    }
  }

  private int col = 0;  //first

  @SuppressWarnings("unchecked")
  private void varClick() {
    final String in = jList2.getSelectedValue().toString();
//<editor-fold defaultstate="collapsed" desc="switch (in) {">
    switch (in) {
      case "stage": {
        sa = stage;
        col = 0;
        break;
      }
      case "burden": {
        sa = burden;
        col = 0;
        break;
      }
      case "type": {
        sa = type;
        col = 0;
        break;
      }
      case "user": {
        sa = user;
        col = 0;
        break;
      }
      case "armortypes": {
        sa = armortypes;
        col = 0;
        break;
      }
//      case "dress": {
//        sa = dress;
//        col = 0;
//        break;
//      }
//      case "armor": {
//        sa = armor;
//        col = 0;
//        break;
//      }
//      case "suit": {
//        sa = suit;
//        col = 0;
//        break;
//      }
//      case "unit": {
//        sa = unit;
//        col = 0;
//        break;
//      }
      case "body": {
        sa = body;
        col = 1;
        break;
      }
      case "item": {
        sa = item;
        col = 0;
        break;
      }
      case "descriptor": {
        sa = descriptor;
        col = 0;
        break;
      }

      default: {
        // yet
        System.out.println("NOT in varClick()" + " = " + in);
        break;
      }
    }
//</editor-fold>
//    jTextArea1.append("");
//    GlobalMethods.showTable(jTextArea1, in.toUpperCase(), sa);
//    jTextArea1.append(CRLF);
    jp1 = new Panel4(in.toUpperCase());
    String[] ss = null;
    int cols = Integer.parseInt(sa[0]);
    int count = 0;
    ss = new String[(sa.length) / cols];
    for (int j = col + cols + 1; j < sa.length; j += cols) {
      ss[count] = sa[j];
      count += 1;
    }
    jl = new JList(ss);
    jl.addListSelectionListener(new ListSelectionListener() {

      @Override
      public void valueChanged(ListSelectionEvent lse) {
        if (lse.getValueIsAdjusting() == false) {
          String s = jl.getSelectedValue().toString();
          jTextArea1.append(showLineContaining(s) + CRLF);
          jf1.setVisible(false);
        }
      }
    });
    JScrollPane jsp = new JScrollPane(jl);
    jp1.add(jsp);
    jf1 = new Frame4(jp1);

  }

  /**
   <p>
   @param s The variable sought
   @return Line containing variable
   */
  private String showLineContaining(String s) {
    String line = "";
    int num = Integer.parseInt(sa[0]);
    int linenum = 0;
    int j = 0;
    for (int k = 1; k <= num; k++) {
      line += sa[k] + TAB;
    }
    line += CRLF;
    for (int i = num; i < sa.length; i++) {
      if (sa[i].equals(s)) {
        int idx = i;
        linenum = idx / num + 1;
        for (j = idx; j <= (linenum * num); j++) {
          line += sa[j] + TAB;
        }
        line += CRLF;
      }
    }
    line = TAB + jList2.getSelectedValue().toString().toUpperCase() + CRLF
      + line;
    return line;
  }

  private void clear(MouseEvent evt) {
    if (evt.getClickCount() > 1) {
      jTextArea1.setText("");
    }
  }

  private void quickCreate() {
    jList2.setSelectedIndex(0);
    jList2MouseClicked(evt);
  }

  private void fillForm() {
  }

  private void armor1() {
  }

  private void armor2() {
  }

  private void options() {
  }

  private void random() {
  }

  private void use() {
  }

  private void showArmor() {

  }

}
