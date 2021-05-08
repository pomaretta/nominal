/*

 Nominal Application
 Nominal Connections

 @author     Carlos Pomares
 Date        2021-04-24

*/

package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {

    /**
     *
     * Creates connection with url, username, password arguments and tries to establish connection.
     *
     * @param url the url of the jdbc pointing to the database.
     * @param username valid username for access to the database.
     * @param password valid password for the username.
     * @return a SQL connection.
     * @throws SQLException if the connections fails.
     */
    public static Connection createConnection(String url, String username, String password) throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

}
