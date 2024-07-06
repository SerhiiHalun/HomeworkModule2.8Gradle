package org.example.service;


import org.example.Database;
import org.example.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public static List<LongestProject> findLongestProject() {
        List<LongestProject> longestProjects = new ArrayList<>();
        try {
            Database database = Database.getInstance();
            Connection connection = database.getConnection();
            String sql = FileSupportSQL.fileReader("sql_resources/find_longest_project.sql");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                longestProjects.add(new LongestProject(resultSet.getString("CLIENT_NAME"), resultSet.getInt("MONTH_COUNT")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return longestProjects;
    }

    public static List<MaxProjectClients> findMaxProjectsClient() {
        List<MaxProjectClients> maxProjectClients = new ArrayList<>();
        try {
            Database database = Database.getInstance();
            Connection connection = database.getConnection();
            String sql = FileSupportSQL.fileReader("sql_resources/find_max_projects_client.sql");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                maxProjectClients.add(new MaxProjectClients(resultSet.getString("NAME"), resultSet.getInt("PROJECT_COUNT")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxProjectClients;
    }

    public static List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> listMaxSalaryWorker = new ArrayList<>();
        try {
            Database database = Database.getInstance();
            Connection connection = database.getConnection();
            String sql = FileSupportSQL.fileReader("sql_resources/find_max_salary_worker.sql");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listMaxSalaryWorker.add(new MaxSalaryWorker(resultSet.getString("NAME")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listMaxSalaryWorker;
    }

    public static List<YoungestEldestWorker> findYoungestEldestWorker() {
        List<YoungestEldestWorker> listYoungestEldestWorker = new ArrayList<>();
        try {
            Database database = Database.getInstance();
            Connection connection = database.getConnection();
            String sql = FileSupportSQL.fileReader("sql_resources/find_youngest_eldest_workers.sql");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listYoungestEldestWorker.add(new YoungestEldestWorker(resultSet.getString("TYPE"), resultSet.getString("NAME"), resultSet.getDate("BIRTHDAY")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listYoungestEldestWorker;
    }

    public static List<ProjectPrices> findProjectPrices() {
        List<ProjectPrices> listProjectPrices = new ArrayList<>();
        try {
            Database database = Database.getInstance();
            Connection connection = database.getConnection();
            String sql = FileSupportSQL.fileReader("sql_resources/print_project_prices.sql");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listProjectPrices.add(new ProjectPrices(resultSet.getString("PROJECT_NAME"), resultSet.getInt("PROJECT_COST")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listProjectPrices;
    }
}
