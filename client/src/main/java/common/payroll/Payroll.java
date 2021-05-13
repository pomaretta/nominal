/*

 Nominal Application
 Payroll

 @author     Carlos Pomares
 Date        2021-04-24

*/

package common.payroll;

import common.NominalObject;
import common.company.Company;
import common.employee.Employee;
import common.NominalMaster;
import common.agreement.Agreement;
import common.employee.Schedule;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.ArrayList;

public class Payroll extends NominalObject {

    // IDENTIFIER
    protected int id;
    protected Timestamp created;

    // REFERENCES
    protected Company company;
    protected Agreement agreement;
    protected Employee employee;
    protected Schedule schedule;

    // DATES
    protected Date from;
    protected Date to;
    protected int totalDays;

    protected float baseSalary;
    protected boolean employeeApportion;
    protected float apportion;

    // COMPLEMENTS
    protected ArrayList<Complement> salaryComplements;
    protected ArrayList<Complement> nonSalaryComplements;

    protected float salaryKind;
    protected float totalEarned;

    // CC
    protected float ccPercentage;
    protected float ccValue;

    // BENEFITS
    protected float benefitsAndCompesations;

    // REDUNDANCY PAYMENT
    protected float redundancyPayment;

    // Other benefits
    protected float otherBenefits;

    // Unemployment
    protected float unemploymentPercentage;
    protected float unemploymentValue;

    // Training
    protected float trainingPercentage;
    protected float trainingValue;

    // Ordinary Hours
    protected float ohOriginal;
    protected float ohPercentage;
    protected float ohValue;

    // Extra hours
    protected float ehOriginal;
    protected float ehPercentage;
    protected float ehValue;

    // Total apportions
    protected float totalApportions;

    // IRPF
    protected float irpfPercentage;
    protected float irpfValue;

    // ADVANCE PAYS
    protected float advancePays;

    // Salary Kind Deduction
    protected float salaryKindDeduction;

    // Other deduction
    protected float otherDeduction;

    // Total BCCC
    protected float totalBccc;

    // Total Deduction
    protected float totalDeduction;

    // Total to Receive
    protected float totalToReceive;

    // COMPANY
    protected float companyCCPercentage;
    protected float companyCCValue;

    protected float companyPCAtPercentage;
    protected float companyPCAtValue;

    protected float companyPCUnemploymentPercentage;
    protected float companyPCUnemploymentValue;

    protected float companyPCTrainingPercentage;
    protected float companyPCTrainingValue;

    protected float companyPCFogasaPercentage;
    protected float companyPCFogasaValue;

    protected float companyEhPercentage;
    protected float companyEhValue;

    protected float companyOhPercentage;
    protected float companyOhValue;

    public Payroll() {
    }

