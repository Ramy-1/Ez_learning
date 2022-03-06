/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nabil
 */
public class societe {
    private String idsoc ;
    private String nom ; 
    private String email;
    private String adresse;
    private String imgsoc;
    private String mdpsoc;

    public societe() {
    }

    public societe(String idsoc, String nom, String email, String adresse, String imgsoc, String mdpsoc) {
        this.idsoc = idsoc;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.imgsoc = imgsoc;
        this.mdpsoc = mdpsoc;
    }

    public societe(String nom, String email, String adresse, String imgsoc, String mdpsoc) {
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.imgsoc = imgsoc;
        this.mdpsoc = mdpsoc;
    }

    public String getIdsoc() {
        return idsoc;
    }

    public void setIdsoc(String idsoc) {
        this.idsoc = idsoc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getImgsoc() {
        return imgsoc;
    }

    public void setImgsoc(String imgsoc) {
        this.imgsoc = imgsoc;
    }

    public String getMdpsoc() {
        return mdpsoc;
    }

    public void setMdpsoc(String mdpsoc) {
        this.mdpsoc = mdpsoc;
    }

    @Override
    public String toString() {
        return "societe{" + "idsoc=" + idsoc + ", nom=" + nom + ", email=" + email + ", adresse=" + adresse + ", imgsoc=" + imgsoc + ", mdpsoc=" + mdpsoc + '}';
    }
              
 }
