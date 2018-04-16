/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.telefonica;


import static bazadedate.Conectare.verifyConnection;
import bazadedate.Interogari;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import Interfata.CarteDeTelefon;

/**
 *
 * @author Octavian
 */
public class CarteModel extends AbstractTableModel {

    Statement s;
    private final String q = "SELECT * FROM agenda";
    private String filtru = "";
//    String nume;
//    String prenume;
//    String CNP;
//    String nr_Fix;
//    String nr_mobil;
    
    //Abonat abonat = new Abonat(carte.gettNume().getText(), carte.gettPrenume().getText(), carte.gettCNP().getText(), carte.gettNumarFix().getText(), carte.gettNumarMobil().getText());
    //NrMobil mobil = new NrMobil(carte.gettNumarMobil().getText());
    //NrFix fix = new NrFix(carte.gettNumarFix().getText());

    public CarteModel() throws SQLException {
        Connection c = verifyConnection();
        s = c.createStatement();
        
    }

    public void adaugare(String nume, String prenume, String CNP, String Numar_Mobil,String Numar_Fix) throws SQLException {
        Abonat a =new Abonat(nume, prenume, CNP, Numar_Mobil, Numar_Fix);
        s.executeUpdate(bazadedate.Interogari.queryAdaugare(nume, prenume, CNP, Numar_Mobil, Numar_Fix));
        fireTableDataChanged();
    }

    public void stergere(String nume, String prenume, String CNP) throws SQLException {
        s.executeUpdate(Interogari.queryStergere(nume, prenume, CNP));
        fireTableDataChanged();
    }

    public void modificare(Abonat a) {
//      s.executeUpdate("UPDATE.....");
        fireTableDataChanged();
    }

    public void cautare(String textCautat) {
        filtru = " WHERE Nume like '%" + textCautat + "%'"
                + "OR Prenume like '%" + textCautat + "%'"
                + "OR CNP like '%" + textCautat + "%'"
                + "OR Numar_Fix like '%" + textCautat + "%'"
                + "OR Numar_Mobil like '%" + textCautat + "%'";
        fireTableDataChanged();
    }

    public void ordonare(Abonat a) {

    }

    @Override
    public int getRowCount() {
        try {
            String countSql = "SELECT COUNT(*) as rezultate FROM agenda " + filtru;
            ResultSet r = s.executeQuery(countSql);
            r.first();
            return r.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(CarteModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return 6;
        //carteDeTelefon.getTabela().getColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            // extragerea valorii unei celule din baza de date
            String sql = q + " " + filtru;
            ResultSet r = s.executeQuery(sql);
            r.absolute(rowIndex + 1);
            return r.getString(columnIndex + 1);

            //carteDeTelefon.getTabela().getValueAt(rowIndex, columnIndex);
        } catch (SQLException ex) {
            Logger.getLogger(CarteModel.class.getName()).log(Level.SEVERE, null, ex);
            return "eroare";
        }
    }

}
