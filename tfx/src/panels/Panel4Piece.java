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

import dbviewer.DBPublic;
import dbviewer.DBViewer;
import dbviewer.globals.GlobalMethods;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**

 @author maggot
 */
public class Panel4Piece extends Panel4 {

  /**
   im
   */
  public static Image[] im = new Image[1];
  /**
   imic
   */
  public static ImageIcon[] imic = new ImageIcon[1];
  /**
   jsp
   */
  public static JScrollPane jsp = new JScrollPane();
  static JPanel p4p = new JPanel();
  static JFrame f4p = new JFrame();

  /**

   @param args strings to start
   */
  public static void main(String[] args) {
    JPanel p4p = new Panel4Piece("Piece");
    p4p.setLayout(new BorderLayout());
    JPanel p4d = new Panel4Dimensions("Dimensions");
    JPanel p4lc = new Panel4ComboSpinner();
    JPanel p4pi = new Panel4PieceInfo();
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new GridLayout(3, 1));
    leftPanel.add(p4d);
    leftPanel.add(p4lc);
    leftPanel.add(p4pi);
    jsp = new JScrollPane(p4p);
    jsp.setPreferredSize(new Dimension(Panel4Piece.B.getWidth(), Panel4Piece.U
      .getY() + Panel4Piece.U.getHeight()));
    f4p = new Frame4();
    f4p.add(leftPanel, BorderLayout.WEST);
    f4p.add(jsp, BorderLayout.CENTER);
    f4p.setTitle("Piece");
    f4p.setSize(new Dimension(350, 300));
    Panel4Piece.updater();
    GlobalMethods.autoColor(p4p, Color.black, Color.LIGHT_GRAY);
    GlobalMethods.autoColor(p4pi, Color.black, Color.LIGHT_GRAY);
    GlobalMethods.autoColor(p4lc, Color.black, Color.LIGHT_GRAY);
//    GlobalMethods.autoColor(topPanel, Color.black, Color.LIGHT_GRAY);
    GlobalMethods.autoColor(jsp, Color.black, Color.LIGHT_GRAY);
  }

  /**
   Creates new form Panel4Piece
   */
  public Panel4Piece() {
    super();
    initComponents();
    U.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        String dir = "./BMP";
        DBPublic.CBView(dir);
        int ret = DBViewer.jfc.showOpenDialog(Panel4Piece.U);
        if (ret == JFileChooser.APPROVE_OPTION) {
          String file = DBViewer.jfc.getSelectedFile().toString();
//          //System.out.print("Open" + " = " + file);
          int i = 0;
          try {
            im[i] = ImageIO.read(new File(file));
            imic[i] = new ImageIcon(im[i]);
          } catch (IOException ex) {
            //System.out.print("IOException = " + ex);
          }
          JLabel lab = null;
          if (i == 0) {
            lab = U;
          }
          lab.setIcon(imic[i]);
//          lab.setVisible(true);
        }
      }
    });
    F.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        String dir = "./BMP";
        DBPublic.CBView(dir);
        DBViewer.jfc.setSelectedFile(new File("/154thBatRon.gif"));
        int ret = DBViewer.jfc.showOpenDialog(Panel4Piece.F);
        if (ret == JFileChooser.APPROVE_OPTION) {
          String file = DBViewer.jfc.getSelectedFile().toString();
          int i = 0;
          im[0] = Toolkit.getDefaultToolkit().getImage(file);
          imic[i] = new ImageIcon(im[i]);
        }
        F.setIcon(imic[0]);
        FG1.setVisible(false);
        F1.setVisible(false);
        B1.setVisible(false);
        BG1.setVisible(false);
        U1.setVisible(false);
//        im[0].getGraphics().drawImage(im[0], F.getX(), F.getY(), jsp);
        repaint();
      }
    });
    U1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        String dir = "./BMP";
        DBPublic.CBView(dir);
        int ret = DBViewer.jfc.showOpenDialog(Panel4Piece.U);
        if (ret == JFileChooser.APPROVE_OPTION) {
          String file = DBViewer.jfc.getSelectedFile().toString();
//          //System.out.print("Open" + " = " + file);
          int i = 0;
          try {
            im[i] = ImageIO.read(new File(file));
            imic[i] = new ImageIcon(im[i]);
          } catch (IOException ex) {
            //System.out.print("IOException = " + ex);
          }
          JLabel lab = null;
          if (i == 0) {
            lab = U1;
          }
          lab.setIcon(imic[i]);
          lab.setVisible(true);
        }
      }
    });
    F1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent me) {
        String dir = "./BMP";
        DBPublic.CBView(dir);
        int ret = DBViewer.jfc.showOpenDialog(Panel4Piece.F);
        if (ret == JFileChooser.APPROVE_OPTION) {
          String file = DBViewer.jfc.getSelectedFile().toString();
//          //System.out.print("Open" + " = " + file);
          int i = 0;
          try {
            im[i] = ImageIO.read(new File(file));
            imic[i] = new ImageIcon(im[i]);
          } catch (IOException ex) {
            //System.out.print("IOException = " + ex);
          }
          JLabel lab = F1;
          lab.setIcon(imic[i]);
          lab.setVisible(true);
        }
      }
    });
