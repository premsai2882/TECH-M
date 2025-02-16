import java.util.Arrays;
public class GenericArrayComparison {
public static <T> boolean areArraysEqual(T[] arr1, T[] arr2) {
return Arrays.equals(arr1, arr2);
}
public static void main(String[] args) {
Integer[] arr1 = {1, 2, 3, 4};
Integer[] arr2 = {1, 2, 3, 4};
String[] arr3 = {"A", "B", "C"};
String[] arr4 = {"A", "C", "B"};
System.out.println("Are arr1 and arr2 equal? " + areArraysEqual(arr1, arr2));
System.out.println("Are arr3 and arr4 equal? " + areArraysEqual(arr3, arr4));
}
}