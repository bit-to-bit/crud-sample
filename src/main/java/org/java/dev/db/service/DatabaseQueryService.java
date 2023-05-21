package org.java.dev.db.service;
import org.java.dev.db.dto.*;
import org.java.dev.db.utils.Database;
import org.java.dev.db.utils.SQLExtractor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DatabaseQueryService {
    private static final Database database = Database.getInstance();
    private static final Connection connection = database.getConnection();
    public List<LongestProject> findLongestProject() {

        List<LongestProject> longestProject = new ArrayList();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQLExtractor.read("find_longest_project.sql"));
            while(rs.next()) {
                LongestProject record = new LongestProject(rs.getString("name"),
                                                           rs.getInt("month_count"));
                longestProject.add(record);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return longestProject;
    }
    public List<MaxProjectsClient> findMaxProjectsClient() {
        List<MaxProjectsClient> maxProjectsClients = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQLExtractor.read("find_max_projects_client.sql"));
            while(rs.next()) {
                MaxProjectsClient record = new MaxProjectsClient(rs.getString("name"),
                                                                 rs.getInt("project_count"));
                maxProjectsClients.add(record);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxProjectsClients;
    }
    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> maxSalaryWorker = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQLExtractor.read("find_max_salary_worker.sql"));
            while(rs.next()) {
                MaxSalaryWorker record = new MaxSalaryWorker(rs.getString("name"),
                                                             rs.getInt("salary"));
                maxSalaryWorker.add(record);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxSalaryWorker;
    }
    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> youngestEldestWorkers = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQLExtractor.read("find_youngest_eldest_workers.sql"));
            while(rs.next()) {
                YoungestEldestWorkers record = new YoungestEldestWorkers(rs.getString("type"),
                                                                         rs.getString("name"),
                                                                         rs.getString("birthday"));
                youngestEldestWorkers.add(record);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return youngestEldestWorkers;
    }
    public List<ProjectPrices> findProjectPrices() {
        List<ProjectPrices> projectPrices = new ArrayList();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQLExtractor.read("print_project_prices.sql"));
            while(rs.next()) {
                ProjectPrices record = new ProjectPrices(rs.getString("NAME"),
                                                         rs.getInt("PRICE"));
                projectPrices.add(record);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectPrices;
    }
}
