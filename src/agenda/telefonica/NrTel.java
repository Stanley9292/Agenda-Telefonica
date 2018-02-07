/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.telefonica;

/**
 *
 * @author Stan
 */
public abstract class NrTel {
    private String numar;
    protected static final int lungimeNumar = 10;
    protected static final String formatMobil = "07";
    protected static final String formatFix = "021";
    
    public abstract boolean verificareNrTel(String numar);
    
    //constructor cu parametru
    public NrTel(String numar){
        this.numar = numar;
    }
    
    //getter NrTel
    public String getNrTel(){
        return numar;
    }
    
    //setter NrTel
    public void setNumar(String numar){
        this.numar = numar;
    }

    //override metoda toString
    @Override
    public String toString(){
        return "Numarul de telefon este " + numar;
    } 
}
