package org.java.dev.db.service;

import org.java.dev.db.dto.WorkerByLevel;
import org.java.dev.db.utils.Database;
import org.java.dev.db.utils.SQLExtractor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseParamQueryService {
    private static final Database database = Database.getInstance();
    private static final Connection connection = database.getConnection();

    public boolean insertNewWorker(String name, Date birthday, String level, int salary) {
        try {
        PreparedStatement statement = connection.prepareStatement(SQLExtractor.read("param_insert_new_worker.sql"));
        statement.setString(1, name);
        statement.setDate(2, birthday);
        statement.setString(3, level);
        statement.setInt(4, salary);
        int rowCount = statement.executeUpdate();
        statement.close();
        return rowCount > 0 ? true : false;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public boolean deleteWorkerByIdBetween(long beginId, long endId) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQLExtractor.read("param_delete_worker_by_id_between.sql"));
            statement.setLong(1, beginId);
            statement.setLong(2, endId);
            int rowCount = statement.executeUpdate();
            statement.close();
            return rowCount > 0 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<WorkerByLevel> findWorkerByLevel(String level) {
        List<WorkerByLevel> workerByLevel = new ArrayList();
        try {
            PreparedStatement statement = connection.prepareStatement(SQLExtractor.read("param_find_worker_by_level.sql"));
            statement.setString(1, level);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                WorkerByLevel record = new WorkerByLevel(rs.getLong("id"),
                        rs.getString("level"),
                        rs.getString("name"),
                        rs.getString("birthday"),
                        rs.getInt("salary"));
                workerByLevel.add(record);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workerByLevel;
    }
}
