/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package web.bits2page;

import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalMethods.getRoll;
import static dbviewer.globals.GlobalVariables.T5;
import static dbviewer.globals.GlobalVariables.TAB;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.console;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import panels.Panel4T5CounterMaker;
import panels.Panel4T5Locator;
//import open.GlobalMethods;
//import static open.GlobalMethods.getRoll;

/**
 *
 * @author Mark Ferguson
 */
public class Bits2Page extends javax.swing.JPanel {

  //<editor-fold defaultstate="collapsed" desc="variables">
  //<editor-fold defaultstate="collapsed" desc="String about">
  private static final String about = "ABOUT\n"
          + "\n" + "<br/>"
          + "Programmed by Mark Ferguson	(maggot.iiss@sky.com)\n" + "<br/>" + "\n" + "<br/>"
          + "\n" + "<br/>"
          + "The Traveller game in all forms is owned by Far Future Enterprises. \n" + "<br/>"
          + "Copyright 1977 - 2019 Far Future Enterprises. \n" + "<br/>"
          + "\n" + "<br/>"
          + "Traveller is a registered trademark of Far Future Enterprises. \n" + "<br/>"
          + "Far Future permits web sites and fanzines for this game, provided \n" + "<br/>"
          + "it contains this notice, that Far Future is notified, and subject \n" + "<br/>"
          + "to a withdrawal of permission on 90 days notice. \n" + "<br/>"
          + "\n" + "<br/>"
          + "Any use of Far Future Enterprises's copyrighted material or \n" + "<br/>"
          + "trademarks anywhere in this document and its files should not \n" + "<br/>"
          + "be viewed as a challenge to those copyrights or trademarks. \n" + "<br/>";

  //</editor-fold>
  String[] nobletitles = {"A Gentleman", "B Knight", "c Baronet", "C Baron",
    "D Marquis", "e Viscount", "E Count", "f duke", "F Duke",
    "G Archduke", "H Emperor"};
  String list = "";
  private static final String CRLF = "\n";
  private static String all = "";
  private static String drive = "C:";
  private static String path = "T5";
  private static String sector = "Vland";
  private static String subsector = "P Kakadan";
  private static String system = "2737 Kesali";
  private static String secdata = "";
  private static String uri = "";
  private static String[] files;
  private static JPanel jp;
  private static JFrame jf;
  private static BorderLayout bl;
  private static JComboBox<String> cb;
  private static String filename = "2737 Kesali";
  private static String text = "";
  private static int colcount = 0;
  private static File f, file;
  private String[] lines;
  private String line = "";
  private static String name = "";
  private String fname = "";
  private String start = "<!-- ";
  private String end = " -->";
  private static String startfolder;
  private String add = "";
  private String s = "";
  private File fil;
  private String[] strings = {".gif"};
  private String part;
  private String ext;
  private final static String FS = "/";
  private int pages = 0;
  static String hex;
  private static String[] kakadan = {"2531 Kiddinu", "2533 Aki", "2534 Zerapii", "2536 Linissa", "2539 Nunaat", "2540 Kalaalit", "2631 Kane", "2634 Wakarsat", "2636 Kakadan", "2637 Akon", "2640 Statia", "2732 Dnak'kritz", "2733 Jarmat", "2734 Rambant", "2737 Kesali", "2738 Tepmaa", "2739 Sg'aa", "2740 P'ginzh", "2831 Kiimzhal", "2832 Telkaa", "2836 Inushir", "2837 Piazza", "2839 Zombagu", "2931 Icuspin", "2932 Zanski", "2933 Kanat", "2934 Assazak", "2936 Elafdt", "2938 Punnari", "2939 Teralvar", "3031 New Salen", "3032 Matuyama", "3035 Zhanora", "3037 Raanbazziil", "3039 Gilnat Paz", "3131 Maamibrin", "3134 Toborit", "3135 Debekov", "3137 Alleman", "3138 Nasaa", "3140 Zana", "3231 Vanutappan", "3232 Tamayo", "3235 Debort", "3237 Zhannag", "3238 Lamiina", "3239 Lannazol"};
  private static String[] sallounn = {"1623 Fraynj"};
  private static String[] regina = {"1910 Regina", "2007 Roup", "2005 Feri", "1904 Boughene", "1705 Efate"};
  private static String[] jewell = {"1307 Lysen", "1106 Jewell"};
  private static String[] solomani = {"1827 Terra"};
  private static String[] district = {"1237 Collace"};
  private static String[] sword = {"1526 Biter"};
  private static String[] five = {"0534 Karin"};
  private static String[] core = {"2118 Capital"};
  private static String[][] campaigns = {kakadan, sallounn, regina, jewell, solomani, district, sword, five, core};
  private String[] folders = {
    "C:/T5/Vland/P Kakadan",
    "C:/T5/Gushemege/J Sallounn",
    "C:/T5/Spinward Marches/C Regina",
    "C:/T5/Spinward Marches/B Jewell",
    "C:/T5/Solomani Rim/K Sol",
    "C:/T5/Spinward Marches/N District 268",
    "C:/T5/Spinward Marches/J Sword Worlds",
    "C:/T5/Spinward Marches/M Five Sisters",
    "C:/T5/Core/G Core"
  };
  String out = "";
  private String TL = "A";
  private String UWP = "B2009AB-E";
  int pos = 0;
  int right = 0;
  int col = 0;
  String[] titles;

