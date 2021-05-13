package persistence;

import common.company.Company;
import common.employee.Employee;
import configuration.DatabaseDeveloper;
import org.junit.Assert;
import org.junit.Test;
import persistence.service.NominalAPI;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmployeeAPITest {

    @Test
    public void checkerTest() {

        NominalAPI api = null;
        Employee employee = null;

        try {
            api = new NominalAPI(DatabaseDeveloper.NOMINAL.getURL(), DatabaseDeveloper.NOMINAL.getUser(), DatabaseDeveloper.NOMINAL.getPassword());
        } catch (SQLException throwables) {
            Assert.fail(throwables.getMessage());
        }

        try {
            employee = api.getEmployeeById(1);
        } catch (Exception e){
            Assert.fail(e.getMessage());
        }

        Assert.assertEquals(1,employee.getId());

        try {
            Assert.assertFalse(api.checkEmployee(employee));
        } catch (SQLException e){
            Assert.fail(e.getMessage());
        }

    }

    @Test
    public void insertTest(){

        NominalAPI api = null;
        Employee employee = null;

        try {
            api = new NominalAPI(DatabaseDeveloper.NOMINAL.getURL(), DatabaseDeveloper.NOMINAL.getUser(), DatabaseDeveloper.NOMINAL.getPassword());
        } catch (SQLException throwables) {
            Assert.fail(throwables.getMessage());
        }

        try {
            employee = new Employee(
                    "43662356R"
                    ,"324352"
                    ,"Pepe"
                    ,""
                    ,"Lastname"
                    ,"Lastname2"
                    ,"pepe@test.es"
                    ,"745678934"
                    ,"Calle Bichuela, 5"
                    ,api.getCategoryById(1)
                    ,Date.valueOf(LocalDate.now())
                    ,null
                    ,true
                    ,false
                    ,false
                    ,40f
                    ,12.5f
            );
        } catch (SQLException e){
            Assert.fail(e.getMessage());
        }

        try {
            api.setEmployee(api.getCompanyByIdMinimal(1),employee);
        } catch (SQLException e){
            Assert.fail(e.getMessage());
        }

    }

}
