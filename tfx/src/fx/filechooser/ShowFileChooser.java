/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.filechooser;

import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables.T5;
import java.io.File;
import java.nio.file.Path;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import panels.Panel4T5Locator;

/**

 @author Mark Ferguson
 */
public class ShowFileChooser extends Application {

  public static TextArea fileArea;

  public static void main(String[] args) {
    launch(args);
  }

  public ShowFileChooser() {
    super();
    this.len = 0;
    this.numend = 0;
    this.numstart = 0;
    this.name = new Label("");
    this.ext = new Label("");
    this.dir = new Label(T5);
    this.CRLF = "\n";
    this.selectedfile = "";
    this.pos = 0;
    //<editor-fold defaultstate="collapsed" desc="addLine">
    this.addLine = (ActionEvent event) -> {
      System.out.println("addLine");
      try {
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile.exists()) {
          selectedfile = selectedFile.toString();
          fileArea.appendText(selectedfile + CRLF);
          updateLabels(selectedfile);
        }
      } catch (Exception e) {
        System.out.println("61" + " = " + e);
      }
    };
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="dirEvent">
    this.dirEvent = (MouseEvent event) -> {
      System.out.println("dirEvent");
      System.out.println(dir.getText());
    };
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="extEvent">
    this.extEvent = (MouseEvent event) -> {
      System.out.println("extEvent");
      System.out.println(ext.getText());
    };
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="nameEvent">
    this.nameEvent = (MouseEvent event) -> {
      System.out.println("nameEvent");
      System.out.println(name.getText());
    };
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="openEvent">
    this.openEvent = (MouseEvent event) -> {
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
      String[] strings = null;
      try {
        //      System.out.println("openEvent");
        string = fileArea.getText();
        if (string.isEmpty()) {
          return;
        }
        strings = string.split(CRLF);
        lines = strings.length;
        //      System.out.println("lines" + " = " + lines);
        numstart = 0;
        numend = 0;
        pos = fileArea.getCaretPosition();
        for (int i = 0; i < lines; i++) {
          //        System.out.println("\tnumstart" + " = " + numstart);
          len = strings[i].length() + 1;
          numend += (len);
          //        System.out.println("\tnumend" + " = " + (numend));
          if (i < lines - 1) {
            numstart += (len);
          }
        }
        //      System.out.println("pos = " + pos);
        line = 0;
        for (int i = pos; i > -1; i--) {
          String s = string.substring(i, i + 1);
          if (CRLF.equals(s)) {
            line += 1;
          }
        }
        //      System.out.println("line" + " = " + line);
        //        System.out.println(strings[line]);
      } catch (Exception e) {
        System.out.println("130" + " = " + e);
      }
      updateLabels(strings[line]);
    };
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="saveEvent">
    this.saveEvent = (MouseEvent event) -> {
      System.out.println("saveEvent");
    };
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="showEvent">
    this.showEvent = (ActionEvent event) -> {
      System.out.println("showEvent");
      String string1 = fileArea.getText();
      String[] strings = string1.split(CRLF);
      line = 0;
      for (int i = 0; i < strings.length; i++) {

      }
      String let = "";
      for (int i = 0; i < string1.length(); i++) {
        let = string1.substring(i, i + 1);
        if (let.equals(CRLF)) {
          line += 1;
        }
        System.out.print(let);
      }
      assert (line == strings.length);
      int start = 0;
      int end = 0;
    };
    //</editor-fold>
  }

  public ShowFileChooser(String filelist) {
    this();
    System.out.println("filelist" + " = " + filelist);
    fileArea.setText(filelist);
  }

  private String CRLF;
  private final EventHandler<ActionEvent> addLine;
  private Label dir;
  private final EventHandler<? super MouseEvent> dirEvent;
  private int end;
  private Label ext;
  private final EventHandler<? super MouseEvent> extEvent;
  private FileChooser fileChooser;
  private ExtensionFilter filter;
  private int len;
  private int line;
  private int lines;
  private Label name;
  private final EventHandler<? super MouseEvent> nameEvent;
  private int numend;
  private int numstart;
  private final EventHandler<? super MouseEvent> openEvent;
  private Path path;
  private int pos;
  private final EventHandler<? super MouseEvent> saveEvent;
  private String selectedfile;
  private final EventHandler<ActionEvent> showEvent;
  private TextArea srcArea;
  private int start;
  private String string;

  @Override
  public void start(Stage primaryStage) {
    HBox line1 = new HBox();
    Button btn = new Button();
    btn.setText("Choose");
    btn.setOnAction(addLine);
    dir.setOnMouseClicked(dirEvent);
    dir.setId("dir");
    name.setOnMouseClicked(nameEvent);
    name.setId("name");
    ext.setOnMouseClicked(extEvent);
    ext.setId("ext");
    line1.getChildren().addAll(btn, dir, name, ext);

    HBox line2 = new HBox();
    Button btn2 = new Button("???");
    btn2.setOnAction(showEvent);
    line2.getChildren().addAll(btn2);

    VBox all = new VBox();
    fileArea = new TextArea("C:\\T5\\Backups.txt\n"
      + "C:\\T5\\CSV.csv\n"
      + "C:\\T5\\defaultProperties.ini\n");
    fileArea.setId("fileArea");
    fileArea.setOnMouseClicked(openEvent);
    srcArea = new TextArea();
    srcArea.setOnMouseClicked(saveEvent);
    all.getChildren().addAll(line1, line2, fileArea, srcArea);

    Scene scene = new Scene(all, 300, 600);
    scene.setUserAgentStylesheet(Panel4T5Locator.stylesheet);
    fileChooser = new FileChooser();
    fileChooser.setInitialDirectory(new File(dir.getText()));
    fileChooser.setInitialFileName(null);
    fileChooser.setTitle("Open Resource File");
    fileChooser.getExtensionFilters().addAll(
      new ExtensionFilter("All Files", "*.*"),
      new ExtensionFilter("Text Files", "*.txt", "*.csv", "*.html", "*.t5c", "*"),
      new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
      new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"));
    filter = fileChooser.getExtensionFilters().get(1);
    fileChooser.setSelectedExtensionFilter(filter);

    primaryStage.setTitle("Create File List");
    primaryStage.setScene(scene);
    primaryStage.setX(0);
    primaryStage.setY(0);
    primaryStage.show();
  }

  private void updateLabels(String p) {
    if (p.contains(FS) & p.contains(".")) {
      dir.setText(p.substring(0, p.lastIndexOf(FS) + 1));
      name.setText(p.substring(p.lastIndexOf(FS) + 1, p.lastIndexOf('.')));
      ext.setText(p.substring(p.lastIndexOf('.')));
    }
  }
}
