/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package names;

/**
 *
 * @author Mark Ferguson modified & linux ready by Leam Hall & Scott
 * ????(Makhidkarun)
 */
//import java.io.BufferedReader;
//import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author sqlitetutorial.net
 */
public class SelectApp {

    //path to this folder on hd, but can be changed (public)
    public static String path = "C:/GitHub/Names/Names/src/names/";
    private static String namesDb = null;
    private static String CRLF = "\n";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        SelectApp app = new SelectApp();
        Class selectAppClass = app.getClass();
        URL namesDbUrl = selectAppClass.getResource("names.db");
        if (namesDbUrl == null) {
            System.err.println("Names database 'names.db' not found");
            System.exit(1);
        }
        if (!namesDbUrl.toString().startsWith("file:")) {
            System.err.println("Names database 'names.db' not found locally");
            System.err.println("namesDbUrl=" + namesDbUrl);
            System.exit(1);
        }
        namesDb = namesDbUrl.toString().substring(5);

        String line = app.getCouple("humaniti");
        System.out.println(line);
//        savePage(line);
//        int num = 3;
//        app.selectOne("humaniti_female_first", num);
//        app.selectAll("humaniti_male_first");
//        app.randomOne("humaniti_female_first");
    }

    private String getCouple(String race) {
        String first = race + "_male_first";
        String second = race + "_female_first";
        String third = race + "_last";
        String[] tables = {first, second, third};

        String manfirst = "";
        String femfirst = "";
        String surname = "";
        String[] names = {manfirst, femfirst, surname};

        for (int i = 0; i < 3; i++) {
            String tablename = tables[i];
            String sql = "SELECT * FROM " + tablename + " ORDER BY RANDOM() LIMIT 1";
            names[i] = randomOne(tables[i]);
            try (Connection conn = this.connect();
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(sql)) {
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        String Couple = names[0] + " & " + names[1] + " " + names[2];
        return Couple;
    }

    public String randomOne(String tablename) {
        String sql = "SELECT * FROM " + tablename + " ORDER BY RANDOM() LIMIT 1";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            return (rs.getString("name"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Connect to the names.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:" + namesDb;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    //==================== COMMENTED OUT ==========================
    //<editor-fold defaultstate="collapsed" desc="OLD">

//    private static void savePage(String name) throws FileNotFoundException {
//        try {
//            //System.out.println(name);
//            String page = replaceHTML("test.html", name, name + ".html");
//            System.out.println(page);
//        } catch (IOException ex) {
//            Logger.getLogger(SelectApp.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static String replaceHTML(String fname, String insert, String output) throws FileNotFoundException, IOException {
//        BufferedReader br = new BufferedReader(new FileReader(path + fname));
//        String line = "";
//        String page = "";
//        while ((line = br.readLine()) != null) {
//            line = line.replace("REPLACE", insert);
//            page += line + CRLF;
//        }
//        br.close();
//        FileWriter fw = new FileWriter(path + output);
//        fw.write(page);
//        fw.close();
//        return page;
//    }


    //    /**
    //     * select all rows in the table
    //     */
    //    public void selectAll(String tablename) {
    //        String sql = "SELECT * FROM " + tablename;
    //        try (Connection conn = this.connect();
    //                Statement stmt = conn.createStatement();
    //                ResultSet rs = stmt.executeQuery(sql)) {
    //            // loop through the result set
    //            while (rs.next()) {
    //                System.out.println(rs.getString("name"));
    //            }
    //        } catch (SQLException e) {
    //            System.out.println(e.getMessage());
    //        }
    //    }
    //
    //    public void selectOne(String tablename, int num) {
    //        String sql = "SELECT * FROM " + tablename;
    //        int count = 0;
    //        try (Connection conn = this.connect();
    //                Statement stmt = conn.createStatement();
    //                ResultSet rs = stmt.executeQuery(sql)) {
    //            // loop through the result set
    //            rs.next();
    //            while (count < num) {
    //                if (count == (num - 1)) {
    //                    System.out.println(rs.getString("name"));
    //                }
    //                count += 1;
    //                rs.next();
    //            }
    //        } catch (SQLException e) {
    //            System.out.println(e.getMessage());
    //        }
    //    }
    //</editor-fold>
}
