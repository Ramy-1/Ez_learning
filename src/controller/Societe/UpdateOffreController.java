/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.societe;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Offre;
import services.ServiceOffre;

/**
 * FXML Controller class
 *
 * @author Ihebowski
 */
public class UpdateOffreController implements Initializable {
    Offre O = new Offre();
    ServiceOffre sO = new ServiceOffre();

    @FXML
    private ImageView Img;
    @FXML
    private Label role;
    @FXML
    private Label labelNom;
    @FXML
    private Label labelPrenom;
    @FXML
    private TextField titre;
    @FXML
    private TextField nbplace;
    @FXML
    private ComboBox type;
    @FXML
    private DatePicker date;
    @FXML
    private Label offreid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ObservableList types = FXCollections.observableArrayList("Stage", "Alternance", "CDI");
       type.getItems().addAll(types);
       
       offreid.setText(String.valueOf(O.getId()));
       titre.setText(O.getTitre());
       date.setValue(O.getDateFin().toLocalDate());
       type.getSelectionModel().select(O.getType());
       nbplace.setText(String.valueOf(O.getNbPlace()));
        // TODO
    }   

    @FXML
    private void UpdateOffreClicked(ActionEvent event) {
        
        Offre o = new Offre(
                O.getId(),
                titre.getText(), 
                type.getSelectionModel().getSelectedItem().toString(),
                java.sql.Date.valueOf(date.getValue()),
                Integer.parseInt(nbplace.getText()), 
                O.getNbDemande(),
                O.getNbAccepted(),
                2
        );
        System.out.println(o.toString());
        sO.modifierOffre(o);
        
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

        @FXML
    private void CloseClicked(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
