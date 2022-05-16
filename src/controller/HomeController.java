/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author mrram
 */
public class HomeController implements Initializable {

    @FXML
    private ScrollPane Scrollepane;
    @FXML
    private VBox pnl_scroll;
    @FXML
    private Circle mi;
    @FXML
    private Circle re;
    @FXML
    private Circle close1;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private Label lbl_completed;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void ListEtudiantClicked(ActionEvent event) {
    }


    @FXML
    private void ListUniversiteClicked(ActionEvent event) {
    }

    @FXML
    private void MiWindow(MouseEvent event) {
    }

    @FXML
    private void ReWindow(MouseEvent event) {
    }

    @FXML
    private void closeWindow(MouseEvent event) {
    }

    @FXML
    private void ListEnseignantClicked(ActionEvent event) {
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

    @FXML
    private void RClicked(ActionEvent event) {
    }

    @FXML
    private void AddClicked(ActionEvent event) {
    }

    @FXML
    private void ListCourClicked(ActionEvent event) {
    }

    @FXML
    private void ajoutCourCLicked(ActionEvent event) {
    }
    
}
