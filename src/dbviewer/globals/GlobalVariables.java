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
package dbviewer.globals;

import dbviewer.StarGen;
import java.awt.Color;
import java.io.File;
import javax.swing.JComboBox;

/**

 @author maggot.iiss
 */
public class GlobalVariables {

  /**
   setup of ComboBoxes
   */
  public static Boolean VARCOMBO = false;
  /**
   * / or \
   */
  public static final String FS = File.separator;
  /**
   Carriage Return and Line Feed
   */
  public static final String CRLF = System.lineSeparator();
  /**
   Home drive for old cyberboard
   */
  public static final String DRIVE = "D:";
  /**
   Home directory for Cyberboard
   */
  public static final String CB = DRIVE + FS + FS + "Cyberboard";
  /**
   Home directory for T5
   */
  public static final String T5 = "C:" + FS + FS + "T5";
  /**
   Home directory for old Cyberboard config files
   */
  public static final String _CFG = T5 + FS + "_CFG";
  /**
   directory for *.gif files
   */
  public static final String _GIF = T5 + FS + "_GIF";
  /**
   directory for *.sec files from http://www.travellermap.com
   */
  public static final String _SEC = T5 + FS + "_SEC";
  /**

   */
  public static final String T5C = "C:\\T5\\_CFG\\T5\\T5C";
  /**

   */
  public static final String _JS = T5 + FS + "_JS";
  /**
   Comma Seperated Values "a","b","c"
   */
  public static final String CSV = T5 + FS + "_CSV";
  /**
   BitMaP files in cyberboard
   */
  public static final String BMP = CB + FS + "BMP";
  /**
   Army
   */
  public static final String ARM = BMP + FS + "Arm";
  /**
   Index cards
   */
  public static final String CARDS = BMP + FS + "Cards";
  /**
   Hardware
   */
  public static final String HAR = BMP + FS + "Har";
  /**
   Imperium
   */
  public static final String IMP = BMP + FS + "Imp";
  /**
   Marine
   */
  public static final String MAR = BMP + FS + "Mar";
  /**
   Merchant
   */
  public static final String MER = BMP + FS + "Mer";
  /**
   Navy
   */
  public static final String NAV = BMP + FS + "Nav";
  /**
   Other
   */
  public static final String OTH = BMP + FS + "Oth";
  /**
   Scout
   */
  public static final String SCO = BMP + FS + "Sco";
  /**
   SkyRig
   */
  public static final String SKY = BMP + FS + "Sky";
  /**
   Spinward Marches Fifth Frontier War
   */
  public static final String SM5FW = CB + FS + "SM5FW";
  /**
   Solomani Rim Invasion Earth
   */
  public static final String SRIE = CB + FS + "SRIE";
  /**
   Temp folder
   */
  public static final String TMP = CB + FS + "TMP";
  /**
   Home for all source code
   */
//  public static final String SRC = CB + FS + "T5app" + FS + "src";
  public static final String SRC = "C:/T5/TFX/src";
  /**
   forms NOT USED
   */
  public static final String JTForms = SRC + FS + "dbviewer/forms";
  /**
   JPanels home for panels
   */
  public static final String JTPanels = SRC + FS + "panels";
  /**
   GlobalVariables
   */
  public static final String JTGlobals = SRC + FS + "globals";

  /**

   */
  public static final String JTOld = SRC + FS + "old";
  /**

   */
  public static final String JTPractice = SRC + FS + "practice";
  /**

   */
  public static final String JTResources = SRC + FS + "resources";
  /**

   */
  public static final String CJ21 = SRC + FS + "cj21";
  /**

   */
  public static final String JAVA = "C:/Program Files/Java/jdk1.7.0_05";
  /**

   */
  public static final String DBV = CB + FS + "DBV";
  /**

   */
//  public static final String SRC = DBV + FS + "src";
  /**
   Where we put files to read into the computer for conversion
   */
  public static final String IMPORTS = SRC + FS + "Imports";
  /**
   MS-DOS batch files
   */
  public static String BAT = CB + FS + "BAT";
  /**
   TAB
   */
  public static String TAB = "\t";
  /**
   Spinward Marches sector
   */
  public static String SPIN = IMP + FS + "SPIN";
  /**
   Spinward Marches sector
   */
  public static String REGINA = IMP + FS + "SPIN" + FS + "C - Regina";
  /**
   System selected
   */
  public static final String Regina = REGINA + FS + "1910-Regina";

