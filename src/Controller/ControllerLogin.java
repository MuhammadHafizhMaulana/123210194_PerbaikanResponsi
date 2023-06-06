/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import view.ViewLogin;
import connection.koneksi;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
import view.ViewAdmin;
import view.ViewRenter;
import model.akun;
import view.ViewRoomList;


/**
 *
 * @author acer
 */
public class ControllerLogin{
    ViewLogin viewlogin;
    Connection connection;
    
        public ControllerLogin(ViewLogin viewlogin){
            this.viewlogin = viewlogin;
            connection = koneksi.getConnection();        
    }
        public void login(){
            String username = viewlogin.getjUsername().getText();
            String password = viewlogin.getjPassword().getText();

            
            String cekUser = null;
            String cekPassword = null;
            
            try{
                Statement st = connection.createStatement();
                String query = "SELECT * FROM accounts WHERE username = '" + username + " 'AND password = '" + password + "'";
                ResultSet result = st.executeQuery(query);
                while(result.next()){
                    cekUser = result.getString("username");
                    cekPassword = result.getString("password");
                }
                result.close();
                st.close();
                
            }catch (Exception e){
                System.out.println("Login Gagal");
            }
            
            if (cekUser == null && cekPassword == null){
                JOptionPane.showMessageDialog(null, "username atau password salah");
                viewlogin.setjUsername(null);
                viewlogin.setjPassword(null);
            }else{
                JOptionPane.showMessageDialog(null, "Login berhasil");
                new ViewRoomList().setVisible(true);
                viewlogin.dispose();
                
          }
            
            
        }

    
}
