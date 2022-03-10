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
    private String contenu;
    private int testid;
    private Reponses reponses;
    private int responsecorrect;
    private float note;

    public questions(int id, String contenu, int testid, Reponses reponses, int responsecorrect, float note) {
        this.id = id;
        this.contenu = contenu;
        this.testid = testid;
        this.reponses = reponses;
        this.responsecorrect = responsecorrect;
        this.note = note;
    }

    public questions(String contenu, int testid, Reponses reponses) {
        this.contenu = contenu;
        this.testid = testid;
        this.reponses = reponses;
    }

    public questions(int id, String contenu, int testid) {
        this.id = id;
        this.contenu = contenu;
        this.testid = testid;
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

    
   

    public void setResponsecorrect(int responsecorrect) {
        this.responsecorrect = responsecorrect;
    }

    public void setNote(float note) {
        this.note = note;
    }
    

    public String getContenu() {
        return contenu;
    }

    public int getTestid() {
        return testid;
    }

    

    public void setReponses(Reponses reponses) {
        this.reponses = reponses;
    }

    public Reponses getReponses() {
        return reponses;
    }

   
    public int getResponsecorrect() {
        return responsecorrect;
    }

    public float getNote() {
        return note;
    }

    @Override
    public String toString() {
        return  contenu  ;
    }
    
  

    
    
    
    
    
}
