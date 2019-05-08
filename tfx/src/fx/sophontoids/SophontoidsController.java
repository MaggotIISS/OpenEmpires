/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.sophontoids;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**

 @author Mark Ferguson
 */
public class SophontoidsController implements Initializable {

  @FXML
  private ComboBox<String> Control;
  @FXML
  private TextField NUM;
  @FXML
  private ComboBox<String> Obtrusive;
  @FXML
  private ComboBox<String> Race;
  @FXML
  private TextField STR;
  @FXML
  private TextField DEX;
  @FXML
  private TextField END;
  @FXML
  private TextField INT;
  @FXML
  private ComboBox<String> SkillSet;
  @FXML
  private TextArea SkillTxt;
  @FXML
  private ComboBox<String> Skills;
  @FXML
  private ComboBox<String> Unobtrusive;
  @FXML
  private ComboBox<String> Dice;
  @FXML
  private Label l4About;
  @FXML
  private Label l4c1;
  @FXML
  private Label l4c2;
  @FXML
  private Label l4c3;
  @FXML
  private Label l4c4;
  @FXML
  private Label l4cost;
  @FXML
  private Label l4dex;
  @FXML
  private Label l4end;
  @FXML
  private Label l4int;
  @FXML
  private Label l4max;
  @FXML
  private Label l4maxskill;
  @FXML
  private Label l4str;
  @FXML
  private Label l4used;
  @FXML
  private Label l4usedskill;
  @FXML
  private RadioButton quality;
  @FXML
  private TextArea ta4skills;
  @FXML
  private TextArea ta4stats;
  @FXML
  private Label units;

  private String CRLF = "\n";
  private String[] obtrusive = {"Spots Overall", "Conspicuous Patterns",
    "Blotches", "Multiple Marks", "Prominent Mark", "Pigmented Skin",
    "Patterned", "Subtly Patterned", "Subtly Colored", "Unpigmented",
    "Transparent Skin"};
  private String[] unobtrusive = {"Tattoo-Hidden", "Tattoo-Inconspicuous",
    "Minor Differences", "Internal RFID", "Internal Scannable Chip",
    "Local ID Marking", "Verbal Trigger", "Touch Point Disable", "Scent Trigger",
    "Visible Pattern Trigger", "IR Hotspot"};
  private String[] control = {"Accumulated Waste Residue Flush",
    "Organic Chemical Supplements", "Dietry Supplements", "Hormone Supplements",
    "Eats (Requires) spoiled or substandard foods",
    "Eats (Requires) a specific geneered food", "Internal Energy Cell Recharge",
    "Internal Energy Cell Recharge", "Tailored Scent Input",
    "Coded Bright Light Incapacitation", "Coded Sound Pattern Incapacitation"};
  private String UPP = "";
  private ObservableList<String> DIce = FXCollections.observableArrayList();
  private ObservableList<String> OBtrusive = FXCollections.observableArrayList();
  private ObservableList<String> UNobtrusive = FXCollections
    .observableArrayList();
  private ObservableList<String> COntrol = FXCollections.observableArrayList();

  private ObservableList<String> skills = FXCollections.observableArrayList();

  private ObservableList<String> starships = FXCollections
    .observableArrayList();
  private ObservableList<String> trades = FXCollections
    .observableArrayList();
  private ObservableList<String> arts = FXCollections.observableArrayList();
  private ObservableList<String> soldiers = FXCollections
    .observableArrayList();
  private ObservableList<String> defaults = FXCollections
    .observableArrayList();
  private ObservableList<String> talents = FXCollections.observableArrayList();
  private ObservableList<String> personals = FXCollections.observableArrayList();
  private ObservableList<String> intuitions = FXCollections
    .observableArrayList();

