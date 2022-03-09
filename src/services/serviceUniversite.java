/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IUniversite;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Cours;
import model.Evenement;
import model.Recruteur;
import model.Universite;
import util.MyConnection;

/**
 *
 * @author Nabil
 */
public class serviceUniversite implements IUniversite {


    public Connection myConnection = MyConnection.getInstance2();
       public     ObservableList<Universite>obList = FXCollections.observableArrayList();

    @Override
    public void ajouterUniversite(Universite U) {
      String request = /*"INSERT INTO `universite`( `nom`, `email`, `adresse`, `imguni`, `mdpuni`) VALUES ('"+U.getNom()+"','"+U.getEmail()+"','"+U.getAdresse()+"','"+U.getImguni()+"','"+U.getMdpuni()+"')"*/"";
        try {
            Statement st = myConnection.createStatement();
             st.executeUpdate(request);
              System.out.println("Societe ajoutee avec succes");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }    
    }

    @Override
    public ObservableList<Universite> afficherUniversite() {
    String request1 = "SELECT * FROM `universite`";
        try {
            Statement st = myConnection.createStatement();
            ResultSet rs = st.executeQuery(request1);
            while (rs.next()) {
                Universite U = new Universite();
                U.setIdUni(rs.getString("idUni"));
                U.setNom(rs.getString("nom"));
                U.setEmail(rs.getString("email"));
                U.setAdresse(rs.getString("adresse"));
                U.setImguni(rs.getString("imgUni"));
                U.setMdpuni(rs.getString("mdpUni"));
                obList.add(U);
            }
        } catch (SQLException ex) {
     System.err.println(ex.getMessage());
        }
    
        return obList;    }

    @Override
    public void supprimerUniversite(Universite U) {
      String request2=/*"DELETE FROM `universite` WHERE `idUni`='"+U.getIdUni()+"'"*/"";
        try{
            Statement st = myConnection.createStatement();
              st.executeUpdate(request2);
              
              System.out.println("Universite supprimee avec succes");
           
        }
        catch(SQLException ex){  
            System.err.println(ex.getMessage());
        }       }

    @Override
    public void modifierUniversite(Universite U, String idUni) {
 try{      
      String request3=/*"UPDATE `universite` SET `nom`='"+U.getNom()+"',`email`='"+U.getEmail()+"',`adresse`='"+U.getAdresse()+"',`imguni`='"+U.getImguni()+"',`mdpuni`='"+U.getMdpuni()+"' WHERE `idUni` = "+idUni*/"" ; 
         
            Statement st = myConnection.createStatement();
       st.executeUpdate(request3);
        System.out.println("suniversite modifie avec succes");
   
     }
     catch(SQLException ex){
     System.err.println(ex.getMessage());
     } 
    }

    @Override
    public List<Evenement> afficherEvenementsUniversite(int idu) {
 
        
        String sql ="SELECT *" +
"  FROM universite u" +
"  JOIN evenement e ON e.idUni ="+idu ;        
  List<Evenement>list = new ArrayList<Evenement>();
    try {
        PreparedStatement st = myConnection.prepareStatement(sql);
      ResultSet rs = st.executeQuery();
            
      while (rs.next()) {
          String idorg = rs.getString("idOrg");
        String desc = rs.getString("description");
        Date date = rs.getDate("date");
        String lien = rs.getString("lien");
        int nbrParticipant = rs.getInt("nbrParticipant");
        int iduni = rs.getInt("idUni");
        
        if(iduni ==idu) {
                    Evenement e = new Evenement(idorg, desc, date, lien,nbrParticipant);
        list.add(e);

        }
        
      }
    }catch(Exception ex) {
        ex.printStackTrace();
    }
    return list;
    
    }
    
    public List getAll() {
        List<Universite> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `universite`";
            Statement st = myConnection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Universite e = new Universite(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5),
                        rs.getString(6), rs.getString(7));
                list.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    

}
