/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Reclamation;
import model.reponse;
import services.serviceReclamation;
import services.servicereponse;

/**
 * FXML Controller class
 *
 * @author Nabil
 */
public class ReclamationsController implements Initializable {

    @FXML
    private Button boutonEnvoyer;
    @FXML
    private TextField TEtudiant;
    @FXML
    private TextArea TFDesc;
    @FXML
    private TextField TCours;
    @FXML
    private ComboBox<String> typeCombo;
    @FXML
    private Label delai;
   
    

    @FXML
    private void EnvoyerReclamation(ActionEvent event) {
          
                  
          String description = TFDesc.getText();
          String idetudiant =TEtudiant.getText();
          String cours = TCours.getText();
          String type1 = typeCombo.getSelectionModel().getSelectedItem();
          
          Reclamation R = new Reclamation(type1, description, idetudiant,cours);
          serviceReclamation sr = new serviceReclamation();
          sr.ajouterReclamation(R);
   
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       ObservableList<String> list = FXCollections.observableArrayList("Reclamation Technique","Reclamation concernant un cours") ; //To change body of generated methods, choose Tools | Templates.
      typeCombo.setItems(list);
    }


    

   
}