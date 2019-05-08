/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.combocon;

import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

/**

 @author Mark Ferguson
 */
public class ComboCon extends ComboBox<String> {

  static String[] test = new String[]{"A", "B", "C"};

  public static ObservableList<String> data = FXCollections
    .observableArrayList();

  public ObservableList<String> getData() {
    return data;
  }

  public void setData(ObservableList<String> data) {
    this.data = data;
  }

  public void setData(String[] strings) {
    data.clear();
    for (int i = 0; i < this.data.size(); i++) {
      data.add(strings[i]);
    }
    itemsProperty().set(data);
  }

  public String[] getStrings() {
    String[] strings = new String[data.size()];
    for (int i = 0; i < data.size(); i++) {
      strings[i] = data.get(i);
    }
    return strings;
  }

  public ComboCon() {
    super();
    setEditable(true);
    setOnAction((ActionEvent e) -> {
      for (int i = 0; i < data.size(); i++) {
        if (getValue().equals(data.get(i))) {
          return;
        }
      }
      data.add(getValue());
    });
    itemsProperty().setValue(data);
  }

  public ComboCon(String[] strings) {
    this();
    data.clear();
    data.addAll(Arrays.asList(strings));
  }

  public ComboCon(String[] strings, boolean editable) {
    this(strings);
    setEditable(editable);
  }

  public ComboCon(ObservableList<String> obslist) {
    this();
    itemsProperty().setValue(obslist);
  }

}
/*
 FileChooser fileChooser = new FileChooser();
 fileChooser.setTitle("Open Resource File");
 fileChooser.getExtensionFilters().addAll(
 new FileChooser.ExtensionFilter("Text Files", "*.txt"),
 new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
 new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
 new FileChooser.ExtensionFilter("All Files", "*.*"));
 File selectedFile = fileChooser.showOpenDialog(null);
 if (selectedFile != null) {
 // stage.display(selectedFile);
 System.out.println(selectedFile);
 }

 */
