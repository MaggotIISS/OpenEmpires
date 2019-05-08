package dbviewer.globals;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

/**
 This class is a wrapper for the data transfer of image objects.
 */
public class ImageTransferable implements Transferable {

  private Image theImage;

  /**
   Constructs the selection.
   @param image an image
   */
  public ImageTransferable(Image image) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.println("ImageTransferable" + " = " + image.toString());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    theImage = image;
  }

  /**
   @return DataFlavor[]
   */
  @Override
  public DataFlavor[] getTransferDataFlavors() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.println("getTransferDataFlavors" + " = "
        + DataFlavor.imageFlavor);
    }
    //</editor-fold>
    return new DataFlavor[]{DataFlavor.imageFlavor};
  }

  /**
   @param flavor DataFlavor flavor
   @return isDataFlavorSupported
   */
  @Override
  public boolean isDataFlavorSupported(DataFlavor flavor) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.println("DataFlavor" + " = " + flavor.toString());
      System.out.println("isDataFlavorSupported" + " = "
        + isDataFlavorSupported(flavor));
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    return flavor.equals(DataFlavor.imageFlavor);
  }

  /**
   @param flavor DataFlavor
   @return Object(needs casting)
   @throws UnsupportedFlavorException on problem
   */
  @Override
  public Object getTransferData(DataFlavor flavor) throws
    UnsupportedFlavorException {
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
    if (flavor.equals(DataFlavor.imageFlavor)) {
      return theImage;
    } else {
      throw new UnsupportedFlavorException(flavor);
    }
  }

  /**
   @return width of Image
   */
  public int getWidth() {
    return theImage.getWidth(null);
  }

  /**
   @return height of Image
   */
  public int getHeight() {
    return theImage.getHeight(null);
  }
}
