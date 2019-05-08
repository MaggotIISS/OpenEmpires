/*

 Copyright (C) 2014 Mark Ferguson



 This program is free software: you can gty1dc istribute it and/or modify

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

import dbviewer.globals.GlobalMethods;
import dbviewer.globals.GlobalVariables;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import static panels.Panel4UTP.toComboBox;

/**
 <p>
 @author Your Name Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4Squadron extends Panel4 implements Interface4Usqp {

  //<editor-fold defaultstate="collapsed" desc="variables">
  //<editor-fold defaultstate="collapsed" desc="TechLevelModifiers">
  private static final String[] TechLevelModifiers = {
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
  private static final String[] ResourcesInfrastructureCultureRatings = {
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
  private static final String[] SDBSquadrons = {
    "5",
    "TL", "Pop7", "Pop8", "Pop9", "PopA",
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
  private static final String[] StreamlineValue = {
    "2",
    "Type", "Value",
    "Unstreamlined", "0",
    "Partially streamlined", "-1",
    "Streamlined", "-2"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="BaseJumpRating">
  private static final String[] BaseJumpRating = {
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
  private static final String[] BaseSquadronCost = {
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
  private static final String[] StreamlineCostMultiplier = {
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
  private static final String[] MaxStarshipSquadrons = {
    "8",
    "StarshipSquadrons", "TL9", "TLA", "TLB", "TLC", "TLD", "TLE", "TLF",
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
  private static final String[] DefenceBattalionsCombatFactor = {
    "6",
    "TL", "Pop6", "Pop7", "Pop8", "Pop9", "PopA",
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
  private static final String[] CombatFactorCapacity = {
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
  private static final String[] InitialProduction = {
    "5",
    "TL", "Pop7", "Pop8", "Pop9", "PopA",
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
  private static final String[] TroopUnitCost = {
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
  private static final String[] TroopUnitSize = {
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
  private static final String[] PlanningFactor = {
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
  private static final String[] TacticalFactor = {
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
  private static final String[] RepairPoints = {
    "5",
    "Pop", "Res0-3", "Res4-7", "Res8-B", "ResC-F",
    "7", "0.25", "0.33", "0.40", "0.50",
    "8", "0.33", "0.40", "0.50", "0.67",
    "9", "0.40", "0.50", "0.67", "0.80",
    "A", "0.50", "0.67", "0.80", "1.00"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="AdmiralsInCombat">
  private static final String[] AdmiralsInCombat = {
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
  private static final String[] PreparednessLevel = {
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
  private static final String[] ReinforcementLevel = {
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
  //<editor-fold defaultstate="collapsed" desc="ReinforcementLevel1">
  private static final String[] ReinforcementLevel1 = {
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
  //<editor-fold defaultstate="collapsed" desc="ReinforcementLevel2">
  private static final String[] ReinforcementLevel2 = {
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
  //<editor-fold defaultstate="collapsed" desc="ReinforcementLevel3">
  private static final String[] ReinforcementLevel3 = {
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
  private static final String[] RequiredRefuellingTimes = {
    "4",
    "Source", "PSL", "SL", "USL",
    "Gas Giant", "0", "0", "1",
    "Ocean", "0", "1", "1",
    "Starport", "*", "*", "*",
    "Base", "0", "0", "0"
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="StarportRefuellingTable">
  private static final String[] StarportRefuellingTable = {
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
  private static final String[] SpaceCombatResultsTable = {
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
  private static final String[] SDBVsSquadronTable = {
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
  private static final String[] SquadronVsSDBTable = {
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
  private static final String[] TLCombatModifiers = {
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
  private static final String[] AtmosphereModifiers = {
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
  private static final String[] SurfaceBombingTable = {
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
  private static final String[] PercentageLossTable = {
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
  private static final String[] TroopCombatResultsTable = {
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
   tables
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
    ReinforcementLevel, ReinforcementLevel1,
    ReinforcementLevel2, ReinforcementLevel3,
    RequiredRefuellingTimes, StarportRefuellingTable,
    SpaceCombatResultsTable, SDBVsSquadronTable,
    SquadronVsSDBTable, TLCombatModifiers,
    AtmosphereModifiers, SurfaceBombingTable,
    PercentageLossTable, TroopCombatResultsTable
  };
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="tablenames">
  /**
   tablenames
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
  /**
   hasParent
   */
  public static boolean hasParent = false;
  private static int len = 15;
  private static JTextArea jta = new JTextArea();
  static String SDBso = null;
  static String SQUADRONSo = null;
  static String DEFENCEBATTSo = null;
  static String TROOPUNITSo = null;
  private static String FS;
  private final JTextArea[] jtas = new JTextArea[1];
  private static JSpinner jsp = new JSpinner();
  private final JSpinner[] jsps = new JSpinner[1];
  private static String name;
  final static String[] names = new String[1];
  private static String line = new String();
  private static String[] lines;
  private static int P = 0;
  private static int M = 0;
  private static String tl;
  private static String pop;

  /**
   number of columns
   */
  public static int cols;
  private static int rows;

  /**
   column
   */
  public static int col;
  private static int row;
  private static String SDBs = "";
  private static String SQUADRONS = "";
  private static String DEFENCEBATTS = "";
  private static String TROOPUNITS = "";
  private static MouseEvent me;
  private static String CRLF = System.lineSeparator();
  private static int DF, AF, BF, TF;

  /**
   table of strings
   */
  public static String[] table;
  private static JLabel lab = new JLabel();
  private static JLabel labm = new JLabel();
  private static Panel4 jp;
  /**
   Frame4
   */
  public static Frame4 jf;
  static String ronpts;
  String type;
  String id;
  String jump;
  String sl;
  String df;
  String af;
  String bf;
  String tf;
  //  String tl;
  String res;
  String inf;
  String cul;
  //  String pop;
  String top;
  private String resm;
  private String tlm;
  private String infm;
  private String culm;
  private String popm;
  JLabel jl[] = new JLabel[2];
  JComboBox<String> jcb;
  JButton jb;
  JRadioButton jr1;
  JRadioButton jr2;
  JLabel[] newval = new JLabel[]{ //      nj, ns, nd, na, nb, nt
  };
  JLabel[] oldval = new JLabel[]{ //      oj, os, od, oa, ob, ot
  };
  JLabel[] modval = new JLabel[]{ //     mj, ms, md, ma, mb, mt
  };
  //  int x;
  private String ron;
  /**
   Base jump number
   */
  public static String BaseJump;
  /**
   Jump number of search
   */
  public static String MaxJump;
  //  int AF = 0, BF = 0, TF = 0, DF = 0;
  int popu = 0, tlmo = 0, rmo = 0, imo = 0, cmo = 0;
  int x = 0;
  int y = 0;
//  String[] list;
  int basejf, basesl, basedf, baseaf, basebf, basetf;
  private String olddf;
  private String oldsl;
  ListSelectionEvent lse1;
  ListSelectionEvent lse2;
  Double d, s;
  int t;
//  Graphics g = this.g;
  Graphics2D g2;
  static String folder = GlobalVariables.BMP + "/";
  static String pic;
//  static int x13;// = jLabel5.getWidth()/3;
//  static int x23;// = jLabel5.getWidth()*2/3;
  static int w;// = jLabel5.getWidth();
  //int w23;// = jLabel5.getWidth()*2;
  static int h;// = jLabel5.getHeight();
//  static int y13;// = jLabel5.getHeight()/3;
//  static int y23;// = jLabel5.getHeight()*2/3;
  private String _GIF = GlobalVariables.BMP + GlobalVariables.FS;
  static String[] titles;
  static String[] values;
  static double cost;
  static Color color = Color.white;
  //</editor-fold>

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    jp = new Panel4Squadron();
    try {
      jf = new Frame4(jp, Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
        .trim());
    } catch (Exception e) {
      jf = new Frame4(jp, "Panel4Squadron");
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    jp.setBackground(color);
    jf.setSize(600, 200);
    jf.setLocation(1200, 200);
    jf.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {
//          GlobalMethods.saveTextFile(Panel4Locator.getPath(),
          GlobalMethods.saveTextFile(Panel4T5Locator.getSysPath(),
            //            Panel4SubSector.jList1.getSelectedValue().toString(),
            Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim()
            .substring(0, 4),
            ".usqp",
            jTextArea1.getText());
        } catch (Exception ex) {
        }
      }
    });
    //MouseEvent me;
//    formMouseClicked(me);

