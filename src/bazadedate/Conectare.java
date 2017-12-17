/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazadedate;

import agenda.telefonica.Abonat;
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
    
    private static String db = "jdbc:mysql://localhost/agenda_telefonica";
    private static String user = "root";
    private static String pass = "root";
    private static String url = "" + db;
    
    public static ArrayList<Abonat> afisareDinBazadeDate(){
        
            ArrayList<agenda.telefonica.Abonat> lista_abonati = new ArrayList<>();

            try {
                java.sql.Connection c = DriverManager.getConnection(db, user, pass);
                String query1 = "Select * FROM agenda";
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(query1);
                agenda.telefonica.Abonat abonat;
                //agenda.telefonica.NrTel nrTel;

                while(rs.next()){
                    abonat = new Abonat(rs.getString("nume"), rs.getString("prenume"), rs.getString("CNP"));
                    //nrTel = new NrTel(rs.getString("telefon")) {};
                   lista_abonati.add(abonat);

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            return lista_abonati;
    }
    
}
