/*

 Nominal Application
 Privilege

*/


package common.auth;

public class Privilege {

    // Attributes.
    private int id;
    private final String name;

    /**
     *
     * @param id privilege identificator
     * @param name privilege name
     */
    public Privilege(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Privilege(String name) {
        this.name = name;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
