/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Reponses;

/**
 *
 * @author Nabil
 */
public interface IReponses {
       public void ajouterReponses(Reponses r);
        public List<Reponses> afficherReponses();
        public void supprimerReponses(Reponses r);
        public void modifierReponses(Reponses r, String id);
}
