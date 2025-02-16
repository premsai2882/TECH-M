import java.util.Scanner;

public class AlternateCapitalization {
    public static String capitalizeAlternate(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(input.charAt(i)));
            } else {
                result.append(Character.toLowerCase(input.charAt(i)));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        System.out.println("Capitalized Alternate Characters: " +
                capitalizeAlternate(input));
        sc.close();
    }
}