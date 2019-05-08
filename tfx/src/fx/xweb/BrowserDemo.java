package fx.xweb;

import java.io.Serializable;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.swing.SwingUtilities;

/**
 @author maggot
 */
public class BrowserDemo extends Application implements Serializable {

  private static String page = "";
  private static final long serialVersionUID = 1L;
  private static final Logger LOG = Logger
    .getLogger(BrowserDemo.class.getName());
  private static String location;

  /**
   @param args main startup
   */
  public static void init(String[] args) {
//    if (args.length > 0) {
//      for (int i = 0; i < args.length; i++) {
//        System.out.println("" + " = " + args[i].toString());
//      }
//    }
    if (args.length > 0) {
      page = args[0];
    } else {
      page = location;
    }
    SwingUtilities.invokeLater(() -> {
      launch(args);
    });
  }

  @Override
  public void start(Stage stage) {
    location
      = "file:C:/T5/Spinward%20Marches/C%20Regina/1910%20Regina/1910%20Regina.html";
    WebView browser = new WebView();
    WebEngine engine = browser.getEngine();
    engine.load(location);
    Scene scene = new Scene(browser);
    stage.setScene(scene);
    stage.setWidth(500);
    stage.setHeight(500);
    stage.show();
  }

  /**
   <p>
   @param args main startup
   */
  public static void main(String[] args) {
    init(new String[]{location});

  }

}
