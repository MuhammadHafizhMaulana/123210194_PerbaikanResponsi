/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author acer
 */
public class Table_Room extends AbstractTableModel{
     List<Room> listroom;
    public Table_Room(List<Room> listroom){
        this.listroom = listroom;
    }
    @Override
    public int getRowCount() {
       return this.listroom.size();
    }

    @Override
    public int getColumnCount() {
       return 4;
    }
    
    @Override
    public String getColumnName(int column){
     switch(column)   {
         case 0 : return "Name";
         case 1 : return "Size";
         case 2 : return "Price";
         case 3 : return "Status";
         default : return null;
     }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0 : return listroom.get(rowIndex).getName();
            case 1 : return listroom.get(rowIndex).getSize();
            case 2 : return listroom.get(rowIndex).getPrice();
            case 3 : return listroom.get(rowIndex).getStatus();
            default : return null;
        }
    }
  
}