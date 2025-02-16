import java.sql.*;
import java.util.Scanner;

public class MenuDrivenJDBC {
public static void main(String[] args) {
try (Connection conn =
DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user",
"password");
Scanner scanner = new Scanner(System.in)) {
while (true) {
System.out.println("Menu:");
System.out.println("1. Insert a new Row");
System.out.println("2. Update a Row");
System.out.println("3. Delete a Row");
System.out.println("4. Select a Row");
System.out.println("5. Exit");
System.out.print("Enter your choice: ");
int choice = scanner.nextInt();
switch (choice) {
case 1:
System.out.print("Enter Name: ");
String name = scanner.next();
System.out.print("Enter Age: ");
int age = scanner.nextInt();
System.out.print("Enter Salary: ");
double salary = scanner.nextDouble();
String insertQuery = "INSERT INTO employees (name, age, salary)
VALUES(?, ?, ?)";
PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
insertStmt.setString(1, name);
insertStmt.setInt(2, age);
insertStmt.setDouble(3, salary);
insertStmt.executeUpdate();
System.out.println("Row inserted.");
break;
case 2:
System.out.print("Enter Employee ID to update: ");
int id = scanner.nextInt();
System.out.print("Enter new Salary: ");
double newSalary = scanner.nextDouble();
String updateQuery = "UPDATE employees SET salary = ? WHERE
id = ?";
PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
updateStmt.setDouble(1, newSalary);
updateStmt.setInt(2, id);
updateStmt.executeUpdate();
System.out.println("Row updated.");
break;
case 3:
System.out.print("Enter Employee ID to delete: ");
int deleteId = scanner.nextInt();
String deleteQuery = "DELETE FROM employees WHERE id = ?";
PreparedStatement deleteStmt = conn.prepareStatement(deleteQuery);
deleteStmt.setInt(1, deleteId);
deleteStmt.executeUpdate();
System.out.println("Row deleted.");
break;
case 4:
System.out.print("Enter Employee ID to retrieve: ");
int selectId = scanner.nextInt();
String selectQuery = "SELECT * FROM employees WHERE id = ?";
PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
selectStmt.setInt(1, selectId);
ResultSet rs = selectStmt.executeQuery();
while (rs.next()) {
System.out.println("ID: " + rs.getInt("id"));
System.out.println("Name: " + rs.getString("name"));
System.out.println("Age: " + rs.getInt("age"));
System.out.println("Salary: " + rs.getDouble("salary"));
}
break;
case 5:
System.out.println("Exiting...");
return;
default:
System.out.println("Invalid choice.");
}
}
} catch (SQLException e) {
e.printStackTrace();
}
}
}