/*

 Nominal Application
 Nominal API Statements

 @author     Carlos Pomares
 Date        2021-04-24

*/

package persistence.service;

public enum Statements {

    SELECT_ALL_EMPLOYEES("SELECT * FROM Employee"),
    SELECT_ALL_COMPANIES("SELECT * FROM Company"),
    SELECT_ALL_AGREEMENTS("SELECT * FROM Employee"),
    SELECT_ALL_PAYROLLS("SELECT * FROM Payroll");

    private final String query;

    Statements(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
