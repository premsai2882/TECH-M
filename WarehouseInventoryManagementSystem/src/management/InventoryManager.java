package management;

import models.Product;
import orders.Order;
import java.util.concurrent.*;
import java.util.PriorityQueue;
import java.util.logging.Logger;
import java.util.Collections;

public class InventoryManager {
    private ConcurrentHashMap<String, Product> products = new ConcurrentHashMap<>();
    private PriorityQueue<Order> orderQueue = new PriorityQueue<>(Collections.reverseOrder());
    private static final Logger logger = Logger.getLogger(InventoryManager.class.getName());

    public void addProduct(Product product) {
        products.put(product.getProductID(), product);
    }

    public synchronized void placeOrder(Order order) {
        orderQueue.add(order);
        logger.info("Order added: " + order.getOrderID() + " Priority: " + order.getPriority());
    }

    public void processOrders() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            executor.execute(() -> processOrder(order));
        }
        executor.shutdown();
    }

    private void processOrder(Order order) {
        try {
            for (String productID : order.getProductIDs()) {
                Product product = products.get(productID);
                if (product != null) {
                    product.reduceQuantity(1);
                    logger.info("Processed " + product.getName() + " for Order " + order.getOrderID());
                } else {
                    throw new exceptions.OutOfStockException("Product not found: " + productID);
                }
            }
        } catch (Exception e) {
            logger.severe("Error processing order " + order.getOrderID() + ": " + e.getMessage());
        }
    }

    public void displayInventory() {
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}
