package common;

import common.agreement.*;
import common.company.Company;
import common.employee.Employee;
import common.payroll.Complement;
import common.payroll.Payroll;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import configuration.DatabaseDeveloper;
import org.junit.Assert;
import org.junit.Test;
import persistence.service.NominalAPI;
import persistence.xml.XmlAPI;

import static org.junit.Assert.*;

public class PayrollTest {
    @Test
    public void payrollGeneration(){

        NominalAPI api = null;
        XmlAPI xmlAPI = new XmlAPI();
        Company company = null;
        Employee employee = null;
        Payroll payroll = null;

        try {
            api = new NominalAPI(DatabaseDeveloper.NOMINAL.getURL(), DatabaseDeveloper.NOMINAL.getUser(), DatabaseDeveloper.NOMINAL.getPassword());
        } catch (SQLException throwables) {
            Assert.fail(throwables.getMessage());
        }

        try {
            company = api.getCompanyById(3);
            employee = api.getEmployeeById(2);
        } catch (Exception e){
            Assert.fail("OBJECT GET GENERATION" + e.getMessage());
        }

        Date from = Date.valueOf("2021-05-01");
        Date to = Date.valueOf("2021-05-30");

        /*try {
            payroll = Payroll.generatePayroll(company,employee,from,to,api);
            api.setPayroll(payroll);
        } catch (SQLException e){
            Assert.fail("PAYROLL GENERATION" + e.getMessage());
        }*/

        try {
            xmlAPI.exportXml(api.getPayrollById(7).generateXML(),"payroll_test.xml");
        } catch (Exception e){
            Assert.fail("XML GENERATION" + e.getMessage());
        }



    }
}
