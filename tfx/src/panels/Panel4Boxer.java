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

import dbviewer.Hexer;
import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables._GIF;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;

/**
 <p>
 @author maggot.iiss
 */
@SuppressWarnings("serial")
public final class Panel4Boxer extends Panel4 {

  /**

   */
  private static JFileChooser jfc = new JFileChooser();
  /**
   JFrame
   */
  public static JFrame jf = new JFrame();
  private static int o = 0, w, h, pw, ph, xm, ym, t = o, l = o, x, y, z, r;
  private static JPanel topPanel, rightPanel, frontPanel, leftPanel, underPanel, backPanel;
  private static JPanel[] panels = {topPanel, rightPanel, frontPanel, leftPanel,
    underPanel, backPanel};
  private static JPanel pan;
  private static JLabel topLabel, rightLabel, frontLabel, leftLabel, underLabel, backLabel;
  private static JLabel[] labels = {topLabel, rightLabel, frontLabel, leftLabel,
    underLabel, backLabel};
  private static JLabel lab;
  private static String[] sides = {"Top", "Right", "Front", "Left", "Under",
    "Back"};
//  private static String file = "D:/Cyberboard/bmp/154thBatRON.gif";
  private static String file = _GIF + FS + "154thBatRon.gif";
  private static Image[] im = new Image[6];
  private static ImageIcon[] imic = new ImageIcon[6];

  /**
   Point
   */
  public Point A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P,
    Q, R, S, T, U, V, K1, K2, C1, C2, C3, C4, C5, C6;
  private String s = "";
  int active;
  private static Graphics2D g2; // Create a Java2D version of g.
  private static Panel4 jp;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4Boxer();
    jf = new Frame4(jp);
    jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

  }

  /**
   Creates new form Panel4Boxer
   */
  public Panel4Boxer() {
    //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    jfc.setCurrentDirectory(new File(dbviewer.globals.GlobalVariables.BMP));
    jfc.setSelectedFile(new File("D:/Cyberboard/bmp/154thBatRon.gif"));
    jfc.setAcceptAllFileFilterUsed(false);
    jfc.addChoosableFileFilter(new FileFilter() {
      @Override
      public boolean accept(File f) {
        if (f.isFile() & f.toString().endsWith(".gif")) {
          return true;
        } else {
          return false;
        }
      }

      @Override
      public String getDescription() {
        return "Graphic Image Format";
      }
    });
    dbviewer.ImagePreviewer ip = new dbviewer.ImagePreviewer(jfc);
    jfc.setAccessory(ip);
    initComponents();
    setActive(0);
    start();
    update();
  }

  /**
   Setup variables for first use
   */
  public void start() {
    jf.setContentPane(this);
    x = (int) X.getValue();
    y = (int) Y.getValue();
    z = (int) Z.getValue();
    r = (int) Ratio.getValue();
    Border border = BorderFactory.createLineBorder(Color.black);
    for (int i = 0; i < panels.length; i++) {
      pan = panels[i];
      pan = new JPanel();
      pan.setName(sides[i].toString());
      pan.setBackground(Color.cyan);
      pan.setToolTipText(sides[i]);
      pan.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          System.out.println("\tPanel mouseClicked");
        }
      });
      pan.setBorder(border);
      pan.setVisible(false);
      panels[i] = pan;
      ViewPanel.add(pan);
//----------------------------
      lab = labels[i];
      lab = new JLabel();
      lab.setName(sides[i].toString());
      lab.setBackground(Color.white);
      lab.setToolTipText(sides[i].toString() + "Label");
      lab.setOpaque(true);
      lab.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          JLabel l;
          int start = e.toString().indexOf("on ", 0);
          int end = e.toString().length();
          String str = e.toString().substring(start + 3, end);
//            System.out.println("" + " = " + str);
          int idx = 0;
          if ("Top".equals(str)) {
            idx = 0;
          }
          if ("Right".equals(str)) {
            idx = 1;
          }
          if ("Front".equals(str)) {
            idx = 2;
          }
          if ("Left".equals(str)) {
            idx = 3;
          }
          if ("Under".equals(str)) {
            idx = 4;
          }
          if ("Back".equals(str)) {
            idx = 5;
          }
          setActive(idx);
          jf.setTitle("" + getActive());
          l = labels[idx];
