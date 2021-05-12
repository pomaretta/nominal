package optimization;

import application.NominalFX;
import common.NominalMaster;
import common.NominalObject;
import common.agreement.Agreement;
import common.company.Company;
import common.employee.Employee;
import common.image.NominalImage;
import common.payroll.Payroll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Cache {

    // ALL
    // private final ArrayList<Object> items;
    private final HashMap<Integer,NominalObject> items;

    // AGREEMENTS
    // private final ArrayList<Object> agreements;
    private final HashMap<Integer,NominalObject> agreements;

    // PAYROLLS
    // private final ArrayList<Object> payrolls;
    private final HashMap<Integer,NominalObject> payrolls;

    // COMPANY
    // private final ArrayList<Object> companies;
    private final HashMap<Integer,NominalObject> companies;

    // EMPLOYEES
    // private final ArrayList<Object> employees;
    private final HashMap<Integer,NominalObject> employees;

    // IMAGES
    // private final ArrayList<Object> images;
    private final HashMap<Integer,NominalObject> images;

    /**
     *
     * The cache class acts like an storage that contains all the
     * needed objects that are in the database.
     *
     */
    public Cache(){
        this.items = new HashMap<>();
        // this.agreements = new ArrayList<>();
        // this.payrolls = new ArrayList<>();
        // this.companies = new ArrayList<>();
        // this.employees = new ArrayList<>();
        // this.images = new ArrayList<>();
        this.agreements = new HashMap<>();
        this.payrolls = new HashMap<>();
        this.companies = new HashMap<>();
        this.employees = new HashMap<>();
        this.images = new HashMap<>();
    }

    public HashMap<Integer, NominalObject> getItems() {
        return items;
    }

    public HashMap<Integer,NominalObject> getAgreements() {
        return agreements;
    }

    public HashMap<Integer, NominalObject> getPayrolls() {
        return payrolls;
    }

    public HashMap<Integer, NominalObject> getCompanies() {
        return companies;
    }

    public HashMap<Integer, NominalObject> getEmployees() {
        return employees;
    }

    public HashMap<Integer, NominalObject> getImages() {
        return images;
    }

    public void add(NominalObject object, HashMap<Integer,NominalObject> list){
        list.put(object.getId(),object);
    }

    public void remove(NominalObject object,HashMap<Integer,NominalObject> list) {
        list.remove(object.getId());
    }

    public void clear(HashMap list){
        list.clear();
    }

    // AGREEMENTS
    public boolean containsAgreement(int agreementId){
        return this.agreements.containsKey(agreementId);
    }

    // COMPANY
    public boolean containsCompany(int companyId){
        return this.companies.containsKey(companyId);
    }

    // EMPLOYEE
    public boolean containsEmployee(int employeeId){
        return this.employees.containsKey(employeeId);
    }

    // PAYROLL
    public boolean containsPayroll(int payrollId){
        return this.payrolls.containsKey(payrollId);
    }

    // IMAGE
    public boolean containsImage(int imageId){
        return this.images.containsKey(imageId);
    }

    // GET ID OBJECTS
    public Agreement getAgreementById(int agreementId){
        try {
            if (NominalFX.nominalAPI.checkAgreement((Agreement) this.agreements.get(agreementId))){
                this.agreements.replace(agreementId,NominalFX.nominalAPI.getAgreementById(agreementId));
            }
            return (Agreement) this.agreements.get(agreementId);
        } catch (SQLException e){
            return (Agreement) this.agreements.get(agreementId);
        }
    }

    public Company getCompanyById(int companyId){
        try {
            if (NominalFX.nominalAPI.checkCompany((Company) this.companies.get(companyId))){
                this.companies.replace(companyId,NominalFX.nominalAPI.getCompanyById(companyId));
            }
            return (Company) this.companies.get(companyId);
        } catch (SQLException e){
            return (Company) this.companies.get(companyId);
        }
    }

    public Employee getEmployeeById(int employeeId){
        try {
            if (NominalFX.nominalAPI.checkEmployee((Employee) this.employees.get(employeeId))){
                this.employees.replace(employeeId,NominalFX.nominalAPI.getEmployeeById(employeeId));
            }
            return (Employee) this.employees.get(employeeId);
        } catch (SQLException e){
            return (Employee) this.employees.get(employeeId);
        }
    }

    public Payroll getPayrollById(int payrollId){
        return (Payroll) this.payrolls.get(payrollId);
    }

    public NominalImage getImageById(int imageId){
        return (NominalImage) this.images.get(imageId);
    }

}
