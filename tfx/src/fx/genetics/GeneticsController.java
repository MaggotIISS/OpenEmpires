/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 //
 */
package fx.genetics;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 FXML Controller class

 @author Mark Ferguson
 */
public class GeneticsController implements Initializable {

  //<editor-fold defaultstate="collapsed" desc="FXvariables">
  @FXML
  private GridPane CLONE;
  @FXML
  private TextField CloneKid;
  @FXML
  private GridPane FATHER;
  @FXML
  private TextField FamilyName;
  @FXML
  private TextField FamilyName1;
  @FXML
  private TextField FamilyName11;
  @FXML
  private TextField FamilyName12;
  @FXML
  private TextField FamilyName2;
  @FXML
  private TextField FamilyName21;
  @FXML
  private TextField FamilyName22;
  @FXML
  private TextField FamilyName23;
  @FXML
  private TextField Gender1;
  @FXML
  private TextField Gender11;
  @FXML
  private TextField Gender111;
  @FXML
  private TextField Gender112;
  @FXML
  private TextField Gender12;
  @FXML
  private TextField Gender121;
  @FXML
  private TextField Gender122;
  @FXML
  private TextField Gender123;
  @FXML
  private GridPane MOTHER;
  @FXML
  private TextField Name1;
  @FXML
  private TextField Name11;
  @FXML
  private TextField Name111;
  @FXML
  private TextField Name112;
  @FXML
  private TextField Name12;
  @FXML
  private TextField Name121;
  @FXML
  private TextField Name122;
  @FXML
  private TextField Name123;
  @FXML
  private GridPane PARENT3;
  @FXML
  private GridPane PARENT4;
  @FXML
  private GridPane PARENT5;
  @FXML
  private GridPane PARENT6;
  @FXML
  private GridPane PC;
  @FXML
  private Button btn;
  @FXML
  private Button button;
  @FXML
  private CheckBox cb;
  @FXML
  private ComboBox<String> cb4gen;
  @FXML
  private ComboBox<String> cb4race;
  @FXML
  private ComboBox<String> cb4sex;
  @FXML
  private TextField contribs;
  @FXML
  private TextField dice;
  @FXML
  private TextField dna;
  @FXML
  private TextField dom;
  @FXML
  private TextField g1cu1;
  @FXML
  private TextField g1cu11;
  @FXML
  private TextField g1cu111;
  @FXML
  private TextField g1cu112;
  @FXML
  private TextField g1cu12;
  @FXML
  private TextField g1cu121;
  @FXML
  private TextField g1cu122;
  @FXML
  private TextField g1cu123;
  @FXML
  private TextField g1cu2;
  @FXML
  private TextField g1cu21;
  @FXML
  private TextField g1cu211;
  @FXML
  private TextField g1cu212;
  @FXML
  private TextField g1cu22;
  @FXML
  private TextField g1cu221;
  @FXML
  private TextField g1cu222;
  @FXML
  private TextField g1cu223;
  @FXML
  private TextField g1cu3;
  @FXML
  private TextField g1cu31;
  @FXML
  private TextField g1cu311;
  @FXML
  private TextField g1cu312;
  @FXML
  private TextField g1cu32;
  @FXML
  private TextField g1cu321;
  @FXML
  private TextField g1cu322;
  @FXML
  private TextField g1cu323;
  @FXML
  private TextField g1cu4;
  @FXML
  private TextField g1cu41;
  @FXML
  private TextField g1cu411;
  @FXML
  private TextField g1cu412;
  @FXML
  private TextField g1cu42;
  @FXML
  private TextField g1cu421;
  @FXML
  private TextField g1cu422;
  @FXML
  private TextField g1cu423;
  @FXML
  private TextField g1cu5;
  @FXML
  private TextField g1cu51;
  @FXML
  private TextField g1cu511;
  @FXML
  private TextField g1cu512;
  @FXML
  private TextField g1cu52;
  @FXML
  private TextField g1cu521;
  @FXML
  private TextField g1cu522;
  @FXML
  private TextField g1cu523;
  @FXML
  private TextField g1cu6;
  @FXML
  private TextField g1cu61;
  @FXML
  private TextField g1cu611;
  @FXML
  private TextField g1cu612;
  @FXML
  private TextField g1cu62;
  @FXML
  private TextField g1cu621;
  @FXML
  private TextField g1cu622;
  @FXML
  private TextField g1cu623;
  @FXML
  private TextField g1du1;
  @FXML
  private TextField g1du11;
  @FXML
  private TextField g1du111;
  @FXML
  private TextField g1du112;
  @FXML
  private TextField g1du12;
  @FXML
  private TextField g1du121;
  @FXML
  private TextField g1du122;
  @FXML
  private TextField g1du123;
  @FXML
  private TextField g1du2;
  @FXML
  private TextField g1du21;
  @FXML
  private TextField g1du211;
  @FXML
  private TextField g1du212;
  @FXML
  private TextField g1du22;
  @FXML
  private TextField g1du221;
  @FXML
  private TextField g1du222;
  @FXML
  private TextField g1du223;
  @FXML
  private TextField g1du3;
  @FXML
  private TextField g1du31;
  @FXML
  private TextField g1du311;
  @FXML
  private TextField g1du312;
  @FXML
  private TextField g1du32;
  @FXML
  private TextField g1du321;
  @FXML
  private TextField g1du322;
  @FXML
  private TextField g1du323;
  @FXML
  private TextField g1du4;
  @FXML
  private TextField g1du41;
  @FXML
  private TextField g1du411;
  @FXML
  private TextField g1du412;
  @FXML
  private TextField g1du42;
  @FXML
  private TextField g1du421;
  @FXML
  private TextField g1du422;
  @FXML
  private TextField g1du423;
  @FXML
  private TextField g1du5;
  @FXML
  private TextField g1du51;
  @FXML
  private TextField g1du511;
  @FXML
  private TextField g1du512;
  @FXML
  private TextField g1du52;
  @FXML
  private TextField g1du521;
  @FXML
  private TextField g1du522;
  @FXML
  private TextField g1du523;
  @FXML
  private TextField g1du6;
  @FXML
  private TextField g1du61;
  @FXML
  private TextField g1du611;
  @FXML
  private TextField g1du612;
  @FXML
  private TextField g1du62;
  @FXML
  private TextField g1du621;
  @FXML
  private TextField g1du622;
  @FXML
  private TextField g1du623;
  @FXML
  private TextField g1gu1;
  @FXML
  private TextField g1gu11;
  @FXML
  private TextField g1gu111;
  @FXML
  private TextField g1gu112;
  @FXML
  private TextField g1gu12;
  @FXML
  private TextField g1gu121;
  @FXML
  private TextField g1gu122;
  @FXML
  private TextField g1gu123;
  @FXML
  private TextField g1gu2;
  @FXML
  private TextField g1gu21;
  @FXML
  private TextField g1gu211;
  @FXML
  private TextField g1gu212;
  @FXML
  private TextField g1gu22;
  @FXML
  private TextField g1gu221;
  @FXML
  private TextField g1gu222;
  @FXML
  private TextField g1gu223;
  @FXML
  private TextField g1gu3;
  @FXML
  private TextField g1gu31;
  @FXML
  private TextField g1gu311;
  @FXML
  private TextField g1gu312;
  @FXML
  private TextField g1gu32;
  @FXML
  private TextField g1gu321;
  @FXML
  private TextField g1gu322;
  @FXML
  private TextField g1gu323;
  @FXML
  private TextField g1gu4;
  @FXML
  private TextField g1gu41;
  @FXML
  private TextField g1gu411;
  @FXML
  private TextField g1gu412;
  @FXML
  private TextField g1gu42;
  @FXML
  private TextField g1gu421;
  @FXML
  private TextField g1gu422;
  @FXML
  private TextField g1gu423;
  @FXML
  private TextField g1gu5;
  @FXML
  private TextField g1gu51;
  @FXML
  private TextField g1gu511;
  @FXML
  private TextField g1gu512;
  @FXML
  private TextField g1gu52;
  @FXML
  private TextField g1gu521;
  @FXML
  private TextField g1gu522;
  @FXML
  private TextField g1gu523;
  @FXML
  private TextField g1gu6;
  @FXML
  private TextField g1gu61;
  @FXML
  private TextField g1gu611;
  @FXML
  private TextField g1gu612;
  @FXML
  private TextField g1gu62;
  @FXML
  private TextField g1gu621;
  @FXML
  private TextField g1gu622;
  @FXML
  private TextField g1gu623;
  @FXML
  private Label l4About;
  @FXML
  private Label l4_1;
  @FXML
  private Label l4d;
  @FXML
  private Label l4dice;
  @FXML
  private Label l4dna;
  @FXML
  private Label l4droid;
  @FXML
  private Label l4genes;
  @FXML
  private Label l4len;
  @FXML
  private Label l4lineage;
  @FXML
  private Label l4mod;
  @FXML
  private Label l4n0;
  @FXML
  private Label l4n_1;
  @FXML
  private TextArea ta4out;
  @FXML
  private Label type;
  @FXML
  private TextField upp;

  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="FXMethods">
  @FXML
  private void getRace(ActionEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    System.out.println(cb4race.getValue());
    cb4sex.getItems().clear();
    ta4out.setEditable(false);
    dice.setEditable(false);
    Stagename = new String[]{"Infant  ", "Child", "Teen ", "YAdult",
      "Adult ", "Peak ", "Midlife", "Senior", "Elder", "Retired"};
    switch (cb4race.getValue()) {
      case "Human": {
        l4dice.setText("12");
        l4mod.setText("+0");
        l4genes.setText("SDEIES");
        cb4sex.getItems().addAll("Male", "Female");
        cb4sex.setValue("Female");
        Terms = new double[]{0.5, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        physical = 5;
        mental = 9;
//        hideLabels();
        break;
      }
      case "Vargr": {
        l4dice.setText("13");
        l4mod.setText("+0");
        l4genes.setText("SDVIES");
        cb4sex.getItems().addAll("Male", "Female");
        cb4sex.setValue("Male");
        Terms = new double[]{0.5, 1, 1, 2, 2, 2, 2, 1, 1, 1};
        physical = 5;
        mental = 9;
//        hideLabels();
        break;
      }
      case "Droyne": {
        l4dice.setText("11");
        l4mod.setText("+0");
        l4genes.setText("SAVIEK");
        cb4sex.getItems().addAll("Chirper", "Uncast", "Drone", "Worker",
          "Warrior", "Sport", "Technician", "Leader");
        cb4sex.setValue("Sport");
        Terms = new double[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        physical = 5;
        mental = 9;
//        hideLabels();
        break;
      }
      case "Aslan": {
        l4dice.setText("12");
        l4mod.setText("+1");
        l4genes.setText("SDEIES");
        cb4sex.getItems().addAll("Male", "Female");
        cb4sex.setValue("Male");
        Terms = new double[]{0.5, 1, 2, 2, 2, 2, 2, 2, 3, 3};
        physical = 5;
        mental = 9;
//        hideLabels();
        break;
      }
      case "K`kree": {
        l4dice.setText("14");
        l4mod.setText("+0");
        l4genes.setText("SDEIEK");
        cb4sex.getItems().addAll("Male", "Female", "Neuter");
        cb4sex.setValue("Male");
        Terms = new double[]{0.5, 1, 1, 1, 3, 2, 3, 3, 2, 1};
        physical = 5;
        mental = 9;
//        hideLabels();
        break;
      }
      case "Other": {
        dice.setEditable(true);
        l4dice.setText("12");
        l4mod.setText("+0");
        l4genes.setText("SDEIES");
        cb4sex.setValue("");
        Terms = new double[]{0.5, 2, 2, 2, 2, 2, 2, 2, 2, 2};
        physical = 5;
        mental = 9;
        ta4out.setEditable(true);
//        showLabels();
        break;
      }
      case "Hiver": {
        l4dice.setText("14");
        l4mod.setText("+0");
        l4genes.setText("SDSIEC");
        cb4sex.getItems().addAll("Male", "Female", "Neuter");
        cb4sex.setValue("Male");
        Terms = new double[]{0.5, 2, 1, 6, 6, 6, 6, 6, 6, 6};
        physical = 5;
        mental = 9;
//        hideLabels();
        break;
      }
      default: {

      }
    }
    if ("Sophontoid".equals(l4droid.getText())) {
      physical -= 1;
      mental -= 1;
    }
//    raceClick(me);
    printOutput();
  }

  @FXML
  private void raceClick(MouseEvent event) {
    if (event.getClickCount() > 1 & "Other".equals(cb4race.getValue())) {
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
      ta4out.setEditable(true);
    }
    printOutput();
  }

  //////////////////////////////////////////////
  @FXML
  private void cb4SexClick(ActionEvent event) {
    printOutput();
  }

  @FXML
  private void sexClick(MouseEvent event) {
    if (event.getClickCount() > 1) {
      if ("Other".equals(cb4race.getValue())) {
        String old = "";
        String reply = JOptionPane.showInputDialog("Enter Sex", "Male");
        for (int i = 0; i < cb4sex.getItems().size(); i++) {
          if (reply.equals(cb4sex.getItems().get(i))) {
            return;
          }
        }
        if (!"".equals(reply)) {
          cb4sex.getItems().add(reply);
        }
      }
    }
    printOutput();
  }

  //////////////////////////////////////////////
  @FXML
  private void cb4genClick(ActionEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    if (Gender1.getText().equals("")) {
      int sex = (int) (Math.random() * 6) + 1;
      if (sex == 1) {
        cb4sex.setValue("Male");
      }
      if (sex == 2) {
        cb4sex.setValue("Female");
      }
    }
    if ("SELF".equals(cb4gen.getValue())) {
      createSelf();
    } else if ("Clone".equals(cb4gen.getValue())) {
      createClone();
    } else if ("Parent".equals(cb4gen.getValue())) {
      createParents();
    } else if ("Child".equals(cb4gen.getValue())) {
      createChild();
    }
    printOutput();
  }

  @FXML
  private void dnaClick(MouseEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName();
        System.out.println(s);
      }
    }
    //</editor-fold>
    String string = "";
    String xna = upp.getText();
    String[] bits = new String[4];
    int[] num = new int[4];
    int[] dnas = new int[4];
    int[] rem = new int[4];
    for (int i = 0; i < bits.length; i++) {
      bits[i] = xna.substring(i, i + 1);
      num[i] = fromeHex(bits[i]);
      dnas[i] = 0;
      if (cb.isSelected()) {
        if (num[i] > 6) {
          dnas[i] = 6;
          rem[i] = num[i] - 6;
        } else {
          dnas[i] = num[i] - 1;
          rem[i] = 1;
        }
      } else if (num[i] == 6) {
        dnas[i] = 5;
        rem[i] = 1;
      } else {//5,4,3,2
        int d1 = 0;
        int d2 = 0;
        do {
          d1 = (int) (Math.random() * 6) + 1;
          d2 = (int) (Math.random() * 6) + 1;
        } while (d1 + d2 != num[i]);
        dnas[i] = d1;
        rem[i] = d2;
        pcdna[i].setText("" + dnas[i]);
      }
      string += "" + dnas[i];
      System.out.println("dna = " + dnas[i]);
      System.out.println("rem = " + rem[i]);
      System.out.println("num = " + num[i]);
    }
    System.out.println("string = " + string);
    dna.setText(string + "XX");
//    cleanGenes();
    domClick(event);
  }

