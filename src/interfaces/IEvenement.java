/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.HashMap;
import java.util.List;
import model.Evenement;

/**
 *
 * @author Nabil
 */
public interface IEvenement {
        public void ajouterEvenement(Evenement Ev);
        public List<Evenement> afficherEvenement();
        public void supprimerEvenement(int id);
        public void modifierEvenement(Evenement Ev,int idE);
        
        //Metier 1
        public List<Evenement> rechercheEvenementsOrganisteur(String id);
        
        //Metier 2 Calculer nombre total
        public int nombreTotalEvenement();
        
        //METIER 3 TOP 5 evenets by number participants
        public void topFiveEvents() ;
        
        
        
        
        
  
}
