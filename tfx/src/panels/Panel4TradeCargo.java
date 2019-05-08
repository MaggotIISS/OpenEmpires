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

import dbviewer.globals.CTTradeSpec;
import dbviewer.globals.GlobalMethods;
import dbviewer.globals.GlobalVariables;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 <p>
 @author maggot
 */
public class Panel4TradeCargo extends javax.swing.JPanel {

  /**
   JPanel
   */
  public static JPanel p4tc;
  /**
   JFrame
   */
  public static JFrame jf;
  /**
   start
   */
  public static String start;
  private String saledm;
  Panel4Mining p4m = new Panel4Mining();

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
//</editor-fold>
    p4tc = new Panel4TradeCargo();
    jf = new Frame4(p4tc, "TradeCargo");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setSize((int) jf.getSize().getWidth() * 7 / 10, (int) jf.getSize()
      .getHeight() / 2);
//    test();
    start = "Panel4TradeCargo";
  }

  /**
   <p>
   @param toString String to setTitle
   */
  public static void setTitle(String toString) {
    if (toString != null) {
      Panel4SubSector.getFrame4Trade().setTitle(toString);
    }
  }

  /**
   setMining
   */
  public static void setMining() {
    int a = Integer.parseInt(Panel4SubSector.jcb4PAG.getSelectedItem()
      .toString().substring(1, 2));
//    if (a > 0) {
    Mining.setEnabled(true);
    jLabel7.setEnabled(true);
    jLabel8.setEnabled(true);
    jLabel10.setEnabled(true);
    Intelligence.setEnabled(true);
    Prospecting.setEnabled(true);
    Pilot.setEnabled(true);
//    } else {
//      Mining.setEnabled(false);
//      jLabel7.setEnabled(false);
//      jLabel8.setEnabled(false);
//      jLabel10.setEnabled(false);
//      Intelligence.setEnabled(false);
//      Prospecting.setEnabled(false);
//      Pilot.setEnabled(false);
//    }
  }

  /**
   Creates new form Panel4TradeCargo
   */
  public Panel4TradeCargo() {
    super();
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
//</editor-fold>
    initComponents();
    try {
      jtf1.setText(Panel4SubSector.last2 + "(" + Panel4SubSector.jcb4Trade
        .getSelectedItem().toString() + ")");
    } catch (java.lang.NullPointerException e) {
      jtf1.setText("");
    }
    jtf1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String buyWorld = Panel4SubSector.jList1.getSelectedValue().toString()
          + "(" + Panel4SubSector.jcb4Trade.getSelectedItem().toString() + ")";
        String sellWorld = Panel4SubSector.jList2.getSelectedValue().toString()
          + "(" + Panel4SubSector.jcb4Trade.getSelectedItem().toString() + ")";
        //System.out.print("buyWorld" + " = " + buyWorld);
        //System.out.print("sellWorld" + " = " + sellWorld);
      }
    });

    repaint();
  }

  /**
   <p>
   @param string strings to start
   */
  public Panel4TradeCargo(String string) {
    this();
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
//</editor-fold>
    jtf1.setText(string);
  }

  /**
   <p>
   @return result of 2D roll
   */
  public static int roll2Die() {
    int x = (int) (Math.random() * 6) + 1;
    x += (int) (Math.random() * 6) + 1;
    return x;
  }

  /**
   @return the cargos
   */
  public static String getCargo() {
    return cargos;
  }

  /**
   @param aCargos the cargos to set
   */
  public static void setCargo(String aCargos) {
    cargos = aCargos;
  }

  /**
   <p>
   @return string containing cash amount available
   */
  public String getBank() {
    return lbank.getText();
  }

  /**
   calc
   */
  public void calc() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
//</editor-fold>
    shorten(lbank);
    shorten(lexpense);
    shorten(ltotal);
    shorten(lhold);
    shorten(lcargo);
    shorten(lempty);
    ibank = Double.parseDouble(lbank.getText());
    iexpense = Double.parseDouble(lexpense.getText());
    itotal = ibank - iexpense; //Double.parseDouble(ltotal.getText());
    ltotal.setText("" + itotal);
    lexpense.setText("0.0");
    lbank.setText("" + itotal);
//    jta.append("ibank" + " = " + ibank + CRLF);
//    jta.append("lbank.getText()" + " = " + lbank.getText() + CRLF);
//    jta.append("iexpense" + " = " + iexpense + CRLF);
//    jta.append("lexpense.getText()" + " = " + lexpense.getText() + CRLF);
//    jta.append("itotal" + " = " + itotal + CRLF);
//    jta.append("ltotal.getText()" + " = " + ltotal.getText() + CRLF);
//    jta.append("" + CRLF);

    ihold = Double.parseDouble(lhold.getText());
//    jta.append("ihold" + " = " + ihold + CRLF);
//    jta.append("lhold.getText()" + " = " + lhold.getText() + CRLF);
    icargo = Double.parseDouble(lcargo.getText());
//    jta.append("icargo" + " = " + icargo + CRLF);
//    jta.append("lcargo.getText()" + " = " + lcargo.getText() + CRLF);
    iempty = ihold - icargo;//Double.parseDouble(lempty.getText());
    lempty.setText("" + iempty);
    lcargo.setText("" + icargo);
