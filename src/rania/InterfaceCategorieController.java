/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rania;

import animatefx.animation.ZoomIn;
import com.jfoenix.controls.JFXButton;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import model.Categorie;
import model.Cours;
import services.serviceCategorie;
import services.serviceCours;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class InterfaceCategorieController implements Initializable {

    @FXML
    private BorderPane border_pane;
    @FXML
    private Circle btnClose;
    @FXML
    private StackPane stackPane;
    @FXML
    private Label rec2;
    @FXML
    private ImageView btnBackFeedback;
    @FXML
    private TableView<Categorie> tableview;
    
    private ObservableList<Categorie> obListCat;
        private ObservableList<Cours> obListCours;

    
    //SERVICES
    serviceCategorie sCategorie = new serviceCategorie();
    serviceCours sCours = new serviceCours();
    
    
    @FXML
    private TableColumn<Categorie, String> col_domaine;
    @FXML
    private TableColumn<Categorie, String> col_nom;
    @FXML
    private JFXButton btnAddForm;
    @FXML
    private TextField domaine_txt;
    @FXML
    private TextField nom_txt;
    @FXML
    private Pane pnl_add_cat;
    @FXML
    private Pane pnl_lst_cat;
    @FXML
    private JFXButton btn_add_cat;
    @FXML
    private TableColumn<Categorie, Void> col_action;
    @FXML
    private Pane pnl_modif;
    @FXML
    private TextField domaine_txt1;
    @FXML
    private TextField nom_txt1;
    @FXML
    private JFXButton btn_Modif;

        private Label label;
    @FXML
    private TableColumn<Categorie, Void> col_action1;
    @FXML
    private JFXButton btn_manage_cours;
    @FXML
    private Pane pnl_add_cours;
    @FXML
    private TextField titre_txt;
    @FXML
    private TextField duree_txt;
    @FXML
    private JFXButton btn_add_cours;
    @FXML
    private TextField supp_txt;
    @FXML
    private TextArea desc_txt;
    @FXML
    private Label rec21;
    @FXML
    private ImageView btnBackFeedback1;
    @FXML
    private JFXButton btnAddFormCours;
    @FXML
    private TableView<Cours> tableview1;
    @FXML
    private TableColumn<Cours, String> col_titre;
    @FXML
    private TableColumn<Cours, String> col_supp;
    @FXML
    private TableColumn<Cours, Void> col_action_modif;
    @FXML
    private TableColumn<Cours, Void> col_action_supp;
    @FXML
    private Pane pnl_lst_cours;
    
    Cours cours = new Cours();
    private Pane pnl_modif_cours;
    @FXML
    private TextField titre_modif_txt;
    @FXML
    private JFXButton btn_Cours_Modif;
    @FXML
    private TextArea desc_txt_modif;
    @FXML
    private TextField duree_txt_modif;
    @FXML
    private TextField supp_txt_modif;
    @FXML
    private Pane pnl_modifcours;

    
                  // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = "ACf86063fbdaa10065ae7a2afdc45e05f4";
    public static final String AUTH_TOKEN = "71ee00f6677bb2437a60e06f809c2b43";
    @FXML
    private TableColumn<Cours, Void> col_traiter;
    @FXML
    private JFXButton btn_manage_cours1;
    @FXML
    private JFXButton btn_manage_cours2;
    @FXML
    private JFXButton btn_manage_cours21;
    @FXML
    private Hyperlink top_ev_txt;
    @FXML
    private void handleMouseEvent(MouseEvent event) {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
          
            //ajout categorie
            Categorie cat = new Categorie(domaine_txt.getText().toString(),nom_txt.getText());
            
            if(domaine_txt.getText().isEmpty() ) {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  remplir le fourmulaire !!!");
            alert.showAndWait();
            }else
                    if(nom_txt.getText().isEmpty() ) {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  remplir le fourmulaire !!!");
            alert.showAndWait();
            }
                    else{
                        Alert alert = new Alert (Alert.AlertType.INFORMATION);
           
            alert.setHeaderText("Succes");
            alert.setContentText("Categorie a ete ajouter avec success");
                        alert.showAndWait();


                        sCategorie.ajouterCategorie(cat);



                        afficherCategories();
                    new ZoomIn(pnl_lst_cat).play();
            pnl_lst_cat.toFront();
            pnl_lst_cat.setVisible(true);
                    }
    }

 
       
    public void afficherCategories() {
        obListCat = sCategorie.afficherCategorie();

        
    tableview.refresh();
            obListCat.clear();
                    obListCat = sCategorie.afficherCategorie();

             col_domaine.setCellValueFactory(new PropertyValueFactory<>("domaine"));
               col_nom.setCellValueFactory(new PropertyValueFactory<>("nomcat"));
              System.out.println("table contain ="+obListCat);
            tableview.setItems(obListCat);
              System.out.println("here we = "+obListCat);

            



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableview.refresh();
                addButtonToTable();
                addButtonDeleteToTable();

        afficherCategories();
                tableview1.refresh();
 addButtonDeleteCoursToTable();
                addButtonCoursToTable();
        afficheCours();
        
        addButtonTraiterCoursToTable();
        
        
        
        
    }

    @FXML
    private void addCategorie(ActionEvent event) {
         if(event.getSource().equals(btnAddForm)) {
            new ZoomIn(pnl_add_cat).play();
            pnl_add_cat.toFront();
            pnl_lst_cat.setVisible(false);
          
        }
    }
    
    JFXButton btn;
    Categorie  categorie = new Categorie();
    
        public void addButtonToTable() {
           


        Callback<TableColumn<Categorie, Void>, TableCell<Categorie, Void>> cellFactory = new Callback<TableColumn<Categorie, Void>, TableCell<Categorie, Void>>() {
            @Override
            public TableCell<Categorie, Void> call(final TableColumn<Categorie, Void> param) {

                final TableCell<Categorie, Void> cell = new TableCell<Categorie, Void>() {


                    { 

                        btn = new JFXButton("Modifier");

                        btn.setOnAction((ActionEvent event) -> {
                            
                             
                              new ZoomIn(pnl_modif).play();
                              pnl_modif.toFront();
                              categorie = tableview.getSelectionModel().getSelectedItem();
                              
                            
                                domaine_txt1.setVisible(true);
                                nom_txt1.setVisible(true);
                                  domaine_txt1.setText(categorie.getDomaine());
                                 nom_txt1.setText(categorie.getNomcat());
                            


                              
                                                                
                            
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;    
            }
        };

        col_action.setCellFactory(cellFactory);


        
        
        
   
      }
        
        
        JFXButton btnSupprimer = new JFXButton();
        JFXButton btnDesac = new JFXButton();
               public void addButtonDeleteToTable() {
              


        Callback<TableColumn<Categorie, Void>, TableCell<Categorie, Void>> cellFactory = new Callback<TableColumn<Categorie, Void>, TableCell<Categorie, Void>>() {
            @Override
            public TableCell<Categorie, Void> call(final TableColumn<Categorie, Void> param) {

                final TableCell<Categorie, Void> cell = new TableCell<Categorie, Void>() {


                    { 

                        btnSupprimer = new JFXButton("Supprimer");
                         btnSupprimer = new JFXButton("Supprimer");
                        btnSupprimer.setOnAction((ActionEvent event) -> {
                            
                             
                              categorie = tableview.getSelectionModel().getSelectedItem();
                              showConfirmation(categorie);
                              
                        });

                   
                        
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);  
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnSupprimer);
                        }
                    }
                };
                return cell;    
            }
        };
               

        col_action1.setCellFactory(cellFactory);
      }

    @FXML
    private void handleButtonActionModif(ActionEvent event) {
   Alert alert = new Alert (Alert.AlertType.INFORMATION);
           
            alert.setHeaderText("Succes");
            alert.setContentText("Cours a ete modifié avec success");
                        alert.showAndWait();

 long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
       sCours.modifierCours(new Cours(titre_modif_txt.getText(), 
               desc_txt_modif.getText(),Integer.parseInt(
               duree_txt_modif.getText()
               ),date,supp_txt_modif.getText(),0),cours.getId());

                        obListCours.clear();
                        tableview1.refresh();
                        afficheCours();
                    new ZoomIn(pnl_lst_cours).play();
            pnl_lst_cours.toFront();
            pnl_lst_cours.setVisible(true);
                    new ZoomIn(pnl_lst_cours).play();
            pnl_lst_cours.toFront();
          //  pnl_add_cat.setVisible(true);
                    }
    
    
    
        private void showConfirmation(Categorie categorie) {
        
 
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Suppression");
      alert.setHeaderText("Voullez vous vraiment supprimer??");
      alert.setContentText("Le Categorie est tres efficace");
 
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
      if (option.get() == null) {
         this.label.setText("pas selection!");
      } else if (option.get() == ButtonType.OK) {
          sCategorie.supprimerCategorie(categorie.getIdcat());
          obListCat.clear();
          tableview.refresh();
          sCategorie.afficherCategorie();
      } else if (option.get() == ButtonType.CANCEL) {
         this.label.setText("Exit!");
      } else {
         this.label.setText("-");
      }
   


  
}

    @FXML
    private void goToCours(ActionEvent event) {
         new ZoomIn(pnl_lst_cours).play();
            pnl_lst_cours.toFront();
            
        
    }

    @FXML
    private void handleButtonActionAddCours(ActionEvent event) {
        
            if(titre_txt.getText().isEmpty() ) {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  remplir le fourmulaire !!!");
            alert.showAndWait();
            }else
                    if(desc_txt.getText().isEmpty() ) {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  remplir le fourmulaire !!!");
            alert.showAndWait();
            }
                    else
                    if(duree_txt.getText().isEmpty() ) {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  remplir le fourmulaire !!!");
            alert.showAndWait();
            }
                        else
                    if(supp_txt.getText().isEmpty() ) {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alerte");
            alert.setHeaderText(null);
            alert.setContentText("!!!  remplir le fourmulaire !!!");
            alert.showAndWait();
            }
                       
                    
                    else{
                        //DATE
             long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
       //ajout Cours
            Cours cours = new Cours(titre_txt.getText().toString(),
                    desc_txt.getText(),Integer.parseInt(duree_txt.getText()),
            date,supp_txt.getText(),0);
            
                        Alert alert = new Alert (Alert.AlertType.INFORMATION);
           
            alert.setHeaderText("Succes");
            alert.setContentText("Cours a ete ajouter avec success");
                        alert.showAndWait();


                        sCours.ajouterCours(cours);
                        
                        
                        //SEND SMS
          

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
               new com.twilio.type.PhoneNumber("+21653673263"),
                new com.twilio.type.PhoneNumber("+16626667325"),
                "il y a un nouveau cours ")
            .create();

        System.out.println(message.getSid());
                       
                        
                        
 obListCours.clear();
          tableview1.refresh();
          sCours.afficherCours();
          addButtonCoursToTable();addButtonDeleteCoursToTable();
                    new ZoomIn(pnl_lst_cours).play();
            pnl_lst_cours.toFront();
            pnl_lst_cours.setVisible(true);
                    }
    }

    private void afficheCours() {
    obListCours = sCours.afficherCours();

        
    //tableview.refresh();
      //      obListCat.clear();
             col_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
               col_supp.setCellValueFactory(new PropertyValueFactory<>("support"));
               col_traiter.setCellValueFactory(new PropertyValueFactory<>("traiter"));
              System.out.println("table Cours contain ="+obListCours);
            tableview1.setItems(obListCours);
              System.out.println("Cours here we = "+obListCours);

            

    }

    @FXML
    private void addCours(ActionEvent event) {
           new ZoomIn(pnl_add_cours).play();
            pnl_add_cours.toFront();
                        pnl_lst_cat.setVisible(false);

            pnl_add_cours.setVisible(true);
    }
   
      public void addButtonCoursToTable() {
           


        Callback<TableColumn<Cours, Void>, TableCell<Cours, Void>> cellFactory1 = new Callback<TableColumn<Cours, Void>, TableCell<Cours, Void>>() {
            @Override
            public TableCell<Cours, Void> call(final TableColumn<Cours, Void> param) {

                final TableCell<Cours, Void> cell = new TableCell<Cours, Void>() {


                    { 

                        btn = new JFXButton("Modifier");

                        btn.setOnAction((ActionEvent event) -> {
                            
                             
                              new ZoomIn(pnl_modifcours).play();
                              pnl_modifcours.toFront();
                              cours = tableview1.getSelectionModel().getSelectedItem();
                              
                            
                                titre_modif_txt.setVisible(true);
                                desc_txt_modif.setVisible(true);
                                        supp_txt_modif.setVisible(true);
                                duree_txt_modif.setVisible(true);

                                 titre_modif_txt.setText(cours.getTitre());
                                 desc_txt_modif.setText(cours.getDescription());
                                 supp_txt_modif.setText(cours.getSupport());
                                 duree_txt_modif.setText(String.valueOf(cours.getDuree()));
                                 
                            


                              
                                                                
                            
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;    
            }
        };

        col_action_modif.setCellFactory(cellFactory1);


        
        
        
   
      }
        
                   public void addButtonDeleteCoursToTable() {
              


        Callback<TableColumn<Cours, Void>, TableCell<Cours, Void>> 
                cellFactory1 = new Callback<TableColumn<Cours, Void>, 
                        TableCell<Cours, Void>>() {
            @Override
            public TableCell<Cours, Void> call(final TableColumn<Cours, Void> param) {

                final TableCell<Cours, Void> cell = new TableCell<Cours, Void>() {


                    { 

                        btnSupprimer = new JFXButton("Supprimer");
                         btnSupprimer = new JFXButton("Supprimer");
                        btnSupprimer.setOnAction((ActionEvent event) -> {
                            
                             
                              cours = tableview1.getSelectionModel().getSelectedItem();
                              showConfirmationCours(cours);
                              
                        });

                   
                        
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);  
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnSupprimer);
                        }
                    }
                };
                return cell;        
            }
        };
               

        col_action_supp.setCellFactory(cellFactory1);
      }
            private void showConfirmationCours(Cours cours) {
        
 
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Suppression");
      alert.setHeaderText("Voullez vous vraiment supprimer??");
      alert.setContentText("Cours numero"+cours.getId());
 
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
      if (option.get() == null) {
         this.label.setText("pas selection!");
      } else if (option.get() == ButtonType.OK) {
          sCours.supprimerCours(cours.getId());
          obListCours.clear();
          tableview1.refresh();
          sCours.afficherCours();
      } else if (option.get() == ButtonType.CANCEL) {
         this.label.setText("Exit!");
      } else {
         this.label.setText("-");
      }
   


  
}

    @FXML
    private void handleButtonActionModifCt(ActionEvent event) {
   
   Alert alert = new Alert (Alert.AlertType.INFORMATION);
           
            alert.setHeaderText("Succes");
            alert.setContentText("Categorie a ete modifié avec success");
                        alert.showAndWait();

 long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
       sCategorie.modifierCategorie(new Categorie(domaine_txt1.getText(),nom_txt1.getText()),categorie.getIdcat());

                        obListCat.clear();
                        tableview.refresh();
                        afficherCategories();
                    new ZoomIn(pnl_lst_cat).play();
            pnl_lst_cat.toFront();
            pnl_lst_cat.setVisible(true);
                    new ZoomIn(pnl_lst_cat).play();
            pnl_lst_cat.toFront();
          //  pnl_add_cat.setVisible(true);
                    }
    
    

       
                   public void addButtonTraiterCoursToTable() {
              


        Callback<TableColumn<Cours, Void>, TableCell<Cours, Void>> 
                cellFactory1 = new Callback<TableColumn<Cours, Void>, 
                        TableCell<Cours, Void>>() {
            @Override
            public TableCell<Cours, Void> call(final TableColumn<Cours, Void> param) {

                final TableCell<Cours, Void> cell = new TableCell<Cours, Void>() {


                    { 

                        btnDesac = new JFXButton("Desactiver");
                         btnDesac = new JFXButton("Desactiver");
                        btnDesac.setOnAction((ActionEvent event) -> {
                            
                             
                              cours = tableview1.getSelectionModel().getSelectedItem();
                              showConfirmationTraiter(cours);
                              
                        });

                   
                        
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);  
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnDesac);
                        }
                    }
                };
                return cell;        
            }
        };
               

        col_traiter.setCellFactory(cellFactory1);
      }
            private void showConfirmationTraiter(Cours cours) {
        
 
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Traiter");
      alert.setHeaderText("Voullez vous vraiment Traiter ce cours??");
      alert.setContentText("Cours numero"+cours.getId());
 
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
      if (option.get() == null) {
         this.label.setText("pas selection!");
      } else if (option.get() == ButtonType.OK) {
//          cours.setEtat(0);
          sCours.traiterCours(cours); //mregl taw??? jareb zid  ekir waamalou desactiver hh  bhi
          obListCours.clear();
          tableview1.refresh();
          sCours.afficherCours();
      } else if (option.get() == ButtonType.CANCEL) {
         this.label.setText("Exit!");
      } else {
         this.label.setText("-");
      }
   


  
}

    @FXML
    private void goToCat(ActionEvent event) {
            new ZoomIn(pnl_lst_cat).play();
            pnl_lst_cat.toFront();
          
        
    }

    @FXML
    private void GoToEvent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InterfaceUnivEvenement.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

                        stage.setScene(scene);
                new animatefx.animation.ZoomIn(root).play();
        stage.show();
         
    }

    private void goToUniv(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("InterfaceUnivEvenement.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

                        stage.setScene(scene);
                new animatefx.animation.ZoomIn(root).play();
        stage.show();
         
    }

    @FXML
    private void GoToLike(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("likeCours.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

                        stage.setScene(scene);
                new animatefx.animation.ZoomIn(root).play();
        stage.show();
    }

    @FXML
    private void goToTopEvenets(ActionEvent event) {
    }
}





               