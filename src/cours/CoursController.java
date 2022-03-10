/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cours;

import controller.HomeController;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.Categorie;
import model.Cours;
import services.serviceCategorie;
import services.serviceCours;
import util.MyConnection;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class CoursController implements Initializable {
    public Connection myConnection = MyConnection.getInstance2();
    serviceCours sC =new serviceCours();
 
    serviceCategorie sCt =new serviceCategorie();
    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox pnl_scroll;
    
     @FXML
    private Button btnFilter;
      @FXML
    private ComboBox comboFilter;
      @FXML
    private Button btnIt;
      @FXML
    private Button btnMarketing;
      @FXML
    private Button btnDev;
      @FXML
    private Button btnDesign;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // setData();
        pnl_scroll.setSpacing(5);
         List<Cours> listU = sC.getAll();
        // TODO
      pnl_scroll.setOnMouseClicked(events -> {
          events.getClickCount();
          Cours item = listU.get(events.getClickCount());    
       });
       scroll.setOnMouseClicked(events -> {
      
       });

        //System.out.println(listU);
        Node[] nodes = new Node[listU.size()];
        int i = 0;

        for (Cours each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cours/ItemCours.fxml"));
            ItemCoursController cont = new ItemCoursController();
            try {
                cont.c=each;
                loader.setController(cont);
                nodes[i] = (Node) loader.load();
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }
int i = 0;
    public void setData(){
        List<Categorie> listC = sCt.getAll();
       
       comboFilter.getItems().clear();
       Node[] nodes = new Node[listC.size()];
       for (Categorie each : listC) {
           comboFilter.getItems().add(listC.get(i));
           i++;
        }

    }
    public void handClicks(ActionEvent events){
         if (events.getSource() == btnIt) {
               List<Categorie> listC = sCt.getDomaine("IT");
       
                comboFilter.getItems().clear();
                Node[] nodes = new Node[listC.size()];
            for (Categorie each : listC) {
                comboFilter.getItems().add(listC.get(i));
                i++;
            }
         }
         if (events.getSource() == btnDev) {
             List<Categorie> listC = sCt.getDomaine("Dev");
       
                comboFilter.getItems().clear();
                Node[] nodes = new Node[listC.size()];
            for (Categorie each : listC) {
                comboFilter.getItems().add(listC.get(i));
                i++;
            }
         }
         if (events.getSource() == btnMarketing) {
             List<Categorie> listC = sCt.getDomaine("Marketing");
       
                comboFilter.getItems().clear();
                Node[] nodes = new Node[listC.size()];
            for (Categorie each : listC) {
                comboFilter.getItems().add(listC.get(i));
                i++;
            }
         }
         if (events.getSource() == btnDesign) {
             List<Categorie> listC = sCt.getDomaine("Design");
       
                comboFilter.getItems().clear();
                Node[] nodes = new Node[listC.size()];
            for (Categorie each : listC) {
                comboFilter.getItems().add(listC.get(i));
                i++;
            }
         }
    }
    public void getCoursByCategorie() {
        Categorie categorie = (Categorie) comboFilter.getSelectionModel().getSelectedItem();
        pnl_scroll.getChildren().clear();
        List<Cours> listC = sC.getCoursByCategorie(categorie.getIdcat());
        Node[] nodes = new Node[listC.size()];
        for (Cours each : listC) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cours/ItemCours.fxml"));
            ItemCoursController cont = new ItemCoursController();
            try {                
                loader.setController(cont);
                nodes[i] = (Node) loader.load();
                pnl_scroll.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
      
    }
   
    
    
    
    
}
