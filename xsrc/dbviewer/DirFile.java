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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.ListModel;

/**

 @author Mark Ferguson maggot.iiss@sky.com
 */
@SuppressWarnings("serial")
public class DirFile extends panels.Frame4 {

  //<editor-fold defaultstate="collapsed" desc="variables">
  private static final String CRLF = System.getProperty("line.separator");
  private static final String FSEP = System.getProperty("file.separator");
  ConsoleWindow cw = new ConsoleWindow();
  SaveOutputWindow sow = new SaveOutputWindow();
  String dir = "";
  String file = "";
  String string = "";
  String pkg = "";
  DefaultListModel dlm = new DefaultListModel();
  DefaultListModel nil = new DefaultListModel();
  AbstractListModel alm = new AbstractListModel() {
    @Override
    public int getSize() {
      return alm.getSize();
    }

    @Override
    public Object getElementAt(int index) {
      return alm.getElementAt(index);
    }
  };
  JFileChooser jfc = new JFileChooser();
  String last = "";
  int i = 0;
  int j = 0;
  int num = 0;
  JList jlist = new JList();

  //</editor-fold>
  /**
   Creates new form DirFile
   */
  public DirFile() {
    sow.setBounds(600, 0, 300, 400);
    ConsoleWindow.setBounds(300, 0, 300, 700);
    initComponents();
    setBounds(0, 0, 300, 700);
    jList1.setSelectedIndex(1);
    jList2.setSelectedIndex(0);
    jList3.setSelectedIndex(1);
    sow.clear();
    openFolder();
  }

