/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cours;

import controller.Universite.HomeController;
import cours.ItemController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventTarget;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Cours;
import model.Enseignant;
import model.Universite;
import model.User;
import services.ServiceEns;
import services.serviceCours;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class CourEtudiantController implements Initializable {
    
    serviceCours sC =new serviceCours();
    
    @FXML
    private VBox pnl_scroll;
   @FXML
    private AnchorPane anchorCour;
   
   @FXML
    private ScrollPane scroll;
   @FXML
   public Label labelTitre;
   @FXML
   public Text labeldescription;
   @FXML
   public Label labelformateur;
   
   @FXML
   public TextField fieldSearch;
   @FXML
   Button btnsearch;
   
   @FXML
   Button btnIt;
   
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pnl_scroll.setSpacing(5);
       
         List<Cours> listU = sC.getAll();
        // TODO
       // refreshNodes();
       
      pnl_scroll.setOnMouseClicked(events -> {
          events.getClickCount();
             Cours item = listU.get(events.getClickCount());
             
            int i = events.getClickCount();
            // System.out.println(pnl_scroll.getChildren().get(i).));
            labelTitre.setText(item.getTitre());
            labeldescription.setText(item.getDescription());
           // labelformateur.setText(item.getFormateurid().getNom());
       });
       scroll.setOnMouseClicked(events -> {     
       });
        //System.out.println(listU);
        Node[] nodes = new Node[listU.size()];
        int i = 0;
        for (Cours each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cours/Item.fxml"));
            ItemController cont = new ItemController();
            try {
                cont.c=each;
                loader.setController(cont);
                nodes[i] = (Node) loader.load();
                pnl_scroll.getChildren().add(nodes[i]);
              //  scroll.getContent()
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }
    
    public void OnclickShow(){
        
    }

/*private void refreshNodes() {
        pnl_scroll.getChildren().clear();

        List<Cours> listU = sC.getAll();
        Node[] nodes = new Node[listU.size()];
        int i = 0;

        for (Cours each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cours/ItemCours.fxml"));
            ItemCoursController cont = new ItemCoursController();
            try {
                
                loader.setController(cont);

                nodes[i] = (Node) loader.load();

                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    } */   
    
    
    public void getItem(String s){
        labelTitre.setText(s);
     
        
    }
    
    public void SearchCoursActionn(){
        pnl_scroll.getChildren().clear();
        String s = fieldSearch.getText();
        List<Cours>Listcour = (List<Cours>) sC.SearchCours(s);
        
        Node[] nodes = new Node[Listcour.size()];
        int i = 0;
        for (Cours each : Listcour) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cours/Item.fxml"));
            ItemController cont = new ItemController();
            try {
                cont.c=each;
                loader.setController(cont);
                nodes[i] = (Node) loader.load();
                pnl_scroll.getChildren().add(nodes[i]);
              //  scroll.getContent()
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
        
    }
    
    public void handClicks(ActionEvent events){
         if (events.getSource() == btnIt) {}
    }
    
}
