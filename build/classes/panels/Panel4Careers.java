/*

 Copyright (C) 2014 Mark Ferguson



 This program is free software: you can redistribute it and/or modify

 it under the terms of the GNU General Public License as published by

 the Free Software Foundation, either version 3 of the License, or

 (at your option) any later version.



 This program is distributed in the hope that it will be useful,

 but WITHOUT ANY WARRANTY; without even the implied warranty of

 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the

 GNU General Public License for more details.



 You should have received a copy of the GNU General Public License

 along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */
package panels;

import dbviewer.CareerSelector;
import dbviewer.DBViewer;
import dbviewer.Debug;
import dbviewer.NameKeyPresser;
import dbviewer.NameMouseClicker;
import dbviewer.SaveOutputWindow;
import dbviewer.UXP;
import dbviewer.globals.GlobalMethods;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 <p>
 @author Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4Careers extends Panel4 {

  private static boolean cont = true;
  /**
   Generate Character
   */
  private static JPanel jp = null;
  /**
   Handy output window for debugging
   */
  public static SaveOutputWindow sow;
  /**
   JPanel containing Panel4LabelComboButton or Career sheet
   */
  public static Panel4LabelComboButton p4lcb;
  /**
   Choose career from here
   */
  public static JComboBox jbox;
  /**
   Career choice
   */
  public static JTextField jtf;
  /**
   UPP held here
   */
  public static final JTextField jtf2 = new JTextField(8);

  /**
   Creates new form Panel4Careers
   */
  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4Careers();
    jf = new Frame4(jp);
    jf.setBounds(200, 0, 450, 600);
  }

  /**
   Create new PC sheet
   */
  @SuppressWarnings("unchecked")
  public Panel4Careers() {
    super();
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
    //</editor-fold>
    initComponents();
//    AnyMenu.addMenuItem((JMenu) SaveAction);
    setLayout(new BorderLayout());
    jbox = new JComboBox();
    JPanel jp1 = new JPanel();
    for (int i = 0; i < 6; i++) {
      jbox.addItem(careers[i]);
    }
    jbox.addActionListener(new CareerSelector(this));
    jbox.addMouseListener(new NameMouseClicker(this));
    jp1.add(jbox);
    jtf = new JTextField(7);
    jtf.setToolTipText("Enter Name or Descriptor");
    jtf.setText("Unnamed");
    jtf.addKeyListener(new NameKeyPresser(this));
    //jtf.addActionListener(new ActionListenerImpl(this));
    jtf.addMouseListener(new NameMouseClicker(this));
    jp1.add(jtf, BorderLayout.NORTH);
    jtf2.setEditable(true);
//    jtf2.addMouseListener(new NameMouseClicker(this));
    jtf2.setText("" + UXP.getUpp());
    jtf2.addKeyListener(new NameKeyPresser(this));
    jp1.add(jtf2);
    final JComboBox<String> options = new JComboBox<>();
    p4lcb = new Panel4LabelComboButton(wid, hgt, name, rownames, null);
    AbstractAction aa = new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        //<editor-fold defaultstate="collapsed" desc="DEBUG">
        boolean DEBUG = false;
        if (DEBUG) { // true or false
          //System.out.print("\tAbstractAction " + Thread.currentThread().getStackTrace()[1].getMethodName());
          ////System.out.print("" + " = " + );
        }
        //</editor-fold>
        switch (options.getSelectedItem().toString()) {
          case "updateName":
            updateName();
            break;
          case "showRownames":
            showRowNames();
            break;
          case "Re-Roll":
            jtf2.setText("" + UXP.getUpp());
            updateName();
            break;
          case "Top%":
            jtf2.setText("" + UXP.bestOfMany(100));
            updateName();
            break;
        }

      }

      public void showComponents() {
        for (int i = 0; i
          < Panel4LabelComboButton.getJpan().getComponents().length; i++) {
          //Debug.debug("p4lcb.getComponent(" + i + ") = " + Panel4LabelComboButton.getJpan().getComponent(i).toString());
          Debug.debug("p4lcb.getComponent(" + i + ").getName() = "
            + Panel4LabelComboButton.getJpan().getComponent(i).getName()
            .toString());
        }
      }

      public void showRowNames() {
        for (int j = 0; j < rownames.length; j++) {
          Debug.debug("rownames[" + j + "] = " + rownames[j]);
        }
      }
    };
    options.addActionListener(aa);
    options.addItem("");
