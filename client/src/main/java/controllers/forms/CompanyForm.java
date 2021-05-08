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
import view.ViewController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CompanyForm extends ViewController implements Initializable {
    private ObservableList companielist = FXCollections.observableArrayList();
    private ArrayList<Company> companies;

    @FXML
    private ComboBox companySelector;
    @FXML
    private TextField fieldName;
    @FXML
    private TextField fieldCif;
    @FXML
    private TextField fieldAdress;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            companies = new ArrayList<>(NominalFX.nominalAPI.getCompaniesMinimal());
        } catch (SQLException throwables) {
            //
        }
        for (Company c : companies){
            companielist.add(c.getName());
        }

        companySelector.setItems(companielist);


    }

    @FXML
    public void updateFields(ActionEvent e){
        Object evt = e.getSource();

        if (evt.equals(companySelector)){
            fieldName.setText(companies.get(companySelector.getSelectionModel().getSelectedIndex()).getName());
        }
    }

}