//    JPanel p4c = new Panel4("Colours");
//    JColorChooser jcc = new JColorChooser(JColorChooser.showDialog(p4c, FS, Color.LIGHT_GRAY));
//    color = jcc.getColor();
//    jcc.setVisible(true);
//    jp.setBackground(color);
//    jf.setBackground(color);
    jf.setVisible(!jf.isVisible());
  }

  static JPanel getPanel() {
    return jp;
  }

  /**
   Creates new form Panel4Squadron
   */
  @SuppressWarnings({"unchecked", "unchecked"})
  public Panel4Squadron() {
    initComponents();
    jPanel3.setVisible(false);
    pic = "Ass.gif";
    top = jLabel9.getText();
    Panel4Squadron.ronpts = null;
    this.tf = null;
    this.bf = null;
    this.af = null;
    this.df = null;
    this.sl = null;
    this.jump = null;
    this.id = null;
    this.type = null;
    Panel4Squadron.tl = null;
    this.res = null;
    this.inf = null;
    this.cul = null;
    Panel4Squadron.pop = "A569ABBD-F9D4";
    this.tlm = null;
    this.resm = null;
    this.infm = null;
    this.culm = null;
    this.popm = null;
    try {
      Panel4Squadron.UWP.setText(Panel4T5Locator.UWP + "-"
        + Panel4SubSector.lab4Resources.getText()
        + Panel4SubSector.lab4Labour.getText()
        + Panel4SubSector.lab4Infrastructure.getText()
        + Panel4SubSector.lab4Culture.getText()
      );
    } catch (Exception e) {
    }
    this.worldUpdate();
    Panel4Squadron.sj.setForeground(Color.green);
    Panel4Squadron.ss.setForeground(Color.green);
    Panel4Squadron.sd.setForeground(Color.green);
    Panel4Squadron.sa.setForeground(Color.green);
    this.sb.setForeground(Color.green);
    this.jLabel44.setVisible(false);
    grayOutWorld();
    newval = new JLabel[]{
      nj, ns, nd, na, nb, nt
    };

    oldval = new JLabel[]{
      oj, os, od, oa, ob, ot
    };

    modval = new JLabel[]{
      mj, ms, md, ma, mb, mt
    };
    d = Double.parseDouble(jLabel44.getText());
    s = Double.parseDouble(md.getText());
    t = (int) (d + s);
    this.calcWorld();
    worldUpdate();
    jPanel1.setVisible(false);
    jComboBox0.setSelectedIndex(0);
    loadFile();
    doMath();
    toComboBox(jTextArea1, jComboBox1);
    try {
      jLabel16.setText(Panel4SubSector.UWP.getText().substring(7, 8));
      jLabel7.setText(Panel4SubSector.squadrons.getText());
    } catch (Exception e) {
//      jLabel15.setText("?");
//      jLabel6.setText("?");
    }
    jTextArea1.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent e) {
//        System.out.println("insertUpdate(DocumentEvent " + e + ")");
        countLines();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
//        System.out.println("removeUpdate(DocumentEvent " + e + ")");
        countLines();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
//        System.out.println("changedUpdate(DocumentEvent " + e + ")");
        countLines();
      }

      private void countLines() {
        String t = jTextArea1.getText();
        String[] lines = t.split(CRLF);
        System.out.println("lines.length" + " = " + lines.length);
      }
    });
    jLabel7.setText(Panel4T5Locator.squadrons.getText());
    String num = Panel4T5Locator.UWP.substring(8, 9);
    jLabel16.setText("" + GlobalMethods.fromHex(num));
    doMath();

  }

  private static void loadFile() {
//    try {
//      GlobalMethods.saveTextFile(Panel4Locator.getPath(),
//              Panel4SubSector.jList1.getSelectedValue().toString(),
//              ".usqp",
//              jTextArea1.getText());
//    } catch (Exception ex) {
//    }

    try {
      String s = Panel4Locator.getPath()
        + Panel4SubSector.jList1.getSelectedValue().toString()
        + ".usqp";
      File f = new File(s);
      String txt = GlobalMethods.loadTextFile(s);
      if (!txt.contains("usqp")) {
        jTextArea1.setText(txt);
      } else {
        jTextArea1.setText("");
      }
    } catch (Exception e) {
      System.out.println("799 File not ready");
      jTextArea1.setText("");
    }

  }

  private static void grayOutWorld() {
    jLabel19.setForeground(Color.LIGHT_GRAY);
    jLabel21.setForeground(Color.LIGHT_GRAY);
    jLabel22.setForeground(Color.LIGHT_GRAY);
    jLabel23.setForeground(Color.LIGHT_GRAY);
    jLabel39.setForeground(Color.LIGHT_GRAY);

    jLabel27.setForeground(Color.LIGHT_GRAY);
    jLabel24.setForeground(Color.LIGHT_GRAY);
    jLabel25.setForeground(Color.LIGHT_GRAY);
    jLabel26.setForeground(Color.LIGHT_GRAY);
    jLabel38.setForeground(Color.LIGHT_GRAY);

    jLabel31.setForeground(Color.LIGHT_GRAY);
    jLabel28.setForeground(Color.LIGHT_GRAY);
    jLabel29.setForeground(Color.LIGHT_GRAY);
    jLabel30.setForeground(Color.LIGHT_GRAY);

    jLabel34.setForeground(Color.LIGHT_GRAY);
    jLabel33.setForeground(Color.LIGHT_GRAY);
    jLabel32.setForeground(Color.LIGHT_GRAY);
    jLabel35.setForeground(Color.LIGHT_GRAY);
  }

  static String getFromTable(int tablenum, String x, String y) {
    table = tables[tablenum];
//    System.out.println("table[0]" + " = " + table[0]);
    cols = Integer.parseInt(table[0]);
//    System.out.println("cols" + " = " + cols);
    rows = (table.length - 1) / cols;
//    System.out.println("rows" + " = " + rows);
    col = 0;
    row = dbviewer.globals.GlobalMethods.fromHex(y);
//    System.out.println("row" + " = " + row);
    pop = Panel4SubSector.po;
//    System.out.println("pop" + " = " + pop);
    tl = Panel4SubSector.tl;
//    System.out.println("tl" + " = " + tl);
    int i = 0;
    for (i = 1; i <= cols; i++) {
      if (table[i].contains(x)) {
        col = i;
//        System.out.println("row" + " = " + y);
        break;
      }
    }
    for (i = 1; i < table.length; i += cols) {
      if (table[i].contains(y)) {
        break;
      }
    }
    if (i + col < table.length) {
      return table[(i + col) - 1];
    } else {
      return "X";
    }
  }

  /**
   <p>
   @param name  String to print
   @param table String[] to print
   */
  public static void printTable(String name, String[] table) {
    int colss = Integer.parseInt(table[0]);
    int roww = 0;
    System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
    System.out.println(name.toUpperCase());
    System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
    for (int i = 1; i < table.length; i++) {
      System.out.print(table[i] + "\t");
      if (i % colss == 0) {
        System.out.println();
        roww += 1;
      }
    }
    System.out.println();
  }

  /**
   <p>
   @param g Graphics
   */
  @Override
  public void paintComponent(Graphics g) {
    //<editor-fold defaultstate="collapsed" desc="left panel">
    try {
      super.paintComponent(g);
      //      w = jLabel5.getWidth();
      //      h = jLabel5.getHeight();
      g.setColor(color);
      g.fillRect(0, 0, 100, 100);
      g.setColor(Color.black);
      g.drawRect(0, 0, 100, 100);

      //g = jLabel5.getGraphics();
      //Graphics2D g2 = (Graphics2D) g;
      Image im = ImageIO.read(new File(_GIF + "lines.gif"));
      g.drawImage(im, Panel4UTP.centerOnX(im, 0, 100),
        Panel4UTP.centerOnY(im, 0, 100), null);

      // Squadron Type
      BufferedImage bii1 = Panel4UTP.strToSmall(3, 5,
        jComboBox0.getSelectedItem().toString().substring(0, 2));
      g.drawImage(bii1, Panel4UTP.centerOnX(bii1, 29, 0), 25, null);
      try {
        // Home hex
        BufferedImage bi1 = Panel4UTP.strToSmall(3, 5, jf.getTitle()
          .substring(0, 4));
        g.drawImage(bi1, Panel4UTP.centerOnX(bi1, 51, 0), 25, null);
        // Fleet ID
        BufferedImage bi11 = Panel4UTP.strToSmall(3, 5, sidn.getText());
        g.drawImage(bi11, Panel4UTP.centerOnX(bi11, 51, 0), 31, null);

        // Streamlining and Jump to middle left box
        BufferedImage bi00 = Panel4UTP.strToSmall(3, 5, ns.getText()
          .substring(0, 1) + "SL");
        g.drawImage(bi00, Panel4UTP.centerOnX(bi00, 29, 0), 43, null);
        //      int s1 = jtf4CF.getText().indexOf("(");
        BufferedImage bi0021 = Panel4UTP.strToSmall(3, 5, "J" + nj.getText());
        g.drawImage(bi0021, Panel4UTP.centerOnX(bi0021, 29, 0), 49, null);

        // TF to middle right box
        BufferedImage bi0 = Panel4UTP.strToSmall(3, 5, "TF");
        g.drawImage(bi0, Panel4UTP.centerOnX(bi0, 73, 0), 43, null);
        //      int s1 = jtf4CF.getText().indexOf("(");
        BufferedImage bi021 = Panel4UTP.strToSmall(3, 5, nt.getText());
        g.drawImage(bi021, Panel4UTP.centerOnX(bi021, 73, 0), 49, null);

        // DF to bottom left box
        BufferedImage bi2 = Panel4UTP.strToSmall(3, 5, "DF");
        g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 29, 0), 61, null);
        //      int s1 = jtf4CF.getText().indexOf("(");
        BufferedImage bi21 = Panel4UTP.strToSmall(3, 5, nd.getText());
        g.drawImage(bi21, Panel4UTP.centerOnX(bi21, 29, 0), 67, null);

        // AF to bottom middle box
        BufferedImage bi3 = Panel4UTP.strToSmall(3, 5, "AF");
        g.drawImage(bi3, Panel4UTP.centerOnX(bi3, 51, 0), 61, null);
        //      int s2 = jtf4CF.getText().indexOf(")");
        BufferedImage bi31 = Panel4UTP.strToSmall(3, 5, na.getText());
        g.drawImage(bi31, Panel4UTP.centerOnX(bi31, 51, 0), 67, null);

        // BF to bottom right box
        BufferedImage bi4 = Panel4UTP.strToSmall(3, 5, "BF");
        g.drawImage(bi4, Panel4UTP.centerOnX(bi4, 73, 0), 61, null);
        BufferedImage bi41 = Panel4UTP.strToSmall(3, 5, nb.getText());
        g.drawImage(bi41, Panel4UTP.centerOnX(bi41, 73, 0), 67, null);
        //    } catch (IOException ex) {
        //      Logger.getLogger(Panel4UTP.class.getName()).log(Level.SEVERE, null, ex);
        //    }
      } catch (Exception e) {

      }
    } catch (IOException ex) {
      Logger.getLogger(Panel4Squadron.class.getName()).log(Level.SEVERE, null,
        ex);
      System.out.println("" + " = " + ex.toString());
    }
    BufferedImage pc = null;
    try {
      pc = ImageIO.read(new File(folder + pic));
      g.drawImage(pc, Panel4UTP.centerOnX(pc, 50, 0), 46, null);
    } catch (IOException ex) {
      Logger.getLogger(Panel4Squadron.class.getName()).log(Level.SEVERE, null,
        ex);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="right panel">
    //2nd Panel
    int left = 100;
    int tops = 0;
    int wid = 100;
    int hgt = 100;
    int r = 10;
    g.setColor(color);
    g.fillRect(left, tops, wid, hgt);
    g.setColor(Color.black);
    g.drawRect(left, tops, wid, hgt);
    titles = new String[]{"ID", "TYPE", "S/L", "JUMP", "TF", "DF", "AF", "BF"};
    values = new String[]{sidn.getText(), sron.getText(), ns.getText(),
      nj.getText(), nt.getText(), nd.getText(), na.getText(), nb.getText()
    };
    for (int i = 0; i < 8; i++) {
      g.drawString(titles[i], left + 2, tops + 15 + (i * 11));
      g.drawString(values[i], left + 37, tops + 15 + (i * 11));
    }
    //</editor-fold>//Right
  }

  @SuppressWarnings("unchecked")
  static void addLine() {
    Double spare = Double.parseDouble(jLabel12.getText());
    values[0] = "" + jTextArea1.getLineCount();
    String val = "";
    if (values[0].length() == 1) {
      val += "00";
    } else {
      val += "0";
    }
    values[0] = val + values[0];
    if (spare - cost >= 0) {
      countCost();
      printCounter();
      getNumber();
      doMath();
    }
    toComboBox(jTextArea1, jComboBox1);
//    GlobalMethods.toTextArea(jComboBox1, rons);
    jComboBox1.setSelectedIndex(jComboBox1.getItemCount() - 1);
    Panel4UTP.image2Pic("squadron");
  }

  @SuppressWarnings("unchecked")
  static void delete() {
    Panel4UTP.deletePics("squadron");
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
//</editor-fold>
    jTextArea1.setText("");
    Panel4UTP.toComboBox(jTextArea1, jComboBox1);
    doMath();
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel20 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    sdbs = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    jLabel32 = new javax.swing.JLabel();
    jLabel37 = new javax.swing.JLabel();
    jLabel36 = new javax.swing.JLabel();
    jLabel19 = new javax.swing.JLabel();
    jLabel39 = new javax.swing.JLabel();
    jLabel31 = new javax.swing.JLabel();
    jLabel26 = new javax.swing.JLabel();
    jLabel25 = new javax.swing.JLabel();
    jLabel28 = new javax.swing.JLabel();
    jLabel42 = new javax.swing.JLabel();
    jLabel22 = new javax.swing.JLabel();
    UWP = new javax.swing.JLabel();
    jLabel35 = new javax.swing.JLabel();
    jLabel33 = new javax.swing.JLabel();
    jLabel24 = new javax.swing.JLabel();
    jLabel30 = new javax.swing.JLabel();
    jLabel23 = new javax.swing.JLabel();
    squadrons = new javax.swing.JLabel();
    defbats = new javax.swing.JLabel();
    troopunits = new javax.swing.JLabel();
    jLabel40 = new javax.swing.JLabel();
    jLabel34 = new javax.swing.JLabel();
    jLabel21 = new javax.swing.JLabel();
    jLabel38 = new javax.swing.JLabel();
    jLabel29 = new javax.swing.JLabel();
    jLabel41 = new javax.swing.JLabel();
    jLabel27 = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    jLabel44 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jPanel6 = new javax.swing.JPanel();
    jPanel4 = new javax.swing.JPanel();
    jComboBox0 = new javax.swing.JComboBox();
    jScrollPane2 = new javax.swing.JScrollPane();
    jList2 = new javax.swing.JList();
    jPanel2 = new javax.swing.JPanel();
    sj = new javax.swing.JLabel();
    ss = new javax.swing.JLabel();
    sd = new javax.swing.JLabel();
    sa = new javax.swing.JLabel();
    sb = new javax.swing.JLabel();
    st = new javax.swing.JLabel();
    nj = new javax.swing.JLabel();
    ns = new javax.swing.JLabel();
    nd = new javax.swing.JLabel();
    na = new javax.swing.JLabel();
    nb = new javax.swing.JLabel();
    nt = new javax.swing.JLabel();
    md = new javax.swing.JLabel();
    os = new javax.swing.JLabel();
    mb = new javax.swing.JLabel();
    ob = new javax.swing.JLabel();
    mt = new javax.swing.JLabel();
    oa = new javax.swing.JLabel();
    mj = new javax.swing.JLabel();
    ma = new javax.swing.JLabel();
    ot = new javax.swing.JLabel();
    od = new javax.swing.JLabel();
    oj = new javax.swing.JLabel();
    ms = new javax.swing.JLabel();
    stype = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    sid = new javax.swing.JLabel();
    sron = new javax.swing.JLabel();
    sidn = new javax.swing.JLabel();
    jPanel5 = new javax.swing.JPanel();
    jComboBox1 = new javax.swing.JComboBox();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jLabel12 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    num = new javax.swing.JLabel();
    jLabel18 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();
    jLabel17 = new javax.swing.JLabel();
    jLabel43 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();

    jLabel20.setForeground(new java.awt.Color(255, 0, 0));
    jLabel20.setText("TL");

    jLabel5.setText("NOT ENOUGH");

    jLabel6.setText("jLabel6");

    sdbs.setForeground(new java.awt.Color(255, 0, 0));
    sdbs.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    sdbs.setText("0");

    jPanel1.setOpaque(false);

    jLabel32.setForeground(new java.awt.Color(192, 192, 192));
    jLabel32.setText("0");

    jLabel37.setForeground(new java.awt.Color(255, 0, 0));
    jLabel37.setText("UWP");
    jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel37MouseClicked(evt);
      }
    });

    jLabel36.setForeground(new java.awt.Color(255, 0, 0));
    jLabel36.setText("SDB Squadrons");
    jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel36MouseClicked(evt);
      }
    });

    jLabel19.setForeground(new java.awt.Color(192, 192, 192));
    jLabel19.setText("TL");

    jLabel39.setForeground(new java.awt.Color(192, 192, 192));
    jLabel39.setText("Pop");

    jLabel31.setForeground(new java.awt.Color(192, 192, 192));
    jLabel31.setText("=");

    jLabel26.setForeground(new java.awt.Color(192, 192, 192));
    jLabel26.setText("0");

    jLabel25.setForeground(new java.awt.Color(192, 192, 192));
    jLabel25.setText("0");

    jLabel28.setForeground(new java.awt.Color(192, 192, 192));
    jLabel28.setText("=");

    jLabel42.setForeground(new java.awt.Color(255, 0, 0));
    jLabel42.setText("Troop Points");
    jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel42MouseClicked(evt);
      }
    });

    jLabel22.setForeground(new java.awt.Color(192, 192, 192));
    jLabel22.setText("Inf");

    UWP.setForeground(new java.awt.Color(255, 0, 0));
    UWP.setText("A569ABBD-F9D4");
    UWP.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        UWPMouseClicked(evt);
      }
    });
    UWP.addInputMethodListener(new java.awt.event.InputMethodListener() {
      public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
      }
      public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
        UWPInputMethodTextChanged(evt);
      }
    });
    UWP.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        UWPPropertyChange(evt);
      }
    });

    jLabel35.setForeground(new java.awt.Color(192, 192, 192));
    jLabel35.setText("0");

    jLabel33.setForeground(new java.awt.Color(192, 192, 192));
    jLabel33.setText("0");

    jLabel24.setForeground(new java.awt.Color(192, 192, 192));
    jLabel24.setText("0");

    jLabel30.setForeground(new java.awt.Color(192, 192, 192));
    jLabel30.setText("=");

    jLabel23.setForeground(new java.awt.Color(192, 192, 192));
    jLabel23.setText("Cul");

    squadrons.setForeground(new java.awt.Color(255, 0, 0));
    squadrons.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    squadrons.setText("0");

    defbats.setForeground(new java.awt.Color(255, 0, 0));
    defbats.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    defbats.setText("0");

    troopunits.setForeground(new java.awt.Color(255, 0, 0));
    troopunits.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    troopunits.setText("0");

    jLabel40.setForeground(new java.awt.Color(255, 0, 0));
    jLabel40.setText("Squadron pts");
    jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel40MouseClicked(evt);
      }
    });

    jLabel34.setForeground(new java.awt.Color(192, 192, 192));
    jLabel34.setText("0");

    jLabel21.setForeground(new java.awt.Color(192, 192, 192));
    jLabel21.setText("Res");

    jLabel38.setForeground(new java.awt.Color(192, 192, 192));
    jLabel38.setText("0");

    jLabel29.setForeground(new java.awt.Color(192, 192, 192));
    jLabel29.setText("=");

    jLabel41.setForeground(new java.awt.Color(255, 0, 0));
    jLabel41.setText("Def. Batt. CF");
    jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel41MouseClicked(evt);
      }
    });

    jLabel27.setForeground(new java.awt.Color(192, 192, 192));
    jLabel27.setText("0");

    jLabel44.setForeground(new java.awt.Color(255, 0, 0));
    jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel44.setText("0");
    jLabel44.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

    jLabel9.setForeground(new java.awt.Color(255, 0, 0));
    jLabel9.setText(" Squadron");
    jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel9MouseClicked(evt);
      }
    });

    jLabel2.setForeground(new java.awt.Color(255, 0, 0));
    jLabel2.setText("n");

    jLabel3.setForeground(new java.awt.Color(255, 0, 0));
    jLabel3.setText("o");

    jLabel1.setForeground(new java.awt.Color(255, 0, 0));
    jLabel1.setText("s");

    jLabel4.setForeground(new java.awt.Color(255, 0, 0));
    jLabel4.setText("m");

    jLabel11.setForeground(new java.awt.Color(255, 0, 0));
    jLabel11.setText("0");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(jLabel1)
        .addGap(5, 5, 5)
        .addComponent(jLabel11)
        .addGap(18, 18, 18)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addGap(26, 26, 26)
            .addComponent(jLabel3)
            .addGap(27, 27, 27)
            .addComponent(jLabel4))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jLabel2)
          .addComponent(jLabel3)
          .addComponent(jLabel4))
        .addGap(22, 22, 22)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel11)
          .addComponent(jLabel44)
          .addComponent(jLabel9))
        .addContainerGap())
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel40)
              .addComponent(jLabel36)
              .addComponent(jLabel42)
              .addComponent(jLabel41)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel39)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel38))
                  .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(jLabel19)
                      .addComponent(jLabel21)
                      .addComponent(jLabel22)
                      .addComponent(jLabel23))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(jLabel27)
                      .addComponent(jLabel24)
                      .addComponent(jLabel25)
                      .addComponent(jLabel26))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel29)
                  .addComponent(jLabel30)
                  .addComponent(jLabel31)
                  .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel34)
                  .addComponent(jLabel33)
                  .addComponent(jLabel32)
                  .addComponent(jLabel35))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(troopunits, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                  .addComponent(defbats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(squadrons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(7, 7, 7)
            .addComponent(jLabel37)
            .addGap(5, 5, 5)
            .addComponent(UWP))))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel37)
          .addComponent(UWP))
        .addGap(0, 0, 0)
        .addComponent(jLabel36)
        .addGap(0, 0, 0)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(squadrons)
          .addComponent(jLabel40))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel41)
          .addComponent(defbats))
        .addGap(0, 0, 0)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel42)
          .addComponent(troopunits))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel31)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel28)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel29)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel27)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel24)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel25)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );

    setMaximumSize(new java.awt.Dimension(200, 100));
    setMinimumSize(new java.awt.Dimension(200, 100));
    setOpaque(true);
    setPreferredSize(new java.awt.Dimension(200, 100));
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        formMouseClicked(evt);
      }
    });

    jPanel6.setBackground(new java.awt.Color(0, 0, 0));

    jPanel4.setName(""); // NOI18N
    jPanel4.setOpaque(false);

    jComboBox0.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AR-Assault", "BR-Battle", "CR-Cruiser", "SR-Scout", "TR-Tanker" }));
    jComboBox0.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jComboBox0MouseClicked(evt);
      }
    });
    jComboBox0.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox0ActionPerformed(evt);
      }
    });

    jList2.setToolTipText("Click green labels to populate");
    jList2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList2MouseClicked(evt);
      }
    });
    jScrollPane2.setViewportView(jList2);

    jPanel2.setOpaque(false);

    sj.setForeground(new java.awt.Color(0, 255, 0));
    sj.setText("JUMP");
    sj.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        sjMouseClicked(evt);
      }
    });

    ss.setForeground(new java.awt.Color(0, 255, 0));
    ss.setText("S/L");
    ss.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        ssMouseClicked(evt);
      }
    });

    sd.setForeground(new java.awt.Color(0, 255, 0));
    sd.setText("DF");
    sd.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        sdMouseClicked(evt);
      }
    });

    sa.setForeground(new java.awt.Color(0, 255, 0));
    sa.setText("AF");
    sa.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        saMouseClicked(evt);
      }
    });

    sb.setForeground(new java.awt.Color(0, 255, 0));
    sb.setText("BF");
    sb.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        sbMouseClicked(evt);
      }
    });

    st.setForeground(new java.awt.Color(255, 0, 0));
    st.setText("TF");
    st.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        stMouseClicked(evt);
      }
    });

    nj.setForeground(new java.awt.Color(255, 0, 0));
    nj.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    nj.setText("0");
    nj.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        njMouseClicked(evt);
      }
    });

    ns.setForeground(new java.awt.Color(255, 0, 0));
    ns.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    ns.setText("U");
    ns.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        nsMouseClicked(evt);
      }
    });
    ns.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        nsPropertyChange(evt);
      }
    });

    nd.setForeground(new java.awt.Color(255, 0, 0));
    nd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    nd.setText("0");
    nd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        ndPropertyChange(evt);
      }
    });

    na.setForeground(new java.awt.Color(255, 0, 0));
    na.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    na.setText("0");
    na.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        naMouseClicked(evt);
      }
    });

    nb.setForeground(new java.awt.Color(255, 0, 0));
    nb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    nb.setText("0");
    nb.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        nbMouseClicked(evt);
      }
    });

    nt.setForeground(new java.awt.Color(255, 0, 0));
    nt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    nt.setText("0");
    nt.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        ntMouseClicked(evt);
      }
    });

    md.setForeground(new java.awt.Color(255, 0, 0));
    md.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    md.setText("0");
    md.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

    os.setForeground(new java.awt.Color(255, 0, 0));
    os.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    os.setText("U");
    os.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        osMouseClicked(evt);
      }
    });
    os.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        osPropertyChange(evt);
      }
    });

    mb.setForeground(new java.awt.Color(255, 0, 0));
    mb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    mb.setText("0");
    mb.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    mb.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        mbMouseClicked(evt);
      }
    });

    ob.setForeground(new java.awt.Color(255, 0, 0));
    ob.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    ob.setText("0");
    ob.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        obMouseClicked(evt);
      }
    });

    mt.setForeground(new java.awt.Color(255, 0, 0));
    mt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    mt.setText("0");
    mt.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    mt.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        mtMouseClicked(evt);
      }
    });

    oa.setForeground(new java.awt.Color(255, 0, 0));
    oa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    oa.setText("0");
    oa.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        oaMouseClicked(evt);
      }
    });

    mj.setForeground(new java.awt.Color(255, 0, 0));
    mj.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    mj.setText("0");
    mj.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    mj.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        mjMouseClicked(evt);
      }
    });

    ma.setForeground(new java.awt.Color(255, 0, 0));
    ma.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    ma.setText("0");
    ma.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    ma.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        maMouseClicked(evt);
      }
    });

    ot.setForeground(new java.awt.Color(255, 0, 0));
    ot.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    ot.setText("0");
    ot.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        otMouseClicked(evt);
      }
    });

    od.setForeground(new java.awt.Color(255, 0, 0));
    od.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    od.setText("0");
    od.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    od.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        odPropertyChange(evt);
      }
    });

    oj.setForeground(new java.awt.Color(255, 0, 0));
    oj.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    oj.setText("0");
    oj.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        ojMouseClicked(evt);
      }
    });

    ms.setForeground(new java.awt.Color(255, 0, 0));
    ms.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    ms.setText("U");
    ms.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
    ms.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        msMouseClicked(evt);
      }
    });
    ms.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        msPropertyChange(evt);
      }
    });

    stype.setForeground(new java.awt.Color(255, 0, 0));
    stype.setText("TYPE");

    jLabel10.setForeground(new java.awt.Color(255, 0, 0));
    jLabel10.setText("0");

    sid.setForeground(new java.awt.Color(255, 0, 0));
    sid.setText("ID");
    sid.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        sidMouseClicked(evt);
      }
    });

    sron.setForeground(new java.awt.Color(255, 0, 0));
    sron.setText("TYPE");

    sidn.setForeground(new java.awt.Color(255, 0, 0));
    sidn.setText("001");
    sidn.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        sidnMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(ss)
                .addComponent(st)
                .addComponent(sd)
                .addComponent(sa)
                .addComponent(sb))
              .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
              .addComponent(sj)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(stype)
              .addComponent(sid))
            .addGap(12, 12, 12)))
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(na, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(nd, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
              .addComponent(ns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(nj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(sidn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(nt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(nb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(0, 0, 0)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(oa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(ob, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(os, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(oj, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(ot, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(od, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(2, 2, 2)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(mt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(mb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(ms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(mj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(ma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(md, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(sron, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(2, 2, 2)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );

    jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {na, nb, nd, nj});

    jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {od, oj, os});

    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(nj)
              .addComponent(sj))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(ns)
              .addComponent(ss))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(sd)
              .addComponent(nd))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(sa)
              .addComponent(na))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(nb)
              .addComponent(sb))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(st)
              .addComponent(nt)))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(oj)
              .addComponent(mj))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(os)
              .addComponent(ms))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(od)
              .addComponent(md))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(oa)
              .addComponent(ma))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(ob)
              .addComponent(mb))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(ot)
              .addComponent(mt))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(stype)
          .addComponent(sron, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(sid)
          .addComponent(sidn)
          .addComponent(jLabel10))
        .addGap(0, 0, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jComboBox0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addComponent(jComboBox0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );

    jPanel5.setOpaque(false);

    jComboBox1.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        jComboBox1ItemStateChanged(evt);
      }
    });
    jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jComboBox1MouseClicked(evt);
      }
    });
    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox1ActionPerformed(evt);
      }
    });
    jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jComboBox1PropertyChange(evt);
      }
    });

    jButton1.setText("ADD");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setText("X");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
      .addComponent(jButton1)
      .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jButton1)
        .addGap(0, 0, 0)
        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jButton2))
    );

    jLabel12.setBackground(new java.awt.Color(255, 255, 255));
    jLabel12.setForeground(java.awt.Color.lightGray);
    jLabel12.setText("0");
    jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel12jLabelMouseClicked(evt);
      }
    });

    jLabel8.setBackground(new java.awt.Color(255, 255, 255));
    jLabel8.setForeground(new java.awt.Color(0, 255, 0));
    jLabel8.setText("Pts");
    jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel8MouseClicked(evt);
      }
    });

    num.setBackground(new java.awt.Color(255, 255, 255));
    num.setForeground(java.awt.Color.lightGray);
    num.setText("0.0");
    num.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        numjLabelMouseClicked(evt);
      }
    });

    jLabel18.setBackground(new java.awt.Color(255, 255, 255));
    jLabel18.setForeground(java.awt.Color.lightGray);
    jLabel18.setText("=");

    jLabel7.setBackground(new java.awt.Color(255, 255, 255));
    jLabel7.setForeground(java.awt.Color.lightGray);
    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel7.setText("1.0");

    jLabel16.setBackground(new java.awt.Color(255, 255, 255));
    jLabel16.setForeground(java.awt.Color.lightGray);
    jLabel16.setText("A");

    jLabel17.setBackground(new java.awt.Color(255, 255, 255));
    jLabel17.setForeground(new java.awt.Color(0, 255, 0));
    jLabel17.setText("TL");
    jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabel17MouseClicked(evt);
      }
    });

    jLabel43.setForeground(new java.awt.Color(255, 0, 0));
    jLabel43.setText("pts");

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel6Layout.createSequentialGroup()
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(num)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12))
              .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jLabel17)
                    .addGap(0, 0, 0)
                    .addComponent(jLabel16)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE)))
            .addContainerGap())
          .addGroup(jPanel6Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel43)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    jPanel6Layout.setVerticalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 3, Short.MAX_VALUE))
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel18)
            .addComponent(jLabel12))
          .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel8)
            .addComponent(num)))
        .addGap(0, 0, 0)
        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel17)
          .addComponent(jLabel16)
          .addComponent(jLabel7))
        .addGap(44, 44, 44)
        .addComponent(jLabel43)
        .addContainerGap())
    );

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextArea1MouseClicked(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jTextArea1MousePressed(evt);
      }
    });
    jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        jTextArea1KeyPressed(evt);
      }
      public void keyTyped(java.awt.event.KeyEvent evt) {
        jTextArea1KeyTyped(evt);
      }
    });
    jScrollPane1.setViewportView(jTextArea1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(34, 34, 34)
        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(133, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addGap(0, 0, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
    worldUpdate();
  }//GEN-LAST:event_jLabel36MouseClicked

  private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
    try {
      jLabel9MouseClicked(evt);
    } catch (Exception e) {
      System.out.println("" + " = " + e.toString());
    }
    try {
//      jLabel15MouseClicked(evt);
    } catch (Exception e) {
      System.out.println("" + " = " + e.toString());
    }
    try {
//      jLabel19MouseClicked(evt);
    } catch (Exception e) {
      System.out.println("" + " = " + e.toString());
    }
    try {
//      jLabel22MouseClicked(evt);
    } catch (Exception e) {
      System.out.println("" + " = " + e.toString());
    }
//    worldUpdate();
  }//GEN-LAST:event_jLabel37MouseClicked

  private void UWPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UWPMouseClicked
//    update();
    //    System.out.println("UWP.getText().length()" + " = " + UWP.getText().length());
  }//GEN-LAST:event_UWPMouseClicked

  private void UWPInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_UWPInputMethodTextChanged
