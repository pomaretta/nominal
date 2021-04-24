/*

 Nominal Application
 Payroll

 @author     Carlos Pomares
 Date        2021-04-24

*/

package common.payroll;

import common.Company;
import common.Employee;
import common.NominalMaster;
import common.agreement.Agreement;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Payroll implements NominalMaster {

    // IDENTIFIER
    private int id;
    private final Timestamp created;

    // REFERENCES
    private final Company company;
    private final Agreement agreement;
    private final Employee employee;

    // DATES
    private final Date from;
    private final Date to;
    private final int totalDays;

    // COMPLEMENTS
    private final ArrayList<Complement> salaryComplements;
    private final ArrayList<Complement> nonSalaryComplements;

    private final float salaryKind;
    private final float totalEarned;

    // CC
    private final float ccPercentage;
    private final float ccValue;

    // Unemployment
    private final float unemploymentPercentage;
    private final float unemploymentValue;

    // Training
    private final float trainingPercentage;
    private final float trainingValue;

    // Ordinary Hours
    private final float ohPercentage;
    private final float ohValue;

    // Extra hours
    private final float ehPercentage;
    private final float ehValue;

    // Total apportions
    private final float totalApportions;

    // IRPF
    private final float irpfPercentage;
    private final float irpfValue;

    // ADVANCE PAYS
    private final float advancePays;

    // Salary Kind Deduction
    private final float salaryKindDeduction;

    // Other deduction
    private final float otherDeduction;

    // Total Deduction
    private final float totalDeduction;

    // Total to Receive
    private final float totalToReceive;

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
