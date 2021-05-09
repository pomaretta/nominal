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
    SELECT_ALL_PAYROLLS("SELECT DISTINCT p.id FROM nominal_dev.payroll p"),

    // CURRENCY
    SELECT_CURRENCY_BY_ID("SELECT c.id as id, c.name as name, c.digit as digit FROM nominal_dev.currency c WHERE c.id = ?"),

    // AGREEMENT
    SELECT_CATEGORY_BY_ID("SELECT aec.agreement as agreement, aec.id as id, aec.name as name, aec.`level` as level FROM nominal_dev.agreement_emp_category aec WHERE aec.id = ?"),
    SELECT_QUOTATION_BY_ID("SELECT acq.agreement as agreement, acq.id as id, acq.name as name, acq.`level` as level FROM nominal_dev.agreement_com_quotation acq WHERE acq.id = ?"),
    SELECT_SALARY_BY_ID("SELECT esv.agreement as agreement, esv.id as id, esv.category as category, esv.quotation as quotation, esv.value as value FROM nominal_dev.employee_salary_values esv WHERE esv.id = ?"),
    SELECT_ANTIQUITY_BY_ID("SELECT eav.agreement as agreement, eav.id as id, eav.category as category, eav.quotation as quotation, eav.years as years, eav.value as value FROM nominal_dev.employee_antiquity_values eav WHERE eav.id = ?"),
    SELECT_AGREEMENT_BY_ID("SELECT a.id as id, a.name as name, a.last_update as last_update FROM nominal_dev.agreement a WHERE a.id = ?"),
    SELECT_AGREEMENT_CATEGORIES("SELECT aec.id FROM nominal_dev.agreement_emp_category aec WHERE aec.agreement = ?"),
    SELECT_AGREEMENT_QUOTATIONS("SELECT acq.id FROM nominal_dev.agreement_com_quotation acq WHERE acq.agreement = ?"),
    SELECT_AGREEMENT_SALARY_TABLES("SELECT esv.id FROM nominal_dev.employee_salary_values esv WHERE esv.agreement = ?"),
    SELECT_AGREEMENT_ANTIQUITY_TABLES("SELECT eav.id FROM nominal_dev.employee_antiquity_values eav WHERE eav.agreement = ?"),
    
    SELECT_AGREEMENT_SALARY_TABLE_BY_FIELDS("SELECT esv.id as id FROM nominal_dev.employee_salary_values esv WHERE esv.agreement = ? AND esv.category = ? AND esv.quotation = ? ORDER BY esv.created_at DESC LIMIT 1"),
    SELECT_AGREEMENT_ANTIQUITY_TABLE_BY_FIELDS("SELECT eav.id as id FROM nominal_dev.employee_antiquity_values eav WHERE eav.agreement = ? AND eav.category = ? AND eav.quotation = ? AND eav.years = ? ORDER BY eav.created_at DESC LIMIT 1"),

    // COMPANY
    SELECT_COMPANY_BY_ID("SELECT A.id as id, A.last_update as last_update, A.name as name, B.agreement as agreement, C.currency as currency, D.phone_number as phone_number, D.state as state, D.street_address as street_address, E.cif as cif, E.social_security_id as social_security_id, C.quotation as quotation FROM ( SELECT c.created_at as creation , c.id as id , c.name as name, c.last_update as last_update FROM nominal_dev.company c ) A INNER JOIN ( SELECT ca.created_at as creation , ca.agreement as agreement , ca.company as company FROM nominal_dev.company_agreement ca ) B ON A.id = B.company INNER JOIN ( SELECT cf.created_at as creation , cf.company as company , cf.currency as currency, cf.quotation as quotation FROM nominal_dev.company_financial cf ) C ON A.id = C.company INNER JOIN ( SELECT cc.created_at as creation , cc.company as company , cc.phone_number as phone_number , cc.state as state , cc.street_address as street_address FROM nominal_dev.company_contact cc ) D ON A.id = D.company INNER JOIN ( SELECT ci.created_at as creation , ci.company as company , ci.cif as cif, ci.socialSecurityId as social_security_id FROM nominal_dev.company_information ci ) E ON A.id = E.company WHERE A.id = ? ORDER BY B.creation DESC, C.creation DESC, D.creation DESC, E.creation DESC LIMIT 1"),
    SELECT_ALL_COMPANIES_ID("SELECT DISTINCT c.id FROM nominal_dev.company c"),

    INSERT_NEW_COMPANY("INSERT INTO nominal_dev.company (name) VALUES (?)"),
    INSERT_COMPANY_CONTACT("INSERT INTO nominal_dev.company_contact (company,street_address,state,phone_number) VALUES (?,?,?,?)"),
    INSERT_COMPANY_FINANCIAL("INSERT INTO nominal_dev.company_financial (company,currency,quotation) VALUES (?,?,?)"),
    INSERT_COMPANY_INFORMATION("INSERT INTO nominal_dev.company_information (company,cif,socialSecurityId) VALUES (?,?,?)"),
    INSERT_COMPANY_AGREEMENT("INSERT INTO nominal_dev.company_agreement (company,agreement) VALUES (?,?)"),

    SELECT_EMPLOYEE_BY_ID("SELECT A.id as id , A.last_update as last_update , A.naf as naf , A.passport as passport , B.email_address as email_address , B.phone_number as phone_number , B.street_address as street_address , C.category as category , C.irpf as irpf , C.hourly as hourly , C.hours as hours , D.name as name , D.name2 as name2 , D.lastname as lastname , D.lastname2 as lastname2 , D.apportion as apportion , D.active as active , E.join_date as join_date , E.expiration_date as expiration_date FROM ( SELECT e.id as id , e.naf as naf , e.passport as passport , e.last_update as last_update FROM nominal_dev.employee e ) A INNER JOIN ( SELECT ec.created_at as creation , ec.employee as employee , ec.email_address as email_address , ec.phone_number as phone_number , ec.street_address as street_address FROM nominal_dev.employee_contact ec ) B ON A.id = B.employee INNER JOIN ( SELECT ec.created_at as creation , ec.employee as employee , ec.category as category , ec.irpf as irpf , ec.hourly as hourly , ec.hired_hours as hours FROM nominal_dev.employee_contract ec ) C ON A.id = C.employee INNER JOIN ( SELECT ei.created_at as creation , ei.employee as employee , ei.name as name , ei.name_2 as name2 , ei.lastname as lastname , ei.lastname_2 as lastname2 , ei.apportion as apportion , ei.active as active FROM nominal_dev.employee_information ei ) D ON A.id = D.employee INNER JOIN ( SELECT ce.created_at as creation , ce.company as company , ce.employee as employee , ce.join_date as join_date , ce.expiration_date as expiration_date FROM nominal_dev.company_employee ce ) E ON A.id = E.employee WHERE A.id = ? ORDER BY B.creation DESC , C.creation DESC , D.creation DESC , E.creation DESC LIMIT 1"),
    SELECT_COMPANY_EMPLOYEES("SELECT ce.employee as id FROM nominal_dev.company_employee ce WHERE ce.company = ? AND ce.expiration_date IS NULL"),

    INSERT_NEW_EMPLOYEE("INSERT INTO nominal_dev.employee (passport,naf) VALUES (?,?)"),
    INSERT_EMPLOYEE_CONTACT("INSERT INTO nominal_dev.employee_contact (employee,email_address,street_address,phone_number) VALUES (?,?,?,?)"),
    INSERT_EMPLOYEE_FINANCIAL("INSERT INTO nominal_dev.employee_contract (employee,category,irpf,hourly,hired_hours) VALUES (?,?,?,?,?)"),
    INSERT_EMPLOYEE_INFORMATION("INSERT INTO nominal_dev.employee_information (employee,name,name_2,lastname,lastname_2,active,apportion) VALUES (?,?,?,?,?,?,?)"),
    INSERT_EMPLOYEE_COMPANY("INSERT INTO nominal_dev.company_employee (company,employee,join_date) VALUES (?,?,?)"),

    SELECT_SCHEDULE_BY_ID("SELECT es.created_at as creation ,es.id as id ,es.employee as employee ,es.turnicity as turnicity ,es.nocturnal as nocturnal ,es.complementary_hours as complementary_hours FROM nominal_dev.employee_schedule es WHERE es.id = ?"),
    SELECT_SCHEDULE_BY_DATE("SELECT es.created_at as creation , es.id as id , es.employee as employee , es.turnicity as turnicity , es.nocturnal as nocturnal , es.complementary_hours as complementary_hours FROM nominal_dev.employee_schedule es WHERE es.created_at BETWEEN ? AND ? AND es.employee = ?"),

    INSERT_EMPLOYEE_SCHEDULE("INSERT INTO nominal_dev.employee_schedule (employee,nocturnal,turnicity,complementary_hours) VALUES (?,?,?,?)"),

    SELECT_COMPANIES_MINIMAL("SELECT c.id as id, c.name as name FROM nominal_dev.company c"),
    SELECT_EMPLOYEES_MINIMAL("SELECT DISTINCT A.employee as id ,B.name as name ,B.lastname as lastname ,B.lastname_2 as lastname2 ,C.email_address FROM nominal_dev.company_employee A INNER JOIN nominal_dev.employee_information B ON A.employee = B.id INNER JOIN nominal_dev.employee_contact C ON A.employee = C.employee WHERE A.company = ? AND A.expiration_date IS NULL ORDER BY B.created_at DESC"),

    // PAYROLL
    SELECT_PAYROLL_BY_ID("SELECT DISTINCT A.id as id ,A.created_at as creation ,A.employee as employee ,A.agreement as agreement ,A.company as company ,A.date_from as date_from ,A.date_to as date_to ,A.date_total_days as total_days ,A.base_salary as base_salary ,A.employee_apportion as emp_apportion ,A.apportion as apportion ,A.salary_kind as salary_kind ,A.total_earned as total_earned ,A.cc_percentage as cc_percentage ,A.cc_value as cc_value ,A.unemployment_percentage as unemployment_percentage ,A.unemployment_value as unemployment_value ,A.training_percentage as training_percentage ,A.training_value as training_value ,A.oh_percentage as oh_percentage ,A.oh_value as oh_value ,A.eh_percentage as eh_percentage ,A.eh_value as eh_value ,A.total_aportations as total_aportations ,A.irpf_percentage as irpf_percentage ,A.irpf_value as irpf_value ,A.advance_pays as advance_pays ,A.sk_reduction as sk_reduction ,A.other_reduction as other_reduction ,A.total_deduction as total_deduction ,A.total_to_receive as total_to_receive ,B.naf as emp_naf ,B.passport as emp_nif ,C.name as name ,C.name_2 as name2 ,C.lastname as lastname ,C.lastname_2 as lastname2 ,G.name as category_name ,F.name as quotation_name ,J.street_address as comp_street_address ,I.cif as comp_cif ,I.socialSecurityId as comp_ss ,E.nocturnal as nocturnal ,E.turnicity as turnicity FROM nominal_dev.payroll A INNER JOIN nominal_dev.employee B ON A.employee = B.id INNER JOIN nominal_dev.employee_information C ON A.employee = C.id INNER JOIN nominal_dev.employee_contract D ON A.employee = D.id INNER JOIN nominal_dev.employee_schedule E ON A.employee = E.employee INNER JOIN nominal_dev.company_financial H ON H.company = A.company INNER JOIN nominal_dev.company_information I ON I.company = A.company INNER JOIN nominal_dev.company_contact J ON J.company = A.company INNER JOIN nominal_dev.currency K ON K.id = H.currency INNER JOIN nominal_dev.agreement_com_quotation F ON F.id = H.quotation INNER JOIN nominal_dev.agreement_emp_category G ON G.id = D.category WHERE A.id = ? AND E.created_at BETWEEN date_from AND date_to AND B.created_at BETWEEN date'2000-01-01' AND date_to AND C.created_at BETWEEN date'2000-01-01' AND date_to AND D.created_at BETWEEN date'2000-01-01' AND date_to AND H.created_at BETWEEN date'2000-01-01' AND date_to AND I.created_at BETWEEN date'2000-01-01' AND date_to AND J.created_at BETWEEN date'2000-01-01' AND date_to ORDER BY C.created_at DESC ,B.created_at DESC ,D.created_at DESC ,H.created_at DESC ,I.created_at DESC ,J.created_at DESC LIMIT 1"),
    SELECT_PAYROLL_BY_EMPLOYEE_ID("SELECT DISTINCT A.id as id ,A.created_at as creation ,A.employee as employee ,A.agreement as agreement ,A.company as company ,A.date_from as date_from ,A.date_to as date_to ,A.date_total_days as total_days ,A.base_salary as base_salary ,A.employee_apportion as emp_apportion ,A.apportion as apportion ,A.salary_kind as salary_kind ,A.total_earned as total_earned ,A.cc_percentage as cc_percentage ,A.cc_value as cc_value ,A.unemployment_percentage as unemployment_percentage ,A.unemployment_value as unemployment_value ,A.training_percentage as training_percentage ,A.training_value as training_value ,A.oh_percentage as oh_percentage ,A.oh_value as oh_value ,A.eh_percentage as eh_percentage ,A.eh_value as eh_value ,A.total_aportations as total_aportations ,A.irpf_percentage as irpf_percentage ,A.irpf_value as irpf_value ,A.advance_pays as advance_pays ,A.sk_reduction as sk_reduction ,A.other_reduction as other_reduction ,A.total_deduction as total_deduction ,A.total_to_receive as total_to_receive ,B.naf as emp_naf ,B.passport as emp_nif ,C.name as name ,C.name_2 as name2 ,C.lastname as lastname ,C.lastname_2 as lastname2 ,G.name as category_name ,F.name as quotation_name ,J.street_address as comp_street_address ,I.cif as comp_cif ,I.socialSecurityId as comp_ss ,E.nocturnal as nocturnal ,E.turnicity as turnicity FROM nominal_dev.payroll A INNER JOIN nominal_dev.employee B ON A.employee = B.id INNER JOIN nominal_dev.employee_information C ON A.employee = C.id INNER JOIN nominal_dev.employee_contract D ON A.employee = D.id INNER JOIN nominal_dev.employee_schedule E ON A.employee = E.employee INNER JOIN nominal_dev.company_financial H ON H.company = A.company INNER JOIN nominal_dev.company_information I ON I.company = A.company INNER JOIN nominal_dev.company_contact J ON J.company = A.company INNER JOIN nominal_dev.currency K ON K.id = H.currency INNER JOIN nominal_dev.agreement_com_quotation F ON F.id = H.quotation INNER JOIN nominal_dev.agreement_emp_category G ON G.id = D.category WHERE A.employee = ? AND E.created_at BETWEEN date_from AND date_to AND B.created_at BETWEEN date'2000-01-01' AND date_to AND C.created_at BETWEEN date'2000-01-01' AND date_to AND D.created_at BETWEEN date'2000-01-01' AND date_to AND H.created_at BETWEEN date'2000-01-01' AND date_to AND I.created_at BETWEEN date'2000-01-01' AND date_to AND J.created_at BETWEEN date'2000-01-01' AND date_to ORDER BY C.created_at DESC ,B.created_at DESC ,D.created_at DESC ,H.created_at DESC ,I.created_at DESC ,J.created_at DESC"),
    SELECT_PAYROLL_BY_COMPANY_ID("SELECT DISTINCT A.id as id ,A.created_at as creation ,A.employee as employee ,A.agreement as agreement ,A.company as company ,A.date_from as date_from ,A.date_to as date_to ,A.date_total_days as total_days ,A.base_salary as base_salary ,A.employee_apportion as emp_apportion ,A.apportion as apportion ,A.salary_kind as salary_kind ,A.total_earned as total_earned ,A.cc_percentage as cc_percentage ,A.cc_value as cc_value ,A.unemployment_percentage as unemployment_percentage ,A.unemployment_value as unemployment_value ,A.training_percentage as training_percentage ,A.training_value as training_value ,A.oh_percentage as oh_percentage ,A.oh_value as oh_value ,A.eh_percentage as eh_percentage ,A.eh_value as eh_value ,A.total_aportations as total_aportations ,A.irpf_percentage as irpf_percentage ,A.irpf_value as irpf_value ,A.advance_pays as advance_pays ,A.sk_reduction as sk_reduction ,A.other_reduction as other_reduction ,A.total_deduction as total_deduction ,A.total_to_receive as total_to_receive ,B.naf as emp_naf ,B.passport as emp_nif ,C.name as name ,C.name_2 as name2 ,C.lastname as lastname ,C.lastname_2 as lastname2 ,G.name as category_name ,F.name as quotation_name ,J.street_address as comp_street_address ,I.cif as comp_cif ,I.socialSecurityId as comp_ss ,E.nocturnal as nocturnal ,E.turnicity as turnicity ,E.created_at as e_creation ,B.created_at as b_creation ,C.created_at as c_creation ,D.created_at as d_creation ,H.created_at as h_creation ,I.created_at as i_creation ,J.created_at as j_creation FROM nominal_dev.payroll A INNER JOIN nominal_dev.employee B ON A.employee = B.id INNER JOIN nominal_dev.employee_information C ON A.employee = C.id INNER JOIN nominal_dev.employee_contract D ON A.employee = D.id INNER JOIN nominal_dev.employee_schedule E ON A.employee = E.employee INNER JOIN nominal_dev.company_financial H ON H.company = A.company INNER JOIN nominal_dev.company_information I ON I.company = A.company INNER JOIN nominal_dev.company_contact J ON J.company = A.company INNER JOIN nominal_dev.currency K ON K.id = H.currency INNER JOIN nominal_dev.agreement_com_quotation F ON F.id = H.quotation INNER JOIN nominal_dev.agreement_emp_category G ON G.id = D.category WHERE A.company = ? HAVING e_creation BETWEEN date'2000-01-01' AND date_to AND b_creation BETWEEN date'2000-01-01' AND date_to AND c_creation BETWEEN date'2000-01-01' AND date_to AND d_creation BETWEEN date'2000-01-01' AND date_to AND h_creation BETWEEN date'2000-01-01' AND date_to AND i_creation BETWEEN date'2000-01-01' AND date_to AND j_creation BETWEEN date'2000-01-01' AND date_to ORDER BY creation DESC ,e_creation DESC ,b_creation DESC ,c_creation DESC ,d_creation DESC ,h_creation DESC ,i_creation DESC ,j_creation DESC"),
    SELECT_PAYROLL_COMPLEMENT_BY_PAYROLL("SELECT pc.title as title ,pc.salarial as salarial ,pc.value_original as original ,pc.value_percentage as percentage ,pc.value as value FROM nominal_dev.payroll_complement pc WHERE pc.payroll = ?"),

    INSERT_PAYROLL("INSERT INTO nominal_dev.payroll (company,agreement,employee,date_from,date_to,date_total_days,base_salary,employee_apportion,apportion,salary_kind,total_earned,cc_percentage,cc_value,unemployment_percentage,unemployment_value,training_percentage,training_value,oh_percentage,oh_value,eh_percentage,eh_value,total_aportations,irpf_percentage,irpf_value,advance_pays,sk_reduction,other_reduction,total_deduction,total_to_receive) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"),
    INSERT_PAYROLL_COMPLEMENTS("INSERT INTO nominal_dev.payroll_complement (payroll,title,salarial,value_original,value_percentage,value) VALUES (?,?,?,?,?,?)"),

    // CHECKERS
    CHECK_COMPANY_UPDATE("SELECT c.last_update >= ? as should_update FROM nominal_dev.company c WHERE c.id = ?"),
    CHECK_AGREEMENT_UPDATE("SELECT a.last_update >= ? as should_update FROM nominal_dev.agreement a WHERE a.id = ?"),
    CHECK_EMPLOYEE_UPDATE("SELECT e.last_update >= ? as should_update FROM nominal_dev.employee e WHERE e.id = ?"),

    PLACEHOLDER("");

    private final String query;

    Statements(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
