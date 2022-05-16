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
    private int questionid;
    private int userid;
    private int testid;
    private boolean iscorrect;
    private int note;
    private int finale;

    public ResultatReponse(int id, int reponseid, float notereponse, int question) {
        this.id = id;
        this.reponseid = reponseid;
       
    }

    public ResultatReponse(int userid, int testid, int finale) {
        this.userid = userid;
        this.testid = testid;
        this.finale = finale;
    }

    public ResultatReponse(int reponseid, int questionid, int userid, int testid, boolean iscorrect, int note) {
        this.reponseid = reponseid;
        this.questionid = questionid;
        this.userid = userid;
        this.testid = testid;
        this.iscorrect = iscorrect;
        this.note = note;
    }

    public ResultatReponse(int reponseid, int questionid, int userid, int testid, boolean iscorrect, int note, int finale) {
        this.reponseid = reponseid;
        this.questionid = questionid;
        this.userid = userid;
        this.testid = testid;
        this.iscorrect = iscorrect;
        this.note = note;
        this.finale = finale;
    }

    public ResultatReponse(int id, int reponseid, int questionid, int userid, int testid, boolean iscorrect, int note, int finale) {
        this.id = id;
        this.reponseid = reponseid;
        this.questionid = questionid;
        this.userid = userid;
        this.testid = testid;
        this.iscorrect = iscorrect;
        this.note = note;
        this.finale = finale;
    }
    
    

    public ResultatReponse(int id, int reponseid, int questionid, int userid, int testid, boolean iscorrect, int finale) {
        this.id = id;
        this.reponseid = reponseid;
        this.questionid = questionid;
        this.userid = userid;
        this.testid = testid;
        this.iscorrect = iscorrect;
        this.finale = finale;
    }

    
    public ResultatReponse(int reponseid, float notereponse, int question) {
        this.reponseid = reponseid;

    }
    

    public ResultatReponse() {
    }
    
    public int getId() {
        return id;
    }

    public int getReponseid() {
        return reponseid;
    }

  
    
    public void setId(int id) {
        this.id = id;
    }

    public void setReponseid(int reponseid) {
        this.reponseid = reponseid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public boolean isIscorrect() {
        return iscorrect;
    }

    public void setIscorrect(boolean iscorrect) {
        this.iscorrect = iscorrect;
    }

    public int getFinale() {
        return finale;
    }

    public void setFinale(int finale) {
        this.finale = finale;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

   
    
    
    
}
