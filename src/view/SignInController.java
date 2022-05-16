/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view;

import helper.AlertHelper;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import model.Role;
import model.User;
import services.ServiceUser;
import util.MyConnection;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class SignInController implements Initializable {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    Window window;

    private double x, y;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private boolean isValidated() {

        window = loginButton.getScene().getWindow();
        if (username.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Username text field cannot be blank.");
            username.requestFocus();
        } else if (username.getText().length() < 5 || username.getText().length() > 25) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Username text field cannot be less than 5 and greator than 25 characters.");
            username.requestFocus();
        } else if (password.getText().equals("")) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Password text field cannot be blank.");
            password.requestFocus();
        } else if (password.getText().length() < 5 || password.getText().length() > 25) {
            AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                    "Password text field cannot be less than 5 and greator than 25 characters.");
            password.requestFocus();
        } else {
            return true;
        }
        return false;
    }

    public void SignIn(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        if (this.isValidated()) {
            PreparedStatement ps;
            ResultSet rs;

            User u = new User();

            System.out.println((u.Login(username.getText(), password.getText())));
            if (u.Login(username.getText(), password.getText())) {

                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();

                Stage stage2 = new Stage();
                ServiceUser sU = new ServiceUser();
                u = sU.getByMail(username.getText());
                Role r = u.getRole();
//                r = Role.admin;
                System.out.println("role = " + r);
                Parent root;
                Scene scene;
                switch (r) {
                    case admin:
//                        root = FXMLLoader.load(getClass().getResource("/etudiant/dashboardEtudiant.fxml"));
                        root = FXMLLoader.load(getClass().getResource("/controller/admin/Home.fxml"));

                        scene = new Scene(root);
                        // scene.setFill(Color.TRANSPARENT);
                        stage2.setScene(scene);
                        // stage2.initStyle(StageStyle.UNDECORATED);
                        // stage2.initStyle(StageStyle.TRANSPARENT);
                        stage2.setTitle("Admin Panel");
                        // drag it here
                        root.setOnMousePressed(events -> {
                            x = events.getSceneX();
                            y = events.getSceneY();
                        });
                        root.setOnMouseDragged(events -> {

                            stage2.setX(events.getScreenX() - x);

                            stage2.setY(events.getScreenY() - y);

                        });
                        stage2.show();
                        break;
                    case societe:
                        root = FXMLLoader.load(getClass().getResource("/controller/societe/Home.fxml"));
                        scene = new Scene(root);
                        // scene.setFill(Color.TRANSPARENT);
                        stage2.setScene(scene);
                        // stage2.initStyle(StageStyle.UNDECORATED);
                        // stage2.initStyle(StageStyle.TRANSPARENT);
                        stage2.setTitle("Admin Panel");
                        // drag it here
                        root.setOnMousePressed(events -> {
                            x = events.getSceneX();
                            y = events.getSceneY();
                        });
                        root.setOnMouseDragged(events -> {

                            stage2.setX(events.getScreenX() - x);

                            stage2.setY(events.getScreenY() - y);

                        });
                        stage2.show();
                        break;

                    case etudiant:
//                        root = FXMLLoader.load(getClass().getResource("/controller/societe/Home.fxml"));
                        root = FXMLLoader.load(getClass().getResource("/etudiant/dashboardEtudiant.fxml"));

                        scene = new Scene(root);
                        // scene.setFill(Color.TRANSPARENT);
                        stage2.setScene(scene);
                        // stage2.initStyle(StageStyle.UNDECORATED);
                        // stage2.initStyle(StageStyle.TRANSPARENT);
                        stage2.setTitle("Admin Panel");
                        // drag it here
                        root.setOnMousePressed(events -> {
                            x = events.getSceneX();
                            y = events.getSceneY();
                        });
                        root.setOnMouseDragged(events -> {

                            stage2.setX(events.getScreenX() - x);

                            stage2.setY(events.getScreenY() - y);

                        });
                        stage2.show();
                        break;
                    case universite:
                        root = FXMLLoader.load(getClass().getResource("/controller/Universite/Home.fxml"));
                        scene = new Scene(root);
                        // scene.setFill(Color.TRANSPARENT);
                        stage2.setScene(scene);
                        // stage2.initStyle(StageStyle.UNDECORATED);
                        // stage2.initStyle(StageStyle.TRANSPARENT);
                        stage2.setTitle("Admin Panel");
                        // drag it here
                        root.setOnMousePressed(events -> {
                            x = events.getSceneX();
                            y = events.getSceneY();
                        });
                        root.setOnMouseDragged(events -> {

                            stage2.setX(events.getScreenX() - x);

                            stage2.setY(events.getScreenY() - y);

                        });
                        stage2.show();
                        break;

                    default:
                        break;
                }
            } else {
                AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
                        "login incorrect");
            }

            // String query = "select * from user WHERE email = ? and pwd = ?";
            // try {
            // if (rs.next()) {
            // Stage stage = (Stage) loginButton.getScene().getWindow();
            // stage.close();
            // int colind = rs.findColumn("role");
            // System.out.println(colind);
            // Object role = rs.getObject(colind);
            // System.out.println(role);
            // Stage stage2 = new Stage();
            // if (role.toString().equals("admin")) {
            // Parent root =
            // FXMLLoader.load(getClass().getResource("/controller/Home.fxml"));
            // /*
            // * FXMLLoader loader = new
            // * FXMLLoader(getClass().getResource("/components/dashboard.fxml"));
            // * BorderPane borderpane = (BorderPane) loader.load();
            // * Node menu =
            // * FXMLLoader.load(getClass().getResource("/components/admin.fxml"));
            // *
            // * borderpane.setLeft(menu);
            // */
            // Scene scene = new Scene(root);
            // scene.setFill(Color.TRANSPARENT);
            // stage2.setScene(scene);
            // stage2.initStyle(StageStyle.UNDECORATED);
            // stage2.initStyle(StageStyle.TRANSPARENT);
            // stage2.setTitle("Admin Panel");
            // // drag it here
            // root.setOnMousePressed(events -> {
            // x = events.getSceneX();
            // y = events.getSceneY();
            // });
            // root.setOnMouseDragged(events -> {
            // stage2.setX(events.getScreenX() - x);
            // stage2.setY(events.getScreenY() - y);
            // });
            // stage2.show();
            // } else if (role.toString().equals("student")) {
            // Parent root =
            // FXMLLoader.load(getClass().getResource("/etudiant/dashboardEtudiant.fxml"));
            // Scene scene = new Scene(root);
            // stage.setScene(scene);
            // stage.setTitle("Student Panel");
            // stage.show();
            // } else if (role.toString().equals("recruter")) {
            // } else if (role.toString().equals("university")) {
            // } else {
            // FXMLLoader loader = new
            // FXMLLoader(getClass().getResource("/dashboard/dashboard.fxml"));
            // BorderPane borderpane = (BorderPane) loader.load();
            // Node menu = FXMLLoader.load(getClass().getResource("/Menu/formateur.fxml"));
            // // MainPanelController mwc = loader.getController();
            // borderpane.setLeft(menu);
            // Scene scene = new Scene(borderpane);
            // stage.setScene(scene);
            // stage.setTitle("Admin Panel");
            // stage.show();
            // }
            // // Parent root =
            // // FXMLLoader.load(getClass().getResource("/view/MainPanelView.fxml"));
            // } else {
            // AlertHelper.showAlert(Alert.AlertType.ERROR, window, "Error",
            // "Verifier votre email et mot de passe.");
            // username.requestFocus();
            // }
            // } catch (SQLException ex) {
            // System.out.println(ex);
            // }
        }
    }
}
