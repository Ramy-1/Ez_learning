/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Test;
import model.questions;
import services.serviceQuestion;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class QuestionItemController implements Initializable {

    @FXML
    private ImageView Img;
    @FXML
    private Label role;
    @FXML
    private Label Test;
    @FXML
    private Label labelContenu;
    @FXML
    private Label labelTest;
    @FXML
    private Label id;
    questions q;
    Test ts;
    serviceQuestion sQ= new serviceQuestion();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        labelContenu.setText(q.getContenu());
        labelTest.setText(ts.getTitre());
        id.setText(Integer.toString(q.getId()));
    }    

     @FXML
    private void DeleteClicked(ActionEvent event) throws IOException {
       Alert a = new Alert(Alert.AlertType.NONE);

                a.setAlertType(Alert.AlertType.CONFIRMATION);
          
                
               Optional<ButtonType> result = a.showAndWait();
                if(!result.isPresent()){
                    a.close();
                }
                else if(result.get() == ButtonType.OK){
                    sQ.delete(q);
                }       
                else if(result.get() == ButtonType.CANCEL){
                     a.close();
                }

      

    }

    @FXML
    private void UpdateClicked(ActionEvent event) throws IOException {
          EditQuestionItemController cont = new EditQuestionItemController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditQuestionItem.fxml"));
        loader.setController(cont);
//        mainAnchor = loader.load();
        cont.q = this.q;
        cont.type=2;
        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    
    @FXML
    private void ReponsesList(ActionEvent event) throws IOException {
        RponsesAllController cont = new RponsesAllController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RponsesAll.fxml"));
        loader.setController(cont);
        cont.Q = this.q;
       
//        mainAnchor = loader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Reponses du Question "+q.getContenu());
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    
}
