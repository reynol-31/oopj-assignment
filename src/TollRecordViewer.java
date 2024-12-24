import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class TollRecordViewer {
    public static void viewRecords() {
        String query = "SELECT reg_no, vehicle_type, DATE(created_at) AS record_date, toll_plaza FROM vehicles";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("\n--- Toll Records Summary ---");

            Map<String, Map<String, Map<String, Integer>>> tollDailySummary = new HashMap<>();
            Map<String, Map<String, Integer>> tollMonthlySummary = new HashMap<>();
            Map<String, Map<String, Double>> tollAmountCollected = new HashMap<>();
            Map<String, Double> tollTotalCollected = new HashMap<>();

            while (resultSet.next()) {
                String tollPlaza = resultSet.getString("toll_plaza");
                String vehicleType = resultSet.getString("vehicle_type").toLowerCase();
                String recordDate = resultSet.getString("record_date");
                String recordMonth = recordDate.substring(0, 7); // Extract YYYY-MM

                tollDailySummary.putIfAbsent(tollPlaza, new HashMap<>());
                tollMonthlySummary.putIfAbsent(tollPlaza, new HashMap<>());
                tollAmountCollected.putIfAbsent(tollPlaza, new HashMap<>());
                tollTotalCollected.putIfAbsent(tollPlaza, 0.0);

                // Update daily summary
                Map<String, Map<String, Integer>> dailySummary = tollDailySummary.get(tollPlaza);
                dailySummary.putIfAbsent(recordDate, new HashMap<>());
                Map<String, Integer> dayData = dailySummary.get(recordDate);
                dayData.put(vehicleType, dayData.getOrDefault(vehicleType, 0) + 1);

                // Update monthly summary
                Map<String, Integer> monthlySummary = tollMonthlySummary.get(tollPlaza);
                monthlySummary.put(recordMonth, monthlySummary.getOrDefault(recordMonth, 0) + 1);

                // Update amount collected
                double fee = FeeViewer.getFee(vehicleType);
                Map<String, Double> amountCollected = tollAmountCollected.get(tollPlaza);
                amountCollected.put(vehicleType, amountCollected.getOrDefault(vehicleType, 0.0) + fee);

                // Update total collected
                tollTotalCollected.put(tollPlaza, tollTotalCollected.get(tollPlaza) + fee);
            }

            // Display records sorted by toll plaza
            tollDailySummary.forEach((tollPlaza, dailySummary) -> {
                System.out.println("\n--- Toll Plaza: " + tollPlaza + " ---");

                // Display daily summary
                dailySummary.forEach((date, typeData) -> {
                    System.out.println("\nDate: " + date);
                    System.out.printf("%-15s %-10s\n", "Vehicle Type", "Count");
                    System.out.println("----------------------------");
                    typeData.forEach((type, count) -> System.out.printf("%-15s %-10d\n", type, count));
                });

                // Display monthly summary
                System.out.println("\n--- Monthly Summary for " + tollPlaza + " ---");
                Map<String, Integer> monthlySummary = tollMonthlySummary.get(tollPlaza);
                monthlySummary.forEach((month, count) -> {
                    System.out.printf("Month: %-10s Total Vehicles: %-10d\n", month, count);
                });

                // Display total amount collected per vehicle type
                System.out.println("\n--- Total Amount Collected by Vehicle Type for " + tollPlaza + " ---");
                Map<String, Double> amountCollected = tollAmountCollected.get(tollPlaza);
                amountCollected.forEach((type, total) -> {
                    System.out.printf("Vehicle Type: %-10s Total Collected: %.2f\n", type, total);
                });

                // Display the grand total amount collected for the toll plaza
                System.out.println("\n--- Grand Total Amount Collected for " + tollPlaza + " ---");
                System.out.printf("Total Amount: %.2f\n", tollTotalCollected.get(tollPlaza));
            });

        } catch (Exception e) {
            System.err.println("Error retrieving records: " + e.getMessage());
        }
    }
}
