package org.example;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database INSTANCE = new Database();
    private static final String URL_CONNECTION_DATABASE = "jdbc:h2:./company";
    private Connection connection;


    public Database() {
        try {
            connection = DriverManager.getConnection(URL_CONNECTION_DATABASE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Flyway flyway = Flyway.configure()
                .dataSource(URL_CONNECTION_DATABASE,null,null)
                .locations("db/migration").load();
        flyway.migrate();
    }

    public static Database getInstance(){
        return INSTANCE;
    }
    public Connection getConnection(){
        return connection;
    }
}
