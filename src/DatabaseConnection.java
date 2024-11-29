import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Method to establish and return a database connection
    public static Connection getConnection() {
        String jdbcURL = "jdbc:mysql://localhost:3306/toll"; // Replace with your database URL
        String dbUser = "root";    // Replace with your database username
        String dbPassword = "root"; // Replace with your database password

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        } catch (SQLException e) {
            System.err.println("Error connecting to the database");
            e.printStackTrace();
        }
        return connection;
    }
}

