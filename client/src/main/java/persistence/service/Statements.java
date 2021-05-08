/*

 Nominal Application
 Nominal API Statements

 @author     Carlos Pomares
 Date        2021-04-24

*/

package persistence.service;

public enum Statements {

    SELECT_ALL_EMPLOYEES("SELECT DISTINCT e.id FROM nominal_dev.employee e"),
    SELECT_ALL_COMPANIES("SELECT DISTINCT c.id FROM nominal_dev.company c"),
    SELECT_ALL_AGREEMENTS("SELECT DISTINCT a.id as id FROM nominal_dev.agreement a"),
    SELECT_ALL_CURRENCIES("SELECT DISTINCT c.id as id FROM nominal_dev.currency c"),
    SELECT_ALL_PAYROLLS("SELECT * FROM payroll"),

    // CURRENCY
    SELECT_CURRENCY_BY_ID("SELECT c.id as id, c.name as name, c.digit as digit FROM nominal_dev.currency c WHERE c.id = ?"),

    // AGREEMENT
    SELECT_CATEGORY_BY_ID("SELECT aec.agreement as agreement, aec.id as id, aec.name as name, aec.`level` as level FROM nominal_dev.agreement_emp_category aec WHERE aec.id = ?"),
    SELECT_QUOTATION_BY_ID("SELECT acq.agreement as agreement, acq.id as id, acq.name as name, acq.`level` as level FROM nominal_dev.agreement_com_quotation acq WHERE acq.id = ?"),
    SELECT_SALARY_BY_ID("SELECT esv.agreement as agreement, esv.id as id, esv.category as category, esv.quotation as quotation, esv.value as value FROM nominal_dev.employee_salary_values esv WHERE esv.id = ?"),
    SELECT_ANTIQUITY_BY_ID("SELECT eav.agreement as agreement, eav.id as id, eav.category as category, eav.quotation as quotation, eav.years as years, eav.value as value FROM nominal_dev.employee_antiquity_values eav WHERE eav.id = ?"),
    SELECT_AGREEMENT_BY_ID("SELECT a.id as id, a.name as name FROM nominal_dev.agreement a WHERE a.id = ?"),
    SELECT_AGREEMENT_CATEGORIES("SELECT aec.id FROM nominal_dev.agreement_emp_category aec WHERE aec.agreement = ?"),
    SELECT_AGREEMENT_QUOTATIONS("SELECT acq.id FROM nominal_dev.agreement_com_quotation acq WHERE acq.agreement = ?"),
    SELECT_AGREEMENT_SALARY_TABLES("SELECT esv.id FROM nominal_dev.employee_salary_values esv WHERE esv.agreement = ?"),
    SELECT_AGREEMENT_ANTIQUITY_TABLES("SELECT eav.id FROM nominal_dev.employee_antiquity_values eav WHERE eav.agreement = ?"),
    
    SELECT_AGREEMENT_SALARY_TABLE_BY_FIELDS("SELECT esv.id as id FROM nominal_dev.employee_salary_values esv WHERE esv.agreement = ? AND esv.category = ? AND esv.quotation = ? ORDER BY esv.created_at DESC LIMIT 1"),
    SELECT_AGREEMENT_ANTIQUITY_TABLE_BY_FIELDS("SELECT eav.id as id FROM nominal_dev.employee_antiquity_values eav WHERE eav.agreement = ? AND eav.category = ? AND eav.quotation = ? AND eav.years = ? ORDER BY eav.created_at DESC LIMIT 1"),

