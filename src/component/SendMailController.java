/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import helper.AlertHelper;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Window;
import model.User;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author mrram
 */
public class SendMailController implements Initializable {

    @FXML
    private ImageView Img;
    @FXML
    private Label role;
    @FXML
    private Label labelNom;
    @FXML
    private Label LabelScore;
    @FXML
    private TextArea body;
    @FXML
    private TextArea subject;
    @FXML
    private Label labelNom1;
    @FXML
    private TextField mail;
    @FXML
    private Button confirm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void confirmClicked(ActionEvent event) {
        String Suj = subject.getText();
        String Body = body.getText();
        String mail = this.mail.getText();
        ServiceUser sU = new ServiceUser();

        Window window;
        window = confirm.getScene().getWindow();
        try {

            User u = new User();
            u = sU.getByMail(mail);

            if (u.getId() == 0) {
                AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                        "Mail invalide.");
//                username.requestFocus();
            } else {
                new SendEmail(u, Suj, Body);
            }
        } catch (Exception e) {

        }
    }

    @FXML
    private void sendToAllClicked(ActionEvent event) {
        ServiceUser sU = new ServiceUser();
        String Suj = subject.getText();
        String Body = body.getText();
        String mail = this.mail.getText();
        sU.getAll().stream().forEach(x -> new SendEmail(x, Suj, Body));
    }

}
