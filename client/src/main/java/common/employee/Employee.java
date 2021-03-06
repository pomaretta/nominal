/*

 Nominal Application
 Employee

*/

package common.employee;

import common.NominalMaster;
import common.NominalObject;
import common.agreement.Category;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;

public class Employee extends NominalObject {

    // IDENTIFIER
    protected int id;
    protected Timestamp lastUpdated;
    protected String passport;
    protected String naf;

    // INFORMATION
    protected String name;
    protected String name2;
    protected String lastName;
    protected String lastName2;

    // CONTACT
    protected String mailAddress;
    protected String phoneNumber;
    protected String streetAddress;

    // CONTRACT
    protected Category category;
    protected Date joinDate;
    protected Date expirationDate;
    protected boolean active;
    protected boolean hourly;

    // FINANCIAL
    protected boolean apportion;
    protected float hiredHours;
    protected float irpf;

    public Employee(){}

    /**
     *
     * @param id employee identificator
     * @param lastUpdated last update date
     * @param passport employee passport
     * @param naf social security identification
     * @param name employee name
     * @param name2 employee second name
     * @param lastName employee firs lastname
     * @param lastName2 employee second lastna,e
     * @param mailAddress email of the employee
     * @param phoneNumber phone of the employee
     * @param streetAddress street address of the employee
     * @param category employee category
     * @param joinDate day the employee joined to the company
     * @param expirationDate day of employee expiration
     * @param active boolean to know the status of the employee
     * @param hourly boolean to know the employee hourly
     * @param apportion extra pays and prorated pays
     * @param hiredHours hired hours of the employee
     * @param irpf irpf percentage of the employee
     */
    public Employee(int id, Timestamp lastUpdated, String passport, String naf, String name, String name2, String lastName, String lastName2, String mailAddress, String phoneNumber, String streetAddress, Category category, Date joinDate, Date expirationDate, boolean active, boolean hourly, boolean apportion, float hiredHours, float irpf) {
        this.id = id;
        this.lastUpdated = lastUpdated;
        this.passport = passport;
        this.naf = naf;
        this.name = name;
        this.name2 = name2;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.mailAddress = mailAddress;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.category = category;
        this.joinDate = joinDate;
        this.expirationDate = expirationDate;
        this.active = active;
        this.hourly = hourly;
        this.apportion = apportion;
        this.hiredHours = hiredHours;
        this.irpf = irpf;
    }

    public Employee(String passport, String naf, String name, String name2, String lastName, String lastName2, String mailAddress, String phoneNumber, String streetAddress, Category category, Date joinDate, Date expirationDate, boolean active, boolean hourly, boolean apportion, float hiredHours, float irpf) {
        this.passport = passport;
        this.naf = naf;
        this.name = name;
        this.name2 = name2;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.mailAddress = mailAddress;
        this.phoneNumber = phoneNumber;
        this.streetAddress = streetAddress;
        this.category = category;
        this.joinDate = joinDate;
        this.expirationDate = expirationDate;
        this.active = active;
        this.hourly = hourly;
        this.apportion = apportion;
        this.hiredHours = hiredHours;
        this.irpf = irpf;
    }

    // GETTERS
    @Override
    public int getId() {
        return id;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public String getPassport() {
        return passport;
    }

    public String getNaf() {
        return naf;
    }

    public String getName() {
        return name;
    }

    public String getName2() {
        return name2;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastName2() {
        return lastName2;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public Category getCategory() {
        return category;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isHourly() {
        return hourly;
    }

    public boolean isApportion() {
        return apportion;
    }

    public float getHiredHours() {
        return hiredHours;
    }

    public float getIrpf() {
        return irpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setHourly(boolean hourly) {
        this.hourly = hourly;
    }

    public void setApportion(boolean apportion) {
        this.apportion = apportion;
    }

    public void setHiredHours(float hiredHours) {
        this.hiredHours = hiredHours;
    }

    public void setIrpf(float irpf) {
        this.irpf = irpf;
    }

    /**
     *
     * Calculates the years between join date and now
     *
     * @return the years in the company
     */
    public int companyYears(){
        LocalDate d1 = this.joinDate.toLocalDate();
        LocalDate d2 = LocalDate.now();
        Duration diff = Duration.between(d1.atStartOfDay(),d2.atStartOfDay());
        double difference = (double) diff.toDays() / 365;
        return (int)Math.floor(difference);
    }

    /**
     *
     * Calculates the Antiquity of a employee in the company by acceptable values.
     *
     * @return the exact years by the agreement values.
     */
    public int calculateYears(){
        int years = companyYears();
        if(years >= 24){
            return 24;
        } else if (years >= 19){
            return 19;
        } else if (years >= 14){
            return 14;
        } else if (years >= 9){
            return 9;
        } else if (years >= 6){
            return 6;
        } else if (years >= 3){
            return 3;
        } else {
            return 0;
        }
    }

}