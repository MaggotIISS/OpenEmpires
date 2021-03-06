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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 <p>
 @author maggot
 */
@SuppressWarnings("serial")
public class Panel4GridLayer extends Panel4 {

  static JPanel jp;
  static JFrame jf;
  int ox;
  int oy;
  static int w;
  static int h;
  static int secX;
  static int secY;
  static boolean VERT;
  static boolean HORIZ;
  static boolean SUB;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4GridLayer("GridLayer");
    jf = new Frame4(jp);
    calc();
  }

  /**
   Creates new form Panel4GridLayer
   */
  public Panel4GridLayer() {
    super();
    initComponents();
    setup();
    calc();
    jLabel8.addMouseMotionListener(new MouseMotionListener() {
      @Override
      public void mouseDragged(MouseEvent e) {
        calc();
      }

      @Override
      public void mouseMoved(MouseEvent e) {
        calc();
        int x = e.getX() - jLabel8.getX() / 2;
        int y = e.getY() - jLabel8.getY() / 2;
        x = (x / 2);
        y = (y / 2);
        int numx = x;// % Integer.parseInt(jSpinner1.getValue().toString());
        int numy = y;// % Integer.parseInt(jSpinner2.getValue().toString());
        jLabel11.setText("" + numx);
        jLabel12.setText("" + numy);
      }
    });
//    JLabel jl = new JLabel();
//    jl.setBackground(Color.black);
//    jScrollPane1.setViewportView(jl);
  }

  /**
   <p>
   @param title setName()
   */
  public Panel4GridLayer(String title) {
    this();
    setName(title);
  }