//    jta.append("iempty" + " = " + iempty + CRLF);
//    jta.append("lempty.getText()" + " = " + lempty.getText() + CRLF);
//    jta.append("" + CRLF);
    //calc();
  }

  /**
   reset
   */
  public void reset() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
//</editor-fold>
    lbank.setText("1000.0");
    lexpense.setText("0.0 ");
    //lhold.setText("30.0");
    lcargo.setText("0.0");
    jsnum.setValue(0.0);
    calc();
    //jta.append("");
    inventory = "";
    dtons = 0;
    freight = 0;
    mail = 0;
    jta.setText("");
    Mining.setEnabled(true);
  }

  /**
   updateFrom
   */
  public void updateFrom() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
//</editor-fold>
    setTitle(jtf1.getText());
  }

  /**
   updateTo
   */
  public void updateTo() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
//</editor-fold>
    //jf.setTitle(jtf1.getText());
    jtf1.setText(Panel4SubSector.jList2.getSelectedValue().toString());
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jtf1 = new javax.swing.JTextField();
    jScrollPaneR = new javax.swing.JScrollPane();
    jta = new javax.swing.JTextArea();
    jScrollPaneL = new javax.swing.JScrollPane();
    jPanel1 = new javax.swing.JPanel();
    jsnum = new javax.swing.JSpinner();
    jPanel2 = new javax.swing.JPanel();
    lkcr = new javax.swing.JLabel();
    lexpense = new javax.swing.JLabel();
    lbank = new javax.swing.JLabel();
    ltotal = new javax.swing.JLabel();
    hold = new javax.swing.JLabel();
    lhold = new javax.swing.JLabel();
    used = new javax.swing.JLabel();
    lcargo = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    empty = new javax.swing.JLabel();
    lempty = new javax.swing.JLabel();
    in = new javax.swing.JLabel();
    out = new javax.swing.JLabel();
    total = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    Broker = new javax.swing.JTextField();
    Admin = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    Bribery = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    Intelligence = new javax.swing.JTextField();
    Prospecting = new javax.swing.JTextField();
    jLabel8 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    Pilot = new javax.swing.JTextField();

    setLayout(new java.awt.BorderLayout());

    jtf1.setText("Destination");
    jtf1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jtf1ActionPerformed(evt);
      }
    });
    add(jtf1, java.awt.BorderLayout.PAGE_START);

    jta.setColumns(15);
    jta.setRows(5);
    jScrollPaneR.setViewportView(jta);

    add(jScrollPaneR, java.awt.BorderLayout.LINE_END);

    jList1.setModel(new javax.swing.AbstractListModel() {
      String[] strings = { "Mail", "Browse", "Buy", "Freight", "Inventory", "Broker", " ", "Reset" };
      public int getSize() { return strings.length; }
      public Object getElementAt(int i) { return strings[i]; }
    });
    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        jList1MouseReleased(evt);
      }
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList1MouseClicked(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jList1MousePressed(evt);
      }
    });
    jScrollPaneL.setViewportView(jList1);

    add(jScrollPaneL, java.awt.BorderLayout.LINE_START);

    jPanel1.setLayout(new java.awt.BorderLayout());

    jsnum.setEditor(new javax.swing.JSpinner.NumberEditor(jsnum, ""));
    jsnum.setValue(0.0);
    jPanel1.add(jsnum, java.awt.BorderLayout.PAGE_START);

    jPanel2.setBackground(java.awt.Color.black);
    jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jPanel2MouseClicked(evt);
      }
    });

    lkcr.setForeground(java.awt.Color.lightGray);
    lkcr.setText("KCr");

    lexpense.setForeground(java.awt.Color.lightGray);
    lexpense.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lexpense.setLabelFor(lexpense);
    lexpense.setText("0.0");
    lexpense.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    lexpense.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        lexpenseMouseClicked(evt);
      }
    });

    lbank.setForeground(java.awt.Color.lightGray);
    lbank.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lbank.setLabelFor(lbank);
    lbank.setText("1000.0");
    lbank.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    lbank.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        lbankMouseClicked(evt);
      }
    });

    ltotal.setForeground(java.awt.Color.lightGray);
    ltotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    ltotal.setLabelFor(ltotal);
    ltotal.setText("1000.0");
    ltotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    ltotal.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        ltotalMouseClicked(evt);
      }
    });

    hold.setForeground(new java.awt.Color(0, 255, 0));
    hold.setText("Hold");
    hold.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        holdMouseClicked(evt);
      }
    });

    lhold.setForeground(java.awt.Color.lightGray);
    lhold.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lhold.setLabelFor(lhold);
    lhold.setText("30.0");
    lhold.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    lhold.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        lholdMouseClicked(evt);
      }
    });

    used.setForeground(new java.awt.Color(0, 255, 0));
    used.setText("Cargo");
    used.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        usedMouseClicked(evt);
      }
    });

    lcargo.setForeground(java.awt.Color.lightGray);
    lcargo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lcargo.setLabelFor(lcargo);
    lcargo.setText("0.0");
    lcargo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    lcargo.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        lcargoMouseClicked(evt);
      }
    });

    jLabel2.setBackground(new java.awt.Color(0, 0, 0));
    jLabel2.setFocusable(false);
    jLabel2.setIconTextGap(0);
    jLabel2.setOpaque(true);

    empty.setForeground(java.awt.Color.lightGray);
    empty.setText("Empty");
    empty.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        emptyMouseClicked(evt);
      }
    });

    lempty.setForeground(java.awt.Color.lightGray);
    lempty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    lempty.setLabelFor(lempty);
    lempty.setText("0.0");
    lempty.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    lempty.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        lemptyMouseClicked(evt);
      }
    });
    lempty.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        lemptyPropertyChange(evt);
      }
    });

    in.setForeground(new java.awt.Color(0, 255, 0));
    in.setText("Bank");
    in.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        inMouseClicked(evt);
      }
    });

    out.setForeground(new java.awt.Color(0, 255, 0));
    out.setText("Expense");
    out.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        outMouseClicked(evt);
      }
    });

    total.setForeground(java.awt.Color.lightGray);
    total.setText("Total");
    total.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        totalMouseClicked(evt);
      }
    });

    jLabel9.setForeground(java.awt.Color.lightGray);
    jLabel9.setText("DTons");

    jLabel3.setBackground(new java.awt.Color(0, 0, 0));
    jLabel3.setFocusable(false);
    jLabel3.setOpaque(true);

    jLabel4.setBackground(new java.awt.Color(0, 0, 0));
    jLabel4.setFocusable(false);
    jLabel4.setOpaque(true);

    jLabel1.setForeground(new java.awt.Color(0, 255, 0));
    jLabel1.setText("Broker");
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel1MouseClicked(evt);
      }
    });

    Broker.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    Broker.setText("2");
    Broker.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BrokerActionPerformed(evt);
      }
    });

    Admin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    Admin.setText("0");
    Admin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        AdminActionPerformed(evt);
      }
    });

    jLabel5.setForeground(new java.awt.Color(0, 255, 0));
    jLabel5.setText("Admin");
    jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel5MouseClicked(evt);
      }
    });

    Bribery.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    Bribery.setText("0");
    Bribery.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BriberyActionPerformed(evt);
      }
    });

    jLabel6.setForeground(new java.awt.Color(0, 255, 0));
    jLabel6.setText("Bribery");
    jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel6MouseClicked(evt);
      }
    });

    Mining.setForeground(java.awt.Color.lightGray);
    Mining.setText("Mining");
    Mining.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        MiningActionPerformed(evt);
      }
    });

    jLabel7.setForeground(java.awt.Color.lightGray);
    jLabel7.setText("Intelligence");
    jLabel7.setEnabled(false);
    jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel7MouseClicked(evt);
      }
    });

    Intelligence.setForeground(java.awt.Color.lightGray);
    Intelligence.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    Intelligence.setText("8");
    Intelligence.setEnabled(false);
    Intelligence.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        IntelligenceActionPerformed(evt);
      }
    });

    Prospecting.setForeground(java.awt.Color.lightGray);
    Prospecting.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    Prospecting.setText("0");
    Prospecting.setEnabled(false);
    Prospecting.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ProspectingActionPerformed(evt);
      }
    });

    jLabel8.setForeground(java.awt.Color.lightGray);
    jLabel8.setText("Prospecting");
    jLabel8.setEnabled(false);
    jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel8MouseClicked(evt);
      }
    });

    jLabel10.setForeground(java.awt.Color.lightGray);
    jLabel10.setText("Pilot");
    jLabel10.setEnabled(false);
    jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel10MouseClicked(evt);
      }
    });

    Pilot.setForeground(java.awt.Color.lightGray);
    Pilot.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    Pilot.setText("0");
    Pilot.setEnabled(false);
    Pilot.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        PilotActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(total)
              .addComponent(out)
              .addComponent(in))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(ltotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(lexpense, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(lbank, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addComponent(Mining)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
            .addComponent(lkcr)))
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(empty)
              .addComponent(used)
              .addComponent(hold))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(lhold, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
              .addComponent(lcargo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(lempty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(8, 8, 8))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9)
            .addContainerGap())))
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel7)
          .addComponent(jLabel1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(Intelligence, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Broker, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(37, 37, 37)
            .addComponent(jLabel5)
            .addGap(18, 18, 18))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(Prospecting, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Admin, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(22, 22, 22)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jLabel10)
          .addComponent(jLabel6))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(Pilot, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Bribery, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(lbank, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(in, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(lhold))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(lcargo, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(lexpense, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(out, javax.swing.GroupLayout.Alignment.TRAILING)))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(hold)
            .addGap(0, 0, 0)
            .addComponent(used)))
        .addGap(0, 0, 0)
        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(3, 3, 3)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lempty, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(ltotal, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(total, javax.swing.GroupLayout.Alignment.TRAILING))
          .addComponent(empty))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(2, 2, 2)
        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel9)
          .addComponent(lkcr)
          .addComponent(Mining))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel1)
          .addComponent(Broker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5)
          .addComponent(Admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel6)
          .addComponent(Bribery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(Pilot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel10)
          .addComponent(jLabel8)
          .addComponent(Prospecting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Intelligence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel7)))
    );

    jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

    add(jPanel1, java.awt.BorderLayout.CENTER);
  }// </editor-fold>//GEN-END:initComponents

  private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
