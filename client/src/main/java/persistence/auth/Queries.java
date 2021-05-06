/*

 Nominal Application
 Nominal AUTH API Queries

 @author     Carlos Pomares
 Date        2021-04-24

*/

package persistence.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Queries extends persistence.Queries {

    public PreparedStatement selectAllUsers;
    public PreparedStatement selectAllPrivileges;

    public PreparedStatement selectUserByName;
    public PreparedStatement selectPrivilegesFromUser;

    public PreparedStatement selectUserById;
    public PreparedStatement selectPrivilegeById;

    public Queries(Connection connection) throws SQLException {
        super(connection);
        this.selectAllUsers = this.connection.prepareStatement(Statements.SELECT_ALL_USERS.getQuery());
        this.selectAllPrivileges = this.connection.prepareStatement(Statements.SELECT_ALL_PRIVILEGES.getQuery());
        this.selectUserByName = this.connection.prepareStatement(Statements.SELECT_USER_BY_NAME.getQuery());
        this.selectUserById = this.connection.prepareStatement(Statements.SELECT_USER_BY_ID.getQuery());
        this.selectPrivilegeById = this.connection.prepareStatement(Statements.SELECT_PRIVILEGE_BY_ID.getQuery());
    }

}
