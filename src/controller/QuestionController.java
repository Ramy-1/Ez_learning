/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Test;
import model.questions;
import services.serviceQuestion;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class QuestionController implements Initializable {
    serviceQuestion sQ= new serviceQuestion();
    @FXML
    private VBox pnl_scroll;
    
    questions Q;
    Test t;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         getQuestionByTest();
   
    }

    public void getQuestionByTest(){
        pnl_scroll.getChildren().clear();
         List<questions> listQ = sQ.getByTestId(t.getId());
         
          Node[] nodes = new Node[listQ.size()];
        int i = 0;
        
        for (questions each : listQ) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("QuestionItem.fxml"));
            QuestionItemController cont = new QuestionItemController();
            try {
              cont.q=each;
              cont.ts=this.t;
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
        EditQuestionItemController cont = new EditQuestionItemController();

        cont.type=1;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditQuestionItem.fxml"));
        loader.setController(cont);
//        mainAnchor = loader.load();

        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(loader.load()));
        stage.show();

//        pnl_scroll.getChildren().add(FXMLLoader.load(getClass().getResource("EditItem.fxml")));
    }
    
}
