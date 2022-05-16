/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PC
 */
public class LikeCours {
    
    private int idLike;
    private int iduser;
    private int idcours;
    private int likeEtat;

    public LikeCours() {
    }

    public LikeCours(int idLike, int iduser, int idcours,int likeEtat) {
        this.idLike = idLike;
        this.iduser = iduser;
        this.idcours = idcours;
        this.likeEtat=likeEtat;    }

    public LikeCours(int iduser, int idcours,int likeEtat) {
        this.iduser = iduser;
        this.idcours = idcours;
        this.likeEtat =likeEtat;
    }

    public int getIdLike() {
        return idLike;
    }

    public void setIdLike(int idLike) {
        this.idLike = idLike;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    public int getLikeEtat() {
        return likeEtat;
    }

    public void setLikeEtat(int likeEtat) {
        this.likeEtat = likeEtat;
    }
    
    
    
    
    
    
}
