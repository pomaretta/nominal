/*

 Nominal Application
 Nominal API

 @author     Carlos Pomares
 Date        2021-04-23

 Last revision
 Date        2021-04-24

*/

package persistence.service;

import common.agreement.*;
import common.company.Company;
import common.company.CompanyMinimal;
import common.company.Currency;
import common.employee.Employee;
import common.employee.EmployeeMinimal;
import common.employee.Schedule;
import service.Driver;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NominalAPI extends Driver {

    public persistence.service.Queries queries;

    public NominalAPI(String url, String username, String password) throws SQLException {
        super(url, username, password);
        this.queries = new persistence.service.Queries(this.connection);
    }

    @Override
    public Queries getQueries() {
        return queries;
    }

    // AGREEMENT

    public Category getCategoryById(int id) throws SQLException {

        this.queries.selectCategoryById.setInt(1,id);

        ResultSet resultSet = null;
        Category category;

        try {
            resultSet = this.queries.selectCategoryById.executeQuery();
            resultSet.next();
            category = new Category(
                    resultSet.getInt("id")
                    ,resultSet.getString("name")
                    ,resultSet.getInt("level")
            );
        } finally {
            resultSet.close();
        }

        return category;
    }

    public Quotation getQuotationById(int id) throws SQLException {

        this.queries.selectQuotationById.setInt(1,id);

        ResultSet resultSet = null;
        Quotation quotation;

        try {
            resultSet = this.queries.selectQuotationById.executeQuery();
            resultSet.next();
            quotation = new Quotation(
                    resultSet.getInt("id")
                    ,resultSet.getString("name")
                    ,resultSet.getInt("level")
            );
        } finally {
            resultSet.close();
        }

        return quotation;
    }

    public Salary getSalaryById(int id) throws SQLException {

        this.queries.selectSalaryById.setInt(1,id);

        ResultSet resultSet = null;
        Salary salary;

        try {
            resultSet = this.queries.selectSalaryById.executeQuery();
            resultSet.next();
            salary = new Salary(
                    resultSet.getInt("id")
                    ,resultSet.getInt("category")
                    ,resultSet.getInt("quotation")
                    ,resultSet.getFloat("value")
            );
        } finally {
            resultSet.close();
        }

        return salary;
    }

    public Antiquity getAntiquityById(int id) throws SQLException {

        this.queries.selectAntiquityById.setInt(1,id);

        ResultSet resultSet = null;
        Antiquity antiquity;

        try {
            resultSet = this.queries.selectAntiquityById.executeQuery();
            resultSet.next();
            antiquity = new Antiquity(
                    resultSet.getInt("id")
                    ,resultSet.getInt("category")
                    ,resultSet.getInt("quotation")
                    ,resultSet.getInt("years")
                    ,resultSet.getFloat("value")
            );
        } finally {
            resultSet.close();
        }

        return antiquity;
    }

    public ArrayList<Category> getCategories(int agreementId) throws SQLException {

        this.queries.selectAgreementCategories.setInt(1,agreementId);

        ResultSet resultSet = null;
        ArrayList<Category> categories = new ArrayList<>();

        try {
            resultSet = this.queries.selectAgreementCategories.executeQuery();
            while(resultSet.next()){
                categories.add(
                        getCategoryById(resultSet.getInt("id"))
                );
            }
        } finally {
            resultSet.close();
        }

        return categories;
    }

    public ArrayList<Quotation> getQuotations(int agreementId) throws SQLException {

        this.queries.selectAgreementQuotations.setInt(1,agreementId);

        ResultSet resultSet = null;
        ArrayList<Quotation> quotations = new ArrayList<>();

        try {
            resultSet = this.queries.selectAgreementQuotations.executeQuery();
            while(resultSet.next()){
                quotations.add(
                        getQuotationById(resultSet.getInt("id"))
                );
            }
        } finally {
            resultSet.close();
        }

        return quotations;
    }

    public ArrayList<Salary> getSalaryTables(int agreementId) throws SQLException {

        this.queries.selectAgreementSalaryTables.setInt(1,agreementId);

        ResultSet resultSet = null;
        ArrayList<Salary> salaries = new ArrayList<>();

        try {
            resultSet = this.queries.selectAgreementSalaryTables.executeQuery();
            while(resultSet.next()){
                salaries.add(
                        getSalaryById(resultSet.getInt("id"))
                );
            }
        } finally {
            resultSet.close();
        }

        return salaries;
    }

    public ArrayList<Antiquity> getAntiquityTables(int agreementId) throws SQLException {

        this.queries.selectAgreementAntiquityTables.setInt(1,agreementId);

        ResultSet resultSet = null;
        ArrayList<Antiquity> antiquities = new ArrayList<>();

        try {
            resultSet = this.queries.selectAgreementAntiquityTables.executeQuery();
            while(resultSet.next()){
                antiquities.add(
                        getAntiquityById(resultSet.getInt("id"))
                );
            }
        } finally {
            resultSet.close();
        }

        return antiquities;
    }

    public Salary getSalaryTableByFields(Agreement agreement,Category category, Quotation quotation) throws SQLException{

        this.queries.selectSalaryTableByFields.setInt(1,agreement.getId());
        this.queries.selectSalaryTableByFields.setInt(2,category.getId());
        this.queries.selectSalaryTableByFields.setInt(3,quotation.getId());

        ResultSet resultSet = null;
        Salary salary;

        try {
            resultSet = this.queries.selectSalaryTableByFields.executeQuery();
            salary = getSalaryById(resultSet.getInt("id"));
        } finally {
            resultSet.close();
        }

        return salary;
    }

    public Antiquity getAntiquityByFields(Agreement agreement,Category category, Quotation quotation, int years) throws SQLException {

        this.queries.selectAntiquityTableByFields.setInt(1,agreement.getId());
        this.queries.selectAntiquityTableByFields.setInt(2,category.getId());
        this.queries.selectAntiquityTableByFields.setInt(3,quotation.getId());
        this.queries.selectAntiquityTableByFields.setInt(4,years);

        ResultSet resultSet = null;
        Antiquity antiquity;

        try {
            resultSet = this.queries.selectAntiquityTableByFields.executeQuery();
            antiquity = getAntiquityById(resultSet.getInt("id"));
        } finally {
            resultSet.close();
        }

        return antiquity;
    }

    public Agreement getAgreementById(int agreementId) throws SQLException {

        this.queries.selectAgreementById.setInt(1,agreementId);

        ResultSet resultSet = null;
        Agreement agreement;

        try {
            resultSet = this.queries.selectAgreementById.executeQuery();
            resultSet.next();
            agreement = new Agreement(
                    resultSet.getInt("id")
                    ,resultSet.getString("name")
                    ,getQuotations(resultSet.getInt("id"))
                    ,getCategories(resultSet.getInt("id"))
                    ,getSalaryTables(resultSet.getInt("id"))
                    ,getAntiquityTables(resultSet.getInt("id"))
            );
        } finally {
            resultSet.close();
        }

        return agreement;
    }

    public ArrayList<Agreement> getAgreements() throws SQLException {

        ResultSet resultSet = null;
        ArrayList<Agreement> agreements = new ArrayList<>();

        try {
            resultSet = this.queries.selectAllAgreements.executeQuery();
            while(resultSet.next()){
                agreements.add(
                        getAgreementById(resultSet.getInt("id"))
                );
            }
        } finally {
            resultSet.close();
        }

        return agreements;
    }

    // EMPLOYEE

    public Employee getEmployeeById(int id) throws SQLException {

        this.queries.selectEmployeeById.setInt(1,id);

        ResultSet resultSet = null;
        Employee employee;

        try {
            resultSet = this.queries.selectEmployeeById.executeQuery();
            resultSet.next();
            employee = new Employee(
                    resultSet.getInt("id")
                    ,resultSet.getString("passport")
                    ,resultSet.getString("naf")
                    ,resultSet.getString("name")
                    ,resultSet.getString("name2")
                    ,resultSet.getString("lastname")
                    ,resultSet.getString("lastname2")
                    ,resultSet.getString("email_address")
                    ,resultSet.getString("phone_number")
                    ,resultSet.getString("street_address")
                    ,getCategoryById(resultSet.getInt("category"))
                    ,resultSet.getDate("join_date")
                    ,resultSet.getDate("expiration_date")
                    ,resultSet.getBoolean("active")
                    ,resultSet.getBoolean("hourly")
                    ,resultSet.getBoolean("apportion")
                    ,resultSet.getFloat("hours")
                    ,resultSet.getFloat("irpf")
            );
        } finally {
            resultSet.close();
        }

        return employee;
    }

    public Schedule getScheduleById(int id) throws SQLException {

        this.queries.selectEmployeeScheduleById.setInt(1,id);

        ResultSet resultSet = null;
        Schedule schedule;

        try {
            resultSet = this.queries.selectEmployeeScheduleById.executeQuery();
            resultSet.next();
            schedule = new Schedule(
                    resultSet.getInt("id")
                    ,getEmployeeById(resultSet.getInt("employee"))
                    ,resultSet.getTimestamp("creation")
                    ,resultSet.getBoolean("nocturnal")
                    ,resultSet.getBoolean("turnicity")
                    ,resultSet.getFloat("complementary_hours")
            );
        } finally {
            resultSet.close();
        }

        return schedule;
    }

    // COMPANY

    public Currency getCurrencyById(int id) throws SQLException {

        this.queries.selectCurrencyById.setInt(1,id);

        ResultSet resultSet = null;
        Currency currency;

        try {
            resultSet = this.queries.selectCurrencyById.executeQuery();
            resultSet.next();
            currency = new Currency(
                    resultSet.getInt("id")
                    ,resultSet.getString("name")
                    ,resultSet.getString("digit")
            );
        } finally {
            resultSet.close();
        }

        return currency;
    }

    public ArrayList<Currency> getCurrencies() throws SQLException {

        ResultSet resultSet = null;
        ArrayList<Currency> currencies = new ArrayList<>();

        try {
            resultSet = this.queries.selectAllCurrencies.executeQuery();
            while (resultSet.next()){
                currencies.add(
                        getCurrencyById(resultSet.getInt("id"))
                );
            }
        } finally {
            resultSet.close();
        }

        return currencies;
    }

    public ArrayList<Employee> getEmployeesByCompanyId(int companyId) throws SQLException {

        this.queries.selectCompanyEmployees.setInt(1,companyId);

        ResultSet resultSet = null;
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            resultSet = this.queries.selectCompanyEmployees.executeQuery();
            while(resultSet.next()){
                employees.add(
                        getEmployeeById(resultSet.getInt("id"))
                );
            }
        } finally {
            resultSet.close();
        }

        return employees;
    }

    public Company getCompanyById(int id) throws SQLException {

        this.queries.selectCompanyById.setInt(1,id);

        ResultSet resultSet = null;
        Company company;

        try {
            resultSet = this.queries.selectCompanyById.executeQuery();
            resultSet.next();
            company = new Company(
                    resultSet.getInt("id")
                    ,getAgreementById(resultSet.getInt("agreement"))
                    ,getEmployeesByCompanyId(resultSet.getInt("id"))
                    ,resultSet.getString("name")
                    ,resultSet.getString("cif")
                    ,resultSet.getString("social_security_id")
                    ,resultSet.getString("street_address")
                    ,resultSet.getString("state")
                    ,resultSet.getString("phone_number")
                    ,getCurrencyById(resultSet.getInt("currency"))
            );
        } finally {
            resultSet.close();
        }

        return company;
    }

    public ArrayList<Company> getCompanies() throws SQLException {

        ResultSet resultSet = null;
        ArrayList<Company> companies = new ArrayList<>();

        try {
            resultSet = this.queries.selectAllCompanies.executeQuery();
            while (resultSet.next()){
                companies.add(
                        getCompanyById(resultSet.getInt("id"))
                );
            }
        } finally {
            resultSet.close();
        }

        return companies;
    }

    public ArrayList<Company> getCompaniesMinimal() throws SQLException {

        ResultSet resultSet = null;
        ArrayList<Company> companies = new ArrayList<>();

        try {
            resultSet = this.queries.selectCompaniesMinimal.executeQuery();
            while (resultSet.next()){
                companies.add(
                        new CompanyMinimal(
                                resultSet.getInt("id")
                                ,resultSet.getString("name")
                        )
                );
            }
        } finally {
            resultSet.close();
        }

        return companies;
    }

    public ArrayList<Employee> getEmployeeInCompanyMinimal(int companyId) throws SQLException {
        this.queries.selectEmployeesInCompanyMinimal.setInt(1,companyId);

        ResultSet resultSet = null;
        ArrayList<Employee> employees = new ArrayList<>();

        try {
            resultSet = this.queries.selectEmployeesInCompanyMinimal.executeQuery();
            while(resultSet.next()){
                employees.add(
                        new EmployeeMinimal(
                                resultSet.getInt("id")
                                ,resultSet.getString("name")
                                ,resultSet.getString("lastname")
                                ,resultSet.getString("lastname2")
                                ,resultSet.getString("email_address")
                        )
                );
            }
        } finally {
            resultSet.close();
        }

        return employees;
    }

}
