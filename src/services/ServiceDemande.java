/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Demande;
import model.Offre;
import util.MyConnection;

/**
 *
 * @author Ihebowski
 */
public class ServiceDemande {
    Connection connection;

    public ServiceDemande() {
        connection = MyConnection.getInstance().getConnection();
    }
    
    public Demande getDemandeById(int id){
        Demande d = new Demande();
        try { 
            String req0 = "SELECT * FROM demande WHERE id = "+id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req0);
            while(rs.next()){
                d.setId(rs.getInt("id"));
                d.setDescription(rs.getString("description"));
                d.setPathCv(rs.getString("pathCv"));
                d.setIsAccepted(rs.getBoolean("isAccepted"));
                d.setIdOffre(rs.getInt("idOffre"));
                d.setIdEtudiant(rs.getInt("idEtudiant"));
            }
        } catch (SQLException ex) {
            System.err.printf(ex.getMessage());
        }
        return d;
    }
      
    public void ajouterDemande(Demande d){
        try {
            String req1 = "INSERT INTO demande (description,pathCv,idOffre,idEtudiant,isAccepted,dateSend) "
                    + "VALUES(?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(req1);
            pst.setString(1, d.getDescription());
            pst.setString(2, d.getPathCv());
            pst.setBoolean(3, false);
            pst.setInt(4, d.getIdOffre());
            pst.setInt(5, d.getIdEtudiant());   
            pst.setDate(6, new java.sql.Date(System.currentTimeMillis()));
            pst.executeUpdate();
            System.out.printf("Demande added.");
        } catch (SQLException ex) {
            System.err.printf(ex.getMessage());
        }
    }
    
    public void modifierDemande(Demande d){
        try {
            String req2 = "UPDATE demande SET description = ? , pathCv = ?"
                    + "WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(req2);
            pst.setString(1, d.getDescription());
            pst.setString(2, d.getPathCv());
            pst.setInt(3, d.getId());
            pst.executeUpdate();
            System.out.println("Demande Updated.");

        }catch(Exception ex) {
            System.err.printf(ex.getMessage());
        } 
    }
    
        public void AccepterDemande(Demande d){
            Offre o = new Offre();
        try {
            String req1 = "UPDATE demande SET isAccepted = ? WHERE id = "+d.getId();
            PreparedStatement pst1 = connection.prepareStatement(req1);
            pst1.setBoolean(1, true);
            pst1.executeUpdate();
            System.out.println("Demande Updated. ( Accepted = true )");
            
            
            String req2 = "SELECT * FROM offre WHERE id = "+d.getIdOffre();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req2);
            while(rs.next()){
                o.setNbAccepted(rs.getInt("nbAccepted")); 
            }
            
            System.out.println(String.valueOf(o.getNbAccepted()));
            
            
            String req3 = "UPDATE offre SET nbAccepted = ? WHERE id = "+d.getIdOffre();
            PreparedStatement pst3 = connection.prepareStatement(req3);
            pst3.setInt(1, (o.getNbAccepted()+1));
            pst3.executeUpdate();
            
            System.out.println("Offre Updated. ( IsAccepted = +1 )");
        }catch(Exception ex) {
            System.err.printf(ex.getMessage());
        }
    }
    
    public void deleteDemande(Demande d){
            try {
               String req3 ="DELETE FROM demande WHERE id = ?";
               PreparedStatement pst = connection.prepareStatement(req3);
               pst.setInt(1, d.getId());
               pst.executeUpdate();
               System.out.println("Demande Deleted.");

            }catch(Exception ex) {
                System.err.printf(ex.getMessage());
            }
    }
    
    public List<Demande> afficherDemande(){
        List<Demande> DemandeList = new ArrayList<>();
        try { 
            String req4 = "SELECT * FROM demande";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req4);
            while(rs.next()){
                Demande d = new Demande();
                d.setId(rs.getInt("id"));
                d.setDescription(rs.getString("description"));
                d.setPathCv(rs.getString("pathCv"));
                d.setDateSend(rs.getDate("dateSend"));
                d.setIsAccepted(rs.getBoolean("isAccepted"));
                d.setIdOffre(rs.getInt("idOffre"));
                d.setIdEtudiant(rs.getInt("idEtudiant"));

                DemandeList.add(d);
            }
        } catch (SQLException ex) {
            System.err.printf(ex.getMessage());
        }
        return DemandeList;
    }
    
    public List<Demande> afficherDemandeByOfferId(Offre o){
        List<Demande> DemandeList = new ArrayList<>();
        try { 
            String req4 = "SELECT * FROM demande WHERE idOffre = "+o.getId();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req4);
            while(rs.next()){
                Demande d = new Demande();
                d.setId(rs.getInt("id"));
                d.setDescription(rs.getString("description"));
                d.setPathCv(rs.getString("pathCv"));
                d.setDateSend(rs.getDate("dateSend"));
                d.setIsAccepted(rs.getBoolean("isAccepted"));
                d.setIdOffre(rs.getInt("idOffre"));
                d.setIdEtudiant(rs.getInt("idEtudiant"));
                DemandeList.add(d);
            }
        } catch (SQLException ex) {
            System.err.printf(ex.getMessage());
        }
        return DemandeList;
    }
}
