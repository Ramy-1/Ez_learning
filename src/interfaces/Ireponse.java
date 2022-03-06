/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.reponse;

/**
 *
 * @author Nabil
 */
public interface Ireponse {
       public void ajouterReponse(reponse rep);
        public List<reponse> afficherReponse();
        public void supprimerReponse(reponse rep);
        public void modifierReponse(reponse rep, int id);
}
