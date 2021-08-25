package persistence;

import common.payroll.Payroll;
import configuration.DatabaseDeveloper;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import persistence.report.ReportAPI;
import persistence.service.NominalAPI;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportAPITest {

    @Test
    @Ignore public void createReport(){

        ReportAPI reportAPI = null;
        URL report = getClass().getResource("/reports/payroll_report.jrxml");

        try {
            reportAPI = new ReportAPI(DatabaseDeveloper.NOMINAL.getURL(), DatabaseDeveloper.NOMINAL.getUser(), DatabaseDeveloper.NOMINAL.getPassword());
        } catch (SQLException throwables) {
            Assert.fail(throwables.getMessage());
        }

        try {
            HashMap<String,Object> parameters = new HashMap<>();
            parameters.put("PAYROLL_ID",1);
            reportAPI.exportToPdf(reportAPI.getReport(report.getPath()),parameters,"report.pdf");
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

    }

}
