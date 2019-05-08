/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package panels;

import dbviewer.DBPublic;
import dbviewer.globals.GlobalMethods;
import static dbviewer.globals.GlobalVariables.CRLF;
import static dbviewer.globals.GlobalVariables.FS;
import static dbviewer.globals.GlobalVariables.T5;
import static dbviewer.globals.GlobalVariables.T5C;
import static dbviewer.globals.GlobalVariables._CFG;
import static dbviewer.globals.GlobalVariables._GIF;
import dbviewer.globals.ImageListDnDFrame;
import java.awt.Color;
import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import static java.awt.Image.SCALE_SMOOTH;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DropMode;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.event.CaretEvent;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.BadLocationException;
import static panels.Panel4T5Locator.UWP;
import static panels.Panel4T5Locator.bits;
import static panels.Panel4T5Locator.data;
import static panels.Panel4T5Locator.gethydro;
import static panels.Panel4T5Locator.getsize;
import static panels.Panel4T5Locator.jcb4Sys;

/**
 * @author Mark Ferguson
 */
@SuppressWarnings("serial")
public class Panel4T5CounterMaker extends Panel4 {

    //<editor-fold defaultstate="collapsed" desc="variables">
    /**
     *
     */
    public static File fil;

    /**
     *
     */
    public static JFileChooser jfc = dbviewer.DBPublic.CBView();

    /**
     *
     */
    public static Panel4 jp;

    /**
     *
     */
    public static Frame4 jf;

    /**
     *
     */
    public static Frame4 il;
    private static BufferedImage bi = new BufferedImage(200, 100,
            BufferedImage.TYPE_3BYTE_BGR);
    private static Color color;
    private static int fh;
    private static FontMetrics fm;
    private static Font fo;
    private static int fw;
    private static Graphics g = bi.getGraphics();

    /**
     *
     */
    public static Color c = Color.CYAN;
    private static String dir;
    private static int left;
    static String[] replies;
    private static String str;
    private static String str1;
    private static String str2;
    private static String str3;
    private static String str4;
    private static String str5;
    private static String str6;
    private static String str7;
    private static String str8;
    private static int top;
    private TransferHandler ImageTransferable;
    private CaretEvent ce;
    static String[] filelines;
    private static MouseEvent me;
    private ActionEvent ae;
    private FileFilter filter;
    private static FileFilter txtFilter;
    private static FileFilter cfgFilter;
    private static FileFilter gifFilter;
    private static Image img;
    private JComponent ipv;

    static JTextField[] jtfs;
    static String[] jtfc = new String[10];
    static String[] jtbc = new String[10];
    static String[] lines;

    static String[] dirsa = {T5, _CFG, _GIF};
    private static int dnuma = 2;
    private static String dira = dirsa[dnuma];

    private static String file = "";
    private static Font font;

    static String[] exts = {"txt", "cfg", "gif"};
    private static int xnum = 2;
    private static String ext = exts[xnum];

    private final static boolean FIXED = false;
    int Count = 0;
    int Start = 0;
    int End = 0;
    int Num = 0;

    static String counter = "";
    static Color cc;
    static String[] fc = new String[10];
    static String[] bc = new String[10];
    static String[] pix;

    /**
     *
     */
    public static String title = "Temp";
    //</editor-fold>
    static String fname = "";
    static ActionEvent a;

    /**
     *
     * @param args strings for start
     */
    public static void main(String[] args) {
        jp = new Panel4T5CounterMaker();
        jf = new Frame4(jp);
        jf.setContentPane(jp);
        jf.setBounds(-30, 495, 600, 400);
        jf.setVisible(true);
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                GlobalMethods.savePic(jf, jf.getTitle());
                if (Panel4Squadron.hasParent == true) {

                }
                if (il.isVisible()) {
                    il.setVisible(false);
                }

            }
        });
    }

    /**
     * Creates new form Panel4CounterMaker
     */
    public Panel4T5CounterMaker() {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        String s = "";
        {
            boolean DEBUG = false;
            //DEBUG = false;
            if (DEBUG) { // true or false
                s += GlobalMethods.comment("=", 80) + CRLF;
                s += "\t" + getClass() + "-" + Thread.currentThread().getStackTrace()[1]
                        .getMethodName() + CRLF;
                JTextArea jta = new JTextArea(s, 20, 20);
                JScrollPane jsp = new JScrollPane(jta);
                System.out.println(s);
//        JOptionPane.showMessageDialog(jf, jsp);
            }
        }
        //</editor-fold>
        try {
            initComponents();
            jtfs = new JTextField[]{
                t1, t2, t3, t4, t5, t6, t7, t8, t9, t10,
                t11, t12, t13, t14, t15, t16, t17, t18, t19, t20
            };
            jtfc = fc;
            jtbc = bc;
            File ff = new File(_GIF);//.replace("\\\\", "\\"));
            bi = new BufferedImage(200, 100, BufferedImage.TYPE_3BYTE_BGR);
            g = bi.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 200, 100);
            g.setColor(c);
            g.fillRect(0, 0, 100, 100);
            txtFilter = new FileFilter() {

                @Override
                public boolean accept(File f) {
                    if (f.isDirectory() | f.toString().toLowerCase().endsWith(".txt")) {
                        return true;
                    }
                    return false;
                }

                @Override
                public String getDescription() {
                    return "Text";
                }
            };
            cfgFilter = new FileFilter() {

                @Override
                public boolean accept(File f) {
                    if (f.isDirectory() | f.toString().toLowerCase().endsWith(".cfg") | f
                            .toString().toLowerCase().endsWith(".t5c")) {
                        return true;
                    }
                    return false;
                }

                @Override
                public String getDescription() {
                    return "ConFiG";
                }
            };
//      gifFilter = new FileFilter() {
//
//        @Override
//        public boolean accept(File f) {
//          if (f != null) {
//            return f.isDirectory() | f.toString().toLowerCase().endsWith(".gif");
//          }
//          return false;
//        }
//
//        @Override
//        public String getDescription() {
//          return "GIF";
//        }
//      };
            jfc.resetChoosableFileFilters();
            jfc.setAcceptAllFileFilterUsed(true);
            jfc.addChoosableFileFilter(txtFilter);
            jfc.addChoosableFileFilter(cfgFilter);
            jfc.addChoosableFileFilter(gifFilter);
            filter = gifFilter;
            jfc.setFileFilter(filter);
            jfc.setAccessory(ipv);
            try {
                jfc.setCurrentDirectory(ff);
            } catch (Exception e) {
                jfc.setCurrentDirectory(new File(T5));
            } finally {

            }
            this.setToolTipText(null);
            lines = ta4Read.getText().split(CRLF);
            l4Ext.setText(ext);
            l4Folder.setText(jfc.getCurrentDirectory().toString());
            file = _GIF + FS + jt4File.getText() + ".gif";
            jfc.setSelectedFile(new File(file));
            img = bi.getScaledInstance(200, 100, SCALE_SMOOTH);
            b4NewPicActionPerformed(ae);
            DropTarget dt = new DropTarget();
            dt.addDropTargetListener(new DropTargetListener() {

                @Override
                public void dragEnter(DropTargetDragEvent dtde) {
                }

                @Override
                public void dragExit(DropTargetEvent dte) {
                }

                @Override
                public void dragOver(DropTargetDragEvent dtde) {
                    jSpinnerX.setValue(fixx(dtde.getLocation().x));
                    jSpinnerY.setValue(fixy(dtde.getLocation().y));
                }

                @Override
                public void drop(DropTargetDropEvent dtde) {
                    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
                    boolean DEBUG = false;
                    //DEBUG = false;
                    if (DEBUG) { // true or false
                        System.out.print(GlobalMethods.comment("=", 80));
                        System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                                .getMethodName());
                        debugDropDetails(dtde);
                    }
                    //</editor-fold>
                    loadgif(jfc.getSelectedFile());
                }

                @Override
                public void dropActionChanged(DropTargetDragEvent dtde) {
                }

                private void debugDropDetails(DropTargetDropEvent dtde) {
                    String txt = "";
                    txt += "" + dtde.toString() + CRLF;
                    txt += "" + dtde.getClass().toString() + CRLF;
                    DataFlavor[] flavors = dtde.getCurrentDataFlavors();
                    for (int j = 0; j < dtde.getCurrentDataFlavors().length; j++) {
                        txt += " " + flavors[j].toString() + CRLF;
                    }
                    txt += "" + dtde.getDropAction() + CRLF;
                    txt += "" + dtde.getSourceActions() + CRLF;
                    txt += "" + dtde.getTransferable() + CRLF;
                    txt += "" + dtde.isDataFlavorSupported(DataFlavor.imageFlavor) + CRLF;
                    txt += "" + dtde + CRLF;
                    txt += "" + dtde + CRLF;
//          JOptionPane.showMessageDialog(jf, "" + txt);
                    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
                    String str = "";
                    {
                        boolean DEBUG = false;
                        //DEBUG = false;
                        if (DEBUG) { // true or false
                            System.out.print(GlobalMethods.comment("=", 80));
                            System.out.println(
                                    "\t" + Thread.currentThread().getStackTrace()[1]
                                            .getMethodName());
                            //System.out.println("DEBUG" + " = " + DEBUG);
                            str += GlobalMethods.comment("=", 80);
                            str += "\t" + Thread.currentThread().getStackTrace()[1]
                                    .getMethodName();
                            System.out.println(txt);
                        }
                    }
                    //</editor-fold>
                }

            });
            panel4Pic.setDropTarget(dt);
            setDragEnabled(true);
            setDropMode(DropMode.INSERT);
            setTransferHandler(ImageTransferable);
            il = new ImageListDnDFrame();
            il.setVisible(true);
            il.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    GlobalMethods.savePic(il, il.getTitle());
                    jf.setVisible(false);
                }
            });
            countFolders(Folder);
            String[] args = {""};
