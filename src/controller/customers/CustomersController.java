package controller.customers;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomersController implements Initializable {
    //    slide menu items
    @FXML public Circle imageCircle ;

    @FXML public Pane openSliderPane;
    @FXML public Pane closeSliderPane;
    @FXML public ImageView openSliderImage;
    @FXML public AnchorPane slider;
    @FXML public AnchorPane x;
//    slide menu items

    //    dashboard   //
//    @FXML public Button dashboardBtn;
//    @FXML public Button sellingBtn;
//    @FXML public Button stockBtn;
//    @FXML public Button suppliersBtn;
//    @FXML public Button billsBtn;
//
    public Stage stage ;
    public Scene scene ;
    public Parent root;
//    dashboard   //

    public void initialize(URL location, ResourceBundle resources) {

        //          slide menu items (there is an error here in the url)
//        Image im = new Image("src/view/images/logo-circle.png", false);
//        imageCircle.setFill(new ImagePattern(im));

        //                  SLIDER                             //
        slider.setTranslateX(-255);
        openSliderPane.setVisible(true);
        closeSliderPane.setVisible(false);

        openSliderImage.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-255);

            slide.setOnFinished((ActionEvent e)-> {
                openSliderPane.setVisible(false);
                closeSliderPane.setVisible(true);
            });
        });

        openSliderPane.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
            System.out.println("kasjdhwo rani nakhdem");
            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-255);

            slide.setOnFinished((ActionEvent e)-> {
                openSliderPane.setVisible(false);
                closeSliderPane.setVisible(true);
            });
        });


        closeSliderPane.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-255);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                openSliderPane.setVisible(true);
                closeSliderPane.setVisible(false);
            });
        });

        x.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-255);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                openSliderPane.setVisible(true);
                closeSliderPane.setVisible(false);
            });
        });

        //                      SLIDER                          //


    }
    //  dashboard   //
    public void dashboardOnClick(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../view/Dashboard/dashboard.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root,1280,679);
        stage.setScene(scene);
        stage.show();
    }

    public void sellingOnClick(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../view/Selling_Entry/selling-entry.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root,1280,679);
        stage.setScene(scene);
        stage.show();
    }

    public void stockOnClick(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../view/Stock/stock.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root,1280,679);
        stage.setScene(scene);
        stage.show();
    }

    public void billsOnClick(ActionEvent actionEvent) throws Exception{
        root = FXMLLoader.load(getClass().getResource("../../view/Purchase_Entry/purchase-entry.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root,1280,679);
        stage.setScene(scene);
        stage.show();
    }
    public void customersOnClick(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../view/Customers/customers.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root,1280,679);
        stage.setScene(scene);
        stage.show();
    }
    public void suppliersOnClick(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../../view/Suppliers/suppliers.fxml"));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root,1280,679);
        stage.setScene(scene);
        stage.show();
    }

//  dashboard   //

    //          SLIDER BUTTONS              //

    public void logOutOnClick(ActionEvent event) throws IOException {
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm logout");
        alert.setHeaderText(null);
        alert.setContentText("Continue logging out?");
        Optional<ButtonType> action =alert.showAndWait();

        if (action.get()==ButtonType.OK){
            Parent root = FXMLLoader.load(getClass().getResource("../../view/Login/login.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root,1280,679);
            stage.setScene(scene);
            stage.show();
        }

    }
    public void exitOnClick(ActionEvent event) {
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm exit");
        alert.setHeaderText(null);
        alert.setContentText("Do you really want to exit?");
        Optional<ButtonType> action =alert.showAndWait();

        if (action.get()==ButtonType.OK){
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    public void homeOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../view/Dashboard/dashboard.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,1280,679);
        stage.setScene(scene);
        stage.show();
    }

    public void creditsOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../view/Credits/credits.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,1280,679);
        stage.setScene(scene);
        stage.show();
    }

}
