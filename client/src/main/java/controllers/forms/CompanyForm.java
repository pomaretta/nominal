/*

 Nominal Application
 Nominal FX Company Form

 @author     Carlos Pomares
 Date        2021-05-04

*/

package controllers.forms;

import application.NominalFX;
import common.company.Company;
import controllers.HomeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import optimization.Cache;
import view.ViewController;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CompanyForm extends ViewController implements Initializable {

    @FXML
    private ComboBox companySelector;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField stateField;
    @FXML
    private TextField cifField;
    @FXML
    private TextField streetAddressField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField socialSecurityField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @Override
    public void run() {
        updateFields();
    }

    @FXML
    public void updateFields() {
        HomeController controller = (HomeController) this.manager.getController();
        idField.setText(String.valueOf(controller.getCurrentCompany().getId()));
        nameField.setText(controller.getCurrentCompany().getName());
        stateField.setText(controller.getCurrentCompany().getState());
        cifField.setText(controller.getCurrentCompany().getCif());
        streetAddressField.setText(controller.getCurrentCompany().getStreetAddress());
        phoneNumberField.setText(controller.getCurrentCompany().getPhoneNumber());
        socialSecurityField.setText(controller.getCurrentCompany().getSocialSecurityId());
    }

    @Override
    public void shouldUpdate() {
        updateFields();
    }
}
