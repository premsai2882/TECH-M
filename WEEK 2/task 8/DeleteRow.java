import java.sql.*;
import java.util.Scanner;

public class DeleteRow {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user",
                "password");
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Employee ID to delete: ");
            int id = scanner.nextInt();
            String query = "DELETE FROM employees WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println(rowsDeleted + " row(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}