//    update();
  }//GEN-LAST:event_UWPInputMethodTextChanged

  private void UWPPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_UWPPropertyChange
//    update();
  }//GEN-LAST:event_UWPPropertyChange

  private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
    worldUpdate();
  }//GEN-LAST:event_jLabel40MouseClicked

  private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
    worldUpdate();
  }//GEN-LAST:event_jLabel41MouseClicked

  private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
//    worldUpdate();
    Panel4UTP.main(new String[]{troopunits.getText(), tl});
    Panel4UTP.setHeight(300);
    Panel4UTP.setTop(300);
  }//GEN-LAST:event_jLabel42MouseClicked

  private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
//<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
//</editor-fold>
    String choice = "X";
    try {
      choice = this.jList2.getSelectedValue().toString();
      System.out.println("choice" + " = " + choice);
    } catch (Exception e) {
    }
    String first = choice.substring(0, 1);
    int leng = choice.length();
    switch (leng) {
      case 5:
      case 6: {
        ms.setText(choice.substring(4));
        ns.setText(first);
        os.setText(first);
        break;
      }
      case 9: {
        String mod1 = choice.substring(0, 4);
        String mod2 = choice.substring(5);
        String txt = "";
        for (int i = 0; i < 2; i++) {
          if (i == 0) {
            txt = mod1;
          } else {
            txt = mod2;
          }
          String val = txt.substring(2);
          System.out.println("val" + " = " + val);
          switch (txt.substring(0, 1)) {
            case "J": {
              labm = mj;
              break;
            }
            case "D": {
              labm = md;
              break;
            }
            case "A": {
              labm = ma;
              break;
            }
            case "B": {
              labm = mb;
              break;
            }
          }
          int v = Integer.parseInt(val);
          switch (first) {
            case "A": {
//              pic = "";
              break;
            }
            case "B": {
//              pic = "";
              break;
            }
            case "C": {
//              pic = "";
              break;
            }
            case "S": {
//              pic = "";
              break;
            }
            case "": {
//              pic = "";
              break;
            }
          }
          labm.setText(val);
        }
        break;
      }
    }
    updateOld();
    repaint();
  }//GEN-LAST:event_jList2MouseClicked

  private void naMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_naMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_naMouseClicked

  private void sbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sbMouseClicked
    setOptions("Bf");
  }//GEN-LAST:event_sbMouseClicked

  private void nsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nsMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_nsMouseClicked

  private void sidnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidnMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_sidnMouseClicked

  private void sjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sjMouseClicked
    setOptions("Jump");
  }//GEN-LAST:event_sjMouseClicked

  private void ssMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ssMouseClicked
