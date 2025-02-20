import java.sql.*;

public class MyJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/car_renting"; // Erstat med din database-info
        String user = "root"; // Erstat med dit brugernavn
        String password = "euwpassword69420!"; // Erstat med dit kodeord

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("✅ Forbindelsen til databasen er oprettet!");
            }
        } catch (SQLException e) {
            System.out.println("⚠️ Kunne ikke forbinde til databasen!");
            e.printStackTrace();
        }
    }
}
