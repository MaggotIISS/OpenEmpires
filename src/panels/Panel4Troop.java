/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package panels;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 <p>
 @author Mark Ferguson
 */
public class Panel4Troop extends Panel4 {

  private static int troop;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    if (args.length > 0) {
      troop = Integer.parseInt(args[0]);
    }
    JPanel jp = new Panel4Troop();
    JFrame jf = new Frame4(jp);
    jf.setSize(400, 400);
  }

  /**
   Creates new form Panel4SDB
   */
  public Panel4Troop() {
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

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
