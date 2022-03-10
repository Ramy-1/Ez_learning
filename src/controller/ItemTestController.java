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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Test;
import model.questions;
import services.serviceTest;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class ItemTestController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private ImageView Img;
    @FXML
    private Label role;
    @FXML
    private Label labelTitre;
    @FXML
    private Label labelDesc;
    @FXML
    private Label titre;
    @FXML
    private Label desc;
    @FXML
    private Label id;
    Test t;
    questions q;
    serviceTest sT = new serviceTest();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        titre.setText(t.getTitre());
        desc.setText(t.getDescription());
        id.setText(Integer.toString(t.getId()));
    }    

    @FXML
    private void DeleteClicked(ActionEvent event) {
       Alert a = new Alert(AlertType.NONE);

                a.setAlertType(AlertType.CONFIRMATION);
          
                
               Optional<ButtonType> result = a.showAndWait();
                if(!result.isPresent()){
                    a.close();
                }
                else if(result.get() == ButtonType.OK){
                    sT.delete(t);
                }       
                else if(result.get() == ButtonType.CANCEL){
                     a.close();
                }

       
    }

    @FXML
    private void UpdateClicked(ActionEvent event) throws IOException {

        EditTestItemController cont = new EditTestItemController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditTestItem.fxml"));
        loader.setController(cont);
//        mainAnchor = loader.load();
        cont.t = this.t;
        cont.type=2;
        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(loader.load()));
        stage.show();
   

    }
    
    @FXML
    private void QuestionList(ActionEvent event) throws IOException {
        QuestionController cont = new QuestionController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("QuestionAll.fxml"));
        loader.setController(cont);
        cont.Q = this.q;
        cont.t = this.t;
//        mainAnchor = loader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Qustions du Test "+t.getTitre());
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    
}
