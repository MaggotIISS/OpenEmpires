/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.counter;

import static dbviewer.globals.GlobalVariables.CRLF;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import panels.Panel4T5CounterMaker;
import static panels.Panel4T5CounterMaker.*;
import static panels.Panel4T5Locator.stylesheet;

/**

 @author Mark Ferguson
 */
public class Counter extends Application {

  //<editor-fold defaultstate="collapsed" desc="strings">
  public String[] strings = {"Clear", "Maker", "Text", "Three"};
  //</editor-fold>
  //<editor-fold defaultstate="collapsed" desc="counterTypes">
  private String[] counterTypes = {"Admiral", "Army", "Belts", "Blank",
    "Defences", "Equipment", "Fleet", "Gas Giants", "Marine", "Merchant", "Navy",
    "Other", "Orbitals", "Orbits", "Planets", "Population", "Scout", "SDBs",
    "Ship", "Stars", "Squadron", "Squadrons", "T5C", "Troop", "Troops",
    "Vehicle"};

  //</editor-fold>
  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  private int wid = 200;
  private int hgt = 100;
  private Canvas canvas;
  private GraphicsContext gc;
  private VBox vbox;
  private HBox hbox;
  private int x = 1;
  private String[] olds;
  private TextField[] tfs;
  private ComboBox<String> combo;
  private TextField field;
  private String[] array;

