/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfata;

/**
 *
 * @author AGStan
 */
public abstract class AbstractCarteDeTelefonActionListener {
    private final CarteDeTelefon carteDeTelefon;
    
    public AbstractCarteDeTelefonActionListener(CarteDeTelefon carteDeTelefon){
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
        carteDeTelefon.getbOrdonare().setEnabled(true);
    }
    
    public void dezactivareInput(){
        carteDeTelefon.getbCautare().setEnabled(false);
        carteDeTelefon.getbEditare().setEnabled(false);
        carteDeTelefon.getbAdauga().setEnabled(false);
        carteDeTelefon.getbStergere().setEnabled(false);
        carteDeTelefon.getbOrdonare().setEnabled(false);
    }
    
}
