/*

 Nominal Application
 Company

 @author     Adán Inarejos
 Date        2021-04-23

 Last revision
 @author     Carlos Pomares
 Date        2021-04-23

*/

package common;

import common.agreement.Agreement;

public class Company implements NominalMaster {

    // IDENTIFIER
    int id;

    // AGREEMENT
    Agreement agreement;

    // INFORMATION
    String name;
    String cif;
    String socialSecurityId;

    // CONTACT
    String streetAddress;
    String state;
    String phoneNumber;

    // TODO
    // String zip;

    // FINANCIAL
    String currency;
    String currencyDigit;

    public Company(int id, Agreement agreement, String name, String cif, String socialSecurityId, String streetAddress, String state, String phoneNumber, String currency, String currencyDigit) {
        this.id = id;
        this.agreement = agreement;
        this.name = name;
        this.cif = cif;
        this.socialSecurityId = socialSecurityId;
        this.streetAddress = streetAddress;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.currency = currency;
        this.currencyDigit = currencyDigit;
    }

    public Company(Agreement agreement, String name, String cif, String socialSecurityId, String streetAddress, String state, String phoneNumber, String currency, String currencyDigit) {
        this.agreement = agreement;
        this.name = name;
        this.cif = cif;
        this.socialSecurityId = socialSecurityId;
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

    public String getName() {
        return name;
    }

    public String getCif() {
        return cif;
    }

    public String getSocialSecurityId() {
        return socialSecurityId;
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