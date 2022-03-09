/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.societe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Demande;
import model.Offre;
import services.ServiceDemande;
import services.ServiceEtudiant;
import services.ServiceOffre;

/**
 * FXML Controller class
 *
 * @author Ihebowski
 */
public class DemandeController implements Initializable {
    Demande D = new Demande();    
    ServiceDemande sD = new ServiceDemande();
    ServiceOffre sO = new ServiceOffre();
    ServiceEtudiant sE = new ServiceEtudiant();

    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private Label titreoffre;
    @FXML
    private Label etudiantname;
    @FXML
    private Label datedemande;
    @FXML
    private Label typeoffre;
    @FXML
    private Label nivetudiant;
    @FXML
    private Label descdemande;
    @FXML
    private Label isaccepted;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //System.out.println(D.toString());
        //System.out.println(sO.getOffreById(D.getIdOffre()).toString());
        //System.out.println(sE.getEtudiantById(D.getIdEtudiant()).toString());
        
        titreoffre.setText(sO.getOffreById(D.getIdOffre()).getTitre());
        typeoffre.setText(sO.getOffreById(D.getIdOffre()).getType());
        
        etudiantname.setText(sE.getById(D.getIdEtudiant()).getNom());
        nivetudiant.setText(String.valueOf(sE.getById(D.getIdEtudiant()).getNiveau()+" eme"));
        
        descdemande.setText(D.getDescription());
        datedemande.setText(String.valueOf(D.getDateSend())); //To do
        
        if (D.getIsAccepted() == true){
            isaccepted.setText("Accepted");
        } else {
            isaccepted.setText("Still Waiting");
        }
        
        System.out.println("test demande");
        // TODO
    }    

    @FXML
    private void RefuseClicked(ActionEvent event) {
        sD.deleteDemande(D);
    }

    @FXML
    private void AcceptClicked(ActionEvent event) {
        sD.AccepterDemande(D);
    }
    
}
