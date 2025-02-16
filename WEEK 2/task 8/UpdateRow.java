import java.sql.*;
import java.util.Scanner;

public class UpdateRow {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user",
                "password");
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Employee ID to update: ");
            int id = scanner.nextInt();
            System.out.print("Enter new Salary: ");
            double salary = scanner.nextDouble();
            String query = "UPDATE employees SET salary = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setDouble(1, salary);
            pstmt.setInt(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            System.out.println(rowsUpdated + " row(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}