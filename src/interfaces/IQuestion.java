/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import model.questions;

/**
 *
 * @author Nabil
 */
public interface IQuestion {
       public void ajouterQuestion(questions q);
        public List<questions> afficherQuestion();
        public void supprimerQuestion(questions q);
        public void modifierQuestion(questions q, int id);
}
