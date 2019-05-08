/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.brains;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**

 @author Mark Ferguson
 */
public class BrainsController implements Initializable {

  @FXML
  private CheckBox AGED;

  //<editor-fold defaultstate="collapsed" desc="FXVariables">
  @FXML
  private ComboBox<String> BRAINS;
  @FXML
  private TextField INT;
  @FXML
  private ComboBox<String> PARAMS;
  @FXML
  private Label c4;
  @FXML
  private CheckBox cb4emotions;
  @FXML
  private CheckBox cb4wafer;
  @FXML
  private TextField gened;
  @FXML
  private Label kcr;
  @FXML
  private Label l1;
  @FXML
  private Label l2;
  @FXML
  private Label l3;
  @FXML
  private Label l4;
  @FXML
  private Label l4About;
  @FXML
  private Label l5;
  @FXML
  private Label l6;
  @FXML
  private Label l7;
  @FXML
  private Label l4ages;
  @FXML
  private Label l4sleeps;
  @FXML
  private Label l4power;
  @FXML
  private Label l4wafer;
  @FXML
  private Label l4air;
  @FXML
  private Label l4temp;
  @FXML
  private Label l4pers;

  @FXML
  private Label l4cost;
  @FXML
  private Label l4int;
  @FXML
  private Label l4unit;
  @FXML
  private TextArea ta;
  @FXML
  private Label units;
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="FXMethods">
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    BRAINS.getItems().addAll(Braintypes);
    BRAINS.getSelectionModel().selectFirst();
    brainChange(ae);
//    cb4ParamsAction(ae);
//    calc();
  }

  @FXML
  private void brainChange(ActionEvent event) {
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
    for (int i = 0; i < Braintypes.length; i++) {
      if (BRAINS.getValue().contains(Braintypes[i])) {
        sel = i;
        System.out.println(Braintypes[i] + " - " + Intelligences[i] + " - " + KCr[i] + " - " + Units[i]);
        c4.setText(Intelligences[i]);
        kcr.setText(KCr[i]);
        units.setText(Units[i]);
        break;
      }
    }
    addParameters();
//    checkBoxes();
//    setIntel();
    cb4ParamsAction(ae);
    calc();
  }

  @FXML
  private void calcAddOns(MouseEvent event) {
    calc();
  }

  @FXML
  private void calcC4(ActionEvent event) {
    calc();
  }

  @FXML
  private void calculate(ActionEvent event) {
    calc();
  }

  @FXML
  private void cb4ParamsAction(ActionEvent event) {
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
    System.out.println(PARAMS.getValue());
    String sel = PARAMS.getValue();
    if (sel != null) {
      int num = 0;
      if (sel != null) {
        for (int i = 0; i < Parameters.length; i++) {
          if (Parameters[i][0].equals(sel)) {
            System.out.println("num = " + i);
            num = i;
            break;
          }
        }
      }
      l4ages.setText(Parameters[num][1]);
      l4sleeps.setText(Parameters[num][2]);
      l4power.setText(Parameters[num][3]);
      l4wafer.setText(Parameters[num][4]);
      l4air.setText(Parameters[num][5]);
      l4temp.setText(Parameters[num][6]);
      l4pers.setText(Parameters[num][7]);
      printDetails();
    }
  }

  @FXML
  private void intClick(MouseEvent event) {
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
    int num = 0;
    String s = c4.getText();
    System.out.println(s);
    if ("Original".equals(s)) {
      int a = Integer.parseInt(gened.getText());
      int b = Integer.parseInt(INT.getText());
      l4int.setText("" + (a + b));
    } else {
      String[] bits = new String[s.length()];
      for (int i = 0; i < s.length(); i++) {
        bits[i] = s.substring(i, i + 1);
      }
      for (int i = 0; i < bits.length; i++) {
        if ("G".equals(bits[i])) {
          num += Integer.parseInt(gened.getText());
        }
        if ("D".equals(bits[i])) {
          num += (int) (Math.random() * 6) + 1;
        }
      }
      if (!s.equals("")) {
        if (!s.contains("G")) {
          if (!s.contains("D")) {
            num = Integer.parseInt(s);
          }
        }
      }
      l4int.setText("" + num);
      costClick(me);
    }
  }

  @FXML
  private void costClick(MouseEvent event) {
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
    //kcr
//    String s = kcr.getText();
//    System.out.println(s);
//    if (s.contains("C4*")) {
    System.out.println("KCr[" + sel + "]" + KCr[sel]);
    if (c4.getText().contains("D")
      | c4.getText().contains("G")
      | BRAINS.getValue().startsWith("6 ")
      | BRAINS.getValue().startsWith("8 ")) {
      int mult = Integer.parseInt(KCr[sel].substring(3));
      System.out.println("mult = " + mult);
      int total = mult * Integer.parseInt(l4int.getText());
      System.out.println("total = " + total);
      kcr.setText("" + total);
    }

  }

  @FXML
  private void unitClick(MouseEvent event) {
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
    //units

  }

  @FXML
  private void randomC4(MouseEvent event) {
    int num = 0;
    for (int i = 0; i < 1; i++) {
      num += (int) (Math.random() * 6) + 1;
    }
    INT.setText("" + num);
    calc();
  }

  @FXML
  private void randomGenes(MouseEvent event) {
    int num = 0;
    for (int i = 0; i < 1; i++) {
      num += (int) (Math.random() * 6) + 1;
    }
    if (BRAINS.getValue().contains("Clone") | BRAINS.getValue().equals("1 Organic")) {
      gened.setText("" + num);
    }
    calc();
  }
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Variables">
  private Label[] parms = {l4ages, l4sleeps, l4power, l4wafer, l4air, l4temp, l4pers};
  private String[][] Parameters = {
    {"Type", "Ages", "Sleeps", "Power", "Wafers", "Air", "Temp.", "Personality"},
    {"Organic A", "Yes", "Yes", "Nutrient", "Yes", "Air", "C2H", "Natural"},
    {"Organic B", "Yes", "Yes", "Anerobic Nu.", "Yes", "", "", "Natural"},
    {"Clone A", "Yes", "Yes", "Nutrient", "Yes", "Air", "C2H", "Clone Implant"},
    {"Clone B", "Yes", "Yes", "Anerobic Nu.", "Yes", "", "", "Clone Implant"},
    {"Semi-Organic A", "Yes", "Yes", "Hybrid", "Yes", "Air", "C2H", "Clone Implant"},
    {"Semi-Organic B", "Yes", "Yes", "Anerobic Hybrid", "Yes", "", "C2H", "Clone Implant"},
    {"Electronic", "No", "No", "Electric", "No", "No", "C2H", "Written"},
    {"Positronic", "Yes", "No", "Self-Powered", "No", "No", "C2H", "Natural"}
  };
  //  String[] Braintypes = {"1 Organic Brain", "2 Organic Clone Brain", "3 Organic Clone Brain", "4 Organic Clone Brain", "5 Organic Clone Brain", "6 Semi-Organic Clone Brain", "7 Semi-Organic CloneBrain", "8 Semi-Organic Clone Brain", "9 Electronic Brain", "10 Electronic Brain", "11 Positronic Brain", "12 Positronic Brain", "13 Positronic Brain", "+ Wafer Jack", "+ Emotional"};
  //  String[] Intelligences = {"Original", "G", "G+D", "G+DD", "G+DDD", "1", "0+D", "0+DD", "D", "DD", "1", "D", "DD", "", ""};
  //  String[] KCr = {"30", "C4*10", "C4*10", "C4*10", "C4*10", "C4*10", "C4*10", "C4*20", "C4*10", "C4*20", "5", "C4*5", "C4*20", "1", "C4*10"};
  //  String[] Units = {"3", "1", "2", "3", "4", "1", "2", "3", "1", "2", "1", "2", "2", "0", "0"};
  //  String[][] BrainTable = {Braintypes, Intelligences, KCr, Units};
  //  String[] colnames = {"BrainType", "Intelligence", "KCr", "Units"};
  private String CRLF = "\n";
  private int sel = 0;
  private String[] Braintypes = {"1 Organic", "2 Clone", "3 Clone", "4 Clone", "5 Clone", "6 Semi-Organic", "7 Semi-Organic", "8 Semi-Organic", "9 Electronic", "10 Electronic", "11 Positronic", "12 Positronic", "13 Positronic"};
  private String[] Intelligences = {"Original", "G", "GD", "GDD", "GDDD", "1", "D", "DD", "D", "DD", "1", "D", "DD"};
  private String[] KCr = {"30", "C4*10", "C4*10", "C4*10", "C4*10", "C4*10", "C4*10", "C4*20", "C4*10", "C4*20", "5", "C4*5", "C4*20"};
  private String[][] organics = {Parameters[1], Parameters[2]};
  private String[][] clones = {Parameters[3], Parameters[4]};
  private String[][] semiorganics = {Parameters[5], Parameters[6]};
  private String[][] electronics = {Parameters[7]};
  private String[][] positronic = {Parameters[8]};
  private String[][] data = organics;
  private String[] Units = {"3", "1", "2", "3", "4", "1", "2", "3", "1", "2", "1", "2", "2"};
  private String[][] BrainTable = {Braintypes, Intelligences, KCr, Units};
  private String[] colnames = {"BrainType", "Intelligence", "KCr", "Units"};
  private String[] params = {"Organic A", "Organic B", "Clone A", "Clone B", "Semi-Organic", "Electronic", "Positronic"};
  private ActionEvent ae;
  private MouseEvent me;
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Methods">
  private void addParameters() {
    for (int i = 0; i < Parameters[0].length; i++) {
      System.out.print(Parameters[0][i] + "\t");
    }
    System.out.println("");
    if (BRAINS.getValue().contains("Organic")) {
      data = organics;
    }
    if (BRAINS.getValue().contains("Clone")) {
      data = clones;
    }
    if (BRAINS.getValue().contains("Semi")) {
      data = semiorganics;
    }
    if (BRAINS.getValue().contains("Electronic")) {
      data = electronics;
    }
    if (BRAINS.getValue().contains("Positronic")) {
      data = positronic;
    }
    PARAMS.getItems().clear();
    System.out.println("data.length" + " = " + data.length);
    for (int i = 0; i < data.length; i++) {
      System.out.println("data[" + i + "][0]" + " = " + data[i][0]);
      PARAMS.getItems().add(data[i][0]);
    }
    PARAMS.getSelectionModel().selectFirst();
  }

  private void calc() {
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
    l4int.setText("0");
    l4cost.setText("0");
    l4unit.setText("0");
    int intell = 0;
    int cost = 0;
    int unit = 0;

    if (cb4wafer.isSelected()) {
      cost += 1;
    }
    if (cb4emotions.isSelected()) {
      int c4 = Integer.parseInt(gened.getText());
      c4 += Integer.parseInt(INT.getText());
      cost += c4 * 10;
    }

    l4int.setText("" + intell);
    l4cost.setText("" + cost);
    l4unit.setText("" + unit);

    intClick(me);
    costClick(me);
    unitClick(me);
    printDetails();
  }

  @FXML
  private void printDetails() {
    ta.setText("");
    ta.appendText("BRAIN ID: ");
    ta.appendText(BRAINS.getValue());
    if (PARAMS.getValue().endsWith(" A") | PARAMS.getValue().endsWith(" B")) {
      String s = PARAMS.getValue();
      ta.appendText(s.substring(s.lastIndexOf(" ")));
    }
    if (cb4wafer.isSelected()) {
      ta.appendText("W");
    }
    if (cb4emotions.isSelected()) {
      ta.appendText("E");
    }
    ta.appendText(CRLF);
    // G
    ta.appendText("Genetic die:  " + gened.getText() + CRLF);
    // C4
    ta.appendText("Int die:  " + INT.getText() + CRLF);
    // INT
    ta.appendText("C4 Intelligence: " + l4int.getText() + CRLF);
    // Cost
    int a;
    int b;
    try {
      a = Integer.parseInt(KCr[sel]);
      b = Integer.parseInt(l4cost.getText());
      ta.appendText("Cost: " + (a + b) + CRLF);
    } catch (Exception e) {
      System.out.println("e = " + e);
      int mult = Integer.parseInt(l4int.getText());
      System.out.println("mult = " + mult);
      a = Integer.parseInt(KCr[sel].substring(3));
      System.out.println("a = " + a);
      b = Integer.parseInt(l4cost.getText());
      System.out.println("b = " + b);
      ta.appendText("Cost: " + ((a + b) * mult) + CRLF);
    }
    // Units
    a = Integer.parseInt(units.getText());
    b = Integer.parseInt(l4unit.getText());
    ta.appendText("Units: " + (a + b) + CRLF);
    // Parameters
    ta.appendText("PARAMETERS" + CRLF);
    String[] labels = {l1.getText(), l2.getText(), l3.getText(), l4.getText(), l5.getText(), l6.getText(), l7.getText()};
    Label[] outs = {l4ages, l4sleeps, l4power, l4wafer, l4air, l4temp, l4pers};
    for (int i = 0; i < outs.length; i++) {
      ta.appendText(labels[i] + " = " + outs[i].getText() + CRLF);
    }
    // Aging roll after 1year to settle INT
    int num = 0;
    if (AGED.isSelected()) {
      int d1 = (int) (Math.random() * 6) + 1;
      int d2 = (int) (Math.random() * 6) + 1;
      num = d1 - d2;
      ta.appendText("Aging after 1 year modifies INT by " + num + CRLF);
    }
    int number = Integer.parseInt(l4int.getText());
    number += num;
    ta.appendText("INT = " + number + CRLF);
  }
  //</editor-fold>

  @FXML
  private void showAbout() {
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
}
