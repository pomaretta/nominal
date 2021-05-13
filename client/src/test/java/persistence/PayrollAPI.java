package persistence;

import common.company.Company;
import common.payroll.Payroll;
import configuration.DatabaseDeveloper;
import org.junit.Assert;
import org.junit.Test;
import persistence.service.NominalAPI;
import persistence.xml.XmlAPI;

import java.sql.SQLException;

public class PayrollAPI {

    @Test
    public void xmlTest(){

        XmlAPI xmlAPI = new XmlAPI();
        NominalAPI api = null;
        Payroll payroll = null;

        try {
            api = new NominalAPI(DatabaseDeveloper.NOMINAL.getURL(), DatabaseDeveloper.NOMINAL.getUser(), DatabaseDeveloper.NOMINAL.getPassword());
        } catch (SQLException throwables) {
            Assert.fail(throwables.getMessage());
        }

        try {
            payroll = api.getPayrollById(1);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        Assert.assertEquals(1,payroll.getId());

        try {
            xmlAPI.exportXml(payroll.generateXML(),"payroll_test.xml");
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void insertPayroll(){

        NominalAPI api = null;
        Payroll payroll = null;
        Payroll payrollTest = null;

        try {
            api = new NominalAPI(DatabaseDeveloper.NOMINAL.getURL(), DatabaseDeveloper.NOMINAL.getUser(), DatabaseDeveloper.NOMINAL.getPassword());
        } catch (SQLException throwables) {
            Assert.fail(throwables.getMessage());
        }

        try {
            payroll = api.getPayrollById(1);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        payrollTest = new Payroll(
                payroll.getCompany()
                ,payroll.getAgreement()
                ,payroll.getEmployee()
                ,payroll.getSchedule()
                ,payroll.getFrom()
                ,payroll.getTo()
                ,payroll.getTotalDays()
                ,payroll.getBaseSalary()
                ,payroll.getEmployee().isApportion()
                ,payroll.getApportion()
                ,payroll.getSalaryComplements()
                ,payroll.getNonSalaryComplements()
                ,payroll.getSalaryKind()
                ,payroll.getTotalEarned()
                ,payroll.getCcPercentage()
                ,payroll.getCcValue()
                ,payroll.getBenefitsAndCompesations()
                ,payroll.getRedundancyPayment()
                ,payroll.getOtherBenefits()
                ,payroll.getUnemploymentPercentage()
                ,payroll.getUnemploymentValue()
                ,payroll.getTrainingPercentage()
                ,payroll.getTrainingValue()
                ,payroll.getOhOriginal()
                ,payroll.getOhPercentage()
                ,payroll.getOhValue()
                ,payroll.getEhOriginal()
                ,payroll.getEhPercentage()
                ,payroll.getEhValue()
                ,payroll.getTotalApportions()
                ,payroll.getIrpfPercentage()
                ,payroll.getIrpfValue()
                ,payroll.getAdvancePays()
                ,payroll.getSalaryKindDeduction()
                ,payroll.getOtherDeduction()
                ,payroll.getTotalBccc()
                ,payroll.getTotalToReceive()
                ,payroll.getTotalToReceive()
                ,payroll.getCompanyCCPercentage()
                ,payroll.getCompanyCCValue()
                ,payroll.getCompanyPCAtPercentage()
                ,payroll.getCompanyPCAtValue()
                ,payroll.getCompanyPCUnemploymentPercentage()
                ,payroll.getCompanyPCUnemploymentValue()
                ,payroll.getCompanyPCTrainingPercentage()
                ,payroll.getCompanyPCTrainingValue()
                ,payroll.getCompanyPCFogasaPercentage()
                ,payroll.getCompanyPCFogasaValue()
                ,payroll.getCompanyEhPercentage()
                ,payroll.getCompanyEhValue()
                ,payroll.getCompanyOhPercentage()
                ,payroll.getCompanyOhValue()
        );

        try {
            api.setPayroll(payrollTest);
        } catch (SQLException e){
            Assert.fail(e.getMessage());
        }

    }

}
