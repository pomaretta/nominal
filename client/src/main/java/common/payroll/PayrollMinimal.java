package common.payroll;

import common.employee.Employee;

import java.sql.Date;

public class PayrollMinimal extends Payroll {

    public PayrollMinimal(int id, Date from, Date to, Employee employee, float totalEarned) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.employee = employee;
        this.totalEarned = totalEarned;
    }

}
