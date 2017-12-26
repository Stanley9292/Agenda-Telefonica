/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfata;

/**
 *
 * @author Stan
 */
public class ActionListenerFactory {
    private final CarteDeTelefon carteDeTelefon;
    
    public ActionListenerFactory(CarteDeTelefon carteDeTelefon){
        this.carteDeTelefon = carteDeTelefon;
    }
    
    public ActivareInput getActivareInput(){
        return new ActivareInput(carteDeTelefon);
    }
    
    public SalveazaAbonat getSalveazaAbonat(){
        return new SalveazaAbonat(carteDeTelefon);
    }
    
    public StergeAbonat getStergeAbonat(){
        return new StergeAbonat(carteDeTelefon);
    }
    
    public ActualizeazaAbonat getActualizeazaAbonat(){
        return new ActualizeazaAbonat(carteDeTelefon);
    }
    
    public AnuleazaInput getAnuleazaInput(){
        return new AnuleazaInput(carteDeTelefon);
    }
    
    
}
