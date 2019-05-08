package fx.treeview;

// Demonstrate a TreeView
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class viewSectors extends Application {

  public static void main(String[] args) {

    // Start the JavaFX application by calling launch().
    launch(args);
  }
  Label response;

  // Override the start() method.
  public void start(Stage myStage) {
    myStage.setTitle("Demonstrate a TreeView");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 310, 460);
    myStage.setScene(myScene);
    response = new Label("No Selection");
    TreeItem<String> sectors = new TreeItem<>("Sectors");
    TreeItem<String> subsectors = new TreeItem<>("Subsectors");
    TreeItem<String> systems = new TreeItem<>("Systems");
    TreeItem<String> orbits = new TreeItem<>("Orbits");
    sectors.getChildren().add(subsectors);
    subsectors.getChildren().add(systems);
    systems.getChildren().add(orbits);
    TreeView<String> model = new TreeView<>(sectors);
    MultipleSelectionModel<TreeItem<String>> thisModel
      = model.getSelectionModel();
    thisModel.selectedItemProperty().addListener(
      new ChangeListener<TreeItem<String>>() {
      public void changed(
        ObservableValue<? extends TreeItem<String>> changed,
        TreeItem<String> oldVal, TreeItem<String> newVal) {

        // Display the selection and its complete path from the root.
        if (newVal != null) {

          // Construct the entire path to the selected item.
          String path = newVal.getValue();
          TreeItem<String> tmp = newVal.getParent();
          while (tmp != null) {
            path = tmp.getValue() + " / " + path;
            tmp = tmp.getParent();
          }

          // Display the selection and the entire path.
          response.setText("Selection is " + newVal.getValue()
            + "\nComplete path is " + path);
        }
      }
    });
    rootNode.getChildren().addAll(model, response);
    myStage.show();
  }
}