//      Folder.setSelectedIndex(2);
        } catch (TooManyListenersException ex) {
            Logger.getLogger(Panel4T5CounterMaker.class.getName()).log(Level.SEVERE,
                    null, ex);
            //<editor-fold defaultstate="collapsed" desc="JOP">
            {
                s = "";
                s += "" + CRLF;
                s += "392" + CRLF;
                JTextArea jta = new JTextArea(s, 50, 80);
                JScrollPane jsp = new JScrollPane(jta);
                JOptionPane.showMessageDialog(jf, jsp);
            }
            //</editor-fold>
        }
    }

    static String findUWP(String line) {
        String[] parts = line.replace("\t", " ").split(" ");
        while (line.contains("  ")) {
            line = line.replace("  ", " ");
        }
        String part = "";
        String party = "";
        for (int j = 0; j < parts.length; j++) {
//      System.out.println("parts[" + j + "]" + " = " + parts[j]);
            part = parts[j].trim();
//      System.out.println(" part.length" + " = " + part.length());
            if (part.length() == 9 && part.substring(7, 8).contains("-")) {
//        System.out.println(" " + parts[j].trim());
                party = parts[j];
                return party;
            }
        }
        return party;
    }

    /**
     *
     * @param s item selected in ComboBox
     */
    public static void createCounter(String s) {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        counter = s;
        Folder.setSelectedItem(counter);
        String base = "C:" + FS + "T5" + FS + "_CFG" + FS + "T5" + FS + "T5C" + FS;
        String dir = counter;
        for (int i = 0; i < 3; i++) {
            //<editor-fold defaultstate="collapsed" desc="getGraphics">
            switch (i) {
                case 0: {
                    g = panel4Pic.getGraphics();
                    break;
                }
                case 1: {
                    g = Panel4T5Locator.panel4Pic.getGraphics();
                    break;
                }
                case 2: {
                    g = bi.getGraphics();
                    break;
                }
            }
            //</editor-fold>
//    g = bi.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(100, 0, 100, 100);
            cc = Color.LIGHT_GRAY;
            String[] backdetails = {"", "", "", "", "", "", "", "", "", ""};
            String[] frontdetails = {"", "", "", "", "", "", "", "", "", ""};
            switch (counter) {
                //<editor-fold defaultstate="collapsed" desc="case "Admiral"">
                case "Admiral": {
                    pix = new String[]{""};
                    cc = Color.CYAN;
                    backdetails = new String[]{
                        "" + "",
                        "" + "",//GlobalMethods.capWords(Panel4Admiral.jTextField6.getText()),
                        "Precedence" + " " + "",//Panel4Admiral.jTextField2.getText(),
                        "Planning" + " " + "",//Panel4Admiral.jTextField3.getText(),
                        "Tactical" + " " + "",//Panel4Admiral.jTextField4.getText(),
                        " " + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + ""};
//          Panel4T5Locator.panel4Pic = Panel4T5CounterMaker.panel4Pic;
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Army"">
                case "Army": {
                    pix = new String[]{"star"};
                    cc = Color.GREEN;
                    backdetails = new String[]{
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " "};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Belts"">
                case "Belts": {
                    pix = new String[]{"BS-Battleship"};
                    cc = Color.LIGHT_GRAY;
                    backdetails = new String[]{
                        "" + "",
                        "Pop" + countPop(),
                        "TL" + " " + Panel4T5Locator.UWP.substring(8, 9),
                        "PBs" + " " + Panel4T5Locator.jLabel9.getText(),
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + ""};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Blank"">
                default:
                case "Blank": {
                    pix = new String[]{};
                    cc = Color.WHITE;
                    backdetails
                            = new String[]{"" + "", "" + "", "" + "", "" + "", "" + "", "" + "",
                                "" + "", "" + "", "" + "", "" + ""};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Commodore"">
                case "Commodore": {
                    pix = new String[]{""};
                    cc = Color.CYAN;
                    backdetails = new String[]{
                        "" + "",
                        "" + "",//GlobalMethods.capWords(Panel4Admiral.jTextField6.getText()),
                        "Precedence" + " " + "",//Panel4Admiral.jTextField2.getText(),
                        "Planning" + " " + "",//Panel4Admiral.jTextField3.getText(),
                        "Tactical" + " " + "",//Panel4Admiral.jTextField4.getText(),
                        " " + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + ""};
//          Panel4T5Locator.panel4Pic = Panel4T5CounterMaker.panel4Pic;
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Defences"">
                case "Defences": {
                    pix = new String[]{"sol"};
                    cc = Color.GREEN;
                    backdetails = new String[]{
                        "" + "",
                        "Pop" + countPop(),
                        "TL" + " " + Panel4T5Locator.UWP.substring(8, 9),
                        "CF" + " " + Panel4T5Locator.defbats.getText(),
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + ""};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Fleet"">
                case "Fleet": {
                    pix = new String[]{""};
                    cc = Color.CYAN;
                    backdetails = new String[]{"",
                        "ID" + " " + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + ""};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Gas Giants"">
                case "Gas Giants": {
                    pix = new String[]{"Star"};
                    cc = Color.GRAY;
                    backdetails = new String[]{
                        "" + "",
                        "Pop" + countPop(),
                        "TL" + " " + Panel4T5Locator.UWP.substring(8, 9),
                        "GGs" + " " + Panel4T5Locator.jLabel10.getText(),
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + ""};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Marine"">
                case "Marine": {
                    pix = new String[]{"star"};
                    cc = Color.RED;
                    backdetails = new String[]{
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " "};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Merchant"">
                case "Merchant": {
                    pix = new String[]{"star"};
                    cc = Color.LIGHT_GRAY;
                    backdetails = new String[]{
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " "};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Navy"">
                case "Navy": {
                    pix = new String[]{"star"};
                    cc = Color.CYAN;
                    backdetails = new String[]{
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " "};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Orbitals"">
                case "Orbitals": {
                    pix = new String[]{""};
                    cc = Color.ORANGE;
                    backdetails = new String[]{
                        "" + "",
                        "Orbits" + "",
                        "" + "",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " "};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Orbit"">
                case "Orbit": {
                    pix = new String[]{""};
                    cc = Color.ORANGE;
                    backdetails = new String[]{
                        "" + "",
                        "Orbit " + "",
                        "" + "",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " "};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Other"">
                case "Other": {
                    pix = new String[]{"star"};
                    cc = Color.WHITE;
                    backdetails = new String[]{
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " "};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Planets"">
                case "Planets": {
                    pix = new String[]{""};
                    cc = Color.ORANGE;
                    backdetails = new String[]{
                        "" + "",
                        "Planets" + "",
                        "" + "",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " "};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Population"">
                case "Population": {
                    pix = new String[]{"caca"};
                    cc = Color.WHITE;
                    backdetails = new String[]{
                        "" + "",
                        "Pop" + countPop(),
                        "TL" + " " + Panel4T5Locator.UWP.substring(8, 9),
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + ""};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Scout"">
                case "Scout": {
                    pix = new String[]{"star"};
                    cc = Color.YELLOW;
                    backdetails = new String[]{
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " ",
                        "" + " "};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "SDBs"">
                case "SDBs": {
                    pix = new String[]{"SDB-Dragon-10"};
                    cc = Color.YELLOW;
                    backdetails = new String[]{
                        "" + "",
                        "Pop" + countPop(),
                        "TL" + " " + Panel4T5Locator.UWP.substring(8, 9),
                        "SDBs" + " " + Panel4T5Locator.sdbs1.getText(),
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + ""};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Ship"">
                case "Ship": {
                    pix = new String[]{""};
                    cc = Color.LIGHT_GRAY;
                    backdetails = new String[]{
                        "" + "",
                        "" + "",
                        "" + "",
                        "V" + " ",
                        "M" + " ",
                        "C" + " ",
                        "TL" + " ",
                        "J" + " ",
                        "G" + " ",
                        "" + " "};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Squadron"">
                case "Squadron": {
                    pix = new String[]{"154thBatRon"};
                    cc = Color.CYAN;
                    backdetails = new String[]{
                        "Hex" + " " + "ID",
                        "" + "",
                        "Type" + " " + "",
                        "Jump" + " " + "",
                        "Refuel" + " " + "",
                        "Defence" + " " + "",
                        "Attack" + " " + "",
                        "Bombard" + " " + "",
                        "Troops" + " " + "",
                        "TL" + " " + ""};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Squadrons"">
                case "Squadrons": {
                    pix = new String[]{"154thBatRon"};
                    cc = Color.CYAN;
                    backdetails = new String[]{
                        "" + "",
                        "Pop" + countPop(),
                        "SDBs" + " " + Panel4T5Locator.sdbs1.getText(),
                        "TL" + Panel4T5Locator.UWP.substring(8, 9),
                        "Rons" + " " + Panel4T5Locator.squadrons.getText(),
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + ""};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Stars"">
                case "Stars": {
                    pix = new String[]{"star"};
                    cc = Color.YELLOW;
                    backdetails = new String[]{
                        "" + "",
                        "Stars" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + ""};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Troops"">
                case "Troops": {
                    pix = new String[]{"Colom"};
                    cc = Color.RED;
                    backdetails = new String[]{
                        "" + "",
                        "Pop" + countPop(),
                        "TL" + " " + Panel4T5Locator.UWP.substring(8, 9),
                        "CF" + " " + Panel4T5Locator.troopunits.getText(),
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + ""};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Troop"">
                case "Troop": {
                    pix = new String[]{"Rearden"};
                    cc = Color.RED;
                    backdetails = new String[]{
                        "Hex" + "",
                        "" + "",
                        "Size" + " " + "",
                        "Quality" + " " + "",
                        "Armament" + " " + "",
                        "Mobility" + " " + "",
                        "Type" + "",
                        "CF" + "",
                        "TF" + "",
                        "TL" + " " + ""
                    };
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Vehicle"">
                case "Vehicle": {
                    pix = new String[]{""};
                    cc = Color.LIGHT_GRAY;
                    backdetails = new String[]{
                        "" + "",
                        "" + "",
                        "" + "",
                        "V" + " ",
                        "M" + " ",
                        "C" + " ",
                        "W" + " ",
                        "H" + " ",
                        "L" + " ",
                        "P" + " "};
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "World"">
                case "World": {
                    drawOutline();
                    Color col = Panel4T5Locator.getTASColor();
                    String Col = "X";
                    if (col.getRed() == 255) {
                        Col = "R";
                    }
                    if (col.getGreen() == 255) {
                        Col = "G";
                    }
                    if (col.getGreen() == 200) {
                        Col = "A";
                    }
//          System.out.println("" + " = " + col.getRed());
//          System.out.println("" + " = " + col.getGreen());
//          System.out.println("" + " = " + col.getBlue());
                    backdetails = new String[]{
                        Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim(),
                        Panel4T5Locator.UWP,
                        "SDBs " + Panel4T5Locator.sdbs1.getText(),
                        "Rons " + Panel4T5Locator.squadrons.getText(),
                        "Def CF " + Panel4T5Locator.defbats.getText(),
                        "Troops " + Panel4T5Locator.troopunits.getText(),
                        "Pop " + countPop(),
                        "Belts " + Panel4T5Locator.jLabel9.getText(),
                        "GGs " + Panel4T5Locator.jLabel10.getText(),
                        "Worlds " + Panel4T5Locator.jLabel12.getText() + " " + Col
                    };
                    for (int j = 0; j < 10; j++) {
                        fc[j] = frontdetails[j].trim();
                        bc[j] = backdetails[j].trim();
                    }
                    for (int j = 0; j < 10; j++) {
                        g.drawString(fc[j], 105, j * 10);
                        g.drawString(bc[j], 105, 10 + (j * 10));
                    }
                    pix = new String[]{};
                    String zone = Panel4T5Locator.data[9].substring(4);
                    //<editor-fold defaultstate="collapsed" desc="switch (zone.toLowerCase())">
                    switch (zone.toLowerCase()) {
                        case "r": {
                            g.setColor(Color.red);
                            break;
                        }
                        case "a": {
                            g.setColor(Color.orange);
                            break;
                        }
                        case "g":
                        case "-":
                        default: {
                            g.setColor(Color.green);
                            break;
                        }
                    }
                    //</editor-fold>
                    g.fillRect(0, 0, 100, 100);
                    String atmo = "" + Panel4T5Locator.UWP.substring(2, 3);
                    //<editor-fold defaultstate="collapsed" desc="switch (atmo.toLowerCase())">
                    switch (atmo.toLowerCase()) {
                        case "5":
                        case "6":
                        case "8":
                        case "normal": {
                            g.setColor(Color.cyan);
                            break;
                        }
                        case "0":
                        case "1":
                        case "vaccuum": {
                            g.setColor(Color.black);
                            break;
                        }
                        case "tainted":
                        default: {
                            g.setColor(Color.lightGray);
                            break;
                        }
                    }
                    //</editor-fold>
                    int w = panel4Pic.getWidth() / 2;
                    int h = panel4Pic.getHeight();
                    g.fillRect(w / 10, h / 10, (int) (w * 0.8), (int) (h * 0.8));
                    int ss = GlobalMethods.fromHex(getsize());
                    if (ss > 10) {
                        ss = 10;
                    }
                    if (ss == 0) {
                        g.setColor(Color.gray);
                        g.drawOval(w / 4, w / 4, (int) (w * 0.5), (int) (w * 0.5));
                    }
                    int c = w / 2;
                    int d = (int) ((w * 0.8));
                    int dm = d * ss / 10;
                    g.setColor(Color.green);
                    g.fillOval(c - (dm / 2), c - (dm / 2), dm, dm);
                    int hy = GlobalMethods.fromHex(gethydro());
                    int hm = hy * dm / 10;
                    g.setColor(Color.blue);
                    g.fillOval(c - (hm / 2), c - (hm / 2), hm, hm);
                    g.setColor(Color.BLACK);
                    break;
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="case "Worlds"">
                case "Worlds": {
                    pix = new String[]{"Star"};
                    cc = Color.GRAY;
                    backdetails = new String[]{
                        "" + "",
                        "Pop" + countPop(),
                        "TL" + " " + Panel4T5Locator.UWP.substring(8, 9),
                        "W" + " " + Panel4T5Locator.jLabel12.getText(),
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + "",
                        "" + ""};
                    break;
                }
                //</editor-fold>
            }
            File d = new File(base + dir);
            if (!d.exists()) {
                d.mkdir();
            }
            if (!"World".equals(Folder.getSelectedItem().toString().trim())) {
                g.setColor(cc);
                g.fillRect(0, 0, 100, 100);
            }
            g.setColor(Color.BLACK);
            drawOutline();
            for (int j = 0; j < pix.length; j++) {
                if (!pix[j].isEmpty()) {
                    String name = _GIF + FS + pix[j] + ".gif";
                    System.out.println("" + " = " + name);
                    loadgifc(new File(name));
                }
                System.out.println("" + " = ");
            }
//      clearTexts();
            bc[0] = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
            for (int j = 1; j < 10; j++) {
                bc[j] = frontdetails[j];
                bc[j] = backdetails[j];
            }
            if ("Blank".equals(s)) {
                fc[0] = "";
                bc[0] = "";
            }
            printText(g);
        }
//    drawWorldPic();
    }

    static void drawWorldPic() {
        String zone = jtfs[19].getText().substring(jtfs[19].getText().length() - 1);
        int ss = 0;
        if (jtfs[11].getText().length() > 2) {
            ss = GlobalMethods.fromHex(jtfs[11].getText().substring(1, 2));
        }
        String atmo = "" + jtfs[11].getText().substring(2, 3);
        int hy = GlobalMethods.fromHex(jtfs[11].getText().substring(3, 4));
        //<editor-fold defaultstate="collapsed" desc="switch (zone.toLowerCase())">
        switch (zone.toLowerCase()) {
            case "r": {
                g.setColor(Color.red);
                break;
            }
            case "a": {
                g.setColor(Color.orange);
                break;
            }
//      case "g":
//      case "-":
            default: {
                g.setColor(Color.green);
                break;
            }
        }
        //</editor-fold>
        g.fillRect(0, 0, 100, 100);
        //<editor-fold defaultstate="collapsed" desc="switch (atmo.toLowerCase())">
        switch (atmo.toLowerCase()) {
            case "5":
            case "6":
            case "8":
            case "normal": {
                g.setColor(Color.cyan);
                break;
            }
            case "0":
            case "1":
            case "vaccuum": {
                g.setColor(Color.black);
                break;
            }
            case "tainted":
            default: {
                g.setColor(Color.lightGray);
                break;
            }
        }
        //</editor-fold>
        int w = panel4Pic.getWidth() / 2;
        int h = panel4Pic.getHeight();
        g.fillRect(w / 10, h / 10, (int) (w * 0.8), (int) (h * 0.8));
        if (ss == 0) {
            g.setColor(Color.gray);
            g.drawOval(w / 4, w / 4, (int) (w * 0.5), (int) (w * 0.5));
        }
        int c = w / 2;
        int d = (int) ((w * 0.8));
        int dm = d * ss / 10;
        g.setColor(Color.green);
        g.fillOval(c - (dm / 2), c - (dm / 2), dm, dm);
        int hm = hy * dm / 10;
        g.setColor(Color.blue);
        g.fillOval(c - (hm / 2), c - (hm / 2), hm, hm);
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = true;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("zone" + " = " + zone);
            System.out.println("ss" + " = " + ss);
            System.out.println("atmo" + " = " + atmo);
            System.out.println("hy" + " = " + hy);
        }
        //</editor-fold>
    }

    static void saveCounters() {
        for (int j = 0; j < Folder.getItemCount(); j++) {
            Folder.setSelectedIndex(j);
            savePic();
        }
    }

    static void savePic() {
        dir = T5;
        String sys = Panel4T5Locator.getSysPath();
        String folder = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
        dir = sys + FS + folder;
        String world = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
        String hex = world.substring(0, 4);
        counter = Folder.getSelectedItem().toString();
        fname = hex + "-" + counter;
        try {
            /*
       CHANGE LINE BELOW
             */
            fname = jLabel13.getText();
            File out = new File(dir, fname + ".gif");
            if (bi != null) {
                ImageIO.write(bi, "gif", out);
            }
            out = new File(dir, fname + ".txt");
            String it = GlobalMethods.loadTextFile(dir, fname, ".txt");
            if (!it.startsWith(t4Write.getText())) {
                GlobalMethods.saveTextFile(dir, fname, ".txt",
                        (t4Write.getText() + CRLF + it));
            }
        } catch (IOException ex) {
            System.out.println("2604 ex" + " = " + ex);
            Logger.getLogger(Panel4T5CounterMaker.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    /**
     *
     * @param x old x coords
     * @return new x coords
     */
    public static int fixx(int x) {
        return fix(x);
    }

    /**
     *
     * @param y old y value of cyberboard
     * @return updated value
     */
    public static int fixy(int y) {
        return fix(y);
    }

    private static int fix(int i) {
        int step = (int) Step.getValue();
        while (i % step != 0) {
            i--;
        }
        return i;
    }

    /**
     *
     * @param ff file containing gif pic
     */
    public static void loadgif(File ff) {
        fil = ff;
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        try {
            for (int j = 0; j < 3; j++) {
                //<editor-fold defaultstate="collapsed" desc="getGraphics">
                switch (i) {
                    case 0: {
                        g = panel4Pic.getGraphics();
                        break;
                    }
                    case 1: {
                        g = Panel4T5Locator.panel4Pic.getGraphics();
                        break;
                    }
                    case 2: {
                        g = bi.getGraphics();
                        break;
                    }
                }
                //</editor-fold>
//        jt4File.setText("");
                BufferedImage bim = ImageIO.read(ff);
                ff = new File(ff.toString());
                int w = bim.getWidth();
                int h = bim.getHeight();
                int x = (int) jSpinnerX.getValue();
                int y = (int) jSpinnerY.getValue();
                g = panel4Pic.getGraphics();
                g.drawImage(bim, x - (w / 2), y - (h / 2), w, h, null);
                int startat = ff.toString().lastIndexOf(FS) + 1;
                int end = ff.toString().lastIndexOf(".");
                String f = ff.toString().substring(startat, end);
                jt4File.setText(f);
                file = f;
                jfc.setFileFilter(gifFilter);
                jfc.setSelectedFile(ff);
                //<editor-fold defaultstate="collapsed" desc="DEBUG">
                //DEBUG = false;
                if (DEBUG) {
                    System.out.println("fil.toString()" + " = " + ff.toString());
                    System.out.println("dira" + " = " + dira);
                    System.out.println("file" + " = " + file);
                    System.out.println("ext" + " = " + ext);
                }
                //</editor-fold>

            }
        } catch (IOException ex) {
            System.out.println(
                    "1562 loadgif(File file)" + " = " + ex.toString() + CRLF + ex
                    .getLocalizedMessage());
        }
    }

    private static void loadgif(Graphics g, File ff) {
        Panel4T5CounterMaker.g = g;
        loadgif(ff);
    }

    /**
     *
     * @param ff file containing gif pic
     */
    public static void loadgifc(File ff) {
        fil = ff;
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
            System.out.println("ff" + " = " + ff.toString());
        }
        //</editor-fold>
        for (int j = 0; j < 3; j++) {
            try {
                jt4File.setText("");
                BufferedImage bim = ImageIO.read(ff);
                int w = bim.getWidth();
                int h = bim.getHeight();
                int x = 50 - (w / 2);
                int y = 50 - (h / 2);
                jSpinnerX.setValue(fixx(x));
                jSpinnerY.setValue(fixy(y));
                jSpinnerW.setValue(w);
                jSpinnerH.setValue(h);
                //<editor-fold defaultstate="collapsed" desc="getGraphics">
                switch (i) {
                    case 0: {
                        g = panel4Pic.getGraphics();
                        break;
                    }
                    case 1: {
                        try {
                            g = Panel4T5Locator.panel4Pic.getGraphics();
                        } catch (Exception e) {
                            g = panel4Pic.getGraphics();
                        } finally {

                        }
                        break;
                    }
                    case 2: {
                        g = bi.getGraphics();
                        break;
                    }
                }
                //</editor-fold>
                try {
                    g.drawImage(bim, x, y, w, h, null);
                } catch (Exception e) {
                } finally {
                    int startat = ff.toString().lastIndexOf(FS) + 1;
                    int end = ff.toString().lastIndexOf(".");
                    String f = ff.toString().substring(startat, end);
                    jt4File.setText(f);
                    file = f;
                    jfc.setFileFilter(gifFilter);
                    jfc.setSelectedFile(ff);
                    //<editor-fold defaultstate="collapsed" desc="DEBUG">
                    //DEBUG = false;
                    if (DEBUG) {
                        System.out.println("fil.toString()" + " = " + ff.toString());
                        System.out.println("dira" + " = " + dira);
                        System.out.println("ff" + " = " + ff.toString());
                        System.out.println("ext" + " = " + ext);
                    }
                    //</editor-fold>
                }
            } catch (IOException ex) {
                System.out.println(
                        "1522 loadgifc(File file)" + " = " + ex.toString() + CRLF + ex
                        .getLocalizedMessage());
            }
        }
    }

    /**
     *
     * @param g Graphics context area
     * @param ff file containing gif pic
     */
    public static void loadgifc(Graphics g, File ff) {
        Panel4T5CounterMaker.g = g;
        loadgif(ff);
    }

    /**
     * <p>
     * @param x width of string
     * @param y height of string
     * @param str string to add to graphic
     * @return string in graphic format (x * str.length() by y pixels)
     */
    public static BufferedImage strToSmall(int x, int y, String str) {
        BufferedImage bi = null;
        if ((x != 0) & (y != 0)) {
            bi = new BufferedImage(str.length() * (x + 1), y,
                    BufferedImage.TYPE_INT_ARGB);
            Image[] im = new Image[str.length()];
            Graphics2D createGraphics = bi.createGraphics();
            BufferedImage m;
            String strings = "";
            for (int i = 0; i < str.length(); i++) {
                String name = _GIF + x + y + str.substring(i, i + 1).toUpperCase()
                        + ".gif";
                File f = new File(name);
                try {
                    m = ImageIO.read(f);
                    createGraphics.drawImage(m, null, i * 4, 0);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Folder, _GIF + x + y + str
                            .substring(i, i + 1).toUpperCase() + ".gif");
                    strings += str.substring(i, i + 1) + CRLF;
                    strings += "1291";
                }
            }
        }
        return bi;
    }

    //<editor-fold defaultstate="collapsed" desc="image2Pic">
    //  static void image2Pic(String name) {
    //    //<editor-fold defaultstate="collapsed" desc="DEBUG">
    //    boolean DEBUG = false;
    //    if (DEBUG) { // true or false
    //      System.out.print(dbviewer.globals.GlobalMethods.comment("=", 20));
    //      System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
    //      System.out.print(dbviewer.globals.GlobalMethods.comment("-", 20));
    //    }
    ////</editor-fold>
    //    BufferedImage bi;
    //    File f = null;
    //    int w = 100, h = 100;
    //    switch (name) {
    //      case "squadron": {
    //        w = 200;
    //        h = 100;
    //        f = new File(Panel4T5Locator.getSysPath() + FS
    //          + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().substring(0, 4)
    //          + "-" + Panel4Squadron.sidn.getText() + ".gif");
    //        break;
    //      }
    //      case "utp": {
    //        w = 200;
    //        h = 100;
    //        f = new File(Panel4T5Locator.getSysPath() + FS
    //          + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().substring(0, 4)
    //          + "-" + Panel4T5Troop.jLabel3.getText() + ".gif");
    //        break;
    //      }
    //    }
    //    try {
    //      bi = ImageIO.read(f);
    //    } catch (IOException ex) {
    //      bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    //      System.out.println("FAIL load image2Pic " + f.toString());
    //    }
    //    Graphics2D g = bi.createGraphics();
    //    //g.setColor(jf.getBackground());
    //    switch (name) {
    //      case "squadron": {
    //        g.setColor(Color.CYAN);
    //        color = Color.CYAN;
    //        break;
    //      }
    //      case "utp": {
    //        g.setColor(Color.RED);
    //        color = Color.RED;
    //        break;
    //      }
    //    }
    //    g.fillRect(0, 0, w, h);
    //
    //    if (name.equals("squadron")) {
    //      //<editor-fold defaultstate="collapsed" desc="left panel">
    //      try {
    //        g.setColor(color);
    //        g.fillRect(0, 0, 100, 100);
    //        g.setColor(Color.black);
    //        g.drawRect(0, 0, 100, 100);
    //
    //        Image im = ImageIO.read(new File(_GIF + "lines.gif"));
    //
    //        Panel4UTP.centerOnY(im, 0, 100);
    //
    //        // Squadron Type
    //        BufferedImage bii1 = Panel4UTP.strToSmall(3, 5,
    //          Panel4Squadron.jComboBox0.getSelectedItem().toString().substring(0, 2));
    //        g.drawImage(bii1, Panel4UTP.centerOnX(bii1, 29, 0), 25, null);
    //
    //        // Home hex
    //        BufferedImage bi1 = Panel4UTP.strToSmall(3, 5,
    //          Panel4Squadron.jf.getTitle().substring(0, 4));
    //        g.drawImage(bi1, Panel4UTP.centerOnX(bi1, 51, 0), 25, null);
    //        // Fleet ID
    //        BufferedImage bi11 = Panel4UTP.strToSmall(3, 5,
    //          Panel4Squadron.sidn.getText());
    //        g.drawImage(bi11, Panel4UTP.centerOnX(bi11, 51, 0), 31, null);
    //
    //        // Streamlining and Jump to middle left box
    //        BufferedImage bi00 = Panel4UTP.strToSmall(3, 5,
    //          Panel4Squadron.ns.getText().substring(0, 1) + "SL");
    //        g.drawImage(bi00, Panel4UTP.centerOnX(bi00, 29, 0), 43, null);
    //        //      int s1 = jtf4CF.getText().indexOf("(");
    //        BufferedImage bi0021 = Panel4UTP.strToSmall(3, 5,
    //          "J " + Panel4Squadron.nj.getText());
    //        g.drawImage(bi0021, Panel4UTP.centerOnX(bi0021, 29, 0), 49, null);
    //
    //        // TF to middle right box
    //        BufferedImage bi0 = Panel4UTP.strToSmall(3, 5, "TF");
    //        g.drawImage(bi0, Panel4UTP.centerOnX(bi0, 73, 0), 43, null);
    //        //      int s1 = jtf4CF.getText().indexOf("(");
    //        BufferedImage bi021 = Panel4UTP.strToSmall(3, 5,
    //          Panel4Squadron.nt.getText());
    //        g.drawImage(bi021, Panel4UTP.centerOnX(bi021, 73, 0), 49, null);
    //
    //        // DF to bottom left box
    //        BufferedImage bi2 = Panel4UTP.strToSmall(3, 5, "DF");
    //        g.drawImage(bi2, Panel4UTP.centerOnX(bi2, 29, 0), 61, null);
    //        //      int s1 = jtf4CF.getText().indexOf("(");
    //        BufferedImage bi21 = Panel4UTP.strToSmall(3, 5,
    //          Panel4Squadron.nd.getText());
    //        g.drawImage(bi21, Panel4UTP.centerOnX(bi21, 29, 0), 67, null);
    //
    //        // AF to bottom middle box
    //        BufferedImage bi3 = Panel4UTP.strToSmall(3, 5, "AF");
    //        g.drawImage(bi3, Panel4UTP.centerOnX(bi3, 51, 0), 61, null);
    //        //      int s2 = jtf4CF.getText().indexOf(")");
    //        BufferedImage bi31 = Panel4UTP.strToSmall(3, 5,
    //          Panel4Squadron.na.getText());
    //        g.drawImage(bi31, Panel4UTP.centerOnX(bi31, 51, 0), 67, null);
    //
    //        // BF to bottom right box
    //        BufferedImage bi4 = Panel4UTP.strToSmall(3, 5, "BF");
    //        g.drawImage(bi4, Panel4UTP.centerOnX(bi4, 73, 0), 61, null);
    //        BufferedImage bi41 = Panel4UTP.strToSmall(3, 5,
    //          Panel4Squadron.nb.getText());
    //        g.drawImage(bi41, Panel4UTP.centerOnX(bi41, 73, 0), 67, null);
    //        //    } catch (IOException ex) {
    //        //      Logger.getLogger(Panel4UTP.class.getName()).log(Level.SEVERE, null, ex);
    //        //    }
    //      } catch (IOException ex) {
    //        Logger.getLogger(Panel4Squadron.class.getName()).log(Level.SEVERE, null, ex);
    //        System.out.println("" + " = " + ex.toString());
    //      }
    //      BufferedImage pc = null;
    //      try {
    //        pc = ImageIO.read(new File(Panel4Squadron.folder + Panel4Squadron.pic));
    //        g.drawImage(pc, Panel4UTP.centerOnX(pc, 50, 0), 46, null);
    //      } catch (IOException ex) {
    //        Logger.getLogger(Panel4Squadron.class.getName()).log(Level.SEVERE, null, ex);
    //      }
    //      //</editor-fold>
    //      //<editor-fold defaultstate="collapsed" desc="right panel">
    //      //2nd Panel
    //      int left = 100;
    //      int tops = 0;
    //      int wid = 100;
    //      int hgt = 100;
    //      int r = 10;
    //      g.setColor(color);
    //      g.fillRect(left, tops, wid, hgt);
    //      g.setColor(Color.black);
    //      g.drawRect(left, tops, wid, hgt);
    //      Panel4Squadron.titles = new String[]{"ID", "TYPE", "S/L", "JUMP", "TF", "DF", "AF", "BF"};
    //      Panel4Squadron.values = new String[]{sidn.getText(),
    //        Panel4Squadron.sron.getText(), Panel4Squadron.ns.getText(),
    //        Panel4Squadron.nj.getText(), Panel4Squadron.nt.getText(),
    //        Panel4Squadron.nd.getText(), Panel4Squadron.na.getText(),
    //        Panel4Squadron.nb.getText()
    //      };
    //      for (int i = 0; i < 8; i++) {
    //        g.drawString(Panel4Squadron.titles[i], left + 2, tops + 15 + (i * 11));
    //        g.drawString(Panel4Squadron.values[i], left + 37, tops + 15 + (i * 11));
    //      }
    //      //</editor-fold>//Right
    //    }
    //    if (name.equals("utp")) {
    //      //<editor-fold defaultstate="collapsed" desc="comment">
    //      left = 0;
    //      top = 0;
    //      fo = g.getFont();
    //      fm = g.getFontMetrics();
    //      fw = (int) (fm.getStringBounds(str, g).getWidth() / 2);
    //      fh = (int) (fm.getStringBounds(str, g).getHeight() / 2);
    //      File[] files = new File[6];
    //      Image[] images = new Image[6];
    //      lines = new String[]{str1, str2, str3, str4, str5, str6, str7, str8};
    //      replies = new String[]{"", "", "", "", "", "", "", ""};
    //      JComboBox jcb = new JComboBox();
    //      JComboBox[] jcbs = new JComboBox[]{
    //        Panel4T5Troop.jcb4Size, Panel4T5Troop.jcb4Quality,
    //        Panel4T5Troop.jcb4Armament, Panel4T5Troop.jcb4Type
    //      };
    //      String fname = "";//jf.getTitle() + "-" + jSpinner1.getValue() + ".gif";
    //      //<editor-fold defaultstate="collapsed" desc="2nd panel">
    //      //2nd Panel
    //      left += wid;
    //      g.setColor(col);
    //      g.fillRect(left, top, wid, hgt);
    //      g.setColor(Color.black);
    //      g.drawRect(left, top, wid, hgt);
    //
    //      g.setColor(Color.black);
    //      for (int i = 0; i < jcbs.length; i++) {
    //        jcb = jcbs[i];
    //        replies[i] = jcb.getSelectedItem().toString().substring(2);
    //        g.drawString(lines[i], left + 2, top + 15 + (i * 11));
    //        g.drawString(replies[i], left + 32, top + 15 + (i * 11));
    //      }
    //      replies[4] = jTextField1.getText();
    //      replies[5] = "" + (CF * Integer.parseInt(jLabel8.getText()));
    //      replies[6] = jtf4CF.getText();
    //      jLabel16.setText(replies[6]);
    //      replies[7] = jSpinner1.getValue().toString();
    //      for (int i = 4; i < replies.length; i++) {
    //        str = lines[i];
    //        g.drawString(str, left + 2, top + 15 + (i * 11));
    //        str = replies[i];
    //        g.drawString(str, left + 42, top + 15 + (i * 11));
    //      }
    //      //</editor-fold>
    //      //<editor-fold defaultstate="collapsed" desc="1st panel">
    //      //1st Panel
    //      left -= wid;
    //      g.setColor(col);
    //      g.fillRect(left, top, wid, hgt);
    //      g.setColor(Color.black);
    //      g.drawRect(left, top, wid, hgt);
    //      try {
    //        Image im = ImageIO.read(new File(bmp + "lines.gif"));
    //        g.drawImage(im, centerOnX(im, left, wid), centerOnY(im, top, hgt), null);
    //      } catch (IOException ex) {
    //        Logger.getLogger(Panel4UTP.class.getName()).log(Level.SEVERE, null, ex);
    //      }
    //      for (int i = 0; i < files.length; i++) {
    //        switch (i) {
    //          case 0: {
    //            //<editor-fold defaultstate="collapsed" desc="jcb4Size.getSelectedItem().toString()">
    //            switch (jcb4Size.getSelectedItem().toString()) {
    //              case "0-Company": {
    //                str = "I";
    //                break;
    //              }
    //              case "1-Battalion": {
    //                str = "II";
    //                break;
    //              }
    //              case "2-Regiment": {
    //                str = "III";
    //                break;
    //              }
    //              case "3-Brigade": {
    //                str = "IIII";
    //                break;
    //              }
    //              case "4-Division": {
    //                str = "X";
    //                break;
    //              }
    //              case "5-Corps": {
    //                str = "XX";
    //                break;
    //              }
    //              case "6-Army": {
    //                str = "XXX";
    //                break;
    //              }
    //              case "7-Army Group": {
    //                str = "XXXX";
    //                break;
    //              }
    //              default: {
    //                break;
    //              }
    //            }
    //            //</editor-fold>
    //            BufferedImage biq = strToSmall(3, 5, str);
    //            g.drawImage(biq, centerOnX(biq, 51, 0), 42, null);
    //            break;
    //          }
    //          case 1: {
    //            //<editor-fold defaultstate="collapsed" desc="jcb4Quality.getSelectedItem().toString()">
    //            switch (jcb4Quality.getSelectedItem().toString()) {
    //              case "1-Elite": {
    //                fname = "launch.gif";
    //                break;
    //              }
    //              default: {
    //                fname = "";
    //                break;
    //              }
    //            }
    //            //</editor-fold>
    //            break;
    //          }
    //          case 2: {
    //            //<editor-fold defaultstate="collapsed" desc="jcb4Armament.getSelectedItem().toString()">
    //            switch (jcb4Armament.getSelectedItem().toString()) {
    //              case "1-Armoured": {
    //                fname = "armor.gif";
    //                break;
    //              }
    //              default: {
    //                fname = "";
    //                break;
    //              }
    //            }
    //            //</editor-fold>
    //            break;
    //          }
    //          case 3: {
    //            //<editor-fold defaultstate="collapsed" desc="jcb4Type.getSelectedItem().toString()">
    //            switch (jcb4Type.getSelectedItem().toString()) {
    //              case "0-Infantry": {
    //                fname = "infantry.gif";
    //                break;
    //              }
    //              case "1-Cavalry": {
    //                fname = "cavalry.gif";
    //                break;
    //              }
    //              case "2-Marines": {
    //                fname = "IM.gif";
    //                break;
    //              }
    //              case "3-Jump Troops": {
    //                fname = "airborne.gif";
    //                break;
    //              }
    //              case "4-Guerilla": {
    //                fname = "G.gif";
    //                break;
    //              }
    //              default: {
    //                fname = "";
    //                break;
    //              }
    //            }
    //            //</editor-fold>
    //            break;
    //          }
    //          case 4: {
    //            //<editor-fold defaultstate="collapsed" desc="jcb4Mobility.getSelectedItem().toString()">
    //            switch (jcb4Mobility.getSelectedItem().toString()) {
    //              case "Grav": {
    //                fname = "Grav.gif";
    //                break;
    //              }
    //              case "Wheeled": {
    //                fname = "Wheeled.gif";
    //                break;
    //              }
    //              case "Tracked": {
    //                fname = "Tracked.gif";
    //                break;
    //              }
    //              default: {
    //                fname = "";
    //                break;
    //              }
    //            }
    //            //</editor-fold>
    //            break;
    //          }
    //          default: {
    //            fname = "";
    //            break;
    //          }
    //        }
    //        //      System.out.println("fname" + " = " +fname);
    //        //      System.out.println("i" + " = " +i);
    //        try {
    //          if (!"".equals(fname)) {
    //            files[i] = new File(bmp + fname);
    //            images[i] = ImageIO.read(files[i]);
    //            int x, y;
    //            x = centerOnX(images[i], left, wid);
    //            y = centerOnY(images[i], top, hgt);
    //            switch (i) {
    //              case 1: {
    //                g.drawImage(images[i], x - 8, y - 7, null);
    //                break;
    //              }
    //              case 4: {
    //                g.drawImage(images[i], x, y + 7, null);
    //                break;
    //              }
    //              default: {
    //                g.drawImage(images[i], x, y, null);
    //                break;
    //              }
    //            }
    //          }
    //        } catch (IOException ex) {
    //          Logger.getLogger(Panel4UTP.class.getName()).log(Level.SEVERE, null, ex);
    //        }
    //      }
    //      // ID to top centre box
    //      BufferedImage bi1 = strToSmall(3, 5, jf.getTitle().substring(0, 4));
    //      g.drawImage(bi1, centerOnX(bi1, 51, 0), 25, null);
    //      BufferedImage bi11 = strToSmall(3, 5, jTextField1.getText());
    //      g.drawImage(bi11, centerOnX(bi11, 51, 0), 31, null);
    //      // CF to bottom left box
    //      BufferedImage bi2 = strToSmall(3, 5, "CF");
    //      g.drawImage(bi2, centerOnX(bi2, 29, 0), 61, null);
    //      int s1 = jtf4CF.getText().indexOf("(");
    //      BufferedImage bi21 = strToSmall(3, 5, jtf4CF.getText().substring(0, s1));
    //      g.drawImage(bi21, centerOnX(bi21, 29, 0), 67, null);
    //      // TF to bottom middle box
    //      BufferedImage bi3 = strToSmall(3, 5, "TF");
    //      g.drawImage(bi3, centerOnX(bi3, 51, 0), 61, null);
    //      int s2 = jtf4CF.getText().indexOf(")");
    //      BufferedImage bi31 = strToSmall(3, 5, jtf4CF.getText().substring(s1 + 1, s2));
    //      g.drawImage(bi31, centerOnX(bi31, 51, 0), 67, null);
    //      // TL to bottom right box
    //      BufferedImage bi4 = strToSmall(3, 5, "TL");
    //      g.drawImage(bi4, centerOnX(bi4, 73, 0), 61, null);
    //      BufferedImage bi41 = strToSmall(3, 5, jLabel11.getText());
    //      g.drawImage(bi41, centerOnX(bi41, 73, 0), 67, null);
    //      //g.dispose();
    //      //</editor-fold>//Left
    //      top = 0;
    //      left = 0;
    //      try {
    //        jLabel11.setText(Panel4SubSector.UWP.getText().substring(7, 8));
    //        jLabel2.setText(Panel4SubSector.troopunits.getText());
    //      } catch (Exception e) {
    //      }
    ////      try {
    ////        ImageIO.write(bi, "gif", f);
    ////        System.out.println("" + " = " + f.toString());
    ////      } catch (IOException ex1) {
    ////        System.out.println("" + " = " + ex1);
    ////        Logger.getLogger(Panel4World.class.getName())
    ////                .log(Level.SEVERE, null, ex1);
    ////      }
    //      //</editor-fold>
    //    }
    //    try {
    //      ImageIO.write(bi, "gif", f);
    //      System.out.println("SUCCEED" + " = " + f.toString());
    //    } catch (IOException ex1) {
    //      System.out.println("FAIL save image2Pic" + " = " + ex1);
    //    }
    //  }
    //
    //</editor-fold>
    /**
     * <p>
     * @param image to centre on
     * @param left of image
     * @param wid of image
     * @return x mod
     */
    public static int centerOnX(Image image, int left, int wid) {
        int iw = image.getWidth(null) / 2;
        int bw = wid / 2;
        int reply = left + (bw - iw);
        return reply;
    }

    /**
     * <p>
     * @param image to centre on
     * @param top of image
     * @param hgt of image
     * @return y mod
     */
    public static int centerOnY(Image image, int top, int hgt) {
        int ih = image.getHeight(null) / 2;
        int bh = hgt / 2;
        int reply = top + (bh - ih);
        return reply;
    }

    private void countFolders(JComboBox<String> jcb) {
        int len = 0;
        String dir = _CFG + FS + "T5" + FS + "T5C";
        File f = new File(dir);
        String[] lines = f.list();
        jcb = new JComboBox<>(lines);
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            for (int j = 0; j < lines.length; j++) {
                System.out.println(lines[j]);
            }
            System.out.println("" + " = " + Folder.getModel().getSize());
        }
        //</editor-fold>
    }

    private void setDragEnabled(boolean b) {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("setDragEnabled" + " = " + b);
        }
        //</editor-fold>
    }

    private void setDropMode(DropMode dropMode) {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("setDropMode(dropMode)" + " = " + dropMode);
        }
        //</editor-fold>
    }

    static void loadOldList(String part) {
        File f = new File(T5C + FS + counter);
        String[] files = f.list();
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println(f.toString());
            System.out.println("files.length" + " = " + files.length);
        }
        //</editor-fold>
        int len = 8;//max len to ignore
        switch (counter) {
            case "Squadron":
            case "Troop": {
                len = 8;
                break;
            }
            default: {
                len = 7;
            }
        }
        ta4Read.setText("");
        for (int j = 0; j < files.length; j++) {
            if (files[j].length() > len) {
                ta4Read.append(files[j] + CRLF);
            }
        }
    }

    private void loadText() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            //System.out.println("" + " = " + );
        }
        //</editor-fold>
        try {
            dir = T5C;
            String[] lines = ta4Read.getText().split(CRLF);
            int o = ta4Read.getCaretPosition();
            int l = ta4Read.getLineOfOffset(o);
            String path = dir + FS + counter;
            String opath = dir;
            String oline = lines[l];
            String name = "";
            String oall = opath + FS + oline;
            String[] txt = GlobalMethods.getLinesFromFile(new File(
                    opath + FS + counter + FS + oline));
            //<editor-fold defaultstate="collapsed" desc="DEBUG">
            if (DEBUG) { // true or false
                System.out.print(GlobalMethods.comment("=", 80));
                System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                        .getMethodName());
                System.out.println("counter" + " = " + counter);
                System.out.println("c" + " = " + c);
                System.out.println("dir" + " = " + dir);
                System.out.println("path" + " = " + path);
                System.out.println("o" + " = " + o);
                System.out.println("l" + " = " + l);
                System.out.println("lines[0]" + " = " + lines[0]);
                System.out
                        .println("path + FS + lines[l]" + " = " + path + FS + lines[l]);
                System.out.println("opath" + " = " + opath);
                System.out.println("oline" + " = " + oline);
                System.out.println("oall" + " = " + oall);
            }
            //</editor-fold>
            t4Write.setText("");
            int b = 0;
            for (int i = 0; i < txt.length; i++) {
                t4Write.append(txt[i] + CRLF);
                if (txt[i].startsWith("/////")) {
                    b = i + 1;
                }
            }
            for (int j = b; j < txt.length; j++) {
                if (txt[j].equals("FC")) {
                    for (int k = 0; k < 10; k++) {
                        fc[k] = txt[j + k + 1].substring(3);
                        jtfc[k] = txt[j + k + 1].substring(3);
                    }
                }
            }
            for (int j = b; j < txt.length; j++) {
                if (txt[j].equals("BC")) {
                    for (int k = 0; k < 10; k++) {
                        bc[k] = txt[j + k + 1].substring(3);
                        jtbc[k] = txt[j + k + 1].substring(3);
                    }
                }
            }
        } catch (BadLocationException ex) {
            System.out.println("1056" + " = " + ex);
            Logger.getLogger(Panel4T5CounterMaker.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
//    drawWorldPic();
    }

    private void modText() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            //System.out.println("" + " = " + );
        }
        //</editor-fold>
        try {
            dir = T5C;
            String[] lines;
            lines = ta4Read.getText().split(CRLF);
            int o = ta4Read.getCaretPosition();
            int l = ta4Read.getLineOfOffset(o);

            String path = dir + FS + counter;
            String opath = dir.substring(0, dir.lastIndexOf(FS)) + FS + "TXT";
            String oline = lines[l].substring(0, lines[l].length() - 4) + "-0.txt";
            String name = "";
            String[] txt = GlobalMethods
                    .getLinesFromFile(new File(opath + FS + oline));
            t4Write.setText("");
            for (int j = 0; j < txt.length; j++) {
                name = oline.replace("-0.txt", "");
                if (txt[j].startsWith("//")) {
                    t4Write.append(txt[j] + CRLF);
                } else {
                    t4Write.append("// " + txt[j] + CRLF);
                }
            }
            t4Write.append(GlobalMethods.comment("/", 80));
//      t4Write.append("// " + name + CRLF);
            bc[0] = name;
            t11.setText(name);
            //insert text fields
            String[] jtfs = new String[10];
            String text = "";
            for (int j = 0; j < 2; j++) {
                switch (j) {
                    case 0: {
                        jtfs = jtfc;
                        text = "FC";
                        break;
                    }
                    case 1: {
                        jtfs = jtbc;
                        text = "BC";
                        break;
                    }
                }
                Panel4T5CounterMaker.jtfs[10].setText(name);
                t11.setText(name);
                t4Write.append(text + CRLF);
                for (int i = 0; i < 10; i++) {
                    if (jtfs[i] == null) {
                        jtfs[i] = "";
                    }
                    t4Write.append("" + (i) + " = " + jtfs[i] + CRLF);
                }
            }
            if (!"World".equals(counter)) {
                Panel4T5CounterMaker.jtfs[10].setText(name);
                t11.setText(name);
            } else {
                Panel4T5CounterMaker.jtfs[10].setText("");
                t11.setText("");
            }
            t4Write.append(GlobalMethods.comment("/", 80));
//      saveT5C(title);
            saveT5C(jLabel13.getText());
        } catch (BadLocationException ex) {
            System.out.println("1117 ex" + " = " + ex);
        }
    }

    private void openNotepad() {
        try {
            dir = "C:" + FS + "T5" + FS + "_CFG" + FS + "T5" + FS + "T5C";
            String[] lines;
            lines = ta4Read.getText().split(CRLF);
            int o = ta4Read.getCaretPosition();
            int l = 0;
            try {
                l = ta4Read.getLineOfOffset(o);
            } catch (BadLocationException ex) {
                System.out.println("1133" + " = " + ex);
                Logger.getLogger(Panel4T5CounterMaker.class.getName()).log(Level.SEVERE,
                        null, ex);
            }
            if (!lines[l].isEmpty()) {
                ProcessBuilder pb = new ProcessBuilder(
                        "\"C:\\Program Files (x86)\\Notepad++\\notepad++.exe\"",
                        dir + FS + counter + FS + lines[l]);
                pb.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Panel4T5CounterMaker.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    static void savePic(Graphics g) {
        Panel4T5CounterMaker.g = g;
        savePic();
    }

    private void saveAllCounters() {
        for (int j = 0; j < Folder.getModel().getSize(); j++) {
            Folder.setSelectedIndex(j);
            savePic();
        }
    }

    private static void saveT5C(String fname) {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            //System.out.println("" + " = " + );
            System.out.println("fname" + " = " + fname);
        }
        //</editor-fold>
        if (!"".equals(fname)) {
            String dir = "C:" + FS + "T5" + FS + "_CFG" + FS + "T5" + FS + "T5C" + FS
                    + counter;
            dir = T5 + FS + Panel4T5Locator.jcb4Sec.getSelectedItem().toString() + FS
                    + Panel4T5Locator.jcb4Sub.getSelectedItem().toString().trim() + FS
                    + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + FS
                    + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + FS;
            String ext = "t5c";
            String txt;
            txt = t4Write.getText();
            GlobalMethods.saveTextFile(dir, fname, ext, txt);
            //<editor-fold defaultstate="collapsed" desc="DEBUG">
            DEBUG = false;//true//false
            if (DEBUG) {
                System.out.print(dir + FS + fname + ext + CRLF);
            }
            //</editor-fold>
        }
    }

    static void clearTexts() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        for (int j = 0; j < 10; j++) {
            fc[j] = "";
            bc[j] = "";
        }
    }

    static void createBeltPic() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
//    if (Panel4T5Locator.running) {
        Panel4T5Locator.createCounters("Belts");
//    }
    }

    static void createDefBatPic() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        if (Panel4T5Locator.running) {
            Panel4T5Locator.createCounters("Defences");
        }
    }

    static void createGasPic() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        if (Panel4T5Locator.running) {
            Panel4T5Locator.createCounters("Gas Giants");
        }
    }

    static void createPopPic() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        if (Panel4T5Locator.running) {
            Panel4T5Locator.createCounters("Population");
        }
    }

    static void createSDBPic() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        if (Panel4T5Locator.running) {
            Panel4T5Locator.createCounters("SDBs");
        }
    }

    static void createSquadronPic() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        if (Panel4T5Locator.running) {
            Panel4T5Locator.createCounters("Squadrons");
        }
    }

    static void createTroopPic() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        if (Panel4T5Locator.running) {
            Panel4T5Locator.createCounters("Troops");
        }
    }

    static void createWorldsPic() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        if (Panel4T5Locator.running) {
            createCounter("Worlds");
        } else {
            //<editor-fold defaultstate="collapsed" desc="JOP">
            {
                String s = "";
                s += "" + CRLF;
                s += "2203" + CRLF;
                System.out.println(s);
                JTextArea jta = new JTextArea(s, 50, 80);
                JScrollPane jsp = new JScrollPane(jta);
//        JOptionPane.showMessageDialog(jf, jsp);
            }
            //</editor-fold>
        }
    }

    static void printText(Graphics g) {
        try {
            for (int j = 0; j < 10; j++) {
                if (bc[j].equals("X")) {
                    bc[j] = "0";
                }
                g.drawString(fc[j], 5, 10 + (j * 10));
                g.drawString(bc[j], 105, 10 + (j * 10));
            }
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }

    /**
     *
     * @return string containing max pop
     */
    public static String countPop() {
        int pop, pm;
        pop = GlobalMethods.fromHex(UWP.substring(4, 5));
        pm = GlobalMethods.fromHex(data[10].substring(6, 7));
        String s = "";
        if (pop > 2) {
            s = " K";
        }
        if (pop > 5) {
            s = " M";
        }
        if (pop > 8) {
            s = " B";
        }
        for (int j = 0; j < (pop % 3); j++) {
            pm *= 10;
        }
        String mynumber = null;
        try {
//      mynumber = NumberFormat.getInstance().format(pm) + s;
            mynumber = pm + s;
        } catch (Exception e) {
//      mynumber = NumberFormat.getInstance().format(pm / 1000) + "K";
            System.out.println("1024" + " = " + e.toString());
        }
        return "< " + mynumber;
    }

//  private static void loadBIM() {
//    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
//    boolean DEBUG = false;
//    //DEBUG = false;
//    if (DEBUG) { // true or false
//      System.out.print(GlobalMethods.comment("=", 80));
//      System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//      System.out.println("counter" + " = " + counter);
//    }
//    //</editor-fold>
//    BufferedImage bim = new BufferedImage(200, 100, BufferedImage.TYPE_INT_ARGB);
//    Graphics g2 = panel4Pic.getGraphics();
//    Image img = Panel4T5Locator.panel4Pic.createImage(null);
//    g2.drawImage(bim, 0, 0, null);
//  }
    /**
     * Clears graphic
     */
    public static void picClick() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        showBlank();
//    addCol(c);
        drawOutline();
        showBI();
//    pix = new String[]{};
    }

    private static void showBlank() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        l4Folder.setText(dira.replace("\\\\", "\\"));
        jt4File.setText("Blank");
        l4Ext.setText("gif");
        jSpinnerW.setValue(200);
        jSpinnerH.setValue(100);
        jSpinnerX.setValue(0);
        jSpinnerY.setValue(0);
        if (!"World".equals(Folder.getSelectedItem().toString().trim())) {

            try {
                drawBlank();
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, 200, 100);
                c = cc;
                g.setColor(c);
                g.fillRect(0, 0, 100, 100);
            } catch (Exception e) {
                System.out.println("2326" + " = " + e);
            }
            drawOutline();
        } else {
            g.setColor(Color.WHITE);
            g.fillRect(100, 0, 100, 100);
        }
    }

    /**
     * show buffered image?
     */
    public static void showBI() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
//      System.out.println("counter" + " = " + counter);
//      System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        Graphics g2 = panel4Pic.getGraphics();
        g2.drawImage(bi, 0, 0, null);
        drawOutline();
    }

    private void addColor(Color c) {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        for (int j = 0; j < 3; j++) {
            switch (j) {
                case 0: {
                    g = panel4Pic.getGraphics();
                    break;
                }
                case 1: {
                    g = Panel4T5Locator.panel4Pic.getGraphics();
                    break;
                }
                case 2: {
                    g = bi.getGraphics();
                    break;
                }
            }
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 200, 100);
            g.setColor(c);
            g.fillRect(0, 0, 100, 100);
            drawOutline();
            showBI();
        }
    }

    /**
     * setPicture
     */
    public static void setPicture() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
//    jfc.setAccessory(ipv);
        jfc.setFileFilter(gifFilter);
        jfc.setCurrentDirectory(new File(_GIF));
        int ret = jfc.showOpenDialog(null);
        if (ret == JFileChooser.APPROVE_OPTION) {
            String s = jfc.getSelectedFile().toString();
            if (!s.endsWith(".gif")) {
                s += ".gif";
            }
            loadgifc(new File(s));
            String t = jfc.getSelectedFile().toString();
            int start = 0;
            int end = t.lastIndexOf(".");
            //start
            if (t.contains(FS)) {
                start = t.lastIndexOf(FS) + 1;
                dir = t.substring(0, start);
            }
            //end
            if (t.contains(".")) {
                end = t.lastIndexOf(".");
                ext = t.substring(end + 1);
                l4Ext.setText(ext);
            }
            jt4File.setText(t.substring(start, end));
            file = jt4File.getText();
//      showChooser();
        }
    }

//  private static void clearText() {
//    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
//    boolean DEBUG = false;
//    //DEBUG = false;
//    if (DEBUG) { // true or false
//      System.out.print(GlobalMethods.comment("=", 80));
//      System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//      System.out.println("counter" + " = " + counter);
//      System.out.println("c" + " = " + c);
//    }
//    //</editor-fold>
//    for (int j = 0; j < jtfs.length; j++) {
//      jtfs[j].setText("");
//    }
//  }
    /**
     * showText
     */
    public static void showText() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        addText();
    }

    static void addText() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        int x = 0;
        g.setColor(Color.BLACK);
        for (int j = 0; j < 10; j++) {
            switch (l4Front.getText()) {
                case "L": {
                    g.drawString(jtfs[j].getText().trim(), 3, 10 + (j * 10));
                    break;
                }
                case "C": {
                    g
                            .drawString(jtfs[j].getText().trim(),
                                    centreString(jtfs[j].getText()),
                                    10 + (j * 10));
                    break;
                }
                case "R": {
                    g.drawString(jtfs[j].getText().trim(), rightString(jtfs[j].getText()),
                            10 + (j * 10));
                    break;
                }
            }
        }
        for (int j = 0; j < 10; j++) {
            switch (l4Back.getText()) {
                case "L": {
                    g.drawString(jtfs[j + 10].getText().trim(), 103, 10 + (j * 10));
                    break;
                }
                case "C": {
                    g.drawString(jtfs[j + 10].getText().trim(), centreString(jtfs[j + 10]
                            .getText()) + 100, 10 + (j * 10));
                    break;
                }
                case "R": {
                    g.drawString(jtfs[j + 10].getText().trim(), rightString(jtfs[j + 10]
                            .getText()) + 100, 10 + (j * 10));
                    break;
                }
            }
        }
    }

//  private static void addText(Graphics g) {
//    Panel4T5CounterMaker.g = g;
//    addText();
//  }
    private static int centreString(String text) {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            //System.out.println("" + " = " + );
        }
        //</editor-fold>
        font = l4Folder.getFont();
        int boxx = 100;
        FontMetrics metrics = g.getFontMetrics();
        int x = (boxx - metrics.stringWidth(text)) / 2;
        return x;
    }

    private static int rightString(String text) {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            //System.out.println("" + " = " + );
        }
        //</editor-fold>
        font = l4Folder.getFont();
        int boxx = 100;
        FontMetrics metrics = g.getFontMetrics();
        int x = boxx - metrics.stringWidth(text);
        return x;
    }

    private void selectColour() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        DBPublic.Colour();
        addColor(c);
        cc = c;
        jt4File.setText("" + c.getRed() + "," + c.getGreen() + "," + c.getBlue());
        jSpinnerW.setValue(200);
        jSpinnerH.setValue(100);
        jSpinnerX.setValue(0);
        jSpinnerY.setValue(0);
        //<editor-fold defaultstate="collapsed" desc="DEBUG">
        //DEBUG = false;
        if (DEBUG) {
            System.out.print("c" + " = " + c + CRLF);
        }
        //</editor-fold>
    }

//  private void insertText() {
//    //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
//    boolean DEBUG = false;
//    //DEBUG = false;
//    if (DEBUG) { // true or false
//      System.out.print(GlobalMethods.comment("=", 80));
//      System.out.println("\t" + Thread.currentThread().getStackTrace()[1].getMethodName());
//      //System.out.println("" + " = " + );
//    }
//    //</editor-fold>
//  }
    private void chooserChange(int ret) {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            //System.out.println("" + " = " + );
        }
        //</editor-fold>
        if (ret == JFileChooser.APPROVE_OPTION) {
            int start = 0, end = jfc.getSelectedFile().toString().length();
            dir = jfc.getCurrentDirectory().toString();
            file = jfc.getSelectedFile().toString();
            if (file.contains(FS)) {
                start = file.lastIndexOf(FS) + 1;
            }
            if (file.contains(".")) {
                end = file.lastIndexOf(".");
                ext = file.substring(file.lastIndexOf(".") + 1);
                l4Ext.setText(ext);
            } else {
                end = file.length();
            }
            file = jfc.getSelectedFile().toString().substring(start, end);
            ext = jfc.getSelectedFile().toString().substring(end);
            l4Folder.setText(dir);
            l4Folder.setToolTipText(dir);
            jt4File.setText(file);
            jfc.setCurrentDirectory(new File(dir));
            if (jfc.getSelectedFile().toString().endsWith(exts[0])) {
                jfc.setFileFilter(txtFilter);
            } else if (jfc.getSelectedFile().toString().endsWith(exts[1])) {
                jfc.setFileFilter(cfgFilter);
            } else if (jfc.getSelectedFile().toString().endsWith(exts[2])) {
                jfc.setFileFilter(gifFilter);
            } else {
            }
            filter = jfc.getFileFilter();
            jfc.setFileFilter(filter);
            showChooser();
        }
    }

    private static void drawBlank() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        String s = _GIF + FS + "Blank.gif";
        try {
            loadgifc(new File(s));
//    if (!"World".equals(Folder.getSelectedItem().toString().trim())) {
            g.setColor(WHITE);
            g.fillRect(0, 0, 200, 100);
            g.setColor(c);
            g.fillRect(0, 0, 100, 100);
        } catch (Exception e) {
            //<editor-fold defaultstate="collapsed" desc="JOP">
            {
                s = "2668 = ";
                s += e;
                JTextArea jta = new JTextArea(s, 50, 80);
                JScrollPane jsp = new JScrollPane(jta);
//        JOptionPane.showMessageDialog(jf, jsp);
                System.out.println(s);
            }
            //</editor-fold>
        }
//    }
    }

    private static void drawOutline() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            //System.out.println("" + " = " + );
        }
        //</editor-fold>
        try {
            g.setColor(Color.BLACK);
            for (int j = 0; j < 2; j++) {//H
                g.drawLine(0, j * 100, 200, j * 100);
            }
            for (int j = 0; j < 3; j++) {//V
                g.drawLine(j * 100, 0, j * 100, 100);
            }
        } catch (Exception e) {
            //<editor-fold defaultstate="collapsed" desc="JOP">
            {
                String s = "2703 = " + e;
                JTextArea jta = new JTextArea(s, 50, 80);
                JScrollPane jsp = new JScrollPane(jta);
//        JOptionPane.showMessageDialog(jf, jsp);
                System.out.println(s);
            }
            //</editor-fold>
        }
    }

    private static void showChooser() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("folder" + " = " + dir);
            System.out.println("file" + " = " + file);
            System.out.println("ext" + " = " + ext);
        }
        //</editor-fold>
    }

    private void wChange() {
    }

    private void hChange() {
    }

    private void xChange() {
    }

    private void yChange() {
    }

    private void saveText(String fname, String text) {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        String txt = "";
        {
            boolean DEBUG = false;
            //DEBUG = false;
            if (DEBUG) { // true or false
                System.out.print(GlobalMethods.comment("=", 80));
                System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                        .getMethodName());
                //System.out.println("DEBUG" + " = " + DEBUG);
                txt += GlobalMethods.comment("=", 80);
                txt += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName();
                System.out.print(GlobalMethods.comment("=", 80));
                System.out.println("FILE" + " = " + fname);
                System.out.println(text);
            }
        }
        //</editor-fold>
        dir = "C:" + FS + "T5" + FS + "_CFG" + FS + "T5" + FS + "TXT";
        ext = "txt";
        GlobalMethods.saveTextFile(dir, fname, ext, t4Write.getText());
    }

    static void getDataFromLocator() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            System.out.println("counter" + " = " + counter);
            System.out.println("c" + " = " + c);
        }
        //</editor-fold>
        jt4File.setText(Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
                .substring(0, 4) + " " + counter);
        c = cc;
        jSpinnerW.setValue(200);
        jSpinnerH.setValue(100);
        jSpinnerX.setValue(0);
        jSpinnerY.setValue(0);
        picClick();
        for (int j = 0; j < 10; j++) {
            jtfs[j].setText(jtfc[j].trim());
            jtfs[j + 10].setText(jtbc[j].trim());
        }
        showText();
        showBI();
        if (Folder.getSelectedItem().toString().equals("World")) {
            String s = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
            jt4File.setText(s);
            bc[0] = s;
        }
