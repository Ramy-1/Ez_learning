/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Reponses;
import model.Test;
import model.questions;
import services.serviceQuestion;
import services.serviceReponsesQ;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class EditReponseItemController implements Initializable {
    @FXML
    private TextField contenu;
    @FXML
    private TextField note;
    
    @FXML
    private ComboBox comboQuestion;
    @FXML
    private CheckBox correct;
    Reponses R;
    questions Q;
    serviceReponsesQ srQ= new serviceReponsesQ();
    serviceQuestion sQ= new serviceQuestion();
    int type = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<questions> listC = sQ.getAll();
       int i=0;
       comboQuestion.getItems().clear();
       Node[] nodes = new Node[listC.size()];
       for (questions each : listC) {
           comboQuestion.getItems().add(listC.get(i));
           i++;
        }    
        
        
       comboQuestion.getSelectionModel().select(Q);
        if(type==1){
        }
        if(type==2){
            contenu.setText(R.getContenu());
            note.setText(String.valueOf(R.getNote()));
            boolean c = R.isCorrect();
            System.out.println(c);
            if(c){
                 correct.isSelected();
            }
            questions ques = sQ.getById(Q.getTestid());
        }
    } 
    
    @FXML
    private void confirmClicked(ActionEvent event) {
         Reponses tc = new Reponses();
        tc.setContenu(contenu.getText());
        questions ques =(questions) comboQuestion.getSelectionModel().getSelectedItem();
        tc.setQuestion(ques.getId());
        
        if(correct.isSelected()){
            tc.setCorrect(true);
        }
        else{
            tc.setCorrect(false);
        }
        tc.setNote(parseInt(note.getText()));
        
        
        if(type==1){
            srQ.add(tc);
        }
        if(type==2){
            tc.setId(R.getId());
            srQ.update(tc);
        }
         
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
}
