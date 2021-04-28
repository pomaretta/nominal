package persistence;

import common.Company;
import persistence.service.NominalAPI;

import java.sql.ResultSet;
import java.sql.SQLException;

public class companyApiTest {

    static NominalAPI a;

    static {
        try {
            a = new NominalAPI();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        ResultSet emp = a.getQueries().selectAllEmployees.executeQuery();
        System.out.println("Employees:\n-----------------");
        while (emp.next()){
            ///Company comp = new Company(emp.getString("passport"));
        System.out.println("\n");
    }
}
}
