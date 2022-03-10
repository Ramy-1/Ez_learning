/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.EtudiantCours;
import model.Test;
import util.MyConnection;

/**
 *
 * @author karim
 */
public class serviceEtudiantCours {
     public void add(Object u) {
        EtudiantCours t = (EtudiantCours)u;
        try {
            String req = "INSERT INTO `etudiantcours`(`idetudiant`, `idcours`) VALUES (?,?)";
            PreparedStatement ps = new MyConnection().getConnection().prepareStatement(req);
            ps.setInt(1, t.getIdetudiant());
            ps.setInt(2, t.getIdcours());
          
            ps.executeUpdate();
            System.out.println("cours Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
}
