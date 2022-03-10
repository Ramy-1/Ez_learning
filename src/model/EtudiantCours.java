/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author karim
 */
public class EtudiantCours {
    private int idetudiant;
    private int idcours;

    public EtudiantCours(int idetudiant, int idcours) {
        this.idetudiant = idetudiant;
        this.idcours = idcours;
    }

    public int getIdetudiant() {
        return idetudiant;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdetudiant(int idetudiant) {
        this.idetudiant = idetudiant;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }
    
    
}
