/*

 Nominal Application
 Payroll

*/

package common.payroll;

import common.NominalObject;
import common.agreement.Antiquity;
import common.company.Company;
import common.employee.Employee;
import common.NominalMaster;
import common.agreement.Agreement;
import common.employee.Schedule;
import common.agreement.Salary;
import persistence.service.NominalAPI;
import application.NominalFX;

import java.sql.Date;
import java.sql.SQLException;
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

    // CONSTRUCTORS.
    public Payroll() {
    }

    /**
     *
     * @param id payroll identificator
     * @param created creation date
     * @param company company to which the employee belongs
     * @param agreement agreement to which the employee belongs
     * @param employee employee who is doing the payroll
     * @param schedule schedule of th employee
     * @param from first day
     * @param to last day
     * @param totalDays total days worked
     * @param baseSalary salary base of the employee
     * @param employeeApportion employee aportions
     * @param apportion extra pays and prorated pays
     * @param salaryComplements salary complements
     * @param nonSalaryComplements non salary complements
     * @param salaryKind salary in kind
     * @param totalEarned sum of perceptions
     * @param ccPercentage percentage to calcs common contingencies value
     * @param ccValue common contingencies value
     * @param benefitsAndCompesations perceptions of benefits and conpensations
     * @param redundancyPayment compensation for transfers, suspensions or dismissals
     * @param otherBenefits other benefits
     * @param unemploymentPercentage percentage to calcs enemployment value
     * @param unemploymentValue calculated unemployment value
     * @param trainingPercentage percentage to calcs training value
     * @param trainingValue calculed training value
     * @param ohOriginal overwhelming hours made
     * @param ohPercentage percentage for calcs overwhelming hours value
     * @param ohValue calculed overwhelming hours value
     * @param ehOriginal extra hours made
     * @param ehPercentage percentage for calcs extra hours value
     * @param ehValue calculed extra hours value
     * @param totalApportions sum of all apportions
     * @param irpfPercentage percentage for calcs irpf
     * @param irpfValue calculed irpf value
     * @param advancePays value of advancePays
     * @param salaryKindDeduction deduction for the salarykind
     * @param otherDeduction other deductions
     * @param totalBccc calculed total Bccc
     * @param totalDeduction sum of al deductions
     * @param totalToReceive calculed total to receive
     * @param companyCCPercentage percentage for calcs the company common contingencies value
     * @param companyCCValue calculed company common contingencies
     * @param companyPCAtPercentage percentage to calc company AT/ET value
     * @param companyPCAtValue calculed company AT/ET value
     * @param companyPCUnemploymentPercentage percentage to cals company unemployment value
     * @param companyPCUnemploymentValue calculated company unemploymet value
     * @param companyPCTrainingPercentage percentage to calcs company training value
     * @param companyPCTrainingValue calculed company training value
     * @param companyPCFogasaPercentage percentage to calcs company fogasa value
     * @param companyPCFogasaValue calculed company fogasa value
     * @param companyEhPercentage percentage to calcs company extra hours value
     * @param companyEhValue calculated company extra hours value
     * @param companyOhPercentage percenatage to calcs overwhelming hours value
     * @param companyOhValue calculated overwhelming hours value
     */
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

    // GETTERS
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

    // This methods generate the XML with the atributes of the payroll, employee and company
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

    // CALCS

    // Arraylist for the complemets
    private static ArrayList<Complement> generateComplements(Employee employee,Antiquity antiquity, Salary salary,Schedule schedule, boolean salarial){

        ArrayList<Complement> complements = new ArrayList<>();

        if(salarial){

            if(schedule.isNocturnal()){
                float nocturnity = ((salary.getValue() / 4) / employee.getHiredHours()) * schedule.getComplementaryHours();
                complements.add(new Complement("Nocturnity",nocturnity,0.0f,nocturnity));
            }

            if(schedule.isTurnicity()){
                float turnicity = salary.getValue() * 0.01f;
                complements.add(new Complement("Turnicity",turnicity,0.0f,turnicity));
            }

            if(antiquity != null){
                float antiquityValue = antiquity.getValue() * employee.companyYears();
                complements.add(new Complement("Antiquity",antiquityValue,0.0f,antiquityValue));
            }

        }

        return complements;
    }

    // This method do the necessary calcs for the payroll and create a payroll with al the nesessary information
    public static Payroll generatePayroll(Company company, Employee employee, Date from, Date to, NominalAPI api) throws SQLException  {

        Salary salary = api.getSalaryTableByFields(company.getAgreement(), employee.getCategory(), company.getQuotation());
        Antiquity antiquity = api.getAntiquityByFields(company.getAgreement(), employee.getCategory(), company.getQuotation(), employee.calculateYears());
        Schedule schedule = api.getScheduleByDateAndEmployee(employee, from, to);

        Duration diff = Duration.between(from.toLocalDate().atStartOfDay(),to.toLocalDate().atStartOfDay());
        int totalDays = (int) diff.toDays() + 1;

        float employeeHour = ((salary.getValue() / 4) / employee.getHiredHours());

        // Salarial Perceptions
        float baseSalary = salary.getValue();

        float apportion = (baseSalary * 2) / 12;

        // SALARY COMPLEMENTS
        float salaryComplements = 0f;
        ArrayList<Complement> salaryComplementsList = generateComplements(employee,antiquity,salary,schedule,true);
        for(Complement c : salaryComplementsList){
            salaryComplements += c.getValue();
        }

        float ohPercentage = 1.14f;
        float oh = (employeeHour * ohPercentage) * schedule.getOverwhelmingHours();

        float ehPercentage = 1f;
        if(schedule.getExtraHours() > 9){
            ehPercentage = 2f;
        }
        float eh = (employeeHour * ehPercentage) * schedule.getExtraHours();

        float complementaryHours = employeeHour * schedule.getComplementaryHours();

        float salaryKind = 0;

        // Non salarial Perceptions

        // NON SALARIAL COMPLEMENTS
        float nonSalaryComplements = 0f;
        ArrayList<Complement> nonSalaryComplementsList = generateComplements(employee,antiquity,salary,schedule,false);
        for(Complement c : salaryComplementsList){
            nonSalaryComplements += c.getValue();
        }

        float benefitsAndCompensations = 0;
        float redudancyPayment = 0;
        float otherBenefits = 0;

        float totalEarned = baseSalary + salaryComplements + oh + eh + complementaryHours + salaryKind + nonSalaryComplements + benefitsAndCompensations + redudancyPayment + otherBenefits;

        if(employee.isApportion()){
            totalEarned += apportion;
        }

        // Reductions.

        float ccPercentage = 4.7f;
        float ccValue = baseSalary * (ccPercentage/100);

        //Variable

        float unemploymentPercentage = 5.50f;
        if(employee.isHourly()){
            unemploymentPercentage = 6.70f;
        }
        float unemploymentValue = baseSalary * (unemploymentPercentage / 100);

        float trainingPercentage = 1.55f;
        if(employee.isHourly()){
            trainingPercentage = 0.10f;
        }
        float trainingValue = baseSalary * (trainingPercentage / 100);

        float reductionOhPercentage = 2.0f;
        float reductionOhValue= oh * ( reductionOhPercentage / 100);

        float reductionEhPercentage = 4.7f;
        float reductionEhValue = eh * (reductionEhPercentage / 100);

        float totalApportions = ccValue + unemploymentValue + trainingValue + reductionOhValue + reductionEhValue;

        float irpfPercentage = employee.getIrpf();
        float irpfValue = baseSalary * (irpfPercentage / 100);

        float advancePays = 0;

        float salaryKindReduction = 0;

        float otherReductions = 0;

        float totalReductions = totalApportions + irpfValue + advancePays + salaryKindReduction + otherReductions;

        //

        float totalToReceive = totalEarned - totalReductions;
        float totalBccc = baseSalary + apportion;

        float companyAtPercentage = 23.60f;
        float companyAtValue = totalEarned * (companyAtPercentage / 100);

        float companyUnemploymentPercentage;
        if (employee.isHourly()) {
            companyUnemploymentPercentage = 6.70f;

        } else {
            companyUnemploymentPercentage = 5.50f;
        }
        float companyUnemploymentValue = totalEarned * (companyUnemploymentPercentage / 100);

        float companyTrainingPercentage = 0.60f;
        float companyTrainingValue = totalEarned * (companyTrainingPercentage / 100);

        float companyFogasaPercentage = 0.20f;
        float companyFogasaValue = totalEarned * (companyFogasaPercentage / 100);

        float companyCCPercentage = 23.6f;
        float companyCCValue = (companyAtValue + companyUnemploymentValue + companyTrainingValue + companyFogasaValue) * (companyCCPercentage / 100);

        float companyOhPercentage = 12.0f;
        float companyOhValue = oh * (companyOhPercentage / 100);

        float companyEhPercentage = 23.60f;
        float companyEhValue = eh * (companyEhPercentage / 100);

        return new Payroll(
                company
                ,company.getAgreement()
                ,employee
                ,schedule
                ,from
                ,to
                ,totalDays
                ,baseSalary
                ,employee.isApportion()
                ,employee.isApportion() ? apportion : 0f
                ,salaryComplementsList
                ,nonSalaryComplementsList
                ,salaryKind
                ,totalEarned
                ,ccPercentage
                ,ccValue
                ,benefitsAndCompensations
                ,redudancyPayment
                ,otherBenefits
                ,unemploymentPercentage
                ,unemploymentValue
                ,trainingPercentage
                ,trainingValue
                ,oh
                ,reductionOhPercentage
                ,reductionOhValue
                ,eh
                ,reductionEhPercentage
                ,reductionEhValue
                ,totalApportions
                ,irpfPercentage
                ,irpfValue
                ,advancePays
                ,salaryKindReduction
                ,otherReductions
                ,totalBccc
                ,totalReductions
                ,totalToReceive
                ,companyCCPercentage
                ,companyCCValue
                ,companyAtPercentage
                ,companyAtValue
                ,companyUnemploymentPercentage
                ,companyUnemploymentValue
                ,companyTrainingPercentage
                ,companyTrainingValue
                ,companyFogasaPercentage
                ,companyFogasaValue
                ,companyEhPercentage
                ,companyEhValue
                ,companyOhPercentage
                ,companyOhValue
        );
    }


}
