package fx.xpath;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 This program evaluates XPath expressions.
 @version 1.01 2007-06-25
 @author Cay Horstmann
 */
public class XPathTester {

  /**

   @param args
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new XPathFrame();
        frame.setTitle("XPathTest");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
      }
    });
  }
}

/**
 This frame shows an XML document, a panel to type an XPath expression, and a
 text field to
 display the result.
 */
class XPathFrame extends JFrame {

  private DocumentBuilder builder;
  private Document doc;
  private XPath path;
  private JTextField expression;
  private JTextField result;
  private JTextArea docText;
  private JComboBox<String> typeCombo;

  public XPathFrame() {
    JMenu fileMenu = new JMenu("File");
    JMenuItem openItem = new JMenuItem("Open");
    openItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        openFile();
      }
    });
    fileMenu.add(openItem);

    JMenuItem exitItem = new JMenuItem("Exit");
    exitItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });
    fileMenu.add(exitItem);

    JMenuBar menuBar = new JMenuBar();
    menuBar.add(fileMenu);
    setJMenuBar(menuBar);

    ActionListener listener = new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        evaluate();
      }
    };
    expression = new JTextField(20);
    expression.addActionListener(listener);
    JButton evaluateButton = new JButton("Evaluate");
    evaluateButton.addActionListener(listener);

    typeCombo = new JComboBox<String>(new String[]{
      "STRING", "NODE", "NODESET", "NUMBER", "BOOLEAN"});
    typeCombo.setSelectedItem("STRING");

    JPanel panel = new JPanel();
    panel.add(expression);
    panel.add(typeCombo);
    panel.add(evaluateButton);
    docText = new JTextArea(10, 40);
    result = new JTextField();
    result.setBorder(new TitledBorder("Result"));

    add(panel, BorderLayout.NORTH);
    add(new JScrollPane(docText), BorderLayout.CENTER);
    add(result, BorderLayout.SOUTH);

    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      builder = factory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      JOptionPane.showMessageDialog(this, e);
    }

    XPathFactory xpfactory = XPathFactory.newInstance();
    path = xpfactory.newXPath();
    openFile();
    pack();
  }

  /**
   Open a file and load the document.
   */
  public void openFile() {
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new File("C:/T5/_XML"));

    chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
      public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".xml");
      }

      public String getDescription() {
        return "XML files";
      }
    });
//    int r = chooser.showOpenDialog(this);
//    if (r != JFileChooser.APPROVE_OPTION) {
//      return;
//    }
    File file = new File("C:/T5/_XML/T5Elements.xml");
    try {
      docText.setText(new String(Files.readAllBytes(file.toPath())));
      doc = builder.parse(file);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(this, e);
    } catch (SAXException e) {
      JOptionPane.showMessageDialog(this, e);
    }
  }

  public void evaluate() {
    try {
      String typeName = (String) typeCombo.getSelectedItem();
      QName returnType = (QName) XPathConstants.class.getField(typeName).get(
        null);
      Object evalResult = path.evaluate(expression.getText(), doc, returnType);
      if (typeName.equals("NODESET")) {
        NodeList list = (NodeList) evalResult;
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (int i = 0; i < list.getLength(); i++) {
          if (i > 0) {
            builder.append(", ");
          }
          builder.append("" + list.item(i));
        }
        builder.append("}");
        result.setText("" + builder);
      } else {
        result.setText("" + evalResult);
      }
    } catch (XPathExpressionException e) {
      result.setText("" + e);
    } catch (Exception e) // reflection exception
    {
      e.printStackTrace();
    }
  }
}
