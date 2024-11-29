import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class TollRecordViewer {
    public static void viewRecords() {
        String query = "SELECT reg_no, vehicle_type, DATE(created_at) AS record_date FROM vehicles";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("\n--- Toll Records Summary ---");

            Map<String, Map<String, Integer>> dailySummary = new HashMap<>();
            Map<String, Integer> monthlySummary = new HashMap<>();
            Map<String, Double> amountCollected = new HashMap<>();
            double totalAmountCollected = 0.0;

            while (resultSet.next()) {
                String vehicleType = resultSet.getString("vehicle_type").toLowerCase();
                String recordDate = resultSet.getString("record_date");
                String recordMonth = recordDate.substring(0, 7); // Extract YYYY-MM

                dailySummary.putIfAbsent(recordDate, new HashMap<>());
                Map<String, Integer> dayData = dailySummary.get(recordDate);
                dayData.put(vehicleType, dayData.getOrDefault(vehicleType, 0) + 1);

                monthlySummary.put(recordMonth, monthlySummary.getOrDefault(recordMonth, 0) + 1);

                double fee = FeeViewer.getFee(vehicleType);
                amountCollected.put(vehicleType, amountCollected.getOrDefault(vehicleType, 0.0) + fee);
                totalAmountCollected += fee;
            }

            // Display the records by day
            dailySummary.forEach((date, typeData) -> {
                System.out.println("\nDate: " + date);
                System.out.printf("%-15s %-10s\n", "Vehicle Type", "Count");
                System.out.println("----------------------------");
                typeData.forEach((type, count) -> System.out.printf("%-15s %-10d\n", type, count));
            });

            // Display monthly totals
            System.out.println("\n--- Monthly Summary ---");
            monthlySummary.forEach((month, count) -> {
                System.out.printf("Month: %-10s Total Vehicles: %-10d\n", month, count);
            });

            // Display total amount collected per vehicle type
            System.out.println("\n--- Total Amount Collected by Vehicle Type ---");
            amountCollected.forEach((type, total) -> {
                System.out.printf("Vehicle Type: %-10s Total Collected: %.2f\n", type, total);
            });

            // Display the grand total amount collected
            System.out.println("\n--- Grand Total Amount Collected ---");
            System.out.printf("Total Amount: %.2f\n", totalAmountCollected);

        } catch (Exception e) {
            System.err.println("Error retrieving records: " + e.getMessage());
        }
    }
}
