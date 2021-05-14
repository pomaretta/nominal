/*

 Nominal Application
 Antiquity

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

    /**
     *
     * @param id antiquity identificator
     * @param category antiquity categorie
     * @param quotation antiquity quatation
     * @param years years of antiquity
     * @param value antiquity value
     */
    public Antiquity(int id, int category, int quotation, int years, float value) {
        this.id = id;
        this.category = category;
        this.quotation = quotation;
        this.years = years;
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

    public int getYears() {
        return years;
    }

    public float getValue() {
        return value;
    }
}