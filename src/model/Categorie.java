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
public class Categorie {
    private int idcat ;
    private String domaine;
    private String nomcat;

    public Categorie() {
    }

    public Categorie(int idcat, String domaine, String nomcat) {
        this.idcat = idcat;
        this.domaine = domaine;
        this.nomcat = nomcat;
    }

    public Categorie(String domaine, String nomcat) {
        this.domaine = domaine;
        this.nomcat = nomcat;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getNomcat() {
        return nomcat;
    }

    public void setNomcat(String nomcat) {
        this.nomcat = nomcat;
    }

    @Override
    public String toString() {
        return "Categorie{" + "idcat=" + idcat + ", domaine=" + domaine + ", nomcat=" + nomcat + '}';
    }
    
    
}
