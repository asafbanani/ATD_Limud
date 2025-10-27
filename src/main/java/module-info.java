module com.example.atd_limud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports controllers;
    opens controllers to javafx.fxml;

    exports atd_limud;
    opens atd_limud to javafx.fxml;
}
