package common.auth;

public class Privilege {

    private int id;
    private final String name;

    public Privilege(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Privilege(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
