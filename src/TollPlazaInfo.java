import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TollPlazaInfo {
    public static void displayInfoMenu() {
        List<String> tollPlazas = new ArrayList<>();
        String fetchQuery = "SELECT DISTINCT name FROM toll_plaza_info";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(fetchQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            System.out.println("\n--- Select Toll Plaza ---");
            int index = 1;

            while (resultSet.next()) {
                String tollPlazaName = resultSet.getString("name");
                tollPlazas.add(tollPlazaName);
                System.out.println(index++ + ". " + tollPlazaName);
            }

            if (tollPlazas.isEmpty()) {
                System.out.println("No toll plazas found in the database.");
                return;
            }

            // Get user's choice
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice < 1 || choice > tollPlazas.size()) {
                System.out.println("Invalid choice. Please try again.");
                return;
            }

            // Display selected toll plaza information
            displayTollPlazaInfo(tollPlazas.get(choice - 1));

        } catch (Exception e) {
            System.err.println("Error retrieving toll plazas: " + e.getMessage());
        }
    }

    public static void displayTollPlazaInfo(String tollPlazaName) {
        String query = "SELECT name, location, stretch, tollable_length, fee_effective_date, due_date_of_toll_revision " +
                       "FROM toll_plaza_info WHERE name = ? LIMIT 1";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, tollPlazaName);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
                    System.out.println("No information found for the selected toll plaza.");
                }
            }

        } catch (Exception e) {
            System.err.println("Error retrieving toll plaza information: " + e.getMessage());
        }
    }
}
