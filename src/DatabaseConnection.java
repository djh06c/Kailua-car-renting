import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/car_renting";
    private static final String USER = "root";
    private static final String PASSWORD = "euwpassword69420!";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Fejl ved oprettelse af databaseforbindelse!");
            e.printStackTrace();
            return null;
        }
    }
}
