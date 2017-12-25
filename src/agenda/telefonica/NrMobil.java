/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.telefonica;

import javax.swing.JOptionPane;

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
        if((mobil == null) || (mobil.length() != lungimeNumar)){
            JOptionPane.showMessageDialog(null, "Lungimea numarului introdus trebuie sa fie de 10 caractere");
        }
        if(mobil.startsWith(formatMobil)){
            this.mobil = mobil;
        }else{
            JOptionPane.showMessageDialog(null, "Formatul introdus este unul gresit! Trebuie sa inceapa cu 07");
        }
    }
    
    //getter NrMobil
    public String getMobil() throws Exception {
        return mobil;
    }
    
    //setter NrMobil
    public void setNrMobil(String mobil ){
        this.mobil = mobil;
    }
    
    //override la metoda toString()
    @Override
    public String toString(){
        return mobil;
    }
}
