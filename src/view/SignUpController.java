/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view;

import co.yogesh.Captcha;

import helper.AlertHelper;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JLabel;
import model.Etudiant;
import model.Role;
import model.User;
import services.ServiceEtudiant;
import services.ServiceUser;
import util.MyConnection;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class SignUpController implements Initializable {

    @FXML
    private Button signupbtn;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txttel;
    @FXML
    private PasswordField txtmdp;
    @FXML
    private PasswordField txtmdp1;

    Window window;
    @FXML
    private JLabel captchalabel;
    @FXML
    private TextField captchaInput;
    @FXML
    private TextField txtnom1;
    @FXML
    private ImageView captchagenerate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        Captcha cap = new Captcha();
//// label = new JLabel();
//        cap.setImageCaptcha(captchalabel);
//        captchagenerate.setImage(SwingFXUtils.toFXImage(NewFXMain.iconToImage(captchalabel.getIcon()), null));
    }


    public void Signup(ActionEvent event) throws IOException, NoSuchAlgorithmException {


        if (this.isValidated()) {
            PreparedStatement ps;
            Etudiant e = new Etudiant();

            User u = new User();
            u.setName(txtnom.getText());
            u.setLast_name(txtprenom.getText());
            u.setEmail(txtemail.getText());
            u.setPassword(txtmdp.getText());
            u.setRole(Role.etudiant);
            u.SignUp();

            ServiceEtudiant sE = new ServiceEtudiant();

            sE.add(e);
            AlertHelper.showAlert(Alert.AlertType.INFORMATION, window, "Information",
                    "register avec succee.");
            Stage stage = (Stage) signupbtn.getScene().getWindow();
            stage.close();

            Parent root = FXMLLoader.load(getClass().getResource("/main/Main.fxml"));
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);

            stage.setTitle("Admin Panel");
            // stage.getIcons().add(new Image("/asset/icon.png"));
            stage.show();

        }
    }

    private boolean isValidated() {

        window = signupbtn.getScene().getWindow();
        if (txtemail.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Entree votre email.");
            txtemail.requestFocus();
        } else if (txtmdp.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Entree votre mot de passe");
            txtmdp.requestFocus();

        } else if (!txtmdp.getText().equals(txtmdp1.getText())) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Mot de passe different");
            txtmdp1.requestFocus();
        } else if (txtnom.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Entree votre nom");
            txtnom.requestFocus();

        } else if (txtprenom.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Entree votre prenom");
            txtprenom.requestFocus();

        } else if (txttel.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Entree votre numero de telephone");
            txttel.requestFocus();

        } else if (txtmdp.getText().length() < 5 || txtmdp.getText().length() > 25) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Mot de passe doit etre supperieure à 5 caracteres.");
            txtmdp.requestFocus();
        } else {
            return true;
        }
        return false;
    }
}