  //////////////////////////////////////////////
  @FXML
  private void randomUpp(MouseEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    String dices = dice.getText();
    int[] stat = new int[6];
    String stats = "";
    System.out.println("randomUpp");
    if (!cb.isSelected()) {
      for (int i = 0; i < 6; i++) {
        int d = Integer.parseInt(dices.substring(i, i + 1));
        for (int j = 0; j < d; j++) {
          stat[i] += (int) (Math.random() * 6) + 1;
        }
        System.out.println(toeHex(stat[i]));
        stats += toeHex(stat[i]);
      }
    } else {
      for (int i = 0; i < 6; i++) {
        int d = Integer.parseInt(dices.substring(i, i + 1));
        stat[i] += (int) (Math.random() * 6) + 7;
        stats += toeHex(stat[i]);
      }
    }
    System.out.println("stats = " + stats);
    upp.setText(stats);
    for (int i = 0; i < pcupp.length; i++) {
      pcupp[i].setText(upp.getText().substring(i, i + 1));
    }
    domClick(event);
    dnaClick(event);
  }

  @FXML
  private void domClick(MouseEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    String Dominant = "";
    for (int i = 0; i < 4; i++) {
      Dominant += (int) (Math.random() * 2) + 1;
    }
    Dominant += "XX";
    System.out.println(Dominant);
    dom.setText(Dominant);
    for (int i = 0; i < Dominant.length(); i++) {
      String s = dom.getText().substring(i, i + 1);
      pcdom[i].setText(s);
    }
//    setParentGenes(dom.getText().substring(0, 4));
    TextField[] tfs = {g1gu1, g1gu2, g1gu3, g1gu4, g1gu5, g1gu6};
    TextField[] dads = {g1gu11, g1gu21, g1gu31, g1gu41, g1gu51, g1gu61};
    TextField[] mums = {g1gu12, g1gu22, g1gu32, g1gu42, g1gu52, g1gu62};
    String ss = dom.getText().substring(0, 4);
    for (int i = 0; i < ss.length(); i++) {
      if (ss.substring(i, i + 1).contains("1")) {
        System.out.println("Mother = " + tfs[i].getText());
        dads[i].setText(tfs[i].getText());
        mums[i].setText("");
      } else {
        System.out.println("Father = " + tfs[i].getText());
        mums[i].setText(tfs[i].getText());
        dads[i].setText("");
      }
    }
  }

