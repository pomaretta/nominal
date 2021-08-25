package cache;

import common.employee.Employee;
import configuration.DatabaseDeveloper;
import optimization.Cache;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import persistence.service.NominalAPI;

public class CacheTest {

    @Test
    @Ignore public void employeeTest(){

        NominalAPI nominalAPI;
        Employee emp = null;

        try {
            nominalAPI = new NominalAPI(DatabaseDeveloper.NOMINAL.getURL(), DatabaseDeveloper.NOMINAL.getUser(), DatabaseDeveloper.NOMINAL.getPassword());
            emp = nominalAPI.getEmployeeById(1);
        } catch (Exception e){
            Assert.fail();
        }

        Cache cache = new Cache();

        cache.add(emp,cache.getEmployees());

        Assert.assertEquals(1,cache.getEmployeeById(1).getId());

    }

}
