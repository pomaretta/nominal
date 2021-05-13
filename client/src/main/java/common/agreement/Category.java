package common.agreement;

public class Category {

    // IDENTIFIER
    int id;

    // GENERAL INFO
    String name;
    int level;

    public Category(int id, String name, int level) {
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
