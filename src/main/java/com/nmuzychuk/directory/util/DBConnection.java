package com.nmuzychuk.directory.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                Properties properties = new Properties();
                InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
                properties.load(inputStream);

                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String user = properties.getProperty("user");
                String password = properties.getProperty("password");

                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);

                createTable(connection);
            } catch (IOException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    private static void createTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE records (id INT PRIMARY KEY, firstName VARCHAR (64), lastName VARCHAR (64), phoneNumber VARCHAR (64))";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.execute();
    }
}
