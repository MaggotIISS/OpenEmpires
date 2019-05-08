/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.t5;

import static dbviewer.globals.GlobalVariables.CRLF;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 FXML Controller class

 @author Mark Ferguson
 */
public class T5Controller implements Initializable {

  public static String get(String part) {
    String reply = "reply";
//    String[] lines = fx.t5.T5Controller.textarea.getText();
    switch (part) {
      case "Year": {
//        reply = year.getText();
        break;
      }
      case "Day": {
//        reply = day.getText();
        break;
      }
      case "Hour": {
//        reply = hour.getText();
        break;
      }
      case "Minute": {
//        reply = minute.getText();
        break;
      }
      case "Second": {
//        reply = second.getText();
        break;
      }
      default: {
        reply = "DEFAULT: " + part;
      }
    }

    return reply;
  }

//  public String getYear() {
//    String it = year.getText();
//    return it;
//  }
  public static void main(String[] args) {
    //
    T5.main(args);
  }

  //<editor-fold defaultstate="collapsed" desc="variables">
  @FXML
  private Label NUM;
  private String StarDate;
  @FXML
  private Accordion accordian;
  private EventHandler<ActionEvent> actionHandler;
  @FXML
  private AnchorPane alienAnchor;
  @FXML
  private MenuButton alienmenu;
  private ContextMenu con;
  private ContextMenu[] cons;
  @FXML
  private AnchorPane controlAnchor;
  @FXML
  private TitledPane controlPane;
  @FXML
  private MenuButton controlmenu;
  @FXML
  private AnchorPane counterAnchor;
  @FXML
  private TitledPane counterPane;
  @FXML
  private MenuButton countermenu;
  @FXML
  private TextField day;
  private TextField field;
  @FXML
  private AnchorPane graphicAnchor;
  @FXML
  private TitledPane graphicPane;
  @FXML
  private MenuButton graphicmenu;
  @FXML
  private TextField hour;
  private MenuItem item;
  @FXML
  private Label l4day;
  @FXML
  private Label l4hr;
  @FXML
  private Label l4min;
  @FXML
  private Label l4sec;
  @FXML
  private Label l4yr;
  private Label lab;
  @FXML
  private Label last;
  private String[][] lefts;
  private MenuButton menubutton;
  private MenuButton[] menubuttons;
  @FXML
  private TextField minute;
  private final ObservableList<String> oblist = FXCollections
    .observableArrayList();
  private int panenum = 0;
  @FXML
  private TitledPane racePane;
  private String[] races;
  private String[][] rights;
  @FXML
  private TextField second;
  @FXML
  private AnchorPane sectorAnchor;
  @FXML
  private TitledPane sectorPane;
  @FXML
  private MenuButton sectormenu;
  @FXML
  private AnchorPane starAnchor;
  @FXML
  private TitledPane starPane;
  private Label stardate;
  @FXML
  private MenuButton starmenu;
  private MenuButton storymenu;
  @FXML
  private AnchorPane subsectorAnchor;
  @FXML
  private TitledPane subsectorPane;
  @FXML
  private MenuButton subsectormenu;
  @FXML
  private AnchorPane systemAnchor;
  @FXML
  private TitledPane systemPane;
  @FXML
  private MenuButton systemmenu;
  @FXML
  private TextArea textarea;
  @FXML
  private TextField textfield;
  private TextField tf = null;
  private TextField[] tfs;
  @FXML
  private AnchorPane timeAnchor;
  @FXML
  private TitledPane timePane;
  @FXML
  private MenuButton timemenu;
  @FXML
  private Pane timepane;
  private TitledPane titled;
  private TitledPane[] titleds;
  private String[] titles;
  @FXML
  public TextField year;
  //</editor-fold>

