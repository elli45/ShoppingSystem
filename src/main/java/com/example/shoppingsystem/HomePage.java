package com.example.shoppingsystem;

import javafx.application.Application;
import javafx.collections.FXCollections;
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
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomePage extends Application implements Initializable {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomePage.class.getResource("home-view.fxml"));
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

    @FXML
    private ListView<String> groupingList;

    private String[] commodity = {"All Commodities","Grocery" , "Break fast","Protein","Dairy","Fruit and Vegetables","Snacks"};

    @FXML
    private ChoiceBox<String> choiceFilter;
    @FXML
    private Label showGroupLabel;
    @FXML
    private Button goToPreviousPageButton;
    @FXML
    private Button goToNextPageButton;
    @FXML
    private Label page;
    @FXML
    private ChoiceBox<String> brandFilter;
    @FXML
    private Label brandName;
    ArrayList<String> brands = new ArrayList<String>();
    private String choiceBoxOption = "Filter";
    String groupListItem  = "All Commodities";
    String brandListItem;
    private ObservableList<String> choiceBoxOptions =
            FXCollections.observableArrayList(
                    "Clear filters",
                    "Cheapest to most expensive",
                    "Most expensive to cheapest",
                    "Based on points");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        brandFilter.setValue("Brands");
        brandFilter.getSelectionModel().selectFirst();
        brandListItem = "Brands";
        ObservableList<String> observableList = FXCollections.observableArrayList(brands);
        brandFilter.setItems(observableList);
        brandFilter.getItems().add(0,"All brands");

        groupingList.getItems().addAll(commodity);
        groupingList.setStyle("-fx-font-family: Century Gothic; -fx-font-size: 13px;");
        groupingList.getSelectionModel().selectFirst();
        groupingList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> listView) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                            setBackground(null);
                        } else {
                            setText(item);
                            setAlignment(Pos.CENTER);
                            if (getIndex() % 2 == 0){
                                setBackground(new Background(new BackgroundFill(Color.rgb(178,235,249), null, null)));
                            }else {
                                setBackground(new Background(new BackgroundFill(Color.rgb(144,209,242),null,null)));
                            }
                        }
                    }
                };
            }
        });

        groupingList.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
