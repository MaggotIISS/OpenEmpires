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

import static dbviewer.globals.GlobalMethods.comment;
import static dbviewer.globals.GlobalMethods.loadTextFile;
import static dbviewer.globals.GlobalVariables.CRLF;
import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables.T5;
import static dbviewer.globals.GlobalVariables.TAB;
import static dbviewer.globals.GlobalVariables._SEC;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 <p>
 @author Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4ComboButtonListAreas extends Panel4 {

  private static String sec = "", sub = "", sys = "";
  private static File f;
  private MouseEvent me;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    JPanel jp = new Panel4ComboButtonListAreas();
    JFrame jf = new Frame4(jp, "Panel4ComboButtonListAreas");
  }

  /**
   Creates new form Panel4T5DBConvert
   */
  @SuppressWarnings("unchecked")
  public Panel4ComboButtonListAreas() {
    initComponents();
    f = new File(_SEC);
    String[] files = f.list();
    System.out.println("" + " = " + f.list());
    for (String file : files) {
      if (file.endsWith(".sec")) {
        jComboBox1.addItem(file);
      }
    }
    jComboBox1.setSelectedIndex(0);
    loadFile();
  }

  private void clear(MouseEvent evt, int i) {
    if (evt.getClickCount() > 2) {
      JTextArea j;
      switch (i) {
        case 1: {
          j = jTextArea1;
          break;
        }
        case 2: {
          j = jTextArea2;
          break;
        }
        case 3: {
          j = jTextArea3;
          break;
        }
        case 4: {
          j = jTextArea4;
          break;
        }
        default: {
          j = null;
          break;
        }
      }
      j.setText("");
    }
  }

  private void loadFile() {
    jTextArea1.append(comment("-", 20));
    f = new File(T5 + FS + jComboBox1.getSelectedItem().toString() + ".sec");
    jTextArea1.append(loadTextFile(f.toString()));
//    jTextArea1.append(comment("-", 20));
  }

  private void buttonClick() {
    if (jCheckBox1.isSelected()) {
      for (int i = 0; i < jComboBox1.getModel().getSize(); i++) {
        jComboBox1.setSelectedIndex(i);
        for (int j = 0; j < jList1.getModel().getSize(); j++) {
          jList1.setSelectedIndex(j);
          jList1MouseClicked(me);
        }
      }
    } else {
      for (int i = 0; i < jList1.getModel().getSize(); i++) {
        jList1.setSelectedIndex(i);
        jList1MouseClicked(me);
      }
    }

  }

  private void listClick() {
    jTextArea1.append(TAB + jList1.getSelectedValue().toString().toUpperCase()
      + CRLF);
  }

  private void comboClick() {

  }

  private void boxClick() {
    if (jCheckBox1.isSelected()) {
      jButton1.setText("All");
    } else {
      jButton1.setText("Once");
    }
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jComboBox1 = new javax.swing.JComboBox();
    jButton1 = new javax.swing.JButton();
    jCheckBox1 = new javax.swing.JCheckBox();
    jScrollPane1 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTextArea2 = new javax.swing.JTextArea();
    jScrollPane4 = new javax.swing.JScrollPane();
    jTextArea3 = new javax.swing.JTextArea();
    jScrollPane5 = new javax.swing.JScrollPane();
    jTextArea4 = new javax.swing.JTextArea();

    setOpaque(false);

    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox1ActionPerformed(evt);
      }
    });

    jButton1.setText("One");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jCheckBox1.setToolTipText("All in ComboBox?");
    jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBox1ActionPerformed(evt);
      }
    });

    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList1MouseClicked(evt);
      }
    });
    jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        jList1ValueChanged(evt);
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

    jTextArea2.setColumns(20);
    jTextArea2.setRows(5);
    jTextArea2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextArea2MouseClicked(evt);
      }
    });
    jScrollPane3.setViewportView(jTextArea2);

    jTextArea3.setColumns(20);
    jTextArea3.setRows(5);
    jTextArea3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextArea3MouseClicked(evt);
      }
    });
    jScrollPane4.setViewportView(jTextArea3);

    jTextArea4.setColumns(20);
    jTextArea4.setRows(5);
    jTextArea4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextArea4MouseClicked(evt);
      }
    });
    jScrollPane5.setViewportView(jTextArea4);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jCheckBox1))
          .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2)
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane3)
          .addComponent(jScrollPane4)
          .addComponent(jScrollPane5))
        .addGap(0, 0, 0))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jButton1)
          .addComponent(jCheckBox1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1))
      .addGroup(layout.createSequentialGroup()
        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
      .addComponent(jScrollPane2)
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    comboClick();
  }//GEN-LAST:event_jComboBox1ActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    buttonClick();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
    listClick();
  }//GEN-LAST:event_jList1ValueChanged

  private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
    clear(evt, 1);
  }//GEN-LAST:event_jTextArea1MouseClicked

  private void jTextArea2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea2MouseClicked
    clear(evt, 2);
  }//GEN-LAST:event_jTextArea2MouseClicked

  private void jTextArea3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea3MouseClicked
    clear(evt, 3);
  }//GEN-LAST:event_jTextArea3MouseClicked

  private void jTextArea4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea4MouseClicked
    clear(evt, 4);
  }//GEN-LAST:event_jTextArea4MouseClicked

  private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
    boxClick();
  }//GEN-LAST:event_jCheckBox1ActionPerformed

  private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked

  }//GEN-LAST:event_jList1MouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JCheckBox jCheckBox1;
  private javax.swing.JComboBox jComboBox1;
  private javax.swing.JList jList1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JScrollPane jScrollPane5;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JTextArea jTextArea2;
  private javax.swing.JTextArea jTextArea3;
  private javax.swing.JTextArea jTextArea4;
  // End of variables declaration//GEN-END:variables
}
