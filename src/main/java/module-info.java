module com.example.atd_limud {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports atd_limud.controllers;
    opens atd_limud.controllers to javafx.fxml;

    exports atd_limud;
    opens atd_limud to javafx.fxml;
}
