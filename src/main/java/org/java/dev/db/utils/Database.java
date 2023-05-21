package org.java.dev.db.utils;

import org.java.dev.properties.Constant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    private Database () {
        String url = Constant.CONNECTION_URL.getValue();
        String user = Constant.CONNECTION_USERNAME.getValue();
        String password = Constant.CONNECTION_PASSWORD.getValue();
        try {
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Database getInstance(){
        return INSTANCE;
    }
    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