//    System.out.println("counter" + " = " + counter);
//    drawWorldPic();
    }

    static void saveConfig() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            //System.out.println("" + " = " + );
        }
        //</editor-fold>
        String folder = Folder.getSelectedItem().toString().trim() + FS;
        String dir = "";
        // if ship or vehicle
        dir = T5C + FS;
        //
        dir = T5 + FS + Panel4T5Locator.jcb4Sec.getSelectedItem().toString() + FS;
        dir += Panel4T5Locator.jcb4Sub.getSelectedItem().toString() + FS;
        dir += Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + FS;
        dir += Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
        //<editor-fold defaultstate="collapsed" desc="JOP">
        {
            String s = dir;
            s += "" + CRLF;
            s += "" + CRLF;
            JTextArea jta = new JTextArea(s, 50, 80);
            JScrollPane jsp = new JScrollPane(jta);
//      JOptionPane.showMessageDialog(null, jsp);
        }
        //</editor-fold>
        String file = t11.getText();
        String ext = ".t5c";
        String fpath = dir + FS + file + ext;
        if ((!"".equals(t11.getText())
                & (!"Ship".equals(Folder.getSelectedItem().toString()))
                & (!"Vehicle".equals(Folder.getSelectedItem().toString())))) {
            File f = new File(fpath);
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Panel4T5CounterMaker.class.getName()).log(
                            Level.SEVERE, null, ex);
                }
            }
            t4Write.setText("");
            t4Write.append("//\t" + t11.getText() + CRLF);
            t4Write.append(GlobalMethods.comment("/", 80));
            ta4Pix.setText("");
            if (pix.length != 0) {
                for (int j = 0; j < pix.length; j++) {
                    if (pix[j] != "") {
                        ta4Pix.append(pix[j] + CRLF);
                        if (j == 0) {
                            t4Write.append("// " + pix[j] + CRLF);
                        } else {
                            t4Write.append("// " + pix[j] + CRLF);
                        }
                    }
                }
            }
            t4Write.append("FC" + CRLF);
            for (int j = 0; j < 10; j++) {
                t4Write.append("" + j + " = " + jtfs[j].getText() + CRLF);
            }
            t4Write.append("BC" + CRLF);
            for (int j = 0; j < 10; j++) {
                t4Write.append("" + j + " = " + jtfs[(j + 10)].getText() + CRLF);
            }
