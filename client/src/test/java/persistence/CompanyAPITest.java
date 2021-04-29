package persistence;

import configuration.DatabaseDeveloper;
import persistence.service.NominalAPI;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyAPITest {

    static NominalAPI a;

    static {
        try {
            a = new NominalAPI(DatabaseDeveloper.NOMINAL.getURL(),DatabaseDeveloper.NOMINAL.getUser(), DatabaseDeveloper.NOMINAL.getPassword());
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
