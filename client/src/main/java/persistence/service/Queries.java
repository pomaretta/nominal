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
    public PreparedStatement selectAgreementCategories;
    public PreparedStatement selectAgreementQuotations;
    public PreparedStatement selectAgreementSalaryTables;
    public PreparedStatement selectAgreementAntiquityTables;

    public PreparedStatement selectSalaryTableByFields;
    public PreparedStatement selectAntiquityTableByFields;

    // COMPANY

    public PreparedStatement selectCompanyById;
    public PreparedStatement selectAllCompaniesId;
    public PreparedStatement selectCompanyEmployees;

    // EMPLOYEE

    public PreparedStatement selectEmployeeById;
    public PreparedStatement selectEmployeeScheduleById;

    // MINIMAL

    public PreparedStatement selectCompaniesMinimal;
    public PreparedStatement selectEmployeesInCompanyMinimal;

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
        selectAgreementCategories = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_CATEGORIES.getQuery());
        selectAgreementQuotations = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_QUOTATIONS.getQuery());
        selectAgreementSalaryTables = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_SALARY_TABLES.getQuery());
        selectAgreementAntiquityTables = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_ANTIQUITY_TABLES.getQuery());

        selectSalaryTableByFields = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_SALARY_TABLE_BY_FIELDS.getQuery());
        selectAntiquityTableByFields = this.connection.prepareStatement(Statements.SELECT_AGREEMENT_ANTIQUITY_TABLE_BY_FIELDS.getQuery());

        selectCompanyById = this.connection.prepareStatement(Statements.SELECT_COMPANY_BY_ID.getQuery());
        selectAllCompaniesId = this.connection.prepareStatement(Statements.SELECT_ALL_COMPANIES_ID.getQuery());
        selectCompanyEmployees = this.connection.prepareStatement(Statements.SELECT_COMPANY_EMPLOYEES.getQuery());

        selectEmployeeById = this.connection.prepareStatement(Statements.SELECT_EMPLOYEE_BY_ID.getQuery());
        selectEmployeeScheduleById = this.connection.prepareStatement(Statements.SELECT_SCHEDULE_BY_ID.getQuery());

        selectCompaniesMinimal = this.connection.prepareStatement(Statements.SELECT_COMPANIES_MINIMAL.getQuery());
        selectEmployeesInCompanyMinimal = this.connection.prepareStatement(Statements.SELECT_EMPLOYEES_MINIMAL.getQuery());

    }

}
