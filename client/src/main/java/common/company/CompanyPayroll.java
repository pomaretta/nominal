package common.company;

import common.agreement.Quotation;

public class CompanyPayroll extends Company {

    public CompanyPayroll(int id, String name, String cif, String street, String ss, String state, Currency currency, Quotation quotation) {
        this.id = id;
        this.name = name;
        this.cif = cif;
        this.streetAddress = street;
        this.socialSecurityId = ss;
        this.state = state;
        this.currency = currency;
        this.quotation = quotation;
    }

}
