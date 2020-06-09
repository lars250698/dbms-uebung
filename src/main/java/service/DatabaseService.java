package service;

import java.sql.*;

public class DatabaseService {

    private static DatabaseService instance;

    private Connection connection = null;

    public Connection getConnection() {
        return connection;
    }

    private DatabaseService() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://172.17.0.2:5432/Ausleihe?user=postgres&password=12345", "postgres", "12345");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseService getInstance() {
        if (instance == null) {
            instance = new DatabaseService();
        }
        return instance;
    }
}