  //<editor-fold defaultstate="collapsed" desc="SUBSECTOR LIST">
  /**
   *
   */
  public static String[] subs = {
    //    "C:/T5/Alpha Crucis/A Ximenes",
    //    "C:/T5/Alpha Crucis/B McKenzie",
    //    "C:/T5/Alpha Crucis/C Dagir",
    //    "C:/T5/Alpha Crucis/D Alba",
    //    "C:/T5/Alpha Crucis/E Orichalc",
    //    "C:/T5/Alpha Crucis/F Auva",
    //    "C:/T5/Alpha Crucis/G Oriah",
    //    "C:/T5/Alpha Crucis/H Fervore",
    //    "C:/T5/Alpha Crucis/I Denebola",
    //    "C:/T5/Alpha Crucis/J Veracruz",
    //    "C:/T5/Alpha Crucis/K Vald",
    //    "C:/T5/Alpha Crucis/L Addison",
    //    "C:/T5/Alpha Crucis/M Ziusudra",
    //    "C:/T5/Alpha Crucis/N Regulus",
    //    "C:/T5/Alpha Crucis/O New Holland",
    //    "C:/T5/Alpha Crucis/P Galloway",
    //    "C:/T5/Antares/A Pelusium",
    //    "C:/T5/Antares/B Ninik",
    //    "C:/T5/Antares/C Dartho",
    //    "C:/T5/Antares/D Oulduktak",
    //    "C:/T5/Antares/E Shurlarlem",
    //    "C:/T5/Antares/F Sarar",
    //    "C:/T5/Antares/G Gimgir",
    //    "C:/T5/Antares/H Kiirkandin",
    //    "C:/T5/Antares/I Urunishu",
    //    "C:/T5/Antares/J Uradnim",
    //    "C:/T5/Antares/K Antares",
    //    "C:/T5/Antares/L Mukusi",
    //    "C:/T5/Antares/M Urgusap",
    //    "C:/T5/Antares/N Gaakish",
    //    "C:/T5/Antares/O Sakhag",
    //    "C:/T5/Antares/P Celebes",
    //    "C:/T5/Core/A Apge",
    //    "C:/T5/Core/B Perite",
    //    "C:/T5/Core/C Ameros",
    //    "C:/T5/Core/D Shinkan",
    //    "C:/T5/Core/E Sanches",
    //    "C:/T5/Core/F Mekee",
    //    "C:/T5/Core/G Core",
    //    "C:/T5/Core/H Kaskii",
    //    "C:/T5/Core/I Bunkeria",
    //    "C:/T5/Core/J Cemplas",
    //    "C:/T5/Core/K Chant",
    //    "C:/T5/Core/L Dingtra",
    //    "C:/T5/Core/M Cadion",
    //    "C:/T5/Core/N Ch'naar",
    //    "C:/T5/Core/O Dunea",
    //    "C:/T5/Core/P Saregon",
    //    "C:/T5/Corridor/A Khouth",
    //    "C:/T5/Corridor/B Khukish",
    //    "C:/T5/Corridor/C Lemish",
    //    "C:/T5/Corridor/D The Narrows",
    //    "C:/T5/Corridor/E Ian",
    //    "C:/T5/Corridor/F Strand",
    //    "C:/T5/Corridor/G Naadi",
    //    "C:/T5/Corridor/H Uantil",
    //    "C:/T5/Corridor/I Shush",
    //    "C:/T5/Corridor/J The Empty Void",
    //    "C:/T5/Corridor/K Atu'l",
    //    "C:/T5/Corridor/L Kivu",
    //    "C:/T5/Corridor/M Two Worlds",
    //    "C:/T5/Corridor/N Ashishinipar",
    //    "C:/T5/Corridor/O Sinta",
    //    "C:/T5/Corridor/P Sashrakusha",
    //    "C:/T5/Dagudashaag/A Mimu",
    //    "C:/T5/Dagudashaag/B Old Suns",
    //    "C:/T5/Dagudashaag/C Arnakhish",
    //    "C:/T5/Dagudashaag/D Iiradu",
    //    "C:/T5/Dagudashaag/E Shallows",
    //    "C:/T5/Dagudashaag/F Ushra",
    //    "C:/T5/Dagudashaag/G Khandi",
    //    "C:/T5/Dagudashaag/H Kuriishe",
    //    "C:/T5/Dagudashaag/I Zeda",
    //    "C:/T5/Dagudashaag/J Remnants",
    //    "C:/T5/Dagudashaag/K Pact",
    //    "C:/T5/Dagudashaag/L Gadde",
    //    "C:/T5/Dagudashaag/M Bolivar",
    //    "C:/T5/Dagudashaag/N Argi",
    //    "C:/T5/Dagudashaag/O Sapphyre",
    //    "C:/T5/Dagudashaag/P Laraa",
    //    "C:/T5/Daibei/A Edge",
    //    "C:/T5/Daibei/B Alun",
    //    "C:/T5/Daibei/C Standish",
    //    "C:/T5/Daibei/D Iingar",
    //    "C:/T5/Daibei/E Woomera",
    //    "C:/T5/Daibei/F Outback",
    //    "C:/T5/Daibei/G Amdani",
    //    "C:/T5/Daibei/H Conda",
    //    "C:/T5/Daibei/I Zhemi",
    //    "C:/T5/Daibei/J Mulaar",
    //    "C:/T5/Daibei/K Dudin",
    //    "C:/T5/Daibei/L Cruxway",
    //    "C:/T5/Daibei/M Gaalorn",
    //    "C:/T5/Daibei/N Hermes",
    //    "C:/T5/Daibei/O Narya",
    //    "C:/T5/Daibei/P Orvon",
    //    "C:/T5/Delphi/A Kirkankhim",
    //    "C:/T5/Delphi/B Tsent",
    //    "C:/T5/Delphi/C Dighirpi",
    //    "C:/T5/Delphi/D Forlorn",
    //    "C:/T5/Delphi/E Zukhumi",
    //    "C:/T5/Delphi/F Rifts Reach",
    //    "C:/T5/Delphi/G Rayoci'Ailr",
    //    "C:/T5/Delphi/H Tolanada",
    //    "C:/T5/Delphi/I Aklan",
    //    "C:/T5/Delphi/J Void",
    //    "C:/T5/Delphi/K Anaxias",
    //    "C:/T5/Delphi/L Eduum",
    //    "C:/T5/Delphi/M Eta-Gu",
    //    "C:/T5/Delphi/N Riramla",
    //    "C:/T5/Delphi/O Zuma",
    //    "C:/T5/Delphi/P Breda",
    //    "C:/T5/Deneb/A Pretoria",
    //    "C:/T5/Deneb/B Lamas",
    //    "C:/T5/Deneb/C Antra",
    //    "C:/T5/Deneb/D Million",
    //    "C:/T5/Deneb/E Sabine",
    //    "C:/T5/Deneb/F Inar",
    //    "C:/T5/Deneb/G Dunmag",
    //    "C:/T5/Deneb/H Atsah",
    //    "C:/T5/Deneb/I Star Lane",
    //    "C:/T5/Deneb/J Vincennes",
    //    "C:/T5/Deneb/K Usani",
    //    "C:/T5/Deneb/L Geniishir",
    //    "C:/T5/Deneb/M Gulf",
    //    "C:/T5/Deneb/N Zeng",
    //    "C:/T5/Deneb/O Kamlar",
    //    "C:/T5/Deneb/P Vast Heavens",
    //    "C:/T5/Diaspora/A Narquel",
    //    "C:/T5/Diaspora/B Libert",
    //    "C:/T5/Diaspora/C Sufren",
    //    "C:/T5/Diaspora/D Khavle",
    //    "C:/T5/Diaspora/E Shadigi",
    //    "C:/T5/Diaspora/F Kushga",
    //    "C:/T5/Diaspora/G Alurza",
    //    "C:/T5/Diaspora/H Pasdaruu",
    //    "C:/T5/Diaspora/I Ebasha",
    //    "C:/T5/Diaspora/J Iusea",
    //    "C:/T5/Diaspora/K The Blight",
    //    "C:/T5/Diaspora/L Promise",
    //    "C:/T5/Diaspora/M Hijiri",
    //    "C:/T5/Diaspora/N Shumisdi",
    //    "C:/T5/Diaspora/O Madoc",
    //    "C:/T5/Diaspora/P Khulam",
    //    "C:/T5/Empty Quarter/A Tsahrroek",
    //    "C:/T5/Empty Quarter/B Kourae",
    //    "C:/T5/Empty Quarter/C Flange",
    //    "C:/T5/Empty Quarter/D Tsosoe",
    //    "C:/T5/Empty Quarter/E Kakhasaek",
    //    "C:/T5/Empty Quarter/F Tokitre",
    //    "C:/T5/Empty Quarter/G Cotan",
    //    "C:/T5/Empty Quarter/H Nisaga",
    //    "C:/T5/Empty Quarter/I Lentuli",
    //    "C:/T5/Empty Quarter/J Yogesh",
    //    "C:/T5/Empty Quarter/K Hebrin",
    //    "C:/T5/Empty Quarter/L Turley",
    //    "C:/T5/Empty Quarter/M Nulinad",
    //    "C:/T5/Empty Quarter/N Gimushi",
    //    "C:/T5/Empty Quarter/O Udusis",
    //    "C:/T5/Empty Quarter/P Yashodhan",
    //    "C:/T5/Fornast/A Cirqa",
    //    "C:/T5/Fornast/B Spas",
    //    "C:/T5/Fornast/C Madu",
    //    "C:/T5/Fornast/D Toza",
    //    "C:/T5/Fornast/E AArna",
    //    "C:/T5/Fornast/F Akashganar",
    //    "C:/T5/Fornast/G Derri",
    //    "C:/T5/Fornast/H Sanny",
    //    "C:/T5/Fornast/I Imaka",
    //    "C:/T5/Fornast/J Irinkuka",
    //    "C:/T5/Fornast/K Dikhari",
    //    "C:/T5/Fornast/L Nareshakir",
    //    "C:/T5/Fornast/M Setten",
    //    "C:/T5/Fornast/N Tharrynra",
    //    "C:/T5/Fornast/O Shumduur",
    //    "C:/T5/Fornast/P Zukhin",
    //    "C:/T5/Glimmerdrift Reaches/A Darkling",
    //    "C:/T5/Glimmerdrift Reaches/B Thorstone",
    //    "C:/T5/Glimmerdrift Reaches/C Tri-Empire",
    //    "C:/T5/Glimmerdrift Reaches/D Marla",
    //    "C:/T5/Glimmerdrift Reaches/E Glowing",
    //    "C:/T5/Glimmerdrift Reaches/F Kraxin",
    //    "C:/T5/Glimmerdrift Reaches/G Williamsburg",
    //    "C:/T5/Glimmerdrift Reaches/H Tasman",
    //    "C:/T5/Glimmerdrift Reaches/I Even",
    //    "C:/T5/Glimmerdrift Reaches/J Poonch",
    //    "C:/T5/Glimmerdrift Reaches/K Sosie",
    //    "C:/T5/Glimmerdrift Reaches/L Ryazan",
    //    "C:/T5/Glimmerdrift Reaches/M Verge",
    //    "C:/T5/Glimmerdrift Reaches/N Zairae",
    //    "C:/T5/Glimmerdrift Reaches/O Sepik",
    //    "C:/T5/Glimmerdrift Reaches/P Daro",
    //    "C:/T5/Gushemege/A Riften",
    //    "C:/T5/Gushemege/B Khiira",
    //    "C:/T5/Gushemege/C Taapvaia",
    //    "C:/T5/Gushemege/D Tansa",
    //    "C:/T5/Gushemege/E Gandonen",
    //    "C:/T5/Gushemege/F Rure",
    //    "C:/T5/Gushemege/G Ankhsusgar",
    //    "C:/T5/Gushemege/H Isi Ahto",
    //    "C:/T5/Gushemege/I Balech",
    //    "C:/T5/Gushemege/J Sallounn",
    //    "C:/T5/Gushemege/K Dashinshaii",
    //    "C:/T5/Gushemege/L Shire",
    //    "C:/T5/Gushemege/M Vipach",
    //    "C:/T5/Gushemege/N Laeth",
    //    "C:/T5/Gushemege/O Truax",
    //    "C:/T5/Gushemege/P Lagan",
    //    "C:/T5/Gvurrdon/A Ongvos",
    //    "C:/T5/Gvurrdon/B Zoghz",
    //    "C:/T5/Gvurrdon/C Adhsakh",
    //    "C:/T5/Gvurrdon/D Fanganger",
    //    "C:/T5/Gvurrdon/E Uerra Rueshken",
    //    "C:/T5/Gvurrdon/F Dzen",
    //    "C:/T5/Gvurrdon/G Lla Iz Therrg",
    //    "C:/T5/Gvurrdon/H Thoengling",
    //    "C:/T5/Gvurrdon/I Kfan Uzangou",
    //    "C:/T5/Gvurrdon/J Ruhk Odzuetarug",
    //    "C:/T5/Gvurrdon/K Ksits Usathu Odzuetarug",
    //    "C:/T5/Gvurrdon/L Aelluekh",
    //    "C:/T5/Gvurrdon/M Lianic",
    //    "C:/T5/Gvurrdon/N Spurl",
    //    "C:/T5/Gvurrdon/O Uthe",
    //    "C:/T5/Gvurrdon/P Firgr",
    //    "C:/T5/Hinterworlds/A Adar",
    //    "C:/T5/Hinterworlds/B Tlianke",
    //    "C:/T5/Hinterworlds/C Anubis",
    //    "C:/T5/Hinterworlds/D Pendiash Ginshar",
    //    "C:/T5/Hinterworlds/E Cimeon",
    //    "C:/T5/Hinterworlds/F Darvis",
    //    "C:/T5/Hinterworlds/G Cromar",
    //    "C:/T5/Hinterworlds/H Menere's Reach",
    //    "C:/T5/Hinterworlds/I Nullia",
    //    "C:/T5/Hinterworlds/J Bruia",
    //    "C:/T5/Hinterworlds/K Silver Laurel",
    //    "C:/T5/Hinterworlds/L Sontra",
    //    "C:/T5/Hinterworlds/M Hashi",
    //    "C:/T5/Hinterworlds/N Kandra",
    //    "C:/T5/Hinterworlds/O Tempri",
    //    "C:/T5/Hinterworlds/P Aquila",
    //    "C:/T5/Ilelish/A Arlumer",
    //    "C:/T5/Ilelish/B Bakkula",
    //    "C:/T5/Ilelish/C Miitan",
    //    "C:/T5/Ilelish/D Ilelish",
    //    "C:/T5/Ilelish/E Steppe",
    //    "C:/T5/Ilelish/F Shillish",
    //    "C:/T5/Ilelish/G Akkula Worlds",
    //    "C:/T5/Ilelish/H Shudash",
    //    "C:/T5/Ilelish/I Verran",
    //    "C:/T5/Ilelish/J Dlan",
    //    "C:/T5/Ilelish/K Desta",
    //    "C:/T5/Ilelish/L Gadirur",
    //    "C:/T5/Ilelish/M Edge",
    //    "C:/T5/Ilelish/N Lyystra",
    //    "C:/T5/Ilelish/O Zagrab",
    //    "C:/T5/Ilelish/P Empty",
    //    "C:/T5/Ley Sector/A Ikhnaton",
    //    "C:/T5/Ley Sector/B Nightmare",
    //    "C:/T5/Ley Sector/C Noir Deep",
    //    "C:/T5/Ley Sector/D Zagrathian",
    //    "C:/T5/Ley Sector/E Spearhead",
    //    "C:/T5/Ley Sector/F Guadix Drift",
    //    "C:/T5/Ley Sector/G Titanstorm",
    //    "C:/T5/Ley Sector/H Osiris Deep",
    //    "C:/T5/Ley Sector/I Highlord",
    //    "C:/T5/Ley Sector/J Matarishan",
    //    "C:/T5/Ley Sector/K Frontier Worlds",
    //    "C:/T5/Ley Sector/L Sydymic",
    //    "C:/T5/Ley Sector/M Satyressia",
    //    "C:/T5/Ley Sector/N Outreaumer",
    //    "C:/T5/Ley Sector/O Diamond-Prince",
    //    "C:/T5/Ley Sector/P Outworld",
    //    "C:/T5/Lishun/A Vakkuun",
    //    "C:/T5/Lishun/B Adawi",
    //    "C:/T5/Lishun/C Sotri",
    //    "C:/T5/Lishun/D Criideu",
    //    "C:/T5/Lishun/E Pryden",
    //    "C:/T5/Lishun/F Masionia",
    //    "C:/T5/Lishun/G Gama",
    //    "C:/T5/Lishun/H Tephany",
    //    "C:/T5/Lishun/I Shuna",
    //    "C:/T5/Lishun/J Taccis",
    //    "C:/T5/Lishun/K Simen",
    //    "C:/T5/Lishun/L Ot Zell",
    //    "C:/T5/Lishun/M Shuun",
    //    "C:/T5/Lishun/N Welling",
    //    "C:/T5/Lishun/O Strashna",
    //    "C:/T5/Lishun/P Mirmida",
    //    "C:/T5/Magyar/A Clan",
    //    "C:/T5/Magyar/B Eery",
    //    "C:/T5/Magyar/C Clown",
    //    "C:/T5/Magyar/D Anise",
    //    "C:/T5/Magyar/E Nemo",
    //    "C:/T5/Magyar/F New Town",
    //    "C:/T5/Magyar/G Voyager",
    //    "C:/T5/Magyar/H Kline",
    //    "C:/T5/Magyar/I Iouo",
    //    "C:/T5/Magyar/J Valhalla",
    //    "C:/T5/Magyar/K Swan",
    //    "C:/T5/Magyar/L New Mars",
    //    "C:/T5/Magyar/M Last Chance",
    //    "C:/T5/Magyar/N Black Jack",
    //    "C:/T5/Magyar/O Olympus",
    //    "C:/T5/Magyar/P Cluster",
    //    "C:/T5/Massilia/A Kerr",
    //    "C:/T5/Massilia/B Arar",
    //    "C:/T5/Massilia/C Khisham",
    //    "C:/T5/Massilia/D Zalucha",
    //    "C:/T5/Massilia/E Keum",
    //    "C:/T5/Massilia/F Vaait",
    //    "C:/T5/Massilia/G Forquee",
    //    "C:/T5/Massilia/H Palasha",
    //    "C:/T5/Massilia/I Ten Suns",
    //    "C:/T5/Massilia/J Shiwonee",
    //    "C:/T5/Massilia/K Nes'Vra",
    //    "C:/T5/Massilia/L Tooka",
    //    "C:/T5/Massilia/M Annari",
    //    "C:/T5/Massilia/N Shokee",
    //    "C:/T5/Massilia/O Shimmer",
    //    "C:/T5/Massilia/P Oreo",
    //    "C:/T5/Old Expanses/A Dethenes",
    //    "C:/T5/Old Expanses/B Quinoid",
    //    "C:/T5/Old Expanses/C Ahrhi",
    //    "C:/T5/Old Expanses/D Rusco",
    //    "C:/T5/Old Expanses/E Srys",
    //    "C:/T5/Old Expanses/F Jayna",
    //    "C:/T5/Old Expanses/G Twenty-One Worlds",
    //    "C:/T5/Old Expanses/H Ile",
    //    "C:/T5/Old Expanses/I Thoezennt",
    //    "C:/T5/Old Expanses/J Shenk",
    //    "C:/T5/Old Expanses/K Karse",
    //    "C:/T5/Old Expanses/L Vendtup",
    //    "C:/T5/Old Expanses/M Nicosia",
    //    "C:/T5/Old Expanses/N Sarid",
    //    "C:/T5/Old Expanses/O So Skire",
    //    "C:/T5/Old Expanses/P Bascoj",
    //    "C:/T5/Provence/A Llaezgaen",
    //    "C:/T5/Provence/B Vorvoun",
    //    "C:/T5/Provence/C Grnouf",
    //    "C:/T5/Provence/D Tsaegag",
    //    "C:/T5/Provence/E Anghikh",
    //    "C:/T5/Provence/F Kaegrogz",
    //    "C:/T5/Provence/G Gveghz",
    //    "C:/T5/Provence/H Thon",
    //    "C:/T5/Provence/I Dzarrvaer",
    //    "C:/T5/Provence/J Aenkuk",
    //    "C:/T5/Provence/K Karrdzae",
    //    "C:/T5/Provence/L Kaerfoz",
    //    "C:/T5/Provence/N Voudzeur",
    //    "C:/T5/Provence/O Uekhourg",
    //    "C:/T5/Provence/P Daekvagul",
    //    "C:/T5/Reaver's Deep/A Farift",
    //    "C:/T5/Reaver's Deep/B Riftdeep",
    //    "C:/T5/Reaver's Deep/C Riftrim",
    //    "C:/T5/Reaver's Deep/D Gulf",
    //    "C:/T5/Reaver's Deep/E Hryaroaa",
    //    "C:/T5/Reaver's Deep/F Scotian Deep",
    //    "C:/T5/Reaver's Deep/G Caledon",
    //    "C:/T5/Reaver's Deep/H Nightrim",
    //    "C:/T5/Reaver's Deep/I Keiar",
    //    "C:/T5/Reaver's Deep/J Ea",
    //    "C:/T5/Reaver's Deep/K Drexilthar",
    //    "C:/T5/Reaver's Deep/L Urlaqqash",
    //    "C:/T5/Reaver's Deep/M Uhtaa",
    //    "C:/T5/Reaver's Deep/N Eakoi",
    //    "C:/T5/Reaver's Deep/O Drinsaar",
    //    "C:/T5/Reaver's Deep/P Fahlnar",
    //    "C:/T5/Reft Sector/A Vestus",
    //    "C:/T5/Reft Sector/B Macon",
    //    "C:/T5/Reft Sector/C Two Little",
    //    "C:/T5/Reft Sector/D Barker",
    //    "C:/T5/Reft Sector/E Usher",
    //    "C:/T5/Reft Sector/F Sagittarian",
    //    "C:/T5/Reft Sector/G Lost Way",
    //    "C:/T5/Reft Sector/H Gome",
    //    "C:/T5/Reft Sector/I Void 8",
    //    "C:/T5/Reft Sector/J New Islands",
    //    "C:/T5/Reft Sector/K Old Islands",
    //    "C:/T5/Reft Sector/L Limon",
    //    "C:/T5/Reft Sector/M Alone",
    //    "C:/T5/Reft Sector/N Evestin",
    //    "C:/T5/Reft Sector/O Arcrant",
    //    "C:/T5/Reft Sector/P Moibin",
    //    "C:/T5/Riftspan Reaches/A Aulryakh",
    //    "C:/T5/Riftspan Reaches/B Hwiwuiyo",
    //    "C:/T5/Riftspan Reaches/C Tyehlai",
    //    "C:/T5/Riftspan Reaches/D Ewasya'",
    //    "C:/T5/Riftspan Reaches/E Trawo",
    //    "C:/T5/Riftspan Reaches/F Aokiylair",
    //    "C:/T5/Riftspan Reaches/G Ryuhleiea",
    //    "C:/T5/Riftspan Reaches/H Iyhaseakh",
    //    "C:/T5/Riftspan Reaches/I Yuhiyah",
    //    "C:/T5/Riftspan Reaches/J Jikhyrleirla",
    //    "C:/T5/Riftspan Reaches/K Hryehkhtyel",
    //    "C:/T5/Riftspan Reaches/L Aohelroiao",
    //    "C:/T5/Riftspan Reaches/M Ftyoauial",
    //    "C:/T5/Riftspan Reaches/N Ioihlehwa",
    //    "C:/T5/Riftspan Reaches/O Tuistao",
    //    "C:/T5/Riftspan Reaches/P Wahtoikoeakh",
    //    "C:/T5/Solomani Rim/A Ultima",
    //    "C:/T5/Solomani Rim/B Suleiman",
    //    "C:/T5/Solomani Rim/C Concord",
    //    "C:/T5/Solomani Rim/D Harlequin",
    //    "C:/T5/Solomani Rim/E Alderamin",
    //    "C:/T5/Solomani Rim/F Esperance",
    //    "C:/T5/Solomani Rim/G Vega",
    //    "C:/T5/Solomani Rim/H Banasdan",
    //    "C:/T5/Solomani Rim/I Albadawi",
    //    "C:/T5/Solomani Rim/J Dingir",
    //    "C:/T5/Solomani Rim/K Sol",
    //    "C:/T5/Solomani Rim/L Arcturus",
    //    "C:/T5/Solomani Rim/M Jardin",
    //    "C:/T5/Solomani Rim/N Capella",
    //    "C:/T5/Solomani Rim/O Gemini",
    //    "C:/T5/Solomani Rim/P Kukulkan",
    "C:/T5/Spinward Marches/A Cronor",
    "C:/T5/Spinward Marches/B Jewell",
    "C:/T5/Spinward Marches/C Regina",
    "C:/T5/Spinward Marches/D Aramis",
    "C:/T5/Spinward Marches/E Querion",
    "C:/T5/Spinward Marches/F Vilis",
    "C:/T5/Spinward Marches/G Lanth",
    "C:/T5/Spinward Marches/H Rhylanor",
    "C:/T5/Spinward Marches/I Darrian",
    "C:/T5/Spinward Marches/J Sword Worlds",
    "C:/T5/Spinward Marches/K Lunion",
    "C:/T5/Spinward Marches/L Mora",
    "C:/T5/Spinward Marches/M Five Sisters",
    "C:/T5/Spinward Marches/N District 268",
    "C:/T5/Spinward Marches/O Glisten",
    "C:/T5/Spinward Marches/P Trin's Veil",
    //    "C:/T5/Trojan Reach/A Menorial",
    //    "C:/T5/Trojan Reach/B Egyrn",
    //    "C:/T5/Trojan Reach/C Pax Rulin",
    //    "C:/T5/Trojan Reach/D Gazulin",
    //    "C:/T5/Trojan Reach/E Yggdrasil",
    //    "C:/T5/Trojan Reach/F Dpres",
    //    "C:/T5/Trojan Reach/G Sindal",
    //    "C:/T5/Trojan Reach/H Tobia",
    //    "C:/T5/Trojan Reach/I Nora'a",
    //    "C:/T5/Trojan Reach/J Goertel",
    //    "C:/T5/Trojan Reach/K Tlaiowaha",
    //    "C:/T5/Trojan Reach/L The Borderland",
    //    "C:/T5/Trojan Reach/M Ranib",
    //    "C:/T5/Trojan Reach/N Silraaihe",
    //    "C:/T5/Trojan Reach/O Hkea'as",
    //    "C:/T5/Trojan Reach/P Binary",
    //    "C:/T5/Tuglikki/A Dokh",
    //    "C:/T5/Tuglikki/B Saerrgh",
    //    "C:/T5/Tuglikki/C Orrgueg",
    //    "C:/T5/Tuglikki/D Knoukhs",
    //    "C:/T5/Tuglikki/E Darrgouts",
    //    "C:/T5/Tuglikki/F Uerrul",
    //    "C:/T5/Tuglikki/G Tsaerlon",
    //    "C:/T5/Tuglikki/H Gaerith",
    //    "C:/T5/Tuglikki/I Kaeng",
    //    "C:/T5/Tuglikki/J Ludzghaeth",
    //    "C:/T5/Tuglikki/K Aenkazarr",
    //    "C:/T5/Tuglikki/L Onrakae",
    //    "C:/T5/Tuglikki/M Anfharsgzo",
    //    "C:/T5/Tuglikki/N Ogaeka",
    //    "C:/T5/Tuglikki/O Ourrvikh",
    //    "C:/T5/Tuglikki/P Aegaek",
    //    "C:/T5/Verge/A Piimigeka",
    //    "C:/T5/Verge/B Draco Abyss",
    //    "C:/T5/Verge/C Mimiuudlika",
    //    "C:/T5/Verge/D Nuzuu",
    //    "C:/T5/Verge/E Shukhuarmiushruu",
    //    "C:/T5/Verge/F Dark Chasm",
    //    "C:/T5/Verge/G Biika",
    //    "C:/T5/Verge/H Miruu",
    //    "C:/T5/Verge/I Arkhukamier",
    //    "C:/T5/Verge/J Khukaruu",
    //    "C:/T5/Verge/K Likagemika",
    //    "C:/T5/Verge/L Khulikhu",
    //    "C:/T5/Verge/M Khuug",
    //    "C:/T5/Verge/N Inugzuu",
    //    "C:/T5/Verge/O Imkhuruuka",
    //    "C:/T5/Verge/P Naakhulige",
    "C:/T5/Vland/A Voskhod",
    "C:/T5/Vland/B Vhodan",
    "C:/T5/Vland/C Anarsi",
    "C:/T5/Vland/D Theton",
    "C:/T5/Vland/E Lalaki Kharir",
    "C:/T5/Vland/F Kagamira",
    "C:/T5/Vland/G Vland",
    "C:/T5/Vland/H Shiigus",
    "C:/T5/Vland/I Dusa",
    "C:/T5/Vland/J Akumid",
    "C:/T5/Vland/K Kasear",
    "C:/T5/Vland/L Anakod",
    "C:/T5/Vland/M Parsi",
    "C:/T5/Vland/N Daangiilu",
    "C:/T5/Vland/O Nulisud",
    "C:/T5/Vland/P Kakadan", //    "C:/T5/Zarushagar/A Ibaru",
  //    "C:/T5/Zarushagar/B Triton",
  //    "C:/T5/Zarushagar/C Lagaar",
  //    "C:/T5/Zarushagar/D Lode",
  //    "C:/T5/Zarushagar/E Iimii",
  //    "C:/T5/Zarushagar/F Khipge",
  //    "C:/T5/Zarushagar/G Epshu",
  //    "C:/T5/Zarushagar/H Gaussi",
  //    "C:/T5/Zarushagar/I Mizar",
  //    "C:/T5/Zarushagar/J Liasdi",
  //    "C:/T5/Zarushagar/K Wolf",
  //    "C:/T5/Zarushagar/L Oasis",
  //    "C:/T5/Zarushagar/M Void",
  //    "C:/T5/Zarushagar/N Allegro",
  //    "C:/T5/Zarushagar/O Rhamsteppe",
  //    "C:/T5/Zarushagar/P Mongrabi"
  //        "C:/T5/Ziafrplians/A Diazhiensh",
  //        "C:/T5/Ziafrplians/B Abishiaz",
  //        "C:/T5/Ziafrplians/C Alta",
  //        "C:/T5/Ziafrplians/D Asepvedl",
  //        "C:/T5/Ziafrplians/E Zhdensh",
  //        "C:/T5/Ziafrplians/F Keditlye",
  //        "C:/T5/Ziafrplians/G Etszdili",
  //        "C:/T5/Ziafrplians/H Tekli",
  //        "C:/T5/Ziafrplians/I Anshniepr Lenzh",
  //        "C:/T5/Ziafrplians/J Dlazdiaz Shtiaklbo",
  //        "C:/T5/Ziafrplians/K Tliaqlvie",
  //        "C:/T5/Ziafrplians/L Ianshepl",
  //        "C:/T5/Ziafrplians/M Ashemiepr Lenzh",
  //        "C:/T5/Ziafrplians/N Dintzhdevr",
  //        "C:/T5/Ziafrplians/O Iavdeiev",
  //    "C:/T5/Ziafrplians/P Zdiadlevepra"
  };
//</editor-fold>
  //</editor-fold>

