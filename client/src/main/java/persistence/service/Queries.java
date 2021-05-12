/*

 Nominal Application
 Nominal API Queries

 @author     Carlos Pomares
 Date        2021-04-24

*/

package persistence.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Queries extends persistence.Queries {

    public PreparedStatement selectAllEmployees;
    public PreparedStatement selectAllCompanies;
    public PreparedStatement selectAllAgreements;
    public PreparedStatement selectAllPayrolls;
    public PreparedStatement selectAllCurrencies;

    public PreparedStatement selectCurrencyById;

    // AGREEMENT

    public PreparedStatement selectCategoryById;
    public PreparedStatement selectQuotationById;

    public PreparedStatement selectSalaryById;
    public PreparedStatement selectAntiquityById;

    public PreparedStatement selectAgreementById;
    public PreparedStatement selectAgreementByIdMinimal;
    public PreparedStatement selectAgreementCategories;
    public PreparedStatement selectAgreementQuotations;
    public PreparedStatement selectAgreementSalaryTables;
    public PreparedStatement selectAgreementAntiquityTables;

    public PreparedStatement selectSalaryTableByFields;
    public PreparedStatement selectAntiquityTableByFields;

    // COMPANY

    public PreparedStatement selectCompanyById;
    public PreparedStatement selectCompanyByIdMinimal;
    public PreparedStatement selectCompanyByIdMinimalPayroll;
    public PreparedStatement selectAllCompaniesId;
    public PreparedStatement selectCompanyEmployees;

    // PAYROLL

    public PreparedStatement selectPayrollById;
    public PreparedStatement selectPayrollComplementById;
    public PreparedStatement selectPayrollSchedule;

    public PreparedStatement selectPayrollsByEmployeeId;
    public PreparedStatement selectPayrollsByCompanyId;
    public PreparedStatement selectLastPayrollByEmployeeId;


    // EMPLOYEE

    public PreparedStatement selectEmployeeById;
    public PreparedStatement selectEmployeeByIdMinimal;
    public PreparedStatement selectEmployeeByIdMinimalPayroll;
    public PreparedStatement selectEmployeeScheduleById;

    public PreparedStatement selectScheduleByDateAndEmployee;

    // MINIMAL

    public PreparedStatement selectAgreementsMinimal;
    public PreparedStatement selectCompaniesMinimal;
    public PreparedStatement selectEmployeesInCompanyMinimal;

    // CHECKERS

    public PreparedStatement checkCompanyUpdate;
    public PreparedStatement checkEmployeeUpdate;
    public PreparedStatement checkAgreementUpdate;

    // INSERTS

    public PreparedStatement selectLastId;

    public PreparedStatement insertEmployeeContact;
    public PreparedStatement insertEmployeeInformation;
    public PreparedStatement insertEmployeeFinancial;
    public PreparedStatement insertEmployeeCompany;
    public PreparedStatement insertEmployeeSchedule;
    public PreparedStatement insertEmployee;

    public PreparedStatement insertCompanyContact;
    public PreparedStatement insertCompanyInformation;
    public PreparedStatement insertCompanyFinancial;
    public PreparedStatement insertCompanyAgreement;
    public PreparedStatement insertCompany;

    public PreparedStatement insertPayroll;
    public PreparedStatement insertPayrollComplement;

    /**
     *
     * All queries from NominalAPI using PreparedStatement
     *
     * @param connection the connection to perfom queries.
     * @throws SQLException if something fails.
     */
    public Queries(Connection connection) throws SQLException {
        super(connection);
        selectAllEmployees = this.connection.prepareStatement(Statements.SELECT_ALL_EMPLOYEES.getQuery());
        selectAllCompanies = this.connection.prepareStatement(Statements.SELECT_ALL_COMPANIES.getQuery());
        selectAllAgreements = this.connection.prepareStatement(Statements.SELECT_ALL_AGREEMENTS.getQuery());
        selectAllPayrolls = this.connection.prepareStatement(Statements.SELECT_ALL_PAYROLLS.getQuery());
        selectAllCurrencies = this.connection.prepareStatement(Statements.SELECT_ALL_CURRENCIES.getQuery());

        selectCurrencyById = this.connection.prepareStatement(Statements.SELECT_CURRENCY_BY_ID.getQuery());

        selectCategoryById = this.connection.prepareStatement(Statements.SELECT_CATEGORY_BY_ID.getQuery());
        selectQuotationById = this.connection.prepareStatement(Statements.SELECT_QUOTATION_BY_ID.getQuery());

        selectSalaryById = this.connection.prepareStatement(Statements.SELECT_SALARY_BY_ID.getQuery());
        selectAntiquityById = this.connection.prepareStatement(Statements.SELECT_ANTIQUITY_BY_ID.getQuery());

        selectAgreementById = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_BY_ID.getQuery());
        selectAgreementByIdMinimal = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_BY_ID_MINIMAL.getQuery());
        selectAgreementCategories = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_CATEGORIES.getQuery());
        selectAgreementQuotations = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_QUOTATIONS.getQuery());
        selectAgreementSalaryTables = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_SALARY_TABLES.getQuery());
        selectAgreementAntiquityTables = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_ANTIQUITY_TABLES.getQuery());

        selectSalaryTableByFields = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_SALARY_TABLE_BY_FIELDS.getQuery());
        selectAntiquityTableByFields = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_ANTIQUITY_TABLE_BY_FIELDS.getQuery());

        selectCompanyById = this.connection.prepareStatement(Statements.SELECT_COMPANY_BY_ID.getQuery());
        selectCompanyByIdMinimal = this.connection.prepareStatement(Statements.SELECT_COMPANY_BY_ID_MINIMAL.getQuery());
        selectCompanyByIdMinimalPayroll = this.connection.prepareStatement(Statements.SELECT_COMPANY_BY_ID_MINIMAL_PAYROLL.getQuery());
        selectAllCompaniesId = this.connection.prepareStatement(Statements.SELECT_ALL_COMPANIES_ID.getQuery());
        selectCompanyEmployees = this.connection.prepareStatement(Statements.SELECT_COMPANY_EMPLOYEES.getQuery());

        // PAYROLL
        selectPayrollById = this.connection.prepareStatement(Statements.SELECT_PAYROLL_BY_ID.getQuery());
        selectPayrollComplementById = this.connection.prepareStatement(Statements.SELECT_PAYROLL_COMPLEMENT_BY_PAYROLL.getQuery());
        selectPayrollSchedule = this.connection.prepareStatement(Statements.SELECT_PAYROLL_SCHEDULE_BY_ID.getQuery());

        selectPayrollsByEmployeeId = this.connection.prepareStatement(Statements.SELECT_PAYROLL_BY_EMPLOYEE_ID.getQuery());
        selectPayrollsByCompanyId = this.connection.prepareStatement(Statements.SELECT_PAYROLL_BY_COMPANY_ID.getQuery());

        selectLastPayrollByEmployeeId = this.connection.prepareStatement(Statements.SELECT_LAST_PAYROLL_BY_EMPLOYEE.getQuery());

        selectEmployeeById = this.connection.prepareStatement(Statements.SELECT_EMPLOYEE_BY_ID.getQuery());
        selectEmployeeByIdMinimal = this.connection.prepareStatement(Statements.SELECT_EMPLOYEE_BY_ID_MINIMAL.getQuery());
        selectEmployeeByIdMinimalPayroll = this.connection.prepareStatement(Statements.SELECT_EMPLOYEE_BY_ID_MINIMAL_PAYROLL.getQuery());
        selectEmployeeScheduleById = this.connection.prepareStatement(Statements.SELECT_SCHEDULE_BY_ID.getQuery());

        selectScheduleByDateAndEmployee = this.connection.prepareStatement(Statements.SELECT_SCHEDULE_BY_DATE.getQuery());

        selectAgreementsMinimal = this.connection.prepareStatement(Statements.SELECT_AGREEMENTS_MINIMAL.getQuery());
        selectCompaniesMinimal = this.connection.prepareStatement(Statements.SELECT_COMPANIES_MINIMAL.getQuery());
        selectEmployeesInCompanyMinimal = this.connection.prepareStatement(Statements.SELECT_EMPLOYEES_MINIMAL.getQuery());

        checkCompanyUpdate = this.connection.prepareStatement(Statements.CHECK_COMPANY_UPDATE.getQuery());
        checkEmployeeUpdate = this.connection.prepareStatement(Statements.CHECK_EMPLOYEE_UPDATE.getQuery());
        checkAgreementUpdate = this.connection.prepareStatement(Statements.CHECK_AGREEMENT_UPDATE.getQuery());

        // INSERTS
        insertEmployee = this.connection.prepareStatement(Statements.INSERT_NEW_EMPLOYEE.getQuery());
        insertEmployeeContact = this.connection.prepareStatement(Statements.INSERT_EMPLOYEE_CONTACT.getQuery());
        insertEmployeeInformation = this.connection.prepareStatement(Statements.INSERT_EMPLOYEE_INFORMATION.getQuery());
        insertEmployeeFinancial = this.connection.prepareStatement(Statements.INSERT_EMPLOYEE_FINANCIAL.getQuery());
        insertEmployeeCompany = this.connection.prepareStatement(Statements.INSERT_EMPLOYEE_COMPANY.getQuery());
        insertEmployeeSchedule = this.connection.prepareStatement(Statements.INSERT_EMPLOYEE_SCHEDULE.getQuery());

        insertCompanyContact = this.connection.prepareStatement(Statements.INSERT_COMPANY_CONTACT.getQuery());
        insertCompanyInformation = this.connection.prepareStatement(Statements.INSERT_COMPANY_INFORMATION.getQuery());
        insertCompanyFinancial = this.connection.prepareStatement(Statements.INSERT_COMPANY_FINANCIAL.getQuery());
        insertCompanyAgreement = this.connection.prepareStatement(Statements.INSERT_COMPANY_AGREEMENT.getQuery());
        insertCompany = this.connection.prepareStatement(Statements.INSERT_NEW_COMPANY.getQuery());

        insertPayroll = this.connection.prepareStatement(Statements.INSERT_PAYROLL.getQuery());
        insertPayrollComplement = this.connection.prepareStatement(Statements.INSERT_PAYROLL_COMPLEMENTS.getQuery());

        selectLastId = this.connection.prepareStatement(Statements.SELECT_LAST_INSERT_ID.getQuery());

    }

}
