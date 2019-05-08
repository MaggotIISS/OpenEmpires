/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package fx.xml;

import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalVariables.CSV;
import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables.T5;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import panels.Panel4T5Locator;
import static panels.Panel4T5Locator.stylesheet;
import panels.Panel4T5Scripting;

/**

 @author Mark Ferguson
 */
public class XML extends Application {

  //<editor-fold defaultstate="collapsed" desc="variables">
  static String out = "";
  static String childs = "";
  static String CRLF = "\r\n";
  static String XSLTemplate = ""
    //    + "<?xml version=\"1.0\"?>\n"
    + "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n"
    + "  <xsl:output method=\"METHOD\">\n"
    + "    <xsl:template match=\"MATCH\">\n"
    + "      <!-- TEMPLATE -->\n"
    + "    </xsl:template>\n"
    + "  </xsl:output>\n"
    + "</xsl:stylesheet>\n";
  static ObservableList<String> list = FXCollections.observableArrayList();
  static ObservableList<String> methods = FXCollections.observableArrayList();
  static ObservableList<String> templates = FXCollections.observableArrayList();
  static String fullpathname = "C:/T5/_XML/T5Elements.xml";
  static String match = "/tas/system";
  static Element docroot;
  static String template = "<!-- TEMPLATE -->";
  static String[] methodss = {"html", "text", "xml"};
  static String methodname = methodss[1];//html//text//xml
  static String xsltemplate = "XSL";
  static String xmltemplate = "XML";
  static String txttemplate = "TXT";
  static String csvtemplate = "CSV";

  /**

   */
  public static Scene scene;
  static Parent root;
  /*
   set variables
   */
  static String comment = "Comment", title = "Title", xmldoc = "xmlDoc",
    xsldoc = "xslDoc", scripts = "Scripts", header = "Header",
    heading = "Heading", picpath = "PicPath", picture = "Picture",
    width = "Width", height = "Height", picalt = "PicAlt", intro = "Intro",
    text = "Text", footnote = "Footnote", footer = "Footer";
  static String[] parts = {comment, title, xmldoc, xsldoc, scripts, header,
    heading,
    picpath, picture, width, height, picalt, intro, text, footnote, footer};
  static String[] uppervalues = new String[parts.length];
  static String[] lowervalues = new String[parts.length];
  static String folder = T5 + FS + "_XML";
  static String input = GlobalMethods.loadTextFile(folder, "Default", "html");
  static String page = "";
  static String ref = "C:/T5/_XML/XML.xml";
  //</editor-fold>

