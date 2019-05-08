/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.personal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**

 @author Mark Ferguson
 */
public class PersonalController implements Initializable {

  @FXML
  private Button Button;
  @FXML
  private Button CALC;
  @FXML
  private CheckBox MOD1;
  @FXML
  private CheckBox MOD2;
  @FXML
  private ComboBox<String> Purpose;
  @FXML
  private ComboBox<String> Strategy;
  @FXML
  private ComboBox<String> Tactic;
  @FXML
  private ComboBox<String> Law;
  @FXML
  private TextField if1;
  @FXML
  private TextField if2;
  @FXML
  private Label l4About;
  @FXML
  private Label l4info;
  @FXML
  private TextField mod1;
  @FXML
  private TextField mod2;
  @FXML
  private Label result;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
//        s += "" + " = " + "";
        //s += "" + " = " + "";
        System.out.println(s);
      }
    }
    //</editor-fold>
    tables = new String[][]{
      {"STRATEGY", "INTERESTS", "ENEMIES", "LOGIC", "AUTHORITY", "MORALITY",
        "CULTURE", "EMOTION", "INDEBTED", "PAYMENT", "BEGGING", "POLITENESS",
        "FLATTERY", "REFERRAL", "FAMILIARITY", "INSULT", "PAIN"},
      {"Casual", "+3", "+2", "+0", "NO", "+0", "+0", "+0", "+0", "NO", "NO",
        "+0", "x2", "x2", "x2", "NO", "-8"},
      {"Enjoyment", "+0", "+0", "+0", "+0", "+0", "+0", "+0", "+0", "+0", "NO",
        "+0", "x2", "x2", "x2", "NO", "-6"},
      {"Discussion", "+0", "+0", "x2", "x2", "x2", "x2", "x2", "+0", "+0", "+0",
        "+0", "+0", "x2", "x2", "NO", "-6"},
      {"Listen", "+0", "+0", "+0", "+0", "+0", "+0", "+0", "+0", "+0",
        "+0", "+0", "+0", "+0", "+0", "+0", "-6"},
      {"Appeal", "+0", "+0", "x2", "+0", "x2", "x2", "x2", "+0", "x2", "x2",
        "x2", "x2", "+0", "+0", "+0", "+4*"},
      {"Will", "+0", "+0", "x2", "x2", "x2", "x2", "x2", "+0", "+0",
        "NO", "+0", "+0", "+0", "+0", "x2", "+6*"},
      {"Charm", "+0", "x3", "+0", "x2", "x2", "x2", "x2", "x2", "+0", "x2",
        "+0", "x2", "x2", "+0", "+0", "-4*"},
      {"Angry", "+0", "x3", "x2", "x2", "x2", "x2", "x2", "x2", "+0", "+0", "+0",
        "+0", "+0", "+0", "x2", "+6*"}
    };
    purpose.addAll("Carouse 1D", "Query 2D", "Persuade 3D", "Command 4D");
    Purpose.getItems().addAll(purpose);
    Strategy.disableProperty().set(true);
    Tactic.disableProperty().set(true);
    Law.disableProperty().set(true);

    Purpose.setTooltip(new Tooltip("Purpose"));
    Strategy.setTooltip(new Tooltip("Strategy"));
    Tactic.setTooltip(new Tooltip("Tactic"));
    Law.setTooltip(new Tooltip("Law"));
    calc(ae);
  }

  @FXML
  private void buttonClick(ActionEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
//        s += "" + " = " + "";
        //s += "" + " = " + "";
        System.out.println(s);
      }
    }
    //</editor-fold>

    Strategy.getItems().clear();
    Tactic.getItems().clear();
    Law.getItems().clear();

    Strategy.disableProperty().set(true);
    Tactic.disableProperty().set(true);
    Law.disableProperty().set(true);

    System.out.println(Button.getText().contains("*"));
  }

  @FXML
  private void calc(ActionEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
//        s += "" + " = " + "";
        //s += "" + " = " + "";
        System.out.println(s);
      }
    }
    //</editor-fold>
    try {
      String txt = Purpose.getValue().split(" ")[1] + " vs. ";
      txt += "(" + Strategy.getValue().split(" ")[1];
      txt += Tactic.getValue().split(" ")[1];
      txt += Law.getValue().split(" ")[1];
      if (MOD1.isSelected()) {
        txt += mod1.getText();
      }
      if (MOD2.isSelected()) {
        txt += mod2.getText();
      }
      txt += ")";
      CALC.setText(txt);
      String string = Purpose.getValue().split(" ")[1];
      int dice = Integer.parseInt(string.substring(0, 1));
      int roll = 0;
      for (int i = 0; i < dice; i++) {
        roll += (int) (Math.random() * 6) + 1;
      }
      System.out.println("your roll " + " = " + roll);
      result.setText("" + roll);
    } catch (Exception e) {
      CALC.setText("???");
    }
    System.out.println("contain * ? =" + Button.getText().contains("*"));
    System.out.println(CALC.getText());
    if (CALC.getText().contains("*")) {
      l4info.setVisible(true);
    } else {
      l4info.setVisible(false);
    }
  }

  @FXML
  private void purposeClick(ActionEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
        //s += "" + " = " + "";
        //s += "" + " = " + "";
        System.out.print(s);
      }
    }
    //</editor-fold>
