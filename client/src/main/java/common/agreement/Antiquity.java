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
    Category category;
    Quotation quotation;
    int years;

    // VALUE
    float value;

    public Antiquity(int id, Category category, Quotation quotation, int years, float value) {
        this.id = id;
        this.category = category;
        this.quotation = quotation;
        this.years = years;
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

    public int getYears() {
        return years;
    }

    public float getValue() {
        return value;
    }
}