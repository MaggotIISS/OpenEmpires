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
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 <p>
 @author maggot.iiss
 */
public class Panel4D66 extends Panel4 {

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    JPanel jp = new Panel4D66();
    JFrame jt = new Frame4(jp);
    jt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  //<editor-fold defaultstate="collapsed" desc="Variables">
  int x = 0, y = 0;
  /**
   result
   */
  public static String[][] result = {
    {"a", "b", "c", "d", "e", "f"},
    {"g", "h", "i", "j", "k", "l"},
    {"m", "n", "o", "p", "q", "r"},
    {"s", "t", "u", "v", "w", "x"},
    {"y", "z", "aa", "bb", "cc", "dd"},
    {"ee", "ff", "gg", "hh", "ii", "jj"}
  };
  /**
   desc
   */
  public static String[][] desc = {
    {"aa", "bb", "cc", "dd", "ee", "ff"},
    {"gg", "hh", "ii", "jj", "kk", "ll"},
    {"mm", "nn", "oo", "pp", "qq", "rr"},
    {"ss", "tt", "uu", "vv", "ww", "xx"},
    {"yy", "zz", "aaaa", "bbbb", "cccc", "dddd"},
    {"eeee", "ffff", "gggg", "hhhh", "iiii", "jjjj"}};
  private final String[][] res = null;
  private final String[][] des = null;
  //</editor-fold>

  /**
   Creates new form Panel4
   */
  public Panel4D66() {
    super();
    initComponents();
    jButton1.doClick();
    GlobalMethods.autoColor(this, Color.black, Color.LIGHT_GRAY);
  }

  /**
   <p>
   @param name setName()
   */
  public Panel4D66(String name) {
    this();
    setName(name);
    super.setName(name);
    //GlobalMethods.autoColor(jTable1, Color.black, Color.LIGHT_GRAY);
//    GlobalMethods.autoColor(jTextArea2, Color.black, Color.LIGHT_GRAY);
  }

  /**
   <p>
   @param name NOT USED
   @param res  result rolled
   */
  public Panel4D66(String name, String[][] res) {
    this();
    //setName(name);
    //super.setName(name);
    Panel4D66.result = res;
  }

  /**
   <p>
   @return name of class
   */
  @Override
  public String toString() {
    return "" + getClass().getName() + "[]";
  }

  /**
   <p>
   @param name NOT USED
   @param res  result rolled
   @param des  description obtained
   */
  public Panel4D66(String name, String[][] res, String[][] des) {
    this();
    //setName(name);
    //super.setName(name);
    Panel4D66.result = res;
    Panel4D66.desc = des;
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
    jTable1 = new javax.swing.JTable();
    jButton1 = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jCheckBox1 = new javax.swing.JCheckBox();
    jCheckBox2 = new javax.swing.JCheckBox();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTextArea2 = new javax.swing.JTextArea();

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {"1", "A", "B", "C", "D", "E", "F"},
        {"2", "G", "H", "I", "J", "K", "L"},
        {"3", "M", "N", "O", "P", "Q", "R"},
        {"4", "S", "T", "U", "V", "W", "X"},
        {"5", "Y", "Z", "AA", "BB", "CC", "DD"},
        {"6", "EE", "FF", "GG", "HH", "II", "JJ"}
      },
      new String [] {
        "1D6", "1", "2", "3", "4", "5", "6"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jTable1.setColumnSelectionAllowed(true);
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTable1MouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jTable1);
    jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

    jButton1.setText("ROLL");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel3.setText("Y");

    jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jLabel4.setText("X");

    jLabel6.setText("1");

    jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel5.setText("2");
    jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

    jLabel7.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel7.setText("ZZ");
    jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

    jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

    jTextArea1.setColumns(2);
    jTextArea1.setRows(2);
    jScrollPane2.setViewportView(jTextArea1);

    jCheckBox1.setText("+1X");
    jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jCheckBox1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
    jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jCheckBoxMouseClicked(evt);
      }
    });

    jCheckBox2.setText("+1Y");
    jCheckBox2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jCheckBox2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jCheckBoxMouseClicked(evt);
      }
    });

    jTextArea2.setColumns(20);
    jTextArea2.setRows(5);
    jTextArea2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        jTextArea2KeyPressed(evt);
      }
    });
    jScrollPane3.setViewportView(jTextArea2);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jCheckBox2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jCheckBox1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel6))
          .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane3)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jButton1)
            .addGap(2, 2, 2)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel3)
              .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel4)
              .addComponent(jLabel6))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel5)
              .addComponent(jLabel7)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(11, 11, 11))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jScrollPane3)
            .addContainerGap())))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    x = (int) (Math.random() * 6) + 1;
    if (jCheckBox1.isSelected()) {
      if (x < 6) {
        x += 1;
      }
    }
    y = (int) (Math.random() * 6) + 1;
    if (jCheckBox2.isSelected()) {
      if (y < 6) {
        y += 1;
      }
    }
    jLabel6.setText("" + x);
    jLabel5.setText("" + y);
    jLabel7.setText(getRolled(y - 1, x - 1).toUpperCase());
    String string = result[y - 1][x - 1].toUpperCase();
    jTextArea1.setText(string.toUpperCase());
    jTextArea2.setText(desc[y - 1][x - 1]);

  }//GEN-LAST:event_jButton1ActionPerformed

  private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    //System.out.print("evt" + " = " + evt);
  }//GEN-LAST:event_jTable1MouseClicked

  private void jCheckBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxMouseClicked
    jButton1.doClick();
  }//GEN-LAST:event_jCheckBoxMouseClicked

  private void jTextArea2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea2KeyPressed
    TextUpdate(jTextArea1.getText());
  }//GEN-LAST:event_jTextArea2KeyPressed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JCheckBox jCheckBox1;
  private javax.swing.JCheckBox jCheckBox2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JTable jTable1;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JTextArea jTextArea2;
  // End of variables declaration//GEN-END:variables

  private String getRolled(int x, int y) {
    String string = "";
    string = result[x][y];
    return string;
  }

  private String getDesc(int x, int y) {
    return desc[x][y];
  }

  private void TextUpdate(String text) {
    desc[y - 1][x - 1] = jTextArea2.getText();
    //System.out.print("desc[" + (x) + "], [" + (y) + "] = " + jTextArea2.getText());
  }
}