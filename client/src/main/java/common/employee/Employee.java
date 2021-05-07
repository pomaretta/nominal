/*

 Nominal Application
 Employee

 @author     Adán Inarejos
 Date        2021-04-23

 Last revision
 @author     Carlos Pomares
 Date        2021-04-23

*/

package common.employee;

import common.NominalMaster;
import common.agreement.Category;

import java.sql.Date;

public class Employee implements NominalMaster {

    // IDENTIFIER
    protected int id;
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

    public Employee(int id, String passport, String naf, String name, String name2, String lastName, String lastName2, String mailAddress, String phoneNumber, String streetAddress, Category category, Date joinDate, Date expirationDate, boolean active, boolean hourly, boolean apportion, float hiredHours, float irpf) {
        this.id = id;
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

    @Override
    public int getId() {
        return id;
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
}