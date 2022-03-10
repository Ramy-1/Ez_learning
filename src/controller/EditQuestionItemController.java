/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import helper.AlertHelper;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Categorie;
import model.Test;
import model.questions;
import services.serviceQuestion;
import services.serviceTest;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class EditQuestionItemController implements Initializable {

    @FXML
    private ImageView Img;
    @FXML
    private Label role;
    @FXML
    private Label labelNom;
    @FXML
    private Label labelPrenom;
    @FXML
    private TextField nom;
    @FXML
    private Label id;
    questions q;
    Window window;
    
     @FXML 
     private ComboBox combotest;
     
     serviceQuestion sQ = new serviceQuestion();
     serviceTest sT = new serviceTest();
     int type = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(type==2){
            List<Test> listC = sT.getAll();
            int i=0;
            combotest.getItems().clear();
            Node[] nodes = new Node[listC.size()];
            for (Test each : listC) {
                combotest.getItems().add(listC.get(i));
                i++;
             }    
             Test test = sT.getById(q.getTestid());

            combotest.getSelectionModel().select(test.getTitre());
            nom.setText(q.getContenu());
        }
        if(type==1){
            List<Test> listC = sT.getAll();
            int i=0;
            combotest.getItems().clear();
            Node[] nodes = new Node[listC.size()];
            for (Test each : listC) {
                combotest.getItems().add(listC.get(i));
                i++;
             }    
        }
        
    } 
    

    @FXML
    private void confirmClicked(ActionEvent event) {
        questions tc = new questions();
        tc.setContenu(nom.getText());
        System.out.println(nom.getText());
        Test tes =(Test) combotest.getSelectionModel().getSelectedItem();
        tc.setTestid(tes.getId());
        if(type==2){
            tc.setId(q.getId());
            sQ.update(tc);
             AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "mod");
        }
        if(type==1){
            sQ.add(tc);
             AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "add");
        }
         
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
}
