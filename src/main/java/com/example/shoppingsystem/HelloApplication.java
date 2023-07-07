package com.example.shoppingsystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloApplication extends Application implements Initializable {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @FXML
    GridPane gridPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("kala_item_view.fxml"));
//        try {
//            Scene scene = new Scene(fxmlLoader.load());
//            Label lbl = (Label) scene.lookup("#title00");
//            lbl.setText("wowowow");
//            Parent item = scene.getRoot();
//            item.setId("one");
//            //gridPane.add(item,0, 0);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



        //parms2 = column, parms3 = row [6X6]
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                gridPane.add(creatItemView(),i,j);
            }
        }


    }

    private static VBox creatItemView(){
        ImageView img = new ImageView("milk.png");
        img.setFitWidth(60);
        img.setFitHeight(60);

        Label label = new Label("Milk");
        label.setStyle("-fx-font-size: 16");
        label.setAlignment(Pos.CENTER_LEFT);

        Label label2 = new Label("5");
        ImageView imgRating = new ImageView("star.png");
        imgRating.setFitWidth(20);
        imgRating.setFitHeight(20);

        Label label3 = new Label("");
        ImageView imgAdd = new ImageView("add.png");
        imgAdd.setFitWidth(20);
        imgAdd.setFitHeight(20);
        HBox hBox = new HBox(label2,imgRating, label3, imgAdd);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(7.0);

        Label lblPrice = new Label("100 Afg");
        lblPrice.setStyle("-fx-font-size: 14; -fx-text-fill: blue");

        VBox vBox = new VBox(img, label, hBox, lblPrice);
        vBox.setMaxHeight(Region.USE_COMPUTED_SIZE);
        vBox.setMaxWidth(Region.USE_COMPUTED_SIZE);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5.0);
        vBox.setStyle("-fx-background-color: white");

        return vBox;
    }
    public void goToNextPageButtonOnAction(ActionEvent event) {

    }

    public void goToPreviousPageButtonOnAction(ActionEvent event) {

    }

    public void switchToLoginScene(ActionEvent event) {

    }

}