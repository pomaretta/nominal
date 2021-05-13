package controllers.forms;

import application.NominalFX;
import common.agreement.Antiquity;
import common.agreement.Salary;
import common.employee.Employee;
import controllers.HomeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.w3c.dom.Text;
import view.ViewController;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PayrollForm extends ViewController implements Initializable {

    private HomeController controller;

    private ObservableList<String> employeeList;

    private Employee currentEmployee;

    @FXML
    private ComboBox employeeSelector;

    @FXML
    private DatePicker scheduleSelector;

    @FXML
    private TabPane payrollPane;

    // INFORMATION

    @FXML
    private TextField idField;

    @FXML
    private TextField companyField;

    @FXML
    private TextField agreementField;

    @FXML
    private TextField secondNameField1;

    @FXML
    private TextField fromField;

    @FXML
    private TextField toField;

    // SALARY

    @FXML
    private TextField baseSalaryField;

    @FXML
    private TextField salaryKindField;

    @FXML
    private TableView salaryComplementsView;

    @FXML
    private  TextField overHoursField;

    @FXML
    private TextField extraHoursField;

    @FXML
    private TextField complementaryHoursField;

    @FXML
    private TextField apportionField;

    // NON SALARY

    @FXML
    private TableView nonSalaryComplementsView;

    @FXML
    private TextField benefitsAndCompensationsField;

    @FXML
    private TextField redundancyPaymentField;

    @FXML
    private TextField otherBenefitsField;

    // REDUCTIONS

    @FXML
    private TextField ccPercentageField;

    @FXML
    private TextField ccValueField;

    @FXML
    private TextField unemploymentPercentageField;

    @FXML
    private TextField unemploymentValueField;

    @FXML
    private TextField trainingPercentageField;

    @FXML
    private TextField trainingValueField;

    @FXML
    private TextField ohPercentageField;

    @FXML
    private TextField ohValueField;

    @FXML
    private TextField ehPercentageField;

    @FXML
    private TextField ehValueField;

    // REDUCTIONS 2

    @FXML
    private TextField irpfPercentageField;

    @FXML
    private TextField irpfValueField;

    @FXML
    private TextField advancePaysPercentageField;

    @FXML
    private TextField salaryKindReductionField;

    @FXML
    private TextField otherReductionField;

    @FXML
    private TextField totalReductionField;

    // TOTAL

    @FXML
    private TextField totalReceivedField;

    // COMMON CONTINGENCIES

    @FXML
    private TextField companyCCValueField;

    @FXML
    private TextField companyCCPercentageField;

    @FXML
    private TextField cEhPercentageField;

    @FXML
    private TextField cEhValueField;

    @FXML
    private TextField cOhValueField;

    @FXML
    private  TextField cOhPercentageField;

    // PROFESSIONAL CONTINGENCIES

    @FXML
    private TextField atPercentageField;

    @FXML
    private TextField atValueField;

    @FXML
    private TextField cUnemploymentPercentageField;

    @FXML
    private TextField cUnemploymentValueField;

    @FXML
    private TextField cTrainingPercentageField;

    @FXML
    private TextField cTrainingValueField;

    @FXML
    private TextField cFogasaPercentageField;

    @FXML
    private TextField cFogasaValueField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void run() {
        controller = (HomeController) this.manager.getController();
        this.employeeList = FXCollections.observableArrayList();
        updateEmployees();
    }

    @FXML
    private void employeeSelection(){
        try {
            this.currentEmployee = this.controller.getCurrentCompany().getEmployees().get(this.employeeSelector.getSelectionModel().getSelectedIndex());
        } catch (IndexOutOfBoundsException e){
            //
        }

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

    private void stablishSalary() throws SQLException {
        Salary salary = NominalFX.nominalAPI.getSalaryTableByFields(this.controller.getCurrentCompany().getAgreement(), this.currentEmployee.getCategory(), this.controller.getCurrentCompany().getQuotation());
    }

    private void stablishAntiquity() throws SQLException {
        Antiquity antiquity = NominalFX.nominalAPI.getAntiquityByFields(this.controller.getCurrentCompany().getAgreement(), this.currentEmployee.getCategory(), this.controller.getCurrentCompany().getQuotation(),this.currentEmployee.calculateYears());
    }

    @Override
    public void shouldUpdate() {
        updateEmployees();
    }

}
