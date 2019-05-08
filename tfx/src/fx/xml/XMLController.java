/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.xml;

import dbviewer.ExtensionFileFilter;
import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalVariables.CRLF;
import static fx.xml.XML.csvtemplate;
import static fx.xml.XML.docroot;
import static fx.xml.XML.fullpathname;
import static fx.xml.XML.list;
import static fx.xml.XML.match;
import static fx.xml.XML.methods;
import static fx.xml.XML.templates;
import static fx.xml.XML.txttemplate;
import static fx.xml.XML.writeCSV;
import static fx.xml.XML.writeHTML;
import static fx.xml.XML.writeTXT;
import static fx.xml.XML.writeXML;
import static fx.xml.XML.writeXSL;
import static fx.xml.XML.xmltemplate;
import static fx.xml.XML.xsltemplate;
import java.io.BufferedReader;
import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JFileChooser;

/**
 FXML Controller class

 @author Mark Ferguson
 */
public class XMLController implements Initializable {

  @FXML
  private AnchorPane anchorpane;
  @FXML
  private Button button;
  @FXML
  private ComboBox<String> Template;
  @FXML
  private ComboBox<String> combo;
  @FXML
  private ComboBox<String> method;
  @FXML
  private Label label;
  @FXML
  private MenuBar menu;
  @FXML
  private TextArea textarea;
  @FXML
  private TextArea textarea1;
  @FXML
  private TextArea textarea2;
  @FXML
  private TextArea textarea3;
  @FXML
  private TextField textfield;
  @FXML
  private TextField TemplateText;

  /**

   @param args
   */
  public static void main(String[] args) {
    XML.main(args);
  }
  @FXML
  private Button xpbut;

  /**
   Initializes the controller class.
   @param url
   @param rb
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    System.out.println("initialize");
    label.setText(fullpathname);
    methods.add("html");
    methods.add("text");
    methods.add("xml");
    method.itemsProperty().setValue(methods);
    method.setValue(methods.get(0));
    combo.itemsProperty().setValue(list);
    combo.setValue(list.get(list.size() - 1));
    textfield.setText(match);
    templates.add("none");
    templates.add("comment");
    templates.add("textarea");
    templates.add("String[]");
    templates.add("Table");
    templates.add("CSV");
    //templates.add("file");
    templates.add("file");
    Template.itemsProperty().setValue(templates);
    Template.setValue(templates.get(templates.size() - 1));
    Template.setValue(templates.get(0));
    textarea.setText("");
    handleButtonAction(new ActionEvent());
  }

  @FXML
  private void comboChange(ActionEvent event) {
    System.out.println("comboChange");
    textfield.setText("/" + docroot.getTagName() + "/" + combo.getValue());
    if (!"".equals(textfield.getText().trim())) {
      match = textfield.getText().trim();
    }
    handleButtonAction(new ActionEvent());
  }

  @FXML
  private void handleButtonAction(ActionEvent event) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      String s = "";
      s += GlobalMethods.comment("=", 80) + CRLF;
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      s += "\t" + method + CRLF;
//      s += "" + " = " + "" + CRLF;
      System.out.print(s);
//      JOptionPane.showMessageDialog(null, s);
    }
    //</editor-fold>
    String smethod = "" + method.getValue();
    String match = textfield.getText();
    String template = TemplateText.getText();
    writeXSL(smethod, match, template);
    textarea.setText(xsltemplate);
    writeXML();
    textarea1.setText(xmltemplate);
    writeTXT();
    textarea2.setText(txttemplate);
    writeCSV();
    textarea3.setText(csvtemplate);
    writeHTML();
  }

  @FXML
  private void methodChange(ActionEvent event) {
    System.out.println("methodChange");
    handleButtonAction(new ActionEvent());
  }

  @FXML
  private void runxpath(ActionEvent event) {
    System.out.println("runxpath");
    fx.xpath.XPathTester.main(new String[]{""});
  }

  @FXML
  private void templateChange(ActionEvent event) {
    System.out.println("templateChange");
    String text = "";
    switch (Template.getValue()) {
      case ("none"): {
        text = "";
        break;
      }
      case ("comment"): {
        text = "<!-- TEMPLATE -->";
        break;
      }
      case ("textarea"): {
//        textarea.setText("TEXTAREA");
        text = textarea.getText();
        //text =
        break;
      }
      case ("file"): {
        text = loadText();
        label.setText(fullpathname);
//        TemplateText.setText(text);
        break;
      }
      default: {
        text = "SOON:";
      }
    }
    TemplateText.setText(text);
    handleButtonAction(new ActionEvent());
  }

  @FXML
  private void textChange(ActionEvent event) {
    System.out.println("textChange");
    handleButtonAction(new ActionEvent());
  }

  String loadText() {
    System.out.println("loadText");
//    label.setText("Loading");
    ExtensionFileFilter eff = new ExtensionFileFilter();
    eff.addExtension("xsl");
    eff.addExtension("xslt");
    eff.setDescription("XML Stylesheets");
    JFileChooser jfc = new JFileChooser();
    jfc.addChoosableFileFilter(eff);
    jfc.setAcceptAllFileFilterUsed(false);
    jfc.setFileFilter(eff);
    jfc.setCurrentDirectory(new File("C:/T5/_XML"));
    jfc.setSelectedFile(new File("*.xslt\n"));
    String line;
    String lines = "";
    try {
      int ret;
      if ((ret = jfc.showOpenDialog(null)) == JFileChooser.APPROVE_OPTION) {
        fullpathname = jfc.getSelectedFile().toString();
        label.setText(fullpathname);

        BufferedReader in = new BufferedReader(new FileReader(fullpathname));
        try {
          lines = "";
          while ((line = in.readLine()) != null) {
            lines += line;
          }
        } catch (IOException ex) {
          Logger.getLogger(XMLController.class.getName()).log(
            Level.SEVERE, null, ex);
        }
        in.close();
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(XMLController.class.getName()).log(Level.SEVERE,
        null, ex);
    } catch (IOException ex) {
      Logger.getLogger(XMLController.class.getName()).log(Level.SEVERE,
        null, ex);
    }
    handleButtonAction(new ActionEvent());
    return lines;
  }

  /**

   @return
   */
  public String getLabelText() {
    return label.getText();
  }

}
