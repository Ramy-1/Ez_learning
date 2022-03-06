/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package finalproject;

import java.io.IOException;
import java.util.List;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;


import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Test;
import services.serviceTest;

/**
 *
 * @author karim
 */
public class FinalProject extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
      Parent root = FXMLLoader.load(getClass().getResource("/main/Main.fxml"));        
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene(scene);
         primaryStage.initStyle(StageStyle.UNDECORATED);
         primaryStage.initStyle(StageStyle.TRANSPARENT);
      
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
      
    }
    
}
