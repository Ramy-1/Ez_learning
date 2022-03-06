/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;


import services.servicereponse;
import services.serviceReclamation;

/**
 *
 * @author Nabil
 */
public class reponse {
    private int idreponse ;
    private int idreclamation ;
    private String description ;
    private LocalDate daterep ; 

    public reponse() {
    }
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public reponse(int idreclamation, String description) {
        this.idreclamation = idreclamation;
        this.description = description;
        this.daterep = LocalDate.now();
    }

    public reponse(int idreclamation, String description, String daterep) {
        this.idreclamation = idreclamation;
        this.description = description;
        this.daterep = LocalDate.now();
    }

    public reponse(int idreponse, int idreclamation, String description, String daterep) {
        this.idreponse = idreponse;
        this.idreclamation = idreclamation;
        this.description = description;
        this.daterep =LocalDate.now();
    }

    public int getIdreponse() {
        return idreponse;
    }

    public void setIdreponse(int idreponse) {
        this.idreponse = idreponse;
    }

    public int getIdreclamation() {
        return idreclamation;
    }

    public void setIdreclamation(int idreclamation) {
        this.idreclamation = idreclamation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDaterep() {
        return daterep;
    }

    public void setDaterep(LocalDate daterep) {
        this.daterep = daterep;
    }

    @Override
    public String toString() {
        return "reponse{" + "idreponse=" + idreponse + ", idreclamation=" + idreclamation + ", description=" + description + ", daterep=" + daterep + '}';
    }
    
    public int delaiReponse(Reclamation R){
        Period daysBetween = Period.between(R.getDaterec(),this.daterep);
        int per = daysBetween.getDays()+daysBetween.getMonths()*30;
        System.out.println("periode de délai pour la reponse a la reclamation : "+ per);
      return per;
    }
    public int MoyDelaiReponse(){
     servicereponse sr = new servicereponse();
          serviceReclamation src = new serviceReclamation();

      List<reponse> list = sr.afficherReponse();
      return (int) list.stream().mapToInt(x -> x.delaiReponse(src.GetByIdReclamtion(x.getIdreclamation())))
              .average()
              .orElse(0.0f);
           
    }
    
}
