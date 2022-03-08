/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    private TextArea descrep;
    @FXML
    private Label daterec;

    int id_reponse;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       rep.setIdreclamation(id_reponse);
       
     typerec.setText(rec.getType());
     idrec.setText(String.valueOf(rec.getIdrec()));
     daterec.setText(String.valueOf(rec.getDaterec()));
     idetud.setText(rec.getIdetudiant());
  
     
     System.out.println(rec);
// TODO
    }    

    @FXML
    private void AjoutReponseClicked(ActionEvent event) {
    int idreclamation =Integer.parseInt(idrec.getText());
    String reponse = descrep.getText();
    reponse rep = new reponse(idreclamation, reponse);
    
    srp.ajouterReponse(rep);
    
     final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    
    }

    @FXML
    private void AnnulerClicked(ActionEvent event) {
   final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    
    }
    
}
