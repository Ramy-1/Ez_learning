/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cours;

import controller.HomeController;
import controller.ReponseItemController;
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
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.Reponses;
import model.ResultatReponse;
import model.Test;
import model.questions;
import services.serviceQuestion;
import services.serviceReponsesQ;
import services.serviceResultatReponse;

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
    serviceResultatReponse srr= new serviceResultatReponse();
    questions Q;
    int k=0;
    int i = 0;
    Test T;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        getReponseByQuestion();
getQuestionsByTest();

    }
    public void getQuestionsByTest(){
        List<questions> listq = sQ.getByTestIdStudent(T.getId());
        //System.out.println(listq);
        Node[] nodes = new Node[listq.size()];
        
        for (questions each : listq) {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("QuizItem.fxml"));
             QuizItemController cont = new QuizItemController();
             try {
               cont.i=this.i+1;
                cont.q=each;
                cont.test=T;
                loader.setController(cont);
                nodes[i] = (Node) loader.load();
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }
    public void getReponseByQuestion(){
        pnl_scroll.getChildren().clear();
//        System.out.println(Q.getId());
         List<questions> listq = sQ.getByTestId(T.getId());
         
       //   Node[] nodes = new Node[listR.size()];
        int i = 0;
        
     /*   for (questions each : listR) {
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
        }*/
    }
    @FXML
    private void submittest(ActionEvent event) {
        List<ResultatReponse> listr =srr.getReponsesByTestAndUser(T.getId(),1);
        int note=0;
         for(ResultatReponse each: listr){
             
             note =+ each.getNote();
         }
         srr.submit(1, T.getId(), note);
    }
}
