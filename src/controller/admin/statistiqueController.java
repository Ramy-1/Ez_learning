/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.serviceReclamation;
import services.servicereponse;
/**
 * FXML Controller class
 *
 * @author Nabil
 */
public class statistiqueController implements Initializable {

    @FXML
    private AnchorPane mainAnchor;
    @FXML
    private PieChart pieChart;
    @FXML
    private Button annulerbtn;

    serviceReclamation sr = new serviceReclamation();
    servicereponse srp = new servicereponse();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Reclamations", sr.calculreclamations()),
                        new PieChart.Data("Reclamations traitées", srp.calculreponserec()));
                       


        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty()
                        )
                )
        );

        pieChart.getData().addAll(pieChartData);
    }  


// TODO
    

    @FXML
    private void annuler(ActionEvent event) {
      final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
}
