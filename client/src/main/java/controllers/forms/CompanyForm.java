/*

 Nominal Application
 Nominal FX Company Form

 @author     Carlos Pomares
 Date        2021-05-04

*/

package controllers.forms;

import application.NominalFX;
import common.company.Company;
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
    private ObservableList companyList = FXCollections.observableArrayList();
    private ArrayList<Company> companies;
    private ArrayList<Object> objectsList = new ArrayList<>();

    private Cache cache = new Cache();

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
        try {
            companies = new ArrayList<>(NominalFX.nominalAPI.getCompaniesMinimal());
        } catch (SQLException throwables) {
            //
        }
        for (Company c : companies){
            companyList.add(c.getName());
        }

        companySelector.setItems(companyList);


    }

    @FXML
    public void updateFields() throws SQLException {

        if (cache.containsCompany(companies.get(companySelector.getSelectionModel().getSelectedIndex()).getId())){
            idField.setText(String.valueOf(cache.getCompanyById(companies.get(companySelector.getSelectionModel().getSelectedIndex()).getId()).getId()));
            nameField.setText(String.valueOf(cache.getCompanyById(companies.get(companySelector.getSelectionModel().getSelectedIndex()).getId()).getName()));
            stateField.setText(String.valueOf(cache.getCompanyById(companies.get(companySelector.getSelectionModel().getSelectedIndex()).getId()).getState()));
            cifField.setText(String.valueOf(cache.getCompanyById(companies.get(companySelector.getSelectionModel().getSelectedIndex()).getId()).getCif()));
            streetAddressField.setText(String.valueOf(cache.getCompanyById(companies.get(companySelector.getSelectionModel().getSelectedIndex()).getId()).getStreetAddress()));
            phoneNumberField.setText(String.valueOf(cache.getCompanyById(companies.get(companySelector.getSelectionModel().getSelectedIndex()).getId()).getPhoneNumber()));
            socialSecurityField.setText(String.valueOf(cache.getCompanyById(companies.get(companySelector.getSelectionModel().getSelectedIndex()).getId()).getSocialSecurityId()));

        } else {
            cache.add(NominalFX.nominalAPI.getCompanyById(companies.get(companySelector.getSelectionModel().getSelectedIndex()).getId()), cache.getCompanies());
            updateFields();
        }

    }

}
