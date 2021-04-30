/*

 Nominal Application
 Auth API

 @author     Carlos Pomares
 Date        2021-04-23

*/

package persistence.auth;

import common.auth.Privilege;
import common.auth.User;
import service.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthAPI extends Driver {

    private persistence.auth.Queries queries;

    public AuthAPI(String url, String username, String password) throws SQLException {
        super(url, username, password);
        this.queries = new persistence.auth.Queries(this.connection);
    }

    @Override
    public Queries getQueries() {
        return queries;
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
                result.getInt("id"),
                result.getString("name"),
                result.getString("password")
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

}