//                String selectedItem = groupingList.getSelectionModel().getSelectedItem();
//                showGroupLabel.setText("Group: " + selectedItem);
//                choiceBoxOption = choiceFilter.getValue();
//                ObservableList<String> observableList1 = FXCollections.observableArrayList(brands);
//                brandFilter.setItems(observableList1);
//                brandFilter.getItems().add(0,"All brands");
//                brandFilter.getSelectionModel().selectFirst();
//                switch (selectedItem){
//                    case "All Commodities" :
//                        switch (choiceBoxOption) {
//                            case "Clear filters", "Filters":
//                                selectCommodities("AllCommodities","Date",false,brandListItem);
//                                break;
//                            case "Cheapest to most expensive" :
//                                selectCommodities("AllCommodities","Price",true,brandListItem);
//                                break;
//                            case "Most expensive to cheapest" :
//                                selectCommodities("AllCommodities","Price",false,brandListItem);
//                                break;
//                            case "Based on points":
//                                selectCommodities("AllCommodities","Ratio",false,brandListItem);
//                                break;
//                        }
//                        break;
//                    case "Grocery" :
//                        switch (choiceBoxOption) {
//                            case "Clear filters", "Filters":
//                                selectCommodities("GroceryCommodities","Date",false,brandListItem);
//                                break;
//                            case "Cheapest to most expensive" :
//                                selectCommodities("GroceryCommodities","Price",true,brandListItem);
//                                break;
//                            case "Most expensive to cheapest" :
//                                selectCommodities("GroceryCommodities","Price",false,brandListItem);
//                                break;
//                            case "Based on points":
//                                selectCommodities("GroceryCommodities","Ratio",false,brandListItem);
//                                break;
//                        }
//                        break;
//                    case "Break fast" :
//                        switch (choiceBoxOption) {
//                            case "Clear filters", "Filters":
//                                selectCommodities("BreakFastCommodities","Date",false,brandListItem);
//                                break;
//                            case "Cheapest to most expensive" :
//                                selectCommodities("BreakFastCommodities","Price",true,brandListItem);
//                                break;
//                            case "Most expensive to cheapest" :
//                                selectCommodities("BreakFastCommodities","Price",false,brandListItem);
//                                break;
//                            case "Based on points":
//                                selectCommodities("BreakFastCommodities","Ratio",false,brandListItem);
//                                break;
//                        }
//                        break;
//                    case  "Protein" :
//                        switch (choiceBoxOption) {
//                            case "Clear filters", "Filters":
//                                selectCommodities("ProteinCommodities","Date",false,brandListItem);
//                                break;
//                            case "Cheapest to most expensive" :
//                                selectCommodities("ProteinCommodities","Price",true,brandListItem);
//                                break;
//                            case "Most expensive to cheapest" :
//                                selectCommodities("ProteinCommodities","Price",false,brandListItem);
//                                break;
//                            case "Based on points":
//                                selectCommodities("ProteinCommodities","Ratio",false,brandListItem);
//                                break;
//                        }
//                        break;
//                    case "Dairy" :
//                        switch (choiceBoxOption) {
//                            case "Clear filters", "Filters":
//                                selectCommodities("DairyCommodities","Date",false,brandListItem);
//                                break;
//                            case "Cheapest to most expensive" :
//                                selectCommodities("DairyCommodities","Price",true,brandListItem);
//                                break;
//                            case "Most expensive to cheapest" :
//                                selectCommodities("DairyCommodities","Price",false,brandListItem);
//                                break;
//                            case "Based on points":
//                                selectCommodities("DairyCommodities","Ratio",false,brandListItem);
//                                break;
//                        }
//                        break;
//                    case "Fruit and Vegetables" :
//                        switch (choiceBoxOption) {
//                            case "Clear filters", "Filters":
//                                selectCommodities("FruitAndVegetablesCommodities","Date",false,brandListItem);
//                                break;
//                            case "Cheapest to most expensive" :
//                                selectCommodities("FruitAndVegetablesCommodities","Price",true,brandListItem);
//                                break;
//                            case "Most expensive to cheapest" :
//                                selectCommodities("FruitAndVegetablesCommodities","Price",false,brandListItem);
//                                break;
//                            case "Based on points":
//                                selectCommodities("FruitAndVegetablesCommodities","Ratio",false,brandListItem);
//                                break;
//                        }
//                        break;
//                    case "Snacks" :
//                        switch (choiceBoxOption) {
//                            case "Clear filters", "Filters":
//                                selectCommodities("SnackCommodities","Date",false,brandListItem);
//                                break;
//                            case "Cheapest to most expensive" :
//                                selectCommodities("SnackCommodities","Price",true,brandListItem);
//                                break;
//                            case "Most expensive to cheapest" :
//                                selectCommodities("SnackCommodities","Price",false,brandListItem);
//                                break;
//                            case "Based on points":
//                                selectCommodities("SnackCommodities","Ratio",false,brandListItem);
//                                break;
//                        }
//                        break;
//                }
//                ObservableList<String> observableList2 = FXCollections.observableArrayList(brands);
//                brandFilter.setItems(observableList2);
//                brandFilter.getItems().add(0,"All brands");
//                brandFilter.getSelectionModel().selectFirst();
//                System.out.println("Selected item: " + selectedItem);
            }
        });

        choiceFilter.setItems(choiceBoxOptions);
        choiceFilter.setValue("Filters");
        choiceFilter.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            groupListItem = groupingList.getSelectionModel().getSelectedItem();
//            selectCommoditiesByChoiceFilter(groupListItem,newValue);
        });
        brandFilter.valueProperty().addListener((observableValue, oldValue, newValue) -> {
            groupListItem = groupingList.getSelectionModel().getSelectedItem();
            brandListItem = newValue;
            brandName.setText("Brand: " + newValue);
//            selectCommoditiesByChoiceFilter(groupListItem,choiceFilter.getValue());

        });
//        checkToVisibleNextButton();
//        checkToVisiblePreviousButton();

        //database
        MyDatabase myDatabase = new MyDatabase();
        myDatabase.openDatabase();

        //for listing commodities
        List<Commodity> allCommodities = null;
        try {

            allCommodities = myDatabase.getAllCommodities();
            displayCommodities(gridPane, allCommodities);

            //next & previous buttons
            if (allCommodities.size() < 18) {
                goToNextPageButton.setVisible(false);
                goToPreviousPageButton.setVisible(false);
                page.setVisible(false);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("problem in displaying all commodities - "+e.getMessage());
        }

        //action = when each commodity is clicked

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

        //action of add button
        imgAdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("dododo "+ commodity.price);
            }
        });

        //action of item
        vBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("commodidy-details-view.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setWidth(700);
                stage.setHeight(400);
                stage.setScene(scene);
                stage.show();
            }
        });

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-in-up-view.fxml"));
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

    public void test(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 1) {

        }
    }
}