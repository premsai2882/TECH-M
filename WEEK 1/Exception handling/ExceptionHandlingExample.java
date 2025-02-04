import java.util.Scanner;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        processInput();
    }

    public static void processInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        try {
            double number = Double.parseDouble(scanner.nextLine());
            System.out.println("The reciprocal of " + number + " is " + calculateReciprocal(number));
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Please enter a valid number.");
        } catch (ArithmeticException e) {
            System.err.println("Error: Division by zero.");
        } finally {
            scanner.close();
        }
    }

    private static double calculateReciprocal(double number) {
        if (number == 0)
            throw new ArithmeticException("Division by zero");
        return 1 / number;
    }
}
