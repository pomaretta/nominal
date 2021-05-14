/*

 Nominal Application
 Agreement

*/

package common.agreement;

import common.NominalMaster;
import common.NominalObject;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Agreement extends NominalObject {

    // IDENTIFIER
    protected int id;
    protected Timestamp lastUpdated;
    protected String name;

    // QUOTATION GROUPS
    protected ArrayList<Quotation> quotations;

    // CATEGORY GROUPS
    protected ArrayList<Category> categories;

    // SALARIES
    protected ArrayList<Salary> salaries;

    // ANTIQUITY
    protected ArrayList<Antiquity> antiquities;

    public Agreement() {
    }

    /**
     *
     * @param id agreemt identificator
     * @param lastUpdated date of last update
     * @param name agreement name
     * @param quotations agreement quotation
     * @param categories agreement categories
     * @param salaries agreement salaries
     * @param antiquities agreement antiquities
     */
    public Agreement(int id, Timestamp lastUpdated, String name, ArrayList<Quotation> quotations, ArrayList<Category> categories, ArrayList<Salary> salaries, ArrayList<Antiquity> antiquities) {
        this.id = id;
        this.lastUpdated = lastUpdated;
        this.name = name;
        this.quotations = quotations;
        this.categories = categories;
        this.salaries = salaries;
        this.antiquities = antiquities;
    }

    // GETTERS
    @Override
    public int getId() {
        return id;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Quotation> getQuotations() {
        return quotations;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public ArrayList<Salary> getSalaries() {
        return salaries;
    }

    public ArrayList<Antiquity> getAntiquities() {
        return antiquities;
    }
}
