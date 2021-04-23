/*

 Nominal Application
 Antiquity

 @author     Carlos Pomares
 Date        2021-04-23

*/

package common.agreement;

import java.sql.Timestamp;

public class Antiquity {

    // IDENTIFIER
    int id;
    Timestamp created;

    // RELATIONS
    int categoryLevel;
    int quotationLevel;
    int years;

    // VALUE
    float value;

    public Antiquity(int id, Timestamp created, int categoryLevel, int quotationLevel, int years, float value) {
        this.id = id;
        this.created = created;
        this.categoryLevel = categoryLevel;
        this.quotationLevel = quotationLevel;
        this.years = years;
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

    public int getYears() {
        return years;
    }

    public float getValue() {
        return value;
    }

}