  /**
   *
   * @param args desc
   */
  public static void main(String[] args) {
    JPanel jp = new Bits2Page(args);
    JFrame jf = new JFrame();
    jf.setContentPane(jp);
    jf.setTitle("Bits2Page");
    jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    jf.setSize(1000, 400);
    jf.setVisible(true);
  }

  /**
   * Creates new form Bits2Page2
   *
   * @param args desc
   */
  public Bits2Page(String[] args) {
    initComponents();
    if (args.length > 0) {
      jTextField1.setText(args[0]);
    }
    hex = jTextField3.getText();
    jLabel1.setText("<html><body>&Delta;</body></html>");
    startfolder = jTextField1.getText();
    list = "";
    jButton1.doClick();
  }

  /**
   *
   * @param fpath filepath
   * @return desc desc
   */
  public String bodyFrom(String fpath) {
    String reply = "";
    File fp = new File(fpath);
    lines = GlobalMethods.getLinesFromFile(fp);
    int start = 0;
    int end = 0;
    for (int i = 0; i < lines.length; i++) {
      if (lines[i].contains("</body>")) {
        end = (i - 1);
        continue;
      }
      if (lines[i].contains("</html")) {
        continue;
      }
      if (lines[i].contains("<body>")) {
        start = i + 1;
      }
    }
    for (int q = start; q < end; q++) {
      reply += lines[q] + CRLF;
    }
    return reply;
  }

  /**
   *
   * @param path desc
   * @return desc
   */
  public String txtFrom(String path) {
    String[] lines = {""};
    String words = "";
    lines = GlobalMethods.getLinesFromFile(new File(path));
    for (String line1 : lines) {
      words += line1 + "<br/>" + CRLF;
    }
    return words;
  }

  private void way2() throws IOException {
    jtask.setText("");

    startfolder = jTextField1.getText().replace("\\", "/").replace("//", "/").trim();
    jTextField1.setText(startfolder);
    f = new File(startfolder);
    ext = ".html";
    all = startfolder + ext;
    files = f.list();
    savePage(all, startfolder, "Sub");
    if (files.length > 0) {
      for (String file1 : files) {
        fil = new File(startfolder + "/" + file1);
        if ((isHexDir(file1)) & (fil.isDirectory())) {
          f = new File(jTextField1.getText() + "/" + file1 + ".html");
          savePage(f.toString(), startfolder, "Sys");
          jtask.append(f.toString().replace("\\", "/") + CRLF);
        }
      }
      indexSubsector(sector, subsector);
      try {
        readSystem();
      } catch (IOException ex) {
        Logger.getLogger(Bits2Page.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    saveISF();
    listErrors();
    cleanT5Cs();
    listNobility();
  }

  ActionEvent evt = null;

  //<editor-fold defaultstate="collapsed" desc="String page = ">
  String page = "<!DOCTYPE html>\n"
          + "<!--\n"
          + "-->\n"
          + "<html>\n"
          + "  <head>\n"
          + "    <title>TITLE</title>\n"
          + "    <meta charset=\"UTF-8\">\n"
          + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
          + "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
          + "    <script src=\"https://www.w3schools.com/lib/w3.js\"></script>\n"
          + "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
          + "    <!-- traveller/TravellerScripts.js -->\n"
          + "<style>\n"
          + "body {\n"
          + "background-color: white;\n"
          + "color: black;\n"
          + "font-size: 8px;\n}\n"
          + "h1 {\n"
          + "  background-color: black;\n"
          + "  color: red;\n"
          + "  text-align: center;\n"
          + "  font-family: verdana;\n"
          + "  font-size: 48px;\n"
          + "}\n"
          + "h2 {\n"
          + "  background-color: black;\n"
          + "  color: white;\n"
          + "  text-align: center;\n"
          + "  font-family: verdana;\n"
          + "  font-size: 24px;\n"
          + "}\n"
          + "</style>\n"
          + "    <script src=\"TravellerScripts.js\"></script>\n"
          + "  </head>\n"
          + "  <body>\n"
          + "TRAVELLERMAP\n" + "<br/>"
          + "\n" + "<br/>"
          + "REPLACEME\n" + "<br/>"
          + "\n" + "<br/>"
          + "ABOUT\n" + "<br/>"
          + "\n";
//            + "  </body>\n"
//            + "</html>\n";
  //</editor-fold>

  private void savePage(String filename, String dir, String SS) throws IOException {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String st = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        st += "//////////////////////////////////////////////" + CRLF;
        st += "//////////////////////////////////////////////" + CRLF;
        st += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
        st += "filename" + " = " + filename + CRLF;
        st += "dir" + " = " + dir + CRLF;
        st += "SS" + " = " + SS + CRLF;
      }
    }
    //</editor-fold>

    jta1.setText(page.trim());
    String tit = "";
    filename = filename.replace("\\", "/");
    {
      tit = filename.substring(filename.lastIndexOf(FS) + 1, filename.lastIndexOf('.'));
    }
    if (fil == null) {
      String t = jTextField1.getText().substring(jTextField1.getText().lastIndexOf('/') + 1);
      tit = t;
    }

    jta1.setText(jta1.getText().replace("FILENAME", filename));
    jta1.setText(jta1.getText().replace("TITLE", tit));
    lines = jtask.getText().split(CRLF);
//    jta1.setText(jta1.getText().replace("COVER", createCover(tit, SS)));
    jta1.setText(jta1.getText().replace("TRAVELLERMAP", insertTravellerMaps(filename)));
    String txt = null;
    if ("Sys".equals(SS)) {
      jta1.setText(jta1.getText().replace("REPLACEME", getDirInfo(filename) + "<br/><br/>"));
    } else if ("Sub".equals(SS)) {
      jta1.setText(jta1.getText().replace("REPLACEME", showSubPics(dir) + "<br/><hr/><br/>"));
      jta1.setText(jta1.getText().replace("font-size: 8px;", "font-size: 12px;"));
      txt = jta1.getText() + "<br/><hr/><br/>" + GlobalMethods.loadTextFile(dir + FS + "ISF.txt").replace(CRLF, "<br/>\n") + "<br/>";
      txt = txt.replace("ABOUT", bodyFrom(dir + FS + "_ISF-Navy.html")
              + "<br/><hr/><br/>" + bodyFrom(dir + FS + "_ISF-Marine.html") + "<br/>");
      jta1.setText(txt);
    }
    //jta1.setText(jta1.getText().replace("ABOUT", about + "  </body>\n" + "</html>\n"));

    txt = jta1.getText() + "<br/>" + CRLF;
    String path = jTextField1.getText() + FS + "Nobility.txt";
    txt = txt + "<hr/>" + txtFrom(path) + "<br/>" + CRLF + "<br/>" + CRLF;
    path = jTextField1.getText() + FS + "NobleWorlds.txt";
    txt = txt + "<hr/>" + txtFrom(path).replace(CRLF + CRLF + CRLF, CRLF + CRLF).replace(CRLF + CRLF + CRLF, CRLF + CRLF).replace(CRLF + CRLF, CRLF + "<hr/>");
    String[] linest = GlobalMethods.getLinesFromFile(new File("C://T5/ADVERT.txt"));
    for (String linest1 : linest) {
      txt += linest1 + "<br/>" + CRLF;
    }
    String xtra = ""
            + "<br/>\n"
            + "<br/>\n"
            + "FREE BLANK CAMPAIGN FORMS AVAILABLE<br/>\n"
            + "https://drive.google.com/open?id=1lcP1Ou4VaOXZA0BB6bYP_uMkOJ5kF-BI";
    txt += xtra + "<br/>\n";
    jta1.setText(txt);

    //System.out.println(filename);
    String in = jta1.getText().trim();
    PrintWriter pw = new PrintWriter(new FileWriter(filename));
    pw.write("<!--" + filename + "-->\n");
    pw.println(in);
    pw.close();
    pages += 1;
  }

  /**
   *
   * @param filename the value of filename
   */
  String getDirInfo(String filename) throws FileNotFoundException, IOException {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "web.Bits2Page.Bits2Page.getDirInfo()" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
      }
    }
    //</editor-fold>
    String ret = filename.substring(0, filename.length() - 5);
    String add = ret.substring(ret.lastIndexOf('/'));
    String all = ret + add + "/";
    File fi = new File(all);
    String outer = all + "</br>" + CRLF;
    String ends = "";
    if (fi.exists()) {
      lines = fi.list();
      String part = null;
      for (String line1 : lines) {
        if (line1.contains(".")) {
          part = line1.substring(line1.lastIndexOf('.') + 1);
          if (!ends.contains(part)) {
            ends += part + CRLF;
          }
        }
      }

      String[] liness = ends.split(CRLF);
      for (String lines1 : liness) {
        for (String line1 : lines) {
          if (line1.endsWith(lines1)) {
            if (line1.contains(add.substring(1, 5))) {
              if (line1.endsWith("Maps.gif")) {
                s = "file:///" + all + line1;
                outer += "<a href=\"" + s + "\">" + line1.substring(0, line1.length() - 4) + "</a><br/>" + CRLF;
                outer += "<img src=\"" + "" + s + "\" width='600' height='600' alt='" + s + "'\"/><br/>" + CRLF;
                s = s.replace(".gif", ".txt");
                File fil = new File(s.substring(8));
                if (fil.exists()) {
                  BufferedReader br = new BufferedReader(new FileReader(s.substring(8)));
                  String lc;
                  while ((lc = br.readLine()) != null) {
                    outer += lc + "<br/>" + CRLF;
                  }
                }
              } else if (line1.endsWith(".gif")) {
                s = "file:///" + all + line1;
                outer += "<a href=\"" + s + "\">" + line1.substring(0, line1.length() - 4) + "</a><br/>" + CRLF;
                outer += "<img src=\""
                        + "" + s + "\" width='200' height='100' alt='" + s + "'/><br/>" + CRLF;
                s = s.replace(".gif", ".txt");
                File fil = new File(s.substring(8));
                //                //System.out.println("" + " = " + fil);
                if (fil.exists()) {
                  BufferedReader br = new BufferedReader(new FileReader(s.substring(8)));
                  String lc;
                  while ((lc = br.readLine()) != null) {
                    outer += lc + "<br/>" + CRLF;
                  }
                }
              } else if (line1.endsWith(".txt")) {
                outer += line1 + "<br/>" + CRLF;
              } else if (line1.endsWith(".html")) {
                outer += line1 + "<br/>" + CRLF;
//              } else if (lines[j].endsWith(".t5c")) {
//                out += lines[j] + "<br/>" + CRLF;
//              } else if (lines[j].endsWith(".java")) {
//                out += lines[j] + "<br/>" + CRLF;
              }
            }
          }
        }
      }
    }
    return outer;
  }

  private String showSubPics(String direc) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String st = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        st += "//////////////////////////////////////////////" + CRLF;
        st += "//////////////////////////////////////////////" + CRLF;
        st += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
        st += "filename" + " = " + filename + CRLF;
        st += "direc" + " = " + direc + CRLF;
        //System.out.print(st);
      }
    }
    //</editor-fold>
    String ret = "";