  @FXML
  private void clearNames(MouseEvent event) {
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
    FamilyName.setText("");
    FamilyName1.setText("");
    FamilyName11.setText("");
    FamilyName12.setText("");
    FamilyName2.setText("");
    FamilyName21.setText("");
    FamilyName22.setText("");
    FamilyName23.setText("");
  }

  @FXML
  private void createSample() {
    FamilyName.setText("Sagaa");
    l4lineage.setText("M");
    /////////////////////////////////////////////////////////////////////////
    tfs = new TextField[]{g1cu1, g1cu2, g1cu3, g1cu4, g1cu5, g1cu6};
    dus = new TextField[]{g1du1, g1du2, g1du3, g1du4, g1du5, g1du6};
    gus = new TextField[]{g1gu1, g1gu2, g1gu3, g1gu4, g1gu5, g1gu6};
    Name1.setText("Marx");
    cb4sex.setValue("Male");
    Gender1.setText("Male");
    UPP = "676CAC";
    upp.setText(UPP);
    DNA = "4446XX";
    dna.setText(DNA);
    DOM = "2211XX";
    dom.setText(DOM);
    DICE = "222222";
    dice.setText(DICE);
    for (int i = 0; i < 6; i++) {
      mupps[i] = UPP.substring(i, i + 1);
      tfs[i].setText(mupps[i]);
      mdnas[i] = DNA.substring(i, i + 1);
      gus[i].setText(mdnas[i]);
      mdoms[i] = DOM.substring(i, i + 1);
      dus[i].setText(mdoms[i]);
    }
  }