    public Payroll(int id, Timestamp created, Company company, Agreement agreement, Employee employee, Schedule schedule, Date from, Date to, int totalDays, float baseSalary, boolean employeeApportion, float apportion, ArrayList<Complement> salaryComplements, ArrayList<Complement> nonSalaryComplements, float salaryKind, float totalEarned, float ccPercentage, float ccValue, float benefitsAndCompesations, float redundancyPayment, float otherBenefits, float unemploymentPercentage, float unemploymentValue, float trainingPercentage, float trainingValue, float ohOriginal, float ohPercentage, float ohValue, float ehOriginal, float ehPercentage, float ehValue, float totalApportions, float irpfPercentage, float irpfValue, float advancePays, float salaryKindDeduction, float otherDeduction, float totalBccc, float totalDeduction, float totalToReceive, float companyCCPercentage, float companyCCValue, float companyPCAtPercentage, float companyPCAtValue, float companyPCUnemploymentPercentage, float companyPCUnemploymentValue, float companyPCTrainingPercentage, float companyPCTrainingValue, float companyPCFogasaPercentage, float companyPCFogasaValue, float companyEhPercentage, float companyEhValue, float companyOhPercentage, float companyOhValue) {
        this.id = id;
        this.created = created;
        this.company = company;
        this.agreement = agreement;
        this.employee = employee;
        this.schedule = schedule;
        this.from = from;
        this.to = to;
        this.totalDays = totalDays;
        this.baseSalary = baseSalary;
        this.employeeApportion = employeeApportion;
        this.apportion = apportion;
        this.salaryComplements = salaryComplements;
        this.nonSalaryComplements = nonSalaryComplements;
        this.salaryKind = salaryKind;
        this.totalEarned = totalEarned;
        this.ccPercentage = ccPercentage;
        this.ccValue = ccValue;
        this.benefitsAndCompesations = benefitsAndCompesations;
        this.redundancyPayment = redundancyPayment;
        this.otherBenefits = otherBenefits;
        this.unemploymentPercentage = unemploymentPercentage;
        this.unemploymentValue = unemploymentValue;
        this.trainingPercentage = trainingPercentage;
        this.trainingValue = trainingValue;
        this.ohOriginal = ohOriginal;
        this.ohPercentage = ohPercentage;
        this.ohValue = ohValue;
        this.ehOriginal = ehOriginal;
        this.ehPercentage = ehPercentage;
        this.ehValue = ehValue;
        this.totalApportions = totalApportions;
        this.irpfPercentage = irpfPercentage;
        this.irpfValue = irpfValue;
        this.advancePays = advancePays;
        this.salaryKindDeduction = salaryKindDeduction;
        this.otherDeduction = otherDeduction;
        this.totalBccc = totalBccc;
        this.totalDeduction = totalDeduction;
        this.totalToReceive = totalToReceive;
        this.companyCCPercentage = companyCCPercentage;
        this.companyCCValue = companyCCValue;
        this.companyPCAtPercentage = companyPCAtPercentage;
        this.companyPCAtValue = companyPCAtValue;
        this.companyPCUnemploymentPercentage = companyPCUnemploymentPercentage;
        this.companyPCUnemploymentValue = companyPCUnemploymentValue;
        this.companyPCTrainingPercentage = companyPCTrainingPercentage;
        this.companyPCTrainingValue = companyPCTrainingValue;
        this.companyPCFogasaPercentage = companyPCFogasaPercentage;
        this.companyPCFogasaValue = companyPCFogasaValue;
        this.companyEhPercentage = companyEhPercentage;
        this.companyEhValue = companyEhValue;
        this.companyOhPercentage = companyOhPercentage;
        this.companyOhValue = companyOhValue;
    }

    public Payroll(Company company, Agreement agreement, Employee employee, Schedule schedule, Date from, Date to, int totalDays, float baseSalary, boolean employeeApportion, float apportion, ArrayList<Complement> salaryComplements, ArrayList<Complement> nonSalaryComplements, float salaryKind, float totalEarned, float ccPercentage, float ccValue, float benefitsAndCompesations, float redundancyPayment, float otherBenefits, float unemploymentPercentage, float unemploymentValue, float trainingPercentage, float trainingValue, float ohOriginal, float ohPercentage, float ohValue, float ehOriginal, float ehPercentage, float ehValue, float totalApportions, float irpfPercentage, float irpfValue, float advancePays, float salaryKindDeduction, float otherDeduction, float totalBccc, float totalDeduction, float totalToReceive, float companyCCPercentage, float companyCCValue, float companyPCAtPercentage, float companyPCAtValue, float companyPCUnemploymentPercentage, float companyPCUnemploymentValue, float companyPCTrainingPercentage, float companyPCTrainingValue, float companyPCFogasaPercentage, float companyPCFogasaValue, float companyEhPercentage, float companyEhValue, float companyOhPercentage, float companyOhValue) {
        this.company = company;
        this.agreement = agreement;
        this.employee = employee;
        this.schedule = schedule;
        this.from = from;
        this.to = to;
        this.totalDays = totalDays;
        this.baseSalary = baseSalary;
        this.employeeApportion = employeeApportion;
        this.apportion = apportion;
        this.salaryComplements = salaryComplements;
        this.nonSalaryComplements = nonSalaryComplements;
        this.salaryKind = salaryKind;
        this.totalEarned = totalEarned;
        this.ccPercentage = ccPercentage;
        this.ccValue = ccValue;
        this.benefitsAndCompesations = benefitsAndCompesations;
        this.redundancyPayment = redundancyPayment;
        this.otherBenefits = otherBenefits;
        this.unemploymentPercentage = unemploymentPercentage;
        this.unemploymentValue = unemploymentValue;
        this.trainingPercentage = trainingPercentage;
        this.trainingValue = trainingValue;
        this.ohOriginal = ohOriginal;
        this.ohPercentage = ohPercentage;
        this.ohValue = ohValue;
        this.ehOriginal = ehOriginal;
        this.ehPercentage = ehPercentage;
        this.ehValue = ehValue;
        this.totalApportions = totalApportions;
        this.irpfPercentage = irpfPercentage;
        this.irpfValue = irpfValue;
        this.advancePays = advancePays;
        this.salaryKindDeduction = salaryKindDeduction;
        this.otherDeduction = otherDeduction;
        this.totalBccc = totalBccc;
        this.totalDeduction = totalDeduction;
        this.totalToReceive = totalToReceive;
        this.companyCCPercentage = companyCCPercentage;
        this.companyCCValue = companyCCValue;
        this.companyPCAtPercentage = companyPCAtPercentage;
        this.companyPCAtValue = companyPCAtValue;
        this.companyPCUnemploymentPercentage = companyPCUnemploymentPercentage;
        this.companyPCUnemploymentValue = companyPCUnemploymentValue;
        this.companyPCTrainingPercentage = companyPCTrainingPercentage;
        this.companyPCTrainingValue = companyPCTrainingValue;
        this.companyPCFogasaPercentage = companyPCFogasaPercentage;
        this.companyPCFogasaValue = companyPCFogasaValue;
        this.companyEhPercentage = companyEhPercentage;
        this.companyEhValue = companyEhValue;
        this.companyOhPercentage = companyOhPercentage;
        this.companyOhValue = companyOhValue;
    }

