/*
 */
package fx.worldmap;

//import static hexer.AHexer.SouthPanel.CRLF;
import static dbviewer.globals.GlobalVariables.CRLF;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 @author Mark Ferguson
 */
public class WorldMapController implements Initializable {

  @FXML
  private Canvas Canvas;
  @FXML
  private ChoiceBox<Integer> Choice;
  @FXML
  private Button HexButton;
  @FXML
  private Label Label;
  @FXML
  private Label SizeLabel;
  @FXML
  private Label l4About;

  @FXML
  private void canvasClick(MouseEvent event) {
    drawBorder(gc);
    drawTriangles(gc);
    drawHexes(gc);
  }

  @FXML
  private void labelClick(MouseEvent event) {
    print(Canvas);
  }

  @FXML
  private void runHexButton(ActionEvent event) {
//    hexer.AHexer.main(args);
    dbviewer.Hexer.main(args);
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    Label.setText("PRINT");
    gc = Canvas.getGraphicsContext2D();
    for (int i = 0; i <= 25; i++) {
      Choice.getItems().add(i);
    }
    Choice.setOnAction(new EventHandlerImpl());
    Choice.setValue(5);
    worldsize = Choice.getValue();
    SizeLabel.setText("" + worldsize);
    draw();
  }

////////////////////////////////////////////////////////////////////////////////
  private String[] args = {""};
  private double h;
  private double w;
  private double pagewidth;
  private double worldsize;
  private double pageheight;
  private GraphicsContext gc;
  private double A;
  private double B;
  private double C;
  private double D;
  private int hexesX;
  private int hexesY;
  private double hw;
  private double hh;
  private double l3;
  private double l4;
  private double l5;
  private String scale = "100km";

  //<editor-fold defaultstate="collapsed" desc="old">
  private void drawTriangles() {
    gc.setLineWidth(0.25);
    gc.setStroke(Color.BLACK);
    hexesX = (int) ((3 * worldsize) + 1);
    hexesY = (int) ((5 * worldsize) + 1);
    h = pageheight / hexesY;
    gc.strokeText("100km Hexes", 10, 10);
    gc.strokeLine(A, h * 2.5, B, h * 0);
    gc.strokeLine(A, h * 7.5, D, h * 0);
    gc.strokeLine(A, h * 12.5, D, h * 5);
    gc.strokeLine(A, h * 17.5, D, h * 10);
    gc.strokeLine(A, h * 22.5, D, h * 15);
    gc.strokeLine(B, h * 25, D, h * 20);

    gc.strokeLine(B, h * 0, D, h * 5);
    gc.strokeLine(A, h * 2.5, D, h * 10);
    gc.strokeLine(A, h * 7.5, D, h * 15);
    gc.strokeLine(A, h * 12.5, D, h * 20);
    gc.strokeLine(A, h * 17.5, D, h * 25);
    gc.strokeLine(A, h * 22.5, B, h * 25);

    gc.strokeLine(B, h * 0, D, h * 0);
    gc.strokeLine(B, h * 25, D, h * 25);

    gc.strokeLine(B, h * 0, B, h * 25);
    gc.strokeLine(C, h * 0, C, h * 25);
    Boolean DEBUG = true;
  }

  private void drawHexes() {
    l4 = 1 + (Choice.getValue() * 3);
    l3 = l4 * 3 / 4;
    l5 = l3 * 5 / 3;
    gc.setStroke(Color.BLACK);

    double y = -(l5 + (l3 * 2) / 2) / 2;

    double x = -((l3 * 2) + l5) / 2;
    int size = 5;
    for (int j = 0; j < (3 * size) + 1; j++) {
      if (j % 2 == 0) {
        y -= l4;
      }
      for (int i = 0; i < 26; i++) {
        gc.strokeLine(0 + x, l4 + y, l3 + x, 0 + y);//a-b
        gc.strokeLine(l3 + x, 0 + y, l3 + l5 + x, 0 + y);//b-c
        gc.strokeLine(l3 + l5 + x, 0 + y, (l3 * 2) + l5 + x, l4 + y);//c-d
        gc.strokeLine((l3 * 2) + x + l5, l4 + y, l3 + l5 + x, l4 * 2 + y);//d-e
        gc.strokeLine(l3 + l5 + x, (l4 * 2) + y, l3 + x, l4 * 2 + y);//e-f
        gc.strokeLine(l3 + x, l4 * 2 + y, 0 + x, l4 + y);//e-f
        y += l4 * 2;
      }
      x += l4 * 2;
      y = -(l5 + (l3 * 2) / 2) / 2;
    }
  }

