package persistence.auth;

public enum Statements {

    SELECT_ALL_USERS("SELECT id FROM user"),
    SELECT_ALL_PRIVILEGES("SELECT id FROM privilege"),

    SELECT_USER_BY_NAME("SELECT id FROM user WHERE name = ?"),
    
    SELECT_USER_BY_ID("SELECT u.id as `user` ,u.name as name,u.password as password,up.privilege as privilege FROM `user` u INNER JOIN user_privelege up ON u.id = up.`user` WHERE u.id = ? ORDER BY up.created_at DESC LIMIT 1"),
    SELECT_PRIVILEGE_BY_ID("SELECT p.id as id, p.name as name FROM nominal_auth_dev.privilege p WHERE p.id = ?");

    private final String query;

    Statements(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
