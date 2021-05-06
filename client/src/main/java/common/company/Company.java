/*

 Nominal Application
 Company

 @author     Adán Inarejos
 Date        2021-04-23

 Last revision
 @author     Carlos Pomares
 Date        2021-04-23

*/

package common.company;

import common.NominalMaster;
import common.agreement.Agreement;
import common.employee.Employee;

import java.util.ArrayList;

public class Company implements NominalMaster {

    // IDENTIFIER
    private int id;

    // AGREEMENT
    private Agreement agreement;

    // EMPLOYEES
    private ArrayList<Employee> employees;

    // INFORMATION
    private String name;
    private String cif;

    // CONTACT
    private String streetAddress;
    private String state;
    private String phoneNumber;

    // FINANCIAL
    private String currency;
    private String currencyDigit;

    public Company(int id, Agreement agreement, ArrayList<Employee> employees, String name, String cif, String streetAddress, String state, String phoneNumber, String currency, String currencyDigit) {
        this.id = id;
        this.agreement = agreement;
        this.employees = employees;
        this.name = name;
        this.cif = cif;
        this.streetAddress = streetAddress;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.currency = currency;
        this.currencyDigit = currencyDigit;
    }

    public Company(Agreement agreement, ArrayList<Employee> employees, String name, String cif, String streetAddress, String state, String phoneNumber, String currency, String currencyDigit) {
        this.agreement = agreement;
        this.employees = employees;
        this.name = name;
        this.cif = cif;
        this.streetAddress = streetAddress;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.currency = currency;
        this.currencyDigit = currencyDigit;
    }

    public Company(Agreement agreement, String name, String cif, String streetAddress, String state, String phoneNumber, String currency, String currencyDigit) {
        this.agreement = agreement;
        this.name = name;
        this.cif = cif;
        this.streetAddress = streetAddress;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.currency = currency;
        this.currencyDigit = currencyDigit;
    }

    @Override
    public int getId() {
        return id;
    }

    public Agreement getAgreement() {
        return agreement;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }

    public String getCif() {
        return cif;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getState() {
        return state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCurrencyDigit() {
        return currencyDigit;
    }
}