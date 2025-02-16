import java.sql.Connection;import java.sql.DriverManager;import
java.sql.PreparedStatement;import java.sql.SQLException;
public class RecursiveInsert {
public static void insertData(Connection conn, int count) throws SQLException {
if (count == 0) return;
String query = "INSERT INTO employees (name, age, salary) VALUES
(?, ?, ?)";
PreparedStatement pstmt = conn.prepareStatement(query);
pstmt.setString(1, "Employee" + count);
pstmt.setInt(2, 25 + count);
pstmt.setDouble(3, 50000 + (count * 1000));
pstmt.executeUpdate();
insertData(conn, count- 1);
}
public static void main(String[] args) {
try (Connection conn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user",
"password")) {
insertData(conn, 5);
System.out.println("5 Rows Inserted Recursively.");
} catch (SQLException e) {
e.printStackTrace();
}
}
}