  private ObservableList<String> groups = FXCollections.observableArrayList();
  private ObservableList<String> animals = FXCollections.observableArrayList();
  private ObservableList<String> driver = FXCollections.observableArrayList();
  private ObservableList<String> engineer = FXCollections.observableArrayList();
  private ObservableList<String> fighter = FXCollections.observableArrayList();
  private ObservableList<String> flyer = FXCollections.observableArrayList();
  private ObservableList<String> gunner = FXCollections.observableArrayList();
  private ObservableList<String> hvywpns = FXCollections.observableArrayList();
  private ObservableList<String> pilot = FXCollections.observableArrayList();
  private ObservableList<String> seafarer = FXCollections.observableArrayList();
  private ObservableList<String> sciences = FXCollections.observableArrayList();
  private ObservableList<String> specials = FXCollections.observableArrayList();
  private ObservableList<String> races = FXCollections.observableArrayList();

  private int dice = 0;
  private String SKILLS = "";
  ActionEvent ae;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
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
    DIce.addAll("8");
    OBtrusive.addAll(obtrusive);
    UNobtrusive.addAll(unobtrusive);
    COntrol.addAll(control);

    Dice.itemsProperty().setValue(DIce);
    Obtrusive.itemsProperty().setValue(OBtrusive);
    Unobtrusive.itemsProperty().setValue(UNobtrusive);
    Control.itemsProperty().setValue(COntrol);

    diceChange();
    Obtrusive.getSelectionModel().select(5);
    Unobtrusive.getSelectionModel().select(5);
    Control.getSelectionModel().select(5);

    groups.addAll("Skills", "Starships", "Trades", "Arts", "Soldiers",
      "Talents", "Personals", "Intuitions", "Animals", "Driver",
      "Engineer", "Fighter", "Flyer", "Gunner", "Hvy Wpns", "Pilot",
      "Seafarer", "Sciences", "Specialized");//
    SkillSet.itemsProperty().setValue(groups);

    skills.addAll("Admin", "Advocate", "Animals", "Athlete", "Broker",
      "Bureaucrat", "Comms", "Computer", "Counsellor", "Designer", "Diplomat",
      "Driver", "Explosives", "Fleet Tactics", "Flyer", "Forensics", "Gambler",
      "High-G", "Hostile Environ", "JOT", "Language", "Leader", "Liaison",
      "Naval Architect", "Seafarer", "Stealth", "Strategy", "Streetwise",
      "Survey", "Survival", "Tactics", "Teacher", "Trader", "Vacc Suit",
      "Zero-G");
    starships.addAll("Astrogator", "Engineer", "Gunner", "Medic", "Pilot",
      "Sensors", "Steward");
    trades.addAll("Biologics", "Craftsman", "Electronics", "Fluidics",
      "Gravitics", "Magnetics", "Mechanic", "Photonics", "Polymets",
      "Programmer");
    arts.addAll("Actor", "Artist", "Author", "Chef", "Dancer", "Musician");
    soldiers.addAll("Fighter", "Fwd Obs", "Hvy Wpns", "Navigation",
      "Recon", "Sapper");
    defaults.addAll("Actor", "Artist", "Athlete", "Author", "Comms",
      "Computer", "Driver", "Fighter", "Turrets", "Mechanic", "Steward",
      "Vacc Suit");
    talents.addAll("Compute", "Empath", "Hibernate", "Hypno", "Intuition",
      "Math", "MemAware", "Memorize", "MemPercept", "MenScent", "MemSight",
      "MemSound", "Morph", "Rage", "SoundMimic");
    personals.addAll("Carouse", "Query", "Persuade", "Command");
    intuitions.addAll("Curiosity", "Insight", "Luck");

    animals.addAll("Rider", "Teamster", "Trainer");
    driver.addAll("ACV", "Automotive", "Grav", "Legged", "Mole", "Tracked",
      "Wheeled");
    engineer.addAll("Jump Drives", "Life Support", "Maneuver Drives",
      "Power Plants");
    fighter.addAll("Battle Dress", "Beams", "Blades", "Exotics",
      "Slug Throwers", "Sprays", "Unarmed");
    flyer.addAll("Aeronautics", "Flapper", "Grav", "LTA", "Rotor", "Wing");
    gunner.addAll("Bay Weapons", "Ortillery", "Screens", "Spines", "Turrets");
    hvywpns.addAll("Artillery", "Launcher", "Ordnance", "WMD");
    pilot.addAll("Small Craft", "Spacecraft ACS", "Spacecraft BCS");
    seafarer.addAll("Aquanautics", "Grav", "Boat", "Ship", "Sub");
    sciences.addAll("Archeology", "Biology", "Chemistry", "History",
      "Linguistics", "Philosophy", "Physics", "Planetology", "Psionicology",
      "Psychohistory", "Psychology", "Robotics", "Sophontology");
    specials.addAll("Career: Academia", "Career: Army", "Career: Navy",
      "Career: <Name>", "World: Capital", "World: Regina", "World: <Name>");