//    System.out.println(Purpose.getValue());
    Strategy.getItems().clear();
    strategy.clear();
    if (Purpose.getValue().startsWith("Carouse")) {
      strategy.addAll("Casual 1", "Enjoyment 2", "Discussion 3", "Listen 4", "Appeal 5");
    } else if (Purpose.getValue().startsWith("Query")) {
      strategy.addAll("Enjoyment 1", "Discussion 2", "Listen 3", "Appeal 4", "Will 5");
    } else if (Purpose.getValue().startsWith("Persuade")) {
      strategy.addAll("Discussion 1", "Listen 2", "Appeal 3", "Will 4", "Charm 5");
    } else if (Purpose.getValue().startsWith("Command")) {
      strategy.addAll("Listen 1", "Appeal 2", "Will 3", "Charm 4", "Angry 5");
    }
    Strategy.getItems().addAll(strategy);
    Strategy.disableProperty().set(false);
    int start = Purpose.getValue().indexOf(" ") + 1;
    int dice = Integer.parseInt(Purpose.getValue().substring(start, start + 1));
//    System.out.println("dice" + " = " + dice);
    calc(ae);
  }

  @FXML
  private void showAbout(MouseEvent event) {
    JFrame jf = new JFrame();
    String txt = "ABOUT\n"
      + "\n"
      + "Programmed by Mark Ferguson	(maggot.iiss@sky.com)\n"
      + "\n"
      + "https://github.com/MaggotIISS\n"
      + "\n"
      + "The Traveller game in all forms is owned by Far Future Enterprises. \n"
      + "Copyright 1977 - 20016 Far Future Enterprises. \n"
      + "\n"
      + "Traveller is a registered trademark of Far Future Enterprises. \n"
      + "Far Future permits web sites and fanzines for this game, provided \n"
      + "it contains this notice, that Far Future is notified, and subject \n"
      + "to a withdrawal of permission on 90 days notice. \n"
      + "\n"
      + "The contents of this site are for personal, non-commercial use only. \n"
      + "\n"
      + "Any use of Far Future Enterprises's copyrighted material or \n"
      + "trademarks anywhere on this web site and its files should not \n"
      + "be viewed as a challenge to those copyrights or trademarks. \n"
      + "In addition, any program/articles/file on this site cannot be \n"
      + "republished or distributed without the consent of \n"
      + "the author who contributed it.\n";
    JTextArea jta = new JTextArea(txt, 50, 50);
    jta.setEditable(false);
    JScrollPane jsp = new JScrollPane(jta);
    jf.getContentPane().add(jsp);
    jf.setSize(500, 500);
    jf.setLocation(300, 300);
    jf.setVisible(true);
  }

  @FXML
  private void strategyClick(ActionEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
        //s += "" + " = " + "";
        //s += "" + " = " + "";
        System.out.print(s);
      }
    }
    //</editor-fold>
//    System.out.println(Purpose.getValue());
    Tactic.getItems().clear();
    tactic.clear();
    strings = new String[]{"Interests", "Enemies", "Logic", "Authority", "Morality",
      "Culture", "Emotion", "Indebted", "Payment", "Begging", "Politeness",
      "Flattery", "Referral", "Familiarity", "Insult", "Pain"};
    int start = Purpose.getValue().indexOf(" ") + 1;
    String purpose = Purpose.getValue().substring(0, Purpose.getValue().indexOf(" "));
//    System.out.println("purpose" + " = " + purpose);
    int dice = Integer.parseInt(Purpose.getValue().substring(start, start + 1));
