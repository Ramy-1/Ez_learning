/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package etudiant;

import component.FxmlLoaderForm;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class DashboardController implements Initializable {
    private double lastX,lastY,lastWidth,lastHeight;
    private boolean isLightMode =true;
    
    @FXML
    public Button btnAccuiel;
    @FXML
    public Button btnTest;
    @FXML
    public Button btnQuestions;
    private double x, y;
    @FXML
    private Circle mi;
    @FXML
    private Circle re;
    public BorderPane parent;
    public Button btnTest2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void closeWindow(){
          System.exit(0);
    }
    
    public void ReWindow(){
        re.setOnMouseClicked(events -> {
          Node n = (Node)events.getSource(); 
 
      Window w = n.getScene().getWindow(); 
 
      double currentX = w.getX(); 
      double currentY = w.getY(); 
      double currentWidth = w.getWidth(); 
      double currentHeight = w.getHeight(); 

      Screen screen = Screen.getPrimary(); 
      Rectangle2D bounds = screen.getVisualBounds(); 
 
       if( currentX != bounds.getMinX() && 
         currentY != bounds.getMinY() && 
         currentWidth != bounds.getWidth() && 
         currentHeight != bounds.getHeight() ) { 
 
         w.setX(bounds.getMinX()); 
         w.setY(bounds.getMinY()); 
         w.setWidth(bounds.getWidth()); 
         w.setHeight(bounds.getHeight()); 
 
         lastX = currentX;  // save old dimensions 
         lastY = currentY; 
         lastWidth = currentWidth; 
         lastHeight = currentHeight; 
        
 
       } else { 
 
         // de-maximize the window (not same as minimize) 
 
         w.setX(lastX); 
         w.setY(lastY); 
         w.setWidth(lastWidth); 
         w.setHeight(lastHeight); 
          
      }
         });
    }
    public void MiWindow(){
         mi.setOnMouseClicked(events -> {
             Node n = (Node)events.getSource(); 
 
      Window w = n.getScene().getWindow(); 
      
          Stage stage = (Stage) w;

            stage.setIconified(true);
         });
    }
    
    
     public void changeMode(ActionEvent event){
        isLightMode =! isLightMode;
        if(isLightMode){
            setLightMode();
        }
        else{
             setDarkMode();
        }
    }
    
    private void setLightMode(){
       
             parent.getStylesheets().remove("style/DarkMode.css");
             parent.getStylesheets().add("style/LightMode.css");
            
       
       
    }
    private void setDarkMode(){
       
        parent.getStylesheets().remove("style/LightMode.css");
        parent.getStylesheets().add("style/DarkMode.css");
        isLightMode=false;
         
    }
    
    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnAccuiel) {}
        if (actionEvent.getSource() == btnTest) {
              FxmlLoaderForm object =new FxmlLoaderForm();
              Pane view = object.getPage("TestAdmin");
              System.out.println(view);
              parent.setCenter(view);
        }
         if (actionEvent.getSource() == btnTest2) {
              FxmlLoaderForm object =new FxmlLoaderForm();
              Node view = object.getPage("test");
              System.out.println(view);
              parent.setCenter(view);
        }
        if (actionEvent.getSource() == btnQuestions) {}
    }
    
}
