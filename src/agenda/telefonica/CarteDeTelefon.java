/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.telefonica;

import InteractiuneGUI.ActionListenerPersonal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Stan
 */
public class CarteDeTelefon extends JFrame {
    
    private Connection conn; //variabila pentru conectarea la baza de date
    
    private DefaultTableModel model;
    private JTable tabel = new JTable();
    private int randSelectat = 0;
    
    private JTextField numeText = new JTextField(15);
    private JTextField prenumeText = new JTextField(15);
    private JTextField cnpText = new JTextField(15);
    private JTextField telefonText = new JTextField(15);
    private JTextField cautareText = new JTextField(15);
    
    private final ActionListenerPersonal actionListenerPersonal;
    
    private static final int lungimeNumar = 10;
    private static final String formatMobil = "07";
    private static final String formatFix = "02";
    
    protected CarteDeTelefon(Connection conn){
        this.setConn(conn);
        actionListenerPersonal = new ActionListenerPersonal(this);
    }

    //getter NrTelefon, verificare daca e null, lungime diferita decat 10 si format nr telefon
    public NrTel getNrTel(String numar) throws Exception{
        if((numar == null) || (numar.length() != lungimeNumar)){
            throw new Exception("Numarul introdus este unul gresit!");
        }
        if(numar.startsWith(formatFix)){
            return new NrFix(numar);
        } else if(numar.startsWith(formatMobil)){
            return new NrMobil(numar);
        }else{
            throw new Exception("Formatul introdus este unul gresit!");
        }
    }

    private void setConn(Connection conn) {
        this.conn = conn;
    }
    
}
