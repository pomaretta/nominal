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
    private final ArrayList<Agreement> agreements;

    // PAYROLLS
    private final ArrayList<Payroll> payrolls;

    // COMPANY
    private final ArrayList<Company> companies;

    // EMPLOYEES
    private final ArrayList<Employee> employees;

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

    public ArrayList<Agreement> getAgreements() {
        return agreements;
    }

    public ArrayList<Payroll> getPayrolls() {
        return payrolls;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public ArrayList<Employee> getEmployees() {
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
        for(Agreement a : getAgreements()){
            if (a.getId() == agreementId){
                return true;
            }
        }
        return false;
    }

    // COMPANY
    public boolean containsCompany(int companyId){
        for(Company c : getCompanies()){
            if (c.getId() == companyId){
                return true;
            }
        }
        return false;
    }

    // EMPLOYEE
    public boolean containsEmployee(int employeeId){
        for(Employee e : getEmployees()){
            if (e.getId() == employeeId){
                return true;
            }
        }
        return false;
    }

    // PAYROLL
    public boolean containsPayroll(int payrollId){
        for(Payroll p : getPayrolls()){
            if (p.getId() == payrollId){
                return true;
            }
        }
        return false;
    }

}
