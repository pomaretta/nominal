/*

 Nominal Application
 Salary

*/


package common.agreement;

import java.sql.Timestamp;

public class Salary {

    // IDENTIFIER
    int id;

    // RELATIONS
    int category;
    int quotation;

    // VALUE
    float value;

    /**
     *
     * @param id salary identificator
     * @param category salary category
     * @param quotation salary quotation
     * @param value salary value
     */
    public Salary(int id, int category, int quotation, float value) {
        this.id = id;
        this.category = category;
        this.quotation = quotation;
        this.value = value;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public int getCategory() {
        return category;
    }

    public int getQuotation() {
        return quotation;
    }

    public float getValue() {
        return value;
    }
}
