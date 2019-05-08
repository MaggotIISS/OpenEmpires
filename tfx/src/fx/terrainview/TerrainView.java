/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.terrainview;

import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables.T5;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import static panels.Panel4T5Locator.stylesheet;

/**
 FXML Controller class

 @author Mark Ferguson
 */
public class TerrainView extends Application implements Initializable {

  /**
   Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    setupListView();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("TerrainView.fxml"));
    Scene scene = new Scene(root, 600, 850);
    scene.setUserAgentStylesheet(stylesheet);
    primaryStage.setTitle("TerrainView");
    primaryStage.setScene(scene);
//    this.primaryStage = primaryStage;
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  public TerrainView() {
    this.list = FXCollections.observableArrayList(strings);
  }

  @FXML
  private BorderPane borderpane;
  @FXML
  private ComboBox<String> combobox;
  @FXML
  private ImageView imageview;
  @FXML
  private Label label;
  @FXML
  private ListView<String> listview;
  String[] strings = {};
  ObservableList<String> list;
  private ArrayList<String> arraylist;
  private String[] files;
  private final String path = T5 + FS + "_T5 Image Library" + FS;
  private File imageDir;
  private String file;
  private Stage primaryStage;

  @FXML
  private void comboAction(ActionEvent event) {
  }

  @FXML
  private void openContextMenu(ContextMenuEvent event) {
  }

  private void setupListView() {
    //System.out.println("path" + " = " + path);
    imageDir = new File(path);
    arraylist = new ArrayList<>();
    String string;
    int count = 0;
    if (imageDir.exists()) {
      // continue
      files = imageDir.list();

      for (int i = 0; i < files.length; i++) {
        if (files[i].contains("Terrain")) {
          if (files[i].endsWith(".jpg")) {
            if (!files[i].contains("Mapping")) {
              if (!files[i].contains("Hex")) {
                int start = 0;
                int end = 0;
                start = files[i].indexOf("Terrain") + 7;
                end = files[i].lastIndexOf(".");
                string = files[i].substring(start, end).trim();
                //System.out.println(string);
                arraylist.add(files[i]);
                list.add(string);
              }
            }
          }
        }
      }

      //System.out.println("" + " = " + arraylist.toString());
      listview.setItems(list);
      InvalidationListener changelistener = new InvalidationListener() {
        @Override
        public void invalidated(Observable observable) {
          //System.out.println("invalidated" + " = " + list.toString());
        }
      };
      list.addListener(changelistener);
      MultipleSelectionModel<String> msm = listview.getSelectionModel();
      InvalidationListener selectListener = new InvalidationListener() {
        private Image image;

        @Override
        public void invalidated(Observable observable) {
          //System.out.println(msm.getSelectedItem());
          findFile(msm.getSelectedItem());
        }

        private void findFile(String selectedItem) {
          for (int i = 0; i < files.length; i++) {
            if (files[i].contains(selectedItem + ".jpg")) {
              if (files[i].endsWith(".jpg")) {
                if (!files[i].contains("Mapping")) {
                  if (!files[i].contains("Hex")) {
                    int start = 0;
                    int end = 0;
                    start = files[i].indexOf("Terrain") + 7;
                    end = files[i].lastIndexOf(".");
                    arraylist.add(files[i]);
                    file = new String(files[i]);
                    //System.out.println("file" + " = " + path + file);
//                    setTitle(file);
                    label.setText(file);
                    image = new Image("file:///" + path + file);
                    //System.out.println("image.toString()" + " = " +
                    //image.toString());
                    imageview.setImage(image);
                  }
                }
              }
            }
          }
          //System.out.println("file" + " = " + file);
        }

        private void setTitle(String string) {
          try {
            primaryStage.setTitle(string);
          } catch (Exception e) {
            //System.out.println("162" + " = " + e);
          }
        }
      };
      msm.selectedItemProperty().addListener(selectListener);
      //System.out.println(arraylist);
    }
  }

}