//</editor-fold>
    String string = jList1.getSelectedValue().toString();
    switch (string) {
      case "Cargo": {
        break;
      }
      case "Mail": {
        break;
      }
      case "Freight": {
        break;
      }
      case "Broker": {
        break;
      }
      case "Clear": {
        break;
      }
      case "Reset": {
        break;
      }
      case "Buy": {
        break;
      }
      case "Jump": {
        break;
      }
    }
    jPanel1.validate();
    repaint();
  }//GEN-LAST:event_jList1MouseClicked

  private void jList1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MousePressed
//<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //////System.out.print("" + " = " + );
    }
//</editor-fold>
    jta.append("");
    String string = jList1.getSelectedValue().toString();
    //jta.append(string + " - " + crlf);
    switch (string) {
      case "Browse": {
        browse(Double.parseDouble(jsnum.getValue().toString()));
        break;
      }
      case "Mail": {
        mail(Double.parseDouble(jsnum.getValue().toString()));
        break;
      }
      case "Freight": {
        freight("" + jsnum.getValue().toString());
        break;
      }
      case "Broker": {
        sell(Double.parseDouble(jsnum.getValue().toString()));
        break;
      }
      case "Clear": {
        hideAll();
        jta.append("");
        break;
      }
      case "Reset": {
        hideAll();
        reset();
        break;
      }
      case "Buy": {
        hideAll();
        buy(Double.parseDouble(jsnum.getValue().toString()));
        break;
      }
      case "Jump": {
        hideAll();
        try {
          //jump(Double.parseDouble(panels.Panel4SubSector.jLabel1.getText().substring(0, panels.Panel4SubSector.jLabel1.getText().length() - 3)));
//          jump(Double.parseDouble(panels.Panel4SubSector.jLabel1.getText().substring(3)));
        } catch (java.lang.NullPointerException e) {
          //System.out.print("" + " = " + e);
        }
        break;
      }
      case "Inventory": {
        inventory();
        break;
      }
    }
    jPanel1.validate();
    repaint();
  }//GEN-LAST:event_jList1MousePressed

  private void jList1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseReleased
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//      ////System.out.print("on " + string);
    }
