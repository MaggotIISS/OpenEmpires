/*
 Copyright (C) 2014 Mark Ferguson * * This program is free software: you can redistribute it and/or modify * it under the terms of the GNU General Public License as published by * the Free Software Foundation, either version 3 of the License, or * (at your option) any later version. * * This program is distributed in the hope that it will be useful, * but WITHOUT ANY WARRANTY; without even the implied warranty of * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the * GNU General Public License for more details. * * You should have received a copy of the GNU General Public License * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package applets;

/**
 @version 1.30 2000-05-12 @author Cay Horstmann
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 @author maggot
 */
public class CalculatorPopupApplet extends JApplet {

  private static final long serialVersionUID = 1L;

  /**
   @param args strings to start
   */
  public void main(String[] args) {
    init();
  }

  /**
   start here
   */
  @Override public void init() {
// create a frame with a calculator panel
    frame = new JFrame();
    frame.setTitle("Calculator");
    frame.setSize(200, 200);
    frame.getContentPane().add(new CalculatorPanel());
// add a button that pops up or hides the calculator
    JButton calcButton = new JButton("Calculator");
    getContentPane().add(calcButton);
    calcButton.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent evt) {
        if (frame.isVisible()) {
          frame.setVisible(false);
        } else {
          frame.setVisible(true);
        }
      }
    });
  }
  private JFrame frame;
}
