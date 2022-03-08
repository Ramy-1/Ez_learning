/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.societe;
import services.serviceSociete;
/**
 * FXML Controller class
 *
 * @author Nabil
 */
public class SocieteController implements Initializable {
societe Soc = new societe();
serviceSociete ssoc = new serviceSociete();
    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private ImageView Img;
    @FXML
    private Label nomsoc;
    @FXML
    private Label emailsoc;
    @FXML
    private Label mdpsoc;
    @FXML
    private Label adressesoc;
    @FXML
    private Label idsoc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nomsoc.setText(Soc.getNom());
        idsoc.setText(String.valueOf(Soc.getIdsoc()));
        emailsoc.setText(Soc.getEmail());
        adressesoc.setText(Soc.getAdresse());
        mdpsoc.setText(Soc.getMdpsoc());
        System.out.println("test societe");
        
    }    

    @FXML
    private void ModifierClicked(ActionEvent event) throws IOException {
        SocieteController cont = new SocieteController();
        cont.Soc = this.Soc;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller/admin/societe.fxml"));
        loader.setController(cont);
//        mainAnchor = loader.load();

        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    
    }

    @FXML
    private void EffacerClicked(ActionEvent event) {
   ssoc.supprimerSociete(Soc);
    }
    
}
