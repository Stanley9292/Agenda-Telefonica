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

//clasa dedicata returnarii fiecarei clase
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
    
    public LoginAbonat getLoginAbonat(){
        return new LoginAbonat(carteDeTelefon);
    }
    
    public StergeAbonat getStergeAbonat(){
        return new StergeAbonat(carteDeTelefon);
    }
    
    public EditareAbonat getEditareAbonat(){
        return new EditareAbonat(carteDeTelefon);
    }
    
}
