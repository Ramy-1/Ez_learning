/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nabil
 */
public class Universite {

    private int id;
    private String idUni;
    private String nom;

    private String email;
    private String adresse;
    private String imguni;
    private String mdpuni;

   
    public Universite() {
        super();
        this.role = Role.universite;
    }


    public Universite(User u) {
//        this.idUni = u.getId();
        this.id = u.id;
        this.nom = u.nom;
        this.email = u.email;
//        this.adresse = adresse;
//        this.imguni = imguni;
        this.mdpuni = u.pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    


    public Universite(int idUni, String nom, String email, String adresse, String imguni, String mdpuni) {

        this.idUni = idUni;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.imguni = imguni;
        this.mdpuni = mdpuni;
    }

    public Universite(String nom, String email, String adresse, String imguni, String mdpuni) {
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.imguni = imguni;
        this.mdpuni = mdpuni;
    }

    public Universite(String text, String text0, String text1) {
        this.nom = text;
        this.email = text0;
        this.adresse = text1;

    }


    public int getIdUni() {
        return idUni;
    }

    public void setIdUni(int idUni) {
        this.idUni = idUni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getImguni() {
        return imguni;
    }

    public void setImguni(String imguni) {
        this.imguni = imguni;
    }

    public String getMdpuni() {
        return mdpuni;
    }

    public void setMdpuni(String mdpuni) {
        this.mdpuni = mdpuni;
    }

    @Override
    public String toString() {
        return "Universite{" + "idUni=" + idUni + ", nom=" + nom + ", email=" + email + ", adresse=" + adresse + ", imguni=" + imguni + ", mdpuni=" + mdpuni + '}';
    }*/
    
     public Universite() {
        super();
        this.role = Role.universite;
    }

    public Universite(int id, String nom, String prenom, int phone, String email, String pwd, String carte_banq
            ) {
        super(id, nom, prenom, phone, email, pwd, carte_banq);
        this.role = Role.universite;
    
    }

    public Universite(String nom, int phone, String email, String pwd, String carte_banq
           ) {
        super(nom, phone, email, pwd, carte_banq);
        this.role = Role.universite;
            }

    public Universite(String nom, String prenom, int phone, String email, String pwd, String carte_banq) {
        super(nom, prenom, phone, email, pwd, carte_banq);
        this.role = Role.universite;
    }

    public Universite(User u) {
        this(u.nom, u.phone, u.email, u.pwd, u.carte_banq);
        // return this;
    }

    
   
    
}
