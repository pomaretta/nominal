package common;

import common.agreement.*;
import common.company.Company;
import common.employee.Employee;
import common.payroll.Complement;
import common.payroll.Payroll;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class PayrollTest {
    @Test
    public void testGettersPayroll(){
//        Antiquity ant1= new Antiquity(1, Timestamp.valueOf("2001-08-01 22:22:22"), 2, 2, 1992, 2);
//        Salary sal1= new Salary(1, Timestamp.valueOf("2001-08-01 22:22:22"), 2, 2, 5 );
//        Category cat1= new Category(1, "category", 2);
//        Quotation q1= new Quotation(1, "quotation", 2);
//        Complement cmp1= new Complement("complement", 55, 22, 22);
//        Complement cmp2= new Complement("complement2", 55, 22, 22);
//
//        ArrayList<Quotation> QuatationArray = new ArrayList<>();
//        QuatationArray.add(q1);
//        ArrayList<Category> CategoryArray = new ArrayList<>();
//        CategoryArray.add(cat1);
//        ArrayList<Salary> SalaryArray = new ArrayList<>();
//        SalaryArray.add(sal1);
//        ArrayList<Antiquity> AntiquityArray = new ArrayList<>();
//        AntiquityArray.add(ant1);
//        ArrayList<Complement> ComplementArray = new ArrayList<>();
//        ComplementArray.add(cmp1);
//        ArrayList<Complement> Complement2Array = new ArrayList<>();
//        Complement2Array.add(cmp2);

//        Agreement a1= new Agreement(1, "agreement", QuatationArray ,CategoryArray, SalaryArray, AntiquityArray );
//        Company c1 = new Company(a1, "ScafoldInteractive", "cif", "securityid", "calle manolo", "state", "6000444", "currency", "cdigit");
////        Employee emp1 = new Employee(1, "passport", "Tofol", "Manolo", "Isaac", "Fernandez", "tofol@tofol.com", "602015412", Date.valueOf("2001-01-22") , Date.valueOf("2002-01-22"), 2, true, true, false, 22, 55 );
//
//        Payroll p1= new Payroll(1, Timestamp.valueOf("2021-01-01 22:22:22"), c1, a1, emp1, Date.valueOf("2001-01-22"), Date.valueOf("2002-01-22"), 22, ComplementArray,Complement2Array, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22);
//
//        assertEquals(1, p1.getId());
//        assertEquals(Timestamp.valueOf("2021-01-01 22:22:22"), p1.getCreated());
//        assertEquals(c1, p1.getCompany());
//        assertEquals(a1, p1.getAgreement());
//        assertEquals(emp1, p1.getEmployee());
//        assertEquals(Date.valueOf("2001-01-22"), p1.getFrom());
//        assertEquals(Date.valueOf("2002-01-22"), p1.getTo());
//        assertEquals(22, p1.getTotalDays());
//        assertEquals(ComplementArray, p1.getSalaryComplements());
//        assertEquals(Complement2Array, p1.getNonSalaryComplements());
//        assertEquals(22, p1.getSalaryKind(), 0.05);
//        assertEquals(22, p1.getTotalEarned(), 0.05);
//        assertEquals(22, p1.getCcPercentage(), 0.05);
//        assertEquals(22, p1.getCcValue(), 0.05);
//        assertEquals(22, p1.getUnemploymentPercentage(), 0.05);
//        assertEquals(22, p1.getUnemploymentValue(), 0.05);
//        assertEquals(22, p1.getTrainingPercentage(), 0.05);
//        assertEquals(22, p1.getTrainingValue(), 0.05);
//        assertEquals(22, p1.getOhPercentage(), 0.05);
//        assertEquals(22, p1.getOhValue(), 0.05);
//        assertEquals(22, p1.getEhPercentage(), 0.05);
//        assertEquals(22, p1.getEhValue(), 0.05);
//        assertEquals(22, p1.getTotalApportions(), 0.05);
//        assertEquals(22, p1.getIrpfPercentage(), 0.05);
//        assertEquals(22, p1.getIrpfValue(), 0.05);
//        assertEquals(22, p1.getAdvancePays(), 0.05);
//        assertEquals(22, p1.getSalaryKindDeduction(), 0.05);
//        assertEquals(22, p1.getOtherDeduction(), 0.05);
//        assertEquals(22, p1.getTotalDeduction(), 0.05);
//        assertEquals(22, p1.getTotalToReceive(), 0.05);
    }
}
