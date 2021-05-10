package controllers.forms;

import common.employee.Employee;
import controllers.HomeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import org.w3c.dom.Text;
import view.ViewController;

import java.net.URL;
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
    private Button removeImageButton;
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
        updateEmployees();
    }

    @FXML
    private void employeeSelection(){
        this.currentEmployee = this.controller.getCurrentCompany().getEmployees().get(this.employeeSelector.getSelectionModel().getSelectedIndex());
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


        // CONTRACT


    }

    @Override
    public void shouldUpdate() {
        updateEmployees();
    }

}