  @Override
  public void start(Stage stage) throws Exception {
    System.out.println("start");
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    File f = new File(fullpathname);
    Document doc = builder.parse(f);
    checkXML(doc);
    root = FXMLLoader.load(getClass().getResource("XML.fxml"));
    scene = new Scene(root);
    stage.setScene(scene);

    System.out.println("stylesheet" + " = " + stylesheet);
    scene.setUserAgentStylesheet(stylesheet);
    XML1.main(new String[]{""});
    stage.show();
  }

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    System.out.println("main");
    launch(args);
  }

  private void checkXML(Document doc) {
    System.out.println("checkXML");
    String fill = "";
    for (int i = 0; i < 60; i++) {
      fill += "/";
    }
    docroot = doc.getDocumentElement();
    out += "<" + docroot.getTagName() + ">" + CRLF;
    NodeList children = docroot.getChildNodes();
    for (int i = 0; i < children.getLength(); i++) {
      Node child = children.item(i);
      if (child instanceof Element) {
        Element childElement = (Element) child;
        list.add(child.getNodeName().trim());
        out += "  <" + child.getNodeName();
        if (child.hasAttributes()) {
          NamedNodeMap nnm = child.getAttributes();
          for (int j = 0; j < nnm.getLength(); j++) {
            out += " " + nnm.item(j);
          }
        }
        out += ">" + CRLF;
        NodeList kinder = child.getChildNodes();
        for (int j = 0; j < kinder.getLength(); j++) {
          Node kind = kinder.item(j);
          if (kind instanceof Element) {
            out += "    <" + kind.getNodeName();
            if (kind.hasAttributes()) {
              NamedNodeMap nnm = kind.getAttributes();
              for (int k = 0; k < nnm.getLength(); k++) {
                out += " " + nnm.item(k);
              }
            }
            out += ">" + kind.getTextContent() + "</" + kind
              .getNodeName() + ">" + CRLF;
          }
        }
        out += "  </" + child.getNodeName() + ">" + CRLF + fill + CRLF;
      }
    }
    out += "</" + docroot.getTagName() + ">" + CRLF;
    for (int i = 0; i < docroot.getChildNodes().getLength(); i++) {
      Node child = children.item(i);
      if (child instanceof Element) {
        Element childElement = (Element) child;
        childs += "  " + child.getNodeName() + CRLF;
      }
    }
  }

  /**

   @param scene
   @return
   */
  public Scene getScene(Scene scene) {
    try {
      root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    } catch (IOException ex) {
      Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
    }
    scene = new Scene(root);
    return scene;
  }

  static void writeXSL(String method, String match, String template) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = false;
    if (DEBUG) { // true or false
      String s = "";
      s += GlobalMethods.comment("=", 80) + CRLF;
      String meth = Thread.currentThread().getStackTrace()[1].getMethodName();
      s += "\t" + meth + CRLF;
      //      s += "" + " = " + "" + CRLF;
      System.out.print(s);
      //      JOptionPane.showMessageDialog(null, s);
    }
    //</editor-fold>
    String text = "";
    text += "method = " + method + CRLF;
    text += "match = " + match + CRLF;
    text += "template = " + template + CRLF;
    System.out.print(text);
