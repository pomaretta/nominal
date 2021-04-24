/*

 Nominal Application
 Nominal AUTH API Queries

 @author     Carlos Pomares
 Date        2021-04-24

*/

package persistence.auth;

import java.sql.Connection;
import java.sql.SQLException;

public class Queries extends persistence.Queries {

    public Queries(Connection connection) throws SQLException {
        super(connection);
    }

}
