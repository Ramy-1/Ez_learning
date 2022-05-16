/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Test;
import model.questions;
import util.MyConnection;

/**
 *
 * @author karim
 */
public class serviceQuestion {
     public void add(Object u) {
        
        try {
            questions q = (questions) u;
            String req = "INSERT INTO questions(contenu,testid) VALUES (?,?)";
            PreparedStatement ps = new MyConnection().getConnection().prepareStatement(req);
            ps.setString(1, q.getContenu());
            ps.setInt(2, q.getTestid());
            
          
            ps.executeUpdate();
            System.out.println("Question Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
/**/
    public List<questions> afficherTest() {
    List<questions> listt = null;
                 try{
                    
                     String a,b;
                     listt = new ArrayList<questions>();
                     String sql = "select * from test";
                      Statement st= new MyConnection().getConnection().createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    
                     while (rs.next())
                     {
                         questions pr = new questions();
                         int id = pr.getId();
                         pr.setContenu(rs.getString("contenu"));
            
                       
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
            String req = "update `questions` set contenu = ? ,testid=? where   id = ?";
            PreparedStatement ps = new MyConnection().getConnection().prepareStatement(req);
            questions q = (questions) u;

            ps.setString(1, q.getContenu());
            ps.setInt(2, q.getTestid());

            ps.setInt(3, q.getId());
            ps.executeUpdate();
            
            System.out.println("Question modifier");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(Object u) {
        questions e = (questions) u;

        String req = "delete from questions where id = ?";
        try {
            PreparedStatement ps = new MyConnection().getConnection().prepareStatement(req);
            ps.setInt(1, e.getId());
            ps.executeUpdate();
            System.out.println("Question supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public List getAll() {
        
        List<questions> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `questions`";
            Statement st =new MyConnection().getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);
            
            
            while (rs.next()) {
                int t = rs.getInt(3);

                questions q = new questions();
                q.setId(rs.getInt(1));
                q.setContenu(rs.getString(2)) ; 
                q.setTestid(t);
                
                list.add(q);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(list);
        return list;
    }
    public questions getById(int id) {
        questions q = new questions();
        
        try {
            String req = "SELECT * FROM `questions` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = new MyConnection().getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                questions us = new questions(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                q = us;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return q;
    }
    public List getByTestId(int id) {
        
        List<questions> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `questions` WHERE `test_id`="+ id;
            // Statement st = cnx.createStatement();
            Statement st = new MyConnection().getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                questions q = new questions(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                list.add(q);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return list;
    }
    
    
    public List getByTestIdStudent(int id) {
        
        List<questions> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `questions` WHERE `test_id`="+id;
            // Statement st = cnx.createStatement();
            Statement st = new MyConnection().getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                questions q = new questions(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(q);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        
        return list;
    }
}