  @FXML
  private void diceClick(MouseEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName();
        System.out.println(s);
      }
    }
    //</editor-fold>
    //    System.out.println(dice.getText());
    String c[] = new String[6];
    TextField[] tf = new TextField[]{g1du1, g1du2, g1du3, g1du4, g1du5, g1du6};
    int total = 0;
    for (int i = 0; i < 6; i++) {
      c[i] = dice.getText().substring(i, i + 1);
      int num = Integer.parseInt(c[i]);
      total += num;
    }
    l4dice.setText("" + total);
  }

  //////////////////////////////////////////////
  @FXML
  private void checkBest(ActionEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    if (cb.isSelected()) {
      cb.setText("Superior");
      cb.setTooltip(new Tooltip("6+1D"));
    } else {
      cb.setText("Standard");
      cb.setTooltip(new Tooltip("Random"));
    }
//    cleanGenes();
  }

  @FXML
  private void getStageLengths(MouseEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    for (int i = 0; i < stages; i++) {
      String reply = JOptionPane.showInputDialog("Enter Term length of Life Stage " + i, Terms[i]);
      Terms[i] = Double.parseDouble(reply);
    }
    printOutput();
  }

  @FXML
  private void l4diceClick(MouseEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    if ("Other".equals(cb4race.getValue())) {
      old = l4dice.getText();
      String text = JOptionPane.showInputDialog(null, "ENTER DICE", "12");
      System.out.println("text" + " = " + text);
      if (text.equals(null)) {
        l4dice.setText(old);
      }
      l4dice.setText(text);
      printOutput();
    }
  }

  @FXML
  private void l4dnaClick(MouseEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    old = l4dna.getText();
    if ("Other".equals(cb4race.getValue())) {
      //<editor-fold defaultstate="collapsed" desc="IFD">
      {
        String s = "";
        boolean DEBUG = true;  // true or false;
        if (DEBUG) { // true or false
          s += "//////////////////////////////////////////////" + CRLF;
          s += "\t" + Thread.currentThread().getStackTrace()[1]
            .getMethodName() + CRLF;
          System.out.print(s);
        }
      }
      //</editor-fold>
      String text = JOptionPane.showInputDialog(null, "ENTER XNA", "DNA");
      System.out.println("text" + " = " + text);
      l4dna.setText(text);
      if (text.equals(null)) {
        l4dna.setText(old);
      }
      printOutput();
    }
  }

  @FXML
  private void l4droidClick(MouseEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    //    String old = upp.getText();
    if ("Sophont".equals(l4droid.getText())) {
      l4droid.setText("Sophontoid");
      l4n_1.setText("Model Type");
      l4n0.setText("Model Type");
      if (cb.isSelected()) {
        upp.setText("8B8BXX");
      } else {
        upp.setText("6967XX");
      }
    } else {
      l4droid.setText("Sophont");
      l4n_1.setText("Family Name");
      l4n0.setText("Family Name");
      upp.setText("777777");
    }
    printOutput();
  }

  @FXML
  private void l4geneClick(MouseEvent event) {
    if ("Other".equals(cb4race.getValue())) {
      //<editor-fold defaultstate="collapsed" desc="IFD">
      {
        String s = "";
        boolean DEBUG = true;  // true or false;
        if (DEBUG) { // true or false
          s += "//////////////////////////////////////////////" + CRLF;
          s += "\t" + Thread.currentThread().getStackTrace()[1]
            .getMethodName() + CRLF;
          System.out.print(s);
        }
      }
      //</editor-fold>
      old = l4genes.getText();
      String text = JOptionPane.showInputDialog(null, "ENTER GENE", "SDEIES");
      System.out.println("text" + " = " + text);
      if (text.equals(null)) {
        l4genes.setText(text);
      }
      printOutput();
    }
  }

  @FXML
  private void l4modClick(MouseEvent event) {
    if ("Other".equals(cb4race.getValue())) {
      //<editor-fold defaultstate="collapsed" desc="IFD">
      {
        String s = "";
        boolean DEBUG = true;  // true or false;
        if (DEBUG) { // true or false
          s += "//////////////////////////////////////////////" + CRLF;
          s += "\t" + Thread.currentThread().getStackTrace()[1]
            .getMethodName() + CRLF;
          System.out.print(s);
        }
      }
      //</editor-fold>
      old = l4mod.getText();
      String text = JOptionPane.showInputDialog(null, "ENTER GENE", "SDEIES");
      System.out.println("text" + " = " + text);
      if (text.equals(null)) {
        l4mod.setText(text);
      }
      printOutput();
    }
  }

  @FXML
  private void lineageChange(MouseEvent event) {
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
    if ("M".equals(l4lineage.getText())) {
      l4lineage.setText("F");
    } else {
      l4lineage.setText("M");
    }
  }

  @FXML
  private void randomize(ActionEvent event) {
    mutate();
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
  private void typeChange(MouseEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    if ("Standard".equals(type.getText())) {
      type.setText("Solitaire");
    } else if ("Solitaire".equals(type.getText())) {
      type.setText("Risky");
    } else if ("Risky".equals(type.getText())) {
      type.setText("Standard");
    }
  }

  private void cleanGenes() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
//    FamilyName.setText("");
//    Name1.setText("");
//    Gender1.setText("");

    g1cu1.setText(upp.getText().substring(0, 1));
    g1cu2.setText(upp.getText().substring(1, 2));
    g1cu3.setText(upp.getText().substring(2, 3));
    g1cu4.setText(upp.getText().substring(3, 4));
    g1cu5.setText(upp.getText().substring(4, 5));
    g1cu6.setText(upp.getText().substring(5, 6));

    g1gu1.setText(dna.getText().substring(0, 1));
    g1gu2.setText(dna.getText().substring(1, 2));
    g1gu3.setText(dna.getText().substring(2, 3));
    g1gu4.setText(dna.getText().substring(3, 4));
    g1gu5.setText(dna.getText().substring(4, 5));
    g1gu6.setText(dna.getText().substring(5, 6));

    g1du1.setText(dom.getText().substring(0, 1));
    g1du2.setText(dom.getText().substring(1, 2));
    g1du3.setText(dom.getText().substring(2, 3));
    g1du4.setText(dom.getText().substring(3, 4));
    g1du5.setText(dom.getText().substring(4, 5));
    g1du6.setText(dom.getText().substring(5, 6));

    diceClick(me);
  }

  @FXML
  private void btnClick(ActionEvent event) {
    clearNames(me);
    printOutput();
    switch (cb4gen.getValue()) {
      case "SELF": {
        PC.setDisable(false);
        CLONE.setDisable(true);
        MOTHER.setDisable(true);
        FATHER.setDisable(true);
        createSelf();
        break;
      }
      case "Clone": {
        PC.setDisable(false);
        CLONE.setDisable(false);
        MOTHER.setDisable(true);
        FATHER.setDisable(true);
        createClone();
        break;
      }
      case "Child": {
        PC.setDisable(false);
        CLONE.setDisable(false);
        MOTHER.setDisable(false);
        FATHER.setDisable(false);
        if ("Male".equals(Gender1.getText())) {
          FATHER.setDisable(true);
        } else {
          MOTHER.setDisable(true);
        }
        createChild();
        break;
      }
      case "Parent": {
        PC.setDisable(false);
        CLONE.setDisable(true);
        MOTHER.setDisable(false);
        FATHER.setDisable(false);
        createParents();
        break;
      }
    }
    showLabels();
  }

  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="Variables">
  private String UPP = "";
  private String DNA = "";
  private String DOM = "";
  private String DICE = "";
  private MouseEvent me;
  private String[] mupps = new String[6];
  private String[] mdnas = new String[6];
  private String[] mdoms = new String[6];
  private TextField[] tfs;
  private TextField[] gus;
  private TextField[] dus;
  private String CRLF = "\n";
  private ActionEvent ae;
  private int stages;
  private String[] titles;
  private String[] Stagename;
  private double[] Terms;
  private double[] Start;
  private int physical = 5;
  private int mental = 9;
  TextField tf;
  TextField[] pcupp;
  TextField[] pcdna;
  TextField[] pcdom;

  TextField[] cloneupp;
  TextField[] clonedna;
  TextField[] clonedom;

  TextField[] mumupp;
  TextField[] mumdna;
  TextField[] mumdom;

  TextField[] dadupp;
  TextField[] daddna;
  TextField[] daddom;

  String old = "";

  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="Methods">
  private void createSelf() {
    randomUpp(me);
  }

  private void createClone() {
    l4_1.setText("CLONE GENETICS");
//    CloneKid.setText("Clone");
    FamilyName21.setText(FamilyName.getText() + " (Clone of " + Name1.getText() + ")");
    Gender121.setText(Gender1.getText());
    for (int i = 0; i < 4; i++) {
      clonedna[i].setText(pcdna[i].getText());
      clonedom[i].setText("0");
      int num = (int) (Math.random() * 6) + 1;
      int dnai = Integer.parseInt(clonedna[i].getText());
      int tot = num + dnai;
      cloneupp[i].setText("" + toeHex(tot));
    }

  }

  private void createChild() {
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
    createClone();
    if ("M".equals(l4lineage.getText())) {
      FamilyName21.setText(FamilyName.getText());
    }
    l4_1.setText("CHILD GENETICS");
    ///////////////////////////////////////////////
    for (int i = 0; i < 4; i++) {
      int yn = (int) (Math.random() * 2) + 1;
      clonedom[i].setText("" + yn);
      if ("Male".equals(Gender1.getText())) {
        //Clear Mothers genes
        tfs = mumdna;
      } else {
        //Clear Fathers genes
        tfs = daddna;
      }
      for (int j = 0; j < tfs.length; j++) {
        tfs[i].setText("");
      }

      int[] nums = new int[tfs.length];
      for (int j = 0; j < nums.length; j++) {
        nums[j] = (int) (Math.random() * 6) + 1;
      }
      ///////////////////////////////////////////////
      /*
       if pc is male, all 1`s in child are Mothers
       if pc is female, all 2`s in child are Fathers
       */
      ///////////////////////////////////////////////
      if ("Male".equals(Gender1.getText())) {
        tfs = clonedna;
        if ("2".equals(clonedom[i].getText())) {
          tfs[i].setText(pcdna[i].getText());
        } else {
          tfs[i].setText("" + ((int) (Math.random() * 6) + 1));
          mumdna[i].setText(tfs[i].getText());
        }
      }
      if ("Female".equals(Gender1.getText())) {
        tfs = clonedna;
        if ("1".equals(clonedom[i].getText())) {
          tfs[i].setText(pcdna[i].getText());
        } else {
          tfs[i].setText("" + ((int) (Math.random() * 6) + 1));
          daddna[i].setText(tfs[i].getText());
        }
      }
      int num = Integer.parseInt(tfs[i].getText());
      int rnd = (int) (Math.random() * 6 + 1);
      cloneupp[i].setText("" + toeHex((num + rnd)));
      ///////////////////////////////////////////////
      if ("Male".equals(Gender1.getText())) {
        fillFields("Male", mumdna);
      }
      if ("Female".equals(Gender1.getText())) {
        fillFields("Female", daddna);
      }

    }

    if ("Male".equals(Gender1.getText())) {
      MOTHER.setDisable(false);
    }
    if ("Female".equals(Gender1.getText())) {
      FATHER.setDisable(false);
    }
    int sex = (int) (Math.random() * 2) + 1;
    if (sex == 1) {
      Gender121.setText("Male");
    }
    if (sex == 2) {
      Gender121.setText("Female");
    }

  }

  private void createParents() {
    domClick(me);
    fillParent(1);
    fillParent(2);
  }

  private void fillParent(int i) {
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
    for (int j = 0; j < 4; j++) {
      switch (i) {
        case 1: {

          tfs = mumupp;
          gus = mumdna;
          dus = mumdom;
          break;
        }
        case 2: {

          tfs = dadupp;
          gus = daddna;
          dus = daddom;
          break;
        }
      }
      tfs[j].setText("");
      int sx = (int) (Math.random() * 2) + 1;
      if (pcdom[j].getText().equals("1")) {
        mumdna[j].setText(pcdna[j].getText());
        mumdom[j].setText("" + sx);
      }
      if (pcdom[j].getText().equals("2")) {
        daddna[j].setText(pcdna[j].getText());
        daddom[j].setText("" + sx);
      }
    }
    for (int j = 0; j < 4; j++) {
      if ("".equals(tfs[j].getText())) {
        int num = (int) (Math.random() * 6) + 1;
        tfs[j].setText("" + num);
      }
      if ("".equals(gus[j].getText())) {
        int num = (int) (Math.random() * 6) + 1;
        gus[j].setText("" + num);
      }
      if ("".equals(dus[j].getText())) {
        int num = (int) (Math.random() * 6) + 1;
        dus[j].setText("" + num);
      }
    }
  }

  //////////////////////////////////////////////
  private void fillFields(String sex, TextField[] tfs) {
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
    for (int i = 0; i < tfs.length; i++) {
      if ("".equals(tfs[i].getText())) {
        int num = (int) (Math.random() * 6) + 1;
        tfs[i].setText("" + num);
        System.out.println("tfs[" + i + "].getText()" + " = " + tfs[i].getText());
      }
    }
    TextField[] other = new TextField[tfs.length];
    TextField[] upps = new TextField[tfs.length];
    TextField[] doms = new TextField[tfs.length];

    if ("Male".equals(sex)) {
      other = mumdna;
      upps = mumupp;
      doms = mumdom;
    } else if ("Female".equals(sex)) {
      other = daddna;
      upps = dadupp;
      doms = daddom;
    }
    for (int i = 0; i < 4; i++) {
//      if ("".equals(other[i].getText())) {
      System.out.println("" + " = " + other[i].getText());
      int numa = Integer.parseInt(other[i].getText());
      int numb = (int) (Math.random() * 6) + 1;
      upps[i].setText("" + toeHex((numa + numb)));
      int sx = (int) (Math.random() * 2) + 1;
      doms[i].setText("" + sx);
//      } else {
//
//      }
    }
  }

  private int fromeHex(String s) {
    int n = 0;
    switch (s.toUpperCase()) {
      case "0": {
        n = 0;
        break;
      }
      case "1": {
        n = 1;
        break;
      }
      case "2": {
        n = 2;
        break;
      }
      case "3": {
        n = 3;
        break;
      }
      case "4": {
        n = 4;
        break;
      }
      case "5": {
        n = 5;
        break;
      }
      case "6": {
        n = 6;
        break;
      }
      case "7": {
        n = 7;
        break;
      }
      case "8": {
        n = 8;
        break;
      }
      case "9": {
        n = 9;
        break;
      }
      case "A": {
        n = 10;
        break;
      }
      case "B": {
        n = 11;
        break;
      }
      case "C": {
        n = 12;
        break;
      }
      case "D": {
        n = 13;
        break;
      }
      case "E": {
        n = 14;
        break;
      }
      case "F": {
        n = 15;
        break;
      }
      case "G": {
        n = 16;
        break;
      }
      case "H": {
        n = 17;
        break;
      }
      case "J": {
        n = 18;
        break;
      }
      case "K": {
        n = 19;
        break;
      }
      case "L": {
        n = 20;
        break;
      }
      case "M": {
        n = 21;
        break;
      }
      case "N": {
        n = 22;
        break;
      }
      case "O": {
        n = 23;
        break;
      }
      case "P": {
        n = 24;
        break;
      }
      case "Q": {
        n = 25;
        break;
      }
      case "R": {
        n = 26;
        break;
      }
      case "S": {
        n = 27;
        break;
      }
      case "T": {
        n = 28;
        break;
      }
      case "U": {
        n = 29;
        break;
      }
      case "V": {
        n = 30;
        break;
      }
      case "W": {
        n = 31;
        break;
      }
      case "X": {
        n = 32;
        break;
      }
      case "Y": {
        n = 33;
        break;
      }
      case "Z": {
        n = 34;
        break;
      }
      default: {
        n = -1;
      }
    }
    return n;
  }

  private void hideLabels() {
    l4d.setVisible(false);
    l4dice.setVisible(false);
    l4dna.setVisible(false);
//    l4droid.setVisible(false);
    l4genes.setVisible(false);
    l4mod.setVisible(false);
    l4len.setVisible(false);
  }

  private void mutate() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    for (int i = 0; i < 4; i++) {
      int num = rollFlux();
      String s = "";
      //<editor-fold defaultstate="collapsed" desc="switch (num)">
      switch (num) {
        case -6: {
          switch (type.getText()) {
            case "Standard": {
              s = "-2d";
              break;
            }
            case "Solitaire": {
              s = "-2d";
              break;
            }
            case "Risky": {
              s = "-6r";
              break;
            }
          }
          break;
        }
        case -5: {
          switch (type.getText()) {
            case "Standard": {
              s = "-2k";
              break;
            }
            case "Solitaire": {
              s = "-2c";
              break;
            }
            case "Risky": {
              s = "-5r";
              break;
            }
          }
          break;
        }
        case -4: {
          switch (type.getText()) {
            case "Standard": {
              s = "-1g";
              break;
            }
            case "Solitaire": {
              s = "-1";
              break;
            }
            case "Risky": {
              s = "-4r";
              break;
            }
          }
          break;
        }
        case -3: {
          switch (type.getText()) {
            case "Standard": {
              s = "r";
              break;
            }
            case "Solitaire": {
              s = "-1";
              break;
            }
            case "Risky": {
              s = "-3r";
              break;
            }
          }
          break;
        }
        case -2: {
          switch (type.getText()) {
            case "Standard": {
              s = "";
              break;
            }
            case "Solitaire": {
              s = "r";
              break;
            }
            case "Risky": {
              s = "-2r";
              break;
            }
          }
          break;
        }
        case -1: {
          switch (type.getText()) {
            case "Standard": {
              s = "";
              break;
            }
            case "Solitaire": {
              s = "";
              break;
            }
            case "Risky": {
              s = "-1";
              break;
            }
          }
          break;
        }
        case 0: {
          switch (type.getText()) {
            case "Standard": {
              s = "";
              break;
            }
            case "Solitaire": {
              s = "";
              break;
            }
            case "Risky": {
              s = "";
              break;
            }
          }
          break;
        }
        case 1: {
          switch (type.getText()) {
            case "Standard": {
              s = "";
              break;
            }
            case "Solitaire": {
              s = "";
              break;
            }
            case "Risky": {
              s = "";
              break;
            }
          }
          break;
        }
        case 2: {
          switch (type.getText()) {
            case "Standard": {
              s = "";
              break;
            }
            case "Solitaire": {
              s = "d";
              break;
            }
            case "Risky": {
              s = "";
              break;
            }
          }
          break;
        }
        case 3: {
          switch (type.getText()) {
            case "Standard": {
              s = "d";
              break;
            }
            case "Solitaire": {
              s = "+1";
              break;
            }
            case "Risky": {
              s = "";
              break;
            }
          }
          break;
        }
        case 4: {
          switch (type.getText()) {
            case "Standard": {
              s = "+1g";
              break;
            }
            case "Solitaire": {
              s = "+1";
              break;
            }
            case "Risky": {
              s = "+1";
              break;
            }
          }
          break;
        }
        case 5: {
          switch (type.getText()) {
            case "Standard": {
              s = "+1k";
              break;
            }
            case "Solitaire": {
              s = "+2c";
              break;
            }
            case "Risky": {
              s = "+2d";
              break;
            }
          }
          break;
        }
        case 6: {
          switch (type.getText()) {
            case "Standard": {
              s = "+2d";
              break;
            }
            case "Solitaire": {
              s = "+2d";
              break;
            }
            case "Risky": {
              s = "+3d";
              break;
            }
          }
          break;
        }
      }
      //</editor-fold>
      System.out.println(num + " = " + s);
    }
  }

  private void printOutput() {
    Gender1.setText(cb4sex.getValue());

    ta4out.setText("");
    ta4out.appendText(cb4race.getValue() + " " + cb4sex.getValue() + " "
      + l4droid.getText() + CRLF);
    ta4out.appendText(l4dna.getText() + " = " + l4genes.getText() + " ("
      + l4dice.getText() + "D" + l4mod.getText() + ")" + CRLF);
    for (int i = 0; i < cb4sex.getItems().size(); i++) {
      ta4out.appendText("GENDERS: " + cb4sex.getItems().get(i) + CRLF);
    }
    double prev = 0.0;
    for (int i = 0; i < titles.length; i++) {
      ta4out.appendText(titles[i] + "\t");
    }
    ta4out.appendText(CRLF);
    for (int i = 0; i < stages; i++) {
      Start[i] = prev;
      if (i > 0) {
        prev += (4.0 * Terms[i - 1]);
        Start[i] = prev;
      }
      ta4out.appendText(i + "\t" + Stagename[i] + "\t" + Terms[i] + "\t\t" + (int) Start[i] + "y" + CRLF);
    }
    int pa;
    int ma;
    if ("Sophont".equals(l4droid.getText())) {
      pa = physical;
      ma = mental;
    } else {
      pa = physical - 1;
      ma = mental - 1;
    }
    ta4out.appendText("Physical checks start @ Stage " + pa + " = " + Start[pa] + "y" + CRLF);
    ta4out.appendText("Mental checks start @ Stage " + ma + " = " + Start[ma] + "y" + CRLF);
    if ("Clone".equals(cb4gen.getValue())) {
      ta4out.appendText("Clones age 1 Term earlier (die younger)" + CRLF);
    }
    ta4out.appendText("PLUS Aging* checks EVERY TERM thereafter" + CRLF);
    ta4out.appendText("* Aging = Physical & Mental checks");
  }

  private int rollFlux() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    int total = 0;
    for (int i = 0; i < 2; i++) {
      int roll = (int) (Math.random() * 6) + 1;
      total += roll;
    }
    total -= 7;
    return total;
  }

  private void showLabels() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    l4d.setVisible(true);
    l4dice.setVisible(true);
    l4dna.setVisible(true);
