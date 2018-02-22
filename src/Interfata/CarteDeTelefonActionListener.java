/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfata;

import agenda.telefonica.Abonat;
import agenda.telefonica.NrFix;
import agenda.telefonica.NrMobil;
import static bazadedate.Conectare.verifyConnection;
import bazadedate.Interogari;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author AGStan
 */

//clasa care contine metodele de manipulare a datelor din baza de date
//si metodele de dezactivare si activare butoane
public class CarteDeTelefonActionListener extends javax.swing.JFrame {
    
    private boolean isLogged = false;
    private final CarteDeTelefon carteDeTelefon;
    private String NrFix;
    private String NrMobil;
    private NrFix nrFix = new NrFix(NrFix);
    private NrMobil nrMobil = new NrMobil(NrMobil);
    
    public CarteDeTelefonActionListener(){
        carteDeTelefon = new CarteDeTelefon();
    }
    
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
        
        if (isLogged == true){
            JOptionPane.showMessageDialog(null, "Sunteti deja logat!");
        }
        else{
            try{
            Connection c = verifyConnection();
            String user = getCarteDeTelefon().getUser().getText();
            String parola = getCarteDeTelefon().getParola().getText();
            PreparedStatement pst = c.prepareStatement(Interogari.queryLogin(user, parola));
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username si parola corecte! Bine ati venit!");
                isLogged = true;
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
    
    public void stergeAbonat(){
         try{
             Connection c = verifyConnection();      
             int row = getCarteDeTelefon().getTabela().getSelectedRow();            
             int valoareMesaj = JOptionPane.showConfirmDialog(null, "Doriti stergerea abonatului?", "Confirmati stergerea?", JOptionPane.YES_NO_OPTION);				
             
             if (valoareMesaj == JOptionPane.YES_OPTION) {
                String nume = getCarteDeTelefon().getTabela().getModel().getValueAt(row, 0).toString();
                String prenume = getCarteDeTelefon().getTabela().getModel().getValueAt(row, 1).toString();
                String CNP = getCarteDeTelefon().getTabela().getModel().getValueAt(row, 2).toString();
                PreparedStatement pst = c.prepareStatement(Interogari.queryStergere(nume, prenume, CNP));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Stergere reusita!");
             }
             else{
                 JOptionPane.showMessageDialog(null, "Abonatul nu a fost sters!");
             }            
             getCarteDeTelefon().refreshTabela();
            
         }
         catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
         }    
    }
    
    public void editareAbonat(){
        try{
            Connection c = verifyConnection();
            int row = getCarteDeTelefon().getTabela().getSelectedRow();
            if(!getCarteDeTelefon().getTabela().isRowSelected(row)){
                JOptionPane.showMessageDialog(null, "Va rog selectati un camp");
            }
            
            //extragere date din jtable
            String nume = getCarteDeTelefon().gettNume().getText();
            String prenume = getCarteDeTelefon().gettPrenume().getText();
            String CNP = getCarteDeTelefon().gettCNP().getText();
            String numar_fix = getCarteDeTelefon().gettNumarFix().getText();
            String numar_mobil = getCarteDeTelefon().gettNumarMobil().getText();
            
            Abonat abonat = new Abonat(nume, prenume, CNP);

            PreparedStatement pst = c.prepareStatement(Interogari.queryEditare(nume, prenume, CNP, numar_fix, numar_mobil));      

            pst.setString(1, nume);
            pst.setString(2, prenume);
            pst.setString(3, CNP);
            pst.setString(4, numar_fix);
            pst.setString(5, numar_mobil);

            if(nrFix.verificareNrTel(getCarteDeTelefon().gettNumarFix().getText()) && nrMobil.verificareNrTel(getCarteDeTelefon().gettNumarMobil().getText())){
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Randul " + row + " a fost editat cu succes.");                
                getCarteDeTelefon().afiseaza_tabela(getCarteDeTelefon().extrageDinBazadeDate());            
            }else{
                JOptionPane.showMessageDialog(null, "Date nu au fost inserate! Ceva ati gresit!");
            }

        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(
                   this,
                    e.getMessage(),
                    "EROARE",
                    JOptionPane.ERROR_MESSAGE
            );
        }
       
    }
    
}
