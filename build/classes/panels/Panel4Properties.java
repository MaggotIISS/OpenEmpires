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
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 <p>
 @author Your Name Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4Properties extends Panel4 {

  static Frame4 jf;
  static Properties defaultProperties;
  static Properties properties;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    Panel4 jp = new Panel4Properties();
    jf = new Frame4(jp, "Panel4Properties");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setTitle(properties.getProperty("TITLE"));
  }

  /**
   Creates new form Panel4Properties
   */
  public Panel4Properties() {
    super();
    initComponents();

    defaultProperties = new Properties();
    defaultProperties.put("SECTOR", "Spinward Marches");
    defaultProperties.put("SUBSECTOR", "Regina");
    defaultProperties.put("SYSTEM", "Regina");
    defaultProperties.put("COLOUR", "255 0 0");
    defaultProperties.put("FONT", "Courier");
    defaultProperties.put("PTSIZE", "12");
    defaultProperties.put("SIZE", "300 600");
    defaultProperties.put("TITLE", "defaultProperties");
    try {
      defaultProperties.store(System.out, "defaultProperties");
    } catch (IOException ex) {
      Logger.getLogger(Panel4Properties.class.getName()).log(Level.SEVERE, null,
        ex);
    }

    try {
      FileOutputStream fos;
      fos
        = new FileOutputStream(defaultProperties.getProperty("TITLE") + ".ini");
      defaultProperties.store(fos, "defaultProperties file");
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Panel4Properties.class.getName()).log(Level.SEVERE, null,
        ex);
    } catch (IOException ex) {
      Logger.getLogger(Panel4Properties.class.getName()).log(Level.SEVERE, null,
        ex);
    }

    //=====================================================
    properties = new Properties(defaultProperties);
    properties.put("SECTOR", "Solomani Rim/");
    properties.put("SUBSECTOR", "Sol/");
    properties.put("SYSTEM", "Terra");
    properties.put("COLOUR", "0 255 0");
    properties.put("FONT", "Monospaced");
    properties.put("PTSIZE", "16");
    properties.put("SIZE", "300 600");
    properties.put("TITLE", "Properties");
    try {
      properties.store(System.out, "properties file");
    } catch (IOException ex) {
    }

    try {
      FileOutputStream fos;
      fos = new FileOutputStream(properties.getProperty("TITLE") + ".ini");
      properties.store(fos, "Properties file");
    } catch (FileNotFoundException ex) {
    } catch (IOException ex) {
    }

    try {
      FileInputStream fis;
      fis = new FileInputStream("Properties");
      properties.load(fis);
    } catch (FileNotFoundException fnfe) {
    } catch (IOException ex) {
    }

    StringTokenizer st = new StringTokenizer(properties.getProperty("COLOUR"));
    int red = Integer.parseInt(st.nextToken());
    int green = Integer.parseInt(st.nextToken());
    int blue = Integer.parseInt(st.nextToken());

    Color foreground = new Color(red, green, blue);
    String name = properties.getProperty("FONT");
    int size = Integer.parseInt(properties.getProperty("PTSIZE"));
    Font f = new Font(name, Font.BOLD, size);
    st = new StringTokenizer(properties.getProperty("SIZE"));
    int hsize = Integer.parseInt(st.nextToken());
    int vsize = Integer.parseInt(st.nextToken());

    JLabel lab = new JLabel(properties.getProperty("TITLE"));
    lab.setFont(f);
    lab.setForeground(foreground);
    jLabel1.setText(lab.getText());
    jLabel1.setFont(lab.getFont());

//    jTextArea1.setText(properties.getProperty("SECTOR"));
//    jTextArea1.append(properties.getProperty("SUBSECTOR"));
//    jTextArea1.append(properties.getProperty("SYSTEM"));
    getSystemInfo();

  }

  private void getSystemInfo() {
    Properties systemProperties = System.getProperties();
    Enumeration e = systemProperties.propertyNames();
    while (e.hasMoreElements()) {
      String key = (String) e.nextElement();
      jTextArea1.append(key + " = " + systemProperties.getProperty(key)
        + dbviewer.globals.GlobalVariables.CRLF);
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

    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jLabel1 = new javax.swing.JLabel();

    jTextArea1.setColumns(10);
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    jLabel1.setForeground(new java.awt.Color(255, 0, 0));
    jLabel1.setText("jLabel1");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(18, 18, 18)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextArea1;
  // End of variables declaration//GEN-END:variables
}
