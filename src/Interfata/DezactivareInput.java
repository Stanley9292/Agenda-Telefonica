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
 * @author AGStan
 */
public class DezactivareInput extends AbstractCarteDeTelefonActionListener implements ActionListener{

    public DezactivareInput(CarteDeTelefon carteDeTelefon){
        super(carteDeTelefon);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        dezactivareInput();
    }
    
}