    // COMPANY
    SELECT_COMPANY_BY_ID("SELECT A.id as id, A.name as name, B.agreement as agreement, C.currency as currency, D.phone_number as phone_number, D.state as state, D.street_address as street_address, E.cif as cif FROM ( SELECT c.created_at as creation , c.id as id , c.name as name FROM nominal_dev.company c ) A INNER JOIN ( SELECT ca.created_at as creation , ca.agreement as agreement , ca.company as company FROM nominal_dev.company_agreement ca ) B ON A.id = B.company INNER JOIN ( SELECT cf.created_at as creation , cf.company as company , cf.currency as currency FROM nominal_dev.company_financial cf ) C ON A.id = C.company INNER JOIN ( SELECT cc.created_at as creation , cc.company as company , cc.phone_number as phone_number , cc.state as state , cc.street_address as street_address FROM nominal_dev.company_contact cc ) D ON A.id = D.company INNER JOIN ( SELECT ci.created_at as creation , ci.company as company , ci.cif as cif FROM nominal_dev.company_information ci ) E ON A.id = E.company WHERE A.id = ? ORDER BY B.creation DESC, C.creation DESC, D.creation DESC, E.creation DESC LIMIT 1"),
    SELECT_ALL_COMPANIES_ID("SELECT DISTINCT c.id FROM nominal_dev.company c"),

    SELECT_EMPLOYEE_BY_ID("SELECT A.id as id , A.naf as naf , A.passport as passport , B.email_address as email_address , B.phone_number as phone_number , B.street_address as street_address , C.category as category , C.irpf as irpf , C.hourly as hourly , C.hours as hours , D.name as name , D.name2 as name2 , D.lastname as lastname , D.lastname2 as lastname2 , D.apportion as apportion , D.active as active , E.join_date as join_date , E.expiration_date as expiration_date FROM ( SELECT e.id as id , e.naf as naf , e.passport as passport FROM nominal_dev.employee e ) A INNER JOIN ( SELECT ec.created_at as creation , ec.employee as employee , ec.email_address as email_address , ec.phone_number as phone_number , ec.street_address as street_address FROM nominal_dev.employee_contact ec ) B ON A.id = B.employee INNER JOIN ( SELECT ec.created_at as creation , ec.employee as employee , ec.category as category , ec.irpf as irpf , ec.hourly as hourly , ec.hired_hours as hours FROM nominal_dev.employee_contract ec ) C ON A.id = C.employee INNER JOIN ( SELECT ei.created_at as creation , ei.employee as employee , ei.name as name , ei.name_2 as name2 , ei.lastname as lastname , ei.lastname_2 as lastname2 , ei.apportion as apportion , ei.active as active FROM nominal_dev.employee_information ei ) D ON A.id = D.employee INNER JOIN ( SELECT ce.created_at as creation , ce.company as company , ce.employee as employee , ce.join_date as join_date , ce.expiration_date as expiration_date FROM nominal_dev.company_employee ce ) E ON A.id = E.employee WHERE A.id = ? ORDER BY B.creation DESC , C.creation DESC , D.creation DESC , E.creation DESC LIMIT 1"),
    SELECT_COMPANY_EMPLOYEES("SELECT ce.employee as id FROM nominal_dev.company_employee ce WHERE ce.company = ? AND ce.expiration_date IS NULL"),

    SELECT_SCHEDULE_BY_ID("SELECT es.created_at as creation ,es.id as id ,es.employee as employee ,es.turnicity as turnicity ,es.nocturnal as nocturnal ,es.complementary_hours as complementary_hours FROM nominal_dev.employee_schedule es WHERE es.id = ?"),

    SELECT_COMPANIES_MINIMAL("SELECT c.id as id, c.name as name FROM nominal_dev.company c"),
    SELECT_EMPLOYEES_MINIMAL("SELECT DISTINCT A.employee as id ,B.name as name ,B.lastname as lastname ,B.lastname_2 as lastname2 ,C.email_address FROM nominal_dev.company_employee A INNER JOIN nominal_dev.employee_information B ON A.employee = B.id INNER JOIN nominal_dev.employee_contact C ON A.employee = C.employee WHERE A.company = ? AND A.expiration_date IS NULL ORDER BY B.created_at DESC"),

    // PAYROLL
    SELECT_PAYROLL_BY_ID(""),
    SELECT_PAYROLL_BY_EMPLOYEE_ID(""),
    SELECT_PAYROLL_BY_COMPANY_ID(""),

    PLACEHOLDER("");

    private final String query;

    Statements(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