//      saveT5C(t11.getText());
            saveT5C(jLabel13.getText());
        } else {
            System.out.println(Folder.getSelectedItem().toString());
            if (("".equals(t11.getText()))) {
                t11.setText("Blank");
            }
            if ("Ship".equals(Folder.getSelectedItem().toString())) {

            }
            if ("Vehicle".equals(Folder.getSelectedItem().toString())) {

            }
        }
        newWay();

    }

    static void deleteXConfig() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        //DEBUG = false;
        if (DEBUG) { // true or false
            System.out.print(GlobalMethods.comment("=", 80));
            System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                    .getMethodName());
            //System.out.println("" + " = " + );
        }
        //</editor-fold>
        String dir = T5C + FS;
        String folder = Folder.getSelectedItem().toString().trim() + FS;
        File f;
//    if ("Squadron".equals(folder) | "Troop".equals(folder)) {
//    JOptionPane.showMessageDialog(jf, "");
        String[] files = new File(dir + folder).list();
        for (int j = 0; j < files.length; j++) {
            System.out.println(files[j]);
            if (files[j].startsWith(jcb4Sys.getSelectedItem().toString().substring(0,
                    4))) {
                f = new File(dir + folder + FS + files[j]);
                f.delete();
            }
        }
//    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b4NewPic = new javax.swing.JButton();
        b4Open = new javax.swing.JButton();
        b4Save = new javax.swing.JButton();
        l4Folder = new javax.swing.JLabel();
        l4Ext = new javax.swing.JLabel();
        b4Locate = new javax.swing.JButton();
        b4Color = new javax.swing.JButton();
        b4Pic = new javax.swing.JButton();
        setText = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jt4File = new javax.swing.JTextField();
        jMenu1 = new javax.swing.JMenu();
        l4X = new javax.swing.JLabel();
        l4Y = new javax.swing.JLabel();
        l4W = new javax.swing.JLabel();
        l4H = new javax.swing.JLabel();
        jSpinnerX = new javax.swing.JSpinner();
        jSpinnerY = new javax.swing.JSpinner();
        jSpinnerW = new javax.swing.JSpinner();
        jSpinnerH = new javax.swing.JSpinner();
        panel4Pic = new javax.swing.JPanel();
        p4Read = new javax.swing.JScrollPane();
        ta4Read = new javax.swing.JTextArea();
        p4Write = new javax.swing.JScrollPane();
        t4Write = new javax.swing.JTextArea();
        l4Save = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        start = new javax.swing.JLabel();
        end = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        num = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        li = new javax.swing.JLabel();
        lin = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        t6 = new javax.swing.JTextField();
        t7 = new javax.swing.JTextField();
        t8 = new javax.swing.JTextField();
        t9 = new javax.swing.JTextField();
        t10 = new javax.swing.JTextField();
        t11 = new javax.swing.JTextField();
        t12 = new javax.swing.JTextField();
        t13 = new javax.swing.JTextField();
        t14 = new javax.swing.JTextField();
        t15 = new javax.swing.JTextField();
        t16 = new javax.swing.JTextField();
        t17 = new javax.swing.JTextField();
        t18 = new javax.swing.JTextField();
        t19 = new javax.swing.JTextField();
        t20 = new javax.swing.JTextField();
        l4Back = new javax.swing.JLabel();
        l4Front = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Step = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta4Pix = new javax.swing.JTextArea();
        Folder = new javax.swing.JComboBox<>();
        X = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();

        b4NewPic.setText(">");
        b4NewPic.setToolTipText("");
        b4NewPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4NewPicActionPerformed(evt);
            }
        });

        b4Open.setText("Open");
        b4Open.setToolTipText("");
        b4Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4OpenActionPerformed(evt);
            }
        });

        b4Save.setText("Save");
        b4Save.setToolTipText("");
        b4Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4SaveActionPerformed(evt);
            }
        });

        l4Folder.setForeground(java.awt.Color.green);
        l4Folder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l4Folder.setText("folder");
        l4Folder.setToolTipText(l4Folder.getText());
        l4Folder.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        l4Folder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l4FolderMouseClicked(evt);
            }
        });

        l4Ext.setForeground(java.awt.Color.green);
        l4Ext.setText("ext");
        l4Ext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l4ExtMouseClicked(evt);
            }
        });

        b4Locate.setText("<");
        b4Locate.setToolTipText("");
        b4Locate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4LocateActionPerformed(evt);
            }
        });

        b4Color.setText("C");
        b4Color.setToolTipText("");
        b4Color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ColorActionPerformed(evt);
            }
        });

        b4Pic.setText("P");
        b4Pic.setToolTipText("");
        b4Pic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4PicActionPerformed(evt);
            }
        });

        setText.setText("T");
        setText.setToolTipText("");
        setText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setTextActionPerformed(evt);
            }
        });

        jLabel7.setForeground(java.awt.Color.green);
        jLabel7.setText("P");
        jLabel7.setToolTipText("Picture");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jt4File.setBackground(java.awt.Color.cyan);
        jt4File.setText("file");
        jt4File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt4FileActionPerformed(evt);
            }
        });

        jMenu1.setText("jMenu1");

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(750, 350));
        setMinimumSize(new java.awt.Dimension(750, 350));
        setPreferredSize(new java.awt.Dimension(750, 350));
        setRequestFocusEnabled(false);

        l4X.setForeground(java.awt.Color.lightGray);
        l4X.setText("X");
        l4X.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l4XMouseClicked(evt);
            }
        });

        l4Y.setForeground(java.awt.Color.lightGray);
        l4Y.setText("Y");

        l4W.setForeground(java.awt.Color.lightGray);
        l4W.setText("W");

        l4H.setForeground(java.awt.Color.lightGray);
        l4H.setText("H");

        jSpinnerX.setModel(new javax.swing.SpinnerNumberModel(0, 0, 200, 1));
        jSpinnerX.setToolTipText("");
        jSpinnerX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerXStateChanged(evt);
            }
        });

        jSpinnerY.setModel(new javax.swing.SpinnerNumberModel(0, null, 100, 1));
        jSpinnerY.setToolTipText("");
        jSpinnerY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerYStateChanged(evt);
            }
        });

        jSpinnerW.setModel(new javax.swing.SpinnerNumberModel(200, null, 200, 1));
        jSpinnerW.setToolTipText("");
        jSpinnerW.setEnabled(false);
        jSpinnerW.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerWStateChanged(evt);
            }
        });

        jSpinnerH.setModel(new javax.swing.SpinnerNumberModel(100, null, 100, 1));
        jSpinnerH.setToolTipText("");
        jSpinnerH.setEnabled(false);
        jSpinnerH.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerHStateChanged(evt);
            }
        });

        panel4Pic.setBackground(new java.awt.Color(204, 204, 255));
        panel4Pic.setToolTipText("");
        panel4Pic.setMaximumSize(new java.awt.Dimension(200, 100));
        panel4Pic.setMinimumSize(new java.awt.Dimension(200, 100));
        panel4Pic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel4PicMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel4PicLayout = new javax.swing.GroupLayout(panel4Pic);
        panel4Pic.setLayout(panel4PicLayout);
        panel4PicLayout.setHorizontalGroup(
            panel4PicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        panel4PicLayout.setVerticalGroup(
            panel4PicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        ta4Read.setColumns(15);
        ta4Read.setRows(5);
        ta4Read.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                ta4ReadCaretUpdate(evt);
            }
        });
        ta4Read.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ta4ReadFocusGained(evt);
            }
        });
        ta4Read.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ta4ReadMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ta4ReadMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ta4ReadMouseReleased(evt);
            }
        });
        ta4Read.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                ta4ReadCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                ta4ReadInputMethodTextChanged(evt);
            }
        });
        p4Read.setViewportView(ta4Read);

        t4Write.setColumns(20);
        t4Write.setRows(5);
        t4Write.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t4WriteMouseClicked(evt);
            }
        });
        p4Write.setViewportView(t4Write);

        l4Save.setForeground(java.awt.Color.green);
        l4Save.setText("S");
        l4Save.setToolTipText("Save in System Folder");
        l4Save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l4SaveMouseClicked(evt);
            }
        });

        jLabel1.setForeground(java.awt.Color.lightGray);
        jLabel1.setText("start =");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setForeground(java.awt.Color.lightGray);
        jLabel2.setText("end = ");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        start.setForeground(java.awt.Color.lightGray);
        start.setText("0");

        end.setForeground(java.awt.Color.lightGray);
        end.setText("0");

        jLabel5.setForeground(java.awt.Color.lightGray);
        jLabel5.setText("num =");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setForeground(java.awt.Color.lightGray);
        jLabel6.setText("count = ");

        num.setForeground(java.awt.Color.lightGray);
        num.setText("0");

        jLabel8.setForeground(java.awt.Color.lightGray);
        jLabel8.setText("0");

        jLabel9.setForeground(java.awt.Color.lightGray);
        jLabel9.setText("line =");

        jLabel10.setForeground(java.awt.Color.lightGray);
        jLabel10.setText("lines = ");

        li.setForeground(java.awt.Color.lightGray);
        li.setText("0");

        lin.setForeground(java.awt.Color.lightGray);
        lin.setText("0");

        jLabel3.setForeground(java.awt.Color.green);
        jLabel3.setText("<");
        jLabel3.setToolTipText("Load");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setForeground(java.awt.Color.green);
        jLabel4.setText("C");
        jLabel4.setToolTipText("Color");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel11.setForeground(java.awt.Color.green);
        jLabel11.setText("T");
        jLabel11.setToolTipText("Text");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setForeground(java.awt.Color.green);
        jLabel12.setText("O");
        jLabel12.setToolTipText("Open");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jPanel2.setOpaque(false);

        t1.setMaximumSize(new java.awt.Dimension(6, 20));

        t2.setMaximumSize(new java.awt.Dimension(6, 20));

        t3.setMaximumSize(new java.awt.Dimension(6, 20));

        t4.setMaximumSize(new java.awt.Dimension(6, 20));

        t5.setMaximumSize(new java.awt.Dimension(6, 20));

        t6.setMaximumSize(new java.awt.Dimension(6, 20));

        t7.setMaximumSize(new java.awt.Dimension(6, 20));

        t8.setMaximumSize(new java.awt.Dimension(6, 20));

        t9.setMaximumSize(new java.awt.Dimension(6, 20));

        t10.setMaximumSize(new java.awt.Dimension(6, 20));

        t11.setBackground(java.awt.Color.cyan);
        t11.setMaximumSize(new java.awt.Dimension(6, 20));

        t12.setMaximumSize(new java.awt.Dimension(6, 20));
        t12.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                t12PropertyChange(evt);
            }
        });
        t12.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                t12VetoableChange(evt);
            }
        });

        t13.setMaximumSize(new java.awt.Dimension(6, 20));

        t14.setMaximumSize(new java.awt.Dimension(6, 20));

        t15.setMaximumSize(new java.awt.Dimension(6, 20));

        t16.setMaximumSize(new java.awt.Dimension(6, 20));

        t17.setMaximumSize(new java.awt.Dimension(6, 20));

        t18.setMaximumSize(new java.awt.Dimension(6, 20));

        t19.setMaximumSize(new java.awt.Dimension(6, 20));

        t20.setMaximumSize(new java.awt.Dimension(6, 20));

        l4Back.setForeground(java.awt.Color.green);
        l4Back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l4Back.setText("C");
        l4Back.setToolTipText("Centre");
        l4Back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l4Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l4BackMouseClicked(evt);
            }
        });

        l4Front.setForeground(java.awt.Color.green);
        l4Front.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l4Front.setText("C");
        l4Front.setToolTipText("Centre");
        l4Front.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l4Front.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l4FrontMouseClicked(evt);
            }
        });

        jLabel14.setForeground(java.awt.Color.green);
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("T5C");
        jLabel14.setToolTipText("saveConfig");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(l4Front, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l4Back, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l4Front)
                    .addComponent(l4Back)
                    .addComponent(jLabel14))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {t1, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t2, t20, t3, t4, t5, t6, t7, t8, t9});

        Step.setModel(new javax.swing.SpinnerNumberModel(10, 1, null, 1));

        ta4Pix.setColumns(15);
        ta4Pix.setRows(5);
        jScrollPane1.setViewportView(ta4Pix);

        Folder.setMaximumRowCount(24);
        Folder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admiral", "Army", "Bases", "Belts", "Blank", "Commodore", "Defences", "Equipment", "Fleet", "Gas Giants", "Marine", "Merchant", "Navy", "Other", "Orbitals", "Orbit", "Planets", "Population", "Scout", "SDBs", "Ship", "Stars", "Squadron", "Squadrons", "T5C", "Troop", "Troops", "Vehicle", "World", "Worlds" }));
        Folder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FolderMouseClicked(evt);
            }
        });
        Folder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FolderActionPerformed(evt);
            }
        });

        X.setSelected(true);
        X.setOpaque(false);
        X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XActionPerformed(evt);
            }
        });

        jLabel13.setForeground(java.awt.Color.green);
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("jLabel13");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Folder, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(X)
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(l4Save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(l4X)
                                .addGap(0, 0, 0)
                                .addComponent(jSpinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(l4Y)
                                .addGap(0, 0, 0)
                                .addComponent(jSpinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(l4W)
                                .addGap(0, 0, 0)
                                .addComponent(jSpinnerW, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(l4H)
                                .addGap(0, 0, 0)
                                .addComponent(jSpinnerH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(Step, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel4Pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p4Read)
                    .addComponent(jScrollPane1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(end))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(num))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(li))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lin))))
                    .addComponent(p4Write, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {end, jLabel8, li, lin, num, start});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l4Y)
                            .addComponent(jSpinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l4W)
                            .addComponent(jSpinnerW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l4H)
                            .addComponent(jSpinnerH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l4X)
                            .addComponent(Step, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(l4Save)
                            .addComponent(jLabel12))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(Folder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(X))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(start))
                                        .addGap(0, 0, 0)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(end)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(num))
                                        .addGap(0, 0, 0)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(li))
                                        .addGap(0, 0, 0)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(lin))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p4Write))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panel4Pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p4Read)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Folder, X});

    }// </editor-fold>//GEN-END:initComponents

  private void b4LocateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4LocateActionPerformed
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          System.out.println("counter" + " = " + counter);
          System.out.println("c" + " = " + c);
      }
      //</editor-fold>
