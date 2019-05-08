package fx.xvideo;

import dbviewer.globals.GlobalMethods;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 <p>
 @author maggot
 */
public class XVideo extends Application implements Runnable {

  /**
   <p>
   @param args main startup
   */
  public static void main(String[] args) {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    Runnable runnable = () -> {
      launch(args);
    };
    runnable.run();
  }

  /**
   play
   */
  public static void play() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
  }

  /**
   start
   @param stage main startup
   */
  @Override
  public void start(Stage stage) {
    stage.setFullScreen(true);
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    Runnable runnable;
    runnable = () -> {
      String path
        = "file:\\\\\\D:\\\\Mark Ferguson\\Downloads\\Ant Videos\\Music\\Celtic Frost - Drown In Ashes - YouTube.mp4";
//      path = Paths.get("C:/T5/Traveller.mp4");
//        path = Paths.get("D:/Vid.mp4");
      System.out.println(path);
//      String location = path.toUri().toString();
      Media media = new Media(path);
      MediaPlayer player = new MediaPlayer(media);
      player.setAutoPlay(true);
      MediaView view = new MediaView(player);
      view.setOnError(e -> System.out.println(e));
      HBox box = new HBox(view);
      box.setAlignment(Pos.CENTER);
      Scene scene = new Scene(box);
      stage.setScene(scene);
//      stage.setWidth(800);
//      stage.setHeight(500);
//      stage.setTitle(path.toString());
//      stage.centerOnScreen();
      stage.show();
    };
  }

  /**
   run
   */
  @Override
  public void run() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("" + " = " + );
    }
    //</editor-fold>
    System.out.println("running a Video");
  }

}
