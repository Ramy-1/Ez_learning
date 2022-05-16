/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cours;

//import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Reponses;
import model.ResultatReponse;
import model.Test;
import model.questions;
import services.serviceReponsesQ;
import services.serviceResultatReponse;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class QuizItemController implements Initializable {

    /*@FXML
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
    serviceResultatReponse srr= new serviceResultatReponse();*/
    @FXML
    private Label txtTitre;
    @FXML
    private Label txtDescription;
    @FXML
    private Text qNo;
    @FXML
    private VBox vbox;
    Test test;
    questions q;
    int i;
    serviceReponsesQ srQ= new serviceReponsesQ();
    serviceResultatReponse srr =new serviceResultatReponse();
    ToggleGroup toggleGroup = new ToggleGroup();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        System.out.println(q.getContenu());
        String titre = q.getContenu();
        txtTitre.setText(q.getContenu());
        txtDescription.setText(q.getDescription());
        qNo.setText("Q."+i);
        getReponsesByQuestion();
       
    }
    private void getReponsesByQuestion() {
        System.out.println(q);
        List<Reponses> listr = srQ.getReponseByQuestion(q.getId());
        System.out.println(q.getType());
        

        for(Reponses each: listr){
            String type = q.getType();
            if("Multiple".equals(type)){
                CheckBox chb=  new CheckBox(each.getContenu());
                //chb.set
          vbox.getChildren();
          vbox.getChildren().add(chb);
            }
            else{
                 ToggleGroup g = new ToggleGroup();
               
                RadioButton rb= new RadioButton(each.getContenu());
                rb.setToggleGroup(toggleGroup);
                vbox.getChildren().add(rb);
            }
          
        }
    }
    @FXML
    private void Repondre(ActionEvent event) {
        toggleGroup.getSelectedToggle();
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        System.out.println(toogleGroupValue);
       Reponses rep= srQ.getReponseByQuestionAndContent(q.getId(), toogleGroupValue);
       srr.AddReponse(rep.getId(), rep.getQuestion(), test.getId(), 1, rep.isCorrect(), rep.getNote());
    }
    
}
