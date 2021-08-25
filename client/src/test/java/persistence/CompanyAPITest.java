package persistence;

import common.company.Company;
import configuration.DatabaseDeveloper;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import persistence.service.NominalAPI;

import java.sql.SQLException;

public class CompanyAPITest {

    @Test
    @Ignore public void checkerTest(){

        NominalAPI api = null;
        Company company = null;

        try {
            api = new NominalAPI(DatabaseDeveloper.NOMINAL.getURL(), DatabaseDeveloper.NOMINAL.getUser(), DatabaseDeveloper.NOMINAL.getPassword());
        } catch (SQLException throwables) {
            Assert.fail(throwables.getMessage());
        }

        try {
            company = api.getCompanyById(1);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        Assert.assertEquals(1,company.getId());

        try {
            Assert.assertFalse(api.checkCompany(company));
        } catch (SQLException e){
            Assert.fail(e.getMessage());
        }

    }

    @Test
    @Ignore public void insertTest(){

        NominalAPI api = null;
        Company company = null;

        try {
            api = new NominalAPI(DatabaseDeveloper.NOMINAL.getURL(), DatabaseDeveloper.NOMINAL.getUser(), DatabaseDeveloper.NOMINAL.getPassword());
        } catch (SQLException throwables) {
            Assert.fail(throwables.getMessage());
        }

        try {
            company = new Company(
                    api.getAgreementById(1)
                    ,"Palma City"
                    ,"B63553"
                    ,"32442/242332/34543"
                    ,"Calle Melia 2"
                    ,"Spain"
                    ,"984235464"
                    ,api.getCurrencyById(48)
                    ,api.getQuotationById(4)
            );
        } catch (SQLException e){
            Assert.fail(e.getMessage());
        }

        try {
            api.setCompany(company);
        } catch (SQLException e){
            Assert.fail(e.getMessage());
        }

    }

}
