package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database INSTANCE = new Database();
    private static final String URL_CONNECTION_DATABASE = "jdbc:h2:./company";
    private Connection connection;
    private Database(){
        try {
            connection = DriverManager.getConnection(URL_CONNECTION_DATABASE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Database getInstance(){
        return INSTANCE;
    }
    public Connection getConnection(){
        return connection;
    }
}