//    if ("World".equals(counter)) {
//      createWorldPic();
//      bc[0] = jcb4Sys.getSelectedItem().toString().trim();
//    }
      getDataFromLocator();
  }//GEN-LAST:event_b4LocateActionPerformed

  private void b4NewPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4NewPicActionPerformed
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          System.out.println("counter" + " = " + counter);
          System.out.println("c" + " = " + c);
      }
      //</editor-fold>
      showBlank();
  }//GEN-LAST:event_b4NewPicActionPerformed

  private void b4ColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ColorActionPerformed
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          System.out.println("counter" + " = " + counter);
          System.out.println("c" + " = " + c);
      }
      //</editor-fold>
      selectColour();
  }//GEN-LAST:event_b4ColorActionPerformed

  private void b4PicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4PicActionPerformed
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      setPicture();
      showBI();
  }//GEN-LAST:event_b4PicActionPerformed

  private void b4SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4SaveActionPerformed
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      if (dir.equals(_GIF)) {
          xnum = 2;
          l4FolderMouseClicked(me);
          l4Ext.setText(exts[xnum]);
      }
      int ret = jfc.showSaveDialog(null);
      chooserChange(ret);
  }//GEN-LAST:event_b4SaveActionPerformed

  private void jSpinnerWStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerWStateChanged
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      //boolean DEBUG = false;
      boolean DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      wChange();
  }//GEN-LAST:event_jSpinnerWStateChanged

  private void jSpinnerHStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerHStateChanged
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      //boolean DEBUG = false;
      boolean DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      hChange();
  }//GEN-LAST:event_jSpinnerHStateChanged

  private void jSpinnerXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerXStateChanged
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      //boolean DEBUG = false;
      boolean DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      xChange();
  }//GEN-LAST:event_jSpinnerXStateChanged

  private void jSpinnerYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerYStateChanged
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      //boolean DEBUG = false;
      boolean DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      yChange();
  }//GEN-LAST:event_jSpinnerYStateChanged

  private void ta4ReadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ta4ReadMouseClicked
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      getDataFromLocator();
      if (evt.getClickCount() > 2) {
          openNotepad();
      }
      saveConfig();
      drawWorldPic();
  }//GEN-LAST:event_ta4ReadMouseClicked

  private void t4WriteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t4WriteMouseClicked
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      if (evt.getClickCount() > 1) {
//      saveT5C(t11.getText());
          saveT5C(jLabel13.getText());
      }
  }//GEN-LAST:event_t4WriteMouseClicked

  private void setTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setTextActionPerformed
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
//    if (counter == "World") {
//      //createWorldPic();
//    }
      showText();
      showBI();
  }//GEN-LAST:event_setTextActionPerformed

  private void panel4PicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel4PicMouseClicked
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
      title = t11.getText() + " " + Folder.getSelectedItem().toString().trim();
      GlobalMethods.saveT5(panel4Pic);
      if (evt.getClickCount() > 1) {
          picClick();
          GlobalMethods.saveT5(panel4Pic);
          l4SaveMouseClicked(me);
      }
