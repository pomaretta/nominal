package common;

import java.sql.Date;

import common.agreement.Category;
import common.employee.Employee;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void dateTest(){

        Employee employee = new Employee(
                "test"
                ,"test"
                ,"test"
                ,"test"
                ,"test"
                ,"test"
                ,"test"
                ,"test"
                ,"test"
                ,new Category(2,"test",1)
                ,Date.valueOf("2016-05-02")
                ,null
                ,true
                ,false
                ,false
                ,25f
                ,16f
        );

        Assert.assertEquals(3,employee.calculateYears());

    }

}
