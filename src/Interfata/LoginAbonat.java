/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Stan
 */
//clasa care mosteneste CarteDeTelefonActionListener si implementeaza ActionListener
//care ne obliga sa facem override metodei ActionPerformed pentru a apela metoda specifica acestei clase
public class LoginAbonat extends CarteDeTelefonActionListener implements ActionListener{

    public LoginAbonat(CarteDeTelefon carteDeTelefon) {
        super(carteDeTelefon);
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        loginAbonat();
    }
    
}
