package lab05_bai10;


import lab05_bai6.*;
import java.sql.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khang's PC
 */
public class MyConnection {
     public Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost/qltaikhoan?user=root&password=";
            Connection con = DriverManager.getConnection(URL);
            return con;
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex.toString(),"loi",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
