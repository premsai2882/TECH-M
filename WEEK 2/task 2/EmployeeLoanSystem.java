import java.util.Scanner;

class Employee {
    private int empId;
    private String empName;
    private double sal;
    private int yearsWorked;

    public void setEmployeeDetails(int empId, String empName, double sal, int yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsWorked = yearsWorked;
    }

    public void getEmployeeDetails() {
        System.out.println("\nEmployee Details:");
        System.out.println("ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Monthly Salary: " + sal);
        System.out.println("Annual Salary: " + (sal * 12));
        System.out.println("Years Worked: " + yearsWorked);
    }

    public void getLoanEligibility() {
        double annualSalary = sal * 12;
        double loanAmount = 0;
        if (yearsWorked > 5) {
            if (annualSalary >= 15_00_000) {
                loanAmount = 7_00_000;
            } else if (annualSalary >= 10_00_000) {
                loanAmount = 5_00_000;
            } else if (annualSalary >= 6_00_000) {
                loanAmount = 2_00_000;
            }
        }
        System.out.println("\nLoan Eligibility:");
        if (loanAmount > 0) {
            System.out.println(empName + " is eligible for a loan of ₹" + loanAmount);
        } else {
            System.out.println(empName + " is not eligible for a loan.");
        }
    }
}

public class EmployeeLoanSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee();
        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        String empName = sc.nextLine();
        System.out.print("Enter Monthly Salary: ");
        double sal = sc.nextDouble();
        System.out.print("Enter Years Worked: ");
        int yearsWorked = sc.nextInt();

        emp.setEmployeeDetails(empId, empName, sal, yearsWorked);

        emp.getEmployeeDetails();

        emp.getLoanEligibility();
        sc.close();
    }
}