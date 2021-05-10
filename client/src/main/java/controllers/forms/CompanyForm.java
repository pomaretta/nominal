/*

 Nominal Application
 Nominal FX Company Form

 @author     Carlos Pomares
 Date        2021-05-04

*/

package controllers.forms;

import application.NominalFX;
import common.agreement.Agreement;
import common.agreement.Quotation;
import common.company.Company;
import common.company.Currency;
import controllers.HomeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import optimization.Cache;
import persistence.service.NominalAPI;
import view.ViewController;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CompanyForm extends ViewController implements Initializable {

    private HomeController controller;

    @FXML
    private ImageView companyImage;

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

    // IMAGE
    @FXML
    private Button changeImageButton;
    @FXML
    private Button removeImageButton;

    private ObservableList<String> agreementsList;
    @FXML
    private ComboBox agreementSelector;

    private ObservableList<String> currencyList;
    @FXML
    private ComboBox currencySelector;

    private ObservableList<String> quotationList;
    @FXML
    private ComboBox quotationSelector;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @Override
    public void run() {
        controller = (HomeController) this.manager.getController();
        this.agreementsList = FXCollections.observableArrayList();
        this.currencyList = FXCollections.observableArrayList();
        this.quotationList = FXCollections.observableArrayList();
        updateFields();
    }

    @FXML
    public void updateFields() {
        idField.setText(String.valueOf(controller.getCurrentCompany().getId()));
        nameField.setText(controller.getCurrentCompany().getName());
        stateField.setText(controller.getCurrentCompany().getState());
        cifField.setText(controller.getCurrentCompany().getCif());
        streetAddressField.setText(controller.getCurrentCompany().getStreetAddress());
        phoneNumberField.setText(controller.getCurrentCompany().getPhoneNumber());

        socialSecurityField.setText(controller.getCurrentCompany().getSocialSecurityId());

        try {
            setAgreement();
            setCurrency();
            setQuotation();
        } catch (Exception e){
            //
        }

        setImage();

    }

    private void setAgreement() throws SQLException {
        this.agreementsList.clear();
        int index = 0;
        int count = 0;
        for(Agreement a : NominalFX.nominalAPI.getAgreementsMinimal()){
            if (a.getId() == controller.getCurrentCompany().getAgreement().getId()){
                index = count;
            }
            this.agreementsList.add(a.getName());
            count++;
        }
        this.agreementSelector.setItems(this.agreementsList);
        this.agreementSelector.getSelectionModel().select(index);
    }

    private void setCurrency() throws SQLException {
        this.currencyList.clear();
        int index = 0;
        int count = 0;
        for(Currency c : NominalFX.nominalAPI.getCurrencies()){
            if (c.getId() == controller.getCurrentCompany().getCurrency().getId()){
                index = count;
            }
            this.currencyList.add(c.getDigit());
            count++;
        }
        this.currencySelector.setItems(this.currencyList);
        this.currencySelector.getSelectionModel().select(index);
    }

    private void setQuotation() throws SQLException {
        this.quotationList.clear();
        int index = 0;
        int count = 0;
        for(Quotation q : NominalFX.nominalAPI.getQuotations(this.controller.getCurrentCompany().getAgreement().getId())){
            if (q.getId() == controller.getCurrentCompany().getQuotation().getId()){
                index = count;
            }
            this.quotationList.add(q.getName());
            count++;
        }
        this.quotationSelector.setItems(this.quotationList);
        this.quotationSelector.getSelectionModel().select(index);
    }

    private void setImage() {
        try {
            if(NominalFX.cache.containsImage(NominalFX.imageAPI.getCompanyImageMinimal(this.controller.getCurrentCompany().getId()))){
                this.companyImage.setImage(NominalFX.imageAPI.getCompanyImage(this.controller.getCurrentCompany().getId()).getImage());
            } else {
                NominalFX.cache.add(NominalFX.imageAPI.getCompanyImage(this.controller.getCurrentCompany().getId()),NominalFX.cache.getImages());
                setImage();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            // System.out.println("No image in BBDD.");
        }
    }

    @FXML
    private void uploadImage(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image to upload");
        try {
            File file = fileChooser.showOpenDialog(this.manager.getController().getStageManager().getPrimaryStage());
            if (file != null){
                NominalFX.imageAPI.registerNewCompanyImage(this.controller.getCurrentCompany(),file);
                setImage();
            }
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void shouldUpdate() {
        updateFields();
    }
}
