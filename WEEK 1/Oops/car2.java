public class ElectricCar extends car2 {
    private final int batteryRange; // Instance variable for battery range
    private static final String CHARGING_MESSAGE = "The battery is being charged.";

    // Constructor
    public ElectricCar(String brand, String model, int batteryRange) {
        super(brand, model);
        this.batteryRange = batteryRange;
    }

    // Method to charge the battery
    public void chargeBattery() {
        System.out.println(CHARGING_MESSAGE);
    }

    // Getter method for battery range
    public int getBatteryRange() {
        return batteryRange;
    }

}

public class car2 {
    private String brand;
    private String model;

    public car2(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
