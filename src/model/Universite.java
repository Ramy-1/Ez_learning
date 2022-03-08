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
public class Universite {
      private String idUni ;
    private String nom ; 
    private String email;
    private String adresse;
    private String imguni;
    private String mdpuni;

    public Universite() {
    }

    public Universite(String idUni, String nom, String email, String adresse, String imguni, String mdpuni) {
        this.idUni = idUni;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.imguni = imguni;
        this.mdpuni = mdpuni;
    }

    public Universite(String nom, String email, String adresse, String imguni, String mdpuni) {
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.imguni = imguni;
        this.mdpuni = mdpuni;
    }

    public Universite(String text, String text0, String text1) {
                this.nom = text;
        this.email = text0;
        this.adresse = text1;
    
    }

    public String getIdUni() {
        return idUni;
    }

    public void setIdUni(String idUni) {
        this.idUni = idUni;
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

    public String getImguni() {
        return imguni;
    }

    public void setImguni(String imguni) {
        this.imguni = imguni;
    }

    public String getMdpuni() {
        return mdpuni;
    }

    public void setMdpuni(String mdpuni) {
        this.mdpuni = mdpuni;
    }

    @Override
    public String toString() {
        return "Universite{" + "idUni=" + idUni + ", nom=" + nom + ", email=" + email + ", adresse=" + adresse + ", imguni=" + imguni + ", mdpuni=" + mdpuni + '}';
    }
    
    
    
}
