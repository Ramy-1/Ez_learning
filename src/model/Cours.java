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
public class Cours {
    private int id ; 
    private String titre;
    private String description;
    private int duree;
    private Date datecreate;
    private String support;
    private int idcat;
    private int etat;

    public Cours() {
    }

    public Cours(int id, String titre, String description, int duree, Date datecreate, String support, int idcat) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.duree = duree;
        this.datecreate = datecreate;
        this.support = support;
        this.idcat = idcat;
        this.etat = etat;
    }

      public Cours( String titre, String description, int duree, Date datecreate,int etat) {
       
        this.titre = titre;
        this.description = description;
        this.duree = duree;
        this.datecreate = datecreate;
        this.etat = etat;
        
    }
    public Cours(String titre, String description, int duree, Date datecreate, String support,int idcat) {
        this.titre = titre;
        this.description = description;
        this.duree = duree;
        this.datecreate = datecreate;
        this.support = support;
        this.idcat = idcat;
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    @Override
    public String toString() {
        return "Cours{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", duree=" + duree + ", datecreate=" + datecreate + ", support=" + support + ", idcat=" + idcat + '}';
    }

    public int isEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    
    
    
    
    
    
}
