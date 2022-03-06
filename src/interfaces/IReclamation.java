/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.Reclamation;

/**
 *
 * @author Nabil
 */
public interface IReclamation {
        public void ajouterReclamation(Reclamation R);
        public List<Reclamation> afficherReclamation();
        public void supprimerReclamation(Reclamation R);
        public void modifierReclamation(Reclamation R, int id);
        
}
