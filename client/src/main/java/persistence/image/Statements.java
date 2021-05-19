package persistence.image;

public enum Statements {

    SELECT_IMAGE_BY_ID("SELECT i.created_at as creation, i.id as id, i.image as image FROM grup2.image i WHERE i.id = ?"),
    SELECT_IMAGE_BY_USER("SELECT ui.image as id FROM grup2.user_image ui WHERE ui.`user` = ? ORDER BY ui.created_at DESC LIMIT 1"),
    SELECT_IMAGE_BY_EMPLOYEE("SELECT ei.image as id FROM grup2.employee_image ei WHERE ei.employee = ? ORDER BY ei.created_at DESC LIMIT 1"),
    SELECT_IMAGE_BY_COMPANY("SELECT ci.image as id FROM grup2.company_image ci WHERE ci.company = ? ORDER BY ci.created_at DESC LIMIT 1"),

    INSERT_NEW_IMAGE("INSERT INTO grup2.image (image) VALUES (?)"),
    INSERT_NEW_USER_IMAGE("INSERT INTO grup2.user_image (`user`,image) VALUES (?,?)"),
    INSERT_NEW_EMPLOYEE_IMAGE("INSERT INTO grup2.employee_image (employee,image) VALUES (?,?)"),
    INSERT_NEW_COMPANY_IMAGE("INSERT INTO grup2.company_image (company,image) VALUES (?,?)"),

    SELECT_LAST_INSERT_ID("SELECT LAST_INSERT_ID() as id");

    private final String query;

    Statements(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

}
