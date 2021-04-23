/*

 Nominal Application
 Quotation

 @author     Carlos Pomares
 Date        2021-04-23

*/

package common.agreement;

public class Quotation {

    // IDENTIFIER
    int id;

    // GENERAL INFO
    String name;
    int level;

    public Quotation(int id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

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