//    String[] dirs = GlobalMethods.getLinesFromFile(direc);
    String[] dirs = new File(direc).list();

    String[] pics = {
      "-Maps.gif",//
      "-SDBs.gif",
      "-Squadrons.gif",
      "-Troops.gif",
      "-Defences.gif",
      "-Population.gif",
      "-Belts.gif",
      "-Gas Giants.gif",
      //" World.gif",
      ".gif",
      "-Worlds.gif"
    };
    String[] pathnames = new String[pics.length];
    String start0 = "<div class=\"w3-center\">\n";
    String end = "</div>\n";
    String startRow = "<div class=\"w3-row\">\n";
    String startCol = "<div class=\"w3-col s4 w3-center\">\n";
    for (int j = 0; j < dirs.length; j++) {
      dirs[j] = dirs[j];
      if (isHexDir(dirs[j])) {
        String directs = direc + FS + dirs[j] + FS + dirs[j];
        for (int i = 0; i < pics.length; i++) {
          switch (i % pics.length) {
            case 0: {
              // center pic
              ret += start0 + "<br/>\n";
              ret += "<a href=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\">" + dirs[j].substring(0, 4) + pics[i] + "</a><br/>\n\n";
              ret += "<img src=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\" width='600' height='600' alt='eh?'/><br/>\n\n";
              ret += end;
              break;
            }
            //------------------------------------------------------------------
            case 1: {
              ret += startRow;
              ret += startCol;
              ret += "<a href=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\">" + dirs[j].substring(0, 4) + pics[i] + "</a>\n";
              ret += "<img src=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\" width='200' height='100' alt='eh?'/>\n";
              ret += end;
              break;
            }
            case 2: {
              ret += startCol;
              ret += "<a href=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\">" + dirs[j].substring(0, 4) + pics[i] + "</a>\n";
              ret += "<img src=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\" width='200' height='100' alt='eh?'/>\n";
              ret += end;
              break;
            }
            case 3: {
              ret += startCol;
              ret += "<a href=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\">" + dirs[j].substring(0, 4) + pics[i] + "</a>\n";
              ret += "<img src=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\" width='200' height='100' alt='eh?'/>\n";
              ret += end;
              ret += end;
              break;
            }
            //------------------------------------------------------------------
            case 4: {
              ret += startRow;
              ret += startCol;
              ret += "<a href=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\">" + dirs[j].substring(0, 4) + pics[i] + "</a>\n";
              ret += "<img src=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\" width='200' height='100' alt='eh?'/>\n";
              ret += end;
              break;
            }
            case 5: {
              ret += startCol;
              ret += "<a href=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\">" + dirs[j].substring(0, 4) + pics[i] + "</a>\n";
              ret += "<img src=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\" width='200' height='100' alt='eh?'/>\n";
              ret += end;
              break;
            }
            case 6: {
              ret += startCol;
              ret += "<a href=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\">" + dirs[j].substring(0, 4) + pics[i] + "</a><br/>\n";
              ret += "<img src=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\" width='200' height='100' alt='eh?'/><br/>\n";
              ret += end;
              ret += end;
              break;
            }
            //------------------------------------------------------------------
            case 7: {
              ret += startRow;
              ret += startCol;
              ret += "<a href=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\">" + dirs[j].substring(0, 4) + pics[i] + "</a><br/>\n";
              ret += "<img src=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\" width='200' height='100' alt='eh?'/><br/>\n";
              ret += end;
              break;
            }
            case 8: {
              ret += startCol;
              String stringp = "";
              File fpath = new File("");
              Boolean ok = false;
              while (!ok) {

                stringp = directs + FS + dirs[j] + pics[i];
                fpath = new File(stringp);
                if (fpath.exists()) {
                  ret += "<a href=\"file:///" + stringp + "\">" + dirs[j] + pics[i] + "</a><br/>\n";
                  ret += "<img src=\"file:///" + stringp + "\" width='200' height='100' alt='eh?'/><br/>\n";
                  ok = true;
                  break;
                }

                stringp = directs + FS + dirs[j].substring(0, 4) + pics[i];
                fpath = new File(stringp);
                if (fpath.exists()) {
                  ret += "<a href=\"file:///" + stringp + "\">" + dirs[j].substring(0, 4) + pics[i] + "</a><br/>\n";
                  ret += "<img src=\"file:///" + stringp + "\" width='200' height='100' alt='eh?'/><br/>\n";
                  ok = true;
                  break;
                }

                stringp = directs + FS + dirs[j] + pics[i].replace(" World", "");
                fpath = new File(stringp);
                if (fpath.exists()) {
                  ret += "<a href=\"file:///" + stringp + "\">" + dirs[j] + pics[i].replace(" World", "") + "</a><br/>\n";
                  ret += "<img src=\"file:///" + stringp + "\" width='200' height='100' alt='eh?'/><br/>\n";
                  ok = true;
                  break;
                }

                ok = true;
              }
              ret += end;
              break;
            }
            case 9: {
              ret += startCol;
              ret += "<a href=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\">" + dirs[j].substring(0, 4) + pics[i] + "</a><br/>\n";
              ret += "<img src=\"file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "\" width='200' height='100' alt='eh?'/><br/>\n";
              ret += end;
              ret += end;
              break;
            }
            //------------------------------------------------------------------
          }
//          if (i == 0 || i % pics.length == 0) {
//            ret += "<a href='file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "'>" + dirs[j].substring(0, 4) + pics[i] + "</a><br/>";
//            ret += "<img src='file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "' width='600' height='600' alt='eh?'/><br/>";
//          }
//          if (i == 8 || i % pics.length == 8) {
//            ret += "<a href='file:///" + directs + FS + dirs[j] + " " + pics[i] + "'>" + dirs[j] + " " + pics[i] + "</a><br/>";
//            ret += "<img src='file:///" + directs + FS + dirs[j] + " " + pics[i] + "' width='200' height='100' alt='eh?'/><br/>";
//          }
//          if ((i != 8) & (i != 0)) {
//            ret += "<a href='file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "'>" + dirs[j].substring(0, 4) + pics[i] + "</a><br/>";
//            ret += "<img src='file:///" + directs + FS + dirs[j].substring(0, 4) + pics[i] + "' width='200' height='100' alt='eh?'/><br/>";
//          }
        }
        ret += "\n\n<hr/>\n\n";
      }

    }
    return ret;
  }

  private void indexSubsector(String Sec, String Sub) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "web.Bits2Page.Bits2Page.listSubsector()" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
        //s += "" + " = " + "" + CRLF;
        //s += "" + " = " + "" + CRLF;
        //System.out.println(s);
      }
    }
    //</editor-fold>
    Path pathPath = Paths.get(drive, path, Sec, Sub);
    File filepath = pathPath.toFile();
    try {
      String[] sdirs = filepath.list();
      File f = new File("");
      for (String sdir : sdirs) {
        f = new File(pathPath + FS + sdir);
        //<editor-fold defaultstate="collapsed" desc="if (f.isDirectory())">
        if (f.isDirectory()) {
          ////System.out.println("" + " = " + f.toString());
          filepath = pathPath.toFile();
          File f2 = new File(pathPath + FS + sdir + FS + sdir);
          ////System.out.println("f2.toString()" + " = " + f2.toString());
          if (f2.isDirectory()) {
            try {
              String[] sdirs2 = f2.list();
              for (String sdirs21 : sdirs2) {
                ////System.out.println("sdirs2[" + j + "]" + " = " + sdirs2[j]);
                filepath = new File(pathPath.toFile() + FS + sdirs21);
                colcount += 1;
                ////System.out.println("  filepath" + " = " + filepath);
              }
            } catch (Exception e) {
              //System.out.println("e" + " = " + e);
            } finally {
            }
          }
        }
        //</editor-fold>
      }
    } catch (Exception e) {
      //System.out.println("Bits2Page 289 e" + " = " + e);
    } finally {
    }
  }

  private void readSystem() throws FileNotFoundException, IOException {
    //load .sec file and locate system
    String drive = "C:";
    String T5 = "T5";
    String secfile = drive + FS + T5 + FS + "_SEC" + FS + sector + ".sec";
    secdata = "";
    //System.out.println("secfile" + " = " + secfile);
    BufferedReader br = new BufferedReader(new FileReader(secfile));
    String line = "";
    String lines = "";
    String titled = "";
    titles = null;
    int linenum = 0;
    int world1 = 0;
    while ((line = br.readLine()) != null) {
      lines += line + CRLF;
      secdata += line + CRLF;
      linenum += 1;
      if (line.startsWith("Hex")) {
//        //System.out.println("linenum" + " = " + linenum);
        jtask.setText(line + CRLF);
        titled = line;
      }
      if (line.startsWith("----")) {
        world1 = linenum + 1;
        parts = line.split(" ");
        jtask.append(line + CRLF);
        titles = new String[parts.length];
      }
      if (line.startsWith(hex)) {
        jtask.append(line + CRLF);
        int start = 0;
        int end = 0;
        for (int i = 0; i < parts.length; i++) {
          //System.out.println("i" + " = " + i);
          if (i < parts.length - 1) {
            end += parts[i].length() + 1;
          } else {
            end = line.length();
          }
          titles[i] = titled.substring(start, end);
//          //System.out.println("start" + " = " + start);
//          //System.out.println("end" + " = " + end);
//          //System.out.println("parts[" + i + "]" + " = " + parts[i]);
//          //System.out.println("nobletitles[" + i + "]" + " = " + nobletitles[i]);
//          //System.out.println("");
          jtask.append(titled.substring(start, end).trim() + " = ");
          jtask.append(line.substring(start, end).trim() + CRLF);
          start = end;
        }
//        Panel4T5Locator.saveJtas(sector, subsector, system);
      }
    }
    br.close();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    javax.swing.JButton jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jTextField6 = new javax.swing.JTextField();
    jTextField1 = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtask = new javax.swing.JTextArea();
    jScrollPane2 = new javax.swing.JScrollPane();
    jta1 = new javax.swing.JTextArea();
    jScrollPane3 = new javax.swing.JScrollPane();
    jList1 = new javax.swing.JList<>();
    jLabel1 = new javax.swing.JLabel();
    jTextField2 = new javax.swing.JTextField();
    jTextField3 = new javax.swing.JTextField();
    jTextField4 = new javax.swing.JTextField();
    jTextField5 = new javax.swing.JTextField();
    jButton5 = new javax.swing.JButton();
    jButton6 = new javax.swing.JButton();
    jButton7 = new javax.swing.JButton();
    jButton8 = new javax.swing.JButton();
    jButton9 = new javax.swing.JButton();
    jButton10 = new javax.swing.JButton();
    jComboBox1 = new javax.swing.JComboBox<>();
    jCheckBox1 = new javax.swing.JCheckBox();
    jTextField7 = new javax.swing.JTextField();
    jButton11 = new javax.swing.JButton();
    jTextField8 = new javax.swing.JTextField();

    jButton2.setText("Loop");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jButton3.setText("Auto");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jButton4.setText("Read");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    jTextField6.setText("jTextField6");

    setPreferredSize(new java.awt.Dimension(800, 303));

    jTextField1.setText("C:/T5/Vland/P Kakadan");
    jTextField1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField1ActionPerformed(evt);
      }
    });

    jButton1.setText("Go");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jtask.setColumns(20);
    jtask.setRows(5);
    jScrollPane1.setViewportView(jtask);

    jta1.setColumns(20);
    jta1.setRows(5);
    jta1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jta1MouseClicked(evt);
      }
    });
    jScrollPane2.setViewportView(jta1);

    jList1.setModel(new javax.swing.AbstractListModel<String>() {
      String[] strings = { "Test", "Cover", "Intro", "Economics", "Nobility", "Targets", "PocketEmpire", "Family", "USqP", "Worlds", "ISF", "///////////", "//jta4All", "//jta4Bases", "//jta4Dest", "//jta4HTML", "//jta4Info", "//jta4Line", "//jta4Near", "//jta4Orb", "//jta4Sec", "//jta4Str", "//jta4Sub", "//jta4Sys", "jta4UWP" };
      public int getSize() { return strings.length; }
      public String getElementAt(int i) { return strings[i]; }
    });
    jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jList1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jList1MouseClicked(evt);
      }
    });
    jScrollPane3.setViewportView(jList1);

    jLabel1.setText("jLabel1");

    jTextField2.setText("Vland");
    jTextField2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField2ActionPerformed(evt);
      }
    });

    jTextField3.setText("2737");
    jTextField3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField3ActionPerformed(evt);
      }
    });

    jTextField4.setText("Kesali");
    jTextField4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField4ActionPerformed(evt);
      }
    });

    jTextField5.setText("P Kakadan");
    jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextField5MouseClicked(evt);
      }
    });
    jTextField5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField5ActionPerformed(evt);
      }
    });

    jButton5.setText("ALL!?");
    jButton5.setToolTipText("-=-WARNING-=-\nThis takes OVER AN HOUR!");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton5ActionPerformed(evt);
      }
    });

    jButton6.setText("listERRs");
    jButton6.setToolTipText("T5 FOLDER ERRS.TXT");
    jButton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton6ActionPerformed(evt);
      }
    });

    jButton7.setText("SEC");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton7ActionPerformed(evt);
      }
    });

    jButton8.setText("Clean?");
    jButton8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton8ActionPerformed(evt);
      }
    });

    jButton9.setText("Nobility");
    jButton9.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton9ActionPerformed(evt);
      }
    });

    jButton10.setText("INDEX");
    jButton10.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton10ActionPerformed(evt);
      }
    });

    jComboBox1.setMaximumRowCount(20);
    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".bat", ".css", ".csv", ".db", ".dtd", ".form", ".gif", ".html", ".java", ".jar", ".js", ".mmd", ".odf", ".odt", ".pdf", ".png", ".properties", ".txt", ".t5", ".t5c", ".UPP", ".USqP", ".UTP", ".UVP", ".UWP", ".xml", ".xsl", ".zip", ".7z" }));
    jComboBox1.setEnabled(false);
    jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jComboBox1MouseClicked(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        jComboBox1MouseExited(evt);
      }
      public void mousePressed(java.awt.event.MouseEvent evt) {
        jComboBox1MousePressed(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        jComboBox1MouseReleased(evt);
      }
    });
    jComboBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jComboBox1ActionPerformed(evt);
      }
    });

    jCheckBox1.setText("File?");
    jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBox1ActionPerformed(evt);
      }
    });

    jTextField7.setText("C:\\OpenEmpires\\src\\web\\bits2page");
    jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextField7MouseClicked(evt);
      }
    });
    jTextField7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField7ActionPerformed(evt);
      }
    });

    jButton11.setText("...");
    jButton11.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton11ActionPerformed(evt);
      }
    });

    jTextField8.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTextField8MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2))
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextField3))
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jButton1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel1))
          .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jButton9)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton11))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jCheckBox1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton1)
          .addComponent(jLabel1)
          .addComponent(jButton6)
          .addComponent(jButton7)
          .addComponent(jButton8)
          .addComponent(jButton9)
          .addComponent(jButton5)
          .addComponent(jButton11)
          .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton10)
          .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jCheckBox1)
          .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(7, 7, 7)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
          .addComponent(jScrollPane2)
          .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try {
//      way1();//show all in one page.  Copy into div on page
      way2();//show each folders worth and save as .html in startfolder
    } catch (IOException ex) {
      Logger.getLogger(Bits2Page.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    startfolder = jTextField1.getText().trim().replace("\\", "/");
    try {
      way2();
    } catch (Exception e) {
      //System.out.println("e" + " = " + e);
    }
  }//GEN-LAST:event_jTextField1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//    try {
//      loopit();
//
//    } catch (IOException ex) {
//      Logger.getLogger(Bits2Page.class
//        .getName()).log(Level.SEVERE, null, ex);
//    }
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//    automate();
  }//GEN-LAST:event_jButton3ActionPerformed

  private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextField4ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//    try {
