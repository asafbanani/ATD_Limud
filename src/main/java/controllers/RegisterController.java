package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private Button clickHereButton;

    @FXML
    private Label registerMessageLabel;

    @FXML
    private Button registerButton;

    @FXML
    private TextField usernameTextfield;

    @FXML
    private PasswordField passwordPasswordfield;

    @FXML
    private PasswordField rePasswordfield;

    @FXML
    private TextField emailTextfield;







    public void registerButtonOnAction(ActionEvent e)
    {
        if(usernameTextfield.getText().isBlank() || passwordPasswordfield.getText().isBlank() || rePasswordfield.getText().isBlank()|| emailTextfield.getText().isBlank()){
            registerMessageLabel.setText("Please fill all the fields.");
        }
        else if(!passwordPasswordfield.getText().equals(rePasswordfield.getText())){
            registerMessageLabel.setText("Password and confirm password fields not match.");

        }
        else{registerMessageLabel.setText("Thank you for joining us!");}
    }


    public void clickHereButtonOnAction(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/screens/login.fxml"));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
