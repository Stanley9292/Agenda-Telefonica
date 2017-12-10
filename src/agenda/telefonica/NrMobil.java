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
public class NrMobil extends NrTel {
    private String mobil;
    private static final String formatMobil = "07";

    //constructor NrMobil
    public NrMobil(String mobil) {
        super(mobil);
        this.mobil = mobil;
    }
    
    //getter NrMobil
    public String getNrMobil() throws Exception {
        if((mobil == null) || (mobil.length() != lungimeNumar)){
            throw new Exception("fixul introdus este unul gresit!");
        }
        if(mobil.startsWith(formatMobil)){
            return mobil;
        }else{
            throw new Exception("Formatul introdus este unul gresit!");
        }
    }
    
    //setter NrMobil
    public void setNrMobil(String mobil ){
        this.mobil = mobil;
    }
    
    //override la metoda toString()
    @Override
    public String toString(){
        return "Numarul mobil este " + mobil;
    }
}
