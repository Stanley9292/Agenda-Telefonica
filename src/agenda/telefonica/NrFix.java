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
    private static final String formatFix = "02";
    

    //constructor
    public NrFix(String fix) {
        super(fix);
        this.fix = fix;
    }
    
    //getter pentru clasa Fix
    public String getFix()throws Exception{
        if((fix == null) || (fix.length() != lungimeNumar)){
            throw new Exception("fixul introdus este unul gresit!");
        }
        if(fix.startsWith(formatFix)){
            return fix;
        }else{
            throw new Exception("Formatul introdus este unul gresit!");
        }
    }
    
    //setter pentru clasa Fix
    public void setFix(String fix){
        this.fix = fix;
    }
    
    @Override
    public String toString(){
        return "fixul fix este " + fix;
    }
    
}
