/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.telefonica;

import InteractiuneGUI.ActionListenerPersonal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
    
    private final ActionListenerPersonal actionListenerPersonal;
    
    
    
    
    
    protected CarteDeTelefon(Connection conn){
        this.setConn(conn);
        actionListenerPersonal = new ActionListenerPersonal(this);
    }

    private void setConn(Connection conn) {
        this.conn = conn;
    }
    
}
