public class EqualsVsDeepEquals {
    public static void main(String[] args) {
    String[] arr1 = {"hello", "world"};
    String[] arr2 = {"hello", "world"};
    String[] arr3 = arr1;
    equals()
    and
    deepEquals()
    System.out.println("Using equals(): " + Arrays.equals(arr1, arr2)); // true
    System.out.println("Using equals(): " + Arrays.equals(arr1, arr3)); // true
    System.out.println("Using deepEquals(): " + Arrays.deepEquals(arr1, arr2)); //
    true
    }
}