  //</editor-fold>
  private void clear() {
    gc.clearRect(0, 0, 1000, 1000);
  }

  public void print(final Node node) {
    Printer printer = Printer.getDefaultPrinter();
    PageLayout pageLayout = printer.createPageLayout(Paper.A4,
      PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);
    double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInParent()
      .getWidth();
    double scaleY = pageLayout.getPrintableHeight() / node.getBoundsInParent()
      .getHeight();
    node.getTransforms().add(new Scale(scaleX, scaleY));

    PrinterJob job = PrinterJob.createPrinterJob();
    if (job != null) {
      boolean success = job.printPage(node);
      if (success) {
        job.endJob();
      }
    }
  }

  private class EventHandlerImpl implements EventHandler<ActionEvent> {

    public EventHandlerImpl() {
    }

    private String CRLF = System.lineSeparator();

    @Override
    public void handle(ActionEvent event) {
      clear();
      Display();
    }

    private void Display() {
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
      SizeLabel.setText("" + Choice.getValue());
      worldsize = Choice.getValue();
      draw();
    }

  }

  private void drawBorder(GraphicsContext gc) {
    worldsize = Choice.getValue();
    hexesX = (int) (3 * worldsize);
    hexesY = (int) (5 * worldsize);

    l4 = (pageheight / hexesY) / 2;
    l3 = l4 * 3 / 4;
    l5 = l3 * 5 / 3;

    pageheight = 780; /// (worldsize * 5);
    w = (l3 * 2) + l5;
    pagewidth = (worldsize * 3 * w) - l4;

    double W = hexesX * w;
    A = 0;
    B = pagewidth / 4;
//    B = W / 4;
    C = pagewidth * 2 / 4;
//    C = W / 2;
    D = pagewidth * 3 / 4;
//    D = (W / 4 * 3) - l3;
    h = pageheight / hexesY; //24;

    gc.setStroke(Color.BLACK);
    gc.setLineWidth(1);

    gc.strokeLine(A, 0, D, 0);
    gc.strokeLine(A, 0, A, pageheight);
    gc.strokeLine(D, 0, D, pageheight);
    gc.strokeLine(A, pageheight, D, pageheight);
  }

  private void drawTriangles(GraphicsContext gc) {
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
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(1);

    gc.strokeText("100km Hexes", 10, 10);
    gc.strokeLine(A, h * 2.5, B, h * 0);
    gc.strokeLine(A, h * 7.5, D, h * 0);
    gc.strokeLine(A, h * 12.5, D, h * 5);
    gc.strokeLine(A, h * 17.5, D, h * 10);
    gc.strokeLine(A, h * 22.5, D, h * 15);
    gc.strokeLine(B, h * 25, D, h * 20);

    gc.strokeLine(B, h * 0, D, h * 5);
    gc.strokeLine(A, h * 2.5, D, h * 10);
    gc.strokeLine(A, h * 7.5, D, h * 15);
    gc.strokeLine(A, h * 12.5, D, h * 20);
    gc.strokeLine(A, h * 17.5, D, h * 25);
    gc.strokeLine(A, h * 22.5, B, h * 25);

    gc.strokeLine(B, h * 0, D, h * 0);
    gc.strokeLine(B, h * 25, D, h * 25);

    gc.strokeLine(B, h * 0, B, h * 25);
    gc.strokeLine(C, h * 0, C, h * 25);
  }

  private void drawHexes(GraphicsContext gc) {
    double y = -l4;
    double x = -((l3 * 2) + l5) / 2;
    for (int j = 0; j < hexesX + 1; j++) {
      if (j % 2 == 0) {
        y -= l4;
      }
      for (int i = 0; i < hexesY + 1; i++) {
        gc.strokeLine(0 + x, l4 + y, l3 + x, 0 + y);//a-b
        gc.strokeLine(l3 + x, 0 + y, l3 + l5 + x, 0 + y);//b-c
        gc.strokeLine(l3 + l5 + x, 0 + y, (l3 * 2) + l5 + x, l4 + y);//c-d
        gc.strokeLine((l3 * 2) + x + l5, l4 + y, l3 + l5 + x, l4 * 2 + y);//d-e
        gc.strokeLine(l3 + l5 + x, (l4 * 2) + y, l3 + x, l4 * 2 + y);//e-f
        gc.strokeLine(l3 + x, l4 * 2 + y, 0 + x, l4 + y);//e-f
        y += l4 * 2;
      }
      x += l4 * 2;
      y = -(l5 + (l3 * 2) / 2) / 2;
    }
  }

  private void draw() {
    drawBorder(gc);
    drawTriangles(gc);
    drawHexes(gc);
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

}
