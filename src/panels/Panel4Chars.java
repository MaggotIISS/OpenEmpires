/*

 Copyright (C) 2014 Mark Ferguson



 This program is free software: you can redistribute it and/or modify

 it under the terms of the GNU General Public License as published by

 the Free Software Foundation, either version 3 of the License, or

 (at your option) any later version.



 This program is distributed in the hope that it will be useful,

 but WITHOUT ANY WARRANTY; without even the implied warranty of

 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the

 GNU General Public License for more details.



 You should have received a copy of the GNU General Public License

 along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */
package panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 <p>
 @author maggot
 */
public class Panel4Chars extends Panel4 {

  static JPanel jp;
  static JFrame f4;
  static JList jl;
  static JTextField jtf;
  static JButton jb;

  /**
   <p>
   @param args strings to start
   */
  public static void main(String[] args) {
    //f4g = new Frame4();
    jp = new Panel4Chars();
    f4 = new Frame4(jp);
    jl.setSelectedIndex(913 - 32);
    f4.setSize(300, 500);
    f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    f4.setTitle("HTML codes");
//    f4.setTitle("<html>&#913</html>");
  }

  /**
   Creates new form Panel4Greek
   */
  @SuppressWarnings("unchecked")
  public Panel4Chars() {
    initComponents();
    //this.setLayout(new GridLayout(1, 2));
    DefaultListModel list = new DefaultListModel();
    int num = 32;//913 - 937 is Alpha to Omega
    String string;
    //for (int i = 0; i < 9830; i++) {
    for (int i = 0; i < 16384; i++) {
      string = "<html>&#" + num + "</html>";
      list.addElement(string);
      num += 1;
    }
    jl = new JList(list);
    jl.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent lse) {
        int num = jl.getSelectedIndex() + 32;
        jl.setToolTipText("" + num);
        jtf.setText("" + num);
        jtf.setText("<html>&#" + num + "</html>");
        String s;
        if (jl.getSelectedIndex() > (912 - 32) & jl.getSelectedIndex() < (938
          - 32)) {
          switch (jtf.getText()) {
            //a
            case "913":
              s = "Alpha";
              break;
            //b
            case "914":
              s = "Beta";
              break;
            //c
            case "915":
              s = "Gamma";
              break;
            //d
            case "916":
              s = "Delta";
              break;
            //e
            case "917":
              s = "Epsilon";
              break;
            //f
            case "918":
              s = "Zeta";
              break;
            //g
            case "919":
              s = "Eta";
              break;
            //h
            case "920":
              s = "Theta";
              break;
            //i
            case "921":
              s = "Iota";
              break;
            //j
            case "922":
              s = "Kappa";
              break;
            //k
            case "923":
              s = "Lambda";
              break;
            //l
            case "924":
              s = "Mu";
              break;
            //m
            case "925":
              s = "Nu";
              break;
            //n
            case "926":
              s = "Xi";
              break;
            //o
            case "927":
              s = "Omicron";
              break;
            //p
            case "928":
              s = "Pi";
              break;
            //q
            case "929":
              s = "Rho";
              break;
            //NO
            case "930":
              s = "";
              break;
            //r
            case "931":
              s = "Sigma";
              break;
            //s
            case "932":
              s = "Tau";
              break;
            //t
            case "933":
              s = "Upsilon";
              break;
            //u
            case "934":
              s = "Phi";
              break;
            //v
            case "935":
              s = "Chi";
              break;
            //w
            case "936":
              s = "Psi";
              break;
            //x
            case "937":
              s = "Omega";
              break;
            default:
              s = "" + jl.getSelectedIndex();
          }
          jl.setToolTipText(s);
        }
        //System.out.print("<html>&#"+num+"</html>");
      }
    });
    JScrollPane jsp = new JScrollPane(jl);
    add(jsp);
    jtf = new JTextField();
    jtf.setText("<html>&#" + num + "</html>");
    jtf.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int num = Integer.parseInt(jtf.getText()) - 32;
        jl.setSelectedIndex(num);
        jl.ensureIndexIsVisible(num + 24);
      }
    });
    add(jtf, BorderLayout.NORTH);
    jb = new JButton("Randomize");
    jb.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int r = (int) (Math.random() * 16384);
        jl.setSelectedIndex(r);
        jl.ensureIndexIsVisible(r);
        System.out.println("" + " = " + jl.getSelectedValue().toString());
      }
    });
    add(jb, BorderLayout.SOUTH);
    jl.setSelectedIndex(913 - 32);
    //jtf.setText("913");
    int a = 881;
    jl.setSelectedIndex(881);
    jl.ensureIndexIsVisible(881);
