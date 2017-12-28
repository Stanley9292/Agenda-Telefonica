/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfata;

import agenda.telefonica.Abonat;
import agenda.telefonica.NrFix;
import agenda.telefonica.NrMobil;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author AGStan
 */
public class AgendaTelefonicaTableModel extends AbstractTableModel {
    private static final int COLUMN_NUME = 0;
    private static final int COLUMN_PRENUME = 1;
    private static final int COLUMN_CNP = 2;
    private static final int COLUMN_NUMAR_FIX = 3;
    private static final int COLUMN_NUMAR_MOBIL = 4;
    
    private String[] columnNames = {"Nume", "Prenume", "CNP", "Numar fix", "Numar mobil"};
    private List<Abonat> listaAbonati;
     
    public AgendaTelefonicaTableModel(List<Abonat> listaAbonati) {
        this.listaAbonati = listaAbonati;
         
        int indexCount = 1;
        for (Abonat a : listaAbonati) {
            a.setIndex(indexCount++);
        }
    }
 
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount() {
        return listaAbonati.size();
    }
     
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
     
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (listaAbonati.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Abonat a = listaAbonati.get(rowIndex);
        Object returnValue = null;
         
        switch (columnIndex) {
        case COLUMN_NUME:
            returnValue = a.getNume();
            break;
        case COLUMN_PRENUME:
            returnValue = a.getPrenume();
            break;
        case COLUMN_CNP:
            returnValue = a.getCNP();
            break;
        case COLUMN_NUMAR_FIX:
            returnValue = a.getNrFix();
            break;
        case COLUMN_NUMAR_MOBIL:
            returnValue = a.getNrMobil();
            break;
        default:
            throw new IllegalArgumentException("Invalid column index");
        }
        return returnValue;
    }
     
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        Abonat a = listaAbonati.get(rowIndex);
        if (columnIndex == COLUMN_NUME) {
            a.setIndex((int) value);
        }      
    }
    
}
