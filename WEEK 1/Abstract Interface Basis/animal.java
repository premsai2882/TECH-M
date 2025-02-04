// Abstract class
abstract class Animal {
    // Abstract method
    abstract void makeSound();
}

// Concrete subclass
class Dog extends Animal {
    // Overriding abstract method
    void makeSound() {
        System.out.println("The dog is barking.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an object of the Dog class
        Dog dog = new Dog();
        // Calling the overridden method
        dog.makeSound();
    }
}