  @Override
  public void start(Stage primaryStage) {
    vbox = new VBox();
    vbox.setId("home");
    hbox = new HBox();
    hbox.setId("hbox " + x++);
    System.out.println(hbox.getId());
    combo = new ComboBox<>();
    combo.setPrefWidth(100);
    combo.getItems().addAll(counterTypes);
    combo.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        String txt = null;
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
        try {
          Panel4T5CounterMaker.Folder.setSelectedItem(combo.getValue());
          txt = Panel4T5CounterMaker.jLabel13.getText();
          txt = Panel4T5CounterMaker.jLabel13.getText();
        } catch (Exception e) {
          txt = "97 Caught";
        }
        setName(txt);
        System.out.println(getName());
      }
    });
    addName();
    System.out.println("addName");
    addColorPicker();
    System.out.println("addColorPicker");
    addCanvas();
    System.out.println("addCanvas");
    addFields();
    System.out.println("addFields");
    addButtons();
    System.out.println("addButtons");
    Scene scene = new Scene(vbox, 200, 500);
    scene.setUserAgentStylesheet(stylesheet);
    primaryStage.setTitle("Counter");
    primaryStage.setScene(scene);
    primaryStage.setX(600);
    primaryStage.setY(400);
    primaryStage.show();
    drawOutline();
    try {
      combo.setValue(Panel4T5CounterMaker.Folder.getSelectedItem().toString());
    } catch (Exception e) {
      System.out.println("e" + " = " + e);
      combo.setValue("World");
    }
  }

  private void addName() {
    field = new TextField();
    field.setPrefWidth(100);
    hbox.getChildren().addAll(combo, field);
    vbox.getChildren().add(hbox);
  }

  private void setName(String name) {
    field.setText(name);
  }

  private String getName() {
    return field.getText();
  }

  private void addCanvas() {
    canvas = new Canvas(wid, hgt);
    gc = canvas.getGraphicsContext2D();
    clear();
    colorSquare(Color.WHITE);
    gc.fillRect(0, 0, 200, 100);
    gc.fillRect(0, 0, 100, 100);
    canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        colorSquare(cp.getValue());
      }
    });
    vbox.getChildren().add(canvas);

  }

  private void addFields() {
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
    hbox = new HBox();
    tfs = new TextField[20];
    for (int i = 0; i < 10; i++) {
      System.out.println("i" + " = " + i);
      hbox = new HBox();
      tfs[(0 + i)] = new TextField();
      tfs[(0 + i)].setPrefWidth(100);
      tfs[(0 + i)].setTooltip(new Tooltip("tfs[" + i + "]"));
      tfs[(0 + i)].setOnAction(new EventHandler<ActionEvent>() {
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
        }
      });
      tfs[(10 + i)] = new TextField();
      tfs[(10 + i)].setPrefWidth(100);
      tfs[(10 + i)].setTooltip(new Tooltip("tfs[" + (10 + i) + "]"));
      tfs[(10 + i)].setOnAction(new EventHandler<ActionEvent>() {
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
        }
      });

      hbox.getChildren().addAll(tfs[i], tfs[10 + i]);
      hbox.setId("hbox " + x++);
      System.out.println(hbox.getId());
      vbox.getChildren().add(hbox);
    }
    for (int i = 0; i < 20; i++) {
      tfs[i].setText("tfs[" + i + "]");
    }

  }

  private void addButtons() {
    hbox = new HBox();
    int num = strings.length;
    for (int i = 0; i < strings.length; i++) {
      Button button = new Button("" + i);
      button.setId("button" + i);
      button.setPrefSize(wid / num, 25);
      button.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
          switch (button.getText()) {
            case "0": {
              // Clear
              clear();
              break;
            }
            case "1": {
              // Maker
              maker();
              break;
            }
            case "2": {
              // Text
              text();
              break;
            }
            case "3": {
              // InSitu
              Three();
              break;
            }
          }
        }

      });
      button.setTooltip(new Tooltip(strings[i]));
      hbox.getChildren().add(button);
    }
    hbox.setId("hbox " + x++);
    System.out.println(hbox.getId());
    vbox.getChildren().add(hbox);//hbox1
  }

  private ColorPicker cp;

  private void addColorPicker() {
    cp = new ColorPicker();
    cp.setPrefWidth(100);
    cp.setId("ColorPicker");
    cp.setOnAction(new EventHandler<ActionEvent>() {
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
        colorSquare(cp.getValue());
      }
    });
    vbox.getChildren().add(cp);
  }

  public void clear() {
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
    gc.setStroke(Color.WHITE);
    gc.clearRect(0, 0, wid, hgt);
    drawOutline();
    try {
      for (int i = 0; i < 20; i++) {
        tfs[i].setText("");
      }
    } catch (Exception e) {

    }
  }

  private void maker() {
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
    array = new String[20];
    try {
      array = new String[]{
        t1.getText(), t2.getText(), t3.getText(), t4.getText(), t5.getText(),
        t6.getText(), t7.getText(), t8.getText(), t9.getText(), t10.getText(),
        t11.getText(), t12.getText(), t13.getText(), t14.getText(),
        t15.getText(), t16.getText(), t17.getText(), t18.getText(),
        t19.getText(), t20.getText()};
    } catch (Exception e) {
      for (int i = 0; i < 20; i++) {
        array[i] = "" + i;
      }
    }
    System.out.println("array");
    for (int i = 0; i < array.length; i++) {
      System.out.println("array[" + i + "] = " + array[i]);
      tfs[i].setText(array[i]);
    }
  }

  private void text() {
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
    String txt = "";
    try {
      txt = Panel4T5CounterMaker.jLabel13.getText();
    } catch (Exception e) {
      txt = "1705";
    }
    setName(txt);
    System.out.println(getName());

  }

  private void Three() {
  }

  public void drawOutline() {
    gc.setStroke(Color.BLACK);
    gc.strokeLine(0, 0, wid, 0);
    gc.strokeLine(wid, 0, wid, hgt);
    gc.strokeLine(wid, hgt, 0, hgt);
    gc.strokeLine(0, hgt, 0, 0);
    gc.strokeLine(wid / 2, 0, wid / 2, hgt);
  }

  public void colorSquare(Color color) {
    gc.setFill(color);
    gc.fillRect(0, 0, wid / 2, hgt);
    drawOutline();
  }

}
