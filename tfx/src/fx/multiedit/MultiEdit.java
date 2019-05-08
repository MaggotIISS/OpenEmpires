/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.multiedit;

import dbviewer.globals.GlobalMethods;
import dbviewer.globals.GlobalVariables;
import static dbviewer.globals.GlobalVariables.CSV;
import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables.T5;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import panels.Panel4T5CounterMaker;
import panels.Panel4T5Locator;
import static panels.Panel4T5Locator.stylesheet;
import panels.Panel4T5Squadron;
import panels.Panel4T5Troop;
import panels.Panel4WordGenOld;

/**

 @author Mark Ferguson
 */
public class MultiEdit extends Application implements Initializable {

  //<editor-fold defaultstate="collapsed" desc="STRINGARRAYS">
  public static final String[][] STRINGARRAYS = new String[][]{
    {"Panel4T5ArmorMaker", "67"},
    {"Panel4T5Backup", "68"},
    {"Panel4T5BitSet", "69"},
    {"Panel4T5BitSub", "70"},
    {"Panel4T5CounterMaker",
      "Name", "Wid", "Hgt", "Folder", "LPos", "RPos",
      "L01", "L02", "L03", "L04", "L05",
      "L06", "L07", "L08", "L09", "L10",
      "R01", "R02", "R03", "R04", "R05",
      "R06", "R07", "R08", "R09", "R10"},
    {"Panel4T5D66", "72"},
    {"Panel4T5DB", "73"},
    {"Panel4T5GunMaker", "Min TL", "Type", "Descriptor", "Burden", "Stage",
      "User", "Text"},
    {"Panel4T5Launch", "75"},
    {"Panel4T5Locator", "76"},
    {"Panel4T5Neighbours", "77"},
    {"Panel4T5QREBS", "78"},
    {"Panel4T5Scripting", "79"},
    {"Panel4T5Squadron", "80"},
    {"Panel4T5System", "81"},
    {"Panel4T5System1", "82"},
    {"Panel4T5SystemPic", "83"},
    {"Panel4T5SystemPic1", "84"},
    {"Panel4T5TableView", "85"},
    {"Panel4T5Troop", "86"},
    {"Panel4T5WebData", "87"},
    {"Panel4", "0"},
    {"Panel4Admiral", "1"},
    {"Panel4Admirals", "2"},
    {"Panel4Batch", "3"},
    {"Panel4BitSet", "4"},
    {"Panel4Boxer", "5"},
    {"Panel4Buttons", "6"},
    {"Panel4Calculator", "7"},
    {"Panel4Careers", "8"},
    {"Panel4Catalogue", "9"},
    {"Panel4Chars", "10"},
    {"Panel4ComboButtonListAreas", "11"},
    {"Panel4ComboLabel", "12"},
    {"Panel4ComboSpinner", "13"},
    {"Panel4Conflict", "14"},
    {"Panel4Counter", "15"},
    {"Panel4D66", "16"},
    {"Panel4DBButtons", "17"},
    {"Panel4Dimensions", "18"},
    {"Panel4Document", "19"},
    {"Panel4Fleet", "20"},
    {"Panel4Fleets", "21"},
    {"Panel4FXSwingMain", "22"},
    {"Panel4Grid", "23"},
    {"Panel4Grid3x3", "24"},
    {"Panel4Grid6x6", "25"},
    {"Panel4GridLayer", "26"},
    {"Panel4Hexer", "27"},
    {"Panel4History", "28"},
    {"Panel4Imperium", "29"},
    {"Panel4JFX", "30"},
    {"Panel4Jump", "31"},
    {"Panel4LabelComboButton", "32"},
    {"Panel4ListBox", "33"},
    {"Panel4ListText", "34"},
    {"Panel4ListTextOld", "35"},
    {"Panel4ListTexts", "36"},
    {"Panel4Locator", "37"},
    {"Panel4MassCombat", "38"},
    {"Panel4Mining", "39"},
    {"Panel4Neighbours", "40"},
    {"Panel4Nobles", "41"},
    {"Panel4NPC", "42"},
    {"Panel4NumTypeGroup", "43"},
    {"Panel4PC", "44"},
    {"Panel4Pic", "45"},
    {"Panel4Piece", "46"},
    {"Panel4PieceInfo", "47"},
    {"Panel4Pix", "48"},
    {"Panel4PlanetTable", "49"},
    {"Panel4Properties", "50"},
    {"Panel4Ron", "51"},
    {"Panel4Rotate", "52"},
    {"Panel4Routes", "53"},
    {"Panel4SDB", "54"},
    {"Panel4Ship", "55"},
    {"Panel4ShortRoute", "56"},
    {"Panel4SplitH", "57"},
    {"Panel4SplitMultiTab", "58"},
    {"Panel4SplitTest", "59"},
    {"Panel4SplitV", "60"},
    {"Panel4Squadron", "61"},
    {"Panel4Squadrons", "62"},
    {"Panel4StarGen", "63"},
    {"Panel4StarPic", "64"},
    {"Panel4SubSector", "65"},
    {"Panel4System", "66"},
    {"Panel4Tab", "88"},
    {"Panel4TableViewer", "89"},
    {"Panel4Tabs", "90"},
    {"Panel4Title", "91"},
    {"Panel4TradeCargo", "92"},
    {"Panel4Troop", "93"},
    {"Panel4UMP", "94"},
    {"Panel4UMPs", "95"},
    {"Panel4UTP", "96"},
    {"Panel4UTPs", "97"},
    {"Panel4Word", "98"},
    {"Panel4WordGen", "99"},
    {"Panel4World", "100"},
    {"Panel4Worlds", "101"},
    ////////////////////////////////////////////////////////////////////////////
    {"WHO", "Location ", "ID", "Name", "Race", "Sex", "Age()", "Hex", "System",
      "UPP", "Career", "Terms", "Rank", "DOB", "POB", "PicName"},
    {"WHAT", "Item", "Armour", "Weapon", "Structure", "Vehicle", "Craft", "Ship",
      "Station"},
    {"WHY", "Orders", "Fight", "Shoot", "Drive", "Fly", "Travel"},
    {"WHERE", "Sector", "Subsector", "System", "Star", "Satellite", "Moon",
      "Orbit", "Hex", "Name", "UWP", "SDBs", "Rons", "CF", "Troops", "Pop",
      "Belts", "GGs", "Worlds", "SecFile", "SubFile", "SysFile", "LineFile",
      "DestFile", "RingFile", "OrbitFile", "DestsFile", "StrengthsFile",
      "UWPFile", "BasesFile", "NavyFile", "TroopFile"},
    {"WHEN", "Year", "Week", "Day", "Hour", "Minute", "Second", "Duration"},
    {"WITH", "People", "Places", "Items", "Duration", "Risk", "Note", "Time",
      "Location"},
    {"Location", "Structure", "X", "Y", "Z", "Sealed", "Exits"},
    ////////////////////////////////////////////////////////////////////////////
    {"RACE", "Vilani", "Solomani", "Darrian", "Droyne", "Hiver", "K`Kree",
      "Vargr", "Zhodani", "Major", "Minor"},
    ////////////////////////////////////////////////////////////////////////////
    {"BUSINESS", "MegaCorps", "Corportaion", "Syndication", "System Line"},
    {"GROUPS", "Team", "Crew", "Section", "Department", "Unit", "Division",
      "Brigade", "Battalion", "Company"},
    {"LOCATIONS", "Starport", "Startown", "Station", "Section", "Career",
      "Terms", "UPP", "Notes"},
    {"UWP", "Starport", "Size", "Atmosphere", "Hydrosphere", "Population",
      "Govenment", "Law Level", "Tech Level"},
    {"Crew Structure", "Men Rank", "1/3 1-3 ", "1/2 4", "1/2 5", "1/? 6"},
    {"UPP", "STRENGTH", "DEXTERITY", "ENDURANCE", "INTELLIGENCE", "EDUCATION",
      "SOCIAL STANDING"},
    {"VMACE", "Volume", "Mass", "AI", "Cost", "Environ"},
    {"VOLUME", "Len", "Wid", "Hgt", "%"},
    {"MASS", "Unit", "Num", "Race"},
    {"AI", "AI", "TL"},
    {"COST", "Cr", "KCr", "MCr", "GCr", "TCr", "PCr", "Value"},
    {"ENVIRON", "Breathes", "Sealed", "G"},
    {"CPC", "Crew", "Passengers", "Cargo"},
    {"CREW", "ID", "Position", "Rank", "Controls"},
    {"PASSENGERS", "Race", "Sex", "Age"},
    {"CARGO"},
    ////////////////////////////////////////////////////////////////////////////
    {"Weapon", "VMACE", "Name", "Type", "Skill", "Rounds", "Range"},
    {"Weapon Description", "Model", "Stage", "Burden", "Descriptor", "Type",//T5
      "User", "Portability", "TL"},
    {"Weapon Extension", "Range", "Cost", "Mass", "QREBS", "Effects"},//T5
    {"Space Weapon", "Stage", "Range", "Mount", "Type", "TL", "(C+S)"},//T5
    {"Space Missile", "Stage", "Missile", "Size", "Type", "Guidance"},//T5
    {"Damper ID", "Stage", "Range", "Mount", "Type", "TL", "(C+S)"},//T5
    {"Scrambler ID", "Stage", "Missile", "Size", "Type", "Guidance"},//T5
    {"Globe ID", "Stage", "Missile", "Size", "Type", "Guidance"},//T5
    {"", "", "", "", "", "", ""},
    {"", "", "", "", "", "", ""},
    {"AM Anti Missile Mode Action", "1D", "Size", "Mods", "Guidance"},//T5
    {"Anti Beam & Absolute Mode Action", "1D", "TL", "Mount", "", "", ""},//T5
    {"Space Weapon Task", "nD", "TL", "(C+S)", "(Size-Range)", "Mods"},//T5
    {"Sensor Task", "1D", "Sensor TL", "(C+S)", "(Size-Range)", "Mods"},
    {"", "", "", "", "", "", ""},
    ////////////////////////////////////////////////////////////////////////////
    {"Unpowered Suit", "VMACE"},//T5
    {"Powered Armour", "VMACE"},//T5
    {"Powered Dress", "VMACE"},//T5
    {"Unit/Item"},//T5
    {"Armour Description", "Model", "Stage", "Burden", "Descriptor", "Type",
      "User", "Portability", "TL"},//T5
    {"Armour Extension", "Model", "Cost", "Mass", "QREBs", "Ar", "Ca", "Fl",
      "Ra", "So", "Ps", "In", "Se"},//T5
    ////////////////////////////////////////////////////////////////////////////
    {"Structure", "VMACE", "CPC"},
    ////////////////////////////////////////////////////////////////////////////
    {"Vehicle", "VMACE", "CPC", "G"},
    {"Vehicle Description", "Model", "Bulk", "Motive", "Mission", "Type", "User",
      "TL"},//T5
    {"Vehicle Extension", "Tons", "Speed", "Load", "Stage", "Environ",
      "Endurance", "QREBs", "Options"},//T5
    {"Hit Locations", "2  Comms", "3  Cargo", "4  Sensors", "5  Protections",
      "6  Life Support", "7  Body Panel", "8  Power Source", "9  Locomotion",
      "10 Weaponry", "11 Navigation", "12 Computer"},//T5
    ////////////////////////////////////////////////////////////////////////////
    {"Sensors", "Stage", "Range", "Mount", "Type", "TL", "(C+S)"},//T5
    ////////////////////////////////////////////////////////////////////////////
    {"Craft", "VMACE", "CPC", "G"},
    ////////////////////////////////////////////////////////////////////////////
    {"Ship", "VMACE", "CPC", "G", "J"},
    ////////////////////////////////////////////////////////////////////////////
    {"QSP", "Mission", "Hull", "Config", "G", "J"},//T5
    ////////////////////////////////////////////////////////////////////////////
    {"ACS Starships", "Scout/Courier (S-AL22)", "Free Trader (A-BS11)",
      "Far Trader (A2-BS12)", "Corvette (E-EA53)", "Yacht (Y-EU42)",
      "Frigate (G-FB43)", "Corsair (P-DA42)", "Cruiser (C-VS23)",
      "Lab Ship (L-DC12)"},
    ////////////////////////////////////////////////////////////////////////////
    {"Station", "VMACE", "CPC", "G"},
    ////////////////////////////////////////////////////////////////////////////
    {"Item", "VMACE"},
    ////////////////////////////////////////////////////////////////////////////
    {"Counter", "Title", "ID", "T01", "T02", "T03", "T04", "T05", "T06", "T07",
      "T08", "T09", "T10", "T11", "T12", "T13", "T14", "T15", "T16", "T17",
      "T18", "T19", "T20", "Pics"},
    {"Address", "Name", "Street", "Town", "Postcode", "County", "Country",
      "Planet", "System", "Polity", "Subsector", "Sector", "????"},
    {"Contact", "Name", "ID", "Phone", "email"},
    {"Dice Rolls", "1d6", "2d6", "3d6", "Flux", "Flux+", "Flux-"},
    {"1D6", "1", "2", "3", "4", "5", "6"},
    {"2D6", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"},
    {"3D6", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
      "15", "16", "17", "18"},
    {"Percentages", "10%", "20%", "30%", "40%", "50%", "60%", "70%", "80%",
      "90%", "100%"},
    {"Appearance", "Height", "Weight", "Hair", "Eyes", "Details"},
    {"Frequency", "Common", "Uncommon", "Rare"},
    ////////////////////////////////////////////////////////////////////////////
    {"Skills", "Admin", "Advocate", "Animals", "Athlete", "Broker", "Bureaucrat",
      "Comms", "Computer", "Counsellor", "Designer", "Diplomat", "Driver",
      "Explosives", "Fleet Tactics", "Flyer", "Forensics", "Gambler", "High-G",
      "Hostile Environ", "JOT", "Language", "Leader", "Liaison",
      "Naval Architect", "Seafarer", "Stealth", "Strategy", "Streetwise",
      "Survey", "Survival", "Tactics", "Teacher", "Trader", "Vacc Suit",
      "Zero-G"},//T5
    {"Starship Skills (7)", "Astrogator", "Engineer", "Gunner", "Medic", "Pilot",
      "Sensors", "Steward"},//T5
    {"The Trades (10)", "Biologics", "Craftsman", "Electronics", "Fluidics",
      "Gravitics", "Magnetics", "Mechanic", "Photonics", "Polymers",
      "Programmer"},//T5
    {"The Arts (6)", "Actor", "Artist", "Author", "Chef", "Dancer", "Musician"},
    {"Soldier Skills (6)", "Fighter", "Forward Obs", "Heavy Wpns", "Navigator",//T5
      "Recon", "Sapper"},//T5
    {"Default Skills", "Actor", "Artist", "Athlete", "Author", "Comms",
      "Computer", "Driver", "Fighter", "Turrets", "Mechanic", "Steward",
      "Vacc Suit"},//T5
    {"Talents (16)", "Compute", "Empath", "Hibernate", "Hypno", "Intuition",
      "Math", "MemAware", "Memorize", "MemPercep", "MemScent", "MemSight",
      "MemSound", "Morph", "Rage", "SoundMimic"},//T5
    {"Personals (7)", "Carouse", "Query", "Persuade", "Command", "Curiosity",
      "Insight", "Luck"},//T5
    {"Animals", "Rider", "Teamster", "Trainer"},//T5
    {"Driver", "ACV", "Automotive", "Grav", "Legged", "Mole", "Tracked",
      "Wheeled"},//T5
    {"Engineer", "Jump Drives", "Life Support", "Maneuver Drives",
      "Power Plants"},//T5
    {"Fighter", "Battle Dress", "Beams", "Blades", "Exotics", "Slug Throwers",
      "Sprays", "Unarmed"},//T5
    {"Flyer", "Aeronautics", "Flapper", "Grav", "LTA", "Rotor", "Wing"},//T5
    {"Gunner", "Bay Weapons", "Ortillery", "Screens", "Spines", "Turrets",
      "Heavy Weapons", "Artillery", "Launcher", "Ordnance", "WMD", "Pilot",
      "Small Craft", "Spacecraft ACS", "Spacecraft BCS"},//T5
    {"Seafarer", "Aquanautics", "Grav", "Boat", "Ship", "Sub"},//T5
    {"The Sciences", "Archeology", "Biology", "Chemistry", "History",
      "Linguistics", "Philosophy", "Physics", "Planetology", "Psionicology",
      "Psychohistory", "Psychology", "Robotics", "Sophontology"},//T5
    {"Specialized", "Career: Academia", "Career: Army", "Career: Navy",
      "Career: <Name>", "World: Capital", "World: Regina", "World: <Name>"},//T5
    {"upp", "STR", "DEX", "END", "INT", "EDU", "SOC"},//T5
    {"Starport elements", "Beacon", "Land Pad and Runways", "Sensor Arrays",
      "Traffic Control facilities", "Auxilliary Traffic Control facilities"},//T5
    {"Terminus", "Concourses", "Freight Docks", "Customs & Immigration",
      "The Cargo Market", "Accomodations", "Data Terminals", "Message Center",
      "Emergency Medical"},//T5
    {"Peripheral facilities", "Starport Defence Establishment", "Scout Base",
      "Naval Base", "Consulates", "System Defence Field", "Shipyard",
      "Repair shops", "Transport hub", "Industry"},//T5
    {"Unofficial Facilities", "The Scout Lounge", "The Hiring Hall",
      "The Lone Star", "TAS", "Off-duty crew", "Startown"},//T5
    {"Terrain Type", "Resource", "Mountains", "Chasm", "Precipice", "Ruins",
      "Crater", "Desert", "Ocean", "Shore", "Islands", "Ice caps", "Ice fields",
      "Frozen lands", "Cropland", "Town", "City", "Domed", "Arcology", "Rural",
      "Starport", "Twilight Zone", "Baked Lands", "Penal", "Wasteland", "Exotic",
      "Clear"},//T5
    {"World Map Details", "Starport", "Size", "Atmosphere", "Hydrosphere",
      "Population", "Government", "Law Level", "Tech Level", "TCs", "L", "R",
      "I", "B", "HZ "},//T5
    {"Terrain Symbols",
      "Clear", "Marsh", "Rough", "Woods", "Swamp", "Rough Wood",
      "Mountain", "Desert", "Chasm", "Cropland", "Rural", "Ruins",
      "Ocean", "Islands", "Shore", "River", "Lake", "Ice cap",
      "Baked Lands", "Twilight", "Frozen Lands", "Ice Field", "Precipice",
      "Exotic",
      "City", "Dome", "Arcology", "Suburbs", "Town", "Starport",
      "Highway", "Road", "Trail", "Air Corridor", "Grid", "High Speed",
      "Ocean Depth", "Abyss", "Caverns", "Crater", "Wasteland", "Penal",
      "Volcano", "Estate", "Reserve", "Mine", "Resource", "Oil",
      "Airpad", "Vlite Airstrip", "Lite Airstrip", "Airport", "Heavy Airport",
      "Vheavy Airport",}//T5
  };
  //</editor-fold>

  @FXML
  private Button button;
  @FXML
  private CheckBox checkbox;
  @FXML
  private ComboBox<String> combobox;
  @FXML
  private Label keylabel;
  @FXML
  private Label label;
  @FXML
  private Label openlabel;
  @FXML
  private Label savelabel;
  @FXML
  private TextArea textarea;
  @FXML
  private Label valuelabel;

  @FXML
  private void fillform(MouseEvent event) {
    fillForm(event);
  }

  @FXML
  private void labelClick(MouseEvent event) {
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
    label.setTooltip(new Tooltip("" + viewnum));
    String text = "";
    if (combobox.getValue() != null) {
      switch (viewnum) {
        case 0: {
          text = "camel";
          break;
        }
        case 1: {
          text = "lower";
          break;
        }
        case 2: {
          text = "upper";
          break;
        }
        case 3: {
          text = "csv";
          text = "camelcsv";
          break;
        }
        case 4: {
          text = "lowcsv";
          break;
        }
        case 5: {
          text = "uppcsv";
          break;
        }
        case 6: {
          text = "split";
          break;
        }
        case 7: {
          text = "lowsplit";
          break;
        }
        case 8: {
          text = "uppsplit";
          break;
        }
      }
    }
    showTexts(text);
    viewnum += 1;
    if (viewnum == 9) {
      viewnum = 0;
    }
  }

  @FXML
  private void keyClick(MouseEvent event) {
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
    textarea.setText("");
    for (int i = 0; i < STRINGARRAYS.length; i++) {
      textarea.appendText("" + map.get(i) + CRLF);
    }
  }

  @FXML
  private void valueClick(MouseEvent event) {
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
    textarea.setText("");
    for (int i = 0; i < values.size(); i++) {
      textarea.appendText("" + map.get(i) + CRLF);
    }
  }

  @FXML
  private void checkCheck(ActionEvent event) {
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
    if (combobox.getValue() != null) {
      combobox.setEditable(checkbox.isSelected());
      textarea.setEditable(checkbox.isSelected());
      if (textarea.isEditable()) {
        textarea.setPromptText(
          "Enter filename above and list below\nOr click label to differ output");
      } else {
        textarea.setPromptText(
          "Select list in combobox above\nOr click label to differ output");
      }
    }
  }

  @FXML
  private void checkText(KeyEvent event) {
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

  @FXML
  private void comboClick(MouseEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        s += "event.getClickCount()" + " = " + event.getClickCount() + CRLF;
        s += "" + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
  }

  @FXML
  private void comboaction(ActionEvent event) {
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
//    setCSV();
    comboAction(event);
  }

  @FXML
  private void openlabelClick(MouseEvent event) {
    openClick();
  }

  @FXML
  private void savelabelClick(MouseEvent event) {
    saveClick(event);
  }

  @FXML
  private void buttonClick(ActionEvent event) {
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
    System.out.println("buttonClick");
    map = new HashMap<>();
    String[] lines = textarea.getText().split(CRLF);
    for (int i = 0; i < lines.length; i++) {
      map.put(lines[i], lines[i]);
    }
    keys = map.keySet();
    values = map.values();
    System.out.println("  list.toString()" + " = " + list.toString());
    System.out.println("combobox.getValue()" + " = " + combobox.getValue());
    System.out.println("keys.toString()" + " = " + keys.toString());
    System.out.println("values.toString()" + " = " + values.toString());
    System.out.println("" + " = " + map.entrySet());
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
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
    createList();
    keylabel.setTooltip(new Tooltip("Keys"));
    valuelabel.setTooltip(new Tooltip("Values"));
    openlabel.setTooltip(new Tooltip("Open"));
    savelabel.setTooltip(new Tooltip("Save"));
    checkbox.setTooltip(new Tooltip("Edit Mode"));
    label.setTooltip(new Tooltip("" + viewnum));
    label.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        labelClick(event);
      }

    });
    textarea.setPromptText(
      "Select list in combobox above\nOr click label to differ output");
    checkbox.setSelected(false);
    checkCheck(ae);
    labelClick(me);
    showTexts("camel");
  }

  @Override
  public void start(Stage stage) throws Exception {
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
    Parent root = FXMLLoader.load(getClass().getResource("MultiEdit.fxml"));
    Scene scene = new Scene(root, 300, 800);
    scene.setUserAgentStylesheet(stylesheet);
    this.stage = stage;
    ownerWindow = stage;
    stage.setScene(scene);
    stage.setX(0);
    stage.setY(0);
    stage.show();
    combobox.setValue("Who");
  }

  public String[] groups = new String[STRINGARRAYS.length];
  private double wid, hgt;
  private String CRLF = "\n";
  private FileChooser fileChooser;
  private FileChooser.ExtensionFilter filter;
  private MouseEvent me;
  private final ObservableList<String> list = FXCollections
    .observableArrayList();
  private int viewnum = 8;
  private String[] cases = {"camel", "lower", "upper", "camelcsv", "lowcsv",
    "uppcsv", "split", "lowsplit", "uppsplit"};
  private Stage stage;
  private int group = 0;
  private ActionEvent ae;
  private int[] members = new int[STRINGARRAYS.length];
  private String d = "C:/T5/_CSV/";
  private String f = "Who";
  private String e = ".csv";
  private String split = ": ";
  private File file = new File(d + f + e);
  private String[] parts;
  private String string;
  private Map<String, String> map = new HashMap<>();
  private Set<String> keys;
  private Collection<String> values;
  private Window ownerWindow;
  private TextField[] fields;

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  private void comboAction(ActionEvent event) {
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
    viewnum = 0;
    textarea.setText("");
    String old = combobox.getValue();
    for (int i = 0; i < STRINGARRAYS.length; i++) {
      if (combobox.getValue().toLowerCase().equals(STRINGARRAYS[i][0]
        .toLowerCase())) {
        for (int j = 1; j < STRINGARRAYS[i].length; j++) {
          textarea.appendText(STRINGARRAYS[i][j] + CRLF);
        }
        break;
      }
    }
    button.fire();
    combobox.setValue(old);
//    MouseEvent evt = null;
//    fillform(evt);
  }

  private String showTexts(String string) {
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
      if (combobox.getValue() != null) {
        if (!"".equals(combobox.getValue().toLowerCase())) {
          if (STRINGARRAYS[i][0].toLowerCase().equals(combobox.getValue()
            .toLowerCase())) {
            textarea.setText("");
            String txt = "";
            for (int j = 1; j < STRINGARRAYS[i].length; j++) {
              switch (string) {
                case "camelcase":
                case "camel": {
                  //0
                  txt = STRINGARRAYS[i][j];
                  break;
                }
                case "lowercase":
                case "lower": {
                  //1
                  txt = STRINGARRAYS[i][j].toLowerCase();
                  break;
                }
                case "uppercase":
                case "upper": {
                  //2
                  txt = STRINGARRAYS[i][j].toUpperCase();
                  break;
                }
                case "csv":
                case "camelcsv": {
                  //3
                  txt = "\"" + STRINGARRAYS[i][j] + "\"" + "," + "\"" + ""
                    + "\"";
                  break;
                }
                case "lowcsv": {
                  //4
                  txt = "\"" + STRINGARRAYS[i][j].toLowerCase() + "\"" + ","
                    + "\"" + "" + "\"";
                  break;
                }
                case "uppcsv": {
                  //5
                  txt = "\"" + STRINGARRAYS[i][j].toUpperCase() + "\"" + ","
                    + "\"" + "" + "\"";
                  break;
                }
                case "split": {
                  //6
                  txt = STRINGARRAYS[i][j] + split;
                  break;
                }
                case "lowsplit": {
                  //7
                  txt = STRINGARRAYS[i][j].toLowerCase() + split;
                  break;
                }
                case "uppsplit": {
                  //8
                  txt = STRINGARRAYS[i][j].toUpperCase() + split;
                  break;
                }
              }
              textarea.appendText(txt + CRLF);
              label.setText(string);
            }
            System.out.println("");
          }
        }
      }
    }
    label.setTooltip(new Tooltip("" + viewnum));
    label.setText(string);
    String text = textarea.getText();
    return text;
  }

  private InvalidationListener listener = new InvalidationListener() {
    @Override
    public void invalidated(Observable observable) {
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
      //<editor-fold defaultstate="collapsed" desc="JOP">
      {
        String s = "";
        s += "" + CRLF;
        s += "" + CRLF;
//        JTextArea jta = new JTextArea(s, 50, 80);
//        JScrollPane jsp = new JScrollPane(jta);
//        JOptionPane.showMessageDialog(null, jsp);
      }
      //</editor-fold>
    }
  };

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
    list.clear();
    d = GlobalVariables.CSV + FS;
    f = "LIST";
    e = ".txt";
    groups = new String[STRINGARRAYS.length];
    for (int i = 0; i < STRINGARRAYS.length; i++) {
      groups[i] = STRINGARRAYS[i][0];
      list.add(STRINGARRAYS[i][0]);
    }
    combobox.setItems(list);
    list.addListener(listener);
