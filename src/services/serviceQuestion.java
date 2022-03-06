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
import model.questions;
import util.MyConnection;

/**
 *
 * @author karim
 */
public class serviceQuestion {
    public void ajouterQuestion(questions q) {
     String request = "INSERT INTO `questions`(`contenu`, `testid`) VALUES ('"+q.getContenu()+"','"+q.getTestid()+"')";
        try {
            Statement st = new MyConnection().getCnx().createStatement();
             st.executeUpdate(request);
              System.out.println("Question ajoutee avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
/**/
    public List<questions> afficherQuestion() {
    List<questions> ListS = new ArrayList<>();
    String request1 = "SELECT * FROM `questions`";
        try {
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(request1);
             while (rs.next()){
               questions q = new questions();
               
                q.setContenu(rs.getString("contenu"));
                q.setTestid((Test) rs.getObject("testid"));
              
               ListS.add(q);
             }
        } catch (SQLException ex) {
     System.err.println(ex.getMessage());
        }
    
        return ListS;
    }
   

    public void supprimerQuestion(questions q) {
String request2="DELETE FROM `questions` WHERE `id`='"+q.getId()+"'";
        try{
              Statement st=new MyConnection().getCnx().createStatement();
              st.executeUpdate(request2);
              
              System.out.println("Question supprimé avec succès");
           
        }
        catch(SQLException ex){  
            System.err.println(ex.getMessage());
        }     }

    
    public void modifierQuestion(questions q,int id) {
 try{      
      String request3="UPDATE `questions` SET `contenu`='"+q.getContenu()+"',`testid`='"+q.getTestid()+"' WHERE `id` = "+id ; 
         
 Statement st=new MyConnection().getCnx().createStatement();
       st.executeUpdate(request3);
        System.out.println("question modifie avec succes");
   
     }
     catch(SQLException ex){
     System.err.println(ex.getMessage());
     }    
    
    }
}
