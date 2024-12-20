import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TollPlazaInfo {
    public static void displayInfo() {
        String query = "SELECT name, location, stretch, tollable_length, fee_effective_date, due_date_of_toll_revision FROM toll_plaza_info LIMIT 1";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            if (resultSet.next()) {
                System.out.println("\n--- Toll Plaza Information ---");
                System.out.println("Toll Plaza Name: " + resultSet.getString("name"));
                System.out.println("Location: " + resultSet.getString("location"));
                System.out.println("Stretch: " + resultSet.getString("stretch"));
                System.out.println("Tollable Length: " + resultSet.getFloat("tollable_length") + " Km(s)");
                System.out.println("Fee Effective Date: " + resultSet.getDate("fee_effective_date"));
                System.out.println("Due Date of Toll Revision: " + resultSet.getDate("due_date_of_toll_revision"));
                System.out.println("---------------------------------------");
            } else {
                System.out.println("No toll plaza information found.");
            }

        } catch (Exception e) {
            System.err.println("Error retrieving toll plaza information: " + e.getMessage());
        }
    }
}
