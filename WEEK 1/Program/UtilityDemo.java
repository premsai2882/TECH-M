package utility;

class NumberUtils {
    private NumberUtils() {
    } // Private constructor to prevent instantiation

    public static int getIntegerLength(int number) {
        return String.valueOf(Math.abs(number)).length();
    }
}

public class UtilityDemo {
    public static void main(String[] args) {
        int num = 12345;
        System.out.println("Length of " + num + " is: " + NumberUtils.getIntegerLength(num));
    }
}
