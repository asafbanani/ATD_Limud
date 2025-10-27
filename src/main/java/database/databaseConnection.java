package database;

import java.io.*;
import java.sql.*;

public class databaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/lesson_db";
    private static final String USER = "root";
    private static final String PASSWORD = readPasswordFromFile("D:/Desktop/private_lessons/mysql_pass.txt");

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static String readPasswordFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read DB password from file", e);
        }
    }
}
