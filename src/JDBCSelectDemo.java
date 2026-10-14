// JDBC Demo: Connect to MySQL and retrieve data from 'users' table
// Uses try-with-resources for automatic resource management

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelectDemo {

    // Step-2: JDBC connection constants
    // Change these values according to your MySQL setup
    private static final String JDBC_URL  = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME  = "root";          // your MySQL username
    private static final String PASSWORD  = "password";      // your MySQL password

    public static void main(String[] args) {

        // Step-3 to Step-9: try-with-resources automatically closes Connection, Statement, ResultSet
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement   = connection.createStatement();
             ResultSet resultSet   = statement.executeQuery("SELECT * FROM users")) {

            System.out.println("Connected to MySQL database successfully!");
            System.out.println("Retrieving records from 'users' table...\n");

            // Step-7: Loop through the ResultSet
            boolean hasRows = false;
            while (resultSet.next()) {
                hasRows = true;
                int    id       = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email    = resultSet.getString("email");

                System.out.println("User ID: " + id +
                                   ", Username: " + username +
                                   ", Email: " + email);
            }

            if (!hasRows) {
                System.out.println("No records found in the 'users' table.");
            }

        } catch (SQLException e) {
            // Step-8: Handle SQLException
            System.err.println("SQLException occurred!");
            System.err.println("Error Message : " + e.getMessage());
            System.err.println("SQL State     : " + e.getSQLState());
            System.err.println("Error Code    : " + e.getErrorCode());
            e.printStackTrace();
        }
        // Step-9: Resources are automatically closed by try-with-resources
    }
}
