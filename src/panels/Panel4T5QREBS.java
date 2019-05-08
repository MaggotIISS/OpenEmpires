/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package panels;

import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalVariables.CRLF;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 <p>
 @author Mark Ferguson
 */
public class Panel4T5QREBS extends javax.swing.JPanel {

  private static final ActionEvent ae = null;
  private static int[] nums;
  private static final JTextField[] jtfs = new JTextField[5];
  private static final String[] lets = {"Q", "R", "E", "B", "S"};
  private static int total = 0;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    JPanel jp = new Panel4T5QREBS();
    JFrame jf = new Frame4(jp);
    jf.setPreferredSize(new Dimension(600, 400));
    jf.setSize(jf.getPreferredSize());
    setQREBS("3 3 3 -3 3");
    //randomize();
  }

  private static void toQREBS() {
    jTextField6.setText(jTextField1.getText() + " " + jTextField2.getText()
      + " " + jTextField3.getText() + " " + jTextField4.getText() + " "
      + jTextField5.getText());
    jTextArea1.setText("QREBS" + CRLF);
    jTextArea1.append(jTextField6.getText() + CRLF);
    String[] labs = {
      jLabel1.getText(),
      jLabel2.getText(),
      jLabel3.getText(),
      jLabel4.getText(),
      jLabel5.getText(),
      jLabel6.getText(),
      jLabel7.getText(),
      jLabel8.getText()
    };
    String[] vals = {
      jLabel9.getText(),
      jLabel10.getText(),
      jLabel11.getText(),
      jLabel12.getText(),
      jLabel13.getText(),
      jLabel14.getText(),
      jLabel15.getText(),
      jLabel16.getText()
    };

    for (int i = 0; i < 8; i++) {
      jTextArea1.append(labs[i] + " = " + vals[i] + CRLF);
    }
    total = 0;
    countPoints();
    jTextArea1.append("Bonus = " + total + CRLF);
  }

  /**
   Creates new form Panel4T5QREBS
   */
  public Panel4T5QREBS() {
    this.nums = new int[5];
    jtfs[0] = jTextField1;
    jtfs[1] = jTextField2;
    jtfs[2] = jTextField3;
    jtfs[3] = jTextField4;
    jtfs[4] = jTextField5;
    initComponents();
    toQREBS();
  }

  /**
   setQREBS
   */
  public static void setQREBS() {
    clickButton("Q");
    clickButton("R");
    clickButton("E");
    clickButton("B");
    clickButton("S");
  }

  /**
   <p>
   @param s String to set QREBS
   */
  public static void setQREBS(String s) {
    try {
      String[] qrebs = s.split(" ");
      jTextField1.setText(qrebs[0]);
      jTextField2.setText(qrebs[1]);
      jTextField3.setText(qrebs[2]);
      jTextField4.setText(qrebs[3]);
      jTextField5.setText(qrebs[4]);
      clickButton("Q");
      clickButton("R");
      clickButton("E");
      clickButton("B");
      clickButton("S");
    } catch (Exception e) {
      System.out.println("exception e" + " = " + e);
      System.out.println("s" + " = " + s);
    }
    setQREBS();
  }

  /**
   <p>
   @return String for QREBS
   */
  public static String getQREBS() {
    return "" + jTextField1.getText() + jTextField2.getText() + jTextField3
      .getText() + jTextField4.getText() + jTextField5.getText();
  }

  /**
   randomize
   */
  public static void randomize() {
    //setQREBS();
    JTextField[] jtfs = {jTextField1, jTextField2, jTextField3, jTextField4,
      jTextField5};
    for (int i = 0; i < 5; i++) {
      int num = GlobalMethods.rollFlux();
      jtfs[i].setText("" + num);
    }
    getQREBS();
  }

  private static void clickButton(String q) {
    JTextField jtf = new JTextField();
    int num = GlobalMethods.rollFlux();
    String txt = "";
    switch (q) {
      case "Q": {
//        jLabel9.setText("" + (num + 5));
        jtf = jTextField1;
        break;
      }
      case "R": {
        jtf = jTextField2;
        break;
      }
      case "E": {
        jtf = jTextField3;
        break;
      }
      case "B": {
        jtf = jTextField4;
        break;
      }
      case "S": {
        jtf = jTextField5;
        break;
      }
    }
    jtf.setText("" + num);
    updateText(q);
    toQREBS();
  }

  private static void updateText(String q) {
    String txt = null;
    int num;
    switch (q) {
      case "Q": {
        num = Integer.parseInt(jTextField1.getText());
        jLabel9.setText("" + (num + 5));
        //<editor-fold defaultstate="collapsed" desc="switch (num + 5) {">
        switch (num + 5) {
          case 0: {
            jLabel10.setText("Very bad");
            jLabel11.setText("-5");
            jLabel12.setText("Minutes");
            break;
          }
          case 1: {
            jLabel10.setText("Bad");
            jLabel11.setText("-4");
            jLabel12.setText("Hours");
            break;
          }
          case 2: {
            jLabel10.setText("Poor");
            jLabel11.setText("-3");
            jLabel12.setText("Days");
            break;
          }
          case 3: {
            jLabel10.setText("Lesser");
            jLabel11.setText("-2");
            jLabel12.setText("Weeks");
            break;
          }
          case 4: {
            jLabel10.setText("Below avg");
            jLabel11.setText("-1");
            jLabel12.setText("Months");
            break;
          }
          case 5: {
            jLabel10.setText("Average");
            jLabel11.setText("0");
            jLabel12.setText("6 Months");
            break;
          }
          case 6: {
            jLabel10.setText("Better than some");
            jLabel11.setText("+1");
            jLabel12.setText("1 Year");
            break;
          }
          case 7: {
            jLabel10.setText("Better than many");
            jLabel11.setText("+2");
            jLabel12.setText("2 Years");
            break;
          }
          case 8: {
            jLabel10.setText("Very Good");
            jLabel11.setText("+3");
            jLabel12.setText("3 Years");
            break;
          }
          case 9: {
            jLabel10.setText("Better than most");
            jLabel11.setText("+4");
            jLabel12.setText("4 Years");
            break;
          }
          case 10: {
            jLabel10.setText("Excellent");
            jLabel11.setText("+5");
            jLabel12.setText("10 Years");
            break;
          }
          case 11: {
            jLabel10.setText("Superb");
            jLabel11.setText("+6");
            jLabel12.setText("20 Years");
            break;
          }
          case 12: {
            jLabel10.setText("Masterpiece");
            jLabel11.setText("+7");
            jLabel12.setText("Centuries");
            break;
          }
        }
        //</editor-fold>
        break;
      }
      case "R": {
        num = Integer.parseInt(jTextField2.getText());
        //<editor-fold defaultstate="collapsed" desc="switch (num) {">
        switch (num) {
          case -5: {
            txt = "Very unreliable";
            break;
          }
          case -4: {
            txt = "More unreliable";
            break;
          }
          case -3: {
            txt = "Unreliable";
            break;
          }
          case -2: {
            txt = "Somewhat unreliable";
            break;
          }
          case -1: {
            txt = "Slightly unreliable";
            break;
          }
          case 0: {
            txt = "Reliability neutral";
            break;
          }
          case 1: {
            txt = "Better than some";
            break;
          }
          case 2: {
            txt = "Better than many";
            break;
          }
          case 3: {
            txt = "Reliable";
            break;
          }
          case 4: {
            txt = "More reliable";
            break;
          }
          case 5: {
            txt = "Very reliable";
            break;
          }
        }
        //</editor-fold>
        jLabel13.setText("" + txt);
        break;
      }
      case "E": {
        num = Integer.parseInt(jTextField3.getText());
        //<editor-fold defaultstate="collapsed" desc="switch (num) {">
        switch (num) {
          case -5: {
            txt = "Very difficult to use";
            break;
          }
          case -4: {
            txt = "More difficult to use";
            break;
          }
          case -3: {
            txt = "Hard to use";
            break;
          }
          case -2: {
            txt = "Somewhat hard to use";
            break;
          }
          case -1: {
            txt = "Slightly difficult to use";
            break;
          }
          case 0: {
            txt = "Ease of use neutral";
            break;
          }
          case 1: {
            txt = "Better than some";
            break;
          }
          case 2: {
            txt = "Better than many";
            break;
          }
          case 3: {
            txt = "Easy to use";
            break;
          }
          case 4: {
            txt = "Easier to use";
            break;
          }
          case 5: {
            txt = "Very easy to use";
            break;
          }
        }
        //</editor-fold>
        jLabel14.setText("" + txt);
        break;
      }
      case "B": {
        num = Integer.parseInt(jTextField4.getText());
        //<editor-fold defaultstate="collapsed" desc="switch (num) {">
        switch (num) {
          case -5: {
            txt = "Very easy to handle";
            break;
          }
          case -4: {
            txt = "Easier to handle";
            break;
          }
          case -3: {
            txt = "Easy to handle";
            break;
          }
          case -2: {
            txt = "Better than many";
            break;
          }
          case -1: {
            txt = "Better than some";
            break;
          }
          case 0: {
            txt = "Burden neutral";
            break;
          }
          case 1: {
            txt = "Slightly unergonomic";
            break;
          }
          case 2: {
            txt = "unwieldy";
            break;
          }
          case 3: {
            txt = "Hard to handle";
            break;
          }
          case 4: {
            txt = "More burdensome";
            break;
          }
          case 5: {
            txt = "Very burdensome";
            break;
          }
        }
        //</editor-fold>
        jLabel15.setText("" + txt);
        break;
      }
      case "S": {
        num = Integer.parseInt(jTextField5.getText());
        //<editor-fold defaultstate="collapsed" desc="switch (num) {">
        switch (num) {
          case -5: {
            txt = "Very hazardous";
            break;
          }
          case -4: {
            txt = "More hazardous";
            break;
          }
          case -3: {
            txt = "Hazardous";
            break;
          }
          case -2: {
            txt = "Somewhat hazardous";
            break;
          }
          case -1: {
            txt = "Slightly hazardous";
            break;
          }
          case 0: {
            txt = "Safety neutral";
            break;
          }
          case 1: {
            txt = "Better than some";
            break;
          }
          case 2: {
            txt = "Better than many";
            break;
          }
          case 3: {
            txt = "Safe to use";
            break;
          }
          case 4: {
            txt = "Safer to use";
            break;
          }
          case 5: {
            txt = "Very safe";
            break;
          }
        }
        //</editor-fold>
        jLabel16.setText("" + txt);
        break;
      }
    }
  }

  private static void setTexts() {
    jTextField1.setText("" + nums[0]);
    jTextField2.setText("" + nums[1]);
    jTextField3.setText("" + nums[2]);
    jTextField4.setText("" + nums[3]);
    jTextField5.setText("" + nums[4]);
  }

  private static void countPoints() {
    JTextField[] jtf = {jTextField1, jTextField2, jTextField3, jTextField4,
      jTextField5};
    int pts = 0;
    for (int i = 0; i < 5; i++) {
      pts = Integer.parseInt(jtf[i].getText());
      if (i == 3) {
        pts = -pts;
      }
      total += pts;
    }
    System.out.println("point value" + " = " + total);
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
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jButton5 = new javax.swing.JButton();
    jTextField1 = new javax.swing.JTextField();
    jTextField2 = new javax.swing.JTextField();
    jTextField3 = new javax.swing.JTextField();
    jTextField4 = new javax.swing.JTextField();
    jTextField5 = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();
    jTextField6 = new javax.swing.JTextField();
    jButton6 = new javax.swing.JButton();
    jButton7 = new javax.swing.JButton();
    jButton8 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();

    setBackground(new java.awt.Color(0, 0, 0));
    setForeground(new java.awt.Color(255, 255, 255));

    jButton1.setText("Q");
    jButton1.setToolTipText("Quality");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setText("R");
    jButton2.setToolTipText("Reliability");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jButton3.setText("E");
    jButton3.setToolTipText("Ease of use");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jButton4.setText("B");
    jButton4.setToolTipText("Burden");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    jButton5.setText("S");
    jButton5.setToolTipText("Safety");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton5ActionPerformed(evt);
      }
    });

    jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    jTextField1.setText("0");
    jTextField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jTextField1PropertyChange(evt);
      }
    });

    jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    jTextField2.setText("0");
    jTextField2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jTextField2PropertyChange(evt);
      }
    });

    jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    jTextField3.setText("0");
    jTextField3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jTextField3PropertyChange(evt);
      }
    });

    jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    jTextField4.setText("0");
    jTextField4.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jTextField4PropertyChange(evt);
      }
    });

    jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    jTextField5.setText("0");
    jTextField5.setToolTipText("");
    jTextField5.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jTextField5PropertyChange(evt);
      }
    });

    jLabel1.setBackground(new java.awt.Color(0, 0, 0));
    jLabel1.setForeground(java.awt.Color.lightGray);
    jLabel1.setText("Quality");
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    jLabel2.setBackground(new java.awt.Color(0, 0, 0));
    jLabel2.setForeground(java.awt.Color.lightGray);
    jLabel2.setText("  Description");
    jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel2MouseClicked(evt);
      }
    });

    jLabel3.setBackground(new java.awt.Color(0, 0, 0));
    jLabel3.setForeground(java.awt.Color.lightGray);
    jLabel3.setText("  Mod");
    jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel3MouseClicked(evt);
      }
    });

    jLabel4.setBackground(new java.awt.Color(0, 0, 0));
    jLabel4.setForeground(java.awt.Color.lightGray);
    jLabel4.setText("  Period");
    jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel4MouseClicked(evt);
      }
    });

    jLabel5.setBackground(new java.awt.Color(0, 0, 0));
    jLabel5.setForeground(java.awt.Color.lightGray);
    jLabel5.setText("Reliability");
    jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel5MouseClicked(evt);
      }
    });

    jLabel6.setBackground(new java.awt.Color(0, 0, 0));
    jLabel6.setForeground(java.awt.Color.lightGray);
    jLabel6.setText("Ease of use");
    jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel6MouseClicked(evt);
      }
    });

    jLabel7.setBackground(new java.awt.Color(0, 0, 0));
    jLabel7.setForeground(java.awt.Color.lightGray);
    jLabel7.setText("Burden");
    jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel7MouseClicked(evt);
      }
    });

    jLabel8.setBackground(new java.awt.Color(0, 0, 0));
    jLabel8.setForeground(java.awt.Color.lightGray);
    jLabel8.setText("Safety");
    jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel8MouseClicked(evt);
      }
    });

    jLabel9.setBackground(new java.awt.Color(0, 0, 0));
    jLabel9.setForeground(java.awt.Color.lightGray);
    jLabel9.setText("jLabel9");
    jLabel9.setToolTipText("jLabel9");

    jLabel10.setBackground(new java.awt.Color(0, 0, 0));
    jLabel10.setForeground(java.awt.Color.lightGray);
    jLabel10.setText("jLabell10");
    jLabel10.setToolTipText("jLabell10");

    jLabel11.setBackground(new java.awt.Color(0, 0, 0));
    jLabel11.setForeground(java.awt.Color.lightGray);
    jLabel11.setText("jLabel11");
    jLabel11.setToolTipText("jLabel11");

    jLabel12.setBackground(new java.awt.Color(0, 0, 0));
    jLabel12.setForeground(java.awt.Color.lightGray);
    jLabel12.setText("jLabel12");
    jLabel12.setToolTipText("jLabel12");

    jLabel13.setBackground(new java.awt.Color(0, 0, 0));
    jLabel13.setForeground(java.awt.Color.lightGray);
    jLabel13.setText("jLabel13");
    jLabel13.setToolTipText("jLabel13");

    jLabel14.setBackground(new java.awt.Color(0, 0, 0));
    jLabel14.setForeground(java.awt.Color.lightGray);
    jLabel14.setText("jLabel14");
    jLabel14.setToolTipText("jLabel14");

    jLabel15.setBackground(new java.awt.Color(0, 0, 0));
    jLabel15.setForeground(java.awt.Color.lightGray);
    jLabel15.setText("jLabel15");
    jLabel15.setToolTipText("jLabel15");

    jLabel16.setBackground(new java.awt.Color(0, 0, 0));
    jLabel16.setForeground(java.awt.Color.lightGray);
    jLabel16.setText("jLabel16");
    jLabel16.setToolTipText("jLabel16");

    jTextField6.setBackground(new java.awt.Color(0, 0, 0));
    jTextField6.setForeground(java.awt.Color.lightGray);
    jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);

    jButton6.setText("Good");
    jButton6.setToolTipText("Good");
    jButton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton6ActionPerformed(evt);
      }
    });

    jButton7.setText("Bad");
    jButton7.setToolTipText("Bad");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton7ActionPerformed(evt);
      }
    });

    jButton8.setText("Flux");
    jButton8.setToolTipText("Flux");
    jButton8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton8ActionPerformed(evt);
      }
    });

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel1)
                  .addComponent(jLabel2)
                  .addComponent(jLabel3)
                  .addComponent(jLabel4)
                  .addComponent(jLabel5)
                  .addComponent(jLabel6)
                  .addComponent(jLabel7)
                  .addComponent(jLabel8))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                  .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
          .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
        .addContainerGap())
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jTextField1, jTextField2, jTextField3, jTextField4, jTextField5});

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton6, jButton7, jButton8});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jButton1)
              .addComponent(jButton2)
              .addComponent(jButton3)
              .addComponent(jButton4)
              .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel1)
              .addComponent(jLabel9)
              .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel2)
              .addComponent(jLabel10)
              .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel3)
              .addComponent(jLabel11)
              .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel4)
              .addComponent(jLabel12))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel5)
              .addComponent(jLabel13))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel6)
              .addComponent(jLabel14))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel15)
              .addComponent(jLabel7))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel8)
              .addComponent(jLabel16))
            .addGap(25, 25, 25)
            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1)))
        .addGap(0, 0, 0))
    );

    layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jTextField1, jTextField2, jTextField3, jTextField4, jTextField5});

  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    clickButton("Q");
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    clickButton("R");
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    clickButton("E");
  }//GEN-LAST:event_jButton3ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    clickButton("B");
  }//GEN-LAST:event_jButton4ActionPerformed

  private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    clickButton("S");
  }//GEN-LAST:event_jButton5ActionPerformed

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_jLabel1MouseClicked

  private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_jLabel2MouseClicked

  private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_jLabel3MouseClicked

  private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_jLabel4MouseClicked

  private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_jLabel5MouseClicked

  private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_jLabel6MouseClicked

  private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_jLabel7MouseClicked

  private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_jLabel8MouseClicked

  private void jTextField1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField1PropertyChange
    // TODO add your handling code here:
    updateText("Q");
  }//GEN-LAST:event_jTextField1PropertyChange

  private void jTextField2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField2PropertyChange
    // TODO add your handling code here:
    updateText("R");
  }//GEN-LAST:event_jTextField2PropertyChange

  private void jTextField3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField3PropertyChange
    // TODO add your handling code here:
    updateText("E");
  }//GEN-LAST:event_jTextField3PropertyChange

  private void jTextField4PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField4PropertyChange
    // TODO add your handling code here:
    updateText("B");
  }//GEN-LAST:event_jTextField4PropertyChange

  private void jTextField5PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField5PropertyChange
    // TODO add your handling code here:
    updateText("S");
  }//GEN-LAST:event_jTextField5PropertyChange

  private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    for (int i = 0; i < 5; i++) {
      nums[i] = GlobalMethods.rollGoodFlux();
      if (i == 3) {
        nums[i] = -nums[i];
      }
      setTexts();
      updateText(lets[i]);
    }
    toQREBS();
  }//GEN-LAST:event_jButton6ActionPerformed

  private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    for (int i = 0; i < 5; i++) {
      nums[i] = GlobalMethods.rollBadFlux();
      if (i == 3) {
        nums[i] = -nums[i];
      }
      setTexts();
      updateText(lets[i]);
    }
    toQREBS();
  }//GEN-LAST:event_jButton7ActionPerformed

  private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    for (int i = 0; i < 5; i++) {
      nums[i] = GlobalMethods.rollFlux();
      if (i == 3) {
        nums[i] = -nums[i];
      }
      setTexts();
      updateText(lets[i]);
    }
    toQREBS();
  }//GEN-LAST:event_jButton8ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private static javax.swing.JButton jButton1;
  private static javax.swing.JButton jButton2;
  private static javax.swing.JButton jButton3;
  private static javax.swing.JButton jButton4;
  private static javax.swing.JButton jButton5;
  private static javax.swing.JButton jButton6;
  private static javax.swing.JButton jButton7;
  private static javax.swing.JButton jButton8;
  private static javax.swing.JLabel jLabel1;
  private static javax.swing.JLabel jLabel10;
  private static javax.swing.JLabel jLabel11;
  private static javax.swing.JLabel jLabel12;
  private static javax.swing.JLabel jLabel13;
  private static javax.swing.JLabel jLabel14;
  private static javax.swing.JLabel jLabel15;
  private static javax.swing.JLabel jLabel16;
  private static javax.swing.JLabel jLabel2;
  private static javax.swing.JLabel jLabel3;
  private static javax.swing.JLabel jLabel4;
  private static javax.swing.JLabel jLabel5;
  private static javax.swing.JLabel jLabel6;
  private static javax.swing.JLabel jLabel7;
  private static javax.swing.JLabel jLabel8;
  private static javax.swing.JLabel jLabel9;
  private javax.swing.JScrollPane jScrollPane1;
  private static javax.swing.JTextArea jTextArea1;
  private static javax.swing.JTextField jTextField1;
  private static javax.swing.JTextField jTextField2;
  private static javax.swing.JTextField jTextField3;
  private static javax.swing.JTextField jTextField4;
  private static javax.swing.JTextField jTextField5;
  private static javax.swing.JTextField jTextField6;
  // End of variables declaration//GEN-END:variables

}
