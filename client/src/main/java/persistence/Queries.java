/*

 Nominal Application
 Nominal API Queries Abstract

 @author     Carlos Pomares
 Date        2021-04-24

*/

package persistence;

import java.sql.Connection;

public abstract class Queries {

    protected Connection connection;

    public Queries(Connection connection) {
        this.connection = connection;
    }

}
