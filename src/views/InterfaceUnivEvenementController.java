///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package views;
//
//import animatefx.animation.ZoomIn;
//import com.jfoenix.controls.JFXButton;
//import java.io.IOException;
//import java.net.URL;
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.Optional;
//import java.util.ResourceBundle;
//import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.Hyperlink;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableCell;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.shape.Circle;
//import javafx.stage.Stage;
//import javafx.util.Callback;
//import model.Categorie;
//import model.Cours;
//import model.Evenement;
//import model.Universite;
//import services.serviceEvenement;
//import services.serviceUniversite;
//
///**
// * FXML Controller class
// *
// * @author PC
// */
//public class InterfaceUnivEvenementController implements Initializable {
//
//    @FXML
//    private BorderPane border_pane;
//    @FXML
//    private Circle btnClose;
//    @FXML
//    private StackPane stackPane;
//    @FXML
//    private Label rec2;
//    @FXML
//    private ImageView btnBackFeedback;
//    private TableView<Categorie> tableview;
//    
//    private ObservableList<Universite> obListUniv;
//        private ObservableList<Evenement> obListEv;
//
//    
//    //SERVICES
//    serviceUniversite sUniv = new serviceUniversite();
//    
//        serviceEvenement sEv = new serviceEvenement() {};
//
//    @FXML
//    private TableColumn<Universite, String> col_nom;
//    private JFXButton btnAddForm;
//    private TextField domaine_txt;
//    private TextField nom_txt;
//    private Pane pnl_add_cat;
//    private Pane pnl_lst_cat;
//    @FXML
//    private TableColumn<Universite, Void> col_action;
//    @FXML
//    private Pane pnl_modif;
//    private TextField domaine_txt1;
//    @FXML
//    private JFXButton btn_Modif;
//
//        private Label label;
//    @FXML
//    private TableColumn<Universite, Void> col_action1;
//    @FXML
//    private JFXButton btn_manage_cours;
//    @FXML
//    private JFXButton btn_manage_evenement;
//
//   
//    @FXML
//    private TextField supp_txt;
//    @FXML
//    private TextArea desc_txt;
//    
//    @FXML
//    private Pane pnl_lst_cours;
//    
//    Cours cours = new Cours();
//    private Pane pnl_modif_cours;
//    @FXML
//    private TextField titre_modif_txt;
//    @FXML
//    private JFXButton btn_Cours_Modif;
//    @FXML
//    private TextArea desc_txt_modif;
//    @FXML
//    private TextField duree_txt_modif;
//    @FXML
//    private TextField supp_txt_modif;
//    @FXML
//    private Pane pnl_modifcours;
//    @FXML
//    private TableColumn<Universite, Void> col_email;
//    @FXML
//    private TextField nomuniv_txt;
//    private TextField emailuniv_txt;
//    @FXML
//    private JFXButton btn_add_univ;
//    private TextField aduniv_adr;
//    @FXML
//    private Pane pnl_lst_un;
//    @FXML
//    private Label rec21;
//    @FXML
//    private ImageView btnBackFeedback1;
//    @FXML
//    private JFXButton btnAddFormCours;
//    @FXML
//    private TableView<?> tableview1;
//    @FXML
//    private TableColumn<?, ?> col_titre;
//    @FXML
//    private TableColumn<?, ?> col_supp;
//    @FXML
//    private TableColumn<?, ?> col_action_modif;
//    @FXML
//    private TableColumn<?, ?> col_action_supp;
//    @FXML
//    private Pane pnl_add_cours;
//    @FXML
//    private TextField titre_txt;
//    @FXML
//    private TextField duree_txt;
//    @FXML
//    private JFXButton btn_add_cours;
//    @FXML
//    private TableColumn<?, ?> col_nom11;
//    @FXML
//    private TableView<Universite> tableviewUn;
//    @FXML
//    private TextField nom_modif_txt;
//    @FXML
//    private TextField email_modif_txt;
//    @FXML
//    private TextField adr_modif_txt;
//    @FXML
//    private TextField email_txt;
//    @FXML
//    private TextField adr_txt;
//    @FXML
//    private JFXButton btnAddFormU;
//    @FXML
//    private Pane pnl_add_Un;
//    private Pane pnl_add_Event;
//    @FXML
//    private TextField org_txt;
//    @FXML
//    private TextField heure_picker;
//    @FXML
//    private DatePicker date_picker;
//    @FXML
//    private Label rec22;
//    @FXML
//    private ImageView btnBackFeedback2;
//    @FXML
//    private JFXButton btnAddFormEvent;
//    @FXML
//    private TableColumn<Evenement, Void> col_org;
//    @FXML
//    private TableColumn<Evenement, Void> col_date;
//    @FXML
//    private TableColumn<Evenement, Void> col_lien;
//    @FXML
//    private TableColumn<Evenement, Void> col_action_modf_ev;
//    @FXML
//    private TableColumn<Evenement, Void> col_action_supp_ev;
//    @FXML
//    private TextField participant_txt;
//    @FXML
//    private Pane pnl_lst_ev;
//    @FXML
//    private TableView<Evenement> tableviewE;
//    @FXML
//    private Pane pnl_modif_Event;
//    @FXML
//    private TextField org_txt_modif;
//    @FXML
//    private JFXButton btn_modif_ev;
//    @FXML
//    private TextField heure_picker_modif;
//    @FXML
//    private TextField participant_txt_modif;
//    @FXML
//    private DatePicker date_picker_modif;
//    @FXML
//    private Pane pnl_add_ev;
//    @FXML
//    private JFXButton btn_add_ev;
//    @FXML
//    private TextField lien_txt;
//    @FXML
//    private TextField txt_filter;
//    @FXML
//    private Hyperlink top_ev_txt;
//    JFXButton btnShare = new JFXButton();
//    @FXML
//    private JFXButton btn_manage_evenement1;
//
//    @FXML
//    private void handleMouseEvent(MouseEvent event) {
//    }
//
//    @FXML
//    private void handleButtonActionAddUniv(ActionEvent event) {
//          
//            //ajout univ
//            Universite u = new Universite(nomuniv_txt.getText(), email_txt.getText(), adr_txt.getText());
//            
//            if(nomuniv_txt.getText().isEmpty() ) {
//                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Alerte");
//            alert.setHeaderText(null);
//            alert.setContentText("!!!  remplir le fourmulaire !!!");
//            alert.showAndWait();
//            }else
//                    if(email_txt.getText().isEmpty() ) {
//                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Alerte");
//            alert.setHeaderText(null);
//            alert.setContentText("!!!  remplir le fourmulaire !!!");
//            alert.showAndWait();
//            }
//                    else
//                    if(adr_txt.getText().isEmpty() ) {
//                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Alerte");
//            alert.setHeaderText(null);
//            alert.setContentText("!!!  remplir le fourmulaire !!!");
//            alert.showAndWait();
//            }
//                    else{
//                        Alert alert = new Alert (Alert.AlertType.INFORMATION);
//           
//            alert.setHeaderText("Succes");
//            alert.setContentText("Universite a ete ajouter avec success");
//                        alert.showAndWait();
//
//
//                        sUniv.ajouterUniversite(u);
//
//                        afficherUniversites();
//                    new ZoomIn(pnl_lst_un).play();
//            pnl_lst_un.toFront();
//            
//                    }
//    }
//
// 
//       
//    public void afficherUniversites() {
//        obListUniv = sUniv.afficherUniversite();
//
//        
//    tableviewUn.refresh();
//           obListUniv.clear();
//                   obListUniv = sUniv.afficherUniversite();
//
//             col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
//               col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
//              System.out.println("table contain ="+obListEv);
//            tableviewUn.setItems(obListUniv);
//              System.out.println("here we = "+obListUniv);
//
//            
//
//
//
//    }
//
//    
//        public void afficherEvenemnts() {
//        obListEv = sEv.afficherEvenement();
//
//        
//    tableviewE.refresh();
//           obListEv.clear();
//                   obListEv = sEv.afficherEvenement();
//
//             col_org.setCellValueFactory(new PropertyValueFactory<>("idOrg"));
//               col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
//               col_lien.setCellValueFactory(new PropertyValueFactory<>("lien"));
//
//              System.out.println("table contain ="+obListEv);
//            tableviewE.setItems(obListEv);
//              System.out.println("here we = "+obListEv);
//
//            
//
//
//
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//   
//        afficherUniversites();
//        obListUniv.clear();
//
//             tableviewUn.refresh();
//                addButtonToTable();
//                addButtonDeleteToTable();
//                        afficherUniversites();
//                                                addButtonToTable();addButtonDeleteToTable();
//
//
// addButtonDeleteEvToTable();
//  addButtonModifEvToTable();
//  
//
//             tableviewE.refresh();
//  afficherEvenemnts();
//        
//    }
//
//    
//    JFXButton btn;
//    Categorie  categorie = new Categorie();
//    
//        public void addButtonToTable() {
//           
//
//
//        Callback<TableColumn<Universite, Void>, TableCell<Universite, Void>> cellFactory = new Callback<TableColumn<Universite, Void>, TableCell<Universite, Void>>() {
//            @Override
//            public TableCell<Universite, Void> call(final TableColumn<Universite, Void> param) {
//
//                final TableCell<Universite, Void> cell = new TableCell<Universite, Void>() {
//
//
//                    { 
//
//                        btn = new JFXButton("Modifier");
//
//                        btn.setOnAction((ActionEvent event) -> {
//                            
//                             
//                              new ZoomIn(pnl_modif).play();
//                              pnl_modif.toFront();
//                              universite = tableviewUn.getSelectionModel().getSelectedItem();
//                              
//                            
//                                nom_modif_txt.setVisible(true);
//                                email_modif_txt.setVisible(true);
//                                adr_modif_txt.setVisible(true);
//                                  nom_modif_txt.setText(universite.getNom());
//                                 email_modif_txt.setText(universite.getEmail());
//
//                                 adr_modif_txt.setText(universite.getAdresse());
//
//                                                            System.out.println("univ="+universite.getIdUni());
//
//                                                                
//                            
//                        });
//                    }
//
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(btn);
//                        }
//                    }
//                };
//                return cell;    
//            }
//        };
//
//        col_action.setCellFactory(cellFactory);
//
//
//        
//        
//        
//   
//      }
//        
//        
//        JFXButton btnSupprimer = new JFXButton();
//        
//        Universite universite = new Universite();
//        Evenement evenement = new Evenement();
//               public void addButtonDeleteToTable() {
//              
//
//
//        Callback<TableColumn<Universite, Void>, TableCell<Universite, Void>> cellFactory = new Callback<TableColumn<Universite, Void>, TableCell<Universite, Void>>() {
//            @Override
//            public TableCell<Universite, Void> call(final TableColumn<Universite, Void> param) {
//
//                final TableCell<Universite, Void> cell = new TableCell<Universite, Void>() {
//
//
//                    { 
//
//                        btnSupprimer = new JFXButton("Supprimer");
//                         btnSupprimer = new JFXButton("Supprimer");
//                        btnSupprimer.setOnAction((ActionEvent event) -> {
//                            
//                             
//                              universite = tableviewUn.getSelectionModel().getSelectedItem();
//                              showConfirmation(universite);
//                              
//                        });
//
//                   
//                        
//                    }
//
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);  
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(btnSupprimer);
//                        }
//                    }
//                };
//                return cell;    
//            }
//        };
//               
//
//        col_action1.setCellFactory(cellFactory);
//      }
//
//    @FXML
//    private void handleButtonActionModif(ActionEvent event) {
//   Alert alert = new Alert (Alert.AlertType.INFORMATION);
//           
//            alert.setHeaderText("Succes");
//            alert.setContentText("Universite a ete modifié avec success");
//                        alert.showAndWait();
//
// long millis=System.currentTimeMillis();  
//        java.sql.Date date=new java.sql.Date(millis); 
//       sUniv.modifierUniversite(new Universite(nom_modif_txt.getText(), 
//               email_modif_txt.getText(),adr_modif_txt.getText())
//              ,universite.getIdUni());
//
//                        obListUniv.clear();
//                        tableviewUn.refresh();
//                        afficherUniversites();
//                    new ZoomIn(pnl_lst_un).play();
//            pnl_lst_un.toFront();
//            pnl_lst_un.setVisible(true);
//                    new ZoomIn(pnl_lst_un).play();
//            pnl_lst_un.toFront();
//            pnl_lst_un.setVisible(true);
//                    }
//    
//    
//    
//        private void showConfirmation(Universite universite) {
//        
// 
//      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//      alert.setTitle("Suppression");
//      alert.setHeaderText("Voullez vous vraiment supprimer??");
//      alert.setContentText("Le Universite est tres efficace");
// 
//      // option != null.
//      Optional<ButtonType> option = alert.showAndWait();
// 
//      if (option.get() == null) {
//         this.label.setText("pas selection!");
//      } else if (option.get() == ButtonType.OK) {
//          sUniv.supprimerUniversite(universite);
//          obListUniv.clear();
//          tableviewUn.refresh();
//          sUniv.afficherUniversite();
//      } else if (option.get() == ButtonType.CANCEL) {
//         this.label.setText("Exit!");
//      } else {
//         this.label.setText("-");
//      }
//   
//
//
//  
//}
//
//        private void showConfirmationEvenement(Evenement evenement) {
//        
// 
//      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//      alert.setTitle("Suppression");
//      alert.setHeaderText("Voullez vous vraiment supprimer??");
//      alert.setContentText("Evenement est tres efficace");
// 
//      // option != null.
//      Optional<ButtonType> option = alert.showAndWait();
// 
//      if (option.get() == null) {
//         this.label.setText("pas selection!");
//      } else if (option.get() == ButtonType.OK) {
//          sEv.supprimerEvenement(evenement.getIdEvent());
//          obListEv.clear();
//          tableviewE.refresh();
//          sEv.afficherEvenement();
//      } else if (option.get() == ButtonType.CANCEL) {
//         this.label.setText("Exit!");
//      } else {
//         this.label.setText("-");
//      }
//   
//
//
//  
//}
//    @FXML
//    private void goToCours(ActionEvent event) {
//         new ZoomIn(pnl_lst_un).play();
//            pnl_lst_un.toFront();
//                        pnl_lst_un.setVisible(false);
//
//            pnl_lst_un.setVisible(true);
//          
//        
//    }
//
//    @FXML
//    private void handleButtonAction(ActionEvent event) {
//        
//             new ZoomIn(pnl_lst_ev).play();
//            pnl_lst_ev.toFront();
//                        pnl_lst_ev.setVisible(false);
//
//            pnl_lst_ev.setVisible(true);
//        
//        
//    }
//
//    @FXML
//    private void handleButtonActionAddCours(ActionEvent event) {
//    }
//
//    @FXML
//    private void addCours(ActionEvent event) {
//    }
//
//    @FXML
//    private void addUn(ActionEvent event) {
//            if(event.getSource().equals(btnAddFormU)) {
//            new ZoomIn(pnl_add_Un).play();
//            pnl_add_Un.toFront();
//            pnl_add_Un.setVisible(true);
//            }
//    }
//
//    @FXML
//    private void handleButtonActionAddEv(ActionEvent event) {
//             
//            //GET DATE Value:
//                        LocalDate value = date_picker.getValue();
//
//            //ajout univ
//            Evenement evenement = new Evenement(org_txt.getText(), desc_txt.getText(), Date.valueOf(value), 
//                    heure_picker.getText(),lien_txt.getText(),Integer.parseInt(participant_txt.getText()));
//            
//            if(org_txt.getText().isEmpty() || desc_txt.getText().isEmpty() || heure_picker.getText().isEmpty() || participant_txt.getText().isEmpty() ) {
//                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Alerte");
//            alert.setHeaderText(null);
//            alert.setContentText("!!!  remplir le fourmulaire !!!");
//            alert.showAndWait();
//            }
//                    
//                    else{
//                        Alert alert = new Alert (Alert.AlertType.INFORMATION);
//           
//            alert.setHeaderText("Succes");
//            alert.setContentText("Evenement a ete ajouter avec success");
//                        alert.showAndWait();
//
//
//                        sEv.ajouterEvenement(evenement);
//
//                        afficherEvenemnts();
//                    new ZoomIn(pnl_lst_ev).play();
//            pnl_lst_ev.toFront();
//    }
//            
//    }
//
//    @FXML
//    private void addEv(ActionEvent event) {
//         if(event.getSource().equals(btnAddFormEvent)) {
//              new ZoomIn(pnl_add_ev).play();
//            pnl_add_ev.toFront();
//                        pnl_add_ev.setVisible(false);
//
//            pnl_add_ev.setVisible(true);
//        }
//    }
//
//    private void addButtonDeleteEvToTable() {
//     Callback<TableColumn<Evenement, Void>, TableCell<Evenement, Void>> cellFactory = new Callback<TableColumn<Evenement, Void>, TableCell<Evenement, Void>>() {
//            @Override
//            public TableCell<Evenement, Void> call(final TableColumn<Evenement, Void> param) {
//
//                final TableCell<Evenement, Void> cell = new TableCell<Evenement, Void>() {
//
//
//                    { 
//
//                        btnSupprimer = new JFXButton("Supprimer");
//                         btnSupprimer = new JFXButton("Supprimer");
//                        btnSupprimer.setOnAction((ActionEvent event) -> {
//                            
//                             
//                              evenement = tableviewE.getSelectionModel().getSelectedItem();
//                              showConfirmationEvenement(evenement);
//                              
//                        });
//
//                   
//                        
//                    }
//
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);  
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(btnSupprimer);
//                        }
//                    }
//                };
//                return cell;    
//            }
//        };
//               
//
//        col_action_supp_ev.setCellFactory(cellFactory);    }
//
//    private void addButtonModifEvToTable() {
//
//
//        Callback<TableColumn<Evenement, Void>, TableCell<Evenement, Void>> cellFactory = new Callback<TableColumn<Evenement, Void>, TableCell<Evenement, Void>>() {
//            @Override
//            public TableCell<Evenement, Void> call(final TableColumn<Evenement, Void> param) {
//
//                final TableCell<Evenement, Void> cell = new TableCell<Evenement, Void>() {
//
//
//                    { 
//
//                        btn = new JFXButton("Modifier");
//
//                        btn.setOnAction((ActionEvent event) -> {
//                            
//                             
//                              new ZoomIn(pnl_modif_Event).play();
//                              pnl_modif_Event.toFront();
//                              evenement = tableviewE.getSelectionModel().getSelectedItem();
//                              
//                            
//                                org_txt_modif.setVisible(true);
//                                date_picker_modif.setVisible(true);
//                                heure_picker_modif.setVisible(true);                                
//                                desc_txt_modif.setVisible(true);
//                                participant_txt_modif.setVisible(true);
//                                org_txt_modif.setText(evenement.getIdOrg());
//                                date_picker_modif.setValue(evenement.getDate().toLocalDate());
//                                desc_txt_modif.setText(evenement.getDescription());
//                                heure_picker_modif.setText(evenement.getLien());
//                                participant_txt_modif.setText(String.valueOf(evenement.getNbrParticipant()));
//                                System.out.println("ev="+evenement);
//
//                                                                
//                            
//                        });
//                    }
//
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(btn);
//                        }
//                    }
//                };
//                return cell;    
//            }
//        };
//
//        col_action_modf_ev.setCellFactory(cellFactory);
//    }
//
//    
//    
//    
//  
//
//    @FXML
//    private void handleButtonActioModifEv(ActionEvent event) {
//           Alert alert = new Alert (Alert.AlertType.INFORMATION);
//           
//            alert.setHeaderText("Succes");
//            alert.setContentText("Evenement a ete modifié avec success");   
//                        alert.showAndWait();
//
// long millis=System.currentTimeMillis();  
//        java.sql.Date date=new java.sql.Date(millis); 
//        Evenement ev = new Evenement(org_txt_modif.getText(), desc_txt_modif.getText(),date, heure_picker_modif.getText(), Integer.parseInt(participant_txt_modif.getText()));
//       sEv.modifierEvenement(ev, evenement.getIdEvent());
//
//            obListEv.clear();
//            tableviewE.refresh();
//            afficherEvenemnts();
//            new ZoomIn(pnl_lst_ev).play();
//            pnl_lst_ev.toFront();
//            pnl_lst_ev.setVisible(true);
//          
//    } 
//
//    
//
//
//    //Metier Relation
//    public void filter() {  
//        FilteredList<Evenement> filteredList = new FilteredList<>(obListEv,b->true);
//        
//        txt_filter.textProperty().addListener((observable,oldValue,newValue) ->{
//                    
//        if(txt_filter.getText().isEmpty()) {
//            //Reload button
//            addButtonToTable();
//            
//        
//        }
//            filteredList.setPredicate(event-> {
//                if(newValue == null || newValue.isEmpty()) {
//                                       btn=new JFXButton("Modifier");
//
//                    return true;
//                }
//                
//                String lowerCaseFilter =newValue.toLowerCase();
//                
//                if(event.getIdOrg().toLowerCase().indexOf(lowerCaseFilter)!=-1 ) {
//
//                    return true;
//                }
//                else if(event.getDescription().toLowerCase().indexOf(lowerCaseFilter)!=-1) {
//
//                    return true;
//                }
//               
//               
//                else{
//                                        
//                    btn = new JFXButton("Modifier");
//                    return false;
//                }
//
//            });
//            
//        });
//
//        
//        SortedList<Evenement> sortedData= new SortedList<>(filteredList);
//        
//        sortedData.comparatorProperty().bind(tableviewE.comparatorProperty());
//
//
//        tableviewE.setItems(sortedData);
//        
//        
//
//    }
//
//    @FXML
//    private void searchAction(KeyEvent event) {
//        
//        if(event.getSource().equals(txt_filter)) {
//            
//            filter();
//            addButtonModifEvToTable();
//            addButtonDeleteEvToTable();
//            
//            
//            
//        }
//    }
//
//    @FXML
//    private void goToTopEvenets(ActionEvent event) throws IOException {
//            Parent root = FXMLLoader.load(getClass().getResource("topEvents.fxml"));
//		Scene scene = new Scene(root);
//		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		stage.setScene(scene);
//		stage.show();
//
//                        stage.setScene(scene);
//                new animatefx.animation.ZoomIn(root).play();
//        stage.show();
//    }
//
//    @FXML
//    private void GoToC(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("interfaceCategorie.fxml"));
//		Scene scene = new Scene(root);
//		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		stage.setScene(scene);
//		stage.show();
//
//                        stage.setScene(scene);
//                new animatefx.animation.ZoomIn(root).play();
//        stage.show();
//    }
//    
//    
//    
//    
//  
//}
//
//
//
//  
//
//
//
