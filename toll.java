import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class toll {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\REYNOL\\Desktop\\java\\tolldata.txt");
            Scanner fileScanner = new Scanner(file);
            
            while (fileScanner.hasNextLine()) {
                String vehicleData = fileScanner.nextLine();
                System.out.println("Vehicle Data: " + vehicleData);
            }
            
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
