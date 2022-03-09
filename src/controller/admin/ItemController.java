/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

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
import model.Enseignant;
import model.Etudiant;
import model.Recruteur;
import model.Role;
import static model.Role.Recruteur;
import model.Universite;
import model.User;
import services.ServiceEns;
import services.ServiceEtudiant;
import services.ServiceRecruteur;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author mrram
 */
public class ItemController implements Initializable {

    ServiceUser sU = new ServiceUser();
    ServiceEtudiant sE = new ServiceEtudiant();
    ServiceEns sEn = new ServiceEns();
    ServiceRecruteur sR = new ServiceRecruteur();

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

//        role.setText(U.getRole().toString());
//        roleController(U.getRole());
//        System.out.println(U);
        nom.setText(U.getNom());
        prenom.setText(U.getPrenom());
        phone.setText(String.valueOf(U.getPhone()));
        role.setText(U.getRole().toString());
        mail.setText(U.getEmail());
        cartbanq.setText(U.getCarte_banq());

        System.out.println("id = " + U.getId() + " Role= " + U.getRole());
        switch (U.getRole()) {
            case etudiant:
                file = new File("src/controler/admin/images/student.jpg");
                Img.setImage(new Image(file.toURI().toString()));

                Etudiant e = new Etudiant(U);
//                e = sE.getById(U.getId());
                e = sE.getByMail(U.getEmail());

                LabelSection.setText("Section");
                section.setText(e.getSection());

                LabelScore.setText("Score");
                score.setText(String.valueOf(e.getScore()));
                LabelScore.setVisible(true);
                score.setVisible(true);
                System.out.println("etudiant = " + e);

                break;

            case Recruteur:
                file = new File("src/controler/admin/images/recruitment.png");
                Img.setImage(new Image(file.toURI().toString()));

                Recruteur rec = new Recruteur(U);
                rec = sR.getByMail(U.getEmail());
                System.out.println("rec= " + rec);

                LabelSection.setText("Societe");
                section.setText(rec.getsociete());

                LabelScore.setVisible(false);
                score.setVisible(false);
                break;

            case enseignant:
                Enseignant en = new Enseignant(U);

                en = sEn.getByMail(U.getEmail());
                file = new File("src/controler/admin/images/teacher.png");
                Img.setImage(new Image(file.toURI().toString()));

                LabelSection.setText("Section");
                section.setText(en.getSection());

                System.out.println("ensg= " + en);

                LabelSection.setText("Section");
                section.setText(en.getSection());

                LabelScore.setText("Universite");
                score.setText(en.getUniversite());
                LabelScore.setVisible(true);
                score.setVisible(true);
                break;

            case admin:

                file = new File("src/controler/adminimages/admin.png");
                Img.setImage(new Image(file.toURI().toString()));

                U.setRole(Role.admin);
                LabelSection.setVisible(false);
                section.setVisible(false);
                LabelScore.setVisible(false);
                score.setVisible(false);
                break;

            // case universite:
            // Universite e = (Universite) U;
            // File file = new File("src//controler/adminimages/teacher.png");
            // Img.setImage(new Image(file.toURI().toString()));
            // LabelSection.setText("Universite");
            // prenom.setVisible(false);
            // LabelScore.setText("Universite");
            // labelNom.setText("Titre");
            // break;
            default:
                System.out.println("empty");
                break;

        }

    }

    File file;

    @FXML
    private void DeleteClicked(ActionEvent event) throws IOException {
        sU.delete(U);

        ItemController Close = new ItemController();
//        Close.reload(event);

    }

    @FXML
    private void UpdateClicked(ActionEvent event) throws IOException {

//        ItemController cont = new ItemController();
//        cont.U = this.U;
//        HomeController home = new HomeController();
//        home.updateUser(this.U);
        EditItemController cont = new EditItemController();
        cont.type = 2;
        cont.U = this.U;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditItem.fxml"));
        loader.setController(cont);
//        mainAnchor = loader.load();

        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(loader.load()));
        stage.show();
        ItemController Close = new ItemController();
//        Close.reload(event);
//        Parent root = FXMLLoader.load(getClass().getResource("EditItem.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//
//        stage.setScene(scene);
//        stage.show();
    }

}