//    options.addItem("updateName");
//    options.addItem("showRownames");
    options.addItem("Re-Roll");
    options.addItem("Top%");
    options.setSelectedItem("");
    jp1.add(options, BorderLayout.NORTH);
    sex = new JCheckBox("Male");
    sex.setSelected(true);
    sex.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent arg0) {
        updateName();
      }
    });
    jp1.add(sex);

    add(jp1, BorderLayout.NORTH);
    JScrollPane jsp = new JScrollPane(p4lcb);
    add(jsp, BorderLayout.CENTER);
//    Panel4Careers.jf.setOpacity((float) 1.0);
    GlobalMethods.autoColor(this, Color.black, Color.LIGHT_GRAY);
    jbox.setSelectedIndex(0);
  }

  /**
   <p>
   @param career selected career
   */
  public Panel4Careers(String[] career) {
    this();
    String it = career[0];
    for (int i = 0; i < careers.length; i++) {
      if (it.toUpperCase().equals(careers[i].toUpperCase())) {
        Panel4Careers.Career = careers[i];
        jbox.setSelectedIndex(i);
      }
    }
    updateName();
  }

  /**
   Generate Character of specific Career by number
   <p>
   @param num number of item in JComboBox to select
   */
  public Panel4Careers(int num) {
    this();
    jbox.setSelectedIndex(num);
  }

  /**
   automate
   */
  public static void automate() {
    JButton jb;
    Debug.debug("p4lcb.jpan.getComponentCount() = "
      + Panel4LabelComboButton.jpan.getComponentCount());
    for (int i = 2; i < Panel4LabelComboButton.jpan.getComponentCount(); i += 3) {
      Debug.debug("i = " + i);
      jb = (JButton) Panel4LabelComboButton.jpan.getComponent(i);
      if (jb.isEnabled()) {
        jb.doClick();
        Debug.debug("clicked = " + i);
        break;
      }
    }
  }

  /**
   <p>
   @return text of SaveOutputWindow
   */
  public static String getSOWText() {
    return sow.getText();
  }

  /**
   <p>
   @return Name of character
   */
  public static String getPCName() {
    return (jtf.getText());
  }

  /**
   <p>
   @return Career
   */
  public static String getCareer() {
    return Career;
  }

  /**
   <p>
   @return title of character
   */
  public static String getTitle() {
    String title = "";
    String soc = jtf2.getText().substring(5, 6);
    if (sex.isSelected()) {
      switch (soc) {
        case "B":
          title = "Knight";
          break;
        case "C":
          title = "Baron";
          break;
        case "D":
          title = "Marquis";
          break;
        case "E":
          title = "Count";
          break;
        case "F":
          title = "Duke";
          break;
        default:
          title = "";
//          title = "Mister";
      }
    }
    if (!sex.isSelected()) {
      switch (soc) {
        case "B":
          title = "Knightess";
          break;
        case "C":
          title = "Baroness";
          break;
        case "D":
          title = "Marquesa";
          break;
        case "E":
          title = "Countess";
          break;
        case "F":
          title = "Duchess";
          break;
        default:
          title = "";
//          title = "Miss";
      }
    }
    //Debug.debug(" = " + soc);
    return title;
  }

  /**
   <p>
   @return rank
   */
  public static String getRank() {
    //String rank = "";
    //Debug.debug("Rank = " + Rank);
    if (!"".equals(Rank)) {
      switch (Career.toUpperCase()) {
        case "NAVY":
          Rank = "Starman ";
          break;
        case "MARINE":
          Rank = "Trooper ";
          break;
        case "ARMY":
          Rank = "Soldier ";
          break;
        case "SCOUT":
          Rank = "Scout ";
          break;
        case "MERCHANT":
          Rank = "Trader ";
          break;
        case "OTHER":
          Rank = "Traveller ";
          break;
      }
    }
    if (!"".equals(p4lcb.getSelectedItemFromCombo(34))) {
      Rank = p4lcb.getSelectedItemFromCombo(34);
    }
    return Rank;
  }

  /**
   <p>
   @return UPP of character
   */
  public static String getUPP() {
//    Debug.debug("UPP = " +jtf2.getText().substring(0, 6));
    return jtf2.getText().substring(0, 6);
  }

  /**
   <p>
   @return Career, Rank, Name and Stats
   */
  public static String updateName() {
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      //System.out.print("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
      ////System.out.print("" + " = " + );
    }
    //</editor-fold>
    String career = getCareer();
    String title = getTitle();
    String rank = getRank();
    String named = getPCName();
    String upp = getUPP();
    String updated = title + " " + career + " " + rank + " " + " " + named
      + " (" + upp + ")";
    DBViewer.setTitle(updated);
    //Frame4Careers.setTitle(updated);
    return updated;
  }

  /**
   <p>
   @return name of class
   */
  @Override
  public String toString() {
    return "" + getClass().getName() + "[]";
  }
  //<editor-fold defaultstate="collapsed" desc="PC Variables">
  /**
   Career
   */
  public static String Career;
  /**
   Careernum
   */
  public static int Careernum;
  /**
   Enlist
   */
  public static String Enlist;
  /**
   EnlistPlus
   */
  public static String EnlistPlus;
  /**
   EnlistPlusPlus
   */
  public static String EnlistPlusPlus;
  /**
   Draft
   */
  public static String Draft;
  /**
   Survival
   */
  public static String Survival;
  /**
   SurvivalPlusPlus
   */
  public static String SurvivalPlusPlus;
  /**
   Commission
   */
  public static String Commission;
  /**
   CommissionPlus
   */
  public static String CommissionPlus;
  /**
   Promotion
   */
  public static String Promotion;
  /**
   PromotionPlus
   */
  public static String PromotionPlus;
  /**
   Reenlist
   */
  public static String Reenlist;
  /**
   Term
   */
  public static String Term;
  /**
   Terms
   */
  public static String[] Terms;
  /**
   Rank
   */
  public static String Rank;
  /**
   Ranks
   */
  public static String[] Ranks;
  /**
   Muster
   */
  public static String Muster;
  /**
   Musters
   */
  public static String[] Musters;
  /**
   Cash
   */
  public static String Cash = "";
  /**
   Cashs
   */
  public static String[] Cashs;
  /**
   Personal
   */
  public static String Personal;
  /**
   Personals
   */
  public static String[] Personals;
  /**
   Service
   */
  public static String Service;
  /**
   Services
   */
  public static String[] Services;
  /**
   Education
   */
  public static String Education;
  /**
   Educations
   */
  public static String[] Educations;
  /**
   Advanced
   */
  public static String Advanced;
  /**
   Advanceds
   */
  public static String[] Advanceds;
  /**
   NAVY
   */
  public static final int NAVY = 0;
  /**
   MARINE
   */
  public static final int MARINE = 1;
  /**
   ARMY
   */
  public static final int ARMY = 2;
  /**
   SCOUT
   */
  public static final int SCOUT = 3;
  /**
   MERCHANT
   */
  public static final int MERCHANT = 4;
  /**
   OTHER
   */
  public static final int OTHER = 5;
  /**
   terms
   */
  public static int terms = 0;
  /**
   commissioned
   */
  public static int commissioned = 0;
  /**
   sex
   */
  public static JCheckBox sex = new JCheckBox();
  /**
   ranknum
   */
  public static int ranknum = 0;
  /**
   mustersgained
   */
  public static int mustersgained = 0;
  /**
   skillsgained
   */
  public static int skillsgained = 0;
  /**
   musterlist
   */
  public static ArrayList<String> musterlist = new ArrayList<>();
  /**
   skillslist
   */
  public static ArrayList<String> skillslist = new ArrayList<>();
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String Variables">
  /**
   titles
   */
  public static final String[] titles = {"Enlist", "Enlist DM+1",
    "Enlist DM+2", "Draft", "Survival", "Survival DM+2", "Commission",
    "Commission DM+1", "Promotion", "Promotion DM+1",
    "Reenlist", "Rank", "Muster", "Cash", "Personal", "Service", "Education",
    "Advanced"};
  /**
   rankservice
   */
  public static final String[][] rankservice = {
    {"Navy Captain", "+1 SOC"},
    {"Navy Admiral", "+1 SOC"},
    {"Marine", "Cutlass"},
    {"Marine Lietenant", "Revolver"},
    {"Army", "Rifle"},
    {"Army Lieutenant", "SMG"},
    {"Merchant 1st Officer", "Pilot"},
    {"Scout", "Pilot"}
  };
  /**
   careers
   */
  public static final String[] careers = {"Navy", "Marine", "Army", "Scout",
    "Merchant", "Other"};
  /**
   enlist
   */
  public static final String[] enlist = {"8", "9", "5", "7", "7", "3"};
  /**
   enlistplus
   */
  public static final String[] enlistplus = {"INT 8", "INT 8", "DEX 6", "INT 6",
    "STR 7", ""};
  /**
   enlistplusplus
   */
  public static final String[] enlistplusplus = {"EDU 9", "STR 8", "END 5",
    "STR 8", "INT 6", ""};
  /**
   draft
   */
  public static final String[] draft = {"1", "2", "3", "4", "5", "6"};
  /**
   survival
   */
  public static final String[] survival = {"5", "6", "5", "7", "5", "5"};
  /**
   survivalplusplus
   */
  public static final String[] survivalplusplus = {"INT 7", "END 8", "EDU 6",
    "END 9", "INT 7", "INT 9"};
  /**
   commission
   */
  public static final String[] commission = {"10", "9", "5", "", "4", ""};
  /**
   commissionplus
   */
  public static final String[] commissionplus = {"SOC 9", "EDU 7", "END 7", "",
    "INT 6", ""};
  /**
   promotion
   */
  public static final String[] promotion = {"8", "9", "6", "", "10", ""};
  /**
   promotionplus
   */
  public static final String[] promotionplus = {"EDU 8", "SOC 8", "EDU 7", "",
    "INT 9", ""};
  /**
   reenlist
   */
  public static final String[] reenlist = {"6", "6", "7", "3", "4", "5"};
  /**
   ranks
   */
  public static String[] ranks = {"", "", "", "", "", ""};
  /**
   musters
   */
  public static String[] musters = {"", "", "", "", "", ""};
  /**
   cashs
   */
  public static String[] cashs = {"", "", "", "", "", "", ""};
  /**
   personals
   */
  public static String[] personals = {"", "", "", "", "", ""};
  /**
   services
   */
  public static String[] services = {"", "", "", "", "", ""};
  /**
   educations
   */
  public static String[] educations = {"", "", "", "", "", ""};
  /**
   advanceds
   */
  public static String[] advanceds = {"", "", "", "", "", ""};
  /**
   norank
   */
  public static final String[] norank = {"", "", "", "", "", ""};
  /**
   navyrank
   */
  public static final String[] navyrank = {"Ensign", "Lieutenant", "Lt. Cmdr.",
    "Commander", "Captain", "Admiral"};
  /**
   marinerank
   */
  public static final String[] marinerank = {"Lieutenant", "Captain",
    "Force Cmdr.", "Lt. Colonel", "Colonel", "Brigadier"};
  /**
   armyrank
   */
  public static final String[] armyrank = {"Lieutenant", "Captain", "Major",
    "Lt. Colonel", "Colonel", "General"};
  /**
   merchantrank
   */
  public static final String[] merchantrank = {"4th Officer", "3rd Officer",
    "2nd Officer", "1st Officer", "Captain", "Captain"};
  /**
   navymuster
   */
  public static final String[] navymuster = {"Low passage", "+1 INT", "+2 EDU",
    "Blade", "TAS", "High passage", "+2 SOC"};
  /**
   marinemuster
   */
  public static final String[] marinemuster
    = {"Low passage", "+2 INT", "+1 EDU", "Blade", "TAS", "High passage",
      "+2 SOC"};
  /**
   armymuster
   */
  public static final String[] armymuster = {"Low passage", "+1 INT", "+2 EDU",
    "Gun", "High passage", "Mid passage", "+1 SOC"};
  /**
   scoutmuster
   */
  public static final String[] scoutmuster = {"Low passage", "+2 INT", "+2 EDI",
    "Blade", "Gun", "Scout ship", ""};
  /**
   merchantmuster
   */
  public static final String[] merchantmuster = {"Low passage", "+1 INT",
    "+1 EDU", "Gun", "Blade", "Low passage", "Free Trader"};
  /**
   othermuster
   */
  public static final String[] othermuster = {"Low passage", "+1 INT", "+1 EDU",
    "Gun", "High passage", "", ""};
  /**
   navycash
   */
  public static final String[] navycash = {"1 KCr", "5 KCr", "5 KCr", "10 KCr",
    "20 KCr", "50 KCr", "50 KCr"};
  /**
   marinecash
   */
  public static final String[] marinecash
    = {"2 KCr", "5 KCr", "5 KCr", "10 KCr", "20 KCr", "30 KCr", "40 KCr"};
  /**
   armycash
   */
  public static final String[] armycash = {"2 KCr", "5 KCr", "10 KCr", "10 KCr",
    "10 KCr", "20 KCr", "30 KCr"};
  /**
   scoutcash
   */
  public static final String[] scoutcash = {"20 KCr", "20 KCr", "30 KCr",
    "30 KCr", "50 KCr", "50 KCr", "50 KCr"};
  /**
   merchantcash
   */
  public static final String[] merchantcash = {"1 KCr", "5 KCr", "10 KCr",
    "20 KCr", "20 KCr", "40 KCr", "40 KCr"};
  /**
   othercash
   */
  public static final String[] othercash
    = {"1 KCr", "5 KCr", "10 KCr", "10 KCr", "10 KCr", "50 KCr", "100 KCr"};
  /**
   navypersonal
   */
  public static final String[] navypersonal = {"+1 STR", "+1 DEX", "+1 END",
    "+1 INT", "+1 EDU", "+1 SOC"};
  /**
   navyservice
   */
  public static final String[] navyservice = {"Ships Boat", "Vacc Suit",
    "Fwd. Obs.", "Gunnery", "Blade", "Gun"};
  /**
   navyeducation
   */
  public static final String[] navyeducation = {"Vacc Suit", "Mechanics",
    "Electronics", "Engineering", "Gunnery", "Jack Of All Trades"};
  /**
   navyadvanced
   */
  public static final String[] navyadvanced = {"Medical", "Navigation",
    "Engineering", "Computer", "Pilot", "Admin"};
  /**
   marinepersonal
   */
  public static final String[] marinepersonal = {"+1 STR", "+1 DEX", "+1 END",
    "Gambling", "Brawling", "Blade"};
  /**
   marineservice
   */
  public static final String[] marineservice = {"Vehicle", "Vacc Suit", "Blade",
    "Gun", "Blade", "Gun"};
  /**
   marineeducation
   */
  public static final String[] marineeducation = {"Vehicle", "Mechanics",
    "Electronics", "Tactics", "Blade", "Gun"};
  /**
   marineadvanced
   */
  public static final String[] marineadvanced
    = {"Medical", "Tactics", "Tactics", "Computer", "Leader", "Admin"};
  /**
   armypersonal
   */
  public static final String[] armypersonal = {"+1 STR", "+1 DEX", "+1 END",
    "Gambling", "EDU +1", "Brawling"};
  /**
   armyservice
   */
  public static final String[] armyservice = {"Vehicle", "Air/Raft", "Gun",
    "Fwd. Obs.", "Blade", "Gun"};
  /**
   armyeducation
   */
  public static final String[] armyeducation = {"Vehicle", "Mechanics",
    "Electronics", "Tactics", "Blade", "Gun"};
  /**
   armyadvanced
   */
  public static final String[] armyadvanced = {"Medical", "Tactics", "Tactics",
    "Computer", "Leader", "Admin"};
  /**
   scoutpersonal
   */
  public static final String[] scoutpersonal = {"+1 STR", "+1 DEX", "+1 END",
    "+1 INT", "+1 EDU", "Gun"};
  /**
   scoutservice
   */
  public static final String[] scoutservice = {"Vehicle", "Vacc Suit",
    "Mechanics", "Navigation", "Electronics", "Jack Of All Trades"};
  /**
   scouteducation
   */
  public static final String[] scouteducation = {"Vehicle", "Mechanics",
    "Electronics", "Jack Of All Trades", "Gunner", "Medical"};
  /**
   scoutadvanced
   */
  public static final String[] scoutadvanced = {"Medical", "Navigation",
    "Engineering", "Computer", "Pilot", "Jack Of All Trades"};
  /**
   merchantpersonal
   */
  public static final String[] merchantpersonal = {"+1 STR", "+1 DEX", "+1 END",
    "+1 STR", "Blade", "Bribery"};
  /**
   merchantservice
   */
  public static final String[] merchantservice = {"Vehicle", "Vacc Suit",
    "Jack Of All Trades", "Steward", "Electronics", "Gun"};
  /**
   merchanteducation
   */
  public static final String[] merchanteducation = {"Streetwise", "Mechanics",
    "Electronics", "Navigation", "Gunnery", "Medical"};
  /**
   merchantadvanced
   */
  public static final String[] merchantadvanced = {"Medical", "Navigation",
    "Engineering", "Computer", "Pilot", "Admin"};
  /**
   otherpersonal
   */
  public static final String[] otherpersonal = {"+1 STR", "+1 DEX", "+1 END",
    "Blade", "Brawling", "-1 SOC"};
  /**
   otherservice
   */
  public static final String[] otherservice
    = {"Vehicle", "Gambling", "Brawling", "Bribery", "Blade", "Gun"};
  /**
   othereducation
   */
  public static final String[] othereducation = {"Streetwise", "Mechanincs",
    "Electronics", "Gambling", "Brawling", "Forgery"};
  /**
   otheradvanced
   */
  public static final String[] otheradvanced = {"Medical", "Forgery",
    "Electronics", "Computer", "Streetwise", "Jack Of All Trades"};
  /**
   retirementpay
   */
  public String[][] retirementpay = {
    {"Terms", "KCr"},
    {"5", "4"},
    {"6", "6"},
    {"7", "8"},
    {"8", "10"}
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="Weapon Variables">
  /**
   Blades
   */
  public String[][] Blades = {
    {"Weapon", "+DM", "-DM", "DMG"},
    {"Dagger", "8", "3", "2"},
    {"Blade", "9", "4", "2"},
    {"Foil", "10", "4", "1"},
    {"Sword", "10", "5", "2"},
    {"Cutlass", "11", "7", "3"},
    {"Broadsword", "12", "7", "4"},
    {"Bayonet", "9", "4", "3"}
  };
  /**
   Polearms
   */
  public String[][] Polearms = {
    {"Weapon", "+DM", "-DM", "DMG"},
    {"Spear", "9", "4", "2"},
    {"Halberd", "10", "5", "3"},
    {"Pike", "10", "6", "3"},
    {"Cudgel", "8", "4", "2"}
  };
  /**
   Guns
   */
  public String[][] Guns = {
    {"Weapon", "+DM", "-DM", "DMG"},
    {"Body Pistol", "11", "7", "2"},
    {"Auto Pistol", "10", "6", "3"},
    {"Revolver", "9", "6", "3"}
  };
  /**
   Rifles
   */
  public String[][] Rifles = {
    {"Weapon", "+DM", "-DM", "DMG"},
    {"Carbine", "9", "4", "3"},
    {"Rifle", "8", "5", "3"},
    {"Auto Rifle", "10", "6", "3"},
    {"Shotgun", "9", "3", "4"},
    {"SMG", "9", "6", "3"},
    {"Laser Carbine", "10", "5", "4"},
    {"Laser Rifle", "11", "6", "5"}
  };
  /**
   skills
   */
  public String[] skills = {"SKILL",
    "Admin", "Air/Raft", "ATV", "Bribery", "Computer", "Electronics",
    "Engineering",
    "Forgery", "Fwd. Obs.", "Gambling", "Gunnery", "Jack Of All Trades",
    "Leader",
    "Mechanics", "Medical", "Navigation", "Pilot", "Ships Boat", "Steward",
    "Streetwise", "Tactics", "Vehicle", "Vacc Suit"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="Frame Variables">
  /**
   wid
   */
  public static final int wid = 400;
  /**
   hgt
   */
  public static final int hgt = 700;
  /**
   name
   */
  public static final String name = "PCSheet";
  /**
   enab
   */
  public static final Boolean[] enab = {false};
  /**
   rownames
   */
  public static final String[] rownames = titles;
  /**
   CRLF
   */
  public static String CRLF = System.lineSeparator();
  /**
   jf
   */
  public static JFrame jf;
//</editor-fold>

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 300, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
