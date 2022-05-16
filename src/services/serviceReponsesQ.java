/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Reponses;
import model.questions;
import util.DataSource;
import util.MyConnection;

/**
 *
 * @author karim
 */
public class serviceReponsesQ {
    Connection cnx = DataSource.getInstance().getCnx();
    public void ajouterReponses(Reponses r) {
     String request = "INSERT INTO `reponses`(`contenu`, `question`, `correct`, `note`) VALUES ('"+r.getContenu()+"','"+r.getQuestion()+"','"+r.isCorrect()+"','"+r.getNote()+"')";
        try {
            Statement st = cnx.createStatement();
             st.executeUpdate(request);
              System.out.println("Reponse ajoutee avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
/**/
    public List<Reponses> afficherReponses() {
    List<Reponses> ListS = new ArrayList<>();
    String request1 = "SELECT * FROM `reponses`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request1);
             while (rs.next()){
               Reponses r = new Reponses();
               
                r.setContenu(rs.getString("contenu"));
                r.setQuestion((questions) rs.getObject("question"));
                r.setCorrect(rs.getBoolean("correct"));
                r.setNote(rs.getFloat("note"));
              
               ListS.add(r);
             }
        } catch (SQLException ex) {
     System.err.println(ex.getMessage());
        }
    
        return ListS;
    }
   

    public void supprimerReponses(Reponses r) {
String request2="DELETE FROM `reponses` WHERE `id`='"+r.getId()+"'";
        try{
              Statement st=cnx.createStatement();
              st.executeUpdate(request2);
              
              System.out.println("Reponses supprimé avec succès");
           
        }
        catch(SQLException ex){  
            System.err.println(ex.getMessage());
        }     }

    
    public void modifierReponses(Reponses r,int id) {
 try{      
      String request3="UPDATE `questions` SET `contenu`='"+r.getContenu()+"',`question`='"+r.isCorrect()+"',`note`='"+r.getNote()+"',`correct`='"+r.getQuestion()+"' WHERE `id` = "+id ; 
         
 Statement st=cnx.createStatement();
       st.executeUpdate(request3);
        System.out.println("reponse modifie avec succes");
   
     }
     catch(SQLException ex){
     System.err.println(ex.getMessage());
     }    
    
    }
}
