package dbviewer.globals;

import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables._GIF;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.TransferHandler;
import static javax.swing.TransferHandler.MOVE;
import panels.Frame4;
import panels.Panel4T5CounterMaker;

/**

 @author maggot
 */
public class ImageListDnDFrame extends Frame4 {

  private static final int DEFAULT_WIDTH = 200;
  private static final int DEFAULT_HEIGHT = 850;

  /**

   */
  public static ImageList list1;
  String txt = "";

  /**
   ImageListDnDFrame
   */
  public ImageListDnDFrame() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    list1 = new ImageList(Paths.get(_GIF));
    list1.addMouseListener(new MouseAdapter() {

      @Override
      public void mousePressed(MouseEvent e) {
        try {
          //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
          boolean DEBUG = false;
          DEBUG = false;
          if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
              .getMethodName());
            //System.out.println("" + " = " + );
          }
          //</editor-fold>
          int idx = list1.getSelectedIndex();
          txt = list1.getModel().getElementAt(idx).toString();
          setTitle(txt.substring(txt.lastIndexOf(FS) + 1));
          list1.setToolTipText(txt);
          Panel4T5CounterMaker.jfc.setSelectedFile(new File(txt));
          BufferedImage bim = ImageIO.read(Panel4T5CounterMaker.jfc
            .getSelectedFile());
          int w = bim.getWidth();
          int h = bim.getHeight();
          int x = 50 - (w / 2);
          int y = 50 - (h / 2);
          Panel4T5CounterMaker.jSpinnerX.setValue(Panel4T5CounterMaker.fixx(x));
          Panel4T5CounterMaker.jSpinnerY.setValue(Panel4T5CounterMaker.fixy(y));
          Panel4T5CounterMaker.jSpinnerW.setValue(w);
          Panel4T5CounterMaker.jSpinnerH.setValue(h);
          Panel4T5CounterMaker.panel4Pic.grabFocus();
        } catch (IOException ex) {
          Logger.getLogger(ImageListDnDFrame.class.getName()).log(Level.SEVERE,
            null, ex);
        }
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        Panel4T5CounterMaker.jt4File.setText(txt.substring(txt.lastIndexOf(FS)
          + 1, txt.length() - 4));
//        jfc.setSelectedFile(new File(txt));
        Panel4T5CounterMaker.picClick();
//        Panel4T5CounterMaker.showBI();
        Panel4T5CounterMaker.showText();
        Panel4T5CounterMaker.showBI();
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
            .getMethodName());
          System.out.println("jfc.getSelectedFile().toString()" + " = "
            + Panel4T5CounterMaker.jfc.getSelectedFile().toString());
        }
        //</editor-fold>
      }

      @Override
      public void mouseClicked(MouseEvent e) {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
            .getMethodName());
          //System.out.println("" + " = " + );
        }
        //</editor-fold>
        System.out.println(txt);
        if (e.getClickCount() > 1) {
          Panel4T5CounterMaker.loadgifc(new File(txt));
//          Panel4T5CounterMaker.t4Write.setText("");
        }
      }

    });
    add(new JScrollPane(list1));
    setLocation(1000, 150);
  }

}

@SuppressWarnings("serial")
class ImageList extends JList<ImageIcon> {

  public ImageList(Path dir) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    DefaultListModel<ImageIcon> model = new DefaultListModel<>();
    try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir)) {
      for (Path entry : entries) {
        model.addElement(new ImageIcon(entry.toString()));
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    setModel(model);
    setVisibleRowCount(0);
    setLayoutOrientation(JList.VERTICAL);
    setDragEnabled(true);
    setDropMode(DropMode.INSERT);
    setTransferHandler(new ImageListTransferHandler());
  }
}

class ImageListTransferHandler extends TransferHandler {
  // support for drop

