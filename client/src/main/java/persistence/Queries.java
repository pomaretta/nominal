/*

 Nominal Application
 Nominal API Queries Abstract

 @author     Carlos Pomares
 Date        2021-04-24

*/

package persistence;

import java.sql.Connection;

public abstract class Queries {

    // Connection to perform queries.
    protected Connection connection;

    /**
     *
     * Abstract class to create specific Queries to Driver.
     *
     * @param connection to make queries.
     */
    public Queries(Connection connection) {
        this.connection = connection;
    }

}