//</editor-fold>
    String string = jList1.getSelectedValue().toString();
    switch (string) {
      case "Cargo": {
        break;
      }
      case "Mail": {
        break;
      }
      case "Freight": {
        break;
      }
      case "Broker": {
        break;
      }
      case "Clear": {
        break;
      }
      case "Reset": {
        break;
      }
      case "Buy": {
        break;
      }
      case "Jump": {
        break;
      }
    }
    jPanel1.validate();
    repaint();
  }//GEN-LAST:event_jList1MouseReleased

  private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
  }//GEN-LAST:event_jPanel2MouseClicked

  private void totalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    calc();
  }//GEN-LAST:event_totalMouseClicked

  private void outMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    String jop = JOptionPane.showInputDialog("what are the costs?", lexpense
      .getText());
    lexpense.setText(jop);
    totalMouseClicked(evt);
  }//GEN-LAST:event_outMouseClicked

  private void inMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    String jop = JOptionPane.showInputDialog("how much can we spend?", lbank
      .getText());
    lbank.setText(jop);
    totalMouseClicked(evt);
  }//GEN-LAST:event_inMouseClicked

  private void lemptyPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lemptyPropertyChange
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    if (Double.parseDouble(lempty.getText().toString()) < 0.0) {
      jta.append("Partial" + crlf);
      jsnum.setValue((-Double.parseDouble(lempty.getText())));
    }
  }//GEN-LAST:event_lemptyPropertyChange

  private void lemptyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lemptyMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    toSpinner(Double.parseDouble(lempty.getText()), lempty);
  }//GEN-LAST:event_lemptyMouseClicked

  private void emptyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emptyMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    calc();
  }//GEN-LAST:event_emptyMouseClicked

  private void lcargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lcargoMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    toSpinner(Double.parseDouble(lcargo.getText()), lcargo);
  }//GEN-LAST:event_lcargoMouseClicked

  private void usedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usedMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    String jop = JOptionPane.showInputDialog("how many filled?", lcargo
      .getText());
    lcargo.setText(jop);
    emptyMouseClicked(evt);
  }//GEN-LAST:event_usedMouseClicked

  private void lholdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lholdMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    toSpinner(Double.parseDouble(lhold.getText()), lhold);
  }//GEN-LAST:event_lholdMouseClicked

  private void holdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_holdMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    String jop = JOptionPane.showInputDialog("how big?", lhold.getText());
    lhold.setText(jop);
    emptyMouseClicked(evt);
  }//GEN-LAST:event_holdMouseClicked

  private void ltotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ltotalMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    toSpinner(Double.parseDouble(ltotal.getText()), ltotal);
  }//GEN-LAST:event_ltotalMouseClicked

  private void lbankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbankMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    toSpinner(Double.parseDouble(lbank.getText()), lbank);
  }//GEN-LAST:event_lbankMouseClicked

  private void lexpenseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lexpenseMouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
    //</editor-fold>
    toSpinner(Double.parseDouble(lexpense.getText()), lexpense);
  }//GEN-LAST:event_lexpenseMouseClicked

  private void jtf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jtf1ActionPerformed

  private void BrokerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrokerActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_BrokerActionPerformed

  private void AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_AdminActionPerformed

  private void BriberyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BriberyActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_BriberyActionPerformed

  private void MiningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MiningActionPerformed
    try {
      String title = "" + Panel4Locator.getSectorName() + "/" + Panel4Locator
        .getSubSectorName() + "/" + Panel4Locator.getSystem().toString();
      Panel4Mining.main(new String[]{title});
      Panel4Mining.Intelligence.setText(Intelligence.getText());
      Panel4Mining.Prospecting.setText(Prospecting.getText());
      Panel4Mining.Pilot.setText(Pilot.getText());
      Panel4Mining.Admin.setText(Admin.getText());
      Panel4Mining.Broker.setText(Broker.getText());
    } catch (Exception ex) {
      Logger.getLogger(Panel4TradeCargo.class.getName()).log(Level.SEVERE, null,
        ex);
    }
  }//GEN-LAST:event_MiningActionPerformed

  private void IntelligenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IntelligenceActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_IntelligenceActionPerformed

  private void ProspectingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProspectingActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_ProspectingActionPerformed

  private void PilotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PilotActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_PilotActionPerformed

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
    Broker.setText(JOptionPane.showInputDialog("Broker skill", "2"));
  }//GEN-LAST:event_jLabel1MouseClicked

  private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    Admin.setText(JOptionPane.showInputDialog("Admin skill", "0"));
  }//GEN-LAST:event_jLabel5MouseClicked

  private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
    Bribery.setText(JOptionPane.showInputDialog("Bribery skill", "0"));
  }//GEN-LAST:event_jLabel6MouseClicked

  private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
    Intelligence.setText(JOptionPane.showInputDialog("Intelligence", "8"));
  }//GEN-LAST:event_jLabel7MouseClicked

  private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    Prospecting.setText(JOptionPane.showInputDialog("Prospecting skill", "0"));
  }//GEN-LAST:event_jLabel8MouseClicked

  private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
    Pilot.setText(JOptionPane.showInputDialog("Pilot skill", "0"));
  }//GEN-LAST:event_jLabel10MouseClicked
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField Admin;
  private javax.swing.JTextField Bribery;
  private javax.swing.JTextField Broker;
  private static javax.swing.JTextField Intelligence;
  public static final javax.swing.JButton Mining = new javax.swing.JButton();
  private static javax.swing.JTextField Pilot;
  private static javax.swing.JTextField Prospecting;
  private javax.swing.JLabel empty;
  private javax.swing.JLabel hold;
  private javax.swing.JLabel in;
  private javax.swing.JLabel jLabel1;
  private static javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private static javax.swing.JLabel jLabel7;
  private static javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  public static final javax.swing.JList jList1 = new javax.swing.JList();
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPaneL;
  private javax.swing.JScrollPane jScrollPaneR;
  private javax.swing.JSpinner jsnum;
  public static javax.swing.JTextArea jta;
  public static javax.swing.JTextField jtf1;
  private javax.swing.JLabel lbank;
  private javax.swing.JLabel lcargo;
  private javax.swing.JLabel lempty;
  private javax.swing.JLabel lexpense;
  private javax.swing.JLabel lhold;
  private javax.swing.JLabel lkcr;
  private javax.swing.JLabel ltotal;
  private javax.swing.JLabel out;
  private javax.swing.JLabel total;
  private javax.swing.JLabel used;
  // End of variables declaration//GEN-END:variables
  //<editor-fold defaultstate="collapsed" desc="Class Private Variables">
