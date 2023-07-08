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
import java.sql.SQLException;
import java.util.List;
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

        //database
        MyDatabase myDatabase = new MyDatabase();
        myDatabase.openDatabase();

        List<Commodity> allCommodities = null;
        try {
            allCommodities = myDatabase.getAllCommodities();
            displayCommodities(gridPane, allCommodities);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("problem in displaying all commodities - "+e.getMessage());
        }

    }

    private static VBox creatItemView(Commodity commodity){
        ImageView img = new ImageView("yogurt.png");
        img.setFitWidth(60);
        img.setFitHeight(60);

        Label label = new Label(commodity.type);
        label.setStyle("-fx-font-size: 16");
        label.setAlignment(Pos.CENTER_LEFT);

        Label label2 = new Label(String.valueOf(commodity.ratio));
        ImageView imgRating = new ImageView("star.png");
        imgRating.setFitWidth(20);
        imgRating.setFitHeight(20);

        Label label3 = new Label(String.valueOf(commodity.number));
        ImageView imgAdd = new ImageView("add.png");
        imgAdd.setFitWidth(20);
        imgAdd.setFitHeight(20);
        HBox hBox = new HBox(label2,imgRating, label3, imgAdd);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(7.0);

        Label lblPrice = new Label(String.valueOf(commodity.price)+"Afg");
        lblPrice.setStyle("-fx-font-size: 14; -fx-text-fill: blue");

        VBox vBox = new VBox(img, label, hBox, lblPrice);
        vBox.setMaxHeight(Region.USE_COMPUTED_SIZE);
        vBox.setMaxWidth(Region.USE_COMPUTED_SIZE);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5.0);
        vBox.setStyle("-fx-background-color: white");

        return vBox;
    }

    private static void displayCommodities(GridPane gridPane, List<Commodity> allCommodities){
        for (int i = 0; i < allCommodities.size(); i++) {
            if (i <= 6) {
                gridPane.add(creatItemView(allCommodities.get(i)),i,0);
                System.out.println(i+"0");
            }else if (i <= 13){
                System.out.println("-"+(i-7)+1);
                gridPane.add(creatItemView(allCommodities.get(i)),i-7,1);
            }else if (i <= 19){
                System.out.println("--"+(i-14)+2);
                gridPane.add(creatItemView(allCommodities.get(i)),i-14,2);
            }
        }
    }

    public void goToNextPageButtonOnAction(ActionEvent event) {

    }

    public void goToPreviousPageButtonOnAction(ActionEvent event) {

    }

    public void switchToLoginScene(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login-scene.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}