//    try {
//      olddf = od.getText();
//      oldsl = ns.getText();
//      df = olddf;
//      sl = oldsl;
//    } catch (Exception e) {
//    }
    setOptions("Sl");
  }//GEN-LAST:event_ssMouseClicked

  private void njMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_njMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_njMouseClicked

  private void ntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ntMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_ntMouseClicked

  private void sdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sdMouseClicked
    setOptions("Df");
  }//GEN-LAST:event_sdMouseClicked

  private void saMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saMouseClicked
    setOptions("Af");
  }//GEN-LAST:event_saMouseClicked

  private void odPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_odPropertyChange
    jLabel44.setText(od.getText());
  }//GEN-LAST:event_odPropertyChange

  private void nbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nbMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_nbMouseClicked

  private void sidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidMouseClicked
  }//GEN-LAST:event_sidMouseClicked

  private void stMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stMouseClicked
    setOptions("Tf");
  }//GEN-LAST:event_stMouseClicked

  private void nsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_nsPropertyChange
    calc();
  }//GEN-LAST:event_nsPropertyChange

  private void osMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_osMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_osMouseClicked

  private void osPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_osPropertyChange
    // TODO add your handling code here:
  }//GEN-LAST:event_osPropertyChange

  private void ojMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ojMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_ojMouseClicked

  private void obMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_obMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_obMouseClicked

  private void otMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_otMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_otMouseClicked

  private void oaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oaMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_oaMouseClicked

  private void msMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_msMouseClicked

  private void msPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_msPropertyChange
    // TODO add your handling code here:
  }//GEN-LAST:event_msPropertyChange

  private void mtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mtMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_mtMouseClicked

  private void maMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_maMouseClicked

  private void mjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mjMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_mjMouseClicked

  private void mbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mbMouseClicked
    // TODO add your handling code here:
  }//GEN-LAST:event_mbMouseClicked

  private void ndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ndPropertyChange
    if (jComboBox0.getSelectedItem().toString().startsWith("CR")) {
      nt.setText(nd.getText());
    }
  }//GEN-LAST:event_ndPropertyChange

  private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    }
    //</editor-fold>
    System.out.println("PRINT TABLE");
    for (int i = 0; i < tables.length; i++) {
      printTable(tablenames[i], tables[i]);
    }
    String startname = "/IS-";
    //    GlobalMethods.saveCSVs(jTextArea6, tables, tablenames, startname);
  }//GEN-LAST:event_jLabel9MouseClicked

  private void jComboBox0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox0ActionPerformed
    sron.setText(jComboBox0.getSelectedItem().toString());
    ron = jComboBox0.getSelectedItem().toString().substring(0, 2);
    switch (ron) { // set cost to have selected squadron type
      case "AR": {
        cost = 2.0;
        //num.setText("2.0");
        pic = "Ass.gif";
        break;
      }
      case "BR": {
        cost = 2.0;
        //num.setText("2.0");
        pic = "BatRon.gif";
        break;
      }
      case "CR": {
        cost = 1.0;
        //num.setText("1.0");
        pic = "CruRon.gif";
        break;
      }
      case "SR": {
        cost = 0.5;
        //num.setText("0.5");
        pic = "ScoutRon.gif";
        break;
      }
      case "TR": {
        cost = 3.0;
        //num.setText("3.0");
        pic = "TankRon.gif";
        break;
      }
    }
