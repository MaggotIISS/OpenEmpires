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

import dbviewer.DBViewer;
import dbviewer.globals.GlobalMethods;
import dbviewer.globals.GlobalVariables;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 <p>
 @author Your Name Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4ListText extends Panel4 {

  //<editor-fold defaultstate="collapsed" desc="variables">
  private static JFrame jf;
  private static JPanel jp;
  private JFileChooser jfc;
  private String[] textfiles = new String[]{"txt", "orb"};
  private String[] graphicfiles = new String[]{"gif"};
  private final String FS = GlobalVariables.FS;
  private String CRLF = GlobalVariables.CRLF;
  //</editor-fold>

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4ListText();
    jf = new Frame4(jp, "Panel4ListText");
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  /**
   Creates new form Panel4Admiral
   */
  public Panel4ListText() {
    super();
    initComponents();
    jfc = DBViewer.jfc;
    jfc.setCurrentDirectory(new File(GlobalVariables.REGINA));
    //jfc.setSelectedFile(new File(GlobalVariables.Regina+".gif"));
  }

  Panel4ListText(String string) {
    this();
    this.setName(string);
  }

  /**
   <p>
   @param dlm DefaultListModel
   */
  @SuppressWarnings("unchecked")
  public void setModel(DefaultListModel<String> dlm) {
    list.setModel(dlm);
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
    list = new javax.swing.JList();
    jScrollPane2 = new javax.swing.JScrollPane();
    jta = new javax.swing.JTextArea();
    Clear = new javax.swing.JLabel();
    Run = new javax.swing.JLabel();
    pic = new javax.swing.JLabel();
    Save = new javax.swing.JLabel();
    Open = new javax.swing.JLabel();

    list.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        listMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(list);

    jta.setColumns(20);
    jta.setRows(5);
    jScrollPane2.setViewportView(jta);

    Clear.setForeground(new java.awt.Color(255, 0, 0));
    Clear.setText("Clear");
    Clear.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        ClearMouseClicked(evt);
      }
    });

    Run.setForeground(new java.awt.Color(0, 255, 0));
    Run.setText("Run");
    Run.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        RunMouseClicked(evt);
      }
    });

    pic.setBackground(new java.awt.Color(255, 255, 255));
    pic.setForeground(new java.awt.Color(255, 255, 255));
    pic.setOpaque(true);
    pic.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        picMouseClicked(evt);
      }
    });

    Save.setForeground(new java.awt.Color(64, 64, 64));
    Save.setText("Save");
    Save.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        SaveMouseClicked(evt);
      }
    });

    Open.setForeground(new java.awt.Color(64, 64, 64));
    Open.setText("Open");
    Open.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        OpenMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(pic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
        .addGap(0, 0, 0)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(Clear)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Run)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Open)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Save)
            .addGap(0, 0, Short.MAX_VALUE))
          .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
        .addContainerGap())
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, pic});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(Clear)
          .addComponent(Run)
          .addComponent(Open)
          .addComponent(Save))
        .addGap(0, 0, 0)
        .addComponent(jScrollPane2))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearMouseClicked
    jta.setText("");
  }//GEN-LAST:event_ClearMouseClicked

  private void RunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RunMouseClicked
//    // run
//    try {
////      run(this.getSelected());
//    } catch (Exception e) {
//      System.out.println("" + " = " + e);
//    }
  }//GEN-LAST:event_RunMouseClicked

  private void SaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveMouseClicked
    DBViewer.jfc.showSaveDialog(this);
//    Panel4System.setJfc(Panel4System.getJfc());
////    this.name = Panel4System.getTitle();
//
////    OldPanel4ListText.ext = getExt();
////    Panel4System.getJfc().setSelectedFile(new File(this.name + "." + this.ext));
//    //    int showSaveDialog = Panel4Tabs.getJfc().showSaveDialog(jf);
//    //    if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
////      save(name, ext);
//    //    }
  }//GEN-LAST:event_SaveMouseClicked

  private void OpenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OpenMouseClicked
    JFileChooser jfc = DBViewer.jfc;
    int ret = jfc.showOpenDialog(this);
    if (jfc.getSelectedFile().isFile()) {
      String filename = jfc.getSelectedFile().toString();
      int len = filename.length();
      String ext = null;
      if (filename.contains(".")) {
        ext = filename.substring(len - 3).toLowerCase();
        System.out.println("ext" + " = " + ext);
        String string = "";
        for (int i = 0; i < textfiles.length; i++) {
          if (textfiles[i].contains(ext)) {
            string = "text";
            showText(filename);
            break;
          }
        }
        for (int i = 0; i < graphicfiles.length; i++) {
          if (graphicfiles[i].contains(ext)) {
            string = "graphic";
            showGraphic(filename);
            break;
          }
        }
        if (!"".equals(string)) {
          System.out.println("OK to load " + string + " file");
        }
      }
    }
  }//GEN-LAST:event_OpenMouseClicked

  private void picMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picMouseClicked
    System.out.println("" + " = " + evt.toString());
    DBViewer.jfc.setSelectedFile(new File("*.gif"));
    DBViewer.jfc.showOpenDialog(this);
//    pic = DBViewer.jfc.getSelectedFile();
  }//GEN-LAST:event_picMouseClicked

  private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
    if (evt.getClickCount() > 1) {
      RunMouseClicked(evt);
    }
  }//GEN-LAST:event_listMouseClicked
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel Clear;
  private javax.swing.JLabel Open;
  private javax.swing.JLabel Run;
  private javax.swing.JLabel Save;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTextArea jta;
  private javax.swing.JList list;
  private javax.swing.JLabel pic;
  // End of variables declaration//GEN-END:variables

  private void showText(String filename) {
    String[] txt = GlobalMethods.getLinesFromFile(new File(filename));
    for (int i = 0; i < txt.length; i++) {
      this.jta.append(txt[i] + CRLF);
    }
  }

  private void showGraphic(String filename) {
    Image image = Toolkit.getDefaultToolkit().getImage(filename);
    System.out.println("" + " = " + image.toString());
    ImageIcon ic;
    ic = new ImageIcon(image);
    System.out.println("" + " = " + ic.toString());
    pic.setIcon(ic);
    System.out.println("" + " = " + pic.toString());
    validate();
  }

  JList getList() {
    return list;
  }
}
