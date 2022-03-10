/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package cours;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import model.Cours;

/**
 * FXML Controller class
 *
 * @author karim
 */
public class ShowCoursController implements Initializable {
    
    
    @FXML
    private AnchorPane anchor;
     @FXML
    MediaView media;
    
    Cours c;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         /*String path = "Téléchargements/vi1.mp4";  
          
        //Instantiating Media class  
        Media media = new Media(new File(path).toURI().toString());  
          
        //Instantiating MediaPlayer class   
        MediaPlayer mediaPlayer = new MediaPlayer(media);  
          
        //Instantiating MediaView class   
        MediaView mediaView = new MediaView(mediaPlayer);  
          
        //by setting this property to true, the Video will be played   
        mediaPlayer.setAutoPlay(true);  
          
        //setting group and scene 
        anchor.getChildren().add(mediaView);*/
         System.out.println("hello");
         Media m = new Media("http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv");
        MediaPlayer mediaPlayer = new MediaPlayer(m);
         media.setMediaPlayer(mediaPlayer);
    
         mediaPlayer.play();
    }    
    
}
