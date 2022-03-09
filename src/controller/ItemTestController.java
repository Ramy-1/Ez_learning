/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.Test;

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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        titre.setText(t.getTitre());
        desc.setText(t.getDescription());
    }    

    @FXML
    private void DeleteClicked(ActionEvent event) {
    }

    @FXML
    private void UpdateClicked(ActionEvent event) {
    }
    
}
