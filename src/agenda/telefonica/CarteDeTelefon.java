/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.telefonica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Stan
 */
public class CarteDeTelefon {
    
    private static final int lungimeNumar = 10;
    private static final String formatMobil = "07";
    private static final String formatFix = "02";

//  pentru validare 10 cifre  -   \d{10}
//  

    //getter NrTelefon, verificare daca e null, lungime diferita decat 10 si format nr telefon
    public NrTel getNrTel(String numar) throws Exception{
        if((numar == null) || (numar.length() != lungimeNumar)){
            throw new Exception("Numarul introdus este unul gresit!");
        }
        if(numar.startsWith(formatFix)){
            return new NrFix(numar);
        } else if(numar.startsWith(formatMobil)){
            return new NrMobil(numar);
        }else{
            throw new Exception("Formatul introdus este unul gresit!");
        }
    }
    
}
