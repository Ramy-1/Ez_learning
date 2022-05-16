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
import model.EtudiantCours;
import model.ResultatReponse;
import model.Test;
import model.questions;
import util.MyConnection;

/**
 *
 * @author karim
 */
public class serviceResultatReponse {
    serviceQuestion sQ= new serviceQuestion();
    
   /* public void add(Object u) {
        ResultatReponse rr = (ResultatReponse)u;
        try {
            String req = "INSERT INTO `reultatreponse`(`reponseid`, `reponsenote`,question`) VALUES (?,?,?)";
            PreparedStatement ps = new MyConnection().getConnection().prepareStatement(req);
            ps.setInt(1, rr.getReponseid());
            ps.setFloat(2, rr.getNotereponse());
            ps.setInt(2, rr.getQuestion());
          
            ps.executeUpdate();
            System.out.println("reultat Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
    /* 
    public questions getResultByQuestion(int id){
        ResultatReponse q = new ResultatReponse();
        try {
            String req = "SELECT * FROM `questions` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = new MyConnection().getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                ResultatReponse us = new ResultatReponse(rs.getInt(1),rs.getInt(2),rs.getInt(2),rs.getInt(2),rs.getInt(2), rs.getBoolean(3), rs.getInt(4), rs.getInt(5));
                q = us;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return q;
    }
    
    public Test getResultByTest(int id){
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
    
    public void getReult(){
        List listQ = sQ.getByTestId(0);
        
      
    }*/
    
    public void AddReponse(int reponse,int question,int user,int test,boolean correct,int note){
        try {
            String req = "INSERT INTO `reponse_etudiant`(`reponse_id`, `question_id`, `user_id`, `test_id`, `is_correct`, `note`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = new MyConnection().getConnection().prepareStatement(req);
            ps.setInt(1, reponse);
            ps.setInt(2, question);
            ps.setInt(3, user);
            ps.setInt(4, test);
            ps.setBoolean(5, correct);
            ps.setInt(6, note);
          
            ps.executeUpdate();
            System.out.println("Reponse Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public List<ResultatReponse> getReponsesByTestAndUser(int user,int test) {
    List<ResultatReponse> listrr = null;
                 try{
                    
                     String a,b;
                     listrr = new ArrayList<ResultatReponse>();
                     String sql = "SELECT * FROM `reponse_etudiant` WHERE test_id="+test+" and user_id="+user;
                      Statement st= new MyConnection().getConnection().createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    
                     while (rs.next())
                     {
                         ResultatReponse pr = new ResultatReponse(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5), rs.getBoolean(6), rs.getInt(7), rs.getInt(8));
                         int id = pr.getId();
                        
                         listrr.add(pr);
                     }

             }
                 catch(SQLException e ) {

                     // System.out.print(e.getMessage());
                     System.out.println("Error = " + e.getMessage());
                    }
        return listrr;
    }
    
    
    public void submit(int user,int test,int note){
        try {
            String req = "INSERT INTO `reponse_etudiant`( `user_id`, `test_id`, `final`) VALUES (?,?,?)";
            PreparedStatement ps = new MyConnection().getConnection().prepareStatement(req);
          ;
            ps.setInt(1, user);
            ps.setInt(2, test);
           
            ps.setInt(3, note);
          
            ps.executeUpdate();
            System.out.println("Reponse Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public ResultatReponse getFinalByUserAndTest(int user,int test) {
    List<ResultatReponse> listrr = null;
    ResultatReponse rr= new ResultatReponse();
                 try{
                    
                     String a,b;
                     listrr = new ArrayList<ResultatReponse>();
                     String sql = "SELECT * FROM `reponse_etudiant` WHERE test_id="+test+" and user_id="+user+" and final != null";
                      Statement st= new MyConnection().getConnection().createStatement();
                    ResultSet rs=st.executeQuery(sql);
                    
                     while (rs.next())
                     {
                         ResultatReponse pr = new ResultatReponse(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5), rs.getBoolean(6), rs.getInt(7), rs.getInt(8));
                         int id = pr.getId();
                        rr.setId(rs.getInt(1));
                        rr.setReponseid(rs.getInt(2));
                        rr.setQuestionid(rs.getInt(3));
                        rr.setUserid(rs.getInt(4));
                        rr.setTestid(rs.getInt(5));
                        rr.setIscorrect(rs.getBoolean(6));
                        rr.setNote(rs.getInt(7));
                        rr.setFinale(rs.getInt(8));
                         listrr.add(pr);
                     }

             }
                 catch(SQLException e ) {

                     // System.out.print(e.getMessage());
                     System.out.println("Error = " + e.getMessage());
                    }
        return rr;
    }
   
}
