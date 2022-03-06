/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Test;
import util.MyConnection;

/**
 *
 * @author karim
 */
public class serviceTest {
    public void ajouterTest(Test t) {
     String request = "INSERT INTO `test`(`titre`, `description`) VALUES ('"+t.getTitre()+"','"+t.getDescription()+"')";
        try {
            Statement st = new MyConnection().getCnx().createStatement();
             st.executeUpdate(request);
              System.out.println("Test ajoutee avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
/**/
    public List<Test> afficherTest() {
    List<Test> listt = null;
                 try{
                    
                     String a,b;
                     listt = new ArrayList<Test>();
                     String sql = "select * from test";
                      Statement st= new MyConnection().getConnection().createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    
                     while (rs.next())
                     {
                         Test pr = new Test();
                         int id = pr.getId();
                         pr.setTitre(rs.getString("titre"));
                         pr.setDescription(rs.getString("description"));
                       
                         System.out.println(pr);
                         listt.add(pr);
                     }

             }
                 catch(SQLException e ) {

                     // System.out.print(e.getMessage());
                     System.out.println("Error = " + e.getMessage());
                    }
        return listt;
    }
   

    public void supprimerTest(Test t) {
String request2="DELETE FROM `test` WHERE `id`='"+t.getId()+"'";
        try{
              Statement st=new MyConnection().getCnx().createStatement();
              st.executeUpdate(request2);
              
              System.out.println("Test supprimé avec succès");
           
        }
        catch(SQLException ex){  
            System.err.println(ex.getMessage());
        }     }

    
    public void modifierTest(Test t,int id) {
 try{      
      String request3="UPDATE `test` SET `nom`='"+t.getTitre()+"',`email`='"+t.getDescription()+"' WHERE `id` = "+id ; 
         
        Statement st=new MyConnection().getCnx().createStatement();
       st.executeUpdate(request3);
        System.out.println("test modifie avec succes");
   
     }
     catch(SQLException ex){
     System.err.println(ex.getMessage());
     }    
    
    }
}
