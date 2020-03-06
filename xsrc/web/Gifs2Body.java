package web;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**

 @author Mark Ferguson
 */
public class Gifs2Body {

  //<editor-fold defaultstate="collapsed" desc="variables">
  private static String CRLF = "\n";
  private static String FS = "/";
  private static String all = "";
  private static BorderLayout bl;
  private static JComboBox<String> cb;
  private static String drive = "C:".toUpperCase();
  private static String filename = "2737 Kesali";
  private static String[] files;
  private static String[] jewell = {"1307 Lysen", "1106 Jewell"};
  private static JFrame jf;
  private static JPanel jp;
  private static JTextArea jta;
//<editor-fold defaultstate="collapsed" desc="private static String[] kakadan">
  private static String[] kakadan = {"2531 Kiddinu", "2533 Aki", "2534 Zerapii", "2536 Linissa", "2539 Nunaat", "2540 Kalaalit", "2631 Kane", "2634 Wakarsat", "2636 Kakadan", "2637 Akon", "2640 Statia", "2732 Dnak'kritz", "2733 Jarmat", "2734 Rambant", "2737 Kesali", "2738 Tepmaa", "2739 Sg'aa", "2740 P'ginzh", "2831 Kiimzhal", "2832 Telkaa", "2836 Inushir", "2837 Piazza", "2839 Zombagu", "2931 Icuspin", "2932 Zanski", "2933 Kanat", "2934 Assazak", "2936 Elafdt", "2938 Punnari", "2939 Teralvar", "3031 New Salen", "3032 Matuyama", "3035 Zhanora", "3037 Raanbazziil", "3039 Gilnat Paz", "3131 Maamibrin", "3134 Toborit", "3135 Debekov", "3137 Alleman", "3138 Nasaa", "3140 Zana", "3231 Vanutappan", "3232 Tamayo", "3235 Debort", "3237 Zhannag", "3238 Lamiina", "3239 Lannazol"};
  private static String path = "T5";
  private static File f = new File(path);
  private static String[] regina = {"1910 Regina", "2007 Roup", "2005 Feri", "1904 Boughene", "1705 Efate"};
  //</editor-fold>
  private static String[] sallounn = {"1623 Fraynj"};
  private static String sector = "Vland";
  private static String[] solomani = {"1827 Terra"};
  private static String[][] campaigns = {kakadan, sallounn, regina, jewell, solomani};
  private static String subsector = "P Kakadan";
  private static String system = "2737 Kesali";
  private static String text = "";
  private static String uri = "";
  //</editor-fold>
  private static final String base = "C://TED/Web/src/iiss/maggot/t5/web";

  /**
   @param args the command line arguments
   */
  public static void main(String[] args) {
    jp = new JPanel();
    jf = new JFrame();
    bl = new BorderLayout();
    jp.setLayout(bl);
    jta = new JTextArea();
    jp.add(jta, BorderLayout.CENTER);
    jf.setContentPane(jp);
    jf.setSize(600, 600);
    jf.setTitle("Pics2HTML");
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    listSubsector("Spinward Marches", "C Regina");
    listSubsector("Spinward Marches", "B Jewell");
    listSubsector("Gushemege", "J Sallounn");
    //listSubsector("Solomani Rim", "C Concord");
    listSubsector("Solomani Rim", "K Sol");
    listSubsector("Vland", "P Kakadan");
    automate();
    listPages("Spinward Marches", "C Regina");
    listPages("Spinward Marches", "B Jewell");
    listPages("Gushemege", "J Sallounn");
    //listPages("Solomani Rim", "C Concord");
    listPages("Solomani Rim", "K Sol");
    listPages("Vland", "P Kakadan");
    String paths = "";
    String fol = "";
    String Kesali = "";
    /*
     Duke of Kesali
     */
    {
      fol = "" + drive + FS + FS + path + FS
        + ("Vland") + FS
        + ("P Kakadan") + FS
        + ("2737 Kesali") + FS
        + ("2737 Kesali");
      Kesali = fol;
      list4Div(fol, ".txt");
      list4Div(fol, ".t5c");
    }
    paths += fol + "\n";
    /*
     My Traveller Web Pages
     */
    String[] folders = {base, base + FS + "templates", base + FS + "traveller", base + FS + "w3s"};
    {
      for (int i = 0; i < folders.length; i++) {
        paths += folders[i];
        System.out.println("<!-- " + folders[i] + " -->");
        fol = folders[i];
        list4Div(fol, ".html");
        paths += fol + "\n";
      }
    }
    // FOLDERLIST
    for (int i = 0; i < paths.split(CRLF).length; i++) {
      System.out.println("" + " = " + paths.split(CRLF)[i]);
    }
    Urls4Div();
  }

