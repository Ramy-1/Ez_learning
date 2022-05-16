package model;

public class Recruteur extends User {

    private String societe;

    public Recruteur() {
        super();
        this.role = Role.Recruteur;
    }

    public Recruteur(int id, String nom, String prenom, int phone, String email, String pwd, String carte_banq,
            String societe) {
//        super(id, nom, prenom, phone, email, pwd, carte_banq);
        this.role = Role.Recruteur;
        this.societe = societe;
    }

    public Recruteur(String nom, String prenom, int phone, String email, String pwd, String carte_banq,
            String societe) {
//        super(nom, prenom, phone, email, pwd, carte_banq);
        this.role = Role.Recruteur;
        this.societe = societe;
    }

    public Recruteur(String nom, String prenom, int phone, String email, String pwd, String carte_banq) {
//        super(nom, prenom, phone, email, pwd, carte_banq);
        this.role = Role.Recruteur;
    }

    public Recruteur(User u) {
//        this(u.nom, u.prenom, u.phone, u.email, u.pwd, u.carte_banq);
        // return this;
    }

    @Override
    public String toString() {
        return "{"
                + " societe='" + getsociete() + "'"
                + "}";
    }

    public String getsociete() {
        return this.societe;
    }

    public void setsociete(String societe) {
        this.societe = societe;
    }

}
