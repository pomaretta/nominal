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
import common.company.CompanyPayroll;
import common.company.Currency;
import common.employee.Employee;
import common.employee.EmployeeMinimal;
import common.employee.EmployeePayroll;
import common.employee.Schedule;
import common.payroll.Complement;
import common.payroll.Payroll;
import service.Driver;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NominalAPI extends Driver {

    // Queries
    public persistence.service.Queries queries;

    /**
     *
     * The nominal API to perform all queries about Nominal Internal objects.
     *
     * @param url the url for jdbc.
     * @param username the username to access database.
     * @param password the password to access database.
     * @throws SQLException if something fails.
     */
    public NominalAPI(String url, String username, String password) throws SQLException {
        super(url, username, password);
        this.queries = new persistence.service.Queries(this.connection);
    }

    @Override
    public Queries getQueries() {
        return queries;
    }

    // AGREEMENT

    /**
     *
     * Get the category info from the database.
     *
     * @param id the id of the category.
     * @return the category object.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get the quotation by his identification.
     *
     * @param id the id of the quotation.
     * @return the quotation object.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get the salary by id.
     *
     * @param id the id of the salary.
     * @return the salary object.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get the antiquity by id.
     *
     * @param id the id of the antiquity.
     * @return the antiquity object.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get the categories list from agreement, and for each category
     * calls the getCategoryById.
     *
     * @param agreementId the id of the agreement.
     * @return the list of the categories.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get the quotation list from the agreement, and for each quotation
     * calls the getQuotationById.
     *
     * @param agreementId the id of the agreement.
     * @return the list of the quotations.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get the salary list from the agreement, and for each salary
     * calls the getSalaryById.
     *
     * @param agreementId the id of the agreement.
     * @return the list of the salary tables.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get the antiquity list from the agreement, and for each antiquity
     * calls the getAntiquityById.
     *
     * @param agreementId the id of the agreement.
     * @return the list of antiquities.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get the salary from agreement, category and quotation fields to obtain the
     * desired salary.
     *
     * @param agreement id of the agreement.
     * @param category object.
     * @param quotation object.
     * @return the desired salary object.
     * @throws SQLException if something fails.
     */
    public Salary getSalaryTableByFields(Agreement agreement,Category category, Quotation quotation) throws SQLException{

        this.queries.selectSalaryTableByFields.setInt(1,agreement.getId());
        this.queries.selectSalaryTableByFields.setInt(2,category.getLevel());
        this.queries.selectSalaryTableByFields.setInt(3,quotation.getLevel());

        ResultSet resultSet = null;
        Salary salary;

        try {
            resultSet = this.queries.selectSalaryTableByFields.executeQuery();
            resultSet.next();
            salary = getSalaryById(resultSet.getInt("id"));
        } finally {
            resultSet.close();
        }

        return salary;
    }

    /**
     *
     * Get the antiquity from agreement by desired category and quotation groups.
     *
     * @param agreement id of the agreement.
     * @param category object.
     * @param quotation object.
     * @param years the years of the antiquity.
     * @return the desired salary object.
     * @throws SQLException if something fails.
     */
    public Antiquity getAntiquityByFields(Agreement agreement,Category category, Quotation quotation, int years) throws SQLException {

        this.queries.selectAntiquityTableByFields.setInt(1,agreement.getId());
        this.queries.selectAntiquityTableByFields.setInt(2,category.getLevel());
        this.queries.selectAntiquityTableByFields.setInt(3,quotation.getLevel());
        this.queries.selectAntiquityTableByFields.setInt(4,years);

        ResultSet resultSet = null;
        Antiquity antiquity;

        try {
            resultSet = this.queries.selectAntiquityTableByFields.executeQuery();
            resultSet.next();
            antiquity = getAntiquityById(resultSet.getInt("id"));
        } finally {
            resultSet.close();
        }

        return antiquity;
    }

    /**
     *
     * Get agreement by id.
     *
     * @param agreementId id of the agreement.
     * @return agreement object.
     * @throws SQLException if something fails.
     */
    public Agreement getAgreementById(int agreementId) throws SQLException {

        this.queries.selectAgreementById.setInt(1,agreementId);

        ResultSet resultSet = null;
        Agreement agreement;

        try {
            resultSet = this.queries.selectAgreementById.executeQuery();
            resultSet.next();
            agreement = new Agreement(
                    resultSet.getInt("id")
                    ,resultSet.getTimestamp("last_update")
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

    public Agreement getAgreementByIdMinimal(int agreementId) throws SQLException {

        this.queries.selectAgreementByIdMinimal.setInt(1,agreementId);

        ResultSet resultSet = null;
        Agreement agreement;

        try {
            resultSet = this.queries.selectAgreementByIdMinimal.executeQuery();
            resultSet.next();
            agreement = new AgreementMinimal(
                    resultSet.getInt("id")
                    ,resultSet.getString("name")
            );
        } finally {
            resultSet.close();
        }

        return agreement;
    }

    /**
     *
     * Get all agreements in a list, and for each id calls getAgreementById.
     *
     * @return a list with all agreements.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get all agreements in a list, and for each id calls getAgreementById.
     *
     * @return a list with all agreements.
     * @throws SQLException if something fails.
     */
    public ArrayList<Agreement> getAgreementsMinimal() throws SQLException {

        ResultSet resultSet = null;
        ArrayList<Agreement> agreements = new ArrayList<>();

        try {
            resultSet = this.queries.selectAgreementsMinimal.executeQuery();
            while(resultSet.next()){
                agreements.add(
                        new AgreementMinimal(
                                resultSet.getInt("id")
                                ,resultSet.getString("name")
                        )
                );
            }
        } finally {
            resultSet.close();
        }

        return agreements;
    }

    // EMPLOYEE

    /**
     *
     * Get an employee by id.
     *
     * @param id the id of the employee.
     * @return an employee object.
     * @throws SQLException if something fails.
     */
    public Employee getEmployeeById(int id) throws SQLException {

        this.queries.selectEmployeeById.setInt(1,id);

        ResultSet resultSet = null;
        Employee employee;

        try {
            resultSet = this.queries.selectEmployeeById.executeQuery();
            resultSet.next();
            employee = new Employee(
                    resultSet.getInt("id")
                    ,resultSet.getTimestamp("last_update")
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

    public Employee getEmployeeByIdMinimal(int id) throws SQLException {

        this.queries.selectEmployeeByIdMinimal.setInt(1,id);

        ResultSet resultSet = null;
        Employee employee;

        try {
            resultSet = this.queries.selectEmployeeByIdMinimal.executeQuery();
            employee = new EmployeeMinimal(
                    resultSet.getInt("id")
                    ,resultSet.getString("name")
                    ,resultSet.getString("lastname")
                    ,resultSet.getString("lastname2")
                    ,resultSet.getString("email_address")
            );
        } finally {
            resultSet.close();
        }

        return employee;
    }

    public Employee getEmployeeByIdMinimalPayroll(int id, Date date) throws SQLException {

        this.queries.selectEmployeeByIdMinimalPayroll.setInt(1,id);
        this.queries.selectEmployeeByIdMinimalPayroll.setDate(2,date);
        this.queries.selectEmployeeByIdMinimalPayroll.setDate(3,date);
        this.queries.selectEmployeeByIdMinimalPayroll.setDate(4,date);

        ResultSet resultSet = null;
        Employee employee;

        try {
            resultSet = this.queries.selectEmployeeByIdMinimalPayroll.executeQuery();
            resultSet.next();
            employee = new EmployeePayroll(
                    resultSet.getInt("id")
                    ,resultSet.getString("passport")
                    ,resultSet.getString("naf")
                    ,resultSet.getString("name")
                    ,resultSet.getString("name2")
                    ,resultSet.getString("lastname")
                    ,resultSet.getString("lastname2")
                    ,resultSet.getString("email_address")
                    ,getCategoryById(resultSet.getInt("category"))
                    ,resultSet.getBoolean("apportion")
            );
        } finally {
            resultSet.close();
        }

        return employee;
    }

    /**
     *
     * Get an schedule by id.
     *
     * @param id the id of the schedule.
     * @return an schedule object.
     * @throws SQLException if something fails.
     */
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

    public Schedule getScheduleByDateAndEmployee(Employee employee,Date from, Date to) throws SQLException {

        this.queries.selectScheduleByDateAndEmployee.setDate(1,from);
        this.queries.selectScheduleByDateAndEmployee.setDate(2,to);
        this.queries.selectScheduleByDateAndEmployee.setInt(3,employee.getId());

        ResultSet resultSet = null;
        int schedule;

        try {
            resultSet = this.queries.selectScheduleByDateAndEmployee.executeQuery();
            resultSet.next();
            schedule = resultSet.getInt("id");
        } finally {
            resultSet.close();
        }

        return getScheduleById(schedule);
    }

    // COMPANY

    /**
     *
     * Get currency by id.
     *
     * @param id currency id.
     * @return currency object.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get a list of currencies and for each one calls getCurrencyId.
     *
     * @return currency object.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get a list of employees of a company and for each one calls getEmployeeById.
     *
     * @param companyId the company to get the employees list.
     * @return a list of employees.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get company by given ID.
     *
     * @param id of the company.
     * @return a company.
     * @throws SQLException if something fails.
     */
    public Company getCompanyById(int id) throws SQLException {

        this.queries.selectCompanyById.setInt(1,id);

        ResultSet resultSet = null;
        Company company;

        try {
            resultSet = this.queries.selectCompanyById.executeQuery();
            resultSet.next();
            company = new Company(
                    resultSet.getInt("id")
                    ,resultSet.getTimestamp("last_update")
                    ,getAgreementById(resultSet.getInt("agreement"))
                    ,getEmployeesByCompanyId(resultSet.getInt("id"))
                    ,resultSet.getString("name")
                    ,resultSet.getString("cif")
                    ,resultSet.getString("social_security_id")
                    ,resultSet.getString("street_address")
                    ,resultSet.getString("state")
                    ,resultSet.getString("phone_number")
                    ,getCurrencyById(resultSet.getInt("currency"))
                    ,getQuotationById(resultSet.getInt("quotation"))
            );
        } finally {
            resultSet.close();
        }

        return company;
    }

    public Company getCompanyByIdMinimal(int id) throws SQLException {
        this.queries.selectCompanyByIdMinimal.setInt(1,id);

        ResultSet resultSet = null;
        Company company;

        try {
            resultSet = this.queries.selectCompanyByIdMinimal.executeQuery();
            resultSet.next();
            company = new CompanyMinimal(
                    resultSet.getInt("id")
                    ,resultSet.getString("name")
            );
        } finally {
            resultSet.close();
        }

        return company;
    }

    public Company getCompanyByIdMinimalPayroll(int id, Date date) throws SQLException {

        this.queries.selectCompanyByIdMinimalPayroll.setInt(1,id);
        this.queries.selectCompanyByIdMinimalPayroll.setDate(2,date);
        this.queries.selectCompanyByIdMinimalPayroll.setDate(3,date);
        this.queries.selectCompanyByIdMinimalPayroll.setDate(4,date);

        ResultSet resultSet = null;
        Company company;

        try {
            resultSet = this.queries.selectCompanyByIdMinimalPayroll.executeQuery();
            resultSet.next();
            company = new CompanyPayroll(
                    resultSet.getInt("id")
                    ,resultSet.getString("name")
                    ,resultSet.getString("cif")
                    ,resultSet.getString("street_address")
                    ,resultSet.getString("ss")
                    ,resultSet.getString("state")
                    ,getCurrencyById(resultSet.getInt("currency"))
                    ,getQuotationById(resultSet.getInt("quotation"))
            );
        } finally {
            resultSet.close();
        }

        return company;
    }

    /**
     *
     * Get a list of companies, and for each one calls getCompanyById.
     *
     * @return a list of companies.
     * @throws SQLException if something fails.
     */
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

    // PAYROLL

    public Payroll getPayrollById(int id) throws SQLException {

        this.queries.selectPayrollById.setInt(1,id);

        ResultSet resultSet = null;
        Payroll payroll;

        try {
            resultSet = this.queries.selectPayrollById.executeQuery();
            resultSet.next();
            payroll = new Payroll(
                    resultSet.getInt("id")
                    ,resultSet.getTimestamp("creation")
                    ,getCompanyByIdMinimalPayroll(resultSet.getInt("company"),resultSet.getDate("date_to"))
                    ,getAgreementByIdMinimal(resultSet.getInt("agreement"))
                    ,getEmployeeByIdMinimalPayroll(resultSet.getInt("employee"),resultSet.getDate("date_to"))
                    ,getScheduleById(resultSet.getInt("schedule"))
                    ,resultSet.getDate("date_from")
                    ,resultSet.getDate("date_to")
                    ,resultSet.getInt("total_days")
                    ,resultSet.getFloat("base_salary")
                    ,resultSet.getBoolean("emp_apportion")
                    ,resultSet.getFloat("apportion")
                    ,getComplementsByPayroll(resultSet.getInt("id"),true)
                    ,getComplementsByPayroll(resultSet.getInt("id"),false)
                    ,resultSet.getFloat("salary_kind")
                    ,resultSet.getFloat("total_earned")
                    ,resultSet.getFloat("cc_percentage")
                    ,resultSet.getFloat("cc_value")
                    ,resultSet.getFloat("benefits_and_compensations")
                    ,resultSet.getFloat("redundancy_payment")
                    ,resultSet.getFloat("other_benefits")
                    ,resultSet.getFloat("unemployment_percentage")
                    ,resultSet.getFloat("unemployment_value")
                    ,resultSet.getFloat("training_percentage")
                    ,resultSet.getFloat("training_value")
                    ,resultSet.getFloat("oh_original_value")
                    ,resultSet.getFloat("oh_percentage")
                    ,resultSet.getFloat("oh_value")
                    ,resultSet.getFloat("eh_original_value")
                    ,resultSet.getFloat("eh_percentage")
                    ,resultSet.getFloat("eh_value")
                    ,resultSet.getFloat("total_aportations")
                    ,resultSet.getFloat("irpf_percentage")
                    ,resultSet.getFloat("irpf_value")
                    ,resultSet.getFloat("advance_pays")
                    ,resultSet.getFloat("sk_reduction")
                    ,resultSet.getFloat("other_reduction")
                    ,resultSet.getFloat("total_bccc")
                    ,resultSet.getFloat("total_deduction")
                    ,resultSet.getFloat("total_to_receive")
                    ,resultSet.getFloat("company_cc_percentage")
                    ,resultSet.getFloat("company_cc_value")
                    ,resultSet.getFloat("company_pc_at_percentage")
                    ,resultSet.getFloat("company_pc_at_value")
                    ,resultSet.getFloat("company_pc_unemployment_percentage")
                    ,resultSet.getFloat("company_pc_unemployment_value")
                    ,resultSet.getFloat("company_pc_training_percentage")
                    ,resultSet.getFloat("company_pc_training_value")
                    ,resultSet.getFloat("company_pc_fogasa_percentage")
                    ,resultSet.getFloat("company_pc_fogasa_value")
                    ,resultSet.getFloat("company_eh_percentage")
                    ,resultSet.getFloat("company_eh_value")
                    ,resultSet.getFloat("company_oh_percentage")
                    ,resultSet.getFloat("company_oh_value")
            );
        } finally {
            resultSet.close();
        }

        return payroll;
    }

    public ArrayList<Complement> getComplementsByPayroll(int payrollId, boolean salarial) throws SQLException {

        this.queries.selectPayrollComplementById.setInt(1,payrollId);
        this.queries.selectPayrollComplementById.setBoolean(2,salarial);

        ResultSet resultSet = null;
        ArrayList<Complement> complements = new ArrayList<>();

        try {
            resultSet = this.queries.selectPayrollComplementById.executeQuery();
            while(resultSet.next()){
                complements.add(new Complement(
                        resultSet.getString("title")
                        ,resultSet.getFloat("original")
                        ,resultSet.getFloat("percentage")
                        ,resultSet.getFloat("value")
                ));
            }
        } finally {
            resultSet.close();
        }

        return complements;
    }

    /**
     *
     * Get companies name and id only for performance design.
     *
     * @return a list of companies.
     * @throws SQLException if something fails.
     */
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

    /**
     *
     * Get employees name and passport and if for performance design.
     *
     * @param companyId of the employees.
     * @return a list of employees.
     * @throws SQLException if something fails.
     */
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

    // CHECKERS

    /**
     *
     * Check if the actual lastUpdate of the company is equal to the Timestamp of the database.
     *
     * @param company object to get lastUpdate.
     * @return if the lastUpdate is older.
     * @throws SQLException if something fails.
     */
    public boolean checkCompany(Company company) throws SQLException {

        this.queries.checkCompanyUpdate.setTimestamp(1,company.getLastUpdated());
        this.queries.checkCompanyUpdate.setInt(2,company.getId());

        ResultSet resultSet = null;
        boolean shouldUpdate;

        try {
            resultSet = this.queries.checkCompanyUpdate.executeQuery();
            resultSet.next();
            shouldUpdate = resultSet.getBoolean("should_update");
        } finally {
            resultSet.close();
        }

        return shouldUpdate;
    }

    /**
     *
     * Check if the actual lastUpdate of the employee is equal to the Timestamp of the database.
     *
     * @param employee object to get lastUpdate.
     * @return if the lastUpdate is older.
     * @throws SQLException if something fails.
     */
    public boolean checkEmployee(Employee employee) throws SQLException {

        this.queries.checkEmployeeUpdate.setTimestamp(1,employee.getLastUpdated());
        this.queries.checkEmployeeUpdate.setInt(2,employee.getId());

        ResultSet resultSet = null;
        boolean shouldUpdate;

        try {
            resultSet = this.queries.checkEmployeeUpdate.executeQuery();
            resultSet.next();
            shouldUpdate = resultSet.getBoolean("should_update");
        } finally {
            resultSet.close();
        }

        return shouldUpdate;
    }

    /**
     *
     * Check if the actual lastUpdate of the agreement is equal to the Timestamp of the database.
     *
     * @param agreement object to get lastUpdate.
     * @return if the lastUpdate is older.
     * @throws SQLException if something fails.
     */
    public boolean checkAgreement(Agreement agreement) throws SQLException {

        this.queries.checkAgreementUpdate.setTimestamp(1,agreement.getLastUpdated());
        this.queries.checkAgreementUpdate.setInt(2,agreement.getId());

        ResultSet resultSet = null;
        boolean shouldUpdate;

        try {
            resultSet = this.queries.checkAgreementUpdate.executeQuery();
            resultSet.next();
            shouldUpdate = resultSet.getBoolean("should_update");
        } finally {
            resultSet.close();
        }

        return shouldUpdate;
    }

    // INSERTS

    public int selectLastId() throws SQLException {
        ResultSet resultSet = null;
        int id;

        try {
            resultSet = this.queries.selectLastId.executeQuery();
            resultSet.next();
            id = resultSet.getInt("id");
        } finally {
            resultSet.close();
        }

        return id;
    }

    // EMPLOYEE

    public void setEmployee(Company company, Employee employee) throws SQLException {
        this.queries.insertEmployee.setString(1,employee.getPassport());
        this.queries.insertEmployee.setString(2,employee.getNaf());
        this.queries.insertEmployee.execute();
        int employeeId = selectLastId();
        setEmployeeInformation(employeeId,employee);
        setEmployeeContact(employeeId,employee);
        setEmployeeFinancial(employeeId,employee);
        setEmployeeCompany(employeeId,employee,company);
    }

    public void setEmployeeInformation(int employeeId, Employee employee) throws SQLException {
        this.queries.insertEmployeeInformation.setInt(1,employeeId);
        this.queries.insertEmployeeInformation.setString(2,employee.getName());
        this.queries.insertEmployeeInformation.setString(3,employee.getName2());
        this.queries.insertEmployeeInformation.setString(4,employee.getLastName());
        this.queries.insertEmployeeInformation.setString(5,employee.getLastName2());
        this.queries.insertEmployeeInformation.setBoolean(6,employee.isActive());
        this.queries.insertEmployeeInformation.setBoolean(7,employee.isApportion());
        this.queries.insertEmployeeInformation.execute();
    }

    public void setEmployeeContact(int employeeId, Employee employee) throws SQLException {
        this.queries.insertEmployeeContact.setInt(1,employeeId);
        this.queries.insertEmployeeContact.setString(2,employee.getMailAddress());
        this.queries.insertEmployeeContact.setString(3,employee.getStreetAddress());
        this.queries.insertEmployeeContact.setString(4,employee.getPhoneNumber());
        this.queries.insertEmployeeContact.execute();
    }

    public void setEmployeeFinancial(int employeeId,Employee employee) throws SQLException {
        this.queries.insertEmployeeFinancial.setInt(1,employeeId);
        this.queries.insertEmployeeFinancial.setInt(2,employee.getCategory().getId());
        this.queries.insertEmployeeFinancial.setFloat(3,employee.getIrpf());
        this.queries.insertEmployeeFinancial.setBoolean(4,employee.isHourly());
        this.queries.insertEmployeeFinancial.setFloat(5,employee.getHiredHours());
        this.queries.insertEmployeeFinancial.execute();
    }

    public void setEmployeeCompany(int employeeId,Employee employee,Company company) throws SQLException {
        this.queries.insertEmployeeCompany.setInt(1,company.getId());
        this.queries.insertEmployeeCompany.setInt(2,employeeId);
        this.queries.insertEmployeeCompany.setDate(3,employee.getJoinDate());
        this.queries.insertEmployeeCompany.execute();
    }

    public void setEmployeeSchedule(Employee employee, Schedule schedule) throws SQLException {
        this.queries.insertEmployeeSchedule.setInt(1,employee.getId());
        this.queries.insertEmployeeSchedule.setBoolean(2,schedule.isNocturnal());
        this.queries.insertEmployeeSchedule.setBoolean(3,schedule.isTurnicity());
        this.queries.insertEmployeeSchedule.setFloat(4,schedule.getComplementaryHours());
        this.queries.insertEmployeeSchedule.execute();
    }

    // COMPANY

    public void setCompany(Company company) throws SQLException {
        this.queries.insertCompany.setString(1,company.getName());
        this.queries.insertCompany.execute();
        int companyId = selectLastId();
        setCompanyInformation(companyId,company);
        setCompanyContact(companyId,company);
        setCompanyFinancial(companyId,company);
        setCompanyAgreement(companyId,company);
    }

    public void setCompanyInformation(int companyId, Company company) throws SQLException {
        this.queries.insertCompanyInformation.setInt(1,companyId);
        this.queries.insertCompanyInformation.setString(2,company.getCif());
        this.queries.insertCompanyInformation.setString(3,company.getSocialSecurityId());
        this.queries.insertCompanyInformation.execute();
    }

    public void setCompanyContact(int companyId, Company company) throws SQLException {
        this.queries.insertCompanyContact.setInt(1,companyId);
        this.queries.insertCompanyContact.setString(2,company.getStreetAddress());
        this.queries.insertCompanyContact.setString(3,company.getState());
        this.queries.insertCompanyContact.setString(4,company.getPhoneNumber());
        this.queries.insertCompanyContact.execute();
    }

    public void setCompanyFinancial(int companyId, Company company) throws SQLException {
        this.queries.insertCompanyFinancial.setInt(1,companyId);
        this.queries.insertCompanyFinancial.setInt(2,company.getCurrency().getId());
        this.queries.insertCompanyFinancial.setInt(3,company.getQuotation().getId());
        this.queries.insertCompanyFinancial.execute();
    }

    public void setCompanyAgreement(int companyId, Company company) throws SQLException {
        this.queries.insertCompanyAgreement.setInt(1,companyId);
        this.queries.insertCompanyAgreement.setInt(2,company.getAgreement().getId());
        this.queries.insertCompanyAgreement.execute();
    }

    // PAYROLL

    public void setPayroll(Payroll payroll) throws SQLException {

        // OBJECTS
        this.queries.insertPayroll.setInt(1,payroll.getCompany().getId());
        this.queries.insertPayroll.setInt(2,payroll.getAgreement().getId());
        this.queries.insertPayroll.setInt(3,payroll.getEmployee().getId());

        // DATES
        this.queries.insertPayroll.setDate(4,payroll.getFrom());
        this.queries.insertPayroll.setDate(5,payroll.getTo());
        this.queries.insertPayroll.setInt(6,payroll.getTotalDays());

        // APORTIONS
        this.queries.insertPayroll.setFloat(7,payroll.getBaseSalary());
        this.queries.insertPayroll.setBoolean(8,payroll.getEmployee().isApportion());
        this.queries.insertPayroll.setFloat(9,payroll.getApportion());
        this.queries.insertPayroll.setFloat(10,payroll.getSalaryKind());
        this.queries.insertPayroll.setFloat(11,payroll.getTotalEarned());

        // DEDUCTIONS PARTITIONED
        this.queries.insertPayroll.setFloat(12,payroll.getCcPercentage());
        this.queries.insertPayroll.setFloat(13,payroll.getCcValue());

        // NON SALARIAL
        this.queries.insertPayroll.setFloat(14,payroll.getBenefitsAndCompesations());
        this.queries.insertPayroll.setFloat(15,payroll.getRedundancyPayment());
        this.queries.insertPayroll.setFloat(16,payroll.getOtherBenefits());

        // DEDUCTIONS PARTITIONED 2
        this.queries.insertPayroll.setFloat(17,payroll.getUnemploymentPercentage());
        this.queries.insertPayroll.setFloat(18,payroll.getUnemploymentValue());
        this.queries.insertPayroll.setFloat(19,payroll.getTrainingPercentage());
        this.queries.insertPayroll.setFloat(20,payroll.getTrainingValue());
        this.queries.insertPayroll.setFloat(21,payroll.getOhOriginal());
        this.queries.insertPayroll.setFloat(22,payroll.getOhPercentage());
        this.queries.insertPayroll.setFloat(23,payroll.getOhValue());
        this.queries.insertPayroll.setFloat(24,payroll.getEhOriginal());
        this.queries.insertPayroll.setFloat(25,payroll.getEhPercentage());
        this.queries.insertPayroll.setFloat(26,payroll.getEhValue());
        this.queries.insertPayroll.setFloat(27,payroll.getTotalApportions());
        this.queries.insertPayroll.setFloat(28,payroll.getIrpfPercentage());
        this.queries.insertPayroll.setFloat(29,payroll.getIrpfValue());
        this.queries.insertPayroll.setFloat(30,payroll.getAdvancePays());
        this.queries.insertPayroll.setFloat(31,payroll.getSalaryKindDeduction());
        this.queries.insertPayroll.setFloat(32,payroll.getOtherDeduction());
        this.queries.insertPayroll.setFloat(33,payroll.getTotalDeduction());
        this.queries.insertPayroll.setFloat(34,payroll.getTotalToReceive());

        // BOTTOM
        this.queries.insertPayroll.setFloat(35,payroll.getCompanyCCPercentage());
        this.queries.insertPayroll.setFloat(36,payroll.getCompanyCCValue());
        this.queries.insertPayroll.setFloat(37,payroll.getCompanyPCAtPercentage());
        this.queries.insertPayroll.setFloat(38,payroll.getCompanyPCAtValue());
        this.queries.insertPayroll.setFloat(39,payroll.getCompanyPCUnemploymentPercentage());
        this.queries.insertPayroll.setFloat(40,payroll.getCompanyPCUnemploymentValue());
        this.queries.insertPayroll.setFloat(41,payroll.getCompanyPCTrainingPercentage());
        this.queries.insertPayroll.setFloat(42,payroll.getCompanyPCTrainingValue());
        this.queries.insertPayroll.setFloat(43,payroll.getCompanyPCFogasaPercentage());
        this.queries.insertPayroll.setFloat(44,payroll.getCompanyPCFogasaValue());
        this.queries.insertPayroll.setFloat(45,payroll.getCompanyEhPercentage());
        this.queries.insertPayroll.setFloat(46,payroll.getCompanyEhValue());
        this.queries.insertPayroll.setFloat(47,payroll.getCompanyOhPercentage());
        this.queries.insertPayroll.setFloat(48,payroll.getCompanyOhValue());
        this.queries.insertPayroll.setFloat(49,payroll.getTotalBccc());

        this.queries.insertPayroll.execute();

        int payrollId = selectLastId();

        // SET COMPLEMENTS

        // SALARIAL
        setPayrollComplements(payrollId,payroll.getSalaryComplements(),true);

        // NON SALARIAL
        setPayrollComplements(payrollId,payroll.getNonSalaryComplements(),false);

    }

    public void setPayrollComplements(int payrollId, ArrayList<Complement> complements, boolean salarial) throws SQLException {
        for (Complement c : complements){
            setPayrollComplement(payrollId,c,salarial);
        }
    }

    public void setPayrollComplement(int payrollId,Complement complement, boolean salarial) throws SQLException {
        this.queries.insertPayrollComplement.setInt(1,payrollId);
        this.queries.insertPayrollComplement.setString(2,complement.getName());
        this.queries.insertPayrollComplement.setBoolean(3,salarial);
        this.queries.insertPayrollComplement.setFloat(4,complement.getOriginalValue());
        this.queries.insertPayrollComplement.setFloat(5,complement.getValuePercentage());
        this.queries.insertPayrollComplement.setFloat(6,complement.getValue());
        this.queries.insertPayrollComplement.execute();
    }

    // PROCEDURES
    public void fireEmployee(Company company, Employee employee) throws SQLException {
        this.queries.fireEmployee.setInt(1,company.getId());
        this.queries.fireEmployee.setInt(2,employee.getId());
        this.queries.fireEmployee.execute();
    }

}
