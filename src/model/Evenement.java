/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Nabil
 */
public class Evenement {
    private int idEvent ;
    private String idOrg ; 
    private String description;
    private Date date;
    private String heure;
    private String lien;
    private String imgEv;
    private int nbrParticipant;
    
    
    private int idUni;

    public Evenement() {
    }

    public Evenement(int idEvent, String idOrg, String description, Date date, String heure, int nbrParticipant) {
        this.idEvent = idEvent;
        this.idOrg = idOrg;
        this.description = description;
        this.date = date;
        this.heure = heure;
        
        this.nbrParticipant = nbrParticipant;
    }

    public Evenement(int idEvent, String idOrg, String description, Date date, String heure, String lien, String imgEv,int nbrParticipant) {
        this.idEvent = idEvent;
        this.idOrg = idOrg;
        this.description = description;
        this.date = date;
        this.heure = heure;
        this.lien = lien;
        this.imgEv = imgEv;
        this.nbrParticipant = nbrParticipant;
    }

    public Evenement(String idOrg, String description, Date date, String heure, String lien, String imgEv,int nbrParticipant) {
        this.idOrg = idOrg;
        this.description = description;
        this.date = date;
        this.heure = heure;
        this.lien = lien;
        this.imgEv = imgEv;
        
        this.nbrParticipant = nbrParticipant;
    }

    public Evenement(String idOrg, String description, Date date, String heure, String lien, String imgEv,int nbrParticipant, int idUni) {
        this.idOrg = idOrg;
        this.description = description;
        this.date = date;
        
        this.heure = heure;
        this.lien = lien;
        this.imgEv = imgEv;
        this.idUni = idUni;
    }
    
    
    public Evenement(String idOrg, String description, Date date, String heure,int nbrParticipant) {
        this.idOrg = idOrg;
        this.description = description;
        this.date = date;
        
        this.heure = heure;
   
    }
  
    public Evenement(String idOrg, String description, Date date, String heure,String lien,int nbrParticipant) {
        this.idOrg = idOrg;
        this.description = description;
        this.date = date;
        this.lien = lien;
        
        this.heure = heure;
   
    }


    
    
    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getIdOrg() {
        return idOrg;
    }

    public void setIdOrg(String idOrg) {
        this.idOrg = idOrg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getImgEv() {
        return imgEv;
    }

    public void setImgEv(String imgEv) {
        this.imgEv = imgEv;
    }

    public int getIdUni() {
        return idUni;
    }

    public void setIdUni(int idUni) {
        this.idUni = idUni;
    }


    public int getNbrParticipant() {
        return nbrParticipant;
    }

    public void setNbrParticipant(int nbrParticipant) {
        this.nbrParticipant = nbrParticipant;
    }
    
    

    
    @Override
    public String toString() {
        return "Evenement{" + "idEvent=" + idEvent + ", idOrg=" + idOrg + ", description=" + description + ", date=" + date + ", heure=" + heure + ", lien=" + lien + ", imgEv=" + imgEv + '}';
    }
    
    
   
}
