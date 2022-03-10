/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.Ireponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import model.Reclamation;
import model.reponse;
import util.MyConnection;
import services.serviceReclamation;
import util.DataSource;


/**
 *
 * @author Nabil
 */
public class servicereponse implements Ireponse {
 Connection cnx = DataSource.getInstance().getCnx();
    @Override
    public void ajouterReponse(reponse rep) {
         String request = "INSERT INTO `reponserec`(`idreclamation`, `description`,`daterep`) VALUES ('"+rep.getIdreclamation()+"','"+rep.getDescription()+"','"+rep.getDaterep()+"')";
        try {
            Statement st = cnx.createStatement();
             st.executeUpdate(request);
              System.out.println("REPONSE ajoutee avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        }

    @Override
    public List<reponse> afficherReponse() {
 List<reponse> ListRep = new ArrayList<>();
    String request1 = "SELECT * FROM `reponserec`";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(request1);
             while (rs.next()){
               reponse rep = new reponse();
                rep.setIdreclamation(rs.getInt("idreponse"));
                rep.setIdreclamation(rs.getInt("idreclamation"));
                rep.setDescription(rs.getString("description"));
                rep.setDaterep(rs.getDate("daterep").toLocalDate());
                ListRep.add(rep);
             }
        } catch (SQLException ex) {
     System.err.println(ex.getMessage());
        }
    
        return ListRep;
    }

    public reponse GetByIdReponse(int id) {
 reponse re = new reponse();
    String request1 = "SELECT * FROM `reponserec` WHERE `idreponse` = "+id ;
        try {
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(request1);
             while (rs.next()){
               reponse rep = new reponse();
                rep.setIdreclamation(rs.getInt("idreponse"));
                rep.setIdreclamation(rs.getInt("idreclamation"));
                rep.setDescription(rs.getString("description"));
                rep.setDaterep(rs.getDate("daterep").toLocalDate());
                re=rep;
             }
        } catch (SQLException ex) {
     System.err.println(ex.getMessage());
        }
    
        return re;
    }
    @Override
    public void supprimerReponse(reponse rep) {
     String request2="DELETE FROM `reponserec` WHERE `idreclamation`='"+rep.getIdreclamation()+"'";
        try{
              Statement st=new MyConnection().getCnx().createStatement();
              st.executeUpdate(request2);
              
              System.out.println("REPONSE supprimé avec succès");
           
        }
        catch(SQLException ex){  
            System.err.println(ex.getMessage());
        }    }

    @Override
    public void modifierReponse(reponse rep, int id) {
 try{      
      String request3="UPDATE `reponserec` SET `description`='"+rep.getDescription()+"',`daterep`='"+rep.getDaterep()+"' WHERE `idreclamation` = "+id ; 
         
 Statement st=new MyConnection().getCnx().createStatement();
       st.executeUpdate(request3);
        System.out.println("REPONSE modifie avec succes");
   
     }
     catch(SQLException ex){
     System.err.println(ex.getMessage());
     }     }
    
    public int calculreponserec(){
    int c = afficherReponse().size();
    return c ;
    }
    
}