//  private static JButton GO = new JButton("GO");
//  private static JButton jbb = new JButton("BUY");
//  private static JButton jbs = new JButton("SELL");
//  private String text = "";
  //<editor-fold defaultstate="collapsed" desc="worlds">
  private String[] worlds = {
    "1910-Regina", "2007-Roup", "2005-Feri", "1904-Boughene",
    "1705-Efate", "1307-Lysen", "1106-Jewell", "1307-Lysen",
    "1705-Efate", "1904-Boughene", "2005-Feri", "2007-Roup",
    "1910-Regina", "2007-Roup", "2005-Feri", "1904-Boughene",
    "1705-Efate", "1307-Lysen", "1106-Jewell", "1307-Lysen",
    "1705-Efate", "1904-Boughene", "2005-Feri", "2007-Roup",
    "1910-Regina"
  };
  //</editor-fold>
  private double ibank;
  private double iexpense;
  private double itotal;
  private double ihold;
  private double icargo;
  private double iempty;
  private static double costperton;
  //private static int tons;
  private static int mail;
  private static int freight;
  private static String cargos;
  private static String crlf = GlobalVariables.CRLF;
  private static String[] parts;
  private double base;
  private String purchasedm;
  private static double dtons;//dtons used for cargo, NOT FREIGHT OR MAIL
  private static String LOT;
  private static double PER;
  private static double COST;//what you pay to buy
  private static double VALUE;//what its worth
  private static double PRICE;//what you get when you sell
  private static String ITEM;//name of it (Guns, Farm Machinery etc.)
  private static String inventory = "";
  //</editor-fold>

  private String add2Bank(double money) {
    double in = Double.parseDouble(lbank.getText().toString());
    in += money;
    lbank.setText("" + in);
    calc();
    return "" + money;
  }

  private String add2Cargo(double dt) {
    double it = dt + Double.parseDouble(lcargo.getText());
    lcargo.setText("" + it);
    calc();
    return "" + it;
  }

  private String add2Expense(double buyValue) {
    double sum = buyValue + Double.parseDouble(lexpense.getText());
    lexpense.setText("" + sum);
    calc();
    return lexpense.getText();
  }

  private String toSpinner(double num, JLabel lempty1) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