//    g2 = (Graphics2D) jLabel5.getGraphics();
    ImageIcon imic = new ImageIcon(Toolkit.getDefaultToolkit().createImage(
      folder + pic));
    System.out.println("" + " = " + folder + pic);
//    jLabel5.setIcon(imic);
    System.out.println("pic" + " = " + pic);
    nd.setText(od.getText());
    jLabel9.setText(jComboBox0.getSelectedItem().toString().substring(3) + top);
    calcWorld();
    calc();
    ssMouseClicked(me);
    md.setText("0");
    ms.setText("0");
    ns.setText("U");
    os.setText("U");
    repaint();
    if (Double.parseDouble(jLabel7.getText()) - Double
      .parseDouble(num.getText()) >= 0) {
      jLabel5.setVisible(false);
    } else {
      jLabel5.setVisible(true);
    }
    jButton1.setToolTipText("" + cost + " pts");
  }//GEN-LAST:event_jComboBox0ActionPerformed

  private void jComboBox0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox0MouseClicked
    repaint();
  }//GEN-LAST:event_jComboBox0MouseClicked

  @SuppressWarnings("unchecked")
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    addLine();
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
    doMath();
    jLabel12.setText("" + (Double.parseDouble(jLabel7.getText()) - Double
      .parseDouble(num.getText())));
    updatePic("squadron");
  }//GEN-LAST:event_jTextArea1MouseClicked

  private void jLabel12jLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12jLabelMouseClicked
