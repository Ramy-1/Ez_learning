/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Ihebowski
 */
public class Offre {
    private int id;
    private String titre;
    private String type;
    private Date dateFin;
    private int nbPlace;
    private int nbDemande;
    private int nbAccepted;
    
    //join
    private int idRecruteur;

    public Offre() {
    }
    
    public Offre(Offre o){
        this.id = o.id;
        this.titre = o.titre;
        this.type = o.type;
        this.dateFin = o.dateFin;
        this.nbPlace = o.nbPlace;
        this.nbDemande = o.nbDemande;
        this.nbAccepted = o.nbAccepted;
        this.idRecruteur = o.idRecruteur;
    }

    public Offre(int id, String titre, String type, Date dateFin, int nbPlace, int nbDemande, int nbAccepted, int idRecruteur) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.dateFin = dateFin;
        this.nbPlace = nbPlace;
        this.nbDemande = nbDemande;
        this.nbAccepted = nbAccepted;
        this.idRecruteur = idRecruteur;
    }

    public Offre(String titre, String type, Date dateFin, int nbPlace, int nbDemande, int nbAccepted, int idRecruteur) {
        this.titre = titre;
        this.type = type;
        this.dateFin = dateFin;
        this.nbPlace = nbPlace;
        this.nbDemande = nbDemande;
        this.nbAccepted = nbAccepted;
        this.idRecruteur = idRecruteur;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public int getNbDemande() {
        return nbDemande;
    }

    public void setNbDemande(int nbDemande) {
        this.nbDemande = nbDemande;
    }

    public int getNbAccepted() {
        return nbAccepted;
    }

    public void setNbAccepted(int nbAccepted) {
        this.nbAccepted = nbAccepted;
    }

    public int getIdRecruteur() {
        return idRecruteur;
    }

    public void setIdRecruteur(int idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", titre=" + titre + ", type=" + type + ", dateFin=" + dateFin + ", nbPlace=" + nbPlace + ", nbDemande=" + nbDemande + ", nbAccepted=" + nbAccepted + ", idRecruteur=" + idRecruteur + '}';
    }

}