package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginController {

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


    public void registerButtonOnAction(ActionEvent e){

    }

    public void loginButtonOnAction(ActionEvent e)
    {
        loginMessageLabel.setText("Trying to login");

        if(!usernameTextfield.getText().isBlank() && !passwordPasswordfield.getText().isBlank()){
            loginMessageLabel.setText("Trying to login");
        }
        else{
            loginMessageLabel.setText("Please enter username and password");

        }
    }


}
