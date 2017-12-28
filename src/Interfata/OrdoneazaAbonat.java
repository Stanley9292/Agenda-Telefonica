/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfata;

import agenda.telefonica.Abonat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stan
 */
public class OrdoneazaAbonat extends AbstractTableModel implements Comparable<String>{
    private List<Abonat> lista = new ArrayList<>();
    enum CriteriuOrdonare{DUPA_NUME, DUPA_PRENUME, DUPA_CNP, DUPA_NUMARTELEFON};
    Map<CriteriuOrdonare, Comparator<Abonat>> comparatori = new HashMap<>();

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(String o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    Comparator<Abonat> dupaNume = new Comparator<Abonat>() {
        @Override
        public int compare(Abonat a1, Abonat a2) {
            return a1.getNume().compareTo(a2.getNume());
        }
    };
    
    Comparator<Abonat> dupaPrenume = new Comparator<Abonat>() {
        @Override
        public int compare(Abonat a1, Abonat a2) {
            return a1.getPrenume().compareTo(a2.getPrenume());
        }
    };
    
    Comparator<Abonat> dupaCNP = new Comparator<Abonat>() {
        @Override
        public int compare(Abonat a1, Abonat a2) {
            return a1.getCNP().compareTo(a2.getCNP());
        }
    };
    
    Comparator<Abonat> dupaNrTel = new Comparator<Abonat>() {
        @Override
        public int compare(Abonat a1, Abonat a2) {
            return a1.getNrFix().compareTo(a2.getNrFix());
        }
    }; 
    
    private void ordoneaza(CriteriuOrdonare c){
        Collections.sort(lista, comparatori.get(c));
    }
    
    //reimprospatare jtable
    protected void regenerateTable(){
        String[] data = new String[lista.size()];
        for (int i = 0; i<data.length; i++){
            Abonat a = lista.get(i);
            data[i] = a.getNume();
        }
        //tabela.setListData(data);
    }
    
}
