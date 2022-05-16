/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.societe;

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
import static model.Role.societe;
import model.Universite;
import model.User;
import model.societe;
import services.ServiceEns;
import services.ServiceEtudiant;
import services.ServiceRecruteur;
import services.ServiceUser;
import services.serviceSociete;
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

    File file;
    @FXML
    private Label LabelBanq;
    @FXML
    private Label LablePhone;

    void roleController(Role r) {
        switch (r) {
            case etudiant:
                file = new File("src/controller/admin/images/student.jpg");
                Img.setImage(new Image(file.toURI().toString()));

                Etudiant e = new Etudiant(U);
                e = new Etudiant(sE.getById(U.getId()));

                LabelSection.setText("Section");
                section.setText(e.getSection());

                LabelScore.setText("Score");
                score.setText(String.valueOf(e.getScore()));
                LabelScore.setVisible(true);
                score.setVisible(true);
                break;

            case Recruteur:
                file = new File("src/controller/admin/images/recruitment.png");
                Img.setImage(new Image(file.toURI().toString()));

                Recruteur rec = new Recruteur(U);
                rec = sR.getById(U.getId());

                LabelSection.setText("Societe");
                section.setText(rec.getsociete());

                LabelScore.setVisible(false);
                score.setVisible(false);
                break;

            case enseignant:
                Enseignant en = new Enseignant(U);

                en = sEn.getById(U.getId());
                file = new File("src/controller/admin/images/teacher.png");
                Img.setImage(new Image(file.toURI().toString()));

                LabelSection.setText("Section");
                section.setText(en.getSection());

                LabelScore.setText("Universite");
                score.setText(en.getUniversite());
                LabelScore.setVisible(true);
                score.setVisible(true);
                break;

            case admin:

                file = new File("src/controller/admin/images/admin.png");
                Img.setImage(new Image(file.toURI().toString()));

                U.setRole(Role.admin);
                LabelSection.setVisible(false);
                section.setVisible(false);
                LabelScore.setVisible(false);
                score.setVisible(false);
                break;

            case universite:
//                Universite uni = Universite (U);
                file = new File("src/controller/adminimages/teacher.png");
                Img.setImage(new Image(file.toURI().toString()));
//                LabelSection.setText("Universite");
                prenom.setVisible(false);
                carteBancaire.setVisible(false);
                LabelSection.setVisible(false);
                section.setVisible(false);
                LabelScore.setVisible(false);
                score.setVisible(false);
                phone.setVisible(false);

//                LabelScore.setText("Universite");
//                labelNom.setText("Titre");
                break;
            case societe:
//                Universite uni = Universite (U);
                file = new File("src/controller/adminimages/admin.png");
                Img.setImage(new Image(file.toURI().toString()));
//                LabelSection.setText("Universite");
//                prenom.setVisible(false);
//                carteBancaire.setVisible(false);
                LabelSection.setVisible(false);
                section.setVisible(false);
                LabelScore.setVisible(false);
                score.setVisible(false);
//                phone.setVisible(false);
                LablePhone.setText("idsoc");
                LabelBanq.setText("img");
                labelPrenom.setText("addresse");

//                LabelScore.setText("Universite");
//                labelNom.setText("Titre");
                break;
            default:
                System.out.println("empty");
                break;

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList types = FXCollections.observableArrayList("Etudiant", "Enseignant", "Recruteur", "Admin",
                "universite", "societe");
        typeBox.getItems().addAll(types);

        U.setRole(roleEnum);
        roleController(roleEnum);

        if (type == 1) {
            role.setText("Add");
        }
        if (type == 2) {
//            nom.setText(U.getNom());
//            phone.setText(String.valueOf(U.getPhone()));
//            prenom.setText(U.getPrenom());
//            email.setText(U.getEmail());
//            carteBancaire.setText(U.getCarte_banq());
//            psw.setText(U.getPwd());
//            U.setRole(roleEnum);
//            roleController(roleEnum);
            // section.setText(u.get);
            // score.setText(u.get);
        }
        // typeUser.setItems(types);
        typeBox.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            System.out.println(newValue);
            roleEnum = roleEnum.value(newValue.toString());
            System.out.println("role = " + roleEnum.toString());
            roleController(roleEnum);
        });

        // ***
        // typeBox.valueProperty().addListener(new ChangeListener<String>() {
    }

    @FXML
    private void confirmClicked(ActionEvent event) throws IOException {
        User x = new User();
//        x.setNom(nom.getText());
//        x.setPrenom(prenom.getText());
//        x.setPhone(Integer.parseInt(phone.getText()));
//        x.setEmail(email.getText());
//        x.setCarte_banq(carteBancaire.getText());
//        x.setPwd(psw.getText());
        // System.out.println(x);
        if (type == 1) {
            // sU.add(x);
            switch (roleEnum) {
                case etudiant:
                    // User obj = new Etudiant();
                    Etudiant e = new Etudiant(x);
                    e.setSection(section.getText());
                    e.setScore(Integer.parseInt(score.getText()));

                    System.out.println("obj = " + x);
                    System.out.println("e = " + e);

                    sE.add(e);
                    break;
                case enseignant:
                    System.out.println("score = " + score.getText() + "/"
                            + "section = " + section.getText());
//                    Enseignant en = new Enseignant(x,score.getText(),section.getText());
                    Enseignant en = new Enseignant(x);
                    en.setName(x.getName());
                    en.setSection(section.getText());
                    en.setUniversite(score.getText());
                    System.out.println("ens = " + en);
                    sEn.add(en);
                    break;
                case Recruteur:
                    Recruteur r = new Recruteur(x);
                    r.setsociete(section.getText());
                    sR.add(r);
                    break;
                case admin:
                    x.setRole(Role.admin);
                    sU.add(x);
                    break;
                case universite:
                    phone.setText("0");
                    Universite un = new Universite(x);
                    System.out.println("uni = " + un);
//                    sU.add(new User(un));
                    serviceUniversite sUni = new serviceUniversite();
                    sUni.ajouterUniversite(un);
                    break;
                case societe:
                    societe s = new societe(x);
                    System.out.println("s = " + s + "/  "
                            + "x = " + x);
//                    sU.add(new User(s));
                    s.setIdsoc(phone.getText());
                    s.setAdresse(prenom.getText());
                    s.setImgsoc(carteBancaire.getText());
                    System.out.println("s = " + s);
                    serviceSociete sS = new serviceSociete();
                    sS.ajouterSociete(s);
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
