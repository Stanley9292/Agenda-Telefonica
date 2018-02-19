/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazadedate;

import agenda.telefonica.Abonat;

/**
 *
 * @author Stan
 */

//clasa care contine metode statice pentru query-urile importante
public class Interogari {
    public static String queryEditare(String nume, String prenume, String CNP, String nr_fix, String nr_mobil){
        return "UPDATE agenda SET nume=?, prenume=?, CNP =?, Numar_Mobil=?, Numar_Fix=? WHERE "
                + "nume= '"  + nume + "' AND prenume=  '" + prenume + "' AND cnp= '" + CNP + "' AND Numar_Mobil= '" + nr_mobil + "' AND Numar_Fix= '" + nr_fix + "';" ;                
    }
    
    public static String queryAdaugare(){
        return  "INSERT INTO agenda(nume, prenume, CNP, Numar_Mobil, Numar_Fix)values(?,?,?,?,?);";
    }
    
    public static String queryStergere(String nume, String prenume, String CNP){
        return "DELETE FROM agenda WHERE nume= '" + nume + "' AND prenume=  '" + prenume + "' AND cnp= '" + CNP + "';";
    }
    
    public static  String queryCautare(String textCautat){
        return "SELECT Nume, Prenume, CNP, Numar_Mobil, Numar_Fix FROM agenda"
                            + " WHERE Nume like '%" + textCautat + "%'"
                            + "OR Prenume like '%" + textCautat + "%'" 
                            + "OR CNP like '%" + textCautat + "%'"
                            + "OR Numar_Fix like '%" + textCautat + "%'"
                            + "OR Numar_Mobil like '%" + textCautat + "%'";
    }
    
    public static String queryLogin(String user, String parola){
        return "Select * from user WHERE username= '" + user + "' and parola= '" + parola + "';";
    }
}
