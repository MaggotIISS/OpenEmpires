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

import dbviewer.DBViewer;
import dbviewer.StarGen;
import static dbviewer.globals.GlobalMethods.showTable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

// Variables declaration - do not modify
/**
 <p>
 @author Your Name Mark Ferguson maggot.iiss@sky.com
 */
public class Panel4StarGen extends Panel4 {
  //<editor-fold defaultstate="collapsed" desc="variables">

  private static int starorbit = 0;
  /**
   String CRLF
   */
  public static String CRLF = System.lineSeparator();
  /**
   boolean hasparent
   */
  public static boolean hasparent = false;
  private static int primarytyperoll;
  private static int primarysizeroll;
  //private static String systemcontentgasgiants;
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
   String starport
   */
  public static String starport = null;
  /**
   String navalbase
   */
  public static String navalbase = null;
  /**
   String scoutbase
   */
  public static String scoutbase = null;
  /**
   String gasgiant
   */
  public static String gasgiant = null;
  /**
   String planetoids
   */
  public static String planetoids = null;
  /**
   String[] SystemContents
   */
  public static String[] SystemContents = new String[5];
  /**
   String[] systemcontentvarnames
   */
  public static String[] systemcontentvarnames = new String[]{
    "starport", "navalbase", "scoutbase",
    "gasgiant", "planetoids"
  };
  /**
   String nature
   */
  public static String nature = null;
  /**
   String primarytype
   */
  public static String primarytype = null;
  /**
   String primarysize
   */
  public static String primarysize = null;
  /**
   String primaryorbit
   */
  public static String primaryorbit = null;
  /**
   String primaryorbits
   */
  public static String primaryorbits = null;
  /**
   String secondarytype
   */
  public static String secondarytype = null;
  /**
   String secondarysize
   */
  public static String secondarysize = null;
  /**
   String secondaryorbit
   */
  public static String secondaryorbit = null;
  /**
   String secondaryorbits
   */
  public static String secondaryorbits = null;
  /**
   String tertiarytype
   */
  public static String tertiarytype = null;
  /**
   String tertiarysize
   */
  public static String tertiarysize = null;
  /**
   String tertiarysize
   */
  public static String tertiaryorbit = null;
  /**
   String tertiaryorbits
   */
  public static String tertiaryorbits;
  /**
   String systemfeaturemaxorbits
   */
  public static String systemfeaturemaxorbits = null;
  /**
   String gasgiantpresence
   */
  public static String gasgiantpresence = gasgiant;
  /**
   String gasgiantquantity
   */
  public static String gasgiantquantity = null;
  /**
   String planetoidpresence
   */
  public static String planetoidpresence = planetoids;
  /**
   String planetoidquantity
   */
  public static String planetoidquantity = null;
  /**
   String[] SystemFeature
   */
  public static String[] SystemFeature;
  /**
   String[] systemfeaturevarnames
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
   String planetaryorbitnumtitle
   */
  public static String planetaryorbitnumtitle = "Orbit";
  /**
   String planetaryorbitnumautitle
   */
  public static String planetaryorbitnumautitle = "r(AU)";
  /**
   String planetaryorbitnummkmtitle
   */
  public static String planetaryorbitnummkmtitle = "r(MKm)";
  /**
   String[] planetaryorbitnum
   */
  public static String[] planetaryorbitnum = new String[16];
  /**
   String[] planetaryorbitnummkm
   */
  public static String[] planetaryorbitnummkm = new String[16];
  /**
   String[] planetaryorbitnumau
   */
  public static String[] planetaryorbitnumau = new String[16];
  private static String[] PlanetaryOrbit = new String[3];

  /**
   public static String[] planetaryorbitvarnames
   */
  public static String[] planetaryorbitvarnames = new String[]{
    "planetaryorbitnum", "planetaryorbitnummkm",
    "planetaryorbitnumau"
  };

  static int getOrbits() {
//    return Integer.parseInt(svars[8]);
    return StarGen.Orbit.length;
  }
  //</editor-fold>
  //Satellites
  //<editor-fold defaultstate="collapsed" desc="Satellite orbit">
  private int orbit;

  /**
   String satelliteorbitringtitle
   */
  public static String satelliteorbitringtitle;

  /**
   String satelliteorbitclosetitle
   */
  public static String satelliteorbitclosetitle;

  /**
   String satelliteorbitextremetitle
   */
  public static String satelliteorbitextremetitle;

  /**
   String satelliteorbitfartitle
   */
  public static String satelliteorbitfartitle;
  /**
   String[] satelliteorbitnum
   */
  public static String[] satelliteorbitnum;
  /**
   String[] satelliteorbitring
   */
  public static String[] satelliteorbitring;
  /**
   String[] satelliteorbitclose
   */
  public static String[] satelliteorbitclose;
  /**
   String[] satelliteorbitfar
   */
  public static String[] satelliteorbitfar;
  /**
   String[] satelliteorbitextreme
   */
  public static String[] satelliteorbitextreme;

  /**
   String[] SatelliteOrbit
   */
  public static String[] SatelliteOrbit;

  /**
   String[] satelliteorbitvarnames
   */
  public static String[] satelliteorbitvarnames = new String[]{
    satelliteorbitringtitle, satelliteorbitclosetitle,
    satelliteorbitfartitle, satelliteorbitextremetitle
  };
  //</editor-fold>
  /**
   String[] svarnames
   */
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
  //Stellar details
  //<editor-fold defaultstate="collapsed" desc="Stellar details">
  /**
   String[] supergiants
   */
  public static String[] supergiants;
  /**
   String[] weakersupergiants
   */
  public static String[] weakersupergiants;
  /**
   String[] brightgiants
   */
  public static String[] brightgiants;
  /**
   String[] giants
   */
  public static String[] giants;
  /**
   String[] subgiants
   */
  public static String[] subgiants;
  /**
   String[] mainsequence
   */
  public static String[] mainsequence;
  /**
   String[] subdwarfs
   */
  public static String[] subdwarfs;
  /**
   String[] whitedwarfs
   */
  public static String[] whitedwarfs;
  /**
   String[] strings
   */
  public String[] strings;
  /**
   String starcolumns
   */
  public static String starcolumns;
  /**
   String startable
   */
  public static String startable;
  /**
   String[] star
   */
  public static String[] star = {
    "Primary",
    "Secondary",
    "Tertiary"
  };
  /**
   String[] startables
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
   int ADD
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
  //<editor-fold defaultstate="collapsed" desc="Size">
  private static String Size = "";
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
    Size, Atmosphere, Hydrosphere,
    Population, Government, LawLevel,
    TechLevel
  };
  //</editor-fold>
  private String[] worlddatatext;
  //<editor-fold defaultstate="collapsed" desc="Star detail tables">
  /**
   int supergiantscols
   */
  public static int supergiantscols;
  /**
   int weakersupergiantscols
   */
  public static int weakersupergiantscols;
  /**
   int brightgiantscols
   */
  public static int brightgiantscols;
  /**
   int giantscols
   */
  public static int giantscols;
  /**
   public static int subgiantscols;
   */
  public static int subgiantscols;
  /**
   <p>
   public static int mainsequencecols;
   */
  public static int mainsequencecols;
  /**
   public static int subdwarfscols;
   */
  public static int subdwarfscols;
  /**
   public static int whitedwarfscols;
   */
  public static int whitedwarfscols;
  //</editor-fold>
  /**
   public static int col;
   */
  public static int col;
  /**
   public static int dec[] = new int[3];
   */
  public static int dec[] = new int[3];
  /**
   public static JPanel p4sg;
   */
  public static JPanel p4sg;
  /**
   public static JFrame f4sg;
   */
  public static JFrame f4sg;
  //<editor-fold defaultstate="collapsed" desc="TravelZone">
  //</editor-fold>
  /**
   public static String[] svars;
   */
  public static String[] svars;
  /**
   public static String[] StellarData;
   */
  public static String[] StellarData;
  /**
   public static String[] MainworldContents;
   */
  public static String[] MainworldContents;
  /**
   public static String[] mainworldcontentsvarnames;
   */
  public static String[] mainworldcontentsvarnames;
  /**
   public static File f;
   */
  public static File f;
  /**
   public static String[] Orbits = new String[]{"5", "0", "3"};
   */
  public static String[] Orbits = new String[]{"5", "0", "3"};
  private static Color O = Color.cyan;
  private static Color B = new Color(0, 240, 240);
  private static Color A = new Color(0, 225, 225);
  private static Color F = new Color(0, 210, 210);
  private static Color G = Color.yellow;
  private static Color K = Color.orange;
  private static Color M = Color.LIGHT_GRAY;
  private static Color[] colors = new Color[]{
    O, B, A, F, G, K, M
  };
  static int I = 0;
  /**
   public static Color Col;
   */
  public static Color Col;
  private static Graphics g;
  private static String let;
  private static String siz;
  private static int top, left, wid, hgt, num;
  //</editor-fold>
  /**
   public static String[] table;
   */
  public static String[] table;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
//    if(f4sg.isVisible()) {
//      f4sg = null;
//      p4sg = null;
//    }
    p4sg = new Panel4StarGen();
    f4sg = new Frame4(p4sg);
//    f4sg.setBounds(0, 0, 640, 700);
//    f4sg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    try {
      f4sg.setTitle(Panel4SubSector.jcb4Star1.getSelectedItem().toString());
    } catch (Exception e) {
      f4sg.setTitle("F7 V");
    }//"F7 V");
    Planets.setVisible(false);
    Moons.setVisible(false);
    Zones.setVisible(false);
    UWP.setVisible(false);
    // only when run inside of DBViewer
    if (args.length == 8) {//Bodge but works!
      hasparent = true;
      f4sg.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      uwp.setText(args[0]
        + args[1]
        + args[2]
        + args[3]
        + args[4]
        + args[5]
        + args[6]
        + "-"
        + args[7]);
      f4sg.setTitle(Panel4SubSector.jcb4Star1.getSelectedItem().toString());
    }
    ActionListener saveAction;
    saveAction = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String filename;
        try {
          filename = DBViewer.jfc.getSelectedFile().toString();
          DBViewer.jfc.setCurrentDirectory(new File(Panel4Locator.getString()));
        } catch (Exception ex) {
          filename = "Test";
        };
        filename = filename.substring(0, filename.length() - 4) + ".orb";
        DBViewer.jfc.setSelectedFile(new File(filename));
        DBViewer.jfc.setAcceptAllFileFilterUsed(false);
        DBViewer.jfc.addChoosableFileFilter(new FileFilter() {
          @Override
          public boolean accept(File f) {
            if (f.toString().endsWith(".orb")) {
              return true;
            } else {
              return false;
            }
          }

          @Override
          public String getDescription() {
            return "Orbital system data";
          }
        });
        int ret;
        if ((ret = DBViewer.jfc.showSaveDialog(DBViewer.jfc))
          == JFileChooser.APPROVE_OPTION) {
          String file = DBViewer.jfc.getSelectedFile().toString();
          try {
            try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
              out.print(Panel4StarGen.jta.getText());
            }
          } catch (IOException ex) {
          }
        }
      }
    };
    f4sg.getJMenuBar().getMenu(0).add("Save").addActionListener(saveAction);
    ActionListener openAction;
    openAction = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String filename;
        try {
          filename = DBViewer.jfc.getSelectedFile().toString();
          DBViewer.jfc.setCurrentDirectory(new File(Panel4Locator.getString()));
        } catch (Exception ex) {
          filename = "Test";
        };
        filename = filename.substring(0, filename.length() - 4) + ".orb";
        DBViewer.jfc.setSelectedFile(new File(filename));
        DBViewer.jfc.setAcceptAllFileFilterUsed(false);
        DBViewer.jfc.addChoosableFileFilter(new FileFilter() {
          @Override
          public boolean accept(File f) {
            if (f.toString().endsWith(".orb")) {
              return true;
            } else {
              return false;
            }
          }

          @Override
          public String getDescription() {
            return "Orbital system data";
          }
        });
        int ret;
        if ((ret = DBViewer.jfc.showOpenDialog(DBViewer.jfc))
          == JFileChooser.APPROVE_OPTION) {
          String file = DBViewer.jfc.getSelectedFile().toString();
          String[] linesFromFile = dbviewer.globals.GlobalMethods
            .getLinesFromFile(new File(filename));
          jta.setText("");
          for (int i = 0; i < linesFromFile.length; i++) {
            jta.append(linesFromFile[i].toString() + CRLF);
          }
        }
        //StarGen.arrange();
        showStar();
      }
    };
    f4sg.getJMenuBar().getMenu(0).add("Open").addActionListener(openAction);
    //StarGen.arrange();
    system.setVisible(false);
    tl.setVisible(false);
    features.setVisible(false);
