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
import java.util.Objects;
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

    private ObservableList<String> agreementsList;
    private ArrayList<Agreement> agreements;
    @FXML
    private ComboBox agreementSelector;

    private ObservableList<String> currencyList;
    private ArrayList<Currency> currencies;
    @FXML
    private ComboBox currencySelector;

    private ObservableList<String> quotationList;
    private ArrayList<Quotation> quotations;
    @FXML
    private ComboBox quotationSelector;

    @FXML
    private Button saveChangesInformationButton;
    @FXML
    private Button saveChangesFinancialButton;
    @FXML
    private Button newCompanyButton;

    private boolean creation;

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

        enableButtons();

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
        this.agreements = NominalFX.nominalAPI.getAgreementsMinimal();
        for(Agreement a : this.agreements){
            try {
                if (a.getId() == controller.getCurrentCompany().getAgreement().getId()){
                    index = count;
                }
            } catch (Exception e){
                continue;
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
        this.currencies = NominalFX.nominalAPI.getCurrencies();
        for(Currency c : this.currencies){
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
        this.quotations = NominalFX.nominalAPI.getQuotations(this.controller.getCurrentCompany().getAgreement().getId());
        for(Quotation q : this.quotations){
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
             // System.out.println("No image in BBDD.");
             this.companyImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/unknown.jpg"))));
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

    @FXML
    private void saveInformation(){

        if (
                hasChanged(this.controller.getCurrentCompany().getStreetAddress(),streetAddressField.getText())
                ||
                hasChanged(this.controller.getCurrentCompany().getState(),stateField.getText())
                ||
                hasChanged(this.controller.getCurrentCompany().getPhoneNumber(),phoneNumberField.getText())
        ){
            this.controller.getCurrentCompany().setStreetAddress(streetAddressField.getText());
            this.controller.getCurrentCompany().setState(stateField.getText());
            this.controller.getCurrentCompany().setPhoneNumber(phoneNumberField.getText());
            try {
                NominalFX.nominalAPI.setCompanyContact(this.controller.getCurrentCompany().getId(),this.controller.getCurrentCompany());
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }

        try {
            this.controller.companySelection();
        } catch (Exception e){
            //
        }
    }

    @FXML
    private void saveFinancial(){

        // CURRENCY
        System.out.println(this.controller.getCurrentCompany().getCurrency().getId());
        System.out.println(this.currencies.get(this.currencySelector.getSelectionModel().getSelectedIndex()).getId());
        if (
                hasChanged(this.controller.getCurrentCompany().getCurrency().getId(),this.currencies.get(this.currencySelector.getSelectionModel().getSelectedIndex()).getId())
        ) {
            System.out.println("currency");
            System.out.println(this.controller.getCurrentCompany().getCurrency().getId());
            this.controller.getCurrentCompany().setCurrency(this.currencies.get(this.currencySelector.getSelectionModel().getSelectedIndex()));
            System.out.println(this.controller.getCurrentCompany().getCurrency().getId());
            try {
                NominalFX.nominalAPI.setCompanyFinancial(this.controller.getCurrentCompany().getId(),this.controller.getCurrentCompany());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        // AGREEMENT
        if (
                hasChanged(this.controller.getCurrentCompany().getAgreement().getId(),this.agreements.get(this.agreementSelector.getSelectionModel().getSelectedIndex()).getId())
        ){
            System.out.println("agreement");
            this.controller.getCurrentCompany().setAgreement(this.agreements.get(this.agreementSelector.getSelectionModel().getSelectedIndex()));
            try {
                NominalFX.nominalAPI.setCompanyAgreement(this.controller.getCurrentCompany().getId(),this.controller.getCurrentCompany());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        if (
                hasChanged(this.controller.getCurrentCompany().getQuotation().getId(),this.quotations.get(this.quotationSelector.getSelectionModel().getSelectedIndex()).getId())
        ){
            System.out.println("quotation");
            this.controller.getCurrentCompany().setQuotation(this.quotations.get(this.quotationSelector.getSelectionModel().getSelectedIndex()));
            try {
                NominalFX.nominalAPI.setCompanyFinancial(this.controller.getCurrentCompany().getId(),this.controller.getCurrentCompany());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        try {
            this.controller.companySelection();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    private void enableButtons(){

        creation = false;

        this.saveChangesInformationButton.setVisible(true);
        this.saveChangesFinancialButton.setVisible(true);
        this.nameField.setEditable(false);
        this.cifField.setEditable(false);
        this.socialSecurityField.setEditable(false);
        this.newCompanyButton.setText("New Company");
        this.newCompanyButton.getStyleClass().remove("success");
    }

    private void disableButtons(){

        creation = true;

        this.saveChangesInformationButton.setVisible(false);
        this.saveChangesFinancialButton.setVisible(false);
        this.cifField.setEditable(true);
        this.nameField.setEditable(true);
        this.socialSecurityField.setEditable(true);
        this.newCompanyButton.setText("Create Company");
        this.newCompanyButton.getStyleClass().add("success");
    }

    private void clearAllFields(){

        creation = true;

        disableButtons();

        this.idField.setText("");
        this.cifField.setText("");
        this.nameField.setText("");
        this.socialSecurityField.setText("");
        this.stateField.setText("");
        this.agreementSelector.getSelectionModel().select(0);
        this.currencySelector.getSelectionModel().select(0);
        this.quotationSelector.getSelectionModel().select(0);
    }

    @FXML
    private void createNewCompany(){
        if(this.creation){

            Company company = new Company(
                    this.agreements.get(this.agreementSelector.getSelectionModel().getSelectedIndex())
                    ,this.nameField.getText()
                    ,this.cifField.getText()
                    ,this.socialSecurityField.getText()
                    ,this.streetAddressField.getText()
                    ,this.stateField.getText()
                    ,this.phoneNumberField.getText()
                    ,this.currencies.get(this.currencySelector.getSelectionModel().getSelectedIndex())
                    ,this.quotations.get(this.quotationSelector.getSelectionModel().getSelectedIndex())
            );

            try {
                NominalFX.nominalAPI.setCompany(company);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

            try {
                this.controller.companySelection();
            } catch (SQLException sqlException) {
                // LOGGER
            }

        } else {
            clearAllFields();
        }
    }

    private float validateField(String field) throws Exception {
        return Float.parseFloat(field);
    }

    private boolean hasChanged(String original, String modified){
        return !original.equals(modified);
    }

    private boolean hasChanged(float original, float modified){
        return original != modified;
    }

    private boolean hasChanged(boolean original, boolean modified){
        return original != modified;
    }

    private boolean hasChanged(int original, int modified){
        return original != modified;
    }

    @Override
    public void shouldUpdate() {
        updateFields();
    }
}
