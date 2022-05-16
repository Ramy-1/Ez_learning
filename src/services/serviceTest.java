/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Recruteur;
import model.Test;
import util.MyConnection;

/**
 *
 * @author karim
 */
public class serviceTest {
    public void add(Object u) {
        Test t = (Test)u;
        try {
            String req = "INSERT INTO `test`(`titre`, `description`) VALUES (?,?)";
            PreparedStatement ps = new MyConnection().getConnection().prepareStatement(req);
            ps.setString(1, t.getTitre());
            ps.setString(2, t.getDescription());
          
            ps.executeUpdate();
            System.out.println("Test Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
/**/
    public List<Test> afficherTest() {
    List<Test> listt = null;
                 try{
                    
                     String a,b;
                     listt = new ArrayList<Test>();
                     String sql = "select * from test";
                      Statement st= new MyConnection().getConnection().createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    
                     while (rs.next())
                     {
                         Test pr = new Test();
                         int id = pr.getId();
                         pr.setTitre(rs.getString("titre"));
                         pr.setDescription(rs.getString("description"));
                       
                         System.out.println(pr);
                         listt.add(pr);
                     }

             }
                 catch(SQLException e ) {

                     // System.out.print(e.getMessage());
                     System.out.println("Error = " + e.getMessage());
                    }
        return listt;
    }
   

   
    public boolean update(Object u) {
        try {
            String req = "update `test` SET `titre`=?,`description`=? where id = ?";
            PreparedStatement ps = new MyConnection().getConnection().prepareStatement(req);
            Test t = (Test) u;
            System.out.println(t.getTitre());
            ps.setString(1, t.getTitre());
            ps.setString(2, t.getDescription());
            ps.setInt(3, t.getId());
            ps.executeUpdate();
            
            System.out.println("Test modifier");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(Object u) {
        Test e = (Test) u;
        String req = "delete from test where id = ?";
        try {
            PreparedStatement ps = new MyConnection().getConnection().prepareStatement(req);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
            System.out.println("Test supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public List getAll() {
        List<Test> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `test`";
            Statement st =new MyConnection().getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Test e = new Test(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
    public List getAllStudent() {
        List<Test> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `test`";
            Statement st =new MyConnection().getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Test e = new Test(rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),
                 rs.getString(7),rs.getString(8),rs.getString(9), rs.getString(10), rs.getInt(11));
                list.add(e);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
    public Test getById(int id) {
        Test t = new Test();
        try {
            String req = "SELECT * FROM `test` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = new MyConnection().getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Test us = new Test(rs.getInt(1), rs.getString(2), rs.getString(3));
                t = us;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return t;
    }
    
    public Test getCoursById(int id) {
        Test t = new Test();
        try {
            String req = "SELECT * FROM `test` where coursid = " + id;
            // Statement st = cnx.createStatement();
            Statement st = new MyConnection().getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Test us = new Test(rs.getInt(1), rs.getString(2), rs.getString(3));
                t = us;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return t;
    }
}
