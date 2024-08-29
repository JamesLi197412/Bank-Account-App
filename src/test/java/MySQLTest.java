package test.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import org.junit.Test;


public class MySQLTest {
    // Database URL, should be in the format "jdbc:mysql://hostname:port/databasename"
    private static final String URL = "jdbc:mysql://localhost:3306/bank/";
    // Database credentials
    private static final String USER = "root";
    private static final String PASSWORD = "lizhiyue1997412";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL JDBC driver (optional, newer versions of JDBC will automatically load it)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database successfully!");

            // Create a statement
            statement = connection.createStatement();

            // Execute a SELECT query
            String query = "SELECT * FROM accounts";
            resultSet = statement.executeQuery(query);

            // Process the result set
            while (resultSet.next()) {
                // Assuming your table has a column named "id" and "name"
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // Print out the values
                System.out.println("ID: " + id + ", Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Print any SQL exception that occurs
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } finally {
            // Clean up resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Handle any exception during cleanup
            }
        }
    }
}