//    panels.Panel4Piece.FG.setBounds(0, 0, (int) jsx.getValue(), (int) jsz.getValue() / 2);
//    panels.Panel4Piece.F.setBounds(0, (int) jsz.getValue() / 2, (int) jsx.getValue(), (int) jsy.getValue());
//    panels.Panel4Piece.B.setBounds(0, (int) jsz.getValue() / 2 + (int) jsy.getValue(), (int) jsx.getValue(), (int) jsy.getValue());
//    panels.Panel4Piece.BG.setBounds(0, (int) jsz.getValue() / 2 + (int) jsy.getValue() + (int) jsy.getValue(), (int) jsx.getValue(), (int) jsz.getValue() / 2);
//    panels.Panel4Piece.U.setBounds(0, (int) jsz.getValue() + (int) jsy.getValue() + (int) jsy.getValue() - i, (int) jsx.getValue(), (int) jsz.getValue());
  }

  /**

   @param g Graphics
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
//    AffineTransform start = g2d.getTransform();
    if (im[0] != null) {
      int w = im[0].getWidth(null);
      int h = im[0].getHeight(null);
      int diag = (int) Math.sqrt((w * w) + (h * h));
//      int cx = diag / 2;
//      int cy = diag / 2;
      Rectangle rect = F.getBounds();
//creating the AffineTransform instance
      AffineTransform affineTransform = new AffineTransform();
//set the translation to the mid of the component
      affineTransform.setToTranslation((rect.width - im[0].getWidth(null)) / 2,
        (rect.height - im[0].getHeight(null)) / 2);
//affineTransform.setToTranslation(im[0].getWidth(null)/2,im[0].getHeight(null)/2);
//rotate with the anchor point as the mid of the image
      affineTransform.rotate(Math.toRadians(180), im[0].getWidth(null) / 2,
        im[0].getHeight(null) / 2);
//draw the image using the AffineTransform
      g2d.drawImage(im[0], affineTransform, F);
//      Graphics graphics = im[0].getGraphics();
//      F.setToolTipText("imic[0]");
    }
  }

  /**

   @param piece name to set Panel4Piece
   */
  public Panel4Piece(String piece) {
    this();
    setName(piece);
  }

  /**

   @return name of class
   */
  @Override
  public String toString() {
    return "" + getClass().getName() + "[]";
  }

  /**
   updater
   */
  public static void updater() {
    Panel4Dimensions.Recalc();
    Panel4PieceInfo.update();
    JLabel lab = null;
    JLabel lab2 = null;
    for (int i = 0; i < 6; i++) {
      switch (i) {
        case 0:
          lab = FG;
          lab2 = FG1;
          break;
        case 1:
          lab = F;
          lab2 = F1;
          break;
        case 2:
          lab = B;
          lab2 = B1;
          break;
        case 3:
          lab = BG;
          lab2 = BG1;
          break;
        case 4:
          lab = U;
          lab2 = U1;
          break;
      }
      lab2.setSize(lab.getSize());
      lab2.setLocation(lab.getX() + lab.getWidth(), lab.getY());
    }
    jsp.setPreferredSize(new Dimension(Panel4Piece.B.getWidth() * 2,
      (Panel4Piece.U.getY() + Panel4Piece.U.getHeight())));

  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    FG = new javax.swing.JLabel();
    F = new javax.swing.JLabel();
    B = new javax.swing.JLabel();
    BG = new javax.swing.JLabel();
    U = new javax.swing.JLabel();
    FG1 = new javax.swing.JLabel();
    F1 = new javax.swing.JLabel();
    B1 = new javax.swing.JLabel();
    BG1 = new javax.swing.JLabel();
    U1 = new javax.swing.JLabel();

    setBackground(getBackground());
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        formMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        formMouseExited(evt);
      }
    });
    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentShown(java.awt.event.ComponentEvent evt) {
        formComponentShown(evt);
      }
    });
    addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseDragged(java.awt.event.MouseEvent evt) {
        formMouseDragged(evt);
      }
    });
    addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        formFocusGained(evt);
      }
    });

    FG.setBackground(new java.awt.Color(255, 255, 255));
    FG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    FG.setAlignmentY(0.0F);
    FG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    FG.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    FG.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
    FG.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    FG.setIconTextGap(0);
    FG.setName("1"); // NOI18N
    FG.setOpaque(true);

    F.setBackground(new java.awt.Color(255, 255, 255));
    F.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    F.setAlignmentY(0.0F);
    F.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    F.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    F.setIconTextGap(0);
    F.setMaximumSize(new java.awt.Dimension(0, 0));
    F.setName("2"); // NOI18N
    F.setOpaque(true);

    B.setBackground(new java.awt.Color(255, 255, 255));
    B.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    B.setText("4");
    B.setAlignmentY(0.0F);
    B.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    B.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    B.setIconTextGap(0);
    B.setMaximumSize(new java.awt.Dimension(0, 0));
    B.setMinimumSize(null);
    B.setName("3"); // NOI18N
    B.setOpaque(true);
    B.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        BMouseClicked(evt);
      }
    });

    BG.setBackground(new java.awt.Color(255, 255, 255));
    BG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    BG.setText("4");
    BG.setAlignmentY(0.0F);
    BG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    BG.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    BG.setIconTextGap(0);
    BG.setMaximumSize(new java.awt.Dimension(0, 0));
    BG.setName("4"); // NOI18N
    BG.setOpaque(true);
    BG.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        BGMouseClicked(evt);
      }
    });

    U.setBackground(new java.awt.Color(255, 255, 255));
    U.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    U.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    U.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    U.setMaximumSize(new java.awt.Dimension(0, 0));
    U.setName("5"); // NOI18N
    U.setOpaque(true);

    FG1.setBackground(new java.awt.Color(255, 255, 255));
    FG1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    FG1.setAlignmentY(0.0F);
    FG1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    FG1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    FG1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    FG1.setIconTextGap(0);
    FG1.setName("1"); // NOI18N
    FG1.setOpaque(true);
    FG1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        FG1MouseClicked(evt);
      }
    });

    F1.setBackground(new java.awt.Color(255, 255, 255));
    F1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    F1.setAlignmentY(0.0F);
    F1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    F1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    F1.setIconTextGap(0);
    F1.setMaximumSize(new java.awt.Dimension(0, 0));
    F1.setName("2"); // NOI18N
    F1.setOpaque(true);
    F1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        F1MouseClicked(evt);
      }
    });

    B1.setBackground(new java.awt.Color(255, 255, 255));
    B1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    B1.setAlignmentY(0.0F);
    B1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    B1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    B1.setIconTextGap(0);
    B1.setMaximumSize(new java.awt.Dimension(0, 0));
    B1.setName("3"); // NOI18N
    B1.setOpaque(true);
    B1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        B1MouseClicked(evt);
      }
    });

    BG1.setBackground(new java.awt.Color(255, 255, 255));
    BG1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    BG1.setAlignmentY(0.0F);
    BG1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    BG1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    BG1.setIconTextGap(0);
    BG1.setMaximumSize(new java.awt.Dimension(0, 0));
    BG1.setName("4"); // NOI18N
    BG1.setOpaque(true);
    BG1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        BG1MouseClicked(evt);
      }
    });

    U1.setBackground(new java.awt.Color(255, 255, 255));
    U1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    U1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    U1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    U1.setMaximumSize(new java.awt.Dimension(0, 0));
    U1.setName("5"); // NOI18N
    U1.setOpaque(true);
    U1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        U1MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(FG, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(F, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(BG, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(U, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(FG1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(F1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(BG1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(U1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {B, B1, BG, BG1, F, F1, FG, FG1, U, U1});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(FG, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(F, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        .addGap(0, 0, 0)
        .addComponent(B, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(BG, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(U, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(layout.createSequentialGroup()
        .addComponent(FG1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(F1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        .addGap(0, 0, 0)
        .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(BG1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(U1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
    updater();
  }//GEN-LAST:event_formMouseEntered

  private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    updater();
  }//GEN-LAST:event_formComponentShown

  private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
    updater();
  }//GEN-LAST:event_formFocusGained

  private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
    updater();
  }//GEN-LAST:event_formMouseDragged

  private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
    updater();
  }//GEN-LAST:event_formMouseExited

  private void BMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BMouseClicked
    B.setText(JOptionPane.showInputDialog("Enter Info"));
  }//GEN-LAST:event_BMouseClicked

  private void BGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BGMouseClicked
    BG.setText(JOptionPane.showInputDialog("Enter Info"));
  }//GEN-LAST:event_BGMouseClicked

  private void B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B1MouseClicked
    B1.setText(JOptionPane.showInputDialog("Enter Info"));
  }//GEN-LAST:event_B1MouseClicked

  private void BG1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BG1MouseClicked
    BG1.setText(JOptionPane.showInputDialog("Enter Info"));
  }//GEN-LAST:event_BG1MouseClicked

  private void FG1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FG1MouseClicked
    FG1.setText(JOptionPane.showInputDialog("Enter Info"));
  }//GEN-LAST:event_FG1MouseClicked

  private void F1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_F1MouseClicked
    FG1.setText(JOptionPane.showInputDialog("Enter Info"));
  }//GEN-LAST:event_F1MouseClicked

  private void U1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_U1MouseClicked
    U1.setText(JOptionPane.showInputDialog("Enter Info"));
  }//GEN-LAST:event_U1MouseClicked
  // Variables declaration - do not modify//GEN-BEGIN:variables
  public static javax.swing.JLabel B;
  public static javax.swing.JLabel B1;
  public static javax.swing.JLabel BG;
  public static javax.swing.JLabel BG1;
  public static javax.swing.JLabel F;
  public static javax.swing.JLabel F1;
  public static javax.swing.JLabel FG;
  public static javax.swing.JLabel FG1;
  public static javax.swing.JLabel U;
  public static javax.swing.JLabel U1;
  // End of variables declaration//GEN-END:variables

}
