/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.societe;

/**
 *
 * @author Nabil
 */
public interface ISociete {
       public void ajouterSociete(societe S);
        public List<societe> afficherSociete();
        public void supprimerSociete(societe S);
        public void modifierSociete(societe S, String id);
}
