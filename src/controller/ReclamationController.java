/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import services.serviceReclamation;
import model.Reclamation;


/**
 * FXML Controller class
 *
 * @author Nabil
 */
public class ReclamationController implements Initializable {
 
    serviceReclamation sr = new serviceReclamation();
    Reclamation R = new Reclamation();
    
    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private ImageView Img;
    @FXML
    private Label typerec;
    @FXML
    private Label idetud;
    @FXML
    private Label idcours;
    @FXML
    private Label daterec;
    @FXML
    private Label id;
    @FXML
    private Label descrec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println("test");
        typerec.setText(R.getType());
        id.setText(String.valueOf(R.getIdrec()));
        daterec.setText(String.valueOf(R.getDaterec()));
        idetud.setText(R.getIdetudiant());
        idcours.setText(R.getIdcours());
        descrec.setText(R.getDescription());
        
    }    

    @FXML
    private void RepondreClicked(ActionEvent event) throws IOException {
        ReponseRecController cont = new ReponseRecController();
        cont.id_reponse = R.getIdrec();
        cont.rec = R;
        

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReponseRec.fxml"));
        loader.setController(cont);
//        mainAnchor = loader.load();

        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    @FXML
    private void EffacerClicked(ActionEvent event) {
    }
    
}
