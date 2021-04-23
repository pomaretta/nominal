/*

 Nominal Application
 Employee

 @author     Adán Inarejos
 Date        2021-04-23

 Last revision
 @author     Carlos Pomares
 Date        2021-04-23

*/

package common;

import java.sql.Date;

public class Employee implements NominalMaster {

    // IDENTIFIER
    int id;
    String passport;

    // INFORMATION
    String name;
    String name2;
    String lastName;
    String lastName2;

    // CONTACT
    String mailAddress;
    String phoneNumber;

    // CONTRACT
    Date joinDate;
    Date expirationDate;
    int category;
    boolean active;
    boolean hourly;

    // FINANCIAL
    boolean apportion;
    float hiredHours;
    float irpf;

    public Employee(int id, String passport, String name, String name2, String lastName, String lastName2, String mailAddress, String phoneNumber, Date joinDate, Date expirationDate, int category, boolean active, boolean hourly, boolean apportion, float hiredHours, float irpf) {
        this.id = id;
        this.passport = passport;
        this.name = name;
        this.name2 = name2;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.mailAddress = mailAddress;
        this.phoneNumber = phoneNumber;
        this.joinDate = joinDate;
        this.expirationDate = expirationDate;
        this.category = category;
        this.active = active;
        this.hourly = hourly;
        this.apportion = apportion;
        this.hiredHours = hiredHours;
        this.irpf = irpf;
    }

    public Employee(String passport, String name, String name2, String lastName, String lastName2, String mailAddress, String phoneNumber, Date joinDate, Date expirationDate, int category, boolean active, boolean hourly, boolean apportion, float hiredHours, float irpf) {
        this.passport = passport;
        this.name = name;
        this.name2 = name2;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.mailAddress = mailAddress;
        this.phoneNumber = phoneNumber;
        this.joinDate = joinDate;
        this.expirationDate = expirationDate;
        this.category = category;
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

    public Date getJoinDate() {
        return joinDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public int getCategory() {
        return category;
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