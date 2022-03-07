/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Evenement;
import model.Universite;

/**
 *
 * @author Nabil
 */
public interface IUniversite<T>{
   public void ajouterUniversite(Universite U);
        public List<Universite> afficherUniversite();
        public void supprimerUniversite(Universite U);
        public void modifierUniversite(Universite U, String idUni);
        //jointure
        public List<Evenement> afficherEvenementsUniversite(int idu);
}
