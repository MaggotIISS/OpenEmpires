/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package panels;

import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalVariables.FS;
import fx.brains.Brains;
import fx.combocon.ComboCon;
import fx.counter.Counter;
import fx.fluctions.Fluctions;
import fx.genetics.Genetics;
import fx.hexbutton.HexButton;
import fx.multiedit.TestEdit;
import fx.personal.Personal;
import fx.scenario.Scenario;
import fx.senses.Senses;
import fx.sophontoids.Sophontoids;
import fx.terrainview.TerrainView;
import fx.worldmap.WorldMap;
import fx.xmaps.StringMaps;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import static panels.Panel4T5Locator.sheetnum;
import static panels.Panel4T5Locator.stylesheet;
import wordgen.WordGen;

/**

 @author Mark Ferguson
 */
public class Locator extends Panel4 {

  public static void main(String[] args) {
    String[] stylesheets = new String[]{
      "file:///C://T5/TFX/src/fx/CSS/modena.css",
      "file:///C://T5/TFX/src/fx/TravellerStylesheet.css"
    };
    Panel4T5Locator.sheetnum = 0;
    stylesheet = stylesheets[sheetnum];
    System.out.println("stylesheet" + " = " + stylesheets[sheetnum]);
    JFrame f4;
    f4 = new Frame4();
    f4.setTitle(stylesheet);
    SwingUtilities.invokeLater(() -> {
      final JFXPanel jfx = new JFXPanel();
      f4.getContentPane().add(jfx);
      f4.setSize(600, 150);
      f4.setVisible(true);
      Platform.runLater(() -> {
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but0 XPathTester">
        Button but0 = new Button("XPathTester");
        but0.setOnAction((javafx.event.ActionEvent e) -> {
          System.out.println(but0.getText());
          fx.xpath.XPathTester xpt = new fx.xpath.XPathTester();
          Stage stage = new Stage();
          stage.initOwner(null);
          stage.setX(0);
          stage.setY(0);
          try {
//            String[] args;
            final String[] argsa = new String[]{""};
            xpt.main(args);
          } catch (Exception ex) {
            Logger.getLogger(Panel4T5Locator.class.getName()).log(Level.SEVERE,
              null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but1 XML">
        Button but1 = new Button("XML");
        but1.setOnAction(e -> {
          System.out.println(but1.getText());
          fx.xml.XML xml = new fx.xml.XML();
          Stage stage = new Stage();
          stage.initOwner(null);
          stage.setX(0);
          stage.setY(0);
          stage.setTitle("XML");
          try {
            xml.start(stage);
          } catch (Exception ex) {
            Logger.getLogger(Panel4T5Locator.class.getName()).log(Level.SEVERE,
              null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but2 MultiText">
//        Button but2 = new Button("MultiText");
//        but2.setOnAction(e -> {
//          System.out.println(but2.getText());
//          MultiText mt = new fx.multitext.MultiText();
//          Stage stage = new Stage();
//          stage.initOwner(null);
//          stage.setX(0);
//          stage.setY(0);
//          stage.setTitle("MultiText");
//          try {
//            mt.start(stage);
//          } catch (Exception ex) {
//            Logger.getLogger(Panel4T5Locator.class.getName()).log(Level.SEVERE,
//              null, ex);
//          }
//        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but3 T5">
        Button but3 = new Button("T5");
        but3.setOnAction(e -> {
          System.out.println(but3.getText());
          fx.t5.T5 t5 = new fx.t5.T5();
          Stage stage = new Stage();
          stage.initOwner(null);
          stage.setX(0);
          stage.setY(0);
          stage.setTitle("T5");
          try {
            t5.start(stage);
          } catch (Exception ex) {
            Logger.getLogger(Panel4T5Locator.class.getName()).log(Level.SEVERE,
              null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but4 ComboCon">
        Button but4 = new Button("ComboCon");
        but4.setOnAction((ActionEvent e) -> {
          System.out.println(but4.getText());
          ComboCon comboCon = new ComboCon();
          StackPane root = new StackPane();
          root.getChildren().addAll(comboCon);
          Stage stage = new Stage();
          stage.initOwner(null);
          stage.setX(0);
          stage.setY(0);
          Scene scene = new Scene(root, 200, 200);
          try {
            scene.setUserAgentStylesheet(stylesheet);
          } catch (Exception x) {

          }
          String title = "ComboCon";
          stage.setTitle(title);
          stage.setScene(scene);
          stage.show();
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but5 HexButton">
        Button but5 = new Button("HexButton");
        but5.setOnAction(e -> {
          System.out.println(but5.getText());
          HexButton button = new HexButton();
          //          HexButton button = new HexButton("Zhodani");
          StackPane pane = new StackPane();
          pane.getChildren().add(button);
          Scene scene = new Scene(pane, 200, 200);
          scene.setUserAgentStylesheet(stylesheet);
          Stage stage = new Stage();
          stage.initOwner(null);
          stage.setX(0);
          stage.setY(0);
          stage.setScene(scene);
          stage.setTitle("HexButton");
          stage.show();
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but6 ContextLink">
        Button but6 = new Button("ContextLink");
        but6.setOnAction((javafx.event.ActionEvent e) -> {
          System.out.println(but6.getText());
          String name;
          try {
            name = panels.Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
              .trim();
          } catch (Exception x) {
            name = "1705 Efate";
          }
          String[] items = HexButton.getStrings("gif");
          fx.contextlink.ContextLink contextLink
            = new fx.contextlink.ContextLink(name, items);
          StackPane pane = new StackPane();
          pane.getChildren().add(contextLink);
          Scene scene = new Scene(pane, 200, 200);
          scene.setUserAgentStylesheet(stylesheet);
          Stage stage = new Stage();
          stage.initOwner(null);
          stage.setX(0);
          stage.setY(0);
          stage.setScene(scene);
          stage.setTitle("ContextLink");
          stage.show();
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but7 old NPC">
        Button but7 = new Button("NPC");
        but7.setOnAction((javafx.event.ActionEvent e) -> {
          System.out.println(but7.getText());
          fx.xtestmap.TestMap testMap = new fx.xtestmap.TestMap();
          StackPane pane = new StackPane();
          TextArea ta = new TextArea();
          ta.setText(testMap.output);
          pane.getChildren().add(ta);
          Scene scene = new Scene(pane, 200, 350);
          scene.setUserAgentStylesheet(stylesheet);
          Stage stage = new Stage();
          stage.initOwner(null);
          stage.setX(0);
          stage.setY(0);
          stage.setScene(scene);
          stage.setTitle(testMap.getMap().get("system").substring(0, 4) + "-"
            + testMap.getMap().get("career") + "-" + testMap.getMap()
            .get("name"));
          stage.show();
          String folder = Panel4T5Locator.getHdpath() + FS
            + Panel4T5Locator.jcb4Sec.getSelectedItem().toString() + FS
            + Panel4T5Locator.jcb4Sub.getSelectedItem().toString() + FS
            + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + FS
            + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + FS;
          String name = stage.getTitle();
          String ext = ".txt";
          String txt = testMap.output;
          GlobalMethods.saveTextFile(folder, name, ext, txt);
//          Panel4T5CounterMaker.savePic();
//          Panel4T5CounterMaker.picClick();
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but8 CSS">
        Button but8 = new Button("CSS");
        but8.setTooltip(new Tooltip(stylesheet));
        but8.setOnAction((javafx.event.ActionEvent e) -> {
          sheetnum += 1;
          if (sheetnum == stylesheets.length) {
            sheetnum = 0;
          }
          stylesheet = stylesheets[sheetnum];
          System.out.println("stylesheet = " + stylesheet);
          f4.setTitle(stylesheet);
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but9 old Sector">
        Button but9 = new Button("Sector");
        but9.setOnAction((javafx.event.ActionEvent e) -> {
          new fx.xmaps.StringMaps().getMap(but9.getText());
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but10 old NPC">
        Button but10 = new Button("NPC");
        but10.setOnAction((javafx.event.ActionEvent e) -> {
          new StringMaps().getMap(but10.getText());
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but11 old Counter">
        Button but11 = new Button("Counter");
        but11.setOnAction((javafx.event.ActionEvent e) -> {
          new StringMaps().getMap(but11.getText());
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but12 MultiMap">
        Button but12 = new Button("MultiMap");
        but12.setOnAction((javafx.event.ActionEvent e) -> {
          new TestEdit().start(new Stage());
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but13 Counter">
        Button but13 = new Button("Counter");
        but13.setOnAction((javafx.event.ActionEvent e) -> {
          new Counter().start(new Stage());
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but14 Scenario">
        Button but14 = new Button("Scenario");
        but14.setOnAction((javafx.event.ActionEvent e) -> {
          new Scenario().start(new Stage());
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but15 TerrainView">
        Button but15 = new Button("TerrainView");
        but15.setOnAction((javafx.event.ActionEvent e) -> {
          try {
            new TerrainView().start(new Stage());
          } catch (Exception ex) {
            Logger.getLogger(Locator.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but16 Brains">
        Button but16 = new Button("Brains");
        but16.setOnAction((javafx.event.ActionEvent e) -> {
          try {
            new Brains().start(new Stage());
//            Brains.main(args);

          } catch (Exception ex) {
            Logger.getLogger(Locator.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but17 Fluctions">
        Button but17 = new Button("Fluctions");
        but17.setOnAction((javafx.event.ActionEvent e) -> {
          try {
            new Fluctions().start(new Stage());
          } catch (Exception ex) {
            Logger.getLogger(Locator.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but18 ???">
        Button but18 = new Button("???");
        but18.setOnAction((javafx.event.ActionEvent e) -> {
          try {
//            new TerrainView().start(new Stage());
          } catch (Exception ex) {
            Logger.getLogger(Locator.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but19 Genetics">
        Button but19 = new Button("Genetics");
        but19.setOnAction((javafx.event.ActionEvent e) -> {
          try {
            new Genetics().start(new Stage());
//            fx.genetics.Genetics.main(args);
          } catch (Exception ex) {
            Logger.getLogger(Locator.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but20 Personal">
        Button but20 = new Button("Personal");
        but20.setOnAction((javafx.event.ActionEvent e) -> {
          try {
            new Personal().start(new Stage());
          } catch (Exception ex) {
            Logger.getLogger(Locator.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but21 Senses">
        Button but21 = new Button("Senses");
        but21.setOnAction((javafx.event.ActionEvent e) -> {
          try {
            new Senses().start(new Stage());
          } catch (Exception ex) {
            Logger.getLogger(Locator.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but22 Sophontoids">
        Button but22 = new Button("Sophontoids");
        but22.setOnAction((javafx.event.ActionEvent e) -> {
          try {
            new Sophontoids().start(new Stage());
          } catch (Exception ex) {
            Logger.getLogger(Locator.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but23 WordGen">
        Button but23 = new Button("WordGen");
        but23.setOnAction((javafx.event.ActionEvent e) -> {
          try {
            new WordGen().start(new Stage());
          } catch (Exception ex) {
            Logger.getLogger(Locator.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        //<editor-fold defaultstate="collapsed" desc="but24 WorldMap">
        Button but24 = new Button("WorldMap");
        but24.setOnAction((javafx.event.ActionEvent e) -> {
          try {
            new WorldMap().start(new Stage());
          } catch (Exception ex) {
            Logger.getLogger(Locator.class.getName())
              .log(Level.SEVERE, null, ex);
          }
        });
        //</editor-fold>
        ////////////////////////////////////////////////////////////////////
        FlowPane pane = new FlowPane(but0, but1, but3, but4, but5, but6,
          but8, but12, but13, but14, but15, but16, but17, but18, but19,
          but20, but21, but22, but23, but24);
        Scene scene = new Scene(pane);
        jfx.setScene(scene);
      });
    });
  }

}
