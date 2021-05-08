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
import common.agreement.Quotation;
import common.employee.Employee;

import java.util.ArrayList;

public class Company implements NominalMaster {

    // IDENTIFIER
    protected int id;

    // AGREEMENT
    protected Agreement agreement;

    // EMPLOYEES
    protected ArrayList<Employee> employees;

    // INFORMATION
    protected String name;
    protected String cif;
    protected String socialSecurityId;

    // CONTACT
    protected String streetAddress;
    protected String state;
    protected String phoneNumber;

    // FINANCIAL
    protected Currency currency;
    protected Quotation quotation;

    public Company(){}

    public Company(int id, Agreement agreement, ArrayList<Employee> employees, String name, String cif, String socialSecurityId, String streetAddress, String state, String phoneNumber, Currency currency, Quotation quotation) {
        this.id = id;
        this.agreement = agreement;
        this.employees = employees;
        this.name = name;
        this.cif = cif;
        this.socialSecurityId = socialSecurityId;
        this.streetAddress = streetAddress;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.currency = currency;
        this.quotation = quotation;
    }

    public Company(Agreement agreement, ArrayList<Employee> employees, String name, String cif, String socialSecurityId, String streetAddress, String state, String phoneNumber, Currency currency, Quotation quotation) {
        this.agreement = agreement;
        this.employees = employees;
        this.name = name;
        this.cif = cif;
        this.socialSecurityId = socialSecurityId;
        this.streetAddress = streetAddress;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.currency = currency;
        this.quotation = quotation;
    }

    public Company(Agreement agreement, String name, String cif, String socialSecurityId, String streetAddress, String state, String phoneNumber, Currency currency, Quotation quotation) {
        this.agreement = agreement;
        this.name = name;
        this.cif = cif;
        this.socialSecurityId = socialSecurityId;
        this.streetAddress = streetAddress;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.currency = currency;
        this.quotation = quotation;
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

    public Currency getCurrency() {
        return currency;
    }

    public String getSocialSecurityId() {
        return socialSecurityId;
    }

    public Quotation getQuotation() {
        return quotation;
    }
}