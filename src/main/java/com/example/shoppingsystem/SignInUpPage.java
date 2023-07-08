package com.example.shoppingsystem;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInUpPage implements Initializable {
    @FXML
    private TextField usernameTextField;
    @FXML
    private Hyperlink forgottenPasswordHyperlink;
    @FXML
    private Hyperlink createAccountHyperlink;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ImageView visibilityImageView;
    @FXML
    private Button loginButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ComboBox<String> comboBox;

    private Image visibleIcon;
    private Image invisibleIcon;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] roles = {"User", "Seller", "Admin"};
        comboBox.setItems(FXCollections.observableArrayList(roles));
        comboBox.setValue(comboBox.getItems().get(0));

        // images
        try {
            visibleIcon     = new Image(new FileInputStream("src\\main\\resources\\com\\example\\" +
                    "shopapplication\\icons\\visible.png"));
            invisibleIcon   = new Image(new FileInputStream("src\\main\\resources\\com\\example\\" +
                    "shopapplication\\icons\\invisible.png"));
            visibilityImageView.setImage(invisibleIcon);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }

    public void close() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        System.out.println("LoginController.close");

    }

    public void login() {
        if (usernameTextField.getText().equals("") || getPasswordText().equals("")) { // if a field is empty
            loginMessageLabel.setTextFill(Color.RED);
            loginMessageLabel.setText("Enter username and password fields.");

        } else { // check inputs
            String username = usernameTextField.getText();
            String password = getPasswordText();
            boolean validation = false;

            switch (comboBox.getValue()) { // validate base on combo box value
                case "User":
                    validation = SignInUp.validateUserLogin(username, password);
                    break;
                case "Seller":
                    validation = SignInUp.validateSellerLogin(username, password);
                    break;
                case "Admin":
                    validation = SignInUp.validateAdminLogin(username, password);
                default:
                    System.out.println(new Exception("combo box selection does not exist."));
            }

            if (validation) { // if inputs are correct
                loginMessageLabel.setTextFill(Color.GREEN);
                loginMessageLabel.setText("Welcome!");
            } else { // invalid inputs
                loginMessageLabel.setTextFill(Color.RED);
                loginMessageLabel.setText("Username or password is invalid.");
            }
        }
    }

    public void switchToSignUp() {
        System.out.println("LoginController.switchToSignUp");
    }

    public void switchToPasswordRestoration() {
        System.out.println("LoginController.switchToPasswordRestoration");
    }

    public void switchVisibilityIcon() {
        if (visibilityImageView.getImage() == invisibleIcon) {
            visibilityImageView.setImage(visibleIcon);
            passwordTextField.      setVisible(true);
            passwordPasswordField.  setVisible(false);
            passwordTextField.setText(passwordPasswordField.getText());

        } else {
            visibilityImageView.setImage(invisibleIcon);
            passwordPasswordField.  setVisible(true);
            passwordTextField.      setVisible(false);
            passwordPasswordField.setText(passwordTextField.getText());
        }

    }

    private String getPasswordText() {
        return passwordTextField.isVisible()
                ? passwordTextField.getText()
                : passwordPasswordField.getText();
    }
}
