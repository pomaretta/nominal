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
import com.lowagie.text.pdf.ArabicLigaturizer;
import common.agreement.Agreement;
import common.agreement.Antiquity;
import common.agreement.Category;
import common.agreement.Salary;
import common.employee.Employee;
import common.employee.Schedule;
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
import java.util.*;

public class EmployeeForm extends ViewController implements Initializable {

    // Atribute for home controller
    private HomeController controller;

    // List for employees
    private ObservableList<String> employeeList;

    // Atribute for the selected current employee
    private Employee currentEmployee;

    // Current Schedule by Employee selection
    private Schedule currentSchedule;

    // List for Categories
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

    // Initialize
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
            if(NominalFX.nominalAPI.checkEmployee(this.controller.getCurrentCompany().getEmployees().get(this.employeeSelector.getSelectionModel().getSelectedIndex()))){
                this.currentEmployee = NominalFX.nominalAPI.getEmployeeById(this.controller.getCurrentCompany().getEmployees().get(this.employeeSelector.getSelectionModel().getSelectedIndex()).getId());
            } else {
                this.currentEmployee = this.controller.getCurrentCompany().getEmployees().get(this.employeeSelector.getSelectionModel().getSelectedIndex());
            }
        } catch (IndexOutOfBoundsException | SQLException e){
            //
        }
        updateFields();
    }

    // Update the list of employees for the employeeSelector
    private void updateEmployees(){
        this.employeeSelector.getSelectionModel().clearSelection();
        this.employeeList.clear();
        for(Employee e : this.controller.getCurrentCompany().getEmployees()){
            this.employeeList.add(String.format("%s %s",e.getPassport(),e.getName()));
        }
        this.employeeSelector.setItems(this.employeeList);
        this.employeeSelector.getSelectionModel().select(0);
        employeeSelection();
        this.controller.updateNotifications();
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
            NominalFX.logger.add("Error while trying to update employee category.");
        }

        try {
            setSalaryView();
        } catch (SQLException sqlException) {
            salaryView.setDisable(true);
        }

        try {
            setAntiquityView();
        } catch (SQLException sqlException) {
            antiquityView.setDisable(true);
        }

        setImage();

    }
    // This method add the employee image from cach
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

    // Method to get the generated cif for the employee
    @FXML
    private void setGeneratedCif(){
        this.cifField.setText(GenerateDNI.generateDNI().toUpperCase());
    }

    // This method is a selector for the images
    @FXML
    private void uploadImage(){
        try {
            File file = NominalFX.imageAPI.chooseFile(this.manager.getController().getStageManager().getPrimaryStage());
            NominalFX.imageAPI.registerNewEmployeeImage(this.currentEmployee,file);
            setImage();
        } catch (Exception e){
            NominalFX.logger.add("Error while trying to upload new employee image.");
        }
    }

    // Method to select and set the category of the employees
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

    // Add the data for the salaryView
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

    // Add the data for the antiquityView
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

    // This method updates the database with the changed fields from the information tab
    @FXML
    private void saveChangesInformation() {
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
            try {
                NominalFX.nominalAPI.setEmployeeInformation(this.currentEmployee.getId(),this.currentEmployee);
            } catch (SQLException throwables) {
                NominalFX.logger.add("Error while trying to update employee information.");
            }
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
            try {
                NominalFX.nominalAPI.setEmployeeContact(this.currentEmployee.getId(),this.currentEmployee);
            } catch (SQLException throwables) {
                NominalFX.logger.add("Error while trying to update employee contact.");
            }
        }

        updateEmployees();
    }

    // This method updates the database with the changed fields from the contract tab
    @FXML
    private void saveChangesContract() {

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
            try {
                try {
                    this.currentEmployee.setIrpf(validateField(irpfField.getText()));
                } catch (Exception e) {
                    NominalFX.logger.add("Error while parsing IRPF employee field.");
                    throw new Exception(e.getMessage());
                }
                this.currentEmployee.setHourly(this.hourlyCheck.isSelected());
                this.currentEmployee.setApportion(this.apportionCheck.isSelected());
                try {
                    this.currentEmployee.setHiredHours(validateField(this.hiredHoursField.getText()));
                } catch (Exception e) {
                    NominalFX.logger.add("Error while parsing Hired Hours employee field.");
                    throw new Exception(e.getMessage());
                }
                NominalFX.nominalAPI.setEmployeeFinancial(this.currentEmployee.getId(),this.currentEmployee);
            } catch (Exception e){
                NominalFX.logger.add("Error while trying to update employee financial.");
            }
        }

        updateEmployees();
    }

    // Update the category using the category selector
    @FXML
    private void saveChangesCategory() {
        if (
                this.currentEmployee != null
                &&
                hasChanged(this.currentEmployee.getCategory().getId(),this.categories.get(this.categoryComboField.getSelectionModel().getSelectedIndex()).getId())
        ){
            this.currentEmployee.setCategory(this.categories.get(this.categoryComboField.getSelectionModel().getSelectedIndex()));
            try {
                NominalFX.nominalAPI.setEmployeeFinancial(this.currentEmployee.getId(),this.currentEmployee);
            } catch (SQLException throwables) {
                NominalFX.logger.add("Error while trying to update employee category.");
            }
        }
        updateEmployees();
    }

    // This method updates the database with the changed fields from the Schedule tab
    @FXML
    private void saveChangesSchedule() {
        try {
            Schedule schedule = new Schedule(
                    this.currentEmployee
                    ,this.nocturnalCheck.isSelected()
                    ,this.turnicityCheck.isSelected()
                    ,validateField(this.complementaryHoursField.getText())
                    ,validateField(this.extraHoursField.getText())
                    ,validateField(this.overwhelmingHoursField.getText())
            );
            NominalFX.nominalAPI.setEmployeeSchedule(this.currentEmployee,schedule);
        } catch (ValidationException validationException){
            System.out.println(validationException.getMessage());
            NominalFX.logger.add("Error while parsing schedule values.");
        } catch (SQLException sql){
            System.out.println(sql.getMessage());
            NominalFX.logger.add("Database error while trying to create schedule.");
        } catch (Exception e){
            System.out.println(e.getMessage());
            NominalFX.logger.add("Error while trying to create schedule.");
        }
    }

    // This method search a schedule
    @FXML
    private void searchSchedule() {
        try {
            ArrayList<Date> dates = getDates();
            this.currentSchedule = NominalFX.nominalAPI.getScheduleByDateAndEmployee(this.currentEmployee,dates.get(0),dates.get(1));
            System.out.println(this.currentSchedule.getId());
        } catch (SQLException e){
            System.out.println(e.getMessage());
            NominalFX.logger.add("No schedule for employee by selected dates.");
        }
        updateScheduleFields();
    }

    private void updateScheduleFields() {

        ArrayList<Date> dates = getDates();
        this.selectedDateField.setText(String.format("%s-%s",dates.get(0),dates.get(1)));

        this.nocturnalCheck.setSelected(this.currentSchedule.isNocturnal());
        this.turnicityCheck.setSelected(this.currentSchedule.isTurnicity());
        this.complementaryHoursField.setText(String.format("%.2f",this.currentSchedule.getComplementaryHours()));
        this.overwhelmingHoursField.setText(String.format("%.2f",this.currentSchedule.getOverwhelmingHours()));
        this.extraHoursField.setText(String.format("%.2f",this.currentSchedule.getExtraHours()));

    }

    private void clearScheduleFields(){

        this.selectedDateField.setText("");

        this.nocturnalCheck.setSelected(false);
        this.turnicityCheck.setSelected(false);
        this.complementaryHoursField.setText("");
        this.overwhelmingHoursField.setText("");
        this.extraHoursField.setText("");


    }

    // Method to optain the from and to data
    private ArrayList<Date> getDates(){

        LocalDate date = this.scheduleSelector.getValue();
        int toDay = 30;

        if(date.getMonthValue() == 2){
            toDay = 28;
        }

        Date from = Date.valueOf(String.format("%d-%02d-%02d",date.getYear(),date.getMonthValue(),1));
        Date to = Date.valueOf(String.format("%d-%02d-%02d",date.getYear(),date.getMonthValue(),toDay));

        ArrayList<Date> dates = new ArrayList<>();
        dates.add(from);
        dates.add(to);

        return dates;
    }

    // Method for disable all the button of the form
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
        this.changeImageButton.setDisable(true);
        this.salaryView.getItems().clear();
        this.antiquityView.getItems().clear();
    }

    // Method for enable all the button of the form
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
        this.changeImageButton.setDisable(false);
    }

    // This method clear all the content of the textFields
    @FXML
    private void clearAllFields() {

        this.currentEmployee = null;

        this.employeeSelector.setDisable(true);

        this.employeePreviewName.setText("");
        this.employeePreviewPassport.setText("");

        this.cifGenerator.setVisible(true);

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

    // validator for the text fields
    private float validateField(String field) throws ValidationException {
        if(field.equals("")){
            return 0f;
        } else {
            return Float.parseFloat(field);
        }
    }

    // This methos create a new employee with the data of the text Fields
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
                NominalFX.logger.add("Error while validating fields in employee creation. (Check numeric values)");
            } catch (Exception e){
                NominalFX.logger.add("Error while trying to create new employee.");
            }

            updateEmployees();
        }
    }

    // Method for fire it an employee
    @FXML
    private void fireItEmployee(){
        if(this.currentEmployee == null){
            enableButtons();
            employeeSelection();
        } else {
            try {
                NominalFX.nominalAPI.fireEmployee(this.controller.getCurrentCompany(),this.currentEmployee);
                this.controller.getCurrentCompany().updateEmployees();
            } catch (SQLException e){
                NominalFX.logger.add("Error while trying to fire an employee.");
            }
        }
        updateEmployees();
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
        updateEmployees();
    }

}
