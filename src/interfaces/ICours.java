/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Cours;

/**
 *
 * @author Nabil
 */
public interface ICours {
    public void ajouterCours(Cours C);
        public List<Cours> afficherCours();
        public void supprimerCours(int id );
        public void modifierCours(Cours C,int idC);
        
        //1 Metier 1
        public boolean likeCours(int iduser,int idcours,int like);
        
        //METIER 2
        public int countLikes();
        public int countDislike();
        
        public String statLikeParRapportCours();
        
        //JOIN
       public List<Cours> afficherCoursParCategorie(int idcat);
  
       // existence user like
       public boolean userLikeExist(int iduser, int idcours);
       
       //JOIN
              public List<Cours> afficherCoursLiker();

              //METIER3
                public void traiterCours(Cours c);
        
}
