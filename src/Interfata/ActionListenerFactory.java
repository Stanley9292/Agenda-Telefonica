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
public class ActionListenerFactory {
    private final CarteDeTelefon carteDeTelefon;
    
    public ActionListenerFactory(CarteDeTelefon carteDeTelefon) {
		this.carteDeTelefon = carteDeTelefon;
	}
    
    public ActivareInput getActivareInput(){
        return new ActivareInput(carteDeTelefon);
    }
    
    public DezactivareInput getDezactivareInput(){
        return new DezactivareInput(carteDeTelefon);
    }
    
    public CautaAbonat getCautaAbonat(){
        return new CautaAbonat(carteDeTelefon);
    }
    
    
}