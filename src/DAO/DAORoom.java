/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connection.koneksi;
import interfce.interfaceRoom;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Room;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author acer
 */
public class DAORoom implements interfaceRoom{
    Connection connect;
    
    public DAORoom(){
        connect = koneksi.getConnection();
    }

    @Override
    public List<Room> getAll() {
        List<Room> listRoom = null;
        try{
            listRoom = new ArrayList<>();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM rooms");
                while (rs.next()){
                    Room room = new Room();
                    room.setName(rs.getString("name"));
                    room.setSize(rs.getString("size"));
                    room.setPrice(rs.getInt("price"));
                    room.setStatus(rs.getString("status"));
                    listRoom.add(room);
                }
        } catch (SQLException e){
            System.out.println("Eror " + e.getMessage());
        }
        return listRoom;
    }

    @Override
    public void UpdateNameInStatus(Room room) {
        PreparedStatement statement = null;
                try{
                    statement = connect.prepareStatement("UPDATE rooms SET status=? WHERE name =?; ");
                    statement.setString(1, room.getName());
                    statement.setString(2, room.getStatus());
                    statement.execute();
                }catch (SQLException e){
                    System.out.println("Update Gagal("+e.getMessage()+")");
                }finally{
                    try{
                        statement.close();
                    }catch (SQLException exc){
                        System.out.println("Update Gagal");
                    }
        }
    }

    @Override
    public void UpdateEmptyRoom(Room room) {
        PreparedStatement statement = null;
                try{
                    statement = connect.prepareStatement("UPDATE rooms SET name=?, contact=? WHERE name =?; ");
                    statement.setString(1, room.getName());
                    statement.setString(2, room.getStatus());
                    statement.execute();
                }catch (SQLException e){
                    System.out.println("Update Gagal("+e.getMessage()+")");
                }finally{
                    try{
                        statement.close();
                    }catch (SQLException exc){
                        System.out.println("Update Gagal");
                    }
        }
    }
    
}
