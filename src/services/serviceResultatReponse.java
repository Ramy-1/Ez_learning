/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public void add(Object u) {
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
    
    public questions getResultByQuestion(int id){
        questions q = new questions();
        try {
            String req = "SELECT * FROM `questions` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = new MyConnection().getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                questions us = new questions(rs.getInt(1), rs.getString(2),  rs.getInt(3));
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
        
      
    }
}
