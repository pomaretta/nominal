/*

 Nominal Application
 Quotation

*/

package common.agreement;

public class Quotation {

    // IDENTIFIER
    int id;

    // GENERAL INFO
    String name;
    int level;

    /**
     *
     * @param id quatation identificator
     * @param name quotation name
     * @param level quotation level
     */
    public Quotation(int id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

}
