/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cours;

import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Reponses;
import model.ResultatReponse;
import model.questions;
import services.serviceReponsesQ;
import services.serviceResultatReponse;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class QuizItemController implements Initializable {

    @FXML
    private Text qNo;
    @FXML
    private Text questions;
    @FXML
    private JFXRadioButton b1;
    @FXML
    private JFXRadioButton b4;
    @FXML
    private JFXRadioButton b3;
    @FXML
    private JFXRadioButton b2;
    @FXML
    private Button btnadd;
     Reponses r;
    questions q;
    serviceReponsesQ srq= new serviceReponsesQ();
    int size=0;
    final int i=0;
    serviceResultatReponse srr= new serviceResultatReponse();
    serviceReponsesQ srQ= new serviceReponsesQ();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        int i=0;
        questions.setText(q.getContenu());
       
            qNo.setText(String.valueOf(size));
        
        
       List<Reponses> listr =srq.getReponseByQuestion(q.getId());
        int size = listr.size();
        
        if(size==0){
              b1.setVisible(false);
              b2.setVisible(false);
              b3.setVisible(false);
              b4.setVisible(false);
          }
        
       for(Reponses each : listr){
           
           System.out.println( );
           /*btnadd.setOnAction(e -> {
             
            });*/
          if(size==1){
              b1.setText(listr.get(i).getContenu());
              b2.setVisible(false);
              b3.setVisible(false);
              b4.setVisible(false);
          }
          if(size==2){
              
              b1.setText(listr.get(i).getContenu());
              b2.setText(listr.get(i+1).getContenu());
              b3.setVisible(false);
              b4.setVisible(false);
          }
          if(size==3){
               b1.setText(listr.get(i).getContenu());
              b2.setText(listr.get(i+1).getContenu());
              b3.setText(listr.get(i+2).getContenu());
              b4.setVisible(false);
          }
          if(size==4){
              b1.setText(listr.get(i).getContenu());
              b2.setText(listr.get(i+1).getContenu());
              b3.setText(listr.get(i+2).getContenu());
              b4.setText(listr.get(i+3).getContenu());
          }
         
       }
    
        
    }    

    @FXML
    private void groupAction(ActionEvent event) {
    }
    
    @FXML
    private void add(ActionEvent event) {
        List<Reponses> listr = srQ.getReponseByQuestion(q.getId());
        
        for(Reponses each: listr){
            ResultatReponse rr= new ResultatReponse();
        
                rr.setReponseid(each.getId());
                if(b1.isSelected()){
                    rr.setNotereponse(each.getNote());
                }
                if(b2.isSelected()){
                    rr.setNotereponse(each.getNote());
                }
                if(b3.isSelected()){
                    rr.setNotereponse(each.getNote());
                }
                if(b4.isSelected()){
                    rr.setNotereponse(each.getNote());
                }
                rr.setQuestion(each.getQuestion());
                srr.add(rr);
        }
    }
    
}
