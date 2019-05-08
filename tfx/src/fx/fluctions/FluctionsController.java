/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.fluctions;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**

 @author Mark Ferguson
 */
public class FluctionsController implements Initializable {

  private final String CRLF = "\n";
  @FXML
  private Label l4About;
  private String[][] old = {{"", ""}};
  private ActionEvent ae;
  @FXML
  private Button b4go;
  @FXML
  private ComboBox<String> cb4tables;
  private int d1 = 0;
  private int d2 = 0;
  @FXML
  private ComboBox<String> fluxable;
  private int len;
  private String mod = "";
  private int result = 0;
  @FXML
  private TextArea ta4tables;
  @FXML
  private TextArea ta4use;
  private String[][] tables = {{"", "", ""}, {"", "", ""}};
  @FXML
  private TextField txt;

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
    fluxable.getItems().addAll("Flux", "Flux Bell", "Flux+", "Flux-", "Random");
    fluxable.setValue("Random");
    cb4tables.getItems().addAll(
      //<editor-fold defaultstate="collapsed" desc="tablenames">
      "Important Eras In History - 17",
      "MOD vs DM - 24",
      "Dice Tables - 25",
      "Two Dice - 25",
      "Flux - 26",
      "Many Dice Flux 3.5 - 32",
      "Probability - 47",
      "Severity - 47",
      "Imminence - 47",
      "Cost Modifiers - 53",
      "Special Object Supply Mods - 53", //Special objects Roll Supply + Demand
      "Special Object Demand Mods - 53",//Ordinary objects Roll Demand
      "Supply Price Mods - 53",
      "Demand Price Mods - 53",
      "Character Creation - 69",
      "UPP - 70",
      "CAREERS - 74",
      "Spinward Marches Homeworlds - 82",
      "01 Craftsman - 83",
      "02 Scholar - 84",
      "03 Entertainer - 85",
      "04 Citizen - 86",
      "Citizen Life Skills - 86",
      "05 Scout - 87",
      "06 Merchant - 88",
      "07 Spacer - 89",
      "08 Soldier - 90",
      "09 Agent - 91",
      "10 Rogue - 92",
      "11 Noble - 93",
      "12 Marine - 94",
      "13 Functionary - 95",
      "Noble Land Grants - 96",
      "Aging Life Stages - 97",
      "Aging Life Stages Aslan (88y) - 97",
      "Aging Life Stages Droyne (76y) - 97",
      "Aging Life Stages Hiver (200+) - 97",
      "Aging Life Stages K`kree (68) - 97",
      "Aging Life Stages Vargr (60) - 97",
      "Day names - 98",
      "Dates - 99",
      "Education-1 College - 100",
      "Education-1 University - 100",
      "Education-1 University+ - 100",
      "Education-1 Medical School - 100",
      "Education-1 Law School - 100",
      "Education-1 Trade School - 100",
      "Education-1 Training Apprectice - 100",
      "Education-1 Training Course - 100",
      "Education-1 Training Mentor - 100",
      "Education-1 Military ANM School - 100",
      "Education-1 Military Command College - 100",
      "Education-1 Military Service Academy - 100",
      "Education-1 ANM School - 100",
      "Education Skills College & University - 100",
      "Education Skills Law School - 100",
      "Education Skills Medical School - 100",
      "Education Skills Apprentice Training Course - 100",
      "Education Skills Naval Academy - 100",
      "Education Skills Military Academy - 100",
      "Education Skills Command College - 100",
      "ED5 - 101",
      "Trade Schools - 101",
      "College - 101",
      "University - 101",
      "Medical School - 101",
      "Law School - 101",
      "Naval/Military Academy - 101",
      "Citizen Life - 102",
      "Research Topic - 102",
      "Merchant Companies - 102",
      "Agent Mission - 102",
      "Noble Intrigues - 102",
      "Spacer Units - 103",
      "Soldier or Marine Units - 103",
      "Rogue Scheme - 103",
      "Spacer Service Battles - 103",
      "Soldier or Marine Service Battles - 103",
      "Rogue Masquerade - 103",
      "Craftsman Secrets - 104",
      "Scholar Secrets - 104",
      "Entertainer Secrets - 104",
      "Citizen or Functionary Secrets - 104",
      "Scout Secrets - 104",
      "Merchant Secrets - 104",
      "Spacer Secrets - 105",
      "Soldier Secrets - 105",
      "Rogue Secrets - 105",
      "Agent Secrets - 105",
      "Noble Secrets - 105",
      "Marine Secrets - 105",
      "Fame Descriptor - 109",
      "Fame Calculation Armed Force Officers - 109",
      "Fame Calculation Others - 109",
      "Medals Table - 109",
      "Sophontoid Obvious Identifying Markings - 126",
      "Sophontoid Unobtrusive Identifying Markings - 126",
      "Sophontoid Control Structures - 126",
      "Task Statements - 130",
      "Task Difficulties - 130",
      "Difficulty Benchmarks - 138",
      "Skill Groups - 142",
      "Skills(35) - 142",
      "Starship Skills(7) - 142",
      "Trades Skills(10) - 142",
      "Arts Skills(6) - 142",
      "Soldier Skills(6) - 142",
      "Default Skills(12) - 142",
      "Talents(16) - 142",
      "Personals(7) - 142",
      "Animals(3) - 142",
      "Driver(7) - 142",
      "Engineer(4) - 142",
      "Fighter(7) - 142",
      "Flyer(6) - 142",
      "Gunner(5) - 142",
      "Heavy Weapons(4) - 142",
      "Pilot(3) - 142",
      "Seafarer(5) - 142",
      "The Sciences(13) - 142",
      "Specials(8) - 142",
      "Knowledge-Skill - 144",
      "Skill-Knowledge - 144",
      "Languages - 163",
      "Musical Instruments - 166",
      "Compute: Accuracy vs Speed - 176",
      "Empath: Readable Emotional States EMOTION - 176",
      "Empath: Readable Emotional States DEGREE - 176",
      "Memorize - 178",
      "Master Environ - 180",
      "Master Touch - 180",
      "Master Sound - 180",
      "Master Smell - 180",
      "Master Light - 180",
      "Master Pain - 180",
      "Master Truth - 180",
      "Master Visibility - 180",
      "Master Respect (Soc1-Soc2) - 180",
      "Master Attitude - 180",
      "Master Conformity - 180",
      "Master Imagination - 180",
      "Master Beauty - 180",
      "Master Walking - 180",
      "Master Driving - 180",
      "Master Highway - 180",
      "Master Vilani - 180",
      "Master New Speak - 180",
      "Master Anglic - 180",
      "Master Gravity - 181",
      "Master Typical Bureaucratic Regs - 181",
      "Master Typical Diplomatic Handbook - 181",
      "Master Typical Diplomatic Difficulty - 181",
      "Master Idea - 181",
      "Master Comms Environ - 181",
      "Master Logic - 181",
      "Master Weather - 181",
      "Master Rewards - 181",
      "Master Speed kph - 181",
      "Master Speed - 181",
      "Master Encounter Range - 181",
      "Master Jump Time Commercial - 181",
      "Master Jump Time Naval - 181",
      "Master Emotional - 181",
      "Master Degree - 181",
      "Master Potential - 181",
      "Master Brand Names - 181",
      "Master Anglic Names - 181",
      "Master Vilani Brands - 181",
      "Master MegaCorps - 181",
      "Typical Mods TL Low - 182",
      "Typical Mods TL High - 182",
      "Typical Mods TL VHigh - 182",
      "Typical Mods TL Extreme - 182",
      "Typical Mods Multiples - 182",
      "Typical Mods Fractions - 182",
      "Typical Mods Evidence - 182",
      "Typical Mods Careers - 182",
      "Typical Mods Friends - 182",
      "Typical Mods Order/Chaos - 182",
      "Typical Mods Good/Evil - 182",
      "Typical Mods Sounds - 182",
      "Typical Mods Probability - 182",
      "Typical Mods Severity - 182",
      "Typical Mods Imminence - 182",
      "Typical Mods Humanitii - 182",
      "Typical Mods Major Races - 182",
      "Typical Mods Major Sophonts - 182",
      "Typical Mods Major Barrier Height - 183",
      "Typical Mods Major Barrier Width - 183",
      "Typical Mods Stability - 183",
      "Typical Mods Xeno-Med - 183",
      "Typical Mods Wounds - 183",
      "Typical Mods Severity - 183",
      "Typical Mods Diagnosis - 183",
      "Typical Mods Gravity Or Acceleration - 183",
      "Typical Mods Environment - 183",
      "Typical Mods Zero-G - 183",
      "Typical Mods Wound - 183",
      "Typical Mods Damage - 183",
      "Typical Mods - 183",
      "Typical Move Mods - 183",
      "Typical Mods Megacorporations - 183",
      "Typical Mods Common Brands - 183",
      "Personal Interactions - 188",
      "Personal Interaction Strategy - 188",
      "Personal Interaction Purpose - 188",
      "Personal Interaction Tactics - 188",
      "Personal Interaction 5 LAWS - 188",
      "Personal Interaction Resolution - 188",
      "QREBS-1 - 194",
      "QREBS-Quality - 194",
      "QREBS-Reliability - 194",
      "QREBS-EaseOfUse - 194",
      "QREBS-Burden - 194",
      "QREBS-Safety - 194",
      "QREBS-TrueAge - 195",
      "QREBS-Scenes - 195"
    //</editor-fold>
    );
    cb4tables
      .setValue(cb4tables.getItems().get(cb4tables.getItems().size() - 1));
    roll(ae);
//    cb4tables.
  }

  @FXML
  public void roll(ActionEvent event) {
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
    d1 = (int) (Math.random() * 6) + 1;
    d2 = (int) (Math.random() * 6) + 1;
    switch (fluxable.getValue()) {
      case "Flux": {
        result = d1 - d2;
        break;
      }
      case "Flux+": {
        if (d1 < d2) {
          result = d2 - d1;
        } else {
          result = d1 - d2;
        }
        break;
      }
      case "Flux-": {
        if (d1 < d2) {
          result = d1 - d2;
        } else {
          result = d2 - d1;
        }
        break;
      }
    }
    showtables(ae);
    printResult(ta4tables.getText(), result);
    int start = cb4tables.getValue().indexOf(" - ") + 3;
    try {
      String texta = cb4tables.getValue().substring(start);
      txt.setText(texta);
    } catch (Exception e) {

    }
  }

  private void printResult(String text, int result) {
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
    String[] t = text.split(CRLF);
    System.out.println(text.trim());
    System.out.println(result + 6);
    len = t.length;
    if (len != 12) {
      fluxable.setValue("Random");
    } else if ("Random".equals(fluxable.getValue())) {
      fluxable.setValue("Flux");
    }
    int num = result + 6;
    if (!"Random".equals(fluxable.getValue())) {
      ta4use.setText(t[num]);
    } else {
      ta4use.setText("");
      num = (int) (Math.random() * len);
      if (num == 0) {
        num = 1;
      }
      ta4use.appendText(t[num] + CRLF);
    }
//    int start = cb4tables.getValue().indexOf(" - " + 3);
//    String texta = cb4tables.getValue().substring(start);
//    txt.setText(texta);
  }

  private void showtables(ActionEvent event) {
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
    old = tables;
    switch (cb4tables.getValue()) {
      //<editor-fold defaultstate="collapsed" desc="cb4tables">
      case "Important Eras In History - 17": {
        tables = new String[][]{
          {"Grandfather’s Children", "Droyne", "300,000 BCE", ""},
          {"The False Dawn", "Kursae", "200,000 BCE", ""},
          {"Ziru Sirka", "Vilani", "9000 BCE", ""},
          {"Consolidation Wars", "Vilani, Suerrat", "5000 BCE"},
          {"First Contact", "Vilani, Terran", "2100 CE", ""},
          {"Interstellar Wars", "Terran, Vilani", "2200 CE", ""},
          {"The Rule of Man", "Terran, Vilani", "2500 CE", ""},
          {"The Long Night", "- -", "3500 CE", ""},
          {"Early Imperium", "Sylean", "0 CE", "4"},
          {"Aslan Border Wars", "Aslan, Imperial", "300 IC", ""},
          {"Vargr Campaigns", "Imperial, Vargr", "329 IC", ""},
          {"The Barracks Emperors", "Imperial", "579 IC", ""},
          {"Civil War", "Imperial", "600 IC", ""},
          {"Psionic Suppressions", "Imperial, Zhodani", "880 IC", ""},
          {"Solomani Rim War", "Imperial, Terran", "990 IC", ""},
          {"The Golden Age", "Imperial", "1000 IC", "Classic Traveller"},
          {"The Rebellion", "Imperial", "1116 IC", "MegaTraveller"},
          {"Virus Era", "-", "1130 IC", "The New Era"},
          {"The New Era", "-", "1200 IC", "The New Era"},
          {"The New New Era", "Imperial", "1248 IC", "The New Era"},
          {"The Far Far Future", "-", "1902 IC", "The Galaxiad"},};
        break;
      }
      case "MOD vs DM - 24": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"+ Mod +", "Increase Target", "More Success"},
          {"- DM -", "Decrease Die", "More Success"},
          {"- Mod -", "Decrease Target", "Less Success"},
          {"+ DM +", "Increase Die", "Less Success"}
        };
        break;
      }
      case "Dice Tables - 25": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"1D", "Easy", "EAS"},
          {"2D", "Average", "AVG"},
          {"D-D", "Flux", "Flux"},
          {"3D", "Difficult", "DIF"},
          {"4D", "Formidable", "FOR"},
          {"5D", "Staggering", "STA"},
          {"6D", "Hopeless", "HOP"},
          {"7D", "Impossible", "IMP"},
          {"8D", "Beyond Impossible", "BEY"},
          {"9D", "Hasty Beyond Impossible", "HBI"},
          {"10D", "Double Hasty Beyond Impossible", "DHB",},
          {"C+S+K", "Char + Skill + Knowledge", "CSK",},
          {"Char", "Select Random Characteristic", "SRC",},
          {"Special", "Various Special Throws", "VST",},
          {"0-9", "Random Nought Nine", "RNN",},
          {"1-9", "Random One Nine", "RON",},
          {"Many", "Random Many Dice", "RMD",},
          {"Flux", "Flux", "Flux",},
          {"Flux Bell", "Random Flux Bell", "RFB",}
        };
        break;
      }
      case "Two Dice - 25": {
        tables = new String[][]{
          {"ROLL", "N", "N%", "N-", "N-%", "N+", "N+%"},
          {"1", "0", "NO", "0", "NO", "36", "100%"},
          {"2", "1", "3%", "1", "3%", "36", "100%"},
          {"3", "2", "6%", "3", "8%", "35", "97%"},
          {"4", "3", "8%", "6", "17%", "33", "92%"},
          {"5", "4", "11%", "10", "28%", "30", "83%"},
          {"6", "5", "14%", "15", "42%", "26", "72%"},
          {"7", "6", "17%", "21", "58%", "21", "58%"},
          {"8", "5", "14%", "26", "72%", "15", "42%"},
          {"9", "4", "11%", "30", "83%", "10", "28%"},
          {"10", "3", "8%", "33", "92%", "6", "17%"},
          {"11", "2", "6%", "35", "97%", "3", "8%"},
          {"12", "1", "3%", "36", "100%", "1", "3%"},
          {"13", "0", "NO", "36", "100%", "0", "NO"}
        };
        break;
      }
      case "Flux - 26": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"2", "-5"},
          {"3", "-4"},
          {"4", "-3"},
          {"5", "-2"},
          {"6", "-1"},
          {"7", "0"},
          {"8", "1"},
          {"9", "2"},
          {"10", "3"},
          {"11", "4"},
          {"12", "5"}};
        break;
      }
      case "Many Dice Flux 3.5 - 32": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"1"},
          {"1.5"},
          {"2"},
          {"2.5"},
          {"3"},
          {"3.5"},
          {"4"},
          {"4.5"},
          {"5"},
          {"5.5"},
          {"6"}
        };
        break;
      }
      case "Probability - 47": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Highly impossible"},
          {"Improbable"},
          {"Highly unlikely"},
          {"Unlikely"},
          {"Not likely"},
          {"Either way"},
          {"Possible"},
          {"Likely"},
          {"Probable"},
          {"Very probable"},
          {"Almost certain"}};
        break;
      }
      case "Severity - 47": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Trivial"},
          {"Negligible"},
          {"Very minor"},
          {"Minor"},
          {"Mild"},
          {"Temporary"},
          {"Strong"},
          {"Major"},
          {"Severe"},
          {"Very severe"},
          {"Devastating"}};
        break;
      }
      case "Imminence - 47": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Centuries"},
          {"Lifetime"},
          {"Generation"},
          {"Decades"},
          {"Years"},
          {"Months"},
          {"Weeks"},
          {"Days"},
          {"Hours"},
          {"Minutes"},
          {"Seconds"}};
        break;
      }
      case "Cost Modifiers - 53": {
        tables = new String[][]{
          {"DESCRIPTION", "COST", "COMMENT"},
          {"Experimental", "10.0", "Before substantial testing"},
          {"Prototype", "5.0", "Handmade sample"},
          {"Early", "2.0", "Preliminary"},
          {"Basic", "0.5", "Elementary, unenhanced"},
          {"Standard", "1.0", "Normal, ordinary"},
          {"(blank)", "1.0", "Normal, ordinary"},
          {"Alternate", "1.1", "Nonstandard performance"},
          {"Improved", "1.3", "Updated"},
          {"Generic", "0.7", "Low quality control"},
          {"Modified", "1.2", "Changed.  New features"},
          {"Advanced", "2.0", "Multiple new features"}};
        break;
      }
      case "Special Object Demand Mods - 53": {
        tables = new String[][]{ //demand
          {"DEMAND", "MOD"},
          {"Very low", "0.5"},
          {"Quite low", "0.6"},
          {"Low", "0.7"},
          {"Weak", "0.8"},
          {"Less ordinary", "0.9"},
          {"Ordinary", "1.0"},
          {"Good", "1.2"},
          {"Strong", "1.4"},
          {"High", "1.6"},
          {"Quite high", "1.8"},
          {"Very high", "2.0"}};
        break;
      }
      case "Special Object Supply Mods - 53": {
        tables = new String[][]{ //supply
          {"SUPPLY", "MOD"},
          {"Ubiquitous", "0.5"},
          {"Abundant", "0.6"},
          {"Very common", "0.7"},
          {"Quite common", "0.8"},
          {"Common", "0.9"},
          {"Typical", "1.0"},
          {"Uncommon", "1.2"},
          {"Scarce", "1.4"},
          {"Rare", "1.6"},
          {"Quite rare", "1.8"},
          {"Very rare", "2.0"}};
        break;
      }
      case "Ordinary Object Price Mods - 53": {
        tables = new String[][]{ //demand only
          {"DEMAND", "MOD"},
          {"Very low", "0.5"},
          {"Quite low", "0.6"},
          {"Low", "0.7"},
          {"Weak", "0.8"},
          {"Less ordinary", "0.9"},
          {"Ordinary", "1.0"},
          {"Good", "1.2"},
          {"Strong", "1.4"},
          {"High", "1.6"},
          {"Quite high", "1.8"},
          {"Very high", "2.0"}};
        break;
      }
      case "Supply Price Mods - 53": {
        tables = new String[][]{ //supply
          {"SUPPLY", "MOD"},
          {"Ubiquitous", "0.5"},
          {"Abundant", "0.6"},
          {"Very common", "0.7"},
          {"Quite common", "0.8"},
          {"Common", "0.9"},
          {"Typical", "1.0"},
          {"Uncommon", "1.2"},
          {"Scarce", "1.4"},
          {"Rare", "1.6"},
          {"Quite rare", "1.8"},
          {"Very rare", "2.0"}};
        break;
      }
      case "Demand Price Mods - 53": {
        tables = new String[][]{ //demand only
          {"DEMAND", "MOD"},
          {"Very low", "0.5"},
          {"Quite low", "0.6"},
          {"Low", "0.7"},
          {"Weak", "0.8"},
          {"Less ordinary", "0.9"},
          {"Ordinary", "1.0"},
          {"Good", "1.2"},
          {"Strong", "1.4"},
          {"High", "1.6"},
          {"Quite high", "1.8"},
          {"Very high", "2.0"}};
        break;
      }
      case "Character Creation - 69": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"1 Homeworld", "Birthworld", "Homeworld", "Other detail"},
          {"2 Characteristics", "UPP", "Genetics", "Name"},
          {"3 Education", "Major", "Minor", "Pre-requisites", "Admission",
            "Pass/Fail", "Honours", "Skills", "Duration", "Graduation"},
          {"4 Career", "Begin", "Risk/Reward", "Promotion", "Skills", "Continue"},
          {"5 Mustering Out", ""}
        };
        break;
      }
      case "UPP - 70": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"C1", "STR"},
          {"C2", "DEX", "AGI", "GRA"},
          {"C3", "END", "VID", "STA"},
          {"C4", "INT"},
          {"C5", "EDU", "TRA", "INS"},
          {"C6", "SOC", "CHA", "CAS"}
        };
        break;
      }
      case "CAREERS - 74": {
        tables = new String[][]{
          {"2D", "DESCRIPTION", "INITIAL RANK", "OFFICER RANK", ""},
          {"1", "Craftsman", "-"},
          {"2", "Scholar", "Varies"},
          {"3", "Entertainer", "-"},
          {"4", "Citizen", "-"},
          {"5", "Scout", "-"},
          {"6", "Merchant", "Temp", "Merchant1", ""},
          {"7", "Spacer", "Spacer1", "Officer1", ""},
          {"8", "Soldier", "Soldier1", "Officer1", ""},
          {"9", "Agent", "-"},
          {"10", "Rogue", "-"},
          {"11", "Noble", "Varies"},
          {"12", "Marine", "Marine1", "Officer1"},
          {"13", "Functionary", "Functionary-0"}
        };
        break;
      }
      case "Spinward Marches Homeworlds - 82": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"A", "Alell", "1706", "Spinward Marches",
            "Oppressive, rich bureaucratic world (Ph Pa Ri)"},
          {"B", "Boughene", "1904", "Spinward Marches",
            "Non-industrial, domed world, corrosive atmosphere (Fl Ni)"},
          {"C", "Capital", "2118", "Core",
            "Capital of the Third Imperium (Hi Cx)"},
          {"D", "Dorannia", "0530", "Spinward Marches",
            "Poor, non-industrial hellworld (He Ni Po)"},
          {"E", "Efate", "1705", "Spinward Marches",
            "High-tech industrial world (Hi In)"},
          {"F", "Feri", "2005", "Spinward Marches",
            "Rich, low gravity world (Ph Pa Ri)"},
          {"G", "Magash", "0316", "Deneb",
            "High-tech, busy, industrial, capital world (Va Hi Na In Cp)"},
          {"H", "Hefry", "1909", "Spinward Marches",
            "IISS regional administration (Va Ni)"},
          {"J", "Jenghe", "1810", "Spinward Marches",
            "\"Truck Stop\" colony world (Ni)"},
          {"K", "Earth", "1827", "Solomani Rim", "Homeworld of humaniti (Ga Hi)"},
          {"L", "Lakou", "0638", "Spinward Marches",
            "Tiny, backwater colony (Ni)"},
          {"M", "Macene", "2612", "Spinward Marches",
            "Asteroid belt mining colony (As Ni)"},
          {"N", "Knorbes", "1807", "Spinward Marches",
            "Rich, low-tech agricultural/archaeological world (Ag Ri)"},
          {"P", "Preslin", "0633", "Deneb", "Poor dry rockball (De Ni Na Po)"},
          {"Q", "Yori", "2110", "Spinward Marches", "Rich desert world (De Ri)"},
          {"R", "Regina", "1910", "Spinward Marches",
            "Rich, Earthlike capital world (Ph Pa Ri Cs)"},
          {"S", "Ruie", "1809", "Spinward Marches",
            "\"Independent\", balkanized, TL7 \"war world\" (Hi In)"},
          {"T", "Tremous Dex", "1311", "Spinward Marches", "Ice world (Ic Ni)"},
          {"U", "Uakye", "1805", "Spinward Marches",
            "Non-industrial backwater world (Ni)"},
          {"V", "Vland", "1717", "Vland",
            "Capital world of the First Imperium (Hi Cs)"},
          {"W", "Wroclaw", "0226", "Deneb",
            "Agricultural, oppressively collectivist world (Ag Ri)"},
          {"X", "Menorb", "1803", "Spinward Marches",
            "Poor, crowded world (Hi Po)"},
          {"Y", "Yorbund", "2303", "Spinward Marches",
            "Domed world, insidious atmosphere (Fl Ni)"},
          {"Z", "Traltha", "2834", "Spinward Marches",
            "Desert \"archaeological mysteries\" world (De He Ni)"},
          {"1", "Dentus", "2201", "Spinward Marches",
            "Desolate border world (Ni)"},
          {"2", "Vanzeti", "0218", "Deneb", "Non-industrial water world (Wa Ni)"},
          {"3", "Syr Darya", "1810", "Deneb",
            "Nondescript agricultural world (Ni Ag)"},
          {"4", "Aramis", "3110", "Spinward Marches",
            "Underground colony (He Ni Cp)"},
          {"5", "Rhylanor", "2716", "Spinward Marches",
            "High tech, crowded capital world (Hi Cp)"},
          {"6", "Raschev", "3230", "Foreven", "Atomic-era backwater world (Ri)"},
          {"7", "Ara Pacis", "0419", "Deneb",
            "Balkanized, non-industrial world (Ni)"},
          {"8", "Roup", "2007", "Spinward Marches",
            "Popular dictatorship, water world (Wa Hi In)"},
          {"9", "Pax Rulin", "2204", "Trojan Reaches",
            "Cold, small, poor capital world (Ic Va Lo Cp)"},
          {"0", "Space", "Grew up in space",
            "A free trader serving backwater worlds (Na Va)"}
        };
        break;
      }
      case "01 Craftsman - 83": {
        tables = new String[][]{
          {"EVENT", "THROW"},
          {"Begin", "2 Skill-6 + Craftsman-1"},
          {"Risk/Reward", "Create Masterpiece"},
          {"Skills", ""},
          {"Continue", "Craftsman x 2"}
        };
        break;
      }
      case "02 Scholar - 84": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"EVENT", "THROW"},
          {"Begin", "Edu or Tra (auto if EDU 8+"},
          {"Risk/Reward", "C1 C2 C3 C4"},
          {"Promotion",
            "Roll Scholar promotion.  Roll Tenure if Scholar3 & EDU 10+"},
          {"Skills", ""},
          {"Continue", "EDU"}
        };
        break;
      }
      case "03 Entertainer - 85": {
        tables = new String[][]{
          {"EVENT", "THROW"},
          {"Begin", "various"},
          {"Risk/Reward", "Flux/Flux?"},
          {"Promotion", "Flux?"},
          {"Skills", ""},
          {"Continue", "Fame"}
        };
        break;
      }
      case "04 Citizen - 86": {
        tables = new String[][]{
          {"EVENT", "THROW"},
          {"Begin", ""},
          {"Risk/Reward", ""},
          {"Promotion", ""},
          {"Skills", ""},
          {"Continue", ""}
        };
        break;
      }
      case "Citizen Life Skills - 86": {
        tables = new String[][]{ //demand only
          {"1", "2", "3", "4", "5", "6"},
          {"ACV", "Comms", "High-G", "Steward", "Ordnance", "Naval Arch"},
          {"JOT", "Rider", "Sensors", "Fwd Obs", "Survival", "Streetwise"},
          {"LTA", "Spines", "Flapper", "Seafarer", "No Skill", "Astrogator"},
          {"WMD", "Leader", "Tracked", "Engineer", "Computer", "Navigation"},
          {"Chef", "Survey", "Animals", "Fluidics", "Bay Wpns", "Explosives"},
          {"Mole", "Dancer", "Tactics", "Launcher", "Magnetics", "Jump Drive"},
          {"Grav", "Artist", "Turrets", "Teamster", "Photonics", "Counsellor"},
          {"Boat", "Legged", "Teacher", "Designer", "Vacc Suit", "Submersible"},
          {"Ship", "Sapper", "Unarmed", "Engineer", "Artillery", "Aeronautics"},
          {"Wing", "Driver", "Exotics", "Language", "Craftsman", "Aquanautics"},
          {"Recon", "Gunner", "Stealth", "Musician", "Gravitics", "BattleDress"},
          {"Actor", "Blades", "Trainer", "Strategy", "Forensics", "Electronics"},
          {"Flyer", "Zero-G", "Animals", "Maneuver", "Biologics", "Hostile Env"},
          {"Pilot", "Author", "Liaison", "Polymers", "Ortillery", "Power"},
          {"Rotor", "Broker", "Athlete", "Advocate", "Automotive",
            "Life Support"},
          {"Admin", "Trader", "Fighter", "Computer", "Bureaucrat",
            "Slug Thrower"},
          {"Beams", "Sprays", "Wheeled", "Diplomat", "Heavy Wpns",
            "Fleet Tactics"},
          {"Medic", "Gambler", "Screens", "Mechanic", "Programmer", "Spacecraft"}
        };
        break;
      }
      case "05 Scout - 87": {
        tables = new String[][]{
          {"EVENT", "THROW"},
          {"Begin", ""},
          {"Risk/Reward", ""},
          {"Promotion", ""},
          {"Skills", ""},
          {"Continue", ""}
        };
        break;
      }
      case "06 Merchant - 88": {
        tables = new String[][]{
          {"EVENT", "THROW"},
          {"Begin", ""},
          {"Risk/Reward", ""},
          {"Promotion", ""},
          {"Skills", ""},
          {"Continue", ""}
        };
        break;
      }
      case "07 Spacer - 89": {
        tables = new String[][]{
          {"EVENT", "THROW"},
          {"Begin", ""},
          {"Risk/Reward", ""},
          {"Promotion", ""},
          {"Skills", ""},
          {"Continue", ""}
        };
        break;
      }
      case "08 Soldier - 90": {
        tables = new String[][]{
          {"EVENT", "THROW"},
          {"Begin", ""},
          {"Risk/Reward", ""},
          {"Promotion", ""},
          {"Skills", ""},
          {"Continue", ""}
        };
        break;
      }
      case "09 Agent - 91": {
        tables = new String[][]{
          {"EVENT", "THROW"},
          {"Begin", ""},
          {"Risk/Reward", ""},
          {"Promotion", ""},
          {"Skills", ""},
          {"Continue", ""}
        };
        break;
      }
      case "10 Rogue - 92": {
        tables = new String[][]{
          {"EVENT", "THROW"},
          {"Begin", ""},
          {"Risk/Reward", ""},
          {"Promotion", ""},
          {"Skills", ""},
          {"Continue", ""}
        };
        break;
      }
      case "11 Noble - 93": {
        tables = new String[][]{
          {"EVENT", "THROW"},
          {"Begin", ""},
          {"Risk/Reward", ""},
          {"Promotion", ""},
          {"Skills", ""},
          {"Continue", ""}
        };
        break;
      }
      case "12 Marine - 94": {
        tables = new String[][]{
          {"EVENT", "THROW"},
          {"Begin", ""},
          {"Risk/Reward", ""},
          {"Promotion", ""},
          {"Skills", ""},
          {"Continue", ""}
        };
        break;
      }
      case "13 Functionary - 95": {
        tables = new String[][]{
          {"EVENT", "THROW"},
          {"Begin", ""},
          {"Risk/Reward", ""},
          {"Promotion", ""},
          {"Skills", ""},
          {"Continue", ""}
        };
        break;
      }
      case "Noble Land Grants - 96": {
        tables = new String[][]{
          {"Noble", "SOC", "Hexes", "Other", "Where", "Preferred"},
          {"Gentleman", "A", "-", "1", "Any", "Any"},
          {"Knight", "B", "1", "1", "Homeworld", "Any"},
          {"Baronet", "c", "2", "2", "1 System", "Pre-Ag or Pre-Ri"},
          {"Baron", "C", "4", "4", "1 System", "Ag or Ri"},
          {"Marquis", "D", "8", "8", "1 Subsector", "Pre-Ind"},
          {"Viscount", "e", "16", "16", "1 Subsector", "Pre-Hi"},
          {"Count", "E", "32", "32", "1 Sector", "In"},
          {"Duke", "f", "64", "64", "1 Sector", "Important World"},
          {"DUKE*", "F", "128", "128", "1 Sector", "Important World"},
          {"Archduke", "G", "256", "256", "1 Domain", "Any"}
        };
        break;
      }
      case "Aging Life Stages - 97": {
        tables = new String[][]{
          {"No", "Life Stage", "Human yrs", "Terms"},
          {"0", "Infancy", "0-1", "1/2"},
          {"1", "Childhood", "2-9", "2"},
          {"2", "Adolesence", "10-17", "2"},
          {"3", "Young Adult*", "18-25", "2"},
          {"4", "Adult", "26-33", "2"},
          {"5", "Peak", "34-41", "2"},
          {"6", "Mid-Life", "42-49", "2"},
          {"7", "Senior", "50-57", "2"},
          {"8", "Elder", "58-65", "2"},
          {"9", "Retired", "66-71", "2"}
        };
        break;
      }
      case "Aging Life Stages Aslan (88y) - 97": {
        tables = new String[][]{{"No", "Life Stage", "Human yrs", "Terms"},
        {"0", "Infant", "", "1/2"},
        {"1", "Child", "", "1"},
        {"2", "Teen", "", "2"},
        {"3", "Young Adult*", "", "2"},
        {"4", "Adult", "", "2"},
        {"5", "Peak", "", "2"},
        {"6", "Mid-Life", "", "2"},
        {"7", "Senior", "", "2"},
        {"8", "Elder", "", "3"},
        {"9", "Retired", "", "3"}
        };
        break;
      }
      case "Aging Life Stages Droyne (76y) - 97": {
        tables = new String[][]{
          {"No", "Life Stage", "Human yrs", "Terms"},
          {"0", "Infancy", "", "1/2"},
          {"1", "Childhood", "", "2"},
          {"2", "Adolesence", "", "2"},
          {"3", "Young Adult*", "", "2"},
          {"4", "Adult", "", "2"},
          {"5", "Peak", "", "2"},
          {"6", "Mid-Life", "", "2"},
          {"7", "Senior", "", "2"},
          {"8", "Elder", "", "2"},
          {"9", "Retired*", "", "2"}
        };
        break;
      }
      case "Aging Life Stages Hiver (200+) - 97": {
        tables = new String[][]{
          {"No", "Life Stage", "Human yrs", "Terms"},
          {"0", "Infancy", "", "1/2"},
          {"1", "Childhood", "", "2"},
          {"2", "Adolesence", "", "1"},
          {"3", "Young Adult*", "", "6"},
          {"4", "Adult", "", "6"},
          {"5", "Peak", "", "6"},
          {"6", "Mid-Life", "", "6"},
          {"7", "Senior", "", "6"},
          {"8", "Elder", "", "6"},
          {"9", "Retired", "", "6"}
        };
        break;
      }
      case "Aging Life Stages K`kree (68) - 97": {
        tables = new String[][]{
          {"No", "Life Stage", "Human yrs", "Terms"},
          {"0", "Infancy", "", "1/2"},
          {"1", "Childhood", "", "1"},
          {"2", "Adolesence", "", "1"},
          {"3", "Young Adult*", "", "1"},
          {"4", "Adult", "", "3"},
          {"5", "Peak", "", "2"},
          {"6", "Mid-Life", "", "3"},
          {"7", "Senior", "", "3"},
          {"8", "Elder", "", "2"},
          {"9", "Retired", "", "1"}
        };
        break;
      }
      case "Aging Life Stages Vargr (60) - 97": {
        tables = new String[][]{
          {"No", "Life Stage", "Human yrs", "Terms"},
          {"0", "Infancy", "", "1/2"},
          {"1", "Childhood", "", "1"},
          {"2", "Adolesence", "", "1"},
          {"3", "Young Adult*", "", "2"},
          {"4", "Adult", "", "2"},
          {"5", "Peak", "", "2"},
          {"6", "Mid-Life", "", "2"},
          {"7", "Senior", "", "1"},
          {"8", "Elder", "", "1"},
          {"9", "Retired", "", "1"}
        };
        break;
      }
      case "Day names - 98": {
        tables = new String[][]{
          {"Wonday"},
          {"Tuday"},
          {"Thirday"},
          {"Forday"},
          {"Fiday"},
          {"Sixday"},
          {"Senday"}
        };
        break;
      }
      case "Dates - 99": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"001-000", "Dawn of the Imperium"},
          {"001-200", "First Survey"},
          {"001-550", "The Civil War"},
          {"001-870", "The Psionic Suppressions"},
          {"001-1105", "The Golden Age"},
          {"001-1116", "The Rebellion"},
          {"001-1248", "The New Era"},
          {"001-1902", "The Far Far Future"},
          {"220-????", "Emperor Strephons Birthday"}
        };
        break;
      }
      case "Education Skills College & University - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Any Art"},
          {"Any Science"},
          {"Athlete"},
          {"Broker"},
          {"Bureaucrat"},
          {"Counsellor"},
          {"Designer"},
          {"Language"},
          {"Teacher"}
        };
        break;
      }
      case "Education Skills Law School - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Advocate"},
          {"Bureaucrat"},
          {"Counsellor"},
          {"Diplomat"},
          {"Psychology"}
        };
        break;
      }
      case "Education Skills Medical School - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Biology"},
          {"Forensics"},
          {"Medical"},
          {"Sophontology"}
        };
        break;
      }
      case "Education Skills Apprentice Training Course - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Admin"},
          {"Advocate"},
          {"Animals"},
          {"Any Art"},
          {"Any Talent"},
          {"Any Trade"},
          {"Comms"},
          {"Computer"},
          {"Counsellor"},
          {"Driver"},
          {"Engineer"},
          {"Explosives"},
          {"Flyer"},
          {"Forensics"},
          {"Language"},
          {"Medical"},
          {"Seafarer"},
          {"Sensors"},
          {"Small Craft"}
        };
        break;
      }
      case "Education Skills Naval Academy - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Any Starship Skill"},
          {"Leader"},
          {"Tactics"},
          {"Naval Architect"}
        };
        break;
      }
      case "Education Skills Military Academy - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Any Soldier Skill"},
          {"Leader"},
          {"Tactics"}
        };
        break;
      }
      case "Education Skills Command College - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Strategy"},
          {"Leader"},
          {"Liaison"},
          {"Fleet Tactics (Navy only)"}
        };
        break;
      }
      case "Education-1 College - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pre-requisite", "EDU 5+"},
          {"To Apply", "INT or EDU"},
          {"Pass/Fail", "2xINT or 2xEDU"},
          {"Duration", "4y"},
          {"Graduation", "EDU=8"},
          {" and", "Bachelors"}
        };
        break;
      }
      case "Education-1 University - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pre-requisite", "EDU 7+ & Bachelor"},
          {"To Apply", "INT or EDU"},
          {"Pass/Fail", "2xINT or 2xEDU"},
          {"Duration", "4y"},
          {"Graduation", "EDU=9"},
          {" and", "Masters"}
        };
        break;
      }
      case "Education-1 University+ - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pre-requisite", "Masters"},
          {"To Apply", "INT or EDU"},
          {"Pass/Fail", "2xINT or 2xEDU"},
          {"Duration", "2y"},
          {"Graduation", "EDU=12"},
          {" and", "Doctor"}
        };
        break;
      }
      case "Education-1 Medical School - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pre-requisite", "Honors BA"},
          {"To Apply", "INT or EDU"},
          {"Pass/Fail", "4x INT or 4xEDU"},
          {"Duration", "4y"},
          {"Graduation", "EDU=10"},
          {" and", "Medical Doctor"}
        };
        break;
      }
      case "Education-1 Law School - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pre-requisite", "Honors BA"},
          {"To Apply", "INT or EDU"},
          {"Pass/Fail", "3xINT or 3xEDU"},
          {"Duration", "2y"},
          {"Graduation", "EDU=10"},
          {" and", "Lawer"}
        };
        break;
      }
      case "Education-1 Trade School - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pre-requisite", "C5=5+"},
          {"To Apply", "C2 or C3"},
          {"Pass/Fail", "1xINT or 1xTRA"},
          {"Duration", "1y"},
          {"Graduation", "-"},
          {" and", "-"}
        };
        break;
      }
      case "Education-1 Training Apprectice - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pre-requisite", "-"},
          {"To Apply", "auto"},
          {"Pass/Fail", "1xTRA"},
          {"Duration", "4y (Life Stage 2)"},
          {"Graduation", "Skill-4"},
          {" and", ""}
        };
        break;
      }
      case "Education-1 Training Course - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pre-requisite", "C5=TRA"},
          {"To Apply", "auto"},
          {"Pass/Fail", "1xTRA"},
          {"Duration", "1y"},
          {"Graduation", "Skill-4"},
          {" and", ""}
        };
        break;
      }
      case "Education-1 Training Mentor - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pre-requisite", "C5=TRA"},
          {"To Apply", "Int"},
          {"Pass/Fail", "1xINT or 1xTRA"},
          {"Duration", "1y"},
          {"Graduation", "TRA+2"},
          {" and", ""}
        };
        break;
      }
      case "Education-1 Military ANM School - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pre-requisite", "assigned"},
          {"To Apply", "auto"},
          {"Pass/Fail", "1xC2 or 1xC3"},
          {"Duration", "1y"},
          {"Graduation", "-"},
          {" and", ""}
        };
        break;
      }
      case "Education-1 Military Command College - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pre-requisite", "assigned"},
          {"To Apply", "auto"},
          {"Pass/Fail", "2xINT or 2xC5"},
          {"Duration", "1y"},
          {"Graduation", "-"},
          {" and", ""}
        };
        break;
      }
      case "Education-1 Military Service Academy - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pre-requisite", "C5=6+"},
          {"To Apply", "INT or EDU"},
          {"Pass/Fail", "4xINT or 4xC5"},
          {"Duration", "4y"},
          {"Graduation", "C5=8"},
          {" and", "Commission"}
        };
        break;
      }
      case "Education-1 ANM School - 100": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"A", "-", "-", "ACV"},
          {"A", "N", "-", "Aeronautics"},
          {"A", "-", "M", "Artillery"},
          {"A", "-", "M", "Automotive"},
          {"-", "N", "-", "Bay Wpns"},
          {"A", "-", "M", "Beams"},
          {"A", "-", "M", "Blades"},
          {"A", "N", "M", "Battle Dress"},
          {"A", "-", "M", "Exotics"},
          {"A", "-", "-", "Flapper"},
          {"A", "N", "M", "Grav"},
          {"-", "N", "-", "J-Drive"},
          {"A", "-", "M", "Launcher"},
          {"A", "-", "-", "Legged"},
          {"A", "N", "-", "Life Support"},
          {"A", "-", "-", "LTA"},
          {"-", "N", "-", "M-Drives"},
          {"A", "-", "-", "Mole"},
          {"A", "-", "M", "Ordnance"},
          {"-", "N", "M", "Ortillery"},
          {"A", "N", "M", "P-Plant"},
          {"-", "-", "-", "Rotor"},
          {"-", "N", "-", "Screens"},
          {"A", "N", "M", "Slug Thrower"},
          {"-", "N", "-", "Spines"},
          {"A", "-", "M", "Sprays"},
          {"A", "-", "M", "Tracked"},
          {"A", "N", "M", "Turrets"},
          {"A", "-", "M", "Unarmed"},
          {"A", "N", "M", "Wheeled"},
          {"A", "N", "-", "Winged"},
          {"A", "N", "M", "WMD"},
          {"A", "-", "M", "Rider"},
          {"A", "N", "M", "Trainer"},
          {"A", "-", "M", "Ship"},
          {"A", "-", "M", "Small Craft"}
        };
        break;
      }
      case "ED5 - 101": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"<City> Municipal Education System"},
          {"<City> City Schools"},
          {"<City> Consolidated School Districtj <Random>"},
          {"<City> Charter Schools"},
          {"<City> Independent School System <Random>"},
          {"<City> School System"},
          {"<Province> Peoples Pedagogical Institute"},
          {"<Province> Provincial Schools"},
          {"<Province> Academy"},
          {"<Province> Alternative Schools"},
          {"<Province> Regional Education System"}};
        break;
      }
      case "Trade Schools - 101": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"<Brand Name> Trade School"},
          {"<Company> School of <Skill>"},
          {"Institute of <Skill>"},
          {"<Brand Name> School of the <Skill> Arts"},
          {"<Company> Institute of <Skill>"},
          {"Standardized <Skill> Qualification Program"},
          {"<Skill> Instruction Course"},
          {"<Skill> Instruction Program"},
          {"<Skill> Correspondence Course"},
          {"<Skill> Career School"},
          {"Certified <Skill> Course"}};
        break;
      }
      case "College - 101": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"<City> College"},
          {"<Province> College"},
          {"College of <World>"},
          {"<City> City College"},
          {"<Province> Provincial College"},
          {"<World> College"},
          {"All <World> College of <Skill>"},
          {"<Province> College of <Skill>"},
          {"Peoples College of <Skill> (<World> Campus)"},
          {"<Province> <Skill> College"},
          {"<World> College <Skill>"}};
        break;
      }
      case "University - 101": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"<World> University"},
          {"<Company> University"},
          {"<Surname> University"},
          {"<World> <Surname> University"},
          {"University of <World>"},
          {"Imperial University of <World>"},
          {"All <World> University"},
          {"<Color> Faculty of the <World> Institute"},
          {"<Surname> Institute"},
          {"The <Color> Institute"},
          {"<World> Orbital University"}};
        break;
      }
      case "Medical School - 101": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"<World> University Medical School"},
          {"<Company> University Medical School"},
          {"<Surname> University Medical School"},
          {"<World> <Surname> University Medical School"},
          {"University of <World> Medical school"},
          {"University of <World> Medical school"},
          {"All <World> University Medical Specialty Course"},
          {"<World> Institute Online Medical Systems"},
          {"<Surname> Institute School of Medicine"},
          {"The <Color> Institute School of the Medical Arts"},
          {"<World> Orbital University College of Medicine"}};
        break;
      }
      case "Law School - 101": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"<World> University Law School"},
          {"<Company> University Law School"},
          {"<Surname> University Law School"},
          {"<World> <Surname> University Law School"},
          {"University of <World> Law school"},
          {"University of <World> Law school"},
          {"All <World> University Law Specialty Course"},
          {"<World> Institute Online Law Systems"},
          {"<Surname> Institute School of Medicine"},
          {"The <Color> Institute School of the Legal Arts"},
          {"<World> Orbital University College of Law"}};
        break;
      }
      case "Naval/Military Academy - 101": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"<Government> <Type> Academy (<World>)"},
          {"<Subdivision> <Type> Academy (<World>)"},
          {"<World> Continental <Type> Academy"},
          {"<Subdivision> Reserve <Type> Academy"},
          {"<Government> Reserve <Type> Academy"},
          {"<World> <Type> Academy"},
          {"<Government> <Type> Training Institute at <World>"},
          {"<Subdivision> <Type> Training Institute at <World>"},
          {"Peoples <Type> Academy at <World>"},
          {"All System Faculty for <Type> Instruction, (<World>)"},
          {"Online <Type> Instruction Directorate"}};
        break;
      }
      //////////////////////////////////////////////////////////////////////////
      case "Citizen Life - 102": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"War.  The homeworld is being devastated by military operations"},
          {"Natural Disaster.  The homeworld is suffering extensive natural disaster"},
          {"Environmental Change.  The homeworld is suffering experiencing extensive ecological change"},
          {"Personal Disaster.  The citizen has suffered a terrible personal loss"},
          {"Personal Discontent.  The citizen is discontent with his personal situation"},
          {"Personal Mission.  The citizen has a significant personal unfilled need"},
          {"Flight.  The citizen has witnessed events which prove dangerous to him"},
          {"Exploration.  The citizen has decided to abandon his current life"},
          {"Economic disaster.  The homeworld is suffering from economic disaster"},
          {"Social disgrace.  The citizen has suffered a significant social embarrassment"},
          {"Retirement.  The citizen has fulfilled his personal responsibilities to society on his homeworld"}};
        break;
      }
      case "Research Topic - 102": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"A preliminary survey of the literature of <Major>"},
          {"Aspects of the elementary philosophy of <Major>"},
          {"A detailed bibliography of <Major>"},
          {"The impact of data from <World> on <Major>"},
          {"Toward an alternate basic theory of <Major>"},
          {"The effects of <Minor> on <Major>"},
          {"Refuting Professor <Name>`s theory of <Major>"},
          {"Practical <Major> on <World>"},
          {"<Major>, and its impact on the Universe today"},
          {"Our evolving understanding of <Major>"},
          {"Disasters in the application of <Major>"}};
        break;
      }
      case "Merchant Companies - 102": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"<Surname> Express"},
          {"<World> Factors"},
          {"<World>-<World> Lines"},
          {"<Star> Agency"},
          {"<Letters> Lines"},
          {"<Surname> Shipping"},
          {"<World> Transporters"},
          {"<Satellite> Lines"},
          {"<Surname> & Sibs"},
          {"<Letters> Trading"},
          {"<Surname> Orbital Express"}};
        break;
      }
      case "Agent Mission - 102": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"To stop piracy"},
          {"To stop counterfeiting"},
          {"To root out bank fraud"},
          {"To stop illegal cloning"},
          {"To suppress psionics"},
          {"To uncover corrupt officials and Nobles"},
          {"To expose incompetence in the Navy"},
          {"To uncover fraud in the Scout service"},
          {"To discover spies in the bureaucracy"},
          {"To discover project secrets at <MegaCorp>"},
          {"To destroy data banks at <World>"}};
        break;
      }
      case "Noble Intrigues - 102": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"The <Element> Affair"},
          {"The <World> Scandal"},
          {"The <Satellite> Ring"},
          {"The Judgement Against <Surname>"},
          {"The Exile To <World>"},
          {"The <Surname> Commission"},
          {"<Surname>`s Palace"},
          {"<Surname>`s Return"},
          {"<Surname>`s Misconduct"},
          {"<Surname>`s Secret Exile"},
          {"The Assassination of <Surname>"}};
        break;
      }
      case "Spacer Units - 103": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"<1-Digit> Joint Battle Squadron"},
          {"<Star> Fleet Headquarters"},
          {"<World> Cruiser Squadron"},
          {"<1-Digit> Escort Squadron"},
          {"<3-Digit> System Defence Wing"},
          {"<4-Digit> Ortillery Squadron"},
          {"<2-Digit> Reserve Fighter Wing"},
          {"<2-Digit> Attack Squadron"},
          {"<City> Defence Squadron"},
          {"<Province> Support Squadron"},
          {"Special Long Range Squadron"}};
        break;
      }
      case "Soldier or Marine Units - 103": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Joint <World> Lift Infantry Regiment"},
          {"<Province> Grav Tank Squadron"},
          {"<City> Ortillery Regiment"},
          {"<1-Digit> Artillery Regiment"},
          {"<3-Digit> Lift Cavalry Squadron"},
          {"<4-Digit> Armored Infantry Regiment"},
          {"<World> PKF (Peace Keeping Force"},
          {"<2-Digit> Admin Battalion"},
          {"<City> Support Battalion"},
          {"<Province> Transportation Battalion"},
          {"Special Rifle Battalion"}};
        break;
      }
      case "Rogue Scheme - 103": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Promoting a fool proof project to terraform <World>"},
          {"Acquiring control of the major industry on <World>"},
          {"Hijacking the <World> Express"},
          {"Faking a Land Grant to the <World> <Element> Mines"},
          {"Selling fake antique portraits on nobles"},
          {"Selling a powerful but flawed starship armor formula"},
          {"Selling a plan to filter atmosphere taint of <World>"},
          {"Selling weapons in the conflict on <World>"},
          {"Selling battle dead clones as labor sophontoids"},
          {"Selling war surplus parts repackaged as new"},
          {"Enticing investors with a promise of nobility"}};
        break;
      }
      case "Spacer Service Battles - 103": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"The Scrubbing of <World>"},
          {"The Bombardments at <Star>"},
          {"The Ortillery Campaign at <Satellite>"},
          {"The Skimishes at <Gas Giant>"},
          {"The Pusuits at <Star>"},
          {"The Battle of <Satellite>"},
          {"The Relief of <World>"},
          {"The Quarantine of <World>"},
          {"The Siege of <World>"},
          {"The Disaster at <World>"},
          {"The Siege of <Gas Giant>"}};
        break;
      }
      case "Soldier or Marine Service Battles - 103": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"The Campaign on <World>"},
          {"The Bloody Campaign in <City>"},
          {"The Retreat from <Provice>"},
          {"The Assault on <World>"},
          {"The Defence of <Star>"},
          {"The Trench War at <Province>"},
          {"The Undeclared War at <World>"},
          {"The PK Operations in <City> (Peace Keeping)"},
          {"The Mistake at <Gas Giant>"},
          {"The Final Victory at <World>"},
          {"The Battle of <City>"}};
        break;
      }
      case "Rogue Masquerade - 103": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Citizen with family ties to the nobility"},
          {"Scholar with secret research in AI"},
          {"Entertainer who knows all the big stars"},
          {"Craftsman with access to thousands of masterpieces"},
          {"Scout with the coordinates of the Golden Worlds"},
          {"Spacer veteran of the <Star> anti-pirate campaign"},
          {"Soldier veteran war hero with an SEH"},
          {"Agent tracking down a Rogue on <World>"},
          {"Noble exiled unfairly"},
          {"Star marine officer once bodyguard to the Emperor"},
          {"Functionary on vacation"}};
        break;
      }
      case "Craftsman Secrets - 104": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"A key and a map"},
          {"<World> for an anti corrosive finish"},
          {"A list of masterpieces in an Imperial warehouse"},
          {"An Imperial Credit printed on ordinary paper"},
          {"A finely crafter target rifle"},
          {"Packet of seeds marked 'Fountain Of Youth' plant"},
          {"An AAB Archive Access Code - (AAB-AAC)"},
          {"A detailed 4NA scan of a sophont species"},
          {"The location of a grove of <Material> trees"},
          {"A wafer with the knowledge to construct a Jump-6 drive"},
          {"A sample of a super glue"}};
        break;
      }
      case "Scholar Secrets - 104": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"A reference to an unobtainable scholarly paper"},
          {"A sample from a long ago field expedition"},
          {"A report on the biology of life on <World>"},
          {"Chemical samples from <World>"},
          {"The secret handwritten memoirs of Cleon I"},
          {"A detailed Anglic-<Language> vocabulary"},
          {"The '<World> Book of Wisdom'"},
          {"Detailed readings predicting flare timing for <Star>"},
          {"A planetary quake predictor"},
          {"The secret location of the <World> Psionics Institute"},
          {"Computer access codes for University of <World>"}};
        break;
      }
      case "Entertainer Secrets - 104": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"A previously unknown script by a famous playwright"},
          {"A book banned by the Imperial bureaucracy"},
          {"The fabled never-released epic video by <Writer>"},
          {"Handwritten Ultimate Melody (some wrong notes?)"},
          {"The location of <Entertainer’s> secret mansion"},
          {"Samples of a paint of intense color"},
          {"Smell Artist <Name>’s private recipe book"},
          {"Studio notes for the Image Artist <Name>"},
          {"Samples of sound responsive paint"},
          {"A subliminal influence projector"},
          {"A detailed operations plan for a Touring Company"}};
        break;
      }
      case "Citizen or Functionary Secrets - 104": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"An approved real estate transaction form"},
          {"The location of the Psionics Institute of <World>"},
          {"A set of old 3D entertainment posters"},
          {"A dress worn by the Empress"},
          {"A data wafer with an encryption code scribbled on it"},
          {"Ownership documents for a company on <World>"},
          {"A set of rare early empire coins"},
          {"An unidentified genetic profile"},
          {"A claim tag for a locker at <World> Starport"},
          {"A small stasis capsule"},
          {"Misfiled ownership papers for property on <World>"}};
        break;
      }
      case "Scout Secrets - 104": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Co-ordinates for a world beyond the frontier"},
          {"The location of a First Empire advanced depot"},
          {"A high quality communicator"},
          {"Orbit details for a comet in the <Star> system"},
          {"The suppressed report on the Disaster at <World>"},
          {"Location of a wrecked battleship"},
          {"Location of a permanent storm on <World>"},
          {"A technique that increases Power Plant output 20%"},
          {"The only copy of a report on faulty Scout ship drives"},
          {"Scout Service bulletin interdicting <Star> System"},
          {"A simple device that disables Maneuver drives"}};
        break;
      }
      case "Merchant Secrets - 104": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"A blank certificate for <skill>"},
          {"Encryption key creation formulas for <Merchant>"},
          {"A face image of a pirate from <Subsector>"},
          {"A bearer bank account number on <World>"},
          {"A cargo shipment storage claim number"},
          {"A ship share certificate marked “Special”"},
          {"A clicker that seems to open every ship it visits"},
          {"An image of <World> starport before its renovation"},
          {"A wafer marked <Date> <World>"},
          {"Detailed plans for the <World> Starport"},
          {"Confidential ship schedules for <Company>"}};
        break;
      }
      case "Spacer Secrets - 105": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"A gun imager from a Zhodani fighter"},
          {"A prototype hull breach patch"},
          {"Precise performance specifications on Jump Drives"},
          {"Secret bulletin on naval patrols in <Subsector"},
          {"A component stock number not in the central catalog"},
          {"Co-ordinates of a rogue world in deep space"},
          {"Images of atrocities committed on <World>"},
          {"An Aslan warrior’s personal dagger"},
          {"A Vargr officer’s uniform cap."},
          {"A captured corsair banner"},
          {"The navigation module from a Zhodani frigate"}};
        break;
      }
      case "Soldier Secrets - 105": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"After Action Report for the <Battle>."},
          {"Contingency plan for an invasion of <World>"},
          {"Strange Zhodani automatic pistol."},
          {"An anti-matter artifact (in a magnetic capsule)."},
          {"Co-ordinates on an unexplored world"},
          {"The location of a fabled lost temple on <World>"},
          {"A seawater-stained shirt flecked with gold"},
          {"The co-ordinates of a ruined Tech-Z world"},
          {"A strange surly self-aware computer."},
          {"A chip with a programmable virus"},
          {"A combat drug that restores Sanity"}};
        break;
      }
      case "Rogue Secrets - 105": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"A Human DNA sample and personality scan"},
          {"A subliminal effect image."},
          {"Images of a secret Imperial starship"},
          {"A marketing plan for a recreational fad"},
          {"A 10,000 share certificate for a corporation."},
          {"A small rock with strange engraved markings"},
          {"An antique bracelet dating from the Long Night"},
          {"Fourteen copies of a real estate report on <World>"},
          {"The master password to a data backup facility"},
          {"The location of a secret Nuclear Weapons depot"},
          {"Time and place co-ordinates several years from now"}};
        break;
      }
      case "Agent Secrets - 105": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"A deck plan map of the Duke’s yacht."},
          {"Lock schematic for the vault at the Bank of <World>"},
          {"The co-ordinates of a “graveyard of lost ships.”"},
          {"A complete set of false identity papers."},
          {"A J-Drive-crippling 4D virus."},
          {"A memo filled with account numbers"},
          {"The script for a potential hit play."},
          {"Blueprints for an experimental navigation system"},
          {"The password to an account at the Bank of <World>,"},
          {"StdDGR-16 Standard Disposable Gauss Rifle -16"},
          {"A shipyard priority building code"}};
        break;
      }
      case "Noble Secrets - 105": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"A dossier on the Baron of <World>."},
          {"A false patent of nobility for the Baron of <World>"},
          {"A high priority code for Army procurement."},
          {"Plans for a starport upgrade at <World>"},
          {"A formula for a potent chemical weapon"},
          {"An heirloom set of goblets from the First Imperium"},
          {"A crudely drawn map labeled <World>."},
          {"A detailed family tree for the Marquis of <World>"},
          {"A 4D virus"},
          {"A bio-sample marked <World> Anagathic?"},
          {"Sophont skull with tags marked <World> 430k years?"}};
        break;
      }
      case "Marine Secrets - 105": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"A Marine dress dagger with a secret compartment"},
          {"A “Secret”-stamped Fusion-Gun Specification Manual"},
          {"A battle language dictionary."},
          {"Evidence of battlefield atrocities"},
          {"A controller for a Cutter"},
          {"Personnel directory of Star Marine Detachment 501"},
          {"A wafer with Fighting-12."},
          {"The location of an abandoned Rule of Man depot"},
          {"AMAcP-13 Advanced Magnum Accelerator Pistol -13"},
          {"An unusual bio-scanner."},
          {"A Zhodani combat banner"}};
        break;
      }
      case "Fame Calculation Armed Force Officers - 109": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Forces", "Rank*"},
          {"Wound Badge", "1"},
          {"MCUF", "1"},
          {"MCG", "3"},
          {"SEH", "8"},
          {"*SEH*", "10"}
        };
        break;
      }
      case "Fame Calculation Others - 109": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Noble", "CharGen", ""},
          {"Scholar", "Rank", ""},
          {"Scholar", "Publications", ""},
          {"Scholar", "Award Winning Pubs", "3"},
          {"Craftsman", "Masterpieces", "3"},
          {"Scout", "Discoveries", "4"},
          {"Merchant", "Rank", ""},
          {"Merchant", "Ship Owner", "1D"},
          {"Agent", "Commendations", ""},
          {"Rogue", "Successful Schemes", "2"},
          {"Rogue", "Failed Schemes", "3"}
        };
        break;
      }
      case "Medals Table - 109": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Char - Reward die"},
          {"1", "eXemplary Service"},
          {"2", "eXemplary Service"},
          {"3", "MCUF"},
          {"4", "MCUF"},
          {"5", "MCUF"},
          {"6", "MCG"},
          {"7", "MCG"},
          {"8", "SEH"},
          {"9", "SEH"},
          {"10", "*SEH*"},
          {"11", "*SEH*"},
          {"12", "*SEH*"}
        };
        break;
      }
      case "Sophontoid Obvious Identifying Markings - 126": {
        // Batch Sophontoid use obvious & unobtrusive
        // Premium Sophontoids use obtrusive only
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Spots Overall"},
          {"Conspicuous Patterns"},
          {"Blotches"},
          {"Multiple Marks"},
          {"Prominent Mark"},
          {"Pigmented Skin"},
          {"Patterned"},
          {"Subtly Patterned"},
          {"Subtly Colored"},
          {"Unpigmented"},
          {"Transparent Skin"}};
        break;
      }
      case "Sophontoid Unobtrusive Identifying Markings - 126": {
        // Batch Sophontoid use obvious & unobtrusive
        // Premium Sophontoids use obtrusive only
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Tattoo- Hidden"},
          {"Tattoo- Inconspicuous"},
          {"Minor"},
          {"Internal RFID"},
          {"Internal Scannable Chip"},
          {"Local ID marking"},
          {"Verbal Trigger"},
          {"Touch Point Disable"},
          {"Scent Trigger"},
          {"Visible Pattern Trigger"},
          {"IR Hotspot"}};
        break;
      }
      case "Sophontoid Control Structures - 126": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Accumulated Waste Residue Flush", "annually"},
          {"Organic Chemical Supplements", "daily"},
          {"Dietary Supplements", "daily"},
          {"Hormone Supplements", "monthly"},
          {"Eats spoiled or substandard foods", ""},
          {"Eats a specific geneered plant", ""},
          {"Internal Energy Cell Recharge", "daily"},
          {"Internal Energy Cell Recharge", "weekly"},
          {"Tailored Scent Input", "weekly"},
          {"Coded Strobe Light Incapacitation", ""},
          {"Coded Sound Pattern Incapacitation"}};
        break;
      }
      case "Task Statements - 130": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Assets", "    ", "", ""},
          {"Char", "    ", "", ""},
          {"Char", "    ", "+Mods1", ""},
          {"Char", "    ", "+Mods1", "+Mods2"},
          {"    ", "+Skill", "    ", "    "},
          {"    ", "+Skill", "+Mods1", ""},
          {"    ", "+Skill", "+Mods1", "+Mods2"},
          {"Char", "+Skill", "", ""},
          {"Char", "+Skill", "+Mods1", ""},
          {"Char", "+Skill", "+Mods1", "+Mods2"}
        };
        break;
      }
      case "Task Difficulties - 130": {
        tables = new String[][]{
          {"", "Difficulty", "Dice", "Hasty", "Cautious"},
          {"Eas", "Easy", "*", "", ""},
          {"Eas", "Easy (Skill-0)", "1D", "2D", "1D"},
          {"Avg", "Average", "2D", "3D", "1D"},
          {"Dif", "Difficult", "3D", "4D", "2D"},
          {"For", "Formidable", "4D", "5D", "3D"},
          {"Sta", "Staggering", "5D", "6D", "4D"},
          {"Hop", "Hopeless", "6D", "7D", "5D"},
          {"Imp", "Impossible", "7D", "8D", "6D"},
          {"Bey", "Beyond Impossible", "8D", "9D", "7D"}
        };
        break;
      }
      case "Difficulty Benchmarks - 138": {
        tables = new String[][]{
          {"Level", "C+S+K", "Difficulty", "Success"},
          {"Unskilled", "7", "Easy*", "58%  *Increased to Average; uses TIH!"},
          {"Novice", "8", "Average 2D", "72%"},
          {"Competent", "11", "Difficult 3D", "63%"},
          {"Experienced", "13", "Formidable 4D**", "84%  **If Cautious"},
          {"Master", "18", "Staggering 5D", "60%"},
          {"Master", "18", "Impossible", "9%"}
        };
        break;
      }
      case "Skill Groups - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Skills"},
          {"Starships"},
          {"Trades"},
          {"Arts"},
          {"Soldiers"},
          {"Talents"},
          {"Personals"},
          {"Intuitions"},
          {"Animals"},
          {"Driver"},
          {"Engineer"},
          {"Fighter"},
          {"Flyer"},
          {"Gunner"},
          {"Heavy Wpns"},
          {"Pilot"},
          {"Seafarer"},
          {"Sciences"},
          {"Specialized"}
        };
        break;
      }
      case "Skills(35) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Admin"},
          {"Advocate"},
          {"Animals"},
          {"Athlete"},
          {"Broker"},
          {"Bureaucrat"},
          {"Comms"},
          {"Computer"},
          {"Counsellor"},
          {"Designer"},
          {"Diplomat"},
          {"Driver"},
          {"Explosives"},
          {"Fleet Tactics"},
          {"Flyer"},
          {"Forensics"},
          {"Gambler"},
          {"High-G"},
          {"Hostile Environ"},
          {"JOT"},
          {"Language"},
          {"Leader"},
          {"Liaison"},
          {"Naval Architect"},
          {"Seafarer"},
          {"Stealth"},
          {"Strategy"},
          {"Streetwise"},
          {"Survey"},
          {"Survival"},
          {"Tactics"},
          {"Teacher"},
          {"Trader"},
          {"Vacc Suit"},
          {"Zero-G"}
        };
        break;
      }
      case "Starship Skills(7) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Astrogator"},
          {"Engineer"},
          {"Gunner"},
          {"Medic"},
          {"Pilot"},
          {"Sensors"},
          {"Steward"}
        };
        break;
      }
      case "Trades Skills(10) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Biologics"},
          {"Craftsman"},
          {"Electronics"},
          {"Fluidics"},
          {"Gravitics"},
          {"Magnetics"},
          {"Mechanic"},
          {"Photonics"},
          {"Polymers"},
          {"Programmer"}
        };
        break;
      }
      case "Arts Skills(6) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Actor"},
          {"Artist"},
          {"Author"},
          {"Chef"},
          {"Dancer"},
          {"Musician"}
        };
        break;
      }
      case "Soldier Skills(6) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Fighter"},
          {"Forward Obs"},
          {"Heavy Wpns"},
          {"Navigator"},
          {"Recon"},
          {"Sapper"}
        };
        break;
      }
      case "Default Skills(12) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Actor"},
          {"Artist"},
          {"Athlete"},
          {"Author"},
          {"Comms"},
          {"Computer"},
          {"Driver"},
          {"Fighter"},
          {"Turrets"},
          {"Mechanic"},
          {"Steward"},
          {"Vacc Suit"}
        };
        break;
      }
      case "Talents(16) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Compute"},
          {"Empath"},
          {"Hibernate"},
          {"Hypno"},
          {"Intuition"},
          {"Math"},
          {"MemAware"},
          {"Memorize"},
          {"MemPercep"},
          {"MemScent"},
          {"MemSight"},
          {"MemSound"},
          {"Morph"},
          {"Rage"},
          {"SoundMimic"}
        };
        break;
      }
      case "Personals(7) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Carouse"},
          {"Query"},
          {"Persuade"},
          {"Command"},
          {"Curiosity"},
          {"Insight"},
          {"Luck"}
        };
        break;
      }
      case "Animals(3) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Rider"},
          {"Teamster"},
          {"Trainer"}
        };
        break;
      }
      case "Driver(7) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"ACV"},
          {"Automotive"},
          {"Grav"},
          {"Legged"},
          {"Mole"},
          {"Tracked"},
          {"Wheeled"}
        };
        break;
      }
      case "Engineer(4) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Jump Drives"},
          {"Life Support"},
          {"Maneuver Drives"},
          {"Power Plants"}
        };
        break;
      }
      case "Fighter(7) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Battle Dress"},
          {"Beams"},
          {"Blades"},
          {"Exotics"},
          {"Slug Throwers"},
          {"Sprays"},
          {"Unarmed"}
        };
        break;
      }
      case "Flyer(6) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Aeronautics"},
          {"Flapper"},
          {"Grav"},
          {"LTA"},
          {"Rotor"},
          {"Wing"}
        };
        break;
      }
      case "Gunner(5) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Bay Weapons"},
          {"Ortillery"},
          {"Screens"},
          {"Spines"},
          {"Turrets"}
        };
        break;
      }
      case "Heavy Weapons(4) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Artillery"},
          {"Launcher"},
          {"Ordnance"},
          {"WMD"}
        };
        break;
      }
      case "Pilot(3) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Small Craft"},
          {"ACS"},
          {"BCS"}
        };
        break;
      }
      case "Seafarer(5) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Aquanautics"},
          {"Grav"},
          {"Boat"},
          {"Ship"},
          {"Sub"}
        };
        break;
      }
      case "The Sciences(13) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Archeology"},
          {"Biology"},
          {"Chemistry"},
          {"History"},
          {"Linguistics"},
          {"Philosophy"},
          {"Physics"},
          {"Planetology"},
          {"Psionicology"},
          {"Psychohistory"},
          {"Psychology"},
          {"Robotics"},
          {"Sophontology"}
        };
        break;
      }
      case "Specials(8) - 142": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Career: Academia"},
          {"Career: Army"},
          {"Career: Navy"},
          {"Career: <Name>"},
          {"World: Capita"},
          {"World: Regina"},
          {"World: <Name>"}
        };
        break;
      }
      case "Knowledge-Skill - 144":
      case "Skill-Knowledge - 144": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"First receipt", "Skill-0, Knowledge-1"},
          {"Second receipt", "Skill-0, Knowledge-2"},
          {"Third receipt", "Skill-1, Knowledge-1"},
          {"Fourth receipt", "Skill-2, Knowledge-2"}};
        break;
      }
      case "Languages - 163": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"!kee:", "K-kree",
            "The trade language spoken by most space-fairing K`kree"},
          {"Anglic", "Imperial", "One of two standard Imperial languages"},
          {"Battle", "Imperial",
            "The spoken and gesture battlefield language on the Imperial Star Marines"},
          {"Flash", "Kursae",
            "The perception based Police language or the Kursae"},
          {"Gonk", "Geonee",
            "The spoken language of the Geonee, a human minor race heavily involved in trade"},
          {"Gvegh", "Vargr",
            "The most commonly encountered Vargr language, spoken by most Vargr"},
          {"Oynprith", "Droyne", "Ancient ritual language of the Droyne"},
          {"Sagamaal", "Sword Worlds",
            "The most common language of the Sword Worlds, derived from Icelandic"},
          {"Tezapet", "Darrian", "The Darrian spoken language"},
          {"Trokh", "Aslan", "The Aslan spoken language"},
          {"Vilani", "Imperial",
            "One of two standard Imperial languages.  Derived from the spoken language of Vland"},
          {"Zhetl", "Zhodani", "The Zhodani spoken language"}
        };
        break;
      }
      case "Musical Instruments - 166": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Guitar"},
          {"Banjo"},
          {"Keyboard"},
          {"Piano"},
          {"Trumpet"},
          {"Trombone"},
          {"Violin"},
          {"Cello"}
        };
        break;
      }
      case "Compute: Accuracy vs Speed - 176": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"1D Easy", "1s", "1 in 100", "3p"},
          {"2D Average", "1m", "1 in 100", "9p"},
          {"3D Difficult", "2m", "1 in 1,000", "27p"},
          {"4D Formidable", "3m", "3m", "1 in 10,000"},
          {"5D Staggering", "5m", "5m", "1 in 100,000"}
        };
        break;
      }
      case "Empath: Readable Emotional States EMOTION - 176": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Distress"},
          {"Hate"},
          {"Fear"},
          {"Surprise"},
          {"Unease"},
          {"Blank"},
          {"Calm"},
          {"Surprise"},
          {"Courage"},
          {"Love"},
          {"Delight"}
        };
        break;
      }
      case "Empath: Readable Emotional States DEGREE - 176": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Utmost"},
          {"Extreme"},
          {"Major"},
          {"Significant"},
          {"Minor"},
          {"Trivial"},
          {"Minor"},
          {"Significant"},
          {"Major"},
          {"Extreme"},
          {"Utmost"}
        };
        break;
      }
      case "Memorize - 178": {
        tables = new String[][]{
          {"To repeat memorized info after:"},
          {"1 day", "Easy (1D)", "< (Int or Ins) + Memorize"},
          {"1 week", "Average (2D)", "< (Int or Ins) + Memorize"},
          {"1 month", "Difficult (3D)", "< (Int or Ins) + Memorize"},
          {"6 months", "Formidable (4D)", "< (Int or Ins) + Memorize"},
          {"1 year", "Staggering (5D)", "< (Int or Ins) + Memorize"},
          {"1 term", "Hopeless (6D)", "< (Int or Ins) + Memorize"},
          {"Life stage", "Impossible (7D)", "< (Int or Ins) + Memorize"},
          {"Lifetime", "Beyond (8D)", "< (Int or Ins) + Memorize"}
        };
        break;
      }
      case "Master Environ - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Frigid"},
          {"VCold"},
          {"Cold"},
          {"Chilly"},
          {"Cool"},
          {"Normal"},
          {"Warm"},
          {"VWarm"},
          {"Hot"},
          {"VHot"},
          {"Scalding"}
        };
        break;
      }
      case "Master Touch - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Frigid"},
          {"VCold"},
          {"Cold"},
          {"Chilly"},
          {"Cool"},
          {"Normal"},
          {"Warm"},
          {"VWarm"},
          {"Hot"},
          {"VHot"},
          {"Scalding"}
        };
        break;
      }
      case "Master Sound - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"- -"},
          {"- -"},
          {"Faint"},
          {"Whisper"},
          {"Soft"},
          {"Talking"},
          {"Loud"},
          {"Shout"},
          {"Cacophony"},
          {"- -"},
          {"- -"}
        };
        break;
      }
      case "Master Smell - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"- -"},
          {"- -"},
          {"- -"},
          {"Subliminal"},
          {"Subtle"},
          {"Ordinary"},
          {"Fragrant"},
          {"Pungent"},
          {"- -"},
          {"Overwhelming"},
          {"- -"}
        };
        break;
      }
      case "Master Light - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"- -"},
          {"- -"},
          {"Dim"},
          {"Obscured"},
          {"Hazy"},
          {"Visible"},
          {"Bright"},
          {"VBright"},
          {"UBright"},
          {"Blinding"},
          {"Burning"}
        };
        break;
      }
      case "Master Pain - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"- -"},
          {"Numb"},
          {"- -"},
          {"Normal"},
          {"Normal"},
          {"Normal"},
          {"Discomfort"},
          {"Stinging"},
          {"Painful"},
          {"VPainful"},
          {"Unbearable"}
        };
        break;
      }
      case "Master Truth - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"GAEWK", "Goes Against Everything We Know"},
          {"Unsettling"},
          {"Obviously false"},
          {"false"},
          {"Not quite"},
          {"Ordinary"},
          {"Good enough"},
          {"True"},
          {"Obviously true"},
          {"Epiphany"},
          {"Absolute truth"}
        };
        break;
      }
      case "Master Visibility - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Contact"},
          {"Reading"},
          {"Talking"},
          {"Vshort"},
          {"Short"},
          {"Visible"},
          {"Medium"},
          {"Long"},
          {"Vlong"},
          {"Distant"},
          {"Vdistant"}
        };
        break;
      }
      case "Master Respect (Soc1-Soc2) - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Non-acknowledgement"},
          {"Utter Contempt"},
          {"- -"},
          {"Distaste"},
          {"- -"},
          {"Peer"},
          {"- -"},
          {"Acknowledgement"},
          {"Admiration"},
          {"Absolute Respect"},
          {"Idolization"}
        };
        break;
      }
      case "Master Attitude - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Unenthusiastic"},
          {"- -"},
          {"Unsupportive"},
          {"- -"},
          {"Indifferent"},
          {"- -"},
          {"Interested"},
          {"- -"},
          {"Supportive"},
          {"- -"},
          {"Enthusiastic"}
        };
        break;
      }
      case "Master Conformity - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Total comformist"},
          {"- -"},
          {"- -"},
          {"Collectivist"},
          {"- -"},
          {"Balanced"},
          {"- -"},
          {"Individualist"},
          {"- -"},
          {"Egotist"},
          {"Narcissist"}
        };
        break;
      }
      case "Master Imagination - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Idiotic"},
          {"Foolish"},
          {"VDull"},
          {"Dull"},
          {"Pedestrian"},
          {"Ordinary"},
          {"Sharp"},
          {"Clever"},
          {"VClever"},
          {"Creative"},
          {"Genius"}
        };
        break;
      }
      case "Master Beauty - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Repulsive"},
          {"Ugly"},
          {"VUnattractive"},
          {"Unattractive"},
          {"VPlain"},
          {"Plain"},
          {"Cute"},
          {"Pretty"},
          {"VPretty"},
          {"Beautiful"},
          {"Stunning"}
        };
        break;
      }
      case "Master Walking - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"- -"},
          {"- -"},
          {"- -"},
          {"Crawl"},
          {"Stroll"},
          {"Walk"},
          {"Trot"},
          {"Run"},
          {"Sprint"},
          {"- -"},
          {"- -"}
        };
        break;
      }
      case "Master Driving - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Stuck"},
          {"- -"},
          {"Stop & Go"},
          {"VSlow"},
          {"Slow"},
          {"Drive"},
          {"Fast"},
          {"VFast"},
          {"Racing"},
          {"- -"},
          {"- -"}
        };
        break;
      }
      case "Master Highway - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Stuck"},
          {"- -"},
          {"- -"},
          {"Creeping"},
          {"Lagging"},
          {"Cruise"},
          {"Fast Lane"},
          {"Vfast Lane"},
          {"Grid Control"},
          {"Speeding"},
          {"- -"}
        };
        break;
      }
      case "Master Vilani - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"La Gasep"},
          {"Khiba"},
          {"Dulamas"},
          {"Ga Gasep"},
          {"Gasep"},
          {"Ligtar"},
          {"Kaar"},
          {"Biilem"},
          {"Ga Kaar"},
          {"Lamas"},
          {"La Kaar"}
        };
        break;
      }
      case "Master New Speak - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Worst*"},
          {"DoublePlusUnGood"},
          {"PlusUnGood"},
          {"Ungood"},
          {"HalfUnGood"},
          {"- -"},
          {"HalfGood"},
          {"Good"},
          {"PlusGood"},
          {"DoublePlusGood"},
          {"Best*"}
        };
        break;
      }
      case "Master Anglic - 180": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Worst"},
          {"Atrocious"},
          {"Very Bad"},
          {"Worse"},
          {"Bad"},
          {"Average"},
          {"Good"},
          {"Better"},
          {"Very Good"},
          {"Excellent"},
          {"Best"}
        };
        break;
      }

      case "Master Gravity - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"World=0 "},
          {"World=1 "},
          {"World=2-3 "},
          {"World=4-5 "},
          {"World=6 "},
          {"World=7 "},
          {"World=8 "},
          {"World=9 "},
          {"World=A "},
          {"World=B "},
          {"World=C "}
        };
        break;
      }
      case "Master Typical Bureaucratic Regs - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"General"},
          {"SuSAG"},
          {"Tukera"},
          {"Sharurshid"},
          {"- -"},
          {"Naasirka"},
          {"- -"},
          {"Makhidkarun"},
          {"Sternmetal"},
          {"LSP"},
          {"- -"}
        };
        break;
      }
      case "Master Typical Diplomatic Handbook - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"- -"},
          {"K`kree"},
          {"Solomani"},
          {"Zhodani"},
          {"- -"},
          {"Imperium"},
          {"Aslan"},
          {"- -"},
          {"Ziru Sirka"},
          {"Hiver"},
          {"- -"}
        };
        break;
      }
      case "Master Typical Diplomatic Difficulty - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Formidable"},
          {"Challenging"},
          {"Very Unstable"},
          {"Unstable"},
          {"Shaky"},
          {"- -"},
          {"- -"},
          {"- -"},
          {"- -"},
          {"- -"},
          {"- -"}
        };
        break;
      }
      case "Master Idea - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Derivative"},
          {"Boring"},
          {"Dull"},
          {"Uninspired"},
          {"Unoriginal"},
          {"Ordinary"},
          {"Novel"},
          {"Ingenious"},
          {"Innovative"},
          {"Imaginative"},
          {"Truly Inspired"}
        };
        break;
      }
      case "Master Comms Environ - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Jammed"},
          {"Equip Fault"},
          {"Equip Glitch"},
          {"Interference"},
          {"Static"},
          {"Good"},
          {"Very Good"},
          {"Excellent"},
          {"Clear"},
          {"Very Clear"},
          {"Crystal Clear"}
        };
        break;
      }
      case "Master Logic - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Indeterminate"},
          {"Fuzzy"},
          {"Meaningless"},
          {"False"},
          {"Probably False"},
          {"Logical"},
          {"Probably True"},
          {"True"},
          {"Self-Referential"},
          {"Unsolvable"},
          {"Paradoxical"}
        };
        break;
      }
      case "Master Weather - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Extremely Bad"},
          {"Very Bad"},
          {"Worse"},
          {"Bad"},
          {"Inconvenient"},
          {"Neutral"},
          {"Fortuitous"},
          {"Good"},
          {"Better"},
          {"Very Good"},
          {"Extremely Good"}
        };
        break;
      }
      case "Master Rewards - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"- -"},
          {"Insulting"},
          {"Insensitive"},
          {"- -"},
          {"- -"},
          {"- -"},
          {"Token"},
          {"- -"},
          {"- -"},
          {"- -"},
          {"Incredible"}
        };
        break;
      }
      case "Master Speed kph - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"5"},
          {"10"},
          {"20"},
          {"30"},
          {"50"},
          {"100"},
          {"300"},
          {"500"},
          {"700"},
          {"1000"},
          {"2000"},
          {"3000"}
        };
        break;
      }
      case "Master Speed - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Creep"},
          {"Crawl"},
          {"XSlow"},
          {"VSlow"},
          {"Slow"},
          {"Standard"},
          {"Cruise"},
          {"Fast"},
          {"VFast"},
          {"Sonic"},
          {"SSonic"},
          {"HSonic"}
        };
        break;
      }
      case "Master Encounter Range - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Contact"},
          {"VShort"},
          {"Short"},
          {"Medium"},
          {"Long"},
          {"VLong"},
          {"Distant"},
          {"VDistant"},
          {"Orbit"}
        };
        break;
      }
      case "Master Jump Time Commercial - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"-10h"},
          {"-8h"},
          {"-6h"},
          {"-4h"},
          {"-2h"},
          {""},
          {"+2h"},
          {"+4h"},
          {"+6h"},
          {"+8h"},
          {"+10h"}
        };
        break;
      }
      case "Master Jump Time Naval - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"-5h"},
          {"-4h"},
          {"-3h"},
          {"-2h"},
          {"-1h"},
          {"+0h"},
          {"+1h"},
          {"+2h"},
          {"+3h"},
          {"+4h"},
          {"+5h"}
        };
        break;
      }
      case "Master Emotional - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Distress"},
          {"Hate"},
          {"Fear"},
          {"Surprise"},
          {"Unease"},
          {"Blank"},
          {"Calm"},
          {"Surprise"},
          {"Courage"},
          {"Love"},
          {"Delight"}
        };
        break;
      }
      case "Master Degree - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Utmost"},
          {"Extreme"},
          {"Major"},
          {"Significant"},
          {"Minor"},
          {"Trivial"},
          {"Minor"},
          {"Significant"},
          {"Major"},
          {"Extreme"},
          {"Utmost"}
        };
        break;
      }
      case "Master Potential - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Terrible"},
          {"XBad"},
          {"VBad"},
          {"Bad"},
          {"Poor"},
          {"Ordinary"},
          {"Possible"},
          {"Good"},
          {"VGood"},
          {"XGood"},
          {"Wonderful"}
        };
        break;
      }
      case "Master Brand Names - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Loamer"},
          {"Sloeph"},
          {"Cerlan"},
          {"Boron"},
          {"Neol Sibs"},
          {"Engolia"},
          {"Kosinar"},
          {"JPG"},
          {"Vereos"},
          {"Tyxagon Corp"},
          {"Starling"}
        };
        break;
      }
      case "Master Anglic Names - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Glump"},
          {"NNA"},
          {"Peerless"},
          {"Consolidated"},
          {"Dorado"},
          {"Acme"},
          {"Ponii"},
          {"Golden"},
          {"Official TAS"},
          {"Iridium"},
          {"715 Corp"}
        };
        break;
      }
      case "Master Vilani Brands - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Naa"},
          {"Kakna"},
          {"Seleni"},
          {"Lanuur"},
          {"Khush"},
          {"Ushum"},
          {"Ganun"},
          {"Shakashdir"},
          {"Sebiilem"},
          {"Agbar Urdim"},
          {"Karak"}
        };
        break;
      }
      case "Master MegaCorps - 181": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"General"},
          {"GsbAg"},
          {"Delgado"},
          {"Hortalez"},
          {"SuSAg"},
          {"Makhidkarun"},
          {"Zirunkarish"},
          {"Zirunkariish"},
          {"Sharurshid"},
          {"Naasirka"},
          {"LSP"},
          {"Instellarms"}
        };
        break;
      }
      //////////////////////////////////////////////////////////////////////////
      case "Fame Descriptor - 109": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Unknown"},
          {"Parent"},
          {"Close Family"},
          {"Extended Family"},
          {"Neighbourhood"},
          {"Town"},
          {"City"},
          {"Large City"},
          {"Regional"},
          {"Continental"},
          {"World"},//10
          {"World Complex"},
          {"World System"},
          {"Inner System"},
          {"System"},
          {"Greater System"},
          {"Outer System"},
          {"System"},
          {"Many Systems"},
          {"Subsector"},
          {"Sector"},//20
          {"Domain"},
          {"Domains"},
          {"Many Domains"},
          {"Empire"},
          {"Beyond Empire"},
          {"Several Empires"},
          {"This Spiral Arm"},
          {"Many Spiral Arms"},
          {"The Galaxy"},
          {"Several Galaxies"},
          {"Many Galaxies"},
          {"The Universe"},
          {"Present Reality"},
          {"Past Realities"},
          {"Future Realities"},
          {"All Reality"},};
        break;
      }
      case "Typical Mods TL Low - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"TL 0"},
          {"TL 1"},
          {"TL 2"},
          {"TL 3"},
          {"TL 4"},
          {"TL 5"},
          {"TL 6"},
          {"TL 7"},
          {"TL 8"},
          {"TL 9"},
          {"TL A"}
        };
        break;
      }
      case "Typical Mods TL High - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"TL 5"},
          {"TL 6"},
          {"TL 7"},
          {"TL 8"},
          {"TL 9"},
          {"TL A"},
          {"TL B"},
          {"TL C"},
          {"TL D"},
          {"TL E"},
          {"TL F"}
        };
        break;
      }
      case "Typical Mods TL VHigh - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"TL A"},
          {"TL B"},
          {"TL C"},
          {"TL D"},
          {"TL E"},
          {"TL F"},
          {"TL G"},
          {"TL H"},
          {"TL J"},
          {"TL K"},
          {"TL M"}
        };
        break;
      }
      case "Typical Mods TL Extreme - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"TL N"},
          {"TL P"},
          {"TL Q"},
          {"TL R"},
          {"TL S"},
          {"TL T"},
          {"TL U"},
          {"TL V"},
          {"TL W"},
          {"TL X"},
          {"TL Y"}
        };
        break;
      }
      case "Typical Mods Multiples - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"- -"},
          {"- -"},
          {"- -"},
          {"- -"},
          {"- -"},
          {"Individuals"},
          {"Groups"},
          {"Hundreds"},
          {"Thousands"},
          {"10,000"},
          {"100,000"}
        };
        break;
      }
      case "Typical Mods Fractions - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Almost none"},
          {"One-Quarter"},
          {"One-Third"},
          {"Three-Eighths"},
          {"Almost Half"},
          {"Half"},
          {"More Than Half"},
          {"Five-Eighths"},
          {"Two-Thirds"},
          {"Three-Quarters"},
          {"Almost All"}
        };
        break;
      }
      case "Typical Mods Evidence - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Inconceivable"},
          {"Impossible"},
          {"Some Scitilla"},
          {"- -"},
          {"Possible"},
          {"Preponderance"},
          {"Probable"},
          {"Substantial"},
          {"Convincing"},
          {"Clear And Convincing"},
          {"Beyond A Shadow Of A Doubt"}
        };
        break;
      }
      case "Typical Mods Careers - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Citizen"},
          {"Scholar"},
          {"Entertainer"},
          {"Craftsman"},
          {"Scout"},
          {"Merchant"},
          {"Spacer"},
          {"Soldier"},
          {"Agent"},
          {"Rogue"},
          {"Noble"},
          {"Marine"},
          {"Functionary"}
        };
        break;
      }
      case "Typical Mods Friends - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"- -"},
          {"Nemesis"},
          {"Enemy"},
          {"- -"},
          {"- -"},
          {"- -"},
          {"- -"},
          {"Acquaintance"},
          {"Fair Weather"},
          {"Friend"},
          {"Fast Friend"},
          {"Close Friend"},
          {"- -"}
        };
        break;
      }
      case "Typical Mods Order/Chaos - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pure Chaos"},
          {"Chaos"},
          {"Chaotic"},
          {"Chaotic"},
          {"Neutral"},
          {"Neutral"},
          {"Neutral"},
          {"Orderly"},
          {"Orderly"},
          {"Orderly"},
          {"Orderly"}
        };
        break;
      }
      case "Typical Mods Good/Evil - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Pure Evil"},
          {"Evil"},
          {"Evil"},
          {"Evil"},
          {"Neutral"},
          {"Neutral"},
          {"Neutral"},
          {"Good"},
          {"Good"},
          {"Good"},
          {"Pure Good"}
        };
        break;
      }
      case "Typical Mods Sounds - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"- -"},
          {"- -"},
          {"- -"},
          {"- -"},
          {"Earpiece"},
          {"Whisper"},
          {"Talking"},
          {"Lecture"},
          {"Shout"},
          {"Distress"},
          {"Many in Distress"},
          {"Gunshot"},
          {"Thunder"}
        };
        break;
      }
      case "Typical Mods Probability - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Impossible"},
          {"Highly Improbable"},
          {"Improbable"},
          {"Highly Unlikely"},
          {"Not Likely"},
          {"50/50"},
          {"Possible"},
          {"Likely"},
          {"Probable"},
          {"Very Probable"},
          {"Almost Certain"},
          {"Certain"}
        };
        break;
      }
      case "Typical Mods Severity - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"None"},
          {"Trivial"},
          {"Negligible"},
          {"Very Minor"},
          {"Minor"},
          {"Mild"},
          {"Temporary"},
          {"Strong"},
          {"Major"},
          {"Severe"},
          {"Very Severe"},
          {"Devastating"},
          {"Total"}
        };
        break;
      }
      case "Typical Mods Imminence - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Distant Future"},
          {"Centuries"},
          {"Lifetime"},
          {"Generation"},
          {"Decades"},
          {"Years"},
          {"Months"},
          {"Weeks"},
          {"Days"},
          {"Hours"},
          {"Minutes"},
          {"Seconds"},
          {"Now"}
        };
        break;
      }
      case "Typical Mods Humanitii - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Ilthanan"},
          {"Thaggeshi"},
          {"Loeskalth"},
          {"Answerin"},
          {"Suerrat"},
          {"Solomani"},
          {"Human"},
          {"Vilani"},
          {"Zhodani"},
          {"Geonee"},
          {"Azhanti"},
          {"Vlazhdumecta"},
          {"Floriani"}
        };
        break;
      }
      case "Typical Mods Major Races - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {""},
          {""},
          {""},
          {"Hivers"},
          {"Aslan"},
          {"Solomani"},
          {"Human"},
          {"Vilani"},
          {"K`kree"},
          {""},
          {""}
        };
        break;
      }
      case "Typical Mods Major Sophonts - 182": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Hlanassai"},
          {"Gurvin"},
          {"Ahetaowa"},
          {"Ael Yael"},
          {"Llellewlowy"},
          {"Vegans"},
          {"Bwaps"},
          {"Virushi"},
          {"Eshaar Ashah"},
          {"Marani"},
          {"Jgd-il-Jadg"},
          {"Lshana"}
        };
        break;
      }
      case "Typical Mods Major Barrier Height - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Formidable"},
          {"Challenging"},
          {"Very High"},
          {"High"},
          {"Barrier"},
          {"Ordinary"}
        };
        break;
      }
      case "Typical Mods Major Barrier Width - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Formidable"},
          {"Challenging"},
          {"Very Wide"},
          {"Wide"},
          {"Barrier"},
          {"Ordinary"}
        };
        break;
      }
      case "Typical Mods Stability - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Formidable"},
          {"Challenging"},
          {"Very Unstable"},
          {"Unstable"},
          {"Shaky"},
          {"Stable"}
        };
        break;
      }
      case "Typical Mods Xeno-Med - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Illogical"},
          {"Obscure"},
          {"Very Strange"},
          {"Strange"},
          {"Uncommon"},
          {"Ordinary"}
        };
        break;
      }
      case "Typical Mods Wounds - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Very Heavy"},
          {"Heavy"},
          {"Common"},
          {"Light"},
          {"Slight"},
          {"Scratch"}
        };
        break;
      }
      case "Typical Mods Severity - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Intense", "5D"},
          {"Critical", "4D"},
          {"Serious", "3D"},
          {"Fair", "2D"},
          {"Good", "1D"},
          {"Scratch", ""}
        };
        break;
      }
      case "Typical Mods Diagnosis - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Very Obscure", "5D"},
          {"Obscure", "4D"},
          {"Very Difficult", "3D"},
          {"Hard", "2D"},
          {"Ordinary", "1D"},
          {"Easy", ""}
        };
        break;
      }
      case "Typical Mods Gravity Or Acceleration - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Crushing"},
          {"Extreme"},
          {"Crippling"},
          {"Very Strong"},
          {"Strong"},
          {"Normal"}
        };
        break;
      }
      case "Typical Mods Environment - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Chaotic"},
          {"Disorienting"},
          {"Disrupting"},
          {"Swirling"},
          {"Bothersome"},
          {"Normal"}
        };
        break;
      }
      case "Typical Mods Zero-G - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Chaotic"},
          {"Disorienting"},
          {"Disrupting"},
          {"Fluxing"},
          {"Abnormal"},
          {"Normal"}
        };
        break;
      }
      case "Typical Mods Wound - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"6D", "Disastrous"},
          {"5D", "Very Heavy"},
          {"4D", "Heavy"},
          {"3D", "Common"},
          {"2D", "Light"},
          {"1pt", "Scratch"}
        };
        break;
      }
      case "Typical Mods Damage - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"6D", "Near Total"},
          {"5D", "Very Heavy"},
          {"4D", "Heavy"},
          {"3D", "Common"},
          {"2D", "Light"},
          {"1pt", "Scratch"}
        };
        break;
      }
      case "Typical Mods - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {""},
          {""},
          {"Heavy Armour"},
          {"Armored"},
          {"Lt Armor"},
          {"Typical"}
        };
        break;
      }
      case "Typical Move Mods - 183": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {""},
          {""},
          {""},
          {""},
          {"Evade"},
          {"Typical"}
        };
        break;
      }
      case "Typical Mods Megacorporations - 183": {
        tables = new String[][]{
          {"MegaCorporation", "Q", "R", "E", "B", "S", "Primary Products"},
          {"General", "-2", "", "", "+1", "-1",
            "Starships, Small Craft, Heavy Machinery."},
          {"GsbAg", "", "-1", "+1", "", "",
            "Military Equipment, Small Arms, Artillery."},
          {"Delgado", "", "", "", "-1", "+1",
            "Heavy Equipment, Infomation Technology."},
          {"Hortalez", "", "-1", "", "", "",
            "Banking. Financial Products.  Investments."},
          {"SuSAg", "-1", "", "", "", "",
            "Chemicals.  Pharmaceuticals.  Synthetics."},
          {"Makhidkarun", "", "", "", "-1", "",
            "Information Technology.  Computers."},
          {"Zirunkariish", "+1", "", "", "", "",
            "Banking.  Investments.  Insurance"},
          {"Sharurshid", "", "+1", "", "", "", "Trading.  Merchantile Services."},
          {"Naasirka", "+2", "", "", "", "+2",
            "Computers.  Robotics.  Software.  Transport."},
          {"LSP", "", "+2", "", "-1", "-1", ""},
          {"Instellarms", "", "", "-1", "", "+1",
            "Military Equipment.  Labor.  Robotics."}
        };
        break;
      }
      case "Typical Mods Common Brands - 183": {
        tables = new String[][]{
          {"Common Brands", "Q", "R", "E", "B", "S", "Primary Products"},
          {"Loamer", "", "-2", "", "", "", "Wafers."},
          {"Sloeph", "", "", "", "", "-2", "Pharmaceutical.  Sanity Meds."},
          {"Cerlan", "", "", "", "-2", "", "Pharmaceutical.  Medicines."},
          {"Engalia", "", "-1", "", "", "", "Starport Services."},
          {"Neol Sibs", "", "", "", "", "", "Entertainment."},
          {"Boron", "", "", "", "", "", "Generic Products."},
          {"Kosinar", "", "", "", "", "", "Consumer Weapons And Armor."},
          {"JPG", "", "", "+1", "", "", "Foods.  Snacks."},
          {"Vereos", "", "", "", "+2", "", "Computers."},
          {"Tyxagon Corp", "", "", "", "", "-2",
            "Artificial, Ersatz, Substitute Products, especially consumables."},
          {"Starling", "", "", "+2", "", "",
            "Information Technology.  Software."}
        };
        break;
      }
      case "Personal Interactions - 188": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"PURPOSE", "STRATEGY", "INTERESTS", "ENEMIES", "LOGIC", "AUTHORITY",
            "MORALITY", "CULTURE", "EMOTION", "INDEBTED", "PAYMENT", "BEGGING",
            "POLITENESS", "FLATTERY", "REFERRAL", "FAMILIARITY", "INSULT",
            "PAIN"},
          //////////////////////////////////////////////////////////////////////
          {"Carouse 1D", "Casual", "+3", "+2", "-", "NO", "-", "-", "-", "-",
            "NO", "NO", "-", "x2", "x2", "x2", "NO", "-8"},
          {"Carouse 1D", "Enjoyment", "-", "-", "-", "-", "-", "-", "-", "-",
            "-", "NO", "-", "x2", "x2", "x2", "NO", "-6"},
          {"Carouse 1D", "Discussion", "-", "-", "x2", "x2", "x2", "x2", "x2",
            "-", "-", "-", "-", "-", "x2", "x2", "NO", "-6"},
          {"Carouse 1D", "Active Listen", "-", "-", "-", "-", "-", "-", "-", "-",
            "-", "-", "-", "-", "-", "-", "-", "-6"},
          {"Carouse 1D", "Appeal To", "-", "-", "x2", "-", "x2", "x2", "x2", "-",
            "x2", "x2", "x2", "x2", "-", "-", "-", "+4*"},
          //////////////////////////////////////////////////////////////////////
          {"Query 2D", "Enjoyment", "-", "-", "-", "-", "-", "-", "-", "-", "-",
            "NO", "-", "x2", "x2", "x2", "NO", "-6"},
          {"Query 2D", "Discussion", "-", "-", "x2", "x2", "x2", "x2", "x2",
            "-", "-", "-", "-", "-", "x2", "x2", "NO", "-6"},
          {"Query 2D", "Active Listen", "-", "-", "-", "-", "-", "-", "-", "-",
            "-", "-", "-", "-", "-", "-", "-", "-6"},
          {"Query 2D", "Appeal To", "-", "-", "x2", "-", "x2", "x2", "x2", "-",
            "x2", "x2", "x2", "x2", "-", "-", "-", "+4*"},
          {"Query 2D", "Force Of Will", "-", "-", "x2", "x2", "x2", "x2", "x2",
            "-", "-", "NO",
            "-", "-", "-", "-", "x2", "+6*"},
          //////////////////////////////////////////////////////////////////////
          {"Persuade 3D", "Discussion", "-", "-", "x2", "x2", "x2", "x2", "x2",
            "-", "-", "-", "-", "-", "x2", "x2", "NO", "-6"},
          {"Persuade 3D", "Active Listen", "-", "-", "-", "-", "-", "-", "-",
            "-", "-", "-", "-", "-", "-", "-", "-", "-6"},
          {"Persuade 3D", "Appeal To", "-", "-", "x2", "-", "x2", "x2", "x2",
            "-", "x2", "x2", "x2", "x2", "-", "-", "-", "+4*"},
          {"Persuade 3D", "Force Of Will", "-", "-", "x2", "x2", "x2", "x2",
            "x2", "-", "-", "NO", "-", "-", "-", "-", "x2", "+6*"},
          {"Persuade 3D", "Charming", "-", "x3", "-", "x2", "x2", "x2", "x2",
            "x2", "-", "x2", "-", "x2", "x2", "-", "-", "-4*"},
          //////////////////////////////////////////////////////////////////////
          {"Command 4D", "Active Listen", "-", "-", "-", "-", "-", "-", "-",
            "-", "-", "-", "-", "-", "-", "-", "-", "-6"},
          {"Command 4D", "Appeal To", "-", "-", "x2", "-", "x2", "x2", "x2",
            "-", "x2", "x2", "x2", "x2", "-", "-", "-", "+4*"},
          {"Command 4D", "Force Of Will", "-", "-", "x2", "x2", "x2", "x2",
            "x2", "-", "-", "NO", "-", "-", "-", "-", "x2", "+6*"},
          {"Command 4D", "Charming", "-", "x3", "-", "x2", "x2", "x2", "x2",
            "x2", "-", "x2", "-", "x2", "x2", "-", "-", "-4*"},
          {"Command 4D", "Angry", "-", "x3", "x2", "x2", "x2", "x2", "x2", "x2",
            "-", "-", "-", "-", "-", "-", "x2", "+6*"}
        };
        break;
      }
      case "Personal Interaction Strategy - 188": {
        tables = new String[][]{
          {"STRATEGY", "INTERESTS", "ENEMIES", "LOGIC", "AUTHORITY",
            "MORALITY", "CULTURE", "EMOTION", "INDEBTED", "PAYMENT", "BEGGING",
            "POLITENESS", "FLATTERY", "REFERRAL", "FAMILIARITY", "INSULT",
            "PAIN"},
          {"Casual", "+3", "+2", "-", "NO", "-", "-", "-", "-",
            "NO", "NO", "-", "x2", "x2", "x2", "NO", "-8"},
          {"Enjoyment", "-", "-", "-", "-", "-", "-", "-", "-",
            "-", "NO", "-", "x2", "x2", "x2", "NO", "-6"},
          {"Discussion", "-", "-", "x2", "x2", "x2", "x2", "x2",
            "-", "-", "-", "-", "-", "x2", "x2", "NO", "-6"},
          {"Active Listen", "-", "-", "-", "-", "-", "-", "-", "-",
            "-", "-", "-", "-", "-", "-", "-", "-6"},
          {"Appeal To", "-", "-", "x2", "-", "x2", "x2", "x2", "-",
            "x2", "x2", "x2", "x2", "-", "-", "-", "+4*"},
          {"Force Of Will", "-", "-", "x2", "x2", "x2", "x2",
            "x2", "-", "-", "NO", "-", "-", "-", "-", "x2", "+6*"},
          {"Charming", "-", "x3", "-", "x2", "x2", "x2", "x2",
            "x2", "-", "x2", "-", "x2", "x2", "-", "-", "-4*"},
          {"Angry", "-", "x3", "x2", "x2", "x2", "x2", "x2", "x2",
            "-", "-", "-", "-", "-", "-", "x2", "+6*"}
        };
        break;
      }
      case "Personal Interaction Purpose - 188": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"PURPOSE"},
          {"Carouse 1D"},
          {"Query 2D"},
          {"Persuade 3D"},
          {"Command 4D"}
        };
        break;
      }
      case "Personal Interaction Tactics - 188": {
        tables = new String[][]{
          {"Interests", "Enemies", "Logic", "Authority", "Morality", "Culture",
            "Emotion", "Indebted", "Payment", "Begging", "Politeness",
            "Flattery", "Referral", "Familiarity", "Insult", "Pain"},};
        break;
      }
      case "Personal Interaction 5 LAWS - 188": {
        tables = new String[][]{
          {"LAW", "TYPE", "CAROUSE", "QUERY", "PERSUADE", "COMMAND"},
          {"1", "Similarity", "+1", "+1", "+1", "-"},
          {"2", "Superiority", "-", "+1", "+2", "+3"},
          {"3", "Inferiority", "-", "+1", "+2*", "-"},
          {"4", "Comfort", "+2", "+1", "+1", "-"},
          {"5", "Violence", "-", "+1", "+2", "+3"},
          {"*", "IF Begging, Flattery or Politeness"}
        };
        break;
      }
      case "Personal Interaction Resolution - 188": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Purpose", ""},
          {"Strategy", ""},
          {"Tactic", ""},
          {"Laws", ""},
          {"Mod1", ""},
          {"Mod2", ""}
        };
        break;
      }
      case "QREBS-1 - 194": {
        tables = new String[][]{
          {cb4tables.getValue().toUpperCase()},
          {"Q", "Quality (and Period)"},
          {"R", "Reliability"},
          {"E", "Ease Of Use"},
          {"B", "Burden"},
          {"S", "Stage"}
        };
        break;
      }
      case "QREBS-Quality - 194": {
        tables = new String[][]{
          {"2D-2", "Description", "Mod", "Period"},
          {"", "Garbage", "-6 or less", "Non-functioning"},
          {"0", "Very Bad", "-5", "Minutes"},
          {"1", "Bad", "-4", "Hours"},
          {"2", "Poor", "-3", "Days"},
          {"3", "Lesser", "-2", "Weeks"},
          {"4", "Below Average", "-1", "Months"},
          {"5", "Average", "0", "Six Months"},
          {"6", "Better Than Some", "+1", "1y"},
          {"7", "Better Than Many", "+2", "2y"},
          {"8", "Very Good", "+3", "3y"},
          {"9", "Better Than Most", "+4", "4y"},
          {"10 A", "Excellent", "+5", "10y"},
          {"11 B", "Superb", "+6", "20y"},
          {"12 C", "Masterpiece", "+7", "Centuries"}
        };
        break;
      }
      case "QREBS-Reliability - 194": {
        tables = new String[][]{
          {"2D-7", "Description"},
          {"-5", "Very Unreliable"},
          {"-4", "More Unreliable"},
          {"-3", "Unreliable"},
          {"-2", "Somewhat Unreliable"},
          {"-1", "Slightly Unreliable"},
          {"0", "Reliability-Neutral"},
          {"+1", "Better Than Some"},
          {"+2", "Better Than Many"},
          {"+3", "Reliable"},
          {"+4", "More Reliable"},
          {"+5", "Very Reliable"}
        };
        break;
      }
      case "QREBS-EaseOfUse - 194": {
        tables = new String[][]{
          {"2D-7", "Description"},
          {"-5", "Very Difficult To Use"},
          {"-4", "More Difficult To Use"},
          {"-3", "Hard To Use"},
          {"-2", "Somewhat Hard To Use"},
          {"-1", "Slightly Difficult To Use"},
          {"0", "Ease Of Use Neutral"},
          {"+1", "Better Than Some"},
          {"+2", "Better Than Many"},
          {"+3", "Easy To Use"},
          {"+4", "Easier To Use"},
          {"+5", "Very Easy To Use"}
        };
        break;
      }
      case "QREBS-Burden - 194": {
        tables = new String[][]{
          {"2D-7", "Description"},
          {"-5", "Very Easy To Carry"},
          {"-4", "Easier To Carry"},
          {"-3", "Easy To Carry"},
          {"-2", "Better Than Many"},
          {"-1", "Better Than Some"},
          {"0", "Burden Neutral"},
          {"+1", "Slightly Unergonomic"},
          {"+2", "Unwieldy"},
          {"+3", "Hard To Carry"},
          {"+4", "More Burdensome"},
          {"+5", "Very Burdensome"}
        };
        break;
      }
      case "QREBS-Safety - 194": {
        tables = new String[][]{
          {"2D-7", "Description"},
          {"-5", "Very Hazardous"},
          {"-4", "More Hazardous"},
          {"-3", "Hazardous"},
          {"-2", "Somewhat Hazardous"},
          {"-1", "Slightly Hazardous"},
          {"0", "Safety Neutral"},
          {"+1", "Better Than Some"},
          {"+2", "Better Than Many"},
          {"+3", "Safe To Use"},
          {"+4", "Safer To Use"},
          {"+5", "Very Safe"}
        };
        break;
      }
      case "QREBS-TrueAge - 195": {
        tables = new String[][]{
          {"FLUX", "CURRENT", "ANTIQUE", "ARTIFACT", "SURPLUS", "EXPERIMENTAL"},
          {"-5", "50", "400", "RR", "100", "20"},
          {"-4", "35", "300", "1300", "90", "10"},
          {"-3", "25", "250", "1200", "80", "9"},
          {"-2", "21", "210", "1100", "70", "8"},
          {"-1", "18", "180", "1000", "60", "7"},
          {"0", "15", "150", "900", "50", "6"},
          {"1", "12", "120", "800", "40", "5"},
          {"2", "9", "100", "700", "30", "4"},
          {"3", "6", "80", "600", "20", "3"},
          {"4", "3", "60", "500", "10", "2"},
          {"5", "NEW", "50", "400", "NEW", "1"}
        };
        break;
      }
      case "QREBS-Scenes - 195": {
        tables = new String[][]{
          {"Scene = Flux + Mods"},
          {"Ergonomics", "Ship Ergonomics", "qrEbs"},
          {"Environment", "vs. normal"},
          {"Situation", "Surprise/confusion"},
          {"Scene roll < 0", "Potential failure if qRebs < Flux"},
          {"Warnings for qRebs x 0.5 h"}
        };
        break;
      }
      //</editor-fold>