//    System.out.println("dice" + " = " + dice);
    try {
      String strat = Strategy.getValue().substring(0, Strategy.getValue().indexOf(" ")).trim();
//      System.out.println("strategy" + " = " + strat);
      for (int i = 1; i < tables.length; i++) {
        if (strat.equals(tables[i][0])) {
//          System.out.println("tables[" + i + "][0]" + " = " + tables[i][0]);
          for (int j = 0; j < strings.length; j++) {
            tactic.add(strings[j] + " " + tables[i][j + 1]);
          }
        }
      }
    } catch (Exception e) {
      System.out.println("154" + " = " + e);
    }
    Tactic.getItems().addAll(tactic);
    Tactic.disableProperty().set(false);
//    System.out.println(Tactic.getValue());
    calc(ae);
  }

  @FXML
  private void tacticClick(ActionEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    Law.getItems().clear();
    law.clear();
    String[] lawstrings = {"None", "Similarity", "Superiority", "Inferiority", "Comfort", "Violence"};
    String[][] laws = new String[][]{
      {"LAW", "CAROUSE", "QUERY", "PERSUADE", "COMMAND"},
      //      {"None", "+0", "+0", "+0", "+0"},
      {"Similarity", "+1", "+1", "+1", "+0"},
      {"Superiority", "+0", "+1", "+2", "+3"},
      {"Inferiority", "+0", "+1", "+2*", "+0"},
      {"Comfort", "+2", "+1", "+1", "+0"},
      {"Violence", "+0", "+1", "+2", "+3"}
    };
    int end = Purpose.getValue().indexOf(' ');
    String purp = Purpose.getValue().substring(0, end);
    System.out.println("purp" + " = " + purp);
    int column = 0;
    switch (purp) {
      case "Carouse": {
        column = 1;
        break;
      }
      case "Query": {
        column = 2;
        break;
      }
      case "Persuade": {
        column = 3;
        break;
      }
      case "Command": {
        column = 4;
        break;
      }
    }
    System.out.println("column" + " = " + column);
    System.out.println("" + " = ");
    int line = 0;
    for (line = 1; line <= laws[0].length; line++) {
      System.out.println("line" + " = " + line);
      System.out.println("laws[" + line + "][0]" + " = " + laws[line][0]);
      System.out.println("laws[" + line + "][" + column + "]" + " = " + laws[line][column]);
      System.out.println("" + " = ");
      law.add(laws[line][0] + " " + laws[line][column]);
    }
    Law.getItems().addAll(law);
    Law.disableProperty().set(false);
    calc(ae);
  }

  @FXML
  private void lawClick(ActionEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
        //s += "" + " = " + "";
        //s += "" + " = " + "";
        System.out.print(s);
      }
    }
    //</editor-fold>
    calc(ae);
  }

  @FXML
  private void mod1Click(ActionEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
        //s += "" + " = " + "";
        //s += "" + " = " + "";
        System.out.println(s);
      }
    }
    //</editor-fold>
    if (MOD1.isSelected()) {
    } else {
      reset(1);
    }
    System.out.println("mod1.getText()" + " = " + mod1.getText());
    System.out.println("if1.getText()" + " = " + if1.getText());
    calc(ae);
  }

  @FXML
  private void mod2Click(ActionEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    if (MOD2.isSelected()) {
    } else {
      reset(2);
    }
    System.out.println("mod2.getText()" + " = " + mod2.getText());
    System.out.println("if2.getText()" + " = " + if2.getText());
    calc(ae);
  }

  private final ObservableList<String> purpose = FXCollections.observableArrayList();
  private final ObservableList<String> strategy = FXCollections.observableArrayList();
  private final ObservableList<String> tactic = FXCollections.observableArrayList();
  private final ObservableList<String> law = FXCollections.observableArrayList();
  private String[][] tables;
  private Label[] labels;
  private String[] strings;
  private final int pur = 0;
  private final String CRLF = "\n";
  private ActionEvent ae;

  private void reset(int i) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
//        s += "" + " = " + "";
        //s += "" + " = " + "";
        System.out.println(s);
      }
    }
    //</editor-fold>
    TextField tf = new TextField();
    TextField stf = new TextField();
    if (i == 1) {
      mod1.setText("+1");
      tf = mod1;
      stf = if1;
    } else {
      mod2.setText("-1");
      tf = mod2;
      stf = if2;
    }
    stf.setText("Value Op Num");
    l4info.setText("0");
  }
}
