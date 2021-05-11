/*

 Nominal Application
 Payroll

 @author     Carlos Pomares
 Date        2021-04-24

*/

package common.payroll;

import common.company.Company;
import common.employee.Employee;
import common.NominalMaster;
import common.agreement.Agreement;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Payroll implements NominalMaster {

    // IDENTIFIER
    protected int id;
    protected Timestamp created;

    // REFERENCES
    protected Company company;
    protected Agreement agreement;
    protected Employee employee;

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

    public Payroll(int id, Timestamp created, Company company, Agreement agreement, Employee employee, Date from, Date to, int totalDays, float baseSalary, boolean employeeApportion, float apportion, ArrayList<Complement> salaryComplements, ArrayList<Complement> nonSalaryComplements, float salaryKind, float totalEarned, float ccPercentage, float ccValue, float benefitsAndCompesations, float redundancyPayment, float otherBenefits, float unemploymentPercentage, float unemploymentValue, float trainingPercentage, float trainingValue, float ohOriginal, float ohPercentage, float ohValue, float ehOriginal, float ehPercentage, float ehValue, float totalApportions, float irpfPercentage, float irpfValue, float advancePays, float salaryKindDeduction, float otherDeduction, float totalBccc, float totalDeduction, float totalToReceive, float companyCCPercentage, float companyCCValue, float companyPCAtPercentage, float companyPCAtValue, float companyPCUnemploymentPercentage, float companyPCUnemploymentValue, float companyPCTrainingPercentage, float companyPCTrainingValue, float companyPCFogasaPercentage, float companyPCFogasaValue, float companyEhPercentage, float companyEhValue, float companyOhPercentage, float companyOhValue) {
        this.id = id;
        this.created = created;
        this.company = company;
        this.agreement = agreement;
        this.employee = employee;
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

    public Payroll(Company company, Agreement agreement, Employee employee, Date from, Date to, int totalDays, float baseSalary, boolean employeeApportion, float apportion, ArrayList<Complement> salaryComplements, ArrayList<Complement> nonSalaryComplements, float salaryKind, float totalEarned, float ccPercentage, float ccValue, float benefitsAndCompesations, float redundancyPayment, float otherBenefits, float unemploymentPercentage, float unemploymentValue, float trainingPercentage, float trainingValue, float ohOriginal, float ohPercentage, float ohValue, float ehOriginal, float ehPercentage, float ehValue, float totalApportions, float irpfPercentage, float irpfValue, float advancePays, float salaryKindDeduction, float otherDeduction, float totalBccc, float totalDeduction, float totalToReceive, float companyCCPercentage, float companyCCValue, float companyPCAtPercentage, float companyPCAtValue, float companyPCUnemploymentPercentage, float companyPCUnemploymentValue, float companyPCTrainingPercentage, float companyPCTrainingValue, float companyPCFogasaPercentage, float companyPCFogasaValue, float companyEhPercentage, float companyEhValue, float companyOhPercentage, float companyOhValue) {
        this.company = company;
        this.agreement = agreement;
        this.employee = employee;
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
}
