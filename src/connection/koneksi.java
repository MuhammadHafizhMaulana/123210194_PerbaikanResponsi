/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class koneksi {
    static Connection connect;
    
    public static Connection getConnection(){
        if( connect == null){
            MysqlDataSource db = new MysqlDataSource();
            db.setDatabaseName("almaul_db");
            db.setUser("root");
            db.setPassword("");
            db.setPort(3308);
            
            try{
                connect = db.getConnection();
                System.out.println("KONEK NI");
            }catch (SQLException e){
                System.out.println("Eror" + e.getMessage());
            }
        }
    
        return connect;
    
    }
}
