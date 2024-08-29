package main.java.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MysqlConfig {
    private String url;
    private String user;
    private String password;

    public Connection loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
            }

            // Load a properties file from class path
            properties.load(input);

            // Get the property values
            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");

            Connection connection = this.connect(url,user,password);
            return connection;


        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Connection connect(String url, String user, String password) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);

            return connection;
            /*
            String sql = "SELECT * FROM accounts";
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            System.out.println(rs);

            System.out.println("Connection to the database established successfully.");
            */

        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
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
