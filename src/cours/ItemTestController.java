/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cours;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Test;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class ItemTestController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label labelTitreItem;
    @FXML
    private Label labelDescriptionItem;
    @FXML
    private Label labeltime;
    Test t;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        labelTitreItem.setText(t.getTitre());
        labelDescriptionItem.setText(t.getDescription());
        
    }    

    @FXML
    private void ItemClicked(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("QuizAll.fxml"));
         QuizAllController cont = new QuizAllController();
         cont.T = this.t;
       
//        mainAnchor = loader.load();
        
        Stage stage = new Stage();
        stage.setTitle("Quiz");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
    
}
