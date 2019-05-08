package applets;/** @version 1.31 2002-07-09 @author Cay Horstmann */import java.awt.BorderLayout;import java.awt.Container;import java.awt.GridLayout;import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import javax.swing.JButton;import javax.swing.JFrame;import javax.swing.JPanel;import javax.swing.JTextField;/** @author maggot */public class Calculator {  /**   @param args strings to start   */  public static void main(String[] args) {    CalculatorFrame frame = new CalculatorFrame();    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);    frame.setVisible(true);  }}/** A frame with a calculator panel. */class CalculatorFrame extends JFrame {  public CalculatorFrame() {    setTitle("Calculator");    Container contentPane = getContentPane();    CalculatorPanel panel = new CalculatorPanel();    contentPane.add(panel);    pack();  }}/** A panel with calculator buttons and a result display. */class CalculatorPanel extends JPanel {  public CalculatorPanel() {    setLayout(new BorderLayout());    result = 0;    lastCommand = "=";    start = true;    // add the display    display = new JTextField("0");    add(display, BorderLayout.NORTH);    ActionListener insert = new InsertAction();    ActionListener command = new CommandAction();    // add the buttons in a 4 x 4 grid    panel = new JPanel();    panel.setLayout(new GridLayout(4, 4));    addButton("7", insert);    addButton("8", insert);    addButton("9", insert);    addButton("/", command);    addButton("4", insert);    addButton("5", insert);    addButton("6", insert);    addButton("*", command);    addButton("1", insert);    addButton("2", insert);    addButton("3", insert);    addButton("-", command);    addButton("0", insert);    addButton(".", insert);    addButton("=", command);    addButton("+", command);    add(panel, BorderLayout.CENTER);  }  /**   Adds a button to the center panel.   @param label    the button label   @param listener the button listener   */  private void addButton(String label, ActionListener listener) {    JButton button = new JButton(label);    button.addActionListener(listener);    panel.add(button);  }  /**   This action inserts the button action string to the end of the display   text.   */  private class InsertAction implements ActionListener {    @Override    public void actionPerformed(ActionEvent event) {      String input = event.getActionCommand();      if (start) {        display.setText("");        start = false;      }      display.setText(display.getText() + input);    }  }  /**   This action executes the command that the button action string denotes.   */  private class CommandAction implements ActionListener {    @Override    public void actionPerformed(ActionEvent evt) {      String command = evt.getActionCommand();      if (start) {        if (command.equals("-")) {          display.setText(command);          start = false;        } else {          lastCommand = command;        }      } else {        calculate(Double.parseDouble(display.getText()));        lastCommand = command;        start = true;      }    }  }  /**   Carries out the pending calculation.   @param x the value to be accumulated with the prior result.   */  public void calculate(double x) {    switch (lastCommand) {      case "+":        result += x;        break;      case "-":        result -= x;        break;      case "*":        result *= x;        break;      case "/":        result /= x;        break;      case "=":        result = x;        break;      default:        break;    }    display.setText("" + result);  }  @Override  public String toString() {    return "" + getClass().getName() + "[]";  }  private JTextField display;  private JPanel panel;  private double result;  private String lastCommand;  private boolean start;}