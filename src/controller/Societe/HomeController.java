/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.societe;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Demande;
import model.Enseignant;
import model.Etudiant;
import model.Offre;
import model.Recruteur;
import model.Universite;
import model.User;
import services.ServiceEns;
import services.ServiceEtudiant;
import services.ServiceRecruteur;
import services.ServiceUser;

import services.serviceReclamation;
import model.Reclamation;
import model.Role;
import model.societe;
import services.ServiceDemande;
import services.ServiceOffre;
import services.serviceSociete;
import services.serviceUniversite;


/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {

    ServiceUser sU = new ServiceUser();
    ServiceEtudiant sE = new ServiceEtudiant();
    ServiceEns sEn = new ServiceEns();
    ServiceRecruteur sR = new ServiceRecruteur();

    serviceReclamation srr =new serviceReclamation();
    serviceSociete ssoc = new serviceSociete();
    serviceUniversite sUn = new serviceUniversite();
   
    ServiceOffre sO = new ServiceOffre();
    ServiceDemande sD = new ServiceDemande();

    @FXML
    private VBox pnl_scroll;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private Label lbl_completed;
    @FXML
    private ScrollPane Scrollepane;
    
    @FXML
    private Circle mi;
    @FXML
    private Circle re;
    private double lastX,lastY,lastWidth,lastHeight;
    @FXML
    private Circle close1;

    @FXML
    private void handleButtonAction(MouseEvent event) {
//        refreshNodes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        Scrollepane.gets
//        refreshNodes();
    }

    


    private void boxifyVBoxes() {
        // styles used for vboxes
        Background focusBackground = new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY));
        Background unfocusBackground = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
        Border border = new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, null, null));

        for (Node child : pnl_scroll.getChildren()) {
            VBox vb = (VBox) child;
            vb.setPadding(new Insets(10));
            vb.setBorder(border);

            // when vbox is clicked focus on it
            vb.setOnMouseClicked((e) -> {
                vb.requestFocus();
            });

            // use different backgrounds for focused and unfocused states
            vb.backgroundProperty().bind(Bindings
                    .when(vb.focusedProperty())
                    .then(focusBackground)
                    .otherwise(unfocusBackground));

        }
    }
    
    private void ListUniversiteClicked(ActionEvent event) {
//        pnl_scroll.getChildren().clear();
//
//        List<Universite> listU = sUn.getAll();
//        System.out.println(listU);
//        Node[] nodes = new Node[listU.size()];
//        int i = 0;
//
//        for (Universite each : listU) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
//            ItemController cont = new ItemController();
//            try {
//                cont.U = each;
//                loader.setController(cont);
//
//                nodes[i] = (Node) loader.load();
//
//                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
//                pnl_scroll.getChildren().add(nodes[i]);
//
//            } catch (IOException ex) {
//                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            i++;
//        }
    }
    
    @FXML
    public void closeWindow(){
          System.exit(0);
    }
    
    @FXML
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
    @FXML
    public void MiWindow(){
         mi.setOnMouseClicked(events -> {
             Node n = (Node)events.getSource(); 
 
      Window w = n.getScene().getWindow(); 
      
          Stage stage = (Stage) w;

            stage.setIconified(true);
         });
    }
    

    

    @FXML
    private void OffreClicked(ActionEvent event) {
        pnl_scroll.getChildren().clear();

        List<Offre> listOffre = sO.afficherOffre();
        Node[] nodes = new Node[listOffre.size()];
        int i = 0;

        for (Offre each : listOffre) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Offre.fxml"));
            OffreController cont = new OffreController();
            try {
                cont.O = each;
                System.out.println(each);
                loader.setController(cont);

                nodes[i] = (Node) loader.load();

                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }

    @FXML
    private void DemandeClicked(ActionEvent event) {
        pnl_scroll.getChildren().clear();

        List<Demande> listDemande = sD.afficherDemande();
        Node[] nodes = new Node[listDemande.size()];
        int i = 0;

        for (Demande each : listDemande) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Demande.fxml"));
            DemandeController cont = new DemandeController();
            try {
                cont.D = each;
                loader.setController(cont);

                nodes[i] = (Node) loader.load();

                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }

    @FXML
    private void AddOffreClicked(ActionEvent event) throws IOException {
        AddOffreController cont = new AddOffreController();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddOffre.fxml"));
        loader.setController(cont);
        //mainAnchor = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Update Offre");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    @FXML
    private void listUserClicked(ActionEvent event) {
        sU.getAll().stream().filter(x -> x.getRole()== Role.Recruteur).forEach(x-> System.out.println(x));
        
        pnl_scroll.getChildren().clear();
//        List<User> listU = sU.getAll().stream().filter(x -> x.getRole() == Role.Recruteur).collect();

        List<User> listU = sU.getAll();
        Node[] nodes = new Node[listU.size()];
        int i = 0;

        for (User each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
            ItemController cont = new ItemController();
            try {
                if(each.getRole() == Role.Recruteur){
                    
                cont.U = each;
                loader.setController(cont);

                nodes[i] = (Node) loader.load();

                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);
                }

            } catch (IOException ex) {
                Logger.getLogger(controller.admin.HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }


    @FXML
<<<<<<< HEAD
    private void SendEmailClicked(ActionEvent event) {
=======
    private void SendEmailClicked(ActionEvent event) throws IOException {
        pnl_scroll.getChildren().clear();

        pnl_scroll.getChildren().add((Node) FXMLLoader.load(getClass().getResource("/component/sendMail.fxml")));
>>>>>>> main
    }

    @FXML
    private void AddClicked(ActionEvent event) {
    }

    @FXML
    private void AjoutRecruteurClicked(ActionEvent event) throws IOException {
        
//        EditItemController cont = new EditItemController();
//        cont.type = 1;
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditItem.fxml"));
//        pnl_scroll.getChildren().add(loader.load());

        EditItemController cont = new EditItemController();
        cont.type = 1;
//        cont.u = this.U;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditItem.fxml"));
        loader.setController(cont);
//        mainAnchor = loader.load();

        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    @FXML
    private void LogOutClcked(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}


