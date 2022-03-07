/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karim
 */
public class MyConnection {
    private String url ="jdbc:mysql://localhost:3306/ez";
    private String login = "root";
    private String password = "";
    Connection connection;
    public static MyConnection instance;
    private static Connection connection2;
    
    public MyConnection() {
        try {
            connection=DriverManager.getConnection(url, login, password);
            System.out.println("Connexion succeed");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        
        return connection;
    }
    
    public static MyConnection getInstance(){
        if(instance == null){
            instance = new MyConnection();
        }
            return instance;  
    }
    Connection cnx ;
    public Connection getCnx(){
   return cnx ;
   }   
  
    public  Connection etablirConnection() {
        
        try {
               connection2 = DriverManager.getConnection(url, login, password);
               System.out.println("connexion établie");

        }catch(Exception ex) {
            System.out.println("connexion échouée"+ex.getMessage());
            
        }
     
        return connection2;
    }
    
    
    
    public static Connection getInstance2() {
        
        if(connection2== null ) {
            
            new MyConnection().etablirConnection();
        }
        return connection2;
        
        
    }
}

