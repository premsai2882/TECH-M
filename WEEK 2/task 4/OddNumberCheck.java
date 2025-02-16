class OddNumberException extends Exception {
    public OddNumberException(String message) {
        super(message);
    }
}

public class OddNumberCheck {
    public static void checkEven(int number) throws OddNumberException {
        if (number % 2 != 0) {
            throw new OddNumberException("Odd number encountered: " + number);
        }
        System.out.println("Even number: " + number);
    }

    public static void main(String[] args) {
        try {
            checkEven(5);
        } catch (OddNumberException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}