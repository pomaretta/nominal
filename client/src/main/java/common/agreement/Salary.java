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
    Timestamp created;

    // RELATIONS
    int categoryLevel;
    int quotationLevel;

    // VALUE
    float value;

    public Salary(int id, Timestamp created, int categoryLevel, int quotationLevel, float value) {
        this.id = id;
        this.created = created;
        this.categoryLevel = categoryLevel;
        this.quotationLevel = quotationLevel;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public int getCategoryLevel() {
        return categoryLevel;
    }

    public int getQuotationLevel() {
        return quotationLevel;
    }

    public float getValue() {
        return value;
    }
}
