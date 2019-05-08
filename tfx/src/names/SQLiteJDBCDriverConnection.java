/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package names;

import java.sql.*;

/**
 *
 * @author Mark Ferguson
 */
public class SQLiteJDBCDriverConnection {

    private static String url;

    /**
     * Connect to a sample database
     */
    public static void connect() {
        System.out.println("\tconnect()");
        Connection conn = null;
        try {
            // db parameters
            url = "jdbc:sqlite:C:/sqlite/names.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}