//    GlobalMethods.savePic(jf, jf.getTitle());
  }//GEN-LAST:event_panel4PicMouseClicked

  private void l4FolderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4FolderMouseClicked
      dnuma += 1;
      if (dnuma > 2) {
          dnuma = 0;
      }
      dir = dirsa[dnuma].replace("\\\\", "\\");
      l4Folder.setText(dir);
      jfc.setCurrentDirectory(new File(dir));
      jfc.setSelectedFile(new File(jt4File.getText()));
  }//GEN-LAST:event_l4FolderMouseClicked

  private void b4OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4OpenActionPerformed
      int ret = jfc.showOpenDialog(null);
      chooserChange(ret);
  }//GEN-LAST:event_b4OpenActionPerformed

  private void l4ExtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4ExtMouseClicked
      xnum += 1;
      if (xnum > 2) {
          xnum = 0;
      }
      l4Ext.setText(exts[xnum]);
      ext = exts[xnum];
      switch (xnum) {
          case 0: {
              filter = txtFilter;
              break;
          }
          case 1: {
              filter = cfgFilter;
              break;
          }
          case 2: {
              filter = gifFilter;
              break;
          }
      }
      jfc.setFileFilter(filter);
  }//GEN-LAST:event_l4ExtMouseClicked

  private void jt4FileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt4FileActionPerformed
      // TODO add your handling code here:
  }//GEN-LAST:event_jt4FileActionPerformed

  private void l4FrontMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4FrontMouseClicked
      switch (l4Front.getText()) {
          case "L": {
              l4Front.setText("C");
              l4Front.setToolTipText("Centre");
              break;
          }
          case "C": {
              l4Front.setText("R");
              l4Front.setToolTipText("Right");
              break;
          }
          case "R": {
              l4Front.setText("L");
              l4Front.setToolTipText("Left");
              break;
          }
      }
  }//GEN-LAST:event_l4FrontMouseClicked

  private void l4BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4BackMouseClicked
      switch (l4Back.getText()) {
          case "L": {
              l4Back.setText("C");
              l4Back.setToolTipText("Centre");
              break;
          }
          case "C": {
              l4Back.setText("R");
              l4Back.setToolTipText("Right");
              break;
          }
          case "R": {
              l4Back.setText("L");
              l4Back.setToolTipText("Left");
              break;
          }
      }
  }//GEN-LAST:event_l4BackMouseClicked

  private void l4SaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4SaveMouseClicked
      jLabel14MouseClicked(evt);
      savePic();
  }//GEN-LAST:event_l4SaveMouseClicked

  private void ta4ReadCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_ta4ReadCaretUpdate
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      saveConfig();
//    drawWorldPic();
  }//GEN-LAST:event_ta4ReadCaretUpdate

  private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      b4Locate.doClick();
  }//GEN-LAST:event_jLabel3MouseClicked

  private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      b4Color.doClick();
  }//GEN-LAST:event_jLabel4MouseClicked

  private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
