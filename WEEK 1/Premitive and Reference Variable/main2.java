public class main2 {
    public static void main(String[] args) {
        int primitiveVar = 10;
        int[] referenceVar = { 1, 2, 3 };

        System.out.println("Before method call:");
        System.out.println("Primitive variable: " + primitiveVar);
        System.out.print("Reference variable: ");
        printArray(referenceVar);

        modifyValues(primitiveVar, referenceVar);

        System.out.println("\nAfter method call:");
        System.out.println("Primitive variable: " + primitiveVar);
        System.out.print("Reference variable: ");
        printArray(referenceVar);
    }

    static void modifyValues(int primitive, int[] reference) {
        primitive = 20;
        reference[0] = 99;
    }

    static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