//      readSystem();
//    } catch (IOException ex) {
//      Logger.getLogger(Bits2Page.class.getName()).log(Level.SEVERE, null, ex);
//    }
  }//GEN-LAST:event_jButton4ActionPerformed

  private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextField3ActionPerformed

  private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextField2ActionPerformed

  private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
    jTextField5.setText(findSub(jTextField3.getText()));
    jTextField1.setText("C:/T5/" + jTextField2.getText() + "/" + jTextField5.getText());
  }//GEN-LAST:event_jTextField5ActionPerformed

  private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
    jTextField5.setText(findSub(jTextField3.getText()));
    jTextField1.setText("C:/T5/" + jTextField2.getText() + "/" + jTextField5.getText());
  }//GEN-LAST:event_jTextField5MouseClicked

  private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    for (String sub : subs) {
      if ((sub.contains("Spinward Marches") | (sub.contains("Vland")))) {
        {
          jTextField1.setText(sub);
          System.out.println(jTextField1.getText() + CRLF);
          jButton1.doClick();
        }
        jta1.setText(out + CRLF);
      }
    }
  }//GEN-LAST:event_jButton5ActionPerformed

  private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    listErrors();
  }//GEN-LAST:event_jButton6ActionPerformed

  private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    String t = jTextField1.getText().substring(0, jTextField1.getText().lastIndexOf("/"));
    System.out.println("t = " + t);
    File f = new File(t);
    String[] l = f.list();
    File f2 = new File(t);
    for (int i = 0; i < l.length; i++) {
      System.out.println("" + (i) + " = " + l[i] + CRLF);
      System.out.println("" + " " + f.toString() + CRLF);
      f2 = new File(t + FS + l[i]);
      String[] l2 = {""};
      if (f2.isDirectory() & l[i].substring(1, 2).equals(" ")) {
        l2 = GlobalMethods.getLinesFromFile(f2);
        jTextField1.setText(f2.toString());
        jButton1.doClick();
      }
    }
  }//GEN-LAST:event_jButton7ActionPerformed

  private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    cleanT5Cs();
  }//GEN-LAST:event_jButton8ActionPerformed

  private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
    listNobility();
    //listNobleWorlds(jTextField1.getText());
  }//GEN-LAST:event_jButton9ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
      if (evt.getClickCount() > 1) {
        String str = jList1.getSelectedValue();
        if (str.startsWith("//")) {
          return;
        }
        if (jList1.getSelectedIndex() == 0) {
          String sec = "C://T5/" + Panel4T5Locator.jcb4Sec.getSelectedItem().toString() + FS;
          String sub = Panel4T5Locator.jcb4Sub.getSelectedItem().toString().trim() + FS;
          String sys = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + FS;
          Panel4T5Locator.saveJtas(sec, sub, sys);
          for (int i = 1; i < jList1.getModel().getSize(); i++) {
            str = jList1.getModel().getElementAt(i);
            createSection(str, jTextField1.getText());
          }
        } else {
          str = jList1.getSelectedValue();
          createSection(str, jTextField1.getText());
        }
      }
    }//GEN-LAST:event_jList1MouseClicked

  private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
    show("Index");
  }//GEN-LAST:event_jButton10ActionPerformed

  private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
    isFile(jCheckBox1, jComboBox1);
    selectType();
  }//GEN-LAST:event_jCheckBox1ActionPerformed

  private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
    selectType();
  }//GEN-LAST:event_jComboBox1MouseClicked

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    selectType();
  }//GEN-LAST:event_jComboBox1ActionPerformed

  private void jComboBox1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MousePressed
    selectType();
  }//GEN-LAST:event_jComboBox1MousePressed

  private void jComboBox1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseReleased
    selectType();
  }//GEN-LAST:event_jComboBox1MouseReleased

  private void jComboBox1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseExited

  }//GEN-LAST:event_jComboBox1MouseExited

  private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
    jButton10.doClick();
  }//GEN-LAST:event_jTextField7ActionPerformed

  private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

  }//GEN-LAST:event_jButton11ActionPerformed

  private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
    jTextField7.setSelectionStart(0);
    jTextField7.setSelectionEnd(jTextField7.getText().length());
  }//GEN-LAST:event_jTextField7MouseClicked

  private void jta1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jta1MouseClicked
    if (evt.getClickCount() > 2) {
      textClick(evt);
    }
  }//GEN-LAST:event_jta1MouseClicked

  private void jTextField8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField8MouseClicked
    jTextField8.setSelectionStart(0);
    jTextField8.setSelectionEnd(jTextField8.getText().length());
  }//GEN-LAST:event_jTextField8MouseClicked

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private static javax.swing.JButton jButton1;
  private javax.swing.JButton jButton10;
  private javax.swing.JButton jButton11;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JButton jButton5;
  private javax.swing.JButton jButton6;
  private javax.swing.JButton jButton7;
  private javax.swing.JButton jButton8;
  private javax.swing.JButton jButton9;
  private javax.swing.JCheckBox jCheckBox1;
  private javax.swing.JComboBox<String> jComboBox1;
  private javax.swing.JLabel jLabel1;
  private static javax.swing.JList<String> jList1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private static javax.swing.JTextField jTextField1;
  private static javax.swing.JTextField jTextField2;
  private static javax.swing.JTextField jTextField3;
  private static javax.swing.JTextField jTextField4;
  private javax.swing.JTextField jTextField5;
  private javax.swing.JTextField jTextField6;
  private javax.swing.JTextField jTextField7;
  private javax.swing.JTextField jTextField8;
  private static javax.swing.JTextArea jta1;
  private static javax.swing.JTextArea jtask;
  // End of variables declaration//GEN-END:variables

  private boolean isHexDir(String ffname) {
    boolean ok;
    if ((" ".equals(ffname.substring(4, 5))) & (!ffname.contains("."))) {
      ok = true;
    } else {
      ok = false;
    }
    return ok;
  }

  private static String gifs2Body(String finame) {
    String mid = "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
            + "    <link rel=\"stylesheet\" href=\"/w3.css\">\n"
            + "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
            + "    <script src=\"jquery-3.2.1.min.js\"></script>\n"
            + "    <script src=\"https://www.w3schools.com/lib/w3.js\"></script>\n"
            + "";
    String start = "<!DOCTYPE html>\n"
            + "<!--\n"
            + "To change this license header, choose License Headers in Project Properties.\n"
            + "To change this template file, choose Tools | Templates\n"
            + "and open the template in the editor.\n"
            + "-->\n"
            + "<html>\n"
            + "  <head>\n"
            + "    <title>" + "Bits2Page</title>\n"
            + "    <meta charset=\"UTF-8\">\n"
            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
            + mid
            + "  </head>\n"
            + "  <body>\n"
            + "TRAVELLERMAP\n"
            + "";
    String end = "</div>\n</body>\n</html>\n";
    FileWriter fw = null;
    f = new File(finame);
    files = f.list();
    jtask.setText(start);
    try {
      for (String file : files) {
        if (file.endsWith(".gif")) {
          jtask.append("<div>\n<a href=\"file:///" + all + FS + file + "\">" + file.substring(0, file.lastIndexOf('.')) + "</a><br>\n");
          jtask.append("<img src=\"file:///" + all + FS + FS + file + "\">" + "<br>\n</div>\n");
        }
      }
    } catch (Exception e) {
      //System.out.println("e" + " = " + e);
    } finally {
      jtask.append(end);
      text = jtask.getText().trim();
      filename = all + FS + system.substring(0, 4) + "-Counters.html";
      //System.out.println("filename" + " = " + filename);
      saveFile(filename, text);
    }
    return text;
  }

  private static void saveFile(String filename, String text) {
    File filenam = new File(filename);
    if (filenam.exists()) {
      try {
        FileWriter fw = new FileWriter(filename);
        fw.write("<!--" + filename + "-->\n");
        fw.write(text);
        fw.close();

      } catch (IOException ex) {
        Logger.getLogger(Bits2Page.class
                .getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  private String findSub(String text) {
    //System.out.println("text" + " = " + text);
    int x = Integer.parseInt(text.substring(0, 2));
    int y = Integer.parseInt(text.substring(2, 4));
    int xx = 0;
    int yy = 0;
    if (x > 0 & x < 9) {
      xx = 0;
    } else if (x > 8 & x < 17) {
      xx = 1;
    } else if (x > 16 & x < 25) {
      xx = 2;
    } else if (x > 24 & x < 33) {
      xx = 3;
    }
    if (y > 0 & y < 11) {
      yy = 0;
    } else if (y > 10 & y < 21) {
      yy = 1;
    } else if (y > 20 & y < 31) {
      yy = 2;
    } else if (y > 30 & y < 41) {
      yy = 3;
    }

    char let = 'A';
    let += ((4 * xx) + yy);

    String start = "# Subsector "
            + let + ": ";
    String reply = "";
    lines = secdata.split(CRLF);

    String sub = null;
    for (String line1 : lines) {
      if (line1.startsWith(start)) {
        reply = line1;
        sub = reply.substring(start.length() - 3).replace(":", "");
        //System.out.println("lines[" + i + "]" + " = " + sub);
        break;
      }
    }
    jTextField5.setText("" + sub);
    return sub;
  }

  private String insertTravellerMaps(String fname) {
    fname = fname.replace(".html", "");
    String string = fname.trim().substring(fname.lastIndexOf(FS) + 1, fname.length());
    //System.out.println("string = " + string);
    String from = fname + FS + string.substring(0, 4) + ".html";
    //System.out.println("from = " + from);
    String[] lines = GlobalMethods.getLinesFromFile(new File(from));
    int start = 0;
    int end = 0;
    String lined = "";
    for (int i = 0; i < lines.length; i++) {
      if (lines[i].contains("<body>")) {
        start = i + 1;
        //System.out.println("start = " + start);
        break;
      }
    }
    for (int i = 0; i < lines.length; i++) {
      if (lines[i].contains("</body>")) {
        end = i - 1;
        //System.out.println("end = " + end);
        break;
      }
    }
    String out = "";
    for (int i = start; i < end; i++) {
      out += lines[i] + "\n";
    }
    //System.out.println("out = " + out);
//    return out.trim().replace("scale=80","scale=51").replace("scale=120","scale=51");
    out = out.trim().replace("scale=80", "scale=60").replace("scale=120", "scale=60").replace("900", "1000");
    return out;
  }

  private void saveISF() {
    if (jTextField1.getText().length() > 6) {
      String jtf = jTextField1.getText();
      String start = jTextField1.getText().substring(0, 6);
      String sec = jtf.substring(6, jtf.lastIndexOf("/"));
      String sub = jtf.substring(jtf.lastIndexOf("/") + 1);
      String ret = "" + sec + "/" + sub + CRLF;
      File dir = new File(jTextField1.getText());
      String[] lines = dir.list();
      File f = new File(jtf);
      File fi = new File(jtf);
      File tech;
      String[] searches = {"SDB Squadrons = ", "Starship Squadrons = ", "Troop CF = ", "Defence CF = "};
      String textr = "";
      String hex = "";
      String CF = "";
      for (String line1 : lines) {
        f = new File(jtf + FS + line1);
        if ((f.isDirectory()) & (line1.substring(4, 5).equals(" "))) {
          String pa = f.toString();
          fi = new File(pa + FS + line1 + FS + "jta4Str.txt");
          if (fi.exists()) {
            String[] lin = GlobalMethods.getLinesFromFile(fi);
            String c = "";
            Boolean isf = false;
            String extra = "";
            for (String searche : searches) {
              isf = false;
              for (String lin1 : lin) {
                c = searche;
                if ((lin1.contains(c)) & (!lin1.endsWith("X"))) {
                  extra += "\t" + lin1 + CRLF;
                  isf = true;
                  if (c.startsWith(searches[2])) {
                    CF = lin1.substring(lin1.indexOf("=") + 2);
                    break;
                  } else {
                    CF = "?";
                    break;
                  }
                }
              }
            }
            if (isf) {
              String UWP = "";
              fi = new File(pa + FS + line1 + FS + "jta4Sys.txt");
              lin = GlobalMethods.getLinesFromFile(fi);
              int qhi = 0;
              String QHI;
              qhi = 0;
              int j = 0;
              for (j = 0; j < lin.length; j++) {
                if (lin[j].contains("UWP = ")) {
                  UWP = lin[j].substring(6);
                  QHI = UWP.substring(4, 5);
                  qhi = GlobalMethods.fromHex(QHI);
                  if (qhi > 8) {
                    ret += "---HI POP TARGET---" + CRLF;
                  }
                  break;
                }
              }
              ret += line1 + " - " + UWP + CRLF + extra;
              if (extra.contains("Troop CF")) {
                ret += addTroops(new File(pa + FS + line1.substring(0, 4) + ".utp"), UWP.substring(8), CF, extra) + CRLF + CRLF;
              } else {
                ret += CRLF;
              }
            }
          }
        }
      }
      if (ret.contains(searches[1])) {
        String[] parts = ret.split(CRLF);
        int countr = 0;
        String sys = "2737 Kesali";
        for (int i = 0; i < parts.length; i++) {
          if ((parts[i].contains(searches[1])) & (!parts[i].endsWith("X"))) {
            int num = Integer.parseInt(parts[i].substring(parts[i].length() - 1));
            for (int a = 0; a < num; a++) {
              for (int j = i; j >= 0; j--) {
                if ((parts[j].substring(4, 5).contains(" ")) & (!parts[j].contains("SDB"))) {
                  hex = parts[j].substring(0, 4);
                  UWP = parts[j].substring(parts[j].length() - 9);
                  TL = parts[j].substring(parts[j].length() - 1);
                  sys = parts[j].substring(0, parts[j].length() - 11).trim();
                  break;
                }
              }
              countr += 1;
              MouseEvent em = null;
              String namew = Panel4T5Locator.getWord(em, Panel4T5Locator.jcb4Lang.getSelectedItem().toString());
              String prec = Panel4T5CounterMaker.getPrec();
              String plan = Panel4T5CounterMaker.getPlan();
              String tact = Panel4T5CounterMaker.getTact();
              textr += "<hr/>" + hex + "-" + UWP + CRLF + "Commodore " + namew + "\n\tPrec " + prec + "\n\tPlan  " + plan + "\n\tTactics " + tact + CRLF;
              String ron = jtf + FS + sys + FS + hex + ".usqp";
              String[] linedd;
              try {
                linedd = GlobalMethods.getLinesFromFile(new File(ron));
                textr += "\t" + linedd[a] + CRLF;
              } catch (Exception e) {
                textr += getRon(this) + CRLF;
              }
            }
          }
        }
      }
      if (textr != "") {
        ret = ret + textr;
      }
      jtask.setText(ret);
      String file = "ISF";
      String ext = ".txt";
      String p = dir.toString();
      GlobalMethods.saveTextFile(p, file, ext, ret);
      addCounters("Navy", p);
      addCounters("Marine", p);
    }
  }

  private String addTroops(File fi, String tl, String cf, String extra) {
    String ret = "";
    if (fi.exists()) {
      try {
        ret = "" + GlobalMethods.loadTextFile(fi.toString()) + CRLF;
        if ("".equals(ret)) {
          ret = "?" + guessCF(tl, cf, extra) + "?" + CRLF;
        }
      } catch (Exception e) {
        ret = "??" + guessCF(tl, cf, extra) + "??" + CRLF;
      }
    } else {
      //ret = "--" + guessCF(uwp.substring(uwp.length() - 8), cf) + "-OOPS-" + CRLF;

      ret = "???" + guessCF(tl, cf, extra) + "???" + CRLF;

    }
    return "  Troop Forces".toUpperCase() + CRLF + ret;
  }

  private String guessCF(String tl, String cf, String extra) {
    /*
    SIZE
    ====================
    SIZE        CF
    Company     1   O1	2Lt
    Battalion   2   O2
    Regiment    5   O3
    Brigade     10	O4
    Division    20	O5
    Corps       50	O5
    Army        100	06
    Army Group  500	07	General


    What ranks lead each of the above structures?
    ie, what does a General have overall command of?
     */
    String ret = "0001-SQAT-C(R)-TL";
    String num = "0001";
    String siz = "0";
    String q = "0";
    String a = "0";
    String t = "0";
    String r = cf;

    String[] ll = extra.split(CRLF);
    for (String ll1 : ll) {
      if (ll1.contains("Troop CF = ")) {
        cf = ll1.substring(11).trim();
        r = cf;
      }
    }

    if ("1".equals(cf)) {
      siz = "0";
      q = "0";
      a = "0";
      t = "0";
    }
    if ("2".equals(cf)) {
      siz = "1";
      q = "0";
      a = "0";
      t = "0";
    }
    if ("5".equals(cf)) {
      siz = "2";
      q = "0";
      a = "0";
      t = "0";
    }
    if ("10".equals(cf)) {
      siz = "3";
      q = "0";
      a = "0";
      t = "0";
    }
    if ("20".equals(cf)) {
      siz = "4";
      q = "0";
      a = "0";
      t = "0";
    }
    if ("50".equals(cf)) {
      siz = "5";
      q = "0";
      a = "0";
      t = "0";
    }
    if ("100".equals(cf)) {
      siz = "5";
      q = "1";
      a = "1";
      t = "0";
    }
    if ("500".equals(cf)) {
      siz = "7";
      q = "0";
      a = "0";
      t = "0";
    }
    ret = "" + num + "-" + siz + q + a + t + "-" + cf + "(" + r + ")-" + tl;
    return ret;
  }

  private String getRon(Bits2Page aLot) {
    String ret = "C001-JS-DAB-T(R)-TL";
    // find hex, go backwards in file to file line starting with with hex & uwp
    //tl from uwp

    String Ty = "C";
    String N = "001";
    String J = "X";
    String S = "U";
    String D = "X";
    String A = "X";
    String B = "X";
    String T = "X";
    String R = "X";
    switch (aLot.TL) {
      case "9":
      case "A":
      case "B":
      case "C": {
        J = "1";
        break;
      }
      case "D": {
        J = "2";
        break;
      }
      case "E": {
        J = "3";
        break;
      }
      case "F": {
        J = "4";
        break;
      }
    }
    // D = P-2+M
    int p = GlobalMethods.fromHex(this.UWP.substring(4, 5));
    int m = 0;
    int lt = 0;
    int re = 0;
    int i = 0;
    int c = 0;
    switch (GlobalMethods.fromHex(this.TL)) {
      case 7:
      case 8:
      case 9: {
        lt = -2;
        break;
      }
      case 10:
      case 11: {
        lt = -1;
        break;
      }
      case 12:
      case 13: {
        lt = 0;
        break;
      }
      case 14: {
        lt = 1;
        break;
      }
      case 15: {
        lt = 2;
        break;
      }
    }
    re = getUM(0, this);
    i = getUM(1, this);
    c = getUM(2, this);
    m = lt + re + i + c;
    int d = p - 2 + m;
    D = "" + d;

    // A = D/2
    int a = d / 2;
    A = "" + a;

    // B = D/3
    int b = d / 3;
    B = "" + b;

    // T = D
    int t = d;
    T = "" + t;

    // R = T
    int r = d;
    R = "" + r;

    ret = "" + Ty + N + "-" + J + S + "-" + D + A + B + "-" + T + "(" + R + ")-" + TL;
    return "???" + ret + "???";
  }

  private int getUM(int i, Bits2Page aThis) {
    switch (i) {
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
    int it = getRoll(2);
    //
    it = 10;  /////////////////////comment out to run without Cultural mods
    //
    switch (it) {
      case 0:
      case 1:
      case 2: {
        it = -3;
        break;
      }
      case 3:
      case 4:
      case 5: {
        it = -2;
        break;
      }
      case 6:
      case 7:
      case 8: {
        it = -1;
        break;
      }
      case 9:
      case 10:
      case 11: {
        it = 0;
        break;
      }
      case 12:
      case 13:
      case 14: {
        it = 1;
        break;
      }
      case 15: {
        it = 2;
        break;
      }
    }
    return it;
  }

  private void listErrors() { // to watch and minimize
    // ERRS SAVED TO SEC/SUB/ERRS.TXT
    jta1.setText("");
    String[] ends = {
      ".usqp", ".utp"
    };
    jtask.setText("");
    jta1.setText("");
    File f = new File(jTextField1.getText());
    String[] texts = f.list();
    list = "";
    File direc = null;
    File direc2;
    File ff;
    File fi;
    for (String tt1 : texts) {
      direc = new File(jTextField1.getText() + FS + tt1);
      if (direc.isDirectory()) {
        if (tt1.substring(4, 5).equals(" ")) {
          hex = tt1.substring(0, 4);
          list += tt1 + CRLF;
          // if(folder should have files) - if it is in ISF.txt?
          ff = new File(jTextField1.getText() + FS + "ISF.txt");
          String[] lines = GlobalMethods.getLinesFromFile(ff);
          if (Arrays.toString(lines).contains(hex)) {
            for (int i = 0; i < lines.length; i++) {
              if (lines[i].contains(hex)) {
                for (int j = i; j < i + 3; j++) {
                  if ((lines[j].contains("Starship Squadrons = ") & (!lines[j].endsWith("X")))) {
                    fi = new File(direc + FS + hex + ".usqp");
                    if (!fi.exists()) {
                      list += "\tNO " + hex + ends[0] + CRLF;
                    }
                  }
                }
                try {
                  for (int j = i; j < i + 4; j++) {
                    if ((lines[j].startsWith("\tTroop CF = ") & (!lines[j].endsWith("X")))) {
                      fi = new File(direc + FS + hex + ".utp");
                      if (!fi.exists()) {
                        list += "\tNO " + hex + ends[1] + CRLF;
//                        System.out.println(CRLF + "\t" + lines[j]);
//                        System.out.println(hex + ends[1]);
//                        System.out.println(ff.toString());
//                        System.out.println(Arrays.toString(lines) + CRLF);
                      }
                    }
                  }
                } catch (Exception e) {
                  System.out.println("e" + " = " + e);
                }
              }
            }
          }

        }
      }
    }
    Boolean found0 = false;
    Boolean found1 = false;
    String[] searches = {"Maps.gif", "UWP.gif"};
    for (String text1 : texts) {
      if (text1.substring(4, 5).equals(" ")) {
        direc2 = new File(jTextField1.getText() + FS + text1 + FS + text1);
        if (direc2.isDirectory()) {
          System.out.println(direc2);
          list += direc2.toString() + CRLF;
          String[] contents = direc2.list();
          found0 = false;
          found1 = false;
          for (String content : contents) {
            if (content.contains(searches[0])) {
              found0 = true;
            }
            if (content.contains(searches[1])) {
              found1 = true;
            }
          }
          if (found0 == true) {
          } else {
            System.out.println("\tNO " + searches[0]);
            list += "\tNO " + searches[0] + CRLF;
          }
          if (found1 == true) {
          } else {
            System.out.println("\tNO " + searches[1]);
            list += "\tNO " + searches[1] + CRLF;
          }
        }
      }
    }
    jta1.append(list);
    String file = "ERRS";
    String ext = ".txt";
    if (!list.isEmpty()) {
      GlobalMethods.saveTextFile(jTextField1.getText(), file, ext, list);
    }
  }

  private void addCounters(String type, String dir) {
    String find = "";
    String search = "";
    switch (type) {
      case "Navy": {
        find = "*-squadron-*.gif";
        search = "-squadron-";
        break;
      }
      case "Marine": {
        find = "*-troop-*.gif";
        search = "-troop-";
        break;
      }
    }
    File sub = new File(jTextField1.getText());
    String[] con = sub.list();
    File t = null;
    String[] tmp = null;
    String files = "";
    int counted = 0;
    for (String con1 : con) { // all files in folder
      try {
        t = new File(sub + FS + con1 + FS + con1);
        if ((t.isDirectory()) & (con1.substring(4, 5).equals(" "))) {
          System.out.println("t.toString()" + " = " + t.toString());
          tmp = t.list();
          for (String tmp1 : tmp) {
            if ((tmp1.toLowerCase().contains(search)) & (tmp1.toLowerCase().endsWith(".gif"))) {
              System.out.println("\t" + tmp1);
              files += t + FS + tmp1 + CRLF;
              counted += 1;
//              break;
            }
          }
          GlobalMethods.saveTextFile(sub.toString(), type, ".txt", files);
          String[] tr = GlobalMethods.loadTextFile(sub.toString(), type, ".txt").split(CRLF);
          int lnum = counted / 3;
          int remain = counted % 3;
          if (remain != 0) {
            lnum += 1;
          }
          String tmps = page.replace("TITLE", "_ISF-" + type).replace("REPLACEME", "").replace("ABOUT", "");
          String tmpp = "<!-- " + lnum + " lines -->" + CRLF;
          for (int i = 0; i < counted; i++) {
            tmpp += "<img src=\"file:///" + tr[i] + "\" width='200' height='100' alt='eh?'/>\n";
          }
          tmpp += dir + CRLF;
          out = tmps.replace("TRAVELLERMAP", tmpp);
          GlobalMethods.saveTextFile(sub.toString(), "_ISF-" + type, ".html", out);
        }
      } catch (Exception x) {
      }
    }
  }

  private void cleanT5Cs() {
    String[] OKs = {"Squadron", "Troop", "Worlds", "Orbit", "Worlds", "SDBs",
      "Admiral", "Army Officer", "BASE", "Bases", "Blank", "Belts", "Commodore",
      "Defences", "Fleet", "Gas Giant", "Equipment",
      "Navy Officer", "Navy-1", "Navy-2", "Navy-3",
      "Navy-4", "Navy-5", "Navy-6",
      "Marine Officer", "Marine-1", "Marine-2", "Marine-3",
      "Marine-4", "Marine-5", "Marine6-",
      "Army Officer", "Army-1", "Army-2", "Army-3",
      "Army-4", "Army-5", "Army-6",
      "Merchant Officer", "Merchant-1", "Merchant-2", "Merchant-3",
      "Merchant-4", "Merchant-5", "Merchant-6",
      "Navy.", "Marine.", "Army.", "Scout.", "Merchant.", "Other.",
      "Planets", "Population", "Stars", "Ship", "Vehicle"
    };
    File dir = new File(jTextField1.getText());
    File dir2;
    File file2;
    String[] files = dir.list();
    String[] files2;
    String keep = "";
    String f2 = "";
//    String t5s = "";
//    String gifs = "";
//    System.out.println("" + " = " + "");
    int num = files.length;
    String name = "";
    for (int i = 0; i < num; i++) {
      if (files[i].substring(4, 5).equals(" ")) {
        files[i] = dir.toString() + FS + files[i] + FS + files[i];
        if (new File(files[i]).isDirectory()) {
//          dirs += files[i] + CRLF;
          System.out.println(files[i]);
          dir2 = new File(files[i]);
          files2 = dir2.list();
          for (String files21 : files2) {
            if (files21.endsWith(".t5c")) {
              if (!files21.substring(4, 5).equals(" ")) {
                f2 = files21;
                Boolean kill = true;
                for (String OK : OKs) {
                  if (f2.contains(OK)) {
                    kill = false;
                    keep += f2 + CRLF;
                  }
                }
                if (kill) {
                  File dead = new File(dir2.toString() + FS + f2);
                  dead.delete();
                  System.out.println("KILL\t" + dead.toString());
                }
              }
            }
          }
        }
      }
    }
    System.out.println("KEEP LIST" + " = " + keep);
//    System.out.println(dirs);
  }

  private String getSubX(int x) {
    return getSub(x);
  }

  private String getSubY(int y) {
    return getSub(y);
  }

  private String getSub(int num) {
    if (num < 10) {
      return "0" + num;
    }
    return "" + num;
  }

  int begin = 0;
  int fin = 0;
  int len = 0;
  int world1 = 0;

  private void listNobility() {
    //<editor-fold defaultstate="collapsed" desc="comment">
    {
      Boolean DEBUG = false; // true
      if (DEBUG) {
        System.out.println("listNobility");
      }
    }
//</editor-fold>
    if (jTextField1.getText().length() > 5) {
      int start = 6;
      String out = jTextField1.getText().substring(start);
      String sec = out.substring(0, out.indexOf(FS));
      String sub = out.substring(out.indexOf(FS) + 1);

      File f = new File("C:/T5/_SEC/" + sec + ".sec");
      lines = GlobalMethods.getLinesFromFile(f);
      for (int i = 0; i < lines.length; i++) {
        if (lines[i].startsWith("---- ")) {
          begin = findNobleCol(lines[i]);
          world1 = i + 1;
          break;
        }
      }
      int end = lines.length;
      int startx = 0;
      int endx = 0;
      int starty = 0;
      int endy = 0;
      //<editor-fold defaultstate="collapsed" desc="switch(sub.substring(0,1))">
      switch (sub.substring(0, 1)) {
        case "A": {
          startx = 1;
          endx = 8;
          starty = 1;
          endy = 10;
          break;
        }
        case "B": {
          startx = 9;
          endx = 16;
          starty = 1;
          endy = 10;
          break;
        }
        case "C": {
          startx = 17;
          endx = 24;
          starty = 1;
          endy = 10;
          break;
        }
        case "D": {
          startx = 25;
          endx = 32;
          starty = 1;
          endy = 10;
          break;
        }
        case "E": {
          startx = 1;
          endx = 8;
          starty = 11;
          endy = 20;
          break;
        }
        case "F": {
          startx = 9;
          endx = 16;
          starty = 11;
          endy = 20;
          break;
        }
        case "G": {
          startx = 17;
          endx = 24;
          starty = 11;
          endy = 20;
          break;
        }
        case "H": {
          startx = 25;
          endx = 32;
          starty = 11;
          endy = 20;
          break;
        }
        case "I": {
          startx = 1;
          endx = 8;
          starty = 21;
          endy = 30;
          break;
        }
        case "J": {
          startx = 9;
          endx = 16;
          starty = 21;
          endy = 30;
          break;
        }
        case "K": {
          startx = 17;
          endx = 24;
          starty = 21;
          endy = 30;
          break;
        }
        case "L": {
          startx = 25;
          endx = 32;
          starty = 21;
          endy = 30;
          break;
        }
        case "M": {
          startx = 1;
          endx = 8;
          starty = 31;
          endy = 40;
          break;
        }
        case "N": {
          startx = 9;
          endx = 16;
          starty = 31;
          endy = 40;
          break;
        }
        case "O": {
          startx = 17;
          endx = 24;
          starty = 31;
          endy = 40;
          break;
        }
        case "P": {
          startx = 25;
          endx = 32;
          starty = 31;
          endy = 40;
          break;
        }
      }
      //</editor-fold>
      String target = "";
      String string = "";
      String strings = "";
      String subs = "";
      for (int i = world1; i < end; i++) {
        for (int x = startx; x <= endx; x++) {
          for (int y = starty; y <= endy; y++) {
            target = "" + getSubX(x) + getSubY(y);
            if (lines[i].startsWith(target)) {
              string = lines[i].substring(begin, fin).trim();
              strings += string;
              subs += lines[i] + CRLF;
            }
          }
        }
      }
      sublist = subs.split(CRLF);
      saveNobles(strings);
      saveNobleWorldImportance();
    }
  }

  private int findNobleCol(String line) {
    //<editor-fold defaultstate="collapsed" desc="comment">
    {
      Boolean DEBUG = false; // true
      if (DEBUG) {
        System.out.println("findNobleCol");
      }
    }
    //</editor-fold>
    colcount = 0;
    String tmp;
    int i = 0;
    for (i = 0; i < line.length(); i++) {
      if (line.substring(i, i + 1).equals(" ")) {
        colcount += 1;
        if (colcount == 7) {
          begin = i;
          tmp = line.substring(begin + 1);
          len = tmp.indexOf(" ");
          fin = begin + len;
//          System.out.println("line" + " = " + line);
//          System.out.println("tmp" + " = " + tmp);
//          System.out.println("ends" + " = " + fin);
//          System.out.println("tmp.substring(0,ends)" + " = " + tmp.substring(0,fin));
          break;
        }
      }
    }
    return i;
  }

  private void saveNobles(String str) {
    //<editor-fold defaultstate="collapsed" desc="comment">
    {
      Boolean DEBUG = false; // true
      if (DEBUG) {
        System.out.println("saveNobles");
      }
    }
    //</editor-fold>
    String s = "";
    int A = 0;
    int B = 0;
    int c = 0;
    int C = 0;
    int D = 0;
    int e = 0;
    int E = 0;
    int f = 0;
    int F = 0;
    int G = 0;
    int H = 0;
    for (int i = 0; i < str.length(); i++) {
      s = str.substring(i, i + 1);
      switch (s) {
        case "A": {
          A += 1;
          break;
        }
        case "B": {
          B += 1;
          break;
        }
        case "c": {
          c += 1;
          break;
        }
        case "C": {
          C += 1;
          break;
        }
        case "D": {
          D += 1;
          break;
        }
        case "e": {
          e += 1;
          break;
        }
        case "E": {
          E += 1;
          break;
        }
        case "f": {
          f += 1;
          break;
        }
        case "F": {
          F += 1;
          break;
        }
        case "G": {
          G += 1;
          break;
        }
        case "H": {
          H += 1;
          break;
        }
      }
    }
    int[] nums = new int[]{A, B, c, C, D, e, E, f, F, G, H};
    String out = "";
    for (int i = 0; i < nobletitles.length; i++) {
      if (nums[i] > 0) {
        out += nobletitles[i] + " = " + nums[i] + CRLF;
        for (int j = 0; j < nums[i]; j++) {
          //out += "\t" + withTitle(nobletitles[i]);
        }
      }
    }
    String dir = jTextField1.getText();
    GlobalMethods.saveTextFile(dir, "Nobility", ".txt", out);
  }

  private String withTitle(String title) {
    //<editor-fold defaultstate="collapsed" desc="comment">
    {
      Boolean DEBUG = false; // true
      if (DEBUG) {
        System.out.println("withTitle");
      }
    }
    //</editor-fold>
    MouseEvent me = null;
    String name = null;
    name = panels.Panel4WordGenOld.getWord(me);
//    name = "Bob";
    return "(" + title.substring(2) + ") " + name.substring(0, name.length() - 1);
  }

  private String[] sublist;

  private String[] parts;

  private void saveNobleWorldImportance() {
    String fives = "";
    String fours = "";
    String threes = "";
    String twos = "";
    String ones = "";
    String zeros = "";
    String mones = "";
    String mtwos = "";
    String mthrees = "";
    String mfours = "";
    String mfives = "";
    String systems = "";
    for (int i = 0; i < Panel4T5Locator.jcb4Sys.getItemCount(); i++) {
      systems += Panel4T5Locator.jcb4Sys.getItemAt(i).substring(0, 4) + CRLF;
    }
    // ---------------------------------------------------------------------
    System.out.println(lines[world1 - 2]);
    System.out.println(lines[world1 - 1]);
    String letter;
    for (int i = 0; i < titles.length; i++) {
      if (titles[i].trim().equals("N")) {
        col = i;
        System.out.println("col " + i + " = " + titles[col].trim());
        break;
      }
    }
    // ---------------------------------------------------------------------
    File f = new File("C:/T5/_SEC/" + Panel4T5Locator.jcb4Sec.getSelectedItem().toString() + ".sec");
    String[] lines = GlobalMethods.getLinesFromFile(f);
    String[] worlds = systems.split(CRLF);
    String[] imps = {fives, fours, threes, twos, ones, zeros,
      mones, mtwos, mthrees, mfours, mfives};
    int dim = 0;
    for (String line1 : lines) {
      for (String world : worlds) {
        if (line1.startsWith(world)) {
          for (int imp = 5; imp >= -5; imp--) {
            if (line1.contains("{ " + imp + " }")) {
              if (imp == 5) {
                dim = 0;
              }
              if (imp == 4) {
                dim = 1;
              }
              if (imp == 3) {
                dim = 2;
              }
              if (imp == 2) {
                dim = 3;
              }
              if (imp == 1) {
                dim = 4;
              }
              if (imp == 0) {
                dim = 5;
              }
              if (imp == -1) {
                dim = 6;
              }
              if (imp == -2) {
                dim = 7;
              }
              if (imp == -3) {
                dim = 8;
              }
              if (imp == -4) {
                dim = 9;
              }
              if (imp == -5) {
                dim = 10;
              }
              imps[dim] += line1 + CRLF + listWorldNobles(line1) + CRLF;
            }
          }
        }
      }
    }
    //----------------------------------------------------------------------
    String out = "";
    for (int i = 0; i < imps.length; i++) {
      if (i == 0) {
        out = imps[i] + CRLF;
      } else {
        out += imps[i] + CRLF;
      }
    }
    GlobalMethods.saveTextFile(jTextField1.getText(), "NobleWorlds", ".txt", out.trim());
  }

  private String listWorldNobles(String line) {
    String let = "";
    int count = 0;
    String comp = lines[world1 - 1];
    for (int i = 0; i < comp.length(); i++) {
      let = comp.substring(i, i + 1);
      if (" ".equals(let)) {
        count += 1;
      }
      if (col == count) {
        pos = i;
        break;
      }
    }
    String ss;
    ss = line.substring(pos).trim();
    String tmp = ss.substring(0, ss.indexOf(" ")).trim();
    ss = "";
    for (int i = 0; i < tmp.length(); i++) {
      ss += getNoble(tmp.substring(i, i + 1)) + CRLF;
    }
    System.out.println(ss);
    return ss;
  }

  private String getNoble(String title) {
    int pts = 0; // SOC-10
    if (title.contains("Knight") | title.startsWith("B")) {
      pts = 1;
    }
    if (title.contains("baronet") | title.startsWith("c")) {
      pts = 2;
    }
    if (title.contains("Baron") | title.startsWith("C")) {
      pts = 3;
    }
    if (title.contains("Marquis") | title.startsWith("D")) {
      pts = 4;
    }
    if (title.contains("Viscount") | title.startsWith("e")) {
      pts = 5;
    }
    if (title.contains("Count") | title.startsWith("E")) {
      pts = 6;
    }
    if (title.contains("duke") | title.startsWith("f")) {
      pts = 7;
    }
    if (title.contains("Duke") | title.startsWith("F")) {
      pts = 8;
    }
    if (title.contains("Archduke") | title.startsWith("G")) {
      pts = 9;
    }
    if (title.contains("Emperor") | title.startsWith("H")) {
      pts = 10;
    }
    title = "\t" + withTitle(nobletitles[pts]);
    return title;
  }

  public static String Start = "";

  public static void createSection(String stringa, String pathstring) {
    int cols = 3;
    String title = stringa.toUpperCase();
    jta1.setText("" + title + CRLF);
    String t = "";
    //<editor-fold defaultstate="collapsed" desc="String start = ">
    Start = ""
            + "<!DOCTYPE html>\n"
            + "<!--\n"
            + "-->\n"
            + "  <head>\n"
            + "    <title>TITLE</title>\n"
            + "    <meta charset=\"UTF-8\">\n"
            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
            + "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
            + "    <script src=\"https://www.w3schools.com/lib/w3.js\"></script>\n"
            + "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
            + "    <link rel=\"stylesheet\" href=\"<script src=\"https://kit.fontawesome.com/21374df260.js\"></script>\">\n"
            + "    <!-- traveller/TravellerScripts.js -->\n"
            + "    <script src=\"TravellerScripts.js\"></script>\n";
//            + "  </head>\n";
    //</editor-fold>
    String sec = Panel4T5Locator.jcb4Sec.getSelectedItem().toString().trim();
    String sub = T5
            + "/" + sec
            + "/" + Panel4T5Locator.jcb4Sub.getSelectedItem().toString().trim() + "/";
    String sys = sub
            + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
    t = "" + stringa.toUpperCase() + "<br><br>";
    switch (stringa) {
      //---------------------------------------------------------------------
      // Texts
      //<editor-fold defaultstate="collapsed" desc="OLD">
      case "jta4All": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      case "jta4Bases": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      case "jta4Dest": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      case "jta4HTML": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      case "jta4Info": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      case "jta4Line": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      case "jta4Near": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      //    "", "", "", "", "", ""
      case "jta4Orb": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      case "jta4Sec": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      case "jta4Str": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      case "jta4Sub": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      case "jta4Sys": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      case "jta4UWP": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(), stringa, ".txt");
        break;
      }
      //</editor-fold>
      //---------------------------------------------------------------------
      // Sections
      //<editor-fold defaultstate="collapsed" desc="CASE">
      case "Cover": {
        cols = 1;
        t += createCovers();
        break;
      }
      // Intro
      case "Intro": {
        cols = 1;
        break;
      }
      // Worlds
      case "Worlds": {
        cols = 1;
        break;
      }
      // Marine
      case "Marine": {
        cols = 3;
        t += GlobalMethods.loadTextFile(sub, "Marine", ".txt") + CRLF;
        break;
      }
      // Navy
      case "Navy": {
        cols = 3;
        t += GlobalMethods.loadTextFile(sub, "Navy", ".txt" + CRLF);
        break;
      }
      case "ISF": {
        cols = 3;
        t += GlobalMethods.loadTextFile(sub, "ISF", ".txt") + CRLF;
        //        t += GlobalMethods.loadTextFile(sub, "Nobility", ".txt") + CRLF;
        //        t += GlobalMethods.loadTextFile(sub, "NobleWorlds", ".txt") + CRLF;
        break;
      }
      case "Targets": {
        cols = 3;
        t += GlobalMethods.loadTextFile(sub, "ISF", ".txt") + CRLF;;
        break;
      }
      case "Nobility": {
        cols = 3;
        t += GlobalMethods.loadTextFile(sub, "Nobility", ".txt") + CRLF;
        t += GlobalMethods.loadTextFile(sub, "NobleWorlds", ".txt") + CRLF;
        break;
      }
      case "PocketEmpire": {
        cols = 3;
        t += GlobalMethods.loadTextFile(sys, "PocketEmpire", ".txt") + CRLF;;
        //        t += GlobalMethods.loadTextFile(sub, "Nobility", ".txt") + CRLF;;
        //        t += GlobalMethods.loadTextFile(sub, "NobleWorlds", ".txt") + CRLF;;
        break;
      }
      // Family
      case "Family": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys, "Investments", ".txt") + CRLF;;
        break;
      }
      // Economics
      case "Economics": {
        cols = 1;
        t += GlobalMethods.loadTextFile(sys, "Economics", ".txt") + CRLF;;
        break;
      }
      // Xtent
      case "Xtent": {
        cols = 1;
        t += GlobalMethods.loadTextFile(T5, "Advert", ".txt") + CRLF;;
        break;
      }
      //      case "Test": {
      ////        JOptionPane.showMessageDialog(null, stringa);
      //        break;
      //      }
      case "USqP": {
        String sector = Panel4T5Locator.jcb4Sec.getSelectedItem().toString().trim();
        String subsec = Panel4T5Locator.jcb4Sub.getSelectedItem().toString().trim();
        String system = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
        String file = system.substring(0, 4);
        File f = new File(T5 + FS + sector + FS + subsec + FS + system
                + FS + file + ".usqp");
        System.out.println("sector = " + sector);
        System.out.println("subsec = " + subsec);
        System.out.println("system = " + system);
        System.out.println("file = " + file);
        System.out.println("f = " + f);
        if (f.exists()) {
          System.out.println("FOUND");
          t += GlobalMethods.loadTextFile(T5 + FS + sector + FS + subsec + FS + system, file, ".usqp") + CRLF;;
        } else {
          System.out.println("_____" + file);
//          JOptionPane.showMessageDialog(null, f.toString() + " DOES NOT EXIST");
          System.out.println("f.toString() + \" DOES NOT EXIST\"");
          return;
        }
        break;
      }
      case "///////////": {
        return;
      }
      //</editor-fold>
      //---------------------------------------------------------------------
      // default
      default: {
        break;
      }
    }
    t = t.replace("\n", "<br/>");
    t += "<br><br>";
    jta1.setText(Start.replace("TITLE", stringa).replace("<body>",
            "<body class='newspaper'>"));
    jta1.append("CSS\n"
            + "TRAVELLERMAP\n"
            + "REPLACEME\n");
    jta1.append("<div>\n");
    jta1.append(t + CRLF);
    jta1.append("</div>\n");
    jta1.append("WIKI\n\n\n");
    jta1.append("</body>" + CRLF);
    jta1.append("</html>" + CRLF);
    String d = "C:/T5/" + Panel4T5Locator.jcb4Sec.getSelectedItem().toString()
            + "/" + Panel4T5Locator.jcb4Sub.getSelectedItem().toString().trim()
            + "/" + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
    String ext = ".html";
    createMissing(stringa);
    GlobalMethods.saveTextFile(d, title, ext, jta1.getText()
            .replace("CSS", addCSS(cols))
            .replace("TRAVELLERMAP", "")
            .replace("REPLACEME", ""));
  }

  private static String addCSS(int cols) {
    String css = "";
    String Class = "newspaper";
    switch (cols) {
      case 1:
        Class = "main";
        break;
      case 2:
        Class = "mag";
        break;
      case 3: {
        Class = "newspaper";
        break;
      }
      default: {
        break;
      }
    }
    css += "<style>\n"
            + ".newspaper {\n"
            + "  /* Old Chrome, Safari and Opera */\n"
            + "  -webkit-column-count: 3; \n"
            + "  -webkit-column-gap: 3px;\n"
            + "  -webkit-column-rule-style: solid;"
            + "  \n"
            + "  /* Old Firefox */\n"
            + "  -moz-column-count: 3;\n"
            + "  -moz-column-gap: 3px;\n"
            + "  -moz-column-rule-style: solid;"
            + "\n"
            + "  /* Standard syntax */\n"
            + "  column-count: 3;\n"
            + "  column-gap: 3px;\n"
            + "  column-rule-style: solid;"
            + "  font-size: 8px;\n"
            + "}\n"
            + ".mag {\n"
            + "  /* Old Chrome, Safari and Opera */\n"
            + "  -webkit-column-count: 2; \n"
            + "  -webkit-column-gap: 3px;\n"
            + "  -webkit-column-rule-style: solid;"
            + "  \n"
            + "  /* Old Firefox */\n"
            + "  -moz-column-count: 2;\n"
            + "  -moz-column-gap: 3px;\n"
            + "  -moz-column-rule-style: solid;"
            + "\n"
            + "  /* Standard syntax */\n"
            + "  column-count: 2;\n"
            + "  column-gap: 3px;\n"
            + "  column-rule-style: solid;"
            + "  font-size: 8px;\n"
            + "}\n"
            + ".main {\n"
            + "  /* Old Chrome, Safari and Opera */\n"
            + "  -webkit-column-count: 1; \n"
            + "  -webkit-column-gap: 3px;\n"
            + "  -webkit-column-rule-style: solid;"
            + "  \n"
            + "  /* Old Firefox */\n"
            + "  -moz-column-count: 1;\n"
            + "  -moz-column-gap: 3px;\n"
            + "  -moz-column-rule-style: solid;"
            + "\n"
            + "  /* Standard syntax */\n"
            + "  column-count: 1;\n"
            + "  column-gap: 3px;\n"
            + "  column-rule-style: solid;"
            + "  font-size: 8px;\n"
            + "}\n"
            + "</style>\n"
            + "</head>\n"
            + "<body class=\'" + Class + "\'>\n";
    return css;
  }

  private static String createCovers() {
    //<editor-fold defaultstate="collapsed" desc="startup">
    //<editor-fold defaultstate="collapsed" desc="String wikiVland">
    String wikiVland = "\n\n\n\n\n\n//=============================================================================\n"
            + "\n"
            + "VLAND\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Vland_Sector\n"
            + "\n"
            + "A Voskhod\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Voskhod_Subsector\n"
            + "https://wiki.travellerrpg.com/Voskhod_(world)\n"
            + "\n"
            + "B Vhodan\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Vhodan_Subsector\n"
            + "https://wiki.travellerrpg.com/Vhodan_(world)\n"
            + "\n"
            + "C Anarsi\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Anarsi_Subsector\n"
            + "https://wiki.travellerrpg.com/Anarsi_(world)\n"
            + "\n"
            + "D Theton\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Theton_Subsector\n"
            + "https://wiki.travellerrpg.com/Theton_(world)\n"
            + "\n"
            + "E Lalaki Kharir\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Lalaki_Kharir_Subsector\n"
            + "\n"
            + "None\n"
            + "F Kagamira\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Kagamira_Subsector\n"
            + "https://wiki.travellerrpg.com/Kagamira_(world)\n"
            + "\n"
            + "G Vland\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Vland_Subsector\n"
            + "https://wiki.travellerrpg.com/Vland_(world)\n"
            + "\n"
            + "H Shiigus\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Shiigus_Subsector\n"
            + "https://wiki.travellerrpg.com/Shiigus_(world)\n"
            + "\n"
            + "I Dusa\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Dusa_Subsector\n"
            + "\n"
            + "None\n"
            + "J Akumid\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Akumid_Subsector\n"
            + "https://wiki.travellerrpg.com/Akumid_(world)\n"
            + "\n"
            + "K Kasear\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Kasear_Subsector\n"
            + "https://wiki.travellerrpg.com/Kasear_(world)\n"
            + "\n"
            + "L Anakod\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Anakod_Subsector\n"
            + "https://wiki.travellerrpg.com/Anakod_(world)\n"
            + "\n"
            + "M Parsi\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Parsi_Subsector\n"
            + "https://wiki.travellerrpg.com/Parsi_(world)\n"
            + "\n"
            + "N Daangiilu\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Daangiilu_Subsector\n"
            + "https://wiki.travellerrpg.com/Daangiilu_(world)\n"
            + "\n"
            + "O Nulisud\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Nulisud_Subsector\n"
            + "https://wiki.travellerrpg.com/Nulisud_(world)\n"
            + "\n"
            + "P Kakadan\n"
            + "\n"
            + "https://wiki.travellerrpg.com/Kakadan_Subsector\n"
            + "https://wiki.travellerrpg.com/Kakadan_(world)\n"
            + "\n"
            + "//=============================================================================";
    //</editor-fold>
    wikiVland = wikiVland.replace("\n", "<br>");
    //<editor-fold defaultstate="collapsed" desc="String[] VlandCaps">
    String[] VlandCaps = {
      "0708 Voskhod", "1208 Vhodan", "2205 Anarsi", "3107 Theton",
      "NONE", "1519 Kagamira", "1717 Vland", "2513 Shiigus",//E
      "NONE", "1628 Akumid", "1822 Kasear", "3224 Anakod",//I
      "0336 Parsi", "1136 Daangiilu", "1937 Nulisud", "2636 Kakadan"};
    //</editor-fold>
    //--------------------------------
    //<editor-fold defaultstate="collapsed" desc="String wikiSpin">
    String wikiSpin = "\n\n\n\n\n\n//=============================================================================\n"
            + "	SPINWARD MARCHES\n"
            + "	https://wiki.travellerrpg.com/Spinward_Marches_Sector\n"
            + "\n"
            + "A Chronor\n"
            + "https://wiki.travellerrpg.com/Chronor_Subsector\n"
            + "0304\n"
            + "https://wiki.travellerrpg.com/Chronor_(world)\n"
            + "B Jewell\n"
            + "https://wiki.travellerrpg.com/Jewell_Subsector\n"
            + "1106\n"
            + "https://wiki.travellerrpg.com/Jewell_(SM_1106)_(world)\n"
            + "C Regina\n"
            + "https://wiki.travellerrpg.com/Regina_Subsector\n"
            + "1910\n"
            + "https://wiki.travellerrpg.com/Regina_(world)\n"
            + "D Aramis\n"
            + "https://wiki.travellerrpg.com/Aramis_Subsector\n"
            + "3110\n"
            + "https://wiki.travellerrpg.com/Aramis_(SM_3110)_(world)\n"
            + "\n"
            + "E Querion\n"
            + "https://wiki.travellerrpg.com/Querion_Subsector\n"
            + "0614\n"
            + "https://wiki.travellerrpg.com/Querion_(world)\n"
            + "F Vilis\n"
            + "https://wiki.travellerrpg.com/Vilis_Subsector\n"
            + "1119\n"
            + "https://wiki.travellerrpg.com/Frenzie_(world)\n"
            + "G Lanth\n"
            + "https://wiki.travellerrpg.com/Lanth_Subsector\n"
            + "1719\n"
            + "https://wiki.travellerrpg.com/Lanth_(world)\n"
            + "H Rhylanor\n"
            + "https://wiki.travellerrpg.com/Rhylanor_Subsector\n"
            + "2716\n"
            + "https://wiki.travellerrpg.com/Rhylanor_(world)\n"
            + "\n"
            + "I Darrian\n"
            + "https://wiki.travellerrpg.com/Darrian_Subsector\n"
            + "0527\n"
            + "https://wiki.travellerrpg.com/Mire_(SM_0527)_(world)\n"
            + "J Sword Worlds\n"
            + "https://wiki.travellerrpg.com/Sword_Worlds_Subsector\n"
            + "1223\n"
            + "https://wiki.travellerrpg.com/Gram_(world)\n"
            + "K Lunion\n"
            + "https://wiki.travellerrpg.com/Lunion_Subsector\n"
            + "2124\n"
            + "https://wiki.travellerrpg.com/Lunion_(world)\n"
            + "L Mora\n"
            + "https://wiki.travellerrpg.com/Mora_Subsector\n"
            + "3124\n"
            + "https://wiki.travellerrpg.com/Mora_(world)\n"
            + "\n"
            + "M Five Sisters\n"
            + "https://wiki.travellerrpg.com/Five_Sisters_Subsector\n"
            + "0732\n"
            + "https://wiki.travellerrpg.com/Iderati_(world)\n"
            + "N District 268\n"
            + "https://wiki.travellerrpg.com/District_268_Subsector\n"
            + "1537\n"
            + "https://wiki.travellerrpg.com/Mertactor_(world)\n"
            + "O Glisten\n"
            + "https://wiki.travellerrpg.com/Glisten_Subsector\n"
            + "2036\n"
            + "https://wiki.travellerrpg.com/Glisten_(world)\n"
            + "P Trin`s Veil\n"
            + "https://wiki.travellerrpg.com/Trin's_Veil_Subsector\n"
            + "3235\n"
            + "https://wiki.travellerrpg.com/Trin_(world)\n"
            + "\n"
            + "//=============================================================================";
    //</editor-fold>
    wikiSpin = wikiSpin.replace("\n", "<br>");
    //<editor-fold defaultstate="collapsed" desc="String[] SpinCaps">
    String[] SpinCaps = {
      "0304 Chronor", "1106 Jewell", "1910 Regina", "3110 Aramis",
      "0614 Querion", "1116 Frenzie", "1719 Lanth", "2716 Rhylanor",
      "0527 Mire", "1223 Gram", "2124 Lunion", "3124 Mora",
      "0732 Iderati", "1533 Forine", "2036 Glisten", "3235 Trin"
    };
    //</editor-fold>
    String[] subcaps;
    String seccap;
    File f = new File(T5 + FS + "SEC.html");
    String sec = jTextField1.getText().substring(6, jTextField1.getText().lastIndexOf(FS));
    String desc = "Sector Guide";
    String line = "Politics, Power & Planets";
    String secgif = "C://T5/" + sec + FS + sec + " Sector.gif";
    String subgif = "";
    String wiki = "";
    String path = "";
    String tmp = "";
    if (sec.contains("Vland")) {
      wiki = wikiVland;
      subcaps = VlandCaps;
      seccap = "C:/T5/Vland/G Vland/1717 Vland/1717 Vland/1717-Subsector.gif";
    } else {
      wiki = wikiSpin;
      subcaps = SpinCaps;
      seccap = "C:/T5/Spinward Marches/L Mora/3124 Mora/3124 Mora/3124-Subsector.gif";
    }
    String[] subs = new String[Panel4T5Locator.jcb4Sub.getItemCount()];
    String txt = null;
    for (int i = 0; i < subs.length; i++) {
      subs[i] = Panel4T5Locator.jcb4Sub.getItemAt(i).trim();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Create Sector cover">
    //Create Sector cover
    txt = null;
    String uwp = ""; // 
//    String[] uwps = new String[16];
    for (int i = 0; i < subs.length; i++) {
      //subs[i] = Panel4T5Locator.jcb4Sub.getItemAt(i).trim();
      tmp = "C:/T5/" + sec + "/" + subs[i] + FS + subcaps[i] + FS + subcaps[i] + FS + subcaps[i].substring(0, 4) + "-Subsector.gif";
      path = tmp.substring(6, tmp.lastIndexOf(FS));
      path = path.substring(0, path.lastIndexOf(FS));
      uwp = GlobalMethods.loadTextFile(tmp.substring(0, tmp.lastIndexOf(FS)), "jta4UWP", ".txt");
      System.out.println("3391\tuwp = " + uwp);
      uwp = uwp.replace("\n", "<br>");
      //uwps[i] = uwp.trim();
      System.out.println("3394\tuwp[" + i + "] = " + uwp);
      subgif = subgif + "<br>" + "SUBSECTOR CAPITAL<br>" + path
              + "<br><IMG SRC=\'" + tmp + "\' NAME=\"graphics" + (i + 2) + "\" "
              + "ALIGN=CENTER WIDTH=215 HEIGHT=268 BORDER=0>"
              + "<br><br>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR>--UWP--<BR>\n".replace("--UWP--", uwp)
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR>\n"
              + "";
      if (path.contains("NONE")) {
        subgif = subgif + ""
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR>\n"
                + "    <BR><BR><BR>\n";

//                + "<p class=\"after\">\n</p>\n";
      }
      txt = GlobalMethods.loadTextFile(f.toString())
              .replace("--SEC--", sec)
              .replace("--GUIDE--", desc)
              .replace("--LINE--", line)
              .replace("--SECGIF--", secgif)
              .replace("--A--", subs[0].substring(2))
              .replace("--B--", subs[1].substring(2))
              .replace("--C--", subs[2].substring(2))
              .replace("--D--", subs[3].substring(2))
              .replace("--E--", subs[4].substring(2))
              .replace("--F--", subs[5].substring(2))
              .replace("--G--", subs[6].substring(2))
              .replace("--H--", subs[7].substring(2))
              .replace("--I--", subs[8].substring(2))
              .replace("--J--", subs[9].substring(2))
              .replace("--K--", subs[10].substring(2))
              .replace("--L--", subs[11].substring(2))
              .replace("--M--", subs[12].substring(2))
              .replace("--N--", subs[13].substring(2))
              .replace("--O--", subs[14].substring(2))
              .replace("--P--", subs[15].substring(2))
              .replace("--SUBGIF--", subgif);
    }
    //  Add Sector Capital
    //  seccap
    txt = txt + "--SECCAP--<br><br>";
    tmp = seccap;
    path = tmp.substring(6, tmp.lastIndexOf(FS));
    path = path.substring(0, path.lastIndexOf(FS));
    tmp = "<br>" + "<B>SECTOR CAPITAL</B><br>" + path + "<br><IMG SRC=\'" + seccap + "\' NAME=\"graphics" + (99) + "\" ALIGN=CENTER WIDTH=643 HEIGHT=804 BORDER=0><br><br><br><br>\n";
    txt = txt.replace("--SECCAP--", tmp);
    GlobalMethods.saveTextFile(T5 + FS + sec + FS + "_SEC" + FS + "0-COVER", sec, ".html", txt);

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Create Subsector covers">
    // Create Subsector covers
    String sub = "";
    subgif = "";
    int num = Panel4T5Locator.jcb4Sub.getItemCount();
    num = 16;
    String sys = "";
    int i = 0;
    for (i = 0; i < num; i++) {
      f = new File(T5 + FS + "SEC.html");
      sub = Panel4T5Locator.jcb4Sub.getItemAt(i).trim();
      desc = "Subsector Guide";
      line = "Power, Politics & Planets";
      tmp = "C:/T5/" + sec + "/" + subs[i] + FS + subcaps[i] + FS + subcaps[i] + FS + subcaps[i].substring(0, 4) + "-Subsector.gif";
      path = tmp.substring(6, tmp.lastIndexOf(FS));
      path = path.substring(0, path.lastIndexOf(FS));
      subgif = "<br>" + "SUBSECTOR CAPITAL<br>" + path + "<br><br><br><IMG SRC=\'" + tmp + "\' NAME=\"graphics" + (i + 2) + "\" ALIGN=CENTER WIDTH=643 HEIGHT=804 BORDER=0><BR><BR>\n<br>"
              + "    <BR><BR>\n"
              + "    <BR>--UWP--<BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "    <BR><BR>\n"
              + "";
      txt = GlobalMethods.loadTextFile(f.toString())
              .replace("--SEC--", sub + "(" + sec + ")")
              .replace("--GUIDE--", desc)
              .replace("--LINE--", line)
              .replace("--SECGIF--", secgif)
              .replace("--A--", subs[0].substring(2))
              .replace("--B--", subs[1].substring(2))
              .replace("--C--", subs[2].substring(2))
              .replace("--D--", subs[3].substring(2))
              .replace("--E--", subs[4].substring(2))
              .replace("--F--", subs[5].substring(2))
              .replace("--G--", subs[6].substring(2))
              .replace("--H--", subs[7].substring(2))
              .replace("--I--", subs[8].substring(2))
              .replace("--J--", subs[9].substring(2))
              .replace("--K--", subs[10].substring(2))
              .replace("--L--", subs[11].substring(2))
              .replace("--M--", subs[12].substring(2))
              .replace("--N--", subs[13].substring(2))
              .replace("--O--", subs[14].substring(2))
              .replace("--P--", subs[15].substring(2))
              .replace("--SUBGIF--", subgif) //              .replace("--SUBGIF--", subs[i])
              ;
      // save into    C:\T5\Vland\_SUB\0-COVER
      GlobalMethods.saveTextFile(
              T5 + FS + sec + FS + "_SUB" + FS + "0-COVER",
              sub + "", ".html", txt);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Create System covers">
    //Create System covers for subsector
    int subnum = Panel4T5Locator.jcb4Sub.getSelectedIndex();
    sys = "";
    int num1 = Panel4T5Locator.jcb4Sys.getItemCount();
    for (int j = 0; j < num1; j++) {
      f = new File(T5 + FS + "SEC.html");
      sub = Panel4T5Locator.jcb4Sub.getSelectedItem().toString().trim();
      tmp = "C:/T5/" + sec + "/" + subs[subnum] + FS + subcaps[subnum] + FS + subcaps[subnum] + FS + subcaps[subnum].substring(0, 4) + "-Subsector.gif";
      path = tmp.substring(6, tmp.lastIndexOf(FS));
      path = path.substring(0, path.lastIndexOf(FS));
      subgif = "<br>" + "SUBSECTOR CAPITAL<br>" + path + "<br><IMG SRC=\'" + tmp + "\' NAME=\"graphics" + (i + 2) + "\" ALIGN=CENTER WIDTH=643 HEIGHT=804 BORDER=0><br><br><br><br>    <BR><BR>\n";
      sys = Panel4T5Locator.jcb4Sys.getItemAt(j).trim();
      desc = "World Guide";
      line = "Planets, Power & Politics";
      txt = GlobalMethods.loadTextFile(f.toString())
              .replace("--SEC--", sys + "(" + sec + ")")
              .replace("--GUIDE--", desc)
              .replace("--LINE--", line)
              .replace("--SECGIF--", secgif)
              .replace("--A--", subs[0].substring(2))
              .replace("--B--", subs[1].substring(2))
              .replace("--C--", subs[2].substring(2))
              .replace("--D--", subs[3].substring(2))
              .replace("--E--", subs[4].substring(2))
              .replace("--F--", subs[5].substring(2))
              .replace("--G--", subs[6].substring(2))
              .replace("--H--", subs[7].substring(2))
              .replace("--I--", subs[8].substring(2))
              .replace("--J--", subs[9].substring(2))
              .replace("--K--", subs[10].substring(2))
              .replace("--L--", subs[11].substring(2))
              .replace("--M--", subs[12].substring(2))
              .replace("--N--", subs[13].substring(2))
              .replace("--O--", subs[14].substring(2))
              .replace("--P--", subs[15].substring(2))
              //              .replace("--WIKI--", wiki)
              //              .replace("--EXTRA--", extra)
              .replace("--SUBGIF--", subgif);
      // save into    C:\T5\<sec>\_SYS\0-COVER\<sub>
      String out = T5 + FS + sec + FS + "_SYS" + FS + "0-COVER" + FS + sub;
      System.out.println(out + FS + sys + ".html");
      GlobalMethods.saveTextFile(out, sys, ".html", txt);
    }
    //</editor-fold>

    return txt;
  }

  private static void createMissing(String stringa) {
    System.out.println("stringa = " + stringa);
    String dir = "C:/T5/";
    String file = stringa;
    String ext = ".txt";
    String txt = "";
    String no = "//";
    File f2 = new File(dir + stringa + ext);
    if (!f2.exists() & (!stringa.contains(no))) {
      System.out.println("CREATE FILE f = " + f2.toString());
      text = stringa.toUpperCase() + CRLF + CRLF;
      GlobalMethods.saveTextFile(dir, file, ext, text);
    }
  }

  private void show(String string) {
    System.out.println("string = " + string);
    String sec = Panel4T5Locator.jcb4Sec.getSelectedItem().toString().trim();
    String sub = Panel4T5Locator.jcb4Sub.getSelectedItem().toString().trim();
    String sys = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
    String START = "C:/T5/";
    String SEC = START + sec + FS;
    String SUB = SEC + FS + sub + FS;
    String SYS = SUB + FS + sys + FS;
    String SSSS = SYS + FS + sys + FS;
    String BTP = "C:/OpenEmpires/src/web/bits2page";
    String TMP = jTextField7.getText();
    String[] paths = {START, BTP, SEC, SUB, SYS, SSSS, TMP};
    String[] names = {"T5", "BTP", "Sector", "Subsector", "System", "SSSS", "TMP"};
    File f;
    String out = "";
    jta1.setText("");
    String[] list;
    //<editor-fold defaultstate="collapsed" desc="if ("Index".equals(string)) {">
    if ("Index".equals(string)) {
      // create list of html files to display
      for (int i = 0; i < paths.length; i++) {
        out += paths[i] + CRLF;
      }
      out += CRLF;
      for (int i = 0; i < paths.length; i++) {
        f = new File(paths[i]);
        list = f.list();
        if (jCheckBox1.isSelected()) {
          f = new File(f.toString() + FS + "");
          out += "FIND FILES OF TYPE "
                  + jComboBox1.getSelectedItem().toString()
                  + " IN FOLDER ";
          out += f.toString() + CRLF;
          for (int j = 0; j < list.length; j++) {
            if (list[j].endsWith(jComboBox1.getSelectedItem().toString())) {
              out += list[j] + CRLF;
            }
          }
          out += CRLF;
        } else {
          out += "FIND ALL TYPES IN FOLDER ";
          out += f.toString() + CRLF;
          for (int j = 0; j < list.length; j++) {
            out += list[j] + CRLF;
          }
          out += CRLF;
        }
      }
      out += CRLF;
      int num = out.split(CRLF).length - (4 * paths.length);
      out += num + " FILES";
      jta1.setText(out.replace("\\", "/"));
    }
    //</editor-fold>
  }

  private void isFile(JCheckBox jCheckBox1, JComboBox<String> jComboBox1) {
    if (jCheckBox1.isSelected()) {
      jComboBox1.setEnabled(true);
    } else {
      jComboBox1.setEnabled(false);
    }
    jButton10.doClick();
  }

  private void selectType() {
    jButton10.doClick();
  }

  private void textClick(MouseEvent evt) {
//    System.out.println("textClick()");
    //JOptionPane.showConfirmDialog(null, "textClick()");
    int pos = 0;
    int end = 0;
    String[] lines = jta1.getText().split(CRLF);
    for (int i = 0; i < lines.length; i++) {
//      System.out.println("lines[" + i + "].length() = " + lines[i].length());
      if (lines[i].length() == 0) {
        end = i;
//        System.out.println("end = " + i);
        break;
      }
    }
    String[] folders;
    folders = new String[end];
    for (int j = 0; j < end; j++) {
      folders[j] = lines[j];
//      System.out.println("folders[" + j + "] = " + folders[j]);
    }
    int paras = 0;
    for (int i = 0; i < lines.length; i++) {
      if (lines[i].startsWith("FIND")) {
        paras += 1;
      }
    }
//    System.out.println("paras = " + paras);
    int[] paraStart = new int[paras];
    int num = 0;
    for (int i = 0; i < lines.length; i++) {
      if (lines[i].startsWith("FIND")) {
        paraStart[num] = i;
//        System.out.println(lines[paraStart[num]]);
        num += 1;
      }
    }
    // Double click sets selectionStart int position, so we can find line 
    // numbers containing it.
    pos = jta1.getSelectionStart();
    int begini = 0;
    String ss = "";
    String txt;
    for (int i = 0; i < lines.length; i++) {
      ss = jta1.getText().substring(pos, jta1.getSelectionEnd());
      if (lines[i].contains(ss)) {
        for (int j = i; j >= paraStart[0]; j--) {
          if (lines[j].startsWith("FIND")) {
            begini = lines[j].indexOf("C:");
            txt = lines[j].substring(begini) + FS + ss;
            System.out.println(txt);
            jTextField8.setText(txt);
            return;
          }
        }
      }
    }

  }

}
