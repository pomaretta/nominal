/*

 Nominal Application
 Nominal Driver

 @author     Carlos Pomares
 Date        2021-04-24

*/

package service;

import persistence.API;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Driver implements API {

    protected Connection connection;

    public Driver(String url, String username, String password) throws SQLException {
        this.connection = Connections.createConnection(url,username,password);
    }

    public void close() throws SQLException {
        this.connection.close();
    }

}