//    f4.setTitle("<html>&#" + num + "</html>");
    //f4g.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
  }

  /**
   This method is called from within the constructor to initialize the form.
   WARNING: Do NOT modify this code. The content of this method is always
   regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setLayout(new java.awt.BorderLayout());
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables

  /**
   <p>
   @param letter to convert
   @return Greek letter code in html
   */
  public String alpha2Greek(String letter) {
    letter = letter.toLowerCase();
    //913
    if ("a".equals(letter)) {
      letter = "Alpha";
    }
    //914
    if ("b".equals(letter)) {
      letter = "Beta";
    }
    //915
    if ("c".equals(letter)) {
      letter = "Gamma";
    }
    //916
    if ("d".equals(letter)) {
      letter = "Delta";
    }
    //917
    if ("e".equals(letter)) {
      letter = "Epsilon";
    }
    //918
    if ("f".equals(letter)) {
      letter = "Zeta";
    }
    //919
    if ("g".equals(letter)) {
      letter = "Eta";
    }
    //920
    if ("h".equals(letter)) {
      letter = "Theta";
    }
    //921
    if ("i".equals(letter)) {
      letter = "Iota";
    }
    //922
    if ("j".equals(letter)) {
      letter = "Kappa";
    }
    //923
    if ("k".equals(letter)) {
      letter = "Lambda";
    }
    //924
    if ("l".equals(letter)) {
      letter = "Mu";
    }
    //925
    if ("m".equals(letter)) {
      letter = "Nu";
    }
    //926
    if ("n".equals(letter)) {
      letter = "Xi";
    }
    //927
    if ("o".equals(letter)) {
      letter = "Omicron";
    }
    //928
    if ("p".equals(letter)) {
      letter = "Pi";
    }
    //929
    if ("q".equals(letter)) {
      letter = "Rho";
    }
    //931
    if ("r".equals(letter)) {
      letter = "Sigma";
    }
    //932
    if ("s".equals(letter)) {
      letter = "Tau";
    }
    //933
    if ("t".equals(letter)) {
      letter = "Upsilon";
    }
    //934
    if ("u".equals(letter)) {
      letter = "Phi";
    }
    //935
    if ("v".equals(letter)) {
      letter = "Chi";
    }
    //936
    if ("w".equals(letter)) {
      letter = "Psi";
    }
    //937
    if ("x".equals(letter)) {
      letter = "Omega";
    } else {
      letter = "ERROR IN ENTRY";
    }
    return letter;
  }

  /**
   <p>
   @param num number to convert
   @return English letter
   */
  public String greek2Alpha(int num) {
    if ((num >= 913) & (num <= 929)) {
      num -= 912;
    }
    if (num >= 931) {
      num -= 913;
    }
    String alpha = null;
    if (1 == num) {
      alpha = "A";
    }
    if (2 == num) {
      alpha = "B";
    }
    if (3 == num) {
      alpha = "C";
    }
    if (4 == num) {
      alpha = "D";
    }
    if (5 == num) {
      alpha = "E";
    }
    if (6 == num) {
      alpha = "F";
    }
    if (7 == num) {
      alpha = "G";
    }
    if (8 == num) {
      alpha = "H";
    }
    if (9 == num) {
      alpha = "I";
    }
    if (10 == num) {
      alpha = "J";
    }
    if (11 == num) {
      alpha = "K";
    }
    if (12 == num) {
      alpha = "L";
    }
    if (13 == num) {
      alpha = "M";
    }
    if (14 == num) {
      alpha = "N";
    }
    if (15 == num) {
      alpha = "O";
    }
    if (16 == num) {
      alpha = "P";
    }
    if (17 == num) {
      alpha = "Q";
    }
    if (18 == num) {
      alpha = "R";
    }
    if (19 == num) {
      alpha = "S";
    }
    if (20 == num) {
      alpha = "T";
    }
    if (21 == num) {
      alpha = "U";
    }
    if (22 == num) {
      alpha = "V";
    }
    if (23 == num) {
      alpha = "W";
    }
    if (24 == num) {
      alpha = "X";
    }
    return alpha;
  }

  /**
   <p>
   @param letter of alphabet to greek
   @return Pronunciation of word
   */
  public String alpha2Word(String letter) {
    letter = letter.toLowerCase();
    if ("a".equals(letter)) {
      letter = "Aye";
    }
    if ("b".equals(letter)) {
      letter = "Bee";
    }
    if ("c".equals(letter)) {
      letter = "See";
    }
    if ("d".equals(letter)) {
      letter = "Dee";
    }
    if ("e".equals(letter)) {
      letter = "Eee";
    }
    if ("f".equals(letter)) {
      letter = "Eff";
    }
    if ("g".equals(letter)) {
      letter = "Gee";
    }
    if ("h".equals(letter)) {
      letter = "Aitch";
    }
    if ("i".equals(letter)) {
      letter = "Eye";
    }
    if ("j".equals(letter)) {
      letter = "Jay";
    }
    if ("k".equals(letter)) {
      letter = "Kay";
    }
    if ("l".equals(letter)) {
      letter = "Ell";
    }
    if ("m".equals(letter)) {
      letter = "Emm";
    }
    if ("n".equals(letter)) {
      letter = "Enn";
    }
    if ("o".equals(letter)) {
      letter = "Oh";
    }
    if ("p".equals(letter)) {
      letter = "Pee";
    }
    if ("q".equals(letter)) {
      letter = "Queue";
    }
    if ("r".equals(letter)) {
      letter = "Arr";
    }
    if ("s".equals(letter)) {
      letter = "Ess";
    }
    if ("t".equals(letter)) {
      letter = "Tee";
    }
    if ("u".equals(letter)) {
      letter = "You";
    }
    if ("v".equals(letter)) {
      letter = "Vee";
    }
    if ("w".equals(letter)) {
      letter = "Double U";
    }
    if ("x".equals(letter)) {
      letter = "Ecks";
    }
    if ("y".equals(letter)) {
      letter = "Why";
    }
    if ("z".equals(letter)) {
      letter = "Zed";
    }

    return letter;
  }

  /**
   <p>
   @return name of class
   */
  @Override
  public String toString() {
    return "" + getClass().getName() + "[]";
  }
}
