package org.java.dev.db.service;

import org.java.dev.db.utils.Database;
import org.java.dev.db.utils.SQLExtractor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        Connection connection = database.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(SQLExtractor.read("populate_db.sql"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}