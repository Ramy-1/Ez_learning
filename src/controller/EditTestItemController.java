/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Enseignant;
import model.Etudiant;
import model.Recruteur;
import model.Test;
import model.User;
import services.serviceTest;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class EditTestItemController implements Initializable {
    
    @FXML
    private TextField titre;
    @FXML
    private TextField description;
    @FXML
    private TextField score;
    @FXML
    private Button upload;
    @FXML
    private DatePicker datedebut;
    @FXML
    private DatePicker datefin;
    
    Test t;
    serviceTest sT= new serviceTest();
    int type=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(type==1){}
        if(type==2){
            titre.setText(t.getTitre());
            description.setText(t.getDescription());
        }
        
        
    }   
    
    @FXML
    private void confirmClicked(ActionEvent event) throws IOException {
        Test tc = new Test();
        tc.setTitre(titre.getText());
        tc.setDescription(description.getText());
        tc.setBeginAt(datedebut.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        tc.setEndAt(datefin.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        tc.setSuccess_score(parseInt(score.getText()));
        
        
        if(type==1){
            sT.add(tc);
            System.out.println("test ajouter");
        }
        if(type==2){
            tc.setId(t.getId());
            sT.update(tc);
        }
        
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    
}
