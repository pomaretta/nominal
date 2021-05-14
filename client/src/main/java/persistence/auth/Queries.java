package persistence.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Queries extends persistence.Queries {

    public PreparedStatement selectAllUsers;
    public PreparedStatement selectAllPrivileges;

    public PreparedStatement selectUserByName;

    public PreparedStatement selectUserById;
    public PreparedStatement selectPrivilegeById;

    public PreparedStatement selectCompaniesByUser;

    public PreparedStatement updatePassword;
    public PreparedStatement setUser;
    public PreparedStatement setUserPrivilege;
    public PreparedStatement setUserCompany;
    public PreparedStatement setPrivilege;

    public PreparedStatement selectLastId;

    public Queries(Connection connection) throws SQLException {
        super(connection);
        this.selectAllUsers = this.connection.prepareStatement(Statements.SELECT_ALL_USERS.getQuery());
        this.selectAllPrivileges = this.connection.prepareStatement(Statements.SELECT_ALL_PRIVILEGES.getQuery());
        this.selectUserByName = this.connection.prepareStatement(Statements.SELECT_USER_BY_NAME.getQuery());
        this.selectUserById = this.connection.prepareStatement(Statements.SELECT_USER_BY_ID.getQuery());
        this.selectPrivilegeById = this.connection.prepareStatement(Statements.SELECT_PRIVILEGE_BY_ID.getQuery());

        this.updatePassword = this.connection.prepareStatement(Statements.UPDATE_USER_PASSWORD.getQuery());
        this.setUser = this.connection.prepareStatement(Statements.INSERT_NEW_USER.getQuery());
        this.setUserPrivilege = this.connection.prepareStatement(Statements.INSERT_NEW_USER_PRIVILEGE.getQuery());
        this.setUserCompany = this.connection.prepareStatement(Statements.INSERT_NEW_USER_COMPANY.getQuery());
        this.setPrivilege = this.connection.prepareStatement(Statements.INSERT_NEW_PRIVILEGE.getQuery());

        this.selectCompaniesByUser = this.connection.prepareStatement(Statements.SELECT_COMPANIES_BY_USER.getQuery());

        this.selectLastId = this.connection.prepareStatement(Statements.SELECT_LAST_INSERT_ID.getQuery());

    }

}
