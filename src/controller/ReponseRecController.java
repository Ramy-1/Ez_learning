/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Reclamation;
import services.servicereponse;
import model.reponse;
import services.serviceReclamation;

/**
 * FXML Controller class
 *
 * @author Nabil
 */



public class ReponseRecController implements Initializable {
    Reclamation rec = new Reclamation();
    
    
    servicereponse srp = new servicereponse();
    reponse rep = new reponse();
    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private ImageView Img;
    @FXML
    private Label typerec;
    @FXML
    private Label idetud;
    @FXML
    private Label idrec;
    @FXML
    private JFXTextArea descrep;
    @FXML
    private Label daterec;
    @FXML
    private Label idreponse;

    int id_reponse;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       rep.setIdreclamation(id_reponse);
       
       System.out.println(rec);
// TODO
    }    

    @FXML
    private void AjoutReponseClicked(ActionEvent event) {
    }

    @FXML
    private void AnnulerClicked(ActionEvent event) {
    }
    
}
