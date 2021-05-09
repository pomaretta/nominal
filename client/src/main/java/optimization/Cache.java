package optimization;

import common.agreement.Agreement;
import common.company.Company;
import common.employee.Employee;
import common.payroll.Payroll;

import java.util.ArrayList;

public class Cache {

    // ALL
    private final ArrayList<Object> items;

    // AGREEMENTS
    private final ArrayList<Object> agreements;

    // PAYROLLS
    private final ArrayList<Object> payrolls;

    // COMPANY
    private final ArrayList<Object> companies;

    // EMPLOYEES
    private final ArrayList<Object> employees;

    /**
     *
     * The cache class acts like an storage that contains all the
     * needed objects that are in the database.
     *
     */
    public Cache(){
        this.items = new ArrayList<>();
        this.agreements = new ArrayList<>();
        this.payrolls = new ArrayList<>();
        this.companies = new ArrayList<>();
        this.employees = new ArrayList<>();
    }

    public ArrayList<Object> getItems() {
        return items;
    }

    public ArrayList<Object> getAgreements() {
        return agreements;
    }

    public ArrayList<Object> getPayrolls() {
        return payrolls;
    }

    public ArrayList<Object> getCompanies() {
        return companies;
    }

    public ArrayList<Object> getEmployees() {
        return employees;
    }

    public boolean add(Object object, ArrayList<Object> list){
        return list.add(object);
    }

    public boolean remove(Object object,ArrayList<Object> list) {
        return list.remove(object);
    }

    public void clear(ArrayList<Object> list){
        list.clear();
    }

    // AGREEMENTS
    public boolean containsAgreement(int agreementId){
        for(Object a : getAgreements()){
             if (((Agreement) a).getId() == agreementId){
                return true;
            }
        }
        return false;
    }

    // COMPANY
    public boolean containsCompany(int companyId){
        for(Object c : getCompanies()){
            if (((Company) c).getId() == companyId){
                return true;
            }
        }
        return false;
    }

    // EMPLOYEE
    public boolean containsEmployee(int employeeId){
        for(Object e : getEmployees()){
            if (((Employee) e).getId() == employeeId){
                return true;
            }
        }
        return false;
    }

    // PAYROLL
    public boolean containsPayroll(int payrollId){
        for(Object p : getPayrolls()){
            if (((Payroll) p).getId() == payrollId){
                return true;
            }
        }
        return false;
    }

    // GET ID OBJECTS
    public Agreement getAgreementById(int agreementId){
        for(Object a : getAgreements()){
            if (((Agreement) a).getId() == agreementId){
                return (Agreement) a;
            }
        }
        return null;
    }

    public Company getCompanyById(int companyId){
        for(Object p : getCompanies()){
            if (((Company) p).getId() == companyId){
                return (Company) p;
            }
        }
        return null;
    }

    public Employee getEmployeeById(int employeeId){
        for(Object e : getEmployees()){
            if (((Employee) e).getId() == employeeId){
                return (Employee) e;
            }
        }
        return null;
    }

    public Payroll getPayrollById(int payrollId){
        for(Object p : getPayrolls()){
            if (((Payroll) p).getId() == payrollId){
                return (Payroll) p;
            }
        }
        return null;
    }

}