////        checkPrevious();
//    for (int i = 0; i < 100; i++) {
//      System.out.println("" + " = " + i);
//      jButton1.doClick();
//    }
  }

  private static void checkPrevious() {
    //if system already saved, then display.  else click jButton1
    File file = null;
    String string = Panel4Locator.getPath();
    System.out.println();
  }

  /**
   public static void showStar()
   */
  public static void showStar() {
    if (hasparent) {
      let = Panel4SubSector.jcb4Star1.getSelectedItem().toString().substring(0,
        1);
      siz = Panel4SubSector.jcb4Star1.getSelectedItem().toString().substring(3)
        .trim();
    } else {
      let = f4sg.getTitle().substring(0, 1);
      siz = f4sg.getTitle().substring(2).trim();
    }
    wid = jButton1.getWidth();
    hgt = jButton1.getWidth();
    top = jButton1.getY() + jButton1.getHeight();
    left = jButton1.getX() + jPanel2.getX();
    g = jLabel1.getGraphics();
    switch (let) {
      case "O": {
        Col = colors[0];
        break;
      }
      case "B": {
        Col = colors[1];
        break;
      }
      case "A": {
        Col = colors[2];
        break;
      }
      case "F": {
        Col = colors[3];
        break;
      }
      case "G": {
        Col = colors[4];
        break;
      }
      case "K": {
        Col = colors[5];
        break;
      }
      case "M": {
        Col = colors[6];
        break;
      }
    }

    switch (siz) {
      case "Ia":
        num = 100;
        break;
      case "Ib":
        num = 90;
        break;
      case "II":
        num = 80;
        break;
      case "III":
        num = 70;
        break;
      case "IV":
        num = 60;
        break;
      case "V":
        num = 50;
        break;
      case "VI":
        num = 40;
        break;
      case "D":
      case "VII":
        num = 20;
        break;

    }
    g.setColor(Col);
    //jLabel1.setBounds(top, left, wid, hgt);

    //repaint();
  }

  /**
   <p>
   @param g Graphics
   */
  @Override
  public void paint(Graphics g) {
    showStar();
    super.paint(g);
    g.setColor(Col);
//    g.fillRoundRect(jta.getWidth(), (jButton1.getY() + jButton1.getHeight()), jButton1.getWidth(), jButton1.getWidth(), 100, 100);
    g.fillOval(left, top, wid * num / 100, hgt * num / 100);
  }

  /**
   copy system and world info from Panel4SubSector to internal
   */
  public static void updateFromImperium() {
    try {
      f4sg.setTitle(Panel4Locator.getSectorName() + "/" + Panel4Locator
        .getSubSectorName() + "/" + Panel4Locator.getSystem());
      p4sg.setBackground(Color.BLACK);
      jPanel1.setBackground(Color.BLACK);
      hasparent = true;
      load.doClick();
      //orbits.setVisible(false);
      system.setVisible(false);
      //<editor-fold defaultstate="collapsed" desc="hasparent">
      String string = null;
      String jcb4star = null;
      String type = "";
      String mag = "";
      String size = "";
      String orbits = "";
      for (int i = 0; i < 3; i++) {
        switch (i) {
          case 0: {
            jcb4star = panels.Panel4SubSector.jcb4Star1.getSelectedItem()
              .toString();
            break;
          }
          case 1: {
            jcb4star = panels.Panel4SubSector.jcb4Star2.getSelectedItem()
              .toString();
            break;
          }
          case 2: {
            jcb4star = panels.Panel4SubSector.jcb4Star3.getSelectedItem()
              .toString();
            break;
          }
        }
        //      primarytype, primarysize, primaryorbit, primaryorbits,]
        //System.out.print("" + globals.GlobalMethods.comment("=", 20));
        if (!"".equals(jcb4star)) {
          type = jcb4star.substring(0, 1);
          mag = jcb4star.substring(1, 2);
          size = jcb4star.substring(2).trim();
          switch (i) {
            case 0: {
              primarytype = type;
              primarysize = size;
              primaryorbit = svars[23];
              primaryorbits = svars[40];
              systemfeaturemaxorbits = primaryorbits;
              break;
            }
            case 1: {
              secondarytype = type;
              secondarysize = primarysize;
              secondaryorbit = svars[24];
              secondaryorbits = svars[41];
              break;
            }
            case 2: {
              tertiarytype = type;
              tertiarysize = primarysize;
              tertiaryorbit = svars[25];
              tertiaryorbits = svars[42];
              break;
            }
          }
        }
        //System.out.print("" + "=" + globals.GlobalMethods.comment("=", 20));
//        load.doClick();
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="starport & bases">
      starport = panels.Panel4SubSector.jcb4StarPort.getSelectedItem()
        .toString().substring(0, 1);
      ////System.out.println("" + " = " + starport);
      if ("2".equals(panels.Panel4SubSector.jcb4Bases.getSelectedItem()
        .toString())) {
        navalbase = "YES";
      } else {
        navalbase = "NO";
      }
      if ("n".equals(panels.Panel4SubSector.jcb4Bases.getSelectedItem()
        .toString().toLowerCase())) {
        navalbase = "YES";
      } else {
        navalbase = "NO";
      }
      if ("2".equals(panels.Panel4SubSector.jcb4Bases.getSelectedItem()
        .toString().toLowerCase())) {
        scoutbase = "YES";
      } else {
        scoutbase = "NO";
      }
      if ("s".equals(panels.Panel4SubSector.jcb4Bases.getSelectedItem()
        .toString().toLowerCase())) {
        scoutbase = "YES";
      } else {
        scoutbase = "NO";
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="gas giants">
      //gas giants
      if ("g".equals(panels.Panel4SubSector.jcb4GGs.getSelectedItem().toString()
        .toLowerCase())) {
        gasgiant = "YES";
      } else {
        gasgiant = "NO";
      }
      gasgiantpresence = gasgiant;
      gasgiantquantity = panels.Panel4SubSector.jcb4PAG.getSelectedItem()
        .toString().substring(2);
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="asteroids">
      //asteroids?
      if ("0".equals(panels.Panel4SubSector.jcb4PAG.getSelectedItem().toString()
        .substring(1, 2))) {
        planetoids = "NO";
      } else {
        planetoids = "YES";
      }
      planetoidpresence = planetoids;
      planetoidquantity = panels.Panel4SubSector.jcb4PAG.getSelectedItem()
        .toString().substring(1, 2);
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="systems">
      if (!"".equals(panels.Panel4SubSector.jcb4Star1.getSelectedItem()
        .toString())) {
        nature = "Solo";
      } else {
        nature = "NO SYSTEM";
      }
      if (!"".equals(panels.Panel4SubSector.jcb4Star2.getSelectedItem()
        .toString())) {
        nature = "Binary";
      }
      if (!"".equals(panels.Panel4SubSector.jcb4Star3.getSelectedItem()
        .toString())) {
        nature = "Trinary";
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="stars">
      if (!"".equals(panels.Panel4SubSector.jcb4Star1.getSelectedItem()
        .toString())) {
        primarytype = panels.Panel4SubSector.jcb4Star1.getSelectedItem()
          .toString().substring(0, 1);
        primarysize = panels.Panel4SubSector.jcb4Star1.getSelectedItem()
          .toString().substring(3);
        dec[0] = Integer.parseInt(panels.Panel4SubSector.jcb4Star1
          .getSelectedItem().toString().substring(1, 2));
      }
      if (!"".equals(panels.Panel4SubSector.jcb4Star2.getSelectedItem()
        .toString())) {
        secondarytype = panels.Panel4SubSector.jcb4Star2.getSelectedItem()
          .toString().substring(0, 1);
        secondarysize = panels.Panel4SubSector.jcb4Star2.getSelectedItem()
          .toString().substring(3);
        dec[1] = Integer.parseInt(panels.Panel4SubSector.jcb4Star2
          .getSelectedItem().toString().substring(1, 2));
      }
      if (!"".equals(panels.Panel4SubSector.jcb4Star3.getSelectedItem()
        .toString())) {
        tertiarytype = panels.Panel4SubSector.jcb4Star3.getSelectedItem()
          .toString().substring(0, 1);
        tertiarysize = panels.Panel4SubSector.jcb4Star3.getSelectedItem()
          .toString().substring(3);
        dec[2] = Integer.parseInt(panels.Panel4SubSector.jcb4Star3
          .getSelectedItem().toString().substring(1, 2));
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Tech Level">
      //Tech Level
      iTL = dbviewer.globals.GlobalMethods.fromHex(panels.Panel4SubSector.UWP
        .getText().substring(7, 8));
      getTLs();

      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Main World">
      //Size
      //Atmosphere
      //Hydrosphere
      //Population
      //Government
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Orbital Detail">
      //System.out.println("" + " = " + globals.GlobalMethods.comment("=", 20));
      //System.out.println("Orbital Detail");
      //System.out.println("" + " = " + globals.GlobalMethods.comment("=", 20));
//    load.doClick();
      primaryorbits = svars[40];
      secondaryorbits = svars[41];
      tertiaryorbits = svars[42];
      for (int i = 0; i < svars.length; i++) {
        //System.out.println(svarnames[i] + " = " + svars[i]);
      }

      //</editor-fold>
      update.doClick();
      //<editor-fold defaultstate="collapsed" desc="save?">
      //is old file > title length?
      f = new File(dbviewer.DBViewer.jfc.getCurrentDirectory() + "/"
        + panels.Panel4SubSector.jList1.getSelectedValue().toString()
        + "-" + panels.Panel4SubSector.UWP.getText().substring(7, 8) + ".txt");
      if (2 >= dbviewer.globals.GlobalMethods.countLines(f)) {
        int ret = JOptionPane.showConfirmDialog(jta, "Save", "Save",
          JOptionPane.YES_NO_OPTION);
        if (ret == JOptionPane.OK_OPTION) {
          //System.out.println("Save " + f.getAbsolutePath());
          save.doClick();
        }
      } else {
        //load in previously saved file
        jta.setText("");
        String[] lines = dbviewer.globals.GlobalMethods.getLinesFromFile(f);
        int j;
        for (j = 0; j < lines.length; j++) {
          if (lines[j].contains("systemcontentstarport")) {
            break;
          }
          jta.append("" + lines[j] + CRLF);
        }
        for (int i = j; i < lines.length; i++) {
          //System.out.println("" + lines[i]);
        }
        //save variables
      }
      //</editor-fold>
      jta.setText("");
      StarGen.printStellarData();
    } catch (Exception ex) {
      Logger.getLogger(Panel4StarGen.class.getName())
        .log(Level.SEVERE, null, ex);
    }

  }

  /**
   Creates new form Panel4StarGen
   */
  public Panel4StarGen() {
    super();
    initComponents();
    setTechLevel();
    setPlanetaryOrbitData();
    setSatelliteOrbitData();
    setStarSizes();
    setSystemFeatures();
    setVars();
//    siz = f4sg.getTitle().substring(2);
//    showStar();
    repaint();
  }

  /**
   <p>
   @param num number of die to roll
   @return result of multiple die rolls
   */
  public static int getRoll(int num) {
    int roll = 0;
    for (starorbit = 0; starorbit < num; starorbit++) {
      roll += (int) ((Math.random() * 6) + 1);
    }
    return roll;
  }

  /**
   <p>
   @param num number to minimise
   @param min minimum for num
   @return number increased if under min
   */
  public static int setMinimum(int num, int min) {
    int it = num;
    if (num < min) {
      it = min;
    }
    return it;
  }

  private static void printTechLevel() {
    jta.append("Tech Level".toUpperCase() + CRLF);
    jta.append(dbviewer.globals.GlobalMethods.comment("=", 20));
    jta.append("\tTL" + " = " + iTL + CRLF);
    for (int i = 0; i < sTLModNames.length; i++) {
      jta.append("\t" + sTLModNames[i] + "DM = " + iTLMods[i] + CRLF);
    }
  }

  /**
   <p>
   @param num num to compare to max
   @param max number to maximize
   @return integer reduced if over max
   */
  public static int setMaximum(int num, int max) {
    if (num > max) {
      num = max;
    }
    return num;
  }

  /**
   public final void setStarSizes()
   */
  public final void setStarSizes() {
    setSuperGiants();//Ia
    setWeakerSuperGiants();//Ib
    setBrightGiants();//II
    setGiants();//III
    setSubGiants();//IV
    setMainSequence();//V
    setSubDwarfs();//VI
    setWhiteDwarfs();//D
    repaint();
  }

  /**
   public static void setSuperGiants() {
   */
  public static void setSuperGiants() {
    //Ia
    ADD = 1;
    starcolumns = "14";
    supergiantscols = 14;
    supergiants = new String[]{
      "Orbit", "B0", "B5", "A0", "A5", "F0", "F5", "G0", "G5", "K0", "K5", "M0",
      "M5", "M9",
      "1", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", ". ", ".", ".",
      "2", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", ".", ".", ".",
      "3", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", ".", ".", ".",
      "4", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", ".", ".", ".",
      "5", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", ".", ".", ".",
      "6", "_", "_", "_", "_", "I", "I", "_", "_", "_", "_", ".", ".", ".",
      "7", "_", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", ".", ".",
      "8", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I",
      "9", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I",
      "10", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I",
      "11", "I", "I", "I", "I", "I", "H", "I", "I", "I", "I", "I", "I", "I",
      "12", "I", "H", "H", "H", "H", "O", "H", "H", "H", "H", "H", "H", "H",
      "13", "H", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "14", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "15", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "16", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "17", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "18", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "19", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "20", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"
    };
  }

  /**
   public static void setWeakerSuperGiants() {
   */
  public static void setWeakerSuperGiants() {
    //Ib
    ADD = 1;
    starcolumns = "14";
    weakersupergiantscols = 14;
    weakersupergiants = new String[]{
      "Orbit", "B0", "B5", "A0", "A5", "F0", "F5", "G0", "G5", "K0", "K5", "M0",
      "M5", "M9",
      "1", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_",
      "2", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_",
      "3", "_", "_", "_", "_", "_", "I", "I", "_", "_", "_", "_", "_", "_",
      "4", "_", "_", "_", "I", "I", "I", "I", "I", "_", "_", "_", "_", "_",
      "5", "_", "_", "I", "I", "I", "I", "I", "I", "I", "_", "_", "_", "_",
      "6", "_", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "_", "_",
      "7", "_", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "_",
      "8", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I",
      "9", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I",
      "10", "I", "I", "I", "H", "H", "H", "H", "H", "H", "I", "I", "I", "I",
      "11", "I", "H", "H", "O", "O", "O", "O", "O", "O", "H", "H", "I", "I",
      "12", "I", "O", "O", "O", "O", "O", "O", "O", "O", "O", "H", "H", "H",
      "13", "H", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "14", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "15", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "16", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "17", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "18", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "19", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "20", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"
    };
  }

  /**
   public static void setBrightGiants() {
   */
  public static void setBrightGiants() {
    //II
    ADD = 1;
    starcolumns = "14";
    brightgiantscols = 14;
    brightgiants = new String[]{
      "Orbit", "B0", "B5", "A0", "A5", "F0", "F5", "G0", "G5", "K0", "K5", "M0",
      "M5", "M9",
      "1", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_",
      "2", "_", "_", "_", "I", "I", "I", "I", "I", "I", "_", "_", "_", "_",
      "3", "_", "_", "I", "I", "I", "I", "I", "I", "I", "I", "_", "_", "_",
      "4", "_", "_", "I", "I", "I", "I", "I", "I", "I", "I", "I", "_", "_",
      "5", "_", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "_", "_",
      "6", "_", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I",
      "7", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I",
      "8", "I", "I", "I", "H", "H", "H", "H", "H", "I", "I", "I", "I", "I",
      "9", "I", "I", "H", "O", "O", "O", "O", "O", "H", "H", "I", "I", "I",
      "10", "I", "I", "O", "O", "O", "O", "O", "O", "O", "O", "H", "I", "I",
      "11", "I", "H", "O", "O", "O", "O", "O", "O", "O", "O", "O", "H", "H",
      "12", "H", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "13", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "14", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "15", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "16", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "17", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "18", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "19", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "20", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"
    };
  }

  /**
   public static void setGiants() {
   */
  public static void setGiants() {
    //III
    ADD = 1;
    starcolumns = "14";
    giantscols = 14;
    giants = new String[]{
      "Orbit", "B0", "B5", "A0", "A5", "F0", "F5", "G0", "G5", "K0", "K5", "M0",
      "M5", "M9",
      "1", "_", "_", "I", "I", "I", "I", "I", "I", "I", "I", "_", "_", "_",
      "2", "_", "_", "I", "I", "I", "I", "I", "I", "I", "I", "I", "_", "_",
      "3", "_", "_", "I", "I", "I", "I", "I", "I", "I", "I", "I", "_", "_",
      "4", "_", "_", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I",
      "5", "_", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I", "I",
      "6", "_", "I", "I", "I", "H", "H", "H", "I", "I", "I", "I", "I", "I",
      "7", "I", "I", "I", "H", "O", "O", "O", "H", "H", "I", "I", "I", "I",
      "8", "I", "I", "H", "O", "O", "O", "O", "O", "O", "H", "H", "I", "I",
      "9", "I", "I", "O", "O", "O", "O", "O", "O", "O", "O", "O", "H", "H",
      "10", "I", "H", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "11", "I", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "12", "H", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "13", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "14", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "15", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "16", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "17", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "18", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "19", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "20", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"
    };
  }

  /**
   public static void setSubGiants() {
   */
  public static void setSubGiants() {
    //IV
    ADD = 0;
    starcolumns = "10";
    subgiantscols = 10;
    subgiants = new String[]{
      "Orbit", "B0", "B5", "A0", "A5", "F0", "F5", "G0", "G5", "K0",
      "0", "_", "_", "_", "I", "I", "I", "I", "I", "I",
      "1", "_", "_", "I", "I", "I", "I", "I", "I", "I",
      "2", "_", "_", "I", "I", "I", "I", "I", "I", "I",
      "3", "_", "I", "I", "I", "I", "I", "I", "I", "I",
      "4", "_", "I", "I", "I", "I", "I", "I", "I", "H",
      "5", "_", "I", "I", "I", "I", "H", "H", "H", "O",
      "6", "_", "I", "I", "H", "H", "O", "O", "O", "O",
      "7", "I", "I", "H", "O", "O", "O", "O", "O", "O",
      "8", "I", "I", "O", "O", "O", "O", "O", "O", "O",
      "9", "I", "H", "O", "O", "O", "O", "O", "O", "O",
      "10", "I", "O", "O", "O", "O", "O", "O", "O", "O",
      "11", "I", "O", "O", "O", "O", "O", "O", "O", "O",
      "12", "H", "O", "O", "O", "O", "O", "O", "O", "O",
      "13", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "14", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "15", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "16", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "17", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "18", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "19", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "20", "O", "O", "O", "O", "O", "O", "O", "O", "O"
    };
  }

  /**
   public static void setMainSequence() {
   */
  public static void setMainSequence() {
    //V
    ADD = 0;
    starcolumns = "14";
    mainsequencecols = 14;
    mainsequence = new String[]{
      "Orbit", "B0", "B5", "A0", "A5", "F0", "F5", "G0", "G5", "K0", "K5", "M0",
      "M5", "M9",
      "0", "_", "_", "I", "I", "I", "I", "I", "I", "I", "H", "H", "O", "O",
      "1", "_", "_", "I", "I", "I", "I", "I", "I", "I", "O", "O", "O", "O",
      "2", "_", "_", "I", "I", "I", "I", "I", "H", "H", "O", "O", "O", "O",
      "3", "_", "I", "I", "I", "I", "I", "H", "O", "O", "O", "O", "O", "O",
      "4", "_", "I", "I", "I", "I", "H", "O", "O", "O", "O", "O", "O", "O",
      "5", "_", "I", "I", "I", "H", "O", "O", "O", "O", "O", "O", "O", "O",
      "6", "I", "I", "I", "H", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "7", "I", "I", "H", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "8", "I", "I", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "9", "I", "H", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "10", "I", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "11", "I", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "12", "H", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "13", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "14", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "15", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "16", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "17", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "18", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "19", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
      "20", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O"
    };
  }

  /**
   public static void setSubDwarfs() {
   */
  public static void setSubDwarfs() {
    //VI
    ADD = 0;
    starcolumns = "9";
    subdwarfscols = 9;
    subdwarfs = new String[]{
      "Orbit", "F5", "G0", "G5", "K0", "K5", "M0", "M5", "M9",
      "0", "I", "I", "I", "I", "O", "O", "O", "O",
      "1", "I", "I", "H", "H", "O", "O", "O", "O",
      "2", "I", "H", "O", "O", "O", "O", "O", "O",
      "3", "H", "O", "O", "O", "O", "O", "O", "O",
      "4", "O", "O", "O", "O", "O", "O", "O", "O",
      "5", "O", "O", "O", "O", "O", "O", "O", "O",
      "6", "O", "O", "O", "O", "O", "O", "O", "O",
      "7", "O", "O", "O", "O", "O", "O", "O", "O",
      "8", "O", "O", "O", "O", "O", "O", "O", "O",
      "9", "O", "O", "O", "O", "O", "O", "O", "O",
      "10", "O", "O", "O", "O", "O", "O", "O", "O",
      "11", "O", "O", "O", "O", "O", "O", "O", "O",
      "12", "O", "O", "O", "O", "O", "O", "O", "O"
    };
  }

  /**
   public static void setWhiteDwarfs() {
   */
  public static void setWhiteDwarfs() {
    //D
    ADD = 0;
    starcolumns = "7";
    whitedwarfscols = 7;
    whitedwarfs = new String[]{
      "Orbit", "BD", "AD", "FD", "GD", "KD", "MD",
      "0", "H", "O", "O", "O", "O", "O",
      "1", "O", "O", "O", "O", "O", "O",
      "2", "O", "O", "O", "O", "O", "O",
      "3", "O", "O", "O", "O", "O", "O",
      "4", "O", "O", "O", "O", "O", "O",
      "5", "O", "O", "O", "O", "O", "O",
      "6", "O", "O", "O", "O", "O", "O",
      "7", "O", "O", "O", "O", "O", "O",
      "8", "O", "O", "O", "O", "O", "O",
      "9", "O", "O", "O", "O", "O", "O",
      "10", "O", "O", "O", "O", "O", "O",};
  }

  /**
   <p>
   @param i number of star size
   */
  public static void getStarTables(int i) {
    int num;
    table = null;
    switch (i) {
      case 0: {
        setSuperGiants();
        table = supergiants;
        break;
      }
      case 1: {
        setWeakerSuperGiants();
        table = weakersupergiants;
        break;
      }
      case 2: {
        setBrightGiants();
        table = brightgiants;
        break;
      }
      case 3: {
        setGiants();
        table = giants;
        break;
      }
      case 4: {
        setSubGiants();
        table = subgiants;
        break;
      }
      case 5: {
        setMainSequence();
        table = mainsequence;
        break;
      }
      case 6: {
        setSubDwarfs();
        table = subdwarfs;
        break;
      }
      case 7: {
        setWhiteDwarfs();
        table = whitedwarfs;
        break;
      }
    }
//    //System.out.println("table[0]" + " = " + table[0]);
    startable = startables[i];
    num = Integer.parseInt(starcolumns);
    int leng = table.length;
    int lines = leng - num;
    jta.append(CRLF);
    jta.append("\t" + startable + CRLF);
    for (int j = 0; j < lines; j += num) {
      for (i = 0; i < num; i++) {
        jta.append("" + table[i + j] + "\t");
      }
      jta.append(CRLF);
    }
    jta.append("" + CRLF);
  }

  /**
   <p>
   @param type Colour of star
   @param size size of star
   @return DM to roll
   */
  public static int getSizeDMs(String type, String size) {
    ////System.out.println("size" + " = " + size);
    int num = 0;
    switch (size) {
      case "Ia": {
        num = 8;
        break;
      }
      case "Ib": {
        num = 8;
        break;
      }
      case "II": {
        num = 8;
        break;
      }
      case "III": {
        num = 4;
        break;
      }
      case "IV": {
        break;
      }
      case "V": {
        break;
      }
      case "VI": {
        break;
      }
      case "D": {
        break;
      }
    }
    switch (type) {
      case "M": {
        num += -4;
        break;
      }
      case "K": {
        num += -2;
        break;
      }
    }
    return num;
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jComboBox1 = new javax.swing.JComboBox();
    jPanel1 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jta = new javax.swing.JTextArea();
    jPanel2 = new javax.swing.JPanel();
    features = new javax.swing.JButton();
    save = new javax.swing.JButton();
    Pic = new javax.swing.JButton();
    setOrbitData = new javax.swing.JButton();
    load = new javax.swing.JButton();
    uwp = new javax.swing.JTextField();
    update = new javax.swing.JButton();
    jSpinner1 = new javax.swing.JSpinner();
    useUWP = new javax.swing.JCheckBox();
    Moons = new javax.swing.JButton();
    Zones = new javax.swing.JButton();
    Planets = new javax.swing.JButton();
    tl = new javax.swing.JButton();
    UWP = new javax.swing.JButton();
    system = new javax.swing.JButton();
    jSpinner2 = new javax.swing.JSpinner();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jButton3 = new javax.swing.JButton();

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "//Choose Table", "Planets", "Moons", "Zones", "UWP", "Magnitude", "Luminosity", "Temp", "Radii", "Masses", "WhiteDwarfs", "HabitableDistance", "Distance" }));
    jComboBox1.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        jComboBox1ItemStateChanged(evt);
      }
    });

    jPanel1.setOpaque(false);
    jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

    jta.setColumns(20);
    jta.setRows(5);
    jta.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jtaMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jta);

    jPanel2.setOpaque(false);
    jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseMoved(java.awt.event.MouseEvent evt) {
        jPanel2MouseMoved(evt);
      }
    });

    features.setText("Features");
    features.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        featuresActionPerformed(evt);
      }
    });

    save.setText("S");
    save.setToolTipText("Save");
    save.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveActionPerformed(evt);
      }
    });

    Pic.setText("Pic");
    Pic.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        PicActionPerformed(evt);
      }
    });

    setOrbitData.setText("Data");
    setOrbitData.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        setOrbitDataActionPerformed(evt);
      }
    });

    load.setText("L");
    load.setToolTipText("Load");
    load.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        loadActionPerformed(evt);
      }
    });

    uwp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    uwp.setText("A788899-C");
    uwp.setToolTipText("Set world data");
    uwp.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        uwpMouseClicked(evt);
      }
    });

    update.setText("Update");
    update.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        updateActionPerformed(evt);
      }
    });

    jSpinner1.setModel(new javax.swing.SpinnerNumberModel(-1, -1, 15, 1));
    jSpinner1.setToolTipText("Select world orbit to get distances");
    jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jSpinner1StateChanged(evt);
      }
    });

    useUWP.setText("TL");
    useUWP.setFocusable(false);
    useUWP.setOpaque(false);
    useUWP.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        useUWPActionPerformed(evt);
      }
    });

    Moons.setText("Moons");
    Moons.setToolTipText("Orbit distance");
    Moons.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        MoonsActionPerformed(evt);
      }
    });

    Zones.setText("Zones");
    Zones.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        ZonesActionPerformed(evt);
      }
    });

    Planets.setText("Planets");
    Planets.setToolTipText("Orbit distance");
    Planets.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        PlanetsActionPerformed(evt);
      }
    });

    tl.setText("TL");
    tl.setToolTipText("Set Tech Level");
    tl.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tlActionPerformed(evt);
      }
    });

    UWP.setText("UWP");
    UWP.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        UWPActionPerformed(evt);
      }
    });

    system.setText("System");
    system.setToolTipText("Set Starport");
    system.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        systemActionPerformed(evt);
      }
    });

    jSpinner2.setModel(new javax.swing.SpinnerNumberModel(-1, -1, 12, 1));
    jSpinner2.setToolTipText("Select satellite orbit to get distances");
    jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jSpinner2StateChanged(evt);
      }
    });

    jButton1.setText("GO");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setText("jButton2");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jButton3.setText("jButton3");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(load, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(useUWP, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(system, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(Pic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(uwp, javax.swing.GroupLayout.Alignment.TRAILING))
              .addGap(79, 79, 79)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(features, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
              .addGap(2, 2, 2)
              .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                  .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(setOrbitData, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createSequentialGroup()
                  .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(Planets, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(Moons, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(Zones, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(UWP, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))))
          .addComponent(jButton3))
        .addGap(0, 0, Short.MAX_VALUE))
    );

    jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Pic, features, system, tl, uwp});

    jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {load, save});

    jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Moons, Planets, UWP, Zones, jButton2, setOrbitData, update});

    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(setOrbitData, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Moons, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Zones, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(UWP, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Planets, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(46, 46, 46)
            .addComponent(system, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tl, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(features, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(111, 111, 111)
            .addComponent(uwp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Pic)))
        .addGap(1, 1, 1)
        .addComponent(jButton3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(load, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(save)
            .addComponent(useUWP))))
    );

    jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Pic, features, system, tl, uwp});

    jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {load, save});

    jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Moons, Planets, UWP, Zones, jButton2, setOrbitData, update});

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        .addGap(0, 0, 0)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jScrollPane1)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    add(jPanel1, java.awt.BorderLayout.CENTER);
  }// </editor-fold>//GEN-END:initComponents

  private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
    //<editor-fold defaultstate="collapsed" desc="comment">
    if (hasparent == true) {
      try {
        DBViewer.jfc.setSelectedFile(new File(
          dbviewer.globals.GlobalVariables.BMP + "/Imp/"
          + panels.Panel4Locator.getSectorName().substring(0, 4) + "/"
          + panels.Panel4Locator.getSubSectorName() + "/"
          + panels.Panel4SubSector.jList1.getSelectedValue().toString()
          + "-" + panels.Panel4SubSector.UWP.getText().substring(7, 8) + ".txt"));
        f = new File(DBViewer.jfc.getSelectedFile().getAbsolutePath());
        ////System.out.println("" + " === " + DBViewer.jfc.getSelectedFile().getAbsolutePath());
      } catch (Exception ex) {
        Logger.getLogger(Panel4StarGen.class.getName()).log(Level.SEVERE, null,
          ex);
      }

    } else {
      // = new File("C:\\Users\\maggot\\Documents\\", "OrbitalData.txt");
    }
    //</editor-fold>
    jta.setText("VARIABLES" + CRLF + "====================" + CRLF);
    String[] lines = dbviewer.globals.GlobalMethods.getLinesFromFile(f);
    if (lines.length > 2) {
      int k = 0;
      //int j = 2;
      for (int i = 2; i < lines.length; i++) {
        try {
          k = lines[i].lastIndexOf("=") + 1;
          svars[i - 2] = lines[i].substring(k).trim();
          //System.out.println("" + " = " + lines[i].substring(k).trim());
          //System.out.println(svarnames[i - 2].trim() + "=" + svars[i - 2].trim());
          jta.append(svarnames[i - 2].trim() + "=" + svars[i - 2].trim() + CRLF);
          //    j += 1;
        } catch (Exception e) {
          JOptionPane.showMessageDialog(jta, "loadActionPerformed()");
          //System.out.println(globals.GlobalMethods.comment("=", 20));
          //System.out.println("loadActionPerformed".toUpperCase());
          //System.out.println("e" + " = " + e);
          //System.out.println("i" + " = " + i);
          //    //System.out.println("j" + " = " + j);
          //System.out.println("k" + " = " + k);
          k = 0;
        }
      }
    }
