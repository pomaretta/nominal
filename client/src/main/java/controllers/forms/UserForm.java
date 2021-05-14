package controllers.forms;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import view.ViewController;
import java.net.URL;
import java.util.ResourceBundle;

public class UserForm extends ViewController implements Initializable {


    @FXML
    ComboBox selectUser;

    @FXML
    Button newUser;

    @FXML
    Button successUser;

    @FXML
    TextField identificatorField;

    @FXML
    TextField nameUser;

    @FXML
    PasswordField passwordUser;



    @FXML

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void run() {

    }

    @Override
    public void shouldUpdate() {

    }
}
