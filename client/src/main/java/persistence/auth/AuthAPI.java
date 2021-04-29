/*

 Nominal Application
 Auth API

 @author     Carlos Pomares
 Date        2021-04-23

*/

package persistence.auth;

import service.Driver;

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

}