//</editor-fold>
    jsnum.setValue(num);
    JLabel ret = lempty1;
    ////System.out.print("ret.getText()" + " = " + ret.getText());
    return ret.getText() + " from " + lempty1.getName();
  }

  private void hideAll() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      jta.append(Thread.currentThread().getStackTrace()[1].getMethodName()
        + crlf);
    }
//</editor-fold>
    int count = jPanel1.getComponentCount();
    //jta.append("" + CRLF);
    for (int i = 2; i < count; i++) {
      jPanel1.remove(i);
    }
    calc();
    repaint();
  }

  private String rollTonnage(String string) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //////System.out.print("" + " = " + );
    }
//</editor-fold>
    ////System.out.print("string" + " = " + string);
    if ((string == "") | (string == null)) {
      string = "1,1";
    }
    String[] a;
    a = string.split(",");
    ////System.out.print("" + " = " + a[0]);
    ////System.out.print("" + " = " + a[1]);
    int dice = Integer.parseInt(a[0]);
    int mult = Integer.parseInt(a[1]);
    int num = 0;
    for (int i = 0; i < dice; i++) {
      num += (int) (Math.random() * 6) + 1;
    }
    num += mult;
    return "" + num;
  }

  private void add2Inventory(String LOT) {
    //add buying information of last cargo purchased
    if (inventory == null) {
      inventory = "";
    }
    inventory += LOT + crlf;
    jta.append("" + inventory + crlf);
    //System.out.print("LOT" + " = " + LOT);
//    lots += 1;
  }

  private void shorten(JLabel label) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
