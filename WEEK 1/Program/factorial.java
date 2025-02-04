public class Main {
    public static void main(String[] args) {
        int number = 100;
        System.out.println("Trailing zeroes in factorial of " + number + ": " + findTrailingZeroes(number));
    }

    static int findTrailingZeroes(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
