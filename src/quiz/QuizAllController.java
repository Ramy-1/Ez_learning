/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package quiz;

import controller.HomeController;
import controller.ReponseItemController;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.Reponses;
import model.questions;
import services.serviceQuestion;
import services.serviceReponsesQ;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class QuizAllController implements Initializable {

    @FXML
    private ScrollPane Scrollepane;
    @FXML
    private VBox pnl_scroll;
    serviceQuestion sQ= new serviceQuestion();
    serviceReponsesQ srQ= new serviceReponsesQ();
    
    questions Q;
    int k=0;
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
//        System.out.println(Q.getId());
         List<questions> listR = sQ.getByTestId(1);
         
          Node[] nodes = new Node[listR.size()];
        int i = 0;
        
        for (questions each : listR) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("QuizItem.fxml"));
            QuizItemController cont = new QuizItemController();
            try {
                cont.size= i+1;
              cont.q=each;
             
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
