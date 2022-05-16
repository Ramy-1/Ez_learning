/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cours;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.Cours;
import services.serviceCours;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class ItemController implements Initializable {

    @FXML
    private HBox itemC;
    @FXML
    private Label labelTitreItem;
    @FXML
    private Label labelDescriptionItem;
    @FXML
    private Label labelDate;
    @FXML
    private Label labeltime;
    Cours c;
    serviceCours sc = new serviceCours();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        Date date = c.getDatecreate();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
                String strDate = dateFormat.format(date); 
        labelTitreItem.setText(c.getTitre());
        labelDate.setText(strDate);
        labeltime.setText(Integer.toString(c.getDuree()));
        //labelDescriptionItem.setText(c.getDescription());    
    }    
    public void ItemClicked() throws IOException{
         System.out.println("hello");
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/cours/courEtudiant.fxml"));
          
         CourEtudiantController cec =new CourEtudiantController();
         loader.setController(cec);
       
         System.out.println(cec.labelTitre.getText());

       
    }
}