//    b4Pic.doClick();
      Folder.setSelectedIndex(0);
//    ImageListDnDTest.main(new String[]{"_GIF"});
  }//GEN-LAST:event_jLabel7MouseClicked

  private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
//    drawOutline();
      setText.doClick();
  }//GEN-LAST:event_jLabel11MouseClicked

  private void FolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FolderActionPerformed
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      counter = Folder.getSelectedItem().toString();
      createCounter(counter);
      b4Locate.doClick();
      loadOldList(counter);
      t4Write.setText("");
      ta4Read.grabFocus();
      loadOldList(counter);
      ta4ReadCaretUpdate(ce);
      ta4Read.append("");
  }//GEN-LAST:event_FolderActionPerformed

  private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      String folder = Folder.getSelectedItem().toString().trim();
      jfc.setFileFilter(cfgFilter);
      jfc.setCurrentDirectory(new File(T5C + FS + folder));
      jfc.showOpenDialog(null);
      Image im = il.getIconImage();
      t4Write.setText(GlobalMethods.loadTextFile(T5C + FS + folder, file, ext));
  }//GEN-LAST:event_jLabel12MouseClicked

  private void ta4ReadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ta4ReadMousePressed
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
//    drawWorldPic();
      t4Write.setText("");
      modText();
      saveConfig();
      loadText();
//    drawWorldPic();
  }//GEN-LAST:event_ta4ReadMousePressed

  private void l4XMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4XMouseClicked
      Folder.setSelectedIndex(0);
      showBlank();
  }//GEN-LAST:event_l4XMouseClicked

  private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
//    GlobalMethods.savePic(jp, jf.getTitle());
  }//GEN-LAST:event_jLabel1MouseClicked

  private void FolderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FolderMouseClicked
      if (evt.getClickCount() > 1) {
          Folder.setSelectedIndex(Folder.getSelectedIndex());
      }
  }//GEN-LAST:event_FolderMouseClicked

  private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
      t4Write.setText("");
  }//GEN-LAST:event_jLabel2MouseClicked

  private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
      saveConfig();
      //<editor-fold defaultstate="collapsed" desc="IFD">
      String s = "";
      {
          boolean DEBUG = true;
          //DEBUG = false;
          if (DEBUG) { // true or false
              s += GlobalMethods.comment("=", 80) + CRLF;
              s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
                      + CRLF;
              JTextArea jta = new JTextArea(s, 20, 20);
              JScrollPane jsp = new JScrollPane(jta);
              System.out.println("" + " = " + s);
              //JOptionPane.showMessageDialog(jf, jsp);
          }
      }
//</editor-fold>
  }//GEN-LAST:event_jLabel14MouseClicked

  private void ta4ReadCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ta4ReadCaretPositionChanged
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
  }//GEN-LAST:event_ta4ReadCaretPositionChanged

  private void ta4ReadInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ta4ReadInputMethodTextChanged
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
  }//GEN-LAST:event_ta4ReadInputMethodTextChanged

  private void ta4ReadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ta4ReadFocusGained
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
      filelines = ta4Read.getText().split(CRLF);
      //<editor-fold defaultstate="collapsed" desc="DEBUG">
      //DEBUG = false;
      if (DEBUG) {
          System.out.print("fileline.length" + " = " + filelines.length + CRLF);
          for (int j = 0; j < filelines.length; j++) {
              if (filelines[j].startsWith(t11.getText())) {
                  System.out.println("fileline[" + j + "] = " + filelines[j]);
              }
          }
      }
      //</editor-fold>
  }//GEN-LAST:event_ta4ReadFocusGained

  private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
      // TODO add your handling code here:
  }//GEN-LAST:event_jLabel5MouseClicked

  private void ta4ReadMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ta4ReadMouseReleased
      //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
      boolean DEBUG = false;
      //DEBUG = false;
      if (DEBUG) { // true or false
          System.out.print(GlobalMethods.comment("=", 80));
          System.out.println("\t" + Thread.currentThread().getStackTrace()[1]
                  .getMethodName());
          //System.out.println("" + " = " + );
      }
      //</editor-fold>
