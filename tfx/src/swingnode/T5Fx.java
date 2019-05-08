package swingnode;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.SwingUtilities;

public class T5Fx extends Application {

  @Override
  public void start(Stage stage) {
    final SwingNode swingNode = new SwingNode();

    createSwingContent(swingNode);

    StackPane pane = new StackPane();
    pane.getChildren().add(swingNode);

    stage.setTitle("Swing in JavaFX");
    stage.setScene(new Scene(pane, 250, 150));
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  private void createSwingContent(final SwingNode swingNode) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        //swingNode.setContent(new JButton("Click me!"));
        swingNode.setContent(new panels.Panel4Word());
      }
    });
  }

  String CRLF = "\n";
  String T5 = "C:/T5/";
}
