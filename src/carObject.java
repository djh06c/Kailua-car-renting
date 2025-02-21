import java.sql.*;
public class carObject {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/car_renting";
    private static final String USER = "root";
    private static final String PASSWORD = "euwpassword69420!";

    public void createCar(String fuelType, String registrationNr, int odometer, String carType, int modelId) {
        String query = "INSERT INTO cars (fuel_type, registration_nr, odometer, car_type, model_id) VALUES ()";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, fuelType);
            stmt.setString(2, registrationNr);
            stmt.setInt(3, odometer);
            stmt.setString(4, carType);
            stmt.setInt(5, modelId);

            stmt.executeUpdate();
            System.out.println("Car has been added :D");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readCars() {
        String query = "SELECT * FROM cars";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int carId = rs.getInt("car_id");
                String fuelType = rs.getString("fuel_type");
                String registrationNr = rs.getString("registration_nr");
                int odometer = rs.getInt("odometer");
                String carType = rs.getString("car_type");
                int modelId = rs.getInt("model_id");

                System.out.println("Car ID: " + carId + ", Fuel Type: " + fuelType + ", Registration: " + registrationNr);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(int carId) {
        String query = "DELETE FROM cars WHERE car_id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, carId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Car has been deleted :D");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

