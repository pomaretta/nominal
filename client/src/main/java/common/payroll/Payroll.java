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

    // COMPLEMENTS
    protected ArrayList<Complement> salaryComplements;
    protected ArrayList<Complement> nonSalaryComplements;

    protected float salaryKind;
    protected float totalEarned;

    // CC
    protected float ccPercentage;
    protected float ccValue;

    // Unemployment
    protected float unemploymentPercentage;
    protected float unemploymentValue;

    // Training
    protected float trainingPercentage;
    protected float trainingValue;

    // Ordinary Hours
    protected float ohPercentage;
    protected float ohValue;

    // Extra hours
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

    // Total Deduction
    protected float totalDeduction;

    // Total to Receive
    protected float totalToReceive;

    public Payroll() {
    }

    public Payroll(int id, Timestamp created, Company company, Agreement agreement, Employee employee, Date from, Date to, int totalDays, ArrayList<Complement> salaryComplements, ArrayList<Complement> nonSalaryComplements, float salaryKind, float totalEarned, float ccPercentage, float ccValue, float unemploymentPercentage, float unemploymentValue, float trainingPercentage, float trainingValue, float ohPercentage, float ohValue, float ehPercentage, float ehValue, float totalApportions, float irpfPercentage, float irpfValue, float advancePays, float salaryKindDeduction, float otherDeduction, float totalDeduction, float totalToReceive) {
        this.id = id;
        this.created = created;
        this.company = company;
        this.agreement = agreement;
        this.employee = employee;
        this.from = from;
        this.to = to;
        this.totalDays = totalDays;
        this.salaryComplements = salaryComplements;
        this.nonSalaryComplements = nonSalaryComplements;
        this.salaryKind = salaryKind;
        this.totalEarned = totalEarned;
        this.ccPercentage = ccPercentage;
        this.ccValue = ccValue;
        this.unemploymentPercentage = unemploymentPercentage;
        this.unemploymentValue = unemploymentValue;
        this.trainingPercentage = trainingPercentage;
        this.trainingValue = trainingValue;
        this.ohPercentage = ohPercentage;
        this.ohValue = ohValue;
        this.ehPercentage = ehPercentage;
        this.ehValue = ehValue;
        this.totalApportions = totalApportions;
        this.irpfPercentage = irpfPercentage;
        this.irpfValue = irpfValue;
        this.advancePays = advancePays;
        this.salaryKindDeduction = salaryKindDeduction;
        this.otherDeduction = otherDeduction;
        this.totalDeduction = totalDeduction;
        this.totalToReceive = totalToReceive;
    }

    public Payroll(Timestamp created, Company company, Agreement agreement, Employee employee, Date from, Date to, int totalDays, ArrayList<Complement> salaryComplements, ArrayList<Complement> nonSalaryComplements, float salaryKind, float totalEarned, float ccPercentage, float ccValue, float unemploymentPercentage, float unemploymentValue, float trainingPercentage, float trainingValue, float ohPercentage, float ohValue, float ehPercentage, float ehValue, float totalApportions, float irpfPercentage, float irpfValue, float advancePays, float salaryKindDeduction, float otherDeduction, float totalDeduction, float totalToReceive) {
        this.created = created;
        this.company = company;
        this.agreement = agreement;
        this.employee = employee;
        this.from = from;
        this.to = to;
        this.totalDays = totalDays;
        this.salaryComplements = salaryComplements;
        this.nonSalaryComplements = nonSalaryComplements;
        this.salaryKind = salaryKind;
        this.totalEarned = totalEarned;
        this.ccPercentage = ccPercentage;
        this.ccValue = ccValue;
        this.unemploymentPercentage = unemploymentPercentage;
        this.unemploymentValue = unemploymentValue;
        this.trainingPercentage = trainingPercentage;
        this.trainingValue = trainingValue;
        this.ohPercentage = ohPercentage;
        this.ohValue = ohValue;
        this.ehPercentage = ehPercentage;
        this.ehValue = ehValue;
        this.totalApportions = totalApportions;
        this.irpfPercentage = irpfPercentage;
        this.irpfValue = irpfValue;
        this.advancePays = advancePays;
        this.salaryKindDeduction = salaryKindDeduction;
        this.otherDeduction = otherDeduction;
        this.totalDeduction = totalDeduction;
        this.totalToReceive = totalToReceive;
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

    public float getOhPercentage() {
        return ohPercentage;
    }

    public float getOhValue() {
        return ohValue;
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

    public float getTotalDeduction() {
        return totalDeduction;
    }

    public float getTotalToReceive() {
        return totalToReceive;
    }
}
