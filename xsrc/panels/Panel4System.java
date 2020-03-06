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
package panels;//"T5SystemPic",

import dbviewer.DBViewer;
import dbviewer.FileFilter4World;
import dbviewer.ImagePreviewer;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import static panels.Panel4ListTextOld.updatePic;

/**
 <p>
 @author Your Name Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4System extends Panel4 {

  //<editor-fold defaultstate="collapsed" desc="variables">
  private static String FS = dbviewer.globals.GlobalVariables.FS;
  private static JFrame jf;
  private static Panel4 jp;
  private static JTabbedPane jtp;
  private static JFileChooser jfc = DBViewer.jfc;
  private static Robot r;
  private static String[] tabs = new String[]{
    "CT", "T5", "JFC"
  };
  private static String[][] tabLists = new String[][]{
    {"UWP", "Details", "Destinations", "Mining", "Squadrons", "Troops"},
    {"T5Locator", "T5WebData", "T5System", "T5ArmorMaker", "T5GunMaker",
      "T5QREBS"},
    {"All", "World", "Image", "Text", "Quicklink", "Trav", "showFilters",
      "getFilterNum", "showChooser", "T52nd Survey", "T5DBConvert"}
  };
//  "T52nd Survey", "T5DBConvert", "T5SectorSplit", "//StarGen"
//  "//UMP", "//Ekex (EE)", "\\Demand", "\\Base GWP", "\\Resource Trade", "\\Aryu (RU)"
//  , "//saveCSVs","\\Variables"
  private static final Panel4ListTextOld[] p4lt
    = new Panel4ListTextOld[tabs.length];
//  private static final Panel4ListText[] p4lt = new Panel4ListText[tabs.length];
  private static JList<String> list = new JList<>();
//  private static JList<String>[] lists = new JList[tabs.length];
  private static DefaultListModel<String> dlm;
  private static FileNameExtensionFilter filter;
  private static String[] filters;
  /**
   FileFilter4World
   */
  public static FileFilter4World wff;
  /**
   FileNameExtensionFilter
   */
  public static FileNameExtensionFilter[] filt;
  private static int numFilters = 0;
  private static BufferedImage bi;
  private static final long serialVersionUID = 1L;
  //private static String ext = "gif";
  //</editor-fold>

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4System();
    jf = new Frame4(jp);
    try {
      jf.setTitle(Panel4SubSector.jList1.getSelectedValue().toString());
      //jf.setTitle(args[0]);
      setBi(ImageIO.read(new File(
        Panel4Locator.getPath() + jf.getTitle() + ".gif")));
      Panel4ListTextOld.jLabel1.setIcon(new ImageIcon(getBi()));
    } catch (Exception e) {
    }
    addFilters();
    ImagePreviewer ipv = new ImagePreviewer(DBViewer.jfc);
    jf.setContentPane(getJtp());
    jf.setSize(300, 400);
    jf.setLocation(800, 0);
    try {
      r = new Robot();
    } catch (AWTException ex) {
      Logger.getLogger(Panel4System.class.getName()).log(Level.SEVERE, null, ex);
    }
    r.mouseMove(850, 70);
    //r.mouseMove(Panel4Imperium.jp.getX(), Panel4Imperium.jp.getY());
    r.delay(300);
    r.mousePress(0);
    r.mouseRelease(0);
  }

  /**
   @return the bi
   */
  public static BufferedImage getBi() {
    return bi;
  }

  /**
   @param aBi the bi to set
   */
  public static void setBi(BufferedImage aBi) {
    bi = aBi;
  }

  /**
   @return the jtp
   */
  public static JTabbedPane getJtp() {
    return jtp;
  }

  /**
   @param aJtp the jtp to set
   */
  public static void setJtp(JTabbedPane aJtp) {
    jtp = aJtp;
  }

  /**
   addFilters
   */
  public static void addFilters() {
    wff = new FileFilter4World();
    getJfc().addChoosableFileFilter(wff);
    int numfilt = 4;
    filt = new FileNameExtensionFilter[numfilt];
    filt[0] = new FileNameExtensionFilter("Image Files", "jpg", "jpeg",
      "gif", "bmp", "png");
    filt[1] = new FileNameExtensionFilter("Text Files", "txt", "cfg", "ici",
      "java", "vbs", "bat", "u*", "npc", "gci");
    filt[2]
      = new FileNameExtensionFilter("QuickLink Files", "zip", "qfm", "txt",
        "gts", "adv", "rar", "pak", "dst");
    filt[3] = new FileNameExtensionFilter("Trav Files", "bmp", "jpg", "jpeg",
      "gif", "bat", "txt", "cfg", "frm", "vb", "exe", "dwi", "frx",
      "gbx", "gsn", "gtl", "hlp", "xls", "mdb", "odb", "npc", "ace",
      "zip", "rar", "sec", "sub", "sys", "ttf");
    for (int i = 0; i < numfilt; i++) {
      getJfc().addChoosableFileFilter(filt[i]);
    }
    filters = new String[]{
      "ace", "adv", "arm", "bat", "bmp", "cfg", "dst", "dwi", "exe", "frx",
      "gbx", "gci", "gif", "gsn", "gtl", "gts", "hlp", "ici", "java", "jpeg",
      "jpg", "mar", "mdb", "mer", "nav", "npc", "odb", "orb", "oth", "pak",
      "png", "qfm", "rar", "sco", "sec", "sub", "sys", "ttf", "txt", "u*",
      "vb*", "vbs", "xls", "zip"
    };
    Arrays.sort(filters);
    for (int i = 0; i < filters.length; i++) {
      filter = new FileNameExtensionFilter(new StringBuilder().append(filters[i]
        .toUpperCase()).append(" Files").toString(), filters[i].toLowerCase());
      getJfc().addChoosableFileFilter(filter);
    }
  }

  /**
   <p>
   @param filter String as extension
   */
  public static void setFilter(String filter) {
    Panel4ListTextOld.ext = filter;

    Boolean found = false;
    FileFilter filte = null;
    FileFilter[] choosableFileFilters = getJfc().getChoosableFileFilters();
    int world = 4;
    for (int i = 0; i < choosableFileFilters.length; i++) {
      if (choosableFileFilters[i].toString().toLowerCase().contains(filter
        .toString().toLowerCase())) {
        System.out.println(String.format(" = %s", choosableFileFilters[i]));
        found = true;
        int num = 4;
        if (Panel4System.getJfc().isAcceptAllFileFilterUsed() == true) {
          num += 1;
        }
        filte = choosableFileFilters[i + num];
        Panel4System.getJfc().setFileFilter(filte);
        return;
      }
    }
//    if (!found) {
//      filt = new FileNameExtensionFilter(filter.toString().toUpperCase() + " Files", filter.toString().toLowerCase());
//      Panel4Tabs.getJfc().addChoosableFileFilter(filt);
//      Panel4Tabs.getJfc().setFileFilter(filt);
//      world += 1;
//    }

//    System.out.println("filt.getDescription()" + " = " + getFilterNum(filt.getDescription()));
  }

  /**
   <p>
   @return Title of frame (Hex-System)
   */
  public static String getTitle() {
    try {
      return jf.getTitle();
    } catch (Exception e) {
//      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      return "jf.getTitle==null";
    }
  }

  /**
   @return the jfc
   */
  public static JFileChooser getJfc() {
    return jfc;
  }

  /**
   @param ajfc JFileChooser
   */
  public static void setJfc(JFileChooser ajfc) {
    jfc = getJfc();
    try {
      jfc = ajfc;
    } catch (Exception e) {
    }

  }

  /**
   Creates new form Panel4Tabs
   */
  public Panel4System() {
    initComponents();
    String folder;
    setJtp(new JTabbedPane());
//-----------------------------------------------
    getJtp().setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
//-----------------------------------------------
    for (int i = 0; i < tabs.length; i++) {
      p4lt[i] = new Panel4ListTextOld(tabs[i]);
//      p4lt[i] = new Panel4ListText(tabs[i]);
      getJtp().addTab(tabs[i], p4lt[i]);
      getJtp().setSelectedIndex(i);
      dlm = new DefaultListModel<>();
      for (int j = 0; j < tabLists[i].length; j++) {
        dlm.addElement(tabLists[i][j]);
      }
      list.setModel(dlm);
      p4lt[i].getList().setModel(dlm);
      //p4lt[i].getList().setSelectedIndex(0);
    }
    int idx = 0;
    getJtp().setSelectedIndex(idx);
    FileFilter[] choosableFileFilters = getJfc().getChoosableFileFilters();
    for (int i = 0; i < choosableFileFilters.length; i++) {
      //getJfc().removeChoosableFileFilter(getJfc().getFileFilter());
      getJfc().removeChoosableFileFilter(choosableFileFilters[i]);
    }
//    Component tabComponentAt = getJtp().getTabComponentAt(idx);
//    tabComponentAt.list();
//-----------------------------------------------
    try {
      jf.setTitle(Panel4Locator.getSystem());
    } catch (Exception e) {
    }
    try {
      folder = dbviewer.globals.GlobalVariables.IMP + FS
        + Panel4Locator.getSector().substring(0, 4).toUpperCase() + FS
        + Panel4Locator.getSubSector();
      jfc.setCurrentDirectory(new File(folder));
      jfc.setFileFilter(new FileFilter() {
        @Override
        public boolean accept(File f) {
//          System.out.println("" + " = " +f);
//          System.out.println("" + " = " +jf.getTitle());
//          if ((f != null)&(jf.getTitle()!=null)) {
          if (f.toString().contains(jf.getTitle())) {
            return true;
          } else {
            return false;
          }
//          }
//          return false;
        }

        @Override
        public String getDescription() {
          return "World Files";
        }
      });
      jfc.setSelectedFile(new File(jf.getTitle()));
    } catch (Exception e) {
    }
    ImagePreviewer ip = new ImagePreviewer(jfc);
    getJfc().setAccessory(ip);
    setJfc(jfc);
    getJtp().addChangeListener(new ChangeListener() {
      //private String CRLF = globals.GlobalVariables.CRLF;
      @Override
      public void stateChanged(ChangeEvent e) {
        String msg = getJtp().getTitleAt(getJtp().getSelectedIndex());
        msg += new StringBuilder().append(" @ ").append(getJtp()
          .getSelectedIndex()).toString();
        System.out.println(new StringBuilder().append("Panel  = ").append(msg)
          .toString() + " stateChanged");
        updatePic();

      }
    });
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
      .addGap(0, 264, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 329, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
