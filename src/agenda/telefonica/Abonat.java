/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.telefonica;

import javax.swing.JOptionPane;

/**
 *
 * @author Stan
 */
public class Abonat {
    private String nume;
    private String prenume;
    private String CNP;
    private NrFix nrFix;
    private NrMobil nrMobil;
    
    //camp de tip NrTel
    
    //constructor cu parametrii
    public Abonat(String nume, String prenume, String CNP){
         if (nume == null || nume.length() == 0 || prenume == null || prenume.length() == 0) {
            throw new IllegalArgumentException("Numele si prenumele nu pot lipsi!");      
        }
        if(!nume.matches("[A-Za-z \\-]+") || !prenume.matches("[A-Za-z \\-]+")){
            //JOptionPane.showMessageDialog(null, "Numele nu pare de om!");
            throw new IllegalArgumentException("Numele nu pare de om!");  
        }
        if(CNP.length() != 13){
            //JOptionPane.showMessageDialog(null, "CNP-ul introdus trebuie sa aiba 13 caractere");
            throw new IllegalArgumentException("CNP-ul introdus trebuie sa aiba 13 caractere");  
        }
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
    }
    
    public Abonat(String nume, String prenume, String CNP, String nrFix, String nrMobil){
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
        this.nrFix = new NrFix(nrFix);
        this.nrMobil = new NrMobil(nrMobil);
    }
    
    //getteri
    public String getNume(){
        return nume;
    }
    
    public String getPrenume(){
        return prenume;
    }
    
    public String getCNP(){
        return CNP;
    }
    
    public NrFix getNrFix(){
        return nrFix;
    }
    
    public NrMobil getNrMobil(){
        return nrMobil;
    }
    
    //setteri
    public void setNume(String nume){
        this.nume = nume;
    }
    
    public void setPrenume(String prenume){
        this.prenume = prenume;
    }
    
    public void setCNP(String CNP){
        this.CNP = CNP;
    }
    
   
    
    @Override
    public String toString(){
        return "Numele este " + nume + ",prenumele este " + prenume + " ,CNP-ul este " + CNP;
    }

    public void setIndex(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
