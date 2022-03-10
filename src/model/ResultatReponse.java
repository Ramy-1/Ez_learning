/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author karim
 */
public class ResultatReponse {
    private int id;
    private int reponseid;
    private float notereponse;
    private int question;

    public ResultatReponse(int id, int reponseid, float notereponse, int question) {
        this.id = id;
        this.reponseid = reponseid;
        this.notereponse = notereponse;
        this.question=question;
    }

    public ResultatReponse(int reponseid, float notereponse, int question) {
        this.reponseid = reponseid;
        this.notereponse = notereponse;
        this.question=question;
    }
    

    public ResultatReponse() {
    }
    
    public int getId() {
        return id;
    }

    public int getReponseid() {
        return reponseid;
    }

    public float getNotereponse() {
        return notereponse;
    }

    public int getQuestion() {
        return question;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setReponseid(int reponseid) {
        this.reponseid = reponseid;
    }

    public void setNotereponse(float notereponse) {
        this.notereponse = notereponse;
    }

    public void setQuestion(int question) {
        this.question = question;
    }
    
    
    
}