  /**
   Initializes the controller class.
   @param url
   @param rb
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    setup();
    addMenus();
    showAccordianPane("timePane");
    year.setText(Year);
    day.setText(Day);
    hour.setText(Hour);
    minute.setText(Minute);
    second.setText(Second);
    showText();
  }

  private void addMenus() {
    //<editor-fold defaultstate="collapsed" desc="setup">
    titles = new String[]{"Random", "Sectors", "Subsectors", "Systems", "Stars",
      "Counters", "Races", "Graphics", "Controls"};
    races = new String[]{"Solomani", "Vilani", "Zhodani", "Vargr", "K`Kree",
      "Hiver"};
    lefts = new String[][]{{"date", "time", "random", "current", "reset", "day",
      "year", "hour", "minute",
      "second"}, {"Spinward Marches"}, {"C Regina"}, {"1910 Regina"}, {"M7  V"},
    {"Main"}, races, {"gifRotate"}, {"ControlL"}};
    rights = new String[][]{
      {"Test", "1000"}, {"Spinward Marches", "Solomani Rim", "Core"},
      {"C Regina", "Terra", "Capital"}, {"1910 Regina", "Terra", "Capital"},
      {"M7  V"}, {"main"}, {"Alien"}, {"Test"}, {"ControlR"}};
    titleds = new TitledPane[]{timePane, sectorPane, subsectorPane, systemPane,
      starPane, counterPane, racePane, graphicPane, controlPane};
    menubuttons = new MenuButton[]{timemenu, sectormenu, subsectormenu,
      systemmenu,
      starmenu, countermenu, alienmenu, graphicmenu, controlmenu};
    item = new MenuItem();
    cons = new ContextMenu[titles.length];
    MenuItem mi = null;
    //</editor-fold>
    actionHandler = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent ae) {
        String selection = ((MenuItem) ae.getTarget()).getText();
        int num = -1;
        try {
          num = Integer.parseInt(selection);
        } catch (java.lang.NumberFormatException e) {
          last.setText(selection);
        }
        if (num == -1) {
          // IS NOT A NUMBER (num=-1) or contains spaces
          //<editor-fold defaultstate="collapsed" desc="Words">
          last.setText(selection);
          //<editor-fold defaultstate="collapsed" desc="switch (last.getText())">
          switch (last.getText()) {
            case "date": {
              randomise("year");
              randomise("day");
              break;
            }
            case "time": {
              randomise("hour");
              randomise("minute");
              randomise("second");
              break;
            }
            case "random": {
              randomise("year");
              randomise("day");
              randomise("hour");
              randomise("minute");
              randomise("second");
              break;
            }
            case "current": {
              year.setText("1120");
              day.setText("01");
              hour.setText("00");
              minute.setText("00");
              second.setText("01");
              showText();
              break;
            }
            case "reset": {
              year.setText("1120");
              day.setText("01");
              hour.setText("00");
              minute.setText("00");
              second.setText("00");
              showText();
              break;
            }
            case "year": {
              randomise("year");
              break;
            }
            case "day": {
              randomise("day");
              break;
            }
            case "hour": {
              randomise("hour");
              break;
            }
            case "minute": {
              randomise("minute");
              break;
            }
            case "second": {
              randomise("second");
              break;
            }
            //////////////////////////////////////            //////////////////////////////////////
            default: {
              System.out.println("DEFAULT 275");
              allOtherCommands(selection, ae);
              last.setText("-1");
              break;
            }
          }
          //</editor-fold>
          NUM.setText("" + num);
          //</editor-fold>
        } else { //if (num > -1) {
          // IS A NUMBER full length of string
          //<editor-fold defaultstate="collapsed" desc="Numbers">
//          if (num != -1) {
          selection = ((MenuItem) ae.getTarget()).getText().toLowerCase().trim();
//          System.out.println(last.getText() + " = " + selection);
          NUM.setText("" + num);
//          }
          //</editor-fold>
        }
        showText();
//        System.out.println("selection" + " = " + selection);
//        System.out.println("num" + " = " + num);
//        System.out.println("" + " = ");
      }

    };
    //<editor-fold defaultstate="collapsed" desc="add menubuttons to panes">
    for (int i = 0; i < menubuttons.length; i++) {
      menubutton = menubuttons[i];
//      System.out.println("" + " = " + menubutton);
      menubutton.setText(titles[i]);
//      System.out.println("menu.getText()" + " = " + menubutton.getText());
      menubutton.setOnAction(actionHandler);
      String string;
      for (int j = 0; j < lefts[i].length; j++) {
        string = lefts[i][j];
        item = new MenuItem(lefts[i][j]);
        item.setOnAction(actionHandler);
        menubutton.getItems().add(item);
      }
      con = new ContextMenu();
      for (int j = 0; j < rights[i].length; j++) {
        mi = new MenuItem(rights[i][j]);
        mi.setOnAction(actionHandler);
        con.getItems().add(mi);
        menubuttons[i].setContextMenu(con);
      }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="add ContextMenu to each label">
    String[] yearmi = {"1120", "1105"};
    String[] weekmi = {"1", "13", "26", "39", "52"};
    String[] daymi = {"1", "15", "30"};
    String[] hourmi = {"00", "08", "16", "00", "06", "12", "18"};
    String[] minutemi = {"00", "15", "30", "45"};
    String[] secondmi = {"00", "15", "30", "45"};
    String[][] mis = {yearmi, daymi, hourmi, minutemi, secondmi};
    Label[] labs = {l4yr, l4day, l4hr, l4min, l4sec};
    ContextMenu cm;
    for (int i = 0; i < mis.length; i++) {
      cm = new ContextMenu();
      for (int j = 0; j < mis[i].length; j++) {
        MenuItem mi2 = new MenuItem(mis[i][j]);
        mi2.setOnAction(actionHandler);
        cm.getItems().add(mi2);
      }
      labs[i].setContextMenu(cm);
    }
    //</editor-fold>

  }

  private void allOtherCommands(String selection, ActionEvent ae) {
    String s = "";
    int len = 0;
    try {
      s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
        + CRLF;
      selection = ((MenuItem) ae.getTarget()).getText().trim();
      s += "selection" + " = " + selection + CRLF;
      if (selection.contains(" ")) {
        len = selection.indexOf(" ");
      } else {
        len = selection.length();
      }
      s += "len" + " = " + len;
      System.out.print(s);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Exception 3824" + e);
    }
  }

  @FXML
  private void day(ActionEvent event) {
    field = day;
    last.setText("day");
    showText();
  }

  private void dayClick(MouseEvent event) {
    field = day;
    randomClick(event);
  }

  private void doMenu(String string) {
    switch (string) {
      case "1120": {
        System.out.println(string);
        break;
      }
    }
  }

  private void fixTexts() {
    String[] txts = {
      year.getText(), day.getText(), hour.getText(), minute.getText(), second
      .getText()
    };
    String out = "";
    for (int i = 0; i < txts.length; i++) {
      int num = Integer.parseInt(txts[i]);
      if (num < 10 & num >= 0) {
        out = "0" + num;
      } else {
        out = "" + num;
      }
      tfs[i].setText(out);
    }
  }

  @FXML
  private void hour(ActionEvent event) {
    field = hour;
    last.setText("hour");
    int hr = (Integer.parseInt(hour.getText()));
    hour.setText("" + hr);
    showText();
  }

  private void hourClick(MouseEvent event) {
    randomClick(event);
  }

  @FXML
  private void lastClick(MouseEvent event) {
    System.out.println("last.getText()" + " = " + last.getText());
  }

  @FXML
  private void minute(ActionEvent event) {
    field = minute;
    last.setText("minute");
    showText();
  }

  private void minuteClick(MouseEvent event) {
    field = minute;
    randomClick(event);
  }

  @FXML
  private String randomClick(MouseEvent event) {
    int max = 0;
    String r = event.getPickResult().toString().toLowerCase();
    String t = r.substring(r.indexOf("text=\"") + 6);
    t = t.substring(0, t.indexOf("\""));
    last.setText(t);
    switch (t) {
      case "year": {
        max = 1120;
        tf = year;
        break;
      }
      case "day": {
        max = 365;
        tf = day;
        break;
      }
      case "hour": {
        max = 24;
        tf = hour;
        break;
      }
      case "minute": {
        max = 60;
        tf = minute;
        break;
      }
      case "second": {
        max = 60;
        tf = second;
        break;
      }
      default: {
        System.out.println("default 470" + " = " + max);
      }
    }
    int num = (int) (Math.random() * max) + 1;
    String out = "" + num;
    tf.setText(out);
    textfield.setText("" + out);
    NUM.setText(out);
    fixTexts();
    showText();
    return "" + out;
  }

  private String randomise(String string) {
    int m = 0;
    TextField tf = new TextField("");
    lab = new Label();
    switch (string.toLowerCase().trim()) {
      case "year": {
        m = (int) (Math.random() * 1120);
        year.setText("11" + m);
        tf = year;
        lab = l4yr;
        break;
      }
      case "day": {
        m = (int) (Math.random() * 365);
        day.setText("" + m);
        tf = day;
        lab = l4day;
        break;
      }
      case "hour": {
        m = (int) (Math.random() * 24);
        hour.setText("" + m);
        tf = hour;
        lab = l4hr;
        break;
      }
      case "minute": {
        m = (int) (Math.random() * 60);
        minute.setText("" + m);
        tf = minute;
        lab = l4min;
        break;
      }
      case "second": {
        m = (int) (Math.random() * 60);
        second.setText("" + m);
        tf = second;
        lab = l4sec;
        break;
      }
      default: {
        tf.setText("" + m);
        switch (lab.getText()) {
          case "": {
            break;
          }
          default: {
            break;
          }
        }
        System.out.println(lab.getText() + " = " + tf.getText());
      }
    }
    tf.setText("" + m);
    fixTexts();
    showText();
    System.out.println(lab.getText() + " = " + tf.getText());
    return "" + m;
  }

  @FXML
  private void second(ActionEvent event) {
    field = second;
    last.setText("second");
    lab.setText(second.getText());
    showText();
  }

  private void secondClick(MouseEvent event) {
    field = second;
    randomClick(event);
  }

  private void setup() {
    tfs = new TextField[]{
      year, day, hour, minute, second
    };
//    StarDate = new SimpleStringProperty("001-1120@00:00:00");
//    System.out.println("StarDate.get()" + " = " + StarDate.get());
  }

  private void showAccordianPane(String xxxPane) {
    String search = xxxPane;
    List l = accordian.getPanes();
    for (int i = 0; i < l.size(); i++) {
      titled = titleds[i];
      if (titled.getId().toString().equals(search)) {
        panenum = i;
        titled = titleds[i];
        menubutton = menubuttons[i];
        accordian.setExpandedPane(titled);
        break;
      }
    }
    System.out.println("panenum" + " = " + panenum);
    System.out.println("titled" + " = " + titled.getText());
    System.out.println("menubutton" + " = " + menubutton.getText());
  }

  private void showText() {
    fixTexts();
    int d = 0, w = 0;
    d = Integer.parseInt(day.getText());
    w = (d / 52) + 1;
    String txt = ""
      + "" + day.getText() + "-" + year.getText() + "@" + hour.getText() + ":"
      + minute.getText() + ":" + second.getText() + CRLF
      + "Date " + day.getText() + "-" + year.getText() + CRLF
      + "Time " + hour.getText() + ":" + minute.getText() + ":" + second
      .getText() + CRLF
      + "Year " + year.getText() + CRLF
      + "Week " + w + CRLF
      + "Day " + day.getText() + CRLF
      + "Hour " + hour.getText() + CRLF
      + "Minute " + minute.getText() + CRLF
      + "Second " + second.getText() + CRLF;

    textarea.setText(txt);
    try {
//      setStarDate(day.getText() + "-" + year.getText() + "@" + hour.getText()
//        + ":" + minute.getText() + ":" + second.getText());
//      StarDate.set(getStarDate());
//      System.out.println("" + " = " + stardate.getText());
//      stardate.setText("STARDATE");
    } catch (Exception e) {
      System.out.println("" + " = " + e);
    }
  }

  @FXML
  private void year(ActionEvent event) {
    field = year;
    last.setText("year");
    showText();
  }

  private void yearClick(MouseEvent event) {
    field = year;
    randomClick(event);
  }

  public static String Year = "1120";

  public static String getYear() {
    return Year;
  }

  public static String Week = "01";

  public static String getWeek() {
    return Week;
  }

  public static String Day = "01";

  public static String getDay() {
    return Day;
  }

  public static String Hour = "00";

  public static String getHour() {
    return Hour;
  }

  public static String Minute = "00";

  public static String getMinute() {
    return Minute;
  }

  public static String Second = "00";

  public static String getSecond() {
    return Second;
  }

  public static String Duration = "00s";

  public static String getDuration() {
    return Duration;
  }

}
