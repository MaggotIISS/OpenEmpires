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
package dbviewer;

import dbviewer.globals.GlobalVariables;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import panels.Frame4;
import panels.Panel4;

/**

 @author maggot
 */
public class HelpFrame extends javax.swing.JFrame {

  /**
   JPanel
   */
  public static JPanel p4subs;
  /**
   JScrollPane
   */
  public static JScrollPane jsp;
  /**
   JTextArea
   */
  public static JTextArea jta;
  /**
   JFrame
   */
  public static JFrame jf;
  /**
   String
   */
  public static String CRLF = dbviewer.globals.GlobalVariables.CRLF;
  /**
   String[]
   */
  public static String[] lines;
  /**
   String[]
   */
  public static String[] titles;
  /**
   String[][]
   */
  public static String[][] all;
  /**
   String[]
   */
  public static String[] parts;
  /**
   String
   */
  public static String splat = ",";
  /**
   String
   */
  public static String quote = "\"";
  /**
   String
   */
  public static String comma = ",";
  /**
   String
   */
  public static String filenam;
  /**
   String
   */
  public static String line;
  /**
   String
   */
  public static String string = "";
  /**
   int
   */
  public static int i;
  /**
   int
   */
  public static int num = 0;
  /**
   BufferedReader
   */
  public static BufferedReader in;

  /**
   Creates new form AFrame
   */
  public HelpFrame() {
    super();
    initComponents();
    //System.out.print("" + " = " + "HelpFrame");
    p4subs = new Panel4("HelpFrame");
    jta = new JTextArea();
    jta.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() > 2) {
          jta.setText("");
        }
      }
    });
    jsp = new JScrollPane(jta);
    p4subs.add(jsp);
    jf = new Frame4(p4subs);
    jf.setVisible(true);
  }

  /**

   @param title title
   */
  public HelpFrame(String title) {
    this();
    jf.setTitle(title);
    p4subs.setName(title);
  }

  /**

   @param title    title
   @param filename filename
   */
  public HelpFrame(String title, String filename) {
    this();
    jf.setTitle(title);
    p4subs.setName(title);
    filenam = filename;
    try {
      in = new BufferedReader(new FileReader(filename));
      try {
        line = in.readLine();
        titles = line.split(splat);
        all = new String[dbviewer.globals.GlobalMethods.countLines(new File(
          filename))][titles.length];
        for (i = 0; i < HelpFrame.titles.length; i++) {
          if (i != titles.length - 1) {
            HelpFrame.all[0][i] = HelpFrame.titles[i] + comma;
          } else if (i == titles.length - 1) {
            HelpFrame.all[0][i] = HelpFrame.titles[i] + CRLF;
          }
          jta.append(HelpFrame.all[0][i].toUpperCase());
        }
        num = 1;
        while ((line = in.readLine()) != null) {
          string = "";
          parts = line.split(splat);
          for (i = 0; i < titles.length; i++) {
            if (i != titles.length - 1) {
              string = (parts[i] = parts[i] + comma);
            } else if (i == titles.length - 1) {
              string = parts[i];
            }
            all[num][i] = string;
            jta.append(string);
          }
          string = string.replace("\"", "");
          jta.append(string + CRLF);
          num += 1;
        }
        in.close();
      } catch (IOException ex) {
        Logger.getLogger(HelpFrame.class.getName()).log(Level.SEVERE, null, ex);
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(HelpFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    //System.out.print("HelpFrame.all.length" + " = " + HelpFrame.all.length);
    String txt = HelpFrame.jta.getText().replace("\",\"", "\", \"");
    jta.setText(txt);
    String[] strings = txt.split(GlobalVariables.CRLF);
    for (int i = 0; i < strings.length; i++) {
      ////System.out.print(GlobalMethods.capWords(strings[i]));
      //System.out.print("" + " = " +strings[i]);
    }
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  /**
   @param args the command line arguments
   */
  public static void main(String args[]) {
    /*
     Set the Nimbus look and feel
     */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /*
     If Nimbus (introduced in Java SE 6) is not available, stay with the
     default look and feel. For details see
     http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
        .getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | InstantiationException |
      IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(HelpFrame.class.getName()).log(
        java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /*
     Create and display the form
     */
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new HelpFrame().setVisible(true);
      }
    });
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