////////////////////////////////////////////////////////////////////////////////
      default: {
        //<editor-fold defaultstate="collapsed" desc="JOP">
        {
          String s = "125 default for " + cb4tables.getValue();
          System.out.println(s);
        }
        //</editor-fold>
        break;
      }
////////////////////////////////////////////////////////////////////////////////
//      case "": {
//        tables = new String[][]{
//          {cb4tables.getValue().toUpperCase()},
//          {""},
//          {""},
//          {""},
//          {""},
//          {""},
//          {""},
//          {""},
//          {""},
//          {""},
//          {""},
//          {""}
//        };
//        break;
//      }
////////////////////////////////////////////////////////////////////////////////
    }
    ta4tables.setText("");
    len = tables.length;
    for (int i = 0; i < tables.length; i++) {
      for (int j = 0; j < tables[i].length; j++) {
        ta4tables.appendText(tables[i][j]);
        if (j < tables[i].length - 1) {
          ta4tables.appendText(",\t");
        }
      }
      ta4tables.appendText(CRLF);
    }
  }

  @FXML
  private void topage(ActionEvent event) {
    int num = 0;
    try {
      num = Integer.parseInt(txt.getText());
      for (int i = 0; i < cb4tables.getItems().size(); i++) {
        if (cb4tables.getItems().get(i).endsWith("" + num)) {
          cb4tables.setValue(cb4tables.getItems().get(i));
        }
      }
    } catch (Exception e) {

    }
    roll(ae);
  }

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
