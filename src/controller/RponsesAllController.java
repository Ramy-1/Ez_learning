/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Reponses;
import model.questions;
import services.serviceReponsesQ;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class RponsesAllController implements Initializable {

    @FXML
    private ScrollPane Scrollepane;
    @FXML
    private VBox pnl_scroll;
    
    questions Q;
    Reponses r;
    serviceReponsesQ srQ= new serviceReponsesQ();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getReponseByQuestion();
    } 
    
    public void getReponseByQuestion(){
        pnl_scroll.getChildren().clear();
        System.out.println(Q.getId());
         List<Reponses> listR = srQ.getReponseByQuestion(Q.getId());
         
          Node[] nodes = new Node[listR.size()];
        int i = 0;
        
        for (Reponses each : listR) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReponseItem.fxml"));
            ReponseItemController cont = new ReponseItemController();
            try {
              cont.r=each;
              cont.q=this.Q;
                loader.setController(cont);
                nodes[i] = (Node) loader.load();
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }
        @FXML
    public void AddClicked(ActionEvent event) throws IOException {
        EditReponseItemController cont = new EditReponseItemController();

        cont.type=1;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditReponseItem.fxml"));
        loader.setController(cont);
        cont.Q=this.Q;
        cont.R=this.r;
//        mainAnchor = loader.load();

        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(loader.load()));
        stage.show();

//        pnl_scroll.getChildren().add(FXMLLoader.load(getClass().getResource("EditItem.fxml")));
    }
    
}
