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
import view.ViewController;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class EmployeeForm extends ViewController implements Initializable {

    private HomeController controller;

    private ObservableList<String> employeeList;

    private Employee currentEmployee;

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
    private TextField stateField;
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
    private TextField hiredHoursField;

    @FXML
    private Button contractSaveButton;

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

    }

    @Override
    public void run() {
        controller = (HomeController) this.manager.getController();
        this.employeeList = FXCollections.observableArrayList();
        this.categoryList = FXCollections.observableArrayList();
        updateEmployees();
    }

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

    private void updateFields(){

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
        this.stateField.setText(this.currentEmployee.getStreetAddress());
        this.streetField.setText(this.currentEmployee.getStreetAddress());
        this.phoneNumberField.setText(this.currentEmployee.getPhoneNumber());

        // CONTRACT
        this.irpfField.setText(String.valueOf(this.currentEmployee.getIrpf()));
        this.hourlyCheck.setSelected(this.currentEmployee.isHourly());
        this.hiredHoursField.setText(String.valueOf(this.currentEmployee.getHiredHours()));

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

    private void setCategory() throws SQLException {
        this.categoryList.clear();
        int index = 0;
        int count = 0;
        for(Category c : NominalFX.nominalAPI.getCategories(this.controller.getCurrentCompany().getAgreement().getId())){
            if (c.getId() == this.currentEmployee.getCategory().getId()){
                index = count;
            }
            this.categoryList.add(c.getName());
            count++;
        }
        this.categoryComboField.setItems(categoryList);
        this.categoryComboField.getSelectionModel().select(index);
    }

    private void setSalaryView() throws SQLException {

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

    private void setAntiquityView() throws SQLException {

        // CHANGE THIS
        Antiquity antiquity = NominalFX.nominalAPI.getAntiquityByFields(
                this.controller.getCurrentCompany().getAgreement()
                ,this.currentEmployee.getCategory()
                ,this.controller.getCurrentCompany().getQuotation()
                ,this.currentEmployee.calculateYears()
        );

        TableColumn<Salary,String> column = new TableColumn<>("Quotation");
        column.setCellValueFactory(new PropertyValueFactory<>("quotation"));

        TableColumn<Salary,String> column2 = new TableColumn<>("Category");
        column2.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Salary,String> column3 = new TableColumn<>("Years");
        column3.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Salary,String> column4 = new TableColumn<>("Value");
        column3.setCellValueFactory(new PropertyValueFactory<>("value"));

        antiquityView.getColumns().add(column);
        antiquityView.getColumns().add(column2);
        antiquityView.getColumns().add(column3);
        antiquityView.getColumns().add(column4);

        antiquityView.getItems().add(antiquity);

    }

    @Override
    public void shouldUpdate() {
        updateEmployees();
    }

}
