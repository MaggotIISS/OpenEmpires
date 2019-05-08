/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.xmultimap;

import dbviewer.globals.GlobalMethods;
import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static panels.Panel4T5Locator.stylesheet;

/**

 @author Mark Ferguson
 */
public class MultiMap extends Application implements Initializable {

  //<editor-fold defaultstate="collapsed" desc="STRINGARRAYS">
  public static final String[][] STRINGARRAYS = new String[][]{
    ////////////////////////////////////////////////////////////////////////////
    {"Who", "Name", "ID", "Age", "Race", "Sex", "Career", "Terms", "UPP",
      "Notes"},
    ////////////////////////////////////////////////////////////////////////////
    {"What", "Armour", "Weapon", "Vehicle", "Spacecraft", "Starship", "Orbital"},
    ////////////////////////////////////////////////////////////////////////////
    {"Why", "Fight", "Shoot", "Drive", "Fly", "Travel"},
    ////////////////////////////////////////////////////////////////////////////
    {"Where", "Sector", "Subsector", "System", "Star", "Satellite", "SubSat",
      "Station", "Ship", "Structure", "Suit"},
    ////////////////////////////////////////////////////////////////////////////
    {"When", "Year", "Week", "Day", "Hour", "Minute", "Second"},
    ////////////////////////////////////////////////////////////////////////////
    //  GEAR & GADGETS
    ////////////////////////////////////////////////////////////////////////////
    {"Weapon", "Name", "Type", "Skill", "Rounds", "Range"},
    ////////////////////////////////////////////////////////////////////////////
    {"Vehicle", "MCr", "Mass", "Men", "Speed", "Range"},
    ////////////////////////////////////////////////////////////////////////////
    {"Spaceship", "MCr", "Mass", "Men", "Speed", "Range"},
    ////////////////////////////////////////////////////////////////////////////
    {"Starship", "MCr", "Mass", "Men", "Speed", "Range"},
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    {"With", "Crew", "Imperium", "Person", "Group", "SPA", "Corporation",
      "MegaCorp"},
    ////////////////////////////////////////////////////////////////////////////
    {"Counter", "Title", "t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8", "t9",
      "t10", "t11", "t12", "t13", "t14", "t15", "t16", "t17", "t18", "t19",
      "t20", "pic1"},
    ////////////////////////////////////////////////////////////////////////////
    {"Groups", "Team", "Crew", "Section", "Department", "t4", "t5", "t6", "t7",
      "t8", "t9",
      "t10", "t11", "t12", "t13", "t14", "t15", "t16", "t17", "t18", "t19",
      "t20", "pic1"},
    ////////////////////////////////////////////////////////////////////////////
    {"ComboMaps", "Who", "What", "Why", "Where", "When", "With", "Counter",
      "ComboMaps"},
    ////////////////////////////////////////////////////////////////////////////
    {"Locations", "Starport", "Startown", "Station", "Section", "Career",
      "Terms", "UPP", "Notes"},
    ////////////////////////////////////////////////////////////////////////////
    {"Address", "Name", "Street", "Town", "Postcode", "County"},
    ////////////////////////////////////////////////////////////////////////////
    {"Contact", "Name", "ID", "Phone", "email"},
    ////////////////////////////////////////////////////////////////////////////
    {"1D6", "1", "2", "3", "4", "5", "6"},
    ////////////////////////////////////////////////////////////////////////////
    {"2D6", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"},
    ////////////////////////////////////////////////////////////////////////////
    {"3D6", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
      "15", "16", "17", "18"},
    ////////////////////////////////////////////////////////////////////////////
    {"Dice Rolls", "1d6", "2d6", "3d6", "Good Flux", "Bad Flux", "Flux"},
    ////////////////////////////////////////////////////////////////////////////
    {"Percentages", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100"},
    ////////////////////////////////////////////////////////////////////////////
    {"Appearance", "Height", "Weight", "Hair", "Eyes", "Appearance"},
    ////////////////////////////////////////////////////////////////////////////
    {"Frequency", "Common", "Uncommon", "Rare"},
    ////////////////////////////////////////////////////////////////////////////
    {"MegaCorps", "Zirunkariish", "Makhidkarun", "General"},
    ////////////////////////////////////////////////////////////////////////////
    {"UWP", "Starport", "Size", "Atmosphere", "Hydrosphere", "Government",
      "Law Level", "Tech Level"},
    ////////////////////////////////////////////////////////////////////////////
    {"UPP", "Strength", "Dexterity", "Endurance", "Intelligence", "Education",
      "Social"},
    ////////////////////////////////////////////////////////////////////////////
    {"UPP", "Strength", "Dexterity", "Endurance", "Intelligence", "Education",
      "Social"}
  ////////////////////////////////////////////////////////////////////////////
  };
  //</editor-fold>
  public String[] groups = new String[STRINGARRAYS.length];

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  private String CRLF = "\n";
  @FXML
  Button button;
  private ActionEvent ae;
  @FXML
  private ComboBox<String> combobox;
  @FXML
  private Label label;
  @FXML
  private Label openlabel;
  @FXML
  private Label savelabel;
  @FXML
  private TextArea textarea;
  private final ObservableList<String> list = FXCollections
    .observableArrayList();

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    createList();
    button.setVisible(false);
    label.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        labelClick(event);
      }

    });
  }

  private void createList() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    groups = new String[STRINGARRAYS.length];
    for (int i = 0; i < STRINGARRAYS.length; i++) {
      groups[i] = STRINGARRAYS[i][0];
      list.add(STRINGARRAYS[i][0]);
    }
    combobox.setItems(list);
  }

  @Override
  public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("MultiMap.fxml"));
    Scene scene = new Scene(root);
    scene.setUserAgentStylesheet(stylesheet);
    stage.setScene(scene);
    stage.show();
  }
  private int group = 0;
  private int[] members = new int[STRINGARRAYS.length];

  @FXML
  private void cbaction(ActionEvent event) {
    label.setText(combobox.getValue().toUpperCase() + CRLF);
    textarea.setText("");
    for (int i = 0; i < STRINGARRAYS.length; i++) {
      if (combobox.getValue().equals(STRINGARRAYS[i][0])) {
        for (int j = 1; j < STRINGARRAYS[i].length; j++) {
          textarea.appendText(STRINGARRAYS[i][j] + CRLF);
        }
        break;
      }
    }
    button.fire();
  }

  @FXML
  private void comboClick(MouseEvent event) {
    if (event.getClickCount() > 1) {
      //<editor-fold defaultstate="collapsed" desc="IFD">
      {
        String s = "";
        boolean DEBUG = true;  // true or false;
        if (DEBUG) { // true or false
          s += "//////////////////////////////////////////////" + CRLF;
          s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
            + CRLF;
          s += "event.getClickCount()" + " = " + event.getClickCount() + CRLF;
          System.out.print(s);
        }
      }
      //</editor-fold>
      showTexts("lower");
      //();
    }
  }

  @FXML
  private void labelClick(MouseEvent event) {
    try {
      showTexts("upper");
    } catch (Exception e) {
      //<editor-fold defaultstate="collapsed" desc="JOP">
//      {
//        String s = "";
//        s += e + CRLF;
//        s += "" + CRLF;
//        JTextArea jta = new JTextArea(s, 50, 80);
//        JScrollPane jsp = new JScrollPane(jta);
//        JOptionPane.showMessageDialog(null, jsp);
//      }
      //</editor-fold>
    } finally {
    }
  }

  @FXML
  private void openlabelClick(MouseEvent event) {
    openClick();
  }

  private void openClick() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
  }
  String d = "C:/T5/_CSV/";
  String f = "1705 Efate";
  String e = ".csv";
  String newsplit = ": ";
  String oldsplit = "\",\"";
  File file = new File(d + f + e);
  String[] parts;
  String string;

  private void saveClick() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    if (!file.exists()) {
      System.out.println("file.exists()" + " = " + file.exists());
    }
    d = "C://T5/_CSV/";
    f = combobox.getValue();
    e = ".csv";
    showEm();
    file = new File(d + f + e);
    System.out.println(file.toString());
    String text = textarea.getText();
    String[] lines = text.split(CRLF);
    int types = 5;
    for (int type = 0; type < types; type++) {
      textarea.setText("");
      switch (type) {
        case 0: {
          f = combobox.getValue();
          e = ".csv";
          lines = text.split(CRLF);
          showEm();
          for (int i = 0; i < lines.length; i++) {
            System.out.println("  " + lines[i]);
            try {
              parts = lines[i].trim().split(oldsplit);
              textarea.appendText("\"" + parts[0] + "\"" + CRLF);
            } catch (Exception e) {
              System.out.println("  " + " = " + e);
              //<editor-fold defaultstate="collapsed" desc="JOP">
              {
                String s = "316" + CRLF;
                s += e + CRLF;
                s += "" + CRLF;
                JTextArea jta = new JTextArea(s, 50, 80);
                JScrollPane jsp = new JScrollPane(jta);
                JOptionPane.showMessageDialog(null, jsp);
              }
              //</editor-fold>
            }
          }
          saveFile(textarea.getText(), d, f, e);
          break;
        }
        case 1: {
          f = combobox.getValue() + "Keys";
          e = ".txt";
          showEm();
          lines = text.split(CRLF);
          for (int i = 0; i < lines.length; i++) {
            parts = lines[i].trim().split(oldsplit);
            System.out.println(parts[0]);
            try {
              textarea.appendText(parts[0] + CRLF);
            } catch (Exception e) {
              System.out.println("" + " = " + e);
            }
          }
          saveFile(textarea.getText(), d, f, e);
          break;
        }
        case 2: {
          f = combobox.getValue() + "Values";
          e = ".txt";
          showEm();
          lines = text.split(CRLF);
          for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
            parts = lines[i].trim().split(oldsplit);
            if (parts.length > 1) {
              try {
                textarea.appendText(parts[1] + CRLF);
              } catch (Exception e) {
                System.out.println("" + " = " + e);
                //<editor-fold defaultstate="collapsed" desc="JOP">
//              {
//                String s = "358";
//                s += d + CRLF;
//                s += f + CRLF;
//                s += e + CRLF;
//                JTextArea jta = new JTextArea(s, 50, 80);
//                JScrollPane jsp = new JScrollPane(jta);
//                JOptionPane.showMessageDialog(null, jsp);
//              }
                //</editor-fold>
              }
            } else {
              textarea.appendText(parts[0] + CRLF);
            }
          }
          saveFile(textarea.getText(), d, f, e);
          break;
        }
        case 3: {
          f = combobox.getValue() + "Pairs";
          e = ".txt";
          showEm();
          lines = text.split(CRLF);
          for (int i = 0; i < lines.length; i++) {
            System.out.println("lines[" + i + "]" + lines[i]);
            parts = lines[i].trim().split(oldsplit);
            try {
              textarea.appendText(parts[0].toUpperCase() + "-" + parts[0]
                .substring(0, parts[0].length() - 1).toLowerCase() + CRLF);
            } catch (Exception e) {
              //<editor-fold defaultstate="collapsed" desc="JOP">
//              {
//                String s = "";
//                s += "" + CRLF;
//                s += "" + CRLF;
//                JTextArea jta = new JTextArea(s, 50, 80);
//                JScrollPane jsp = new JScrollPane(jta);
//                JOptionPane.showMessageDialog(null, jsp);
//              }
              //</editor-fold>
            }
          }
          saveFile(textarea.getText(), d, f, e);
          break;
        }
        case 4: {
          f = combobox.getValue() + "Blank";
          e = ".txt";
          lines = text.split(CRLF);
          showEm();
          for (int i = 0; i < lines.length; i++) {
            System.out.println(lines[i]);
            parts = lines[i].trim().split(oldsplit);
            try {
              textarea.appendText(parts[0] + CRLF);
            } catch (Exception e) {
              //<editor-fold defaultstate="collapsed" desc="JOP">
              {
                String s = "";
                s += e + CRLF;
                s += "" + CRLF;
                JTextArea jta = new JTextArea(s, 50, 80);
                JScrollPane jsp = new JScrollPane(jta);
                JOptionPane.showMessageDialog(null, jsp);
              }
              //</editor-fold>
            }

            for (int j = 0; j < parts.length; j++) {
            }
          }
          saveFile(textarea.getText(), d, f, e);
          break;
        }
        default: {
          //<editor-fold defaultstate="collapsed" desc="JOP">
          {
            String s = "";
            s += "373" + CRLF;
            s += "" + CRLF;
            JTextArea jta = new JTextArea(s, 50, 80);
            JScrollPane jsp = new JScrollPane(jta);
            JOptionPane.showMessageDialog(null, jsp);
          }
          //</editor-fold>
        }
      }
    }

