package main.java.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MysqlConfig {
    private String url;
    private String user;
    private String password;

    private void loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                return;
            }

            // Load a properties file from class path
            properties.load(input);

            // Get the property values
            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");
            System.out.println("Success");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to the database established successfully.");
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
        System.out.println("Connected Succsssfully");
        return connection;
    }

    public void queryDatabase(Connection connection, String tableName) {
        String query = "SELECT * FROM " + tableName; // Change this to your table
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                // Assuming your table has a column named "column_name"
                String data = resultSet.getString("column_name");
                System.out.println(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
