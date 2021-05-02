package controllers;

import application.NominalFX;
import application.Views;
import common.auth.User;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import persistence.auth.AuthenticationException;
import util.MD5;
import view.BaseController;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeController extends BaseController implements Initializable {

    private double xOffset, yOffset;

    @FXML
    private AnchorPane root;

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

    @FXML
    public void logoutHandler(){
        this.stageManager.switchScenes(Views.LOGIN);
    }

}