//    JOptionPane.showMessageDialog(null, text);
    xsltemplate = XSLTemplate
      .replace("METHOD", method)
      .replace("MATCH", match)
      .replace("<!-- TEMPLATE -->", template);

    File out = new File("C:/T5/_XML/XSL.xsl");
    if (out.exists()) {
      System.out.println("rewriting " + out.toString());
    } else {
      System.out.println("creating " + out.toString());
    }
    template = xsltemplate.replace("<?xml version=\\\"1.0\\\" ?>\\n", "").trim();
    System.out.println("newtemplate = " + xsltemplate);
    System.out.println(out.toPath().toString());
    try {
      FileWriter fw = new FileWriter(out);
      fw.append(template);
      fw.close();
    } catch (IOException ex) {
      Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  static void writeSector(String csv) {
    for (int i = Panel4T5Locator.world1; i < Panel4T5Locator.lines.length; i++) {
      csv += "\"" + Panel4T5Locator.lines[i].substring(0, 4) + "\"";
      csv += CRLF;
    }
    GlobalMethods.saveTextFile(CSV, Panel4T5Locator.jcb4Sec.getSelectedItem()
      .toString().trim(), ".csv", csv);
    GlobalMethods.saveTextFile(T5 + FS + "_XML", "CSV", ".csv", csv);
    csv += GlobalMethods.comment("=", 80);

  }

  static void writeSubs(String csv) {

    for (int i = 0; i < Panel4T5Locator.jcb4Sub.getItemCount(); i++) {
      csv = "";
//      Panel4T5Locator.jcb4Sub.setSelectedIndex(i);
//      for (int j = 0; j < Panel4T5Locator.jcb4Sys.getItemCount(); j++) {
//        Panel4T5Locator.addSystems();
//        Panel4T5Locator.jcb4Sys.setSelectedIndex(j);
//        Panel4T5Locator.createSubPic();
//        csv += "\"" + Panel4T5Locator.jcb4Sys.getItemAt(j).substring(
//          0, 4) + "\"";
//        csv += CRLF;
//      }
//      GlobalMethods.saveTextFile(CSV, Panel4T5Locator.jcb4Sub.getSelectedItem()
//        .toString().trim(), ".csv", csv);
//      GlobalMethods.saveTextFile(T5 + FS + "_XML", Panel4T5Locator.jcb4Sub
//        .getSelectedItem().toString().trim(), ".csv", csv);
//      csv += GlobalMethods.comment("-", 80);
    }
    csv += GlobalMethods.comment("=", 80);
  }

  private static void writeSystem() {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    //DEBUG = false;
    if (DEBUG) { // true or false
      System.out.print(GlobalMethods.comment("=", 80));
      System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
        .getMethodName());
      //System.out.println("DEBUG" + " = " + DEBUG);
    }
    //</editor-fold>
    String s = "\"" + Panel4T5Locator.data[0].substring(6) + "\"";
    String folder = T5 + FS + "_XML";
    GlobalMethods.saveTextFile(folder, "CSV", ".csv", s);
    Panel4T5Scripting.csvName.setText(folder + FS + "CSV" + ".csv");
    Panel4T5Scripting.CSV.setText(s);
  }

  static void writeXML() {
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
  }

  static void writeTXT() {

  }

  static void writeCSV() {
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
    String csv = "";
    int num = 0;
    try {
      num = Panel4T5Locator.jcb4Sub.getSelectedIndex();
//    writeSector(csv);
      writeSubs(csv);
//    writeSystem();
      Panel4T5Locator.jcb4Sub.setSelectedIndex(num);
      Panel4T5Locator.addSystems();
    } catch (Exception e) {
      num = 0;
    }
  }

  static void writeHTML() {
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
    /*
     set desired change words to UPPERCASE
     */
    for (int i = 0; i < parts.length; i++) {
//      System.out.println(parts[i]);
      uppervalues[i] = parts[i].toUpperCase();
//      System.out.println(uppervalues[i]);
      lowervalues[i] = parts[i].toLowerCase();
//      System.out.println(lowervalues[i]);
//      System.out.println("////////////////////////////////////////////////");
//      input = input.replace(uppervalues[i], uppervalues[i]);
    }
    //<editor-fold defaultstate="collapsed" desc="comment">
    /*
     00 COMMENT
     01 TITLE
     02 XMLDOC
     03 XSLDOC
     04 SCRIPTS
     05 HEADER
     06 HEADING

     07 PICPATH
     08 WIDTH
     09 HEIGHT
     10 PICALT

     11 INTRO
     12 TEXT

     13 FOOTNOTE
     14 FOOTER
     */
 /*
     set xmldoc & xsldoc, then Clear header, footnote & footer
     */
    //</editor-fold>
    input = input.replace(uppervalues[0], "COMMENT");//comment
    input = input.replace(uppervalues[1], "TITLE");//comment
    input = input.replace(uppervalues[2], "\"XML.xml\"");//xmlDoc
    input = input.replace(uppervalues[3], "\"XSL.xsl\"");//xslDoc
//    input = input.replace(uppervalues[4], "");//scripts
    input = input.replace(uppervalues[5], "");//header
//    input = input.replace(uppervalues[6], "");//heading
//    input = input.replace(uppervalues[7], "");//picpath
//    input = input.replace(uppervalues[8], "");//width
//    input = input.replace(uppervalues[9], "");//height
//    input = input.replace(uppervalues[10], "");//picalt
//    input = input.replace(uppervalues[11], "");//intro
//    input = input.replace(uppervalues[12], "");//intro
//    input = input.replace(uppervalues[13], "");//text
    input = input.replace(uppervalues[14], "");//footnote
    input = input.replace(uppervalues[15], "");//footer
    //<editor-fold defaultstate="collapsed" desc="comment">
    /*
     CSV.csv
     Default.html
     DTD.dtd
     HTML.html
     TEXT.txt
     XML.xml
     XSL.xsl
     // FileListing.txt
     // T5Elements.dtd
     // T5Elements.xml
     */
    //    for (int i = 0; i < uppervalues.length; i++) {
    //      System.out.println("" + uppervalues[i]);
    //    }

    //</editor-fold>
//    System.out.println(input);
    //<editor-fold defaultstate="collapsed" desc="comment">
    /*
     Show nicely
     */
    //    JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(input, 40,
    //      40)));
    /*
     SAVE TO DISK
     */
    //</editor-fold>
    String out = folder + FS + "HTML.html";
    try {
      FileWriter fw = new FileWriter(out);
      fw.write(input);
      fw.close();
    } catch (IOException ex) {
      Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
    }
    GlobalMethods.saveTextFile(folder, "Test", ".html", createWebPage("Test"));

    String where = Panel4T5Locator.getSysPath();
    String name = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim()
      + " System Index";
    GlobalMethods.saveTextFile(where, name, ".html", createWebPage(name));
  }

  static String createWebPage(String type) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    if (DEBUG) { // true or false
      String s = "";
      s += GlobalMethods.comment("=", 80);
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      s += "\t" + method + CRLF;
      s += "type" + " = " + type + CRLF;
      System.out.print(s);
      //      JOptionPane.showMessageDialog(null, s);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="page">
    page = ""
      + "<!DOCTYPE html>\n"
      + "<!--\n"
      + "COMMENT\n"
      + "//http://www.w3schools.com/xsl/xsl_w3celementref.asp\n"
      + "-->\n"
      + "<html id=\"html\">\n";
    //</editor-fold>
    String path = Panel4T5Locator.getSysPath() + FS + Panel4T5Locator.jcb4Sys
      .getSelectedItem().toString().trim();
    addHead(type);
    ////////////////////
    switch (type) {
      case "Test": {
        addPic(type);
        addText(type);
//        addTable("C:/T5/_JS/Systems/1705 Efate.xml",
//          "C:/T5/_JS/Systems.xsl",
//          "C:/T5/_XML/XML.xml");
        addTable("C:/T5/_XML/XML.xml",
          "C:/T5/_XML/Systems.xsl",
          "C:/T5/_XML/XML.html");
        addButton("???");
        break;
      }
      default: {
        break;
      }
    }
    addBodyEnd(path);
    return page;
  }

  static void addHead(String string) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    if (DEBUG) { // true or false
      String s = "";
      s += GlobalMethods.comment("=", 80);
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      s += "\t" + method + CRLF;
      //      s += "" + " = " + method + CRLF;
      System.out.print(s);
      //      JOptionPane.showMessageDialog(null, s);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="page">
    page += ""
      + "  <head id=\"head\">\n"
      + "    <title id=\"title\">TITLE</title>\n"
      + "    <script id=\"loadxmldoc\">\n"
      + "      function loadXMLDoc(filename)\n"
      + "      {\n"
      + "        if (window.ActiveXObject)\n"
      + "        {\n"
      + "          xhttp = new ActiveXObject(\"Msxml2.XMLHTTP\");\n"
      + "        }\n"
      + "        else\n"
      + "        {\n"
      + "          xhttp = new XMLHttpRequest();\n"
      + "        }\n"
      + "        xhttp.open(\"GET\", filename, false);\n"
      + "        try {\n"
      + "          xhttp.responseType = \"msxml-document\"\n"
      + "        } catch (err) {\n"
      + "        } // Helping IE11\n"
      + "        xhttp.send(\"\");\n"
      + "        return xhttp.responseXML;\n"
      + "      }\n"
      + "\n"
      + "      function displayResult()\n"
      + "      {\n"
      + "        xml = loadXMLDoc(XMLDOC);\n"
      + "        xsl = loadXMLDoc(XSLDOC);\n"
      + "        // code for IE\n"
      + "        if (window.ActiveXObject || xhttp.responseType == \"msxml-document\")\n"
      + "        {\n"
      + "          ex = xml.transformNode(xsl);\n"
      + "          document.getElementById(\"example\").innerHTML = ex;\n"
      + "        }\n"
      + "        // code for Chrome, Firefox, Opera, etc.\n"
      + "        else if (document.implementation && document.implementation.createDocument)\n"
      + "        {\n"
      + "          xsltProcessor = new XSLTProcessor();\n"
      + "          xsltProcessor.importStylesheet(xsl);\n"
      + "          resultDocument = xsltProcessor.transformToFragment(xml, document);\n"
      + "          document.getElementById(\"example\").appendChild(resultDocument);\n"
      + "        }\n"
      + "      }\n"
      + "\n"
      + "    </script>\n"
      + "    <script id=\"headscripts\">\n"
      + "      SCRIPTS\n"
      + "    </script>\n"
      + "  </head>\n"
      + "  <body id=\"body\">\n"
      + "    <h2 id=\"heading\">\n"
      + "      HEADING\n"
      + "    </h2>\n";
    //</editor-fold>
    page = page.replace(uppervalues[0], string);//COMMENT
    page = page.replace(uppervalues[1], string);//TITLE
    page = page.replace(uppervalues[2], uppervalues[2]);//xmlDoc
    page = page.replace(uppervalues[3], uppervalues[3]);//xslDoc
    page = page.replace(uppervalues[4], uppervalues[4]);//SCRIPTS
    page = page.replace(uppervalues[5], uppervalues[5]);//HEADER
    page = page.replace(uppervalues[6], string);//HEADING
  }

  static void addPic(String string) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    if (DEBUG) { // true or false
      String s = "";
      s += GlobalMethods.comment("=", 80);
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      s += "\t" + method + CRLF;
      //      s += "" + " = " + method + CRLF;
      System.out.print(s);
      //      JOptionPane.showMessageDialog(null, s);
    }
    //</editor-fold>
    page += ""
      + "    <!--\n"
      + "    //Add picture\n"
      + "    -->\n"
      + "    <div id=\"picture\">\n"
      + "      PICPATH<br/>\n"
      + "      <img id=\"picture\" src=\"PICTURE\" width=\"WIDTH\" height=\"HEIGHT\" alt=\"PICALT\"/><br/>\n"
      + "    </div>\n";