//    jLabel12.setText("" + (Integer.parseInt(jLabel7.getText()) - Double.parseDouble(num.getText())));
//    num.setText("0");
  }//GEN-LAST:event_jLabel12jLabelMouseClicked

  private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
    String num = Panel4T5Locator.UWP.substring(8, 9);
    jLabel16.setText("" + GlobalMethods.fromHex(num));
//    jLabel16.setText(JOptionPane.showInputDialog("Enter TL", Panel4T5Locator.UWP.substring(8, 9)));
//    calcUTP();
    repaint();
  }//GEN-LAST:event_jLabel17MouseClicked

  private void numjLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numjLabelMouseClicked
//    num.setText("0");
//    jLabel12.setText("0");
//    countPoints();
  }//GEN-LAST:event_numjLabelMouseClicked

  private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
    jLabel7.setText(Panel4T5Locator.squadrons.getText());
//    jLabel7.setText(JOptionPane.showInputDialog("Enter Points", Panel4T5Locator.squadrons.getText()));
    doMath();
    repaint();
  }//GEN-LAST:event_jLabel8MouseClicked

  private void jTextArea1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MousePressed
    doMath();
  }//GEN-LAST:event_jTextArea1MousePressed

  private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
    doMath();
  }//GEN-LAST:event_jTextArea1KeyPressed

  private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
    doMath();
  }//GEN-LAST:event_jTextArea1KeyTyped

  @SuppressWarnings("unchecked")
  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    delete();
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
//    System.out.println("jComboBox2ActionPerformed(java.awt.event.ActionEvent evt)");
    Panel4UTP.updatePic("squadron");
  }//GEN-LAST:event_jComboBox1ActionPerformed

  private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
//    System.out.println("jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt)");
  }//GEN-LAST:event_jComboBox1ItemStateChanged

  private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
//    System.out.println("jComboBox2MouseClicked(java.awt.event.MouseEvent evt)");
  }//GEN-LAST:event_jComboBox1MouseClicked

  private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange
