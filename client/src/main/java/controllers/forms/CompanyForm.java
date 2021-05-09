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
import view.ViewController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CompanyForm extends ViewController implements Initializable {

    private ArrayList<Company> companies;
    private ObservableList companyList = FXCollections.observableArrayList();

    @FXML
    private ComboBox companySelector;

    @FXML
    private TextField companyNameField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    @FXML
    private void updateFields(){
        HomeController controller = (HomeController) this.manager.getController();
        companyNameField.setText(controller.getCurrentCompany().getName());
    }

    @Override
    public void shouldUpdate() {
        updateFields();
    }

}
