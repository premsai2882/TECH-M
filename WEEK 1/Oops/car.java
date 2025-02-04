public class car {
    private static final String ENGINE_START_MESSAGE = "The engine has started.";
    private String make, model;
    private int year;

    public car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void startEngine() {
        System.out.println(ENGINE_START_MESSAGE);
    }

    public static void main(String[] args) {
        car myCar = new car("Toyota", "Corolla", 2022);
        System.out.println(myCar.make + " " + myCar.model + " " + myCar.year);
        myCar.startEngine();
    }
}
