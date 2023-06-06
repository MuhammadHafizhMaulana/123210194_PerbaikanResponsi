/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connection.koneksi;
import interfce.interfaceRenter;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import model.Renter;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author acer
 */
public class DAORenter implements interfaceRenter{
    Connection connect;
    
    public DAORenter(){
        connect = koneksi.getConnection();
    }

    @Override
    public List<Renter> getAll() {
        List<Renter> listRen = null;
        try{
            listRen = new ArrayList<>();
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM renter");
                while (rs.next()){
                    Renter renter = new Renter();
                    renter.setName(rs.getString("name"));
                    renter.setId(rs.getString("id"));
                    renter.setContact(rs.getString("contact"));
                    renter.setDuration(rs.getInt("duration"));
                    renter.setBill(rs.getInt("bill"));
                    renter.setStatus(rs.getString("status"));
                    renter.setRoom(rs.getString("Room"));
                    listRen.add(renter);
                }
        } catch (SQLException e){
            System.out.println("Eror " + e.getMessage());
        }
        return listRen;
    }

    @Override
    public void inputRenter(Renter renter) {
        PreparedStatement statement = null;
        try{
            statement = connect.prepareStatement("INSERT INTO renter(`name`, `id`, `contact`, `duration`, `bill`, `room`) VALUES (?,?,?,?,?,?)");
            statement.setString(1, renter.getName());
            statement.setString(2, renter.getId());
            statement.setString(3, renter.getContact());
            statement.setInt(4, renter.getDuration());
            statement.setInt(5, renter.getBill());
            statement.setString(6, renter.getStatus());
            statement.setString(7, renter.getRoom());
            statement.execute();
        }catch (SQLException e){
            System.out.println("Input Gagal("+e.getMessage()+")");
        }finally{
            try{
                statement.close();
            }catch (SQLException exc){
                System.out.println("Input Gagal");
            }
        }
    }

    @Override
    public void updateRenter(Renter renter) {
        PreparedStatement statement = null;
                try{
                    statement = connect.prepareStatement("UPDATE renter SET name=?, contact=? WHERE id =?; ");
                    statement.setString(1, renter.getName());
                    statement.setString(2, renter.getId());
                    statement.setString(3, renter.getContact());
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
    public void hapusRenter(String id) {
        PreparedStatement statement = null;
                try{
                    statement = connect.prepareStatement("DELETE FROM renter WHERE id =?; ");
                    statement.setString(1, "id");
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
    public void SetPaid(String id) {
        PreparedStatement statement = null;
                try{
                    statement = connect.prepareStatement("UPDATE renter SET status='Paid' WHERE id =?; ");
                    statement.setString(1, "id");
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
