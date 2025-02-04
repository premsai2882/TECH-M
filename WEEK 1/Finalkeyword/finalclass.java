final class FinalClass {
    final int finalVariable = 10;

    final void displayFinalMethod() {
        System.out.println("This is a final method.");
    }
}

class RegularClass {
    final void displayAnotherFinalMethod() {
        System.out.println("This is another final method.");
    }
}

public class Main {
    public static void main(String[] args) {
        FinalClass finalClass = new FinalClass();
        System.out.println("Final variable value: " + finalClass.finalVariable);
        finalClass.displayFinalMethod();

        RegularClass regularClass = new RegularClass();
        regularClass.displayAnotherFinalMethod();
    }
}