//    drawWorldPic();
  }//GEN-LAST:event_ta4ReadMouseReleased

  private void t12PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_t12PropertyChange
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
  }//GEN-LAST:event_t12PropertyChange

  private void t12VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_t12VetoableChange
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
  }//GEN-LAST:event_t12VetoableChange

  private void XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XActionPerformed
      newWay();
  }//GEN-LAST:event_XActionPerformed

  private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
      //<editor-fold defaultstate="collapsed" desc="IFD">
      {
          boolean DEBUG = true;
          //DEBUG = false;
          if (DEBUG) { // true or false
              String s = "";
              s += GlobalMethods.comment("=", 80) + CRLF;
              s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName()
                      + CRLF;
              s += "4247" + CRLF;
              JTextArea jta = new JTextArea(s, 20, 40);
              JScrollPane jsp = new JScrollPane(jta);
              System.out.println("" + " = " + s);
              JOptionPane.showMessageDialog(jf, jsp);
          }
      }
      //</editor-fold>
      if (evt.getClickCount() == 1) {
          String reply = JOptionPane.showInputDialog("Enter new name", jLabel13
                  .getText());
          jLabel13.setText(reply);
      } else {
          if (evt.getClickCount() > 1) {
              String p = Panel4T5Locator.getSysPath() + FS + jLabel13.getText() + ".gif";
              //<editor-fold defaultstate="collapsed" desc="JOP">
              {
                  String s = "";
                  s += p + CRLF;
                  s += "" + CRLF;
                  JTextArea jta = new JTextArea(s, 50, 80);
                  JScrollPane jsp = new JScrollPane(jta);
                  JOptionPane.showMessageDialog(null, jsp);
              }
              //</editor-fold>
          }
      }

  }//GEN-LAST:event_jLabel13MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> Folder;
    private static javax.swing.JSpinner Step;
    public static javax.swing.JCheckBox X;
    private static javax.swing.JButton b4Color;
    private static javax.swing.JButton b4Locate;
    private static javax.swing.JButton b4NewPic;
    private static javax.swing.JButton b4Open;
    public static javax.swing.JButton b4Pic;
    private static javax.swing.JButton b4Save;
    private static javax.swing.JLabel end;
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel jLabel10;
    private static javax.swing.JLabel jLabel11;
    private static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    private static javax.swing.JLabel jLabel14;
    private static javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel5;
    private static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private static javax.swing.JLabel jLabel8;
    private static javax.swing.JLabel jLabel9;
    private static javax.swing.JMenu jMenu1;
    private static javax.swing.JPanel jPanel2;
    private static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JSpinner jSpinnerH;
    public static javax.swing.JSpinner jSpinnerW;
    public static javax.swing.JSpinner jSpinnerX;
    public static javax.swing.JSpinner jSpinnerY;
    public static javax.swing.JTextField jt4File;
    public static javax.swing.JLabel l4Back;
    private static javax.swing.JLabel l4Ext;
    private static javax.swing.JLabel l4Folder;
    public static javax.swing.JLabel l4Front;
    private static javax.swing.JLabel l4H;
    public static javax.swing.JLabel l4Save;
    private static javax.swing.JLabel l4W;
    private static javax.swing.JLabel l4X;
    private static javax.swing.JLabel l4Y;
    private static javax.swing.JLabel li;
    private static javax.swing.JLabel lin;
    private static javax.swing.JLabel num;
    private static javax.swing.JScrollPane p4Read;
    private static javax.swing.JScrollPane p4Write;
    public static javax.swing.JPanel panel4Pic;
    public static javax.swing.JButton setText;
    private static javax.swing.JLabel start;
    public static javax.swing.JTextField t1;
    public static javax.swing.JTextField t10;
    public static javax.swing.JTextField t11;
    public static javax.swing.JTextField t12;
    public static javax.swing.JTextField t13;
    public static javax.swing.JTextField t14;
    public static javax.swing.JTextField t15;
    public static javax.swing.JTextField t16;
    public static javax.swing.JTextField t17;
    public static javax.swing.JTextField t18;
    public static javax.swing.JTextField t19;
    public static javax.swing.JTextField t2;
    public static javax.swing.JTextField t20;
    public static javax.swing.JTextField t3;
    public static javax.swing.JTextField t4;
    public static javax.swing.JTextArea t4Write;
    public static javax.swing.JTextField t5;
    public static javax.swing.JTextField t6;
    public static javax.swing.JTextField t7;
    public static javax.swing.JTextField t8;
    public static javax.swing.JTextField t9;
    public static javax.swing.JTextArea ta4Pix;
    public static javax.swing.JTextArea ta4Read;
    // End of variables declaration//GEN-END:variables

    void oldWay() {
//    saveAllCounters();
//    drawWorldPic();
        jt4File.setText(t11.getText());
//    Panel4T5Scripting.Name.setText("");
        Panel4T5Scripting.Folder.setSelectedItem("Counters");
        Panel4T5Scripting.saveTXT();
        Panel4T5Scripting.writeXML();
//    String savename = "Test";
//    Panel4T5Scripting.saveTXT(savename);
//    Panel4T5Scripting.writeXML(savename);
    }

    static void newWay() {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        if (DEBUG) { // true or false
            String s = "";
            s += GlobalMethods.comment("=", 80) + CRLF;
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            s += "\t" + method + CRLF;
//      s += "" + " = " + "" + CRLF;
            System.out.println(s);
//      JOptionPane.showMessageDialog(null, s);
        }
        //</editor-fold>
//    oldWay();
        jt4File.setText(t11.getText());
        Panel4T5Scripting.Folder.setSelectedItem("World");
        setVars();
//    Panel4T5Scripting.saveTXT();
//    Panel4T5Scripting.writeXML();
//    write("TXT");
//    save("TXT");
//    load("TXT");
//    view("TXT");
    }

    static String s = "";
    static String sys;
    static String type;
    static String method;

    private static void setVars() {
        method = Thread.currentThread().getStackTrace()[1].getMethodName();
        sys = Panel4T5CounterMaker.t11.getText();
        sys = Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim();
        type = Panel4T5CounterMaker.Folder.getSelectedItem().toString();
        String hex = Panel4T5Locator.jcb4Sys.getSelectedItem().toString()
                .substring(0, 4);
        s = "";
        s += hex + "-" + type;
        if (!"".equals(t11.getText())) {
            if (X.isSelected()) {
                switch (type) {
                    case "": {
                        //<editor-fold defaultstate="collapsed" desc="JOP">
                        {
                            String s = "";
                            s += GlobalMethods.comment("=", 80) + CRLF;
                            s += "\t" + Thread.currentThread().getStackTrace()[1]
                                    .getMethodName() + CRLF;
                            s += "4398" + " = " + CRLF;
                            JTextArea jta = new JTextArea(s, 50, 80);
                            JScrollPane jsp = new JScrollPane(jta);
                            JOptionPane.showMessageDialog(jf, jsp);
                            System.out.println(s);
                        }
                        //</editor-fold>
                        return;
                    }
                    case "Blank": {
                        break;
                    }
                    case "Squadrons": {
                        break;
                    }
                    case "Troops": {
                        break;
                    }
                    case "SDBs": {
                        break;
                    }
                    case "Fleet": {
                        break;
                    }
                    case "Admiral": {
                        break;
                    }
                    case "Defences": {
                        break;
                    }
                    case "Population": {
                        break;
                    }
                    case "Belts": {
                        break;
                    }
                    case "Gas Giants": {
                        break;
                    }
                    case "Worlds": {
                        break;
                    }

                    case "T5C": {
                        if (!"".equals(t11.getText())) {
                            s += "-" + t11.getText();
                        }
                        break;
                    }
                    case "World": {
                        if (!"".equals(t12.getText())) {
                            s += "-" + t12.getText();
                        }
                        s = sys.replace(CRLF, "");
                        break;
                    }
                    case "Squadron": {
                        if (!"".equals(t12.getText())) {
                            s += "-" + t12.getText();
                        }
                        X.setSelected(true);
                        break;
                    }
                    case "Troop": {
                        if (!"".equals(t12.getText())) {
                            s += "-" + t12.getText();
                        }
                        X.setSelected(true);
                        break;
                    }
                    case "Vehicle": {
                        if (!"".equals(t11.getText())) {
                            s += "-" + t11.getText();
                        }
                        break;
                    }
                    case "Ship": {
                        if (!"".equals(t11.getText())) {
                            s += "-" + t11.getText();
                        }
                        break;
                    }
                    case "Equipment": {
                        if (!"".equals(t11.getText())) {
                            s += "-" + t11.getText();
                        }
                        break;
                    }
                    case "Navy": {
                        if (!"".equals(t13.getText())) {
                            s += "-" + t13.getText();
                        }
                        break;
                    }
                    case "Marine": {
                        if (!"".equals(t13.getText())) {
                            s += "-" + t13.getText();
                        }
                        break;
                    }
                    case "Army": {
                        if (!"".equals(t13.getText())) {
                            s += "-" + t13.getText();
                        }
                        break;
                    }
                    case "Scout": {
                        if (!"".equals(t13.getText())) {
                            s += "-" + t13.getText();
                        }
                        break;
                    }
                    case "Stars": {
                        if (!"".equals(t13.getText())) {
                            s += "-" + t13.getText();
                        }
                        break;
                    }
                    case "Orbit": {
                        if (!"".equals(t13.getText())) {
                            s += "-" + t13.getText();
                        }
                        break;
                    }
                    case "Orbitals": {
                        if (!"".equals(t13.getText())) {
                            s += "-" + t13.getText();
                        }
                        break;
                    }
                    case "Planets": {
                        if (!"".equals(t13.getText())) {
                            s += "-" + t13.getText();
                        }
                        break;
                    }
                    case "Other": {
                        if (!"".equals(t13.getText())) {
                            s += "-" + t13.getText();
                        }
                        break;
                    }
                    case "Merchant": {
                        if (!"".equals(t13.getText())) {
                            s += "-" + t13.getText();
                        }
                        break;
                    }
                    case "Commodore": {
                        if (!"".equals(t13.getText())) {
                            t12.setText("COMMODORE");
                        }
                        break;
                    }
                    case "Bases": {
                        if (!"".equals(t13.getText())) {
                            t12.setText("BASES");
                        }
                        break;
                    }
                    default: {
                        JOptionPane.showMessageDialog(jf,
                                "4527\ndefault: " + s + "\n" + "method: " + method);
                        break;
                    }
                }
            }
        }
//    s += "method: " + method + CRLF;
        System.out.println(s);
//    jta.append(s);
        jLabel13.setText(s);
        s += CRLF;
    }

    private void write(String txt) {
        //<editor-fold defaultstate="collapsed" desc="IF DEBUG">
        boolean DEBUG = false;
        if (DEBUG) { // true or false
            String s = "";
            s += GlobalMethods.comment("=", 80) + CRLF;
            String method = Thread.currentThread().getStackTrace()[1].getMethodName();
            s += "\t" + method + CRLF;
//      s += "" + " = " + "" + CRLF;
//      JOptionPane.showMessageDialog(null, s);
            System.out.print(s);
        }
        //</editor-fold>
        switch (txt) {
            case "TXT": {
                break;
            }
            default: {
                String s = "";
                s += "DEFAULT" + CRLF;
                System.out.println("s" + " = " + s);
                break;
            }
        }
    }

    private void save(String txt) {
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

    private void load(String txt) {
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

    private void view(String txt) {
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

    public static void killOld() {
        File file = new File(Panel4T5Locator.getSysPath() + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim());
        String[] files = file.list();
        try {
            for (int j = 0; j < files.length; j++) {
                System.out.println("files[" + j + "]" + " = " + files[j]);
                String line = files[j];
                if (line.endsWith(".gif") & (line.contains("-Orbit-"))) {
                    System.out.println("  line" + " = " + line);
                    File f = new File(Panel4T5Locator.getSysPath() + FS + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + FS + line);
                    System.out.println("  f.toString()" + " = " + f.toString());
                    System.out.println("  f.exists() = " + f.exists());
                    if (f.exists()) {
                        f.delete();
                        System.out.println("KILLED");
                    }
                    Panel4T5Locator.saveFullPic();
                }
            }
        } catch (Exception e) {
            System.out.println("Failed!!!!!!!!!!!!!!!!!!!!");
        }
    }

    public static String getPrec() {
        //3d-3
        int prec = 0;
        int num = 0;
        prec += GlobalMethods.roll2d();
        prec += GlobalMethods.roll1d();
        return "" + prec;
    }

    public static String getPlan() {
        //2d
        int num = GlobalMethods.roll2d();
        int pf = 5;
        switch (num) {
            case 2: {  // PF 0
                pf = 0;
                break;
            }
            case 12: {  // PF 1
                pf = 1;
                break;
            }
            case 3:
            case 11: {  // PF 2
                pf = 2;
                break;
            }
            case 4:
            case 10: {  // PF 3
                pf = 3;
                break;
            }
            case 5:
            case 9: {  // PF 4
                pf = 4;
                break;
            }
            case 6:
            case 7:
            case 8: {  // PF 5
                pf = 5;
                break;
            }
        }
        return "" + pf;
    }

    public static String getTact() {
        //1d
        int num = GlobalMethods.roll1d();
        int tf = 0;
        switch (num) {
            case 1: {
                tf = -2;
                break;
            }
            case 2: {
                tf = -1;
                break;
            }
            case 3:
            case 4: {
                tf = 0;
                break;
            }
            case 5: {
                tf = 1;
                break;
            }
            case 6: {
                tf = 2;
                break;
            }
        }
        return "" + tf;
    }

    /*
        Regina
        Fraynj
        Kesali
        Capital
        bits2Page()
        createAdmiral()
        createBases()
        createCommodores()
        createFamily()
        createNPCs()
        createOrbitCounters()
     */
    static void createAdmiral() {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        {
            String s = "";
            boolean DEBUG = true;  // true or false;
            if (DEBUG) { // true or false
                s += "//////////////////////////////////////////////" + CRLF;
                s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
                s += "" + " = " + "" + CRLF;
                s += "" + " = " + "" + CRLF;
                System.out.println(s);
            }
        }
        //</editor-fold>
        String old = jf.getTitle();
        Folder.setSelectedItem("Admiral");
        jLabel13.setText(t11.getText().substring(0, 4) + "-Admiral");
        picClick();
        t13.setText("Precedence: " + getPrec());
        t14.setText("Planning: " + getPlan());
        t15.setText("Tactical: " + getTact());
        t17.setText("Adm: " + wordgen.Panel4WordGen.getWord(me));
        showText();
        showBI();
        GlobalMethods.saveT5(panel4Pic);
    }

    static void createBases() {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        {
            String s = "";
            boolean DEBUG = true;  // true or false;
            if (DEBUG) { // true or false
                s += "//////////////////////////////////////////////" + CRLF;
                s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
                s += "" + " = " + "" + CRLF;
//            s += "parts[5]" + " = " + parts[5].getText() + CRLF;
                System.out.println(s);
            }
        }
        //</editor-fold>
        for (int j = 0; j < bits.length; j++) {
            System.out.println("bits[" + j + "] = " + bits[j]);
        }
        int num = bits[8].length(); // num = number of bases
        String old = jf.getTitle();
        for (int j = 0; j < num; j++) {
            Folder.setSelectedItem("Bases");
            //Select colour due to type of base
            String s = bits[8].toString();
            for (int k = 0; k < s.length(); k++) {
                System.out.println("bits[" + k + "] = " + s.substring(k, k + 1));
            }
            jLabel13.setText(t11.getText().substring(0, 4) + "-BASE-" + (j + 1));
            picClick();
            showText();
            showBI();
            GlobalMethods.saveT5(panel4Pic);
            //      jf.setTitle("Temp");
            System.out.println("bits[8].toString() = " + bits[8].toString());
        }

    }

    public static void createCommodores() {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        {
            String s = "";
            boolean DEBUG = true;  // true or false;
            if (DEBUG) { // true or false
                s += "//////////////////////////////////////////////" + CRLF;
                s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
                s += "" + " = " + "" + CRLF;
                s += "" + " = " + "" + CRLF;
                System.out.println(s);
            }
        }
        //</editor-fold>
        int num2;
        try {
            num2 = Integer.parseInt(Panel4T5Locator.squadrons.getText());
        } catch (Exception e) {
            System.out.println("4993 = " + e);
            num2 = 0;
            System.out.println("num2 = " + num2);
        }
        String old = jf.getTitle();
        for (int j = 0; j < num2; j++) {
            Folder.setSelectedItem("Commodore");
            jLabel13.setText(t11.getText().substring(0, 4) + "-Commodore-" + (j + 1));
            picClick();
            t13.setText("Precedence: " + getPrec());
            t14.setText("Planning: " + getPlan());
            t15.setText("Tactical: " + getTact());
            t17.setText("" + wordgen.Panel4WordGen.getWord(me));
            showText();
            showBI();
            GlobalMethods.saveT5(panel4Pic);
            //      jf.setTitle("Temp");
        }

    }

    public static void createMOfficers() {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        {
            String s = "";
            boolean DEBUG = true;  // true or false;
            if (DEBUG) { // true or false
                s += "//////////////////////////////////////////////" + CRLF;
                s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
                s += "" + " = " + "" + CRLF;
                s += "" + " = " + "" + CRLF;
                System.out.println(s);
            }
        }
        //</editor-fold>
        int ranks = 0;
        /*
        Navy
        Navy Officer
        Marine
        Marine Officer
        Army
        Army Officer
        Other
        Merchant
         */
        String[] cars = {"Navy", "Marine", "Army"};
        int[] idxs = {1, 3, 5};
        int[] maxs = {7, 7, 6};
        for (int k = 0; k < cars.length; k++) {
            System.out.println("k = " + k);
            Folder.setSelectedItem(cars[k]);
            Panel4T5Locator.jcb4Career.setSelectedItem(cars[k]);
            for (int l = 0; l < Panel4T5Locator.jcb4Career.getItemCount(); l++) {
                if (Panel4T5Locator.jcb4Career.getItemAt(l).toString().contains(cars[k])) {
                    System.out.println("l = " + l);
                    Panel4T5Locator.jcb4Career.setSelectedIndex(l);
                    Panel4T5Locator.setRanks();
                    ranks = maxs[k];
                    for (int j = 0; j < ranks; j++) {
                        Panel4T5Locator.jcb4Career.setSelectedIndex(idxs[k]);
                        Panel4T5Locator.jcb4Rank.setSelectedIndex(ranks - 1 - j);
                        showText();
                        picClick();
                        Panel4T5Locator.jButton2.doClick();
                        Panel4T5CounterMaker.jLabel13.setText(t11.getText().substring(0, 4) + "-" + cars[k] + "-" + (j + 1));
                        showBI();
                        GlobalMethods.savePic(Panel4T5CounterMaker.panel4Pic, t11.getText().substring(0, 4) + "-Marine-" + Panel4T5Locator.jcb4Rank.getSelectedItem().toString());
                        System.out.println("");
                    }
                }
            }
        }
    }

    public static void createNPCs() {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        {
            String s = "";
            boolean DEBUG = true;  // true or false;
            if (DEBUG) { // true or false
                s += "//////////////////////////////////////////////" + CRLF;
                s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
                s += "" + " = " + "" + CRLF;
                s += "" + " = " + "" + CRLF;
                System.out.println(s);
            }
        }
        //</editor-fold>
        int ranks = 0;

        String[] careers;
        //careers = new String[] {"Navy", "Marine", "Army"};
        careers = new String[]{
            "Navy",
            "Navy Officer",
            "Marine",
            "Marine Officer",
            "Army",
            "Army Officer",
            "Other",
            "Merchant",
            "Scout"
        };

        int[] idxs;
        idxs = new int[]{1, 3, 5};
        idxs = new int[careers.length];
        for (int j = 0; j < careers.length; j++) {
            idxs[j] = j;
        }

        int[] maxs;
//        maxs = new int[] {7, 7, 6};
        maxs = new int[]{6, 7, 6, 7, 6, 7, 0, 9, 0};

        for (int k = 0; k < careers.length; k++) {
            System.out.println("k = " + k);
            Folder.setSelectedItem(careers[k]);
            Panel4T5Locator.jcb4Career.setSelectedItem(careers[k]);
            for (int l = 0; l < Panel4T5Locator.jcb4Career.getItemCount(); l++) {
                if (Panel4T5Locator.jcb4Career.getItemAt(l).toString().contains(careers[k])) {
                    System.out.println("l = " + l);
                    Panel4T5Locator.jcb4Career.setSelectedIndex(l);
                    Panel4T5Locator.setRanks();
                    ranks = maxs[k];
                    for (int j = 0; j < ranks; j++) {
                        Panel4T5Locator.jcb4Career.setSelectedIndex(l);
                        Panel4T5Locator.setRanks();
                        Panel4T5Locator.jcb4Rank.setSelectedIndex(j);
                        int times = 1;
                        int m = 0;
                        for (m = 0; m < times; m++) {
                            showText();
                            picClick();
                            Panel4T5Locator.jButton2.doClick();
                            Panel4T5CounterMaker.jLabel13.setText(t11.getText().substring(0, 4) + "-" + careers[k] + "-" + (j + 1) + "-" + m);
                            showBI();
                            GlobalMethods.savePic(Panel4T5CounterMaker.panel4Pic, t11.getText().substring(0, 4) + "-Marine-" + Panel4T5Locator.jcb4Rank.getSelectedItem().toString() + "-" + m);
                            System.out.println("");
                        }
                    }
                }
            }
        }
    }

    static void createFamily() {
//        int idx = Panel4T5Locator.jcb4Career.getSelectedIndex();
//        Panel4T5Locator.jcb4Career.setSelectedIndex(idx);
//        String f = T5 + FS + Panel4T5CounterMaker.jLabel13.getText() + ".gif";
//        saveT5C(jLabel13.getText());
//        GlobalMethods.savePic(Panel4T5CounterMaker.panel4Pic, f);
    }

    static void createOrbitCounters() {
        //<editor-fold defaultstate="collapsed" desc="IFD">
        {
            String s = "";
            boolean DEBUG = true;  // true or false;
            if (DEBUG) { // true or false
                s += "//////////////////////////////////////////////" + CRLF;
                s += "\t" + Thread.currentThread().getStackTrace()[1].getMethodName() + CRLF;
                s += "" + " = " + "" + CRLF;
                s += "" + " = " + "" + CRLF;
                System.out.println(s);
            }
        }
        //</editor-fold>
        Panel4T5CounterMaker.Folder.setSelectedItem("Orbit");
        String start = Panel4T5CounterMaker.jLabel13.getText();
        String reading = Panel4T5Locator.getSysPath() + FS
                + Panel4T5Locator.jcb4Sys.getSelectedItem().toString().trim() + FS
                + "jta4Orb.txt";
        File f = new File(reading);
        if (!f.exists()) {

        }
        int orbit = 0;
        String line = "";
        if (f.exists()) {
            lines = GlobalMethods.getLinesFromFile(f);
            String text = "";
            text = "" + orbit + " =";
            for (int j = 0; j < lines.length; j++) {
                //<editor-fold defaultstate="collapsed" desc="old">
                //        line = lines[j].trim();
                //        while (line.contains("  ")) {
                //          line = line.replace("  ", " ");
                //          line = line.replace("\t", " ");
                //        }
                //        String nums;
                //        if (line.contains(text)) {
                //          if (line.length() > 3) {
                //            System.out.println(line);
                //            nums = line.substring(0, line.indexOf(" = "));
                //            System.out.print(findUWP(line));
                //            Panel4T5CounterMaker.t12.setText("Orbit " + nums);
                //            Panel4T5CounterMaker.t13.setText("" + findUWP(line));
                //            Panel4T5CounterMaker.picClick();
                //            Panel4T5CounterMaker.showText();
                //            Panel4T5CounterMaker.jLabel13.setText(start + "-" + nums);
                //            Panel4T5CounterMaker.savePic();
                //            count += 1;
                //            text = "" + count + " = ";
                //
                //          }
                //        }
                //</editor-fold>
                line = lines[j].replace("\t", " ");
                line = line.replace("\n", " ");
                line = line.replace("\r", " ");
                line = line.replace(CRLF, " ");
                while (line.contains("  ")) {
                    line = line.replace("  ", " ");
                }
                line = line.trim();
//        System.out.println("" + CRLF + line);
//        System.out.println("text" + " = " + text);
//        System.out.println("line.contains(text)" + " = " + line.contains(text));
//        System.out.println("line.length()" + " = " + line.length());
                if (line.contains(text)) {
                    if (line.length() > text.length()) {
//            System.out.println("\t" + line + CRLF);
                        System.out.print(orbit + " ");
                        System.out.println(findUWP(line));
                        String[] parts = line.split(" ");
                        for (int k = 0; k < parts.length; k++) {
                            System.out.println("\tparts[" + k + "]" + " = " + parts[k]);
                        }
                        //  NOW TO SAVE DATA TO GIF IMAGE
                        Panel4T5CounterMaker.t12.setText("Orbit " + orbit);
                        Panel4T5CounterMaker.t13.setText("" + findUWP(line));
//            Panel4T5CounterMaker.t14.setText("" + parts[0]);
//            Panel4T5CounterMaker.t15.setText("" + parts[1]);
                        Panel4T5CounterMaker.t16.setText("" + parts[2]);
                        Panel4T5CounterMaker.t17.setText("" + parts[3]);
                        Panel4T5CounterMaker.picClick();
                        Panel4T5CounterMaker.showText();
                        Panel4T5CounterMaker.jLabel13.setText(start + "-" + orbit);
                        Panel4T5CounterMaker.savePic();
                    }
                    orbit += 1;
                }
                text = "" + orbit + " =";
            }
        } else {
            //<editor-fold defaultstate="collapsed" desc="JOP">
            {
                String s = "";
                s += reading + CRLF;
                s += "" + CRLF;
                JTextArea jta = new JTextArea(s, 50, 80);
                JScrollPane jsp = new JScrollPane(jta);
                JOptionPane.showMessageDialog(null, jsp);
            }
            //</editor-fold>
        }
    }

    static void saveGraphical() {
        //SDBs
        Panel4T5Locator.SDBsClick(me);
        savePic();
        //Rons
        Panel4T5Locator.RonsClick(me);
        savePic();
        //CF
        Panel4T5Locator.CFClick(me);
        savePic();
        //Troops
        Panel4T5Locator.TroopsClick(me);
        savePic();
        //pop
        Panel4T5Locator.createPopPic();
        savePic();
        //belt
        Panel4T5Locator.createBeltPic();
        savePic();
        //GGs
        Panel4T5Locator.createGasPic();
        savePic();
        //W
        Panel4T5Locator.createWorldsPic();
        savePic();
    }

}