//==============================================================================
  /**
   <p>
   @param g Graphics
   */
  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g.setColor(Color.black);
    g.fillRect(0, 0, getSize().width, getSize().height);
    calc();
    ox = Panel4GridLayer.jLabel8.getX();
    oy = 300 + Panel4GridLayer.jLabel8.getY();
    g.setColor(Color.white);
    g.drawRect(ox, oy, secX, secY);
    if (VERT == true) {
      for (int i = 0; i < JLabel.WIDTH; i += secX) {
        g.drawLine(ox + i, oy + JLabel.TOP, ox + i, JLabel.TOP + JLabel.HEIGHT);
      }
    }
    if (HORIZ == true) {
      for (int i = 0; i < JLabel.HEIGHT; i += secY) {
        g.drawLine(ox + i, oy + JLabel.TOP, ox + i, JLabel.TOP + JLabel.HEIGHT);
      }
    }
    this.repaint();
  }

  /**
   calc
   */
  public static void calc() {
    w = jLabel8.getWidth();
    h = jLabel8.getHeight();
//    //System.out.print("w" + " = " + w);
//    //System.out.print("h" + " = " + h);
    secX = w / (int) jSpinner1.getValue();
    secY = h / (int) jSpinner2.getValue();
    jSpinner3.setValue(secX);
    jSpinner4.setValue(secY);
    jSpinner5.setValue(secX / (int) jSpinner7.getValue());
    jSpinner6.setValue(secY / (int) jSpinner7.getValue());
    int subs = (int) jSpinner7.getValue();

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
    jSpinner1 = new javax.swing.JSpinner();
    jSpinner2 = new javax.swing.JSpinner();
    jSpinner3 = new javax.swing.JSpinner();
    jSpinner4 = new javax.swing.JSpinner();
    jSpinner5 = new javax.swing.JSpinner();
    jSpinner6 = new javax.swing.JSpinner();
    jSpinner7 = new javax.swing.JSpinner();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jScrollPane1 = new javax.swing.JScrollPane();
    jLabel8 = new javax.swing.JLabel();

    jPanel1.setMaximumSize(new java.awt.Dimension(100, 32767));
    jPanel1.setMinimumSize(new java.awt.Dimension(100, 0));
    jPanel1.setOpaque(false);

    jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(12), Integer.valueOf(0), null, Integer.valueOf(1)));
    jSpinner1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jSpinnerMouseClicked(evt);
      }
    });
    jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jSpinnerStateChanged(evt);
      }
    });
    jSpinner1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(java.awt.event.MouseEvent evt) {
        jSpinnerMouseDragged(evt);
      }
    });

    jSpinner2.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(9), Integer.valueOf(0), null, Integer.valueOf(1)));
    jSpinner2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jSpinnerMouseClicked(evt);
      }
    });
    jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jSpinnerStateChanged(evt);
      }
    });
    jSpinner2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(java.awt.event.MouseEvent evt) {
        jSpinnerMouseDragged(evt);
      }
    });

    jSpinner3.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
    jSpinner3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jSpinnerMouseClicked(evt);
      }
    });
    jSpinner3.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jSpinnerStateChanged(evt);
      }
    });
    jSpinner3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(java.awt.event.MouseEvent evt) {
        jSpinnerMouseDragged(evt);
      }
    });

    jSpinner4.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
    jSpinner4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jSpinnerMouseClicked(evt);
      }
    });
    jSpinner4.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jSpinnerStateChanged(evt);
      }
    });
    jSpinner4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(java.awt.event.MouseEvent evt) {
        jSpinnerMouseDragged(evt);
      }
    });

    jSpinner5.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(4), null, null, Integer.valueOf(1)));
    jSpinner5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jSpinnerMouseClicked(evt);
      }
    });
    jSpinner5.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jSpinnerStateChanged(evt);
      }
    });
    jSpinner5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(java.awt.event.MouseEvent evt) {
        jSpinnerMouseDragged(evt);
      }
    });

    jSpinner6.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(4), null, null, Integer.valueOf(1)));
    jSpinner6.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jSpinnerMouseClicked(evt);
      }
    });
    jSpinner6.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jSpinnerStateChanged(evt);
      }
    });
    jSpinner6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(java.awt.event.MouseEvent evt) {
        jSpinnerMouseDragged(evt);
      }
    });

    jSpinner7.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(4), Integer.valueOf(0), null, Integer.valueOf(1)));
    jSpinner7.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jSpinnerMouseClicked(evt);
      }
    });
    jSpinner7.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jSpinnerStateChanged(evt);
      }
    });
    jSpinner7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(java.awt.event.MouseEvent evt) {
        jSpinnerMouseDragged(evt);
      }
    });

    jLabel1.setText("Across");
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    jLabel2.setText("Down");
    jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel2MouseClicked(evt);
      }
    });

    jLabel3.setText("Subs");

    jLabel4.setText("SecW");

    jLabel5.setText("SecH");

    jLabel6.setText("SubW");

    jLabel7.setText("SubH");

    jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel9.setText("x");

    jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel10.setText("y");

    jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel11.setText("0");

    jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel12.setText("0");

    jTextArea1.setColumns(6);
    jTextArea1.setRows(5);
    jTextArea1.setPreferredSize(new java.awt.Dimension(50, 80));
    jScrollPane2.setViewportView(jTextArea1);

    org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(jPanel1Layout.createSequentialGroup()
        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
          .add(jPanel1Layout.createSequentialGroup()
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
              .add(jSpinner2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
              .add(jSpinner1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
              .add(jLabel2)
              .add(jLabel1)))
          .add(jPanel1Layout.createSequentialGroup()
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
              .add(jSpinner4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
              .add(jSpinner3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
              .add(jLabel4)
              .add(jLabel5)))
          .add(jPanel1Layout.createSequentialGroup()
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
              .add(jSpinner6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
              .add(jSpinner5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
              .add(jLabel6)
              .add(jLabel7)))
          .add(jPanel1Layout.createSequentialGroup()
            .add(jLabel9)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
            .add(jLabel11))
          .add(jPanel1Layout.createSequentialGroup()
            .add(jLabel10)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
            .add(jLabel12))
          .add(jPanel1Layout.createSequentialGroup()
            .add(jSpinner7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(jLabel3)))
        .add(0, 22, Short.MAX_VALUE))
      .add(jScrollPane2)
    );

    jPanel1Layout.linkSize(new java.awt.Component[] {jSpinner1, jSpinner2, jSpinner3, jSpinner4, jSpinner5, jSpinner6, jSpinner7}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(jPanel1Layout.createSequentialGroup()
        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jSpinner1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
          .add(jLabel1))
        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jSpinner2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
          .add(jLabel2))
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jLabel4)
          .add(jSpinner3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        .add(2, 2, 2)
        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jLabel5)
          .add(jSpinner4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jLabel6)
          .add(jSpinner5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        .add(2, 2, 2)
        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jSpinner6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
          .add(jLabel7))
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jLabel3)
          .add(jSpinner7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jLabel9)
          .add(jLabel11))
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
          .add(jLabel10)
          .add(jLabel12))
        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
        .add(jScrollPane2)
        .add(0, 0, 0))
    );

    jScrollPane1.setOpaque(false);

    jLabel8.setBackground(new java.awt.Color(0, 0, 0));
    jLabel8.setIcon(new javax.swing.ImageIcon("D:\\Cyberboard\\BMP\\Imp\\allmap.gif")); // NOI18N
    jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel8MouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        jLabel8MouseEntered(evt);
      }
    });
    jScrollPane1.setViewportView(jLabel8);

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        .add(0, 0, 0)
        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
      .add(layout.createSequentialGroup()
        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(49, Short.MAX_VALUE))
      .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents

    private void jSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerStateChanged
    calc();
    }//GEN-LAST:event_jSpinnerStateChanged

    private void jSpinnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinnerMouseClicked
    calc();
    }//GEN-LAST:event_jSpinnerMouseClicked

    private void jSpinnerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSpinnerMouseDragged
    calc();
    }//GEN-LAST:event_jSpinnerMouseDragged

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    HORIZ = !HORIZ;
    //System.out.print("HORIZ" + " = " +HORIZ);
    repaint();
  }//GEN-LAST:event_jLabel1MouseClicked

  private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
    VERT = !VERT;
    //System.out.print("VERT" + " = " +VERT);
    repaint();
  }//GEN-LAST:event_jLabel2MouseClicked

  private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
    calc();
    int x = evt.getX() - jLabel8.getX();
    int y = evt.getY() - jLabel8.getY();
    jLabel11.setText("" + x);
    jLabel12.setText("" + y);
  }//GEN-LAST:event_jLabel8MouseEntered

  private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    calc();
  }//GEN-LAST:event_jLabel8MouseClicked
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private static javax.swing.JLabel jLabel11;
  private static javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  static javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  public static javax.swing.JSpinner jSpinner1;
  public static javax.swing.JSpinner jSpinner2;
  public static javax.swing.JSpinner jSpinner3;
  public static javax.swing.JSpinner jSpinner4;
  public static javax.swing.JSpinner jSpinner5;
  public static javax.swing.JSpinner jSpinner6;
  public static javax.swing.JSpinner jSpinner7;
  private javax.swing.JTextArea jTextArea1;
  // End of variables declaration//GEN-END:variables

  private void setup() {
    int picwidth = 0;
    int picheight = 0;
    picwidth = jLabel8.getWidth();
    picheight = jLabel8.getHeight();
    //System.out.print("picwidth" + " = " +picwidth);
    //System.out.print("picheight" + " = " +picheight);
  }
}
