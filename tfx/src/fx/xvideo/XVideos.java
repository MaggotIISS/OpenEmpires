package fx.xvideo;

import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables.T5;
import java.awt.EventQueue;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import panels.Frame4;
import panels.Panel4;

/**
 <p>
 @author maggot
 */
public class XVideos extends Application implements Runnable {

  private static final Logger LOG = Logger.getLogger(XVideos.class.getName());
  private static JPanel jp = null;
  private static JList<String> jList;
  private static JFrame jf = null;
  private static Path path;// = Paths.get("C:/T5/Traveller.mp4");
  private static String string;

  /**
   <p>
   @param args main startup
   */
  public static void main(String[] args) {
    int count = 0;
    string
      = "C:/Users/maggot/Downloads/Ant Videos/Celtic Frost/Acheron -  Dawn of Meggido  Celtic Frost cover.mp4";
    if (args.length > 0) {
      string = args[0];
    }
    File file;
    file = new File(T5 + FS + "Player.txt");
    String[] lines = GlobalMethods.getLinesFromFile(file);
    jList = new JList<>(lines);
    jList.addListSelectionListener((ListSelectionEvent lse) -> {
      if (lse.getValueIsAdjusting() == false) {
        string = jList.getSelectedValue();
        SwingUtilities.invokeLater(() -> {
          launch(new String[]{string});
        });
      }
    });
    jp = new Panel4("List");
    JScrollPane jsp = new JScrollPane(jList);
    jp.add(jsp);
    jf = new Frame4(jp);

  }
  private final String[] ARGS = {""};

  @Override
  public void start(Stage stage) {
//    path = Paths.get("C:/T5/Traveller.mp4");
//    path = Paths.get("C:/Users/maggot/Downloads/Ant XVideos/Celtic Frost/Celtic Frost - One In Their Pride.mp4");
//    path = Paths.get("C:/Users/maggot/Downloads/Ant XVideos/Celtic Frost/Obituary playing Celtic Frosts Circle of Tyrants.mp4");
    Runnable runnable = new Runnable() {
      public void run() {
        path = Paths.get(string);
        System.out.println("path = " + path);

        String location = path.toUri().toString();
        Media media = new Media(location);
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
//
        MediaView view = new MediaView(player);
        view.setOnError(e -> System.out.println(e));
        HBox box = new HBox(view);
        box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(box);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setTitle(path.toString());
        stage.show();
      }
    };
    runnable.run();
  }

  private static int count;

  /**
   run
   */
  @Override
  public void run() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        if (count == 0) {
          XVideo.main(ARGS);
          count += 1;
        } else {
//          XVideo.play();
        }
      }
    });
  }

}
