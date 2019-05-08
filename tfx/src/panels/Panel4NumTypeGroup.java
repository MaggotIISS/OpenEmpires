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

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 <p>
 @author Your Name Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4NumTypeGroup extends Panel4 {

  private static String CRLF = System.lineSeparator();
  private boolean Locked = false;
  static int num;
  static int types;
  static int groups;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    JPanel jp = new Panel4NumTypeGroup();
    JFrame jf = new Frame4(jp);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void Lock() {
    this.Locked = true;
  }

  private void unLock() {
    this.Locked = false;
  }

  /**
   Creates new form Panel4NumTypeGroup
   */
  public Panel4NumTypeGroup() {
    initComponents();
  }

  /**
   <p>
   @param s String to set JLabel1
   */
  public void setLabel(String s) {
    jLabel1.setText(s);
  }

  /**
   <p>
   @return text from label
   */
  public String getLabel() {
    return jLabel1.getText();
  }

  /**
   <p>
   @return values of string
   */
  public String getValues() {
    String strings = "";
    strings += getLabel() + CRLF;
    return strings;
  }

  /**
   <p>
   @param title  String of JLabel
   @param num    number of total
   @param types  number of types
   @param groups number of groups
   */
  public void setValues(String title, int num, int types, int groups) {
    this.jLabel1.setText(title.toUpperCase());
    this.Num.setValue(num);
    this.Types.setValue(types);
    this.Groups.setValue(groups);

  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    Num = new javax.swing.JSpinner();
    Types = new javax.swing.JSpinner();
    Groups = new javax.swing.JSpinner();

    setOpaque(false);

    jLabel1.setForeground(java.awt.Color.lightGray);
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel1.setLabelFor(Num);
    jLabel1.setText("NUMBER");
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    jLabel2.setForeground(java.awt.Color.lightGray);
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel2.setLabelFor(Types);
    jLabel2.setText("Types");

    jLabel3.setForeground(java.awt.Color.lightGray);
    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel3.setLabelFor(Groups);
    jLabel3.setText("Groups");

    Num.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(0), null, Integer.valueOf(1)));
    Num.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        NumStateChanged(evt);
      }
    });

    Types.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(1)));
    Types.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        TypesStateChanged(evt);
      }
    });

    Groups.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(1)));
    Groups.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        GroupsStateChanged(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, Short.MAX_VALUE)
            .addGap(1, 1, 1))
          .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(Num, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
          .addComponent(Types)
          .addComponent(Groups, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
        .addGap(9, 9, 9))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(2, 2, 2)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(Types, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(2, 2, 2)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(Groups, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void NumStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_NumStateChanged
    calc();
  }//GEN-LAST:event_NumStateChanged

  private void TypesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TypesStateChanged
    calc();
  }//GEN-LAST:event_TypesStateChanged

  private void GroupsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_GroupsStateChanged
    calc();
  }//GEN-LAST:event_GroupsStateChanged

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    String ret = "";
    if (evt.getClickCount() > 1) {
      ret = JOptionPane.showInputDialog(Num, "Enter value for string", jLabel1
        .getText());
      if (!ret.equals("")) {
        jLabel1.setText(ret.toUpperCase());
      }
    }
  }//GEN-LAST:event_jLabel1MouseClicked
  // Variables declaration - do not modify//GEN-BEGIN:variables
  static javax.swing.JSpinner Groups;
  static javax.swing.JSpinner Num;
  static javax.swing.JSpinner Types;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  // End of variables declaration//GEN-END:variables

  static void calc() {
    num = Integer.parseInt(Num.getValue().toString());
    types = Integer.parseInt(Types.getValue().toString());
    groups = Integer.parseInt(Groups.getValue().toString());

    if (types > num) {
      types = num;
    }
    if (groups > num) {
      groups = num;
    }

    if (types < 1 & num > 0) {
      types = 1;
      Types.setValue(types);
    }
    if (groups == 0 & num > 0) {
      groups = 1;
      Groups.setValue(groups);
    }

    Num.setValue(num);
    Types.setValue(types);
    Groups.setValue(groups);

  }
}
