/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAORoom;
import interfce.interfaceRoom;
import java.util.List;
import model.Room;
import model.Table_Room;
import view.ViewLogin;
import view.ViewRoomList;

/**
 *
 * @author acer
 */
public class ControllerRoomList {
    ViewLogin viewlogin;
    interfaceRoom iRoom;
    ViewRoomList viewroomlist;
    List<Room> listroom;
    
    public ControllerRoomList(ViewRoomList viewroomlist){
        this.viewroomlist = viewroomlist;
        iRoom = new DAORoom();
    }
    
    public void readData(){
        listroom = iRoom.getAll();
        Table_Room tabelroom = new Table_Room(listroom);
        viewroomlist.getTableData().setModel(tabelroom);
        
    }
    
}
