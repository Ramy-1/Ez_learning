/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author karim
 */
public class Test {
    private int id;
    private int user_id;
    private int coursid;
    private String titre;
    private String description;
    private String image;
    private String imageUpdatedat;
    private String createdAt;
    private String beginAt;
    private String endAt;
    private int success_score;
    
    
    
    public Test(){
    }

    public Test(int id, String titre) {
        this.id = id;
        this.titre = titre;
        
    }

    public Test(int coursid, String titre, String description, String image) {
        this.coursid = coursid;
        this.titre = titre;
        this.description = description;
        this.image = image;
    }

    public Test(int coursid, String titre, String description, String image, String beginAt, String endAt, int success_score) {
        this.coursid = coursid;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.beginAt = beginAt;
        this.endAt = endAt;
        this.success_score = success_score;
    }

    public Test(int id, int user_id, int coursid, String titre, String description, String image, String imageUpdatedat, String createdAt, int success_score) {
        this.id = id;
        this.user_id = user_id;
        this.coursid = coursid;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.imageUpdatedat = imageUpdatedat;
        this.createdAt = createdAt;
        this.success_score = success_score;
    }

    public Test(int id, int user_id, int coursid, String titre, String description, String image, String imageUpdatedat, String createdAt, String beginAt, String endAt, int success_score) {
        this.id = id;
        this.user_id = user_id;
        this.coursid = coursid;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.imageUpdatedat = imageUpdatedat;
        this.createdAt = createdAt;
        this.beginAt = beginAt;
        this.endAt = endAt;
        this.success_score = success_score;
    }

    public Test(int user_id, int coursid, String titre, String description, String image, String imageUpdatedat, String createdAt, int success_score) {
        this.user_id = user_id;
        this.coursid = coursid;
        this.titre = titre;
        this.description = description;
        this.image = image;
        this.imageUpdatedat = imageUpdatedat;
        this.createdAt = createdAt;
        this.success_score = success_score;
    }
    
    
    
    public Test(String titre, String description) {
        this.titre = titre;
        this.description = description;
        
    }

    public Test(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    public Test(int id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }

    public int getCoursid() {
        return coursid;
    }

    public void setCoursid(int coursid) {
        this.coursid = coursid;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageUpdatedat() {
        return imageUpdatedat;
    }

    public void setImageUpdatedat(String imageUpdatedat) {
        this.imageUpdatedat = imageUpdatedat;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getSuccess_score() {
        return success_score;
    }

    public void setSuccess_score(int success_score) {
        this.success_score = success_score;
    }

    

   
   

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getBeginAt() {
        return beginAt;
    }

    public void setBeginAt(String beginAt) {
        this.beginAt = beginAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    @Override
    public String toString() {
        return  titre ;
    }

    
    
}