  /**
   CONVERT TEXT URLS TO HYPERLINKS WITH SHORTENED NAMES
   */
  public static void Urls4Div() {
    //CONVERT TEXT URLS TO HYPERLINKS WITH SHORTENED NAMES
    String file = base;
    uri = "file:///" + file;
    list4Div(file, ".html");
    String myline = "";
    String newtext = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader(base + FS + "URLs.txt"));
      String content;
      try {
        while ((content = br.readLine()) != null) {
          if (content.startsWith("http")) {
            String shorter = content.substring(content.lastIndexOf(FS), content.lastIndexOf("."));
            myline = "<a href=\"" + content + "\"" + ">" + shorter + "</a><br/>";
//            System.out.println("myline" + " = " + myline);
            newtext += myline + CRLF;
          }
        }
      } catch (IOException ex) {
        Logger.getLogger(Gifs2Body.class.getName()).log(Level.SEVERE, null, ex);
      }
      br.close();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Gifs2Body.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Gifs2Body.class.getName()).log(Level.SEVERE, null, ex);
    }
    System.out.println(newtext);

  }

  private static void automate() {
    all = drive + FS + FS + path + FS + sector + FS + subsector + FS + system + FS + system;
    uri = "file:///" + all;
    for (int i = 0; i < campaigns.length; i++) {
      switch (i) {
        case 0: {
          sector = "Vland";
          subsector = "P Kakadan";
          break;
        }
        case 1: {
          sector = "Gushemege";
          subsector = "J Sallounn";
          break;
        }
        case 2: {
          sector = "Spinward Marches";
          subsector = "C Regina";
          break;
        }
        case 3: {
          sector = "Spinward Marches";
          subsector = "B Jewell";
          break;
        }
        case 4: {
          sector = "Solomani Rim";
          subsector = "K Sol";
          break;
        }
      }
      for (int j = 0; j < campaigns[i].length; j++) {
        system = campaigns[i][j];
        all = drive + FS + FS + path + FS + sector + FS + subsector + FS + system + FS + system;
        filename = all + FS + system.toUpperCase() + " Counters.html";
        gifs2Body(all);
      }
    }
  }

  private static String gifs2Body(String folder) {
    //<editor-fold defaultstate="collapsed" desc="String mid">
    String mid = "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
      + "    <link rel=\"stylesheet\" href=\"/w3.css\">\n"
      + "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
      + "    <script src=\"jquery-3.2.1.min.js\"></script>\n"
      + "    <script src=\"https://www.w3schools.com/lib/w3.js\"></script>\n"
      + "";
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="String start">
    String start = "<!DOCTYPE html>\n"
      + "<!--\n"
      + "To change this license header, choose License Headers in Project Properties.\n"
      + "To change this template file, choose Tools | Templates\n"
      + "and open the template in the editor.\n"
      + "-->\n"
      + "<html>\n"
      + "  <head>\n"
      + "    <title>" + "Counters.html</title>\n"
      + "    <meta charset=\"UTF-8\">\n"
      + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
      + mid
      + "  </head>\n"
      + "  <body>\n"
      + "    <div>\n"
      + "";
    //</editor-fold>
    String end = "</div>\n</body>\n</html>\n";
    FileWriter fw = null;
    f = new File(folder);
    files = f.list();
    jta.setText(start);
    try {
      for (String file : files) {
        if (file.toLowerCase().endsWith(".gif")) {
          jta.append("<div>\n");
          jta.append("<img src=\"file:///" + all + FS + FS + file + "\">" + "</img><br/>\n");
        }
        if (file.toLowerCase().endsWith(".t5c")) {
          jta.append("<a href=\"file:///" + all + FS + FS + file + "\">" + file.substring(0, file.lastIndexOf('.')) + "</a>\n");
        }
      }
    } catch (Exception e) {
      System.out.println("e" + " = " + e);
    } finally {
      jta.append(end);
      text = jta.getText();
      filename = all + FS + system.toUpperCase() + " Counters.html";
      System.out.println("filename" + " = " + filename);
      saveFile(filename, text);
    }
    return text;
  }

  /**
   @param folder path to directory

   Prints output to put in a <div>SECTION</div> of HTML page
   */
  private static String[] list4Div(String folder, String end) {
    System.out.println();
    System.out.println("<!-- " + folder + " -->");
    System.out.println("<h2><br/>" + end.toUpperCase() + " Files<br/></h2>");
    String[] contents;
    String[] outstring = {""};
    File file = new File(folder);
    if (file.exists()) {
      contents = file.list();
      for (int i = 0; i < contents.length; i++) {
        if (contents[i].endsWith(end)) {
          int it = (contents[i].length() - end.length());
          String line = "<a href=\"file:///" + folder + FS
            + contents[i] + "\">" + contents[i].substring(0, it) + "</a><br/>";
          System.out.println(line);
        }
      }
    } else {
      //<editor-fold defaultstate="collapsed" desc="JOP">
      {
        String s = "";
        s += "BadFilename" + CRLF;
        s += "folder = " + folder + CRLF;
        s += "end = " + end + CRLF;
        JTextArea jta = new JTextArea(s, 50, 80);
        JScrollPane jsp = new JScrollPane(jta);
        JOptionPane.showMessageDialog(null, jsp);
      }
      //</editor-fold>
      return new String[]{"BadFilename"};
    }

    return outstring;
  }

  private static void listPages(String Sector, String SubSector) {
    Path sectorpath = Paths.get(drive, path, Sector);
    System.out.println("sectorpath" + " = " + sectorpath);
    Path subsectorpath = Paths.get(sectorpath.toString() + FS + SubSector);
    System.out.println("subsectorpath" + " = " + subsectorpath);
    File sub = new File(subsectorpath.toString());
    String[] sublist = sub.list();
    for (int i = 0; i < sublist.length; i++) {
      File file = new File(subsectorpath + FS + sublist[i] + FS + sublist[i]);
      if (file.isDirectory()) {
        if (!file.toString().contains("-")) {
          String[] syslist = file.list();
          for (int j = 0; j < syslist.length; j++) {
            if (syslist[j].endsWith(".html")) {
              System.out.println(" " + file.toString() + FS + syslist[j]);
              String[] words = syslist[j].split(" ");
              String w0 = words[0];
              int count = 0;
              for (int k = 1; k < words.length; k++) {
                if (words[k].equals(w0)) {
//                  System.out.println("DELETE" + " = " + file.toString() + FS + syslist[j]);
//                  File killme = new File(file.toString() + FS + syslist[j]);
//                  killme.delete();
                }
              }
            }
          }
        }
      }
    }
  }

  private static void listSubsector(String Sec, String Sub) {
    Path pathPath = Paths.get(drive, path, Sec, Sub);
    System.out.println("pathPath.toString()" + " = " + pathPath.toString());
    File filepath = pathPath.toFile();
    String[] sdirs = filepath.list();
    File f = new File("");
    for (int i = 0; i < sdirs.length; i++) {
      f = new File(pathPath + FS + Sub + FS + sdirs[i]);
      if (f.isDirectory()) {
        File f2 = new File(sdirs[i]);
      }
    }
  }

  private static void saveFile(String filename, String text) {
    try {
      System.out.println("\tfilename" + " = " + filename);
      FileWriter fw = new FileWriter(filename);
      fw.write(text);
      fw.close();
    } catch (IOException ex) {
      Logger.getLogger(Gifs2Body.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}
