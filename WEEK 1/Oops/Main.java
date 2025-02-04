class Car {
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void startEngine() {
        System.out.println("The engine of " + brand + " " + model + " is starting.");
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}

class ElectricCar extends Car {
    public ElectricCar(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void startEngine() {
        System.out.println("The electric engine of " + getBrand() + " " + getModel() + " is starting silently.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car[] cars = { new Car("Toyota", "Corolla"), new ElectricCar("Tesla", "Model S"), new Car("Honda", "Civic") };

        for (Car car : cars) {
            car.startEngine();
        }
    }
}
