/*

 Nominal Application
 Agreement

 @author     Carlos Pomares
 Date        2021-04-23

*/

package common.agreement;

import common.NominalMaster;
import java.util.ArrayList;

public class Agreement implements NominalMaster {

    // IDENTIFIER
    int id;
    String name;

    // QUOTATION GROUPS
    ArrayList<Quotation> quotations;

    // CATEGORY GROUPS
    ArrayList<Category> categories;

    // SALARIES
    ArrayList<Salary> salaries;

    // ANTIQUITY
    ArrayList<Antiquity> antiquities;

    public Agreement(int id, String name, ArrayList<Quotation> quotations, ArrayList<Category> categories, ArrayList<Salary> salaries, ArrayList<Antiquity> antiquities) {
        this.id = id;
        this.name = name;
        this.quotations = quotations;
        this.categories = categories;
        this.salaries = salaries;
        this.antiquities = antiquities;
    }

    @Override
    public int getId() {
        return id;
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
