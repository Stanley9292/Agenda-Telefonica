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
public class Abonat {
    private String nume;
    private String prenume;
    private long CNP;
    private NrTel numarTelefon;
    //camp de tip NrTel
    
    //constructor cu parametrii
    public Abonat(String nume, String prenume, long CNP){
        this.nume = nume;
        this.prenume = prenume;
        this.CNP = CNP;
    }
    
    //getteri
    public String getNume(){
        return nume;
    }
    
    public String getPrenume(){
        return prenume;
    }
    
    public long getCNP(){
        return CNP;
    }
    
    public NrTel getNrTel(){
        return numarTelefon;
    }
    
    //setteri
    public void setNume(String nume){
        this.nume = nume;
    }
    
    public void setPrenume(String prenume){
        this.prenume = prenume;
    }
    
    public void setCNP(long CNP){
        this.CNP = CNP;
    }
    
    public void setNrTel(NrTel numarTelefon){
        this.numarTelefon = numarTelefon;
    }
    
    @Override
    public String toString(){
        return "Numele este " + nume + ",prenumele este " + prenume + " ,CNP-ul este " + CNP;
    }
    
}
