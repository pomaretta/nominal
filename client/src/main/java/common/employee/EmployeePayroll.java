package common.employee;

import common.agreement.Category;

public class EmployeePayroll extends Employee {

    public EmployeePayroll(int id,String passport, String naf, String name, String name2, String lastname, String lastname2, String email, Category category, boolean apportion) {
        this.id = id;
        this.passport = passport;
        this.naf = naf;
        this.name = name;
        this.name2 = name2;
        this.lastName = lastname;
        this.lastName2 = lastname2;
        this.mailAddress = email;
        this.category = category;
        this.apportion = apportion;
    }

}
