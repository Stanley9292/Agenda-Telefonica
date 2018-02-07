/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazadedate;

import agenda.telefonica.Abonat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Stan
 */
public class Conectare {
    
    private static String db = "jdbc:mysql://localhost/global";
    private static String user = "root";
    private static String pass = "root";
    private static String url = "" + db;
    private static Connection con;
    
    public static Connection verifyConnection(){
        try{
            con = DriverManager.getConnection(db, user, pass);
        }catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex);
        }
        return con;
    }
}
