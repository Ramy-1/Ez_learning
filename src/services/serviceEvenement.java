/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IEvenement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Evenement;
import model.Universite;
import rania.MyConnection;

/**
 *
 * @author Nabil
 */
public abstract class serviceEvenement implements IEvenement {

    public ObservableList<Evenement> obList = FXCollections.observableArrayList();

    public ObservableList<Evenement> topOblist = FXCollections.observableArrayList();

    public Connection myConnection = MyConnection.getInstance();

    @Override
    public void ajouterEvenement(Evenement Ev) {
        String request = "INSERT INTO `evenement`(`idEvent`, `idOrg`, `description`, `date`, `heure`, `lien`, `imgEv`,`nbrParticipant`) VALUES ('" + Ev.getIdEvent() + "','" + Ev.getIdOrg() + "','" + Ev.getDescription() + "','" + Ev.getDate() + "','" + Ev.getHeure() + "','" + Ev.getLien() + "','" + Ev.getImgEv() + "','" + Ev.getNbrParticipant() + "')";
        try {
            if (!Existe(Ev) == true) {
                Statement st = myConnection.createStatement();
                st.executeUpdate(request);
                System.out.println("Event ajoutee avec succes");
            } else {
                System.out.println("Evenement deja existe");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Evenement> afficherEvenement() {
        String request1 = "SELECT * FROM `evenement`";
        try {
            Statement st = myConnection.createStatement();
            ResultSet rs = st.executeQuery(request1);
            while (rs.next()) {
                Evenement Ev = new Evenement();
                Ev.setIdEvent(rs.getInt(1));
                Ev.setIdOrg(rs.getString("idOrg"));
                Ev.setDescription(rs.getString("description"));
                Ev.setDate(rs.getDate("date"));
                Ev.setHeure(rs.getString("heure"));
                Ev.setLien(rs.getString("lien"));
                Ev.setImgEv(rs.getString("imgEv"));
                Ev.setNbrParticipant(rs.getInt("nbrParticipant"));

                obList.add(Ev);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return obList;
    }

    public Evenement detailEvenement(int id) {
        String request1 = "SELECT * FROM evenement WHERE idEvent=?";
        Evenement Ev = null;
        try {
            Statement st = myConnection.createStatement();
            ResultSet rs = st.executeQuery(request1);
            while (rs.first()) {
                Ev = new Evenement();
                Ev.setIdEvent(id);
                Ev.setIdOrg(rs.getString("idOrg"));
                Ev.setDescription(rs.getString("description"));
                Ev.setDate(rs.getDate("date"));
                Ev.setHeure(rs.getString("heure"));
                Ev.setLien(rs.getString("lien"));
                Ev.setImgEv(rs.getString("imgEv"));
                Ev.setNbrParticipant(rs.getInt("nbrParticipant"));

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return Ev;
    }

    @Override
    public void supprimerEvenement(int id) {
        String request2 = "DELETE FROM evenement WHERE idEvent=" + id;
        try {
            Statement st = myConnection.createStatement();
            st.executeUpdate(request2);

            System.out.println("Event supprimee avec succes");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifierEvenement(Evenement Ev, int idE) {
        try {

            String request3 = "UPDATE `evenement` SET `idOrg`='" + Ev.getIdOrg() + "',`description`='" + Ev.getDescription() + "',`date`='"
                    + Ev.getDate() + "',`heure`='" + Ev.getHeure() + "',`lien`='" + Ev.getLien() + "',`nbrParticipant`='" + Ev.getNbrParticipant() + "', `imgEv`='" + Ev.getImgEv() + "' WHERE `idEvent` = " + idE;

            Statement st = myConnection.createStatement();
            st.executeUpdate(request3);
            System.out.println("evenement modifie avec succes");

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Evenement> rechercheEvenementsOrganisteur(String idOrganisteur) {
        List<Evenement> evenements = new ArrayList<Evenement>();

        String req = "SELECT * FROM evenement WHERE idOrg = ?";
        try {
            PreparedStatement st = myConnection.prepareStatement(req);
            st.setString(1, idOrganisteur);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Evenement Ev = new Evenement();
                Ev.setIdOrg(rs.getString("idOrg"));
                Ev.setDescription(rs.getString("description"));
                Ev.setDate(rs.getDate("date"));
                Ev.setHeure(rs.getString("heure"));
                Ev.setLien(rs.getString("lien"));
                Ev.setImgEv(rs.getString("imgEv"));
                Ev.setNbrParticipant(rs.getInt("nbrParticipant"));
                evenements.add(Ev);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return evenements;

    }

    public boolean Existe(Evenement e) {
        String sql = "SELECT * FROM evenement WHERE idOrg= ? AND description =? AND date = ? AND heure =?";//getting username
        try {
            Statement st = myConnection.createStatement();

            //setting value for ?
            PreparedStatement ps = myConnection.prepareStatement(sql);

            ps.setString(1, e.getIdOrg());
            ps.setString(2, e.getDescription());
            ps.setDate(3, e.getDate());
            ps.setString(4, e.getHeure());
            ResultSet rs = ps.executeQuery();
            //checking if record with zid exist if yes do below  
            if (rs.next()) {
                //put alert here
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(serviceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public int nombreTotalEvenement() {
        int i = 0;

        try {
            try {
                Statement st = myConnection.createStatement();
                String query = "SELECT COUNT(*) FROM evenement";
                ResultSet rs = st.executeQuery(query);
                //Extact result from ResultSet rs
                while (rs.next()) {
                    System.out.println("Nombre totale des evenements(*)=" + rs.getInt("COUNT(*)"));
                    i++;
                }
                // close ResultSet rs
            } catch (SQLException s) {
                s.printStackTrace();
            }
            // close Connection and Statement
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public Evenement getEventById(int id) {
        String req = "SELECT * FROM evenement WHERE idEvent=" + id;
        Evenement Ev = null;

        try {
            PreparedStatement pre = myConnection.prepareStatement(req);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                Ev = new Evenement();
                Ev.setIdEvent(rs.getInt("idEvent"));
                Ev.setIdOrg(rs.getString("idOrg"));
                Ev.setDescription(rs.getString("description"));
                Ev.setDate(rs.getDate("date"));
                Ev.setHeure(rs.getString("heure"));
                Ev.setLien(rs.getString("lien"));
                Ev.setImgEv(rs.getString("imgEv"));
                Ev.setNbrParticipant(rs.getInt("nbrParticipant"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Ev;

    }

 
    public ObservableList<Evenement> topFiveEvents() {

        List<Evenement> list = new ArrayList<>();
        String s = "";
        List<Integer> listId = new ArrayList<>();
        List<Integer> listViews = new ArrayList<>();

        for (Evenement e : afficherEvenement()) {
            listId.add(e.getIdEvent());
            listViews.add(e.getNbrParticipant());

        }

        List<Integer> sortedList = new ArrayList<>(listViews);

        Collections.sort(sortedList);

        for (int i = 0; i < 2; i++) {
            int max = sortedList.get(sortedList.size() - 1);
            int ind = listId.get(listViews.indexOf(max));

            sortedList.remove(sortedList.size() - 1);
            listViews.set(listViews.indexOf(max), -1);

            topOblist.add(getEventById(ind));

        }

        return topOblist;

    }

}
