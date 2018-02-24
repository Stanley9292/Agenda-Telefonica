/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.telefonica;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Octavian
 */
public class CarteTelefon extends AbstractTableModel{
    private List<Abonat> abonati;
    
    public void adaugare(Abonat a){
        
    }
    public void stergere(Abonat a){
        
    }
    public void editare(Abonat a){
        
        fireTableDataChanged();
    }
    public void cautare(Abonat a){
        
    }
    public void ordonare(Abonat a){
        
    }
}
