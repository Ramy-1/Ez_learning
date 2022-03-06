/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package view;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Test;
import model.societe;

import services.serviceTest;
import util.MyConnection;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class TestAdminController implements Initializable {
    @FXML
    private ListView list;
    @FXML
    private TextField txtTitre;
    @FXML
    private TextArea txtDescription;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        updatelist();
        
      
      
    }

serviceTest st = new serviceTest();
        List<Test> TestC ;
    public void updatelist(){
        
    TestC = st.afficherTest();
    
    for(int i=0;i< TestC.size();i++){
        Test t = TestC.get(i);
        list.getItems().add(t);
    }      
    }


@FXML
    private void Modifiertest(ActionEvent event) {    
        String titre = txtTitre.getText();
        String decription = txtDescription.getText();
        Test S = new Test( titre, decription);
        Test testm = new Test();
        testm =  (Test) list.getSelectionModel().getSelectedItem();
        st.modifierTest(S, testm.getId());
       updatelist();
    }    
    
}
