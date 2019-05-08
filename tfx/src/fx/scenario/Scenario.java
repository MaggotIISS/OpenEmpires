/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.scenario;

import dbviewer.globals.GlobalMethods;
import java.io.File;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import static panels.Panel4T5Locator.stylesheet;

/**

 @author Mark Ferguson
 */
public class Scenario extends Application {

  //<editor-fold defaultstate="collapsed" desc="variables">
  private String CRLF = System.lineSeparator();
  private String FS = File.separator;
  private final String T5;
  private Button button;
  private Button[] buttons;
  private String d;
  private String e;
  private String f;
  private String files;
  private String firsts;
  private HBox hbox;
  private Label label;
  private Label[] labels;
  private String links;
  private String notes;
  private int num = 0;
  private int prev = 0;
  private String relations;
  private String s;
  private final String scenarios;
  private String seconds;
  private int selected;
  private int[] selecteds;
  private String[] strings;
  private TextArea ta;
  private String text;
  private final TextArea textarea;
  private TextField textfield;
  private TextField[] textfields;
  private String[] texts;
  private String title;
  private TextField titleField;
  private VBox vbox;
  private String what;
  private String when;
  private String where;
  private String who;
  private String why;
  private String with;
  private String[] lines;
  //</editor-fold>

  /**
   @param args the command level arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  public Scenario() {
    this.FS = File.separator;
    this.CRLF = System.lineSeparator();
    this.T5 = "C:" + FS + FS + "T5";
    this.with = "";
    this.why = "";
    this.who = "";
    this.where = "";
    this.when = "";
    this.what = "";
    this.seconds = "";
    this.s = "";
    this.relations = "";
    this.notes = "";
    this.links = "";
    this.firsts = "";
    this.files = "";
    this.scenarios = T5 + FS + "_Scenarios" + FS;
    this.textarea = new TextArea();
  }

  @Override
  public void start(Stage primaryStage) {
    createScene();
    Scene scene = new Scene(vbox, 200, 500);
    scene.setUserAgentStylesheet(stylesheet);
    primaryStage.setTitle("SceneGen");
    primaryStage.setScene(scene);
    primaryStage.setX(1000);
    primaryStage.show();
  }

  private void createCommandButtons() {
    Button but;
    int num = 7;
    String[] tips = {"setSkyRig", "saveScenario", "openScenario", "readMindMap",
      "showVars", "writeCode"};
    for (int i = 0; i < num; i++) {
      but = new Button("" + i);
      but.setPrefWidth(300 / num);
      but.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          butClick(event);
        }

        private void butClick(ActionEvent event) {
          for (int j = 0; j < num; j++) {
            boolean value = event.toString().contains("'" + j + "'");
            if (value) {
              buttonClick(j);
            }
          }
        }

        private void buttonClick(int i) {
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
          System.out.println("button" + " = " + i);
          switch (i) {
            case 0: {
              setSkyRig();
              break;
            }
            case 1: {
              saveScenario();
              break;
            }
            case 2: {
              openScenario();
              break;
            }
            case 3: {
              readMindMap();
              break;
            }
            case 4: {
              showVars();
              break;
            }
            case 5: {
              writeCode();
              break;
            }
            default: {
              System.out.println("DEFAULT 181: i = " + i);
              break;
            }
          }
        }

      });
      try {
        but.setTooltip(new Tooltip(tips[i]));
      } catch (Exception e) {

      }
      hbox.getChildren().add(but);
      but.fire();
    }
  }

  private void createPartLines() {
    EventHandler<ActionEvent> buttonClick = new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        String evt = event.toString();
        text = evt.substring(evt.indexOf('\'') + 1, evt.lastIndexOf('\''));
        buttonClick(text);
      }

      private void buttonClick(String txt) {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        {
          String s = "";
          boolean DEBUG = true;  // true or false;
          if (DEBUG) { // true or false
            s += "//////////////////////////////////////////////" + CRLF;
            s += "\t" + Thread.currentThread().getStackTrace()[1]
              .getMethodName() + CRLF;
            //s += "" + " = " + CRLF;
            System.out.print(s);
          }
        }
        //</editor-fold>
        System.out.println(txt);
      }
    };
    EventHandler<MouseEvent> labelClick = new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        String evt = event.toString();
        String word = evt.substring(evt.indexOf("'") + 1, evt.lastIndexOf("'"));
        int end = 0;
        labelClick(word);
      }

      private void labelClick(String txt) {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        {
          String s = "";
          boolean DEBUG = true;  // true or false;
          if (DEBUG) { // true or false
            s += "//////////////////////////////////////////////" + CRLF;
            s += "\t" + Thread.currentThread().getStackTrace()[1]
              .getMethodName() + CRLF;
//            s += label.getId() + CRLF;
            //s += "" + " = " + CRLF;
            System.out.print(s);
          }
        }
        //</editor-fold>
        TextArea ta = new TextArea();
        ta.setText("");
        text = txt;
        textarea.setText(ta.getText());
      }
    };
    EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent event) {
        System.out.println(event.getText());
      }
    };
    EventHandler<ActionEvent> textEnter = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        textAction(event);
      }

      private void textAction(ActionEvent event) {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        {
          String s = "";
          boolean DEBUG = true;  // true or false;
          if (DEBUG) { // true or false
            s += "//////////////////////////////////////////////" + CRLF;
            s += "\t" + Thread.currentThread().getStackTrace()[1]
              .getMethodName() + CRLF;
            //s += "" + " = " + CRLF;
            System.out.print(s);
          }
        }
        //</editor-fold>
        TextField textfield = new TextField();
        switch (event.toString()) {
          case "Who": {
            s = who;
            break;
          }
          case "What": {
            s = what;
            break;
          }
          case "Why": {
            s = why;
            break;
          }
          case "Where": {
            s = where;
            break;
          }
          case "When": {
            s = when;
            break;
          }
          case "With": {
            s = with;
            break;
          }
          default: {
            System.out
              .println("DEFAULT: event.toString() = " + event.toString());
            break;
          }
        }
        if (!"".equals(textfield.getText())) {
          s += textfield.getText() + CRLF;
        }
        s.trim();
        System.out.println("s" + " = " + s);
        textfield.setText("");
        switch (textfield.getId()) {
          case "Who": {
            who = s;
            break;
          }
          case "What": {
            what = s;
            break;
          }
          case "Why": {
            why = s;
            break;
          }
          case "Where": {
            where = s;
            break;
          }
          case "When": {
            when = s;
            break;
          }
          case "With": {
            with = s;
            break;
          }
          default: {
            System.out.println("DEFAULT 345: txt = " + textfield.getId());
            break;
          }
        }
        textarea.setText(s);
      }
    };
    EventHandler<MouseEvent> fieldClick = new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        textClick(event);
      }

    };
    buttons = new Button[texts.length];
    labels = new Label[texts.length];
    textfields = new TextField[texts.length];
    selecteds = new int[texts.length + 2];
    //<editor-fold defaultstate="collapsed" desc="for (int i = 0; i < texts.length; i++)">
    for (int i = 0; i < texts.length; i++) {
      // hbox
      text = texts[i];
      hbox = new HBox();
      hbox.setId(texts[i] + " " + i);
      // button
      button = new Button(texts[i]);
      button.setId(texts[i]);
      button.setPrefWidth(60);
      button.setOnAction(buttonClick);
      buttons[i] = button;
      hbox.getChildren().add(button);
      //label
      label = new Label(texts[i]);
      label.setId(texts[i]);
      label.setPrefSize(50, 25);
      label.setAlignment(Pos.CENTER);
      label.setOnMouseClicked(labelClick);
      labels[i] = label;
      hbox.getChildren().add(label);
      //textfield
      textfield = new TextField("");
      textfield.setId(texts[i]);
      textfield.setPrefSize(100, 25);
      textfield.setPromptText(texts[i]);
      textfield.setText("");
      textfield.setAlignment(Pos.CENTER_RIGHT);
      textfield.setPromptText(texts[i]);
      textfield.setOnAction(textEnter);
      textfield.setOnKeyPressed(keyPressed);
      textfield.setOnMouseClicked(fieldClick);
      textfields[i] = textfield;
      hbox.getChildren().add(textfield);
      vbox.getChildren().add(hbox);
    }
    //</editor-fold>
  }

  private void createScene() {
    texts = new String[]{"Who", "What", "Why", "Where", "When", "With"};
    title = "SkyRig";

    vbox = new VBox();
    hbox = new HBox();

    createTitleField();
    vbox.getChildren().add(titleField);

    hbox = new HBox();
    createCommandButtons();

    vbox.getChildren().add(hbox);
    createPartLines();

    textarea.setPrefHeight(500);
    vbox.getChildren().add(textarea);
  }

  private void createTitleField() {
    titleField = new TextField(title);
    titleField.setPrefWidth(200);
    titleField.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        {
          String s = "";
          boolean DEBUG = true;  // true or false;
          if (DEBUG) { // true or false
            s += "//////////////////////////////////////////////" + CRLF;
            s += "\t" + Thread.currentThread().getStackTrace()[1]
              .getMethodName() + CRLF;
            //s += "" + " = " + CRLF;
            System.out.print(s);
          }
        }
        //</editor-fold>
        title = titleField.getText();
      }
    });
    titleField.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        {
          String s = "";
          boolean DEBUG = true;  // true or false;
          if (DEBUG) { // true or false
            s += "//////////////////////////////////////////////" + CRLF;
            s += "\t" + Thread.currentThread().getStackTrace()[1]
              .getMethodName() + CRLF;
            //s += "" + " = " + CRLF;
            System.out.print(s);
          }
        }
        //</editor-fold>
        title = titleField.getText();
      }
    });
    titleField.setOnKeyTyped(new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent event) {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        {
          String s = "";
          boolean DEBUG = true;  // true or false;
          if (DEBUG) { // true or false
            s += "//////////////////////////////////////////////" + CRLF;
            s += "\t" + Thread.currentThread().getStackTrace()[1]
              .getMethodName() + CRLF;
            //s += "" + " = " + CRLF;
            System.out.print(s);
          }
        }
        //</editor-fold>
        title = titleField.getText();
      }
    });
  }

  private void embold(int num) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        //s += "" + " = " + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
//        System.out.println("it" + " = " + num);
    labels[num].setFont(Font.font("System", FontWeight.BOLD, 12));
  }

  private void openScenario() {
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
    d = scenarios;
    FileChooser fc = new FileChooser();
    fc.setInitialDirectory(new File(d));
    fc.setInitialFileName(f);
    fc.setSelectedExtensionFilter(new ExtensionFilter("Text Files", "*.txt"));
    File selectedfile = fc.showOpenDialog(null);
//    System.out.println(selectedfile.toString());
    d = selectedfile.getAbsolutePath().substring(0,
      selectedfile.getAbsolutePath().lastIndexOf(FS));
    f = selectedfile.getName().substring(0, selectedfile.getName().length() - 4);
    e = ".txt";
    String[] lines = GlobalMethods.loadTextFile(d, f, e).split(CRLF);
    int x = 0;
    selecteds = new int[texts.length + 1];
    for (int i = 0; i < lines.length; i++) {
      if ((lines[i].toUpperCase().equals(lines[i])) & (!lines[i].equals(""))) {
        System.out.println("" + lines[i] + " @ " + i);
        selecteds[x] = i + 1;
        System.out.println("\t" + lines[selecteds[x]] + " @ " + (i + 1));
        x += 1;
      }
    }
    title = "";
    who = "";
    what = "";
    why = "";
    where = "";
    when = "";
    with = "";
    title += lines[2];
    titleField.setText(title);
    int num = 0;
    for (int i = 0; i < lines.length; i++) {
      if (!"".equals(lines[i])) {
        if (lines[i].toUpperCase().equals(lines[i])) {
          selecteds[num] = i + 1;
          num += 1;
        }
      }
    }
    for (int i = 0; i < selecteds.length; i++) {
      String string = "";
      int from = 0;
      int to = 0;
      try {
        from = selecteds[i];
        to = (selecteds[i + 1] - 2);
        System.out.println("from " + from + " to " + to);
        for (int j = from; j < to; j++) {
          string += lines[j] + CRLF;
        }
      } catch (Exception e) {
        System.out.println(
          "from " + selecteds[i] + ": to " + (lines.length - 1));
        string += lines[lines.length - 1] + CRLF;
      }
      switch (i) {
        case 0: {
          title = string;
          break;
        }
        case 1: {
          who = string;
          break;
        }
        case 2: {
          what = string;
          break;
        }
        case 3: {
          why = string;
          break;
        }
        case 4: {
          where = string;
          break;
        }
        case 5: {
          when = string;
          break;
        }
        case 6: {
          with = string;
          break;
        }
        default: {
          break;
        }
      }
    }

    System.out.println("title = " + title);
    System.out.println("who = " + who);
    System.out.println("what = " + what);
    System.out.println("why = " + why);
    System.out.println("where = " + where);
    System.out.println("when = " + when);
    System.out.println("with = " + with);
  }

  private void saveScenario() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        //s += "" + " = " + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    d = scenarios + title + FS;
    f = title;
    e = "txt";
    System.out.println("saveScenario()" + " = " + d + f + "." + e);
    TextArea ta = new TextArea();
    ta.setText("" + d + f + "." + e + CRLF);
    ta.appendText("TITLE" + CRLF);
    ta.appendText("" + titleField.getText().trim() + CRLF);
    ta.appendText("" + CRLF);
    ta.appendText("WHO" + CRLF);
    ta.appendText("" + who.trim() + CRLF);
    ta.appendText("" + CRLF);
    ta.appendText("WHAT" + CRLF);
    ta.appendText("" + what.trim() + CRLF);
    ta.appendText("" + CRLF);
    ta.appendText("WHY" + CRLF);
    ta.appendText("" + why.trim() + CRLF);
    ta.appendText("" + CRLF);
    ta.appendText("WHERE" + CRLF);
    ta.appendText("" + where.trim() + CRLF);
    ta.appendText("" + CRLF);
    ta.appendText("WHEN" + CRLF);
    ta.appendText("" + when.trim() + CRLF);
    ta.appendText("" + CRLF);
    ta.appendText("WITH" + CRLF);
    ta.appendText("" + with.trim() + CRLF);
    ta.appendText("" + CRLF);
    File dir = new File(d);
    if (!dir.exists()) {
      dir.mkdirs();
    }
    String[] lines = ta.getText().split(CRLF);
//    for (int i = 0; i < lines.length; i++) {
//      System.out.println("" + " = " + lines[i]);
//    }
    GlobalMethods.saveTextFile(d, f, e, lines);
//    System.out.println("" + " = " + ta.getText());
  }

  private void readMindMap() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        //s += "" + " = " + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    d = "C:/T5/TFX/src/fx/scenario/";
    f = "Scenario";
    e = "txt";
    text = GlobalMethods.loadTextFile(d, f, e);
    strings = text.split(CRLF);
    for (int i = 0; i < strings.length; i++) {
      if (strings[i].contains("==")) {
        title = " " + strings[i - 1] + CRLF;
      }
      if (strings[i].contains("#")) {
        notes += strings[i] + CRLF;
      }
      if (strings[i].contains("--")) {
        firsts += strings[i - 1] + CRLF;
      }
      if (strings[i].contains("..")) {
        seconds += strings[i - 1] + CRLF;
      }
      if (strings[i].contains("Related to:")) {
        relations += strings[i] + CRLF;
      }
      if (strings[i].contains("FILE:")) {
        files += strings[i] + CRLF;
      }
      if (strings[i].contains("URL:")) {
        links += strings[i] + CRLF;
      }
    }
    ta = new TextArea();
    ta.setText(text);
    lines = ta.getText().split(CRLF);
    String out = "";
    String t = "";
    for (int i = 0; i < lines.length; i++) {
      if (lines[i].contains("--")) {
      } else if (lines[i].contains("..")) {
      } else if ("".equals(lines[i])) {
      } else if (lines[i].contains("Related to:")) {
      } else if (lines[i + 1].contains("..")) {
        t = "" + i + "-" + countSpace(lines[i]);
        out += t + CRLF;
      }
    }
    out += "  title" + " = \n" + title;
//    out += "relations" + " = " + relations;
//    out += "files" + " = " + files;
//    out += "links" + " = " + links;
//    out += "notes" + " = " + notes;
    out += "  firsts" + " = \n" + firsts;
//    out += "seconds" + " = " + seconds;
    System.out.println(out);
  }

  private void showVars() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        //s += "" + " = " + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    String[] vars = new String[]{d, f, e, notes,
      relations, files, links, firsts, seconds};
    String all = "";
    for (int i = 0; i < vars.length; i++) {
      String t = vars[i];
      all += t + CRLF;
    }
//    all += "notes" + " = " + notes + CRLF;
//    all += "relations" + " = " + relations + CRLF;
//    all += "files" + " = " + files + CRLF;
//    all += "links" + " = " + links + CRLF;
//    all += "title" + " = " + title + CRLF;
//    all += "firsts" + " = " + firsts + CRLF;
//    all += "seconds" + " = " + seconds + CRLF;
    System.out.println(all);
  }

  private void setSkyRig() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        //s += "" + " = " + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    who = "Carl" + CRLF + "Terri" + CRLF + "Andi" + CRLF + "Nool" + CRLF
      + "Grinder" + CRLF + "Raoul" + CRLF + "Max" + CRLF + "" + CRLF;
    what = "Captain" + CRLF + "Navigator" + CRLF + "Doctor" + CRLF + "Trader"
      + CRLF + "2ndEng." + CRLF + "Chief" + CRLF;
    why = "Trade/Repair";
    where = "Regina";
    when = "Hour = 23";
    with = "SkyRig";
    title = "SkyRig";
    titleField.setText(title);
    textarea.setText(who);
//    MouseEvent me = null;
//    textClick(me);
    prev = 0;
  }

  private void textClick(MouseEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        //s += event.toString() + CRLF;
        s += event.getSource().toString() + CRLF;
        //s += (TextField)
        System.out.print(s);
      }
    }
    //</editor-fold>
    prev = num;
    updateTexts(prev);
    String info = event.getSource().toString();
    if (info.contains("id=Who")) {
      num = 0;
      s = who;
    } else if (info.contains("id=What")) {
      num = 1;
      s = what;
    } else if (info.contains("id=Why")) {
      num = 2;
      s = why;
    } else if (info.contains("id=Where")) {
      num = 3;
      s = where;
    } else if (info.contains("id=When")) {
      num = 4;
      s = when;
    } else if (info.contains("id=With")) {
      num = 5;
      s = with;
    }
    textarea.setText(s);
    unboldAll();
    embold(num);
    System.out.println("num = " + num);
    System.out.println("prev = " + prev);
  }

  private void unboldAll() {
    //<editor-fold defaultstate="collapsed" desc="IFD">
    {
      String s = "";
      boolean DEBUG = true;  // true or false;
      if (DEBUG) { // true or false
        s += "//////////////////////////////////////////////" + CRLF;
        s += "\t" + Thread.currentThread().getStackTrace()[1]
          .getMethodName() + CRLF;
        //s += "" + " = " + CRLF;
        System.out.print(s);
      }
    }
    //</editor-fold>
    Font font = Font.getDefault();
    Font f = Font.font("System", FontWeight.NORMAL, 12);
    for (int j = 0; j < texts.length; j++) {
      labels[j].setFont(f);
    }
  }

  private void updateTexts(int prev) {
    switch (prev) {
      case 0: {
        who = textarea.getText();
        break;
      }
      case 1: {
        what = textarea.getText();
        break;
      }
      case 2: {
        why = textarea.getText();
        break;
      }
      case 3: {
        where = textarea.getText();
        break;
      }
      case 4: {
        when = textarea.getText();
        break;
      }
      case 5: {
        with = textarea.getText();
        break;
      }
      default: {
        System.out.println("DEFAULT 995: prev = " + prev);
        break;
      }
    }
  }

  private void writeCode() {
    String[] lines;
    lines = text.split(CRLF);
    String t = "";
    String out = "";
    for (int i = 0; i < lines.length; i++) {
      try {
        if ("".equals(lines[i])) {
        } else if (lines[i].contains("..")) {
        } else if (lines[i].contains("--")) {
        } else if (lines[i].contains("Related to:")) {
        } else if (lines[i + 1].contains("..") | lines[i + 1].contains("--")) {
          t = "line " + i + "-" + countSpace(lines[i]) + " spaces = ";
          out += t + lines[i] + CRLF;
        }
      } catch (Exception e) {

      }
    }
    countLevels();
    System.out.println("out" + " = \n" + out);
  }

  private int countSpace(String line) {
    int num = 0;
    for (int i = 0; i < line.length(); i++) {
      if (line.substring(i, i + 1).equals(" ")) {
        num += 1;
      } else {
        break;
      }
    }
    return num;
  }

  private void countLevels() {
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
    //<editor-fold defaultstate="collapsed" desc="old">
    String level = "";
    String[] lines = text.split(CRLF);
    // find highest number of spaces
    int max = 0;
    for (int i = 0; i < lines.length; i++) {
      if (countSpace(lines[i]) > 0) {
        if (lines[i].contains("..")) {
        } else if (lines[i].contains("--")) {
        } else if (countSpace(lines[i]) > max) {
          max = countSpace(lines[i]);
        }
      }
    }
    max -= 1;
    System.out.println("max" + " = " + max);

    ObservableList<String> ones = FXCollections.observableArrayList();
    ObservableList<String> twos = FXCollections.observableArrayList();
    ObservableList<String> threes = FXCollections.observableArrayList();
    ObservableList<String> fours = FXCollections.observableArrayList();
    String[] levels = new String[max];
    for (int i = 0; i < lines.length; i++) {
      if (!lines[i].contains("..") & !lines[i].contains("--")) {
        if ((lines[i].contains("(") | (lines[i].toUpperCase().equals(lines[i])))) {
          if (countSpace(lines[i]) == 1) {
            ones.add("" + i);
          }
        }
      }
    }
    //</editor-fold>
    String out = "";
    String d = T5 + FS + "TFX" + FS + "src" + FS;
    String src = "fx" + FS + "scenario";
    int start = 0;
    int end = 0;
    String outer = "";
    String name = "";
    for (int i = 0; i < ones.size(); i++) {
      String line = lines[Integer.parseInt(ones.get(i))];
      start = Integer.parseInt(ones.get(i)) + 1;
      end = 0;
      try {
        end = Integer.parseInt(ones.get(i + 1));
      } catch (Exception e) {
        end = lines.length - 1;
      }
      try {
        out += line.substring(0, line.indexOf("(")).trim() + CRLF;
      } catch (Exception e) {
        out += line.trim() + CRLF;
      }
      outer = "";
      for (int j = start; j < end; j++) {
        out = "";
        if (!lines[j].contains("..") & !lines[j].contains("--") & !lines[j]
          .isEmpty() & !lines[j].contains("Related to:")) {
          if (countSpace(lines[j]) == 4) {
            outer += "       " + lines[j].trim() + CRLF;
            out += outer;
          }
          if (countSpace(lines[j]) == 3) {
            outer += "     " + lines[j].trim() + CRLF;
            out += outer;
          }
          if (countSpace(lines[j]) == 2) {
            outer += "   " + lines[j].trim() + CRLF;
            out += outer;
          }
        }
        try {
          name = lines[start - 1].substring(0, lines[start - 1].indexOf("("))
            .trim();
        } catch (Exception e) {
          name = lines[start - 1].trim();
        }
      }
      System.out.println("d+src" + " = " + d + src + "/" + name + ".txt");
      GlobalMethods.saveTextFile(d + src, name, ".txt", outer);
      createSceneGen();
    }
    System.out.println(out);
  }

  private void createSceneGen() {
    String[] parts = {"Who", "What", "Why", "Where", "When", "With", "Deatils"};
  }

}