    @Override
    public int getId() {
        return id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public Company getCompany() {
        return company;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public boolean isEmployeeApportion() {
        return employeeApportion;
    }

    public float getApportion() {
        return apportion;
    }

    public ArrayList<Complement> getSalaryComplements() {
        return salaryComplements;
    }

    public ArrayList<Complement> getNonSalaryComplements() {
        return nonSalaryComplements;
    }

    public float getSalaryKind() {
        return salaryKind;
    }

    public float getTotalEarned() {
        return totalEarned;
    }

    public float getCcPercentage() {
        return ccPercentage;
    }

    public float getCcValue() {
        return ccValue;
    }

    public float getBenefitsAndCompesations() {
        return benefitsAndCompesations;
    }

    public float getRedundancyPayment() {
        return redundancyPayment;
    }

    public float getOtherBenefits() {
        return otherBenefits;
    }

    public float getUnemploymentPercentage() {
        return unemploymentPercentage;
    }

    public float getUnemploymentValue() {
        return unemploymentValue;
    }

    public float getTrainingPercentage() {
        return trainingPercentage;
    }

    public float getTrainingValue() {
        return trainingValue;
    }

    public float getOhOriginal() {
        return ohOriginal;
    }

    public float getOhPercentage() {
        return ohPercentage;
    }

    public float getOhValue() {
        return ohValue;
    }

    public float getEhOriginal() {
        return ehOriginal;
    }

    public float getEhPercentage() {
        return ehPercentage;
    }

    public float getEhValue() {
        return ehValue;
    }

    public float getTotalApportions() {
        return totalApportions;
    }

    public float getIrpfPercentage() {
        return irpfPercentage;
    }

    public float getIrpfValue() {
        return irpfValue;
    }

    public float getAdvancePays() {
        return advancePays;
    }

    public float getSalaryKindDeduction() {
        return salaryKindDeduction;
    }

    public float getOtherDeduction() {
        return otherDeduction;
    }

    public float getTotalBccc() {
        return totalBccc;
    }

    public float getTotalDeduction() {
        return totalDeduction;
    }

    public float getTotalToReceive() {
        return totalToReceive;
    }

    public float getCompanyCCPercentage() {
        return companyCCPercentage;
    }

    public float getCompanyCCValue() {
        return companyCCValue;
    }

    public float getCompanyPCAtPercentage() {
        return companyPCAtPercentage;
    }

    public float getCompanyPCAtValue() {
        return companyPCAtValue;
    }

    public float getCompanyPCUnemploymentPercentage() {
        return companyPCUnemploymentPercentage;
    }

    public float getCompanyPCUnemploymentValue() {
        return companyPCUnemploymentValue;
    }

    public float getCompanyPCTrainingPercentage() {
        return companyPCTrainingPercentage;
    }

    public float getCompanyPCTrainingValue() {
        return companyPCTrainingValue;
    }

    public float getCompanyPCFogasaPercentage() {
        return companyPCFogasaPercentage;
    }

    public float getCompanyPCFogasaValue() {
        return companyPCFogasaValue;
    }

    public float getCompanyEhPercentage() {
        return companyEhPercentage;
    }

    public float getCompanyEhValue() {
        return companyEhValue;
    }

    public float getCompanyOhPercentage() {
        return companyOhPercentage;
    }

    public float getCompanyOhValue() {
        return companyOhValue;
    }

    public String generateXML(){

        // Initial
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

        // Payroll Info
        xml = addLine(xml,String.format("<payroll id=\"%d\" creation=\"%s\" from=\"%s\" to=\"%s\">",getId(),created.toLocalDateTime().toLocalDate(),from.toLocalDate(),to.toLocalDate()));

        // AGREEMENT
        xml = addLine(xml,String.format("<agreement id=\"%d\"/>",agreement.getId()));
        // END AGREEMENT

        xml = companyXML(xml);

        xml = employeeXML(xml);

        // TOTAL DAYS
        xml = addLine(xml,String.format("<total_days>%d</total_days>",totalDays));

        xml = salaryPerceptionsXML(xml);

        xml = nonSalaryPerceptionsXML(xml);

        xml = addLine(xml,String.format("<total_bccc>%.2f</total_bccc>",totalBccc));
        xml = addLine(xml,String.format("<total_earned>%.2f</total_earned>",totalEarned));

        xml = deductionsXML(xml);

        xml = quotationBasesXML(xml);

        // TOTAL
        xml = addLine(xml,String.format("<total_to_receive>%.2f</total_to_receive>",totalToReceive));

        xml = addLine(xml,"</payroll>");

        return xml;
    }

    private String companyXML(String xml){
        // COMPANY
        xml = addLine(xml,String.format("<company id=\"%d\">",company.getId()));

        xml = addLine(xml,String.format("<name>%s</name>",company.getName()));
        xml = addLine(xml,String.format("<address>%s</address>",company.getStreetAddress()));
        xml = addLine(xml,String.format("<cif>%s</cif>",company.getCif()));
        xml = addLine(xml,String.format("<ss>%s</ss>",company.getSocialSecurityId()));
        xml = addLine(xml,String.format("<state>%s</state>",company.getState()));
        xml = addLine(xml,String.format("<currency>%s</currency>",company.getCurrency().getDigit()));
        xml = addLine(xml,String.format("<quotation name=\"%s\" />",company.getQuotation().getName()));

        xml = addLine(xml,"</company>");
        // END COMPANY
        return xml;
    }

    private String employeeXML(String xml){
        // EMPLOYEE
        xml = addLine(xml,String.format("<employee id=\"%d\" nif=\"%s\" naf=\"%s\">",employee.getId(),employee.getPassport(),employee.getNaf()));

        xml = addLine(xml,String.format("<name first=\"%s\" second=\"%s\"/>",employee.getName(),employee.getName2()));
        xml = addLine(xml,String.format("<lastname first=\"%s\" second=\"%s\"/>",employee.getLastName(),employee.getLastName2()));
        xml = addLine(xml,String.format("<category name=\"%s\" />",employee.getCategory().getName()));
        xml = addLine(xml,String.format("<apportion>%d</apportion>",processCardinality(employee.isApportion())));

        // SCHEDULE
        xml = addLine(xml,"<schedule>");

        xml = addLine(xml,String.format("<nocturnal>%d</nocturnal>",processCardinality(schedule.isNocturnal())));
        xml = addLine(xml,String.format("<turnicity>%d</turnicity>",processCardinality(schedule.isTurnicity())));
        xml = addLine(xml,String.format("<complementary_hours>%.2f</complementary_hours>",schedule.getComplementaryHours()));
        xml = addLine(xml,String.format("<extra_hours>%.2f</extra_hours>",schedule.getExtraHours()));
        xml = addLine(xml,String.format("<overwhelming_hours>%.2f</overwhelming_hours>",schedule.getOverwhelmingHours()));

        xml = addLine(xml,"</schedule>");
        // END SCHEDULE

        xml = addLine(xml,"</employee>");
        // END EMPLOYEE
        return xml;
    }

    private String salaryPerceptionsXML(String xml){
        // SALARIAL PERCEPTIONS
        xml = addLine(xml,"<perceptions salarial=\"1\">");

        // COMPLEMENTS
        xml = generateComplementsXML(xml,getSalaryComplements(),true);

        xml = addLine(xml,String.format("<base_salary>%.2f</base_salary>",baseSalary));
        xml = addLine(xml,String.format("<apportion>%.2f</apportion>",apportion));
        xml = addLine(xml,String.format("<salary_kind>%.2f</salary_kind>",salaryKind));

        xml = addLine(xml,"</perceptions>");
        // END SALARIAL PERCEPTIONS
        return xml;
    }

    private String nonSalaryPerceptionsXML(String xml){
        // NON SALARIAL PERCEPTIONS
        xml = addLine(xml,"<perceptions salarial=\"0\">");

        // COMPLEMENTS
        xml = generateComplementsXML(xml,getNonSalaryComplements(),false);

        xml = addLine(xml,String.format("<benefits_and_compensations>%.2f</benefits_and_compensations>",benefitsAndCompesations));
        xml = addLine(xml,String.format("<other_benefits>%.2f</other_benefits>",otherBenefits));
        xml = addLine(xml,String.format("<redundancy_payment>%.2f</redundancy_payment>",redundancyPayment));

        xml = addLine(xml,"</perceptions>");
        // END NON SALARIAL PERCEPTIONS

        return xml;
    }

    private String deductionsXML(String xml){
        // DEDUCTIONS
        xml = addLine(xml,"<deductions>");

        xml = addLine(xml,String.format("<cc percentage=\"%.2f\" value=\"%.2f\" />",ccPercentage,ccValue));
        xml = addLine(xml,String.format("<unemployment percentage=\"%.2f\" value=\"%.2f\" />",unemploymentPercentage,unemploymentValue));
        xml = addLine(xml,String.format("<training percentage=\"%.2f\" value=\"%.2f\" />",trainingPercentage,trainingValue));
        xml = addLine(xml,String.format("<oh original=\"%.2f\" percentage=\"%.2f\" value=\"%.2f\" />",ohOriginal,ohPercentage,ohValue));
        xml = addLine(xml,String.format("<eh original=\"%.2f\" percentage=\"%.2f\" value=\"%.2f\" />",ehOriginal,ehPercentage,ehValue));
        xml = addLine(xml,String.format("<irpf percentage=\"%.2f\" value=\"%.2f\" />",irpfPercentage,irpfValue));
        xml = addLine(xml,String.format("<advance_pays>%.2f</advance_pays>",advancePays));
        xml = addLine(xml,String.format("<salary_kind>%.2f</salary_kind>",salaryKindDeduction));
        xml = addLine(xml,String.format("<other>%.2f</other>",otherDeduction));
        xml = addLine(xml,String.format("<total>%.2f</total>",totalDeduction));

        xml = addLine(xml,"</deductions>");
        // END DEDUCTIONS
        return xml;
    }

    private String quotationBasesXML(String xml){
        // QUOTATION BASES
        xml = addLine(xml,"<quotation_bases>");

        xml = addLine(xml,String.format("<cc percentage=\"%.2f\" value=\"%.2f\" />",companyCCPercentage,companyCCValue));
        xml = addLine(xml,String.format("<at percentage=\"%.2f\" value=\"%.2f\" />",companyPCAtPercentage,companyPCAtValue));
        xml = addLine(xml,String.format("<fogasa percentage=\"%.2f\" value=\"%.2f\" />",companyPCFogasaPercentage,companyPCFogasaValue));
        xml = addLine(xml,String.format("<unemployment percentage=\"%.2f\" value=\"%.2f\" />",companyPCUnemploymentPercentage,companyPCUnemploymentValue));
        xml = addLine(xml,String.format("<training percentage=\"%.2f\" value=\"%.2f\" />",companyPCTrainingPercentage,companyPCTrainingValue));
        xml = addLine(xml,String.format("<oh percentage=\"%.2f\" value=\"%.2f\" />",companyOhPercentage,companyOhValue));
        xml = addLine(xml,String.format("<eh percentage=\"%.2f\" value=\"%.2f\" />",companyEhPercentage,companyEhValue));

        xml = addLine(xml,"</quotation_bases>");
        // END QUOTATION BASES
        return xml;
    }

    private String generateComplementsXML(String xml,ArrayList<Complement> complements,boolean salarial){
        xml = addLine(xml,String.format("<complements salarial=\"%d\">",processCardinality(salarial)));
        for(Complement c : complements){
            xml = addLine(xml,String.format("<complement title=\"%s\" original=\"%.2f\" percentage=\"%.2f\" value=\"%.2f\" />",c.getName(),c.getOriginalValue(),c.getValuePercentage(),c.getValue()));
        }
        xml = addLine(xml,"</complements>");
        return xml;
    }

    private String addLine(String data, String content){
        data += "\n" + content;
        return data;
    }

    private int processCardinality(boolean cardinality){
        if(cardinality){
            return 1;
        } else {
            return 0;
        }
    }

}
