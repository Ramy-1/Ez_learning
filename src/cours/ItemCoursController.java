/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cours;

import controller.HomeController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Cours;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class ItemCoursController implements Initializable {
    @FXML 
    Label labelTitreItem;
    @FXML 
    Label labelDescriptionItem;
    
    Cours c;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
        labelTitreItem.setText(c.getTitre());
       // labelDescriptionItem.setText(c.getDescription());       
    } 
    
    public Cours ItemClicked(){
        
     return c;
    }
    @FXML
    private void DeleteClicked(ActionEvent event) {
    }

    @FXML
    private void UpdateClicked(ActionEvent event) {
    }
    
}