//</editor-fold>
    int len;
    int pos;
    len = label.getText().length();
    int end = 0;  //how many chars? if over 3, then shorten
    if (end != 1) {
      try {
        String target = ".";
        len = label.getText().length();
        pos = label.getText().indexOf(target) + 1;
        if (pos != -1) { //if there is a point
          end = (len) - (pos);
          //<editor-fold defaultstate="collapsed" desc="DEBUG">
          DEBUG = false;
          if (DEBUG) { // true or false
            //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
            //System.out.print("pos" + " = " + (pos));
            //System.out.print("len" + " = " + (len));
            //System.out.print("end" + " = " + end);
          }
//</editor-fold>
        }
        if (end > 1) {
          label.setText("" + (label.getText().substring(0, len - pos)));
        }
      } catch (java.lang.StackOverflowError e) {
//
      } catch (java.lang.NumberFormatException m) {
        //System.out.print("m" + " = " + m.getMessage());
        label.setText("" + 0.0);
        throw (m);
      }
    }
  }

  private void browse(double dt) {
    jta.append("-----------------------------------" + crlf);
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    hideAll();
    setCargo(CTTradeSpec.getCargo());
    purchasedm = CTTradeSpec.getPurchaseDMs(getCargo());
    //<editor-fold defaultstate="collapsed" desc="percentage paid">
    int d66 = (int) (0 + (Math.random() * 6) + 1);
    d66 += (int) (0 + (Math.random() * 6) + 1) + Integer.parseInt(purchasedm);
    int percent = 0;
    switch (d66) {
      case 2: {
        percent = 40;
        break;
      }
      case 3: {
        percent = 50;
        break;
      }
      case 4: {
        percent = 70;
        break;
      }
      case 5: {
        percent = 80;
        break;
      }
      case 6: {
        percent = 90;
        break;
      }
      case 7: {
        percent = 100;
        break;
      }
      case 8: {
        percent = 110;
        break;
      }
      case 9: {
        percent = 120;
        break;
      }
      case 10: {
        percent = 130;
        break;
      }
      case 11: {
        percent = 150;
        break;
      }
      case 12: {
        percent = 170;
        break;
      }
      case 13: {
        percent = 200;
        break;
      }
      case 14: {
        percent = 300;
        break;
      }
      default: {
        percent = 400;
        break;
      }
    }
    ////System.out.print("percent" + " = " + percent + crlf);
    //</editor-fold>
    parts = GlobalMethods.stripCSV(cargos);
    String number = rollTonnage(parts[parts.length - 1]);
    toSpinner(Double.parseDouble(number), lempty);
    base = Double.parseDouble(parts[2]) / 1000;//Base cost per DTon
    costperton = base * (percent / 100);
    double cost;
    cost = (Double.parseDouble(number));
    cost *= costperton;
    purchasedm = CTTradeSpec.getPurchaseDMs(getCargo());
    double bvpt = (double) base;
    double tons = (double) jsnum.getValue();
    double per = (double) percent;
    String cost2buy = "" + ((percent / 100.0) * (bvpt * tons));
    int dec = cost2buy.indexOf(".");
    cost2buy = cost2buy.substring(0, dec + 2);
    COST = Double.parseDouble(cost2buy);
    VALUE = Double.parseDouble(parts[2]);
    dtons = tons;
    VALUE = (Double.parseDouble(parts[2]) / 1000) * dtons;
    PER = per / 100;
    LOT = cargos + ",\"" + dtons + "\",\"" + base + "\",\"" + PER + "\"";
    jta.setText("BROWSING" + crlf);
    jta.append("  " + number + " DTons" + crlf);
    jta.append("  " + parts[1] + crlf);
    jta.append("  Avg Value KCr" + VALUE + crlf);
    jta.append("  COST KCr" + cost2buy + crlf);
    //getInfo();
  }

  private void buy(double dt) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    if (dt > 0.0) {
      jta.append("-----------------------------------" + crlf);
      //System.out.print("TONS" + " = " + dt);
      dtons += dt;
      jsnum.setValue(0.0);
      VALUE = dt * base;
      String words = "BUYING" + crlf;
      words += "  " + LOT + crlf;
      words += "  Avg VALUE KCr" + VALUE + crlf;
      words += crlf;
      jta.append(words);
      if (Panel4SubSector.isRecording()) {
        Panel4History.write(words);
      }
      add2Inventory(LOT);
      add2Expense(COST);
      add2Cargo(dt);
      calc();
    }
    inventory();
  }

  private void sell(double num) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    //jta.setText("-----------------------------------" + crlf);
    hideAll();
    String[] lines = inventory.split(crlf);
    String[] strings;
    int profit = 0;
    //System.out.print("start" + " = " + start);
    switch (start) {
      case "CTTradeSpec":
        //        globals.CTTradeSpec.uwp = globals.CTTradeSpec.uwp;
        //        globals.CTTradeSpec.trade = globals.CTTradeSpec.trade;
        //System.out.print("uwp" + " = " + globals.CTTradeSpec.uwp);
        //System.out.print("trade" + " = " + globals.CTTradeSpec.trade);
        break;
      case "Panel4TradeCargo":
        //System.out.print("uwp" + " = " + globals.CTTradeSpec.uwp);
        //System.out.print("trade" + " = " + globals.CTTradeSpec.trade);
        break;
      case "Panel4SubSector":
        //System.out.print("uwp" + " = " + Panel4SubSector.UWP.getText());
        //System.out.print("trade" + " = " + Panel4SubSector.jComboBox6.getSelectedItem().toString());
        break;
    }
    String words = "";
    //======================================================================
    if (Panel4SubSector.isRecording()) {
      if (mail == 1) {
        Panel4History.writeLine("Mail - KCr10" + crlf);
      }
      if (freight > 0) {
        Panel4History.writeLine("Freight - KCr" + freight + crlf);
      }
      Panel4History.writeLine(words);
    }
    if (mail == 1) {
      jta.append("-----------------------------------" + crlf);
      jta.append("MAIL\nKCr10" + crlf);
      add2Bank((double) 10.0);
      mail = 0;
    }
    if (freight > 0) {
      jta.append("Freight\nKCr" + (double) freight + crlf);
      add2Bank((double) (1.0 * freight));
      freight = 0;
    }
    int a = lines.length;
    if (mail == 1) {
      a -= 1;
    }
    if (freight > 0) {
      a -= 1;
    }
    for (int i = 0; i < lines.length; i++) {
      String string = lines[i];
      //jta.append("" + i + " = " + string + crlf);
    }

    if (dtons > 0.0) {
      for (int i = 0; i < a; i++) {
        double tons;
        //System.out.print("-------------------");
        dbviewer.globals.CTTradeSpec.purchasedm = dbviewer.globals.CTTradeSpec
          .getDMs(lines[i], 3);
        dbviewer.globals.CTTradeSpec.saledm = dbviewer.globals.CTTradeSpec
          .getDMs(lines[i], 4);
        //System.out.print("purchasedm" + " = " + globals.CTTradeSpec.purchasedm);
        //System.out.print("saledm" + " = " + globals.CTTradeSpec.saledm);
        //System.out.print("lines[" + i + "]" + " = " + lines[i]);
        cargos = lines[i];
        strings = GlobalMethods.stripCSV(lines[i]);
        tons = Double.parseDouble(strings[6]);//0
        //System.out.print(" TONS" + " = " + tons);
        ITEM = strings[1];//4
        //System.out.print(" ITEM" + " = " + ITEM);
        PER = Double.parseDouble(strings[8]);//2
        //System.out.print(" PER" + " = " + PER);
        int broker = Integer.parseInt(Broker.getText());
        if (broker > 4) {
          broker = 4;
        } else if (broker < 0) {
          broker = 0;
        }
        int roll = (int) ((Math.random() * 6) + 1);
        roll += (int) (Math.random() * 6) + 1;
        //int admin = (int) Double.parseDouble(JOptionPane.showInputDialog("Admin + Bribery", 0));
        int admin = Integer.parseInt(Admin.getText());
        int bribery = Integer.parseInt(Bribery.getText());
        int rba = (roll + broker + admin + bribery + Integer.parseInt(
          CTTradeSpec.getSaleDMs(cargos)));
        //System.out.print(" roll" + " = " + roll);
        //System.out.print(" broker" + " = " + broker);
        //System.out.print(" admin" + " = " + admin);
        //System.out.print(" bribery" + " = " + bribery);
        //System.out.print("CTTradeSpec.getPurchaseDMs(cargos)" + " = " + CTTradeSpec.getPurchaseDMs(cargos));
        //System.out.print("CTTradeSpec.getSaleDMs(cargos)" + " = " + CTTradeSpec.getSaleDMs(cargos));
        //        <editor-fold defaultstate="collapsed" desc="switch">
        double percent;
        switch (rba) {
          case 2: {
            percent = 40;
            break;
          }
          case 3: {
            percent = 50;
            break;
          }
          case 4: {
            percent = 70;
            break;
          }
          case 5: {
            percent = 80;
            break;
          }
          case 6: {
            percent = 90;
            break;
          }
          case 7: {
            percent = 100;
            break;
          }
          case 8: {
            percent = 110;
            break;
          }
          case 9: {
            percent = 120;
            break;
          }
          case 10: {
            percent = 130;
            break;
          }
          case 11: {
            percent = 150;
            break;
          }
          case 12: {
            percent = 170;
            break;
          }
          case 13: {
            percent = 200;
            break;
          }
          case 14: {
            percent = 300;
            break;
          }
          default: {
            percent = 400;
            break;
          }
        }
//        </editor-fold>
        //System.out.print("SELL percent" + " = " + percent);
        if (LOT != null) {
          LOT = lines[i];
//          double at = Double.parseDouble(strings[7])/1000;
//          COST = tons * at * PER;
//          VALUE = tons * at;
          saledm = CTTradeSpec.getSaleDMs(getCargo());
          //System.out.print("saledm" + " = " + saledm);
          PRICE = VALUE * percent / 100;
          //System.out.print("PRICE" + " = " + PRICE);
          words = "SELLING" + crlf;
          words += "  " + LOT + crlf;
          words += "  " + "PAID KCr" + COST + crlf;
          words += "  " + "AVG KCr" + VALUE + crlf;
          words += "  PRICE KCr" + PRICE + crlf;
          words += "PROFIT KCr" + (PRICE - COST) + crlf + crlf;
        }

        double sum = (Double.parseDouble(strings[6]) * (Double.parseDouble(
          strings[7]) * (Double.parseDouble(strings[8]))));
        //System.out.print("Bought for  KCr" + sum);
        PRICE = (Double.parseDouble(strings[6]) * Double.parseDouble(strings[7])
          * (percent - (broker * 5)) / 100);
        add2Bank(PRICE);
        calc();
        dtons -= Double.parseDouble("" + tons);
        lexpense.setText("" + 0.0);
        //System.out.print("-------------------");
//        words = "SELLING" + crlf;
//        words += "  " + LOT + crlf;
//        words += "  " + "PAID KCr" + COST + crlf;
//        words += "  " + "AVG KCr" + VALUE + crlf;
        tons = Double.parseDouble(strings[6]);//0
        words += "  PRICE KCr" + PRICE + crlf;
        words += "PROFIT" + crlf;
        words += "KCr" + (PRICE - COST) + crlf;
        words += "TONS " + tons + crlf;
        profit += (PRICE - COST);
        //System.out.print("words" + " = " + words);
        jta.append("-----------------------------------" + crlf);
        jta.append(words);
        ////System.out.print("-------------------");
        String selldm = CTTradeSpec.getSaleDMs(cargos);
        //System.out.print("selldm" + " = " + selldm);
        calc();
        jta.append(crlf + "OVERALL PROFIT OF KCr" + profit + crlf);
      }
    }
