module com.example.shoppingsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.shoppingsystem to javafx.fxml;
    exports com.example.shoppingsystem;
}