//          jf.setTitle("" + idx);
          //rotate(l);
          if (e.getClickCount() == 2) {
            int ret;
            if ((ret = jfc.showOpenDialog(lab)) == JFileChooser.APPROVE_OPTION) {
              try {
                im[idx] = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                  l.getWidth(), -1, Image.SCALE_SMOOTH);
                imic[idx] = new ImageIcon(im[idx]);

              } catch (IOException ex) {
                System.out.print("IOException = " + ex);
              }
              labels[idx].setIcon(imic[idx]);
              labels[idx].setVisible(true);
            }
          }
        }
      });
      lab.setBorder(border);
      lab.setBounds(pan.getBounds());
      lab.setHorizontalAlignment(SwingConstants.CENTER);
      try {
        im[i] = ImageIO.read(new File(file));
        imic[i] = new ImageIcon(im[i]);

      } catch (IOException ex) {
        System.out.print("IOException = " + ex);
      }
      lab.setIcon(imic[i]);
      lab.setVisible(true);

      labels[i] = lab;
      pan.add(lab);
      ViewPanel.add(lab);
      //System.out.print("jf.getContentPane()" + " = " + jf.getContentPane());
      jf.pack();
    }
  }

  /**
   Update variables with new data for repainting
   */
  public void update() {
    //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    x = (int) X.getValue();//width(front view)
    y = (int) Y.getValue();//height(front view)
    z = (int) Z.getValue();//length(front view)
    r = (int) Ratio.getValue();

    Image image = im[getActive()];
    g2 = (Graphics2D) this.getGraphics();
    g2.setColor(Color.black);

    g2.drawLine(0, 0 + conPanel.getHeight(),
      labels[2].getX(), labels[2].getY() + conPanel.getHeight());
    g2.drawLine(0, z + conPanel.getHeight(),
      labels[0].getX(), labels[0].getY() + conPanel.getHeight());

    g2.drawLine(labels[3].getX(), labels[3].getY() + conPanel.getHeight(),
      labels[3].getX() + labels[3].getWidth(), labels[0].getY() + conPanel
      .getHeight());
    g2.drawLine(labels[0].getX() + labels[0].getWidth(),
      labels[0].getY() + conPanel.getHeight(), labels[3].getX() + labels[3]
      .getWidth(), labels[3].getY() + conPanel.getHeight());

    g2.drawLine(labels[1].getX(), labels[4].getY() + conPanel.getHeight(),
      labels[5].getX(), labels[5].getY() + conPanel.getHeight());
    g2.drawLine(0, labels[5].getY() + conPanel.getHeight(),
      labels[4].getX(), labels[4].getY() + conPanel.getHeight());

    g2.drawLine(labels[3].getX(), labels[4].getY() + conPanel.getHeight(),
      labels[3].getX() + labels[3].getWidth(), labels[5].getY() + conPanel
      .getHeight());
    g2.drawLine(labels[3].getX(), labels[5].getY() + conPanel.getHeight(),
      labels[3].getX() + labels[3].getWidth(), labels[4].getY() + conPanel
      .getHeight());

    g2.drawLine(0,
      0 + conPanel.getHeight(),
      labels[3].getX() + labels[3].getWidth(),
      0 + conPanel.getHeight());
    g2.drawLine(labels[3].getX() + labels[3].getWidth(),
      0 + conPanel.getHeight(),
      labels[3].getX() + labels[3].getWidth(),
      labels[5].getY() + labels[5].getHeight() + conPanel.getHeight());
    g2.drawLine(0, labels[5].getY() + conPanel.getHeight(),
      labels[3].getX() + labels[3].getWidth(),
      labels[5].getY() + conPanel.getHeight());
    g2.drawLine(0, 0 + conPanel.getHeight(),
      0, labels[5].getY() + conPanel.getHeight());

    g2.drawLine(0,
      labels[5].getY() + conPanel.getHeight(),
      labels[5].getX(),
      labels[5].getY() + labels[5].getHeight() + conPanel.getHeight());
    g2.drawLine(labels[5].getX() + labels[5].getWidth(),
      labels[5].getY() + labels[5].getHeight() + conPanel.getHeight(),
      labels[3].getX() + labels[3].getWidth(),
      labels[5].getY() + conPanel.getHeight());

    g2.drawLine(0,//labels[5].getX() / 2,
      labels[5].getY() + (labels[5].getHeight()) + conPanel.getHeight(),
      labels[5].getX(),
      labels[5].getY() + conPanel.getHeight());
    g2.drawLine(labels[5].getX() + labels[5].getWidth(),
      labels[5].getY() + conPanel.getHeight(),
      labels[3].getX() + (labels[3].getWidth()),
      labels[5].getY() + (labels[5].getHeight()) + conPanel.getHeight());

    g2.drawLine(labels[1].getX(),
      labels[5].getY() + labels[5].getHeight() + conPanel.getHeight(),
      labels[5].getX() + labels[5].getWidth(),
      labels[5].getY() + labels[5].getHeight() + conPanel.getHeight());

    jf.setTitle("" + getActive());
    for (int i = 0; i < panels.length; i++) {
      pan = panels[i];
      lab = labels[i];
      if (pan.getName().equals("Top")) {
        pan.setBounds(z, o, x, z);
        lab.setBounds(z, o, x, z);
      }
      if (pan.getName().equals("Right")) {
        pan.setBounds(o, z, z, y);
        lab.setBounds(o, z, z, y);
      }
      if (pan.getName().equals("Front")) {
        pan.setBounds(z, z, x, y);
        lab.setBounds(z, z, x, y);
      }
      if (pan.getName().equals("Left")) {
        pan.setBounds(z + x, z, z, y);
        lab.setBounds(z + x, z, z, y);
      }
      if (pan.getName().equals("Under")) {
        pan.setBounds(z, z + y, x, z);
        lab.setBounds(z, z + y, x, z);
      }
      if (pan.getName().equals("Back")) {
        pan.setBounds(z, (z * 2) + y, x, y);
        lab.setBounds(z, (z * 2) + y, x, y);
      }
    }
//-----------------------------------
    AffineTransform affineTransform = new AffineTransform();
    affineTransform.setToTranslation(labels[0].getX(),
      labels[0].getY() + conPanel.getHeight());
    affineTransform.rotate(Math.toRadians(180), image.getWidth(this) / 2, image
      .getHeight(this) / 2);
    g2.drawImage(image, affineTransform, this);
//-----------------------------------
    AffineTransform start = g2.getTransform();
    start.setToTranslation(labels[1].getX() + 2, labels[1].getY() + conPanel
      .getHeight() + 2);
    start.rotate(Math.toRadians(90), 2 + (image.getWidth(labels[0]) / 2),
      1 + (image.getHeight(this) / 2));
    g2.drawImage(image, start, this);
//-----------------------------------
    //repaint();

//    jsp.setPreferredSize(new Dimension((2*x)+y,(2*y)+(2*z)));
//    jsp.setSize(ViewPanel.getPreferredSize());
  }

  /**
   <p>
   @param g Graphics
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Image image = im[getActive()];
    Graphics2D g2 = (Graphics2D) g; // Create a Java2D version of g.
    //-----------------------------------
    AffineTransform affineTransform = new AffineTransform();
    affineTransform.setToTranslation(labels[0].getX(),
      labels[0].getY() + conPanel.getHeight());
    affineTransform.rotate(Math.toRadians(180), image.getWidth(this) / 2, image
      .getHeight(this) / 2);
    g2.drawImage(image, affineTransform, this);
//-----------------------------------
//    AffineTransform start = g2.getTransform();
//    start.setToTranslation(labels[1].getX() + 2, labels[1].getY() + conPanel.getHeight() + 2);
//    start.rotate(Math.toRadians(90), 2 + (image.getWidth(labels[0]) / 2), 1 + (image.getHeight(this) / 2));
//    g2.drawImage(image, start, this);
//-----------------------------------
    jf.setTitle("" + getActive());
    update();
  }

  private void rotate(int active) {
    Image image = im[active];
    ImageIcon ii = imic[active];
    System.out.println("image.toString()" + " = " + image.toString());
    System.out.println("ii.toString()" + " = " + ii.toString());
//    AffineTransform start = g2.getTransform();
//    start.setToTranslation(labels[1].getX() + 2, labels[1].getY() + conPanel.getHeight() + 2);
//    start.rotate(Math.toRadians(90), 2 + (image.getWidth(labels[0]) / 2), 1 + (image.getHeight(this) / 2));
//    g2.drawImage(image, start, this);
    repaint();
  }

//---------------------------
  private static class BoxPrinter implements ActionListener, Printable {

    public BoxPrinter() {
      ////System.out.print("BoxPrinter");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      ////System.out.print("actionPerformed(ActionEvent ae) = " + ae);
      PrinterJob job = PrinterJob.getPrinterJob();
      job.setPrintable(this);
      boolean ok = job.printDialog();
      if (ok) {
        try {
          job.print();
        } catch (PrinterException ex) {
          /*
           The job did not successfully complete
           */
          //System.out.print("OOPS!");
        }
      }
    }

    @Override
    public int print(Graphics grphcs, PageFormat pf, int i) throws
      PrinterException {
//      //System.out.print("print(Graphics grphcs, PageFormat pf, int i) = "
//              + grphcs + " " + pf + " " + i);
      if (i > 0) {
        /*
         We have only one page, and 'page' is zero-based
         */

        return NO_SUCH_PAGE;
      }

      /*
       User (0,0) is typically outside the imageable area, so we must
       translate by the X and Y values in the PageFormat to avoid clipping
       */
      Graphics2D g2d = (Graphics2D) grphcs;
      g2d.translate(pf.getImageableX(), pf.getImageableY());

//      /* Now we perform our rendering */
//      g2d.rotate(50);
//      //grphcs.drawString("Hello world!", 100, 100);
//      g2d.drawString("Hexer", 100, 300);
      jf.printAll(grphcs);

      return PAGE_EXISTS;
    }
  }

  /**
   <p>
   @return name of class
   */
  @Override
  public String toString() {
    return "" + getClass().getName() + "[]";
  }

  private int getActive() {
    return active;
  }

  private void setActive(int n) {
    active = n;

  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conPanel = new javax.swing.JPanel();
        X = new javax.swing.JSpinner();
        Y = new javax.swing.JSpinner();
        Z = new javax.swing.JSpinner();
        Ratio = new javax.swing.JSpinner();
        printButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        rotate = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jsp = new javax.swing.JScrollPane();
        ViewPanel = new javax.swing.JPanel();

        conPanel.setName("conPanel"); // NOI18N

        X.setModel(new javax.swing.SpinnerNumberModel(100, 2, 1000, 1));
        X.setName("X"); // NOI18N
        X.setValue(100);
        X.setVerifyInputWhenFocusTarget(false);
        X.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                XStateChanged(evt);
            }
        });

        Y.setModel(new javax.swing.SpinnerNumberModel(200, 2, 1000, 1));
        Y.setName("Y"); // NOI18N
        Y.setValue(200);
        Y.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                YStateChanged(evt);
            }
        });

        Z.setModel(new javax.swing.SpinnerNumberModel(150, 2, 1000, 1));
        Z.setName("Z"); // NOI18N
        Z.setValue(150);
        Z.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                ZStateChanged(evt);
            }
        });

        Ratio.setModel(new javax.swing.SpinnerNumberModel(100, 1, 100, 1));
        Ratio.setName("Ratio"); // NOI18N
        Ratio.setValue(100);
        Ratio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RatioStateChanged(evt);
            }
        });

        printButton.setText("Print");
        printButton.setName("printButton"); // NOI18N

        jButton1.setText("Hexer");
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        rotate.setText("R");
        rotate.setToolTipText("Rotate");
        rotate.setName("rotate"); // NOI18N
        rotate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rotateMouseClicked(evt);
            }
        });

        jButton2.setText("R");
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout conPanelLayout = new javax.swing.GroupLayout(conPanel);
        conPanel.setLayout(conPanelLayout);
        conPanelLayout.setHorizontalGroup(
            conPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conPanelLayout.createSequentialGroup()
                .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Y, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Z, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ratio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rotate, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        conPanelLayout.setVerticalGroup(
            conPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(conPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Y, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Z, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Ratio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(printButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1)
                .addComponent(rotate, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2))
        );

        printButton.addActionListener(new BoxPrinter());

        add(conPanel, java.awt.BorderLayout.PAGE_START);

        jsp.setToolTipText("jsp");
        jsp.setName("jsp"); // NOI18N

        ViewPanel.setBackground(new java.awt.Color(0, 0, 0));
        ViewPanel.setToolTipText("ViewPanel");
        ViewPanel.setName("ViewPanel"); // NOI18N
        ViewPanel.setOpaque(false);

        javax.swing.GroupLayout ViewPanelLayout = new javax.swing.GroupLayout(ViewPanel);
        ViewPanel.setLayout(ViewPanelLayout);
        ViewPanelLayout.setHorizontalGroup(
            ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
        );
        ViewPanelLayout.setVerticalGroup(
            ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 582, Short.MAX_VALUE)
        );

        jsp.setViewportView(ViewPanel);

        add(jsp, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

  private void XStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_XStateChanged
    update();
  }//GEN-LAST:event_XStateChanged

  private void YStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_YStateChanged
    update();
  }//GEN-LAST:event_YStateChanged

  private void ZStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_ZStateChanged
    update();
  }//GEN-LAST:event_ZStateChanged

  private void RatioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RatioStateChanged
    update();
  }//GEN-LAST:event_RatioStateChanged

  private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
    String[] args = null;
    Hexer.main(args);
  }//GEN-LAST:event_jButton1MouseClicked

  private void rotateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rotateMouseClicked
//    for (int i = 0; i < 6; i++) {
//      panels[i].setVisible(!panels[i].isVisible());
//    }
//    rotate(getActive());
    Image image = labels[getActive()].createImage(100, 100);
    AffineTransform start = g2.getTransform();
    start.setToTranslation(labels[0].getX() + 1, labels[0].getY() + 28);
//    start.setToQuadrantRotation(2);
    start.rotate(Math.toRadians(90), image.getWidth(this) / 2, image.getHeight(
      this) / 2);
    g2.drawImage(image, start, this);
  }//GEN-LAST:event_rotateMouseClicked

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    rotate(getActive());
    repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JSpinner Ratio;
    private static javax.swing.JPanel ViewPanel;
    private static javax.swing.JSpinner X;
    private static javax.swing.JSpinner Y;
    private static javax.swing.JSpinner Z;
    private javax.swing.JPanel conPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jsp;
    private static javax.swing.JButton printButton;
    private javax.swing.JButton rotate;
    // End of variables declaration//GEN-END:variables
}
