/*

 Nominal Application
 Payroll Form

 Description:
 The PayrollForm class is a controller
 for the payroll_creation fxml file.

*/

package controllers.forms;

import application.NominalFX;
import common.employee.Employee;
import common.payroll.Complement;
import common.payroll.Payroll;
import controllers.HomeController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.view.JasperViewer;
import view.ViewController;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class PayrollForm extends ViewController implements Initializable {

    // Atributte for home contorller
    private HomeController controller;

    // List for employees
    private ObservableList<String> employeeList;

    // Atribute for the current selected employee
    private Employee currentEmployee;

    // Atribute for the selected payroll
    private Payroll currentPayroll;

    // FXML class Atributes
    @FXML
    private ComboBox employeeSelector;

    @FXML
    private DatePicker scheduleSelector;

    @FXML
    private TabPane payrollPane;

    @FXML
    private Label employeePreviewName;

    @FXML
    private Label employeePreviewPassport;

    // INFORMATION

    @FXML
    private TextField idField;

    @FXML
    private TextField companyField;

    @FXML
    private TextField agreementField;

    @FXML
    private TextField employeeNameField;

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
    private TextField advancePaysField;

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

    // CONTROLS
    @FXML
    private Button pdfExport;

    @FXML
    private Button xmlExport;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    // Initialize
    public void run() {
        controller = (HomeController) this.manager.getController();
        this.employeeList = FXCollections.observableArrayList();
        updateEmployees();
        this.xmlExport.setVisible(false);
        this.pdfExport.setVisible(false);
    }

    // Method to select the employee
    @FXML
    private void employeeSelection(){
        try {
            this.currentEmployee = this.controller.getCurrentCompany().getEmployees().get(this.employeeSelector.getSelectionModel().getSelectedIndex());
        } catch (IndexOutOfBoundsException e){
            //
        }
        employeePreviewName.setText(this.currentEmployee.getName());
        employeePreviewPassport.setText(this.currentEmployee.getPassport());
        this.controller.updateNotifications();
    }

    // Method to add the employees to the employees list
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
        baseSalaryField.setText(String.format("%.2f",currentPayroll.getBaseSalary()));
        apportionField.setText(String.format("%.2f",currentPayroll.getApportion()));
        ohPercentageField.setText(String.format("%.2f", currentPayroll.getOhPercentage()));
        ohValueField.setText(String.format("%.2f", currentPayroll.getOhValue()));
        ehPercentageField.setText(String.format("%.2f", currentPayroll.getEhPercentage()));
        ehValueField.setText(String.format("%.2f", currentPayroll.getEhValue()));
        complementaryHoursField.setText(String.format("%.2f", currentPayroll.getSchedule().getComplementaryHours()));
        salaryKindField.setText(String.format("%.2f", currentPayroll.getSalaryKind()));
        benefitsAndCompensationsField.setText(String.format("%.2f", currentPayroll.getBenefitsAndCompesations()));
        redundancyPaymentField.setText(String.format("%.2f", currentPayroll.getRedundancyPayment()));
        otherBenefitsField.setText(String.format("%.2f", currentPayroll.getOtherBenefits()));
        unemploymentPercentageField.setText(String.format("%.2f", currentPayroll.getUnemploymentPercentage()));
        unemploymentValueField.setText(String.format("%.2f", currentPayroll.getUnemploymentValue()));
        trainingPercentageField.setText(String.format("%.2f", currentPayroll.getTrainingPercentage()));
        trainingValueField.setText(String.format("%.2f", currentPayroll.getTrainingValue()));
        idField.setText(String.format("%d", currentPayroll.getId()));
        companyField.setText(String.format("%s", currentPayroll.getCompany().getName()));
        agreementField.setText(String.format("%d", currentPayroll.getAgreement().getId()));
        employeeNameField.setText(String.format("%s", currentPayroll.getEmployee().getName()));
        fromField.setText(String.format("%s", currentPayroll.getFrom()));
        toField.setText(String.format("%s", currentPayroll.getTo()));
        overHoursField.setText(String.format("%.2f", currentPayroll.getSchedule().getOverwhelmingHours()));
        extraHoursField.setText(String.format("%.2f", currentPayroll.getSchedule().getExtraHours()));
        ccPercentageField.setText(String.format("%.2f", currentPayroll.getCcPercentage()));
        ccValueField.setText(String.format("%.2f", currentPayroll.getCcValue()));
        irpfPercentageField.setText(String.format("%.2f", currentPayroll.getIrpfPercentage()));
        irpfValueField.setText(String.format("%.2f", currentPayroll.getIrpfValue()));
        advancePaysField.setText(String.format("%.2f", currentPayroll.getAdvancePays()));
        salaryKindReductionField.setText(String.format("%.2f", currentPayroll.getSalaryKindDeduction()));
        otherReductionField.setText(String.format("%.2f", currentPayroll.getOtherDeduction()));
        totalReceivedField.setText(String.format("%.2f", currentPayroll.getTotalToReceive()));
        totalReductionField.setText(String.format("%.2f", currentPayroll.getTotalDeduction()));
        companyCCValueField.setText(String.format("%.2f", currentPayroll.getCompanyCCValue()));
        companyCCPercentageField.setText(String.format("%.2f,", currentPayroll.getCompanyCCPercentage()));
        cEhPercentageField.setText(String.format("%.2f", currentPayroll.getCompanyEhPercentage()));
        cEhValueField.setText(String.format("%.2f,", currentPayroll.getCompanyEhValue()));
        cOhValueField.setText(String.format("%.2f,", currentPayroll.getCompanyOhValue()));
        cOhPercentageField.setText(String.format("%.2f", currentPayroll.getCompanyOhPercentage()));
        atPercentageField.setText(String.format("%.2f", currentPayroll.getCompanyPCAtPercentage()));
        atValueField.setText(String.format("%.2f", currentPayroll.getCompanyPCAtValue()));
        cUnemploymentPercentageField.setText(String.format("%.2f", currentPayroll.getCompanyPCUnemploymentPercentage()));
        cUnemploymentValueField.setText(String.format("%.2f", currentPayroll.getCompanyPCUnemploymentValue()));
        cTrainingPercentageField.setText(String.format("%.2f", currentPayroll.getCompanyPCTrainingPercentage()));
        cTrainingValueField.setText(String.format("%.2f", currentPayroll.getCompanyPCTrainingValue()));
        cFogasaPercentageField.setText(String.format("%.2f", currentPayroll.getCompanyPCFogasaPercentage()));
        cFogasaValueField.setText(String.format("%.2f", currentPayroll.getCompanyPCFogasaValue()));

        setComplementView(salaryComplementsView,this.currentPayroll.getSalaryComplements());
        setComplementView(nonSalaryComplementsView,this.currentPayroll.getNonSalaryComplements());

        this.xmlExport.setVisible(true);
        this.pdfExport.setVisible(true);

    }

    // Method to add teh data for the complements view
    public void setComplementView(TableView view, ArrayList<Complement> complements){

        view.getItems().clear();
        view.getColumns().clear();

        TableColumn<Complement,String> column = new TableColumn<>("Name");
        column.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Complement,String> column2 = new TableColumn<>("Original Value");
        column2.setCellValueFactory(new PropertyValueFactory<>("originalValue"));

        TableColumn<Complement,String> column3 = new TableColumn<>("Percentage Value");
        column3.setCellValueFactory(new PropertyValueFactory<>("valuePercentage"));

        TableColumn<Complement,String> column4 = new TableColumn<>("Value");
        column4.setCellValueFactory(new PropertyValueFactory<>("value"));

        view.getColumns().add(column);
        view.getColumns().add(column2);
        view.getColumns().add(column3);
        view.getColumns().add(column4);

        for(Complement c : complements){
            view.getItems().add(c);
        }

    }

    // Method to preview the information of the payroll
    @FXML
    private void previewPayroll(){
        try {
            ArrayList<Date> dates = getDates();
            Payroll payroll = Payroll.generatePayroll(this.controller.getCurrentCompany(),this.currentEmployee,dates.get(0),dates.get(1),NominalFX.nominalAPI);
            int id = NominalFX.nominalAPI.setPayroll(payroll);
            this.currentPayroll = NominalFX.nominalAPI.getPayrollById(id);
        } catch (Exception e){
            NominalFX.logger.add("An error ocurred ocurred while trying to preview a payroll");
            this.controller.updateNotifications();
        }
        updateFields();
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

    // Method for do the export to PDS with Jasperfeport.
    @FXML
    private void exportToPdf() throws JRException, IOException {
        HashMap<String,Object> parameters = new HashMap<>();
        parameters.put("PAYROLL_ID",this.currentPayroll.getId());
        JasperViewer.viewReport(NominalFX.reportAPI.getPrint(NominalFX.reportAPI.getReport(getClass().getResource("/reports/payroll_report.jrxml").getPath()),parameters),false);
    }

    //Method to do de xml export.
    @FXML
    private void exportToXML(){
        LocalDate date = LocalDate.now();
        String key = String.format("%s_%s_%d-%02d-%02d.xml",this.currentPayroll.getEmployee().getName(),this.currentPayroll.getEmployee().getLastName(),date.getYear(),date.getMonthValue(),date.getDayOfMonth());
        try {
            NominalFX.xmlAPI.exportXmlWithDialog(this.currentPayroll.generateXML(),key,this.manager.getController().getStageManager().getPrimaryStage());
        } catch (IOException e){
            System.out.println(e.getMessage());
            NominalFX.logger.add("Failed to create XML.");
        }
    }

    @Override
    public void shouldUpdate() {
        updateEmployees();
        this.controller.updateNotifications();
    }

}
