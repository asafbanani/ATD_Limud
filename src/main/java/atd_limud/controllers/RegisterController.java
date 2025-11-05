package atd_limud.controllers;

import atd_limud.models.User;
import atd_limud.services.AuthService;
import atd_limud.utils.InputValidator;
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
    private final AuthService authService = new AuthService();


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
        String username = usernameTextfield.getText();
        String password = passwordPasswordfield.getText();
        String rePassword = rePasswordfield.getText();
        String email = emailTextfield.getText();

        if(username.isEmpty() || password.isEmpty() || rePassword.isEmpty() || email.isEmpty()){
            registerMessageLabel.setText("Please fill all the fields.");
            return;
        }

        else if(!InputValidator.isValidUsername(username)) {
            registerMessageLabel.setText("Please enter a valid username. (max 20 characters)");
            return;
        }

        else if(!InputValidator.isValidEmail(email)) {
            registerMessageLabel.setText("Please enter a valid email address.");
            return;
        }
        else if(!InputValidator.isValidPassword(password)) {
            registerMessageLabel.setText("Please enter a valid password. (max 30 characters)");
            return;
        }
        else if(!password.equals(rePassword)){
            registerMessageLabel.setText("Password and confirm password fields not match.");
            return;
        }
        else if(authService.CheckIsExistUser(username))
        {
            registerMessageLabel.setText("Username already exists.");
            return;
        }
        else if(authService.CheckIsExistUser(username)){
            registerMessageLabel.setText("Username already exists.");
            return;
        }

        else{
            registerMessageLabel.setText("Thank you for joining us!");
            String userId = authService.generateUserId();
            User newUser = new User(userId,username, password, email, null);
            authService.registerUser(newUser);
        }
    }


    public void clickHereButtonOnAction(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/screens/login.fxml"));
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

}
