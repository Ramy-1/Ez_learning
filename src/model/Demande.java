/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ihebowski
 */
public class Demande {
    private int id;
    private String description;
    private String pathCv;
    
    //join
    private int idOffre;
    private int idEtudiant;

    public Demande() {
    }

    public Demande(int id, String description, String pathCv, int idOffre, int idEtudiant) {
        this.id = id;
        this.description = description;
        this.pathCv = pathCv;
        this.idOffre = idOffre;
        this.idEtudiant = idEtudiant;
    }

    public Demande(String description, String pathCv, int idOffre, int idEtudiant) {
        this.description = description;
        this.pathCv = pathCv;
        this.idOffre = idOffre;
        this.idEtudiant = idEtudiant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathCv() {
        return pathCv;
    }

    public void setPathCv(String pathCv) {
        this.pathCv = pathCv;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    @Override
    public String toString() {
        return "demande{" + "id=" + id + ", description=" + description + ", pathCv=" + pathCv + ", idOffre=" + idOffre + ", idEtudiant=" + idEtudiant + '}';
    }

}
