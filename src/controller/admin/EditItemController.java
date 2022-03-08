/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import com.jfoenix.controls.JFXComboBox;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.U;
import javafx.stage.Stage;
import model.Enseignant;
import model.Etudiant;
import model.Recruteur;
import model.Role;
import model.Universite;
import model.User;
import services.ServiceEns;
import services.ServiceEtudiant;
import services.ServiceRecruteur;
import services.ServiceUser;
import services.serviceUniversite;

/**
 * FXML Controller class
 *
 * @author mrram
 */
public class EditItemController implements Initializable {

    @FXML
    private Label role;
    private Label labelsection;
    private Label labelscore;
    User U = new User();
    @FXML
    private TextField nom;
    @FXML
    private TextField phone;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField carteBancaire;
    @FXML
    private TextField section;
    @FXML
    private TextField score;
    @FXML
    private ImageView Img;
    @FXML
    private Label labelPrenom;
    @FXML
    private Label labelNom;
    /**
     * Initializes the controller class.
     */
    ServiceUser sU = new ServiceUser();
    ServiceEtudiant sE = new ServiceEtudiant();
    ServiceEns sEn = new ServiceEns();
    ServiceRecruteur sR = new ServiceRecruteur();
    serviceUniversite sUni = new serviceUniversite();
    @FXML
    private TextField psw;
    int type = 0;
    @FXML
    private JFXComboBox<?> type2;
    @FXML
    private ComboBox<?> typeBox;
    Role roleEnum = Role.empty;
    @FXML
    private Label LabelSection;
    @FXML
    private Label LabelScore;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList types = FXCollections.observableArrayList("Etudiant", "Enseignant", "Recruteur", "Admin", "universite");
        typeBox.getItems().addAll(types);
        
        
        U.setRole(roleEnum);
        File file;
        switch (U.getRole()) {
            case etudiant:
                file = new File("src/controler/admin/images/student.jpg");
                Img.setImage(new Image(file.toURI().toString()));

                Etudiant e = (Etudiant) sE.getById(U.getId());

                LabelSection.setText("Section");
                section.setText(e.getSection());

                LabelScore.setText("Score");
                score.setText(String.valueOf(e.getScore()));
                LabelScore.setVisible(true);
                score.setVisible(true);
                break;
                
            case Recruteur:
                file = new File("src/controler/admin/images/recruitment.png");
                Img.setImage(new Image(file.toURI().toString()));

                Recruteur r = (Recruteur) U;
                r = (Recruteur) sR.getById(U.getId());

                LabelSection.setText("Societe");
                section.setText(r.getsociete());
                LabelScore.setVisible(false);
                score.setVisible(false);
                break;

            case enseignant:
                Enseignant en = (Enseignant) U;

                file = new File("src/controler/admin/images/teacher.png");
                Img.setImage(new Image(file.toURI().toString()));

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

                LabelSection.setVisible(false);
                section.setVisible(false);
                LabelScore.setVisible(false);
                score.setVisible(false);
                break;

//            case universite:
//Universite e = (Universite) U;
//            File file = new File("src//controler/adminimages/teacher.png");
//            Img.setImage(new Image(file.toURI().toString()));
//            LabelSection.setText("Universite");
//            prenom.setVisible(false);
//            LabelScore.setText("Universite");
//            labelNom.setText("Titre");
//                break;
             default:
                 System.out.println("EROOOORRRREEEE");
                 break;

        }
        
        if (type == 1) {
            role.setText("Add");
        }
        if (type == 2) {
            nom.setText(U.getNom());
            phone.setText(String.valueOf(U.getPhone()));
            prenom.setText(U.getPrenom());
            email.setText(U.getEmail());
            carteBancaire.setText(U.getCarte_banq());
            psw.setText(U.getPwd());
            // section.setText(u.get);
            // score.setText(u.get);
        }
        // typeUser.setItems(types);
        typeBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            // System.out.println(newValue);
            roleEnum = roleEnum.value(newValue.toString());
            // System.out.println("role = " + role.toString());
            if (roleEnum == Role.etudiant) {
                labelsection.setText("Section");
                labelscore.setText("Score");

                labelscore.setVisible(true);
                score.setVisible(true);

                // labelscore.setText("Score");
                // labelscore.setText("Score");
                // Etudiant e = (Etudiant) u;
                // section.setText(e.getSection());
                // score.setText(String.valueOf(e.getScore()));
                // File file = new File("src/dashboard/images/student.jpg");
                // Img.setImage(new Image(file.toURI().toString()));
            }
            if (roleEnum == Role.Recruteur) {
//                Recruteur r = new Recruteur (U);
                File filee = new File("src/dashboard/images/recruitment.png");
                Img.setImage(new Image(filee.toURI().toString()));
                labelsection.setText("Societe");

                labelscore.setVisible(false);
                score.setVisible(false);

            }
            if (roleEnum == Role.enseignant) {
//                Enseignant e = (Enseignant) U;
                File filee = new File("src/dashboard/images/teacher.png");
                Img.setImage(new Image(filee.toURI().toString()));

                labelsection.setText("Section");
                labelscore.setText("Universite");

                labelscore.setVisible(true);
                score.setVisible(true);

                // score.setText(e.getUniversite());
            }
            if ((roleEnum) == Role.universite) {
                // Universite uni = (Universite) U;
                System.out.println("hello");
                File filee = new File("src/dashboard/images/teacher.png");
                Img.setImage(new Image(filee.toURI().toString()));
                //LabelSection.setText("Universite");
                prenom.setVisible(false);
                //  LabelScore.setText("Universite");
                labelNom.setText("Titre");
                labelNom.setStyle("display:none;");
            }
            if (roleEnum == Role.admin) {
                File filee = new File("src/dashboard/images/admin.png");
                Img.setImage(new Image(filee.toURI().toString()));
                
                labelscore.setText("Universite");
                labelscore.setVisible(true);

                labelsection.setVisible(false);
                section.setVisible(false);
            }
            if (roleEnum == Role.empty) {

                labelscore.setVisible(false);
                labelsection.setVisible(false);

                section.setText("");
                score.setText("");
            }

        });

        // ***
        // typeBox.valueProperty().addListener(new ChangeListener<String>() {
    }

    @FXML
    private void confirmClicked(ActionEvent event) throws IOException {
        User x = new User();
        x.setNom(nom.getText());
        x.setPrenom(prenom.getText());
        x.setPhone(Integer.parseInt(phone.getText()));
        x.setEmail(email.getText());
        x.setCarte_banq(carteBancaire.getText());
        x.setPwd(psw.getText());
        // System.out.println(x);
        if (type == 1) {
//            sU.add(x);
            switch (roleEnum) {
                case etudiant:
//                    User obj = new Etudiant();
                    Etudiant e = new Etudiant(x);
                    e.setSection(section.getText());
                    e.setScore(Integer.parseInt(score.getText()));

                    System.out.println("obj = " + x);
                    System.out.println("e = " + e);

                    sE.add(e);
                    break;
                case enseignant:
                    Enseignant en = new Enseignant(x);
                    en.setSection(section.getText());
//                    en.setUniversite(u.getText());
                    sEn.add(en);
                    break;
                case Recruteur:
                    Recruteur r = new Recruteur(x);
                    r.setsociete(section.getText());
                    sR.add(r);
                    break;
                case admin:
                    sU.add(x);
                    break;

                default:
                    break;
            }
        }
        if (type == 2) {
            x.setId(U.getId());
            sU.update(x);
        }
        // HomeController Close = new HomeController();
        // Close.reload(event);
        // //LOGOUT ***
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
