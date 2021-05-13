/*

 Nominal Application
 Employee

 Date        2021-04-23

 Last revision
 Date        2021-04-23

 Description:
 The employeeForm class is a controller
 for the employee_creation fxml file.

*/

package controllers.forms;

import application.NominalFX;
import common.agreement.Antiquity;
import common.agreement.Category;
import common.agreement.Salary;
import common.employee.Employee;
import controllers.HomeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.w3c.dom.Text;
import util.generators.GenerateDNI;
import util.generators.ValidationException;
import view.ViewController;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class EmployeeForm extends ViewController implements Initializable {

    // Atribute for home controller
    private HomeController controller;

    // List for employees.
    private ObservableList<String> employeeList;

    // Atribute to asign the current selected employee
    private Employee currentEmployee;

    // List for Categories.
    private ArrayList<Category> categories;

    // FXML class atributes
    @FXML
    private ComboBox<String> employeeSelector;

    // PREVIEW

    @FXML
    private Label employeePreviewName;
    @FXML
    private Label employeePreviewPassport;

    // INFORMATION

    @FXML
    private Button cifGenerator;
    @FXML
    private Button nafGenerator;

    @FXML
    private TextField cifField;
    @FXML
    private TextField nafField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField secondNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField secondLastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button saveChangesInformation;

    // IMAGE

    @FXML
    private Button changeImageButton;
    @FXML
    private ImageView employeeImage;

    // Contract

    @FXML
    private TextField irpfField;
    @FXML
    private CheckBox hourlyCheck;
    @FXML
    private CheckBox apportionCheck;
    @FXML
    private TextField hiredHoursField;

    @FXML
    private Button contractSaveButton;

    @FXML
    private DatePicker joinDatePicker;

    // CATEGORY

    private ObservableList<String> categoryList;
    @FXML
    private ComboBox categoryComboField;

    @FXML
    private TableView salaryView;

    @FXML
    private TableView antiquityView;

    @FXML
    private Button saveCategoryField;

    // SCHEDULE

    @FXML
    private DatePicker scheduleSelector;

    @FXML
    private TextField selectedDateField;

    @FXML
    private Button searchButton;

    @FXML
    private CheckBox nocturnalCheck;

    @FXML
    private CheckBox turnicityCheck;

    @FXML
    private TextField complementaryHoursField;

    @FXML
    private TextField overwhelmingHoursField;

    @FXML
    private TextField extraHoursField;

    @FXML
    private Button scheduleSaveButton;

    // CONTROLS

    @FXML
    private Button newEmployeeButton;

    @FXML
    private Button fireItButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.cifGenerator.setVisible(false);
        this.nafGenerator.setVisible(false);

    }

    // Initialize
    @Override
    public void run() {
        controller = (HomeController) this.manager.getController();
        this.employeeList = FXCollections.observableArrayList();
        this.categoryList = FXCollections.observableArrayList();
        updateEmployees();
    }

    // Method to select a employee from the selected company
    @FXML
    private void employeeSelection(){
        try {
            this.currentEmployee = this.controller.getCurrentCompany().getEmployees().get(this.employeeSelector.getSelectionModel().getSelectedIndex());
        } catch (IndexOutOfBoundsException e){
            //
        }
        updateFields();
    }

    private void updateEmployees(){
        this.employeeSelector.getSelectionModel().clearSelection();
        this.employeeList.clear();
        for(Employee e : this.controller.getCurrentCompany().getEmployees()){
            this.employeeList.add(String.format("%s %s",e.getPassport(),e.getName()));
        }
        this.employeeSelector.setItems(this.employeeList);
        this.employeeSelector.getSelectionModel().select(0);
        employeeSelection();
    }


    // Method for update the text fields with the data from the database
    private void updateFields(){

        enableButtons();


        // PREVIEW
        this.employeePreviewName.setText(this.currentEmployee.getName());
        this.employeePreviewPassport.setText(this.currentEmployee.getPassport());

        // INFORMATION
        this.cifField.setText(this.currentEmployee.getPassport());
        this.nafField.setText(this.currentEmployee.getNaf());
        this.nameField.setText(this.currentEmployee.getName());
        this.secondNameField.setText(this.currentEmployee.getName2());
        this.lastNameField.setText(this.currentEmployee.getLastName());
        this.secondLastNameField.setText(this.currentEmployee.getLastName2());
        this.emailField.setText(this.currentEmployee.getMailAddress());
        this.streetField.setText(this.currentEmployee.getStreetAddress());
        this.phoneNumberField.setText(this.currentEmployee.getPhoneNumber());

        // CONTRACT
        this.irpfField.setText(String.valueOf(this.currentEmployee.getIrpf()));
        this.hourlyCheck.setSelected(this.currentEmployee.isHourly());
        this.apportionCheck.setSelected(this.currentEmployee.isApportion());
        this.hiredHoursField.setText(String.valueOf(this.currentEmployee.getHiredHours()));
        this.joinDatePicker.setEditable(false);
        this.joinDatePicker.setValue(this.currentEmployee.getJoinDate().toLocalDate());

        // CATEGORY
        try {
            setCategory();
        } catch (Exception e){
            //
        }

        try {
            setSalaryView();
        } catch (SQLException sqlException) {
            //
            salaryView.setDisable(true);
        }

        try {
            setAntiquityView();
        } catch (SQLException sqlException) {
            //
            antiquityView.setDisable(true);
        }

        setImage();

    }

    // This method add the employee image from cache
    private void setImage(){
        try {
            int id = NominalFX.imageAPI.getEmployeeImageMinimal(this.currentEmployee.getId());
            if(NominalFX.cache.containsImage(id)){
                this.employeeImage.setImage(NominalFX.cache.getImageById(id).getImage());
            } else {
                NominalFX.cache.add(NominalFX.imageAPI.getImageById(id),NominalFX.cache.getImages());
                setImage();
            }
        } catch (Exception e){
            this.employeeImage.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/unknown.jpg"))));
        }
    }

    @FXML
    private void uploadImage(){
        try {
            File file = NominalFX.imageAPI.chooseFile(this.manager.getController().getStageManager().getPrimaryStage());
            NominalFX.imageAPI.registerNewEmployeeImage(this.currentEmployee,file);
            setImage();
        } catch (Exception e){
            //
        }
    }

    // Method for add the categories from the database to the currency list.
    private void setCategory() throws SQLException {
        this.categoryList.clear();
        int index = 0;
        int count = 0;
        this.categories = NominalFX.nominalAPI.getCategories(this.controller.getCurrentCompany().getAgreement().getId());
        for(Category c : this.categories){
            if (c.getId() == this.currentEmployee.getCategory().getId()){
                index = count;
            }
            this.categoryList.add(c.getName());
            count++;
        }
        this.categoryComboField.setItems(categoryList);
        this.categoryComboField.getSelectionModel().select(index);
    }

    // Add the data for the salaryView.
    private void setSalaryView() throws SQLException {

        this.salaryView.getItems().clear();
        this.salaryView.getColumns().clear();

        Salary salary = NominalFX.nominalAPI.getSalaryTableByFields(
                this.controller.getCurrentCompany().getAgreement()
                ,this.currentEmployee.getCategory()
                ,this.controller.getCurrentCompany().getQuotation()
        );

        TableColumn<Salary,String> column = new TableColumn<>("Quotation");
        column.setCellValueFactory(new PropertyValueFactory<>("quotation"));

        TableColumn<Salary,String> column2 = new TableColumn<>("Category");
        column2.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Salary,String> column3 = new TableColumn<>("Value");
        column3.setCellValueFactory(new PropertyValueFactory<>("value"));

        salaryView.getColumns().add(column);
        salaryView.getColumns().add(column2);
        salaryView.getColumns().add(column3);

        salaryView.getItems().add(salary);

    }

    // Add the data for the antiquityView.
    private void setAntiquityView() throws SQLException {

        this.antiquityView.getItems().clear();
        this.antiquityView.getColumns().clear();

        // CHANGE THIS
        Antiquity antiquity = NominalFX.nominalAPI.getAntiquityByFields(
                this.controller.getCurrentCompany().getAgreement()
                ,this.currentEmployee.getCategory()
                ,this.controller.getCurrentCompany().getQuotation()
                ,this.currentEmployee.calculateYears()
        );

        TableColumn<Antiquity,String> column = new TableColumn<>("Quotation");
        column.setCellValueFactory(new PropertyValueFactory<>("quotation"));

        TableColumn<Antiquity,String> column2 = new TableColumn<>("Category");
        column2.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Antiquity,String> column3 = new TableColumn<>("Years");
        column3.setCellValueFactory(new PropertyValueFactory<>("years"));

        TableColumn<Antiquity,String> column4 = new TableColumn<>("Value");
        column4.setCellValueFactory(new PropertyValueFactory<>("value"));

        antiquityView.getColumns().add(column);
        antiquityView.getColumns().add(column2);
        antiquityView.getColumns().add(column3);
        antiquityView.getColumns().add(column4);

        antiquityView.getItems().add(antiquity);

    }

    // This method updates the database with the changed fields from the information tab.
    @FXML
    private void saveChangesInformation() throws SQLException {
        if (
                this.currentEmployee != null
                &&
                hasChanged(this.currentEmployee.getName(),this.nameField.getText())
                ||
                hasChanged(this.currentEmployee.getName2(),this.secondNameField.getText())
                ||
                hasChanged(this.currentEmployee.getLastName(),this.lastNameField.getText())
                ||
                hasChanged(this.currentEmployee.getLastName2(),this.secondLastNameField.getText())
        ){
            this.currentEmployee.setName(this.nameField.getText());
            this.currentEmployee.setName2(this.secondNameField.getText());
            this.currentEmployee.setLastName(this.lastNameField.getText());
            this.currentEmployee.setLastName2(this.secondLastNameField.getText());
            NominalFX.nominalAPI.setEmployeeInformation(this.currentEmployee.getId(),this.currentEmployee);
        }

        if (
                this.currentEmployee != null
                &&
                hasChanged(this.currentEmployee.getMailAddress(),this.emailField.getText())
                ||
                hasChanged(this.currentEmployee.getStreetAddress(),this.streetField.getText())
                ||
                hasChanged(this.currentEmployee.getPhoneNumber(),this.phoneNumberField.getText())
        ){
            this.currentEmployee.setMailAddress(this.emailField.getText());
            this.currentEmployee.setStreetAddress(this.streetField.getText());
            this.currentEmployee.setPhoneNumber(this.phoneNumberField.getText());
            NominalFX.nominalAPI.setEmployeeContact(this.currentEmployee.getId(),this.currentEmployee);
        }

        updateEmployees();
    }

    // This method updates the database with the changed fields from the contract tab.
    @FXML
    private void saveChangesContract() throws Exception {

        if (
                this.currentEmployee != null
                        &&
                hasChanged(String.valueOf(this.currentEmployee.getIrpf()),irpfField.getText())
                        ||
                        hasChanged(this.currentEmployee.isHourly(),this.hourlyCheck.isSelected())
                        ||
                        hasChanged(this.currentEmployee.isApportion(),this.apportionCheck.isSelected())
                        ||
                        hasChanged(String.valueOf(this.currentEmployee.getHiredHours()),this.hiredHoursField.getText())
        ){
            this.currentEmployee.setIrpf(validateField(irpfField.getText()));
            this.currentEmployee.setHourly(this.hourlyCheck.isSelected());
            this.currentEmployee.setApportion(this.apportionCheck.isSelected());
            this.currentEmployee.setHiredHours(validateField(this.hiredHoursField.getText()));
            System.out.println(this.hourlyCheck.isSelected());
            NominalFX.nominalAPI.setEmployeeFinancial(this.currentEmployee.getId(),this.currentEmployee);
        }

        updateEmployees();
    }

    // Update the category using the category selector.
    @FXML
    private void saveChangesCategory() throws SQLException {
        if (
                this.currentEmployee != null
                &&
                hasChanged(this.currentEmployee.getCategory().getId(),this.categories.get(this.categoryComboField.getSelectionModel().getSelectedIndex()).getId())
        ){
            this.currentEmployee.setCategory(this.categories.get(this.categoryComboField.getSelectionModel().getSelectedIndex()));
            NominalFX.nominalAPI.setEmployeeFinancial(this.currentEmployee.getId(),this.currentEmployee);
        }

        updateEmployees();
    }

    @FXML
    private void saveChangesSchedule() throws SQLException {

    }

    @FXML
    private void searchSchedule() throws SQLException {

    }

    // Disable all the buttons.
    private void disableButtons(){
        this.employeeSelector.setDisable(true);
        this.saveChangesInformation.setVisible(false);
        this.contractSaveButton.setVisible(false);
        this.salaryView.setDisable(true);
        this.antiquityView.setDisable(true);
        this.saveCategoryField.setVisible(false);
        this.scheduleSelector.setDisable(true);
        this.selectedDateField.setDisable(true);
        this.overwhelmingHoursField.getParent().setVisible(false);
        this.scheduleSaveButton.setVisible(false);
        this.searchButton.setVisible(false);
        this.cifField.setEditable(true);
        this.nafField.setEditable(true);
    }

    // Enable all the buttons
    private void enableButtons(){
        this.employeeSelector.setDisable(false);
        this.saveChangesInformation.setVisible(true);
        this.contractSaveButton.setVisible(true);
        this.salaryView.setDisable(false);
        this.antiquityView.setDisable(false);
        this.saveCategoryField.setVisible(true);
        this.scheduleSelector.setDisable(false);
        this.selectedDateField.setDisable(false);
        this.overwhelmingHoursField.getParent().setVisible(true);
        this.scheduleSaveButton.setVisible(true);
        this.fireItButton.setVisible(true);
        this.newEmployeeButton.setText("New Employee");
        this.newEmployeeButton.getStyleClass().remove("success");
        this.fireItButton.setText("Fire It");
        this.searchButton.setVisible(true);
        this.cifField.setEditable(false);
        this.nafField.setEditable(false);
    }

    // Clear al the textFileds information.
    @FXML
    private void clearAllFields() {

        this.currentEmployee = null;

        this.employeeSelector.setDisable(true);

        this.employeePreviewName.setText("");
        this.employeePreviewPassport.setText("");

        this.cifGenerator.setVisible(true);
        this.nafGenerator.setVisible(true);

        this.cifField.setText("");
        this.nafField.setText("");

        this.cifField.setEditable(true);
        this.nafField.setEditable(true);

        this.nameField.setText("");
        this.secondNameField.setText("");
        this.lastNameField.setText("");
        this.secondLastNameField.setText("");

        this.emailField.setText("");
        this.streetField.setText("");

        this.phoneNumberField.setText("");

        this.saveChangesInformation.setVisible(false);

        this.irpfField.setText("");
        this.hourlyCheck.setSelected(false);
        this.apportionCheck.setSelected(false);
        this.hiredHoursField.setText("");

        this.joinDatePicker.setValue(LocalDate.now());
        this.joinDatePicker.setEditable(true);

        this.contractSaveButton.setVisible(false);
        this.categoryComboField.getSelectionModel().select(0);
        this.salaryView.setDisable(true);
        this.antiquityView.setDisable(true);

        this.saveCategoryField.setVisible(false);

        this.scheduleSelector.setDisable(true);
        this.selectedDateField.setDisable(true);
        this.selectedDateField.setText("");

        this.overwhelmingHoursField.getParent().setVisible(false);
        this.overwhelmingHoursField.setText("");
        this.extraHoursField.setText("");

        this.scheduleSaveButton.setVisible(false);

        this.newEmployeeButton.setText("Create Employee");
        this.newEmployeeButton.getStyleClass().add("success");

        this.fireItButton.setText("Cancel");

        disableButtons();

    }

    private float validateField(String field) throws Exception {
        return Float.parseFloat(field);
    }

    // Method to add a new Employee and set his information.
    @FXML
    private void createNewEmployee(){
        if(this.currentEmployee != null){
            clearAllFields();
        } else {

            try {
                GenerateDNI.validateDNI(this.cifField.getText().toLowerCase());

                Employee employee = new Employee(
                        this.cifField.getText().toUpperCase()
                        ,this.nafField.getText().toUpperCase()
                        ,this.nameField.getText()
                        ,this.secondNameField.getText()
                        ,this.lastNameField.getText()
                        ,this.secondLastNameField.getText()
                        ,this.emailField.getText()
                        ,this.phoneNumberField.getText()
                        ,this.streetField.getText()
                        ,this.categories.get(this.categoryComboField.getSelectionModel().getSelectedIndex())
                        ,Date.valueOf(this.joinDatePicker.getValue())
                        ,null
                        ,true
                        ,this.hourlyCheck.isSelected()
                        ,this.apportionCheck.isSelected()
                        ,validateField(this.hiredHoursField.getText())
                        ,validateField(this.irpfField.getText())
                );

                NominalFX.nominalAPI.setEmployee(this.controller.getCurrentCompany(),employee);

            } catch (ValidationException validationException){
                // LOGGER
            } catch (Exception e){
                // LOG
            }

        }
    }



    @FXML
    private void fireItEmployee(){
        if(this.currentEmployee == null){
            enableButtons();
            employeeSelection();
        } else {
            // Set active = 0 and set expiration date. PROCEDURE??
        }
    }

    private boolean hasChanged(String original, String modified){
        return !original.equals(modified);
    }

    private boolean hasChanged(float original, float modified){
        return !(original == modified);
    }

    private boolean hasChanged(boolean original, boolean modified){
        return original == modified;
    }

    private boolean hasChanged(int original, int modified){
        return original == modified;
    }

    @Override
    public void shouldUpdate() {
        updateEmployees();
    }

}
