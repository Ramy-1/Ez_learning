/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Reclamation;
import model.User;
import services.ServiceEns;
import services.ServiceEtudiant;
import services.ServiceRecruteur;
import services.ServiceUser;
import services.serviceReclamation;

/**
 *
 * @author mrram
 */
public class HomeController {

    ServiceUser sU = new ServiceUser();
    ServiceEtudiant sE = new ServiceEtudiant();
    ServiceEns sEn = new ServiceEns();
    ServiceRecruteur sR = new ServiceRecruteur();

    @FXML
    private ScrollPane Scrollepane;
    @FXML
    private VBox pnl_scroll;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private Label lbl_completed;
    @FXML
    private Circle mi;
    @FXML
    private Circle re;
    @FXML
    private Circle close1;

    @FXML
    private void listUserClicked(ActionEvent event) {
        pnl_scroll.getChildren().clear();

        List<User> listU = sU.getAll();
        Node[] nodes = new Node[listU.size()];
        int i = 0;

        for (User each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
            ItemController cont = new ItemController();
            try {
                cont.U = each;
                loader.setController(cont);

                nodes[i] = (Node) loader.load();

                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }

    @FXML
    private void SocieteClicked(ActionEvent event) {
    }

    @FXML
    private void UniversiteClicked(ActionEvent event) {
    }

    @FXML
    private void ReclamationClicked(ActionEvent event) {
        serviceReclamation srr = new serviceReclamation();

        pnl_scroll.getChildren().clear();

        List<Reclamation> listR = srr.afficherReclamation();
        Node[] nodes = new Node[listR.size()];
        int i = 0;

        for (Reclamation each : listR) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller/admin/Reclamation.fxml"));
            ReclamationController cont = new ReclamationController();
            try {
                cont.R = each;
                loader.setController(cont);

                nodes[i] = (Node) loader.load();

                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(controller.admin.HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }

    @FXML
    private void EvenementClicked(ActionEvent event) {
    }

    @FXML
    private void SendEmailClicked(ActionEvent event) {
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
    }

    @FXML
    private void AddClicked(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/controller/admin/EditItem.fxml"));
        EditItemController cont = new EditItemController();
        cont.type=1;
        loader.setController(cont);
//        mainAnchor = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Add User");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    @FXML
    private void MiWindow(MouseEvent event) {
    }

    @FXML
    private void ReWindow(MouseEvent event) {
    }

    @FXML
    private void closeWindow(MouseEvent event) {
    }

}
