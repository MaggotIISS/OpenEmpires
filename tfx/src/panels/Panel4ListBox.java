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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 <p>
 @author maggot
 */
public class Panel4ListBox extends Panel4 {

  String string;
  static DefaultListModel dlm = new DefaultListModel();
  static JPanel jp;
  static JFrame jf;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4ListBox();
    jf = new Frame4(jp);
  }

  /**
   Creates new form Panel4ListBox
   */
  public Panel4ListBox() {
    initComponents();
//    int j = jf.getJMenuBar().getComponentCount();
//    System.out.println("" + " = " +jf.getJMenuBar().get);
//    Component c;
//    for (int i = 0; i < j; i++) {
//      c = jf.getJMenuBar().getComponent(i);
//      System.out.print("c.toString()" + " = " + c.toString());
//    }
  }

  ActionListener saveAction = new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
      String[] strings = new String[jList1.getModel().getSize() + 1];
      strings[0] = jLabel1.getText();
      for (int i = 1; i < dlm.getSize(); i++) {
        strings[i] = dlm.getElementAt(i - 1).toString();
      }
    }

  };

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
    jLabel1 = new javax.swing.JLabel();

    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList1MouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jList1);

    jLabel1.setForeground(java.awt.Color.green);
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Add");
    jLabel1.setToolTipText("click to addElement()");
    jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
      .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  @SuppressWarnings("unchecked")
  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    if (jLabel1.getText() == "Add") {
      string = JOptionPane.showInputDialog(jScrollPane1, "Add Entry");
      if (!"".equals(string)) {
        dlm.addElement(string);
        jList1.setModel(dlm);
      }
    }
  }//GEN-LAST:event_jLabel1MouseClicked

  private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
    try {
      if (evt.getClickCount() == 2) {
        dlm.remove(jList1.getSelectedIndex());
      }
      listClick(evt);
    } catch (Exception e) {
      System.out.println("Exception e " + " = " + e + e.toString());
    }
  }//GEN-LAST:event_jList1MouseClicked
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  public static javax.swing.JList jList1;
  private javax.swing.JScrollPane jScrollPane1;
  // End of variables declaration//GEN-END:variables

  /**
   <p>
   @param title for jLabel1 and name of jList1
   @param lines to setList
   */
  @SuppressWarnings("unchecked")
  public void setList(String title, String[] lines) {
    jLabel1.setText(title);
    jList1.setName(title);
    int size = jList1.getModel().getSize();
    dlm = new DefaultListModel();
    for (int i = 0; i < size; i++) {
      dlm.addElement(lines[i]);
    }
    jList1.setModel(dlm);

  }

  /**
   <p>
   @return JList
   */
  public JList getList() {
    return jList1;
  }

  /**
   <p>
   @param item to add to jList1
   */
  @SuppressWarnings("unchecked")
  public static void addItem(String item) {
    dlm.addElement(item);
    jList1.setModel(dlm);
  }

  private void listClick(MouseEvent evt) {
    String word = jList1.getSelectedValue().toString();
  }

}
