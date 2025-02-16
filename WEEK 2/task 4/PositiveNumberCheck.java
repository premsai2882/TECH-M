import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PositiveNumberException extends Exception {
    public PositiveNumberException(String message) {
        super(message);
    }
}

public class PositiveNumberCheck {
    public static void checkNegativeNumbers(String filePath) throws FileNotFoundException, PositiveNumberException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number > 0) {
                scanner.close();
                throw new PositiveNumberException("Positive number found: " + number);
            }
        }
        scanner.close();
        System.out.println("All numbers are non-positive.");
    }

    public static void main(String[] args) {
        try {
            checkNegativeNumbers("C:\\Users\\Public\\numbers.txt"); // Change path
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } catch (PositiveNumberException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
