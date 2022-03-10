/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.societe;
import services.serviceSociete;

/**
 * FXML Controller class
 *
 * @author Nabil
 */
public class UpsocieteController implements Initializable {
   societe soc = new societe();
   serviceSociete ssoc = new serviceSociete();
    
    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private ImageView Img;
    @FXML
    private Label nom_societe;
    @FXML
    private Button bouton_changer;
    @FXML
    private Button bouton_annuler;
    @FXML
    private TextField id_societe;
    @FXML
    private TextField email_societe;
    @FXML
    private TextField adresse_societe;
    @FXML
    private PasswordField mdp_societe;
    private String path;
    @FXML
    private TextField pathimg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          File path = new File("C:\\Users\\mrram\\Desktop\\Ez_learning\\src\\controller\\images\\"+soc.getImgsoc());
        Image image = new Image(path.toURI().toString());
        Img.setImage(image);
       nom_societe.setText(soc.getNom());
       id_societe.setText(soc.getIdsoc());
       email_societe.setText(soc.getEmail());
       mdp_societe.setText(soc.getMdpsoc());
       adresse_societe.setText(soc.getAdresse());
       pathimg.setText(soc.getImgsoc());
       System.out.println("affichage modification societe");
      
        
      
        
// TODO
    }    

    @FXML
    private void ChangerClicked(ActionEvent event) {
     String noms = nom_societe.getText();
       String ids = id_societe.getText();
       String mails = email_societe.getText();
       String mdps = mdp_societe.getText();
       String adrs = adresse_societe.getText();
       String img = pathimg.getText();
       societe nvsoc = new societe(ids, noms, mails, adrs,img, mdps);
       ssoc.modifierSociete(nvsoc, ids);
       quittersession(event);
    }

    @FXML
    private void AnnulerClicked(ActionEvent event) {
    quittersession(event);
    }
    private void quittersession(ActionEvent event){
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void uploadlogo(ActionEvent event) {
                FileChooser fc = new FileChooser();
                fc.setTitle("choisissez le logo de la societe");
                File file = fc.showOpenDialog(null);
                pathimg.setText(file.getName());
    }


}
