/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfata;

import agenda.telefonica.Abonat;
import static bazadedate.Conectare.verifyConnection;
import bazadedate.Interogari;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author AGStan
 */
public class CautaAbonat extends AbstractCarteDeTelefonActionListener implements ActionListener{

    public CautaAbonat(CarteDeTelefon carteDeTelefon) {
        super(carteDeTelefon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        try{
            String textCautat = getCarteDeTelefon().gettCautare().getText();        
            ArrayList<agenda.telefonica.Abonat> lista_abonati = new ArrayList<>();
            agenda.telefonica.Abonat abonat;
            
            if(textCautat != null & textCautat.length() > 0){            
                Connection c = verifyConnection();
                PreparedStatement pst = c.prepareStatement(Interogari.queryCautare(textCautat));
                String sqlRezultate = "SELECT COUNT(*) as rezultate FROM ( "
                                      + Interogari.queryCautare(textCautat) + " ) as inregistrari";
                
               
                Statement st = c.createStatement();
                ResultSet rsRezultate = st.executeQuery(sqlRezultate); 
                rsRezultate.next();
                rsRezultate.close();
                
                ResultSet rs = st.executeQuery(Interogari.queryCautare(textCautat));
               
                while(rs.next()){
                    String nume = rs.getString("nume");
                    String prenume = rs.getString("prenume");
                    String CNP = rs.getString("CNP");
                    String nrFix = rs.getString("Numar_Fix");
                    String nrMobil = rs.getString("Numar_Mobil");
                    abonat = new Abonat(nume, prenume, CNP, nrFix, nrMobil);
                    lista_abonati.add(abonat);
                }
                int rezultate = lista_abonati.size();
                if(rezultate >= 1){
                   JOptionPane.showMessageDialog(null, "Am gasit: " + rezultate + " rezultate."); 
                }else{
                   JOptionPane.showMessageDialog(null, "Niciun rezultat gasit!");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Completati campul de cautare");
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Eroare: " + ex.getMessage());
        }
        //refreshTabela();
        //afiseaza_tabela(lista_abonati);
    }
    
}
