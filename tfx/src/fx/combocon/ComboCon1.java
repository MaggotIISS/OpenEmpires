/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.combocon;

import fx.hexbutton.HexButton;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Control;
import javafx.scene.control.MenuItem;

/**

 @author Mark Ferguson
 */
public class ComboCon1 extends ComboBox<String> {

//  static String[] test = new String[]{"A", "B", "C"};
  public static ComboCon1 comboCon;
  static Control control;
  static ContextMenu contextmenu;
  static MenuItem menuitem;

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
  }

  @SuppressWarnings("unchecked")
  public ComboCon1() {
    super();
    comboCon = this;
    comboCon.getItems().clear();
    control = new fx.hexbutton.HexButton();
    contextmenu = fx.hexbutton.HexButton.getMenuItems(
      HexButton.names[HexButton.selnum]);
    contextmenu.setOnAction((ActionEvent e) -> {
      System.out.println("");
      System.out.println("\tcontextmenu.setOnAction");
      System.out.println(getValue());
//      System.out.println(contextmenu.getItems());
//      for (int i = 0; i < this.data.size(); i++) {
////        if (getValue().equals(this.data.get(i))) {
//        System.out.println(this.data.get(i));
////        }
//      }
    });
    System.out.println("");
    menuitem = new MenuItem();
    for (int i = 0; i < contextmenu.getItems().size(); i++) {
      menuitem = control.getContextMenu().getItems().get(i);
      menuitem.addEventHandler(EventType.ROOT, (Event event) -> {
        System.out.println("\tevent" + " = " + event);
        setValue(menuitem.toString());
      });
    }
    comboCon.setData(data);
    comboCon.setContextMenu(contextmenu);
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
//    this = comboCon;
  }

  public ComboCon1(String[] list) {
    this();
    data.clear();
    data.addAll(Arrays.asList(list));
  }

  public ComboCon1(String[] list, boolean editable) {
    this(list);
    setEditable(editable);
  }

  public ComboCon1(ObservableList<String> data) {
    this();
    itemsProperty().setValue(data);
  }

}
