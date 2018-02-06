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
public class CautaAbonat extends CarteDeTelefonActionListener implements ActionListener{

    public CautaAbonat(CarteDeTelefon carteDeTelefon) {
        super(carteDeTelefon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cautareAbonat();
    }
    
}
