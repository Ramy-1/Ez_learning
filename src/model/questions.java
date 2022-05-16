/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author karim
 */
public class questions {
    private int id;
     private int testid;
    private String contenu;
    private String description;
    private String support;
    private String supportUpdatedAt;
    private String type;

    public questions(int id, int testid, String contenu, String description, String support, String supportUpdatedAt, String type) {
        this.id = id;
        this.testid = testid;
        this.contenu = contenu;
        this.description = description;
        this.support = support;
        this.supportUpdatedAt = supportUpdatedAt;
        this.type = type;
    }

    public questions(int id, int testid, String contenu, String support, String supportUpdatedAt, String type) {
        this.id = id;
        this.testid = testid;
        this.contenu = contenu;
        this.support = support;
        this.supportUpdatedAt = supportUpdatedAt;
        this.type = type;
    }

    public questions(int id, int testid, String contenu) {
        this.id = id;
        this.testid = testid;
        this.contenu = contenu;
    }

    
    public questions(int id, String contenu) {
        this.id = id;
        this.contenu = contenu;
    }
    
    
    public questions(){
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public String getContenu() {
        return contenu;
    }

    public int getTestid() {
        return testid;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getSupportUpdatedAt() {
        return supportUpdatedAt;
    }

    public void setSupportUpdatedAt(String supportUpdatedAt) {
        this.supportUpdatedAt = supportUpdatedAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

   
    @Override
    public String toString() {
        return  contenu  ;
    }
    
  

    
    
    
    
    
}
