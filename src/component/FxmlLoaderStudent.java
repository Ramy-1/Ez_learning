/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import java.net.URL;
import finalproject.FinalProject;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author karim
 */
public class FxmlLoaderStudent {
    private Pane view;
    
    public Pane getPage(String fileName){
        try {
            URL fileURL =FinalProject.class.getResource("/etudiant/" + fileName + ".fxml");
            System.out.println(fileURL);
            if (fileURL== null){
                throw new java.io.FileNotFoundException("file not found");
            }
            view = new FXMLLoader().load(fileURL);
        } catch (Exception e) {
        }
        return view;
    }
}
