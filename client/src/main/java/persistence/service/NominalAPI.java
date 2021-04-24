/*

 Nominal Application
 Nominal API

 @author     Carlos Pomares
 Date        2021-04-23

 Last revision
 Date        2021-04-24

*/

package persistence.service;

import service.Driver;

import java.sql.SQLException;

public class NominalAPI extends Driver {

    public persistence.service.Queries queries;

    public NominalAPI(String url, String username, String password) throws SQLException {
        super(url, username, password);
        this.queries = new persistence.service.Queries(this.connection);
    }

    @Override
    public Queries getQueries() {
        return queries;
    }

}