//    page = page.replace("PICPATH", "PICPATH");//parts[7]
//    page = page.replace("PICTURE", "PICTURE");//parts[8]
//    page = page.replace("WIDTH", "WIDTH");//parts[9]
//    page = page.replace("HEIGHT", "HEIGHT");//parts[10]
//    page = page.replace("PICALT", "PICALT");//parts[11]
    page = page.replace(uppervalues[7], uppervalues[7]);//PICPATH
    page = page.replace(uppervalues[8], uppervalues[8]);//PICPATH
    page = page.replace(uppervalues[9], uppervalues[9]);//PICPATH
    page = page.replace(uppervalues[10], uppervalues[10]);//PICPATH
    page = page.replace(uppervalues[11], uppervalues[11]);//PICPATH
    switch (string) {
      case "Test": {
        break;
      }
      default: {
        break;
      }
    }
  }

  static void addButton(String string) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    if (DEBUG) { // true or false
      String s = "";
      s += GlobalMethods.comment("=", 80);
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      s += "\t" + method + CRLF;
      //      s += "" + " = " + method + CRLF;
      System.out.print(s);
      //      JOptionPane.showMessageDialog(null, s);
    }
    //</editor-fold>
    page += ""
      + "    <!--\n"
      + "    //Add button\n"
      + "    -->\n"
      + "    <div id = \"button\">\n"
      + "      <button id=\"button\" onclick=\"displayButton()\">\n"
      + "        EDIT\n"
      + "      </button><br/>\n"
      + "      <script id=\"displayButton\">\n"
      + "        function displayButton() {\n"
      + "          document.getElementById(\"button\").innerHTML = \"" + string
      + "\";\n"
      + "        }\n"
      + "      </script>\n"
      + "    </div>\n";
    switch (string) {
      case "Test": {
        break;
      }
      default: {
        break;
      }
    }
  }

  static void addText(String string) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    if (DEBUG) { // true or false
      String s = "";
      s += GlobalMethods.comment("=", 80);
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      s += "\t" + method + CRLF;
      //      s += "" + " = " + method + CRLF;
      System.out.print(s);
      //      JOptionPane.showMessageDialog(null, s);
    }
    //</editor-fold>
    String s = "";
    switch (string) {
      case "Test": {
        s = string;
        break;
      }
      default: {
        s = "DEFAULT";
        break;
      }
    }
    page += "\n"
      + "    <!--\n"
      + "    //Add text\n"
      + "    -->\n";
    page += s + "<br/>\n";
  }

  static void addLink(String string) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    if (DEBUG) { // true or false
      String s = "";
      s += GlobalMethods.comment("=", 80);
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      s += "\t" + method + CRLF;
      //      s += "" + " = " + method + CRLF;
      System.out.print(s);
      //      JOptionPane.showMessageDialog(null, s);
    }
    //</editor-fold>
    String s = ""
      //        page += ""
      + "<div>"
      + "  <a href=\"Default.html\">Default</a><br/>\n"
      + "</div>";
    s = s.replace("Default", string);
    page += ""
      + "    <!--\n"
      + "    //Add Link\n"
      + "    -->\n";
    page = page + s;
  }

  static void addTable(String xml, String xsl, String ref) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
    if (DEBUG) { // true or false
      String s = "";
      s += GlobalMethods.comment("=", 80) + CRLF;
      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
      s += "\t" + method + CRLF;
      System.out.print(s);
//      JOptionPane.showMessageDialog(null, s);
    }
    //</editor-fold>
    addLoader(xml, xsl);
  }

  private static void addLinks(String string) {
    page += "\n"
      + "<div>\n"
      + "  <a href=\"file:\\\\\\C:\\\\T5\\_XML\\Default.html\">Default</a><br/>\n"
      + "  <a href=\"file:\\\\\\C:\\\\T5\\_XML\\HTML.html\">HTML</a><br/>\n"
      + "  <a href=\"file:\\\\\\C:\\\\T5\\_XML\\Test.html\">Test</a><br/>\n"
      + "  <a href=\"file:\\\\\\C:\\\\T5\\_XML\\CSV.csv\">CSV</a><br/>\n"
      + "  <a href=\"file:\\\\\\C:\\\\T5\\_XML\\DTD.dtd\">DTD</a><br/>\n"
      + "  <a href=\"file:\\\\\\C:\\\\T5\\_XML\\TXT.txt\">TXT</a><br/>\n"
      + "  <a href=\"file:\\\\\\C:\\\\T5\\_XML\\XML.xml\">XML</a><br/>\n"
      + "  <a href=\"file:\\\\\\C:\\\\T5\\_XML\\XSL.xsl\">XSL</a><br/>\n"
      + "</div>\n";
    switch (string) {
      case "Test": {
        break;
      }
      default: {
        break;
      }
    }
  }

  private static void change(String uppervalue, String part) {
    page = page.replace(uppervalue, part);
  }

  ////////////////////////////////////////////////////////////////////////////
  static void addBodyEnd(String path) {
    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
    boolean DEBUG = true;
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
//    page += "<br/>\n";
    addLinks(path);
    addWorldLinks(path);
    page += "\n  </body>\n</html>\n";
  }

  private static void addWorldLinks(String path) {
//    {
//      JTextArea jta = new JTextArea(20, 20);
//      jta.setText(path);
//      JScrollPane jsp = new JScrollPane(jta);
//      System.out.println("path" + " = " + path);
//      JOptionPane.showMessageDialog(null, jsp);
//    }
    String string = GlobalMethods.loadTextFile(path, "Index", ".html").replace(
      "href=", "href=\"file:///" + path + FS).replace("\\", "/").replace("html",
      "html\"");
    page += string;
  }

  /**

   @param path
   @return
   */
  public static String getWorldLinks(String path) {
    String string = GlobalMethods.loadTextFile(path, "Index", ".html").replace(
      "href=", "href=\"file:///" + path + FS).replace("\\", "/").replace("html",
      "html\"");
    return string;
  }

  private static void addLoader(String xml, String xsl) {
    page += ""
      + "    <!--\n"
      + "    //Add table\n"
      + "    -->\n";
    page += ""
      + "xml = " + xml + "<br/>" + "\n"
      + "xsl = " + xsl + "<br/>" + "\n"
      + "ref = " + ref + "<br/>" + "\n";
    String xtra = ""
      + "    <script id=\"loadxmldoc\" onload=\"displayResult()\">\n"
      + "      function displayResult()\n"
      + "      {\n"
      + "        xml = loadXMLDoc(XMLDOC);\n"
      + "        xsl = loadXMLDoc(XSLDOC);\n"
      + "        // code for IE\n"
      + "        if (window.ActiveXObject || xhttp.responseType == \"msxml-document\")\n"
      + "        {\n"
      + "          ex = xml.transformNode(xsl);\n"
      + "          document.getElementById(\"examplea\").innerHTML = ex;\n"
      + "        }\n"
      + "        // code for Chrome, Firefox, Opera, etc.\n"
      + "        else if (document.implementation && document.implementation.createDocument)\n"
      + "        {\n"
      + "          xsltProcessor = new XSLTProcessor();\n"
      + "          xsltProcessor.importStylesheet(xsl);\n"
      + "          resultDocument = xsltProcessor.transformToFragment(xml, document);\n"
      + "          document.getElementById(\"examplea\").appendChild(resultDocument);\n"
      + "        }\n"
      + "      function loadXMLDoc(filename)\n"
      + "      {\n"
      + "        if (window.ActiveXObject)\n"
      + "        {\n"
      + "          xhttp = new ActiveXObject(\"Msxml2.XMLHTTP\");\n"
      + "        }\n"
      + "        else\n"
      + "        {\n"
      + "          xhttp = new XMLHttpRequest();\n"
      + "        }\n"
      + "        xhttp.open(\"GET\", filename, false);\n"
      + "        try {\n"
      + "          xhttp.responseType = \"msxml-document\"\n"
      + "        } catch (err) {\n"
      + "        } // Helping IE11\n"
      + "        xhttp.send(\"\");\n"
      + "        return xhttp.responseXML;\n"
      + "      }\n"
      + "      }\n"
      + "    </script>\n".replace("XMLDOC", xml).replace("XSLDOC", xsl)
      + "    <div id=\"examplea\">\n"
      + "ExampleA\n".replace("examplea", ref).replace("ExampleA", ref)
      + "    </div>\n";
    page += xtra;
  }

//<editor-fold defaultstate="collapsed" desc="comment">
//  static void makePage(String type) {
//    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
//    boolean DEBUG = true;
//    if (DEBUG) { // true or false
//      String s = "";
//      s += GlobalMethods.comment("=", 80);
//      String method = Thread.currentThread().getStackTrace()[1].getMethodName();
//      s += "\t" + method + CRLF;
//      //      s += "" + " = " + method + CRLF;
//      System.out.print(s);
//      //      JOptionPane.showMessageDialog(null, s);
//    }
//    //</editor-fold>
//    page = GlobalMethods.loadTextFile(T5 + FS + "_XML", "Default", ".html");
//    String[] strings = new String[parts.length];
////        for (int i = 0; i < parts.length; i++) {
////            change(uppervalues[i], uppervalues[i]);
////        }
//    switch (type) {
//      case "Test": {
//        for (int i = 0; i < parts.length; i++) {
//          change(uppervalues[i], type);
//        }
//        break;
//      }
//      default: {
//        break;
//      }
//    }
//    System.out.println(page);
//
//  }
//</editor-fold>
}
