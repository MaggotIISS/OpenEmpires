/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.contextlink;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import panels.Panel4T5Locator;

/**

 @author Mark Ferguson
 */
public class ContextLink extends Hyperlink {

  public String menuitem = "";
  private ContextMenu conmen;
  private ObservableList<String> list = FXCollections.observableArrayList();

  @SuppressWarnings("unchecked")
  public ContextLink() {
    super();
    setBorder(null);
    setText("ContextLink");
    setId("ContextLink");
    setOnMouseClicked(new EventHandler() {
      @Override
      public void handle(Event event) {
//        System.out.println("  Left click");
//        System.out.println(event.getTarget());
//        System.out.println(getId());
      }
    });
    setTextFill(Color.GREEN);
    super.getStylesheets().add(Panel4T5Locator.stylesheet);
  }

  public ContextLink(String txt) {
    this();
    setText(txt);
    setId(txt);
  }

  @SuppressWarnings("unchecked")
  public ContextLink(String txt, String[] menuitems) {
    this(txt);
    list.clear();
    ContextMenu contextMenu = new ContextMenu();
    MenuItem menuItem = new MenuItem();
    for (int i = 0; i < menuitems.length; i++) {
      menuItem = new MenuItem(menuitems[i]);
      menuItem.setId(menuitems[i]);
      menuItem.addEventHandler(EventType.ROOT, (Event event) -> {
        //          System.out.println("  Right Click");
        System.out.println(event.getTarget());
//          System.out.println(getId());
      });
      contextMenu.getItems().add(menuItem);
      list.add(menuitem);
    }
    setContextMenu(contextMenu);
  }

  private ContextLink lab;

  /**
   @return the conmen
   */
  public ContextMenu getConmen() {
    return conmen;
  }

  /**
   @param conmen the conmen to set
   */
  public void setConmen(ContextMenu conmen) {
    this.conmen = conmen;
  }

  /**
   @return the lab
   */
  public ContextLink getLab() {
    return lab;
  }

  /**
   @param lab the lab to set
   */
  public void setLab(ContextLink lab) {
    this.lab = lab;
  }

  public ContextMenu getItems() {
    return getConmen();
  }

  public void setItems(ContextMenu conmen) {
    this.setConmen(conmen);
  }

//  private void doEvents(Event event) {
//    System.out.println(event.getEventType());
//    System.out.println(" " + event.getClass());
//    System.out.println(" " + event.getSource());
//    System.out.println(" " + event.getTarget());
//    //  ADD LINK TO EXTERNAL FILE TO PROCESS EVENTS
//    System.out.println("ADD LINK TO EXTERNAL FILE TO PROCESS EVENTS");
//  }
  /**
   @return the list
   */
  public ObservableList<String> getList() {
    return list;
  }

  /**
   @param list the list to set
   */
  public void setList(ObservableList<String> list) {
    this.list = list;
  }
}