  /**
   @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new DirFile().setVisible(true);
      }
    });
  }

  /**
   @return name of class
   */
  @Override
  public String toString() {
    return "" + getClass().getName() + "[]";
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        jTextField1.setName("jTextField1"); // NOI18N

        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "D:\\Java\\JTrav", "D:\\Java\\JTrav\\src\\jtrav", "D:\\Trav\\Java", "C:\\Program Files\\Java\\jdk1.7.0\\src", "E:\\_Install\\JAVA", "D:\\CYBERBOARD", "C:\\Program Files\\Java\\jdk1.7.0", "C:\\Program Files\\Java\\jdk1.7.0_04" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setName("jList1"); // NOI18N
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item A", "Item B", "Item C", "Item D", "Item E" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList2.setName("jList2"); // NOI18N
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);
        jList2.getAccessibleContext().setAccessibleDescription("jList2");

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jList3.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "addDir", "removeDir", "open", "save", "openFolder", " ", "main", "filter", "setVars", " ", "sow", "clear", "block", "comment", "chapter", "section", "listJ", " ", "cw", "reflect", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList3.setName("jList3"); // NOI18N
        jList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList3);
        jList3.getAccessibleContext().setAccessibleDescription("jList3");

        jLabel3.setName("jLabel3"); // NOI18N

        jTextField2.setText(".java"); // NOI18N
        jTextField2.setName("jTextField2"); // NOI18N

        jLabel2.setName("jLabel2"); // NOI18N

        jLabel1.setName("jLabel1"); // NOI18N

        jCheckBox1.setName("jCheckBox1"); // NOI18N
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setName("jCheckBox2"); // NOI18N
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addComponent(jCheckBox2))
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(92, 92, 92))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu2.setName("jMenu2"); // NOI18N
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
    if (!jList2.getValueIsAdjusting()) {
      fileListChange();
    }
  }//GEN-LAST:event_jList2ValueChanged

  private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
    if (!jList1.getValueIsAdjusting()) {
      jLabel1.setText("");
      dirListChange();
      openFolder();
    }
  }//GEN-LAST:event_jList1ValueChanged

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseClicked
    if (!jList3.getValueIsAdjusting()) {
      commandChange();
    }
  }//GEN-LAST:event_jList3MouseClicked

  private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jCheckBox1ActionPerformed

  private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jCheckBox2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton jButton1;
    javax.swing.JCheckBox jCheckBox1;
    javax.swing.JCheckBox jCheckBox2;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    javax.swing.JList jList1;
    javax.swing.JList jList2;
    javax.swing.JList jList3;
    javax.swing.JMenu jMenu2;
    javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    javax.swing.JTextField jTextField1;
    javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

  private void dirListChange() {
    last = "dir";
    dir = jList1.getModel().getElementAt(jList1.getSelectedIndex()).toString();
    setTitle(dir);
    jLabel3.setText(last);
    jLabel1.setText("");
  }

  private void fileListChange() {
    last = "file";
    dir = jList1.getModel().getElementAt(jList1.getSelectedIndex()).toString();
    if (!jList2.isSelectionEmpty()) {
      file = jList2.getModel().getElementAt(jList2.getSelectedIndex())
        .toString();
      string = jList2.getModel().getElementAt(jList2.getSelectedIndex())
        .toString();
    }
    jLabel3.setText(last);
    jLabel1.setText(string);
    debug(file);
    //openFolder();
  }

  private void commandChange() {
    //System.out.print("\tcommandChange");
    jLabel2.setText(jList3.getModel().getElementAt(jList3.getSelectedIndex())
      .toString());
    string = jLabel2.getText();
    if ("main".equalsIgnoreCase(string)) {
      try {
        main();
      } catch (ClassNotFoundException ex) {
        Logger.getLogger(DirFile.class.getName()).log(Level.SEVERE, null, ex);
      }
      //runMain();
    } else if ("clear".equalsIgnoreCase(string)) {
      clear();
    } else if ("reflect".equalsIgnoreCase(string)) {
      reflect();
    } else if ("filter".equalsIgnoreCase(string)) {
      filter();
    } else if ("listJ".equalsIgnoreCase(string)) {
      listJ();
    } else if ("debug".equalsIgnoreCase(string)) {
      debug();
    } else if ("sow".equalsIgnoreCase(string)) {
      sow();
    } else if ("cw".equalsIgnoreCase(string)) {
      cw();
    } else if ("open".equalsIgnoreCase(string)) {
      open();
    } else if ("save".equalsIgnoreCase(string)) {
      save();
    } else if ("comment".equalsIgnoreCase(string)) {
      createComment();
    } else if ("chapter".equalsIgnoreCase(string)) {
      createChapter();
    } else if ("section".equalsIgnoreCase(string)) {
      createSection();
    } else if ("setVars".equalsIgnoreCase(string)) {
      setVars();
    } else if ("openFolder".equalsIgnoreCase(string)) {
      openFolder();
    } else if ("updateDirs".equalsIgnoreCase(string)) {
      updateDirs();
    } else if ("addDir".equalsIgnoreCase(string)) {
      addDir();
    } else if ("removeDir".equalsIgnoreCase(string)) {
      removeDir();
    } else if ("block".equalsIgnoreCase(string)) {
      createBlock();
    } else {
      debug(string + " NOT ENTERED IN commandChange()");
    }
    string = jList3.getModel().getElementAt(jList3.getSelectedIndex())
      .toString();
    //debug(string);
  }

  private void clear() {
    sow.clear();
  }

  private void main() throws ClassNotFoundException {
    if (!jList2.isSelectionEmpty()) {
      String folder = jList1.getSelectedValue().toString();
      String name = jList2.getSelectedValue().toString();
      String fullname = folder + "/" + name;
      int start = fullname.indexOf("jtrav");
      int enda = fullname.length() - jTextField2.getText().length();
      int len = fullname.length();
      name = fullname.substring(start, enda).replace("\\", "/")
        .replace("/", ".");

      //System.out.print("folder = " + folder);
      //System.out.print("name = " + name);
      //System.out.print("fullname = " + fullname);
      //System.out.print("start = " + start);
      //System.out.print("enda = " + enda);
      //System.out.print("len = " + len);
      //System.out.print("name = " + name);
      Class cl = Class.forName(name);
      //System.out.print("cl.getCanonicalName().toString() = " + cl.getCanonicalName().toString());
      //System.out.print("cl.getName().toString() = " + cl.getName().toString());
      //System.out.print("cl.getSimpleName().toString() = " + cl.getSimpleName().toString());
      //System.out.print("cl.toString() = " + cl.toString());
      //System.out.print("cl.getAnnotations().toString() = " + cl.getAnnotations().toString());
      //System.out.print("cl.getClasses().toString() = " + cl.getClasses().toString());
      ////System.out.print(" = " + cl.getComponentType().toString());
      //System.out.print("cl.getConstructors().toString() = " + cl.getConstructors().toString());
      //System.out.print("cl.getDeclaredAnnotations().toString() = " + cl.getDeclaredAnnotations().toString());
      //System.out.print("cl.getDeclaredClasses().toString() = " + cl.getDeclaredClasses().toString());
      //System.out.print("cl.getDeclaredConstructors().toString() = " + cl.getDeclaredConstructors().toString());
      //System.out.print("cl.getDeclaredFields().toString() = " + cl.getDeclaredFields().toString());
      //System.out.print("cl.getDeclaredMethods().toString() = " + cl.getDeclaredMethods().toString());
      ////System.out.print(" = " + cl.getDeclaredConstructors().toString());
      //System.out.print("cl.getDeclaredFields().toString() = " + cl.getDeclaredFields().toString());
      ////System.out.print(" = " + cl.getDeclaredMethods().toString());
      ////System.out.print(" = " + cl.getDeclaringClass().toString());
      ////System.out.print(" = " + cl.getEnclosingConstructor().toString());
      ////System.out.print(" = " + cl.getEnclosingMethod().toString());
      ////System.out.print(" = " + cl.getEnumConstants().toString());
      //System.out.print("cl.getFields().toString() = " + cl.getFields().toString());
      //System.out.print("cl = " + cl);
//      try {
//        cl.newInstance();
////      } catch (InstantiationException ex) {
////        Logger.getLogger(DirFile.class.getName()).log(Level.SEVERE, null, ex);
////      } catch (IllegalAccessException ex) {
////        Logger.getLogger(DirFile.class.getName()).log(Level.SEVERE, null, ex);
////      }
//      } catch (InstantiationException ex) {
//        Logger.getLogger(DirFile.class.getName()).log(Level.SEVERE, null, ex);
//      } catch (IllegalAccessException ex) {
//        Logger.getLogger(DirFile.class.getName()).log(Level.SEVERE, null, ex);
//      }
    }
  }

  private void reflect() {
    reflect(file);
  }

  private void reflect(String name) {
    setVars();
    String dest = dir + "/" + name;
    int start = dir.length() + 1;
    ////System.out.print(dest);
    dest = dest.substring(dest.indexOf("jtrav"), dest.length() - 5).replace("/",
      ".");
    ////System.out.print(dest);
    //System.out.print("dest = " + dest);
    String[] names = {dest};
    TestReflection.main(names);
  }

  private void filter() {
    if ("dir".equals(jLabel3.getText())) {
      filter(jList1);
    } else {
      filter(jList2);
    }
  }

  private void filter(JList list) {
    string = "filter " + jLabel3.getText() + "`s";
    if (jCheckBox1.isSelected()) {
      string += " recursively ";
    }
    if (!"".equals(jTextField1.getText())) {
      string += "to names containing " + jTextField1.getText();
    }
    if (!"".equals(jTextField2.getText())) {
      string += " ending in " + jTextField2.getText();
    }
    //System.out.print(string);
  }

  private void listJ() {
    if ("dir".equalsIgnoreCase(jLabel3.getText())) {
      listJ(jList1);
    } else {
      listJ(jList2);
    }
  }

  //@SuppressWarnings("empty-statement")
  private void listJ(JList lister) {
    if (lister == jList2) {
      alm = (AbstractListModel) lister.getModel();
    } else if (lister == jList1) {
      alm = (AbstractListModel) lister.getModel();
    }
    num = alm.getSize();
    if (num > 0) {
      for (i = 0; i < num; i++) {
        sow.append(alm.getElementAt(i).toString() + CRLF);
      }
    }
  }

  private void debug() {
    //debug("Test");
  }

  private void debug(String toString) {
    //System.out.print(toString);
  }

  private void sow() {
    sow(sow.isVisible());
  }

  private void sow(boolean visible) {
    if (visible == true) {
      sow.setVisible(false);
    } else {
      sow.setVisible(true);
    }
  }

  private void cw(boolean visible) {
    if (visible == true) {
      cw.setVisible(false);
    } else {
      cw.setVisible(true);
    }
  }

  private void cw() {
    cw(cw.isVisible());
  }

  private void open() {
    String dirname = getTitle();
    //System.out.print("Directory = " + dirname);
    open(dirname);
  }

  private void open(String dirname) {
    String filename = "";
    jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    jfc.setCurrentDirectory(new File(dirname));
    if (!jList2.isSelectionEmpty()) {
      filename = jList2.getSelectedValue().toString();
      jfc.setSelectedFile(new File(dirname + "/" + filename));
      //System.out.print("OPEN " + dirname + " looking 4 " + filename);
    } else if (jList2.isSelectionEmpty()) {
      jfc.setSelectedFile(null);
      //System.out.print("OPEN " + dirname);
      //filename = "";
    }
    int reply = jfc.showOpenDialog(this);
    if (reply == JFileChooser.APPROVE_OPTION) {
      //System.out.print("APPROVE_OPTION");
      sow.clear();
      sow.setTitle(jfc.getSelectedFile().toString());
      try {
        try (BufferedReader in = new BufferedReader(new FileReader(
          dirname + "/" + filename))) {
          String line;
          while ((line = in.readLine()) != null) {
            sow.append(line + CRLF);
          }
        }
      } catch (IOException iox) {
        //System.out.print(iox);
      }
    } else if (reply != JFileChooser.APPROVE_OPTION) {
      //System.out.print("CANCEL_OPTION");
    }
  }

  private void save() {
    save(getTitle());
  }

  private void save(String title) {
    //string = getTitle();
    string = title;
    //debug("save = " + string);
    jfc.setCurrentDirectory(new File(jList1.getSelectedValue().toString()));
    //jfc.setFileFilter(new FileFilter() {});
    int reply = 0;
    if ((reply = jfc.showSaveDialog(jList3)) != 0) {
      //System.out.print("CANCEL");
    } else {
      //System.out.print("SAVE");
    }
  }

  private void createComment() {
    int spaces = 0;
    String letter = "-";
    string = "";
    string = createComment(spaces, letter);
    sow.append(string);
  }

  private String createComment(int spaces, String letter) {
    String s = "";
    if (i > 0) {
      for (i = 0; i < spaces; i++) {
        s += " ";
      }
    }
    s += "//";
    for (i = 0; i < 78 - spaces; i++) {
      s += letter;
    }
    s += CRLF;
    return s;
  }

  private void setVars() {
    setVars("setVars");
  }

  private void setVars(String string) {
    //debug("");
    if (!jList1.isSelectionEmpty()) {
      dir = jList1.getSelectedValue().toString();
    } else {
      dir = "-";
    }
    if (!jList2.isSelectionEmpty()) {
      file = jList2.getSelectedValue().toString();
    } else {
      file = "-";
    }
    if (!jList3.isSelectionEmpty()) {
      string = jList3.getSelectedValue().toString();
    } else {
      string = "-";
    }
    setTitle(dir);
    jLabel1.setText(file);
    jLabel2.setText(string);
    jLabel3.setText(last);
    //debug(string + " " + dir + "/" + file);
    ////System.out.print("last = " + last);
    //debug("");
  }

  private void updateDirs() {
    updateDirs(dir);
  }

  private void updateDirs(String d) {
    //System.out.print(d);
  }

  private void openFolder() {
    //System.out.print("\topenFolder");
    jLabel1.setText("");
    String[] st = openFolder(dir);
  }

  @SuppressWarnings("unchecked")
  private String[] openFolder(String dir) {
    //System.out.print("\topenFolder(" + dir.toString());
    String[] files = FilteredListing.getFilteredListing(dir, jTextField2
      .getText());
    ////System.out.print("files = " + files);
    dlm = new DefaultListModel();
    for (i = 0; i < files.length; i++) {
      //System.out.print(i + " = " + files[i].toString());
      dlm.add(i, files[i]);
    }
    jList2.setModel(dlm);
    jList2.validate();
    jLabel1.setText("");
    return files;
  }

  private void addDir() {
    addDir(jList1.getSelectedValue().toString());
  }

  @SuppressWarnings("unchecked")
  private void addDir(String string) {
    if (!jList1.isSelectionEmpty()) {
      ////System.out.print("string = " + string);
//      sow.append("// " + string + CRLF);
      //sow.OpenIt();
      jfc.setCurrentDirectory(new File(dir));
      jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      int reply = jfc.showOpenDialog(jlist);
      //System.out.print("" + jfc.getSelectedFile().toString());
      DefaultListModel dlm1 = new DefaultListModel();
      dlm1.ensureCapacity(jList1.getModel().getSize() + 1);
      for (i = 0; i < jList1.getModel().getSize(); i++) {
        dlm1.add(i, jList1.getModel().getElementAt(i));
      }
      dlm1.add(0, jfc.getSelectedFile().toString());
      jList1.setModel(dlm1);
//      jList1.ensureIndexIsVisible(0);
//      jList1.setSelectedIndex(0);
      jList1.validate();
      //System.out.print("dlm1.getSize() = " + dlm1.getSize());
    }
  }

  private void removeDir() {
    removeDir(jList1.getSelectedValue().toString());
  }

  @SuppressWarnings("unchecked")
  private void removeDir(String toString) {
    //System.out.print("\tremoveDir");
    ListModel lm = jList1.getModel();
    dlm = new DefaultListModel();
    dlm.ensureCapacity(lm.getSize());
    for (i = 0; i < lm.getSize(); i++) {
      if (lm.getElementAt(i).toString().equals(toString)) {
        //System.out.print("Found it @ " + i);
        continue;
      }
      dlm.addElement(lm.getElementAt(i));
    }
    for (i = 0; i < dlm.getSize(); i++) {
      //System.out.print("" + i + " = " + dlm.getElementAt(i));
    }
    jList1.setModel(dlm);
    jList1.validate();
    //System.out.print("dlm.getSize() = " + dlm.getSize());
  }

  private void createChapter() {
    string = "";
    string += createComment(6, "*");
    string += createComment(4, "*");
    string += createComment(2, " ");
    string += createComment(0, " ");
    string += createComment(2, " ");
    string += createComment(4, "*");
    string += createComment(6, "*");
    //System.out.print(string);
    sow.append(string);
  }

  private void createSection() {

    string = "";
    string += createComment(0, "-");
    string += createComment(2, " ");
    string += createComment(4, " ");
    string += createComment(2, " ");
    string += createComment(0, "-");
    //System.out.print(string);
    sow.append(string);

  }

  private void createBlock() {
    string = "";
    string += createComment(0, "=");
    string += createComment(0, "-");
    string += createComment(0, " ");
    string += createComment(0, " ");
    string += createComment(0, " ");
    string += createComment(0, "-");
    string += createComment(0, "=");
    //System.out.print(string);
    sow.append(string);
  }
}
