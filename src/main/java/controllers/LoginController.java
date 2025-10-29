package controllers;
import services.AuthService;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {

    private final AuthService authService = new AuthService();
    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextfield;

    @FXML
    private PasswordField passwordPasswordfield;


    public void registerButtonOnAction(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/screens/register.fxml"));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void loginButtonOnAction(ActionEvent event)
    {
        String username = usernameTextfield.getText();
        String password = passwordPasswordfield.getText();

        if (username.isBlank() || password.isBlank()) {
            loginMessageLabel.setText("Please enter username and password");
            return;
        }

        try {
            boolean success = authService.validateLogin(username, password);
            if (success) {
                loginMessageLabel.setText("Login successful! Welcome " + username);
            } else {
                loginMessageLabel.setText("Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            loginMessageLabel.setText("Database error, please try again later");
        }
    }


}
