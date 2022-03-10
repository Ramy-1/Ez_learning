/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Recruteur;
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

    public void add(Object u) {
        Reponses r = (Reponses) u;
        try {
            String req = "INSERT INTO `Reponses`(`contenu`, `question`, `correct`, `note`) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, r.getContenu());
            ps.setInt(2, r.getQuestion());
            ps.setBoolean(3, r.isCorrect());
            ps.setFloat(4, r.getNote());
          
            ps.executeUpdate();
            System.out.println("Reponse Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public Object getById(int id) {
        Reponses r = new Reponses();
        try {
            String req = "SELECT * FROM `Reponses` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Reponses us = new Reponses(rs.getInt(1),rs.getString(2),  rs.getInt(3), rs.getBoolean(4), rs.getFloat(5) );
                r = us;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return r;
    }

    public List getAll() {
        List<Reponses> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `Reponses`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reponses r= new Reponses(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getBoolean(4), rs.getFloat(5) );
                list.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    public boolean update(Object u) {
        try {
            String req = "update reponses set contenu = ?, question = ?, correct = ?, note = ? where   id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            Reponses r = (Reponses) u;

            ps.setString(1, r.getContenu());
            ps.setInt(2, r.getQuestion());
            ps.setBoolean(3, r.isCorrect());
            ps.setFloat(4, r.getNote());

            ps.setInt(5, r.getId());
            ps.execute();
            System.out.println("Reponse modifier");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(Object u) {
        Reponses e = (Reponses) u;

        String req = "delete from Reponses where id = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
            System.out.println("Reponse supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public List getReponseByQuestion(int id) {
        
        List<Reponses> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `reponses` where question ="+ id;
            // Statement st = cnx.createStatement();
            Statement st = new MyConnection().getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Reponses r = new Reponses(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getBoolean(4),rs.getInt(5));
                list.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(list);
        return list;
    }
    
    
}
