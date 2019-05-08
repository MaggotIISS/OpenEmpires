/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.xweb;

import java.io.Serializable;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 Create a resizable WebView pane
 */
public class WebViewPane extends Pane implements Serializable {

  private final WebViewBrowser outer;

  /**
   <p>
   @param outer browser instance
   */
  public WebViewPane(final WebViewBrowser outer) {
    this.outer = outer;
    VBox.setVgrow(this, Priority.ALWAYS);
    setMaxWidth(Double.MAX_VALUE);
    setMaxHeight(Double.MAX_VALUE);
    WebView view = new WebView();
    view.setMinSize(500, 400);
    view.setPrefSize(500, 400);
    final WebEngine eng = view.getEngine();
    eng.load(
      "file:///C:/T5/Spinward%20Marches/C%20Regina/1910%20Regina/1910%20Regina.html");
    final TextField locationField = new TextField(
      "file:///C:/T5/Spinward%20Marches/C%20Regina/1910%20Regina/1910%20Regina.html");
    locationField.setMaxHeight(Double.MAX_VALUE);
    Button goButton = new Button("Go");
    goButton.setDefaultButton(true);
    EventHandler<ActionEvent> goAction = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        eng.load(locationField.getText().startsWith("http://") ? locationField
          .getText() : "http://" + locationField.getText());
      }
    };
    goButton.setOnAction(goAction);
    locationField.setOnAction(goAction);
    eng.locationProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable,
        String oldValue, String newValue) {
        locationField.setText(newValue);
      }
    });
    GridPane grid = new GridPane();
    grid.setVgap(5);
    grid.setHgap(5);
    GridPane.setConstraints(locationField, 0, 0, 1, 1, HPos.CENTER, VPos.CENTER,
      Priority.ALWAYS, Priority.SOMETIMES);
    GridPane.setConstraints(goButton, 1, 0);
    GridPane.setConstraints(view, 0, 1, 2, 1, HPos.CENTER, VPos.CENTER,
      Priority.ALWAYS, Priority.ALWAYS);
    grid.getColumnConstraints().addAll(new ColumnConstraints(100, 100,
      Double.MAX_VALUE, Priority.ALWAYS, HPos.CENTER, true),
      new ColumnConstraints(40, 40, 40, Priority.NEVER, HPos.CENTER, true));
    grid.getChildren().addAll(locationField, goButton, view);
    getChildren().add(grid);
  }

  @Override
  protected void layoutChildren() {
    List<Node> managed = getManagedChildren();
    double width = getWidth();
    double height = getHeight();
    double top = getInsets().getTop();
    double right = getInsets().getRight();
    double left = getInsets().getLeft();
    double bottom = getInsets().getBottom();
    for (int i = 0; i < managed.size(); i++) {
      Node child = managed.get(i);
      layoutInArea(child, left, top, width - left - right, height - top - bottom,
        0, Insets.EMPTY, true, true, HPos.CENTER, VPos.CENTER);
    }
  }

}
