/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Cours;
import model.Enseignant;
import model.Etudiant;
import model.Recruteur;
import model.Role;
import static model.Role.Recruteur;
import model.Universite;
import model.User;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author mrram
 */
public class ItemController implements Initializable {

    ServiceUser sU = new ServiceUser();

    private Label Username;

    String test;
    User U;
    @FXML
    private Label prenom;
    @FXML
    private Label phone;
    @FXML
    private Label section;
    @FXML
    private Label score;
    @FXML
    private Label role;
    @FXML
    private Label nom;
    @FXML
    private Label mail;
    @FXML
    private Label cartbanq;
    @FXML
    private ImageView Img;
    @FXML
    private Label id;
    @FXML
    private AnchorPane mainAnchor;
    private Label SectionLabel;
    @FXML
    private Label LabelSection;
    @FXML
    private Label LabelScore;
    @FXML
    private Label labelPrenom;
    @FXML
    private Label labelNom;
    public Cours c;

//    public ItemController(String haja) {
//        this.test = haja;
//    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        Username.setText("ahmeddd");
//        nom.setText(U.getNom());

        nom.setText(U.getNom());
        prenom.setText(U.getPrenom());
        phone.setText(String.valueOf(U.getPhone()));
        role.setText(U.getRole().toString());
        mail.setText(U.getEmail());
        cartbanq.setText(U.getCarte_banq());

        if (U.getRole() == Role.etudiant) {
            Etudiant e = (Etudiant) U;
            section.setText(e.getSection());
            score.setText(String.valueOf(e.getScore()));
            File file = new File("src/dashboard/images/student.jpg");
            Img.setImage(new Image(file.toURI().toString()));
            prenom.setVisible(true);
             labelPrenom.setVisible(true);
        }
        if (U.getRole() == Role.Recruteur) {
            Recruteur r = (Recruteur) U;
            File file = new File("src/dashboard/images/recruitment.png");
            Img.setImage(new Image(file.toURI().toString()));
            LabelSection.setText("Societe");
            section.setText(r.getsociete());
            LabelScore.setVisible(false);
            score.setVisible(false);
            prenom.setVisible(true);
             labelPrenom.setVisible(true);
        }
        if (U.getRole() == Role.enseignant) {
            Enseignant e = (Enseignant) U;
            File file = new File("src/dashboard/images/teacher.png");
            Img.setImage(new Image(file.toURI().toString()));
//            LabelSection.setText("Universite");
            section.setText(e.getSection());
            LabelScore.setText("Universite");
            score.setText(e.getUniversite());
             prenom.setVisible(true);
             labelPrenom.setVisible(true);
        }
        if (U.getRole() == Role.admin) {
            File file = new File("src/dashboard/images/admin.png");
            Img.setImage(new Image(file.toURI().toString()));
        }
        
        if (U.getRole() == Role.universite) {
            Universite un = new Universite(U);
                File file = new File("src/controller/adminimages/teacher.png");
                Img.setImage(new Image(file.toURI().toString()));
                LabelSection.setText("Universite");
                prenom.setVisible(false);
                LabelScore.setText("Universite");
                labelNom.setText("Titre");
                
        }
        if (U.getRole() == Role.empty) {
            LabelScore.setVisible(false);
            LabelSection.setVisible(false);
            labelPrenom.setVisible(false);
            section.setText("");
            score.setText("");
        }

    }

    void initData(String u) {
        Username.setText(u);
    }

    @FXML
    private void DeleteClicked(ActionEvent event) throws IOException {
        sU.delete(U);


    }

    @FXML
    private void UpdateClicked(ActionEvent event) throws IOException {

//        ItemController cont = new ItemController();
//        cont.U = this.U;
//        HomeController home = new HomeController();
//        home.updateUser(this.U);
        EditItemController cont = new EditItemController();
        cont.type = 2;
        cont.u = this.U;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditItem.fxml"));
        loader.setController(cont);
//        mainAnchor = loader.load();

        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(loader.load()));
        stage.show();
       
//        Close.reload(event);
//        Parent root = FXMLLoader.load(getClass().getResource("EditItem.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//
//        stage.setScene(scene);
//        stage.show();
    }

}
