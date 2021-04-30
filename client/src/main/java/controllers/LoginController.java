/*

 Nominal Application
 Nominal FX Login Controller

 @author     Carlos Pomares
 Date        2021-04-28

 Last revision
 Date        2021-04-29

*/

package controllers;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import view.BaseController;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends BaseController implements Initializable {

    private double xOffset, yOffset;

    @FXML
    private AnchorPane root;

    @FXML
    private Button loginButton;

    @FXML
    private HBox minimizeButton;

    @FXML
    private HBox exitButton;

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
    private void exitHandler(){
        Platform.exit();
    }

    @FXML
    private void minimizeHandler(){
        this.stageManager.getPrimaryStage().setIconified(true);
    }

}
