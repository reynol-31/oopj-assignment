import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FeeViewer {
    private static final String FEE_FILE_PATH = "D:\\Tollgate_management\\src\\vehicle_fees.txt";
    private static Map<String, Double> feeMap = new HashMap<>();

    // Method to load fees from the text file
    private static void loadFees() {
        feeMap.clear(); // Clear any existing data to reload
        try (BufferedReader reader = new BufferedReader(new FileReader(FEE_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String vehicleType = parts[0].trim().toLowerCase();
                    double fee = Double.parseDouble(parts[1].trim());
                    feeMap.put(vehicleType, fee);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading fee file: " + e.getMessage());
        }
    }

    // Method to get the fee for a specific vehicle type
    public static double getFee(String vehicleType) {
        loadFees();
        return feeMap.getOrDefault(vehicleType.toLowerCase(), 0.00); // Default to 0.00 if not found
    }

    // Method to display all fees
    public static void displayFees() {
        loadFees(); // Ensure fees are loaded
        System.out.println("\n--- Toll Fees ---");
        System.out.println("-----------------------------------------");
        System.out.printf("%-15s %-15s\n", "Vehicle Type", "Single Journey");
        System.out.println("-----------------------------------------");
        feeMap.forEach((vehicleType, fee) -> 
            System.out.printf("%-15s %-15.2f\n", capitalize(vehicleType), fee)
        );
        System.out.println("-----------------------------------------");
    }

    // Helper method to capitalize the first letter of vehicle type
    private static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
