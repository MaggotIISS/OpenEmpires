/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.notes;

import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalVariables.CRLF;
import java.io.File;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**

 @author Mark Ferguson
 */
public class NoteIt extends Application {

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  private final String FS = "/";

  private ComboBox<String> cb;
  private ComboBox<String> cb2;
  private final Label dir = new Label("dir");
  private final Label ext = new Label("ext");
  private final Label file = new Label("file");
  private ObservableList<String> filelist;
  private String line;
  private Label searchfor;
  private ObservableList<String> srclist;
  private final Stage stage = new Stage();
  private TextArea ta;
  private String[] texts;

  @Override
  @SuppressWarnings("unchecked")
  public void start(Stage primaryStage) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        System.out.println(s);
      }
    }
    //</editor-fold>
    String string = GlobalMethods.loadTextFile("C://T5/TFX/src/fx/notes/",
      "NoteList", ".txt");
    String[] strings = string.split(CRLF);
    filelist = FXCollections.observableArrayList();
    filelist.setAll(strings);
    filelist = filelist.sorted();
    cb = new ComboBox<>(filelist);
    //<editor-fold defaultstate="collapsed" desc="cb.setOnAction">
    cb.setOnAction(
      (ActionEvent e) -> {
      //<editor-fold defaultstate="collapsed" desc="IFD">
      {
        String s = "";
        boolean DEBUG = true;  // true or false;
        if (DEBUG) { // true or false
          s += "//////////////////////////////////////////////" + CRLF;
          s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
            + CRLF;
          System.out.println(s);
        }
      }
      //</editor-fold>
      System.out.print("cb.getValue() = ");
      String line = cb.getValue().trim();
      System.out.println(line);
      cb.setValue(line);
      File f = new File(line);
      if (f.exists()) {
        srclist.clear();
        switch (f.toString().toLowerCase().substring(f.toString().lastIndexOf(
          ".") + 1)) {
          case "txt": {
            ta.setText(readFile(f));
            texts = GlobalMethods.getLinesFromFile(f);
            String t;
            for (String text : texts) {
              if (text.startsWith("// ")) {
                t = text;
                srclist.add(t);
              }
            }
            break;
          }
          default: {
            System.out.println("ERROR");
          }
        }
      }
      cb2 = new ComboBox<>(srclist);
      System.out.println(updateLabels(line));
    }
    );
    //</editor-fold>

    srclist = FXCollections.observableArrayList();
    cb2 = new ComboBox<>(srclist);
    //<editor-fold defaultstate="collapsed" desc="cb2.setOnAction">
    cb2.setOnAction((ActionEvent e) -> {
      //<editor-fold defaultstate="collapsed" desc="IFD">
      {
        String s = "";
        boolean DEBUG = true;  // true or false;
        if (DEBUG) { // true or false
          s += "//////////////////////////////////////////////" + CRLF;
          s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
            + CRLF;
          System.out.println(s);
        }
      }
      //</editor-fold>
      System.out.println("" + " = " + e);
      System.out.println("e.getSource()" + " = " + e.getSource());
      System.out.println("e.getTarget()" + " = " + e.getTarget());
      System.out.println("e.getEventType()" + " = " + e.getEventType());
      System.out.println("e.hashCode()" + " = " + e.hashCode());
      for (int i = 0; i < texts.length; i++) {
        if (!texts[i].isEmpty()) {
          System.out.println("" + i + " = " + texts[i]);
        }
      }
      line = cb2.getValue();
      System.out.println("cb2.getValue() = " + line);
      new fx.filechooser.ShowFileChooser();
    });
    //</editor-fold>

//    String stylesheet = "file:///C://T5/TFX/src/fx/TravellerStylesheet.css";
//    setUserAgentStylesheet(stylesheet);
    HBox line3 = new HBox();
    line3.getChildren()
      .addAll(dir, file, ext);

    HBox line4 = new HBox();
    searchfor = new Label("search");
    line4.getChildren()
      .add(searchfor);

    ta = new TextArea();
//    ta.setText("");

    VBox root = new VBox();

    root.getChildren()
      .addAll(cb, cb2, line3, line4, ta);
    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle(
      "NoteIt");
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  String readFile(File f) {
    updateLabels(f.toString());
    return GlobalMethods.loadTextFile(f.toString());
  }

  private String updateLabels(String value) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
          + CRLF;
        System.out.println(s);
      }
    }
    //</editor-fold>
    String ret = "";
    if (value.contains(FS)) {
      if (value.contains(".")) {
        String d = value.substring(0, value.lastIndexOf(FS));
        if (!d.endsWith(FS)) {
          d += FS;
        }
        dir.setText(d);
        System.out.println("d" + " = " + d);
        String f = value.substring(value.lastIndexOf(FS) + 1, value.lastIndexOf(
          '.'));
        file.setText(f);
        System.out.println("f" + " = " + f);
        String e = value.substring(value.lastIndexOf('.'));
        ext.setText(e);
        System.out.println("e" + " = " + e);
        ret = dir.getText() + file.getText() + ext.getText();
        System.out.println("" + " = " + ret);
      }
    }
    return ret;
  }

}
