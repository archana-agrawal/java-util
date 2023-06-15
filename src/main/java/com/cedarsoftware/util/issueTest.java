import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLServiceSender {
    public static void sendAccountName(String accountName) {
        // MySQL database connection details
        String url = "jdbc:mysql://localhost:3306/your_database_name"; // Replace with your MySQL database URL
        String username = "your_username"; // Replace with your MySQL username
        String password = "your_password"; // Replace with your MySQL password

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Create database connection
            connection = DriverManager.getConnection(url, username, password);

            // Create SQL query
            String query = "INSERT INTO account_names (name) VALUES (?)";

            // Create prepared statement
            statement = connection.prepareStatement(query);

            // Set the account name parameter
            statement.setString(1, accountName);

            // Execute the SQL statement
            statement.executeUpdate();

            System.out.println("Account name sent successfully to MySQL.");
        } catch (SQLException e) {
            System.out.println("An error occurred while sending account name: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing database resources: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String accountName = "Example Account";
        sendAccountName(accountName);
    }
}
