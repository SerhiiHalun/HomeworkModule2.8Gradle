package org.example.return_entity_query;

import org.example.Database;
import org.example.FileSupportSQL;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        try {
            Statement statement = database.getConnection().createStatement();
            statement.executeUpdate(FileSupportSQL.fileReader("sql_resources/populate_db.sql"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