  /**
   choices in combo box
   */
  public static JComboBox jcb4choice = null;
  /**
   sides in combo box
   */
  public static JComboBox jcb4side = null;
  /**
   Imperium in combo box
   */
  public static JComboBox jcb4imp = null;
  /**
   TAS zones
   */
  public static JComboBox jcb4TAS = null;
  /**
   Sec, Sub, Sys
   */
  public static JComboBox jcb4SSS = null;
  /**
   Atmosphere types for 5FW counters
   */
  public static JComboBox jcb4Atmo = null;
  /**
   Squadron types
   */
  public static JComboBox jcb4Ron = null;
  /**
   Gas Giants
   */
  public static JComboBox jcb4GG = null;
  /**
   StarPort
   */
  public static JComboBox jcb4SP = null;
  /**
   Size0
   */
  public static JComboBox jcb4Size = null;
  /**
   Atmosphere
   */
  public static JComboBox jcb4Atmos = null;
  /**
   Hydrosphere
   */
  public static JComboBox jcb4Hydros = null;
  /**
   Population
   */
  public static JComboBox jcb4Pop = null;
  /**
   Government
   */
  public static JComboBox jcb4Govt = null;
  /**
   Law Level
   */
  public static JComboBox jcb4LL = null;
  /**
   Tech Level
   */
  public static JComboBox jcb4TL = null;
  /**
   Hex location
   */
  public static JComboBox jcb4Hex = null;
  /**
   Career background
   */
  public static final Color[] serviceBack = new Color[]{
    Color.black,//space
    Color.cyan,//air
    Color.green,//land
    Color.red,//Scout
    Color.blue,//sea
    Color.gray//under
  };
  /**
   Career foreground
   */
  public static final Color[] serviceFore = new Color[]{
    Color.gray,//space
    Color.black,//air
    Color.darkGray,//land
    Color.white,//Scout
    Color.white,//sea
    Color.black//under
  };
  /**
   Service colours
   */
  public static final Color[][] service = new Color[][]{
    {serviceBack[0], serviceFore[0]}, //Navy
    {serviceBack[1], serviceFore[1]}, //Marine
    {serviceBack[2], serviceFore[2]}, //Army
    {serviceBack[3], serviceFore[3]}, //Scout
    {serviceBack[4], serviceFore[4]}, //Other
    {serviceBack[5], serviceFore[5]} //Merchant
  };
  //<editor-fold defaultstate="collapsed" desc="TechLevelModifiers">
  /**
   TechLevelModifiers
   */
  public static final String[] TechLevelModifiers = {
    "2",
    "TL", "Modifier",
    "7", "-2",
    "8", "-2",
    "9", "-2",
    "A", "-1",
    "B", "-1",
    "C", "0",
    "D", "0",
    "E", "+1",
    "F", "+2"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="ResourcesInfrastructureCultureRatings">
  /**
   ResourcesInfrastructureCultureRatings
   */
  public static final String[] ResourcesInfrastructureCultureRatings = {
    "2",
    "Rating", "Modifier",
    "0", "-3",
    "1", "-3",
    "2", "-3",
    "3", "-2",
    "4", "-2",
    "5", "-2",
    "6", "-1",
    "7", "-1",
    "8", "-1",
    "9", "0",
    "A", "0",
    "B", "0",
    "C", "+1",
    "D", "+1",
    "E", "+1",
    "F", "+2"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="SDBSquadrons">
  /**
   SDBSquadrons
   */
  public static final String[] SDBSquadrons = {
    "5",
    "TL/Pop", "7", "8", "9", "A",
    "7", "1", "5", "50", "500",
    "8", "1", "5", "50", "500",
    "9", "1", "10", "100", "1000",
    "A", "1", "10", "100", "1000",
    "B", "1", "12", "120", "1200",
    "C", "1", "12", "120", "1200",
    "D", "1", "15", "150", "1500",
    "E", "1", "15", "150", "1500",
    "F", "1", "20", "200", "2000"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="StreamlineValue">
  /**
   StreamlineValue
   */
  public static final String[] StreamlineValue = {
    "2",
    "Type", "Value",
    "Unstreamlined", "0",
    "Partially streamlined", "-1",
    "Streamlined", "-2"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="BaseJumpRating">
  /**
   BaseJumpRating
   */
  public static final String[] BaseJumpRating = {
    "3",
    "TL", "Max Jump", "Base Jump",
    "9", "1", "1",
    "A", "1", "1",
    "B", "2", "1",
    "C", "3", "1",
    "D", "4", "2",
    "E", "5", "3",
    "F", "6", "BR=3,OTHERS=4"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="BaseSquadronCost">
  /**
   BaseSquadronCost
   */
  public static final String[] BaseSquadronCost = {
    "2",
    "Type", "Value",
    "BR", "2",
    "CR", "1",
    "AR", "2",
    "TR", "3",
    "SR", "0.5"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="StreamlineCostMultiplier">
  /**
   StreamlineCostMultiplier
   */
  public static final String[] StreamlineCostMultiplier = {
    "2",
    "Type", "Multiplier",
    "BR", "2",
    "CR", "1",
    "AR", "1",
    "TR", "1",
    "SR", "0.5"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="MaxStarshipSquadrons">
  /**
   MaxStarshipSquadrons
   */
  public static final String[] MaxStarshipSquadrons = {
    "8",
    "Squadrons/TL", "9", "A", "B", "C", "D", "E", "F",
    "10", "1", "1", "1", "1", "1", "1", "1",
    "12", "1", "1", "1", "1", "1", "2", "2",
    "15", "1", "1", "1", "2", "2", "2", "2",
    "20", "1", "1", "2", "2", "2", "2", "2",
    "50", "1", "2", "2", "2", "2", "2", "2",
    "100", "2", "2", "2", "2", "2", "2", "2",
    "120", "2", "2", "2", "2", "2", "3", "3",
    "150", "2", "2", "2", "3", "3", "3", "3",
    "200", "2", "2", "3", "3", "3", "3", "3",
    "500", "2", "3", "3", "3", "3", "4", "4",
    "1000", "3", "3", "3", "4", "4", "4", "4",
    "1200", "3", "3", "4", "4", "4", "5", "5",
    "1500", "3", "3", "4", "4", "5", "5", "5",
    "2000", "3", "3", "4", "4", "5", "5", "6",};
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="DefenceBattalionsCombatFactor">
  /**
   DefenceBattalionsCombatFactor
   */
  public static final String[] DefenceBattalionsCombatFactor = {
    "6",
    "TL/Pop", "6", "7", "8", "9", "A",
    "6", "1", "2", "20", "200", "2000",
    "7", "1", "5", "50", "500", "5000",
    "8", "1", "5", "50", "500", "5000",
    "9", "1", "10", "100", "1000", "10000",
    "A", "1", "10", "100", "1000", "10000",
    "B", "2", "12", "120", "1200", "12000",
    "C", "2", "12", "120", "1200", "12000",
    "D", "2", "15", "150", "1500", "15000",
    "E", "2", "15", "150", "1500", "15000",
    "F", "2", "20", "200", "2000", "20000"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="CombatFactorCapacity">
  /**
   CombatFactorCapacity
   */
  public static final String[] CombatFactorCapacity = {
    "2",
    "Squadron", "CF Capacity",
    "AR", "600",
    "CR", "20",
    "CR", "DF of Squadron",
    "SR", "0",
    "TR", "0"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="InitialProduction">
  /**
   InitialProduction
   */
  public static final String[] InitialProduction = {
    "5",
    "TL/Pop", "7", "8", "9", "A",
    "7", "1", "5", "20", "100",
    "8", "1", "5", "20", "100",
    "9", "1", "5", "20", "100",
    "A", "1", "5", "20", "100",
    "B", "2", "10", "50", "500",
    "C", "2", "10", "50", "500",
    "D", "5", "20", "100", "1000",
    "E", "5", "20", "100", "1000",
    "F", "10", "50", "500", "2000"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="TroopUnitCost">
  /**
   TroopUnitCost
   */
  public static final String[] TroopUnitCost = {
    "2",
    "Unit Type", "Production Points per CF",
    "Foot Infantry", "1",
    "Horse Cavalry", "1",
    "Armoured Infantry", "2",
    "Armoured Cavalry", "2",
    "Elite Foot Infantry", "2",
    "Elite Horse Cavalry", "2",
    "Elite Armoured Infantry", "4",
    "Elite Armoured Cavalry", "4",
    "Jump Troops", "2",
    "Marines", "2"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="TroopUnitSize">
  /**
   TroopUnitSize
   */
  public static final String[] TroopUnitSize = {
    "2",
    "SIZE", "CF",
    "Company", "1",
    "Battalion", "2",
    "Regiment", "5",
    "Brigade", "10",
    "Division", "20",
    "Corps", "50",
    "Army", "100",
    "Army Group", "500"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="PlanningFactor">
  /**
   PlanningFactor
   */
  public static final String[] PlanningFactor = {
    "2",
    "2D", "PF",
    "2", "0",
    "3", "2",
    "4", "3",
    "5", "4",
    "6", "5",
    "7", "5",
    "8", "5",
    "9", "4",
    "10", "3",
    "11", "2",
    "12", "1"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="TacticalFactor">
  /**
   TacticalFactor
   */
  public static final String[] TacticalFactor = {
    "2",
    "1D", "TF",
    "1", "-2",
    "2", "-1",
    "3", "0",
    "4", "0",
    "5", "1",
    "6", "2"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="RepairPoints">
  /**
   RepairPoints
   */
  public static final String[] RepairPoints = {
    "5",
    "Pop", "Res0-3", "Res4-7", "Res8-B", "ResC-F",
    "7", "0.25", "0.33", "0.40", "0.50",
    "8", "0.33", "0.40", "0.50", "0.67",
    "9", "0.40", "0.50", "0.67", "0.80",
    "A", "0.50", "0.67", "0.80", "1.00"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="AdmiralsInCombat">
  /**
   AdmiralsInCombat
   */
  public static final String[] AdmiralsInCombat = {
    "2",
    "1D", "Result",
    "1", "Battlefield promotion",
    "2", "Critical battle",
    "3", "No effect",
    "4", "No effect",
    "5", "Wounded",
    "6", "KIA"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="PreparednessLevel">
  /**
   PreparednessLevel
   */
  public static final String[] PreparednessLevel = {
    "2",
    "1D", "PL",
    "1", "0-Total Demobilisation",
    "2", "1-Partial Demobilisation",
    "3", "2-Limited Mobilisation",
    "4", "3-Moderate Mobilisation",
    "5", "4-High Mobilisation",
    "6", "5-Full Mobilisation"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="ReinforcementLevel">
  /**
   ReinforcementLevel
   */
  public static final String[] ReinforcementLevel = {
    "2",
    "1D", "RL",
    "1", "0",
    "2", "1",
    "3", "2",
    "4", "3",
    "5", "4",
    "6", "5"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="ReinforcementLevelOne">
  /**
   ReinforcementLevelOne
   */
  public static final String[] ReinforcementLevelOne = {
    "12",
    "ML", "1", "11", "21", "31", "41", "51", "61", "71", "81", "91", "101",
    "0", "0", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10",
    "1", "10", "10", "10", "10", "10", "10", "10", "10", "10", "10", "",
    "2", "20", "10", "10", "10", "10", "10", "10", "10", "10", "", "",
    "3", "30", "10", "10", "10", "10", "10", "10", "10", "", "", "",
    "4", "40", "10", "10", "10", "10", "10", "10", "", "", "", "",
    "5", "50", "10", "10", "10", "10", "10", "", "", "", "", "",
    "6", "60", "10", "10", "10", "10", "", "", "", "", "", "",
    "7", "70", "10", "10", "10", "", "", "", "", "", "", "",
    "8", "80", "10", "10", "", "", "", "", "", "", "", "",
    "9", "90", "10", "", "", "", "", "", "", "", "", "",
    "A", "100", "", "", "", "", "", "", "", "", "", ""
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="ReinforcementLevelTwo">
  /**
   ReinforcementLevelTwo
   */
  public static final String[] ReinforcementLevelTwo = {
    "7",
    "ML", "1", "11", "21", "31", "41", "51",
    "0", "0", "20", "20", "20", "20", "20",
    "1", "10", "20", "20", "20", "20", "10",
    "2", "20", "20", "20", "20", "20", "",
    "3", "30", "20", "20", "20", "10", "",
    "4", "40", "20", "20", "20", "", "",
    "5", "50", "20", "20", "10", "", "",
    "6", "60", "20", "20", "", "", "",
    "7", "70", "20", "10", "", "", "",
    "8", "80", "20", "", "", "", "",
    "9", "90", "10", "", "", "", "",
    "A", "100", "", "", "", "", ""
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="ReinforcementLevelThree">
  /**
   ReinforcementLevelThree
   */
  public static final String[] ReinforcementLevelThree = {
    "6",
    "ML", "1", "11", "21", "31", "41",
    "0", "0", "30", "30", "30", "10",
    "1", "10", "30", "30", "30", "",
    "2", "20", "30", "30", "20", "",
    "3", "30", "30", "30", "10", "",
    "4", "40", "30", "30", "", "",
    "5", "50", "30", "20", "", "",
    "6", "60", "30", "10", "", "",
    "7", "70", "30", "", "", "",
    "8", "80", "20", "", "", "",
    "9", "90", "10", "", "", "",
    "A", "100", "", "", "", ""
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="RequiredRefuellingTimes">
  /**
   RequiredRefuellingTimes
   */
  public static final String[] RequiredRefuellingTimes = {
    "4",
    "Source", "PSL", "SL", "USL",
    "Gas Giant", "0", "0", "1",
    "Ocean", "0", "1", "1",
    "Starport", "*", "*", "*",
    "Base", "0", "0", "0"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="StarportRefuellingTable">
  /**
   StarportRefuellingTable
   */
  public static final String[] StarportRefuellingTable = {
    "2",
    "Port", "Description",
    "A", "4",
    "B", "3",
    "C", "2",
    "D", "1",
    "E", "0"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="SpaceCombatResultsTable">
  /**
   SpaceCombatResultsTable
   */
  public static final String[] SpaceCombatResultsTable = {
    "11",
    "1D", "AF1", "AF3", "AF6", "AF12", "AF18", "AF24", "AF30", "AF36", "AF42",
    "AF48",
    "1", "-", "-", "-", "2", "3", "6", "8", "10", "12", "14",
    "2", "-", "-", "-", "4", "6", "8", "10", "12", "14", "16",
    "3", "-", "-", "2", "4", "8", "10", "12", "14", "16", "18",
    "4", "-", "2", "4", "6", "8", "10", "12", "14", "16", "18",
    "5", "-", "2", "4", "6", "10", "12", "14", "16", "18", "20",
    "6", "2", "4", "6", "8", "12", "14", "16", "18", "20", "22"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="SDBVsSquadronTable">
  /**
   SDBVsSquadronTable
   */
  public static final String[] SDBVsSquadronTable = {
    "11",
    "Roll", "10", "30", "60", "120", "180", "240", "300", "360", "420", "480",
    "-2", "-", "-", "-", "-", "-", "-", "2", "4", "6", "8",
    "-1", "-", "-", "-", "-", "-", "2", "4", "6", "8", "10",
    "0", "-", "-", "-", "-", "2", "4", "6", "8", "10", "12",
    "1", "-", "-", "-", "2", "4", "6", "8", "10", "12", "14",
    "2", "-", "-", "2", "4", "6", "8", "10", "12", "14", "16",
    "3", "-", "2", "4", "6", "8", "10", "12", "14", "16", "18",
    "4", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20",
    "5", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22",
    "6", "6", "8", "10", "12", "14", "16", "18", "20", "22", "24",
    "7", "8", "10", "12", "14", "16", "18", "20", "22", "24", "26",
    "8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="SquadronVsSDBTable">
  /**
   SquadronVsSDBTable
   */
  public static final String[] SquadronVsSDBTable = {
    "11",
    "SDBs", "BF1", "BF3", "BF6", "BF12", "BF18", "BF24", "BF30", "BF36", "BF42",
    "BF48",
    "1", "80", "90", "d", "d", "d", "d", "d", "d", "d", "d",
    "2", "70", "80", "90", "d", "d", "d", "d", "d", "d", "d",
    "5", "60", "70", "80", "90", "d", "d", "d", "d", "d", "d",
    "10", "50", "60", "70", "80", "90", "d", "d", "d", "d", "d",
    "12", "40", "50", "60", "70", "80", "90", "d", "d", "d", "d",
    "15", "30", "40", "50", "60", "70", "80", "90", "d", "d", "d",
    "20", "20", "30", "40", "50", "60", "70", "80", "90", "d", "d",
    "50", "10", "20", "30", "40", "50", "60", "70", "80", "90", "d",
    "100", "-", "10", "20", "30", "40", "50", "60", "70", "80", "90",
    "120", "-", "-", "10", "20", "30", "40", "50", "60", "70", "80",
    "150", "-", "-", "-", "10", "20", "30", "40", "50", "60", "70",
    "200", "-", "-", "-", "-", "10", "20", "30", "40", "50", "60",
    "500", "-", "-", "-", "-", "-", "10", "20", "30", "40", "50",
    "1000", "-", "-", "-", "-", "-", "-", "10", "20", "30", "40",
    "1200", "-", "-", "-", "-", "-", "-", "-", "10", "20", "30",
    "1500", "-", "-", "-", "-", "-", "-", "-", "-", "10", "20",
    "2000", "-", "-", "-", "-", "-", "-", "-", "-", "-", "10",
    "5000", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="TLCombatModifiers">
  /**
   TLCombatModifiers
   */
  public static final String[] TLCombatModifiers = {
    "2",
    "TL", "Modifier",
    "15", "+2",
    "14", "+1",
    "13", "+1",
    "12", "0",
    "11", "-1",
    "10", "-2",
    "9", "-2",
    "8", "-3"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="AtmosphereModifiers">
  /**
   AtmosphereModifiers
   */
  public static final String[] AtmosphereModifiers = {
    "2",
    "Code", "Modifier",
    "0", "-2",
    "1", "-2",
    "2", "-1",
    "3", "-1",
    "4", "-1",
    "5", "0",
    "6", "0",
    "7", "-1",
    "8", "0",
    "9", "-1",
    "A", "-1",
    "B", "-1",
    "C", "-1",
    "D", "-1",
    "E", "-1",
    "F", "-1"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="SurfaceBombingTable">
  /**
   SurfaceBombingTable
   */
  public static final String[] SurfaceBombingTable = {
    "11",
    "Roll", "BF1", "BF3", "BF6", "BF12", "BF18", "BF24", "BF30", "BF36", "BF42",
    "BF48",
    "-2", "20", "30", "30", "40", "40", "50", "50", "50", "50", "50",
    "-1", "20", "20", "30", "30", "40", "40", "50", "50", "50", "50",
    "0", "10", "20", "20", "30", "30", "40", "40", "50", "50", "50",
    "1", "10", "10", "20", "20", "30", "30", "40", "40", "50", "50",
    "2", "-", "10", "10", "20", "20", "30", "30", "40", "40", "50",
    "3", "-", "-", "10", "10", "20", "20", "30", "30", "40", "40",
    "4", "-", "-", "-", "10", "10", "20", "20", "30", "30", "40",
    "5", "-", "-", "-", "-", "10", "10", "20", "20", "30", "30",
    "6", "-", "-", "-", "-", "-", "10", "10", "20", "20", "30",
    "7", "-", "-", "-", "-", "-", "-", "10", "10", "20", "20",
    "8", "-", "-", "-", "-", "-", "-", "-", "10", "10", "20"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="PercentageLossTable">
  /**
   PercentageLossTable
   */
  public static final String[] PercentageLossTable = {
    "10",
    "Full", "90", "80", "70", "60", "50", "40", "30", "20", "10",
    "1", "0", "0", "0", "0", "1", "1", "1", "1", "1",
    "2", "0", "0", "1", "1", "1", "1", "1", "2", "2",
    "3", "0", "1", "1", "1", "2", "2", "2", "2", "3",
    "4", "0", "1", "1", "2", "2", "2", "3", "3", "4",
    "5", "1", "1", "2", "2", "3", "3", "4", "4", "5",
    "10", "1", "2", "3", "4", "5", "6", "7", "8", "9",
    "12", "1", "2", "4", "5", "6", "7", "8", "10", "11",
    "15", "2", "3", "5", "6", "8", "9", "11", "12", "14",
    "20", "2", "4", "6", "8", "10", "12", "14", "16", "18",
    "30", "3", "6", "9", "12", "15", "18", "21", "24", "27",
    "40", "4", "8", "12", "16", "20", "24", "28", "32", "36",
    "50", "5", "10", "15", "20", "25", "30", "35", "40", "45",
    "100", "10", "20", "30", "40", "50", "60", "70", "80", "90",
    "120", "12", "24", "36", "48", "60", "72", "84", "96", "108",
    "150", "15", "30", "45", "60", "75", "90", "105", "120", "135",
    "200", "20", "40", "60", "80", "100", "120", "140", "160", "180",
    "300", "30", "60", "90", "120", "150", "180", "210", "240", "270",
    "400", "40", "80", "120", "160", "200", "240", "280", "320", "360",
    "500", "50", "100", "150", "200", "250", "300", "500", "400", "450",
    "1000", "100", "200", "300", "400", "500", "600", "700", "800", "900",
    "1200", "120", "240", "360", "480", "600", "720", "840", "960", "1080",
    "1500", "150", "300", "450", "600", "750", "900", "1050", "1200", "1500",
    "2000", "200", "400", "600", "800", "1000", "1200", "1400", "1600", "1800",
    "3000", "300", "600", "900", "1200", "1500", "1800", "2100", "2400", "2700",
    "4000", "400", "800", "1200", "1600", "2000", "2400", "2800", "3200", "3600",
    "5000", "500", "1000", "1500", "2000", "2500", "3000", "5000", "4000",
    "4500",
    "20000", "2000", "4000", "6000", "8000", "10000", "12000", "14000", "16000",
    "18000",
    "150000", "15000", "30000", "45000", "60000", "75000", "90000", "105000",
    "120000", "150000",};
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="TroopCombatResultsTable">
  /**
   TroopCombatResultsTable
   */
  public static final String[] TroopCombatResultsTable = {
    "14",
    "Roll", "1:100", "1:10", "1:5", "1:3", "1:2", "1:1.5", "1:1", "1.5:1", "2:1",
    "3:1", "5:1", "10:1", "100:1",
    "2", "-", "10", "10", "20", "30", "40", "50", "60", "70", "90", "d", "d",
    "d",
    "3", "-", "-", "10", "10", "20", "30", "40", "50", "60", "80", "90", "d",
    "d",
    "4", "-", "-", "-", "10", "10", "20", "30", "40", "50", "70", "90", "d", "d",
    "5", "-", "-", "-", "-", "10", "10", "20", "30", "40", "60", "90", "d", "d",
    "6", "-", "-", "-", "-", "-", "10", "10", "20", "30", "50", "80", "d", "d",
    "7", "-", "-", "-", "-", "-", "-", "10", "10", "20", "40", "70", "90", "d",
    "8", "-", "-", "-", "-", "-", "-", "-", "10", "10", "30", "60", "80", "d",
    "9", "-", "-", "-", "-", "-", "-", "-", "-", "10", "20", "50", "70", "d",
    "10", "-", "-", "-", "-", "-", "-", "-", "-", "-", "10", "40", "60", "d",
    "11", "-", "-", "-", "-", "-", "-", "-", "-", "-", "10", "30", "50", "90",
    "12", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "20", "40", "80"
  };
  //</editor-fold>
  //------------------
  //<editor-fold defaultstate="collapsed" desc="tables">
  /**
   tables used by StarGen
   */
  public static final String[][] tables = {
    TechLevelModifiers, ResourcesInfrastructureCultureRatings,
    SDBSquadrons, StreamlineValue,
    BaseJumpRating, BaseSquadronCost,
    StreamlineCostMultiplier, MaxStarshipSquadrons,
    DefenceBattalionsCombatFactor, CombatFactorCapacity,
    InitialProduction, TroopUnitCost,
    TroopUnitSize, PlanningFactor,
    TacticalFactor, RepairPoints,
    AdmiralsInCombat, PreparednessLevel,
    ReinforcementLevel, ReinforcementLevelOne,
    ReinforcementLevelTwo, ReinforcementLevelThree,
    RequiredRefuellingTimes, StarportRefuellingTable,
    SpaceCombatResultsTable, SDBVsSquadronTable,
    SquadronVsSDBTable, TLCombatModifiers,
    AtmosphereModifiers, SurfaceBombingTable,
    PercentageLossTable, TroopCombatResultsTable
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="tablenames">
  /**
   names of tables used by StarGen
   */
  public static final String[] tablenames = {
    "Tech Level Modifiers", "Resources Infrastructure Culture Ratings",
    "SDB Squadrons", "Streamline Value",
    "Base Jump Rating", "Base Squadron Cost",
    "Streamline Cost Multiplier", "Max Starship Squadrons",
    "Defence Battalions Combat Factor", "Combat Factor Capacity",
    "Initial Production", "Troop Unit Cost",
    "Troop Unit Size", "Planning Factor",
    "Tactical Factor", "Repair Points",
    "Admirals In Combat", "Preparedness Level",
    "Reinforcement Level", "Reinforcement Level 1",
    "Reinforcement Level 2", "Reinforcement Level 3",
    "Required Refuelling Times", "Starport Refuelling Table",
    "Space Combat Results Table", "SDB Vs Squadron Table",
    "Squadron Vs SDB Table", "TL Combat Modifiers",
    "Atmosphere Modifiers", "Surface Bombing Table",
    "Percentage Loss Table", "Troop Combat Results Table"
  };
  //</editor-fold>
  //Mainworlds
  //<editor-fold defaultstate="collapsed" desc="Mainworlds">
  private static String mainworldsize = null;
  private static String mainworldatmo = null;
  private static String mainworldhydro = null;
  private static String mainworldpop = null;
  private static String mainworldgovt = null;
  private static String mainworldlaw = null;
  private static String mainworldtl = null;
//  private static String[] MainworldContents = new String[5];
//  private static String[] mainworldcontentsvarnames = new String[]{
//    "mainworldsize", "mainworldatmo", "mainworldhydro", "mainworldpop",
//    "mainworldgovt"
//  };
  private static int iTL;
  private static int roll, sp, si, at, hy, po, go;
  private static int[] iTLMods = {roll, sp, si, at, hy, po, go};
  private static String[] sTLModNames = {
    "1d6", "Starport", "Size", "Atmoshpere", "Hydrosphere", "Population",
    "Government"
  };
  //</editor-fold>
  //System
  //<editor-fold defaultstate="collapsed" desc="System Features">
  /**
   Starport
   */
  public static String starport = null;
  /**
   navy base used by StarGen
   */
  public static String navalbase = null;
  /**
   scout base used by StarGen
   */
  public static String scoutbase = null;
  /**
   gasgiant used by StarGen
   */
  public static String gasgiant = null;
  /**
   planetoids used by StarGen
   */
  public static String planetoids = null;
  /**
   used by StarGen
   */
  public static String[] SystemContents = new String[5];
  /**
   used by StarGen
   */
  public static String[] systemcontentvarnames = new String[]{
    "starport", "navalbase", "scoutbase",
    "gasgiant", "planetoids"
  };
  /**
   used by StarGen
   */
  public static String nature = null;
  /**
   used by StarGen
   */
  public static String primarytype = null;
  /**
   used by StarGen
   */
  public static String primarysize = null;
  /**
   used by StarGen
   */
  public static String primaryorbit = null;
  /**
   used by StarGen
   */
  public static String primaryorbits = null;
  /**
   used by StarGen
   */
  public static String secondarytype = null;
  /**
   used by StarGen
   */
  public static String secondarysize = null;
  /**
   used by StarGen
   */
  public static String secondaryorbit = null;
  /**
   used by StarGen
   */
  public static String secondaryorbits = null;
  /**
   used by StarGen
   */
  public static String tertiarytype = null;
  /**
   used by StarGen
   */
  public static String tertiarysize = null;
  /**
   used by StarGen
   */
  public static String tertiaryorbit = null;
  /**
   used by StarGen
   */
  public static String tertiaryorbits;
  /**
   used by StarGen
   */
  public static String systemfeaturemaxorbits = null;
  /**
   used by StarGen
   */
  public static String gasgiantpresence = gasgiant;
  /**
   used by StarGen
   */
  public static String gasgiantquantity = null;
  /**
   used by StarGen
   */
  public static String planetoidpresence = planetoids;
  /**
   used by StarGen
   */
  public static String planetoidquantity = null;
  /**
   used by StarGen
   */
  public static String[] SystemFeature;
  /**
   used by StarGen
   */
  public static String[] systemfeaturevarnames = new String[]{
    "systemfeaturenature",
    "systemfeatureprimarytype", "systemfeatureprimarysize",
    "systemfeatureprimaryorbit",
    "systemfeaturesecondarytype", "systemfeaturesecondarysize",
    "systemfeaturesecondaryorbit",
    "systemfeaturetertiarytype", "systemfeaturetertiarysize",
    "systemfeaturetertiaryorbit",
    "systemfeaturemaxorbits", "systemfeaturegasgiantpresence",
    "systemfeaturegasgiantquantity", "systemfeatureplanetoidpresence",
    "systemfeatureplanetoidquantity",
    "systemfeatureprimaryorbits", "systemfeaturesecondaryorbits",
    "systemfeaturetertiaryorbits",
    "mainworldsize", "mainworldatmo", "mainworldhydro",
    "mainworldpop", "mainworldgovt", "mainworldlaw", "mainworldtl",
    "Orbits[0]", "Orbits[1]", "Orbits[2]"
  };
  //</editor-fold>
  //Planets
  //<editor-fold defaultstate="collapsed" desc="Planetary orbit">
  /**
   used by StarGen
   */
  public static String planetaryorbitnumtitle = "Orbit";
  /**
   used by StarGen
   */
  public static String planetaryorbitnumautitle = "r(AU)";
  /**
   used by StarGen
   */
  public static String planetaryorbitnummkmtitle = "r(MKm)";
  /**
   used by StarGen
   */
  public static String[] planetaryorbitnum = new String[16];
  /**
   used by StarGen
   */
  public static String[] planetaryorbitnummkm = new String[16];
  /**
   used by StarGen
   */
  public static String[] planetaryorbitnumau = new String[16];
  private static String[] PlanetaryOrbit = new String[3];
  private static String[] planetaryorbitvarnames = new String[]{
    "planetaryorbitnum", "planetaryorbitnummkm",
    "planetaryorbitnumau"
  };

  /**
   used by StarGen
   */
  public static String[] satelliteorbitnum;
  /**
   used by StarGen
   */
  public static String[] satelliteorbitring;
  /**
   used by StarGen
   */
  public static String[] satelliteorbitclose;
  /**
   used by StarGen
   */
  public static String[] satelliteorbitfar;
  /**
   used by StarGen
   */
  public static String[] satelliteorbitextreme;
  //</editor-fold>
  /**
   used by StarGen
   */
  //<editor-fold defaultstate="collapsed" desc="svarnames">
  public static String[] svarnames = new String[]{
    "starport", "navalbase", "scoutbase", "gasgiant", "nature",
    "primarytype", "primarysize", "primaryorbit", "primaryorbits",
    "secondarytype", "secondarysize", "secondaryorbit", "secondaryorbits",
    "tertiarytype", "tertiarysize", "tertiaryorbit", "tertiaryorbits",
    "gasgiant", "gasgiantpresence", "gasgiantquantity",
    "planetoids", "planetoidpresence", "planetoidquantity",
    "primaryorbits", "secondaryorbits", "tertiaryorbits",
    "mainworldsize", "mainworldatmo", "mainworldhydro",
    "mainworldpop", "mainworldgovt", "mainworldlaw", "mainworldtl",
    "1d6",
    "Starport", "Size", "Atmosphere", "Hydrosphere", "Population", "Government",
    "Primary Orbits", "Secondary Orbits", "Tertiary Orbits"
  };
  //</editor-fold>
  //Stellar details
  //<editor-fold defaultstate="collapsed" desc="Stellar details">
  /**
   table (CT)
   */
  public static String[] supergiants;
  /**
   table (CT)
   */
  public static String[] weakersupergiants;
  /**
   table (CT)
   */
  public static String[] brightgiants;
  /**
   table (CT)
   */
  public static String[] giants;
  /**
   table (CT)
   */
  public static String[] subgiants;
  /**
   table (CT)
   */
  public static String[] mainsequence;
  /**
   table (CT)
   */
  public static String[] subdwarfs;
  /**
   table (CT)
   */
  public static String[] whitedwarfs;
  /**
   table (CT)
   */
  public static String starcolumns;
  /**
   table (CT)
   */
  public static String startable;
  /**
   table (CT)
   */
  public static String[] star = {
    "Primary",
    "Secondary",
    "Tertiary"
  };
  /**
   table (CT)
   */
  public static String[] startables = {
    "Ia - Bright Super Giant",
    "Ib - Weaker Super Giant",
    "II - Bright Giant",
    "III - Giant",
    "IV - Sub Giant",
    "V - Main Sequence",
    "VI - Sub Dwarf",
    "D - White Dwarf"
  };
  /**
   NOT USED
   */
  public static int ADD = 0;
  //</editor-fold>
  //Mainworlds
  private static String Starport = "";
  //<editor-fold defaultstate="collapsed" desc="Starport">
  private static String[] StarportValues = {
    "A-Excellent quality with refined fuel,overhaul and shipyards",
    "B-Good quality with refined fuel, overhaul, shipyards for non starships",
    "C-Routine quality with unrefined fuel, some repair facilities",
    "D-Poor quality with unrefined fuel, no repair facilities",
    "E-Frontier installation, no facilities",
    "X-No Starport.  Generally Red travel zone"
  };
  private static String[] SpaceportValues = {
    "F-Good quality with unrefined fuel, minor repair facilities",
    "G-Poor quality with unrefined fuel, no repair facilities",
    "H-Primitive installation, no facilities",
    "Y-No spaceport"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="Size0">
  private static String Size0 = "";
  private static String[] SizeValues = {
    "0-Asteroid/Planetoid belt",
    "R-Ring (around a world)",
    "S-Small World - 2d6 x 100km",
    "1-1000 miles (1600km)",
    "2-2000 miles (3200km)",
    "3-3000 miles (4800km)",
    "4-4000 miles (6400km)",
    "5-5000 miles (8000km)",
    "6-6000 miles (9600km)",
    "7-7000 miles (11200km)",
    "8-8000 miles (12800km)",
    "9-9000 miles (14400km)",
    "A-10000 miles (16000km)"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="Atmosphere">
  private static String Atmosphere = "";
  private static String[] AtmosphereValues = {
    "0-No Atmosphere",
    "1-Trace",
    "2-Very thin, tainted",
    "3-Very thin",
    "4-Thin, tainted",
    "5-Thin",
    "6-Standard",
    "7-Standard, tainted",
    "8-Dense",
    "9-Dense, tainted",
    "A-Exotic",
    "B-Corrosive",
    "C-Insidious",
    "D-Dense, high",
    "E-Ellipsoid",
    "F-Thin, low"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="Hydrosphere">
  private static String Hydrosphere = "";
  private static String[] HydrosphereValues = {
    "0-No free standing water",
    "1-10% water",
    "2-20% water",
    "3-30% water",
    "4-40% water",
    "5-50% water",
    "6-60% water",
    "7-70% water",
    "8-80% water",
    "9-90% water",
    "A-100% water"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="Population">
  private static String Population = "";
  private static String[] PopulationValues = {
    "0-Single digit",
    "1-Tens",
    "2-Hundreds",
    "3-Thousands",
    "4-Tens of thousands",
    "5-Hundreds of thousands",
    "6-Millions",
    "7-Tens of millions",
    "8-Hundreds of millions",
    "9-Billions",
    "A-Tens of billions"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="Government">
  private static String Government = "";
  private static String[] GovernmentValues = {
    "0-No governmental structure.  "
    + "In many cases, family bonds predominate",
    "1-Company/Corporation.  "
    + "Government by a company managerial elite; citizens are "
    + "company employees",
    "2-Participating Democracy.  "
    + "Government by advice and consent of the citizens",
    "3-Self Perpetuating Oligarchy.  "
    + "Rule by a restricted minority, with little or no input from "
    + "the masses",
    "4-Representative Democracy.  "
    + "Rule by elected representatives",
    "5-Feudal Technocracy.  "
    + "Government by specific individuals for those who agree to be ruled.  "
    + "Relationships are based on the performance of technical activities "
    + "which are mutually beneficial",
    "6-Captive Government.  "
    + "Government by a leadership answerable to an outside group; "
    + "a colony or conquered group",
    "7-Balkanization.  "
    + "No central ruling authority exists; rival governments compete for"
    + "control",
    "8-Civil Service Bureaucracy.  "
    + "Government by agencies employing individuals selected for "
    + "their expertise",
    "9-Impersonal Bureaucracy.  "
    + "Government by agencies which are insulated from the governed",
    "A-Charismatic Dictator.  "
    + "Government by a single enjoying the confidence of the citizends",
    "B-Non Charismatic Leader.  "
    + "A previous charismatic dictator has been replaced by a leader "
    + "through normal channels",
    "C-Charismatic Oligarchy.  "
    + "Government by a select group, organization, or class enjoying "
    + "the overwhelming confidence of the citizenry",
    "D-Religious Dictatorship.  "
    + "Government by a religious organization "
    + "without regard to the needs of the citizenry"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="LawLevel">
  private static String LawLevel = "";
  private static String[] LawLevelValues = {
    "0-No prohibitions",
    "1-Body Pistols undetectable by standard detectors, "
    + "explosives (bombs, grenades), and poison gas prohibited",
    "2-Portable Energy Weapons (laser carbine, laser rifle) prohibited.  "
    + "Ships gunnery not affected",
    "3-Weapons of a strictly military nature "
    + "(machine guns, automatic rifles) prohibited",
    "4-Light assault weapons (sub-machine guns) prohibited",
    "5-Personal concealable firearms (pistols, revolvers) prohibited",
    "6-Most firearms (all except shotguns) prohibited.  "
    + "The carrying of any weapon is openly discouraged.",
    "7-Shotguns are prohibited",
    "8-Long bladed weapons (all but daggers) are controlled, and open"
    + "posession is prohibited",
    "9-Posession on any weapon outside one`s residence is prohibited",
    "A-Weapon posession is prohibited"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="TechLevel">
  private static String TechLevel = "";
  private static String[] TechLevelValues = {
    "0-Stone Age.  primitive",
    "1-Bronze Age - Middle Ages",
    "2-1400-1700",
    "3-1700-1860",
    "4-1860-1900",
    "5-1900-1939",
    "6-1940-1969",
    "7-1970-1979",
    "8-1980-1989",
    "9-1990-2000",
    "A-Interstellar community",
    "B-Average Imperial",
    "C-Average Imperial",
    "D-Above average Imperial",
    "E-Above average Imperial",
    "F-Technical maximum Imperial",
    "G-Above Imperial",
    "H-Over",
    "I-Grandfathers great grandchildren",
    "J-Grandfathers grandchildren",
    "K-Grandfathers children",
    "J-Grandfather",};
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="TravelZone">
  private static String TravelZone = "";
  private static String[] TravelZoneValues = {
    "Green - No particular danger or problem for travellers",
    "Amber - Caution advised for travellers, local conditions may pose some danger",
    "Red - Prohibited for travellers, local conditions can involve death or injury"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="TradeClass">
  private static String TradeClass = "";
  private static String[] TradeClassValues = {
    "Agricultural - Atmo 4-9, Hydro 4-8, Pop 5-7",
    "Non Agricultural - Atmo 3-, Hydro 3-, Pop 6+",
    "Industrial - Atmo 0 1 2 4 7 9 (vacuum, trace or tainted), Pop 9+",
    "Non Industrial - Pop 6-",
    "Rich - Atmo 6 8, Pop 6-8, Govt 4-9",
    "Poor - Atmo 2-5, Hydro 3-",
    "Water World - Hyro A",
    "Desert World - Hyro 0, Atmo 2+",
    "Vacuum World - Atmo 0",
    "Asteroid Belt - MainWorld Size 0 ",
    "Ice Capped - Atmo 0-1, Hydro 1+",
    "SubSector Capital",
    "Sector Capital"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="Bases">
  private static String Bases = "";
  private static String[] BasesValues = {
    "Naval Base - Port facility for the support and maintenance of naval vessels.  "
    + "Includes administrative sections, and some security personnel",
    "Scout Base - Port facility for support of scout vessels.  "
    + "Provides fuel and maintenance to detached duty scouts",
    "Naval Depot - Major naval support and training facility.  "
    + "Generally occupies an entire star system, displacing other "
    + "development of its worlds.  No more than 1 Depot per sector",
    "Way station - Large scout base involved in repair and maintenance for "
    + "ships in an xboat system.  Must be situated on an expressboat route"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="Facilities">
  private static String Facilities = "";
  private static String[] FacilitiesValues = {
    "Farming",
    "Mining",
    "Colony",
    "Research laboratory",
    "Military base"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="worlddatanames">
  private static String[] worlddatanames = new String[]{
    "Starport",
    "Size", "Atmosphere", "Hydrosphere",
    "Population", "Government", "LawLevel",
    "TechLevel"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="worlddata">
  private static String[] worlddata = new String[]{
    Starport,
    Size0, Atmosphere, Hydrosphere,
    Population, Government, LawLevel,
    TechLevel
  };
  //<editor-fold defaultstate="collapsed" desc="Star detail tables">
  /**
   columns in table
   */
  public static int supergiantscols;
  /**
   columns in table
   */
  public static int weakersupergiantscols;
  /**
   columns in table
   */
  public static int brightgiantscols;
  /**
   columns in table
   */
  public static int giantscols;
  /**
   columns in table
   */
  public static int subgiantscols;
  /**
   columns in table
   */
  public static int mainsequencecols;
  /**
   columns in table
   */
  public static int subdwarfscols;
  /**
   columns in table
   */
  public static int whitedwarfscols;

  /**
   table (CT)
   */
  public static String[] HabZones = new String[]{"12",
    "Size", "A0", "A4", "A9", "F2", "F7", "G2", "G9", "K4", "K9", "M4", "M9",
    "Ia", "12", "12", "12", "12", "11", "12", "12", "12", "12", "12", "12",
    "Ib", "11", "11", "10", "10", "10", "10", "10", "10", "10", "11", "11",
    "II", "9", "9", "8", "8", "8", "8", "8", "9", "9", "10", "11",
    "III", "8", "8", "7", "6", "6", "6", "7", "7", "8", "8", "9",
    "IV", "7", "7", "6", "6", "5", "5", "5", "99", "99", "99", "99",
    "V", "7", "7", "6", "5", "4", "3", "2", "2", "0", "0", "0",
    "VI", "99", "99", "99", "3", "3", "2", "1", "0", "0", "0", "0",
    "VII", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "D", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
  //</editor-fold>

  /**
   setup of combo boxex
   */
  @SuppressWarnings(value = "unchecked")
  public static void varCombos() {
    VARCOMBO = true;
    //<editor-fold defaultstate="collapsed" desc="Choice">
    jcb4choice = new JComboBox();
    jcb4choice.setToolTipText("Choice");
    jcb4choice.addItem("World");
    jcb4choice.addItem("Navy");
    jcb4choice.addItem("Troop");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Side">
    jcb4side = new JComboBox();
    jcb4side.setToolTipText("Side");
    jcb4side.addItem("Imperium");
    jcb4side.addItem("Other");
    jcb4side.addItem("Solomani");
    jcb4side.addItem("Zhodani");
    jcb4side.addItem("Vargr");
    jcb4side.addItem("K`Kree");
    jcb4side.addItem("Hiver");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Type">
    jcb4imp = new JComboBox();
    jcb4imp.setToolTipText("Type");
    jcb4imp.addItem("Regular");
    jcb4imp.addItem("Colonial");
    jcb4imp.addItem("Marines");
    jcb4imp.addItem("Mercenary");
    jcb4imp.addItem("Display");
    jcb4imp.addItem("Bases");
    jcb4imp.addItem("Squadron");
    jcb4imp.addItem("SDB");
    jcb4imp.addItem("Rebel");
    jcb4imp.addItem("PD");
    jcb4imp.addItem("Geurilla");
    jcb4imp.addItem("RebelDisplay");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="TAS">
    jcb4TAS = new JComboBox();
    jcb4TAS.setToolTipText("TAS");
    jcb4TAS.addItem("Green");
    jcb4TAS.addItem("Amber");
    jcb4TAS.addItem("Red");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="SSS">
    jcb4SSS = new JComboBox();
    jcb4SSS.setToolTipText("SSS");
    jcb4SSS.addItem("Sector");
    jcb4SSS.addItem("SubSector");
    jcb4SSS.addItem("System");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="AtmoType">
    jcb4Atmo = new JComboBox();
    jcb4Atmo.setToolTipText("Atmosphere");
    jcb4Atmo.addItem("None");
    jcb4Atmo.addItem("Normal");
    jcb4Atmo.addItem("Tainted");
    jcb4Atmo.addItem("Bad");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Squadron Type">
    jcb4Ron = new JComboBox();
    jcb4Ron.setToolTipText("Naval");
    jcb4Ron.addItem("1/2-SR");
    jcb4Ron.addItem("1-CR");
    jcb4Ron.addItem("2-AR");
    jcb4Ron.addItem("2-BR");
    jcb4Ron.addItem("3-TR");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="GasGiants">
    jcb4GG = new JComboBox();
    jcb4GG.setToolTipText("Gas Giants");
    jcb4GG.addItem("0");
    jcb4GG.addItem("1");
    jcb4GG.addItem("2");
    jcb4GG.addItem("3");
    jcb4GG.addItem("4");
    jcb4GG.addItem("5");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="TL">
    jcb4TL = new JComboBox();
    jcb4TL.setToolTipText("Tech Level");
    for (int i = 0; i < 16; i++) {
      jcb4TL.addItem("" + i);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Starport Type">
    jcb4SP = new JComboBox();
    jcb4SP.setToolTipText("StarPort");
    jcb4SP.addItem("A - Excellent");
    jcb4SP.addItem("B - Good");
    jcb4SP.addItem("C - Routine");
    jcb4SP.addItem("D - Poor");
    jcb4SP.addItem("E - Poor");
    jcb4SP.addItem("F - Frontier");
    jcb4SP.addItem("X - None");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Size0">
    //Size
    jcb4Size = new JComboBox();
    jcb4Size.setToolTipText("Size");
    jcb4Size.addItem("0 - 800km");
    jcb4Size.addItem("1 - 1600km");
    jcb4Size.addItem("2 - 3200km");
    jcb4Size.addItem("3 - 4800km");
    jcb4Size.addItem("4 - 6400km");
    jcb4Size.addItem("5 - 8000km");
    jcb4Size.addItem("6 - 9600km");
    jcb4Size.addItem("7 - 11200km");
    jcb4Size.addItem("8 - 12800km");
    jcb4Size.addItem("9 - 14400km");
    jcb4Size.addItem("A - 16000km");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Atmosphere">
    //Atmosphere
    jcb4Atmos = new JComboBox();
    jcb4Atmos.setToolTipText("Atmosphere");
    jcb4Atmos.addItem("0 - None");
    jcb4Atmos.addItem("1 - Trace");
    jcb4Atmos.addItem("2 - V Thin, Tainted");
    jcb4Atmos.addItem("3 - V Thin");
    jcb4Atmos.addItem("4 - Thin, Tainted");
    jcb4Atmos.addItem("5 - Thin");
    jcb4Atmos.addItem("6 - Standard");
    jcb4Atmos.addItem("7 - Std, Tainted");
    jcb4Atmos.addItem("8 - Dense");
    jcb4Atmos.addItem("9 - Dense, Tainted");
    jcb4Atmos.addItem("A - Exotic");
    jcb4Atmos.addItem("B - Corrosive");
    jcb4Atmos.addItem("C - Insidious");
    jcb4Atmos.addItem("D - Dense, High");
    jcb4Atmos.addItem("E - Thin, Low");
    jcb4Atmos.addItem("F - Unusual");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Hydrosphere">
    //Hydrosphere
    jcb4Hydros = new JComboBox();
    jcb4Hydros.setToolTipText("Hydrosphere");
    jcb4Hydros.addItem("0 - 0%");
    jcb4Hydros.addItem("1 - 10%");
    jcb4Hydros.addItem("2 - 20%");
    jcb4Hydros.addItem("3 - 30%");
    jcb4Hydros.addItem("4 - 40%");
    jcb4Hydros.addItem("5 - 50%");
    jcb4Hydros.addItem("6 - 60%");
    jcb4Hydros.addItem("7 - 70%");
    jcb4Hydros.addItem("8 - 80%");
    jcb4Hydros.addItem("9 - 90%");
    jcb4Hydros.addItem("A - 100%");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Population">
    //Population
    jcb4Pop = new JComboBox();
    jcb4Pop.setToolTipText("Population");
    jcb4Pop.addItem("0 - None");
    jcb4Pop.addItem("1 - Few");
    jcb4Pop.addItem("2 - Hundreds");
    jcb4Pop.addItem("3 - Thousands");
    jcb4Pop.addItem("4 - Tens of Thousands");
    jcb4Pop.addItem("5 - Hundreds of Thousands");
    jcb4Pop.addItem("6 - Millions");
    jcb4Pop.addItem("7 - Tens of Millions");
    jcb4Pop.addItem("8 - Hundreds of Millions");
    jcb4Pop.addItem("9 - Billions");
    jcb4Pop.addItem("A - Tens of Billions");
    jcb4Pop.addItem("B - Hundreds of Billions");
    jcb4Pop.addItem("C - Trillions");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Government">
    //Government
    jcb4Govt = new JComboBox();
    jcb4Govt.setToolTipText("Government");
    jcb4Govt.addItem("0 - None");
    jcb4Govt.addItem("1 - Company/Corporation ");
    jcb4Govt.addItem("2 - Participating Democracy");
    jcb4Govt.addItem("3 - Self Perpetuating Oligarchy");
    jcb4Govt.addItem("4 - Representative Democracy");
    jcb4Govt.addItem("5 - Feudal Technocracy");
    jcb4Govt.addItem("6 - Captive Government");
    jcb4Govt.addItem("7 - Balkanisation");
    jcb4Govt.addItem("8 - Civil Service Bureaucracy");
    jcb4Govt.addItem("9 - Impersonal Bureaucracy");
    jcb4Govt.addItem("A - Charismatic Dictator");
    jcb4Govt.addItem("B - Non Charismatic Leader");
    jcb4Govt.addItem("C - Charismatic Oligarchy");
    jcb4Govt.addItem("D - Religious Dictatorship");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Law Level">
    //Law Level
    jcb4LL = new JComboBox();
    jcb4LL.setToolTipText("Law Level");
    jcb4LL.addItem("0 - No Law");
    jcb4LL.addItem("1 - Low Law");
    jcb4LL.addItem("2 - Low Law");
    jcb4LL.addItem("3 - Low Law");
    jcb4LL.addItem("4 - Moderate Law");
    jcb4LL.addItem("5 - Moderate Law");
    jcb4LL.addItem("6 - Moderate Law");
    jcb4LL.addItem("7 - Moderate Law");
    jcb4LL.addItem("8 - High Law");
    jcb4LL.addItem("9 - High Law");
    jcb4LL.addItem("A - Extreme Law");
    jcb4LL.addItem("B - Extreme Law");
    jcb4LL.addItem("C - Extreme Law");
    jcb4LL.addItem("D - Extreme Law");
    jcb4LL.addItem("E - Extreme Law");
    jcb4LL.addItem("F - Extreme Law");
    jcb4LL.addItem("G - Extreme Law");
    jcb4LL.addItem("H - Extreme Law");
    jcb4LL.addItem("J - Extreme Law");
    jcb4LL.addItem("K - Extreme Law");
    jcb4LL.addItem("L - Extreme Law");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Tech Level">
    //Tech Level
    jcb4TL = new JComboBox();
    jcb4TL.setToolTipText("Tech Level");
    jcb4TL.addItem("0 - Stone Age");
    jcb4TL.addItem("1 - Bronze Age");
    jcb4TL.addItem("2 - 1400-1700AD");
    jcb4TL.addItem("3 - 1700-1860AD");
    jcb4TL.addItem("4 - 1860-1900AD");
    jcb4TL.addItem("5 - 1900-1939AD");
    jcb4TL.addItem("6 - 1940-1969");
    jcb4TL.addItem("7 - 1970-1990");
    jcb4TL.addItem("8 - 1990-2100");
    jcb4TL.addItem("9 - 2100+AD");
    jcb4TL.addItem("A - Early Interstellar");
    jcb4TL.addItem("B - Average Interstellar");
    jcb4TL.addItem("C - Average Interstellar");
    jcb4TL.addItem("D - Above Average Interstellar");
    jcb4TL.addItem("E - Above Average Interstellar");
    jcb4TL.addItem("F - Technical Maximum");
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Hexadecimal">
    jcb4Hex = new JComboBox();
    jcb4Hex.setToolTipText("Hexadecimal");
    for (int i = 0; i < 10; i++) {
      jcb4Hex.addItem("" + i);
    }
    jcb4Hex.addItem("A");
    jcb4Hex.addItem("B");
    jcb4Hex.addItem("C");
    jcb4Hex.addItem("D");
    jcb4Hex.addItem("E");
    jcb4Hex.addItem("F");
    //</editor-fold>
  }

  static int getOrbits() {
    //    return Integer.parseInt(svars[8]);
    return StarGen.Orbit.length;
  }
  //</editor-fold>
  //Satellites
  //<editor-fold defaultstate="collapsed" desc="Satellite orbit">
  private int orbit;
  private String satelliteorbitringtitle;
  private String satelliteorbitclosetitle;
  private String satelliteorbitextremetitle;
  private String satelliteorbitfartitle;
  private String[] SatelliteOrbit;
  private String[] satelliteorbitvarnames = new String[]{
    satelliteorbitringtitle, satelliteorbitclosetitle,
    satelliteorbitfartitle, satelliteorbitextremetitle
  };
  /**
   table (CT)
   */
  public String[] strings;
  //</editor-fold>
  private String[] worlddatatext;
  /**
   Allegiance codes
   */
  //<editor-fold defaultstate="collapsed" desc="Allegs">
  public String[] Allegs = new String[]{//take from alleg in T5 .sec files
    "Imperial", "Zhodani", "Solomani", "Sword Worlds", "Darrian",
    "Vargr", "Aslan", "Droyne", "K`kree", "Hiver"
  };
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="String[] MainworldType">
  private static String[] MainworldType = {
    "5",
    "Flux", "World", "HZ Var", "Close", "Far",
    "-6", "Close Satellite", "-2", "A", "N",
    "-5", "Far Satellite", "-1", "B", "O",
    "-4", "Far Satellite", "-1", "C", "P",
    "-3", "Close Satellite", "-1", "D", "Q",
    "-2", "World", "0", "E", "R",
    "-1", "World", "0", "F", "S",
    "0", "World", "0", "G", "T",
    "1", "World", "0", "H", "U",
    "2", "World", "0", "I", "V",
    "3", "World", "1", "J", "W",
    "4", "World", "1", "K", "X",
    "5", "World", "1", "L", "Y",
    "6", "World", "2", "M", "Z"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] Hab">
  /**

   */
  public static final String[] Hab = new String[]{
    "12",
    "Sp/Si", "A0-A3", "A4-A8", "A9-F1", "F2-F6", "F7-G1", "G2-G8", "G9-K3",
    "K4-K8", "K9-M3", "M4-M8", "M9",
    "Ia", "12", "12", "12", "12", "11", "12", "12", "12", "12", "12", "12",
    "Ib", "11", "11", "10", "10", "10", "10", "10", "10", "10", "11", "11",
    "II", "9", "9", "8", "8", "8", "8", "8", "9", "9", "10", "11",
    "III", "8", "8", "7", "6", "6", "6", "7", "7", "8", "8", "9",
    "IV", "7", "7", "6", "6", "5", "5", "5", "-1", "-1", "-1", "-1",
    "V", "7", "7", "6", "5", "4", "3", "2", "2", "0", "0", "0",
    "VI", "-1", "-1", "-1", "3", "3", "2", "1", "0", "0", "0", "0",
    "VII", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
    "D", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"
  };

  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] Placement">
  /*
   2D LGG SGG IG Belt World1 World2
   GG and Belt placement is based on the HZ.
   World placement is based on Orbit.
   If an orbits is duplicated or precluded, adjust to
   an adjacent or the closest possible orbits.
   */
  private static final String[] Placement = new String[]{
    "7",
    "2D", "LGG", "SGG", "IG", "Belt", "World1", "World2",
    "2", "-3", "-2", "+1", "-1", "10", "17",
    "3", "-2", "-1", "+2", "0", "8", "16",
    "4", "-1", "0", "+3", "+1", "6", "15",
    "5", "+0", "+1", "+4", "+2", "4", "14",
    "6", "+1", "+2", "+5", "+3", "2", "13",
    "7", "+2", "+3", "+6", "+4", "0", "12",
    "8", "+3", "+4", "+7", "+5", "1", "11",
    "9", "+4", "+5", "+8", "+6", "3", "10",
    "10", "+5", "+6", "+9", "+7", "5", "9",
    "11", "+6", "+7", "+10", "+8", "7", "8",
    "12", "+7", "+8", "+11", "+9", "10", "7"
  };

  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] GGs">
  private static String[] GGs = {
    "5",
    "2D", "Size", "WSize", "Dia", "Type",
    "1", "L", "20", "20,000", "",
    "2", "M", "21", "30,000", "Neptune",
    "3", "N", "22", "40,000", "",
    "4", "P", "23", "50,000", "",
    "5", "Q", "24", "60,000", "",
    "6", "R", "25", "70,000", "Saturn",
    "7", "S", "26", "80,000", "",
    "8", "T", "27", "90,000", "Jupiter",
    "9", "U", "28", "125,000", "2Mj",
    "10", "V", "29", "180,000", "4Mj",
    "11", "W", "30", "220,000", "6Mj",
    "12", "X", "31", "250,000", "8Mj"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] StarColor">
  static String[] StarColor = {
    "3",
    "Code", "Description", "Temperature (K)",
    "O", "Blue", ">33,000",
    "B", "Blue-White", "10,000-33,000",
    "A", "Blue-White", "7,500-10,000",
    "F", "Yellow-White", "6,000-7,500",
    "G", "Yellow", "5,200-6,000",
    "K", "Orange", "3,700-5,200",
    "M", "Red", "2,000-3,700"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] StarSize">
  static String[] StarSize = {
    "3",
    "Code", "Description", "Diameter (Sol = 1)",
    "Ia", "Bright Supergiant", "52 - 3500",
    "Ib", "Weak Supergiant", "30 - 3000",
    "II", "Bright Giant", "14 - 1000",
    "III", "Normal Giant", "4.6 - 360",
    "IV", "Subgiant", "3.3 - 13",
    "V", "Main Sequence Star", "0.2 - 10",
    "VI", "Subdwarf", "0.1 - 1.2",
    "VII", "White Dwarf", "0.006 - 0.018",
    "D", "White Dwarf", "0.006 - 0.018"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] OtherWorld">
  String[] OtherWorld = {
    "Hospitable", "Planetoid", "IceWorld", "RadWorld", "Inferno",
    "BigWorld", "Worldlet", "InnerWorld", "StormWorld"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] InnerSats">
  String[] InnerSats = {
    "Worldlet", "Worldlet", "Inferno",
    "InnerWorld", "StormWorld", "RadWorld", "BigWorld"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] OuterSats">
  String[] OuterSats = {
    "Worldlet", "Worldlet", "IceWorld",
    "OuterWorld", "StormWorld", "RadWorld", "BigWorld"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] HospitableSats">
  String[] HospitableSats = new String[]{
    "Worldlet", "Worldlet", "Inferno",
    "Hospitable", "StormWorld", "RadWorld", "BigWorld"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] InnerWorlds">
  String[] InnerWorlds = {
    "Worldlet", "Inferno", "InnerWorld", "BigWorld", "StormWorld", "RadWorld"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] OuterWorlds">
  String[] OuterWorlds = {
    "Worldlet", "IceWorld", "IceWorld", "BigWorld", "IceWorld", "RadWorld"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] HospitableWorlds">
  String[] HospitableWorlds = new String[]{
    "Worldlet", "Inferno", "Hospitable", "BigWorld", "StormWorld", "RadWorld"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] D10Limit">
  private static final String[] D10Limit = {
    "9",
    "TD", "Ia", "Ib", "II", "III", "IV", "V", "VI", "D",
    "A0", "7", "5", "4", "1", "1", "0", "-1", "-1",
    "A5", "7", "5", "3", "1", "0", "-1", "-1", "-1",
    "F0", "7", "6", "3", "1", "0", "-1", "-1", "-1",
    "F5", "7", "6", "4", "1", "0", "-1", "-1", "-1",
    "G0", "8", "6", "4", "1", "0", "-1", "-1", "-1",
    "G5", "9", "7", "5", "3", "0", "-1", "-1", "-1",
    "K0", "10", "7", "6", "3", "0", "-1", "-1", "-1",
    "K5", "10", "8", "7", "5", "-2", "-1", "-1", "-1",
    "M0", "11", "10", "8", "6", "-2", "-1", "-1", "-1",
    "M5", "11", "11", "9", "8", "-2", "-1", "-1", "-1",
    "M9", "12", "11", "10", "8", "-2", "-1", "-1", "-1"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] D100Limit">
  private static final String[] D100Limit = {
    "9",
    "TD", "Ia", "Ib", "II", "III", "IV", "V", "VI", "D",
    "A0", "10", "9", "7", "6", "5", "5", "-2", "-1",
    "A5", "10", "9", "7", "5", "4", "4", "-2", "-1",
    "F0", "11", "9", "7", "5", "4", "3", "-2", "-1",
    "F5", "11", "9", "7", "5", "4", "3", "3", "-1",
    "G0", "11", "10", "8", "6", "4", "2", "2", "-1",
    "G5", "12", "10", "8", "7", "4", "2", "1", "-1",
    "K0", "12", "11", "9", "7", "5", "2", "0", "-1",
    "K5", "13", "12", "10", "9", "-2", "1", "0", "-1",
    "M0", "14", "13", "11", "9", "-2", "1", "0", "-1",
    "M5", "15", "14", "13", "11", "-2", "0", "-1", "-1",
    "M9", "15", "15", "13", "12", "-2", "-1", "-1", "-1"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] D1000Limit">
  private static final String[] D1000Limit = {
    "9",
    "TD", "Ia", "Ib", "II", "III", "IV", "V", "VI", "D",
    "A0", "13", "12", "11", "9", "9", "8", "-2", "-1",
    "A5", "14", "12", "10", "9", "8", "7", "-2", "-1",
    "F0", "14", "12", "10", "9", "8", "7", "-2", "-1",
    "F5", "14", "12", "11", "9", "8", "7", "7", "-1",
    "G0", "15", "13", "11", "9", "8", "6", "6", "-1",
    "G5", "15", "14", "12", "10", "8", "6", "5", "-1",
    "K0", "16", "14", "12", "10", "8", "6", "5", "-1",
    "K5", "16", "15", "13", "12", "-2", "6", "5", "-1",
    "M0", "17", "16", "14", "12", "-2", "5", "4", "-1",
    "M5", "18", "17", "16", "14", "-2", "5", "2", "-1",
    "M9", "18", "18", "16", "15", "-2", "4", "1", "-1"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] EHex">
  private String[] EHex = {
    "2",
    "eHex", "Decimal",
    "0", "0",
    "1", "1",
    "2", "2",
    "3", "3",
    "4", "4",
    "5", "5",
    "6", "6",
    "7", "7",
    "8", "8",
    "9", "9",
    "A", "10",
    "B", "11",
    "C", "12",
    "D", "13",
    "E", "14",
    "F", "15",
    "G", "16",
    "H", "17",
    "J", "18",
    "K", "19",
    "L", "20",
    "M", "21",
    "N", "22",
    "P", "23",
    "Q", "24",
    "R", "25",
    "S", "26",
    "T", "27",
    "U", "28",
    "V", "29",
    "W", "30",
    "X", "31*",
    "Y", "32*",
    "Z", "33*"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] Size">
  private static String[] Size = {
    //Size = 2D-2
    //if 10, reroll 1D+9
    "3",
    "Digit", "Dia(mi)", "Dia(km)",
    "0", "Asteroid Belt", "varies",
    "1", "1,000", "1,600",
    "2", "2,000", "3,200",
    "3", "3,000", "4,800",
    "4", "4,000", "6,400",
    "5", "5,000", "8,000",
    "6", "6,000", "9,600",
    "7", "7,000", "12,200",
    "8", "8,000", "13,800",
    "9", "9,000", "14,400",
    "A", "10,000", "16,000",
    "B", "11,000", "17,600",
    "C", "12,000", "19,200",
    "D", "13,000", "20,800",
    "E", "14,000", "22,400",
    "F", "15,000", "24,000"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] Atmo">
  private static String[] Atmo = {
    //Atmo = Flux + Size0
    //if Atmo<0 or Size0=0 then Atmo=0
    //if Atmo>F then Atmo=F
    "3",
    "Digit", "Description", "Effects",
    "0", "Vacuum", "S3",
    "1", "Trace", "S3",
    "2", "VThin, Tainted", "P1, S2",
    "3", "VThin", "S2",
    "4", "Thin, Tainted", "P1, S1",
    "5", "This", "S1",
    "6", "Standard", "",
    "7", "Standard, Tainted", "P1",
    "8", "Dense", "",
    "9", "Dense, Tainted", "P1",
    "A", "Exotic", "P1",
    "B", "Corrosive", "C1 P1",
    "C", "Insidious", "C2 P1",
    "D", "Dense, High", "varies",
    "E", "Ellipsoid", "varies",
    "F", "Thin, Low", "varies"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] Hydro">
  private static String[] Hydro = {
    //Hydro = Flux + Atmo
    //Max = A
    //if Siz < 2 then Hyd = 0
    //if Atm < 2 or Atm > 9 then Atmo DM-4
    //if Hyd <0 then 0
    //if Hyd > A then A
    "2",
    "Digit", "Description",
    "0", "Desert World",
    "1", "10%",
    "2", "20%",
    "3", "30%",
    "4", "40%",
    "5", "50%",
    "6", "60%",
    "7", "70%",
    "8", "80%",
    "9", "90%",
    "A", "Water World"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] Pop">
  private static String[] Pop = {
    //pop = 2D-2
    //if 10, reroll 9 + 1D
    "3",
    "Digit", "Description", "Value",
    "0", "Unpopulated", "",
    "1", "Tens", "0",
    "2", "Hundred", "00",
    "3", "Thousand", ",000",
    "4", "Ten thousand", "0,000",
    "5", "Hundred thousand", "00,000",
    "6", "Million", ",000,000",
    "7", "Ten million", "0,000,000",
    "8", "Hundred million", "00,000,000",
    "9", "Billion", ",000,000,000",
    "A", "Ten billion", "0,000,000,000",
    "B", "Hundred billion", "00,000,000,000",
    "C", "Trillion", ",000,000,000,000",
    "D", "Ten trillion", "0,000,000,000,000",
    "E", "Hundred trillion", "00,000,000,000,0000",
    "F", "Quadrillion", ",000,000,000,000,000"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] Govt">
  private static String[] Govt = {
    //Gov = Flux + Pop, if Gov > F then Gov = F
    "3",
    "Digit", "Description", "Note",
    "0", "No Government Structure", "Family bonds predominate",
    "1", "Company/Corporation", "Rule by a managerial elite",
    "2", "Participating Democracy", "Rule by popular vote",
    "3", "Self-Perpetuating Oligarchy", "Rule by a restricted minority with "
    + "little or no input from the masses",
    "4", "Representative Democracy", "Government by proxy",
    "5", "Feudal Technocracy", "Governmental relationships based on mutually "
    + "beneficial technical activities",
    "6", "Captive Government/Colony", "Rule by a leadership answerable to an "
    + "outside group",
    "7", "Balkanization", "Rival governments continually compete for control "
    + "of the world",
    "8", "Civil Service Bureaucracy", "Rule by agencies employing "
    + "individuals selected by merit",
    "9", "Impersonal Bureaucracy", "Impersonal agencies rule",
    "A", "Charismatic Dictatorship", "Government by a single leader "
    + "enjoying the confidence of the citizens",
    "B", "Non-Charismatic Dictatorship", "Government by the successor "
    + "to a charismatic dictator",
    "C", "Charismatic Oligarchy", "Government by a select religious, "
    + "mystic, or psionic group, organization, or class enjoying the "
    + "overwhelming confidence of the citizenry",
    "D", "Religious Dictatorship", "With little or no regard for the needs "
    + "of the citizenry",
    "E", "Religious Autocracy", "Government by a single religious, mystic, "
    + "or psionic leader weilding absolute power",
    "F", "Totalitarian Oligarchy", "Government by an all powerfule minority "
    + "which maintains absolute control through widespread coercion and "
    + "oppression"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] Law">
  private static String[] Law = {
    //Law = Flux + Go
    //if Law > J then Law = J
    "3",
    "Digit", "Description", "Note",
    "0", "No Law", "No prohibitions",
    "1", "Low Law", "Prohibition of WMD, Psi weapons",
    "2", "Low Law", "Prohibition of 'portable' weapons",
    "3", "Low Law", "Prohibition of Acid, Fire, Gas weapons",
    "4", "Moderate Law", "Laser, Beam weapons prohibited",
    "5", "Moderate Law", "Shock, EMP, Rad, Mag, Grav weapons prohibited",
    "6", "Moderate Law", "Pohibition of Machineguns",
    "7", "Moderate Law", "Prohibition of Pistols",
    "8", "High Law", "Open display of weapons prohibited",
    "9", "High Law", "Weapons outside the home prohibited",
    "A", "Extreme Law", "Weapon possession prohibited",
    "B", "Extreme Law", "Continental passports required",
    "C", "Extreme Law", "Unrestricted invasion of privacy",
    "D", "Extreme Law", "Paramilitary law enforcement",
    "E", "Extreme Law", "Full-fledged police state",
    "F", "Extreme Law", "Daily life rigidly controlled",
    "G", "Extreme Law", "Disproportionate punishments",
    "H", "Extreme Law", "Legalized oppressive practices",
    "J", "Extreme Law", "Routinely oppressive and restrictive"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] Tech">
  private static String[] Tech = {
    //Starport A = +6
    //B = +4
    //C = +2
    //F = +1
    //X = -4
    "3",
    "Digit", "", "",
    "0", "", "",
    "1", "", "",
    "2", "", "",
    "3", "", "",
    "4", "", "",
    "5", "", "",
    "6", "", "",
    "7", "", "",
    "8", "", "",
    "9", "", "",
    "A", "", "",
    "B", "", "",
    "C", "", "",
    "D", "", "",
    "E", "", "",
    "F", "", ""
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] Remarks">
  private static String[] Remarks = {
    "9",
    "Code", "Siz", "Atm", "Hyd", "Pop", "Govt", "Law", "Definition", "Formula",
    //---------------------------------PLANETARY
    "As", "0", "0", "0", "", "", "", "Asteroid", "",
    "De", "23456789", "0", "", "", "", "", "Desert", "",
    "Fl", "", "ABC", "123456789A", "", "", "", "Fluid", "",
    "Ga", "678", "568", "567", "", "", "", "Garden World", "",
    "He", "3459ABC", "2479ABC", "012", "", "", "", "Hell World", "",
    "Ic", "", "01", "123456789A", "", "", "", "Ice Capped", "",
    "Oc", "ABC", "", "A", "", "", "", "Ocean World", "",
    "Va", "", "0", "", "", "", "", "Vacuum", "",
    "Wa", "56789", "", "A", "", "", "", "Water World", "",
    //---------------------------------POPULATION
    "Di", "", "", "", "0", "0", "0", "Dieback (000-T)", "",
    "Ba", "", "", "", "0", "0", "0", "Barren", "",
    "Lo", "", "", "", "123", "", "", "Low Population", "",
    "Ni", "", "", "", "456", "", "", "Non Industrial", "",
    "Ph", "", "", "", "8", "", "", "Pre High", "",
    "Hi", "", "", "", "9ABC", "", "", "High Population", "",
    //---------------------------------ECONOMIC
    "Pa", "", "456789", "45678", "48", "", "", "Pre Agricultural", "",
    "Ag", "", "456789", "45678", "567", "", "", "Agricultural", "",
    "Na", "", "0123", "0123", "6789ABC", "", "", "Non Agricultural", "",
    "Pi", "", "012479", "", "78", "", "", "Pre Industrial", "",
    "In", "", "012479", "", "9ABC", "", "", "industrial", "",
    "Po", "", "2345", "0123", "", "", "", "Poor", "",
    "Pr", "", "68", "", "59", "", "", "Pre Rich", "",
    "Ri", "", "68", "", "678", "", "", "Rich", "",
    //---------------------------------CLIMATE
    "Fr", "23456789", "", "123456789A", "", "", "", "Frozen", "HZ +2 or outer",
    "Ho", "", "", "", "", "", "", "Hot", "HZ -1",
    "Co", "", "", "", "", "", "", "Cold", "HZ +1",
    "Lk", "", "", "", "", "", "", "Locked", "Close Satellite",
    "Tr", "6789", "456789", "34567", "", "", "", "Tropic", "HZ -1",
    "Tu", "6789", "456789", "34567", "", "", "", "Tundra", "HZ +1",
    "Tz", "", "", "", "", "", "", "Twilight Zone", "Orbit 0-1",
    //---------------------------------SECONDARY
    "Fa", "", "456789", "45678", "23456", "", "", "Farming",
    "Not MainWorld.  HZ",
    "Mi", "", "", "", "23456", "", "", "Mining", "Not MainWorld.  MainWorld=In",
    "Mr", "", "", "", "", "", "", "Military Rule by Regional Power", "",
    "Px", "", "23AB", "12345", "3456", "", "6789", "Prison.  Exile Camp", "",
    "Pe", "", "23AB", "12345", "3456", "6", "6789", "Penal Colony", "",
    "Re", "", "", "", "1234", "6", "45", "Reserve", "",
    //---------------------------------POLITICAL
    "Cp", "", "", "", "", "", "", "Subsector Capital", "Imperial",
    "Cs", "", "", "", "", "", "", "Client State", "Imperial",
    "Cx", "", "", "", "", "", "", "Sector Capital", "Imperial",
    "Cy", "", "", "", "", "", "", "Colony", "O:xxyy (p434)",
    //---------------------------------SPECIAL
    "Sa", "", "", "", "", "", "", "Satellite", "",
    "Fo", "", "", "", "", "", "", "Forbidden", "Red Zone",
    "Pz", "", "", "", "789ABC", "", "", "Puzzle", "Amber Zone",
    "Da", "", "", "", "0123456", "", "", "Dangerous", "Amber Zone",
    "Ab", "", "", "", "", "", "", "Data Repository", "",
    "An", "", "", "", "", "", "", "Ancient Site", "",
    "Rs", "", "", "", "", "", "", "Research Station", "",
    "RsA", "", "", "", "", "", "", "Research Station Alpha", "",
    "RsB", "", "", "", "", "", "", "Research Station Beta", "",
    //    "", "", "", "", "", "", "", "", "",
    "RsD", "", "", "", "", "", "", "Research Station Delta", ""
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] NIL">
  private static String[] NIL = {
    "5",
    "Pop", "Atm", "TL", "Comment", "Note",
    "7+", "2-9", "1+", "Intelligent life evolved on this world", "Natives",
    "7+", "A+", "1+",
    "Local intelligent life incompatible with human enviroments", "Exotics",
    "7+", "0-1", "1+", "Sophonts evolved elsewhere and settled here years ago",
    "Transplants",
    "0", "2+", "1+",
    "Intelligent life evolved on this world, but is now extinct", "Extinct",
    "0", "0-1", "1+", "Evidence of Transplants, but are no longer present",
    "Vanished",
    "1-3", "", "", "Non permanent commercial or scientific activity",
    "Transients",
    "4-6", "", "", "The initial steps of creating a colony", "Settlers"
  //  if Gov == 1   Locals are company employees
  //  if Gov == 6   Locals are colonists from a nearby world
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] N">
  private static String[] N = {
    "3",
    "Code", "Rank", "TC",
    "A", "Gentleman", "Peer",
    "B", "Knight", "any",
    "c", "Baronet", "Pa Pr",
    "C", "Baron", "Ag Ri",
    "D", "Marquis", "Pi",
    "e", "Viscount", "Ph",
    "E", "Count", "Hi",
    "f", "Duke", "In",
    "F", "Duke", "In",
    "G", "Archduke", "",
    "H", "Emperor", ""
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] B">
  private static String[] B = {
    "3",
    "Digit", "Description", "Alleg",
    "C", "Corsair Base", "Vargr",
    "D", "Naval Depot", "Any",
    "K", "Naval Base", "Any",
    "M", "Military Base", "Any",
    "N", "Naval Base", "Imperial",
    "R", "Clan Base", "Aslan",
    "S", "Scout Base", "Imperial",
    "T", "Tlaukhu Base", "Aslan",
    "V", "Exploration Base", "Any",
    "W", "Scout Way Station", "Imperial",
    "X", "Relay Station", "Zhodani"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] Zones">
  private static String[] Zones = {
    "2",
    "Code", "Description",
    "R", "Red - Interdicted. Dangerous.  Prohibited.  Imperial.",
    "A", "Amber - Potentially dangerous.  Caution advised.  Imperial.",
    "-", "Green - Unrestricted.  Imperial.",
    "G", "Green - Unrestricted.  Imperial.",
    "B", "Blue - Technologically Elevated Dicatorship.  TNE (circa 1202)",
    "F", "Forbidden - Access prohibited Zhodani",
    "U", "Unabsorbed - Access restricted Zhodani"
  };
//</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="String[] Alleg">
  private static String[] Alleg = {
    "2",
    "Code", "Description",
    "AnTC", "Anubian Trade Coalition",
    "AsIf", "Iyeaao'fte (Tlaukhu client state)",
    "AsMw", "Aslan Hierate, single multiple-world clan dominates",
    "AsOf", "Oleaiy'fte (Tlaukhu client state)",
    "AsSc", "Aslan Hierate, multiple clans split control",
    "AsSF", "Aslan Hierate, small facility (temporary)",
    "AsT0",
    "Aslan Hierate, Tlaukhu control, Yerlyaruiwo (1), Hrawoao (13), Eisohiyw (14), Ferekhearl (19)",
    "AsT1",
    "Aslan Hierate, Tlaukhu control, Khauleairl (2), Estoieie' (16), Toaseilwi (22)",
    "AsT2", "Aslan Hierate, Tlaukhu control, Syoisuis (3)",
    "AsT3",
    "Aslan Hierate, Tlaukhu control, Tralyeaeawi (4), Yulraleh (12), Aiheilar (25), Riyhalaei (28)",
    "AsT4",
    "Aslan Hierate, Tlaukhu control, Eakhtiyho (5), Eteawyolei' (11), Fteweyeakh (23)",
    "AsT5", "Aslan Hierate, Tlaukhu control, Hlyueawi (6), Isoitiyro (15)",
    "AsT6",
    "Aslan Hierate, Tlaukhu control, Uiktawa (7), Iykyasea (17), Faowaou (27)",
    "AsT7",
    "Aslan Hierate, Tlaukhu control, Ikhtealyo (8), Tlerfearlyo (20), Yehtahikh (24)",
    "AsT8",
    "Aslan Hierate, Tlaukhu control, Seieakh (9), Akatoiloh (18), We'okunir (29)",
    "AsT9",
    "Aslan Hierate, Tlaukhu control, Aokhalte (10), Sahao' (21), Ouokhoi (26)",
    "AsTv", "Aslan Hierate, Tlaukhu vassal clan dominates",
    "AsTz", "Aslan Hierate, Zodia clan (Tralyeaeawi vassal)",
    "AsVc", "Aslan Hierate, vassal clan dominates",
    "AsWc", "Aslan Hierate, single one-world clan dominates",
    "AsXX", "Aslan Hierate, unknown",
    "BlSo", "Belgardian Sojurnate",
    "CaAs", "Carrillian Assembly",
    "CaPr", "Principality of Caledon",
    "CaTe", "Carter Technocracy",
    "CoLp", "Council of Leh Perash",
    "CsCa", "Client State, Principality of Caledon",
    "CsIm", "Client State, Third Imperium",
    "CsZh", "Client State, Zhodani Consulate",
    "CyUn", "Cytralin Unity",
    "DaCf", "Darrian Confederation",
    "DuCf", "Confederation of Duncinae",
    "FeHe", "Federation of Heron",
    "FlLe", "Florian League",
    "GaRp", "Gamma Republic",
    "GdMh", "Grand Duchy of Marlheim",
    "GdSt", "Grand Duchy of Stoner",
    "GeOr", "Gerontocracy of Ormine",
    "GlEm", "Glorious Empire (Aslan independent clan, outcast)",
    "GlFe", "Glimmerdrift Federation",
    "GnCl", "Gniivi Collective",
    "ImAp", "Third Imperium, Amec Protectorate (Dagu)",
    "ImDa", "Third Imperium, Domain of Antares (Anta/Empt/Lish)",
    "ImDc", "Third Imperium, Domain of Sylea (Core/Delp/Forn/Mass)",
    "ImDd", "Third Imperium, Domain of Deneb (Dene/Reft/Spin/Troj)",
    "ImDg", "Third Imperium, Domain of Gateway (Glim/Hint/Ley)",
    "ImDi", "Third Imperium, Domain of Ilelish (Daib/Ilel/Reav/Verg/Zaru)",
    "ImDs", "Third Imperium, Domain of Sol (Alph/Dias/Magy/Olde/Solo)",
    "ImDv", "Third Imperium, Domain of Vland (Corr/Dagu/Gush/Reft/Vlan)",
    "ImLa", "Third Imperium, League of Antares (Anta)",
    "ImLu", "Third Imperium, Luriani Cultural Association (Ley/Forn)",
    "ImSy", "Third Imperium, Sylean Worlds (Core)",
    "ImVd", "Third Imperium, Vegan Autonomous District (Solo)",
    "IsDo", "Islaiat Dominate",
    "JuHl", "Julian Protectorate, Hegemony of Lorean",
    "JuPr", "Julian Protectorate, independent",
    "JuRu", "Julian Protectorate, Rukadukaz Republic",
    "KhLe", "Khuur League",
    "LnRp", "Loyal Nineworlds Republic",
    "LyCo", "Lanyard Colonies",
    "MaEm", "Maskai Empire",
    "NaAs", "Non-Aligned, Aslan-dominated (outside Hierate)",
    "NaHu", "Non-Aligned, Human-dominated",
    "NaVa", "Non-Aligned, Vargr-dominated",
    "NaXX", "Unclaimed",
    "OcWs", "Outcasts of the Whispering Sky",
    "RaRa", "Ral Ranta",
    "SeFo", "Senlis Foederate",
    "SlLg", "Shukikikar League",
    "SoCf", "Solomani Confederation",
    "StCl", "Strend Cluster",
    "SwCf", "Sword Worlds Confederation",
    "TeAr", "Tealou Arlaoh (Aslan independent clan, non-outcast)",
    "UhHa", "Union of Harmony",
    "V40S", "40th Squadron",
    "VARC", "Anti-Rukh Coalition",
    "VAug", "United Followers of Augurgh",
    "VCKd", "Commonality of Kedzudh",
    "VDzF", "Dzarrgh Federate",
    "VPGa", "Pact of Gaerr",
    "VRuk", "Worlds of Leader Rukh",
    "VSDp", "Seaknouth Dependency",
    "VSEq", "Society of Equals",
    "VThE", "Thoengling Empire",
    "VTzE", "Thirz Empire",
    "VUru", "Nation of Urukhu",
    "XXXX", "Unknown",
    "ZhCo", "Zhodani Consulate",};
  //</editor-fold>

}
