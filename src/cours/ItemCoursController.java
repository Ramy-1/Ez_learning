/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cours;

import controller.EditItemController;
import controller.HomeController;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
//import mediaplayer.MediaPlayerController;
import model.Cours;
import services.serviceEtudiantCours;

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
    @FXML 
    Label durationfield;
    @FXML 
    Label createdfield;
    
    Cours c;
    serviceEtudiantCours sec= new serviceEtudiantCours();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Date date = c.getDatecreate();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
                System.out.println(date);
                String strDate = dateFormat.format(date); 
        labelTitreItem.setText(c.getTitre());
       labelDescriptionItem.setText(c.getDescription()); 
       durationfield.setText(Integer.toString(c.getDuree()));
       createdfield.setText(strDate);
    } 
    
    public void ItemClicked() throws IOException{
        
        ShowCoursController cont = new ShowCoursController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowCours.fxml"));
        loader.setController(cont);
        
        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(loader.load()));
        stage.show();
        
        
    }
    @FXML
    private void DeleteClicked(ActionEvent event) {
    }

    @FXML
    private void UpdateClicked(ActionEvent event) {
    }
    
}