//    saveFile(textarea.getText(), d, f, e);
//    save Detail
  }

  private void saveFile(String text, String d, String f, String e) {
    GlobalMethods.saveTextFile(d, f, e, text);
  }

  @FXML
  private void savelabelClick(MouseEvent event) {
    saveClick();
  }

  private void showEm() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
//    {
//      String s = "";
//      boolean DEBUG = true;  // true or false;
//      if (DEBUG) { // true or false
//        s += "//////////////////////////////////////////////" + CRLF;
//        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
//          + CRLF;
//        System.out.print(s);
//      }
//    }
//    //</editor-fold>
//    System.out.println("410 DFE = " + d + f + e);
  }

  private void showTexts(String string) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    for (int i = 0; i < STRINGARRAYS.length; i++) {
      if (!"".equals(combobox.getValue().toLowerCase())) {
        if (STRINGARRAYS[i][0].toLowerCase().equals(combobox.getValue()
          .toLowerCase())) {
          textarea.setText("");
          for (int j = 1; j < STRINGARRAYS[i].length; j++) {
            System.out.println(STRINGARRAYS[i][j]);
//            textarea.appendText(STRINGARRAYS[i][j] + CRLF);
            switch (string) {
              case "upper": {
                textarea.appendText(STRINGARRAYS[i][j].toUpperCase() + CRLF);
                break;
              }
              case "lower": {
                textarea.appendText(STRINGARRAYS[i][j].toLowerCase() + CRLF);
                break;
              }
              case "": {
                textarea.appendText(STRINGARRAYS[i][j] + CRLF);
                cbaction(ae);
              }
            }
          }
          System.out.println("");
        }
      }
    }
  }
  private Set<String> keys;

  public Set<String> getKeys() {
    return keys;
  }

  public void setKeys(Set<String> set) {
    keys = set;
  }
  Map<String, String> map = new HashMap<>();

  public Map<String, String> getMap() {
    return map;
  }

  public void setMap(Map<String, String> amap) {
    map = amap;
  }
  private Collection<String> values;

  public Collection<String> getValues() {
    return values;
  }

  @FXML
  private void buttonClick(ActionEvent event) {
    System.out.println("buttonClick");
    map = new HashMap<>();
    String[] lines = textarea.getText().split(CRLF);
    textarea.setText("");
    for (int i = 0; i < lines.length; i++) {
      map.put(lines[i].toUpperCase(), lines[i].toLowerCase());
      textarea.appendText(lines[i].toUpperCase() + newsplit + "" + CRLF);
    }
    keys = map.keySet();
    values = map.values();
    System.out.println("  list.toString()" + " = " + list.toString());
    System.out.println("combobox.getValue()" + " = " + combobox.getValue());
    System.out.println("keys.toString()" + " = " + keys.toString());
    System.out.println("values.toString()" + " = " + values.toString());
  }

  public void setValues(Collection<String> list) {
    values = list;
  }
}
