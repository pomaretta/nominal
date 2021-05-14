/*

 Nominal Application
 Nominal FX Company Form

 Date        2021-05-04

 Description:
 The companyForm class is a controller
 for the company_creation fxml file.

*/

package controllers.forms;

import application.NominalFX;
import com.sun.org.apache.xpath.internal.operations.Quo;
import common.NominalObject;
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
import java.util.*;

public class CompanyForm extends ViewController implements Initializable {

    // Atribute for the HomeController
    private HomeController controller;

    private HashMap<Integer,ArrayList<Quotation>> quotationMap;
    private int currentAgreement;

    // FXML class atributes
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

    // Initialize.
    @Override
    public void run() {
        controller = (HomeController) this.manager.getController();
        this.agreementsList = FXCollections.observableArrayList();
        this.currencyList = FXCollections.observableArrayList();
        this.quotationList = FXCollections.observableArrayList();
        this.quotationMap = new HashMap<>();

        try {
            setAgreement();
            setQuotation();
            setCurrency();
        } catch (SQLException e){
            System.out.println("PETA" + e.getMessage());
            NominalFX.logger.add("Error while trying to get agreement data.");
        } catch (Exception e){
            //
        }

        updateFields();
    }

    // Method for update the text fields with the data from the database
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
            NominalFX.logger.add("Error while updating company fields.");
        }

        setImage();

    }

    // Method for add the agreements from the database to the agreement list
    private void setAgreement() throws SQLException {
        this.agreementsList.clear();
        int index = 0;
        int count = 0;
        this.agreements = NominalFX.nominalAPI.getAgreementsMinimal();
        if(this.controller.getCurrentCompany() != null){
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
        } else {
            for(Agreement a : this.agreements){
                this.agreementsList.add(a.getName());
            }
        }
        this.agreementSelector.setItems(this.agreementsList);
        this.agreementSelector.getSelectionModel().select(index);
    }

    // Method for add the Currency from the database to the currency list
    private void setCurrency() throws SQLException {
        this.currencyList.clear();
        int index = 0;
        int count = 0;
        this.currencies = NominalFX.nominalAPI.getCurrencies();
        if(this.controller.getCurrentCompany() != null){
            for(Currency c : this.currencies){
                try {
                    if (c.getId() == controller.getCurrentCompany().getCurrency().getId()){
                        index = count;
                    }
                } catch (Exception e){
                    continue;
                }
                this.currencyList.add(c.getDigit());
                count++;
            }
        } else {
            for(Currency c : this.currencies){
                this.currencyList.add(c.getDigit());
            }
        }
        this.currencySelector.setItems(this.currencyList);
        this.currencySelector.getSelectionModel().select(index);
    }

    // Method for add the Quotations from the database to the currency list
    private void setQuotation() throws SQLException {
        this.quotationList.clear();
        int index = 0;
        int count = 0;
        if (this.controller.getCurrentCompany() != null){
            for(Quotation q : NominalFX.nominalAPI.getQuotations(this.controller.getCurrentCompany().getAgreement().getId())){
                try {
                    if (q.getId() == controller.getCurrentCompany().getQuotation().getId()){
                        index = count;
                    }
                } catch (Exception e){
                    continue;
                }
                this.quotationList.add(q.getName());
                count++;
            }
        } else {
            for(Agreement a : this.agreements){
                try {
                    this.quotationMap.put(a.getId(),NominalFX.nominalAPI.getQuotations(a.getId()));
                } catch (SQLException e){
                    // LOGGER
                }
            }
            this.currentAgreement = 1;
            for(Quotation a : this.quotationMap.get(this.currentAgreement)){
                this.quotationList.add(a.getName());
            }
        }
        this.quotationSelector.setItems(this.quotationList);
        this.quotationSelector.getSelectionModel().select(index);
    }

    // This method add the company image from cache
    private void setImage() {
        try {
            if(NominalFX.cache.containsImage(NominalFX.imageAPI.getCompanyImageMinimal(this.controller.getCurrentCompany().getId()))){
                this.companyImage.setImage(NominalFX.imageAPI.getCompanyImage(this.controller.getCurrentCompany().getId()).getImage());
            } else {
                NominalFX.cache.add(NominalFX.imageAPI.getCompanyImage(this.controller.getCurrentCompany().getId()),NominalFX.cache.getImages());
                setImage();
            }
        } catch (Exception e){
             this.companyImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/unknown.jpg"))));
        }
    }

    // This method is a selector for the images
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
            NominalFX.logger.add("No image selected in company logo.");
        }
    }

    // This method save the information of the text Fields from the information tab
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
                NominalFX.logger.add("Error while trying to update company contact.");
            }
        }

        try {
            this.controller.companySelection();
        } catch (Exception e){
            NominalFX.logger.add("Error while trying to update company selection.");
        }
    }

    // This method save the information of the text Fields from the financial tab
    @FXML
    private void saveFinancial(){

        // CURRENCY
        if (
                hasChanged(this.controller.getCurrentCompany().getCurrency().getId(),this.currencies.get(this.currencySelector.getSelectionModel().getSelectedIndex()).getId())
        ) {

            this.controller.getCurrentCompany().setCurrency(this.currencies.get(this.currencySelector.getSelectionModel().getSelectedIndex()));
            try {
                NominalFX.nominalAPI.setCompanyFinancial(this.controller.getCurrentCompany().getId(),this.controller.getCurrentCompany());
            } catch (Exception e){
                NominalFX.logger.add("Error while trying to update company currency.");
            }
        }

        // AGREEMENT
        if (
                hasChanged(this.controller.getCurrentCompany().getAgreement().getId(),this.agreements.get(this.agreementSelector.getSelectionModel().getSelectedIndex()).getId())
        ){
            this.controller.getCurrentCompany().setAgreement(this.agreements.get(this.agreementSelector.getSelectionModel().getSelectedIndex()));
            try {
                NominalFX.nominalAPI.setCompanyAgreement(this.controller.getCurrentCompany().getId(),this.controller.getCurrentCompany());
            } catch (Exception e){
                NominalFX.logger.add("Error while trying to update company agreement.");
            }
        }

        if (
                hasChanged(this.controller.getCurrentCompany().getQuotation().getId(),this.quotations.get(this.quotationSelector.getSelectionModel().getSelectedIndex()).getId())
        ){
            this.controller.getCurrentCompany().setQuotation(this.quotations.get(this.quotationSelector.getSelectionModel().getSelectedIndex()));
            try {
                NominalFX.nominalAPI.setCompanyFinancial(this.controller.getCurrentCompany().getId(),this.controller.getCurrentCompany());
            } catch (Exception e){
                NominalFX.logger.add("Error while trying to update company quotation.");
            }
        }

        this.controller.companySelection();
    }

    // Method to enable the form buttons
    private void enableButtons(){

        creation = false;

        this.saveChangesInformationButton.setVisible(true);
        this.saveChangesFinancialButton.setVisible(true);
        this.changeImageButton.setDisable(false);
        this.nameField.setEditable(false);
        this.cifField.setEditable(false);
        this.socialSecurityField.setEditable(false);
        this.newCompanyButton.setText("New Company");
        this.newCompanyButton.getStyleClass().remove("success");
    }

    // Method to disable the form buttons
    private void disableButtons(){

        creation = true;

        this.companyImage.setImage(new Image(getClass().getResourceAsStream("/images/unknown.jpg")));
        this.saveChangesInformationButton.setVisible(false);
        this.saveChangesFinancialButton.setVisible(false);
        this.changeImageButton.setDisable(true);
        this.cifField.setEditable(true);
        this.nameField.setEditable(true);
        this.socialSecurityField.setEditable(true);
        this.newCompanyButton.setText("Create Company");
        this.newCompanyButton.getStyleClass().add("success");
    }

    // This method clear all the content of the textFields
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

    // Method to create a company with the information of the text fields.
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
                    ,this.quotationMap.get(this.agreements.get(this.agreementSelector.getSelectionModel().getSelectedIndex()).getId()).get(this.quotationSelector.getSelectionModel().getSelectedIndex())
            );

            try {
                NominalFX.nominalAPI.setCompany(company);
            } catch (Exception e){
                NominalFX.logger.add("Error while trying to create new company.");
            }

            this.controller.updateCompanies();
            this.controller.companySelection();
        } else {
            clearAllFields();
        }
    }

    // Methods for check if any of the information has changed
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