//    recreateList();
  }

  private void recreateList() {
    list.clear();
    list.removeListener(listener);
    d = GlobalVariables.CSV + FS;
    f = "LIST";
    e = ".csv";

    String line = "";
    String[] lines;
    File file = new File(GlobalVariables.CSV);
    lines = file.list();
    groups = new String[lines.length];
    for (int i = 0; i < lines.length; i++) {
      if (lines[i].endsWith(e)) {
        groups[i] = lines[i];
        list.add(lines[i].substring(0, lines[i].length() - 4));
      }
    }
    combobox.setItems(list);
    list.addListener(listener);
    String text = "";
    for (int i = 0; i < list.size(); i++) {
      text += list.get(i) + CRLF;
    }
    GlobalMethods.saveTextFile(d, f, e, text);
  }

  private void modeClick(MouseEvent event) {
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
    fileChooser = new FileChooser();
    fileChooser.setInitialDirectory(new File(d));
    fileChooser.setInitialFileName(f);
    fileChooser.setTitle("Open Resource File");
    fileChooser.getExtensionFilters().addAll(
      new FileChooser.ExtensionFilter("All Files", "*.*"),
      new FileChooser.ExtensionFilter("Text Files", "*.txt", "*.csv", "*.html",
        "*.t5c", "*"),
      new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
      new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"));
    filter = fileChooser.getExtensionFilters().get(1);
    fileChooser.setSelectedExtensionFilter(filter);
    File fi = fileChooser.showOpenDialog(ownerWindow);
    d = fi.toString().substring(0, fi.toString().lastIndexOf(FS) + 1);
    f = fi.toString().substring(fi.toString().lastIndexOf(FS) + 1, fi
      .toString().lastIndexOf("."));
    e = fi.toString().substring(fi.toString().lastIndexOf("."));
    combobox.setValue(f);
    if (fi.exists()) {
      textarea.setText("");
      String line = GlobalMethods.loadTextFile(d, f, e);
      String[] lines = line.split(CRLF);
      for (int i = 0; i < lines.length; i++) {
        System.out.println("" + " = " + lines[i]);
        textarea.appendText(lines[i] + CRLF);
      }
    }
  }

  private void saveClick(MouseEvent event) {
    if (event.getClickCount() > 1) {
      saveStrings();
    }
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
    if (label.getText().endsWith("csv")) {
      e = ".csv";
    } else {
      e = ".txt";
    }
    f = combobox.getValue();
    GlobalMethods.saveTextFile(d, f, e, textarea.getText());
  }

  private void saveStrings() {
    //<editor-fold defaultstate="collapsed" desc="USEFUL">
    //delete STRINGARRAYS.txt
    //delete CSVs.txt
    //delete TXTs.txt
    f = "";
    String[] names = {"STRINGARRAYS", "CSVs", "TXTs"};
    for (int i = 0; i < names.length; i++) {
      d = CSV;
      f = "" + names[i];
      e = ".txt";
      File file = new File(d + FS + f + e);
      if (file.exists()) {
        file.delete();
      }
    }
////////////////////////////////////////////////////////////////////////////////
    file = new File(CSV);
    String[] files = file.list();
    TextArea taCSV = new TextArea();
    TextArea taTXT = new TextArea();
    textarea.setText("");
    taCSV.setText("");
    taTXT.setText("");
    for (int i = 0; i < files.length; i++) {
      String path = CSV + FS + files[i];
      if (files[i].endsWith(".csv")) {
        System.out.println(files[i]);
        taCSV.appendText(GlobalMethods.comment("/", 80) + CRLF);
//        taCSV.appendText(files[i] + CRLF);
        String string = GlobalMethods.loadTextFile(path);
        taCSV.appendText(string + CRLF);
      } else if (files[i].endsWith(".txt")) {
        taTXT.appendText(GlobalMethods.comment("/", 80) + CRLF);
//        taTXT.appendText(files[i] + CRLF);
        System.out.println(files[i]);
        path = CSV + FS + files[i];
        String string = GlobalMethods.loadTextFile(path);
        taTXT.appendText(string + CRLF);
      }
//      }
    }
    f = "CSVs";
    e = ".txt";
    GlobalMethods.saveTextFile(d, f, e, taCSV.getText());
    textarea.appendText(taCSV.getText());
    //  END
    f = "TXTs";
    e = ".txt";
    GlobalMethods.saveTextFile(d, f, e, taTXT.getText());
    textarea.appendText(taTXT.getText());
    //  END
    //</editor-fold>
////////////////////////////////////////////////////////////////////////////////
    TextArea stringarrays = new TextArea();
    stringarrays = new TextArea();
    //STRINGARRAYS.TXT FOR QUICK ITEM UPDATES!
    for (int i = 0; i < STRINGARRAYS.length; i++) {
      stringarrays.appendText("{");
      for (int j = 0; j < STRINGARRAYS[i].length; j++) {
        stringarrays.appendText("\"" + STRINGARRAYS[i][j] + "\"");
        if (j < STRINGARRAYS[i].length - 1) {
          stringarrays.appendText(",");
        }
      }
      stringarrays.appendText("}");
      if (i < STRINGARRAYS.length - 1) {
        stringarrays.appendText(",");
      }
      stringarrays.appendText(CRLF);
    }
    checkbox.setSelected(true);
    combobox.setValue("STRINGARRAYS");
    File file;
    d = CSV;
    f = combobox.getValue();
    if (label.getText().endsWith("csv")) {
      e = ".csv";
    } else {
      e = ".txt";
    }
    GlobalMethods.saveTextFile(d, f, e, stringarrays.getText());
    textarea.setText(stringarrays.getText());
////////////////////////////////////////////////////////////////////////////////
  }

  public Set<String> getKeys() {
    return keys;
  }

  public void setKeys(Set<String> set) {
    keys = set;
  }

  public Map<String, String> getMap() {
    return map;
  }

  public void setMap(Map<String, String> amap) {
    map = amap;
//    buttonClick(ae);
  }

  public Collection<String> getValues() {
    return values;
  }

  public void setValues(Collection<String> list) {
    values = list;
  }

  private void setCSV() {
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
    while (!label.getText().endsWith("csv")) {
      viewnum += 1;
      labelClick(me);
    }
  }

  private void fillForm(MouseEvent event) {
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
    String[] lines = textarea.getText().split(CRLF);
    HBox hbox = null;
    VBox vbox = null;
    vbox = new VBox();
    fields = new TextField[lines.length];
    for (int i = 0; i < lines.length; i++) {
      hbox = new HBox();
      Label labela;
      if (label.getText().endsWith("csv")) {
        labela = new Label(lines[i].split("\",\"")[0].substring(1));
      } else {
        labela = new Label(lines[i]);
      }
      labela.setPrefWidth(100);
      TextField textfielda = new TextField("");
      textfielda.setId(lines[i]);
      textfielda.setTooltip(new Tooltip(lines[i]));
      textfielda.setPrefWidth(100);
      fields[i] = textfielda;
      ObservableList<String> lista = FXCollections.observableArrayList();
      if (label.getText().endsWith("csv")) {
        lista.add(lines[i].split("\",\"")[0].substring(1));
      } else {
        lista.add(lines[i]);
      }

      ComboBox<String> combo = new ComboBox<>(lista);
      combo.setPrefWidth(100);
      Button buttona = new Button(lines[i]);
      buttona.setPrefWidth(100);
      hbox.getChildren().addAll(labela, textfielda);//, combo);
      vbox.getChildren().add(hbox);
    }
    wid = 325;
    hgt = lines.length * 26;
    ScrollPane scrollPane = new ScrollPane(vbox);
    Stage stageb = new Stage();
    Scene scene = new Scene(scrollPane, wid, hgt);
    stageb.setScene(scene);
    stageb.setTitle(combobox.getValue());
    stageb.initOwner(ownerWindow);
    stageb.show();
    writePanels();
    fillFields(combobox.getValue(), lines);

  }

  private void fillFields(String value, String[] lines) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        s += "value = " + value + CRLF;
        s += "lines.length = " + lines.length + CRLF;
        for (int i = 0; i < lines.length; i++) {
          s += "  lines[" + i + "] = " + lines[i] + CRLF;
        }
        System.out.println(s);
      }

    }
    //</editor-fold>
