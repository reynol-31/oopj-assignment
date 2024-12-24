import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestClassJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the list of toll plazas
        List<String> tollPlazas = new ArrayList<>();
        tollPlazas.add("Gundmi");
        tollPlazas.add("Surathkal");
        tollPlazas.add("Hejamadi");
        tollPlazas.add("Shanthigrama");
        tollPlazas.add("Hazamady");

        while (true) {
            System.out.println("\n--- Toll Management System ---");
            System.out.println("1. Insert Vehicle Data");
            System.out.println("2. View Toll Plaza Information");
            System.out.println("3. View Toll Records");
            System.out.println("4. View Toll Fees");
            System.out.println("5. Add New Toll Plaza");
            System.out.println("6. Exit");
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

                    // Display available toll plazas dynamically
                    System.out.println("\n--- Select Toll Plaza ---");
                    for (int i = 0; i < tollPlazas.size(); i++) {
                        System.out.printf("%d. %s\n", i + 1, tollPlazas.get(i));
                    }
                    System.out.print("Enter your choice: ");
                    int tollChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    String tollPlazaName;
                    if (tollChoice >= 1 && tollChoice <= tollPlazas.size()) {
                        tollPlazaName = tollPlazas.get(tollChoice - 1);
                    } else {
                        System.out.println("Invalid choice. Defaulting to Gundmi.");
                        tollPlazaName = "Gundmi";
                    }

                    // Insert data into the database
                    boolean isInserted = InsertVehicle.insertData(regNo, vehicleType, tollPlazaName);
                    if (isInserted) {
                        System.out.println("Vehicle data inserted successfully.");
                    } else {
                        System.out.println("Failed to insert vehicle data.");
                    }
                    break;

                case 2:
                    TollPlazaInfo.displayInfoMenu();
                    break;

                case 3:
                    TollRecordViewer.viewRecords();
                    break;

                case 4:
                    FeeViewer.displayFees();
                    break;

                case 5:
                    System.out.print("Enter the name of the new toll plaza: ");
                    String newTollPlaza = scanner.nextLine();
                    tollPlazas.add(newTollPlaza);
                    System.out.println("New toll plaza added successfully.");
                    break;

                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