//    System.out.println("jComboBox2PropertyChange(java.beans.PropertyChangeEvent evt)");
    Panel4UTP.updatePic("squadron");
  }//GEN-LAST:event_jComboBox1PropertyChange

  private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    if (evt.getClickCount() > 1) {
      JPanel p4c = new Panel4("Colours");
      JColorChooser jcc = new JColorChooser(JColorChooser.showDialog(p4c, FS,
        Color.LIGHT_GRAY));
      color = jcc.getColor();
      jcc.setVisible(true);
      jp.setBackground(color);
      jf.setBackground(color);
//      Panel4UTP.image2Pic("squadron");
    }
  }//GEN-LAST:event_formMouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private static javax.swing.JLabel UWP;
  private static javax.swing.JLabel defbats;
  static javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  public static javax.swing.JComboBox jComboBox0;
  public static javax.swing.JComboBox jComboBox1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private static javax.swing.JLabel jLabel12;
  private static javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel18;
  public static javax.swing.JLabel jLabel19;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel20;
  public static javax.swing.JLabel jLabel21;
  public static javax.swing.JLabel jLabel22;
  public static javax.swing.JLabel jLabel23;
  public static javax.swing.JLabel jLabel24;
  public static javax.swing.JLabel jLabel25;
  public static javax.swing.JLabel jLabel26;
  public static javax.swing.JLabel jLabel27;
  public static javax.swing.JLabel jLabel28;
  public static javax.swing.JLabel jLabel29;
  private javax.swing.JLabel jLabel3;
  public static javax.swing.JLabel jLabel30;
  public static javax.swing.JLabel jLabel31;
  public static javax.swing.JLabel jLabel32;
  public static javax.swing.JLabel jLabel33;
  public static javax.swing.JLabel jLabel34;
  public static javax.swing.JLabel jLabel35;
  private static javax.swing.JLabel jLabel36;
  private static javax.swing.JLabel jLabel37;
  public static javax.swing.JLabel jLabel38;
  public static javax.swing.JLabel jLabel39;
  private javax.swing.JLabel jLabel4;
  private static javax.swing.JLabel jLabel40;
  private static javax.swing.JLabel jLabel41;
  private static javax.swing.JLabel jLabel42;
  private javax.swing.JLabel jLabel43;
  private javax.swing.JLabel jLabel44;
  private javax.swing.JLabel jLabel5;
  public static javax.swing.JLabel jLabel6;
  private static javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JList jList2;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  public static javax.swing.JTextArea jTextArea1;
  public static javax.swing.JLabel ma;
  public static javax.swing.JLabel mb;
  private javax.swing.JLabel md;
  public static javax.swing.JLabel mj;
  public static javax.swing.JLabel ms;
  public static javax.swing.JLabel mt;
  public static javax.swing.JLabel na;
  public static javax.swing.JLabel nb;
  static javax.swing.JLabel nd;
  public static javax.swing.JLabel nj;
  public static javax.swing.JLabel ns;
  public static javax.swing.JLabel nt;
  private static javax.swing.JLabel num;
  public static javax.swing.JLabel oa;
  public static javax.swing.JLabel ob;
  public static javax.swing.JLabel od;
  public static javax.swing.JLabel oj;
  public static javax.swing.JLabel os;
  public static javax.swing.JLabel ot;
  public static javax.swing.JLabel sa;
  private javax.swing.JLabel sb;
  public static javax.swing.JLabel sd;
  private static javax.swing.JLabel sdbs;
  private javax.swing.JLabel sid;
  public static javax.swing.JLabel sidn;
  public static javax.swing.JLabel sj;
  private static javax.swing.JLabel squadrons;
  static javax.swing.JLabel sron;
  public static javax.swing.JLabel ss;
  private javax.swing.JLabel st;
  private javax.swing.JLabel stype;
  private static javax.swing.JLabel troopunits;
  // End of variables declaration//GEN-END:variables

  @SuppressWarnings("unchecked")
  private void setOptions(String txt1) {
    DefaultListModel dlm = new DefaultListModel();
    double sss = 1;
    int v = 0;
    switch (txt1) {
      //<editor-fold defaultstate="collapsed" desc="Jump">
      case "Jump": {
        dlm.addElement("JU+1,AF-2");
        dlm.addElement("JU+1,BF-2");
        dlm.addElement("JU-1,AF+2");
        dlm.addElement("JU-1,BF+2");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Sl">
      case "Sl": {
        //<editor-fold defaultstate="collapsed" desc="sss cost">
        try {
          switch (ron) {
            case "BR": {
              sss = 2;
              break;
            }
            case "SR": {
              sss = 0.5;
              break;
            }
          }
        } catch (Exception e) {
        }
        //</editor-fold>
        v = 0;
        String txt;
        txt = "U = " + (int) (sss * v);
        dlm.addElement(txt);

        v = -1;
        txt = "P = " + (int) ((sss + 0.5) * v);
        dlm.addElement(txt);

        v = -2;
        txt = "S = " + (int) (sss * v);
        dlm.addElement(txt);
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Df">

      case "Df": {
        dlm.addElement("DF+2,AF-1");
        dlm.addElement("DF-2,AF+1");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Af">
      case "Af": {
        dlm.addElement("AF+1,DF-2");
        dlm.addElement("AF+1,BF-1");
        dlm.addElement("AF-1,DF+2");
        dlm.addElement("AF-1,BF+1");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Bf">
      case "Bf": {
        dlm.addElement("BF+1,AF-1");
        dlm.addElement("BF+2,JU-1");
        dlm.addElement("BF-1,AF+1");
        dlm.addElement("BF-2,JU+1");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Tf">
      case "Tf": {
//        dlm.addElement("AF+1,DF-2");
//        dlm.addElement("AF+1,BF-1");
//        dlm.addElement("AF-1,DF+2");
//        dlm.addElement("AF-1,BF+1");
        break;
      }
      //</editor-fold>
    }
    jList2.setModel(dlm);
//    jList2.update(jList2.getGraphics());
  }

  private void calc() {
    popu = Integer.parseInt(jLabel38.getText());
    tlmo = Integer.parseInt(jLabel34.getText());
    rmo = Integer.parseInt(jLabel33.getText());
    imo = Integer.parseInt(jLabel32.getText());
    cmo = Integer.parseInt(jLabel35.getText());
    calcDF();
    calcAF();
    calcBF();
    calcTF();
    calcJump();
  }

  private void calcJump() {
    //JLabel18
    BaseJump = "0";
    MaxJump = "0";
    tl = jLabel27.getText();
    switch (tl) {
      case "9":
      case "A":
      case "10": {
        BaseJump = "1";
        MaxJump = "1";
        break;
      }
      case "B":
      case "11": {
        BaseJump = "1";
        MaxJump = "2";
        break;
      }
      case "C":
      case "12": {
        BaseJump = "1";
        MaxJump = "3";
        break;
      }
      case "D":
      case "13": {
        BaseJump = "2";
        MaxJump = "4";
        break;
      }
      case "E":
      case "14": {
        BaseJump = "3";
        MaxJump = "5";
        break;
      }
      case "F":
      case "15": {
        BaseJump = "4";
        if ("BR".equals(ron)) {
          BaseJump = "3";
        }
        MaxJump = "6";
        break;
      }
    }
    nj.setText(BaseJump);
    oj.setText(BaseJump);
    basejf = Integer.parseInt(BaseJump);
  }

  private void calcDF() {
    //DF=P-2+M
    DF = popu - 2 + tlmo + rmo + imo + cmo;
    basedf = DF;
    od.setText("" + DF);
    nd.setText("" + DF);
  }

  private void calcAF() {
    AF = 0;
    if ("CR".equals(ron)) {
      AF = (DF / 2) + tlmo + rmo + imo + cmo;
    } else {
    }
    if ("BR".equals(ron)) {
      AF = ((2 * DF) / 3) + tlmo + rmo + imo + cmo;
    } else {
    }
    baseaf = AF;
    na.setText("" + AF);
  }

  private void calcBF() {
    BF = 0;
    nb.setText("" + BF);
    basebf = BF;
  }

  private void calcTF() {
    TF = 0;
    if ("AR".equals(ron)) {
      TF = 600;
    } else if ("BR".equals(ron)) {
      TF = 20;
    } else if ("CR".equals(ron)) {
      calcDF();
      TF = DF;
    }
    basetf = TF;
    nt.setText("" + TF);
  }

  private void calcWorld() {
    try {
//------------------------------------------------
      //TL (27&34)
      String tec = "" + dbviewer.globals.GlobalMethods.fromHex(UWP.getText()
        .substring(7, 8));
      try {
        tec = "" + dbviewer.globals.GlobalMethods.fromHex(
          Panel4SubSector.UWP.getText().substring(7, 8));
      } catch (Exception e) {
      }
      switch (tec) {
        case "7":
        case "8":
        case "9": {
          tlm = "-2";
          break;
        }
        case "10":
        case "11": {
          tlm = "-1";
          break;
        }
        case "12":
        case "13": {
          tlm = "0";
          break;
        }
        case "14": {
          tlm = "+1";
          break;
        }
        case "15": {
          tlm = "+2";
          break;
        }
      }
      jLabel27.setText("" + tec);
      jLabel34.setText(tlm);
      Panel4Squadron.tl = tec;
//      this.tlm = tlm;
//------------------------------------------------
      //Res (24&33)
      String r = "" + dbviewer.globals.GlobalMethods.fromHex(
        UWP.getText().substring(9, 10));
      try {
        r = "" + dbviewer.globals.GlobalMethods.fromHex(
          Panel4SubSector.lab4Resources.getText());
      } catch (Exception e) {
      }
      String rm = getMod(r);
      jLabel24.setText(r);
      jLabel33.setText(rm);
      this.res = r;
      this.resm = rm;
//------------------------------------------------
      //Inf (25&32)
      String i = "" + dbviewer.globals.GlobalMethods.fromHex(
        UWP.getText().substring(10, 11));
      try {
        i = "" + dbviewer.globals.GlobalMethods.fromHex(
          Panel4SubSector.lab4Infrastructure.getText());
      } catch (Exception e) {
      }
      String im = getMod(i);
      jLabel25.setText(i);
      jLabel32.setText(im);
      this.inf = i;
      this.infm = im;
//------------------------------------------------
      //Cul (26&35)
      String c = "" + dbviewer.globals.GlobalMethods.fromHex(
        UWP.getText().substring(11, 12));
      try {
        c = "" + dbviewer.globals.GlobalMethods.fromHex(
          Panel4SubSector.lab4Culture.getText());
      } catch (Exception e) {
      }
      String cm = getMod(c);
      jLabel26.setText(c);
      jLabel35.setText(cm);
      this.cul = c;
      this.culm = cm;
//------------------------------------------------
      //Pop (38)
      String p = "" + dbviewer.globals.GlobalMethods.fromHex(UWP.getText()
        .substring(4, 5));
      try {
        p = "" + dbviewer.globals.GlobalMethods.fromHex(
          Panel4SubSector.UWP.getText().substring(4, 5));
      } catch (Exception e) {
      }
      jLabel38.setText(p);
      pop = p;//globals.GlobalMethods.toHex(Integer.parseInt(p));
      //this.popm = im;
    } catch (Exception e) {
      System.out.println("1916" + " = " + e);
    }
  }

  private String getMod(String str) {
    String v = null;
    switch (str) {
      case "0":
      case "1":
      case "2": {
        v = "-3";
        break;
      }
      case "3":
      case "4":
      case "5": {
        v = "-2";
        break;
      }
      case "6":
      case "7":
      case "8": {
        v = "-1";
        break;
      }
      case "9":
      case "10":
      case "11": {
        v = "0";
        break;
      }
      case "12":
      case "13":
      case "14": {
        v = "+1";
        break;
      }
      case "15": {
        v = "+2";
        break;
      }
    }
    return v;
  }

  static String getPop() {
    return UWP.getText().substring(4, 5);
  }

  void worldUpdate() {
    //--------------------------------------------------
    // SDBs
    printTable(tablenames[2], tables[2]);
    System.out.println("getFromTable(2, " + getPop() + ", " + getTL()
      + ")" + " = " + getFromTable(2, getPop(), getTL()));
    SDBs = getFromTable(2, getPop(), getTL());
    sdbs.setText(SDBs);
    //--------------------------------------------------
    // Squadrons
    printTable(tablenames[7], tables[7]);
    System.out.println("getFromTable(7, " + getTL() + ", " + SDBs
      + ")" + " = " + getFromTable(7, getTL(), SDBs));
    SQUADRONS = getFromTable(7, getTL(), SDBs);
    squadrons.setText(SQUADRONS);
    //--------------------------------------------------
    // Defence Battalions
    printTable(tablenames[8], tables[8]);
    System.out.println("getFromTable(8, " + getPop() + ", " + getTL()
      + ")" + " = " + getFromTable(8, getPop(), getTL()));
    DEFENCEBATTS = getFromTable(8, getPop(), getTL());
    defbats.setText(DEFENCEBATTS + "-"
      + UWP.getText().substring(7, 8));
    try {
      TROOPUNITS = "0";
      troopunits.setText(TROOPUNITS);
      int u, p;
//      t = globals.GlobalMethods.fromHex(jLabel27.getText());
//      p = globals.GlobalMethods.fromHex(jLabel38.getText());
      u = Integer.parseInt(jLabel27.getText());
      p = Integer.parseInt(jLabel38.getText());
      if (u > 6 & p > 6) {
        System.out.println("getFromTable(10, " + getPop() + ", " + getTL()
          + ")" + " = " + getFromTable(10, getPop(), getTL()));
        TROOPUNITS = getFromTable(10, getPop(), getTL());
        troopunits.setText(TROOPUNITS);
        //jLabel22MouseClicked(evt);
      }
    } catch (Exception e) {
      System.out.println("" + " = " + e.toString());
    }
  }

  static void setHeight(int i) {
    jf.setSize(jf.getHeight(), i);
  }

  static void setTop(int i) {
    jf.setLocation(jf.getX(), i);
  }

  //<editor-fold defaultstate="collapsed" desc="Overrides">
  /**
   <p>
   @return Point cost for squadron
   */
  @Override
  public String getRonPts() {
    return this.jLabel10.getText();
  }

  /**
   <p>
   @return Squadron type
   */
  @Override
  public String getType() {
    return this.jComboBox0.getSelectedItem().toString();
  }

  /**
   <p>
   @return ID
   */
  @Override
  public String getID() {
    return this.id;
  }

  /**
   <p>
   @return Jump rating
   */
  @Override
  public String getJump() {
    return this.jump;
  }

  /**
   <p>
   @return Streamlining
   */
  @Override
  public String getSL() {
    return this.sl;
  }

  /**
   <p>
   @return Defence Factor
   */
  @Override
  public String getDF() {
    return this.df;
  }

  /**
   <p>
   @return Attack Factor
   */
  @Override
  public String getAF() {
    return this.af;
  }

  /**
   <p>
   @return Bombardment Factor
   */
  @Override
  public String getBF() {
    return this.bf;
  }

  /**
   <p>
   @return Transport Factor
   */
  @Override
  public String getTF() {
    return this.tf;
  }

  /**
   <p>
   @return Tech level
   */
  @Override
  public String getTL() {
    return UWP.getText().substring(7, 8);
  }

  /**
   <p>
   @return Base jump value
   */
  @Override
  public String getBaseJump() {
    return this.BaseJump;
  }

  /**
   <p>
   @return Maximum jump
   */
  @Override
  public String getMaxJump() {
    return this.MaxJump;
  }
  //</editor-fold>

  private void updateOld() {
    for (int i = 0; i < oldval.length; i++) {
      oldval[i].setText(newval[i].getText());
      try {
        newval[i].setText("" + (Integer.parseInt(oldval[i].getText()) + Integer
          .parseInt(modval[i].getText())));
        oldval[i].setText(newval[i].getText());

      } catch (Exception e) {
        newval[i].setText(oldval[i].getText());
      }
      if (i != 1) {
        modval[i].setText("0");
      }
    }
  }

  static String getTecL() {
    return Panel4SubSector.UWP.getText().trim().substring(7, 8);
  }

  static String worldupdate(String txt) {
    //--------------------------------------------------
    //--------------------------------------------------
    //--------------------------------------------------
    //--------------------------------------------------
    switch (txt) {
      //<editor-fold defaultstate="collapsed" desc="SDBs">
      case "SDBs": {
        if (GlobalMethods.fromHex(getpop()) > 6 & GlobalMethods.fromHex(
          getTecL()) > 6) {
          // SDBs
          printTable(tablenames[2], tables[2]);
          try {
            SDBso = getFromTable(2, getpop(), getTecL());
          } catch (Exception e) {
            System.out.println("SDBs e" + " = " + e);
          }
          System.out.println("getpop()" + " = " + GlobalMethods
            .fromHex(getpop()));
          System.out.println("getTecL()" + " = " + GlobalMethods.fromHex(
            getTecL()));
          System.out.println("SDBs" + " = " + SDBso);
          try {
            sdbs.setText(SDBso);
          } catch (Exception e) {
            Panel4SubSector.sdbs1.setText("" + SDBso);
          }
          return SDBso;
        } else {
          return "X";
        }
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="SQUADRONS">
      case "SQUADRONS": {
        if (GlobalMethods.fromHex(getTecL()) > 8 & GlobalMethods.fromHex(
          getpop()) > 6) {
          // Squadrons
          printTable(tablenames[7], tables[7]);
          //    System.out.println("getFromTable(7, " + getTL() + ", " + SDBs
          //            + ")" + " = " + getFromTable(7, getTL(), SDBs));
          try {
            SQUADRONSo = getFromTable(7, getTecL(), SDBso);
          } catch (Exception e) {
            System.out.println("SQUADRONS e" + " = " + e);
          }
          if (SQUADRONSo == "TLF") {
            SQUADRONSo = "0";
          }
          try {
            squadrons.setText(SQUADRONSo);
          } catch (Exception e) {
            Panel4SubSector.squadrons.setText(SQUADRONSo);
          }
          System.out.println("getTecL()" + " = " + getTecL());
          System.out.println("SDBso" + " = " + SDBso);
          System.out.println("SQUADRONS" + " = " + SQUADRONSo);
          return SQUADRONSo;
//        } else {
//          return "0";
//        }
        } else {
          return "X";
        }
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="DEFENCEBATTS">
      case "DEFENCEBATTSo":
      case "DEFENCEBATTS": {
        if (GlobalMethods.fromHex(getpop()) > 5 & GlobalMethods.fromHex(
          getTecL()) > 5) {
          // Defence Batteries
          printTable(tablenames[8], tables[8]);
//            System.out.println("getFromTable(8, " + getPop() + ", " + getTecL()
//                    + ")" + " = " + getFromTable(8, getPop(), getTecL()));
          String p;
          String t;
          p = Panel4SubSector.UWP.getText().substring(4, 5);
          t = Panel4SubSector.UWP.getText().substring(7, 8);
//        p = Panel4SubSector.uwp.substring(4, 5);
//        t = Panel4SubSector.uwp.substring(7, 8);
          System.out.println("pop" + " = " + p);
          System.out.println("tech" + " = " + t);
          try {
            DEFENCEBATTSo = getFromTable(8, p, t);
            defbats.setText(DEFENCEBATTSo);
          } catch (Exception e) {
            Panel4SubSector.defbats.setText(DEFENCEBATTSo);
          }
          System.out.println("DEFENCEBATTSo" + " = " + DEFENCEBATTSo);
//        try {
//          defbats.setText(DEFENCEBATTSo);
//        } catch (Exception e) {
//          Panel4SubSector.defbats.setText(DEFENCEBATTSo);
//        }
          return DEFENCEBATTSo;
        } else {
          return "X";
        }
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="TROOPUNITS">
      case "TROOPUNITS": {
        if (GlobalMethods.fromHex(getpop()) > 6 & GlobalMethods.fromHex(
          getTecL()) > 6) {
          printTable(tablenames[10], tables[10]);
          int t, p;
          t = dbviewer.globals.GlobalMethods.fromHex(
            Panel4SubSector.UWP.getText().substring(7, 8));
          p = dbviewer.globals.GlobalMethods.fromHex(
            Panel4SubSector.UWP.getText().substring(4, 5));
          if (t > 6 & p > 6) {
            TROOPUNITSo = getFromTable(10, getpop(), getTecL());
            try {
              troopunits.setText(TROOPUNITSo);
            } catch (Exception e) {
              Panel4SubSector.troopunits.setText(TROOPUNITSo);
            }
          } else {
            try {
              troopunits.setText("0");
            } catch (Exception e) {
              Panel4SubSector.troopunits.setText("0");
            }
          }
          System.out.println("getpop()" + " = " + getpop());
          System.out.println("getTecL()" + " = " + getTecL());
          System.out.println("TROOPUNITSo" + " = " + TROOPUNITSo);
          return TROOPUNITSo;
        } else {
          return "X";
        }
      }
      //</editor-fold>
    }
    return null;
  }

  static String getpop() {
    return Panel4SubSector.UWP.getText().substring(4, 5);
  }

  static void countCost() {
    cost = 0.0;
    switch (jComboBox0.getSelectedItem().toString().substring(0, 2)) {
      case "AR":
      case "BR": {
        cost = 2.0;
        break;
      }
      case "CR": {
        cost = 1.0;
        break;
      }
      case "SR": {
        cost = 0.5;
        break;
      }
      case "TR": {
        cost = 3.0;
        break;
      }
    }
//    repaint();

  }

  static void printCounter() {
    for (int i = 0; i < values.length - 1; i++) {
      jTextArea1.append(values[i] + "-");
    }
    jTextArea1.append(values[7]);
    jTextArea1.append(" = " + cost + " pt - ");
  }

  static void doMath() {
    String[] txt = jTextArea1.getText().split(CRLF);
    Double total = Double.parseDouble(jLabel7.getText());
    Double numb = 0.0;
    for (int i = 0; i < txt.length; i++) {
      if (txt[i].contains(" = ")) {
        int start = txt[i].indexOf(" = ") + 3;
        int end = txt[i].indexOf(" pt");
        String s = txt[i].substring(start, end);
        numb += Double.parseDouble(s);
      }
    }
//    System.out.println("numb" + " = " + numb);
    num.setText("" + numb);
    jLabel12.setText("" + (total - numb));

  }

  static void getNumber() {
    String text = "";
    String num1 = "" + jTextArea1.getLineCount();
    int pos = 0;
    for (int i = 0; i < num1.length(); i++) {
      if ("0".equals(num1.substring(i, i + 1))) {
        pos = i + 1;
      } else {
        break;
      }
    }
    String lined = num1.substring(pos);
    int j = Integer.parseInt(lined);
    if (!(j > 10 & j < 20)) {
      if (lined.endsWith("1")) {
        lined += "st";
      } else if (lined.endsWith("2")) {
        lined += "nd";
      } else if (lined.endsWith("3")) {
        lined += "rd";
      } else {
        lined += "th";
      }
    } else {
      lined += "th";
    }
    jTextArea1.append(lined + " ");
    text += lined + " ";
    jTextArea1.append(sron.getText().substring(3));
    jTextArea1.append(" Squadron (" + jf.getTitle() + ")" + CRLF);
    jLabel12.setText("" + Double.parseDouble(jLabel7.getText()));

    //sidn.setText("" + (Double.parseDouble(sidn.getText()+1)));
  }

  /**
   <p>
   @param s String "squadron" or "utp"
   */
  public static void updatePic(String s) {
    Panel4UTP.updatePic(s);
  }
}
