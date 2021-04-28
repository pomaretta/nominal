/*

 Nominal Application
 Nominal API Statements

 @author     Carlos Pomares
 Date        2021-04-24

*/

package persistence.service;

public enum Statements {

    SELECT_ALL_EMPLOYEES("SELECT * FROM employee"),
    SELECT_ALL_COMPANIES("SELECT * FROM company"),
    SELECT_ALL_AGREEMENTS("SELECT * FROM company_agreement"),
    SELECT_ALL_PAYROLLS("SELECT * FROM payroll");



    private final String query;

    Statements(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
