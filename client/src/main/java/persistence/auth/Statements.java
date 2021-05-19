package persistence.auth;

public enum Statements {

    SELECT_ALL_USERS("SELECT id as id FROM grup2.user"),
    SELECT_ALL_PRIVILEGES("SELECT id as id FROM grup2.privilege"),

    SELECT_USER_BY_NAME("SELECT id FROM user WHERE name = ?"),
    
    SELECT_USER_BY_ID("SELECT u.id as `user` ,u.name as name,u.password as password,up.privilege as privilege FROM `user` u INNER JOIN user_privelege up ON u.id = up.`user` WHERE u.id = ? ORDER BY up.created_at DESC LIMIT 1"),
    SELECT_PRIVILEGE_BY_ID("SELECT p.id as id, p.name as name FROM grup2.privilege p WHERE p.id = ?"),

    SELECT_COMPANIES_BY_USER("SELECT uc.company as id FROM grup2.user_companies uc WHERE uc.`user` = ?"),

    UPDATE_USER_PASSWORD("UPDATE grup2.`user` u SET u.password = ? WHERE u.id = ?"),

    SELECT_LAST_INSERT_ID("SELECT LAST_INSERT_ID() as id"),

    INSERT_NEW_USER("INSERT INTO grup2.`user` (name,password) VALUES (?,?)"),
    INSERT_NEW_PRIVILEGE("INSERT INTO grup2.privilege (name) VALUES (?)"),
    INSERT_NEW_USER_PRIVILEGE("INSERT INTO grup2.user_privelege (`user`,privilege) VALUES (?,?)"),
    INSERT_NEW_USER_COMPANY("INSERT INTO grup2.user_companies (`user`,company) VALUES (?,?)");

    private final String query;

    Statements(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
