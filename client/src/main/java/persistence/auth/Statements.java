package persistence.auth;

public enum Statements {

    SELECT_ALL_USERS("SELECT id FROM user"),
    SELECT_ALL_PRIVILEGES("SELECT id FROM privilege"),

    SELECT_USER_BY_NAME("SELECT id FROM user WHERE name = ?"),
    SELECT_PRIVILEGES_FROM_USER("SELECT * FROM user_privilege A INNER JOIN privilege B ON a.id = b.id WHERE A.user = ?"),

    SELECT_USER_BY_ID("SELECT * FROM user WHERE id = ?"),
    SELECT_PRIVILEGE_BY_ID("SELECT * FROM privilege WHERE id = ?");

    private final String query;

    Statements(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
