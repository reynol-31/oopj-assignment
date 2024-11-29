import java.util.Scanner;

public class TestClassJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Toll Management System ---");
            System.out.println("1. Insert Vehicle Data");
            System.out.println("2. View Toll Plaza Information");
            System.out.println("3. View Toll Records");
            System.out.println("4. View Toll Fees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Collect data from the user
                    System.out.print("Enter Registration Number (reg_no): ");
                    String regNo = scanner.nextLine();

                    System.out.print("Enter Vehicle Type (vehicle_type): ");
                    String vehicleType = scanner.nextLine();

                    // Insert data into the database
                    boolean isInserted = InsertVehicle.insertData(regNo, vehicleType);
                    if (isInserted) {
                        System.out.println("Vehicle data inserted successfully.");
                    } else {
                        System.out.println("Failed to insert vehicle data.");
                    }
                    break;
                case 2:
                    TollPlazaInfo.displayInfo();
                    break;
                case 3:
                    TollRecordViewer.viewRecords();
                    break;
                case 4:
                    FeeViewer.displayFees();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
