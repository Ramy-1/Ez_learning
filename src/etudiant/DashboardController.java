/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package etudiant;

import component.FxmlLoader;
import component.FxmlLoaderCours;
import component.FxmlLoaderForm;
import component.FxmlLoaderStudent;
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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
    public Button btnMesCours;
    public Button btnCours;
   public Button btnOffre;
    
    @FXML
    public Button btnBack;
    @FXML
    public Button btnBack1;
    @FXML
    public Button btnBack2;
    
    @FXML
    private Rectangle btnblue;
    @FXML
    private Rectangle btngreen;
    @FXML
    private Rectangle btnred;
    @FXML
    private Rectangle btnpurple;
    @FXML
    private Rectangle btnyellow;
    
      private int bk=0;

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
     
        if(bk==0){
             parent.getStylesheets().remove("style/DarkMode.css");
             parent.getStylesheets().add("style/LightMode.css");
            
             bk=0;
             isLightMode=true;
        }
        if(bk==1){
             parent.getStylesheets().remove("style/back1.css");
             parent.getStylesheets().add("style/LightMode.css");
             bk=0;
             isLightMode=true;
        }
        if(bk==2){
             parent.getStylesheets().remove("style/back2.css");
             parent.getStylesheets().add("style/LightMode.css");
             bk=0;
             isLightMode=true;
        }
        if(bk==3){
             parent.getStylesheets().remove("style/back3.css");
             parent.getStylesheets().add("style/LightMode.css");
             bk=0;
             isLightMode=true;
        }
       
    }
    private void setDarkMode(){
        System.out.println(bk);
         if(bk==0){
            parent.getStylesheets().remove("style/LightMode.css");
            parent.getStylesheets().add("style/DarkMode.css");
            bk=0;
            isLightMode=false;
        }
        if(bk==1){
            parent.getStylesheets().remove("style/back1.css");
            parent.getStylesheets().add("style/DarkMode.css");
            bk=0;
            isLightMode=false;
        }
        if(bk==2){
            parent.getStylesheets().remove("style/back2.css");
        parent.getStylesheets().add("style/DarkMode.css");
        bk=0;
        isLightMode=false;
        }
        if(bk==3){
            
             parent.getStylesheets().remove("style/back3.css");
            parent.getStylesheets().add("style/DarkMode.css");
            bk=0;
            isLightMode=false;
        }
         
    }
    
    @FXML
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == btnAccuiel) {
            FxmlLoaderStudent object =new FxmlLoaderStudent();
              BorderPane view = (BorderPane) object.getPage("dashboardEtudiant");
                Node mainp = view.getCenter().getParent();
              parent.setCenter(mainp);
              parent.getChildren().remove(parent.getLeft());
               parent.getChildren().remove(parent.getTop());

        }
        if (actionEvent.getSource() == btnTest) {
              FxmlLoaderForm object =new FxmlLoaderForm();
              Pane view = object.getPage("TestAdmin");
              System.out.println(view);
              parent.setCenter(view);
        }
         if (actionEvent.getSource() == btnMesCours) {
              FxmlLoaderCours object =new FxmlLoaderCours();
              Node view = object.getPage("courEtudiant"); 
              view.setLayoutX(20);
              view.setLayoutY(50);
              System.out.println(view);
              parent.setCenter(view);
        }
        if (actionEvent.getSource() == btnCours) {
            
            FxmlLoaderCours object =new FxmlLoaderCours();
              Node view = object.getPage("Cours");              
              System.out.println(view);
              parent.setCenter(view);
        }
       /* if (actionEvent.getSource() == btnAccuiel) {
             FxmlLoaderStudent object =new FxmlLoaderStudent();
              BorderPane view = (BorderPane) object.getPage("dashboardEtudiant");
          Node mainp = view.getCenter().getParent();
              System.out.println(mainp);
         System.out.println(mainp);
              parent.setCenter(mainp);
              parent.getChildren().remove(parent.getLeft());
               parent.getChildren().remove(parent.getTop());
        }*/
      
       
        if (actionEvent.getSource() == btnBack) {
             Rectangle clip = new Rectangle(
            parent.getWidth(), parent.getHeight()
            );
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            parent.setClip(clip);
          if(bk==0){
              parent.getStylesheets().remove("style/DarkMode.css");
              parent.getStylesheets().add("style/back1.css");
              
              
              bk=1;
          }
          if(bk==1){
              parent.getStylesheets().remove("style/back1.css");
              parent.getStylesheets().add("style/back1.css");
              
              bk=1;
          }
          if(bk==2){
              parent.getStylesheets().remove("style/back2.css");
              parent.getStylesheets().add("style/back1.css");
              
              bk=1;
          }
          if(bk==3){
              parent.getStylesheets().remove("style/back3.css");
              parent.getStylesheets().add("style/back1.css");
              
              bk=1;
          }
        }
        if (actionEvent.getSource() == btnBack1) {
             Rectangle clip = new Rectangle(
            parent.getWidth(), parent.getHeight()
            );
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            parent.setClip(clip);
          if(bk==0){
              parent.getStylesheets().remove("style/DarkMode.css");
              parent.getStylesheets().add("style/back2.css");
              
              bk=2;
          }
          if(bk==1){
              parent.getStylesheets().remove("style/back1.css");
              parent.getStylesheets().add("style/back2.css");
              
              bk=2;
          }
          if(bk==2){
              parent.getStylesheets().remove("style/back2.css");
              parent.getStylesheets().add("style/back2.css");
              
              bk=2;
          }
          if(bk==3){
              parent.getStylesheets().remove("style/back3.css");
              parent.getStylesheets().add("style/back2.css");
              
              bk=2;
          }
         
      }
      if (actionEvent.getSource() == btnBack2) {
           Rectangle clip = new Rectangle(
            parent.getWidth(), parent.getHeight()
            );
            clip.setArcWidth(20);
            clip.setArcHeight(20);
            parent.setClip(clip);
         if(bk==0){
              parent.getStylesheets().remove("style/DarkMode.css");
              parent.getStylesheets().add("style/back3.css");
              
              bk=3;
          }
          if(bk==1){
              parent.getStylesheets().remove("style/back1.css");
              parent.getStylesheets().add("style/back3.css");
              
              bk=3;
          }
          if(bk==2){
              parent.getStylesheets().remove("style/back2.css");
              parent.getStylesheets().add("style/back3.css");
              
              bk=3;
          }
          if(bk==3){
              parent.getStylesheets().remove("style/back3.css");
              parent.getStylesheets().add("style/back3.css");
              
              bk=3;
          }
      }
    }
    
    public void bluebutton(){
        parent.setStyle(".button:hover{-fx-background-color : #3695ff !important;}.button:pressed{-fx-background-color : #3695ff ;}-fx-background-radius:15 px;");
    }
    
}
