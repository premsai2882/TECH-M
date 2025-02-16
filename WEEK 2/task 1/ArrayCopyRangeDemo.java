import java.util.Arrays;

public class ArrayCopyRangeDemo {
    public static void main(String[] args) {
        int[] numbers = { 10, 20, 30, 40, 50, 60, 70 };
        // Copy a subarray from index 2 to 5 (excluding index 5)
        int[] copiedRange = Arrays.copyOfRange(numbers, 2, 5);
        System.out.println("Original Array: " + Arrays.toString(numbers));
        System.out.println("Copied Range: " + Arrays.toString(copiedRange));
    }
}
