import management.InventoryManager;
import models.Product;
import models.Location;
import orders.Order;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addProduct(new Product("P001", "Laptop", 10, new Location(1, 2, 3)));
        inventoryManager.addProduct(new Product("P002", "Mouse", 20, new Location(2, 1, 4)));
        inventoryManager.addProduct(new Product("P003", "Keyboard", 15, new Location(3, 5, 2)));

        Order order1 = new Order("O001", Arrays.asList("P001", "P002"), Order.Priority.EXPEDITED);
        Order order2 = new Order("O002", Arrays.asList("P003"), Order.Priority.STANDARD);

        inventoryManager.placeOrder(order1);
        inventoryManager.placeOrder(order2);

        inventoryManager.processOrders();
        inventoryManager.displayInventory();
    }
}
