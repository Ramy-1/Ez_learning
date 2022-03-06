/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Nabil
 */
public class Reclamation {
     private int idrec ;
     private String type ;
     private String description;
     private String idetudiant;
     private String idcours;
     private LocalDate daterec;

    public Reclamation() {
    }
 
    public Reclamation(int idrec, String type, String description, String idetudiant, String idcours,LocalDate daterec) {
        this.idrec = idrec;
        this.type = type;
        this.description = description;
        this.idetudiant = idetudiant;
        this.idcours = idcours;
        this.daterec = daterec;
    }
 DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public Reclamation(String type, String description, String idetudiant, String idcours) {
        this.type = type;
        this.description = description;
        this.idetudiant = idetudiant;
        this.idcours = idcours;
        this.daterec=LocalDate.now();
    }

    public Reclamation(String type, String description, String idetudiant, String idcours,String daterec) {
        this.type = type;
        this.description = description;
        this.idetudiant = idetudiant;
        this.idcours = idcours;
        this.daterec = LocalDate.now();
    }

    public int getIdrec() {
        return idrec;
    }

    public void setIdrec(int idrec) {
        this.idrec = idrec;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdetudiant() {
        return idetudiant;
    }

    public void setIdetudiant(String idetudiant) {
        this.idetudiant = idetudiant;
    }

    public String getIdcours() {
        return idcours;
    }

    public void setIdcours(String idcours) {
        this.idcours = idcours;
    }

    public LocalDate getDaterec() {
        return daterec;
    }

    public void setDaterec(LocalDate daterec) {
        this.daterec = daterec;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idrec=" + idrec + ", type=" + type + ", description=" + description + ", idetudiant=" + idetudiant + ", idcours=" + idcours + ", daterec=" +daterec+ '}';
    }
     
     
}
