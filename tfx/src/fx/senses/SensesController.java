/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.senses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**

 @author Mark Ferguson
 */
public class SensesController implements Initializable {

  //<editor-fold defaultstate="collapsed" desc="FXVariables">
  @FXML
  private Label STRING;
  @FXML
  private ComboBox<String> cb;
  @FXML
  private Label con;
  @FXML
  private Label l4;
  @FXML
  private Label l4About;
  @FXML
  private Label la;
  @FXML
  private Label laba;
  @FXML
  private Label labb;
  @FXML
  private Label labc;
  @FXML
  private Label labd;
  @FXML
  private Label labe;
  @FXML
  private Label labf;
  @FXML
  private Label labg;
  @FXML
  private Label lb;
  @FXML
  private Label lc;
  @FXML
  private Label ld;
  private MouseEvent me;
  @FXML
  private Label out1;
  @FXML
  private Label out2;
  @FXML
  private Label out3;
  @FXML
  private Label out4;
  @FXML
  private Label out5;
  @FXML
  private Label out6;
  @FXML
  private Label out7;
  @FXML
  private ComboBox<String> race;
  @FXML
  private Label a;
  @FXML
  private Label b;
  @FXML
  private Label c;
  @FXML
  private Label l1;
  @FXML
  private Label l2;
  @FXML
  private Label l3;
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="FXMethods">
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    //<editor-fold defaultstate="collapsed" desc="initVariables">
    RangeBenchmark = new String[]{
      "0 Contact 0m",
      "1 VShort 5m",
      "2 Short 50m",
      "3 Medium 150m",
      "4 Long 500m",
      "5 VLong 1000m",
      "6 Distant 5000m",
      "7 VDistant	50km",
      "8 Orbit 500km",
      "9 FarOrbit	5000km"
    };

    VisionBenchmark = new String[]{
      "0 Contact 0m",
      "R Reading 0m",
      "T Touch 0m",
      "1 VShort 5m",
      "2 Short 50m",
      "3 Medium 150m",
      "4 Long 500m",
      "5 VLong 1000m",
      "6 Distant 5km",
      "7 VDistant 50km"
    };

    HearingBenchmark = new String[]{
      "0 Earpiece 0m Contact",
      "R Reading 0m Whisper",
      "T Talking 0m Talking",
      "1 VShort 5m Lecture",
      "2 Short 50m Shout",
      "3 Medium 150m Distress",
      "4 Long 500m Distress!!",
      "5 VLong 1000m Pistol",
      "6 Distant 5km Storm",
      "7 Gunshot 50km Nuke"
    };

    SmellBenchmark = new String[]{
      "0 Odorless",
      "1 Slight",
      "2 Aromatic",
      "3 Strong",
      "4 Intense",
      "5 Overwhelming",
      "H Harmful",
      "E Exotic"
    };

    AwarenessMassBenchmark = new String[]{
      "R Coin",
      "T Cards",
      "1 Book",
      "2 Suitcase",
      "3 Human",
      "4 Hvy m/c",
      "5 Buildings",
      "6 Hills",
      "7 Mountains"
    };

    AwarenessElectricBenchmark = new String[]{
      "1 SD Card",
      "2 Mobile",
      "3 Circuit Board",
      "4 Hvy m/c",
      "5 Town",
      "6 Grid",
      "7 Lightning"
    };

    AwarenessMagneticBenchmark = new String[]{
      "1 Coin",
      "2 Pistol",
      "3 Rifle",
      "4 Cooker",
      "5 Vehicle",
      "6 Town",
      "7 Country"
    };

    PerceptionLifeBenchmark = new String[]{
      "1 Flea",
      "2 Butterfly",
      "3 Mouse",
      "4 Dog",
      "5 Bull",
      "6 Elephant",
      "7 Whale"
    };