//    l4droid.setVisible(true);
    l4genes.setVisible(true);
    l4mod.setVisible(true);
    l4len.setVisible(true);
  }

  private String toeHex(int i) {
    if (i < 10) {
      return "" + i;
    } else if (i == 10) {
      return "A";
    } else if (i == 11) {
      return "B";
    } else if (i == 12) {
      return "C";
    } else if (i == 13) {
      return "D";
    } else if (i == 14) {
      return "E";
    } else if (i == 15) {
      return "F";
    } else if (i == 16) {
      return "G";
    } else if (i == 17) {
      return "H";
    } else if (i == 18) {
      return "J";
    } else if (i == 19) {
      return "K";
    } else if (i == 20) {
      return "L";
    } else if (i == 21) {
      return "M";
    } else if (i == 22) {
      return "N";
    } else if (i == 23) {
      return "P";
    } else if (i == 24) {
      return "Q";
    } else if (i == 25) {
      return "R";
    } else if (i == 26) {
      return "S";
    } else if (i == 27) {
      return "T";
    } else if (i == 28) {
      return "U";
    } else if (i == 29) {
      return "V";
    } else if (i == 30) {
      return "W";
    } else if (i == 31) {
      return "X";
    } else if (i == 32) {
      return "Y";
    } else if (i == 33) {
      return "Z";
    } else {
      return null;
    }
  }

  private String getSex(int idx) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
