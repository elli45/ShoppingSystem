module com.example.shoppingsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.shoppingsystem to javafx.fxml;
    exports com.example.shoppingsystem;
}