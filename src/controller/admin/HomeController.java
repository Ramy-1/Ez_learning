/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

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
import model.Enseignant;
import model.Etudiant;
import model.Recruteur;
import model.Universite;
import model.User;
import services.ServiceEns;
import services.ServiceEtudiant;
import services.ServiceRecruteur;
import services.ServiceUser;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import services.servicereponse;
import model.reponse;
import services.serviceReclamation;
import model.Reclamation;
import model.societe;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import services.serviceSociete;
import services.serviceUniversite;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {

    ServiceUser sU = new ServiceUser();
    ServiceEtudiant sE = new ServiceEtudiant();
    ServiceEns sEn = new ServiceEns();
    ServiceRecruteur sR = new ServiceRecruteur();

    servicereponse sepr = new servicereponse();

    serviceReclamation srr = new serviceReclamation();
    serviceSociete ssoc = new serviceSociete();
    serviceUniversite sUn = new serviceUniversite();

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
    private double lastX, lastY, lastWidth, lastHeight;
    @FXML
    private Circle close1;

    @FXML
    private void handleButtonAction(MouseEvent event) {
        refreshNodes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        Scrollepane.gets
        refreshNodes();
    }

    private void refreshNodes() {
        pnl_scroll.getChildren().clear();

        List<User> listU = sU.getAll();
        Node[] nodes = new Node[listU.size()];
        int i = 0;

        for (User each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
            ItemController cont = new ItemController();
            try {
                cont.U = each;
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
    private void listUserClicked(ActionEvent event) {
        refreshNodes();
    }

    private void ListEtudiantClicked(ActionEvent event) {
//        boxifyVBoxes();
        pnl_scroll.getChildren().clear();

        List<Etudiant> listU = sE.getAll();
        Node[] nodes = new Node[listU.size()];
        int i = 0;

        for (Etudiant each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
            ItemController cont = new ItemController();
            try {
                cont.U = each;
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

    private void ListEnseignantClicked(ActionEvent event) {
        pnl_scroll.getChildren().clear();

        List<Enseignant> listU = sEn.getAll();
        Node[] nodes = new Node[listU.size()];
        int i = 0;

        for (Enseignant each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
            ItemController cont = new ItemController();
            try {
                cont.U = each;
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

    private void ListRecruteurClicked(ActionEvent event) {
        pnl_scroll.getChildren().clear();

        List<Recruteur> listU = sR.getAll();
        System.out.println(listU);
        Node[] nodes = new Node[listU.size()];
        int i = 0;

        for (Recruteur each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
            ItemController cont = new ItemController();
            try {
                cont.U = each;
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
    public void AddClicked(ActionEvent event) throws IOException {
//        pnl_scroll.getChildren().clear();
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

//        pnl_scroll.getChildren().add(FXMLLoader.load(getClass().getResource("EditItem.fxml")));
    }

    public void reload(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

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
    public void closeWindow() {
        System.exit(0);
    }

    @FXML
    public void ReWindow() {
        re.setOnMouseClicked(events -> {
            Node n = (Node) events.getSource();

            Window w = n.getScene().getWindow();

            double currentX = w.getX();
            double currentY = w.getY();
            double currentWidth = w.getWidth();
            double currentHeight = w.getHeight();

            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();

            if (currentX != bounds.getMinX()
                    && currentY != bounds.getMinY()
                    && currentWidth != bounds.getWidth()
                    && currentHeight != bounds.getHeight()) {

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
    public void MiWindow() {
        mi.setOnMouseClicked(events -> {
            Node n = (Node) events.getSource();

            Window w = n.getScene().getWindow();

            Stage stage = (Stage) w;

            stage.setIconified(true);
        });
    }

    @FXML
    private void RClicked(ActionEvent event) {
        pnl_scroll.getChildren().clear();

        List<Reclamation> listR = srr.afficherReclamation();
        Node[] nodes = new Node[listR.size()];
        int i = 0;

        for (Reclamation each : listR) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
            ReclamationController cont = new ReclamationController();
            try {
                cont.R = each;
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
    private void UniversiteClicked(ActionEvent event) {
        pnl_scroll.getChildren().clear();

        List<reponse> listRep = sepr.afficherReponse();
        Node[] nodes = new Node[listRep.size()];
        int i = 0;

        for (reponse each : listRep) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ReponseRec.fxml"));
            ReclamationController cont = new ReclamationController();
            try {
//                cont.R = each;
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
    private void EvenementClicked(ActionEvent event) {
    }

    @FXML
    private void SendEmailClicked(ActionEvent event) {
        
    }

    @FXML
    private void Societeclick(ActionEvent event) {
        pnl_scroll.getChildren().clear();

        List<societe> listSoc = ssoc.afficherSociete();
        Node[] nodes = new Node[listSoc.size()];
        int i = 0;

        for (societe each : listSoc) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("societe.fxml"));
            SocieteController cont = new SocieteController();
            try {
                cont.Soc = each;
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
    private void LogOutClcked(ActionEvent event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void MyTeam(ActionEvent event) throws Exception {
        User u = new User();
        u.Login("mouhamedrami@esprit.tn","123456");

//        URL url = new URL("http://127.0.0.1:8000/user/listUserJSON");
//        HttpURLConnection http = (HttpURLConnection) url.openConnection();
////        http.setRequestProperty("Accept", "application/json");
//
//        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
//        try (BufferedReader br = new BufferedReader(
//                new InputStreamReader(http.getInputStream(), "utf-8"))) {
//            StringBuilder response = new StringBuilder();
//            String responseLine = null;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//            }
//            System.out.println(response.toString());
//        }
//        http.disconnect();

//        
//        String postUrl = "www.site.com";// put in your url
//        Gson gson = new Gson();
//        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpPost post = new HttpPost(postUrl);
//        StringEntity postingString = new StringEntity(gson.toJson(u));//gson.tojson() converts your pojo to json
//        post.setEntity(postingString);
//        post.setHeader("Content-type", "application/json");
//        HttpResponse response = httpClient.execute(post);
    }
}
