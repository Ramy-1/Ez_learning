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
    private String titre;
    private String description;
    private int[] questions;
    
    public Test(){
    }

    public Test(int id, String titre, int[] questions) {
        this.id = id;
        this.titre = titre;
        this.questions = questions;
    }

    public Test(String titre, String description, int[] questions) {
        this.titre = titre;
        this.description = description;
        this.questions = questions;
    }

    public Test(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Test(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public Test(int id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
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

    public int[] getQuestions() {
        return questions;
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

    public void setQuestions(int[] questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return  titre ;
    }

    
    
}
