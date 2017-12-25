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
    static final int lungimeNumar = 10;
    private static final String identificareNumarFix = "02";
    private static final String identificareNumarMobil = "07";

    
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

    public NrTel getTipNumarTel(String numarTel) throws Exception {
	if((numarTel==null) || (numarTel.length() != lungimeNumar)) {
		throw new Exception("Formatul numarului introdus este incorect!");
        }
	if(numarTel.startsWith(identificareNumarMobil)){
		return new NrMobil(numarTel);
	} else if(numarTel.startsWith(identificareNumarFix)){
			return new NrFix(numarTel);
	} else {
		throw new Exception("Formatul numarului introdus este incorect!");
	}
    }
    
    //override metoda toString
    @Override
    public String toString(){
        return "Numarul de telefon este " + numar;
    }

    public int compareTo(NrTel nrTel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
}
