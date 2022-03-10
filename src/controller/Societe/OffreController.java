/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.societe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Offre;
import services.ServiceOffre;

/**
 * FXML Controller class
 *
 * @author Ihebowski
 */
public class OffreController implements Initializable {
    Offre O = new Offre();
    ServiceOffre sO = new ServiceOffre();

    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private ImageView Img;
    @FXML
    private Label titreoffre;
    @FXML
    private Label nbplaceoffre;
    @FXML
    private Label dateoffre;
    @FXML
    private Label typeoffre;
    @FXML
    private Label nbaccoffre;
    @FXML
    private Label nbdemandeoffre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        titreoffre.setText(O.getTitre());
        typeoffre.setText(O.getType());
        dateoffre.setText(String.valueOf(O.getDateFin()));
        nbplaceoffre.setText(String.valueOf(O.getNbPlace()));
        nbdemandeoffre.setText(String.valueOf(O.getNbDemande()));
        nbaccoffre.setText(String.valueOf(O.getNbAccepted()));
        
        System.out.println("test Offre");
    }    

    @FXML
    private void ModifierClicked(ActionEvent event) throws IOException {
        UpdateOffreController cont = new UpdateOffreController();
        cont.O = this.O;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateOffre.fxml"));
        loader.setController(cont);
        //mainAnchor = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Update Offre");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    @FXML
    private void EffacerClicked(ActionEvent event) {
        sO.deleteOffre(O);
    }
    
}
