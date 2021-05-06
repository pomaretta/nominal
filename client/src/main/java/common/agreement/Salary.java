/*

 Nominal Application
 Salary

 @author     Carlos Pomares
 Date        2021-04-23

*/

package common.agreement;

import java.sql.Timestamp;

public class Salary {

    // IDENTIFIER
    int id;

    // RELATIONS
    Category category;
    Quotation quotation;

    // VALUE
    float value;

    public Salary(int id, Category category, Quotation quotation, float value) {
        this.id = id;
        this.category = category;
        this.quotation = quotation;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public float getValue() {
        return value;
    }

}
