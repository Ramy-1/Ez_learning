/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author karim
 */
public class Reponses {
    
    private int id;
    private String contenu;
    private int question;
    private boolean correct;
    private float note;

    public Reponses(int id, String contenu, int question, boolean correct, float note) {
        this.id = id;
        this.contenu = contenu;
        this.question = question;
        this.correct = correct;
        this.note = note;
    }

    public Reponses(String contenu, int question, boolean correct, float note) {
        this.contenu = contenu;
        this.question = question;
        this.correct = correct;
        this.note = note;
    }

   
    
    public Reponses() {
       
    }

    public int getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public int getQuestion() {
        return question;
    }

    public boolean isCorrect() {
        return correct;
    }

    public float getNote() {
        return note;
    }
    
    
    public void setId(int id) {
        this.id = id;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public void setNote(float note) {
        this.note = note;
    }
    
    @Override
    public String toString() {
        return "Reponses{" + "id=" + id + ", contenu=" + contenu + ", question=" + question + ", correct=" + correct + '}';
    }
    
    
}
