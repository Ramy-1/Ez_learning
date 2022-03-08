/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rania;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class MyConnection  {

    
    private String url ="jdbc:mysql://localhost:3306/ez";
    private String login = "root";
    private String password = "";
    private static Connection connection;
    private static MyConnection  myConnection;
    
    
    public MyConnection() {
        
    }
    public  Connection etablirConnection() {
        
        try {
               connection = DriverManager.getConnection(url, login, password);
               System.out.println("connexion établie");

        }catch(Exception ex) {
            System.out.println("connexion échouée"+ex.getMessage());
            
        }
     
        return connection;
    }
    
    public Connection getConnection() {
        return connection;
        
        
    }
    
    public static Connection getInstance() {
        
        if(connection== null ) {
            
            new MyConnection().etablirConnection();
        }
        return connection;
        
        
    }
}
