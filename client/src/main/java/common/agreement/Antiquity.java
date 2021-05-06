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

    // RELATIONS
    int category;
    int quotation;
    int years;

    // VALUE
    float value;

    public Antiquity(int id, int category, int quotation, int years, float value) {
        this.id = id;
        this.category = category;
        this.quotation = quotation;
        this.years = years;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getCategory() {
        return category;
    }

    public int getQuotation() {
        return quotation;
    }

    public int getYears() {
        return years;
    }

    public float getValue() {
        return value;
    }
}