//    save.doClick();
  }//GEN-LAST:event_loadActionPerformed

  private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
    jta.setText("");
    update();
  }//GEN-LAST:event_updateActionPerformed

  private void UWPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UWPActionPerformed
    jta.setText("");
    printUWP();
  }//GEN-LAST:event_UWPActionPerformed

  private void ZonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZonesActionPerformed
    jta.setText("");
    jta.append("Star Zone Detail".toUpperCase() + CRLF);
    jta.append(dbviewer.globals.GlobalMethods.comment("=", 20));
    for (int i = 0; i < 8; i++) {
      getStarTables(i);
    }
    //    test();
  }//GEN-LAST:event_ZonesActionPerformed

  private void MoonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoonsActionPerformed
    jta.setText("");
    jta.append("Satellite Orbit Detail".toUpperCase() + CRLF);
    jta.append(dbviewer.globals.GlobalMethods.comment("=", 20));
    for (int i = 0; i < satelliteorbitvarnames.length; i++) {
      jta.append(" " + satelliteorbitvarnames[i].toUpperCase().substring(14)
        + "\t");
    }
    jta.append(CRLF);
    for (int i = 0; i < 13; i++) {
      jta.append("" + getSatelliteOrbit(i) + CRLF);
    }
  }//GEN-LAST:event_MoonsActionPerformed

  private void PlanetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlanetsActionPerformed
    jta.setText("");
    jta.append("Planetary Orbit Table".toUpperCase() + CRLF);
    jta.append(dbviewer.globals.GlobalMethods.comment("=", 20));
    int i;
    for (i = 0; i < planetaryorbitvarnames.length; i++) {
      jta.append("ORBIT " + planetaryorbitvarnames[i].toUpperCase()
        .substring(17) + "\t");
    }
    jta.append(CRLF);
    for (i = 0; i < planetaryorbitnum.length; i++) {
      jta.append("" + getPlanetaryOrbit(i) + CRLF);
    }
  }//GEN-LAST:event_PlanetsActionPerformed

  private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
    jta.setText("");
    int num = (int) jSpinner2.getValue();
    for (starorbit = 0; starorbit < satelliteorbitvarnames.length; starorbit++) {
      jta.append("" + satelliteorbitvarnames[starorbit].toUpperCase().substring(
        14) + "\t");
    }
    jta.append(CRLF);
    if (num >= 0) {
      jta.append("" + getSatelliteOrbit(num) + CRLF);
    }
  }//GEN-LAST:event_jSpinner2StateChanged

  private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
    jta.setText("");
    int num = (int) jSpinner1.getValue();
    for (starorbit = 0; starorbit < planetaryorbitvarnames.length; starorbit++) {
      jta.append("ORBIT " + planetaryorbitvarnames[starorbit].toUpperCase()
        .substring(17) + "\t");
    }
    jta.append(CRLF);
    if (num >= 0) {
      jta.append("" + getPlanetaryOrbit(num) + CRLF);
    }
  }//GEN-LAST:event_jSpinner1StateChanged

  private void useUWPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useUWPActionPerformed
    if (useUWP.isSelected()) {
      //String string = "A788999C";
      //uwp.setText(string);
    } else {
      uwp.setText("");
    }
  }//GEN-LAST:event_useUWPActionPerformed

  private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    update.doClick();
    dbviewer.globals.GlobalMethods.autoSave(true, jta, hasparent);
    try {
      String[] lines = dbviewer.globals.GlobalMethods.getLinesFromFile(f);
      int j = 2;
      jta.setText("VARIABLES" + CRLF + dbviewer.globals.GlobalMethods.comment(
        "=", 20));
      try {
        for (int i = 0; i < svars.length; i++) {
          int k = lines[j].lastIndexOf("=") + 1;
          svars[i] = lines[j].substring(k).trim();
          jta.append(svarnames[i] + "=" + svars[i] + CRLF);
          j += 1;
        }
      } catch (Exception e) {
      }
    } catch (Exception e) {
    }
  }//GEN-LAST:event_saveActionPerformed

  private void featuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_featuresActionPerformed
    try {
      jta.setText("");
      getSystemFeatures();
      update.doClick();
//      orbits.doClick();
      repaint();
    } catch (Exception e) {
      //System.out.println("e.toString()" + " = " + e.toString());
    }
  }//GEN-LAST:event_featuresActionPerformed

  private void tlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tlActionPerformed
    jta.setText("");
    useUWP.setSelected(true);
    getTechLevel();
  }//GEN-LAST:event_tlActionPerformed

  private void uwpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uwpMouseClicked
    if (hasparent == false) {
      generateUWP();
      UWP.doClick();
    }
