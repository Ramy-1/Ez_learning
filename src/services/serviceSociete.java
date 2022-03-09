/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.ISociete;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.societe;
import util.MyConnection;

/**
 *
 * @author Nabil
 */
public class serviceSociete implements ISociete {

    @Override
    public void ajouterSociete(societe S) {
     String request = "INSERT INTO `societe`(`idsoc`, `nom`, `email`, `adresse`, `imgsoc`, `mdpsoc`) VALUES ('"+S.getIdsoc()+"','"+S.getNom()+"','"+S.getEmail()+"','"+S.getAdresse()+"','"+S.getImgsoc()+"','"+S.getMdpsoc()+"')";
        try {
            Statement st = new MyConnection().getCnx().createStatement();
             st.executeUpdate(request);
              System.out.println("Societe ajoutee avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
/**/
    @Override
    public List<societe> afficherSociete() {
    List<societe> ListS = new ArrayList<>();
    String request1 = "SELECT * FROM `societe`";
        try {
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(request1);
             while (rs.next()){
               societe S = new societe();
                S.setIdsoc(rs.getString(1));
                S.setNom(rs.getString("nom"));
                S.setEmail(rs.getString("email"));
                S.setAdresse(rs.getString("adresse"));
                S.setImgsoc(rs.getString("imgsoc"));
                S.setMdpsoc(rs.getString("mdpsoc"));
               ListS.add(S);
             }
        } catch (SQLException ex) {
     System.err.println(ex.getMessage());
        }
    
        return ListS;
    }
   

    @Override
    public void supprimerSociete(societe S) {
String request2="DELETE FROM `societe` WHERE `idsoc`='"+S.getIdsoc()+"'";
        try{
              Statement st=new MyConnection().getCnx().createStatement();
              st.executeUpdate(request2);
              
              System.out.println("Societe supprimé avec succès");
           
        }
        catch(SQLException ex){  
            System.err.println(ex.getMessage());
        }     }

    
    @Override
    public void modifierSociete(societe S,String id) {
 try{      
      String request3="UPDATE `societe` SET `nom`='"+S.getNom()+"',`email`='"+S.getEmail()+"',`adresse`='"+S.getAdresse()+"',`imgsoc`='"+S.getImgsoc()+"',`mdpsoc`='"+S.getMdpsoc()+"' WHERE `idsoc` = "+id ; 
         
 Statement st=new MyConnection().getCnx().createStatement();
       st.executeUpdate(request3);
        System.out.println("societe modifie avec succes");
   
     }
     catch(SQLException ex){
     System.err.println(ex.getMessage());
     }    
    
    }
    
}

 