  public boolean canImport(TransferHandler.TransferSupport support) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    return support.isDataFlavorSupported(DataFlavor.imageFlavor);
  }

  // support for drag
  @Override
  public int getSourceActions(JComponent source) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.println("source.toString()" + " = " + source.toString());
    }
    //</editor-fold>
    return COPY_OR_MOVE;
  }

  public boolean importData(TransferHandler.TransferSupport support) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    ImageList list = (ImageList) support.getComponent();
    DefaultListModel<ImageIcon> model = (DefaultListModel<ImageIcon>) list
      .getModel();

    Transferable transferable = support.getTransferable();
    List<DataFlavor> flavors = Arrays.asList(transferable
      .getTransferDataFlavors());

    List<Image> images = new ArrayList<>();

    try {
      if (flavors.contains(DataFlavor.javaFileListFlavor)) {
        @SuppressWarnings("unchecked") List<File> fileList
          = (List<File>) transferable.getTransferData(
            DataFlavor.javaFileListFlavor);
        for (File f : fileList) {
          try {
            images.add(ImageIO.read(f));
          } catch (IOException ex) {
            // couldn't read image--skip
          }
        }
      } else if (flavors.contains(DataFlavor.imageFlavor)) {
        images.add((Image) transferable.getTransferData(DataFlavor.imageFlavor));
      }

      int index;
      if (support.isDrop()) {
        JList.DropLocation location = (JList.DropLocation) support
          .getDropLocation();
        index = location.getIndex();
        if (!location.isInsert()) {
          model.remove(index); // replace location
        }
      } else {
        index = model.size();
      }
      for (Image image : images) {
        model.add(index, new ImageIcon(image));
        index++;
      }
      return true;
    } catch (IOException ex) {
      return false;
    } catch (UnsupportedFlavorException ex) {
      return false;
    }
  }

  @Override
  protected Transferable createTransferable(JComponent source) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    ImageList list = (ImageList) source;
    int index = list.getSelectedIndex();
    if (index < 0) {
      return null;
    }
    ImageIcon icon = list.getModel().getElementAt(index);
    return new ImageTransferable(icon.getImage());
  }

  protected void exportDone(JComponent source, Transferable data, int action) {
    if (action == MOVE) {
      ImageList list = (ImageList) source;
      int index = list.getSelectedIndex();
      if (index < 0) {
        return;
      }
      DefaultListModel<?> model = (DefaultListModel<?>) list.getModel();
      model.remove(index);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="old">
//class ImageListTransferHandler extends TransferHandler {
//
//  @Override
//  public boolean canImport(TransferSupport support) {
//    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
//    boolean DEBUG = false;
//    //DEBUG = false;
//    if (DEBUG) { // true or false
//      System.out.print(GlobalMethods.comment("=", 80));
//      System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//      //System.out.println("" + " = " + );
//    }
//    //</editor-fold>
//    if (support.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
//      if (support.getUserDropAction() == MOVE) {
//        support.setDropAction(COPY);
//      }
//      return true;
//    } else {
//      return support.isDataFlavorSupported(DataFlavor.imageFlavor);
//    }
//  }
//
//  // support for drag
//  @Override
//  public int getSourceActions(JComponent source) {
//    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
//    boolean DEBUG = false;
//    //DEBUG = false;
//    if (DEBUG) { // true or false
//      System.out.print(GlobalMethods.comment("=", 80));
//      System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//      System.out.println("source" + " = " + source);
//      System.out.println("source.toString()" + " = " + source.toString());
//    }
//    //</editor-fold>
//    return COPY;
//  }
//
//  @Override
//  public boolean importData(TransferSupport support) {
//    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
//    boolean DEBUG = false;
//    //DEBUG = false;
//    if (DEBUG) { // true or false
//      System.out.print(GlobalMethods.comment("=", 80));
//      System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//      //System.out.println("" + " = " + );
//    }
//    //</editor-fold>
//    ImageList list = (ImageList) support.getComponent();
//    DefaultListModel<ImageIcon> model = (DefaultListModel<ImageIcon>) list.getModel();
//
//    Transferable transferable = support.getTransferable();
//    List<DataFlavor> flavors = Arrays.asList(transferable.getTransferDataFlavors());
//
//    List<Image> images = new ArrayList<>();
//
//    try {
//      if (flavors.contains(DataFlavor.javaFileListFlavor)) {
//        @SuppressWarnings("unchecked") List<File> fileList
//          = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
//        for (File f : fileList) {
//          try {
//            images.add(ImageIO.read(f));
//            System.out.println("" + " = " + f.toString());
//          } catch (IOException ex) {
//            // couldn't read image--skip
//          }
//        }
//      } else if (flavors.contains(DataFlavor.imageFlavor)) {
//        images.add((Image) transferable.getTransferData(DataFlavor.imageFlavor));
//      }
//
//      int index;
//      if (support.isDrop()) {
//        JList.DropLocation location = (JList.DropLocation) support.getDropLocation();
//        index = location.getIndex();
//        if (!location.isInsert()) {
//          model.remove(index); // replace location
//        }
//      } else {
//        index = model.size();
//      }
//      for (Image image : images) {
//        model.add(index, new ImageIcon(image));
//        index++;
////        System.out.println("" + " = " + image);
//      }
//      return true;
//    } catch (IOException ex) {
//      return false;
//    } catch (UnsupportedFlavorException ex) {
//      return false;
//    }
//  }
//
//  @Override
//  protected Transferable createTransferable(JComponent source) {
//    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
//    boolean DEBUG = false;
//    //DEBUG = false;
//    if (DEBUG) { // true or false
//      System.out.print(GlobalMethods.comment("=", 80));
//      System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//    }
//    //</editor-fold>
//    ImageList list = (ImageList) source;
//    int index = list.getSelectedIndex();
//    if (index < 0) {
//      return null;
//    }
//    ImageIcon icon = list.getModel().getElementAt(index);
//    //<editor-fold defaultstate="collapsed" desc="DEBUG">
//    //DEBUG = false;
//    if (DEBUG) {
//      System.out.println("icon.toString()" + " = " + icon.toString());
//    }
//    //</editor-fold>
//    return new ImageTransferable(icon.getImage());
//  }
//
//  @Override
//  protected void exportDone(JComponent source, Transferable data, int action) {
//    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
//    boolean DEBUG = false;
//    //DEBUG = false;
//    if (DEBUG) { // true or false
//      System.out.print(GlobalMethods.comment("=", 80));
//      System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//      System.out.println("source.toString()" + " = " + source.toString());
//      System.out.println("data.toString()" + " = " + data.toString());
//      System.out.println("action" + " = " + action);
//    }
//    //</editor-fold>
//
//    //<editor-fold defaultstate="collapsed" desc="DEBUG">
//    if (DEBUG) { // true or false
//      System.out.println("pic" + " = " + ImageListDnDFrame.list1.getSelectedValue().toString());
//    }
//    //</editor-fold>
//  }
//}
//</editor-fold>
