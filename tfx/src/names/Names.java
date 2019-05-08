/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package names;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 *
 * @author Mark Ferguson
 */
public class Names {

    private static String CRLF = "\n";
    private static JFileChooser jfc = new JFileChooser();
    private static String[] paths = {"C:/T5/AslanDictionary.txt",
        "C:/T5/DroyneDictionary.txt", "C:/T5/VilaniDictionary.txt",
        "C:/T5/VargrDictionary.txt", "C:/T5/ZhodaniDictionary.txt"};
    private static String[] names = {"Aslan", "Droyne", "Vilani", "Vargr", "Zhodani"};
    // change paths and names to your language files
    private static String FS = "/";

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        JTextArea jta;
//        jta = new JTextArea();
//        jta.setText("");
//        for (int j = 0; j < paths.length; j++) {
//            System.out.println("exists = " + new File(paths[j]).exists());
//            String[] lines = getLinesFromFile(new File(paths[j]));
//            jta.setText("\t//"+names[j]+CRLF);
//            jta.append("BEGIN DEFERRED;" + CRLF);
//            for (int i = 0; i < lines.length; i++) {
//                jta.append("INSERT INTO " + names[j] + " VALUES('" + lines[i] + "');" + CRLF);
//            }
//            jta.append("END;" + CRLF + CRLF);
//            System.out.println(jta.getText());
////            saveIt(jta, j);
//        }
//    }

    /**
     * @param f file to search
     * @return lines within file
     */
    public static String[] getLinesFromFile(File f) {
        String line;
        String[] lines = new String[countLines(f)];
        int max = 0;
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(f));
            try {
                while ((line = in.readLine()) != null) {
                    line = line.trim();
                    lines[i] = line;
                    i += 1;
                }
                in.close();
            } catch (IOException ex) {
            }
        } catch (FileNotFoundException ex) {
        }
        return lines;
    }

    /**
     * @param file to search
     * @return number of lines in file
     */
    public static int countLines(File file) {
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            // read input lines until the end of file is reached
            while ((line = reader.readLine()) != null) {
                lines++; // increment line count
            }
            reader.close();
        } catch (IOException exception) {
        }
        return lines;
    }

    /**
     * saveIt
     * <p>
     * @param jta text to save
     */
    public static void saveIt(JTextArea jta, int j) {
        int ret;
        jfc.setSelectedFile(new File(jfc.getCurrentDirectory().toString() + FS + names[j]+"_both_both.sql"));
        String pathname = jfc.getCurrentDirectory().toString() + FS + jfc.getSelectedFile();
        jfc.setSelectedFile(new File(pathname));
        
        if ((ret = jfc.showSaveDialog(jfc))
                == JFileChooser.APPROVE_OPTION) {
            String file = jfc.getSelectedFile().toString();
            jfc.setSelectedFile(new File(file));
            try {
                try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
                    out.print(jta.getText());
                }
            } catch (IOException ex) {
            }
        }
    }

}