//    String[] strings = {""};
    String[] keyss = {""};
    String[] valuess = {""};
    String old = combobox.getValue();
    String location = "" + Panel4T5Locator.jcb4Sec.getSelectedItem().toString()
      + FS + Panel4T5Locator.jcb4Sub.getSelectedItem().toString() + FS
      + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + FS
      + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + FS;
    switch (value) {
      //////////////////////////////////////////////////////////////////////////
      //<editor-fold defaultstate="collapsed" desc="default">
      default: {
        System.out.println("  // value" + " = " + value);
        String string = "case \"" + value + "\": {" + CRLF;
        string += "  break;" + CRLF + "}" + CRLF;
        System.out.println(string);
        break;
      }
      //</editor-fold>
      //////////////////////////////////////////////////////////////////////////
      //<editor-fold defaultstate="collapsed" desc="Panel4T5CounterMaker">
      case "Panel4T5CounterMaker": {
        keyss = new String[]{"Name", "Wid", "Hgt", "Folder", "LPos", "RPos",
          "L01", "L02", "L03", "L04", "L05",
          "L06", "L07", "L08", "L09", "L10",
          "R01", "R02", "R03", "R04", "R05",
          "R06", "R07", "R08", "R09", "R10"};
        valuess = new String[keyss.length];
        for (int i = 0; i < valuess.length; i++) {
          valuess[i] = "";
        }
        try {
          valuess[0] = "" + Panel4T5CounterMaker.jLabel13.getText();	// Name
          valuess[1] = "" + Panel4T5CounterMaker.jSpinnerW.getValue();	// Wid
          valuess[2] = "" + Panel4T5CounterMaker.jSpinnerH.getValue();	// Hgt
          valuess[3] = "" + Panel4T5CounterMaker.Folder.getSelectedItem()
            .toString();	// Folder
          valuess[4] = "" + Panel4T5CounterMaker.l4Front.getText();	// LPos
          valuess[5] = "" + Panel4T5CounterMaker.l4Back.getText();	// RPos
          valuess[6] = "" + Panel4T5CounterMaker.t1.getText();	// L01
          valuess[7] = "" + Panel4T5CounterMaker.t2.getText();	// L02
          valuess[8] = "" + Panel4T5CounterMaker.t3.getText();	// L03
          valuess[9] = "" + Panel4T5CounterMaker.t4.getText();	// L04
          valuess[10] = "" + Panel4T5CounterMaker.t5.getText();	// L05
          valuess[11] = "" + Panel4T5CounterMaker.t6.getText();	// L06
          valuess[12] = "" + Panel4T5CounterMaker.t7.getText();	// L07
          valuess[13] = "" + Panel4T5CounterMaker.t8.getText();	// L08
          valuess[14] = "" + Panel4T5CounterMaker.t9.getText();	// L09
          valuess[15] = "" + Panel4T5CounterMaker.t10.getText();	// L10
          valuess[16] = "" + Panel4T5CounterMaker.t11.getText();	// R01
          valuess[17] = "" + Panel4T5CounterMaker.t12.getText();	// R02
          valuess[18] = "" + Panel4T5CounterMaker.t13.getText();	// R03
          valuess[19] = "" + Panel4T5CounterMaker.t14.getText();	// R04
          valuess[20] = "" + Panel4T5CounterMaker.t15.getText();	// R05
          valuess[21] = "" + Panel4T5CounterMaker.t16.getText();	// R06
          valuess[22] = "" + Panel4T5CounterMaker.t17.getText();	// R07
          valuess[23] = "" + Panel4T5CounterMaker.t18.getText();	// R08
          valuess[24] = "" + Panel4T5CounterMaker.t19.getText();	// R09
          valuess[25] = "" + Panel4T5CounterMaker.t20.getText();	// R10
        } catch (Exception e) {
          for (int i = 0; i < valuess.length; i++) {
            valuess[i] = "???";
          }
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5GunMaker">
      case "Panel4T5GunMaker": {
        keyss = new String[]{"Panel4T5GunMaker", "Min TL", "Type", "Descriptor",
          "Burden", "Stage", "User", "Text"};
        valuess = new String[keyss.length];
        for (int i = 0; i < valuess.length; i++) {
          valuess[i] = "";
        }
        try {
          valuess[0] = "" + panels.Panel4T5GunMaker.TL.getText();	//Min TL
          valuess[1] = "" + panels.Panel4T5GunMaker.Type.getSelectedItem()
            .toString();	//Type
          valuess[2] = "" + panels.Panel4T5GunMaker.Descriptor.getSelectedItem()
            .toString();	//Descriptor
          valuess[3] = "" + panels.Panel4T5GunMaker.Burden.getSelectedItem()
            .toString();	//Burden
          valuess[4] = "" + panels.Panel4T5GunMaker.Stage.getSelectedItem()
            .toString();	//Stage
          valuess[5] = "" + panels.Panel4T5GunMaker.User.getSelectedItem()
            .toString();	//User
          valuess[6] = "" + panels.Panel4T5GunMaker.jta.getText();	//TextFile
        } catch (Exception e) {
          for (int i = 0; i < valuess.length; i++) {
            valuess[i] = "???";
          }
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="WHO">
      case "WHO": {
        keyss = new String[]{"Location ", "ID", "Name", "Race", "Sex",
          "Age()", "Hex", "System", "UPP", "Career", "Terms", "Rank", "DOB",
          "POB", "PicName"};
        valuess = new String[keyss.length];
        for (int i = 0; i < valuess.length; i++) {
          valuess[i] = "";
        }
        try {
          valuess[0] = "" + Panel4T5Locator.jcb4Sec.getSelectedItem().toString()
            .trim() + "/";	//Location
          valuess[0] += Panel4T5Locator.jcb4Sub.getSelectedItem().toString()
            .trim() + "/";	//Location
          valuess[0] += Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
            .trim() + "/";	//Location
          valuess[1] = "";	//ID
          valuess[2] = "" + Panel4T5Locator.jtf4Word.getText();	//Name
          valuess[3] = "" + Panel4T5Locator.jcb4Lang.getSelectedItem()
            .toString().trim();	//Race
          valuess[4] = "" + Panel4T5Locator.Sex.getToolTipText();	//Sex
          int terms = (int) Panel4T5Locator.js4Terms.getValue();
          int age = 18 + (4 * terms);
          String mid = "";
          if (terms > 4) {
            mid = "" + (terms - 4);
          }
          String loss = "(" + mid + ")";
          valuess[5] = "" + age + loss;	//Age()
          valuess[6] = "" + Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
            .substring(0, 4);	//Hex
          valuess[7] = "" + Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
            .substring(5);	//System
          valuess[8] = "" + Panel4T5Locator.jtf4UPP.getText();	//UPP
          valuess[9] = "" + Panel4T5Locator.jcb4Career.getSelectedItem()
            .toString();	//Career
          valuess[10] = "" + Panel4T5Locator.js4Terms.getValue();	//Terms
          valuess[11] = "";	//Rank
          valuess[12] = "";	//DOB
          valuess[13] = "";	//POB
          valuess[14] = "" + Panel4T5CounterMaker.jLabel13.getText();	//PicName
        } catch (Exception e) {
          for (int i = 0; i < valuess.length; i++) {
            valuess[i] = "???";
          }
        }
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="WHERE">
      case "WHERE": {
        keyss = new String[]{"Sector", "Subsector", "System", "Star",
          "Satellite", "Moon", "Orbit", "Hex", "Name", "UWP", "SDBs", "Rons",
          "CF", "Troops", "Pop", "Belts", "GGs", "Worlds", "SecInfo", "SubInfo",
          "SysInfo", "LineInfo", "DestInfo", "RingInfo", "OrbitInfo",
          "DestsInfo", "StrengthsInfo", "UWPInfo", "BasesInfo", "NavyInfo",
          "TroopInfo"};
        valuess = new String[keyss.length];
        for (int i = 0; i < valuess.length; i++) {
          valuess[i] = "";
        }
        try {
          valuess[0] = "" + Panel4T5Locator.jcb4Sec.getSelectedItem().toString()
            .trim();	//Sector
          valuess[1] = "" + Panel4T5Locator.jcb4Sub.getSelectedItem().toString()
            .trim();	//Subsector
          valuess[2] = "" + Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
            .trim();	//System
          valuess[3] = "" + Panel4T5Locator.jcb4Star.getSelectedItem()
            .toString().trim();	//Star
          valuess[4] = "";	//Satellite
          valuess[5] = "";	//Moon
          valuess[6] = "";	//Orbit
          valuess[7] = "" + Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
            .substring(0, 4).trim();	//Hex
          valuess[8] = "" + Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
            .substring(5).trim();	//Name
          valuess[9] = "" + Panel4T5Locator.jtf4UWP.getText();	//UWP
          valuess[10] = "" + Panel4T5Locator.sdbs1.getText();	//SDBs
          valuess[11] = "" + Panel4T5Locator.squadrons.getText();	//Rons

          valuess[12] = "" + Panel4T5Locator.defbats.getText();	//CF
          valuess[13] = "" + Panel4T5Locator.troopunits.getText();	//Troops
          valuess[14] = "" + Panel4T5Locator.jLabel8.getText();	//Pop
          valuess[15] = "" + Panel4T5Locator.jLabel9.getText();	//Belts
          valuess[16] = "" + Panel4T5Locator.jLabel10.getText();	//GGs
          valuess[17] = "" + Panel4T5Locator.jLabel12.getText();	//Worlds

          String d = T5 + FS + location;
          String f = "jta4Sec";
          String e = ".txt";
          System.out.println(d + f + e);
          String pre = Panel4T5Locator.jcb4All.getSelectedItem().toString();

          Panel4T5Locator.jcb4All.setSelectedItem("jta4Sec");
          f = Panel4T5Locator.jcb4All.getSelectedItem().toString();
          valuess[18] = "" + f;	//SecText
          GlobalMethods.saveTextFile(d, f, e, Panel4T5Locator.jta4All.getText());

          Panel4T5Locator.jcb4All.setSelectedItem("jta4Sub");
          f = Panel4T5Locator.jcb4All.getSelectedItem().toString();
          valuess[19] = "" + f;	//SubText
          GlobalMethods.saveTextFile(d, f, e, Panel4T5Locator.jta4All.getText());

          Panel4T5Locator.jcb4All.setSelectedItem("jta4Sys");
          f = Panel4T5Locator.jcb4All.getSelectedItem().toString();
          valuess[20] = "" + f;	//SysText
          GlobalMethods.saveTextFile(d, f, e, Panel4T5Locator.jta4All.getText());

          Panel4T5Locator.jcb4All.setSelectedItem("jta4Line");
          f = Panel4T5Locator.jcb4All.getSelectedItem().toString();
          valuess[21] = "" + f;	//LineText
          GlobalMethods.saveTextFile(d, f, e, Panel4T5Locator.jta4All.getText());

          Panel4T5Locator.jcb4All.setSelectedItem("jta4Info");
          f = Panel4T5Locator.jcb4All.getSelectedItem().toString();
          valuess[22] = "" + f;	//DestText
          GlobalMethods.saveTextFile(d, f, e, Panel4T5Locator.jta4All.getText());

          Panel4T5Locator.jcb4All.setSelectedItem("jta4Near");
          f = Panel4T5Locator.jcb4All.getSelectedItem().toString();
          valuess[23] = "" + f;	//RingText
          GlobalMethods.saveTextFile(d, f, e, Panel4T5Locator.jta4All.getText());

          Panel4T5Locator.jcb4All.setSelectedItem("jta4Orb");
          f = Panel4T5Locator.jcb4All.getSelectedItem().toString();
          valuess[24] = "" + f;	//OrbitText
          GlobalMethods.saveTextFile(d, f, e, Panel4T5Locator.jta4All.getText());

          Panel4T5Locator.jcb4All.setSelectedItem("jta4Dest");
          f = Panel4T5Locator.jcb4All.getSelectedItem().toString();
          valuess[25] = "" + f;	//DestsText
          GlobalMethods.saveTextFile(d, f, e, Panel4T5Locator.jta4All.getText());

          Panel4T5Locator.jcb4All.setSelectedItem("jta4Str");
          f = Panel4T5Locator.jcb4All.getSelectedItem().toString();
          valuess[26] = "" + f;	//StrengthsText
          GlobalMethods.saveTextFile(d, f, e, Panel4T5Locator.jta4All.getText());

          Panel4T5Locator.jcb4All.setSelectedItem("jta4UWP");
          f = Panel4T5Locator.jcb4All.getSelectedItem().toString();
          valuess[27] = "" + f;	//UWPText
          GlobalMethods.saveTextFile(d, f, e, Panel4T5Locator.jta4All.getText());

          Panel4T5Locator.jcb4All.setSelectedItem("jta4Bases");
          f = Panel4T5Locator.jcb4All.getSelectedItem().toString();
          valuess[28] = "" + f;	//BasesText
          GlobalMethods.saveTextFile(d, f, e, Panel4T5Locator.jta4All.getText());

          f = "USqP";
          valuess[29] = "" + f;
          GlobalMethods.saveTextFile(d, f, e, Panel4T5Squadron.rons.getText());

          f = "UTP";
          valuess[30] = "" + f;
          GlobalMethods
            .saveTextFile(d, f, e, Panel4T5Troop.jTextArea1.getText());

          Panel4T5Locator.jcb4All.setSelectedItem(pre);
        } catch (Exception e) {
          for (int i = 0; i < valuess.length; i++) {
            valuess[i] = "???";
          }
        }
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="WHEN">
      case "WHEN": {
        keyss = new String[]{"Year", "Week", "Day", "Hour", "Minute", "Second",
          "Duration"};
        valuess = new String[keyss.length];
        for (int i = 0; i < valuess.length; i++) {
          valuess[i] = "";
        }
        try {
          valuess[0] = "" + fx.t5.T5Controller.getYear();  //Year
          valuess[1] = "" + fx.t5.T5Controller.getWeek();	//Week
          valuess[2] = "" + fx.t5.T5Controller.getDay();	//Day
          valuess[3] = "" + fx.t5.T5Controller.getHour();	//Hour
          valuess[4] = "" + fx.t5.T5Controller.getMinute();	//Minute
          valuess[5] = "" + fx.t5.T5Controller.getSecond();	//Second
          valuess[6] = "" + fx.t5.T5Controller.getDuration();	//Duration
        } catch (Exception e) {
          for (int i = 0; i < valuess.length; i++) {
            valuess[i] = "???";
          }
        }
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="RACE">
      case "RACE": {
        keyss = new String[]{"Vilani", "Solomani", "Darrian", "Droyne", "Hiver",
          "K`Kree", "Vargr", "Zhodani", "Major", "Minor"};
        valuess = new String[keyss.length];
        java.awt.event.MouseEvent evt = null;
        for (int i = 0; i < valuess.length; i++) {
          valuess[i] = "";
        }
        try {
          String s = "";
          valuess[0] = "" + Panel4WordGenOld.getWord(evt, "Vilani", s);	//Vilani
          valuess[1] = "";// + Panel4WordGenOld.getWord(evt, "Solomani", s);	//Solomani
          valuess[2] = "";// + Panel4WordGenOld.getWord(evt, "Darrian", s);	//Darrian
          valuess[3] = "" + Panel4WordGenOld.getWord(evt, "Droyne", s);	//Droyne
          valuess[4] = "" + Panel4WordGenOld.getWord(evt, "Hiver", s);	//Hiver
          valuess[5] = "" + Panel4WordGenOld.getWord(evt, "K`Kree", s);	//K`Kree
          valuess[6] = "" + Panel4WordGenOld.getWord(evt, "Vargr", s);	//Vargr
          valuess[7] = "" + Panel4WordGenOld.getWord(evt, "Zhodani", s);	//Zhodani
          valuess[8] = "";// + Panel4WordGenOld.getWord(evt, "Major", s);	//Major
          valuess[9] = "";// + Panel4WordGenOld.getWord(evt, "Minor", s);	//Minor
        } catch (Exception e) {
          for (int i = 0; i < valuess.length; i++) {
            valuess[i] = "???";
          }
        }
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="UWP">
      case "UWP": {
        keyss = new String[]{"Starport", "Size", "Atmosphere", "Hydrosphere",
          "Population", "Government", "Law Level", "Tech Level"};
        valuess = new String[keyss.length];
        for (int i = 0; i < valuess.length; i++) {
          valuess[i] = "";
        }
        try {
          valuess[0] = "" + Panel4T5Locator.jtf4UWP.getText().substring(0, 1);	//Starport
          valuess[1] = "" + Panel4T5Locator.jtf4UWP.getText().substring(1, 2);	//Size
          valuess[2] = "" + Panel4T5Locator.jtf4UWP.getText().substring(2, 3);	//Atmosphere
          valuess[3] = "" + Panel4T5Locator.jtf4UWP.getText().substring(3, 4);	//Hydrosphere
          valuess[4] = "" + Panel4T5Locator.jtf4UWP.getText().substring(4, 5);	//Population
          valuess[5] = "" + Panel4T5Locator.jtf4UWP.getText().substring(5, 6);	//Government
          valuess[6] = "" + Panel4T5Locator.jtf4UWP.getText().substring(6, 7);	//Law Level
          valuess[7] = "" + Panel4T5Locator.jtf4UWP.getText().substring(8);	//Tech Level
        } catch (Exception e) {
          for (int i = 0; i < valuess.length; i++) {
            valuess[i] = "???";
          }
        }
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="UPP">
      case "UPP": {
        keyss = new String[]{"STRENGTH", "DEXTERITY", "ENDURANCE",
          "INTELLIGENCE", "EDUCATION", "SOCIAL STANDING"};
        valuess = new String[keyss.length];
        for (int i = 0; i < valuess.length; i++) {
          valuess[i] = "";
        }
        try {
          valuess[0] = "" + Panel4T5Locator.jtf4UPP.getText().substring(0, 1);	//STR
          valuess[1] = "" + Panel4T5Locator.jtf4UPP.getText().substring(1, 2);	//DEX
          valuess[2] = "" + Panel4T5Locator.jtf4UPP.getText().substring(2, 3);	//END
          valuess[3] = "" + Panel4T5Locator.jtf4UPP.getText().substring(3, 4);	//INT
          valuess[4] = "" + Panel4T5Locator.jtf4UPP.getText().substring(4, 5);	//EDU
          valuess[5] = "" + Panel4T5Locator.jtf4UPP.getText().substring(5);	//SOC
        } catch (Exception e) {
          for (int i = 0; i < valuess.length; i++) {
            valuess[i] = "";
          }
        }
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="upp">
      case "upp": {
        keyss = new String[]{"STR", "DEX", "END", "INT", "EDU", "SOC"};
        valuess = new String[keyss.length];
        for (int i = 0; i < valuess.length; i++) {
          valuess[i] = "";
        }
        try {
          valuess[0] = "" + Panel4T5Locator.jtf4UPP.getText().substring(0, 1);	//STR
          valuess[1] = "" + Panel4T5Locator.jtf4UPP.getText().substring(1, 2);	//DEX
          valuess[2] = "" + Panel4T5Locator.jtf4UPP.getText().substring(2, 3);	//END
          valuess[3] = "" + Panel4T5Locator.jtf4UPP.getText().substring(3, 4);	//INT
          valuess[4] = "" + Panel4T5Locator.jtf4UPP.getText().substring(4, 5);	//EDU
          valuess[5] = "" + Panel4T5Locator.jtf4UPP.getText().substring(5);	//SOC
        } catch (Exception e) {
          for (int i = 0; i < valuess.length; i++) {
            valuess[i] = "???";
          }
        }
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="COST">
      case "COST": {
        keyss = new String[]{"Cr", "KCr", "MCr", "GCr", "TCr", "PCr"};
        valuess = new String[keyss.length];
        for (int i = 0; i < valuess.length; i++) {
          valuess[i] = "";
        }
        try {
          valuess[0] = "";	//Cr
          valuess[1] = "";	//KCr
          valuess[2] = "";	//MCr
          valuess[3] = "";	//GCr
          valuess[4] = "";	//TCr
//          valuess[5] = "";	//PCr
        } catch (Exception e) {
          for (int i = 0; i < valuess.length; i++) {
            valuess[i] = "???";
          }
        }
        break;
      }
      //</editor-fold>
      //////////////////////////////////////////////////////////////////////////
      //<editor-fold defaultstate="collapsed" desc="generated by code BELOW">
      //<editor-fold defaultstate="collapsed" desc="Panel4T5ArmorMaker">
      case "Panel4T5ArmorMaker": {
        keyss = new String[]{"67"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//67
        try {
          valuess[0] = "";	//67
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//67
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5Backup">
      case "Panel4T5Backup": {
        keyss = new String[]{"68"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//68
        try {
          valuess[0] = "";	//68
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//68
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5BitSet">
      case "Panel4T5BitSet": {
        keyss = new String[]{"69"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//69
        try {
          valuess[0] = "";	//69
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//69
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5BitSub">
      case "Panel4T5BitSub": {
        keyss = new String[]{"70"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//70
        try {
          valuess[0] = "";	//70
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//70
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5D66">
      case "Panel4T5D66": {
        keyss = new String[]{"72"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//72
        try {
          valuess[0] = "";	//72
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//72
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5DB">
      case "Panel4T5DB": {
        keyss = new String[]{"73"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//73
        try {
          valuess[0] = "";	//73
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//73
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5Launch">
      case "Panel4T5Launch": {
        keyss = new String[]{"75"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//75
        try {
          valuess[0] = "";	//75
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//75
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5Locator">
      case "Panel4T5Locator": {
        keyss = new String[]{"76"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//76
        try {
          valuess[0] = "";	//76
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//76
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5Neighbours">
      case "Panel4T5Neighbours": {
        keyss = new String[]{"77"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//77
        try {
          valuess[0] = "";	//77
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//77
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5QREBS">
      case "Panel4T5QREBS": {
        keyss = new String[]{"78"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//78
        try {
          valuess[0] = "";	//78
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//78
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5Scripting">
      case "Panel4T5Scripting": {
        keyss = new String[]{"79"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//79
        try {
          valuess[0] = "";	//79
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//79
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5Squadron">
      case "Panel4T5Squadron": {
        keyss = new String[]{"80"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//80
        try {
          valuess[0] = "";	//80
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//80
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5System">
      case "Panel4T5System": {
        keyss = new String[]{"81"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//81
        try {
          valuess[0] = "";	//81
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//81
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5System1">
      case "Panel4T5System1": {
        keyss = new String[]{"82"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//82
        try {
          valuess[0] = "";	//82
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//82
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5SystemPic">
      case "Panel4T5SystemPic": {
        keyss = new String[]{"83"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//83
        try {
          valuess[0] = "";	//83
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//83
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5SystemPic1">
      case "Panel4T5SystemPic1": {
        keyss = new String[]{"84"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//84
        try {
          valuess[0] = "";	//84
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//84
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5TableView">
      case "Panel4T5TableView": {
        keyss = new String[]{"85"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//85
        try {
          valuess[0] = "";	//85
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//85
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5Troop">
      case "Panel4T5Troop": {
        keyss = new String[]{"86"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//86
        try {
          valuess[0] = "";	//86
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//86
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4T5WebData">
      case "Panel4T5WebData": {
        keyss = new String[]{"87"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//87
        try {
          valuess[0] = "";	//87
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//87
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4">
      case "Panel4": {
        keyss = new String[]{"0"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//0
        try {
          valuess[0] = "";	//0
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//0
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Admiral">
      case "Panel4Admiral": {
        keyss = new String[]{"1"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//1
        try {
          valuess[0] = "";	//1
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//1
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Admirals">
      case "Panel4Admirals": {
        keyss = new String[]{"2"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//2
        try {
          valuess[0] = "";	//2
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//2
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Batch">
      case "Panel4Batch": {
        keyss = new String[]{"3"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//3
        try {
          valuess[0] = "";	//3
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//3
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4BitSet">
      case "Panel4BitSet": {
        keyss = new String[]{"4"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//4
        try {
          valuess[0] = "";	//4
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//4
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Boxer">
      case "Panel4Boxer": {
        keyss = new String[]{"5"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//5
        try {
          valuess[0] = "";	//5
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//5
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Buttons">
      case "Panel4Buttons": {
        keyss = new String[]{"6"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//6
        try {
          valuess[0] = "";	//6
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//6
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Calculator">
      case "Panel4Calculator": {
        keyss = new String[]{"7"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//7
        try {
          valuess[0] = "";	//7
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//7
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Careers">
      case "Panel4Careers": {
        keyss = new String[]{"8"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//8
        try {
          valuess[0] = "";	//8
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//8
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Catalogue">
      case "Panel4Catalogue": {
        keyss = new String[]{"9"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//9
        try {
          valuess[0] = "";	//9
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//9
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Chars">
      case "Panel4Chars": {
        keyss = new String[]{"10"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//10
        try {
          valuess[0] = "";	//10
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//10
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4ComboButtonListAreas">
      case "Panel4ComboButtonListAreas": {
        keyss = new String[]{"11"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//11
        try {
          valuess[0] = "";	//11
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//11
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4ComboLabel">
      case "Panel4ComboLabel": {
        keyss = new String[]{"12"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//12
        try {
          valuess[0] = "";	//12
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//12
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4ComboSpinner">
      case "Panel4ComboSpinner": {
        keyss = new String[]{"13"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//13
        try {
          valuess[0] = "";	//13
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//13
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Conflict">
      case "Panel4Conflict": {
        keyss = new String[]{"14"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//14
        try {
          valuess[0] = "";	//14
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//14
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Counter">
      case "Panel4Counter": {
        keyss = new String[]{"15"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//15
        try {
          valuess[0] = "";	//15
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//15
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4D66">
      case "Panel4D66": {
        keyss = new String[]{"16"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//16
        try {
          valuess[0] = "";	//16
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//16
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4DBButtons">
      case "Panel4DBButtons": {
        keyss = new String[]{"17"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//17
        try {
          valuess[0] = "";	//17
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//17
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Dimensions">
      case "Panel4Dimensions": {
        keyss = new String[]{"18"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//18
        try {
          valuess[0] = "";	//18
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//18
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Document">
      case "Panel4Document": {
        keyss = new String[]{"19"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//19
        try {
          valuess[0] = "";	//19
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//19
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Fleet">
      case "Panel4Fleet": {
        keyss = new String[]{"20"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//20
        try {
          valuess[0] = "";	//20
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//20
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Fleets">
      case "Panel4Fleets": {
        keyss = new String[]{"21"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//21
        try {
          valuess[0] = "";	//21
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//21
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4FXSwingMain">
      case "Panel4FXSwingMain": {
        keyss = new String[]{"22"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//22
        try {
          valuess[0] = "";	//22
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//22
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Grid">
      case "Panel4Grid": {
        keyss = new String[]{"23"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//23
        try {
          valuess[0] = "";	//23
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//23
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Grid3x3">
      case "Panel4Grid3x3": {
        keyss = new String[]{"24"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//24
        try {
          valuess[0] = "";	//24
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//24
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Grid6x6">
      case "Panel4Grid6x6": {
        keyss = new String[]{"25"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//25
        try {
          valuess[0] = "";	//25
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//25
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4GridLayer">
      case "Panel4GridLayer": {
        keyss = new String[]{"26"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//26
        try {
          valuess[0] = "";	//26
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//26
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Hexer">
      case "Panel4Hexer": {
        keyss = new String[]{"27"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//27
        try {
          valuess[0] = "";	//27
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//27
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4History">
      case "Panel4History": {
        keyss = new String[]{"28"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//28
        try {
          valuess[0] = "";	//28
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//28
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Imperium">
      case "Panel4Imperium": {
        keyss = new String[]{"29"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//29
        try {
          valuess[0] = "";	//29
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//29
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4JFX">
      case "Panel4JFX": {
        keyss = new String[]{"30"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//30
        try {
          valuess[0] = "";	//30
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//30
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Jump">
      case "Panel4Jump": {
        keyss = new String[]{"31"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//31
        try {
          valuess[0] = "";	//31
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//31
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4LabelComboButton">
      case "Panel4LabelComboButton": {
        keyss = new String[]{"32"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//32
        try {
          valuess[0] = "";	//32
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//32
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4ListBox">
      case "Panel4ListBox": {
        keyss = new String[]{"33"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//33
        try {
          valuess[0] = "";	//33
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//33
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4ListText">
      case "Panel4ListText": {
        keyss = new String[]{"34"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//34
        try {
          valuess[0] = "";	//34
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//34
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4ListTextOld">
      case "Panel4ListTextOld": {
        keyss = new String[]{"35"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//35
        try {
          valuess[0] = "";	//35
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//35
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4ListTexts">
      case "Panel4ListTexts": {
        keyss = new String[]{"36"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//36
        try {
          valuess[0] = "";	//36
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//36
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Locator">
      case "Panel4Locator": {
        keyss = new String[]{"37"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//37
        try {
          valuess[0] = "";	//37
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//37
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4MassCombat">
      case "Panel4MassCombat": {
        keyss = new String[]{"38"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//38
        try {
          valuess[0] = "";	//38
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//38
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Mining">
      case "Panel4Mining": {
        keyss = new String[]{"39"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//39
        try {
          valuess[0] = "";	//39
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//39
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Neighbours">
      case "Panel4Neighbours": {
        keyss = new String[]{"40"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//40
        try {
          valuess[0] = "";	//40
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//40
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Nobles">
      case "Panel4Nobles": {
        keyss = new String[]{"41"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//41
        try {
          valuess[0] = "";	//41
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//41
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4NPC">
      case "Panel4NPC": {
        keyss = new String[]{"42"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//42
        try {
          valuess[0] = "";	//42
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//42
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4NumTypeGroup">
      case "Panel4NumTypeGroup": {
        keyss = new String[]{"43"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//43
        try {
          valuess[0] = "";	//43
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//43
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4PC">
      case "Panel4PC": {
        keyss = new String[]{"44"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//44
        try {
          valuess[0] = "";	//44
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//44
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Pic">
      case "Panel4Pic": {
        keyss = new String[]{"45"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//45
        try {
          valuess[0] = "";	//45
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//45
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Piece">
      case "Panel4Piece": {
        keyss = new String[]{"46"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//46
        try {
          valuess[0] = "";	//46
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//46
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4PieceInfo">
      case "Panel4PieceInfo": {
        keyss = new String[]{"47"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//47
        try {
          valuess[0] = "";	//47
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//47
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Pix">
      case "Panel4Pix": {
        keyss = new String[]{"48"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//48
        try {
          valuess[0] = "";	//48
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//48
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4PlanetTable">
      case "Panel4PlanetTable": {
        keyss = new String[]{"49"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//49
        try {
          valuess[0] = "";	//49
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//49
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Properties">
      case "Panel4Properties": {
        keyss = new String[]{"50"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//50
        try {
          valuess[0] = "";	//50
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//50
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Ron">
      case "Panel4Ron": {
        keyss = new String[]{"51"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//51
        try {
          valuess[0] = "";	//51
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//51
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Rotate">
      case "Panel4Rotate": {
        keyss = new String[]{"52"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//52
        try {
          valuess[0] = "";	//52
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//52
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Routes">
      case "Panel4Routes": {
        keyss = new String[]{"53"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//53
        try {
          valuess[0] = "";	//53
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//53
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4SDB">
      case "Panel4SDB": {
        keyss = new String[]{"54"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//54
        try {
          valuess[0] = "";	//54
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//54
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Ship">
      case "Panel4Ship": {
        keyss = new String[]{"55"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//55
        try {
          valuess[0] = "";	//55
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//55
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4ShortRoute">
      case "Panel4ShortRoute": {
        keyss = new String[]{"56"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//56
        try {
          valuess[0] = "";	//56
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//56
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4SplitH">
      case "Panel4SplitH": {
        keyss = new String[]{"57"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//57
        try {
          valuess[0] = "";	//57
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//57
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4SplitMultiTab">
      case "Panel4SplitMultiTab": {
        keyss = new String[]{"58"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//58
        try {
          valuess[0] = "";	//58
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//58
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4SplitTest">
      case "Panel4SplitTest": {
        keyss = new String[]{"59"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//59
        try {
          valuess[0] = "";	//59
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//59
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4SplitV">
      case "Panel4SplitV": {
        keyss = new String[]{"60"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//60
        try {
          valuess[0] = "";	//60
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//60
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Squadron">
      case "Panel4Squadron": {
        keyss = new String[]{"61"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//61
        try {
          valuess[0] = "";	//61
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//61
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Squadrons">
      case "Panel4Squadrons": {
        keyss = new String[]{"62"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//62
        try {
          valuess[0] = "";	//62
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//62
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4StarGen">
      case "Panel4StarGen": {
        keyss = new String[]{"63"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//63
        try {
          valuess[0] = "";	//63
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//63
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4StarPic">
      case "Panel4StarPic": {
        keyss = new String[]{"64"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//64
        try {
          valuess[0] = "";	//64
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//64
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4SubSector">
      case "Panel4SubSector": {
        keyss = new String[]{"65"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//65
        try {
          valuess[0] = "";	//65
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//65
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4System">
      case "Panel4System": {
        keyss = new String[]{"66"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//66
        try {
          valuess[0] = "";	//66
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//66
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Tab">
      case "Panel4Tab": {
        keyss = new String[]{"88"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//88
        try {
          valuess[0] = "";	//88
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//88
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4TableViewer">
      case "Panel4TableViewer": {
        keyss = new String[]{"89"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//89
        try {
          valuess[0] = "";	//89
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//89
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Tabs">
      case "Panel4Tabs": {
        keyss = new String[]{"90"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//90
        try {
          valuess[0] = "";	//90
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//90
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Title">
      case "Panel4Title": {
        keyss = new String[]{"91"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//91
        try {
          valuess[0] = "";	//91
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//91
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4TradeCargo">
      case "Panel4TradeCargo": {
        keyss = new String[]{"92"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//92
        try {
          valuess[0] = "";	//92
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//92
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Troop">
      case "Panel4Troop": {
        keyss = new String[]{"93"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//93
        try {
          valuess[0] = "";	//93
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//93
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4UMP">
      case "Panel4UMP": {
        keyss = new String[]{"94"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//94
        try {
          valuess[0] = "";	//94
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//94
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4UMPs">
      case "Panel4UMPs": {
        keyss = new String[]{"95"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//95
        try {
          valuess[0] = "";	//95
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//95
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4UTP">
      case "Panel4UTP": {
        keyss = new String[]{"96"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//96
        try {
          valuess[0] = "";	//96
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//96
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4UTPs">
      case "Panel4UTPs": {
        keyss = new String[]{"97"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//97
        try {
          valuess[0] = "";	//97
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//97
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Word">
      case "Panel4Word": {
        keyss = new String[]{"98"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//98
        try {
          valuess[0] = "";	//98
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//98
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4WordGenOld">
      case "Panel4WordGen": {
        keyss = new String[]{"99"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//99
        try {
          valuess[0] = "";	//99
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//99
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4World">
      case "Panel4World": {
        keyss = new String[]{"100"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//100
        try {
          valuess[0] = "";	//100
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//100
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Panel4Worlds">
      case "Panel4Worlds": {
        keyss = new String[]{"101"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//101
        try {
          valuess[0] = "";	//101
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//101
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="WHAT">
      case "WHAT": {
        keyss = new String[]{"Item", "Armour", "Weapon", "Structure", "Vehicle",
          "Craft", "Ship", "Station"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Item
        valuess[1] = "";	//Armour
        valuess[2] = "";	//Weapon
        valuess[3] = "";	//Structure
        valuess[4] = "";	//Vehicle
        valuess[5] = "";	//Craft
        valuess[6] = "";	//Ship
        valuess[7] = "";	//Station
        try {
          valuess[0] = "";	//Item
          valuess[1] = "";	//Armour
          valuess[2] = "";	//Weapon
          valuess[3] = "";	//Structure
          valuess[4] = "";	//Vehicle
          valuess[5] = "";	//Craft
          valuess[6] = "";	//Ship
          valuess[7] = "";	//Station
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Item
          valuess[1] = "???";	//Armour
          valuess[2] = "???";	//Weapon
          valuess[3] = "???";	//Structure
          valuess[4] = "???";	//Vehicle
          valuess[5] = "???";	//Craft
          valuess[6] = "???";	//Ship
          valuess[7] = "???";	//Station
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="WHY">
      case "WHY": {
        keyss = new String[]{"Orders", "Fight", "Shoot", "Drive", "Fly",
          "Travel"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Orders
        valuess[1] = "";	//Fight
        valuess[2] = "";	//Shoot
        valuess[3] = "";	//Drive
        valuess[4] = "";	//Fly
        valuess[5] = "";	//Travel
        try {
          valuess[0] = "";	//Orders
          valuess[1] = "";	//Fight
          valuess[2] = "";	//Shoot
          valuess[3] = "";	//Drive
          valuess[4] = "";	//Fly
          valuess[5] = "";	//Travel
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Orders
          valuess[1] = "???";	//Fight
          valuess[2] = "???";	//Shoot
          valuess[3] = "???";	//Drive
          valuess[4] = "???";	//Fly
          valuess[5] = "???";	//Travel
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="WHEN">
//      case "WHEN": {
//        keyss = new String[]{"Year", "Week", "Day", "Hour", "Minute", "Second",
//          "Duration"};
//        valuess = new String[keyss.length];
//        valuess[0] = "";	//Year
//        valuess[1] = "";	//Week
//        valuess[2] = "";	//Day
//        valuess[3] = "";	//Hour
//        valuess[4] = "";	//Minute
//        valuess[5] = "";	//Second
//        valuess[6] = "";	//Duration
//        try {
//          valuess[0] = "";	//Year
//          valuess[1] = "";	//Week
//          valuess[2] = "";	//Day
//          valuess[3] = "";	//Hour
//          valuess[4] = "";	//Minute
//          valuess[5] = "";	//Second
//          valuess[6] = "";	//Duration
//        } catch (Exception e) {
//          System.out.println(e.toString());
//          valuess[0] = "???";	//Year
//          valuess[1] = "???";	//Week
//          valuess[2] = "???";	//Day
//          valuess[3] = "???";	//Hour
//          valuess[4] = "???";	//Minute
//          valuess[5] = "???";	//Second
//          valuess[6] = "???";	//Duration
//        }
//        break;
//      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="WITH">
      case "WITH": {
        keyss = new String[]{"People", "Places", "Items", "Duration", "Risk",
          "Note", "Time", "Location"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//People
        valuess[1] = "";	//Places
        valuess[2] = "";	//Items
        valuess[3] = "";	//Duration
        valuess[4] = "";	//Risk
        valuess[5] = "";	//Note
        valuess[6] = "";	//Time
        valuess[7] = "";	//Location
        try {
          valuess[0] = "";	//People
          valuess[1] = "";	//Places
          valuess[2] = "";	//Items
          valuess[3] = "";	//Duration
          valuess[4] = "";	//Risk
          valuess[5] = "";	//Note
          valuess[6] = "";	//Time
          valuess[7] = "";	//Location
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//People
          valuess[1] = "???";	//Places
          valuess[2] = "???";	//Items
          valuess[3] = "???";	//Duration
          valuess[4] = "???";	//Risk
          valuess[5] = "???";	//Note
          valuess[6] = "???";	//Time
          valuess[7] = "???";	//Location
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Location">
      case "Location": {
        keyss = new String[]{"Structure", "X", "Y", "Z", "Sealed", "Exits"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Structure
        valuess[1] = "";	//X
        valuess[2] = "";	//Y
        valuess[3] = "";	//Z
        valuess[4] = "";	//Sealed
        valuess[5] = "";	//Exits
        try {
          valuess[0] = "";	//Structure
          valuess[1] = "";	//X
          valuess[2] = "";	//Y
          valuess[3] = "";	//Z
          valuess[4] = "";	//Sealed
          valuess[5] = "";	//Exits
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Structure
          valuess[1] = "???";	//X
          valuess[2] = "???";	//Y
          valuess[3] = "???";	//Z
          valuess[4] = "???";	//Sealed
          valuess[5] = "???";	//Exits
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="BUSINESS">
      case "BUSINESS": {
        keyss = new String[]{"MegaCorps", "Corportaion", "Syndication",
          "System Line"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//MegaCorps
        valuess[1] = "";	//Corportaion
        valuess[2] = "";	//Syndication
        valuess[3] = "";	//System Line
        try {
          valuess[0] = "";	//MegaCorps
          valuess[1] = "";	//Corportaion
          valuess[2] = "";	//Syndication
          valuess[3] = "";	//System Line
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//MegaCorps
          valuess[1] = "???";	//Corportaion
          valuess[2] = "???";	//Syndication
          valuess[3] = "???";	//System Line
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="GROUPS">
      case "GROUPS": {
        keyss = new String[]{"Team", "Crew", "Section", "Department", "Unit",
          "Division", "Brigade", "Battalion", "Company"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Team
        valuess[1] = "";	//Crew
        valuess[2] = "";	//Section
        valuess[3] = "";	//Department
        valuess[4] = "";	//Unit
        valuess[5] = "";	//Division
        valuess[6] = "";	//Brigade
        valuess[7] = "";	//Battalion
        valuess[8] = "";	//Company
        try {
          valuess[0] = "";	//Team
          valuess[1] = "";	//Crew
          valuess[2] = "";	//Section
          valuess[3] = "";	//Department
          valuess[4] = "";	//Unit
          valuess[5] = "";	//Division
          valuess[6] = "";	//Brigade
          valuess[7] = "";	//Battalion
          valuess[8] = "";	//Company
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Team
          valuess[1] = "???";	//Crew
          valuess[2] = "???";	//Section
          valuess[3] = "???";	//Department
          valuess[4] = "???";	//Unit
          valuess[5] = "???";	//Division
          valuess[6] = "???";	//Brigade
          valuess[7] = "???";	//Battalion
          valuess[8] = "???";	//Company
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="LOCATIONS">
      case "LOCATIONS": {
        keyss = new String[]{"Starport", "Startown", "Station", "Section",
          "Career", "Terms", "UPP", "Notes"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Starport
        valuess[1] = "";	//Startown
        valuess[2] = "";	//Station
        valuess[3] = "";	//Section
        valuess[4] = "";	//Career
        valuess[5] = "";	//Terms
        valuess[6] = "";	//UPP
        valuess[7] = "";	//Notes
        try {
          valuess[0] = "";	//Starport
          valuess[1] = "";	//Startown
          valuess[2] = "";	//Station
          valuess[3] = "";	//Section
          valuess[4] = "";	//Career
          valuess[5] = "";	//Terms
          valuess[6] = "";	//UPP
          valuess[7] = "";	//Notes
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Starport
          valuess[1] = "???";	//Startown
          valuess[2] = "???";	//Station
          valuess[3] = "???";	//Section
          valuess[4] = "???";	//Career
          valuess[5] = "???";	//Terms
          valuess[6] = "???";	//UPP
          valuess[7] = "???";	//Notes
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Crew Structure">
      case "Crew Structure": {
        keyss = new String[]{"Men Rank", "1/3 1-3", "1/2 4", "1/2 5", "1/? 6"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Men Rank
        valuess[1] = "";	//1/3 1-3
        valuess[2] = "";	//1/2 4
        valuess[3] = "";	//1/2 5
        valuess[4] = "";	//1/? 6
        try {
          valuess[0] = "";	//Men Rank
          valuess[1] = "";	//1/3 1-3
          valuess[2] = "";	//1/2 4
          valuess[3] = "";	//1/2 5
          valuess[4] = "";	//1/? 6
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Men Rank
          valuess[1] = "???";	//1/3 1-3
          valuess[2] = "???";	//1/2 4
          valuess[3] = "???";	//1/2 5
          valuess[4] = "???";	//1/? 6
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="VMACE">
      case "VMACE": {
        keyss = new String[]{"Volume", "Mass", "AI", "Cost", "Environ"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Volume
        valuess[1] = "";	//Mass
        valuess[2] = "";	//AI
        valuess[3] = "";	//Cost
        valuess[4] = "";	//Environ
        try {
          valuess[0] = "";	//Volume
          valuess[1] = "";	//Mass
          valuess[2] = "";	//AI
          valuess[3] = "";	//Cost
          valuess[4] = "";	//Environ
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Volume
          valuess[1] = "???";	//Mass
          valuess[2] = "???";	//AI
          valuess[3] = "???";	//Cost
          valuess[4] = "???";	//Environ
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="VOLUME">
      case "VOLUME": {
        keyss = new String[]{"Len", "Wid", "Hgt", "%"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Len
        valuess[1] = "";	//Wid
        valuess[2] = "";	//Hgt
        valuess[3] = "";	//%
        try {
          valuess[0] = "";	//Len
          valuess[1] = "";	//Wid
          valuess[2] = "";	//Hgt
          valuess[3] = "";	//%
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Len
          valuess[1] = "???";	//Wid
          valuess[2] = "???";	//Hgt
          valuess[3] = "???";	//%
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="MASS">
      case "MASS": {
        keyss = new String[]{"Unit", "Num", "Race"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Unit
        valuess[1] = "";	//Num
        valuess[2] = "";	//Race
        try {
          valuess[0] = "";	//Unit
          valuess[1] = "";	//Num
          valuess[2] = "";	//Race
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Unit
          valuess[1] = "???";	//Num
          valuess[2] = "???";	//Race
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="AI">
      case "AI": {
        keyss = new String[]{"AI", "TL"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//AI
        valuess[1] = "";	//TL
        try {
          valuess[0] = "";	//AI
          valuess[1] = "";	//TL
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//AI
          valuess[1] = "???";	//TL
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="ENVIRON">
      case "ENVIRON": {
        keyss = new String[]{"Breathes", "Sealed", "G"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Breathes
        valuess[1] = "";	//Sealed
        valuess[2] = "";	//G
        try {
          valuess[0] = "";	//Breathes
          valuess[1] = "";	//Sealed
          valuess[2] = "";	//G
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Breathes
          valuess[1] = "???";	//Sealed
          valuess[2] = "???";	//G
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="CPC">
      case "CPC": {
        keyss = new String[]{"Crew", "Passengers", "Cargo"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Crew
        valuess[1] = "";	//Passengers
        valuess[2] = "";	//Cargo
        try {
          valuess[0] = "";	//Crew
          valuess[1] = "";	//Passengers
          valuess[2] = "";	//Cargo
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Crew
          valuess[1] = "???";	//Passengers
          valuess[2] = "???";	//Cargo
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="CREW">
      case "CREW": {
        keyss = new String[]{"ID", "Position", "Rank", "Controls"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//ID
        valuess[1] = "";	//Position
        valuess[2] = "";	//Rank
        valuess[3] = "";	//Controls
        try {
          valuess[0] = "";	//ID
          valuess[1] = "";	//Position
          valuess[2] = "";	//Rank
          valuess[3] = "";	//Controls
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//ID
          valuess[1] = "???";	//Position
          valuess[2] = "???";	//Rank
          valuess[3] = "???";	//Controls
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="PASSENGERS">
      case "PASSENGERS": {
        keyss = new String[]{"Race", "Sex", "Age"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Race
        valuess[1] = "";	//Sex
        valuess[2] = "";	//Age
        try {
          valuess[0] = "";	//Race
          valuess[1] = "";	//Sex
          valuess[2] = "";	//Age
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Race
          valuess[1] = "???";	//Sex
          valuess[2] = "???";	//Age
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="CARGO">
      case "CARGO": {
        keyss = new String[]{""};
        valuess = new String[keyss.length];
        valuess[0] = "";	//
        try {
          valuess[0] = "";	//
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Weapon">
      case "Weapon": {
        keyss
          = new String[]{"VMACE", "Name", "Type", "Skill", "Rounds", "Range"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//VMACE
        valuess[1] = "";	//Name
        valuess[2] = "";	//Type
        valuess[3] = "";	//Skill
        valuess[4] = "";	//Rounds
        valuess[5] = "";	//Range
        try {
          valuess[0] = "";	//VMACE
          valuess[1] = "";	//Name
          valuess[2] = "";	//Type
          valuess[3] = "";	//Skill
          valuess[4] = "";	//Rounds
          valuess[5] = "";	//Range
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//VMACE
          valuess[1] = "???";	//Name
          valuess[2] = "???";	//Type
          valuess[3] = "???";	//Skill
          valuess[4] = "???";	//Rounds
          valuess[5] = "???";	//Range
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Weapon Description">
      case "Weapon Description": {
        keyss = new String[]{"Model", "Stage", "Burden", "Descriptor", "Type",
          "User", "Portability", "TL"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Model
        valuess[1] = "";	//Stage
        valuess[2] = "";	//Burden
        valuess[3] = "";	//Descriptor
        valuess[4] = "";	//Type
        valuess[5] = "";	//User
        valuess[6] = "";	//Portability
        valuess[7] = "";	//TL
        try {
          valuess[0] = "";	//Model
          valuess[1] = "";	//Stage
          valuess[2] = "";	//Burden
          valuess[3] = "";	//Descriptor
          valuess[4] = "";	//Type
          valuess[5] = "";	//User
          valuess[6] = "";	//Portability
          valuess[7] = "";	//TL
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Model
          valuess[1] = "???";	//Stage
          valuess[2] = "???";	//Burden
          valuess[3] = "???";	//Descriptor
          valuess[4] = "???";	//Type
          valuess[5] = "???";	//User
          valuess[6] = "???";	//Portability
          valuess[7] = "???";	//TL
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Weapon Extension">
      case "Weapon Extension": {
        keyss = new String[]{"Range", "Cost", "Mass", "QREBS", "Effects"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Range
        valuess[1] = "";	//Cost
        valuess[2] = "";	//Mass
        valuess[3] = "";	//QREBS
        valuess[4] = "";	//Effects
        try {
          valuess[0] = "";	//Range
          valuess[1] = "";	//Cost
          valuess[2] = "";	//Mass
          valuess[3] = "";	//QREBS
          valuess[4] = "";	//Effects
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Range
          valuess[1] = "???";	//Cost
          valuess[2] = "???";	//Mass
          valuess[3] = "???";	//QREBS
          valuess[4] = "???";	//Effects
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Space Weapon">
      case "Space Weapon": {
        keyss = new String[]{"Stage", "Range", "Mount", "Type", "TL", "(C+S)"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Stage
        valuess[1] = "";	//Range
        valuess[2] = "";	//Mount
        valuess[3] = "";	//Type
        valuess[4] = "";	//TL
        valuess[5] = "";	//(C+S)
        try {
          valuess[0] = "";	//Stage
          valuess[1] = "";	//Range
          valuess[2] = "";	//Mount
          valuess[3] = "";	//Type
          valuess[4] = "";	//TL
          valuess[5] = "";	//(C+S)
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Stage
          valuess[1] = "???";	//Range
          valuess[2] = "???";	//Mount
          valuess[3] = "???";	//Type
          valuess[4] = "???";	//TL
          valuess[5] = "???";	//(C+S)
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Space Missile">
      case "Space Missile": {
        keyss = new String[]{"Stage", "Missile", "Size", "Type", "Guidance"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Stage
        valuess[1] = "";	//Missile
        valuess[2] = "";	//Size
        valuess[3] = "";	//Type
        valuess[4] = "";	//Guidance
        try {
          valuess[0] = "";	//Stage
          valuess[1] = "";	//Missile
          valuess[2] = "";	//Size
          valuess[3] = "";	//Type
          valuess[4] = "";	//Guidance
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Stage
          valuess[1] = "???";	//Missile
          valuess[2] = "???";	//Size
          valuess[3] = "???";	//Type
          valuess[4] = "???";	//Guidance
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Damper ID">
      case "Damper ID": {
        keyss = new String[]{"Stage", "Range", "Mount", "Type", "TL", "(C+S)"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Stage
        valuess[1] = "";	//Range
        valuess[2] = "";	//Mount
        valuess[3] = "";	//Type
        valuess[4] = "";	//TL
        valuess[5] = "";	//(C+S)
        try {
          valuess[0] = "";	//Stage
          valuess[1] = "";	//Range
          valuess[2] = "";	//Mount
          valuess[3] = "";	//Type
          valuess[4] = "";	//TL
          valuess[5] = "";	//(C+S)
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Stage
          valuess[1] = "???";	//Range
          valuess[2] = "???";	//Mount
          valuess[3] = "???";	//Type
          valuess[4] = "???";	//TL
          valuess[5] = "???";	//(C+S)
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Scrambler ID">
      case "Scrambler ID": {
        keyss = new String[]{"Stage", "Missile", "Size", "Type", "Guidance"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Stage
        valuess[1] = "";	//Missile
        valuess[2] = "";	//Size
        valuess[3] = "";	//Type
        valuess[4] = "";	//Guidance
        try {
          valuess[0] = "";	//Stage
          valuess[1] = "";	//Missile
          valuess[2] = "";	//Size
          valuess[3] = "";	//Type
          valuess[4] = "";	//Guidance
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Stage
          valuess[1] = "???";	//Missile
          valuess[2] = "???";	//Size
          valuess[3] = "???";	//Type
          valuess[4] = "???";	//Guidance
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Globe ID">
      case "Globe ID": {
        keyss = new String[]{"Stage", "Missile", "Size", "Type", "Guidance"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Stage
        valuess[1] = "";	//Missile
        valuess[2] = "";	//Size
        valuess[3] = "";	//Type
        valuess[4] = "";	//Guidance
        try {
          valuess[0] = "";	//Stage
          valuess[1] = "";	//Missile
          valuess[2] = "";	//Size
          valuess[3] = "";	//Type
          valuess[4] = "";	//Guidance
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Stage
          valuess[1] = "???";	//Missile
          valuess[2] = "???";	//Size
          valuess[3] = "???";	//Type
          valuess[4] = "???";	//Guidance
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="">
      case "": {
        keyss = new String[]{};
        valuess = new String[keyss.length];
        try {
        } catch (Exception e) {
          System.out.println(e.toString());
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="AM Anti Missile Mode Action">
      case "AM Anti Missile Mode Action": {
        keyss = new String[]{"1D", "Size", "Mods", "Guidance"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//1D
        valuess[1] = "";	//Size
        valuess[2] = "";	//Mods
        valuess[3] = "";	//Guidance
        try {
          valuess[0] = "";	//1D
          valuess[1] = "";	//Size
          valuess[2] = "";	//Mods
          valuess[3] = "";	//Guidance
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//1D
          valuess[1] = "???";	//Size
          valuess[2] = "???";	//Mods
          valuess[3] = "???";	//Guidance
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Anti Beam & Absolute Mode Action">
      case "Anti Beam & Absolute Mode Action": {
        keyss = new String[]{"1D", "TL", "Mount"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//1D
        valuess[1] = "";	//TL
        valuess[2] = "";	//Mount
        try {
          valuess[0] = "";	//1D
          valuess[1] = "";	//TL
          valuess[2] = "";	//Mount
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//1D
          valuess[1] = "???";	//TL
          valuess[2] = "???";	//Mount
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Space Weapon Task">
      case "Space Weapon Task": {
        keyss = new String[]{"nD", "TL", "(C+S)", "(Size-Range)", "Mods"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//nD
        valuess[1] = "";	//TL
        valuess[2] = "";	//(C+S)
        valuess[3] = "";	//(Size-Range)
        valuess[4] = "";	//Mods
        try {
          valuess[0] = "";	//nD
          valuess[1] = "";	//TL
          valuess[2] = "";	//(C+S)
          valuess[3] = "";	//(Size-Range)
          valuess[4] = "";	//Mods
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//nD
          valuess[1] = "???";	//TL
          valuess[2] = "???";	//(C+S)
          valuess[3] = "???";	//(Size-Range)
          valuess[4] = "???";	//Mods
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Sensor Task">
      case "Sensor Task": {
        keyss = new String[]{"1D", "Sensor TL", "(C+S)", "(Size-Range)", "Mods"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//1D
        valuess[1] = "";	//Sensor TL
        valuess[2] = "";	//(C+S)
        valuess[3] = "";	//(Size-Range)
        valuess[4] = "";	//Mods
        try {
          valuess[0] = "";	//1D
          valuess[1] = "";	//Sensor TL
          valuess[2] = "";	//(C+S)
          valuess[3] = "";	//(Size-Range)
          valuess[4] = "";	//Mods
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//1D
          valuess[1] = "???";	//Sensor TL
          valuess[2] = "???";	//(C+S)
          valuess[3] = "???";	//(Size-Range)
          valuess[4] = "???";	//Mods
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Unpowered Suit">
      case "Unpowered Suit": {
        keyss = new String[]{"VMACE"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//VMACE
        try {
          valuess[0] = "";	//VMACE
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//VMACE
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Powered Armour">
      case "Powered Armour": {
        keyss = new String[]{"VMACE"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//VMACE
        try {
          valuess[0] = "";	//VMACE
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//VMACE
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Powered Dress">
      case "Powered Dress": {
        keyss = new String[]{"VMACE"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//VMACE
        try {
          valuess[0] = "";	//VMACE
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//VMACE
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Unit/Item">
      case "Unit/Item": {
        keyss = new String[]{""};
        valuess = new String[keyss.length];
        valuess[0] = "";	//
        try {
          valuess[0] = "";	//
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Armour Description">
      case "Armour Description": {
        keyss = new String[]{"Model", "Stage", "Burden", "Descriptor", "Type",
          "User", "Portability", "TL"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Model
        valuess[1] = "";	//Stage
        valuess[2] = "";	//Burden
        valuess[3] = "";	//Descriptor
        valuess[4] = "";	//Type
        valuess[5] = "";	//User
        valuess[6] = "";	//Portability
        valuess[7] = "";	//TL
        try {
          valuess[0] = "";	//Model
          valuess[1] = "";	//Stage
          valuess[2] = "";	//Burden
          valuess[3] = "";	//Descriptor
          valuess[4] = "";	//Type
          valuess[5] = "";	//User
          valuess[6] = "";	//Portability
          valuess[7] = "";	//TL
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Model
          valuess[1] = "???";	//Stage
          valuess[2] = "???";	//Burden
          valuess[3] = "???";	//Descriptor
          valuess[4] = "???";	//Type
          valuess[5] = "???";	//User
          valuess[6] = "???";	//Portability
          valuess[7] = "???";	//TL
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Armour Extension">
      case "Armour Extension": {
        keyss = new String[]{"Model", "Cost", "Mass", "QREBs", "Ar", "Ca", "Fl",
          "Ra", "So", "Ps", "In", "Se"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Model
        valuess[1] = "";	//Cost
        valuess[2] = "";	//Mass
        valuess[3] = "";	//QREBs
        valuess[4] = "";	//Ar
        valuess[5] = "";	//Ca
        valuess[6] = "";	//Fl
        valuess[7] = "";	//Ra
        valuess[8] = "";	//So
        valuess[9] = "";	//Ps
        valuess[10] = "";	//In
        valuess[11] = "";	//Se
        try {
          valuess[0] = "";	//Model
          valuess[1] = "";	//Cost
          valuess[2] = "";	//Mass
          valuess[3] = "";	//QREBs
          valuess[4] = "";	//Ar
          valuess[5] = "";	//Ca
          valuess[6] = "";	//Fl
          valuess[7] = "";	//Ra
          valuess[8] = "";	//So
          valuess[9] = "";	//Ps
          valuess[10] = "";	//In
          valuess[11] = "";	//Se
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Model
          valuess[1] = "???";	//Cost
          valuess[2] = "???";	//Mass
          valuess[3] = "???";	//QREBs
          valuess[4] = "???";	//Ar
          valuess[5] = "???";	//Ca
          valuess[6] = "???";	//Fl
          valuess[7] = "???";	//Ra
          valuess[8] = "???";	//So
          valuess[9] = "???";	//Ps
          valuess[10] = "???";	//In
          valuess[11] = "???";	//Se
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Structure">
      case "Structure": {
        keyss = new String[]{"VMACE", "CPC"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//VMACE
        valuess[1] = "";	//CPC
        try {
          valuess[0] = "";	//VMACE
          valuess[1] = "";	//CPC
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//VMACE
          valuess[1] = "???";	//CPC
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Vehicle">
      case "Vehicle": {
        keyss = new String[]{"VMACE", "CPC", "G"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//VMACE
        valuess[1] = "";	//CPC
        valuess[2] = "";	//G
        try {
          valuess[0] = "";	//VMACE
          valuess[1] = "";	//CPC
          valuess[2] = "";	//G
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//VMACE
          valuess[1] = "???";	//CPC
          valuess[2] = "???";	//G
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Vehicle Description">
      case "Vehicle Description": {
        keyss = new String[]{"Model", "Bulk", "Motive", "Mission", "Type",
          "User", "TL"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Model
        valuess[1] = "";	//Bulk
        valuess[2] = "";	//Motive
        valuess[3] = "";	//Mission
        valuess[4] = "";	//Type
        valuess[5] = "";	//User
        valuess[6] = "";	//TL
        try {
          valuess[0] = "";	//Model
          valuess[1] = "";	//Bulk
          valuess[2] = "";	//Motive
          valuess[3] = "";	//Mission
          valuess[4] = "";	//Type
          valuess[5] = "";	//User
          valuess[6] = "";	//TL
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Model
          valuess[1] = "???";	//Bulk
          valuess[2] = "???";	//Motive
          valuess[3] = "???";	//Mission
          valuess[4] = "???";	//Type
          valuess[5] = "???";	//User
          valuess[6] = "???";	//TL
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Vehicle Extension">
      case "Vehicle Extension": {
        keyss = new String[]{"Tons", "Speed", "Load", "Stage", "Environ",
          "Endurance", "QREBs", "Options"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Tons
        valuess[1] = "";	//Speed
        valuess[2] = "";	//Load
        valuess[3] = "";	//Stage
        valuess[4] = "";	//Environ
        valuess[5] = "";	//Endurance
        valuess[6] = "";	//QREBs
        valuess[7] = "";	//Options
        try {
          valuess[0] = "";	//Tons
          valuess[1] = "";	//Speed
          valuess[2] = "";	//Load
          valuess[3] = "";	//Stage
          valuess[4] = "";	//Environ
          valuess[5] = "";	//Endurance
          valuess[6] = "";	//QREBs
          valuess[7] = "";	//Options
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Tons
          valuess[1] = "???";	//Speed
          valuess[2] = "???";	//Load
          valuess[3] = "???";	//Stage
          valuess[4] = "???";	//Environ
          valuess[5] = "???";	//Endurance
          valuess[6] = "???";	//QREBs
          valuess[7] = "???";	//Options
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Hit Locations">
      case "Hit Locations": {
        keyss = new String[]{"2  Comms", "3  Cargo", "4  Sensors",
          "5  Protections", "6  Life Support", "7  Body Panel",
          "8  Power Source", "9  Locomotion", "10 Weaponry", "11 Navigation",
          "12 Computer"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//2  Comms
        valuess[1] = "";	//3  Cargo
        valuess[2] = "";	//4  Sensors
        valuess[3] = "";	//5  Protections
        valuess[4] = "";	//6  Life Support
        valuess[5] = "";	//7  Body Panel
        valuess[6] = "";	//8  Power Source
        valuess[7] = "";	//9  Locomotion
        valuess[8] = "";	//10 Weaponry
        valuess[9] = "";	//11 Navigation
        valuess[10] = "";	//12 Computer
        try {
          valuess[0] = "";	//2  Comms
          valuess[1] = "";	//3  Cargo
          valuess[2] = "";	//4  Sensors
          valuess[3] = "";	//5  Protections
          valuess[4] = "";	//6  Life Support
          valuess[5] = "";	//7  Body Panel
          valuess[6] = "";	//8  Power Source
          valuess[7] = "";	//9  Locomotion
          valuess[8] = "";	//10 Weaponry
          valuess[9] = "";	//11 Navigation
          valuess[10] = "";	//12 Computer
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//2  Comms
          valuess[1] = "???";	//3  Cargo
          valuess[2] = "???";	//4  Sensors
          valuess[3] = "???";	//5  Protections
          valuess[4] = "???";	//6  Life Support
          valuess[5] = "???";	//7  Body Panel
          valuess[6] = "???";	//8  Power Source
          valuess[7] = "???";	//9  Locomotion
          valuess[8] = "???";	//10 Weaponry
          valuess[9] = "???";	//11 Navigation
          valuess[10] = "???";	//12 Computer
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Sensors">
      case "Sensors": {
        keyss = new String[]{"Stage", "Range", "Mount", "Type", "TL", "(C+S)"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Stage
        valuess[1] = "";	//Range
        valuess[2] = "";	//Mount
        valuess[3] = "";	//Type
        valuess[4] = "";	//TL
        valuess[5] = "";	//(C+S)
        try {
          valuess[0] = "";	//Stage
          valuess[1] = "";	//Range
          valuess[2] = "";	//Mount
          valuess[3] = "";	//Type
          valuess[4] = "";	//TL
          valuess[5] = "";	//(C+S)
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Stage
          valuess[1] = "???";	//Range
          valuess[2] = "???";	//Mount
          valuess[3] = "???";	//Type
          valuess[4] = "???";	//TL
          valuess[5] = "???";	//(C+S)
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Craft">
      case "Craft": {
        keyss = new String[]{"VMACE", "CPC", "G"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//VMACE
        valuess[1] = "";	//CPC
        valuess[2] = "";	//G
        try {
          valuess[0] = "";	//VMACE
          valuess[1] = "";	//CPC
          valuess[2] = "";	//G
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//VMACE
          valuess[1] = "???";	//CPC
          valuess[2] = "???";	//G
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Ship">
      case "Ship": {
        keyss = new String[]{"VMACE", "CPC", "G", "J"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//VMACE
        valuess[1] = "";	//CPC
        valuess[2] = "";	//G
        valuess[3] = "";	//J
        try {
          valuess[0] = "";	//VMACE
          valuess[1] = "";	//CPC
          valuess[2] = "";	//G
          valuess[3] = "";	//J
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//VMACE
          valuess[1] = "???";	//CPC
          valuess[2] = "???";	//G
          valuess[3] = "???";	//J
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="QSP">
      case "QSP": {
        keyss = new String[]{"Mission", "Hull", "Config", "G", "J"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Mission
        valuess[1] = "";	//Hull
        valuess[2] = "";	//Config
        valuess[3] = "";	//G
        valuess[4] = "";	//J
        try {
          valuess[0] = "";	//Mission
          valuess[1] = "";	//Hull
          valuess[2] = "";	//Config
          valuess[3] = "";	//G
          valuess[4] = "";	//J
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Mission
          valuess[1] = "???";	//Hull
          valuess[2] = "???";	//Config
          valuess[3] = "???";	//G
          valuess[4] = "???";	//J
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="ACS Starships">
      case "ACS Starships": {
        keyss = new String[]{"Scout/Courier (S-AL22)", "Free Trader (A-BS11)",
          "Far Trader (A2-BS12)", "Corvette (E-EA53)", "Yacht (Y-EU42)",
          "Frigate (G-FB43)", "Corsair (P-DA42)", "Cruiser (C-VS23)",
          "Lab Ship (L-DC12)"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Scout/Courier (S-AL22)
        valuess[1] = "";	//Free Trader (A-BS11)
        valuess[2] = "";	//Far Trader (A2-BS12)
        valuess[3] = "";	//Corvette (E-EA53)
        valuess[4] = "";	//Yacht (Y-EU42)
        valuess[5] = "";	//Frigate (G-FB43)
        valuess[6] = "";	//Corsair (P-DA42)
        valuess[7] = "";	//Cruiser (C-VS23)
        valuess[8] = "";	//Lab Ship (L-DC12)
        try {
          valuess[0] = "";	//Scout/Courier (S-AL22)
          valuess[1] = "";	//Free Trader (A-BS11)
          valuess[2] = "";	//Far Trader (A2-BS12)
          valuess[3] = "";	//Corvette (E-EA53)
          valuess[4] = "";	//Yacht (Y-EU42)
          valuess[5] = "";	//Frigate (G-FB43)
          valuess[6] = "";	//Corsair (P-DA42)
          valuess[7] = "";	//Cruiser (C-VS23)
          valuess[8] = "";	//Lab Ship (L-DC12)
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Scout/Courier (S-AL22)
          valuess[1] = "???";	//Free Trader (A-BS11)
          valuess[2] = "???";	//Far Trader (A2-BS12)
          valuess[3] = "???";	//Corvette (E-EA53)
          valuess[4] = "???";	//Yacht (Y-EU42)
          valuess[5] = "???";	//Frigate (G-FB43)
          valuess[6] = "???";	//Corsair (P-DA42)
          valuess[7] = "???";	//Cruiser (C-VS23)
          valuess[8] = "???";	//Lab Ship (L-DC12)
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Station">
      case "Station": {
        keyss = new String[]{"VMACE", "CPC", "G"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//VMACE
        valuess[1] = "";	//CPC
        valuess[2] = "";	//G
        try {
          valuess[0] = "";	//VMACE
          valuess[1] = "";	//CPC
          valuess[2] = "";	//G
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//VMACE
          valuess[1] = "???";	//CPC
          valuess[2] = "???";	//G
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Item">
      case "Item": {
        keyss = new String[]{"VMACE"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//VMACE
        try {
          valuess[0] = "";	//VMACE
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//VMACE
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Counter">
      case "Counter": {
        keyss = new String[]{"Title", "ID", "T01", "T02", "T03", "T04", "T05",
          "T06", "T07", "T08", "T09", "T10", "T11", "T12", "T13", "T14", "T15",
          "T16", "T17", "T18", "T19", "T20", "Pics"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Title
        valuess[1] = "";	//ID
        valuess[2] = "";	//T01
        valuess[3] = "";	//T02
        valuess[4] = "";	//T03
        valuess[5] = "";	//T04
        valuess[6] = "";	//T05
        valuess[7] = "";	//T06
        valuess[8] = "";	//T07
        valuess[9] = "";	//T08
        valuess[10] = "";	//T09
        valuess[11] = "";	//T10
        valuess[12] = "";	//T11
        valuess[13] = "";	//T12
        valuess[14] = "";	//T13
        valuess[15] = "";	//T14
        valuess[16] = "";	//T15
        valuess[17] = "";	//T16
        valuess[18] = "";	//T17
        valuess[19] = "";	//T18
        valuess[20] = "";	//T19
        valuess[21] = "";	//T20
        valuess[22] = "";	//Pics
        try {
          valuess[0] = "";	//Title
          valuess[1] = "";	//ID
          valuess[2] = "";	//T01
          valuess[3] = "";	//T02
          valuess[4] = "";	//T03
          valuess[5] = "";	//T04
          valuess[6] = "";	//T05
          valuess[7] = "";	//T06
          valuess[8] = "";	//T07
          valuess[9] = "";	//T08
          valuess[10] = "";	//T09
          valuess[11] = "";	//T10
          valuess[12] = "";	//T11
          valuess[13] = "";	//T12
          valuess[14] = "";	//T13
          valuess[15] = "";	//T14
          valuess[16] = "";	//T15
          valuess[17] = "";	//T16
          valuess[18] = "";	//T17
          valuess[19] = "";	//T18
          valuess[20] = "";	//T19
          valuess[21] = "";	//T20
          valuess[22] = "";	//Pics
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Title
          valuess[1] = "???";	//ID
          valuess[2] = "???";	//T01
          valuess[3] = "???";	//T02
          valuess[4] = "???";	//T03
          valuess[5] = "???";	//T04
          valuess[6] = "???";	//T05
          valuess[7] = "???";	//T06
          valuess[8] = "???";	//T07
          valuess[9] = "???";	//T08
          valuess[10] = "???";	//T09
          valuess[11] = "???";	//T10
          valuess[12] = "???";	//T11
          valuess[13] = "???";	//T12
          valuess[14] = "???";	//T13
          valuess[15] = "???";	//T14
          valuess[16] = "???";	//T15
          valuess[17] = "???";	//T16
          valuess[18] = "???";	//T17
          valuess[19] = "???";	//T18
          valuess[20] = "???";	//T19
          valuess[21] = "???";	//T20
          valuess[22] = "???";	//Pics
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Address">
      case "Address": {
        keyss = new String[]{"Name", "Street", "Town", "Postcode", "County",
          "Country", "Planet", "System", "Polity", "Subsector", "Sector", "????"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Name
        valuess[1] = "";	//Street
        valuess[2] = "";	//Town
        valuess[3] = "";	//Postcode
        valuess[4] = "";	//County
        valuess[5] = "";	//Country
        valuess[6] = "";	//Planet
        valuess[7] = "";	//System
        valuess[8] = "";	//Polity
        valuess[9] = "";	//Subsector
        valuess[10] = "";	//Sector
        valuess[11] = "";	//????
        try {
          valuess[0] = "";	//Name
          valuess[1] = "";	//Street
          valuess[2] = "";	//Town
          valuess[3] = "";	//Postcode
          valuess[4] = "";	//County
          valuess[5] = "";	//Country
          valuess[6] = "";	//Planet
          valuess[7] = "";	//System
          valuess[8] = "";	//Polity
          valuess[9] = "";	//Subsector
          valuess[10] = "";	//Sector
          valuess[11] = "";	//????
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Name
          valuess[1] = "???";	//Street
          valuess[2] = "???";	//Town
          valuess[3] = "???";	//Postcode
          valuess[4] = "???";	//County
          valuess[5] = "???";	//Country
          valuess[6] = "???";	//Planet
          valuess[7] = "???";	//System
          valuess[8] = "???";	//Polity
          valuess[9] = "???";	//Subsector
          valuess[10] = "???";	//Sector
          valuess[11] = "???";	//????
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Contact">
      case "Contact": {
        keyss = new String[]{"Name", "ID", "Phone", "email"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Name
        valuess[1] = "";	//ID
        valuess[2] = "";	//Phone
        valuess[3] = "";	//email
        try {
          valuess[0] = "";	//Name
          valuess[1] = "";	//ID
          valuess[2] = "";	//Phone
          valuess[3] = "";	//email
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Name
          valuess[1] = "???";	//ID
          valuess[2] = "???";	//Phone
          valuess[3] = "???";	//email
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Dice Rolls">
      case "Dice Rolls": {
        keyss = new String[]{"1d6", "2d6", "3d6", "Flux", "Flux+", "Flux-"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//1d6
        valuess[1] = "";	//2d6
        valuess[2] = "";	//3d6
        valuess[3] = "";	//Flux
        valuess[4] = "";	//Flux+
        valuess[5] = "";	//Flux-
        try {
          valuess[0] = "";	//1d6
          valuess[1] = "";	//2d6
          valuess[2] = "";	//3d6
          valuess[3] = "";	//Flux
          valuess[4] = "";	//Flux+
          valuess[5] = "";	//Flux-
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//1d6
          valuess[1] = "???";	//2d6
          valuess[2] = "???";	//3d6
          valuess[3] = "???";	//Flux
          valuess[4] = "???";	//Flux+
          valuess[5] = "???";	//Flux-
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="1D6">
      case "1D6": {
        keyss = new String[]{"1", "2", "3", "4", "5", "6"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//1
        valuess[1] = "";	//2
        valuess[2] = "";	//3
        valuess[3] = "";	//4
        valuess[4] = "";	//5
        valuess[5] = "";	//6
        try {
          valuess[0] = "";	//1
          valuess[1] = "";	//2
          valuess[2] = "";	//3
          valuess[3] = "";	//4
          valuess[4] = "";	//5
          valuess[5] = "";	//6
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//1
          valuess[1] = "???";	//2
          valuess[2] = "???";	//3
          valuess[3] = "???";	//4
          valuess[4] = "???";	//5
          valuess[5] = "???";	//6
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="2D6">
      case "2D6": {
        keyss = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
          "12"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//2
        valuess[1] = "";	//3
        valuess[2] = "";	//4
        valuess[3] = "";	//5
        valuess[4] = "";	//6
        valuess[5] = "";	//7
        valuess[6] = "";	//8
        valuess[7] = "";	//9
        valuess[8] = "";	//10
        valuess[9] = "";	//11
        valuess[10] = "";	//12
        try {
          valuess[0] = "";	//2
          valuess[1] = "";	//3
          valuess[2] = "";	//4
          valuess[3] = "";	//5
          valuess[4] = "";	//6
          valuess[5] = "";	//7
          valuess[6] = "";	//8
          valuess[7] = "";	//9
          valuess[8] = "";	//10
          valuess[9] = "";	//11
          valuess[10] = "";	//12
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//2
          valuess[1] = "???";	//3
          valuess[2] = "???";	//4
          valuess[3] = "???";	//5
          valuess[4] = "???";	//6
          valuess[5] = "???";	//7
          valuess[6] = "???";	//8
          valuess[7] = "???";	//9
          valuess[8] = "???";	//10
          valuess[9] = "???";	//11
          valuess[10] = "???";	//12
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="3D6">
      case "3D6": {
        keyss
          = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
            "13", "14", "15", "16", "17", "18"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//3
        valuess[1] = "";	//4
        valuess[2] = "";	//5
        valuess[3] = "";	//6
        valuess[4] = "";	//7
        valuess[5] = "";	//8
        valuess[6] = "";	//9
        valuess[7] = "";	//10
        valuess[8] = "";	//11
        valuess[9] = "";	//12
        valuess[10] = "";	//13
        valuess[11] = "";	//14
        valuess[12] = "";	//15
        valuess[13] = "";	//16
        valuess[14] = "";	//17
        valuess[15] = "";	//18
        try {
          valuess[0] = "";	//3
          valuess[1] = "";	//4
          valuess[2] = "";	//5
          valuess[3] = "";	//6
          valuess[4] = "";	//7
          valuess[5] = "";	//8
          valuess[6] = "";	//9
          valuess[7] = "";	//10
          valuess[8] = "";	//11
          valuess[9] = "";	//12
          valuess[10] = "";	//13
          valuess[11] = "";	//14
          valuess[12] = "";	//15
          valuess[13] = "";	//16
          valuess[14] = "";	//17
          valuess[15] = "";	//18
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//3
          valuess[1] = "???";	//4
          valuess[2] = "???";	//5
          valuess[3] = "???";	//6
          valuess[4] = "???";	//7
          valuess[5] = "???";	//8
          valuess[6] = "???";	//9
          valuess[7] = "???";	//10
          valuess[8] = "???";	//11
          valuess[9] = "???";	//12
          valuess[10] = "???";	//13
          valuess[11] = "???";	//14
          valuess[12] = "???";	//15
          valuess[13] = "???";	//16
          valuess[14] = "???";	//17
          valuess[15] = "???";	//18
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Percentages">
      case "Percentages": {
        keyss = new String[]{"10%", "20%", "30%", "40%", "50%", "60%", "70%",
          "80%", "90%", "100%"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//10%
        valuess[1] = "";	//20%
        valuess[2] = "";	//30%
        valuess[3] = "";	//40%
        valuess[4] = "";	//50%
        valuess[5] = "";	//60%
        valuess[6] = "";	//70%
        valuess[7] = "";	//80%
        valuess[8] = "";	//90%
        valuess[9] = "";	//100%
        try {
          valuess[0] = "";	//10%
          valuess[1] = "";	//20%
          valuess[2] = "";	//30%
          valuess[3] = "";	//40%
          valuess[4] = "";	//50%
          valuess[5] = "";	//60%
          valuess[6] = "";	//70%
          valuess[7] = "";	//80%
          valuess[8] = "";	//90%
          valuess[9] = "";	//100%
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//10%
          valuess[1] = "???";	//20%
          valuess[2] = "???";	//30%
          valuess[3] = "???";	//40%
          valuess[4] = "???";	//50%
          valuess[5] = "???";	//60%
          valuess[6] = "???";	//70%
          valuess[7] = "???";	//80%
          valuess[8] = "???";	//90%
          valuess[9] = "???";	//100%
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Appearance">
      case "Appearance": {
        keyss = new String[]{"Height", "Weight", "Hair", "Eyes", "Details"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Height
        valuess[1] = "";	//Weight
        valuess[2] = "";	//Hair
        valuess[3] = "";	//Eyes
        valuess[4] = "";	//Details
        try {
          valuess[0] = "";	//Height
          valuess[1] = "";	//Weight
          valuess[2] = "";	//Hair
          valuess[3] = "";	//Eyes
          valuess[4] = "";	//Details
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Height
          valuess[1] = "???";	//Weight
          valuess[2] = "???";	//Hair
          valuess[3] = "???";	//Eyes
          valuess[4] = "???";	//Details
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Frequency">
      case "Frequency": {
        keyss = new String[]{"Common", "Uncommon", "Rare"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Common
        valuess[1] = "";	//Uncommon
        valuess[2] = "";	//Rare
        try {
          valuess[0] = "";	//Common
          valuess[1] = "";	//Uncommon
          valuess[2] = "";	//Rare
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Common
          valuess[1] = "???";	//Uncommon
          valuess[2] = "???";	//Rare
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Skills">
      case "Skills": {
        keyss
          = new String[]{"Admin", "Advocate", "Animals", "Athlete", "Broker",
            "Bureaucrat", "Comms", "Computer", "Counsellor", "Designer",
            "Diplomat", "Driver", "Explosives", "Fleet Tactics", "Flyer",
            "Forensics", "Gambler", "High-G", "Hostile Environ", "JOT",
            "Language", "Leader", "Liaison", "Naval Architect", "Seafarer",
            "Stealth", "Strategy", "Streetwise", "Survey", "Survival", "Tactics",
            "Teacher", "Trader", "Vacc Suit", "Zero-G"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Admin
        valuess[1] = "";	//Advocate
        valuess[2] = "";	//Animals
        valuess[3] = "";	//Athlete
        valuess[4] = "";	//Broker
        valuess[5] = "";	//Bureaucrat
        valuess[6] = "";	//Comms
        valuess[7] = "";	//Computer
        valuess[8] = "";	//Counsellor
        valuess[9] = "";	//Designer
        valuess[10] = "";	//Diplomat
        valuess[11] = "";	//Driver
        valuess[12] = "";	//Explosives
        valuess[13] = "";	//Fleet Tactics
        valuess[14] = "";	//Flyer
        valuess[15] = "";	//Forensics
        valuess[16] = "";	//Gambler
        valuess[17] = "";	//High-G
        valuess[18] = "";	//Hostile Environ
        valuess[19] = "";	//JOT
        valuess[20] = "";	//Language
        valuess[21] = "";	//Leader
        valuess[22] = "";	//Liaison
        valuess[23] = "";	//Naval Architect
        valuess[24] = "";	//Seafarer
        valuess[25] = "";	//Stealth
        valuess[26] = "";	//Strategy
        valuess[27] = "";	//Streetwise
        valuess[28] = "";	//Survey
        valuess[29] = "";	//Survival
        valuess[30] = "";	//Tactics
        valuess[31] = "";	//Teacher
        valuess[32] = "";	//Trader
        valuess[33] = "";	//Vacc Suit
        valuess[34] = "";	//Zero-G
        try {
          valuess[0] = "";	//Admin
          valuess[1] = "";	//Advocate
          valuess[2] = "";	//Animals
          valuess[3] = "";	//Athlete
          valuess[4] = "";	//Broker
          valuess[5] = "";	//Bureaucrat
          valuess[6] = "";	//Comms
          valuess[7] = "";	//Computer
          valuess[8] = "";	//Counsellor
          valuess[9] = "";	//Designer
          valuess[10] = "";	//Diplomat
          valuess[11] = "";	//Driver
          valuess[12] = "";	//Explosives
          valuess[13] = "";	//Fleet Tactics
          valuess[14] = "";	//Flyer
          valuess[15] = "";	//Forensics
          valuess[16] = "";	//Gambler
          valuess[17] = "";	//High-G
          valuess[18] = "";	//Hostile Environ
          valuess[19] = "";	//JOT
          valuess[20] = "";	//Language
          valuess[21] = "";	//Leader
          valuess[22] = "";	//Liaison
          valuess[23] = "";	//Naval Architect
          valuess[24] = "";	//Seafarer
          valuess[25] = "";	//Stealth
          valuess[26] = "";	//Strategy
          valuess[27] = "";	//Streetwise
          valuess[28] = "";	//Survey
          valuess[29] = "";	//Survival
          valuess[30] = "";	//Tactics
          valuess[31] = "";	//Teacher
          valuess[32] = "";	//Trader
          valuess[33] = "";	//Vacc Suit
          valuess[34] = "";	//Zero-G
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Admin
          valuess[1] = "???";	//Advocate
          valuess[2] = "???";	//Animals
          valuess[3] = "???";	//Athlete
          valuess[4] = "???";	//Broker
          valuess[5] = "???";	//Bureaucrat
          valuess[6] = "???";	//Comms
          valuess[7] = "???";	//Computer
          valuess[8] = "???";	//Counsellor
          valuess[9] = "???";	//Designer
          valuess[10] = "???";	//Diplomat
          valuess[11] = "???";	//Driver
          valuess[12] = "???";	//Explosives
          valuess[13] = "???";	//Fleet Tactics
          valuess[14] = "???";	//Flyer
          valuess[15] = "???";	//Forensics
          valuess[16] = "???";	//Gambler
          valuess[17] = "???";	//High-G
          valuess[18] = "???";	//Hostile Environ
          valuess[19] = "???";	//JOT
          valuess[20] = "???";	//Language
          valuess[21] = "???";	//Leader
          valuess[22] = "???";	//Liaison
          valuess[23] = "???";	//Naval Architect
          valuess[24] = "???";	//Seafarer
          valuess[25] = "???";	//Stealth
          valuess[26] = "???";	//Strategy
          valuess[27] = "???";	//Streetwise
          valuess[28] = "???";	//Survey
          valuess[29] = "???";	//Survival
          valuess[30] = "???";	//Tactics
          valuess[31] = "???";	//Teacher
          valuess[32] = "???";	//Trader
          valuess[33] = "???";	//Vacc Suit
          valuess[34] = "???";	//Zero-G
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Starship Skills (7)">
      case "Starship Skills (7)": {
        keyss = new String[]{"Astrogator", "Engineer", "Gunner", "Medic",
          "Pilot", "Sensors", "Steward"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Astrogator
        valuess[1] = "";	//Engineer
        valuess[2] = "";	//Gunner
        valuess[3] = "";	//Medic
        valuess[4] = "";	//Pilot
        valuess[5] = "";	//Sensors
        valuess[6] = "";	//Steward
        try {
          valuess[0] = "";	//Astrogator
          valuess[1] = "";	//Engineer
          valuess[2] = "";	//Gunner
          valuess[3] = "";	//Medic
          valuess[4] = "";	//Pilot
          valuess[5] = "";	//Sensors
          valuess[6] = "";	//Steward
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Astrogator
          valuess[1] = "???";	//Engineer
          valuess[2] = "???";	//Gunner
          valuess[3] = "???";	//Medic
          valuess[4] = "???";	//Pilot
          valuess[5] = "???";	//Sensors
          valuess[6] = "???";	//Steward
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="The Trades (10)">
      case "The Trades (10)": {
        keyss
          = new String[]{"Biologics", "Craftsman", "Electronics", "Fluidics",
            "Gravitics", "Magnetics", "Mechanic", "Photonics", "Polymers",
            "Programmer"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Biologics
        valuess[1] = "";	//Craftsman
        valuess[2] = "";	//Electronics
        valuess[3] = "";	//Fluidics
        valuess[4] = "";	//Gravitics
        valuess[5] = "";	//Magnetics
        valuess[6] = "";	//Mechanic
        valuess[7] = "";	//Photonics
        valuess[8] = "";	//Polymers
        valuess[9] = "";	//Programmer
        try {
          valuess[0] = "";	//Biologics
          valuess[1] = "";	//Craftsman
          valuess[2] = "";	//Electronics
          valuess[3] = "";	//Fluidics
          valuess[4] = "";	//Gravitics
          valuess[5] = "";	//Magnetics
          valuess[6] = "";	//Mechanic
          valuess[7] = "";	//Photonics
          valuess[8] = "";	//Polymers
          valuess[9] = "";	//Programmer
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Biologics
          valuess[1] = "???";	//Craftsman
          valuess[2] = "???";	//Electronics
          valuess[3] = "???";	//Fluidics
          valuess[4] = "???";	//Gravitics
          valuess[5] = "???";	//Magnetics
          valuess[6] = "???";	//Mechanic
          valuess[7] = "???";	//Photonics
          valuess[8] = "???";	//Polymers
          valuess[9] = "???";	//Programmer
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="The Arts (6)">
      case "The Arts (6)": {
        keyss = new String[]{"Actor", "Artist", "Author", "Chef", "Dancer",
          "Musician"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Actor
        valuess[1] = "";	//Artist
        valuess[2] = "";	//Author
        valuess[3] = "";	//Chef
        valuess[4] = "";	//Dancer
        valuess[5] = "";	//Musician
        try {
          valuess[0] = "";	//Actor
          valuess[1] = "";	//Artist
          valuess[2] = "";	//Author
          valuess[3] = "";	//Chef
          valuess[4] = "";	//Dancer
          valuess[5] = "";	//Musician
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Actor
          valuess[1] = "???";	//Artist
          valuess[2] = "???";	//Author
          valuess[3] = "???";	//Chef
          valuess[4] = "???";	//Dancer
          valuess[5] = "???";	//Musician
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Soldier Skills (6)">
      case "Soldier Skills (6)": {
        keyss
          = new String[]{"Fighter", "Forward Obs", "Heavy Wpns", "Navigator",
            "Recon", "Sapper"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Fighter
        valuess[1] = "";	//Forward Obs
        valuess[2] = "";	//Heavy Wpns
        valuess[3] = "";	//Navigator
        valuess[4] = "";	//Recon
        valuess[5] = "";	//Sapper
        try {
          valuess[0] = "";	//Fighter
          valuess[1] = "";	//Forward Obs
          valuess[2] = "";	//Heavy Wpns
          valuess[3] = "";	//Navigator
          valuess[4] = "";	//Recon
          valuess[5] = "";	//Sapper
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Fighter
          valuess[1] = "???";	//Forward Obs
          valuess[2] = "???";	//Heavy Wpns
          valuess[3] = "???";	//Navigator
          valuess[4] = "???";	//Recon
          valuess[5] = "???";	//Sapper
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Default Skills">
      case "Default Skills": {
        keyss = new String[]{"Actor", "Artist", "Athlete", "Author", "Comms",
          "Computer", "Driver", "Fighter", "Turrets", "Mechanic", "Steward",
          "Vacc Suit"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Actor
        valuess[1] = "";	//Artist
        valuess[2] = "";	//Athlete
        valuess[3] = "";	//Author
        valuess[4] = "";	//Comms
        valuess[5] = "";	//Computer
        valuess[6] = "";	//Driver
        valuess[7] = "";	//Fighter
        valuess[8] = "";	//Turrets
        valuess[9] = "";	//Mechanic
        valuess[10] = "";	//Steward
        valuess[11] = "";	//Vacc Suit
        try {
          valuess[0] = "";	//Actor
          valuess[1] = "";	//Artist
          valuess[2] = "";	//Athlete
          valuess[3] = "";	//Author
          valuess[4] = "";	//Comms
          valuess[5] = "";	//Computer
          valuess[6] = "";	//Driver
          valuess[7] = "";	//Fighter
          valuess[8] = "";	//Turrets
          valuess[9] = "";	//Mechanic
          valuess[10] = "";	//Steward
          valuess[11] = "";	//Vacc Suit
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Actor
          valuess[1] = "???";	//Artist
          valuess[2] = "???";	//Athlete
          valuess[3] = "???";	//Author
          valuess[4] = "???";	//Comms
          valuess[5] = "???";	//Computer
          valuess[6] = "???";	//Driver
          valuess[7] = "???";	//Fighter
          valuess[8] = "???";	//Turrets
          valuess[9] = "???";	//Mechanic
          valuess[10] = "???";	//Steward
          valuess[11] = "???";	//Vacc Suit
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Talents (16)">
      case "Talents (16)": {
        keyss = new String[]{"Compute", "Empath", "Hibernate", "Hypno",
          "Intuition", "Math", "MemAware", "Memorize", "MemPercep", "MemScent",
          "MemSight", "MemSound", "Morph", "Rage", "SoundMimic"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Compute
        valuess[1] = "";	//Empath
        valuess[2] = "";	//Hibernate
        valuess[3] = "";	//Hypno
        valuess[4] = "";	//Intuition
        valuess[5] = "";	//Math
        valuess[6] = "";	//MemAware
        valuess[7] = "";	//Memorize
        valuess[8] = "";	//MemPercep
        valuess[9] = "";	//MemScent
        valuess[10] = "";	//MemSight
        valuess[11] = "";	//MemSound
        valuess[12] = "";	//Morph
        valuess[13] = "";	//Rage
        valuess[14] = "";	//SoundMimic
        try {
          valuess[0] = "";	//Compute
          valuess[1] = "";	//Empath
          valuess[2] = "";	//Hibernate
          valuess[3] = "";	//Hypno
          valuess[4] = "";	//Intuition
          valuess[5] = "";	//Math
          valuess[6] = "";	//MemAware
          valuess[7] = "";	//Memorize
          valuess[8] = "";	//MemPercep
          valuess[9] = "";	//MemScent
          valuess[10] = "";	//MemSight
          valuess[11] = "";	//MemSound
          valuess[12] = "";	//Morph
          valuess[13] = "";	//Rage
          valuess[14] = "";	//SoundMimic
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Compute
          valuess[1] = "???";	//Empath
          valuess[2] = "???";	//Hibernate
          valuess[3] = "???";	//Hypno
          valuess[4] = "???";	//Intuition
          valuess[5] = "???";	//Math
          valuess[6] = "???";	//MemAware
          valuess[7] = "???";	//Memorize
          valuess[8] = "???";	//MemPercep
          valuess[9] = "???";	//MemScent
          valuess[10] = "???";	//MemSight
          valuess[11] = "???";	//MemSound
          valuess[12] = "???";	//Morph
          valuess[13] = "???";	//Rage
          valuess[14] = "???";	//SoundMimic
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Personals (7)">
      case "Personals (7)": {
        keyss = new String[]{"Carouse", "Query", "Persuade", "Command",
          "Curiosity", "Insight", "Luck"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Carouse
        valuess[1] = "";	//Query
        valuess[2] = "";	//Persuade
        valuess[3] = "";	//Command
        valuess[4] = "";	//Curiosity
        valuess[5] = "";	//Insight
        valuess[6] = "";	//Luck
        try {
          valuess[0] = "";	//Carouse
          valuess[1] = "";	//Query
          valuess[2] = "";	//Persuade
          valuess[3] = "";	//Command
          valuess[4] = "";	//Curiosity
          valuess[5] = "";	//Insight
          valuess[6] = "";	//Luck
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Carouse
          valuess[1] = "???";	//Query
          valuess[2] = "???";	//Persuade
          valuess[3] = "???";	//Command
          valuess[4] = "???";	//Curiosity
          valuess[5] = "???";	//Insight
          valuess[6] = "???";	//Luck
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Animals">
      case "Animals": {
        keyss = new String[]{"Rider", "Teamster", "Trainer"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Rider
        valuess[1] = "";	//Teamster
        valuess[2] = "";	//Trainer
        try {
          valuess[0] = "";	//Rider
          valuess[1] = "";	//Teamster
          valuess[2] = "";	//Trainer
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Rider
          valuess[1] = "???";	//Teamster
          valuess[2] = "???";	//Trainer
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Driver">
      case "Driver": {
        keyss = new String[]{"ACV", "Automotive", "Grav", "Legged", "Mole",
          "Tracked", "Wheeled"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//ACV
        valuess[1] = "";	//Automotive
        valuess[2] = "";	//Grav
        valuess[3] = "";	//Legged
        valuess[4] = "";	//Mole
        valuess[5] = "";	//Tracked
        valuess[6] = "";	//Wheeled
        try {
          valuess[0] = "";	//ACV
          valuess[1] = "";	//Automotive
          valuess[2] = "";	//Grav
          valuess[3] = "";	//Legged
          valuess[4] = "";	//Mole
          valuess[5] = "";	//Tracked
          valuess[6] = "";	//Wheeled
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//ACV
          valuess[1] = "???";	//Automotive
          valuess[2] = "???";	//Grav
          valuess[3] = "???";	//Legged
          valuess[4] = "???";	//Mole
          valuess[5] = "???";	//Tracked
          valuess[6] = "???";	//Wheeled
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Engineer">
      case "Engineer": {
        keyss = new String[]{"Jump Drives", "Life Support", "Maneuver Drives",
          "Power Plants"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Jump Drives
        valuess[1] = "";	//Life Support
        valuess[2] = "";	//Maneuver Drives
        valuess[3] = "";	//Power Plants
        try {
          valuess[0] = "";	//Jump Drives
          valuess[1] = "";	//Life Support
          valuess[2] = "";	//Maneuver Drives
          valuess[3] = "";	//Power Plants
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Jump Drives
          valuess[1] = "???";	//Life Support
          valuess[2] = "???";	//Maneuver Drives
          valuess[3] = "???";	//Power Plants
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Fighter">
      case "Fighter": {
        keyss = new String[]{"Battle Dress", "Beams", "Blades", "Exotics",
          "Slug Throwers", "Sprays", "Unarmed"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Battle Dress
        valuess[1] = "";	//Beams
        valuess[2] = "";	//Blades
        valuess[3] = "";	//Exotics
        valuess[4] = "";	//Slug Throwers
        valuess[5] = "";	//Sprays
        valuess[6] = "";	//Unarmed
        try {
          valuess[0] = "";	//Battle Dress
          valuess[1] = "";	//Beams
          valuess[2] = "";	//Blades
          valuess[3] = "";	//Exotics
          valuess[4] = "";	//Slug Throwers
          valuess[5] = "";	//Sprays
          valuess[6] = "";	//Unarmed
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Battle Dress
          valuess[1] = "???";	//Beams
          valuess[2] = "???";	//Blades
          valuess[3] = "???";	//Exotics
          valuess[4] = "???";	//Slug Throwers
          valuess[5] = "???";	//Sprays
          valuess[6] = "???";	//Unarmed
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Flyer">
      case "Flyer": {
        keyss = new String[]{"Aeronautics", "Flapper", "Grav", "LTA", "Rotor",
          "Wing"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Aeronautics
        valuess[1] = "";	//Flapper
        valuess[2] = "";	//Grav
        valuess[3] = "";	//LTA
        valuess[4] = "";	//Rotor
        valuess[5] = "";	//Wing
        try {
          valuess[0] = "";	//Aeronautics
          valuess[1] = "";	//Flapper
          valuess[2] = "";	//Grav
          valuess[3] = "";	//LTA
          valuess[4] = "";	//Rotor
          valuess[5] = "";	//Wing
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Aeronautics
          valuess[1] = "???";	//Flapper
          valuess[2] = "???";	//Grav
          valuess[3] = "???";	//LTA
          valuess[4] = "???";	//Rotor
          valuess[5] = "???";	//Wing
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Gunner">
      case "Gunner": {
        keyss = new String[]{"Bay Weapons", "Ortillery", "Screens", "Spines",
          "Turrets", "Heavy Weapons", "Artillery", "Launcher", "Ordnance", "WMD",
          "Pilot", "Small Craft", "Spacecraft ACS", "Spacecraft BCS"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Bay Weapons
        valuess[1] = "";	//Ortillery
        valuess[2] = "";	//Screens
        valuess[3] = "";	//Spines
        valuess[4] = "";	//Turrets
        valuess[5] = "";	//Heavy Weapons
        valuess[6] = "";	//Artillery
        valuess[7] = "";	//Launcher
        valuess[8] = "";	//Ordnance
        valuess[9] = "";	//WMD
        valuess[10] = "";	//Pilot
        valuess[11] = "";	//Small Craft
        valuess[12] = "";	//Spacecraft ACS
        valuess[13] = "";	//Spacecraft BCS
        try {
          valuess[0] = "";	//Bay Weapons
          valuess[1] = "";	//Ortillery
          valuess[2] = "";	//Screens
          valuess[3] = "";	//Spines
          valuess[4] = "";	//Turrets
          valuess[5] = "";	//Heavy Weapons
          valuess[6] = "";	//Artillery
          valuess[7] = "";	//Launcher
          valuess[8] = "";	//Ordnance
          valuess[9] = "";	//WMD
          valuess[10] = "";	//Pilot
          valuess[11] = "";	//Small Craft
          valuess[12] = "";	//Spacecraft ACS
          valuess[13] = "";	//Spacecraft BCS
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Bay Weapons
          valuess[1] = "???";	//Ortillery
          valuess[2] = "???";	//Screens
          valuess[3] = "???";	//Spines
          valuess[4] = "???";	//Turrets
          valuess[5] = "???";	//Heavy Weapons
          valuess[6] = "???";	//Artillery
          valuess[7] = "???";	//Launcher
          valuess[8] = "???";	//Ordnance
          valuess[9] = "???";	//WMD
          valuess[10] = "???";	//Pilot
          valuess[11] = "???";	//Small Craft
          valuess[12] = "???";	//Spacecraft ACS
          valuess[13] = "???";	//Spacecraft BCS
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Seafarer">
      case "Seafarer": {
        keyss = new String[]{"Aquanautics", "Grav", "Boat", "Ship", "Sub"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Aquanautics
        valuess[1] = "";	//Grav
        valuess[2] = "";	//Boat
        valuess[3] = "";	//Ship
        valuess[4] = "";	//Sub
        try {
          valuess[0] = "";	//Aquanautics
          valuess[1] = "";	//Grav
          valuess[2] = "";	//Boat
          valuess[3] = "";	//Ship
          valuess[4] = "";	//Sub
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Aquanautics
          valuess[1] = "???";	//Grav
          valuess[2] = "???";	//Boat
          valuess[3] = "???";	//Ship
          valuess[4] = "???";	//Sub
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="The Sciences">
      case "The Sciences": {
        keyss = new String[]{"Archeology", "Biology", "Chemistry", "History",
          "Linguistics", "Philosophy", "Physics", "Planetology", "Psionicology",
          "Psychohistory", "Psychology", "Robotics", "Sophontology"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Archeology
        valuess[1] = "";	//Biology
        valuess[2] = "";	//Chemistry
        valuess[3] = "";	//History
        valuess[4] = "";	//Linguistics
        valuess[5] = "";	//Philosophy
        valuess[6] = "";	//Physics
        valuess[7] = "";	//Planetology
        valuess[8] = "";	//Psionicology
        valuess[9] = "";	//Psychohistory
        valuess[10] = "";	//Psychology
        valuess[11] = "";	//Robotics
        valuess[12] = "";	//Sophontology
        try {
          valuess[0] = "";	//Archeology
          valuess[1] = "";	//Biology
          valuess[2] = "";	//Chemistry
          valuess[3] = "";	//History
          valuess[4] = "";	//Linguistics
          valuess[5] = "";	//Philosophy
          valuess[6] = "";	//Physics
          valuess[7] = "";	//Planetology
          valuess[8] = "";	//Psionicology
          valuess[9] = "";	//Psychohistory
          valuess[10] = "";	//Psychology
          valuess[11] = "";	//Robotics
          valuess[12] = "";	//Sophontology
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Archeology
          valuess[1] = "???";	//Biology
          valuess[2] = "???";	//Chemistry
          valuess[3] = "???";	//History
          valuess[4] = "???";	//Linguistics
          valuess[5] = "???";	//Philosophy
          valuess[6] = "???";	//Physics
          valuess[7] = "???";	//Planetology
          valuess[8] = "???";	//Psionicology
          valuess[9] = "???";	//Psychohistory
          valuess[10] = "???";	//Psychology
          valuess[11] = "???";	//Robotics
          valuess[12] = "???";	//Sophontology
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Specialized">
      case "Specialized": {
        keyss = new String[]{"Career: Academia", "Career: Army", "Career: Navy",
          "Career: <Name>", "World: Capital", "World: Regina", "World: <Name>"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Career: Academia
        valuess[1] = "";	//Career: Army
        valuess[2] = "";	//Career: Navy
        valuess[3] = "";	//Career: <Name>
        valuess[4] = "";	//World: Capital
        valuess[5] = "";	//World: Regina
        valuess[6] = "";	//World: <Name>
        try {
          valuess[0] = "";	//Career: Academia
          valuess[1] = "";	//Career: Army
          valuess[2] = "";	//Career: Navy
          valuess[3] = "";	//Career: <Name>
          valuess[4] = "";	//World: Capital
          valuess[5] = "";	//World: Regina
          valuess[6] = "";	//World: <Name>
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Career: Academia
          valuess[1] = "???";	//Career: Army
          valuess[2] = "???";	//Career: Navy
          valuess[3] = "???";	//Career: <Name>
          valuess[4] = "???";	//World: Capital
          valuess[5] = "???";	//World: Regina
          valuess[6] = "???";	//World: <Name>
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Starport elements">
      case "Starport elements": {
        keyss = new String[]{"Beacon", "Land Pad and Runways", "Sensor Arrays",
          "Traffic Control facilities", "Auxilliary Traffic Control facilities"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Beacon
        valuess[1] = "";	//Land Pad and Runways
        valuess[2] = "";	//Sensor Arrays
        valuess[3] = "";	//Traffic Control facilities
        valuess[4] = "";	//Auxilliary Traffic Control facilities
        try {
          valuess[0] = "";	//Beacon
          valuess[1] = "";	//Land Pad and Runways
          valuess[2] = "";	//Sensor Arrays
          valuess[3] = "";	//Traffic Control facilities
          valuess[4] = "";	//Auxilliary Traffic Control facilities
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Beacon
          valuess[1] = "???";	//Land Pad and Runways
          valuess[2] = "???";	//Sensor Arrays
          valuess[3] = "???";	//Traffic Control facilities
          valuess[4] = "???";	//Auxilliary Traffic Control facilities
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Terminus">
      case "Terminus": {
        keyss = new String[]{"Concourses", "Freight Docks",
          "Customs & Immigration", "The Cargo Market", "Accomodations",
          "Data Terminals", "Message Center", "Emergency Medical"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Concourses
        valuess[1] = "";	//Freight Docks
        valuess[2] = "";	//Customs & Immigration
        valuess[3] = "";	//The Cargo Market
        valuess[4] = "";	//Accomodations
        valuess[5] = "";	//Data Terminals
        valuess[6] = "";	//Message Center
        valuess[7] = "";	//Emergency Medical
        try {
          valuess[0] = "";	//Concourses
          valuess[1] = "";	//Freight Docks
          valuess[2] = "";	//Customs & Immigration
          valuess[3] = "";	//The Cargo Market
          valuess[4] = "";	//Accomodations
          valuess[5] = "";	//Data Terminals
          valuess[6] = "";	//Message Center
          valuess[7] = "";	//Emergency Medical
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Concourses
          valuess[1] = "???";	//Freight Docks
          valuess[2] = "???";	//Customs & Immigration
          valuess[3] = "???";	//The Cargo Market
          valuess[4] = "???";	//Accomodations
          valuess[5] = "???";	//Data Terminals
          valuess[6] = "???";	//Message Center
          valuess[7] = "???";	//Emergency Medical
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Peripheral facilities">
      case "Peripheral facilities": {
        keyss = new String[]{"Starport Defence Establishment", "Scout Base",
          "Naval Base", "Consulates", "System Defence Field", "Shipyard",
          "Repair shops", "Transport hub", "Industry"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Starport Defence Establishment
        valuess[1] = "";	//Scout Base
        valuess[2] = "";	//Naval Base
        valuess[3] = "";	//Consulates
        valuess[4] = "";	//System Defence Field
        valuess[5] = "";	//Shipyard
        valuess[6] = "";	//Repair shops
        valuess[7] = "";	//Transport hub
        valuess[8] = "";	//Industry
        try {
          valuess[0] = "";	//Starport Defence Establishment
          valuess[1] = "";	//Scout Base
          valuess[2] = "";	//Naval Base
          valuess[3] = "";	//Consulates
          valuess[4] = "";	//System Defence Field
          valuess[5] = "";	//Shipyard
          valuess[6] = "";	//Repair shops
          valuess[7] = "";	//Transport hub
          valuess[8] = "";	//Industry
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Starport Defence Establishment
          valuess[1] = "???";	//Scout Base
          valuess[2] = "???";	//Naval Base
          valuess[3] = "???";	//Consulates
          valuess[4] = "???";	//System Defence Field
          valuess[5] = "???";	//Shipyard
          valuess[6] = "???";	//Repair shops
          valuess[7] = "???";	//Transport hub
          valuess[8] = "???";	//Industry
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Unofficial Facilities">
      case "Unofficial Facilities": {
        keyss = new String[]{"The Scout Lounge", "The Hiring Hall",
          "The Lone Star", "TAS", "Off-duty crew", "Startown"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//The Scout Lounge
        valuess[1] = "";	//The Hiring Hall
        valuess[2] = "";	//The Lone Star
        valuess[3] = "";	//TAS
        valuess[4] = "";	//Off-duty crew
        valuess[5] = "";	//Startown
        try {
          valuess[0] = "";	//The Scout Lounge
          valuess[1] = "";	//The Hiring Hall
          valuess[2] = "";	//The Lone Star
          valuess[3] = "";	//TAS
          valuess[4] = "";	//Off-duty crew
          valuess[5] = "";	//Startown
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//The Scout Lounge
          valuess[1] = "???";	//The Hiring Hall
          valuess[2] = "???";	//The Lone Star
          valuess[3] = "???";	//TAS
          valuess[4] = "???";	//Off-duty crew
          valuess[5] = "???";	//Startown
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Terrain Type">
      case "Terrain Type": {
        keyss = new String[]{"Resource", "Mountains", "Chasm", "Precipice",
          "Ruins", "Crater", "Desert", "Ocean", "Shore", "Islands", "Ice caps",
          "Ice fields", "Frozen lands", "Cropland", "Town", "City", "Domed",
          "Arcology", "Rural", "Starport", "Twilight Zone", "Baked Lands",
          "Penal", "Wasteland", "Exotic", "Clear"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Resource
        valuess[1] = "";	//Mountains
        valuess[2] = "";	//Chasm
        valuess[3] = "";	//Precipice
        valuess[4] = "";	//Ruins
        valuess[5] = "";	//Crater
        valuess[6] = "";	//Desert
        valuess[7] = "";	//Ocean
        valuess[8] = "";	//Shore
        valuess[9] = "";	//Islands
        valuess[10] = "";	//Ice caps
        valuess[11] = "";	//Ice fields
        valuess[12] = "";	//Frozen lands
        valuess[13] = "";	//Cropland
        valuess[14] = "";	//Town
        valuess[15] = "";	//City
        valuess[16] = "";	//Domed
        valuess[17] = "";	//Arcology
        valuess[18] = "";	//Rural
        valuess[19] = "";	//Starport
        valuess[20] = "";	//Twilight Zone
        valuess[21] = "";	//Baked Lands
        valuess[22] = "";	//Penal
        valuess[23] = "";	//Wasteland
        valuess[24] = "";	//Exotic
        valuess[25] = "";	//Clear
        try {
          valuess[0] = "";	//Resource
          valuess[1] = "";	//Mountains
          valuess[2] = "";	//Chasm
          valuess[3] = "";	//Precipice
          valuess[4] = "";	//Ruins
          valuess[5] = "";	//Crater
          valuess[6] = "";	//Desert
          valuess[7] = "";	//Ocean
          valuess[8] = "";	//Shore
          valuess[9] = "";	//Islands
          valuess[10] = "";	//Ice caps
          valuess[11] = "";	//Ice fields
          valuess[12] = "";	//Frozen lands
          valuess[13] = "";	//Cropland
          valuess[14] = "";	//Town
          valuess[15] = "";	//City
          valuess[16] = "";	//Domed
          valuess[17] = "";	//Arcology
          valuess[18] = "";	//Rural
          valuess[19] = "";	//Starport
          valuess[20] = "";	//Twilight Zone
          valuess[21] = "";	//Baked Lands
          valuess[22] = "";	//Penal
          valuess[23] = "";	//Wasteland
          valuess[24] = "";	//Exotic
          valuess[25] = "";	//Clear
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Resource
          valuess[1] = "???";	//Mountains
          valuess[2] = "???";	//Chasm
          valuess[3] = "???";	//Precipice
          valuess[4] = "???";	//Ruins
          valuess[5] = "???";	//Crater
          valuess[6] = "???";	//Desert
          valuess[7] = "???";	//Ocean
          valuess[8] = "???";	//Shore
          valuess[9] = "???";	//Islands
          valuess[10] = "???";	//Ice caps
          valuess[11] = "???";	//Ice fields
          valuess[12] = "???";	//Frozen lands
          valuess[13] = "???";	//Cropland
          valuess[14] = "???";	//Town
          valuess[15] = "???";	//City
          valuess[16] = "???";	//Domed
          valuess[17] = "???";	//Arcology
          valuess[18] = "???";	//Rural
          valuess[19] = "???";	//Starport
          valuess[20] = "???";	//Twilight Zone
          valuess[21] = "???";	//Baked Lands
          valuess[22] = "???";	//Penal
          valuess[23] = "???";	//Wasteland
          valuess[24] = "???";	//Exotic
          valuess[25] = "???";	//Clear
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="World Map Details">
      case "World Map Details": {
        keyss = new String[]{"Starport", "Size", "Atmosphere", "Hydrosphere",
          "Population", "Government", "Law Level", "Tech Level", "TCs", "L", "R",
          "I", "B", "HZ"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Starport
        valuess[1] = "";	//Size
        valuess[2] = "";	//Atmosphere
        valuess[3] = "";	//Hydrosphere
        valuess[4] = "";	//Population
        valuess[5] = "";	//Government
        valuess[6] = "";	//Law Level
        valuess[7] = "";	//Tech Level
        valuess[8] = "";	//TCs
        valuess[9] = "";	//L
        valuess[10] = "";	//R
        valuess[11] = "";	//I
        valuess[12] = "";	//B
        valuess[13] = "";	//HZ
        try {
          valuess[0] = "";	//Starport
          valuess[1] = "";	//Size
          valuess[2] = "";	//Atmosphere
          valuess[3] = "";	//Hydrosphere
          valuess[4] = "";	//Population
          valuess[5] = "";	//Government
          valuess[6] = "";	//Law Level
          valuess[7] = "";	//Tech Level
          valuess[8] = "";	//TCs
          valuess[9] = "";	//L
          valuess[10] = "";	//R
          valuess[11] = "";	//I
          valuess[12] = "";	//B
          valuess[13] = "";	//HZ
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Starport
          valuess[1] = "???";	//Size
          valuess[2] = "???";	//Atmosphere
          valuess[3] = "???";	//Hydrosphere
          valuess[4] = "???";	//Population
          valuess[5] = "???";	//Government
          valuess[6] = "???";	//Law Level
          valuess[7] = "???";	//Tech Level
          valuess[8] = "???";	//TCs
          valuess[9] = "???";	//L
          valuess[10] = "???";	//R
          valuess[11] = "???";	//I
          valuess[12] = "???";	//B
          valuess[13] = "???";	//HZ
        }
        break;
      }
//</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Terrain Symbols">
      case "Terrain Symbols": {
        keyss = new String[]{"Clear", "Marsh", "Rough", "Woods", "Swamp",
          "Rough Wood", "Mountain", "Desert", "Chasm", "Cropland", "Rural",
          "Ruins", "Ocean", "Islands", "Shore", "River", "Lake", "Ice cap",
          "Baked Lands", "Twilight", "Frozen Lands", "Ice Field", "Precipice",
          "Exotic", "City", "Dome", "Arcology", "Suburbs", "Town", "Starport",
          "Highway", "Road", "Trail", "Air Corridor", "Grid", "High Speed",
          "Ocean Depth", "Abyss", "Caverns", "Crater", "Wasteland", "Penal",
          "Volcano", "Estate", "Reserve", "Mine", "Resource", "Oil", "Airpad",
          "Vlite Airstrip", "Lite Airstrip", "Airport", "Heavy Airport",
          "Vheavy Airport"};
        valuess = new String[keyss.length];
        valuess[0] = "";	//Clear
        valuess[1] = "";	//Marsh
        valuess[2] = "";	//Rough
        valuess[3] = "";	//Woods
        valuess[4] = "";	//Swamp
        valuess[5] = "";	//Rough Wood
        valuess[6] = "";	//Mountain
        valuess[7] = "";	//Desert
        valuess[8] = "";	//Chasm
        valuess[9] = "";	//Cropland
        valuess[10] = "";	//Rural
        valuess[11] = "";	//Ruins
        valuess[12] = "";	//Ocean
        valuess[13] = "";	//Islands
        valuess[14] = "";	//Shore
        valuess[15] = "";	//River
        valuess[16] = "";	//Lake
        valuess[17] = "";	//Ice cap
        valuess[18] = "";	//Baked Lands
        valuess[19] = "";	//Twilight
        valuess[20] = "";	//Frozen Lands
        valuess[21] = "";	//Ice Field
        valuess[22] = "";	//Precipice
        valuess[23] = "";	//Exotic
        valuess[24] = "";	//City
        valuess[25] = "";	//Dome
        valuess[26] = "";	//Arcology
        valuess[27] = "";	//Suburbs
        valuess[28] = "";	//Town
        valuess[29] = "";	//Starport
        valuess[30] = "";	//Highway
        valuess[31] = "";	//Road
        valuess[32] = "";	//Trail
        valuess[33] = "";	//Air Corridor
        valuess[34] = "";	//Grid
        valuess[35] = "";	//High Speed
        valuess[36] = "";	//Ocean Depth
        valuess[37] = "";	//Abyss
        valuess[38] = "";	//Caverns
        valuess[39] = "";	//Crater
        valuess[40] = "";	//Wasteland
        valuess[41] = "";	//Penal
        valuess[42] = "";	//Volcano
        valuess[43] = "";	//Estate
        valuess[44] = "";	//Reserve
        valuess[45] = "";	//Mine
        valuess[46] = "";	//Resource
        valuess[47] = "";	//Oil
        valuess[48] = "";	//Airpad
        valuess[49] = "";	//Vlite Airstrip
        valuess[50] = "";	//Lite Airstrip
        valuess[51] = "";	//Airport
        valuess[52] = "";	//Heavy Airport
        valuess[53] = "";	//Vheavy Airport
        try {
          valuess[0] = "";	//Clear
          valuess[1] = "";	//Marsh
          valuess[2] = "";	//Rough
          valuess[3] = "";	//Woods
          valuess[4] = "";	//Swamp
          valuess[5] = "";	//Rough Wood
          valuess[6] = "";	//Mountain
          valuess[7] = "";	//Desert
          valuess[8] = "";	//Chasm
          valuess[9] = "";	//Cropland
          valuess[10] = "";	//Rural
          valuess[11] = "";	//Ruins
          valuess[12] = "";	//Ocean
          valuess[13] = "";	//Islands
          valuess[14] = "";	//Shore
          valuess[15] = "";	//River
          valuess[16] = "";	//Lake
          valuess[17] = "";	//Ice cap
          valuess[18] = "";	//Baked Lands
          valuess[19] = "";	//Twilight
          valuess[20] = "";	//Frozen Lands
          valuess[21] = "";	//Ice Field
          valuess[22] = "";	//Precipice
          valuess[23] = "";	//Exotic
          valuess[24] = "";	//City
          valuess[25] = "";	//Dome
          valuess[26] = "";	//Arcology
          valuess[27] = "";	//Suburbs
          valuess[28] = "";	//Town
          valuess[29] = "";	//Starport
          valuess[30] = "";	//Highway
          valuess[31] = "";	//Road
          valuess[32] = "";	//Trail
          valuess[33] = "";	//Air Corridor
          valuess[34] = "";	//Grid
          valuess[35] = "";	//High Speed
          valuess[36] = "";	//Ocean Depth
          valuess[37] = "";	//Abyss
          valuess[38] = "";	//Caverns
          valuess[39] = "";	//Crater
          valuess[40] = "";	//Wasteland
          valuess[41] = "";	//Penal
          valuess[42] = "";	//Volcano
          valuess[43] = "";	//Estate
          valuess[44] = "";	//Reserve
          valuess[45] = "";	//Mine
          valuess[46] = "";	//Resource
          valuess[47] = "";	//Oil
          valuess[48] = "";	//Airpad
          valuess[49] = "";	//Vlite Airstrip
          valuess[50] = "";	//Lite Airstrip
          valuess[51] = "";	//Airport
          valuess[52] = "";	//Heavy Airport
          valuess[53] = "";	//Vheavy Airport
        } catch (Exception e) {
          System.out.println(e.toString());
          valuess[0] = "???";	//Clear
          valuess[1] = "???";	//Marsh
          valuess[2] = "???";	//Rough
          valuess[3] = "???";	//Woods
          valuess[4] = "???";	//Swamp
          valuess[5] = "???";	//Rough Wood
          valuess[6] = "???";	//Mountain
          valuess[7] = "???";	//Desert
          valuess[8] = "???";	//Chasm
          valuess[9] = "???";	//Cropland
          valuess[10] = "???";	//Rural
          valuess[11] = "???";	//Ruins
          valuess[12] = "???";	//Ocean
          valuess[13] = "???";	//Islands
          valuess[14] = "???";	//Shore
          valuess[15] = "???";	//River
          valuess[16] = "???";	//Lake
          valuess[17] = "???";	//Ice cap
          valuess[18] = "???";	//Baked Lands
          valuess[19] = "???";	//Twilight
          valuess[20] = "???";	//Frozen Lands
          valuess[21] = "???";	//Ice Field
          valuess[22] = "???";	//Precipice
          valuess[23] = "???";	//Exotic
          valuess[24] = "???";	//City
          valuess[25] = "???";	//Dome
          valuess[26] = "???";	//Arcology
          valuess[27] = "???";	//Suburbs
          valuess[28] = "???";	//Town
          valuess[29] = "???";	//Starport
          valuess[30] = "???";	//Highway
          valuess[31] = "???";	//Road
          valuess[32] = "???";	//Trail
          valuess[33] = "???";	//Air Corridor
          valuess[34] = "???";	//Grid
          valuess[35] = "???";	//High Speed
          valuess[36] = "???";	//Ocean Depth
          valuess[37] = "???";	//Abyss
          valuess[38] = "???";	//Caverns
          valuess[39] = "???";	//Crater
          valuess[40] = "???";	//Wasteland
          valuess[41] = "???";	//Penal
          valuess[42] = "???";	//Volcano
          valuess[43] = "???";	//Estate
          valuess[44] = "???";	//Reserve
          valuess[45] = "???";	//Mine
          valuess[46] = "???";	//Resource
          valuess[47] = "???";	//Oil
          valuess[48] = "???";	//Airpad
          valuess[49] = "???";	//Vlite Airstrip
          valuess[50] = "???";	//Lite Airstrip
          valuess[51] = "???";	//Airport
          valuess[52] = "???";	//Heavy Airport
          valuess[53] = "???";	//Vheavy Airport
        }
        break;
      }
//</editor-fold>

      //</editor-fold>
    }
    ////////////////////////////////////////////////////////////////////////////
    // AUTO GENERATE SWITCH VALUES HERE
    //<editor-fold defaultstate="collapsed" desc="LAZILY!">
    String out = "";
    for (int i = 0; i < combobox.getItems().size(); i++) {
      String strungs = "";
      String string
        = "    //<editor-fold defaultstate=\"collapsed\" desc=\"" + combobox
        .getItems().get(i)
        .trim() + "\">";
      String start = string + CRLF + "case \"" + combobox.getItems().get(i)
        .trim() + "\": {" + CRLF;
      combobox.setValue(combobox.getItems().get(i).trim());
      String[] lined = textarea.getText().split(CRLF);
      strungs += "    keyss = new String[] {";
      for (int j = 0; j < lined.length; j++) {
        string
          = "\"      //<editor-fold defaultstate=" + FS + "\"collapsed" + FS
          + "\" desc=" + FS + "\""
          + combobox.getValue().toLowerCase() + "" + FS + "\">" + FS + "n\" + "
          + CRLF;
        string += "  " + "valuess[" + j + "] = \"\";";
        string += "  //" + lined[j].trim() + CRLF;
        strungs += "\"" + lined[j].trim() + "\"";
        if (j < lined.length - 1) {
          strungs += ",";
        }
      }
      string = start + strungs;
      string += "};" + CRLF;
      string += "valuess = new String[keyss.length];" + "" + CRLF;
      for (int j = 0; j < lined.length; j++) {
        string += "valuess[" + j + "] = \"\";\t//" + lined[j].trim()
          + CRLF;
      }

      string += "try {" + CRLF;
      for (int j = 0; j < lined.length; j++) {
        string += "valuess[" + j + "] = \"\";\t//" + lined[j].trim()
          + CRLF;
      }
      string += "} catch (Exception e) {" + CRLF;
      string += "System.out.println(e.toString());" + CRLF;
      for (int j = 0; j < lined.length; j++) {
        string += "valuess[" + j + "] = \"???\";\t//" + lined[j].trim()
          + CRLF;
      }
      string += "}" + CRLF;

      string += "break;" + CRLF + "}" + CRLF + "//</editor-fold>"
        + CRLF;
      out += string;
    }

    {
      String s = "";
      s += out + CRLF;
      JTextArea jta = new JTextArea(s, 50, 80);
      JScrollPane jsp = new JScrollPane(jta);
//      JOptionPane.showMessageDialog(null, jsp);
      d = T5;
      f = "SwitchValues";
      e = ".txt";
      GlobalMethods.saveTextFile(d, f, e, out);
    }
    //</editor-fold>
    ////////////////////////////////////////////////////////////////////////////
    for (int i = 0; i < valuess.length; i++) {
      System.out.println(keyss[i] + " = " + valuess[i]);
      fields[i].setText(valuess[i]);
    }
    combobox.setValue(value);
    ////////////////////////////////////////////////////////////////////////////
  }

  private void writePanels() {
    // Panels
    d = "C:" + FS + "T5" + FS + "TFX" + FS + "src" + FS + "panels" + FS;
    f = "Panels";
    e = ".java";
    File dir = new File(d);
    String[] files = dir.list();
    ArrayList<String> lista = new ArrayList<>();
    int errs = 0;
    int len = 0;
    for (int i = 0; i < files.length; i++) {
      if ((files[i].startsWith("Panel4")) & (files[i].endsWith(".java"))) {
        len = files[i].length() - 5;
        file = new File(d + files[i].substring(0, len) + e);
        lista.add(files[i].substring(0, len));
      }
    }
    System.out.println("Errs = " + errs);

    TextArea ta = new TextArea("");
    ta.appendText("String[] names = {");
    Object[] strings = lista.toArray();
    Object[][] stringss = new String[strings.length][];
    ta.appendText("};" + CRLF + CRLF);
    for (int i = 0; i < strings.length; i++) {
      ta.appendText("{\"" + strings[i] + "\",\"" + i + "\" }," + CRLF);
    }
    //<editor-fold defaultstate="collapsed" desc="JOP">
    {
      JTextArea jta = new JTextArea(ta.getText(), 50, 80);
      JScrollPane jsp = new JScrollPane(jta);
//      JOptionPane.showMessageDialog(null, jsp);
    }
    //</editor-fold>
    GlobalMethods.saveTextFile(d, f, ".txt", ta.getText());
  }
}
