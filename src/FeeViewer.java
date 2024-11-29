public class FeeViewer {
    public static double getFee(String vehicleType) {
        switch (vehicleType.toLowerCase()) {
            case "car":
                return 60.00;
            case "bus":
                return 200.00;
            case "truck":
                return 315.00;
            default:
                return 0.00; // Unknown vehicle type
        }
    }

    public static void displayFees() {
        System.out.println("\n--- Toll Fees ---");
        System.out.println("-----------------------------------------");
        System.out.printf("%-15s %-15s\n", "Vehicle Type", "Single Journey");
        System.out.println("-----------------------------------------");
        System.out.printf("%-15s %-15.2f\n", "Car", 60.00);
        System.out.printf("%-15s %-15.2f\n", "Bus", 200.00);
        System.out.printf("%-15s %-15.2f\n", "Truck", 315.00);
        System.out.println("-----------------------------------------");
    }
}