    PerceptionThoughtBenchmark = new String[]{
      "1 Calm life process",
      "2 Complex life process",
      "3 Simple thought",
      "4 Complex thought",
      "5 Strong emotion",
      "6 Death throes",
      "7 Many Death throes"
    };
    //</editor-fold>
    cb.getItems().addAll(senses);
    cb.getSelectionModel().selectFirst();
    race.getItems().addAll(races);
    race.getSelectionModel().selectFirst();
    try {
      raceChange(ae);
    } catch (IOException ex) {
      Logger.getLogger(SensesController.class.getName()).log(Level.SEVERE, null, ex);
    }
    cb.setValue("Smell");
    try {
      senseChange(ae);
      MouseEvent me = null;
      senseClick(me);
    } catch (IOException ex) {
      Logger.getLogger(SensesController.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @FXML
  private void line1(MouseEvent event) throws IOException {
    show(laba.getText());
  }

  @FXML
  private void line2(MouseEvent event) throws IOException {
    show(labb.getText());
  }

  @FXML
  private void line3(MouseEvent event) throws IOException {
    show(labc.getText());
  }

  @FXML
  private void line4(MouseEvent event) throws IOException {
    show(labd.getText());
  }

  @FXML
  private void line5(MouseEvent event) throws IOException {
    show(labe.getText());
  }

  @FXML
  private void line6(MouseEvent event) throws IOException {
    show(labf.getText());
  }

  @FXML
  private void line7(MouseEvent event) throws IOException {
    show(labg.getText());
  }

  @FXML
  private void raceChange(ActionEvent event) throws IOException {
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
    String s = "00";
    String raced = race.getValue();
    String sense = cb.getValue();
    if (raced != null & sense != null) {
      //Set String
      switch (raced) {
        //<editor-fold defaultstate="collapsed" desc="Human">
        case "Human": {
          visionString = "16-RGB";
          hearingString = "16-9392";
          smellString = "10-2";
          touchString = "6-2";
          awareString = "na";
          percepString = "na";
          switch (sense) {
            case "Vision": {
              s = "16";
              break;
            }
            case "Touch": {
              s = "6";
              break;
            }
            case "Hearing": {
              s = "16";
              break;
            }
            case "Awareness": {
              s = "00";
              break;
            }
            case "Smell": {
              s = "10";
              break;
            }
            case "Perception": {
              s = "00";
              break;
            }
          }

          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Vargr">
        case "Vargr": {
          visionString = "20-RxB";
          hearingString = "18-9471";
          smellString = "20-4";
          touchString = "14-3";
          awareString = "na";
          percepString = "na";
          switch (sense) {
            case "Vision": {
              s = "0";
              break;
            }
            case "Touch": {
              s = "0";
              break;
            }
            case "Hearing": {
              s = "0";
              break;
            }
            case "Awareness": {
              s = "0";
              break;
            }
            case "Smell": {
              s = "0";
              break;
            }
            case "Perception": {
              s = "0";
              break;
            }
          }
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Aslan">
        case "Aslan": {
          visionString = "16-RGB";
          hearingString = "18-8474";
          smellString = "18-3";
          touchString = "12-3";
          awareString = "na";
          percepString = "na";
          switch (sense) {
            case "Vision": {
              s = "0";
              break;
            }
            case "Touch": {
              s = "0";
              break;
            }
            case "Hearing": {
              s = "0";
              break;
            }
            case "Awareness": {
              s = "0";
              break;
            }
            case "Smell": {
              s = "0";
              break;
            }
            case "Perception": {
              s = "0";
              break;
            }
          }
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Droyne">
        case "Droyne": {
          visionString = "16-BPS";
          hearingString = "16-0000";
          smellString = "16-0";
          touchString = "16-0";
          awareString = "na";
          percepString = "na";
          switch (sense) {
            case "Vision": {
              s = "0";
              break;
            }
            case "Touch": {
              s = "0";
              break;
            }
            case "Hearing": {
              s = "0";
              break;
            }
            case "Awareness": {
              s = "0";
              break;
            }
            case "Smell": {
              s = "0";
              break;
            }
            case "Perception": {
              s = "0";
              break;
            }
          }
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="K`kree">
        case "K`kree": {
          visionString = "14-BPS";
          hearingString = "12-8191";
          smellString = "16-4";
          touchString = "8-3";
          awareString = "na";
          percepString = "na";
          switch (sense) {
            case "Vision": {
              s = "0";
              break;
            }
            case "Touch": {
              s = "0";
              break;
            }
            case "Hearing": {
              s = "0";
              break;
            }
            case "Awareness": {
              s = "0";
              break;
            }
            case "Smell": {
              s = "0";
              break;
            }
            case "Perception": {
              s = "0";
              break;
            }
          }
          break;
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Hiver">
        case "Hiver": {
          visionString = "16-CRG";
          hearingString = "16-9400";
          smellString = "12-2";
          touchString = "24-6";
          awareString = "20-5";
          percepString = "na";
          switch (sense) {
            case "Vision": {
              s = "0";
              break;
            }
            case "Touch": {
              s = "0";
              break;
            }
            case "Hearing": {
              s = "0";
              break;
            }
            case "Awareness": {
              s = "0";
              break;
            }
            case "Smell": {
              s = "0";
              break;
            }
            case "Perception": {
              s = "0";
              break;
            }
          }
          break;
        }
        //</editor-fold>
        }
      con.setText(s);
      c.setText(s);
      senseChange(ae);
    }
  }

  @FXML
  private void senseChange(ActionEvent event) throws IOException {
    System.out.println("senseChange");
    String r = race.getValue();
    String rr = cb.getValue();
    String s = "";
    String sense = "";
    String string = "";
    switch (rr) {
      case "Vision": {
        string = visionString;
        s = "16";
        l1.setText("RGB");
        l2.setText("");
        l3.setText("");
        l4.setText("");
        la.setText("RGB");
        lb.setText("");
        lc.setText("");
        ld.setText("");
        sense = "VISION";
        break;
      }
      case "Touch": {
        string = touchString;
        s = "6";
        l1.setText("S");
        l2.setText("");
        l3.setText("");
        l4.setText("");
        la.setText("S");
        lb.setText("");
        lc.setText("");
        ld.setText("");
        sense = "TOUCH";
        break;
      }
      case "Hearing": {
        string = hearingString;
        s = "16";
        l1.setText("FSVR");
        l2.setText("");
        l3.setText("");
        l4.setText("");
        la.setText("FSVR");
        lb.setText("");
        lc.setText("");
        ld.setText("");
        sense = "HEARING";
        break;
      }
      case "Awareness": {
        string = awareString;
        s = "0";
        l1.setText("A");
        l2.setText("");
        l3.setText("");
        l4.setText("");
        la.setText("A");
        lb.setText("");
        lc.setText("");
        ld.setText("");
        sense = "AWARENESS";
        break;
      }
      case "Smell": {
        string = smellString;
        s = "10";
        l1.setText("SP");
        l2.setText("");
        l3.setText("");
        l4.setText("");
        la.setText("SP");
        lb.setText("");
        lc.setText("");
        ld.setText("");
        sense = "SMELL";
        break;
      }
      case "Perception": {
        string = percepString;
        s = "0";
        l1.setText("TP");
        l2.setText("");
        l3.setText("");
        l4.setText("");
        la.setText("TP");
        lb.setText("");
        lc.setText("");
        ld.setText("");
        sense = "PERCEPTION";
        break;
      }
    }
    con.setText(s);
    a.setText(rr);
    b.setText(rr.substring(0, 1));
    System.out.println("string = " + string);
    STRING.setText("\t" + string);
    updateString(string);
    showLabels();
    show(sense);
  }

  @FXML
  private void senseClick(MouseEvent event) throws IOException {
    senseChange(ae);
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
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Variables">
  private String[] senses = {"Vision", "Hearing", "Smell", "Touch", "Awareness", "Perception"};
  private String[] races = {"Human", "Vargr", "Aslan", "Droyne", "K`kree", "Hiver"};
  private String CRLF = "\n";
  private ActionEvent ae;
  @FXML
  private TextArea ta;

  private String visionString = "";
  private String hearingString = "";
  private String smellString = "";
  private String touchString = "";
  private String awareString = "";
  private String percepString = "";

  private String[] RangeBenchmark;
  private String[] VisionBenchmark;
  private String[] HearingBenchmark;
  private String[] SmellBenchmark;
//  private String[] TouchBenchmark;
  private String[] AwarenessMassBenchmark;
  private String[] AwarenessElectricBenchmark;
  private String[] AwarenessMagneticBenchmark;
  private String[] PerceptionLifeBenchmark;
  private String[] PerceptionThoughtBenchmark;
  private String TEXT = "";
  private String[] LINES;
  private String[] lines;
  private String string;
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Methods">
  private void updateString(String value) {
    System.out.println("value = " + value);
    try {
      c.setText(value.split("-")[0]);
      l1.setText(value.split("-")[1]);
    } catch (Exception e) {
      System.out.println("e = " + e);
      c.setText("0");
      l1.setText("0");
    }
    switch (cb.getValue()) {
      case "Vision": {
        clearLabs();
        laba.setText("Band 1");
        labb.setText("Band 2");
        labc.setText("Band 3");
        break;
      }
      case "Touch": {
        clearLabs();
        laba.setText("Sensitivity");
        break;
      }
      case "Hearing": {
        clearLabs();
        laba.setText("Frequency");
        labb.setText("Span");
        labc.setText("Voice");
        labd.setText("Range");
        break;
      }
      case "Awareness": {
        clearLabs();
        laba.setText("Acuity");
        break;
      }
      case "Smell": {
        clearLabs();
        laba.setText("Sharpness");
        labb.setText("Primary");
        labc.setText("Overtone");
        labd.setText("Nuance");
        labe.setText("Diff 1/Gender");
        labf.setText("Diff 2/Caste");
        labg.setText("Diff 3/Pheromone");
        break;
      }
      case "Perception": {
        clearLabs();
        laba.setText("Tone");
        labb.setText("PVoice");
        break;
      }
      default: {
        break;
      }
    }
  }

  private void clearLabs() {
    laba.setText("");
    labb.setText("");
    labc.setText("");
    labd.setText("");
    labe.setText("");
    labf.setText("");
    labg.setText("");
  }

  private void clearLabels() {
    out1.setText("");
    out2.setText("");
    out3.setText("");
    out4.setText("");
    out5.setText("");
    out6.setText("");
    out7.setText("");
  }

  private void showLabels() {
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
    clearLabels();
    Label[] labs = {laba, labb, labc, labd, labe, labf, labg};
    Label[] outs = {out1, out2, out3, out4, out5, out6, out7};
    try {
      for (int i = 0; i < outs.length; i++) {
        if (labs[i].getText().equals(null)) {
          break;
        }
        switch (i) {
          case 0: {
            line1(me);
            break;
          }
          case 1: {
            line2(me);
            break;
          }
          case 2: {
            line3(me);
            break;
          }
          case 3: {
            line4(me);
            break;
          }
          case 4: {
            line5(me);
            break;
          }
          case 5: {
            line6(me);
            break;
          }
          case 6: {
            line7(me);
            break;
          }
        }
      }
    } catch (Exception e) {

    }
  }

  private void showLines(String[] array) {
    ta.setText("");
    if (array != null) {
      if (array.length > 0) {
        for (int i = 0; i < array.length; i++) {
          ta.appendText(array[i] + CRLF);
        }
      }
    }
  }

  private void add(String[] stringarray, String title) {
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
    TEXT += CRLF + CRLF + "\t" + title.toUpperCase();
    for (int i = 0; i < stringarray.length; i++) {
      TEXT += CRLF + stringarray[i];
    }
    TEXT += CRLF;
    LINES = new String[]{TEXT};
    lines = LINES;
  }

  private void addTable(String txt) throws IOException {
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
    try {
      String s = "C://T5/Senses/src/senses/" + txt;
      try (BufferedReader br = new BufferedReader(new FileReader(s))) {
        String contents;
        TEXT += "\n";
        while ((contents = br.readLine()) != null) {
          String line = contents.replace("\"", "").replace(",", "\t\t");
          TEXT += line + CRLF;
        }
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(SensesController.class.getName()).log(Level.SEVERE, null, ex);
    }
    lines = new String[]{TEXT};
  }

  //</editor-fold>
  private void show(String text) throws IOException {
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
    ta.setText("\t" + text.toUpperCase());
    TEXT = text;
    lines = new String[]{"\t" + text.toUpperCase()};
    switch (text) {
      //////////////////////////////SENSES
      //<editor-fold defaultstate="collapsed" desc="VISION">
      case "VISION": {
        add(VisionBenchmark, "RANGE");
        addTable("Vision.csv");
        add(new String[]{""
          + "To Notice Object: 2D < Constant + Benchmark + Mod + Mod" + CRLF
          + "" + CRLF
          + "RANGE\tRoll dice equal to R=Range" + CRLF
          + text + "\tVision Constant for Race" + CRLF
          + "BENCHMARK\tObject Size - R=Range" + CRLF
          + "MODS\tMaster Mods Table" + CRLF
        }, "Notice");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="HEARING">
      case "HEARING": {
        add(HearingBenchmark, text);
        addTable("Hearing.csv");
        add(new String[]{""
          + "To Notice Sound: 2D < Constant + Benchmark + Mod + Mod" + CRLF
          + "" + CRLF
          + "RANGE\tRoll dice equal to R=Range" + CRLF
          + text + "\tHearing Constant for Race" + CRLF
          + "BENCHMARK\tObject Size - R=Range" + CRLF
          + "MODS\tMaster Mods Table" + CRLF
          + "" + CRLF
          + "Delta Waves\tInduces/Promotes Sleep.\n\t\t5m + Check C3 or sleep\n\t\t(First time = 1D m, " + "Second time = 1D h)" + CRLF
          + "Theta Waves\tInduces Hypnotic/Trance suggestive states" + CRLF
          + "\t\t5m + Personals vs character may include Good Flux" + CRLF
          + "Alpha Waves\tInduces Relaxation" + CRLF
          + "\t\t5m + Feels sleepy" + CRLF
          + "Beta Waves\tInduces Alertness" + CRLF
          + "\t\t1m + Feels Ordinary for 1h" + CRLF
          + "\t\t + Then returns to previous Attention level" + CRLF
          + "\t\t + Many Alarms output at F=4 (Overuse check SAN)" + CRLF
          + "Gamma Waves\tInduces Heightened Productivity" + CRLF
          + "\t\t5m + Feels Optimal for 1h" + CRLF
          + "\t\t1m + Then returns to previous Attention level" + CRLF
        }, "Notice");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="SMELL">
      case "SMELL": {
        add(SmellBenchmark, text);
        addTable("Odors.csv");
        add(new String[]{""
          + "To Notice Scent: 2D < Constant + Benchmark + Mod + Mod" + CRLF
          + "" + CRLF
          + "RANGE\tRoll 2D" + CRLF
          + text + "\tSmell Constant for Race" + CRLF
          + "BENCHMARK\tSmell Intensity < 1 = no smell" + CRLF
          + "MODS\tMaster Mods Table" + CRLF
        }, "Notice");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="TOUCH">
      case "TOUCH": {
        addTable("Manipulators.csv");
        add(new String[]{""
          + "To Notice Texture: 2D < Constant + Benchmark + Mod + Mod" + CRLF
          + "" + CRLF
          + text + "\tTouch Constant for Race" + CRLF
          + "BENCHMARK\tObject Texture" + CRLF
          + "MODS\tManipulator Mods Table" + CRLF
          + "SENSITIVITY = NUMBER OF RETRIES ALLOWED" + CRLF
        }, "Notice");
        addTable("Manipulators.csv");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="PERCEPTION">
      case "PERCEPTION": {
        add(PerceptionLifeBenchmark, "Life Benchmark");
        add(PerceptionThoughtBenchmark, "Thought Benchmark");
        add(new String[]{""
          + "To Notice Aura: 2D < Constant + Benchmark + Mod + Mod" + CRLF
          + "" + CRLF
          + "RANGE\tRoll dice equal to R=Range" + CRLF
          + text + "\tPerception Constant for Race" + CRLF
          + "BENCHMARK\tObject Size - R=Range" + CRLF
          + "MODS\tMaster Mods Table" + CRLF
        }, "Notice");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="AWARENESS">
      case "AWARENESS": {
        add(AwarenessMassBenchmark, "Mass");
        add(AwarenessElectricBenchmark, "Lek");
        add(AwarenessMagneticBenchmark, "Mag");
        add(new String[]{""
          + "To Notice Field: 2D < Constant + Benchmark + Mod + Mod" + CRLF
          + "" + CRLF
          + "RANGE\tRoll dice equal to R=Range" + CRLF
          + text + "\tAware Constant for Race" + CRLF
          + "BENCHMARK\tObject Size - R=Range" + CRLF
          + "MODS\tMaster Mods Table" + CRLF
          + "" + CRLF
          + "L = Lek = Color Associated with Electric Fields" + CRLF
          + "M = Mag = Color Associated with Magnetic Fields" + CRLF
          + "" + CRLF
          + "Direction" + CRLF
          + "Local Features" + CRLF
          + "Electric & Magnetic Fields" + CRLF
        }, "Notice");
        break;
      }
      //</editor-fold>
      //////////////////////////////Vision
      //<editor-fold defaultstate="collapsed" desc="Band 1">
      case "Band 1": {
        add(new String[]{}, "High Band");
        addTable("Vision.csv");
        String labeltext = l1.getText().substring(0, 1);
        out1.setText(labeltext);
        add(new String[]{labeltext}, "High Band");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Band 2">
      case "Band 2": {
        add(new String[]{}, "Medium Band");
        addTable("Vision.csv");
        String labeltext = l1.getText().substring(1, 2);
        out2.setText(labeltext);
        add(new String[]{labeltext}, "Medium Band");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Band 3">
      case "Band 3": {
        add(new String[]{}, "Low Band");
        addTable("Vision.csv");
        String labeltext = l1.getText().substring(2, 3);
        out3.setText(labeltext);
        add(new String[]{labeltext}, "Low Band");
        break;
      }
      //</editor-fold>
      //////////////////////////////Hearing
      //<editor-fold defaultstate="collapsed" desc="Frequency">
      case "Frequency": {
        add(HearingBenchmark, "Hearing Benchmark");
        add(new String[]{""
          + "Human Audible from C2 to C8" + CRLF
          + "Male Voice = C4" + CRLF
          + "Female Voice = C5" + CRLF
        }, "Frequency");
        out1.setText(l1.getText().substring(0, 1));
        addTable("Hearing.csv");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Span">
      case "Span": {
        add(HearingBenchmark, "Hearing Benchmark");
        out2.setText(l1.getText().substring(1, 2));
        add(new String[]{""
          + "Span:\t" + out2.getText() + " Octaves above and below F=Frequency" + CRLF
        }, text);
        addTable("Hearing.csv");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Voice">
      case "Voice": {
        add(HearingBenchmark, "Hearing Benchmark");
        out3.setText(l1.getText().substring(2, 3));
        add(new String[]{""
          + "Voice:\tHuman Voice Centered on C5" + CRLF
          + "Human Male is 1 Octave Lower @ C4" + CRLF
        }, text);
        addTable("Hearing.csv");
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Range">
      case "Range": {
        add(HearingBenchmark, "Hearing Benchmark");
        out4.setText(l1.getText().substring(3, 4));
        add(new String[]{""
          + "Octaves Above & Below F=Frequency" + CRLF
        }, text);
        addTable("Hearing.csv");
        break;
      }
      //</editor-fold>
      //////////////////////////////Smell
      //<editor-fold defaultstate="collapsed" desc="Sharpness">
      case "Sharpness": {
        add(SmellBenchmark, "Sharpness Benchmark");
        out1.setText(l1.getText().substring(0, 1));
        addTable("Odors.csv");
        add(new String[]{}, text);
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Primary">
      case "Primary": {
        add(new String[]{}, "Primary");
        addTable("Odors.csv");
        add(new String[]{}, text);
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Overtone">
      case "Overtone": {
        add(new String[]{}, "Overtone");
        addTable("Odors.csv");
        add(new String[]{}, text);
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Nuance">
      case "Nuance": {
        add(new String[]{}, "Nuance");
        addTable("Odors.csv");
        add(new String[]{}, text);
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Diff 1/Gender">
      case "Diff 1/Gender": {
        add(new String[]{}, "Gender");
        addTable("Odors.csv");
        add(new String[]{}, text);
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Diff 2/Caste">
      case "Diff 2/Caste": {
        add(new String[]{}, "Caste");
        addTable("Odors.csv");
        add(new String[]{}, text);
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="Diff 3/Pheromone">
      case "Diff 3/Pheromone": {
        addTable("Odors.csv");
        add(new String[]{}, text);
        addTable("Pheromone.csv");
        break;
      }
      //</editor-fold>
      //////////////////////////////Touch
      //<editor-fold defaultstate="collapsed" desc="Sensitivity">
      case "Sensitivity": {
        add(new String[]{}, "Sensitivity");
        out1.setText(l1.getText());
        break;
      }
      //</editor-fold>
      //////////////////////////////Awareness
      //<editor-fold defaultstate="collapsed" desc="Acuity">
      case "Acuity": {
        add(new String[]{}, "Acuity");
        out1.setText(l1.getText());
        break;
      }
      //</editor-fold>
      //////////////////////////////Perception
      //<editor-fold defaultstate="collapsed" desc="Tone">
      case "Tone": {
        add(new String[]{}, "Tone");
        out1.setText(l1.getText());
        break;
      }
      //</editor-fold>
      //<editor-fold defaultstate="collapsed" desc="comment">
      case "PVoice": {
        add(new String[]{}, "PVoice");
        break;
      }
      //</editor-fold>
      default: {
        System.out.println(text + "\tOOOOOOOOOOOOOOOOOO");
      }
    }
    showLines(lines);
  }

  /*
   */
}
