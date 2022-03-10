/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cours;

import controller.HomeController;
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
import model.Cours;
import model.Test;
import services.serviceTest;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class TestAllController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private VBox pnl_scroll;
    serviceTest st =new serviceTest();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         pnl_scroll.setSpacing(5);
                 List<Test> listU = st.getAll();
                 
        Node[] nodes = new Node[listU.size()];
        int i = 0;
        for (Test each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cours/ItemTest.fxml"));
            ItemTestController cont = new ItemTestController();
            try {
                cont.t=each;
                loader.setController(cont);
                nodes[i] = (Node) loader.load();
                pnl_scroll.getChildren().add(nodes[i]);
              //  scroll.getContent()
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }    
    
}
