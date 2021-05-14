package persistence.auth;

import application.NominalFX;
import common.auth.Privilege;
import common.auth.User;
import common.company.Company;
import service.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class AuthAPI extends Driver {

    private persistence.auth.Queries queries;
    private User logedUser;

    public AuthAPI(String url, String username, String password) throws SQLException {
        super(url, username, password);
        this.queries = new persistence.auth.Queries(this.connection);
    }

    @Override
    public Queries getQueries() {
        return queries;
    }

    public User getLogedUser() {
        return logedUser;
    }

    public void setLogedUser(User logedUser) {
        this.logedUser = logedUser;
    }

    public Privilege getPrivilege(int id) throws SQLException {
        this.queries.selectPrivilegeById.setInt(1,id);
        ResultSet result = this.queries.selectPrivilegeById.executeQuery();
        result.next();
        return new Privilege(
                result.getInt("id"),
                result.getString("name")
        );
    }

    public User getUser(int id) throws SQLException {

        this.queries.selectUserById.setInt(1,id);

        ResultSet result = null;
        User user;

        try {
            result = this.queries.selectUserById.executeQuery();
            result.next();
            user = new User(
                    result.getInt("user")
                    ,getPrivilege(result.getInt("privilege"))
                    ,result.getString("name")
                    ,result.getString("password")
            );
        } finally {
            result.close();
        }

        return user;
    }

    public User getUserByName(String name) throws SQLException, AuthenticationException {
        this.queries.selectUserByName.setString(1,name);

        ResultSet result = null;
        int id;

        try {
             result = this.queries.selectUserByName.executeQuery();
             result.next();
             id = result.getInt("id");
        } finally {
            result.close();
        }

        return getUser(id);
    }

    public ArrayList<User> getUsers() throws SQLException {

        ResultSet resultSet = null;
        ArrayList<User> users = new ArrayList<>();

        try {
            resultSet = this.queries.selectAllUsers.executeQuery();
            while(resultSet.next()){
                users.add(getUser(resultSet.getInt("id")));
            }
        } finally {
            resultSet.close();
        }

        return users;
    }

    public ArrayList<Privilege> getPrivileges() throws SQLException {

        ResultSet resultSet = null;
        ArrayList<Privilege> privileges = new ArrayList<>();

        try {
            resultSet = this.queries.selectAllPrivileges.executeQuery();
            while(resultSet.next()){
                privileges.add(getPrivilege(resultSet.getInt("id")));
            }
        } finally {
            resultSet.close();
        }

        return privileges;
    }

    public ArrayList<Company> getCompaniesByUser(User user) throws SQLException {

        this.queries.selectCompaniesByUser.setInt(1,user.getId());

        ResultSet resultSet = null;
        ArrayList<Company> companies = new ArrayList<>();

        try {
            resultSet = this.queries.selectCompaniesByUser.executeQuery();
            while(resultSet.next()){
                companies.add(NominalFX.nominalAPI.getCompanyByIdMinimal(resultSet.getInt("id")));
            }
        } finally {
            resultSet.close();
        }

        return companies;
    }

    public void updateUserPassword(User user) throws SQLException {
        this.queries.updatePassword.setString(1,user.getPassword());
        this.queries.updatePassword.setInt(2,user.getId());
        this.queries.updatePassword.execute();
    }

    public void setUser(User user) throws SQLException {

        this.queries.setUser.setString(1,user.getName());
        this.queries.setUser.setString(2,user.getPassword());
        this.queries.setUser.execute();

        ResultSet resultSet = null;
        int id;

        try {
            resultSet = this.queries.selectLastId.executeQuery();
            resultSet.next();
            id = resultSet.getInt("id");
            System.out.println(id);
        } finally {
            resultSet.close();
        }

        setUserPrivilege(id,user);

    }

    public void setUserPrivilege(int userId, User user) throws SQLException {

        this.queries.setUserPrivilege.setInt(1,userId);
        this.queries.setUserPrivilege.setInt(2,user.getPrivilege().getId());

        this.queries.setUserPrivilege.execute();
    }

    public void setUserCompany(User user, Company company) throws SQLException {

        this.queries.setUserCompany.setInt(1,user.getId());
        this.queries.setUserCompany.setInt(2,company.getId());

        this.queries.setUserCompany.execute();
    }

}
