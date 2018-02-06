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

/**
 *
 * @author Stan
 */
public class OrdonareAbonat {
    ArrayList<Abonat> lista= new ArrayList<Abonat>();
    public enum CriteriuOrdonare{DUPA_NUME, DUPA_PRENUME, DUPA_CNP, DUPA_FIX, DUPA_MOBIL};
    Map<CriteriuOrdonare, Comparator<Abonat>> comparatori = new HashMap<>();
    
    
    public OrdonareAbonat(){
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
    
    Comparator<Abonat> dupaNrFix = new Comparator<Abonat>() {
        @Override
        public int compare(Abonat a1, Abonat a2) {
            return a1.getNrFix().compareTo(a2.getNrFix());
        }
    }; 
    
     Comparator<Abonat> dupaNrMobil = new Comparator<Abonat>() {
        @Override
        public int compare(Abonat a1, Abonat a2) {
            return a1.getNrMobil().compareTo(a2.getNrMobil());
        }
    }; 
     comparatori.put(CriteriuOrdonare.DUPA_NUME, dupaNume);
     comparatori.put(CriteriuOrdonare.DUPA_PRENUME, dupaPrenume);
     comparatori.put(CriteriuOrdonare.DUPA_CNP, dupaCNP);
     comparatori.put(CriteriuOrdonare.DUPA_FIX, dupaNrFix);
     comparatori.put(CriteriuOrdonare.DUPA_MOBIL, dupaNrMobil);
    }  
     
    public List<Abonat> ordoneaza(CriteriuOrdonare c){
           Collections.sort(lista, comparatori.get(c));
           return lista;
           
    }
}
