/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazadedate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stan
 */
public class Conectare {
    private static String db = "agenda";
    private static String user = "agenda";
    private static String pass = "agenda1";
    private static String url = "" + db;
    private static Connection Conn;
    
    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver"); //incaracarea driver-ului
            Conn = DriverManager.getConnection(url,user,pass); //deschiderea conexiunii la baza de date
        } catch (Exception e) {
            System.err.println("Conexiunea nu s-a putut realiza.");
        }
        return Conn;
    }
}