//        ===========================================

    dtons = 0.0;
    inventory = "";
    jsnum.setValue(0.0);
    lcargo.setText("0.0");
    calc();
//    lempty.setText("" + Double.parseDouble(lhold.getText()));
  }

  private void freight(String num) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
//</editor-fold>
    hideAll();
    //jsnum.setValue(num);
    jta.setText("-----------------------------------" + crlf);
    jta.append("FREIGHT" + crlf);
    jsnum.setValue(Double.parseDouble(lempty.getText()));
    num = "" + jsnum.getValue();
    jta.append("  " + num + " DTons" + crlf);
    lcargo.setText("" + (Double.parseDouble(lcargo.getText()) + (Double
      .parseDouble(num))));
    calc();
    freight += Double.parseDouble(num);
    Panel4History.writeLine("Freight x " + freight + " dtons");
  }

  private void mail(double num) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      ////System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      //jta.append("" + " = " + );
    }
//</editor-fold>
    hideAll();
    if (mail == 0) {
      int reply = JOptionPane.showConfirmDialog(null,
        "Do you have any gunners?", "The Mail Must Get Through",
        JOptionPane.YES_NO_OPTION);
      if (reply == JOptionPane.YES_OPTION) {
        jta.setText("-----------------------------------" + crlf);
        jta.append("MAIL" + crlf);
        jta.append("  1.0 DTons" + crlf);
        lcargo.setText("" + (Double.parseDouble(lcargo.getText()) + 1.0));
        mail = 1;
        calc();
      }

    }
  }

  private void inventory() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("---------------------------");
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
//</editor-fold>
    if (inventory != null) {
      String[] lines = inventory.split(crlf);
      //System.out.print("lines.length" + " = " + lines.length);
      jta.setText("-----------------------------------" + crlf);
      jta.append("INVENTORY" + crlf);
      for (int i = 0; i < lines.length; i++) {
        //System.out.print("" + " = " + lines[i]);
        jta.append(lines[i] + crlf);
      }
    }
    if (mail == 1) {
      jta.append("Mail - 1 DTons" + crlf);
    }
    if (freight > 0) {
      jta.append("Freight - " + freight + " DTons" + crlf);
    }
  }

  void updateTo(String selectedItem) {
    jtf1.setText(selectedItem.toString() + "(" + Panel4SubSector.jcb4Trade
      .getSelectedItem().toString() + ")");
//    String from = Panel4TradeCargo.jtf1.getText();
//    updateFrom(from);
  }

  void updateFrom(String toString) {
    Panel4TradeCargo.setTitle(toString);
  }
}
