import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLServiceSender {
    public static void sendBankAccountDetails(String accountNumber, String accountHolderName, double balance) {
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
            String query = "INSERT INTO bank_accounts (account_number, account_holder_name, balance) VALUES (?, ?, ?)";

            // Create prepared statement
            statement = connection.prepareStatement(query);

            // Set parameters for the bank account details
            statement.setString(1, accountNumber);
            statement.setString(2, accountHolderName);
            statement.setDouble(3, balance);

            // Execute the SQL statement
            statement.executeUpdate();

            System.out.println("Bank account details sent successfully to MySQL.");
        } catch (SQLException e) {
            System.out.println("An error occurred while sending bank account details: " + e.getMessage());
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
        String accountNumber = "1234567890";
        String accountHolderName = "John Doe";
        double balance = 5000.0;

        sendBankAccountDetails(accountNumber, accountHolderName, balance);
    }
}
