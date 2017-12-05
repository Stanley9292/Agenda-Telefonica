/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.telefonica;

/**
 *
 * @author AGStan
 */
public class NrFix extends NrTel {
    private String fix;

    //constructor
    public NrFix(String fix) {
        super(fix);
        this.fix = fix;
    }
    
    //getter pentru clasa Fix
    public String getFix(){
        return fix;
    }
    
    //setter pentru clasa Fix
    public void setFix(String fix){
        this.fix = fix;
    }
    
    @Override
    public String toString(){
        return "Numarul fix este " + fix;
    }
    
}
