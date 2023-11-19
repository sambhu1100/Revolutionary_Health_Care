/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SCHpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class MyConnection {
   Connection con;
    Statement stmt;
    ResultSet rs;
    public java.sql.Connection getCon(){
        try{
            System.out.println("MyConnection.java-----");
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/smart_health_care", "root", "Barik@123");
        }catch(ClassNotFoundException | SQLException ex){
            
        }
        return con;
    }
    
}
