package persistence;

import persistence.service.NominalAPI;

import java.sql.ResultSet;
import java.sql.SQLException;

public class nominalApiTest {
    static NominalAPI a;

    static {
        try {
            a = new NominalAPI("jdbc:mysql://carlospomares.es:35462/nominal", "nominal", "1f7b4f1dbe8fa53089854e0ffa829523");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {

        ResultSet emp = a.getQueries().selectAllEmployees.executeQuery();
        System.out.println("Employees:\n-----------------");
        while (emp.next()){
            System.out.println(emp.getTimestamp("created_at") + " - " + emp.getInt("id") + " - " + emp.getString("passport"));
        }
        System.out.println("\n");

        ResultSet comp = a.getQueries().selectAllCompanies.executeQuery();
        System.out.println("Companies:\n-----------------");
        while (comp.next()){
            System.out.println(comp.getTimestamp("created_at") + " - " + comp.getInt("id") + " - " + comp.getString("name"));
        }

    }


    public nominalApiTest() throws SQLException {
    }
}
