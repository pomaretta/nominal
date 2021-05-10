package persistence.image;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Queries extends persistence.Queries {

    public PreparedStatement selectImageById;

    public PreparedStatement selectImageByUserId;
    public PreparedStatement selectImageByEmployeeId;
    public PreparedStatement selectImageByCompanyId;

    public PreparedStatement selectLastId;

    public PreparedStatement insertNewImage;
    public PreparedStatement insertUserImage;
    public PreparedStatement insertEmployeeImage;
    public PreparedStatement insertCompanyImage;

    public Queries(Connection connection) throws SQLException {
        super(connection);
        selectImageById = this.connection.prepareStatement(Statements.SELECT_IMAGE_BY_ID.getQuery());

        selectImageByUserId = this.connection.prepareStatement(Statements.SELECT_IMAGE_BY_USER.getQuery());
        selectImageByEmployeeId = this.connection.prepareStatement(Statements.SELECT_IMAGE_BY_EMPLOYEE.getQuery());
        selectImageByCompanyId = this.connection.prepareStatement(Statements.SELECT_IMAGE_BY_COMPANY.getQuery());

        selectLastId = this.connection.prepareStatement(Statements.SELECT_LAST_INSERT_ID.getQuery());

        insertNewImage = this.connection.prepareStatement(Statements.INSERT_NEW_IMAGE.getQuery());
        insertUserImage = this.connection.prepareStatement(Statements.INSERT_NEW_USER_IMAGE.getQuery());
        insertEmployeeImage = this.connection.prepareStatement(Statements.INSERT_NEW_EMPLOYEE_IMAGE.getQuery());
        insertCompanyImage = this.connection.prepareStatement(Statements.INSERT_NEW_COMPANY_IMAGE.getQuery());

    }

}
