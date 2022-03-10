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
import model.Offre;
import util.MyConnection;

/**
 *
 * @author Ihebowski
 */
public class ServiceOffre {
    Connection connection;

    public ServiceOffre() {
        connection = MyConnection.getInstance().getConnection();
    }
    
    public Offre getOffreById(int id){
        Offre o = new Offre();
        try { 
            String req0 = "SELECT * FROM offre WHERE id = "+id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req0);
            while(rs.next()){
                o.setId(rs.getInt("id"));
                o.setTitre(rs.getString("titre"));
                o.setType(rs.getString("type"));
                o.setDateFin(rs.getDate("dateFin"));
                o.setNbPlace(rs.getInt("nbPlace"));
                o.setNbDemande(rs.getInt("nbDemande"));
                o.setNbAccepted(rs.getInt("nbAccepted"));
                o.setIdRecruteur(rs.getInt("IdRecruteur"));
                rs.close();
            }
        } catch (SQLException ex) {
            System.err.printf(ex.getMessage());
        }
        return o;
    }
    
    public void ajouterOffre(Offre o){
        try {
            String req1 = "INSERT INTO offre (titre,type,dateFin,nbPlace,nbDemande,nbAccepted,idRecruteur) "
                    + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(req1);
            pst.setString(1, o.getTitre());
            pst.setString(2, o.getType());
            pst.setDate(3, o.getDateFin());
            pst.setInt(4, o.getNbPlace());
            pst.setInt(5, o.getNbPlace());
            pst.setInt(6, o.getNbAccepted());
            pst.setInt(7, o.getIdRecruteur()); 
            pst.executeUpdate();
            System.out.printf("Offre added.");
            pst.close();
        } catch (SQLException ex) {
            System.err.printf(ex.getMessage());
        }
    }
    
    public void modifierOffre(Offre o){
        try {
            String req2 = "UPDATE offre SET titre = ? , type = ? , dateFin = ? , nbPlace = ? WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(req2);
            pst.setString(1, o.getTitre());
            pst.setString(2, o.getType());
            pst.setDate(3, o.getDateFin());
            pst.setInt(4, o.getNbPlace());
            pst.setInt(5, o.getId());
            pst.executeUpdate();
            System.out.println("Offre Updated.");
            pst.close();

        }catch(Exception ex) {
            System.err.printf(ex.getMessage());
        } 
    }
    
    public void deleteOffre(Offre o){
            try {
               String req3 ="DELETE FROM offre WHERE id=?";
               PreparedStatement pst = connection.prepareStatement(req3);
               pst.setInt(1, o.getId());
               pst.executeUpdate();
               System.out.println("Offre Deleted.");
               pst.close();
            }catch(Exception ex) {
                System.err.printf(ex.getMessage());
            }
    }
    
    public List<Offre> afficherOffre(){
        List<Offre> OffreList = new ArrayList<>();
        try { 
            String req4 = "SELECT * FROM offre";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req4);
            while(rs.next()){
                Offre o = new Offre();
                o.setId(rs.getInt("id"));
                o.setTitre(rs.getString("titre"));
                o.setType(rs.getString("type"));
                o.setDateFin(rs.getDate("dateFin"));
                o.setNbPlace(rs.getInt("nbPlace"));
                o.setNbDemande(rs.getInt("nbDemande"));
                o.setNbAccepted(rs.getInt("nbAccepted"));
                o.setIdRecruteur(rs.getInt("idRecruteur"));
                rs.close();
                OffreList.add(o);
            }
        } catch (SQLException ex) {
            System.err.printf(ex.getMessage());
        }
        return OffreList;
    }
    
    public List<Offre> afficherOffreByRecruterId(int id){
        List<Offre> OffreList = new ArrayList<>();
        try { 
            String req4 = "SELECT * FROM offre WHERE idRecruteur = "+id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req4);
            while(rs.next()){
                Offre o = new Offre();
                o.setId(rs.getInt("id"));
                o.setTitre(rs.getString("titre"));
                o.setType(rs.getString("type"));
                o.setDateFin(rs.getDate("dateFin"));
                o.setNbPlace(rs.getInt("nbPlace"));
                o.setNbDemande(rs.getInt("nbDemande"));
                o.setNbAccepted(rs.getInt("nbAccepted"));
                o.setIdRecruteur(rs.getInt("idRecruteur"));
                OffreList.add(o);
                rs.close();
            }
        } catch (SQLException ex) {
            System.err.printf(ex.getMessage());
        }
        return OffreList;
    }
    
    public String OfferDisponibility(Offre o){
        Offre x=this.getOffreById(o.getId());
        int result = x.getNbPlace()-x.getNbAccepted();
        if (result > 5){
            return "This offre has "+result+" left.";
        } else if (result >0 && result <5){
            return "This offre has "+result+" left. Hurry up!";
        } else if (result == 0){
            return "No places left in this offre.";
        }
        return "Offre has error";
    }
    
    public String OffreAcceptPercentage(Offre o){
        Offre x=this.getOffreById(o.getId());
        float result = (x.getNbAccepted()/x.getNbPlace())*100;
        return result+"%";
    } 
    
}
