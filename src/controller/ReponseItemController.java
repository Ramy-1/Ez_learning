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
import javafx.stage.Stage;
import model.Reponses;
import model.questions;
import services.serviceQuestion;
import services.serviceReponsesQ;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class ReponseItemController implements Initializable {
    
    Reponses r;
    questions q;
    
    @FXML
    private Label contenu;
    @FXML
    private Label correct;
    @FXML
    private Label note;
    @FXML
    private Label question;
    serviceQuestion sQ= new serviceQuestion();
    serviceReponsesQ srQ = new serviceReponsesQ();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        contenu.setText(r.getContenu());
        correct.setText(String.valueOf(r.isCorrect()));
        note.setText(String.valueOf(r.getNote()));
        questions ques = sQ.getById(r.getQuestion());
        question.setText(ques.getContenu());
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
                    srQ.delete(r);
                }       
                else if(result.get() == ButtonType.CANCEL){
                     a.close();
                }

    }

    @FXML
    private void UpdateClicked(ActionEvent event) throws IOException {
        EditReponseItemController cont = new EditReponseItemController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditReponseItem.fxml"));
        loader.setController(cont);
//        mainAnchor = loader.load();
        cont.R = this.r;
        cont.Q =this.q;
        cont.type=2;
        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}