//    StarGen.addMainworld();
  }//GEN-LAST:event_uwpMouseClicked

  private void systemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_systemActionPerformed
    jta.setText("");
    getSystemContents();
  }//GEN-LAST:event_systemActionPerformed

  private void jtaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtaMouseClicked
    if (evt.getClickCount() > 2) {
      jta.setText("");
    }
  }//GEN-LAST:event_jtaMouseClicked

  private void PicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PicActionPerformed
//    setOrbitData.doClick();

    Panel4StarPic.hasparent = true;
    Panel4StarPic.main(new String[]{f4sg.getTitle()});
  }//GEN-LAST:event_PicActionPerformed

  private void setOrbitDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setOrbitDataActionPerformed
    StarGen.showOrbitData();
  }//GEN-LAST:event_setOrbitDataActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    setVars();
    printVars();
    try {
      StarGen.arrange();
    } catch (Exception e) {
      System.out.println("StarGen.arrange()" + " = " + e);
    }
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    testButton();
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved
    //repaint();
  }//GEN-LAST:event_jPanel2MouseMoved

  private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
    jta.setText("");
    switch (jComboBox1.getSelectedItem().toString()) {
      case "Planets": {
//        Planets.doClick();
        showTable(jta, "Planets", StarGen.Planets);
        break;
      }
      case "Moons": {
//        Moons.doClick();
        showTable(jta, "Moons", StarGen.Moons);
        break;
      }
      case "Zones": {
//        Zones.doClick();
        showTable(jta, "Zones", StarGen.Zones);
        break;
      }
      case "UWP": {
//        UWP.doClick();
        showTable(jta, "UWP", StarGen.UWP);
        break;
      }
      case "Magnitude": {
//        Panel4USqP.showTable(jta,"Magnitude",StarGen.Magnitude);
        showTable(jta, "Magnitude", StarGen.Magnitude);
        break;
      }
      case "Luminosity": {
        showTable(jta, "Luminosity", StarGen.Luminosity);
        break;
      }
      case "Temp": {
        showTable(jta, "Temp", StarGen.Temp);
        break;
      }
      case "Radii": {
        showTable(jta, "Radii", StarGen.Radii);
        break;
      }
      case "Masses": {
        showTable(jta, "Masses", StarGen.Masses);
        break;
      }
      case "WhiteDwarfs": {
        showTable(jta, "WhiteDwarfs", StarGen.WhiteDwarfs);
        break;
      }
      case "HabitableDistance": {
        showTable(jta, "HabitableDistance", StarGen.HabitableDistance);
        break;
      }
      case "Distance": {
        showTable(jta, "Distance", StarGen.Distance);
        break;
      }
    }

  }//GEN-LAST:event_jComboBox1ItemStateChanged

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    for (int i = 0; i < 100; i++) {
      System.out.println("" + " = " + i);
      jButton1.doClick();
    }
  }//GEN-LAST:event_jButton3ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private static javax.swing.JButton Moons;
  public static javax.swing.JButton Pic;
  private static javax.swing.JButton Planets;
  private static javax.swing.JButton UWP;
  private static javax.swing.JButton Zones;
  private static javax.swing.JButton features;
  public static javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  public javax.swing.JComboBox jComboBox1;
  private static javax.swing.JLabel jLabel1;
  private static javax.swing.JPanel jPanel1;
  private static javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSpinner jSpinner1;
  private javax.swing.JSpinner jSpinner2;
  public static javax.swing.JTextArea jta;
  public static javax.swing.JButton load;
  public static javax.swing.JButton save;
  private static javax.swing.JButton setOrbitData;
  private static javax.swing.JButton system;
  private static javax.swing.JButton tl;
  private static javax.swing.JButton update;
  public static javax.swing.JCheckBox useUWP;
  public static javax.swing.JTextField uwp;
  // End of variables declaration//GEN-END:variables

  private void testButton() {
////    jta.setText("");
//    int count = 0;
//    for (int i = 0; i < StarGen.txt.length; i++) {
////      jta.append(StarGen.txt[i]+CRLF);
//      if (StarGen.txt[i].contains("--------------------")) {
//        count += 1;
//      }
//      if (StarGen.txt[i].contains("\tH")) {
//        StarGen.setHabitable(count-1);
//        //System.out.println("" + " = " + (count-1));
//
//        break;
//      }
//    }
//    return;
  }

  private void update() {
    starport = uwp.getText().substring(0, 1);
    planetoidpresence = planetoids;
    gasgiantpresence = gasgiant;
    mainworldsize = uwp.getText().substring(1, 2);
    mainworldatmo = uwp.getText().substring(2, 3);
    mainworldhydro = uwp.getText().substring(3, 4);
    mainworldpop = uwp.getText().substring(4, 5);
    mainworldgovt = uwp.getText().substring(5, 6);
    mainworldlaw = uwp.getText().substring(6, 7);
    mainworldtl = uwp.getText().substring(8, 9);
    svars = new String[]{
      starport, navalbase, scoutbase, gasgiant, nature,
      primarytype, primarysize, primaryorbit, primaryorbits,
      secondarytype, secondarysize, secondaryorbit, secondaryorbits,
      tertiarytype, tertiarysize, tertiaryorbit, tertiaryorbits,
      gasgiant, gasgiantpresence, gasgiantquantity, planetoids,
      planetoidpresence, planetoidquantity,
      primaryorbits, secondaryorbits, tertiaryorbits,
      mainworldsize, mainworldatmo, mainworldhydro,
      mainworldpop, mainworldgovt, mainworldlaw, mainworldtl,
      "" + iTLMods[0], "" + iTLMods[1], "" + iTLMods[2], "" + iTLMods[3],
      "" + iTLMods[4], "" + iTLMods[5], "" + iTLMods[6],
      primaryorbits, secondaryorbits, tertiaryorbits
    };
//    for (int i = 0; i < svars.length; i++) {
//      //System.out.println(svarnames[i] + "=" + svars[i].trim());
//    }
    printVars();
  }

  private static void getTLs() {
    //<editor-fold defaultstate="collapsed" desc="systemcontentstarport">
    switch (starport) {
      case "A": {
        sp = 6;
        break;
      }
      case "B": {
        sp = 4;
        break;
      }
      case "C": {
        sp = 2;
        break;
      }
      case "X": {
        sp = -4;
        break;
      }
      default: {
        sp = 0;
      }
    }
    iTLMods[1] = sp;
    //</editor-fold>//sp
    //<editor-fold defaultstate="collapsed" desc="mainworldsize">
    mainworldsize = uwp.getText().substring(1, 2);
    switch ("" + mainworldsize) {
      case "0":
      case "1": {
        si = 2;
        break;
      }
      case "2":
      case "3":
      case "4": {
        si = 1;
        break;
      }
      default: {
        si = 0;
      }
    }
    iTLMods[2] = si;
    //</editor-fold>//si
    //<editor-fold defaultstate="collapsed" desc="mainworldatmo">
    mainworldatmo = uwp.getText().substring(2, 3);
//      mainworldatmo = globals.GlobalMethods.fromHex(mainworldatmo);

    switch (mainworldatmo) {
      case "0":
      case "1":
      case "2":
      case "3":
      case "A":
      case "B":
      case "C":
      case "D":
      case "E": {
        at = 1;
        break;
      }
      default: {
        at = 0;
      }
    }
    iTLMods[3] = at;
    //</editor-fold>//at
    //<editor-fold defaultstate="collapsed" desc="mainworldhydro">
    mainworldhydro = uwp.getText().substring(3, 4);
    switch ("" + mainworldhydro) {
      case "9": {
        hy = 1;
        break;
      }
      case "A": {
        hy = 2;
        break;
      }
      default: {
        hy = 0;
      }
    }
    iTLMods[4] = hy;
    //</editor-fold>//hy
    //<editor-fold defaultstate="collapsed" desc="mainworldpop">
    mainworldpop = uwp.getText().substring(4, 5);
    switch ("" + mainworldpop) {
      case "1":
      case "2":
      case "3":
      case "4":
      case "5": {
        po = 1;
        break;
      }
      case "9": {
        po = 2;
        break;
      }
      case "A": {
        po = 4;
        break;
      }
      default: {
        po = 0;
      }
    }
    iTLMods[5] = po;
    //</editor-fold>//po
    //<editor-fold defaultstate="collapsed" desc="mainworldgovt">
    mainworldgovt = uwp.getText().substring(5, 6);
    switch ("" + mainworldgovt) {
      case "0":
      case "5": {
        go = 1;
        break;
      }
      case "D": {
        go = -2;
        break;
      }
      default: {
        go = 0;
      }
    }
    iTLMods[6] = go;
    //</editor-fold>//go
    int i = iTLMods[1] + iTLMods[2] + iTLMods[3] + iTLMods[4] + iTLMods[5]
      + iTLMods[6];
    iTLMods[0] = iTL - i;
  }

  private static String getString(String string) {
    try {
//      ////System.out.println("" + " = " + string.toLowerCase());
      switch (string.toLowerCase()) {
        //<editor-fold defaultstate="collapsed" desc="MainworldContents">
        case "tl": {
          string = "" + iTL;
        }
        case "mainworldsize": {
          string = mainworldsize;
          break;
        }
        case "mainworldatmo": {
          string = mainworldatmo;
          break;
        }
        case "mainworldhydro": {
          string = mainworldhydro;
          break;
        }
        case "mainworldpop": {
          string = mainworldpop;
          break;
        }
        case "mainworldgovt": {
          string = mainworldgovt;
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="SystemContents">
        /*
         private static String starport;
         private static String navalbase;
         private static String scoutbase;
         private static String gasgiant;
         private static String planetoids;
         */
        case "starport": {
          string = starport;
        }
        case "navalbase": {
          string = navalbase;
        }
        case "scoutbase": {
          string = scoutbase;
        }
        case "gasgiant": {
          string = gasgiant;
        }
        case "planetoids": {
          string = planetoids;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="SystemFeature">
        case "nature": {
          string = nature;
          break;
        }
        case "primarytype": {
          string = primarytype;
          break;
        }
        case "primarysize": {
          string = primarysize;
          break;
        }
        case "companiontype": {
          string = secondarytype;
          break;
        }
        case "companionsize": {
          string = secondarysize;
          break;
        }
        case "companionorbit": {
          string = secondaryorbit;
          break;
        }
        case "maxorbits": {
          string = systemfeaturemaxorbits;
          break;
        }
        case "gasgiantpresence": {
          string = gasgiantpresence;
          break;
        }
        case "gasgiantquantity": {
          string = gasgiantquantity;
          break;
        }
        case "planetoidpresence": {
          string = planetoidpresence;
          break;
        }
        case "planetoidquantity": {
          string = planetoidquantity;
          break;
        }
        case "primaryorbits": {
          string = primaryorbits;
          break;
        }
        case "secondaryorbits": {
          string = secondaryorbits;
          break;
        }
        case "tertiaryorbits": {
          string = tertiaryorbits;
          break;
        }
        //</editor-fold>
      }
    } catch (NullPointerException e) {
      ////System.out.println("e.getLocalizedMessage()" + " = " + e.getLocalizedMessage());
      ////System.out.println("" + " = " + globals.GlobalMethods.comment("x", 20));
    }
    return string;
  }

  private static int getTechLevel() {
//    roll = (int) ((Math.random() * 6) + 1);
//    iTLMods[0] = roll;
    if (useUWP.isSelected()) {
      //<editor-fold defaultstate="collapsed" desc="systemcontentstarport">
      switch (starport) {
        case "A": {
          sp = 6;
          break;
        }
        case "B": {
          sp = 4;
          break;
        }
        case "C": {
          sp = 2;
          break;
        }
        case "X": {
          sp = -4;
          break;
        }
        default: {
          sp = 0;
        }
      }
//      TLs[1] = sp;
      //</editor-fold>//sp
      //<editor-fold defaultstate="collapsed" desc="mainworldsize">
      mainworldsize = uwp.getText().substring(1, 2);
      switch ("" + mainworldsize) {
        case "0":
        case "1": {
          si = 2;
          break;
        }
        case "2":
        case "3":
        case "4": {
          si = 1;
          break;
        }
        default: {
          si = 0;
        }
      }
//      TLs[2] = si;
      //</editor-fold>//si
      //<editor-fold defaultstate="collapsed" desc="mainworldatmo">
      mainworldatmo = uwp.getText().substring(2, 3);
//      mainworldatmo = globals.GlobalMethods.fromHex(mainworldatmo);

      switch (mainworldatmo) {
        case "0":
        case "1":
        case "2":
        case "3":
        case "A":
        case "B":
        case "C":
        case "D":
        case "E": {
          at = 1;
          break;
        }
        default: {
          at = 0;
        }
      }
      iTLMods[3] = at;
      //</editor-fold>//at
      //<editor-fold defaultstate="collapsed" desc="mainworldhydro">
      mainworldhydro = uwp.getText().substring(3, 4);
      switch ("" + mainworldhydro) {
        case "9": {
          hy = 1;
          break;
        }
        case "A": {
          hy = 2;
          break;
        }
        default: {
          hy = 0;
        }
      }
      iTLMods[4] = hy;
      //</editor-fold>//hy
      //<editor-fold defaultstate="collapsed" desc="mainworldpop">
      mainworldpop = uwp.getText().substring(4, 5);
      switch ("" + mainworldpop) {
        case "1":
        case "2":
        case "3":
        case "4":
        case "5": {
          po = 1;
          break;
        }
        case "9": {
          po = 2;
          break;
        }
        case "A": {
          po = 4;
          break;
        }
        default: {
          po = 0;
        }
      }
      iTLMods[5] = po;
      //</editor-fold>//po
      //<editor-fold defaultstate="collapsed" desc="mainworldgovt">
      mainworldgovt = uwp.getText().substring(5, 6);
      switch ("" + mainworldgovt) {
        case "0":
        case "5": {
          go = 1;
          break;
        }
        case "D": {
          go = -2;
          break;
        }
        default: {
          go = 0;
        }
      }
//      TLs[6] = go;
      //</editor-fold>//go
      int i = getRoll(1);
      iTLMods[0] = i;
      iTLMods[1] = sp;
      iTLMods[2] = si;
      iTLMods[3] = at;
      iTLMods[4] = hy;
      iTLMods[5] = po;
      iTLMods[6] = go;
      iTL = setMinimum(i + sp + si + at + hy + po + go, 0);

      String uwps = uwp.getText().substring(0, 7);
      String tl = dbviewer.globals.GlobalMethods.toHex(iTL);
      uwps += "-" + tl;
      uwp.setText(uwps);
    }
    printTechLevel();
    return iTL;
  }

  private void getSystemContents() {
    //<editor-fold defaultstate="collapsed" desc="Starport">
    /*
     Starport
     */
    if (useUWP.isSelected()) {
      starport = uwp.getText().substring(0, 1);
    } else {
//      starport = uwp.getText().substring(0, 1);
      getSP();
    }
    String Uwp = uwp.getText();
    uwp.setText(starport + Uwp.substring(1));
//    JOptionPane.showMessageDialog(this, Uwp);
    uwp.setText(Uwp);
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Naval Base">
    /*
     Naval Base
     */
    if (("A".equals(starport)) | ("B".equals(starport))) {
      starorbit = getRoll(2);
      switch (starorbit) {
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7: {
          navalbase = "no";
          break;
        }
        case 8:
        case 9:
        case 10:
        case 11:
        case 12: {
          navalbase = "yes";
          break;
        }
      }
    } else {
      navalbase = "NO";
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Scout Base">
    /*
     Scout Base
     */
    if ((!"X".equals(starport)) & (!"E".equals(starport))) {
      starorbit = getRoll(2);
      switch (starport) {
        case "C": {
          starorbit -= 1;
          break;
        }
        case "B": {
          starorbit -= 2;
          break;
        }
        case "A": {
          starorbit -= 3;
          break;
        }
        default: {
          starorbit = 0;
        }
      }
      setMinimum(starorbit, 2);
      switch (starorbit) {
        case 2:
        case 3:
        case 4:
        case 5:
        case 6: {
          scoutbase = "no";
          break;
        }
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12: {
          scoutbase = "yes";
          break;
        }
      }
    } else {
      scoutbase = "NO";
      starorbit = 0;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Gas Giants">
    /*
     Gas Giants
     */
    starorbit = getRoll(2);
    switch (starorbit) {
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9: {
        gasgiant = "yes";
        break;
      }
      case 10:
      case 11:
      case 12: {
        gasgiant = "no";
        break;
      }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Planetoids">
    /*
     Planetoids
     */
    starorbit = getRoll(2);
    switch (starorbit) {
      case 2:
      case 3:
      case 4:
      case 5:
      case 6: {
        planetoids = "yes";
        break;
      }
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12: {
        planetoids = "no";
      }
    }
    //</editor-fold>
    //-------------------------
    SystemContents = new String[]{
      starport, navalbase, scoutbase, gasgiant, planetoids
    };
    printSystemContents();
  }

  private void printSystemContents() {
    jta.append("System Contents".toUpperCase() + CRLF);
    jta.append(dbviewer.globals.GlobalMethods.comment("=", 20));
    for (starorbit = 0; starorbit < SystemContents.length; starorbit++) {
      jta.append("\t" + systemcontentvarnames[starorbit].toUpperCase() + " = "
        + getString(SystemContents[starorbit]) + CRLF);
    }
  }

  private void getSystemFeatures() {
    //<editor-fold defaultstate="collapsed" desc="if(hasparent)">
    if (hasparent == true) {
      //<editor-fold defaultstate="collapsed" desc="Basic Nature">
      //Basic Nature
      if (!"".equals(panels.Panel4SubSector.jcb4Star1.getSelectedItem()
        .toString())) {
        nature = "Solo";
      }
      if (!"".equals(panels.Panel4SubSector.jcb4Star2.getSelectedItem()
        .toString())) {
        nature = "Binary";
      }
      if (!"".equals(panels.Panel4SubSector.jcb4Star3.getSelectedItem()
        .toString())) {
        nature = "Trinary";
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Primary">
      String jcb;
      jcb = Panel4SubSector.jcb4Star1.getSelectedItem().toString();
      //System.out.println("jcb" + " = " + jcb);
      if (!"".equals(jcb)) {
        primarytype = Panel4SubSector.jcb4Star1.getSelectedItem().toString()
          .substring(0, 1);
        primarysize = Panel4SubSector.jcb4Star1.getSelectedItem().toString()
          .substring(2);
        primaryorbit = "Centre";
      } else {
        //        primarytype = "no";
        //        primarysize = "no";
        //        primaryorbit = "no";
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Secondary">
      jcb = Panel4SubSector.jcb4Star2.getSelectedItem().toString();
      //System.out.println("jcb" + " = " + jcb);
      if (!"".equals(jcb)) {
        secondarytype = Panel4SubSector.jcb4Star2.getSelectedItem().toString()
          .substring(0, 1);
        secondarysize = Panel4SubSector.jcb4Star2.getSelectedItem().toString()
          .substring(2);
        //<editor-fold defaultstate="collapsed" desc="secondaryorbit">
        starorbit = getRoll(2);
        if (starorbit > 12) {
          starorbit = 12;
        }
        switch (starorbit) {
          case 0:
          case 1:
          case 2:
          case 3: {
            secondaryorbit = "Close";
            break;
          }
          case 4: {
            secondaryorbit = "1";
            break;
          }
          case 5: {
            secondaryorbit = "2";
            break;
          }
          case 6: {
            secondaryorbit = "3";
            break;
          }
          case 7: {
            secondaryorbit = "" + (4 + getRoll(1));
            break;
          }
          case 8: {
            secondaryorbit = "" + (5 + getRoll(1));
            break;
          }
          case 9: {
            secondaryorbit = "" + (6 + getRoll(1));
            break;
          }
          case 10: {
            secondaryorbit = "" + (7 + getRoll(1));
            break;
          }
          case 11: {
            secondaryorbit = "" + (8 + getRoll(1));
            break;
          }
          case 12: {
            secondaryorbit = "Far";
            break;
          }
        }
        //</editor-fold>
      } else {
        //        secondarytype = "no";
        //        secondarysize = "no";
        //        secondaryorbit = "no";
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Tertiary">
      jcb = Panel4SubSector.jcb4Star3.getSelectedItem().toString();
      //System.out.println("jcb" + " = " + jcb);
      //JOptionPane.showMessageDialog(null, jcb);
      if (!"".equals(jcb)) {
        tertiarytype = Panel4SubSector.jcb4Star3.getSelectedItem().toString()
          .substring(0, 1);
        tertiarysize = Panel4SubSector.jcb4Star3.getSelectedItem().toString()
          .substring(2);
        //<editor-fold defaultstate="collapsed" desc="tertiaryorbit">
        starorbit = getRoll(2) + 4;
        if (starorbit > 12) {
          starorbit = 12;
        }
        switch (starorbit) {
          case 0:
          case 1:
          case 2:
          case 3: {
            tertiaryorbit = "Close";
            break;
          }
          case 4: {
            tertiaryorbit = "1";
            break;
          }
          case 5: {
            tertiaryorbit = "2";
            break;
          }
          case 6: {
            tertiaryorbit = "3";
            break;
          }
          case 7: {
            tertiaryorbit = "" + (4 + getRoll(1));
            break;
          }
          case 8: {
            tertiaryorbit = "" + (5 + getRoll(1));
            break;
          }
          case 9: {
            tertiaryorbit = "" + (6 + getRoll(1));
            break;
          }
          case 10: {
            tertiaryorbit = "" + (7 + getRoll(1));
            break;
          }
          case 11: {
            tertiaryorbit = "" + (8 + getRoll(1));
            break;
          }
          case 12: {
            tertiaryorbit = "Far";
            break;
          }
        }
        //</editor-fold>
        //        JOptionPane.showMessageDialog(jButton3, tertiaryorbit);
      } else {
        //        tertiarytype = "no";
        //        tertiarysize = "no";
        //        tertiaryorbit = "no";
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Max Orbits">
      int j = getRoll(2);
//      if (j > 12) {
//        j = 12;
//      }
      systemfeaturemaxorbits = "" + (j + getSizeDMs(primarytype, primarysize));
      primaryorbits = "" + (j + getSizeDMs(primarytype, primarysize));
      Orbits[0] = "" + (j + getSizeDMs(primarytype, primarysize));
//      orbitsaround = 10;
      j = getRoll(2);
      secondaryorbits = "" + (j + getSizeDMs(secondarytype, secondarysize));
      Orbits[1] = "" + (j + getSizeDMs(secondarytype, secondarysize));
      j = getRoll(2);
      tertiaryorbits = "" + (j + getSizeDMs(tertiarytype, tertiarysize));
      Orbits[2] = "" + (j + getSizeDMs(tertiarytype, tertiarysize));
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Gas Giant Presence">
      if ("g".equals(Panel4SubSector.jcb4GGs.getSelectedItem().toString()
        .toLowerCase())) {
        gasgiantpresence = "yes";
      } else {
        gasgiantpresence = "no";
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Gas Giant Quantity">
      gasgiantquantity = Panel4SubSector.jcb4PAG.getSelectedItem().toString()
        .substring(2);
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Planetoid Presence">
      /*
       Planetoid Presence
       */
      if (!"0".equals(panels.Panel4SubSector.jcb4PAG.getSelectedItem()
        .toString().substring(1, 2))) {
        planetoidpresence = "yes";
      } else {
        planetoidpresence = "no";
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Planetoid Quantity">
      planetoidquantity = Panel4SubSector.jcb4PAG.getSelectedItem().toString()
        .substring(1, 2);
      //</editor-fold>
    } //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="else">
    else {
      //<editor-fold defaultstate="collapsed" desc="Basic Nature">
      /*
       Basic Nature
       */
      starorbit = getRoll(2);
      switch (starorbit) {
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7: {
          nature = "Solo";
          break;
        }
        case 8:
        case 9:
        case 10:
        case 11: {
          nature = "Binary";
          break;
        }
        case 12: {
          nature = "Trinary";
          break;
        }
      }
      /*

       CUT 3 LINES AND PASTE AFTER NEXT LINE TO COMMENT OUT
       systemfeaturenature = "Trinary";


       */
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Primary Type">
      /*
       Primary Type

       */
      starorbit = getRoll(2);
      /*
       if main world has atmos 4-9 or pop 8+
       DM+4
       */
      int at = dbviewer.globals.GlobalMethods.fromHex(mainworldatmo);
      ////System.out.println("mainworldatmo" + " = " + at);
      int po = dbviewer.globals.GlobalMethods.fromHex(mainworldpop);
      ////System.out.println("mainworldpop" + " = " + po);
      if ((at >= 4) | (at <= 9)) {
        starorbit += 4;
      }
      if (po >= 8) {
        starorbit += 4;
      }
      if (starorbit > 12) {
        starorbit = 12;
      }
      primarytyperoll = starorbit;
      switch (starorbit) {
        case 1: {
          primarytype = "B";
          break;
        }
        case 2: {
          primarytype = "A";
        }
        case 3:
        case 4:
        case 5:
        case 6:
        case 7: {
          primarytype = "M";
          break;
        }
        case 8:
          primarytype = "K";
        case 9:
          primarytype = "G";
        case 10:
        case 11:
        case 12: {
          primarytype = "F";
          break;
        }
      }

      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Primary Size">
      /*
       Primary Size
       */
      starorbit = getRoll(2);
      primarysizeroll = starorbit;
      switch (starorbit) {
        case 0: {
          primarysize = "Ia";
          break;
        }
        case 1: {
          primarysize = "Ib";
          break;
        }
        case 2: {
          primarysize = "II";
          break;
        }
        case 3: {
          primarysize = "III";
          break;
        }
        case 4: {
          primarysize = "IV";
          break;
        }
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10: {
          primarysize = "V";
          break;
        }
        case 11: {
          primarysize = "VI";
          break;
        }
        case 12: {
          primarysize = "D";
          break;
        }
        default:
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Primary Orbit">
      /*
       Primary Orbit
       */
      primaryorbit = "Centre";
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Secondary Type">
      /*
       Secondary Type
       */
      starorbit = getRoll(2) + primarytyperoll;
      if (starorbit > 12) {
        starorbit = 12;
      }
      switch (starorbit) {
        case 1: {
          secondarytype = "B";
          break;
        }
        case 2: {
          secondarytype = "A";
          break;
        }
        case 3:
        case 4: {
          secondarytype = "F";
          break;
        }
        case 5:
        case 6: {
          secondarytype = "G";
          break;
        }
        case 7:
        case 8: {
          secondarytype = "K";
          break;
        }
        case 9:
        case 10:
        case 11:
        case 12: {
          secondarytype = "M";
          break;
        }
      }

      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Secondary Size">
      /*
       Secondary Size
       */
      starorbit = getRoll(2) + primarysizeroll;
      if (starorbit > 12) {
        starorbit = 12;
      }
      switch (starorbit) {
        case 0: {
          secondarysize = "Ia";
          break;
        }
        case 1: {
          secondarysize = "Ib";
          break;
        }
        case 2: {
          secondarysize = "II";
          break;
        }
        case 3: {
          secondarysize = "III";
          break;
        }
        case 4: {
          secondarysize = "IV";
          break;
        }
        case 5:
        case 6: {
          secondarysize = "D";
          break;
        }
        case 7:
        case 8: {
          secondarysize = "V";
          break;
        }
        case 9: {
          secondarysize = "VI";
          break;
        }
        case 10:
        case 11:
        case 12: {
          secondarysize = "D";
          break;
        }
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Secondary Orbit">
      /*
       Secondary Orbit
       */
      starorbit = getRoll(2);
      if (starorbit > 12) {
        starorbit = 12;
      }
      switch (starorbit) {
        case 0:
        case 1:
        case 2:
        case 3: {
          secondaryorbit = "Close";
          break;
        }
        case 4: {
          secondaryorbit = "1";
          break;
        }
        case 5: {
          secondaryorbit = "2";
          break;
        }
        case 6: {
          secondaryorbit = "3";
          break;
        }
        case 7: {
          secondaryorbit = "" + (4 + getRoll(1));
          break;
        }
        case 8: {
          secondaryorbit = "" + (5 + getRoll(1));
          break;
        }
        case 9: {
          secondaryorbit = "" + (6 + getRoll(1));
          break;
        }
        case 10: {
          secondaryorbit = "" + (7 + getRoll(1));
          break;
        }
        case 11: {
          secondaryorbit = "" + (8 + getRoll(1));
          break;
        }
        case 12: {
          secondaryorbit = "Far";
          break;
        }

      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Tertiary Type">
      /*
       Tertiary Type
       */
      starorbit = getRoll(2);
      if (starorbit > 12) {
        starorbit = 12;
      }
      switch (starorbit) {
        case 1: {
          tertiarytype = "B";
          break;
        }
        case 2: {
          tertiarytype = "A";
          break;
        }
        case 3:
        case 4: {
          tertiarytype = "F";
          break;
        }
        case 5:
        case 6: {
          tertiarytype = "G";
          break;
        }
        case 7:
        case 8: {
          tertiarytype = "K";
          break;
        }
        case 9:
        case 10:
        case 11:
        case 12: {
          tertiarytype = "M";
          break;
        }

      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Tertiary Size">
      /*
       Tertiary Size
       */
      starorbit = getRoll(2) + primarysizeroll;
      if (starorbit > 12) {
        starorbit = 12;
      }
      switch (starorbit) {
        case 0: {
          tertiarysize = "Ia";
          break;
        }
        case 1: {
          tertiarysize = "Ib";
          break;
        }
        case 2: {
          tertiarysize = "II";
          break;
        }
        case 3: {
          tertiarysize = "III";
          break;
        }
        case 4: {
          tertiarysize = "IV";
          break;
        }
        case 5:
        case 6: {
          tertiarysize = "D";
          break;
        }
        case 7:
        case 8: {
          tertiarysize = "V";
          break;
        }
        case 9: {
          tertiarysize = "VI";
          break;
        }
        case 10:
        case 11:
        case 12: {
          tertiarysize = "D";
          break;
        }
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Tertiary Orbit">
      /*
       Tertiary Orbit
       */
      starorbit = getRoll(2) + primarysizeroll;
      starorbit += 4;
      if (starorbit > 12) {
        starorbit = 12;
      }
      switch (starorbit) {
        case 0:
        case 1:
        case 2:
        case 3: {
          tertiaryorbit = "Close";
          break;
        }
        case 4: {
          tertiaryorbit = "1";
          break;
        }
        case 5: {
          tertiaryorbit = "2";
          break;
        }
        case 6: {
          tertiaryorbit = "3";
          break;
        }
        case 7: {
          tertiaryorbit = "" + (4 + getRoll(1));
          break;
        }
        case 8: {
          tertiaryorbit = "" + (5 + getRoll(1));
          break;
        }
        case 9: {
          tertiaryorbit = "" + (6 + getRoll(1));
          break;
        }
        case 10: {
          tertiaryorbit = "" + (7 + getRoll(1));
          break;
        }
        case 11: {
          tertiaryorbit = "" + (8 + getRoll(1));
          break;
        }
        case 12: {
          tertiaryorbit = "Far";
          break;
        }

      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Max Orbits">
      /*
       Max Orbits
       */
      int j = getRoll(2);
      if (j > 12) {
        j = 12;
      }
      systemfeaturemaxorbits = "" + (j + getSizeDMs(primarytype, primarysize));
      primaryorbits = "" + (j + getSizeDMs(primarytype, primarysize));
      Orbits[0] = "" + (j + getSizeDMs(primarytype, primarysize));
      j = getRoll(2);
      secondaryorbits = "" + (j + getSizeDMs(secondarytype, secondarysize));
      Orbits[1] = "" + (j + getSizeDMs(secondarytype, secondarysize));
      j = getRoll(2);
      tertiaryorbits = "" + (j + getSizeDMs(tertiarytype, tertiarysize));
      Orbits[2] = "" + (j + getSizeDMs(tertiarytype, tertiarysize));
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Gas Giant Presence">
      /*
       Gas Giant Presence
       */
      j = getRoll(2);
      switch (j) {
        case 0:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6: {
          gasgiantpresence = "yes";
          break;
        }
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12: {
          gasgiantpresence = "no";
          break;
        }
      }    //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Gas Giant Quantity">
      /*
       Gas Giant Quantity
       */
      j = getRoll(2);
      switch (j) {
        case 1:
        case 2:
        case 3: {
          gasgiantquantity = "" + 1;
          break;
        }
        case 4:
        case 5: {
          gasgiantquantity = "" + 2;
          break;
        }
        case 6:
        case 7: {
          gasgiantquantity = "" + 3;
          break;
        }
        case 8:
        case 9:
        case 10: {
          gasgiantquantity = "" + 4;
          break;
        }
        case 11:
        case 12: {
          gasgiantquantity = "" + 5;
          break;
        }
      }

      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Planetoid Presence">
      /*
       Planetoid Presence
       */
      j = getRoll(2);
      switch (j) {
        case 2:
        case 3:
        case 4:
        case 5:
        case 6: {
          planetoidpresence = "yes";
          break;
        }
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12: {
          planetoidpresence = "no";
          break;
        }
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Planetoid Quantity">
      /*
       Planetoid Quantity
       */
      j = getRoll(2);
      switch (j) {
        case 0: {
          planetoidquantity = "" + 3;
          break;
        }
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6: {
          planetoidquantity = "" + 2;
          break;
        }
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12: {
          planetoidquantity = "" + 1;
          break;
        }
      }
      //</editor-fold>
    }
    //</editor-fold>
    //-------------------------
    //<editor-fold defaultstate="collapsed" desc="SystemFeatures">
    SystemFeature = new String[]{
      nature,
      primarytype,
      primarysize, primaryorbit,
      secondarytype,
      secondarysize, secondaryorbit,
      tertiarytype,
      tertiarysize, tertiaryorbit,
      systemfeaturemaxorbits,
      gasgiantpresence, gasgiantquantity,
      planetoidpresence,
      planetoidquantity,
      primaryorbits, secondaryorbits, tertiaryorbits,
      primaryorbits, secondaryorbits, tertiaryorbits
    };
    //</editor-fold>
    printSystemFeatures();
  }

  private String[] getSystemFeatures(int star) {
    switch (star) {
      case 0: {
        break;
      }
      case 1: {
        break;
      }
      case 2: {
        break;
      }
    }
    SystemFeature = new String[]{
      nature,
      primarytype,
      primarysize, primaryorbit,
      secondarytype,
      secondarysize, secondaryorbit,
      tertiarytype,
      tertiarysize, tertiaryorbit,
      systemfeaturemaxorbits,
      gasgiantpresence, gasgiantquantity,
      planetoidpresence,
      planetoidquantity,
      primaryorbits, secondaryorbits, tertiaryorbits,
      primaryorbits, secondaryorbits, tertiaryorbits
    };
    return SystemFeature;
  }

  private void printSystemFeatures() {
    jta.append("System Features".toUpperCase() + CRLF);
    jta.append(dbviewer.globals.GlobalMethods.comment("=", 20));
    for (int i = 0; i < SystemFeature.length; i++) {
      jta.append("\t" + systemfeaturevarnames[i].toUpperCase().substring(13)
        + " = " + getString(SystemFeature[i]) + CRLF);
    }
  }

  private void generateUWP() {
    //getSystemContents();
    int DM = 0;
    //-------------------------------
    int size = getRoll(2) - 2;
    //-------------------------------
    int atmos = getRoll(2) - 7 + size;
    if (size == 0) {
      atmos = 0;
    }
    //-------------------------------
    int hydro = getRoll(2) - 7 + size;
    if (size < 2) {
      hydro = 0;
    }
    if ((atmos < 2) | (atmos > 10)) {
      DM = -4;
    }
    hydro += DM;
    if (hydro > 10) {
      hydro = 10;
    }
    if (atmos < 0) {
      atmos = 0;
    }
    if (atmos >= 10) {
      atmos = 10;
    }
    //-------------------------------
    int pop = getRoll(2) - 2;
    int govt = getRoll(2) - 7 + pop;
    int law = getRoll(2) - 7 + govt;
    size = setMinimum(size, 0);
    atmos = setMinimum(atmos, 0);
    hydro = setMinimum(hydro, 0);
    hydro = setMaximum(hydro, 10);
    pop = setMinimum(pop, 0);
    govt = setMinimum(govt, 0);
    law = setMinimum(law, 0);
    iTL = setMinimum(iTL, 0);
    uwp.setText("" + starport
      + "" + dbviewer.globals.GlobalMethods.toHex(size)
      + "" + dbviewer.globals.GlobalMethods.toHex(atmos)
      + "" + dbviewer.globals.GlobalMethods.toHex(hydro)
      + "" + dbviewer.globals.GlobalMethods.toHex(pop)
      + "" + dbviewer.globals.GlobalMethods.toHex(govt)
      + "" + dbviewer.globals.GlobalMethods.toHex(law)
      + "-" + dbviewer.globals.GlobalMethods.toHex(iTL));
    printUWP();
  }

  private void getSP() {
    starorbit = getRoll(2);
    switch (starorbit) {
      case 2:
      case 3:
      case 4: {
        starport = "A";
        break;
      }
      case 5:
      case 6: {
        starport = "B";
        break;
      }
      case 7:
      case 8: {
        starport = "C";
        break;
      }
      case 9: {
        starport = "D";
        break;
      }
      case 10:
      case 11: {
        starport = "E";
        break;
      }
      case 12: {
        starport = "X";
        break;
      }
    }
  }

  private void setPlanetaryOrbitData() {
    setPlanetaryOrbitNum();
    setPlanetaryOrbitMKm();
    setPlanetaryOrbitAU();
    PlanetaryOrbit = new String[]{
      planetaryorbitnumtitle, planetaryorbitnummkmtitle,
      planetaryorbitnumautitle
    };
    planetaryorbitvarnames = new String[]{
      "planetaryorbitnum",
      "planetaryorbitnummkm",
      "planetaryorbitnumau"
    };
  }

  private void setPlanetaryOrbitNum() {
    for (starorbit = 0; starorbit < 16; starorbit++) {
      planetaryorbitnum[starorbit] = "" + starorbit;
    }
  }

  private void setPlanetaryOrbitMKm() {
    planetaryorbitnummkm = new String[]{
      "29.9", "59.8", "104.7", "149.6",
      "339.3", "418.9", "777.9", "1495.9",
      "2932", "5804", "11548", "23038",
      "46016", "91972", "183885", "367711"};
  }

  private void setPlanetaryOrbitAU() {
    planetaryorbitnumau = new String[]{
      "0.2", "0.4", "0.7", "1.0",
      "1.6", "2.8", "5.2", "10.0",
      "19.6", "38.8", "77.2", "154.0",
      "307.4", "614.8", "1229.2", "2458.0"};
  }

  /**
   <p>
   @param orbit of planet
   @return orbit num
   */
  public static String getPlanetaryOrbit(int orbit) {
    String string = planetaryorbitnum[orbit] + "\t"
      + planetaryorbitnummkm[orbit] + "\t"
      + planetaryorbitnumau[orbit];
    return string;
  }

  private void setSatelliteOrbitData() {
    setSatelliteOrbitNum();
    setSatelliteOrbitRing();
    setSatelliteOrbitClose();
    setSatelliteOrbitFar();
    setSatelliteOrbitExtreme();
    SatelliteOrbit = new String[]{
      "Satellite", satelliteorbitringtitle,
      satelliteorbitclosetitle, satelliteorbitfartitle,
      satelliteorbitextremetitle};
    satelliteorbitvarnames = new String[]{
      "satelliteorbitnum", "satelliteorbitring",
      "satelliteorbitclose", "satelliteorbitfar",
      "satelliteorbitextreme"};
  }

  private void setSatelliteOrbitNum() {
    satelliteorbitnum = new String[13];
    for (starorbit = 0; starorbit < satelliteorbitnum.length; starorbit++) {
      satelliteorbitnum[starorbit] = "" + starorbit;
//      jta.append("" + " = " + satelliteorbitnum[starorbit] + CRLF);
    }
  }

  private void setSatelliteOrbitRing() {
    satelliteorbitring = new String[]{
      "-", "1", "1", "1", "2", "2", "3", "-", "-", "-", "-", "-", "-"
    };
  }

  private void setSatelliteOrbitClose() {
    satelliteorbitclose = new String[]{
      "-", "-", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"
    };
  }

  private void setSatelliteOrbitFar() {
    satelliteorbitfar = new String[]{
      "-", "-", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65"
    };
  }

  private void setSatelliteOrbitExtreme() {
    satelliteorbitextreme = new String[]{
      "-", "-", "75", "100", "125", "150", "175", "200", "225", "250", "275",
      "300", "325"
    };
  }

  /**
   <p>
   @param orbit orbit of planet
   @return orbit num of satellite
   */
  public static String getSatelliteOrbit(int orbit) {
    String string
      = satelliteorbitnum[orbit] + "\t"
      + satelliteorbitring[orbit] + "\t"
      + satelliteorbitclose[orbit] + "\t"
      + satelliteorbitfar[orbit] + "\t"
      + satelliteorbitextreme[orbit];
    return string;
  }

  private void printUWP() {
    //  jta.append("UWP = " + uwp.getText() + CRLF);
    printWorldData();
  }

  private void printVars() {
    jta.setText("VARIABLES".toUpperCase() + CRLF);
//    //System.out.println("svarnames.length" + " = " +svarnames.length);
//    //System.out.println("svars.length" + " = " +svars.length);
    jta.append(dbviewer.globals.GlobalMethods.comment("=", 20));
    //    jta.setText("");
    for (int i = 0; i < svars.length; i++) {
      jta.append(svarnames[i] + "=" + svars[i] + CRLF);
    }

  }

  private void setVars() {
    //setSystemFeatures();

    svars = new String[]{
      starport, navalbase, scoutbase,
      gasgiant, nature, primarytype,
      primarysize, primaryorbit, primaryorbits,
      secondarytype, secondarysize, secondaryorbit, secondaryorbits,
      tertiarytype, tertiarysize, tertiaryorbit, tertiaryorbits,
      gasgiant, gasgiantpresence, gasgiantquantity,
      planetoids, planetoidpresence, planetoidquantity,
      primaryorbits, secondaryorbits, tertiaryorbits,
      mainworldsize, mainworldatmo, mainworldhydro,
      mainworldpop, mainworldgovt, mainworldlaw, mainworldtl,
      "" + iTLMods[0], "" + iTLMods[1], "" + iTLMods[2], "" + iTLMods[3], ""
      + iTLMods[4],
      "" + iTLMods[5], "" + iTLMods[6],
      primaryorbits, secondaryorbits, tertiaryorbits
    };
    setSystemContents();
    SystemContents = new String[]{
      starport, navalbase, scoutbase, gasgiant, planetoids
    };
    SystemFeature = new String[]{
      nature,
      primarytype,
      primarysize, primaryorbit,
      secondarytype,
      secondarysize, secondaryorbit,
      tertiarytype,
      tertiarysize, tertiaryorbit,
      systemfeaturemaxorbits,
      gasgiantpresence, gasgiantquantity,
      planetoidpresence,
      planetoidquantity,
      primaryorbits, secondaryorbits, tertiaryorbits
    };
//    setSystemFeatures();
  }

  private static void setSystemFeatures() {
    nature = "Trinary";
    primarytype = "F";
    primarysize = "V";
    primaryorbit = "Center";
    secondarytype = "M";
    secondarysize = "D";
    secondaryorbit = "Close";
    tertiarytype = "M";
    tertiarysize = "V";
    tertiaryorbit = "Far";
    systemfeaturemaxorbits = "4";
    gasgiantpresence = "yes";
    gasgiantquantity = "3";
    planetoidpresence = "no";
    planetoidquantity = "0";
    primaryorbits = "5";
    secondaryorbits = "0";
    tertiaryorbits = "3";
    Orbits[0] = primaryorbits;
    Orbits[1] = secondaryorbits;
    Orbits[2] = tertiaryorbits;
  }

  private void setSystemContents() {
    starport = "A";
    navalbase = "yes";
    scoutbase = "yes";
    gasgiant = "yes";
    planetoids = "no";
  }

  private static void setTechLevel() {
    iTL = dbviewer.globals.GlobalMethods.fromHex(uwp.getText().substring(8));
    iTLMods[1] = 6;
    iTLMods[3] = 0;
    MainworldContents = new String[]{
      "" + roll, mainworldsize, mainworldatmo, mainworldhydro, mainworldpop,
      mainworldgovt
    };
    for (starorbit = 0; starorbit < iTLMods.length; starorbit++) {
//      jta.append("" + iTLMods[starorbit] + CRLF);
    }
    printTechLevel();
  }

  private static String getZone(int i) {
    String s = null;
    for (int j = 0; j < StarGen.Orbit.length; j++) {
      s = StarGen.getZone(j);
      //System.out.print("Orbit " + j + " = ");
      switch (s) {
        case ".": {
          //System.out.println("Inside");
          s = "Inside";
          break;
        }
        case "_": {
          //System.out.println("Unavailable");
          s = "Unavailable";
          break;
        }
        case "I": {
          //System.out.println("Inner");
          s = "Inner";
          break;
        }
        case "H": {
          //System.out.println("Habitable");
          s = "Habitable";
          break;
        }
        case "O": {
          //System.out.println("Outer");
          s = "Outer";
          break;
        }
      }
      if (i == j) {
        return s;
      }
    }
    return null;
  }

  /**
   public static void saveLines() {
   */
  public static void saveLines() {
    jButton1.doClick();
  }

  private String getDataText(String string, String[] table) {
    String[] vars = null;
    //<editor-fold defaultstate="collapsed" desc="switch">
    switch (string) {
      case "Starport": {
        vars = StarportValues;
      }
      case "Size": {
        vars = SizeValues;
      }
      case "Atmosphere": {
        vars = AtmosphereValues;
      }
      case "Hydrosphere": {
        vars = HydrosphereValues;
      }
      case "Population": {
        vars = PopulationValues;
      }
      case "Government": {
        vars = GovernmentValues;
      }
      case "LawLevel": {
        vars = LawLevelValues;
      }
      case "TechLevel": {
        vars = TechLevelValues;
      }
      default: {
        vars = table;
      }
    }
    //</editor-fold>
//----------------------------------------------------
    ////System.out.println("string" + " = " +string);
    ////System.out.println("table" + " = " +table);
    int j = 0;
    for (starorbit = 0; starorbit < vars.length; starorbit++) {
      ////System.out.println("" + " = " +vars[i]);
      if (vars[starorbit].substring(0, 1).equals(string)) {
        j = starorbit;
        break;
      }
    }
//----------------------------------------------------

//----------------------------------------------------
    try {
      return ("" + vars[j]);
    } catch (Exception e) {
      return "OOPS";
    }
  }

  private void printWorldData() {
    String UWP = uwp.getText();
    Starport = UWP.substring(0, 1);
    Size = UWP.substring(1, 2);
    Atmosphere = UWP.substring(2, 3);
    Hydrosphere = UWP.substring(3, 4);
    Population = UWP.substring(4, 5);
    Government = UWP.substring(5, 6);
    LawLevel = UWP.substring(6, 7);
    TechLevel = UWP.substring(8, 9);

    worlddata = new String[]{
      Starport,
      Size, Atmosphere, Hydrosphere,
      Population, Government, LawLevel,
      TechLevel
    };

    worlddatatext = new String[]{
      getDataText(Starport, StarportValues),
      getDataText(Size, SizeValues),
      getDataText(Atmosphere, AtmosphereValues),
      getDataText(Hydrosphere, HydrosphereValues),
      getDataText(Population, PopulationValues),
      getDataText(Government, GovernmentValues),
      getDataText(LawLevel, LawLevelValues),
      getDataText(TechLevel, TechLevelValues)
    };

    jta.append("World Data".toUpperCase() + CRLF);
    jta.append(dbviewer.globals.GlobalMethods.comment("=", 20));
    for (int i = 0; i < UWP.length() - 1; i++) {
//      jta.append("\t" + worlddatanames[stars] + "\t" + worlddata[stars] + "\t" + worlddatatext[stars] + CRLF);
      jta.append("\t" + worlddatanames[i] + "\t" + worlddatatext[i] + CRLF);
    }
  }
  //------------------------------------------------
}
