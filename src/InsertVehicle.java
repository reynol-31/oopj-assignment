import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertVehicle {
    public static boolean insertData(String regNo, String vehicleType, String tollPlaza) {
        String insertQuery = "INSERT INTO vehicles (reg_no, vehicle_type, toll_plaza, created_at) VALUES (?, ?, ?, NOW())";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // Set the values for the placeholders
            preparedStatement.setString(1, regNo);
            preparedStatement.setString(2, vehicleType);
            preparedStatement.setString(3, tollPlaza);

            // Execute the insert statement
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Error inserting data: " + e.getMessage());
            return false;
        }
    }
}
