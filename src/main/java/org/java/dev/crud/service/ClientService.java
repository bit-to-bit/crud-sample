package org.java.dev.crud.service;

import org.java.dev.crud.entity.Client;
import org.java.dev.db.utils.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final Logger LOG = LoggerFactory.getLogger(ClientService.class);
    private static final Database database = Database.getInstance();
    private static final Connection connection = database.getConnection();

    public long create(String name) throws Exception {
        String functionName = "ClientService.create(): ";
        try {
            String generatedColumns[] = {"id"};
            PreparedStatement statement = connection.prepareStatement("INSERT INTO client(name) VALUES(?);", generatedColumns);
            statement.setString(1, name);
            int rowCount = statement.executeUpdate();
            if (rowCount == 0) {
                LOG.error(functionName + "Creating user failed, no rows affected");
                throw new Exception(functionName + "Creating user failed, no rows affected");
            } else {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    return resultSet.getLong("id");
                }
            }
            statement.close();
        } catch (Exception e) {
            LOG.error(functionName + e);
            throw new Exception(functionName + e);
        }
        return -1l;
    }

    public String getById(long id) throws Exception {
        String functionName = "ClientService.getById(): ";
        String result = "";
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT name FROM client WHERE id = ?;");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getString("name");
            }
            statement.close();
        } catch (Exception e) {
            LOG.error(functionName + e);
            throw new Exception(functionName + e);
        }
        return result;
    }

    public void setName(long id, String name) throws Exception {
        String functionName = "ClientService.setName(): ";
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ?;");
            statement.setString(1, name);
            statement.setLong(2, id);
            int rowCount = statement.executeUpdate();
            if (rowCount == 0) {
                LOG.info(functionName + "The name was not set");
            }
            statement.close();
        } catch (Exception e) {
            LOG.error(functionName + e);
            throw new Exception(functionName + e);
        }
    }

    public void deleteById(long id) throws Exception {
        String functionName = "ClientService.deleteById(): ";
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM client WHERE id = ?;");
            statement.setLong(1, id);
            int rowCount = statement.executeUpdate();
            if (rowCount == 0) {
                LOG.info(functionName + "The client was not delete");
            }
            statement.close();
        } catch (Exception e) {
            LOG.error(functionName + e);
            throw new Exception(functionName + e);
        }
    }

    public List<Client> listAll() throws Exception {
        String functionName = "ClientService.listAll(): ";
        List<Client> clientList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id, name FROM client;");
            while (resultSet.next()) {
                Client record = new Client(resultSet.getLong("id"),
                        resultSet.getString("name"));
                clientList.add(record);
            }
            statement.close();
        } catch (Exception e) {
            LOG.error(functionName + e);
            throw new Exception(functionName + e);
        }
        return clientList;
    }
}

