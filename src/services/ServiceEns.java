package services;

import interfaces.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cour;
import model.Enseignant;
import model.Role;
import util.DataSource;

public class ServiceEns {
    Connection cnx = DataSource.getInstance().getCnx();

    public List<Cour> addCours(Enseignant e) {
        List<Cour> cours = new ArrayList<>();
        try {
            String req = "SELECT * FROM `cour` where id_enseignant = " + e.getId();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Cour c = new Cour(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
                cours.add(c);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return cours;
    }


    public Enseignant getByMail(String mail) {
        Enseignant u = new Enseignant();
        try {
            // String req = "SELECT * FROM `user` WHERE `email` = " + mail;

            String req = "SELECT * FROM `Enseignant` WHERE email = '" + mail + "'";
            Statement st = cnx.createStatement();

            // String req = "SELECT * FROM `user` WHERE email = ? ";
            // PreparedStatement ps = cnx.prepareStatement(req);
            // ps.setString(1, mail);
            // System.out.println(req);
            // System.out.println("*******");
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Enseignant us = new Enseignant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                u = us;
                // System.out.println(u);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return u;
    }
    public void add(Enseignant u) {
        Enseignant e = u;
        e.setRole(Role.enseignant);
        try {
            String req = "INSERT INTO `Enseignant`(`nom`, `prenom`, `tel`, `email`, `pwd`, `carte_banq` ,`role` ,`universite`,`section`) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
//            ps.setString(1, e.getNom());
//            ps.setString(2, e.getPrenom());
//            ps.setInt(3, e.getPhone());
//            ps.setString(4, e.getEmail());
//            ps.setString(5, e.getPwd());
//            ps.setString(6, e.getCarte_banq());
            ps.setString(7, e.getRole().toString());
            ps.setString(8, e.getUniversite());
            ps.setString(9, e.getSection());

            ps.executeUpdate();
            System.out.println("Enseignant Ajout??e");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        ServiceUser sU = new ServiceUser();
        sU.add(e);
    }


    public Enseignant getById(int id) {
        Enseignant u = new Enseignant();
        try {
            String req = "SELECT * FROM `Enseignant` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Enseignant us = new Enseignant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                u = us;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return u;
    }


    public List getAll() {
        List<Enseignant> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `Enseignant`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Enseignant e = new Enseignant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(9), rs.getString(10));
                list.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    public boolean update(Object u) {
        try {
            String req = "update `etudiant` set nom = ?, prenom = ?, phone = ?, email = ?, pwd = ?, carte_banq = ?, universite = ? , section = ? where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            Enseignant e = (Enseignant) u;

//            ps.setString(1, e.getNom());
//            ps.setString(2, e.getPrenom());
//            ps.setInt(3, e.getPhone());
//            ps.setString(4, e.getEmail());
//            ps.setString(5, e.getPwd());
//            ps.setString(6, e.getCarte_banq());
            ps.setString(7, e.getRole().toString());
            ps.setString(8, e.getUniversite());
            ps.setString(9, e.getSection());
            ps.setInt(10, e.getId());

            ServiceUser sU = new ServiceUser();

            sU.update(e);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean delete(Object u) {
        Enseignant e = (Enseignant) u;

        String req = "delete from Enseignant where id = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
            System.out.println("Enseignant supprimer");
            ServiceUser sU = new ServiceUser();
            sU.delete(e);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
  public Enseignant getByMail(String mail) {
        Enseignant u = new Enseignant();
        try {
            // String req = "SELECT * FROM `user` WHERE `email` = " + mail;

            String req = "SELECT * FROM `Enseignant` WHERE email = '" + mail + "'";
            Statement st = cnx.createStatement();

            // String req = "SELECT * FROM `user` WHERE email = ? ";
            // PreparedStatement ps = cnx.prepareStatement(req);
            // ps.setString(1, mail);
            // System.out.println(req);
            // System.out.println("*******");
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Enseignant us = new Enseignant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                u = us;
                // System.out.println(u);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return u;
    }
}
