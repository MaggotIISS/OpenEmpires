/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package open;

/**
 *
 * @author Mark Ferguson
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//    args = new String[] {"applets.Calculator"};
//    args = new String[] {"applets.FontTest"};
//    args = new String[]{"starters.Chart"};
//    args = new String[]{"starters.Counters"};
//    args = new String[] {"empires.Empire"};

        args = new String[]{"open.P4Start"};
        P4Start.main(args);
        P4Start.jButton1.doClick();
    }

}
