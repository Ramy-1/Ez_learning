/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cours;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.Cours;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class ItemController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label labelTitreItem;
    @FXML
    private Label labelDescriptionItem;
    
    Cours c;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        labelTitreItem.setText(c.getTitre());
        //labelDescriptionItem.setText(c.getDescription());    
    }    
    public void ItemClicked() throws IOException{
         System.out.println("hello");
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/cours/courEtudiant.fxml"));
          
         CourEtudiantController cec =new CourEtudiantController();
         loader.setController(cec);
       
         System.out.println(cec.labelTitre.getText());

       
    }
}