//    Object[] possibleValues = {"First", "Second", "Third"};
//
//    Object selectedValue = JOptionPane.showInputDialog(null,
//      "Choose one", "Input",
//      JOptionPane.INFORMATION_MESSAGE, null,
//      possibleValues, possibleValues[0]);

    int reply = JOptionPane.showConfirmDialog(null, "Male?", "Male?", JOptionPane.YES_NO_CANCEL_OPTION);
    String string = "?";
    switch (reply) {
      case 0:
        string = "Male";
        break;
      case 1:
        string = "Female";
        break;
      default:
        int num = (int) (Math.random() * 2) + 1;
        if (num == 2) {
          string = "Male";
        } else if (num == 1) {
          string = "Female";
        }
        break;
    }
    switch (idx) {
      case -1: {
        Gender121.setText(string);
        break;
      }
      case 0: {
//        Gender1.setText(string);
        break;
      }
      default: {
        break;
      }
//      case 1: {
//        Gender11.setText(string);
//        break;
//      }
//      case 2: {
//        Gender12.setText(string);
//        break;
//      }
//      case 3: {
//        Gender111.setText(string);
//        break;
//      }
//      case 4: {
//        Gender122.setText(string);
//        break;
//      }
//      case 5: {
//        Gender112.setText(string);
//        break;
//      }
//      case 6: {
//        Gender123.setText(string);
//        break;
//      }
    }
    cb4sex.setValue(string);
    return string;
  }

  private void updateUPP(TextField[] tfss) {
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
    for (int i = 0; i < tfss.length; i++) {
      if (!"".equals(tfss[i].getText())) {
        System.out.println("" + i + " = " + tfss[i].getText());
      }
    }
  }
  //</editor-fold>

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    tf = new TextField();

    clonedna = new TextField[]{g1gu121, g1gu221, g1gu321, g1gu421, g1gu521, g1gu621};
    clonedom = new TextField[]{g1du121, g1du221, g1du321, g1du421, g1du521, g1du621};
    cloneupp = new TextField[]{g1cu121, g1cu221, g1cu321, g1cu421, g1cu521, g1cu621};

    pcupp = new TextField[]{g1cu1, g1cu2, g1cu3, g1cu4, g1cu5, g1cu6};
    pcdna = new TextField[]{g1gu1, g1gu2, g1gu3, g1gu4, g1gu5, g1gu6};
    pcdom = new TextField[]{g1du1, g1du2, g1du3, g1du4, g1du5, g1du6};

    mumupp = new TextField[]{g1cu11, g1cu21, g1cu31, g1cu41, g1cu51, g1cu61};
    mumdna = new TextField[]{g1gu11, g1gu21, g1gu31, g1gu41, g1gu51, g1gu61};
    mumdom = new TextField[]{g1du11, g1du21, g1du31, g1du41, g1du51, g1du61};

    dadupp = new TextField[]{g1cu12, g1cu22, g1cu32, g1cu42, g1cu52, g1cu62};
    daddna = new TextField[]{g1gu12, g1gu22, g1gu32, g1gu42, g1gu52, g1gu62};
    daddom = new TextField[]{g1du12, g1du22, g1du32, g1du42, g1du52, g1du62};

    contribs.setTooltip(new Tooltip("Gene Contributors"));
    dice.setTooltip(new Tooltip("Modify WHEN race == Other"));
    cb4sex.setTooltip(new Tooltip("Double Click to Add\nif RACE = Other"));
    UPP = "777777";
    cb4race.getItems().addAll("Human", "Vargr", "Droyne", "Aslan", "K`kree",
      "Other", "Hiver");
    cb4race.setValue("Human");
    cb4sex.setValue("Male");
    stages = 10;
    titles = new String[]{"#", "STAGE", "TERMS", "STARTS @"};
    Stagename = new String[stages];
    Terms = new double[stages];
    Start = new double[stages];
    getRace(ae);
    physical = 5;
    mental = 9;
    cb4race.setTooltip(new Tooltip("Select Race"));
    l4droid.setTooltip(new Tooltip("Select Type"));
//    hideLabels();
    cb.setTooltip(new Tooltip("Random"));
    cb4sex.setTooltip(new Tooltip("Gender"));
    cb4gen.setTooltip(new Tooltip("Create"));
    cb4gen.getItems().addAll("SELF", "Clone", "Child", "Parent");
    cb4sex.setValue("Female");
    cb4gen.setValue("SELF");
    PC.setDisable(false);
    CLONE.setDisable(false);
    MOTHER.setDisable(false);
    FATHER.setDisable(false);
    dice.setText("222222");
    createSample();
//    cleanGenes();
    randomUpp(me);
    printOutput();
  }

  public static void main(String[] args) {
    Genetics.main(args);
  }

}