    races
      .addAll("Human", "Vargr", "Aslan", "Droyne", "K`Kree", "Hiver", "Other");
    Race.getItems().addAll(races);
    Race.setValue("Human");
    diceChange();
    recalc();
  }

  @FXML
  private void Change(MouseEvent event) {
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
    if (event.getSource().equals(l4c2)) {
      switch (l4dex.getText()) {
        case "DEX": {
          l4dex.setText("AGI");
          break;
        }
        case "AGI": {
          l4dex.setText("GRA");
          break;
        }
        case "GRA": {
          l4dex.setText("DEX");
          break;
        }
      }
    } else if (event.getSource().equals(l4c3)) {
      switch (l4end.getText()) {
        case "END": {
          l4end.setText("STA");
          break;
        }
        case "STA": {
          l4end.setText("VIG");
          break;
        }
        case "VIG": {
          l4end.setText("END");
          break;
        }
      }
    }
  }

  @FXML
  private void addSkill(ActionEvent event) {
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
    countSkills(ae);
    int used = Integer.parseInt(l4usedskill.getText());
    int from = Integer.parseInt(l4maxskill.getText());
    SKILLS = "";
    if (used < from) {
      if (Skills.getValue() != null) {
        SKILLS += Skills.getValue() + CRLF;
      }
      ta4skills.appendText(SKILLS);
      countSkills(ae);
    }
  }

  private void countSkills(ActionEvent event) {
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
    String newlist = "";
    String selected = null;
    String[] lines = ta4skills.getText().trim().split(CRLF);//
    for (int i = 0; i < lines.length; i++) {
      if (!newlist.contains(lines[i]) & !"".equals(lines[i])) {
        selected = lines[i];
        System.out.println(lines[i].length());
        newlist += lines[i] + "-";

        int count = -1;
        for (int j = 0; j < lines.length; j++) {
          if (lines[j].contains(selected)) {
            count += 1;
          }
        }
        newlist += count + CRLF;
      }
    }
    System.out.println(newlist);
    lines = newlist.split(CRLF);
    Arrays.sort(lines);
    SkillTxt.setText("");
    for (int i = 0; i < lines.length; i++) {
      SkillTxt.appendText(lines[i] + CRLF);
    }
    l4usedskill.setText("" + ta4skills.getText().split(CRLF).length);
  }

  private void diceChange() {
    Dice.getSelectionModel().select(0);
    dice = Integer.parseInt(Dice.getValue());
  }

  @FXML
  private void qualityOptionAction(ActionEvent event) {
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
    if (quality.isSelected()) {
      quality.setText("Premium");
      NUM.setText("10");
      STR.setText("8");
      DEX.setText("11");
      END.setText("8");
      INT.setText("11");
      l4maxskill.setText("18");
    } else {
      quality.setText("Standard");
      NUM.setText("100");
      STR.setText("6");
      DEX.setText("9");
      END.setText("6");
      INT.setText("7");
      l4maxskill.setText("12");
    }
//    addDefaults();
    recalc();
  }

  @FXML
  private void raceChange(ActionEvent event) {
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
    Dice.setValue("8");
    recalc();
  }

  @FXML
  @SuppressWarnings("unchecked")
  private void recalc() {
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
    dice = Integer.parseInt(Dice.getValue());
    if (quality.isSelected()) {
      l4max.setText("" + (int) (10 + (3.5 * dice)));
    } else {
      l4max.setText("" + (int) (3.5 * dice));
    }
    int cost = 0;
    int str = 0, dex = 0, end = 0, intel = 0, num = 0;
    str = Integer.parseInt(STR.getText());
    dex = Integer.parseInt(DEX.getText());
    end = Integer.parseInt(END.getText());
    intel = Integer.parseInt(INT.getText());
    num = Integer.parseInt(NUM.getText());
    int total = str * dex * end * intel * num;
    l4cost.setText("" + total);
    l4used.setText("" + (str + dex + end + intel));
    l4usedskill.setText("0");
    String[] parts = {"" + str, "" + dex, "" + end, "" + intel, "0", "0"};
    UPP = "";
    for (int i = 0; i < parts.length; i++) {
      UPP += toHex(parts[i]);
    }
    ta4stats.setText("" + Race.getValue() + " Sophontoid");
    int number = Integer.parseInt(NUM.getText());
    if (number > 1) {
      ta4stats.appendText("s");
    }
    ta4stats.appendText(CRLF);
    String t = "" + System.currentTimeMillis();
    ta4stats.appendText("Model: " + t + CRLF);
    ta4stats.appendText("UPP: " + UPP + CRLF);
    ComboBox<String>[] combos;
    combos = new ComboBox[]{Obtrusive, Unobtrusive, Control};
    for (int i = 0; i < combos.length; i++) {
      int max = combos[i].getItems().size();
      int sel = (int) (Math.random() * max);
      String val = combos[i].getItems().get(sel);
      if (i == 0) {
        if (!quality.getText().equals("Premium")) {
          ta4stats.appendText(val + CRLF);
        }
      } else {
        ta4stats.appendText(val + CRLF);
      }
    }
    countSkills(ae);
  }

  @FXML
  private void setSkills(ActionEvent event) {
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
    System.out.println(SkillSet.getValue());
    switch (SkillSet.getValue()) {
      case "Skills": {
        Skills.itemsProperty().setValue(skills);
        break;
      }
      case "Starships": {
        Skills.itemsProperty().setValue(starships);
        break;
      }
      case "Trades": {
        Skills.itemsProperty().setValue(trades);
        break;
      }
      case "Arts": {
        Skills.itemsProperty().setValue(arts);
        break;
      }
      case "Soldiers": {
        Skills.itemsProperty().setValue(soldiers);
        break;
      }
      case "Defaults": {
        Skills.itemsProperty().setValue(defaults);
        break;
      }
      case "Talents": {
        Skills.itemsProperty().setValue(talents);
        break;
      }
      case "Personals": {
        Skills.itemsProperty().setValue(personals);
        break;
      }
      case "Intuitions": {
        Skills.itemsProperty().setValue(intuitions);
        break;
      }
      case "Animals": {
        Skills.itemsProperty().setValue(animals);
        break;
      }
      case "Driver": {
        Skills.itemsProperty().setValue(driver);
        break;
      }
      case "Engineer": {
        Skills.itemsProperty().setValue(engineer);
        break;
      }
      case "Fighter": {
        Skills.itemsProperty().setValue(fighter);
        break;
      }
      case "Flyer": {
        Skills.itemsProperty().setValue(flyer);
        break;
      }
      case "Gunner": {
        Skills.itemsProperty().setValue(gunner);
        break;
      }
      case "Hvy Wpns": {
        Skills.itemsProperty().setValue(hvywpns);
        break;
      }
      case "Pilot": {
        Skills.itemsProperty().setValue(pilot);
        break;
      }
      case "Seafarer": {
        Skills.itemsProperty().setValue(seafarer);
        break;
      }
      case "Sciences": {
        Skills.itemsProperty().setValue(sciences);
        break;
      }
      case "Specialized": {
        Skills.itemsProperty().setValue(specials);
        break;
      }
    }
  }

  private void addDefaults() {
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
    SKILLS = "";
    for (int i = 0; i < defaults.size(); i++) {
      SKILLS += defaults.get(i) + CRLF;
    }
    ta4skills.setText(SKILLS);
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

  private String toHex(String s) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String t = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        t += "//////////////////////////////////////////////" + CRLF;
        t += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        System.out.print(t);
      }
    }
    //</editor-fold>
    char c = 'X';
    int num = 0;
    if (s.length() == 1) {
      return s;
    } else {
      try {
        num = Integer.parseInt(s);
        c = (char) (55 + num);
      } catch (Exception e) {
      }
    }
    return "" + c;
  }

}
