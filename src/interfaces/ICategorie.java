/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.List;
import model.Categorie;
/**
 *
 * @author Nabil
 */
public interface ICategorie {
     public void ajouterCategorie(Categorie Cat);
        public List<Categorie> afficherCategorie();
        public void supprimerCategorie(int id );
        public void modifierCategorie(Categorie Cat,int idCat);
        
}
