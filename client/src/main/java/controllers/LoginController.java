/*
 Nominal Application
 Login

 Description:
 The LoginController class is a controller
 for the login fxml file.

*/

package controllers;

import application.NominalFX;
import application.Views;
import common.auth.User;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import persistence.auth.AuthenticationException;
import util.MD5;
import view.BaseController;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController extends BaseController implements Initializable {

    private double xOffset, yOffset;

    // FXML classes Attributes
    @FXML
    private AnchorPane root;

    @FXML
    private Button loginButton;

    @FXML
    private HBox minimizeButton;

    @FXML
    private HBox exitButton;

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;

    // Initialize
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // When this controller in called with the stage manager calls this function.
        Font.loadFont(getClass().getResourceAsStream("/fonts/Poppings-Bold.ttf"),12);
        Font.loadFont(getClass().getResourceAsStream("/fonts/Poppings-Light.ttf"),12);
        Font.loadFont(getClass().getResourceAsStream("/fonts/Poppings-Medium.ttf"),12);
        Font.loadFont(getClass().getResourceAsStream("/fonts/Poppings-Regular.ttf"),12);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                    xOffset = mouseEvent.getSceneX();
                    yOffset = mouseEvent.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stageManager.getPrimaryStage().setX(mouseEvent.getScreenX() - xOffset);
                stageManager.getPrimaryStage().setY(mouseEvent.getScreenY() - yOffset);
            }
        });

    }

    // Handler for exit button
    @FXML
    private void exitHandler(){
        Platform.exit();
    }

    // Handler for minimize button
    @FXML
    private void minimizeHandler(){
        this.stageManager.getPrimaryStage().setIconified(true);
    }

    // Handler for user auth, this handler use the nominal_auth_dev db
    @FXML
    private void loginHandler(){
        // SEARCH FOR AN USER WITH GET TEXT FROM EMAIL FIELD
        User user;
        try {
            user = NominalFX.authAPI.getUserByName(emailField.getText());
            if (user.getPassword().equals(MD5.getMD5(passwordField.getText()))) {
                NominalFX.authAPI.setLogedUser(user);
                NominalFX.initializeServices();
                this.stageManager.switchScenes(Views.HOME);
            }
        } catch (AuthenticationException authenticationException){
            NominalFX.logger.add("Bad password.");
        } catch (Exception sqlException){
            NominalFX.logger.add("Error while trying to auth.");
        }
    }

}
