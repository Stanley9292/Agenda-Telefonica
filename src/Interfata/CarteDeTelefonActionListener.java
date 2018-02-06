/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfata;

import agenda.telefonica.Abonat;
import static bazadedate.Conectare.verifyConnection;
import bazadedate.Interogari;
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
public class CarteDeTelefonActionListener {
    private final CarteDeTelefon carteDeTelefon;
    
    public CarteDeTelefonActionListener(CarteDeTelefon carteDeTelefon){
        this.carteDeTelefon = carteDeTelefon;
    }
    
    protected CarteDeTelefon getCarteDeTelefon(){
        return carteDeTelefon;
    }
    
    public void activareInput(){
        carteDeTelefon.getbCautare().setEnabled(true);
        carteDeTelefon.getbEditare().setEnabled(true);
        carteDeTelefon.getbAdauga().setEnabled(true);
        carteDeTelefon.getbStergere().setEnabled(true);
        carteDeTelefon.getbActualizare().setEnabled(true);
    }
    
    public void dezactivareInput(){
        carteDeTelefon.getbCautare().setEnabled(false);
        carteDeTelefon.getbEditare().setEnabled(false);
        carteDeTelefon.getbAdauga().setEnabled(false);
        carteDeTelefon.getbStergere().setEnabled(false);
        carteDeTelefon.getbActualizare().setEnabled(false);
    }
    
    public void cautareAbonat() {
        String textCautat = getCarteDeTelefon().gettCautare().getText();
        ArrayList<agenda.telefonica.Abonat> lista_abonati = new ArrayList<>();
        agenda.telefonica.Abonat abonat;
        
        try{
            
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
        this.getCarteDeTelefon().refreshTabela();
        this.getCarteDeTelefon().afiseaza_tabela(lista_abonati);
    }
    
    public void loginAbonat(){
        try{
            Connection c = verifyConnection();
            String user = getCarteDeTelefon().getUser().getText();
            String parola = getCarteDeTelefon().getParola().getText();
            PreparedStatement pst = c.prepareStatement(Interogari.queryLogin(user, parola));
            pst.setString(1, getCarteDeTelefon().getUser().getText());
            pst.setString(2, getCarteDeTelefon().getParola().getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username si parola corecte! Bine ati venit!");
                getCarteDeTelefon().getloginPanel().setVisible(false);
                activareInput();
                this.getCarteDeTelefon().afiseaza_tabela(this.getCarteDeTelefon().extrageDinBazadeDate());
            }
            else{
                JOptionPane.showMessageDialog(null, "Username si parola incorecte!");
            }
            c.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
