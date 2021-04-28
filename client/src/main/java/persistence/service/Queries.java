/*

 Nominal Application
 Nominal API Queries

 @author     Carlos Pomares
 Date        2021-04-24

*/

package persistence.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Queries extends persistence.Queries {

    public PreparedStatement selectAllEmployees;
    public PreparedStatement selectAllCompanies;
    public PreparedStatement selectAllAgreements;
    public PreparedStatement selectAllPayrolls;

    public Queries(Connection connection) throws SQLException {
        super(connection);
        selectAllEmployees = this.connection.prepareStatement(Statements.SELECT_ALL_EMPLOYEES.getQuery());
        selectAllCompanies = this.connection.prepareStatement(Statements.SELECT_ALL_COMPANIES.getQuery());
        selectAllAgreements = this.connection.prepareStatement(Statements.SELECT_ALL_AGREEMENTS.getQuery());
        selectAllPayrolls = this.connection.prepareStatement(Statements.SELECT_ALL_PAYROLLS.getQuery());

    }

}
